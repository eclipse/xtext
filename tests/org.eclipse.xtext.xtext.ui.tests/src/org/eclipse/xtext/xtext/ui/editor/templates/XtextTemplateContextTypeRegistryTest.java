/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.templates;

import java.util.Iterator;

import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.services.XtextGrammarAccess;
import org.eclipse.xtext.ui.common.editor.templates.XtextTemplateContextType;
import org.eclipse.xtext.ui.common.editor.templates.XtextTemplateContextTypeRegistry;

import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextTemplateContextTypeRegistryTest extends AbstractXtextTests implements Provider<XtextTemplateContextType>{

	private XtextGrammarAccess grammarAccess;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
		grammarAccess = get(XtextGrammarAccess.class);
	}

	public XtextTemplateContextType get() {
		return new XtextTemplateContextType();
	}
	
	public void testTypesAreSorted() {
		XtextTemplateContextTypeRegistry registry = new XtextTemplateContextTypeRegistry(grammarAccess, this);
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
