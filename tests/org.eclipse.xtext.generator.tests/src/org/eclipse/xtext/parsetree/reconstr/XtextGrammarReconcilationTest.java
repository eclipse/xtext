package org.eclipse.xtext.parsetree.reconstr;

import java.io.ByteArrayOutputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.tests.AbstractGeneratorTest;
import org.eclipse.xtext.util.StringInputStream;

public class XtextGrammarReconcilationTest extends AbstractGeneratorTest {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		XtextStandaloneSetup.doSetup();
		with(XtextStandaloneSetup.class);
	}
	
	public void testSimple() throws Exception {
		// this fails see bug #252181
//		String model = "language foo Honolulu : name=ID;";
//
//		// load grammar model
//		XtextResourceSet rs = new XtextResourceSet();
//		Resource resource = rs.createResource(URI.createURI("foo.xtext"));
//		resource.load(new StringInputStream(model),null);
//		Grammar object = (Grammar) resource.getContents().get(0);
//		
//		// modify first rule
//		object.getRules().get(0).setName("HONOLULU");
//		
//		// save
//		ByteArrayOutputStream out = new ByteArrayOutputStream();
//		resource.save(out, null);
//		String result = new String(out.toByteArray());
//		
//		// check
//		assertFalse(model.equals(result));
//		assertEquals(model.toLowerCase(),result.toLowerCase());
	}
}
