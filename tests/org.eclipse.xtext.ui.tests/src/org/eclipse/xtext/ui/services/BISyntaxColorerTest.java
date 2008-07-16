/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.services;

import static org.easymock.EasyMock.expect;

import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.xtext.builtin.IXtextBuiltin;
import org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceScopeFactory;
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
		if (ServiceScopeFactory.get(IXtextBuiltin.ID) == null)
			XtextBuiltinStandaloneSetup.doSetup();
	}
	private BuiltInSyntaxColorer colorer;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		colorer = new BuiltInSyntaxColorer();
		final IServiceScope languageDescriptorMock = createMock(IServiceScope.class);
		expect(languageDescriptorMock.getId()).andStubReturn("org.test.language");
		final IPersistentPreferenceStore persistablePrefStore = createMock(IPersistentPreferenceStore.class);

		BuiltInTokenTypeDef service = new BuiltInTokenTypeDef();
		service.setPreferenceStore(new BuiltInPreferenceStore() {
			@Override
			public IPersistentPreferenceStore getPersitablePreferenceStore() {
				return persistablePrefStore;
			}
		});
		colorer.setTokenTypeDefProvider(service);
		replay();
	}

	public void testTextDefaultStyle() throws Exception {
		LeafNode leafNode = createLeafNode();
		leafNode.setText("nothing");
		TextStyle textStyle = colorer.color(leafNode);
		assertNull(textStyle);
	}

	public void testKnownTokenTypeStyle() throws Exception {
		LeafNode leafNode = createSLComment();
		TextStyle textStyle = colorer.color(leafNode);
		assertNotNull(textStyle);
	}

}
