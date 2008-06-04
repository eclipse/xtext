/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.language;

import junit.framework.TestCase;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.ui.core.service.ISyntaxColorer;

/**
 * @author Peter Friese - Initial contribution and API
 *
 */
public class ServiceFactoryTest extends TestCase {

	public void testGetSyntaxColorerHappyCase() throws ClassNotFoundException {
	    Class.forName("org.eclipse.xtext.ui.core.editor.BaseTextEditor");
		ILanguageDescriptor language = LanguageDescriptorFactory.get("org.eclipse.xtext.ui.tests.dummylanguage");
		ISyntaxColorer syntaxColorer = ServiceRegistry.getService(language, ISyntaxColorer.class);
		assertNotNull(syntaxColorer);
		assertEquals("org.eclipse.xtext.ui.SyntaxColorer1", syntaxColorer.getClass().getName());
	}
	
	public void testGetServiceWithoutClass() {
		ILanguageDescriptor language = LanguageDescriptorFactory.createLanguageDescriptor("org.eclipse.xtexte.ui.tests.language.ServiceWithoutClass", "", "",null);
		ISyntaxColorer syntaxColorer = ServiceRegistry.getService(language, ISyntaxColorer.class);
		assertNull(syntaxColorer);	
	}

}
