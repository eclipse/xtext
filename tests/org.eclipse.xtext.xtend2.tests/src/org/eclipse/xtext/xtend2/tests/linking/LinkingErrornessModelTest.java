/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.linking;

import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class LinkingErrornessModelTest extends AbstractXtend2TestCase {
	
	/**
	 * just ensures that parsing, linking and validation don't throw exceptions on invlaid models.
	 */
	public void testParseErrornessModel() throws Exception {
		final String name = "/"+getClass().getName().replace('.', '/')+"Data.xtend";
		final InputStream resourceAsStream = getClass().getResourceAsStream(name);
		String string = Files.readStreamIntoString(resourceAsStream);
		for (int i = 1; i < string.length(); i=i+4) {
			doParseLinkAndValidate(string.substring(0, i));
		}
	}

	protected void doParseLinkAndValidate(String string) throws Exception {
		XtextResourceSet set = get(XtextResourceSet.class);
		LazyLinkingResource resource = (LazyLinkingResource) set.createResource(URI.createURI("Test.xtend"));
		resource.load(new StringInputStream(string), null);
		resource.resolveLazyCrossReferences(CancelIndicator.NullImpl);
		resource.getResourceServiceProvider().getResourceValidator().validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
	}
}
