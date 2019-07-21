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

<<<<<<< Updated upstream
Arguments optional:
* SERVER:String
* TOPIC:String
* THREADS:INT
* BASELAT:Double
* BASELONG:Double
* DELTALAT:Double
* DELTALONG:Double
=======
## Start testing

Start kafka and create a test topic

```bash
nohup bin/zookeeper-server-start.sh config/zookeeper.properties &
nohup bin/kafka-server-start.sh config/server.properties &
bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test
bin/kafka-topics.sh --list --bootstrap-server localhost:9092
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning

```

>>>>>>> Stashed changes
