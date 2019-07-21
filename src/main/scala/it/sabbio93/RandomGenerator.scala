package it.sabbio93

import java.util.concurrent.Executors

import scala.util.Properties
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

object RandomGenerator {

  def main(args: Array[String]): Unit = {

<<<<<<< Updated upstream
    val baseLat   = Properties.envOrNone("BASELAT").map(value=>value.toDouble).getOrElse(43.836833)
    val baseLong  = Properties.envOrNone("BASELONG").map(value=>value.toDouble).getOrElse(9.463728)
    val deltaLat  = Properties.envOrNone("DELTALAT").map(value=>value.toDouble).getOrElse(1.275308)
    val deltaLong = Properties.envOrNone("DELTALONG").map(value=>value.toDouble).getOrElse(3.232666)
    val server    = Properties.envOrElse("SERVER", "localhost:9092")
    val topic     = Properties.envOrElse("TOPIC", "test")
    val threads   = Properties.envOrNone("THREADS").map(value=>value.toInt).getOrElse(1)

    val props = new java.util.Properties()
    props.put("bootstrap.servers", server) //cambiare con nome variabile
=======
    val baseLat = 43.836833
    val baseLong = 9.463728
    val deltaLat = 1.275308
    val deltaLong = 3.232666
    val server= Properties.envOrElse("SERVER","localhost:9092")
    val topic= Properties.envOrElse("TOPIC","test")


    println("loggin on server: "+server)
    val random = new scala.util.Random()

    val props = new java.util.Properties()
    props.put("bootstrap.servers", server)
>>>>>>> Stashed changes
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

<<<<<<< Updated upstream
    val executor = Executors.newFixedThreadPool(threads)
    executor.submit(new Producer(deltaLat, deltaLong, baseLat, baseLong, props, topic))

  }//main
}//RandomGenerator

class Producer(deltaLat: Double, deltaDouble: Double, baseLat: Double, baseDouble: Double, props: java.util.Properties, topic: String) extends Runnable {

  def run(): Unit = {

    val producer = new KafkaProducer[String, String](props)
    val random= new scala.util.Random()
    while (true)
=======
    while (!Thread.currentThread().isInterrupted)//TODO set listener to system signaling
>>>>>>> Stashed changes
    {
      val lat = ((random.nextFloat() * 10) % deltaLat) + baseLat
      val long = ((random.nextFloat() * 10) % deltaDouble) + baseDouble
      val value = "lat:" + lat + ",long:" + long
      producer.send(new ProducerRecord[String, String](topic, "ll", value))
      Thread.sleep(100)
    }
    producer.close()
  }
}