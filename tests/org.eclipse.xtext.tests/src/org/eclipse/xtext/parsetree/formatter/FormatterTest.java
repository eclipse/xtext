package org.eclipse.xtext.parsetree.formatter;

import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting.INodeModelFormatter.IFormattedRegion;
import org.eclipse.xtext.formatting.INodeModelStreamer;
import org.eclipse.xtext.formatting.impl.AbstractTokenStream;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor;
import org.eclipse.xtext.resource.SaveOptions;

public class FormatterTest extends AbstractXtextTests {

	private static class TokenBuffer extends AbstractTokenStream {

		private StringBuffer buf = new StringBuffer();

		@Override
		public void writeHidden(EObject grammarElement, String value) throws IOException {
			buf.append("Hidden   " + grammarElement.eClass().getName() + ": '" + value + "'\n");
		}

		@Override
		public void writeSemantic(EObject grammarElement, String value) throws IOException {
			buf.append("Semantic " + grammarElement.eClass().getName() + ": '" + value + "'\n");
		}

		@Override
		public String toString() {
			return buf.toString();
		}

	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(FormatterTestLanguageStandaloneSetup.class);
	}

	// test formatting based on the ParseTreeConstructor
	private void assertFormattedPTC(String expected, String model) throws Exception {
		EObject m = getModel(model);
		String res = getSerializer().serialize(m, SaveOptions.newBuilder().format().getOptions());
		assertEquals(expected, res);
	}

	// test formatting based on the NodeModel
	private void assertFormattedNM(String expected, String model, int offset, int lengt) throws Exception {
		CompositeNode node = NodeUtil.getRootNode(getModel(model));
		// System.out.println(EmfFormatter.objToStr(node));
		IFormattedRegion r = getNodeModelFormatter().format(node, offset, lengt);
		String actual = model.substring(0, r.getOffset()) + r.getFormattedText()
				+ model.substring(r.getLenght() + r.getOffset());
		assertEquals(expected, actual);
	}

	private void assertEqualTokenStreams(String modelString) throws Exception {
		EObject model = getModel(modelString);
		IParseTreeConstructor ptc = get(IParseTreeConstructor.class);
		INodeModelStreamer nms = get(INodeModelStreamer.class);
		TokenBuffer ptcTb = new TokenBuffer();
		TokenBuffer nmsTb = new TokenBuffer();
		ptc.serializeSubtree(model, ptcTb);
		nms.feedTokenStream(nmsTb, NodeUtil.getRootNode(model), 0, modelString.length());
		assertEquals(ptcTb.toString(), nmsTb.toString());
	}

	public void testLinewrap() throws Exception {
		final String model = "test linewrap float val; int x; double y;";
		final String expected = "test linewrap\nfloat val;\nint x;\ndouble y;";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
		assertEqualTokenStreams(model);
	}

	public void testKeepComments() throws Exception {
		// final String model = "test linewrap float val; int x; double y;";
		final String model = "// begincomment \ntest linewrap// comment1\n" + "float val;//comment2\n" + "int x;"
				+ "double y; //yoyoyo!\n// endcomment.";
		final String exp = "// begincomment \ntest linewrap // comment1\n" + "float val; //comment2\n" + "int x;\n"
				+ "double y; //yoyoyo!\n// endcomment.";
		assertFormattedPTC(exp, model);
		assertFormattedNM(exp, model, 0, model.length());
		assertEqualTokenStreams(model);
	}

	public void testIndentation() throws Exception {
		final String model = "test indentation { float val; double y; indentation { int x; } }";
		final String expected = "test indentation {\n  float val;\n  double y;\n  indentation {\n    int x;\n  }\n}";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
		assertEqualTokenStreams(model);
	}

	public void testAssociation() throws Exception {
		final String model = "test indentation { var = [0,1,2,3,4]; }";
		final String expected = "test indentation {\n  var=[ 0, 1, 2, 3, 4 ];\n}";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
		assertEqualTokenStreams(model);
	}

	public void testIndentationAndComments() throws Exception {
		final String model = "test /* xxx */ indentation { float val; // some float\n double /* oo */ y; indentation { // some block\n int x; // xxx\n } } // final comment";
		final String expected = "test /* xxx */ indentation {\n  float val; // some float\n  double /* oo */ y;\n  indentation { // some block\n    int x; // xxx\n  }\n} // final comment";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
		assertEqualTokenStreams(model);
	}

	public void testIndentationAndLineWrap() throws Exception {
		final String model = "test indentation { void func(x:int,y:int,s:javalangString, foo:javasqlDate, blupp:mylongtype,  msads:adshdjkhsakdasdkslajdlsask, x:x, a:b, c:d ); }";
		final String expected = "test indentation {\n  void func(x:int, y:int,\n    s:javalangString,\n    foo:javasqlDate,\n    blupp:mylongtype,\n    msads:adshdjkhsakdasdkslajdlsask,\n    x:x, a:b, c:d);\n}";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
		assertEqualTokenStreams(model);
	}

	public void testBetween1() throws Exception {
		final String model = "test indentation { indentation { x x; }; }";
		final String expected = "test indentation {\n  indentation {\n    x x;\n  };\n}";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
		assertEqualTokenStreams(model);
	}

	public void testBetween2() throws Exception {
		final String model = "test indentation { indentation { x x; } }";
		final String expected = "test indentation {\n  indentation {\n    x x;\n  }\n}";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
		assertEqualTokenStreams(model);
	}

	public void testLinewrapDatatypeRule() throws Exception {
		final String model = "test linewrap fqn ab; fqn xx.yy.zz;";
		final String expected = "test linewrap\nfqn\nab;\nfqn\nxx.yy.zz;";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
		assertEqualTokenStreams(model);
	}

	public void testLinewrapDatatypeRulePartial1() throws Exception {
		final String model = "test linewrap fqn ab . xx .yy   .zz;";
		final String expected = "test linewrap fqn \nab.xx.yy.zz;";
		assertFormattedNM(expected, model, 22, 2);
	}

	public void testLinewrapDatatypeRulePartial2() throws Exception {
		final String model = "test linewrap fqn ab . xx .yy   .zz;fqn xxx;";
		final String expected = "test linewrap fqn\nab.xx.yy.zz;fqn xxx;";
		assertFormattedNM(expected, model, 15, 10);
	}

	public void testLinewrapDatatypeRulePartial3() throws Exception {
		final String model = "test linewrap fqn ab . xx .yy   .zz;fqn xxx;";
		final String expected = "test linewrap fqn \nab.xx.yy.zz;\nfqn xxx;";
		assertFormattedNM(expected, model, 25, 12);
	}

	public void testLinewrapDatatypeRuleRef1() throws Exception {
		final String model = "test linewrap fqn ab  .cd .ef; fqnref ab. cd. ef;";
		final String expected = "test linewrap\nfqn\nab.cd.ef;\nfqnref\nab.cd.ef;";
		//		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
		//		assertEqualTokenStreams(model);
	}

	public void testLinewrapDatatypeRuleRef2() throws Exception {
		final String model = "test linewrap fqn ab.cd.ef; fqnref ab.cd.ef;";
		final String expected = "test linewrap\nfqn\nab.cd.ef;\nfqnref\nab.cd.ef;";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
		assertEqualTokenStreams(model);
	}

	public void testLinewrapDatatypeRuleComments() throws Exception {
		final String model = "test linewrap/* 1 */fqn/* 2 */ab.cd.ef/* 3 */;/* 4 */fqnref/* 5 */ab.cd.ef/* 6 */;/* 7 */";
		final String expected = "test linewrap /* 1 */ fqn\n/* 2 */\nab.cd.ef /* 3 */; /* 4 */\nfqnref /* 5 */ ab.cd.ef\n/* 6 */; /* 7 */";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
		assertEqualTokenStreams(model);
	}

	public void testEnumeration() throws Exception {
		final String model = "test linewrap enum lit1,lit2,lit3,lit1;";
		final String expected = "test linewrap\nenum lit1 ,\nlit2,\nlit3,\nlit1;";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
		assertEqualTokenStreams(model);
	}
}
