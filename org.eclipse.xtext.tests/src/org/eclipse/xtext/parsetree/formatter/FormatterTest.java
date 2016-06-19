package org.eclipse.xtext.parsetree.formatter;

import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.formatting.INodeModelFormatter.IFormattedRegion;
import org.eclipse.xtext.formatting.INodeModelStreamer;
import org.eclipse.xtext.formatting.impl.AbstractTokenStream;
import org.eclipse.xtext.formatting.impl.DefaultNodeModelFormatter;
import org.eclipse.xtext.formatting.impl.NodeModelStreamer;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Decl;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.FormattertestlanguageFactory;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.TestLinewrapMinMax;
import org.eclipse.xtext.parsetree.reconstr.ITokenStream;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.ISyntacticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.TokenStreamSequenceAdapter;
import org.eclipse.xtext.serializer.analysis.SerializationContext;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;
import org.eclipse.xtext.serializer.sequencer.IHiddenTokenSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ISyntacticSequencer;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

public class FormatterTest extends AbstractXtextTests {

	protected static class TokenBuffer extends AbstractTokenStream {

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
		public void init(ParserRule startRule) {
			buf.append("Start '" + startRule.getName() + "'\n");
		}

		@Override
		public String toString() {
			return buf.toString();
		}

	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(FormatterTestLanguageStandaloneSetup.class);
		get(FormatterTestLineSeparatorInformation.class).setLineSeparator(getLineSeparator());
	}
	
	protected void assertFormattedPTC(String expected, String model) throws Exception {
		EObject m = getModel(convertLineBreaks(model));
		String res = getSerializer().serialize(m, SaveOptions.newBuilder().format().getOptions());
		assertEquals(revealLineBreaks(convertLineBreaks(expected)), revealLineBreaks(res));
	}

	protected void assertPreserved(final String modelP) throws Exception {
		String model = convertLineBreaks(modelP);
		EObject m = getModel(model);
		String res = getSerializer().serialize(m, SaveOptions.newBuilder().getOptions());
		assertEquals(revealLineBreaks(model), revealLineBreaks(res));
	}

	// test formatting based on the NodeModel
	protected void assertFormattedNM(String expected, String model, int offset, int lengt) throws Exception {
		EObject m = getModel(model);
		ICompositeNode node = NodeModelUtils.getNode(m).getRootNode();
		// System.out.println(EmfFormatter.objToStr(node));
		IFormattedRegion r = getNodeModelFormatter().format(node, offset, lengt);
		String actual = model.substring(0, r.getOffset()) + r.getFormattedText()
				+ model.substring(r.getLength() + r.getOffset());
		assertEquals(expected, actual);
	}

	protected String convertLineBreaks(String model) {
		return model.replace("\n", getLineSeparator());
	}
	
	protected String revealLineBreaks(String model) {
		return model.replace("\n", "\\n\n").replace("\r", "\\r");
	}
	
	protected String getLineSeparator() {
		return "\n";
	}

	protected void serializeToTokenBuffer(String model, ITokenStream out) throws Exception {
		EObject semanticObject = get(ParseHelper.class).parse(model);
		ISerializationDiagnostic.Acceptor errors = ISerializationDiagnostic.EXCEPTION_THROWING_ACCEPTOR;
		ISemanticSequencer semantic = get(ISemanticSequencer.class);
		ISyntacticSequencer syntactic = get(ISyntacticSequencer.class);
		IHiddenTokenSequencer hidden = get(IHiddenTokenSequencer.class);
		TokenStreamSequenceAdapter tokenstream = new TokenStreamSequenceAdapter(out, getGrammarAccess().getGrammar(), errors);
		semantic.init((ISemanticSequenceAcceptor) syntactic, errors);
		ISerializationContext context = new SerializationContext.RuleContext(null, (ParserRule) get(IGrammarAccess.class).getGrammar().getRules().get(0));
		syntactic.init(context, semanticObject, (ISyntacticSequenceAcceptor) hidden, errors);
		hidden.init(context, semanticObject, tokenstream, errors);
		tokenstream.init(context);
		semantic.createSequence(context, semanticObject);
	}

	protected void assertEqualTokenStreams(String modelString) throws Exception {
		// disabled for now since the new serializer appends/prepends whitespace 
		// to serialized regions and the old one doesn't.
		//		EObject model = getModel(modelString);
		//		//		IParseTreeConstructor ptc = get(IParseTreeConstructor.class);
		//		INodeModelStreamer nms = get(INodeModelStreamer.class);
		//		TokenBuffer ptcTb = new TokenBuffer();
		//		TokenBuffer nmsTb = new TokenBuffer();
		//		//		ptc.serializeSubtree(model, ptcTb);
		//		serializeToTokenBuffer(modelString, ptcTb);
		//		nms.feedTokenStream(nmsTb, NodeModelUtils.getNode(model).getRootNode(), 0, modelString.length());
		//		assertEquals(ptcTb.toString(), nmsTb.toString());
	}

	@Test public void testLinewrap() throws Exception {
		final String model = "test linewrap float val; int x; double y;";
		final String expected = "test linewrap\nfloat val;\nint x;\ndouble y;";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
		assertEqualTokenStreams(model);
		assertPreserved(model);
	}

	@Test public void testKeepComments() throws Exception {
		// final String model = "test linewrap float val; int x; double y;";
		final String model = "// begincomment \ntest linewrap// comment1\n" + "float val;//comment2\n" + "int x;"
				+ "double y; //yoyoyo!\n// endcomment.";
		final String exp = "// begincomment \ntest linewrap // comment1\n" + "float val; //comment2\n" + "int x;\n"
				+ "double y; //yoyoyo!\n// endcomment.";
		assertFormattedPTC(exp, model);
		assertFormattedNM(exp, model, 0, model.length());
		assertEqualTokenStreams(model);
		assertPreserved(model);
	}

	@Test public void testIndentation() throws Exception {
		final String model = "test indentation { float val; double y; indentation { int x; } }";
		final String expected = "test indentation {\n	float val;\n	double y;\n	indentation {\n		int x;\n	}\n}";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
		assertEqualTokenStreams(model);
		assertPreserved(model);
	}

	@Test public void testAssociation() throws Exception {
		final String model = "test indentation { var = [0,1,2,3,4]; }";
		final String expected = "test indentation {\n	var=[ 0, 1, 2, 3, 4 ];\n}";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
		assertEqualTokenStreams(model);
		assertPreserved(model);
	}

	@Test public void testIndentationAndComments() throws Exception {
		final String model = "test /* xxx */ indentation { float val; // some float\n double /* oo */ y; indentation { // some block\n int x; // xxx\n } } // final comment";
		final String expected = "test /* xxx */ indentation {\n	float val; // some float\n	double /* oo */ y;\n	indentation { // some block\n		int x; // xxx\n	}\n} // final comment";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
		assertEqualTokenStreams(model);
		assertPreserved(model);
	}

	@Test public void testIndentationAndLineWrap() throws Exception {
		final String model = "test indentation { void func(x:int,y:int,s:javalangString, foo:javasqlDate, blupp:mylongtype,  msads:adshdjkhsakdasdkslajdlsask, x:x, a:b, c:d ); }";
		final String expected = "test indentation {\n	void func(x:int, y:int,\n\t		s:javalangString,\n\t		foo:javasqlDate,\n\t		blupp:mylongtype,\n\t		msads:adshdjkhsakdasdkslajdlsask,\n\t		x:x, a:b, c:d);\n}";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
		assertEqualTokenStreams(model);
		assertPreserved(model);
	}

	@Test public void testBetween1() throws Exception {
		final String model = "test indentation { indentation { x x; }; }";
		final String expected = "test indentation {\n	indentation {\n		x x;\n	};\n}";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
		assertEqualTokenStreams(model);
		assertPreserved(model);
	}

	@Test public void testBetween2() throws Exception {
		final String model = "test indentation { indentation { x x; } }";
		final String expected = "test indentation {\n	indentation {\n		x x;\n	}\n}";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
		assertEqualTokenStreams(model);
		assertPreserved(model);
	}

	@Test public void testLinewrapDatatypeRule() throws Exception {
		final String model = "test linewrap fqn ab; fqn xx.yy.zz;";
		final String expected = "test linewrap\nfqn\nab;\nfqn\nxx.yy.zz;";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
		assertEqualTokenStreams(model);
		assertPreserved(model);
	}

	@Test public void testLinewrapDatatypeRulePartial1() throws Exception {
		final String model = "test linewrap fqn ab . xx .yy   .zz;";
		final String expected = "test linewrap fqn ab.xx.yy.zz;";
		assertFormattedNM(expected, model, 22, 2);
	}

	@Test public void testLinewrapDatatypeRulePartial2() throws Exception {
		final String model = "test linewrap fqn ab . xx .yy   .zz;fqn xxx;";
		final String expected = "test linewrap fqn\nab.xx.yy.zz;fqn xxx;";
		assertFormattedNM(expected, model, 15, 10);
	}

	@Test public void testLinewrapDatatypeRulePartial3() throws Exception {
		final String model = "test linewrap fqn ab . xx .yy   .zz;fqn xxx;";
		final String expected = "test linewrap fqn ab.xx.yy.zz;\nfqn xxx;";
		assertFormattedNM(expected, model, 25, 12);
	}

	@Test public void testFormatSegment1() throws Exception {
		final String model = "test\nindentation {\n    indentation  {  x  x  ;  }  }";
		final String expected = "test\nindentation {\n    indentation {\n    	x x;\n    }  }";
		assertFormattedNM(expected, model, 30, 18);
	}

	@Test public void testFormatSegment2() throws Exception {
		final String model = "test       indentation {\n    indentation  {  x  x  ;  }  }";
		//		final String expected = "test\nindentation {\n    indentation {\n    	x x;\n    }  }";
		assertFormattedNM(model, model, 7, 10);
	}

	@Test public void testFormatSegment3() throws Exception {
		final String model = "     test       indentation {\n    indentation  {  x  x  ;  }  }";
		final String expected = "test indentation {\n	indentation {\n		x x;\n	}\n}";
		assertFormattedNM(expected, model, 0, model.length());
	}

	@Test public void testLinewrapDatatypeRuleRef1() throws Exception {
		final String model = "test linewrap fqn ab  .cd .ef; fqnref ab. cd. ef;";
		final String expected = "test linewrap\nfqn\nab.cd.ef;\nfqnref\nab.cd.ef;";
		//		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
		assertEqualTokenStreams(model);
	}

	@Test public void testLinewrapDatatypeRuleRef2() throws Exception {
		final String model = "test linewrap fqn ab.cd.ef; fqnref ab.cd.ef;";
		final String expected = "test linewrap\nfqn\nab.cd.ef;\nfqnref\nab.cd.ef;";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
		assertEqualTokenStreams(model);
		assertPreserved(model);
	}

	@Test public void testLinewrapDatatypeRuleComments() throws Exception {
		final String model = "test linewrap/* 1 */fqn/* 2 */ab.cd.ef/* 3 */;/* 4 */fqnref/* 5 */ab.cd.ef/* 6 */;/* 7 */";
		final String expected = "test linewrap /* 1 */ fqn\n\t/* 2 */\nab.cd.ef /* 3 */; /* 4 */\n\tfqnref /* 5 */ ab.cd.ef\n\t/* 6 */; /* 7 */";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
		assertEqualTokenStreams(model);
		assertPreserved(model);
	}

	@Test public void testEnumeration() throws Exception {
		final String model = "test linewrap enum lit1,lit2,lit3,lit1;";
		final String expected = "test linewrap\nenum lit1 ,\nlit2,\nlit3,\nlit1;";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
		assertEqualTokenStreams(model);
		assertPreserved(model);
	}

	// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=312559
	@Test public void testSuppressedWhitespace() throws Exception {
		final String model = "test linewrap `f%<b>%a` post;";
		final String expected = "test linewrap\n`f%< b >%a` post;";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
		assertEqualTokenStreams(model);
		assertPreserved(model);
	}

	@Test public void testSuppressedLinewrap() throws Exception {
		final String model = "test linewrap\n`foo%abcd%foo%< b\n\t>%abcd%foo%abcd%foo%abcd%"
				+ "foo%abcd%foo%abcd%foo%abcd%foo%abcd%foo%abcd%foo%xx%foo%abcd%foo%abcd%"
				+ "foo%abcd%foo%<\n\tb >%foo%abcd` post;";
		assertFormattedPTC(model, model);
		assertFormattedNM(model, model, 0, model.length());
		assertEqualTokenStreams(model);
		assertPreserved(model);
	}

	@Test public void testLinewrapMin() throws Exception {
		final String model = "test wrapminmax foo bar;";
		final String expected = "test wrapminmax\n\nfoo bar;";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
		assertEqualTokenStreams(model);
		assertPreserved(model);
	}

	@Test public void testLinewrapMax() throws Exception {
		final String model = "test wrapminmax\n\n\n\n\n\n\n\n\n\n\n\n\nfoo bar;";
		final String expected = "test wrapminmax\n\n\n\n\nfoo bar;";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
		assertEqualTokenStreams(model);
		assertPreserved(model);
	}

	@Test public void testLinewrapKeep() throws Exception {
		final String model = "test wrapminmax\n\n\n\nfoo bar;";
		assertFormattedPTC(model, model);
		assertFormattedNM(model, model, 0, model.length());
		assertEqualTokenStreams(model);
		assertPreserved(model);
	}

	@Test
	public void testLinewrapDefault() throws Exception {
		FormattertestlanguageFactory f = FormattertestlanguageFactory.eINSTANCE;
		TestLinewrapMinMax m = f.createTestLinewrapMinMax();
		Decl d = f.createDecl();
		d.getType().add("xxx");
		d.getName().add("yyy");
		m.getItems().add(d);
		String actual = getSerializer().serialize(m, SaveOptions.newBuilder().format().getOptions());
		final String expected = convertLineBreaks("test wrapminmax\n\n\nxxx yyy;");
		assertEquals(expected, actual);
	}

	@Test public void testSpace() throws Exception {
		final String model = "test linewrap space foo;";
		final String expected = "test linewrap\nspace     foo;";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
		assertEqualTokenStreams(model);
		assertPreserved(model);
	}

	@Test public void testDatatypeRules() throws Exception {
		final String model = "test linewrap datatypes abc kw1 bcd def kw3;";
		final String expected = "test linewrap\ndatatypes abc\nkw1\nbcd\ndef\nkw3;";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
		assertEqualTokenStreams(model);
		assertPreserved(model);
	}

	@Test public void testWrappingdatatype1() throws Exception {
		final String model = "test wrappingdt foo kw1";
		final String expected = "test wrappingdt foo kw1";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
		assertEqualTokenStreams(model);
		assertPreserved(model);
	}

	@Test public void testWrappingdatatype2() throws Exception {
		final String model = "test wrappingdt foo bar kw1";
		final String expected = "test wrappingdt foo bar kw1";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
		assertEqualTokenStreams(model);
		assertPreserved(model);
	}

	@Test public void testWrappingdatatype3() throws Exception {
		final String model = "test wrappingdt f\nb kw1";
		final String expected = "test wrappingdt f\nb kw1";
		assertFormattedPTC(expected, model);
		assertFormattedNM(expected, model, 0, model.length());
		assertEqualTokenStreams(model);
		assertPreserved(model);
	}

	private static class AccessibleFormatter extends DefaultNodeModelFormatter {
		void setNodeModelStreamer(INodeModelStreamer streamer) {
			nodeModelStreamer = streamer;
		}
	}
	
	private static class BrokenStreamer extends NodeModelStreamer {
		@Override
		protected String getFormattedDatatypeValue(ICompositeNode node, AbstractRule rule, String text)
				throws ValueConverterException {
			throw new ValueConverterException("", null, null);
		}
	}
	
	@Test public void testBug471212() throws Exception {
		String model = "test wrappingdt f\nb kw1";
		ICompositeNode node = NodeModelUtils.getNode(getModel(model)).getRootNode();
		AccessibleFormatter formatter = get(AccessibleFormatter.class);
		formatter.setNodeModelStreamer(get(BrokenStreamer.class));
		IFormattedRegion region = formatter.format(node, 0, model.length());
		String actual = region.getFormattedText();
		assertEquals(model, actual);
		assertEqualTokenStreams(model);
		assertPreserved(model);
	}

}
