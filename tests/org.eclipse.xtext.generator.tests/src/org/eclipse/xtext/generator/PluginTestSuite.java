package org.eclipse.xtext.generator;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Runs all tests in this plug-in. Delegates to eclipse auto-generated test
 * suites (New->TestSuite) in the contained packages.
 * 
 * @author Jan Koehnlein
 */
public class PluginTestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite("org.eclipse.xtext.generator.tests");
		suite.addTestSuite(org.eclipse.xtext.XtextGrammarTest.class);
		suite.addTestSuite(org.eclipse.xtext.EcoreUtil2Tests.class);
		suite.addTestSuite(org.eclipse.xtext.generator.resource.ResourceTest.class);
		suite.addTestSuite(org.eclipse.xtext.grammarinheritance.InheritanceTest.class);
		suite.addTestSuite(org.eclipse.xtext.grammarinheritance.ToEcoreTrafoTest.class);
		suite.addTestSuite(org.eclipse.xtext.lexer.LexerErrorTest.class);
		suite.addTestSuite(org.eclipse.xtext.lexer.LexerSLComment.class);
		suite.addTestSuite(org.eclipse.xtext.metamodelreferencing.tests.MetamodelRefTest.class);
		suite.addTestSuite(org.eclipse.xtext.metamodelreferencing.tests.MultiGenMMTest.class);
		suite.addTestSuite(org.eclipse.xtext.parseerrorhandling.ParseErrorHandlingTest.class);
		suite.addTestSuite(org.eclipse.xtext.parser.PartialParserReplaceTest.class);
		suite.addTestSuite(org.eclipse.xtext.parser.PartialParserTest.class);
		suite.addTestSuite(org.eclipse.xtext.parser.PartialParsingPerformanceTest.class);
		suite.addTestSuite(org.eclipse.xtext.parser.PartialParsingPointerTest.class);
		suite.addTestSuite(org.eclipse.xtext.parser.XtextParserTest.class);
		suite.addTestSuite(org.eclipse.xtext.parsetree.ASTChangeTest.class);
		suite.addTestSuite(org.eclipse.xtext.parsetree.CommentTest.class);
		suite.addTestSuite(org.eclipse.xtext.parsetree.EmptyModelTest.class);
		suite.addTestSuite(org.eclipse.xtext.parsetree.HiddenTokensTest.class);
		suite.addTestSuite(org.eclipse.xtext.parsetree.InvalidTokenTest.class);
		suite.addTestSuite(org.eclipse.xtext.parsetree.LengthOffsetLineTest.class);
		suite.addTestSuite(org.eclipse.xtext.parsetree.NodeContentAdapterTest.class);
		suite.addTestSuite(org.eclipse.xtext.parsetree.NodeModelTest.class);
		suite.addTestSuite(org.eclipse.xtext.parsetree.SerializeTest.class);
		suite.addTestSuite(org.eclipse.xtext.parsetree.reconstr.ComplexReconstrTest.class);
		suite.addTestSuite(org.eclipse.xtext.parsetree.reconstr.SimpleReconstrTest.class);
		suite.addTestSuite(org.eclipse.xtext.parsetree.reconstr.WhitespacePreservingCallbackTest.class);
		suite.addTestSuite(org.eclipse.xtext.parsetree.ParseTreeUtilTest.class);
		suite.addTestSuite(org.eclipse.xtext.reference.CommentOnEofBug_234135_Test.class);
		suite.addTestSuite(org.eclipse.xtext.reference.LeafNodeBug_234132_Test.class);
		suite.addTestSuite(org.eclipse.xtext.resource.metamodel.Xtext2EcoreTransformerTest.class);
		suite.addTestSuite(org.eclipse.xtext.resource.metamodel.TypeHierarchyHelperTests.class);
		suite.addTestSuite(org.eclipse.xtext.crossrefs.CrossRefTest.class);
		suite.addTestSuite(org.eclipse.xtext.crossrefs.LinkingErrorTest.class);
		suite.addTestSuite(org.eclipse.xtext.parser.XtextParserBugsTest.class);
		suite.addTestSuite(org.eclipse.xtext.parsetree.transientvalues.TransientValuesTest.class );
		suite.addTestSuite(org.eclipse.xtext.parsetree.formatter.FormatterTest.class );
		return suite;
	}
}
