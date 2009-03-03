package org.eclipse.xtext.crossrefs;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.crossref.ILinkingService;
import org.eclipse.xtext.crossref.impl.DefaultLinkingService;
import org.eclipse.xtext.crossrefs.services.LangATestLanguageGrammarAccess;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

public class CrossRefTest extends AbstractGeneratorTest {
	private static final Logger logger = Logger.getLogger(CrossRefTest.class);
	private DefaultLinkingService linkingService;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(LangATestLanguageStandaloneSetup.class);
		linkingService = (DefaultLinkingService) get(ILinkingService.class);
	}

	public void testSimple() throws Exception {
		EObject model = getModel("type A extends B type B extends A");
		logger.debug(invokeWithXtend("types.collect(e|e.name+' '+e.extends.name).toString(',')", model));
		assertWithXtend("'B'", "types.first().extends.name", model);
		assertWithXtend("types.first()", "types.first().extends.extends", model);
	}

	public void testGetLinkedObjects() throws Exception {
		XtextResource r = getResourceFromString("type TypeA extends TypeB type TypeB extends TypeA type AnotherType extends TypeA");
		EObject model = r.getParseResult().getRootASTElement();
		LeafNode leaf = (LeafNode) NodeUtil.findLeafNodeAtOffset(r.getParseResult().getRootNode(), 6);

		assertWithXtend("3", "types.size", model);

		EObject context = (EObject) invokeWithXtend("types.first()", model);
		ParserRule prType =  get(LangATestLanguageGrammarAccess.class).prType().getRule();
		Assignment asExtends = (Assignment) ((Group) prType.getAlternatives()).getTokens().get(3);
		CrossReference xref = (CrossReference) asExtends.getTerminal();
		EReference ref = GrammarUtil.getReference(xref, context.eClass());

		assertEquals(1, linkingService.getLinkedObjects(context, ref, leaf).size());
	}

}
