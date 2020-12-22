package by.tc.task02.entity;

import java.util.ArrayList;
import java.util.List;

public class AdditionToList {

    private List<Appliance> applianceList = new ArrayList<>();

    public List<Appliance> getApplianceList() {
        return applianceList;
    }

    public void setApplianceList(List<Appliance> applianceList) {
        this.applianceList = applianceList;
    }

    public List<Appliance> addAppliance(Appliance appliance){
        if(appliance!=null){
            this.applianceList.add(appliance);
        }
        return applianceList;
    }

}
