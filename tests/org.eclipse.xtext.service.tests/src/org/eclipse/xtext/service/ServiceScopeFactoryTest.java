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

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class ServiceScopeFactoryTest extends TestCase {
	public void testgetLanguageDescriptor() throws Exception {
		IServiceScope descr = ServiceScopeFactory.createScope("org.eclipse.xtext.ui.tests.dummylanguage", null);
		assertNotNull("LanguageDescriptor Initializing failed", descr);
		assertEquals("org.eclipse.xtext.ui.tests.dummylanguage", descr
				.getId());
	}
}
