package org.xpect.tests;

import org.junit.Test;
import org.xpect.runner.Xpect;
import org.xpect.runner.XpectSuiteClasses;
import org.xpect.tests.XjmMethodsTest.SuiteWithLoop.LoopMember1;
import org.xpect.tests.XjmMethodsTest.SuiteWithNameConflicts.Conflict1;
import org.xpect.tests.XjmMethodsTest.SuiteWithNameConflicts.Conflict2;
import org.xpect.tests.XjmMethodsTest.SuiteWithNesting.SuiteMember1;
import org.xpect.tests.XjmMethodsTest.SuiteWithNesting.SuiteMember2;

public class XjmMethodsTest extends AbstractXjmTest {

	protected static class SingleTestWithMethods {
		@Test
		void packageTest() {
		}

		@Xpect
		void packageXpect() {
		}

		@Test
		private void privateTest() {
		}

		@Xpect
		private void privateXpect() {
		}

		@Test
		protected void protectedTest() {
		}

		@Xpect
		protected void protectedXpect() {
		}

		@Test
		public void publicTest() {
		}

		@Xpect
		public void publicXpect() {
		}

		@Override
		public String toString() {
			StringBuilder buf = new StringBuilder();
			buf.append("suite org.xpect.tests.XjmMethodsTest$SingleTestWithMethods {\n");
			buf.append("  test org.xpect.tests.XjmMethodsTest$SingleTestWithMethods {\n");
			buf.append("    @Test public void publicTest();\n");
			buf.append("    @Xpect public void publicXpect();\n");
			buf.append("  }\n");
			buf.append("}");
			return buf.toString();
		}
	}

	@XpectSuiteClasses(LoopMember1.class)
	protected static class SuiteWithLoop {

		@XpectSuiteClasses(SuiteWithLoop.class)
		protected static class LoopMember1 {
			@Test
			public void testMember1() {
			}
		}

		@Test
		public void testMember0() {
		}

		@Override
		public String toString() {
			StringBuilder buf = new StringBuilder();
			buf.append("suite org.xpect.tests.XjmMethodsTest$SuiteWithLoop {\n");
			buf.append("  test org.xpect.tests.XjmMethodsTest$SuiteWithLoop {\n");
			buf.append("    @Test public void testMember0();\n");
			buf.append("  }\n");
			buf.append("  test org.xpect.tests.XjmMethodsTest$SuiteWithLoop$LoopMember1 {\n");
			buf.append("    @Test public void testMember1();\n");
			buf.append("  }\n");
			buf.append("}");
			return buf.toString();
		}

	}

	@XpectSuiteClasses({ Conflict1.class, Conflict2.class })
	protected static class SuiteWithNameConflicts {
		protected static class AbstractConflict {
			@Test
			public void TestConflict0() {
			}

			@Xpect
			public void xpectConflict0() {
			}
		}

		protected static class Conflict1 {
			@Xpect
			public void noConflict() {
			}

			@Test
			public void TestConflict1() {
			}

			@Xpect
			public void xpectConflict1() {
			}
		}

		protected static class Conflict2 {
			@Test
			public void noConflict() {
			}

			@Test
			public void TestConflict1() {
			}

			@Xpect
			public void xpectConflict1() {
			}
		}

		@Override
		public String toString() {
			StringBuilder buf = new StringBuilder();
			buf.append("suite org.xpect.tests.XjmMethodsTest$SuiteWithNameConflicts {\n");
			buf.append("  test org.xpect.tests.XjmMethodsTest$SuiteWithNameConflicts {}\n");
			buf.append("  test org.xpect.tests.XjmMethodsTest$SuiteWithNameConflicts$Conflict1 {\n");
			buf.append("    @Xpect public void noConflict();\n");
			buf.append("  }\n");
			buf.append("  test org.xpect.tests.XjmMethodsTest$SuiteWithNameConflicts$Conflict2 {\n");
			buf.append("    @Test public void noConflict();\n");
			buf.append("  }\n");
			buf.append("}");
			return buf.toString();
		}
	}

	@XpectSuiteClasses({ SuiteMember1.class, SuiteMember2.class })
	protected static class SuiteWithNesting {
		protected static class SuiteMember1 {
			@Test
			public void testMember1() {
			}

			@Xpect
			public void xpectMember1() {
			}
		}

		@XpectSuiteClasses(SuiteMember3.class)
		protected static class SuiteMember2 {
			@Test
			public void testMember2() {
			}

			@Xpect
			public void xpectMember2() {
			}
		}

		protected static class SuiteMember3 {
			@Test
			public void testMember3() {
			}

			@Xpect
			public void xpectMember3() {
			}
		}

		@Test
		public void testMember0() {
		}

		@Override
		public String toString() {
			StringBuilder buf = new StringBuilder();
			buf.append("suite org.xpect.tests.XjmMethodsTest$SuiteWithNesting {\n");
			buf.append("  test org.xpect.tests.XjmMethodsTest$SuiteWithNesting {\n");
			buf.append("    @Test public void testMember0();\n");
			buf.append("    @Xpect public void xpectMember0();\n");
			buf.append("  }\n");
			buf.append("  test org.xpect.tests.XjmMethodsTest$SuiteWithNesting$SuiteMember1 {\n");
			buf.append("    @Test public void testMember1();\n");
			buf.append("    @Xpect public void xpectMember1();\n");
			buf.append("  }\n");
			buf.append("  test org.xpect.tests.XjmMethodsTest$SuiteWithNesting$SuiteMember2 {\n");
			buf.append("    @Test public void testMember2();\n");
			buf.append("    @Xpect public void xpectMember2();\n");
			buf.append("  }\n");
			buf.append("  test org.xpect.tests.XjmMethodsTest$SuiteWithNesting$SuiteMember3 {\n");
			buf.append("    @Test public void testMember3();\n");
			buf.append("    @Xpect public void xpectMember3();\n");
			buf.append("  }\n");
			buf.append("}");
			return buf.toString();
		}

		@Xpect
		public void xpectMember0() {
		}

	}

	@Test
	public void singleTestWithMethods() {
		assertXjm(SingleTestWithMethods.class);
	}

	@Test
	public void suiteWithLoop() {
		assertXjm(SuiteWithLoop.class);
	}

	@Test
	public void suiteWithNameConflicts() {
		assertXjm(SuiteWithNameConflicts.class);
	}

	@Test
	public void suiteWithNesting() {
		assertXjm(SuiteWithNesting.class);
	}
}
