package by.tc.task02.factory;

import by.tc.task02.entity.Appliance;

import java.util.List;

public interface DeviceFactory {
    public List<Appliance> createDevice();
}
