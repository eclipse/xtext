package org.xpect.tests.state;

import org.xpect.state.Creates;
import org.xpect.state.Managed;
import org.xpect.state.ManagedImpl;

public class TestData {
	public static class StaticValueProvider {
		@Creates
		public String getDefaultValue() {
			return "DefaultValue";
		}

		@Creates(annotatedWith = Ann.class)
		public String getAnnotatedValue() {
			return "AnnotatedValue";
		}
	}

	public static class StaticManagedProvider {

		@Creates
		public Managed<String> getDefaultManaged() {
			return new ManagedImpl<String>("DefaultManaged");
		}

		@Creates(annotatedWith = Ann.class)
		public Managed<String> getAnnotatedManaged() {
			return new ManagedImpl<String>("AnnotatedManaged");
		}
	}

	public @interface Ann {
	}

}
