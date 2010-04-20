package org.eclipse.xtext.parser;

import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.ParsetreePackage;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageStandaloneSetup;
import org.eclipse.xtext.tests.EmfAssert;
import org.eclipse.xtext.util.StringInputStream;

public class OffsetInformationTest extends AbstractXtextTests {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(ReferenceGrammarTestLanguageStandaloneSetup.class);
	}
	
	public void testCheckParsing() throws Exception {
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
		CompositeNode rootNode = resource.getParseResult().getRootNode();
		
		for (int i=0;i<string.length()/2;i++) {
			String substring = string.substring(i, string.length()-i);
			resource.update(i, substring.length(), substring);
			CompositeNode model = resource.getParseResult().getRootNode();
			NodeUtil.checkOffsetConsistency(model);
			EmfAssert.assertEObjectsEqual(rootNode, model,ParsetreePackage.eINSTANCE.getAbstractNode_Element());
		}
		
	}
}
