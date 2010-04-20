package org.eclipse.xtext.parsetree.reconstr;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;

public class XtextGrammarReconcilationTest extends AbstractXtextTests {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		XtextStandaloneSetup.doSetup();
		with(XtextStandaloneSetup.class);
	}

	public void testSimple() throws Exception {
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
		Map<String,Object> opt = new HashMap<String,Object>();
		opt.put(XtextResource.OPTION_FORMAT, Boolean.TRUE);
		resource.save(out, opt);
		String result = new String(out.toByteArray());

		// check
		assertFalse(model.equals(result));
		String expectedModel = "grammar foo with org.eclipse.xtext.common.Terminals\n\nHONOLULU:\n  name=ID;";
		assertEquals(expectedModel, result);
	}

	public void testSelf() {
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
