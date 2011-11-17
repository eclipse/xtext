/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests;

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

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class URIsInEcoreFilesTest extends AbstractXbaseTestCase {

	private ResourceSet resourceSet;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		resourceSet = get(XtextResourceSet.class);
		resourceSet.getLoadOptions().put(XMLResource.OPTION_URI_HANDLER, new URIHandlerImpl.PlatformSchemeAware() {
			
			@Override
			public URI resolve(URI uri) {
				assertPortableURI(uri);
				return super.resolve(uri);
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
				public String apply(GenPackage p) {
					return p.getEcorePackage().getName();
				}
			});
			List<String> packageNamesList = Arrays.asList(packageNames);
			Collections.sort(packageNamesList);
			for(int i = 0; i < packageNamesList.size(); i++) {
				assertEquals(packageNamesList.get(i), packages.get(i).getEcorePackage().getName());
			}
		} else {
			fail("Unexpected root element type: " + obj.eClass().getName());
		}
	}
	
	public void testXbase() {
		doTestResource("org.eclipse.xtext.xbase/model/Xbase.ecore", "xbase");
	}
	
	public void testXtype() {
		doTestResource("org.eclipse.xtext.xbase/model/Xtype.ecore", "xtype");
	}
	
	public void testXbaseWithAnnotations() {
		doTestResource("org.eclipse.xtext.xbase/model/XAnnotations.ecore", "xAnnotations");
	}
	
	public void testXbaseGenmodel() {
		doTestResource("org.eclipse.xtext.xbase/model/Xbase.genmodel", "xbase", "xtype", "xAnnotations");
	}
	
	public void testXtend2() {
		doTestResource("org.eclipse.xtext.xtend2/model/Xtend2.ecore", "xtend2");
	}
	
	public void testXtend2GenModel() {
		doTestResource("org.eclipse.xtext.xtend2/model/Xtend2.genmodel", "xtend2");
	}
	
	public void testRichStrings() {
		doTestResource("org.eclipse.xtext.xtend2/model/RichStrings.ecore", "richstring");
	}
	
	public void testRichStringsGenModel() {
		doTestResource("org.eclipse.xtext.xtend2/model/RichStrings.genmodel", "richstring");
	}
	
	public void testCommonTypes() {
		doTestResource("org.eclipse.xtext.common.types/model/JavaVMTypes.ecore", "types");
	}

	public void testCommonTypesGenModel() {
		doTestResource("org.eclipse.xtext.common.types/model/JavaVMTypes.genmodel", "types");
	}
	
	protected void assertPortableURI(URI uri) {
		if (uri.isRelative()) {
			String path = uri.path();
			assertFalse(uri.toString() + " is not portable", path.startsWith(".."));
		}
	}
	
}
