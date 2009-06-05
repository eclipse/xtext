package org.eclipse.xtext.ui.common.editor.outline.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.common.editor.outline.transformer.DefaultSemanticModelTransformer;
import org.eclipse.xtext.ui.core.DefaultLabelProvider;
import org.eclipse.xtext.ui.core.DefaultLocationInFileProvider;

public class DefaultSemanticModelTransformerTest extends AbstractXtextTests {

	private EObject root;
	private EObject a1;
	private EObject a2;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		XtextResourceSet resourceSet = get(XtextResourceSet.class);
		resourceSet.setClasspathURIContext(getClass());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		Resource resource = resourceSet.createResource(URI
				.createURI("classpath:/org/eclipse/xtext/ui/common/editor/outline/impl/simplestructure.xmi"));
		resource.load(null);
		root = resource.getContents().get(0);
		a1 = root.eContents().get(0);
		a2 = root.eContents().get(1);
	}

	protected DefaultSemanticModelTransformer getSemanticModelTransformer() {
		DefaultSemanticModelTransformer tr = new DefaultSemanticModelTransformer();
		tr.setLabelProvider(new DefaultLabelProvider());
		tr.setLocationProvider(new DefaultLocationInFileProvider());
		return tr;
	}

	public void testNullSafety() {
		DefaultSemanticModelTransformer transformer = getSemanticModelTransformer();
		assertFalse(transformer.consumeSemanticChildNodes(null));
		assertFalse(transformer.consumeSemanticNode(null));
		assertEquals("<unknown>", transformer.getText(null));
	}

	public void testGetText() {
		DefaultSemanticModelTransformer transformer = getSemanticModelTransformer();
		String a1Text = transformer.getText(a1);
		assertEquals("A1", a1Text);
		String a2Text = transformer.getText(a2);
		assertEquals("A2", a2Text);
	}

}
