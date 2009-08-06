package org.eclipse.xtext.linking;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.langATestLanguage.LangATestLanguagePackage;
import org.eclipse.xtext.linking.langATestLanguage.Main;
import org.eclipse.xtext.linking.langATestLanguage.Type;
import org.eclipse.xtext.linking.lazy.LazyLinkingTestLanguageStandaloneSetup;
import org.eclipse.xtext.linking.lazy.lazyLinking.LazyLinkingPackage;
import org.eclipse.xtext.linking.lazy.lazyLinking.Model;
import org.eclipse.xtext.linking.lazy.lazyLinking.Property;
import org.eclipse.xtext.linking.services.LangATestLanguageGrammarAccess;
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
		ParserRule prType =  get(LangATestLanguageGrammarAccess.class).getTypeRule();
		Assignment asExtends = (Assignment) ((Group) prType.getAlternatives()).getTokens().get(3);
		CrossReference xref = (CrossReference) asExtends.getTerminal();
		EReference ref = GrammarUtil.getReference(xref, context.eClass());

		assertEquals(1, linkingService.getLinkedObjects(context, ref, leaf).size());
	}

	public void testGetSingleValuedLinkText() throws Exception {
		XtextResource r = getResourceFromString("type TypeA extends ^extends type ^extends extends ^type");
		Main model = (Main) r.getContents().get(0);
		assertEquals(2, model.getTypes().size());

		Type type = model.getTypes().get(0);
		assertEquals("TypeA", type.getName());
		Type superType = type.getExtends();
		assertEquals("extends", superType.getName());
		String linkText = linkingService.getLinkText(superType, LangATestLanguagePackage.Literals.TYPE__EXTENDS, type);
		assertEquals("^extends", linkText);

		type = superType;
		superType = type.getExtends();
		assertTrue(superType.eIsProxy());
		linkText = linkingService.getLinkText(superType, LangATestLanguagePackage.Literals.TYPE__EXTENDS, type);
		assertEquals("^type", linkText);

		type.eAdapters().remove(NodeUtil.getNodeAdapter(type));
		linkText = linkingService.getLinkText(superType, LangATestLanguagePackage.Literals.TYPE__EXTENDS, type);
		assertNull(linkText);
	}

	public void testGetMultiValuedLinkText() throws Exception {
		with(LazyLinkingTestLanguageStandaloneSetup.class);
		linkingService = (DefaultLinkingService) get(ILinkingService.class);

		XtextResource r = getResourceFromString("type TypeA {} type TypeB { TypeA TypeC TypeB p1; }");
		Model model = (Model) r.getContents().get(0);
		assertEquals(2, model.getTypes().size());
		
		org.eclipse.xtext.linking.lazy.lazyLinking.Type type = model.getTypes().get(1);
		assertEquals("TypeB", type.getName());
		assertEquals(1, type.getProperties().size());

		Property prop = type.getProperties().get(0);
		assertEquals("p1", prop.getName());
		assertEquals(3, prop.getType().size());

		org.eclipse.xtext.linking.lazy.lazyLinking.Type propType = prop.getType().get(0);
		assertFalse(propType.eIsProxy());
		String linkText = linkingService.getLinkText(propType, LazyLinkingPackage.Literals.PROPERTY__TYPE, prop);
		assertEquals("TypeA", linkText);

		propType = prop.getType().get(1);
		assertTrue(propType.eIsProxy());
		linkText = linkingService.getLinkText(propType, LazyLinkingPackage.Literals.PROPERTY__TYPE, prop);
		assertEquals("TypeC", linkText);

		propType = prop.getType().get(2);
		assertFalse(propType.eIsProxy());
		linkText = linkingService.getLinkText(propType, LazyLinkingPackage.Literals.PROPERTY__TYPE, prop);
		assertEquals("TypeB", linkText);

		prop.eAdapters().remove(NodeUtil.getNodeAdapter(prop));
		propType = prop.getType().get(1);
		assertTrue(propType.eIsProxy());
		linkText = linkingService.getLinkText(propType, LazyLinkingPackage.Literals.PROPERTY__TYPE, prop);
		assertNull(linkText);
	}

}
