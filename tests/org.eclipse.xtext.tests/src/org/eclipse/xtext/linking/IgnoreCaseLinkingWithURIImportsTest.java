/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.linking;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.scoping.impl.SyntheticModelAwareURIConverter;
import org.eclipse.xtext.util.StringInputStream;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class IgnoreCaseLinkingWithURIImportsTest extends AbstractIgnoreCaseLinkingTest {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(IgnoreCaseImportsTestLanguageStandaloneSetup.class);
	}

	@Override
	public void testWithImports() throws Exception {
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
