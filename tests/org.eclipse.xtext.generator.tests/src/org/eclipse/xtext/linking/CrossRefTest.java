package org.eclipse.xtext.linking;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.linking.langATestLanguage.LangATestLanguageFactory;
import org.eclipse.xtext.linking.langATestLanguage.Main;
import org.eclipse.xtext.linking.langATestLanguage.Type;
import org.eclipse.xtext.linking.lazy.LazyLinkingTestLanguageStandaloneSetup;
import org.eclipse.xtext.linking.lazy.lazyLinking.Model;
import org.eclipse.xtext.linking.lazy.lazyLinking.Property;
import org.eclipse.xtext.linking.lazy.services.LazyLinkingTestLanguageGrammarAccess;
import org.eclipse.xtext.linking.services.LangATestLanguageGrammarAccess;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.reconstr.ICrossReferenceSerializer;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

public class CrossRefTest extends AbstractGeneratorTest {
	private static final Logger logger = Logger.getLogger(CrossRefTest.class);
	private ICrossReferenceSerializer linkingService;
	private LangATestLanguageGrammarAccess grammar;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(LangATestLanguageStandaloneSetup.class);
		linkingService =  get(ICrossReferenceSerializer.class);
		grammar = (LangATestLanguageGrammarAccess) get(IGrammarAccess.class);
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
		Assignment asExtends = get(LangATestLanguageGrammarAccess.class).getTypeAccess().getExtendsAssignment_2_1();
		CrossReference xref = (CrossReference) asExtends.getTerminal();
		EReference ref = GrammarUtil.getReference(xref, context.eClass());

		assertEquals(1, getLinkingService().getLinkedObjects(context, ref, leaf).size());
	}

	public void testGetSingleValuedLinkText() throws Exception {
		XtextResource r = getResourceFromStringAndExpect("type TypeA extends ^extends type ^extends extends ^type", 1);
		Main model = (Main) r.getContents().get(0);
		assertEquals(2, model.getTypes().size());

		Type type = model.getTypes().get(0);
		assertEquals("TypeA", type.getName());
		Type superType = type.getExtends();
		assertEquals("extends", superType.getName());
		String linkText = linkingService.serializeCrossRef(type, grammar.getTypeAccess().getExtendsTypeCrossReference_2_1_0(), superType);
		assertEquals("^extends", linkText);

		type = superType;
		superType = type.getExtends();
		assertTrue(superType.eIsProxy());
		linkText = linkingService.serializeCrossRef(type, grammar.getTypeAccess().getExtendsTypeCrossReference_2_1_0(), superType);
		assertEquals("^type", linkText);

		type.eAdapters().remove(NodeUtil.getNodeAdapter(type));
		linkText = linkingService.serializeCrossRef(type, grammar.getTypeAccess().getExtendsTypeCrossReference_2_1_0(), superType);
		assertNull(linkText);
	}

	public void testGetMultiValuedLinkText() throws Exception {
		with(LazyLinkingTestLanguageStandaloneSetup.class);
		linkingService =  get(ICrossReferenceSerializer.class);
		LazyLinkingTestLanguageGrammarAccess g =  (LazyLinkingTestLanguageGrammarAccess) get(IGrammarAccess.class);

		XtextResource r = getResourceFromStringAndExpect("type TypeA {} type TypeB { TypeA TypeC TypeB p1; }", 1);
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
		String linkText = linkingService.serializeCrossRef(prop,g.getPropertyAccess().getTypeTypeCrossReference_0_0(), propType);
		assertEquals("TypeA", linkText);

		propType = prop.getType().get(1);
		assertTrue(propType.eIsProxy());
		linkText = linkingService.serializeCrossRef(prop,g.getPropertyAccess().getTypeTypeCrossReference_0_0(), propType);
		assertEquals("TypeC", linkText);

		propType = prop.getType().get(2);
		assertFalse(propType.eIsProxy());
		linkText = linkingService.serializeCrossRef(prop,g.getPropertyAccess().getTypeTypeCrossReference_0_0(), propType);
		assertEquals("TypeB", linkText);

		prop.eAdapters().remove(NodeUtil.getNodeAdapter(prop));
		propType = prop.getType().get(1);
		assertTrue(propType.eIsProxy());
		linkText = linkingService.serializeCrossRef(prop,g.getPropertyAccess().getTypeTypeCrossReference_0_0(), propType);
		assertNull(linkText);
	}

	/* see https://bugs.eclipse.org/bugs/show_bug.cgi?id=287813 */
	public void testNonDefaultLinkText() throws Exception {
		XtextResource r = getResourceFromString("type TypeA extends ^TypeB type TypeB");
		Main model = (Main) r.getContents().get(0);
		assertEquals(2, model.getTypes().size());

		Type type = model.getTypes().get(0);
		assertEquals("TypeA", type.getName());
		Type superType = type.getExtends();
		assertEquals("TypeB", superType.getName());
		String linkText = linkingService.serializeCrossRef(type, grammar.getTypeAccess().getExtendsTypeCrossReference_2_1_0(), superType);
		assertEquals("^TypeB", linkText);
	}

	/* see https://bugs.eclipse.org/bugs/show_bug.cgi?id=287813 */
	public void testOutOfSyncNodeModel() throws Exception {
		XtextResource r = getResourceFromString("type TypeA extends ^TypeB type TypeB ");
		Main model = (Main) r.getContents().get(0);

		Type type = model.getTypes().get(0);
		Type superType = type.getExtends();
		superType.setName("TypeC");

		String linkText = linkingService.serializeCrossRef(type, grammar.getTypeAccess().getExtendsTypeCrossReference_2_1_0(), superType);
		assertEquals("TypeC", linkText);
	}
	
	/* see https://bugs.eclipse.org/bugs/show_bug.cgi?id=298506 */
	public void testCrossReferenceValueConverter() throws Exception {
		Resource r = get(XtextResourceSet.class).createResource(URI.createURI("test." + getCurrentFileExtension()));
		Type ele = LangATestLanguageFactory.eINSTANCE.createType();
		r.getContents().add(ele);
		ele.setName("type");
		ele.setExtends(ele);
		assertEquals("type ^type extends ^type", getSerializer().serialize(ele));
	}

}
