package by.tc.task02.dao;

import by.tc.task02.entity.Appliance;
import by.tc.task02.entity.criteria.Criteria;

import java.io.IOException;

public interface ApplianceDAO {
	Appliance find(Criteria criteria) throws IOException;

}
