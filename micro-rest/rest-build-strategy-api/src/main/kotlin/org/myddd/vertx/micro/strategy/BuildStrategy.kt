package org.myddd.vertx.micro.strategy

import com.google.inject.AbstractModule
import io.vertx.core.Vertx
import io.vertx.core.impl.logging.LoggerFactory
import io.vertx.kotlin.coroutines.CoroutineVerticle
import org.myddd.vertx.base.BusinessLogicException
import java.util.*

/**
 * 构建策略，这是个接口
 * 具体单机构建与分布式构建需要根据添加的实现来决定
 */
interface BuildStrategy {

    /**
     * 返回Guice的注入,需要继承AbstractWebModule
     * AbstractWebModule提供了基本的注入
     * 不同的构建自行扩展，添加自己的注入
     */
    fun guiceModule(vertx: Vertx): AbstractModule

    /**
     * 不同构建可以定义自己需要启动的Verticle
     */
    fun verticleList(vertx: Vertx): List<CoroutineVerticle>

    companion object {

        private val logger by lazy { LoggerFactory.getLogger(BuildStrategy::class.java) }

        private const val LOCAL_BUILD_STRATEGY = "org.myddd.vertx.micro.rest.strategy.LocalBuildStrategy"

        private const val DISTRIBUTED_BUILD_STRATEGY = "org.myddd.vertx.micro.rest.strategy.DistributedBuildStrategy"


        fun getBuildStrategy():BuildStrategy {
            var buildStrategy : BuildStrategy? = tryLoadBuildStrategy(LOCAL_BUILD_STRATEGY)
            if(Objects.isNull(buildStrategy)){
                buildStrategy = tryLoadBuildStrategy(DISTRIBUTED_BUILD_STRATEGY)
            }

            if(Objects.isNull(buildStrategy)){
                throw BusinessLogicException(BuildStrategyErrorCode.BUILD_STRATEGY_NOT_FOUND)
            }

            return buildStrategy!!
        }

        private fun tryLoadBuildStrategy(className:String):BuildStrategy? {
            var buildStrategyClass: Class<BuildStrategy>? = null
            try {
                buildStrategyClass = Class.forName(className) as Class<BuildStrategy>?
            }catch (e:Exception){
                logger.warn("【未搜索到相关的打包策略】: $className")
            }
            if(Objects.nonNull(buildStrategyClass)){
                return buildStrategyClass!!.getDeclaredConstructor().newInstance()
            }else{
                return null
            }
        }
    }

}