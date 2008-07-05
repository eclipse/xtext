/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.services;

import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.xtext.builtin.IXtextBuiltin;
import org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.ui.AbstractEasyMockTest;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import org.eclipse.xtext.ui.service.impl.BuiltInPreferenceStore;
import org.eclipse.xtext.ui.service.impl.BuiltInSyntaxColorer;
import org.eclipse.xtext.ui.service.impl.BuiltInTokenTypeDef;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class BISyntaxColorerTest extends AbstractEasyMockTest {
	static {
		Thread.currentThread().setContextClassLoader(AbstractServiceTest.class.getClassLoader());
		if (LanguageDescriptorFactory.get(IXtextBuiltin.ID) == null)
			XtextBuiltinStandaloneSetup.doSetup();
	}
	private BuiltInSyntaxColorer colorer;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		colorer = new BuiltInSyntaxColorer();
		final ILanguageDescriptor languageDescriptorMock = createMock(ILanguageDescriptor.class);
		final IPersistentPreferenceStore persistablePrefStore = createMock(IPersistentPreferenceStore.class);

		colorer.setLanguageDescriptor(languageDescriptorMock);
		colorer.setTokenTypeDefProvider(new BuiltInTokenTypeDef());
		colorer.setPreferenceStore(new BuiltInPreferenceStore() {
			@Override
			public IPersistentPreferenceStore getPersitablePreferenceStore() {
				return persistablePrefStore;
			}
		});
		replay();
	}

	public void testTextDefaultStyle() throws Exception {
		LeafNode leafNode = createLeafNode();
		leafNode.setText("nothing");
		TextStyle textStyle = colorer.color(leafNode);
		assertNotNull(textStyle);
	}

	public void testKnownTokenTypeStyle() throws Exception {
		LeafNode leafNode = createSLComment();
		TextStyle textStyle = colorer.color(leafNode);
		assertNotNull(textStyle);
	}

}
