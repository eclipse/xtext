package org.eclipse.xtext.parser;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

public class XtextParserTest extends AbstractGeneratorTest {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}
	
	public void test_resolveReturnType() throws Exception {
		Grammar model = (Grammar) getModel("language foo generate foo 'bar' as x Model returns x::Foo : 'holla' name=ID;");
		assertWithXtend("'x'", "metamodelDeclarations.first().alias", model);
	}
	
	public void testParseCrossRef() throws Exception {
		Grammar model = (Grammar) getModel("language foo generate foo 'bar' Model : 'a' stuff+=Stuff*; Stuff : 'stuff' name=ID refersTo=[Stuff];");
		assertWithXtend("'Stuff'", "eAllContents.typeSelect(xtext::CrossReference).first().type.name", model);
	}
}
