package org.eclipse.xtext.parser;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testlanguages.indent.IndentationAwareTestLanguageStandaloneSetup;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Test;

public class PartialParsingEmptyTokensTest extends AbstractXtextTests {
	
	@Override
	protected boolean shouldTestSerializer(XtextResource resource) {
		return false;
	}

	private static final String DOC = 
		"1\n" + 
		"	1a\n" +
		"	1b\n" +
		"2";

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(IndentationAwareTestLanguageStandaloneSetup.class);
	}

	@Test public void testValidDocument() throws Exception {
		getResource(new StringInputStream(DOC));
	}

	@Test public void testMarkerEmptyTokens() throws Exception {
		int pos = DOC.indexOf("1b");
		String brokenDoc = DOC.replace("1b", "");
		XtextResource resource = getResourceAndExpect(new StringInputStream(brokenDoc), 1);
		resource.update(pos, 0, "1b");
		assertTrue("Expected 0 errors, got " + resource.getErrors(), resource.getErrors().isEmpty());
	}

	@Override
	protected void checkNodeModel(XtextResource resource) {
		// No NodeModel check here.
	}
}
