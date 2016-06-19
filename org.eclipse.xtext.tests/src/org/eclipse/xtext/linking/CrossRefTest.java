package org.eclipse.xtext.linking;

import java.util.List;

import org.apache.log4j.Level;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.linking.langATestLanguage.LangATestLanguageFactory;
import org.eclipse.xtext.linking.langATestLanguage.Main;
import org.eclipse.xtext.linking.langATestLanguage.Type;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.linking.lazy.LazyLinkingTestLanguageStandaloneSetup;
import org.eclipse.xtext.linking.lazy.lazyLinking.Model;
import org.eclipse.xtext.linking.lazy.lazyLinking.Property;
import org.eclipse.xtext.linking.lazy.services.LazyLinkingTestLanguageGrammarAccess;
import org.eclipse.xtext.linking.services.LangATestLanguageGrammarAccess;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer.ICrossReferenceSerializer;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.service.SingletonBinding;
import org.eclipse.xtext.testing.logging.LoggingTester;
import org.eclipse.xtext.testing.logging.LoggingTester.LogCapture;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class CrossRefTest extends AbstractXtextTests {
	private ICrossReferenceSerializer crossRefSerializer;
	private LangATestLanguageGrammarAccess grammar;
	
	public static class CrossRefLinkingService extends DefaultLinkingService {
		
		private EObject oneOffResult;

		public void returnOnceForGetLinkedObjects(EObject result) {
			oneOffResult = result;
		}

		@Override
		public List<EObject> getLinkedObjects(EObject context, EReference ref, INode node) throws IllegalNodeException {
			if (oneOffResult != null) {
				List<EObject> result = Lists.newArrayList(oneOffResult);
				oneOffResult = null;
				return result;
			}
			return super.getLinkedObjects(context, ref, node);
		}
	}

	protected INode getCrossReferenceNode(EObject context, EReference reference, EObject target) {
		List<INode> nodes = NodeModelUtils.findNodesForFeature(context, reference);
		if (!nodes.isEmpty()) {
			if (reference.isMany()) {
				int index = ((List<?>) context.eGet(reference, false)).indexOf(target);
				if (index >= 0 && index < nodes.size())
					return nodes.get(index);
			} else {
				return nodes.get(0);
			}
		}
		return null;
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(new LangATestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new LangATestLanguageRuntimeModule() {
					@Override
					@SingletonBinding
					public Class<? extends ILinkingService> bindILinkingService() {
						return CrossRefLinkingService.class;
					}
				});
			}
		});
		crossRefSerializer =  get(ICrossReferenceSerializer.class);
		grammar = (LangATestLanguageGrammarAccess) get(IGrammarAccess.class);
	}

	@Test public void testSimple() throws Exception {
		Main model = (Main) getModel("type A extends B type B extends A");
		assertEquals("B", model.getTypes().get(0).getExtends().getName());
		assertEquals(model.getTypes().get(0), model.getTypes().get(0).getExtends().getExtends());
	}

	@Test public void testGetLinkedObjects() throws Exception {
		XtextResource r = getResourceFromString("type TypeA extends TypeB type TypeB extends TypeA type AnotherType extends TypeA");
		Main model = (Main) r.getParseResult().getRootASTElement();
		ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(r.getParseResult().getRootNode(), 6);

		assertEquals(3, model.getTypes().size());

		EObject context = model.getTypes().get(0);
		Assignment asExtends = get(LangATestLanguageGrammarAccess.class).getTypeAccess().getExtendsAssignment_2_1();
		CrossReference xref = (CrossReference) asExtends.getTerminal();
		EReference ref = GrammarUtil.getReference(xref, context.eClass());

		assertEquals(1, getLinkingService().getLinkedObjects(context, ref, leaf).size());
	}

	@Test public void testGetSingleValuedLinkText() throws Exception {
		XtextResource r = getResourceFromStringAndExpect("type TypeA extends ^extends type ^extends extends ^type", 1);
		Main model = (Main) r.getContents().get(0);
		assertEquals(2, model.getTypes().size());

		Type type = model.getTypes().get(0);
		assertEquals("TypeA", type.getName());
		Type superType = type.getExtends();
		assertEquals("extends", superType.getName());
		String linkText = crossRefSerializer.serializeCrossRef(type, grammar.getTypeAccess().getExtendsTypeCrossReference_2_1_0(), superType, null);
		assertEquals("^extends", linkText);

		type = superType;
		superType = type.getExtends();
		assertTrue(superType.eIsProxy());
		INode node = getCrossReferenceNode(type, GrammarUtil.getReference(grammar.getTypeAccess().getExtendsTypeCrossReference_2_1_0()), superType);
		linkText = crossRefSerializer.serializeCrossRef(type, grammar.getTypeAccess().getExtendsTypeCrossReference_2_1_0(), superType, node);
		assertEquals("^type", linkText);

		type.eAdapters().remove(NodeModelUtils.getNode(type));
		linkText = crossRefSerializer.serializeCrossRef(type, grammar.getTypeAccess().getExtendsTypeCrossReference_2_1_0(), superType, null);
		assertNull(linkText);
	}

	@Test public void testGetMultiValuedLinkText() throws Exception {
		with(LazyLinkingTestLanguageStandaloneSetup.class);
		crossRefSerializer =  get(ICrossReferenceSerializer.class);
		final LazyLinkingTestLanguageGrammarAccess g =  (LazyLinkingTestLanguageGrammarAccess) get(IGrammarAccess.class);
		
		final XtextResource r = CrossRefTest.this.getResourceFromStringAndExpect("type TypeA {} type TypeB { TypeA TypeC TypeB p1; }", 1);
		LogCapture log = LoggingTester.captureLogging(Level.ERROR, LazyLinkingResource.class, new Runnable() {
			@Override
			public void run() {
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
				String linkText = crossRefSerializer.serializeCrossRef(prop,g.getPropertyAccess().getTypeTypeCrossReference_0_0(), propType, null);
				assertEquals("TypeA", linkText);
		
				propType = prop.getType().get(1);
				assertTrue(propType.eIsProxy());
				INode node = getCrossReferenceNode(prop, GrammarUtil.getReference(g.getPropertyAccess().getTypeTypeCrossReference_0_0()), propType);
				linkText = crossRefSerializer.serializeCrossRef(prop,g.getPropertyAccess().getTypeTypeCrossReference_0_0(), propType, node);
				assertEquals("TypeC", linkText);
		
				propType = prop.getType().get(2);
				assertFalse(propType.eIsProxy());
				node = getCrossReferenceNode(prop, GrammarUtil.getReference(g.getPropertyAccess().getTypeTypeCrossReference_0_0()), propType);
				linkText = crossRefSerializer.serializeCrossRef(prop,g.getPropertyAccess().getTypeTypeCrossReference_0_0(), propType, null);
				assertEquals("TypeB", linkText);
		
				prop.eAdapters().remove(NodeModelUtils.getNode(prop));
				propType = prop.getType().get(1);
				assertTrue(propType.eIsProxy());
				linkText = crossRefSerializer.serializeCrossRef(prop,g.getPropertyAccess().getTypeTypeCrossReference_0_0(), propType, null);
				assertNull(linkText);
			}
		});
		log.assertNumberOfLogEntries(2);
	}

	/* see https://bugs.eclipse.org/bugs/show_bug.cgi?id=287813 */
	@Test public void testNonDefaultLinkText() throws Exception {
		XtextResource r = getResourceFromString("type TypeA extends ^TypeB type TypeB");
		Main model = (Main) r.getContents().get(0);
		assertEquals(2, model.getTypes().size());

		Type type = model.getTypes().get(0);
		assertEquals("TypeA", type.getName());
		Type superType = type.getExtends();
		assertEquals("TypeB", superType.getName());
		INode node = getCrossReferenceNode(type, GrammarUtil.getReference(grammar.getTypeAccess().getExtendsTypeCrossReference_2_1_0()), superType);
		String linkText = crossRefSerializer.serializeCrossRef(type, grammar.getTypeAccess().getExtendsTypeCrossReference_2_1_0(), superType, node);
		assertTrue(ITokenSerializer.KEEP_VALUE_FROM_NODE_MODEL == linkText);
	}

	/* see https://bugs.eclipse.org/bugs/show_bug.cgi?id=325435 */
	@Test public void testSerializingProxiedCrossReference() throws Exception {
		XtextResource r = getResourceFromString("type TypeA extends ^TypeB type TypeB ");
		Main model = (Main) r.getContents().get(0);

		Type type = model.getTypes().get(0);
		Type superType = type.getExtends();

		CrossRefLinkingService linkingService = (CrossRefLinkingService) get(ILinkingService.class);
		InternalEObject typeProxy = (InternalEObject) LangATestLanguageFactory.eINSTANCE.createType();
		typeProxy.eSetProxyURI(EcoreUtil.getURI(superType));
		linkingService.returnOnceForGetLinkedObjects(typeProxy);

		INode node = getCrossReferenceNode(type, GrammarUtil.getReference(grammar.getTypeAccess().getExtendsTypeCrossReference_2_1_0()), superType);
		String linkText = crossRefSerializer.serializeCrossRef(type, grammar.getTypeAccess().getExtendsTypeCrossReference_2_1_0(), superType, node);
		assertEquals(ITokenSerializer.KEEP_VALUE_FROM_NODE_MODEL, linkText);
	}

	/* see https://bugs.eclipse.org/bugs/show_bug.cgi?id=287813 */
	@Test public void testOutOfSyncNodeModel() throws Exception {
		XtextResource r = getResourceFromString("type TypeA extends ^TypeB type TypeB ");
		Main model = (Main) r.getContents().get(0);

		Type type = model.getTypes().get(0);
		Type superType = type.getExtends();
		superType.setName("TypeC");

		String linkText = crossRefSerializer.serializeCrossRef(type, grammar.getTypeAccess().getExtendsTypeCrossReference_2_1_0(), superType, null);
		assertEquals("TypeC", linkText);
	}
	
	/* see https://bugs.eclipse.org/bugs/show_bug.cgi?id=298506 */
	@Test public void testCrossReferenceValueConverter() throws Exception {
		Resource r = get(XtextResourceSet.class).createResource(URI.createURI("test." + getCurrentFileExtension()));
		Main main = LangATestLanguageFactory.eINSTANCE.createMain();
		Type ele = LangATestLanguageFactory.eINSTANCE.createType();
		r.getContents().add(main);
		main.getTypes().add(ele);
		ele.setName("type");
		ele.setExtends(ele);
		assertEquals("type ^type extends ^type", getSerializer().serialize(main));
	}

}
