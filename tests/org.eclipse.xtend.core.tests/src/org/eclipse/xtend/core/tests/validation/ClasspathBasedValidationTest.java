/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.XtendRuntimeModule;
import org.eclipse.xtend.core.XtendStandaloneSetup;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtext.junit4.GlobalRegistries;
import org.eclipse.xtext.junit4.GlobalRegistries.GlobalStateMemento;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ClasspathBasedValidationTest extends Assert {
	
	private Injector injector;

	@Inject
	protected ValidationTestHelper helper;

	private GlobalStateMemento memento;
	
	@Before
	public void setUp() throws Exception {
		memento = GlobalRegistries.makeCopyOfGlobalState();
		GlobalRegistries.clearGlobalRegistries();
		injector = new XtendStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new XtendRuntimeModule() {
					@Override
					public ClassLoader bindClassLoaderToInstance() {
						return AbstractXtendTestCase.class.getClassLoader();
					}

				});
			}
		}.createInjectorAndDoEMFRegistration();
		injector.injectMembers(this);
	}
	
	@After
	public void tearDown() throws Exception {
		memento.restoreGlobalState();
	}

	@Test public void testFileNamingConventions_0() throws Exception {
		XtendFile xtendFile = loadExampleXtendFile();
		helper.assertNoError(xtendFile, IssueCodes.WRONG_PACKAGE);
		helper.assertNoError(xtendFile, IssueCodes.WRONG_FILE);
	}
	
	@Ignore
	@Test public void testFileNamingConventions_1() throws Exception {
		XtendFile xtendFile = loadExampleXtendFile();
			xtendFile.getXtendTypes().get(0).setName("Bar");
		helper.assertNoError(xtendFile, IssueCodes.WRONG_PACKAGE);
		helper.assertError(xtendFile, XtendPackage.Literals.XTEND_CLASS, IssueCodes.WRONG_FILE);
	}
		
	@Ignore
	@Test public void testFileNamingConventions_2() throws Exception {
		XtendFile xtendFile = loadExampleXtendFile();
		Resource resource = xtendFile.eResource();
		URI resourceURI = resource.getURI();
		URI invalidPackageURI = resourceURI.trimSegments(1).appendSegment("invalid").appendSegment(resourceURI.lastSegment());
		resource.setURI(invalidPackageURI);
		helper.assertError(xtendFile, XtendPackage.Literals.XTEND_FILE, IssueCodes.WRONG_PACKAGE);
		helper.assertNoError(xtendFile, IssueCodes.WRONG_FILE);
	}
	
	@Ignore
	@Test public void testFileNamingConventions_3() throws Exception {
		XtendFile xtendFile = loadExampleXtendFile();
		xtendFile.setPackage(null);
		helper.assertError(xtendFile, XtendPackage.Literals.XTEND_FILE, IssueCodes.WRONG_PACKAGE);
		helper.assertNoError(xtendFile, IssueCodes.WRONG_FILE);
	}
	
	@Test public void testFileNamingConventions_4() throws Exception {
		XtendFile xtendFile = loadXtendFile("classpath:/NoPackage.xtend");
		helper.assertNoError(xtendFile, IssueCodes.WRONG_PACKAGE);
		helper.assertNoError(xtendFile, IssueCodes.WRONG_FILE);
	}
	
	protected XtendFile loadExampleXtendFile() {
		final String uri = "classpath:/test/Foo.xtend";
		return loadXtendFile(uri);
	}

	protected XtendFile loadXtendFile(final String uri) {
		XtextResourceSet resourceSet = new XtextResourceSet();
		resourceSet.setClasspathURIContext(this);
		URI classpathURI = URI.createURI(uri);
		URI normalizedURI = resourceSet.getURIConverter().normalize(classpathURI);
		Resource resource = resourceSet.getResource(normalizedURI, true);
		return (XtendFile) resource.getContents().get(0);
	}
}
