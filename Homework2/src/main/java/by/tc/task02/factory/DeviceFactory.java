package by.tc.task02.factory;

import by.tc.task02.entity.Appliance;
import by.tc.task02.entity.criteria.Criteria;

public interface DeviceFactory {
    Appliance createDevice(Criteria criteria);
}
