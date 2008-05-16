package org.eclipse.xtext.parsetree;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.m2t.type.emf.EmfRegistryMetaModel;
import org.eclipse.xtext.core.parsetree.AbstractNode;
import org.eclipse.xtext.core.parsetree.NodeAdapter;
import org.eclipse.xtext.core.parsetree.ParsetreePackage;
import org.eclipse.xtext.dummy.DummyLanguage;
import org.eclipse.xtext.dummy.DummyLanguageConstants;
import org.eclipse.xtext.dummy.parser.DummyLanguageASTFactory;
import org.eclipse.xtext.generator.tests.AbstractGeneratorTest;
import org.openarchitectureware.expression.ExecutionContextImpl;
import org.openarchitectureware.xtend.XtendFacade;

public class ASTChangeTest extends AbstractGeneratorTest {

	public void testWhitespaceIsIncluded() throws Exception {
		String model = "element foo;\nelement bar;";
		AbstractNode node = getRootNode(model);
		EObject me = node.getElement();
		assertWithXtend("'foo'", "elements.first().name", me);
		invokeWithXtend("elements.first().setName('stuff')", me);
		assertWithXtend("'stuff'", "elements.first().name", me);
		
//		assertEquals("element stuff;\nelement bar;", node.serialize());
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
				return new EPackage[]{DummyLanguageConstants.getDummyLangEPackage(),ParsetreePackage.eINSTANCE, EcorePackage.eINSTANCE};
			}
		});
		return XtendFacade.create(ctx);
	}
}
