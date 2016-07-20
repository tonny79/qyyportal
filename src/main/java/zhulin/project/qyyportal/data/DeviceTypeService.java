package zhulin.project.qyyportal.data;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import zhulin.project.qyyportal.DeviceType;

@Component
public class DeviceTypeService implements DeviceTypeManager {
	private String dmServerURL;
	
	public DeviceTypeService(String dmServerURL){
		this.dmServerURL=dmServerURL;
	}

	@Override
	public List<DeviceType> loadDeviceTypes() {
		List<DeviceType> result=new ArrayList<DeviceType>();
		Client client = ClientBuilder.newClient();
		WebTarget base = client.target(this.dmServerURL);

		Response response = base.path("dmrest/devicetypes").request(MediaType.APPLICATION_JSON).get();
		JsonArray array=response.readEntity(JsonArray.class);
		for(JsonValue value:array){
			JsonObject object=(JsonObject)value;
			JsonArray array2=object.getJsonArray("attributes");
			Set<String> attributes=new HashSet<String>();
			for(JsonValue value2:array2){
				JsonObject object2=(JsonObject)value2;
				attributes.add(object2.getString("attribute"));
			}
			
			result.add(new DeviceType(object.getInt("id"),object.getString("name"),attributes));
		}
		
		return result;
	}

}
