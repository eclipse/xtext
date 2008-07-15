/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.services;

import java.io.InputStream;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.service.ServiceScopeFactory;
import org.eclipse.xtext.util.StringInputStream;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public abstract class AbstractServiceTest extends TestCase {
	static {
		Thread.currentThread().setContextClassLoader(AbstractServiceTest.class.getClassLoader());
	}

	private static final String DEFAULT_LANGUAGE = "org.eclipse.xtext.reference.ReferenceGrammar";
	private IServiceScope languageDescriptor;

	protected IServiceScope getDefaultTestLanguage() {
		if (languageDescriptor == null)
			languageDescriptor = ServiceScopeFactory.get(DEFAULT_LANGUAGE);
		return languageDescriptor;
	}

	protected <T extends ILanguageService> T getServiceForDefaultLanguage(Class<T> clazz) {
		return ServiceRegistry.getService(getDefaultTestLanguage(), clazz);
	}

	protected IParseResult getModelForDefaultLanguage(String model) throws Exception {
		IResourceFactory resfac = getServiceForDefaultLanguage(IResourceFactory.class);
		return getResource(resfac, new StringInputStream(model)).getParseResult();
	}

	protected XtextResource getResource(IResourceFactory resfac, InputStream in) throws Exception {
		XtextResourceSet rs = new XtextResourceSet();
		XtextResource resource = (XtextResource) rs.createResource(URI.createURI("mytestmodel."
				+ resfac.getModelFileExtensions()[0]));
		resource.load(in, null);
		return resource;
	}

}
