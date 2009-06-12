package org.eclipse.xtext.parsetree.formatter;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

public class FormatterTest extends AbstractGeneratorTest {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(FormatterTestLanguageStandaloneSetup.class);
	}

	public void testLinewrap() throws Exception {
		final String model = "test linewrap float val; int x; double y;";
		final String expected = "test linewrap\nfloat val;\nint x;\ndouble y;";
		EObject m = getModel(model);
		// System.out.println(EmfFormater.objToStr(m, ""));
		String res = serialize(m);
		// System.out.println(res);
		assertEquals(expected, res);
	}

	public void testKeepComments() throws Exception {
		// final String model = "test linewrap float val; int x; double y;";
		final String model = "// begincomment \ntest linewrap// comment1\n"
				+ "float val;//comment2\n" + "int x;"
				+ "double y;//yoyoyo!\n// endcomment.";
		final String exp = "// begincomment \ntest linewrap // comment1\n"
			+ "float val; //comment2\n" + "int x;\n"
			+ "double y; //yoyoyo!\n// endcomment.";
		EObject m = getModel(model);
//		System.out.println(EmfFormatter.objToStr(getResource(
//				new StringInputStream(model)).getParseResult().getRootNode()));
		String res = serialize(m);
		// System.out.println(res);
		assertEquals(exp, res);
	}

	public void testIndentation() throws Exception {
		final String model = "test indentation { float val; indentation { int x; } double y; }";
		final String expected = "test indentation {\n  float val;\n  double y;\n  indentation {\n    int x;\n  }\n}";
		EObject m = getModel(model);
		// System.out.println(EmfFormater.objToStr(m, ""));
		String res = serialize(m);
		// System.out.println(res);
		assertEquals(expected, res);
	}
	
	public void testAssociation() throws Exception {
		final String model = "test indentation { var = [0,1,2,3,4]; }";
		final String expected = "test indentation {\n  var=[ 0, 1, 2, 3, 4 ];\n}";
		EObject m = getModel(model);
		// System.out.println(EmfFormater.objToStr(m, ""));
		String res = serialize(m);
		// System.out.println(res);
		assertEquals(expected, res);
	}
	
	public void testIndentationAndComments() throws Exception {
		final String model = "test /* xxx */ indentation { float val; // some float\n double /* oo */ y; indentation { // some block\n int x; // xxx\n } } // final comment";
		final String expected = "test /* xxx */ indentation {\n  float val; // some float\n  double /* oo */ y;\n  indentation { // some block\n    int x; // xxx\n  }\n} // final comment";
		EObject m = getModel(model);
		String res = serialize(m);
		assertEquals(expected, res);
	}
	
	public void testIndentationAndLineWrap() throws Exception {
		final String model = "test indentation { void func(x:int,y:int,s:javalangString, foo:javasqlDate, blupp:mylongtype,  msads:adshdjkhsakdasdkslajdlsask, x:x, a:b, c:d ); }";
		final String expected = "test indentation {\n  void func(x:int, y:int,\n    s:javalangString,\n    foo:javasqlDate,\n    blupp:mylongtype,\n    msads:adshdjkhsakdasdkslajdlsask,\n    x:x, a:b, c:d);\n}";
		EObject m = getModel(model);
		String res = serialize(m);
		assertEquals(expected, res);
	}
	
	public void testBetween1() throws Exception {
		final String model = "test indentation { indentation { x x; }; }";
		final String expected = "test indentation {\n  indentation {\n    x x;\n  };\n}";
		EObject m = getModel(model);
		String res = serialize(m);
		assertEquals(expected, res);
	}
	
	public void testBetween2() throws Exception {
		final String model = "test indentation { indentation { x x; } }";
		final String expected = "test indentation {\n  indentation {\n    x x;\n  }\n}";
		EObject m = getModel(model);
		String res = serialize(m);
		assertEquals(expected, res);
	}


}
