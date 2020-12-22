package by.tc.task02.entity;

import by.tc.task02.entity.criteria.Criteria;

import java.util.HashMap;
import java.util.Map;

public class ValidatorOfCriteria {

    public boolean isValidDevice(Criteria criteria, Criteria requiredCriteria) {
        Map<String, Object> listOfCriteria = new HashMap<>();
        Map<String, Object> listOfRequiredCriteria = new HashMap<>();
        listOfCriteria.putAll(criteria.getCriteria());
        listOfRequiredCriteria.putAll(requiredCriteria.getCriteria());
        int countOfMatchesOfCriteria = 0;
            if(listOfCriteria.size() < listOfRequiredCriteria.size()){
                countOfMatchesOfCriteria = listOfRequiredCriteria.size() - listOfCriteria.size();
            }
        for(Map.Entry<String, Object> tempCriteria : listOfCriteria.entrySet()) {
            if (tempCriteria.getValue().toString().equalsIgnoreCase(listOfRequiredCriteria.get(tempCriteria.getKey()).toString())) {
                countOfMatchesOfCriteria++;
            }
        }
        return countOfMatchesOfCriteria == requiredCriteria.getCriteria().size();
    }

}
