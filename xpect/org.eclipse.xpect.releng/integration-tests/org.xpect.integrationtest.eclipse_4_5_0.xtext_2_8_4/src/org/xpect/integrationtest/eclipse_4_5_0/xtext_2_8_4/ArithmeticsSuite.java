package org.xpect.integrationtest.eclipse_4_5_0.xtext_2_8_4;

import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;

public class ArithmeticsSuite extends Suite {

	public ArithmeticsSuite(Class<?> klass) throws InitializationError {
		super(klass, getClasses());
	}

	private static Class<?>[] getClasses() {
		try {
			String name = "org.eclipse.xtext.example.arithmetics.xpect.tests.AllArithmeticsTests";
			return new Class<?>[] { Class.forName(name) };
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
