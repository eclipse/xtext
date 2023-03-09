/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.linking;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.scoping.impl.SyntheticModelAwareURIConverter;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class IgnoreCaseLinkingWithURIImportsTest extends AbstractIgnoreCaseLinkingTest {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(IgnoreCaseImportsTestLanguageStandaloneSetup.class);
	}

	@Override
	@Test public void testWithImports() throws Exception {
		SyntheticModelAwareURIConverter uriConverter = new SyntheticModelAwareURIConverter();
		XtextResourceSet resourceSet = get(XtextResourceSet.class);
		resourceSet.setURIConverter(uriConverter);
		
		uriConverter.addModel("a.ignorecaseimportstestlanguage", "a A {}");
		
		XtextResource resource = (XtextResource) getResourceFactory().createResource(URI.createURI("b.ignorecaseimportstestlanguage"));
		resourceSet.getResources().add(resource);
		resource.load(new StringInputStream("'a.ignorecaseimportstestlanguage' b A {}"), null);
		EcoreUtil.resolveAll(resource);
		assertTrue(resource.getErrors().toString(), resource.getErrors().isEmpty());
	}
	
	
	
}
