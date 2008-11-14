package org.eclipse.xtext.crossrefs;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.crossref.ILinkingService;
import org.eclipse.xtext.crossref.impl.XtextBuiltinLinkingService;
import org.eclipse.xtext.crossrefs.services.LangAGrammarAccess;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

public class CrossRefTest extends AbstractGeneratorTest {
	private static final Logger logger = Logger.getLogger(CrossRefTest.class);
	private XtextBuiltinLinkingService linkingService;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(LangAStandaloneSetup.class);
		linkingService = (XtextBuiltinLinkingService) ServiceRegistry.getService(ILangA.SCOPE, ILinkingService.class);
	}

	public void testSimple() throws Exception {
		EObject model = getModel("type A extends B type B extends A");
		logger.debug(invokeWithXtend("types.collect(e|e.name+' '+e.extends.name).toString(',')", model));
		assertWithXtend("'B'", "types.first().extends.name", model);
		assertWithXtend("types.first()", "types.first().extends.extends", model);
	}

	public void testGetLinkCandidates01() throws Exception {
		EObject model = getModel("type TypeA extends TypeB type TypeB extends TypeA type AnotherType extends TypeA");

		assertWithXtend("3", "types.size", model);

		EObject context = (EObject) invokeWithXtend("types.first()", model);
		ParserRule prType = new LangAGrammarAccess().pr_Type();
		Assignment asExtends = (Assignment) ((Group) prType.getAlternatives()).getAbstractTokens().get(1);
		CrossReference xref = (CrossReference) asExtends.getTerminal();

		assertEquals(3, linkingService.doGetLinkedObjects(context, xref, "", false).size());
		assertEquals(2, linkingService.doGetLinkedObjects(context, xref, "Type", false).size());
		assertEquals(1, linkingService.doGetLinkedObjects(context, xref, "TypeA", false).size());
		assertEquals(0, linkingService.doGetLinkedObjects(context, xref, "TypeC", false).size());
	}

	public void testGetLinkCandidates02() throws Exception {
		EObject model = getModel("type TypeA extends TypeB type TypeB extends TypeA type AnotherType extends TypeA");

		EObject context = (EObject) invokeWithXtend("types.first()", model);
		ParserRule prType = new LangAGrammarAccess().pr_Type();
		Assignment asExtends = (Assignment) ((Group) prType.getAlternatives()).getAbstractTokens().get(1);
		CrossReference xref = (CrossReference) asExtends.getTerminal();

		List<EObject> candidates = linkingService.getLinkCandidates(context, xref, "TypeA");
		assertEquals(1, candidates.size());
		EObject candidate = candidates.get(0);
		EStructuralFeature feature = candidate.eClass().getEStructuralFeature("name");
		assertNotNull(feature);
		Object name = candidate.eGet(feature);
		assertNotNull(name);
		assertEquals("TypeA", name);
	}
}
