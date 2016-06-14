package org.eclipse.xtext.parser;

import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.impl.InvariantChecker;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageStandaloneSetup;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Test;

public class OffsetInformationTest extends AbstractPartialParserTest {
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(ReferenceGrammarTestLanguageStandaloneSetup.class);
	}
	
	@Test public void testCheckParsing() throws Exception {
		String string = "spielplatz 34 'holla' {\n"
			+ "  kind (Horst 3)\n"
			+ "  erwachsener (Julia 45)\n"
			+ "  erwachsener (Herrmann 50)\n" 
			+ "  erwachsener (Herrmann 50)\n" 
			+ "  erwachsener (Herrmann 50)\n" 
			+ "  erwachsener (Herrmann 50)\n" 
			+ "  erwachsener (Herrmann 50)\n" 
			+ "}";
		XtextResource resource = getResource(new StringInputStream(string));
		ICompositeNode rootNode = resource.getParseResult().getRootNode();
		
		for (int i=0;i<string.length()/2;i++) {
			String substring = string.substring(i, string.length()-i);
			resource.update(i, substring.length(), substring);
			ICompositeNode model = resource.getParseResult().getRootNode();
			new InvariantChecker().checkInvariant(model);
			assertSameStructure(rootNode, model);
		}
		
	}
}
