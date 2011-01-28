/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.outline;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xtext.ui.Activator;

import com.google.inject.Injector;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtextOutlineTreeProviderTest extends AbstractXtextTests {

	private XtextOutlineTreeProvider treeProvider;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		final Injector injector = Activator.getDefault().getInjector("org.eclipse.xtext.Xtext");
		with(new ISetup() {
			public Injector createInjectorAndDoEMFRegistration() {
				return injector;
			}
		});
		treeProvider = get(XtextOutlineTreeProvider.class);
	}

	public void testNoNPEs() throws Exception {
		assertNoException("grammar Foo generate foo 'Foo' terminal framgment : ;");
		assertNoException("grammar Foo generate foo 'Foo' terminal : ;");
	}

	protected void assertNoException(String model) throws Exception {
		try {
			XtextResource resource = getResourceAndExpect(new StringInputStream(model), UNKNOWN_EXPECTATION);
			XtextDocument document = get(XtextDocument.class);
			document.setInput(resource);
			IOutlineNode root = treeProvider.createRoot(document);
			traverseChildren(root);
		} catch (Exception exc) {
			exc.printStackTrace();
			fail("Exception in outline tree construction");
		}
	}

	private void traverseChildren(IOutlineNode node) {
		for (IOutlineNode child : node.getChildren()) {
			traverseChildren(child);
		}
	}

}
