package org.xpect.tests.state;

import org.junit.Test
import org.xpect.state.Creates

import static org.xpect.tests.state.StateTestUtil.*

class AnlyzedConfigurationTest {

	@Test
	def void testSimple() {
		val actual = newAnalyzedConfiguration [
			addFactory(Singleton1);
			addFactory(Singleton2);
			addDefaultValue("MyString1");
			addValue(MyAnnotaion1, "MyString2");
		]
		val expected = '''
			Primary Values {
			    PrimaryValue[@MyAnnotaion1 String Managed[MyString2]]
			    PrimaryValue[String Managed[MyString1]]
			}
			Derived Values {
			    org.xpect.tests.state.Singleton1{
			        out DerivedValue[StringBuffer Singleton1.getBuffer()]
			    }
			    org.xpect.tests.state.Singleton2{
			        in PrimaryValue[String Managed[MyString1]]
			        out DerivedValue[@Annotation StringBuffer Singleton2.getBuffer()]
			    }
			}
		'''
		assertEquals(expected, actual);
	}

	@Test
	def void testStaticValue() {
		val actual = newAnalyzedConfiguration[
			addFactory(TestData.StaticValueProvider);
		]
		val expected = '''
			Primary Values {
			}
			Derived Values {
			    org.xpect.tests.state.TestData$StaticValueProvider{
			        out DerivedValue[@Ann String StaticValueProvider.getAnnotatedValue()]
			        out DerivedValue[String StaticValueProvider.getDefaultValue()]
			    }
			}
		'''
		assertEquals(expected, actual);
	}

	@Test
	def void testStaticManaged() {
		val actual = newAnalyzedConfiguration [
			addFactory(TestData.StaticManagedProvider);
		]
		val expected = '''
			Primary Values {
			}
			Derived Values {
			    org.xpect.tests.state.TestData$StaticManagedProvider{
			        out DerivedValue[@Ann String StaticManagedProvider.getAnnotatedManaged()]
			        out DerivedValue[String StaticManagedProvider.getDefaultManaged()]
			    }
			}
		'''
		assertEquals(expected, actual);
	}

	@Test
	def void testLogginTestDataValue() {
		val actual = newAnalyzedConfiguration[
			addDefaultValue(new LoggingTestData.EventLogger());
			addFactory(LoggingTestData.StaticValueLoggingProvider);
			addFactory(LoggingTestData.DerivedProvider);
		]
		val expected = '''
			Primary Values {
			    PrimaryValue[EventLogger Managed[]]
			}
			Derived Values {
			    org.xpect.tests.state.LoggingTestData$StaticValueLoggingProvider{
			        in PrimaryValue[EventLogger Managed[]]
			        out DerivedValue[@Ann String StaticValueLoggingProvider.getAnnotatedValue()]
			        out DerivedValue[String StaticValueLoggingProvider.getDefaultValue()]
			    }
			    org.xpect.tests.state.LoggingTestData$DerivedProvider{
			        in DerivedValue[@Ann String StaticValueLoggingProvider.getAnnotatedValue()]
			        in DerivedValue[String StaticValueLoggingProvider.getDefaultValue()]
			        in PrimaryValue[EventLogger Managed[]]
			        out DerivedValue[@AnnDerived1 String DerivedProvider.getDerived1()]
			        out DerivedValue[@AnnDerived2 String DerivedProvider.getDerived2()]
			    }
			}
		'''
		assertEquals(expected, actual);
	}

	@Test
	def void testLogginTestDataManaged() {
		val actual = newAnalyzedConfiguration[
			addDefaultValue(new LoggingTestData.EventLogger());
			addFactory(LoggingTestData.StaticManagedLoggingProvider);
			addFactory(LoggingTestData.DerivedProvider);
		]
		val expected = '''
			Primary Values {
			    PrimaryValue[EventLogger Managed[]]
			}
			Derived Values {
			    org.xpect.tests.state.LoggingTestData$StaticManagedLoggingProvider{
			        in PrimaryValue[EventLogger Managed[]]
			        out DerivedValue[@Ann String StaticManagedLoggingProvider.getAnnotatedManaged()]
			        out DerivedValue[String StaticManagedLoggingProvider.getDefaultManaged()]
			    }
			    org.xpect.tests.state.LoggingTestData$DerivedProvider{
			        in DerivedValue[@Ann String StaticManagedLoggingProvider.getAnnotatedManaged()]
			        in DerivedValue[String StaticManagedLoggingProvider.getDefaultManaged()]
			        in PrimaryValue[EventLogger Managed[]]
			        out DerivedValue[@AnnDerived1 String DerivedProvider.getDerived1()]
			        out DerivedValue[@AnnDerived2 String DerivedProvider.getDerived2()]
			    }
			}
		'''
		assertEquals(expected, actual);
	}

}

annotation MyAnnotaion1 {
}

class Singleton1 {
	@Creates()
	def StringBuffer getBuffer() {
		new StringBuffer("buffer")
	}
}

class Singleton2 {

	val String param;

	new(@MyAnnotaion1 String param) {
		this.param = param;
	}

	@Creates(Annotation)
	def StringBuffer getBuffer() {
		return new StringBuffer("buffer " + param);
	}
}

annotation Annotation {
}
