/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * @author Sven Efftinge
 */
public class URIsInEcoreFilesXtendTest extends Assert {

	private ResourceSet resourceSet;

	@Before
	public void setUp() throws Exception {
		resourceSet = new XtextResourceSet();
		resourceSet.getLoadOptions().put(XMLResource.OPTION_URI_HANDLER, new URIHandlerImpl.PlatformSchemeAware() {

			@Override
			public URI resolve(URI uri) {
				assertPortableURI(uri);
				return super.resolve(uri);
			}

			private void assertPortableURI(URI uri) {
				if (uri.isRelative()) {
					String path = uri.path();
					assertFalse(uri.toString() + " is not portable", path.startsWith(".."));
				}
			}
		});
	}

	protected void doTestResource(String platformPath, String... packageNames) {
		Resource resource = resourceSet.getResource(URI.createPlatformPluginURI(platformPath, false), true);
		assertNotNull(resource);
		assertEquals(1, resource.getContents().size());
		EObject obj = resource.getContents().get(0);
		if (obj instanceof EPackage) {
			assertEquals(packageNames[0], ((EPackage) obj).getName());
		} else if (obj instanceof GenModel) {
			GenModel model = (GenModel) obj;
			List<GenPackage> packages = Lists.newArrayList(model.getGenPackages());
			assertEquals(packageNames.length, packages.size());
			ListExtensions.sortInplaceBy(packages, new Functions.Function1<GenPackage, String>() {
				@Override
				public String apply(GenPackage p) {
					return p.getEcorePackage().getName();
				}
			});
			List<String> packageNamesList = Arrays.asList(packageNames);
			Collections.sort(packageNamesList);
			for (int i = 0; i < packageNamesList.size(); i++) {
				assertEquals(packageNamesList.get(i), packages.get(i).getEcorePackage().getName());
			}
		} else {
			fail("Unexpected root element type: " + obj.eClass().getName());
		}
	}

	@Test
	public void testXtend() {
		doTestResource("org.eclipse.xtend.core/model/Xtend.ecore", "xtend");
	}

	@Test
	public void testXtendGenModel() {
		doTestResource("org.eclipse.xtend.core/model/Xtend.genmodel", "xtend");
	}

	@Test
	public void testRichStrings() {
		doTestResource("org.eclipse.xtend.core/model/RichStrings.ecore", "richstring");
	}

	@Test
	public void testRichStringsGenModel() {
		doTestResource("org.eclipse.xtend.core/model/RichStrings.genmodel", "richstring");
	}

}
