# KafkaLongLat Producer

 Create docker image

`sbt docker:publishLocal`

Retag the image

`docker tag kafkallproducer:0.1 nimbler/geostresser
`

Login on docker hub( use docker id instead of mail)

`docker login`

Push container

` docker push nimbler/geostresser`
