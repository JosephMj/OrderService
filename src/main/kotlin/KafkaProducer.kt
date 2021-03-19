import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.Producer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringSerializer
import java.util.*

// $ kafka-topics --zookeeper localhost:9092 --create --topic persons --replication-factor 1 --partitions 4

class KafkaProducer {

    private val producer = createProducer()

    private fun createProducer(): Producer<String, String> {
        val props = Properties()
        props["bootstrap.servers"] = "localhost:9092"
        props["key.serializer"] = StringSerializer::class.java
        props["value.serializer"] = StringSerializer::class.java
        return KafkaProducer<String, String>(props)
    }

    fun produce(msg: String) {

            val futureResult = producer.send(ProducerRecord("Order-Submitted",msg))
            futureResult.get()

    }
}