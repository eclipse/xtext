/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.service;

import junit.framework.TestCase;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class LanguageDescriptorFactoryTest extends TestCase {
	public void testgetLanguageDescriptor() throws Exception {
		ILanguageDescriptor descr = LanguageDescriptorFactory.createLanguageDescriptor("org.eclipse.xtext.ui.tests.dummylanguage", "Dummy Language", "org.eclipse", null);
		assertNotNull("LanguageDescriptor Initializing failed", descr);
		assertEquals("org.eclipse.xtext.ui.tests.dummylanguage", descr
				.getId());
		assertEquals("Dummy Language", descr.getName());
	}
}
