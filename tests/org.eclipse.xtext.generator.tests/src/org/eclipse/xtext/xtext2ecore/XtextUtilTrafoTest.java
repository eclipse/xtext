package org.eclipse.xtext.xtext2ecore;

import java.util.List;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.tests.AbstractGeneratorTest;
import org.eclipse.xtext.xtextutil.MetaModel;
import org.eclipse.xtext.xtextutil.XtextutilPackage;

public class XtextUtilTrafoTest extends AbstractGeneratorTest {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		XtextutilPackage.eINSTANCE.getAbstractType(); // initialze and register
		with(XtextStandaloneSetup.class);
	}

	@SuppressWarnings("unchecked")
	public void testCrossRefs() throws Exception {
		Grammar model = (Grammar) getModel("language foo generate foo 'bar' Model : stuff+=Stuff*; Stuff : 'stuff' name=ID refersTo=[Stuff];");
		List<MetaModel> metamodels = (List<MetaModel>) invokeWithXtend("getAllMetaModels(this)", model);
		assertEquals(2, metamodels.size());
		assertWithXtend("'Stuff'",
				"eAllContents.flatten().typeSelect(xtextutil::ComplexType).select(e|e.name=='Stuff')"
						+ ".first().features.selectFirst(e|e.name=='refersTo').type.name", metamodels);
	}

	@Override
	protected String[] importedExtensions() {
		return new String[] { "org::eclipse::xtext::XtextUtil" };
	}

	public void testCurrentType() throws Exception {
		Grammar model = (Grammar) getModel("language org.eclipse.xtext.crossrefs.LangA" +
				" generate langA 'http://eclipse.org/xtext/langA' "
				+ "Main : 	^import+=Import* 	types+=Type*;"
				+ "Import :	'import' uri=STRING;"
				+ "Type :	'type' name=ID 'extends' ^extends=[Type];");
		RuleCall rc = (RuleCall) invokeWithXtend("parserRules.first().eAllContents.typeSelect(xtext::RuleCall).first()", model);
		assertNotNull(rc);
		assertWithXtend("'Main'", "testCurrentType().name", rc);
		assertWithXtend("false", "testCurrentType().abstract", rc);
	}
}
