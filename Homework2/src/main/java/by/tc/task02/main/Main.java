package by.tc.task02.main;

import static by.tc.task02.entity.criteria.SearchCriteria.*;

import by.tc.task02.entity.AdditionToList;
import by.tc.task02.entity.criteria.Criteria;
import by.tc.task02.service.ApplianceService;
import by.tc.task02.service.ServiceFactory;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		AdditionToList appliance = new AdditionToList();
		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		//////////////////////////////////////////////////////////////////

		Criteria criteriaOven = new Criteria(Oven.class.getSimpleName());//"Oven"
		criteriaOven.add(Oven.CAPACITY.toString(), 32);

		appliance.addAppliance(service.find(criteriaOven));

		PrintApplianceInfo.print(appliance.getApplianceList());

		//////////////////////////////////////////////////////////////////

		criteriaOven = new Criteria(Oven.class.getSimpleName());
		criteriaOven.add(Oven.HEIGHT.toString(), 40);
		criteriaOven.add(Oven.DEPTH.toString(), 70);

		appliance.addAppliance(service.find(criteriaOven));

		PrintApplianceInfo.print(appliance.getApplianceList());

		//////////////////////////////////////////////////////////////////
		
		Criteria criteriaTabletPC = new Criteria(TabletPC.class.getSimpleName());
		criteriaTabletPC.add(TabletPC.COLOR.toString(), "blue");
		criteriaTabletPC.add(TabletPC.DISPLAY_INCHES.toString(), 14);
		criteriaTabletPC.add(TabletPC.MEMORY_ROM.toString(), 8000);

		appliance.addAppliance(service.find(criteriaTabletPC));

		PrintApplianceInfo.print(appliance.getApplianceList());

	}

}
