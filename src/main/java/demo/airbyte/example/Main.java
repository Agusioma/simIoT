package demo.airbyte.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {

        Main mainProcessor = new Main();
        StreamProducer streamProducer = new StreamProducer();
        int counter = 0;

        System.out.println("SUCCESS! Sending data...\n");

        do{
            Thread.sleep(1000);
            JsonNode extractedData = mainProcessor.extract(counter);
            streamProducer.sendToTopic(extractedData);
            System.out.println("Extracted Data: "+ extractedData);
            System.out.println("Portion "+(counter + 1) +" sent");
            counter++;
        }while(counter<150);

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
        String json = objectMapper.writeValueAsString(phoneNosNode);
        System.out.println(json);
       return phoneNosNode;
    }
}