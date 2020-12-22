package by.tc.task02.entity;

import by.tc.task02.entity.criteria.Criteria;

import java.util.List;

public class DataParser {

    public final static String COLON = " : ";
    public final static String COMMA = ", ";
    public final static String EQUALSIGN = "=";

    public Criteria dataParser(List<String> appliancesList, Criteria criteria) {
        ValidatorOfCriteria validator = new ValidatorOfCriteria();
        boolean b = false;
        String nameOfAppliance = criteria.getGroupSearchName();
        String[] info, deviceParameters;
        String deviceName;
        Criteria criteria1 = null;
        for (String appliance : appliancesList) {
            if (appliance.contains(nameOfAppliance) && !b) {
                info = appliance.split(COLON);
                deviceName = info[0];
                criteria1 = new Criteria(deviceName);
                deviceParameters = info[1].split(COMMA);
                for (String parameter : deviceParameters) {
                    deviceParameters = parameter.split(EQUALSIGN);
                    criteria1.add(deviceParameters[0], deviceParameters[1]);
                }
                b = validator.isValidDevice(criteria, criteria1);
            }
            if(b) break;
        }
        if (!b) return null;
        else return criteria1;
    }

}
