package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.junit.AbstractXtextTests;

public class HiddenTokensMergerTest extends AbstractXtextTests {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(HiddenTokensMergerTestLanguageStandaloneSetup.class);
	}

	private void assertRoundtrip(String model) throws Exception {
		EObject o = getModel(model);
		 //System.out.println(EmfFormatter.objToStr(((XtextResource) o.eResource()).getParseResult().getRootNode()));
		String r = getSerializer().serialize(o, false);
		assertEquals(model, r);
	}

	public void testDatatypeBug286557a() throws Exception {
		assertRoundtrip("#1 a;");
	}

	public void testDatatypeBug286557b() throws Exception {
		assertRoundtrip("#1 a ref a;");
	}

	public void testDatatypeBug286557c() throws Exception {
		assertRoundtrip("#1 a.b.c;");
	}

	public void testDatatypeBug286557d() throws Exception {
		assertRoundtrip("#1 a.b.c ref a.b.c;");
	}
	
	public void testEnumBug() throws Exception {
		assertRoundtrip("#2  kw1   array     test");
	}

}
