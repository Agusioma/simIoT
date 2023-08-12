package demo.airbyte.example;

import com.fasterxml.jackson.databind.JsonNode;
import io.confluent.kafka.serializers.json.KafkaJsonSchemaSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.kafka.clients.producer.ProducerConfig;

import java.util.Properties;

public class StreamProducer {
    private static final Logger log = LoggerFactory.getLogger(StreamProducer.class);
    public void sendToTopic(SensorData sensorData) {
        log.info("Demo Producer");

        String bootstrapServers = "127.0.0.1:9092";

        // create Producer properties
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaJsonSchemaSerializer.class.getName());
        properties.put("schema.registry.url", "http://127.0.0.1:8081");

        // create the producer
        KafkaProducer<String, SensorData> producer = new KafkaProducer<>(properties);
        // create a producer record
        ProducerRecord<String, SensorData> producerRecord = new ProducerRecord<>("quickstart-events2", sensorData);

        // send data - asynchronous
        producer.send(producerRecord);

        // flush data - synchronous
        //producer.flush();
        // flush and close producer
        //producer.close();
    }

}