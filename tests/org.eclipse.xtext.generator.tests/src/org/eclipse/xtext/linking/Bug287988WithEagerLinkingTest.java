/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.linking;

import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.linking.bug287988Test.BaseAttribute;
import org.eclipse.xtext.linking.bug287988Test.Model;
import org.eclipse.xtext.linking.impl.Linker;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug287988WithEagerLinkingTest extends Bug287988Test {
	
	private ResourceFactoryImpl factory;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		factory = new ResourceFactoryImpl(){
			@Override
			public Resource createResource(URI uri) {
				XtextResource resource = new XtextResource();
				injectMembers(resource);
				resource.setLinker(get(Linker.class));
				resource.setURI(uri);
				return resource;
			}
		};
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("bug287988testlanguage", factory);
	}

	@Override
	protected XtextResource doGetResource(InputStream in, URI uri) throws Exception {
		XtextResourceSet rs = get(XtextResourceSet.class);
		rs.setClasspathURIContext(getClass());
		XtextResource resource = (XtextResource) factory.createResource(uri);
		rs.getResources().add(resource);
		resource.load(in, null);
		EcoreUtil.resolveAll(resource);
		return resource;
	}
	
	@Override
	public void testAction_03() throws Exception {
		String modelAsString = "actions master mytype attr1; attribute ref attr3 attr2;";
		Model model = (Model) getModelAndExpect(modelAsString, 1);
		assertEquals(2, model.getAttributes().size());
		BaseAttribute baseAttribute = model.getAttributes().get(1);
		assertNull(baseAttribute.getTypeRef());
	}
	
}
