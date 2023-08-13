package demo.airbyte.example;

import java.util.LinkedHashMap;
import java.util.Map;

public class SensorData {

    private String ts;

    private String device;

    private Double co;

    private Double humidity;

    private Boolean light;

    private Double lpg;

    private Boolean motion;

    private Double smoke;

    private Double temp;

    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public SensorData()
    {
        super();
    }
    public SensorData(String ts,
                      String device,
                      Double co,
                      Double humidity,
                      Boolean light,
                      Double lpg,
                      Boolean motion,
                      Double smoke,
                      Double temp) {
     this.ts = ts;
        this.device = device;
        this.co = co;
        this.humidity = humidity;
        this.light = light;
        this.lpg = lpg;
        this.motion = motion;
        this.smoke = smoke;
        this.temp = temp;
    }


    public String getTs() {
        return ts;
    }


    public void setTs(String ts) {
        this.ts = ts;
    }


    public String getDevice() {
        return device;
    }


    public void setDevice(String device) {
        this.device = device;
    }


    public Double getCo() {
        return co;
    }


    public void setCo(Double co) {
        this.co = co;
    }


    public Double getHumidity() {
        return humidity;
    }


    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }


    public Boolean getLight() {
        return light;
    }


    public void setLight(Boolean light) {
        this.light = light;
    }


    public Double getLpg() {
        return lpg;
    }


    public void setLpg(Double lpg) {
        this.lpg = lpg;
    }


    public Boolean getMotion() {
        return motion;
    }

    //@JsonProperty("motion")
    public void setMotion(Boolean motion) {
        this.motion = motion;
    }

    //@JsonProperty("smoke")
    public Double getSmoke() {
        return smoke;
    }

    //@JsonProperty("smoke")
    public void setSmoke(Double smoke) {
        this.smoke = smoke;
    }

    //@JsonProperty("temp")
    public Double getTemp() {
        return temp;
    }

    //@JsonProperty("temp")
    public void setTemp(Double temp) {
        this.temp = temp;
    }

    //@JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    //@JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}