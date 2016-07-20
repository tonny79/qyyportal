package zhulin.project.qyyportal.data;

import java.util.ArrayList;
import java.util.List;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import zhulin.project.qyyportal.Device;

@Component
public class DeviceService implements DeviceManager {
	private String dmServerURL;
	
	public DeviceService(String dmServerURL){
		this.dmServerURL=dmServerURL;
	}

	@Override
	public List<Device> loadDevices(String deviceType) {
		List<Device> result=new ArrayList<Device>();
		
		Client client=ClientBuilder.newClient();
		WebTarget base=client.target(this.dmServerURL);
		
		Response response=base.path("dmrest/devices/type/"+deviceType).request(MediaType.APPLICATION_JSON).get();
		JsonArray array=response.readEntity(JsonArray.class);
		for(JsonValue value:array){
			JsonObject object=(JsonObject)value;
			result.add(new Device(object.getInt("id"),object.getString("name")));
		}
		
		return result;
	}

}
