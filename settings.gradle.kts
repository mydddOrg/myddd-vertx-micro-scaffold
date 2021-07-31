rootProject.name = "myddd-vertx-micro-scaffold"

include("document:document-domain")
include("document:document-api")
include("document:document-infra")
include("document:document-application")
include("document:document-rpc-bootstrap")



include("distributed-id:distributed-id-domain")
include("distributed-id:distributed-id-api")
include("distributed-id:distributed-id-infra")
include("distributed-id:distributed-id-application")
include("distributed-id:distributed-id-rpc-bootstrap")

include("micro-rest:rest-build-strategy-api")
include("micro-rest:micro-rest-bootstrap")
include("micro-rest:rest-build-strategy-distributed")
include("micro-rest:rest-build-strategy-local")