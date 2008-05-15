/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.language;

import junit.framework.TestCase;

import org.eclipse.xtext.ui.core.service.ISyntaxColorer;

/**
 * @author Peter Friese - Initial contribution and API
 *
 */
public class ServiceFactoryTest extends TestCase {

	public void testGetSyntaxColorerHappyCase() {
		LanguageDescriptor language = new LanguageDescriptor("org.eclipse.xtext.ui.core.tests.dummylanguage", "Dummy Language");
		ISyntaxColorer syntaxColorer = LanguageServiceFactory.getInstance().getSyntaxColorer(language);
		assertNotNull(syntaxColorer);
		assertEquals("org.eclipse.xtext.ui.core.language.SyntaxColorer1", syntaxColorer.getClass().getName());
	}
	
	public void testGetServiceWithoutClass() {
		LanguageDescriptor language = new LanguageDescriptor("org.eclipse.xtexte.ui.core.tests.language.ServiceWithoutClass");
		ISyntaxColorer syntaxColorer =LanguageServiceFactory.getInstance().getSyntaxColorer(language);
		assertNull(syntaxColorer);	
	}

}
