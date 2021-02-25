package com.namitha.training.spring_starter_pro;

public class SoftwareEngineer implements Engineer {//implements initializingBean, DisposableBean
	
	public SoftwareEngineer(Address theAddress) {
		
		this.theAddress = theAddress;
	}

     public SoftwareEngineer() {
		
		
	}
	
	private Address theAddress;

	public Address getTheAddress() {
		return theAddress;
	}

	public void setTheAddress(Address theAddress) {
		this.theAddress = theAddress;
	}
	
	public void workForWages()
	{
		System.out.println("I am  a software engineer, I belong to");
		System.out.println(this.getTheAddress().getLocation()+", "+ this.getTheAddress().getPinCode());
	}
	
	void callAtBeginning()
	{
		System.out.println("Software Engineer has been instantiated");
	}
	
	void callAtEnd()
	{
		System.out.println("Software Engineer bean about to be destroyed");
	}
	
//	@Override
//	public void afterPropertiesSet() throws Exception{
//		System.out.println("Software engineer bean has been instantiated");
//	}
//	
//	@Override
//	public void destroy() throws exception {
//		System.out.println(" Bean about to be destroyed");
//	}
//	

}
