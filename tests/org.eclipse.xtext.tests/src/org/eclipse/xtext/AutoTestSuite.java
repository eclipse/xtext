package org.eclipse.xtext;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * DO NOT MODIFY MANUALLY! This class has been automatically generated. 
 * Install org.eclipse.xtext.testcollector and use the Xtext Tools/Create Test Suite
 * action on the source folder to regenerate this.
 */
public class AutoTestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite("org.eclipse.xtext.tests");
		suite.addTestSuite(org.eclipse.xtext.crossref.PartialLinkingTest.class);
		suite.addTestSuite(org.eclipse.xtext.crossref.impl.SimpleAttributeResolverTest.class);
		suite.addTestSuite(org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleTokenTest.class);
		suite.addTestSuite(org.eclipse.xtext.parsetree.AbstractNodeTest.class);
		suite.addTestSuite(org.eclipse.xtext.parsetree.NodeContentAdapterTest.class);
		suite.addTestSuite(org.eclipse.xtext.resource.ClassloaderClasspathUriResolverTests.class);
		suite.addTestSuite(org.eclipse.xtext.util.ChainedIteratorTest.class);
		suite.addTestSuite(org.eclipse.xtext.util.FilteringIteratorTest.class);
		suite.addTestSuite(org.eclipse.xtext.util.MappingIteratorTest.class);
		suite.addTestSuite(org.eclipse.xtext.util.SimpleCacheTest.class);
		suite.addTestSuite(org.eclipse.xtext.util.TailWriterTest.class);
		suite.addTestSuite(org.eclipse.xtext.util.TuplesTest.class);
		suite.addTestSuite(org.eclipse.xtext.xtext.XtextGrammarSerializationTest.class);
		return suite;
	}
}
