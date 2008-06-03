package org.eclipse.xtext.typeresolution;

import java.util.List;

import org.eclipse.m2t.type.emf.EmfRegistryMetaModel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.tests.AbstractGeneratorTest;
import org.eclipse.xtext.xtextutil.MetaModel;
import org.eclipse.xtext.xtextutil.XtextutilPackage;
import org.openarchitectureware.expression.ExecutionContextImpl;
import org.openarchitectureware.xtend.XtendFacade;

public class XtextUtilConstructionTest extends AbstractGeneratorTest {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		XtextStandaloneSetup.doSetup();
		XtextutilPackage.eINSTANCE.getComplexType();
		with(XtextStandaloneSetup.class);
	}

	@SuppressWarnings("unchecked")
	public void testConstruction() throws Exception {
		StringBuffer b = new StringBuffer();
		b.append("generate SimpleTest2 'http://eclipse.org/xtext/tests/SimpleTest2'");
		b.append("Model : (contents+=Child)*;");
		b.append("Child : (optional?='optional')? 'keyword' name=ID number=INT '{' '}';");

		Grammar grammarModel = (Grammar) getModel(b.toString());

		ExecutionContextImpl executionContext = new ExecutionContextImpl();
		executionContext.registerMetaModel(new EmfRegistryMetaModel());
		XtendFacade facade = XtendFacade.create(executionContext, "org::eclipse::xtext::XtextUtil");
		List<MetaModel> result = (List<MetaModel>) facade.call("getAllMetaModels", grammarModel);
		assertEquals(2, result.size());
		MetaModel generated = (MetaModel) invokeWithXtend("select(e|e.declaration.alias==null).first()", result);
		assertNotNull(generated);
		assertEquals(2, generated.getTypes().size());
	}

	@SuppressWarnings("unchecked")
	public void testConstruction2() throws Exception {
		StringBuffer b = new StringBuffer();
		b.append("generate TestLang 'http://www.eclipse.org/2008/xtext/TestLang'");
		b.append("EntryRule returns Model : (multiFeature+=AbstractRule)*;");
		b.append("AbstractRule returns AbstractElement : ChoiceRule | ReducibleRule;");
		b.append("ChoiceRule returns ChoiceElement : 'choice' (optionalKeyword?='optional')? name=ID;");
		b.append("ReducibleRule returns ReducibleElement : 'reducible' " +
				"TerminalRule ( {ReducibleComposite.actionFeature+=current} actionFeature+=TerminalRule )?;");
		b.append("TerminalRule returns TerminalElement : stringFeature=STRING;");

		Grammar grammarModel = (Grammar) getModel(b.toString());

		ExecutionContextImpl executionContext = new ExecutionContextImpl();
		executionContext.registerMetaModel(new EmfRegistryMetaModel());
		XtendFacade facade = XtendFacade.create(executionContext, "org::eclipse::xtext::XtextUtil");
		List<MetaModel> result = (List<MetaModel>) facade.call("getAllMetaModels", grammarModel);
		assertEquals(2, result.size());
		MetaModel generated = (MetaModel) invokeWithXtend("select(e|e.declaration.alias==null).first()", result);
		assertNotNull(generated);
		assertEquals(6, generated.getTypes().size());
		assertWithXtend("'ReducibleElement'","types.select(e|e.name == 'ReducibleComposite').first().superTypes.first().name",generated);
	}
}
