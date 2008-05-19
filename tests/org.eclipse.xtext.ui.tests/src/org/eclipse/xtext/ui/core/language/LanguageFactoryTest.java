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

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class LanguageFactoryTest extends TestCase {
	public void testgetLanguageDescriptor() throws Exception {
		LanguageDescriptor descr = LanguageDescriptorFactory
				.createLanguageDescriptor(org.eclipse.xtext.ui.core.tests.Activator.PLUGIN_ID);
		assertNotNull("LanguageDescriptor Initializing failed", descr);
		assertEquals("org.eclipse.xtext.ui.core.tests.dummylanguage", descr
				.getId());
		assertEquals("Dummy Language", descr.getName());
	}
}
