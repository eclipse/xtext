package org.eclipse.xtext.idea.sdomain.idea.tests.parsing;

import org.eclipse.xtext.idea.lang.BaseXtextASTFactory;
import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainLanguage;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;

import com.intellij.lang.LanguageASTFactory;
import com.intellij.lang.ParserDefinition;

public class MyDslParsingTest extends AbstractLanguageParsingTestCase {
	
	public MyDslParsingTest() {
		super("", "sdomain", SDomainLanguage.INSTANCE.getInstance(ParserDefinition.class));
		SDomainLanguage.INSTANCE.injectMembers(this);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		addExplicitExtension(LanguageASTFactory.INSTANCE, SDomainLanguage.INSTANCE, SDomainLanguage.INSTANCE.getInstance(BaseXtextASTFactory.class));
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
	
	@Override
	protected String getTestDataPath() {
		return "./testData/parsing";
	}
	
}
