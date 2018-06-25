package com.rackspace.vehicleinventory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class VehicleInventoryManagerApplication {


	public static void main(String[] args) {
		ApplicationContext ctx =
				new AnnotationConfigApplicationContext(VehicleInventoryManagerConfiguration.class);
		((AnnotationConfigApplicationContext) ctx).refresh();
	}
}
