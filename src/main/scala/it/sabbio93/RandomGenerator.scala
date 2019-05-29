package it.sabbio93

import scala.util.Properties
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

object RandomGenerator {

  def main(args: Array[String]): Unit = {

    val baseLat = 43.836833
    val baseLong = 9.463728
    val deltaLat = 1.275308
    val deltaLong = 3.232666
    val server= Properties.envOrElse("SERVER","localhost:9092")
    val topic= Properties.envOrElse("TOPIC","test")


    val random = new scala.util.Random()

    val props = new java.util.Properties()
    props.put("bootstrap.servers", server)//cambiare con nome variabile
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    val producer = new KafkaProducer[String, String](props)

    while (true)//TODO set listener to system signaling
    {
      val lat=((random.nextFloat()*10)%deltaLat)+baseLat
      val long=((random.nextFloat()*10)%deltaLong)+baseLong
      val value= "lat:"+lat+",long:"+long
      producer.send(new ProducerRecord[String, String](topic, "ll", value))
      Thread.sleep(100)
      println(value)
    }
    producer.close()
  }
}
