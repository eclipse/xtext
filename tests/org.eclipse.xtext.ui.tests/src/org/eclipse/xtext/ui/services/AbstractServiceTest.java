/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.services;

import junit.framework.TestCase;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class AbstractServiceTest extends TestCase {
	private static final String DEFAULT_LANGUAGE = "org.eclipse.xtext.reference.ReferenceGrammar";
	private ILanguageDescriptor languageDescriptor;

	protected ILanguageDescriptor getDefaultTestLanguage() {
		if (languageDescriptor == null)
			languageDescriptor = LanguageDescriptorFactory.get(DEFAULT_LANGUAGE);
		return languageDescriptor;
	}

	protected <T extends ILanguageService> T getServiceForDefaultLanguage(Class<T> clazz) {
		return ServiceRegistry.getService(getDefaultTestLanguage(), clazz);
	}

	@Override
	protected void setUp() throws Exception {
	    super.setUp();
	    // Activate UI plugin
	    Class.forName("org.eclipse.xtext.ui.core.editor.BaseTextEditor");
	}
}
