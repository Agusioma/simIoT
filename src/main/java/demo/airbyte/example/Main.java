package demo.airbyte.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Main mainProcessor = new Main();
        StreamProducer streamProducer = new StreamProducer();
        int counter = 0;


        System.out.println("SUCCESS! Sending data...\n");

        do{
            Thread.sleep(1000);
            JsonNode extractedData = mainProcessor.extract(counter);
            streamProducer.sendToTopic(extractedData);
            System.out.println(extractedData);
            System.out.println("Portion "+(counter + 1) +" sent");
            counter++;
        }while(counter<10);

        System.out.println("\nData sent");
    }

    public JsonNode extract(int position) throws IOException {
        SensorData sensorData;
        Double co2, lpg, smoke, temperature, humidity;
        String deviceID, timestamp;
        Boolean motion, light;
        ObjectMapper objectMapper = new ObjectMapper();

        byte[] jsonData = Files.readAllBytes(Paths.get("src/main/resources/data/csvjson.json"));
        JsonNode rootNode = objectMapper.readTree(jsonData);
        JsonNode phoneNosNode = rootNode.get(position);
        System.out.println(phoneNosNode);
      /* smoke = phoneNosNode.get("smoke").asDouble();
        timestamp = phoneNosNode.get("ts").asText();
        co2 = phoneNosNode.get("co").asDouble();
        lpg = phoneNosNode.get("lpg").asDouble();
        temperature = phoneNosNode.get("temp").asDouble();
        humidity = phoneNosNode.get("humidity").asDouble();
        deviceID = phoneNosNode.get("device").asText();
        motion = phoneNosNode.get("motion").asBoolean();
        light = phoneNosNode.get("light").asBoolean();

        sensorData = new SensorData(timestamp, deviceID, co2, humidity, light, lpg, motion, smoke, temperature);
        return sensorData;*/
        return phoneNosNode;
    }
}