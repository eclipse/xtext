package org.xpect.tests;

import org.junit.Test;
import org.xpect.Environment;
import org.xpect.runner.XpectSuiteClasses;
import org.xpect.setup.XpectModule;
import org.xpect.setup.XpectModules;
import org.xpect.tests.XjmModulesTest.SetupsAndSuite.SetupsAndSuiteTest;

import com.google.inject.Binder;
import com.google.inject.Module;

public class XjmModulesTest extends AbstractXjmTest {

	public static class NullModule implements Module {
		public void configure(Binder binder) {
		}
	}

	public static class OtherModule implements Module {
		public void configure(Binder binder) {
		}
	}

	@XpectModule(module = NullModule.class)
	public static class SingleSetup {

		@Override
		public String toString() {
			StringBuilder buf = new StringBuilder();
			buf.append("suite org.xpect.tests.XjmModulesTest$SingleSetup {\n");
			buf.append("  module org.xpect.tests.XjmModulesTest$NullModule\n");
			buf.append("  test org.xpect.tests.XjmModulesTest$SingleSetup {\n");
			buf.append("    STANDALONE_TEST NullModule\n");
			buf.append("  }\n");
			buf.append("}");
			return buf.toString();
		}

	}

	@XpectModules({ //
	/*    */@XpectModule(environment = Environment.STANDALONE_TEST, module = NullModule.class), //
			@XpectModule(environment = Environment.PLUGIN_TEST, module = NullModule.class) //
	})
	public static class TwoSetups {

		@Override
		public String toString() {
			StringBuilder buf = new StringBuilder();
			buf.append("suite org.xpect.tests.XjmModulesTest$TwoSetups {\n");
			buf.append("  module org.xpect.tests.XjmModulesTest$NullModule\n");
			buf.append("  test org.xpect.tests.XjmModulesTest$TwoSetups {\n");
			buf.append("    STANDALONE_TEST NullModule\n");
			buf.append("    PLUGIN_TEST NullModule\n");
			buf.append("  }\n");
			buf.append("}");
			return buf.toString();
		}

	}

	@XpectModules({ //
	/*    */@XpectModule(environment = Environment.STANDALONE_TEST, module = NullModule.class), //
			@XpectModule(environment = Environment.PLUGIN_TEST, module = NullModule.class) //
	})
	@XpectSuiteClasses(SetupsAndSuiteTest.class)
	public static class SetupsAndSuite {

		@XpectModules({ //
		/*    */@XpectModule(environment = Environment.STANDALONE_TEST, module = NullModule.class), //
				@XpectModule(environment = Environment.PLUGIN_TEST, module = OtherModule.class) //
		})
		public static class SetupsAndSuiteTest {

		}

		@Override
		public String toString() {
			StringBuilder buf = new StringBuilder();
			buf.append("suite org.xpect.tests.XjmModulesTest$SetupsAndSuite {\n");
			buf.append("  module org.xpect.tests.XjmModulesTest$NullModule\n");
			buf.append("  module org.xpect.tests.XjmModulesTest$OtherModule\n");
			buf.append("  test org.xpect.tests.XjmModulesTest$SetupsAndSuite {\n");
			buf.append("    STANDALONE_TEST NullModule\n");
			buf.append("    PLUGIN_TEST NullModule\n");
			buf.append("  }\n");
			buf.append("  test org.xpect.tests.XjmModulesTest$SetupsAndSuite$SetupsAndSuiteTest {\n");
			buf.append("    STANDALONE_TEST NullModule\n");
			buf.append("    PLUGIN_TEST OtherModule\n");
			buf.append("  }\n");
			buf.append("}");
			return buf.toString();
		}

	}

	@Test
	public void singleSetup() {
		assertXjm(SingleSetup.class);
	}

	@Test
	public void twoSetups() {
		assertXjm(TwoSetups.class);
	}

	@Test
	public void setupsAndSuite() {
		assertXjm(SetupsAndSuite.class);
	}
}
