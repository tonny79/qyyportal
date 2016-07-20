package zhulin.project.qyyportal;

public class Device {
	private int id;
	private String name;
	
	public Device(int id,String name){
		this.id=id;
		this.name=name;
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}
}
