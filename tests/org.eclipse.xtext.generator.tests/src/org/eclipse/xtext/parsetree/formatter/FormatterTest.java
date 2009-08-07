package org.eclipse.xtext.parsetree.formatter;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting.INodeModelFormatter.IFormattedRegion;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.tests.AbstractGeneratorTest;
import org.eclipse.xtext.util.EmfFormatter;

public class FormatterTest extends AbstractGeneratorTest {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(FormatterTestLanguageStandaloneSetup.class);
	}

	// test formatting based on the ParseTreeConstructor
	private void assertFormattedPTC(String expected, String model)
			throws Exception {
		EObject m = getModel(model);
		String res = serialize(m);
		assertEquals(expected, res);
	}

	// test formatting based on the NodeModel
	private void assertFormattedNM(String expected, String model, int offset,
			int lengt) throws Exception {
		CompositeNode node = NodeUtil.getRootNode(getModel(model));
		System.out.println(EmfFormatter.objToStr(node));
		IFormattedRegion r = getNodeModelFormatter()
				.format(node, offset, lengt);
		String actual = model.substring(0, r.getOffset())
				+ r.getFormattedText()
				+ model.substring(r.getLenght() + r.getOffset());
		assertEquals(expected, actual);
	}

	public void testLinewrap() throws Exception {
		final String model = "test linewrap float val; int x; double y;";
		final String expected = "test linewrap\nfloat val;\nint x;\ndouble y;";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
	}

	public void testKeepComments() throws Exception {
		// final String model = "test linewrap float val; int x; double y;";
		final String model = "// begincomment \ntest linewrap// comment1\n"
				+ "float val;//comment2\n" + "int x;"
				+ "double y; //yoyoyo!\n// endcomment.";
		final String exp = "// begincomment \ntest linewrap // comment1\n"
				+ "float val; //comment2\n" + "int x;\n"
				+ "double y; //yoyoyo!\n// endcomment.";
		assertFormattedPTC(exp, model);
		assertFormattedNM(exp, model, 0, model.length());
	}

	public void testIndentation() throws Exception {
		final String model = "test indentation { float val; double y; indentation { int x; } }";
		final String expected = "test indentation {\n  float val;\n  double y;\n  indentation {\n    int x;\n  }\n}";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
	}

	public void testAssociation() throws Exception {
		final String model = "test indentation { var = [0,1,2,3,4]; }";
		final String expected = "test indentation {\n  var=[ 0, 1, 2, 3, 4 ];\n}";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
	}

	public void testIndentationAndComments() throws Exception {
		final String model = "test /* xxx */ indentation { float val; // some float\n double /* oo */ y; indentation { // some block\n int x; // xxx\n } } // final comment";
		final String expected = "test /* xxx */ indentation {\n  float val; // some float\n  double /* oo */ y;\n  indentation { // some block\n    int x; // xxx\n  }\n} // final comment";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
	}

	public void testIndentationAndLineWrap() throws Exception {
		final String model = "test indentation { void func(x:int,y:int,s:javalangString, foo:javasqlDate, blupp:mylongtype,  msads:adshdjkhsakdasdkslajdlsask, x:x, a:b, c:d ); }";
		final String expected = "test indentation {\n  void func(x:int, y:int,\n    s:javalangString,\n    foo:javasqlDate,\n    blupp:mylongtype,\n    msads:adshdjkhsakdasdkslajdlsask,\n    x:x, a:b, c:d);\n}";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
	}

	public void testBetween1() throws Exception {
		final String model = "test indentation { indentation { x x; }; }";
		final String expected = "test indentation {\n  indentation {\n    x x;\n  };\n}";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
	}

	public void testBetween2() throws Exception {
		final String model = "test indentation { indentation { x x; } }";
		final String expected = "test indentation {\n  indentation {\n    x x;\n  }\n}";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
	}

	public void testLinewrapDatatypeRule() throws Exception {
		final String model = "test linewrap fqn ab; fqn xx.yy.zz;";
		final String expected = "test linewrap\nfqn\nab;\nfqn\nxx.yy.zz;";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
	}

	public void testLinewrapDatatypeRulePartial1() throws Exception {
		final String model = "test linewrap fqn ab . xx .yy   .zz;";
		final String expected = "test linewrap fqn ab.xx.yy.zz;";
		assertFormattedNM(expected, model, 22, 2);
	}

	public void testLinewrapDatatypeRulePartial2() throws Exception {
		final String model = "test linewrap fqn ab . xx .yy   .zz;fqn xxx;";
		final String expected = "test linewrap fqn\nab.xx.yy.zz;fqn xxx;";
		assertFormattedNM(expected, model, 15, 10);
	}

	public void testLinewrapDatatypeRulePartial3() throws Exception {
		final String model = "test linewrap fqn ab . xx .yy   .zz;fqn xxx;";
		final String expected = "test linewrap fqn ab.xx.yy.zz;\nfqn xxx;";
		assertFormattedNM(expected, model, 25, 12);
	}

	public void _testLinewrapDatatypeRuleRef() throws Exception {
		final String model = "test linewrap fqn ab  .cd .ef; fqnref ab. cd. ef;";
		final String expected = "test linewrap\nfqn\nab.cd.ef;\nfqnref\nab.cd.ef;";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
	}
}
