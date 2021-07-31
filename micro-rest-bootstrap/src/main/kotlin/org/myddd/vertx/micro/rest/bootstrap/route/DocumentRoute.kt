package org.myddd.vertx.micro.rest.bootstrap.route


import com.google.protobuf.Int64Value
import io.vertx.core.Vertx
import io.vertx.core.json.JsonObject
import io.vertx.ext.web.Router
import io.vertx.kotlin.coroutines.await
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.myddd.vertx.distributed.bootstrap.validation.DocumentValidationHandler
import org.myddd.vertx.base.BusinessLogicException
import org.myddd.vertx.document.api.DocumentGrpcService
import org.myddd.vertx.document.api.VertxDocumentApplicationGrpc
import org.myddd.vertx.grpc.GrpcInstanceFactory
import org.myddd.vertx.micro.rest.bootstrap.WebErrorCode
import org.myddd.vertx.micro.rest.bootstrap.ext.toDocumentDTO
import org.myddd.vertx.micro.rest.bootstrap.ext.toJsonObject
import org.myddd.vertx.web.router.AbstractRouter
import org.myddd.vertx.web.router.ext.jsonFormatEnd

class DocumentRoute(vertx: Vertx, router: Router): AbstractRouter(vertx = vertx,router = router)  {

    init {
        createDocumentRoute()
        queryDocumentRoute()
    }

    private val documentApplication by lazy {
        GrpcInstanceFactory.getInstance<VertxDocumentApplicationGrpc.DocumentApplicationVertxStub>(DocumentGrpcService.DocumentService)
    }


    private fun createDocumentRoute(){

        createPostRoute(path = "/$version/documents"){ route ->

            route.handler(DocumentValidationHandler().createDocumentValidationHandler())

            route.handler {
                GlobalScope.launch(vertx.dispatcher()) {
                    try {
                        val body = it.bodyAsJson
                        val documentDTO = body.toDocumentDTO()
                        val created = documentApplication.rpcRun {
                            it.createDocument(documentDTO)
                        }.await()
                        if(created.hasData()){
                            it.jsonFormatEnd(created.data.toJsonObject().toBuffer())
                        }else{
                            it.fail(400)
                        }
                    }catch (t:Throwable){
                        it.fail(t)
                    }
                }
            }


        }
    }

    private fun queryDocumentRoute(){

        createGetRoute(path = "/$version/documents/:id"){ route ->
            route.handler {
                GlobalScope.launch(vertx.dispatcher()) {
                    try {

                        val id = it.pathParam("id").toLong()
                        val queryDocument = documentApplication.rpcRun {
                            it.queryDocumentById(Int64Value.of(id))
                        }.await()

                        if(queryDocument.hasData()){
                            it.jsonFormatEnd(queryDocument.data.toJsonObject().toBuffer())
                        }else{
                            throw BusinessLogicException(WebErrorCode.MEDIA_NOT_FOUND)
                        }

                    }catch (t:Throwable){
                        it.fail(t)
                    }
                }
            }
        }

    }
}