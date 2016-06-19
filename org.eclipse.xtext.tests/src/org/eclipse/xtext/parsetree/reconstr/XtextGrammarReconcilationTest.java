package org.eclipse.xtext.parsetree.reconstr;

import java.io.ByteArrayOutputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.tests.LineDelimiters;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Test;

public class XtextGrammarReconcilationTest extends AbstractXtextTests {
	@Override
	public void setUp() throws Exception {
		super.setUp();
		XtextStandaloneSetup.doSetup();
		with(XtextStandaloneSetup.class);
	}

	@Test public void testSimple() throws Exception {
		// this fails see bug #252181
		String model = "grammar foo with org.eclipse.xtext.common.Terminals Honolulu : name=ID;";

		// load grammar model
		XtextResourceSet rs = get(XtextResourceSet.class);
		Resource resource = rs.createResource(URI.createURI("foo.xtext"), ContentHandler.UNSPECIFIED_CONTENT_TYPE);
		resource.load(new StringInputStream(model), null);
		Grammar object = (Grammar) resource.getContents().get(0);

		// modify first rule
		object.getRules().get(0).setName("HONOLULU");

		// save
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		resource.save(out, SaveOptions.newBuilder().format().getOptions().toOptionsMap());
		String result = new String(out.toByteArray());

		// check
		assertFalse(model.equals(result));
		String expectedModel = LineDelimiters.toPlatform("grammar foo with org.eclipse.xtext.common.Terminals\n\nHONOLULU:\n	name=ID;");
		assertEquals(expectedModel, result);
	}

	@Test public void testSelf() {
		Grammar g = getGrammarAccess().getGrammar();
		for (AbstractRule r : g.getRules()) {
			// AbstractRule r = GrammarUtil.findRuleForName(g, "GrammarID");
			// System.out.println("serializing :" + r.getName());
			String s = serialize(r);
			assertNotNull(s, r.getName());
			// System.out.println(s);
		}
	}
}
