package by.tc.task02.dao.impl;

import by.tc.task02.dao.ApplianceDAO;
import by.tc.task02.entity.Appliance;
import by.tc.task02.entity.DataParser;
import by.tc.task02.entity.ReadFromFile;
import by.tc.task02.entity.criteria.Criteria;
import by.tc.task02.factory.impl.ApplianceSimpleFactory;

import java.io.IOException;

public class ApplianceDAOImpl implements ApplianceDAO{

	@Override
	public Appliance find(Criteria criteria) throws IOException {

		ReadFromFile reader = new ReadFromFile();
		DataParser parser = new DataParser();
		ApplianceSimpleFactory factory = new ApplianceSimpleFactory();
		Criteria testCriteria = parser.dataParser(reader.readFromFile(), criteria);
		if (testCriteria == null) return null;
		return factory.createDevice(testCriteria);
	}
	
	// you may add your own code here

}


//you may add your own new classes