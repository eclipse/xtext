package org.xpect.setup;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.xpect.setup.ThisTestObject.TestObjectSetup;
import org.xpect.state.Creates;

@Retention(RetentionPolicy.RUNTIME)
@XpectSetup(TestObjectSetup.class)
public @interface ThisTestObject {

	public class TestObjectSetup {
		private final Class<?> testClass;

		public TestObjectSetup(@ThisTestClass Class<?> testClass) {
			super();
			this.testClass = testClass;
		}

		@Creates(ThisTestObject.class)
		public Object createTestInstance() throws InstantiationException, IllegalAccessException {
			return this.testClass.newInstance();
		}

		protected Class<?> getTestClass() {
			return testClass;
		}
	}

}
