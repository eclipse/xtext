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

}
