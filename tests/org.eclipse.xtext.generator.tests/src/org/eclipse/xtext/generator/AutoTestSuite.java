package org.eclipse.xtext.generator;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * DO NOT MODIFY MANUALLY! This class has been automatically generated. 
 * Install org.eclipse.xtext.testcollector and use the Xtext Tools/Create Test Suite
 * action on the source folder to regenerate this.
 */
public class AutoTestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite("org.eclipse.xtext.generator.tests");
		suite.addTestSuite(org.eclipse.xtext.XtextGrammarTest.class);
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
		suite.addTestSuite(org.eclipse.xtext.reference.CommentOnEofBug_234135_Test.class);
		suite.addTestSuite(org.eclipse.xtext.reference.LeafNodeBug_234132_Test.class);
		suite.addTestSuite(org.eclipse.xtext.typeresolution.XtextUtilConstructionTest.class);
		suite.addTestSuite(org.eclipse.xtext.xtext2ecore.ActionTest.class);
		suite.addTestSuite(org.eclipse.xtext.xtext2ecore.BootstrapModelTest.class);
		suite.addTestSuite(org.eclipse.xtext.xtext2ecore.MultiEPackagesTest.class);
		return suite;
	}
}
