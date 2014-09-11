package org.eclipse.xcore.test;

import org.eclipse.xcoretest.MyClass2;
import org.eclipse.xcoretest.XcoretestFactory;

public class MyClass3 {
	
	public static void log() {
		MyClass1 myClass1 = new MyClass1();
		myClass1.toString();
		MyClass2 myClass2 = XcoretestFactory.eINSTANCE.createMyClass2();
		myClass2.toString();
	}
}
