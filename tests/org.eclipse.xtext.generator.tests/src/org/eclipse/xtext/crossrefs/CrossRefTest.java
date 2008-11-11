package org.eclipse.xtext.crossrefs;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.crossref.ILinkingService;
import org.eclipse.xtext.crossrefs.services.LangAGrammarAccess;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.tests.AbstractGeneratorTest;
import org.eclipse.xtext.util.Pair;

public class CrossRefTest extends AbstractGeneratorTest {
	private static final Logger logger = Logger.getLogger(CrossRefTest.class);
	private ILinkingService linkingService;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(LangAStandaloneSetup.class);
		linkingService = ServiceRegistry.getService(ILangA.SCOPE, ILinkingService.class);
	}
	
	public void testSimple() throws Exception {
		EObject model = getModel("type A extends B type B extends A");
		logger.debug(invokeWithXtend("types.collect(e|e.name+' '+e.extends.name).toString(',')", model));
		assertWithXtend("'B'", "types.first().extends.name", model);
		assertWithXtend("types.first()", "types.first().extends.extends", model);
	}
	
	public void testGetLinkText() throws Exception {
		EObject model = getModel("type A extends B type B extends A");
		EObject typeA = model.eResource().getEObject("A"); 
		EObject typeB = model.eResource().getEObject("B"); 
		URI uriA = EcoreUtil.getURI(typeA);
		URI uriB = EcoreUtil.getURI(typeB);
		assertEquals("A", linkingService.getLinkAsText(typeA, uriA));
		assertEquals("B", linkingService.getLinkAsText(typeA, uriB));
		assertEquals("A", linkingService.getLinkAsText(typeB, uriA));
		assertEquals("B", linkingService.getLinkAsText(typeB, uriB));
	}
	
	public void testGetLinkCandidates01() throws Exception {
		EObject model = getModel("type TypeA extends TypeB type TypeB extends TypeA type AnotherType extends TypeA");
		
		assertWithXtend("3", "types.size", model);
		
		EObject context = (EObject) invokeWithXtend("types.first()", model);
		ParserRule prType = new LangAGrammarAccess().pr_Type();
		Assignment asExtends = (Assignment)((Group)prType.getAlternatives()).getAbstractTokens().get(1);
		CrossReference xref = (CrossReference) asExtends.getTerminal();
		
		assertEquals(3, linkingService.getLinkCandidates(context, xref, "").size());
		assertEquals(2, linkingService.getLinkCandidates(context, xref, "Type").size());
		assertEquals(1, linkingService.getLinkCandidates(context, xref, "TypeA").size());
		assertEquals(0, linkingService.getLinkCandidates(context, xref, "TypeC").size());
	}
	
	public void testGetLinkCandidates02() throws Exception {
		EObject model = getModel("type TypeA extends TypeB type TypeB extends TypeA type AnotherType extends TypeA");
		
		EObject context = (EObject) invokeWithXtend("types.first()", model);
		ParserRule prType = new LangAGrammarAccess().pr_Type();
		Assignment asExtends = (Assignment)((Group)prType.getAlternatives()).getAbstractTokens().get(1);
		CrossReference xref = (CrossReference) asExtends.getTerminal();
		
		List<Pair<String, URI>> candidates = linkingService.getLinkCandidates(context, xref, "TypeA");
		assertEquals(1, candidates.size());
		Pair<String, URI> candidate = candidates.get(0);
		assertEquals("TypeA", candidate.getFirstElement());
		assertEquals(model.eResource().getURI().appendFragment("TypeA"), candidate.getSecondElement());
	}
}
