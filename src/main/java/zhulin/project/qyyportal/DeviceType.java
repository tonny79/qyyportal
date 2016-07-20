package zhulin.project.qyyportal;

import java.util.Set;

public class DeviceType {
	private int id;
	private String name;
	private Set<String> attributes;
	
	public DeviceType(int id,String name,Set<String> attributes){
		this.id=id;
		this.name=name;
		this.attributes=attributes;
	}
	
	public int getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public Set<String> getAttributes(){
		return this.attributes;
	}
}
