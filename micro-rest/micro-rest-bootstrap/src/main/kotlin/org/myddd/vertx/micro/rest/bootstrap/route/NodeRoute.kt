package org.myddd.vertx.micro.rest.bootstrap.route

import com.google.protobuf.Empty
import io.vertx.core.Vertx
import io.vertx.core.json.JsonObject
import io.vertx.ext.web.Router
import io.vertx.kotlin.coroutines.await
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.myddd.vertx.grpc.GrpcInstanceFactory
import org.myddd.vertx.grpc.VertxHealthCheckGrpc
import org.myddd.vertx.grpc.health.HealthGrpcService
import org.myddd.vertx.web.router.AbstractRouter
import org.myddd.vertx.web.router.ext.jsonFormatEnd

class NodeRoute(vertx: Vertx,router: Router,coroutineScope: CoroutineScope):AbstractRouter(vertx,router,coroutineScope) {

    init {
        nodeInfoRoute()
    }

    private val healthCheckApplication by lazy {
        GrpcInstanceFactory.getInstance<VertxHealthCheckGrpc.HealthCheckVertxStub>(HealthGrpcService.HealthCheck)
    }

    private fun nodeInfoRoute(){
        createGetRoute("/$version/node"){ route ->
            route.handler {
                GlobalScope.launch(vertx.dispatcher()) {
                    try {
                        val node = healthCheckApplication.rpcRun {
                            it.nodeInfo(Empty.getDefaultInstance())
                        }.await()
                        it.jsonFormatEnd(JsonObject().put("host",node.host).put("port",node.port).toBuffer())
                    }catch (t:Throwable){
                        it.fail(t)
                    }
                }
            }
        }
    }
}