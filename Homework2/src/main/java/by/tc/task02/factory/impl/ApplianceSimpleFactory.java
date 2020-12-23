package by.tc.task02.factory.impl;

import by.tc.task02.entity.*;
import by.tc.task02.entity.criteria.Criteria;
import by.tc.task02.factory.DeviceFactory;
import java.util.Map;

public class ApplianceSimpleFactory implements DeviceFactory {
    
    @Override
    public Appliance createDevice(Criteria criteria)  {
        if (criteria == null) return null;
        Appliance appliance = null;
        Map<String, Object> applianceInfo = criteria.getCriteria();
        switch (criteria.getGroupSearchName()){
            case "Oven" -> {
                appliance = new Oven(applianceInfo);
            }
            case "Laptop" -> {
                appliance = new Laptop(applianceInfo);
            }
            case "Refrigerator" -> {
                appliance = new  Refrigerator(applianceInfo);
            }
            case "Speakers" -> {
                appliance = new  Speakers(applianceInfo);
            }
            case "TabletPC" -> {
                appliance = new TabletPC(applianceInfo);
            }
            case "VacuumCleaner" -> {
                appliance = new VacuumCleaner(applianceInfo);
            }
        }
        return appliance;
    }
}
