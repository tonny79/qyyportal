package zhulin.project.qyyportal.data;

import java.util.List;
import zhulin.project.qyyportal.Device;

public interface DeviceManager {
	public List<Device> loadDevices(String deviceType);
}
