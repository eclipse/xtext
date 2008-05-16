package org.eclipse.xtext.parsetree;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.m2t.type.emf.EmfRegistryMetaModel;
import org.eclipse.xtext.core.parsetree.AbstractNode;
import org.eclipse.xtext.core.parsetree.CompositeNode;
import org.eclipse.xtext.core.parsetree.LeafNode;
import org.eclipse.xtext.core.parsetree.NodeAdapter;
import org.eclipse.xtext.core.parsetree.ParsetreePackage;
import org.eclipse.xtext.dummy.DummyLanguage;
import org.eclipse.xtext.dummy.parser.DummyLanguageASTFactory;
import org.eclipse.xtext.generator.tests.AbstractGeneratorTest;
import org.openarchitectureware.expression.ExecutionContextImpl;
import org.openarchitectureware.xtend.XtendFacade;

public class LengthOffsetLineTest extends AbstractGeneratorTest {

	public void testOffset() throws Exception {
		String model = "element foo;\nelement bar;";
		CompositeNode node = (CompositeNode) getRootNode(model);
		EList<LeafNode> leafNodes = node.getLeafNodes();
		Iterator<LeafNode> iter = leafNodes.iterator();
		assertEquals(0,iter.next().offset());
		assertEquals(7,iter.next().offset());
		assertEquals(8,iter.next().offset());
		assertEquals(11,iter.next().offset());
		assertEquals(12,iter.next().offset());
		assertEquals(13,iter.next().offset());
		assertEquals(20,iter.next().offset());
		assertEquals(21,iter.next().offset());
		assertEquals(24,iter.next().offset());
	}
	
	public void testOffset2() throws Exception {
		String model = "element foo;\nelement bar;";
		CompositeNode node = (CompositeNode) getRootNode(model);
		Iterator<AbstractNode> iter = node.getChildren().iterator();
		assertEquals(0,iter.next().offset());
		assertEquals(12,iter.next().offset());
		assertFalse(iter.hasNext());
	}

	public void testLineForLeafnodes() throws Exception {
		String model = "element foo;\nelement bar;";
		CompositeNode node = (CompositeNode) getRootNode(model);
		EList<LeafNode> leafNodes = node.getLeafNodes();
		Iterator<LeafNode> iter = leafNodes.iterator();
		assertEquals(0,iter.next().line());
		assertEquals(0,iter.next().line());
		assertEquals(0,iter.next().line());
		assertEquals(0,iter.next().line());
		assertEquals(0,iter.next().line());
		assertEquals(1,iter.next().line());
		assertEquals(1,iter.next().line());
		assertEquals(1,iter.next().line());
		assertEquals(1,iter.next().line());
		assertFalse(iter.hasNext());
	}
	
	public void testLineForCompositeNodes() throws Exception {
		String model = "element foo;\nelement bar;\nelement bar;\nelement bar;";
		CompositeNode node = (CompositeNode) getRootNode(model);
		Iterator<AbstractNode> iter = node.getChildren().iterator();
		assertEquals(0,iter.next().line());
		//Note: because preceding whitespace is added to the following node,
		// the '\n' is always added to the following composite node
		assertEquals(0,iter.next().line());
		assertEquals(1,iter.next().line());
		assertEquals(2,iter.next().line());
		assertFalse(iter.hasNext());
	}
	
	
	private AbstractNode getRootNode(String model) throws Exception {
		EObject object = (EObject) parse(model,new DummyLanguageASTFactory());
		NodeAdapter adapter = (NodeAdapter) object.eAdapters().get(0);
		AbstractNode node = adapter.getParserNode();
		return node;
	}
	@Override
	protected Class<?> getTheClass() {
		return DummyLanguage.class;
	}
	
	@Override
	protected XtendFacade getXtendFacade() {
		ExecutionContextImpl ctx = new ExecutionContextImpl();
		ctx.registerMetaModel(new EmfRegistryMetaModel() {
			@Override
			protected EPackage[] allPackages() {
				return new EPackage[]{ParsetreePackage.eINSTANCE, EcorePackage.eINSTANCE};
			}
		});
		return XtendFacade.create(ctx);
	}
}
