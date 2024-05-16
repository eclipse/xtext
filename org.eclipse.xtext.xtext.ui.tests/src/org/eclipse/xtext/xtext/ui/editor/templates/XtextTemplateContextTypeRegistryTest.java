/*******************************************************************************
 * Copyright (c) 2009, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.templates;

import java.util.Iterator;

import org.eclipse.text.templates.ContextTypeRegistry;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.eclipse.xtext.services.XtextGrammarAccess;
import org.eclipse.xtext.ui.editor.templates.ContextTypeIdHelper;
import org.eclipse.xtext.ui.editor.templates.XtextTemplateContextType;
import org.eclipse.xtext.ui.editor.templates.XtextTemplateContextTypeRegistry;
import org.junit.Test;

import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class XtextTemplateContextTypeRegistryTest extends AbstractXtextTests implements Provider<XtextTemplateContextType>{

	private XtextGrammarAccess grammarAccess;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
		grammarAccess = get(XtextGrammarAccess.class);
	}

	@Override
	public XtextTemplateContextType get() {
		return new XtextTemplateContextType();
	}
	
	@Test public void testTypesAreSorted() {
		ContextTypeRegistry registry = new XtextTemplateContextTypeRegistry(grammarAccess, this, new ContextTypeIdHelper());
		String prevName = "";
		Iterator<?> iter = registry.contextTypes();
		assertTrue(iter.hasNext());
		while(iter.hasNext()) {
			XtextTemplateContextType next = (XtextTemplateContextType) iter.next();
			assertTrue(prevName.compareTo(next.getName()) < 0);
			prevName = next.getName();
		}
	}
	
}
