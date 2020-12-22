package by.tc.task02.entity;

import by.tc.task02.entity.criteria.SearchCriteria;

import java.util.Map;
import java.util.Objects;

public class Oven implements Appliance {

    int capacity;
    int powerConsumption;
    int weight;
    int depth;
    double width;
    double height;

    public Oven(){
    }

    public Oven(Map<String, Object> applianceInfo) {
        capacity = Integer.parseInt(String.valueOf(applianceInfo.get(SearchCriteria.Oven.CAPACITY.toString())));
        powerConsumption = Integer.parseInt(String.valueOf(applianceInfo.get(SearchCriteria.Oven.POWER_CONSUMPTION.toString())));
        weight =  Integer.parseInt(String.valueOf(applianceInfo.get(SearchCriteria.Oven.WEIGHT.toString())));
        width = Double.parseDouble(String.valueOf(applianceInfo.get(SearchCriteria.Oven.WIDTH.toString())));
        height =  Double.parseDouble(String.valueOf(applianceInfo.get(SearchCriteria.Oven.HEIGHT.toString())));
        depth =  Integer.parseInt(String.valueOf(applianceInfo.get(SearchCriteria.Oven.DEPTH.toString())));
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Oven oven = (Oven) obj;
        return powerConsumption == oven.powerConsumption &&
                weight == oven.weight &&
                capacity == oven.capacity &&
                depth == oven.depth &&
                Double.compare(oven.height, height) == 0 &&
                Double.compare(oven.width, width) == 0;
    }

    @Override
    public String toString() {
            return "Oven{" +
                    "powerConsumption=" + powerConsumption +
                    ", weight=" + weight +
                    ", capacity=" + capacity +
                    ", depth=" + depth +
                    ", height=" + height +
                    ", width=" + width +
                    '}';
        }

    @Override
    public int hashCode() {
        return Objects.hash(capacity,powerConsumption, weight, width, height, depth);
    }

}
