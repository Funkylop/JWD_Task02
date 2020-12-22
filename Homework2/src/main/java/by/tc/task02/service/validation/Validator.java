package by.tc.task02.service.validation;

import by.tc.task02.entity.criteria.Criteria;
import by.tc.task02.entity.criteria.SearchCriteria;

import java.util.Map;

public class Validator {

	private final static String redColor = "red";
	private final static String blueColor = "blue";
	private final static String greenColor = "green";
	private final static String linux = "Linux";
	private final static String windows = "Windows";
	private final static String filterA = "A";
	private final static String filterB = "B";
	private final static String filterC = "C";

	public static boolean isValidOven;
	public static boolean isValidTabletPC;
	public static boolean isValidLaptop;
	public static boolean isValidSpeakers;
	public static boolean isValidRefrigerator;
	public static boolean isValidVacuumCleaner;

	public static boolean criteriaValidator(Criteria criteria) {
		boolean isValid = false;
		if (criteria.getGroupSearchName() == null){
			boolean isValidOven = isValidateCriteriaOfOven(criteria);
			boolean isValidTabletPC = isValidateCriteriaOfTabletPC(criteria);
			boolean isValidLaptop = isValidateCriteriaOfLaptop(criteria);
			boolean isValidRefrigerator = isValidateCriteriaOfRefrigerator(criteria);
			boolean isValidSpeakers = isValidateCriteriaOfSpeakers(criteria);
			boolean isValidVacuumCleaner = isValidateCriteriaOfVacuumCleaner(criteria);
			return isValidOven || isValidTabletPC || isValidLaptop || isValidRefrigerator || isValidSpeakers || isValidVacuumCleaner;
		}
		switch (criteria.getGroupSearchName()) {
			case "Oven" -> isValid = isValidateCriteriaOfOven(criteria);
			case "TabletPC" -> isValid = isValidateCriteriaOfTabletPC(criteria);
			case "Laptop" -> isValid = isValidateCriteriaOfLaptop(criteria);
			case "Refrigerator" -> isValid = isValidateCriteriaOfRefrigerator(criteria);
			case "VacuumCleaner" -> isValid = isValidateCriteriaOfVacuumCleaner(criteria);
			case "Speakers" -> isValid = isValidateCriteriaOfSpeakers(criteria);
		}
		return isValid;
	}

	public static boolean isValidateCriteriaOfOven(Criteria criteria) {
		int countOfMatchOfNameCriteria = 0;
		for (Map.Entry<String, Object> validateCriteria : criteria.getCriteria().entrySet()) {
			if (validateCriteria.getKey().equalsIgnoreCase(SearchCriteria.Oven.CAPACITY.toString())) {
				if (Integer.parseInt(validateCriteria.getValue().toString()) > 0
						&& Integer.parseInt(validateCriteria.getValue().toString()) < 100){
					countOfMatchOfNameCriteria++;
				}
			} else if (validateCriteria.getKey().equalsIgnoreCase(SearchCriteria.Oven.POWER_CONSUMPTION.toString())) {
				if (Integer.parseInt(validateCriteria.getValue().toString()) > 0
						&& Integer.parseInt(validateCriteria.getValue().toString()) < 8000) {
					countOfMatchOfNameCriteria++;
				}
			} else if (validateCriteria.getKey().equalsIgnoreCase(SearchCriteria.Oven.WEIGHT.toString())) {
				if (Integer.parseInt(validateCriteria.getValue().toString()) > 0
						&& Integer.parseInt(validateCriteria.getValue().toString()) < 20) {
					countOfMatchOfNameCriteria++;
				}
			} else if (validateCriteria.getKey().equalsIgnoreCase(SearchCriteria.Oven.DEPTH.toString())) {
				if (Integer.parseInt(validateCriteria.getValue().toString()) > 0
						&& Integer.parseInt(validateCriteria.getValue().toString()) < 100) {
					countOfMatchOfNameCriteria++;
				}
			} else if (validateCriteria.getKey().equalsIgnoreCase(SearchCriteria.Oven.HEIGHT.toString())) {
				if (Double.parseDouble(validateCriteria.getValue().toString()) > 0
						&& Double.parseDouble(validateCriteria.getValue().toString()) < 50) {
					countOfMatchOfNameCriteria++;
				}
			} else if (validateCriteria.getKey().equalsIgnoreCase(SearchCriteria.Oven.WIDTH.toString())) {
				if (Double.parseDouble(validateCriteria.getValue().toString()) > 0
						&& Double.parseDouble(validateCriteria.getValue().toString()) < 100) {
					countOfMatchOfNameCriteria++;
				}
			}
		}
		return countOfMatchOfNameCriteria == criteria.getCriteria().size();
	}


	public static boolean isValidateCriteriaOfVacuumCleaner(Criteria criteria) {
		int countOfMatchOfNameCriteria = 0;
		for (Map.Entry<String, Object> validateCriteria : criteria.getCriteria().entrySet()) {
			if (validateCriteria.getKey().equalsIgnoreCase(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString())) {
				if (Integer.parseInt(validateCriteria.getValue().toString()) > 0
						&& Integer.parseInt(validateCriteria.getValue().toString()) < 300) {
					countOfMatchOfNameCriteria++;
				}
			} else if (validateCriteria.getKey().equalsIgnoreCase(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString())) {
				if (validateCriteria.getValue().equals(filterA)|| validateCriteria.getValue().equals(filterB)
						|| validateCriteria.getValue().equals(filterC)) {
					countOfMatchOfNameCriteria++;
				}
			} else if (validateCriteria.getKey().equalsIgnoreCase(SearchCriteria.VacuumCleaner.BAG_TYPE.toString())) {
				if (validateCriteria.getValue().equals("A2")|| validateCriteria.getValue().equals("AA-89")
						|| validateCriteria.getValue().equals("XX00")){
					countOfMatchOfNameCriteria++;
				}
			} else if (validateCriteria.getKey().equalsIgnoreCase(SearchCriteria.VacuumCleaner.WAND_TYPE.toString())) {
				if (validateCriteria.getValue().equals("all-in-one")) {
					countOfMatchOfNameCriteria++;
				}
			} else if (validateCriteria.getKey().equalsIgnoreCase(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString())) {
				if (Integer.parseInt(validateCriteria.getValue().toString()) > 0
						&& Integer.parseInt(validateCriteria.getValue().toString()) < 5000) {
					countOfMatchOfNameCriteria++;
				}
			}else if (validateCriteria.getKey().equalsIgnoreCase(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString())) {
				if (Integer.parseInt(validateCriteria.getValue().toString()) > 0
						&& Integer.parseInt(validateCriteria.getValue().toString()) < 100){
					countOfMatchOfNameCriteria++;
				}
			}
		}
		return countOfMatchOfNameCriteria == criteria.getCriteria().size();
	}

	private static boolean isValidateCriteriaOfLaptop(Criteria criteria) {
		int countOfMatchOfCriteria = 0;
		for (Map.Entry<String, Object> validateCriteria : criteria.getCriteria().entrySet()){
			if (validateCriteria.getKey().equalsIgnoreCase(SearchCriteria.Laptop.BATTERY_CAPACITY.toString())){
				if (Integer.parseInt(validateCriteria.getValue().toString()) > 0
						&& Integer.parseInt(validateCriteria.getValue().toString()) < 0) {
					countOfMatchOfCriteria++;
				}
			}
			if (validateCriteria.getKey().equalsIgnoreCase(SearchCriteria.Laptop.CPU.toString())){
				if (Double.parseDouble(validateCriteria.getValue().toString()) > 0
						&& Double.parseDouble(validateCriteria.getValue().toString()) < 5) {
					countOfMatchOfCriteria++;
				}
			}
			if (validateCriteria.getKey().equalsIgnoreCase(SearchCriteria.Laptop.OS.toString())){
				if (validateCriteria.getValue().toString().equalsIgnoreCase(linux)
						|| validateCriteria.getValue().toString().equalsIgnoreCase(windows)) {
					countOfMatchOfCriteria++;
				}
			}
			if (validateCriteria.getKey().equalsIgnoreCase(SearchCriteria.Laptop.MEMORY_ROM.toString())){
				if (Integer.parseInt(validateCriteria.getValue().toString()) > 2000
						&& Integer.parseInt(validateCriteria.getValue().toString()) < 32000) {
					countOfMatchOfCriteria++;
				}
			}
			if (validateCriteria.getKey().equalsIgnoreCase(SearchCriteria.Laptop.SYSTEM_MEMORY.toString())){
				if (Double.parseDouble(validateCriteria.getValue().toString()) > 0
						&& Double.parseDouble(validateCriteria.getValue().toString()) < 2000) {
					countOfMatchOfCriteria++;
				}
			}
			if (validateCriteria.getKey().equalsIgnoreCase(SearchCriteria.Laptop.DISPLAY_INCHS.toString())){
				if (Double.parseDouble(validateCriteria.getValue().toString()) > 11
						&& Double.parseDouble(validateCriteria.getValue().toString()) < 22) {
					countOfMatchOfCriteria++;
				}
			}
		}

	return countOfMatchOfCriteria == criteria.getCriteria().size();
	}

	private static boolean isValidateCriteriaOfTabletPC(Criteria criteria) {
		int countOfMatchOfCriteria = 0;
		for (Map.Entry<String, Object> validateCriteria : criteria.getCriteria().entrySet()) {
			if(validateCriteria.getKey().equalsIgnoreCase(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString())){
				if (Integer.parseInt(validateCriteria.getValue().toString()) > 0
						&& Integer.parseInt(validateCriteria.getValue().toString()) < 5){
					countOfMatchOfCriteria++;
				}
			}
			if(validateCriteria.getKey().equalsIgnoreCase(SearchCriteria.TabletPC.COLOR.toString())){
				if (validateCriteria.getValue().toString().equalsIgnoreCase(redColor)
						|| validateCriteria.getValue().toString().equalsIgnoreCase(blueColor)
						|| validateCriteria.getValue().toString().equalsIgnoreCase(greenColor)){
					countOfMatchOfCriteria++;
				}
			}
			if(validateCriteria.getKey().equalsIgnoreCase(SearchCriteria.TabletPC.DISPLAY_INCHES.toString())){
				if (Integer.parseInt(validateCriteria.getValue().toString()) > 11
						&& Integer.parseInt(validateCriteria.getValue().toString()) < 20){
					countOfMatchOfCriteria++;
				}
			}
			if(validateCriteria.getKey().equalsIgnoreCase(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString())){
				if (Integer.parseInt(validateCriteria.getValue().toString()) > 0
						&& Integer.parseInt(validateCriteria.getValue().toString()) < 10){
					countOfMatchOfCriteria++;
				}
			}
			if(validateCriteria.getKey().equalsIgnoreCase(SearchCriteria.TabletPC.MEMORY_ROM.toString())){
				if (Integer.parseInt(validateCriteria.getValue().toString()) > 4000
						&& Integer.parseInt(validateCriteria.getValue().toString()) < 32000){
					countOfMatchOfCriteria++;
				}
			}

		}
		return countOfMatchOfCriteria == criteria.getCriteria().size();
	}

	public static boolean isValidateCriteriaOfRefrigerator(Criteria criteria) {
		int countOfMatchOfNameCriteria = 0;
		for (Map.Entry<String, Object> validateCriteria : criteria.getCriteria().entrySet()) {
			if (validateCriteria.getKey().equalsIgnoreCase(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString())) {
				if (validateCriteria.getValue() instanceof Integer
						&& Integer.parseInt(validateCriteria.getValue().toString()) > 0
						&& Integer.parseInt(validateCriteria.getValue().toString()) < 300) {
					countOfMatchOfNameCriteria++;
				}
			} else if (validateCriteria.getKey().equalsIgnoreCase(SearchCriteria.Refrigerator.WEIGHT.toString())) {
				if (validateCriteria.getValue() instanceof Integer
						&& Integer.parseInt(validateCriteria.getValue().toString()) > 0
						&& Integer.parseInt(validateCriteria.getValue().toString()) < 100) {
					countOfMatchOfNameCriteria++;
				}
			} else if (validateCriteria.getKey().equalsIgnoreCase(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString())) {
				if (validateCriteria.getValue() instanceof Integer
						&& Integer.parseInt(validateCriteria.getValue().toString()) > 0
						&& Integer.parseInt(validateCriteria.getValue().toString()) < 500) {
					countOfMatchOfNameCriteria++;
				}
			} else if (validateCriteria.getKey().equalsIgnoreCase(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString())) {
				if (Double.parseDouble(validateCriteria.getValue().toString()) > 0
						&& Double.parseDouble(validateCriteria.getValue().toString()) < 500) {
					countOfMatchOfNameCriteria++;
				}
			} else if (validateCriteria.getKey().equalsIgnoreCase(SearchCriteria.Refrigerator.HEIGHT.toString())) {
				if (validateCriteria.getValue() instanceof Integer
						&& Integer.parseInt(validateCriteria.getValue().toString()) > 0
						&& Integer.parseInt(validateCriteria.getValue().toString()) < 100) {
					countOfMatchOfNameCriteria++;
				}
			}else if (validateCriteria.getKey().equalsIgnoreCase(SearchCriteria.Refrigerator.WIDTH.toString())) {
				if (validateCriteria.getValue() instanceof Integer
						&& Integer.parseInt(validateCriteria.getValue().toString()) > 0
						&& Integer.parseInt(validateCriteria.getValue().toString()) < 100) {
					countOfMatchOfNameCriteria++;
				}
			}
		}
		return countOfMatchOfNameCriteria == criteria.getCriteria().size();
	}

	public static boolean isValidateCriteriaOfSpeakers(Criteria criteria) {
		int countOfMatchOfNameCriteria = 0;
		for (Map.Entry<String, Object> validateCriteria : criteria.getCriteria().entrySet()) {
			if (validateCriteria.getKey().equalsIgnoreCase(SearchCriteria.Speakers.POWER_CONSUMPTION.toString())) {
				if (validateCriteria.getValue() instanceof Integer
						&& Integer.parseInt(validateCriteria.getValue().toString()) > 0
						&& Integer.parseInt(validateCriteria.getValue().toString()) < 100) {
					countOfMatchOfNameCriteria++;
				}
			} else if (validateCriteria.getKey().equalsIgnoreCase(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString())) {
				if (validateCriteria.getValue() instanceof Integer
						&& Integer.parseInt(validateCriteria.getValue().toString()) > 0
						&& Integer.parseInt(validateCriteria.getValue().toString()) < 10) {
					countOfMatchOfNameCriteria++;
				}
			} else if (validateCriteria.getKey().equalsIgnoreCase(SearchCriteria.Speakers.FREQUENCY_RANGE.toString())) {
				if (validateCriteria.getValue().equals("2-4")|| validateCriteria.getValue().equals("3-4")
						|| validateCriteria.getValue().equals("2-3.5")){
					countOfMatchOfNameCriteria++;
				}
			} else if (validateCriteria.getKey().equalsIgnoreCase(SearchCriteria.Speakers.CORD_LENGTH.toString())) {
				if (validateCriteria.getValue() instanceof Integer
						&&Integer.parseInt(validateCriteria.getValue().toString()) > 0
						&& Integer.parseInt(validateCriteria.getValue().toString()) < 10) {
					countOfMatchOfNameCriteria++;
				}
			}
		}
		return countOfMatchOfNameCriteria == criteria.getCriteria().size();
	}

}

//you may add your own new classes