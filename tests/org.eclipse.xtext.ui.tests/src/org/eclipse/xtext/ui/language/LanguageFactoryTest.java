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

import org.eclipse.xtext.service.LanguageDescriptorFactory;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class LanguageFactoryTest extends TestCase {
	public void testgetLanguageDescriptor() throws Exception {
		Class.forName("org.eclipse.xtext.ui.core.editor.BaseTextEditor");
		try {
			LanguageDescriptorFactory
					.createLanguageDescriptor("org.eclipse.xtext.ui.tests.dummylanguage", "", "", null);
			fail("Initialisation should have failed");
		}
		catch (Exception exc) {
			// happy case
		}
	}
}
