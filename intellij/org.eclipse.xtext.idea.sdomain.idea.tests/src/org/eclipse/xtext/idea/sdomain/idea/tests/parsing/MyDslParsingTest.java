package org.eclipse.xtext.idea.sdomain.idea.tests.parsing;

import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainFileType;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;

public class MyDslParsingTest extends AbstractLanguageParsingTestCase {
	
	public MyDslParsingTest() {
		super(SDomainFileType.INSTANCE);
	}
	
	@Override
	protected String getTestDataPath() {
		return "./testData/parsing";
	}
	
	public void testNamespaces() {
		doTest(true);
	}
	
	public void testEntities() {
		doTest(true);
	}
	
	public void testDatatypes() {
		doTest(true);
	}
	
	public void testQualifiedNamespace() {
		doTest(true);
	}
	
	public void testQualifiedNamespace2() {
		doTest(true);
	}
	
	public void testCrossReferences() {
		doTest(true);
	}
	
	public void testSyntaxErrors() {
		doTest(true);
	}
	
	public void testSyntaxErrors2() {
		doTest(true);
	}
	
	public void testMissingTokenErrorRecovery() {
		doTest(true);
	}
	
	public void testUnwantedTokenErrorRecovery() {
		doTest(true);
	}
	
	public void testUnwantedTokenErrorRecovery2() {
		doTest(true);
	}
	
}
