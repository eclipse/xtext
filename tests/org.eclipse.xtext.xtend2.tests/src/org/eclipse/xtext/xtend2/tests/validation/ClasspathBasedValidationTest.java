/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.validation;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.junit.GlobalRegistries;
import org.eclipse.xtext.junit.GlobalRegistries.GlobalStateMemento;
import org.eclipse.xtext.junit.validation.ValidationTestHelper;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xtend2.Xtend2RuntimeModule;
import org.eclipse.xtext.xtend2.Xtend2StandaloneSetup;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;
import org.eclipse.xtext.xtend2.validation.IssueCodes;
import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ClasspathBasedValidationTest extends TestCase {
	
	private Injector injector;

	@Inject
	protected ValidationTestHelper helper;

	private GlobalStateMemento memento;
	
	@Override
	protected void setUp() throws Exception {
		memento = GlobalRegistries.makeCopyOfGlobalState();
		GlobalRegistries.clearGlobalRegistries();
		injector = new Xtend2StandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new Xtend2RuntimeModule() {
					@Override
					public ClassLoader bindClassLoaderToInstance() {
						return AbstractXtend2TestCase.class.getClassLoader();
					}

				});
			}
		}.createInjectorAndDoEMFRegistration();
		injector.injectMembers(this);
	}
	
	@Override
	protected void tearDown() throws Exception {
		memento.restoreGlobalState();
		super.tearDown();
	}

	public void testFileNamingConventions_0() throws Exception {
		XtendFile xtendFile = loadExampleXtendFile();
		helper.assertNoError(xtendFile, IssueCodes.WRONG_PACKAGE);
		helper.assertNoError(xtendFile, IssueCodes.WRONG_FILE);
	}
	
	public void testFileNamingConventions_1() throws Exception {
		XtendFile xtendFile = loadExampleXtendFile();
			xtendFile.getXtendClass().setName("Bar");
		helper.assertNoError(xtendFile, IssueCodes.WRONG_PACKAGE);
		helper.assertError(xtendFile, Xtend2Package.Literals.XTEND_CLASS, IssueCodes.WRONG_FILE);
	}
		
	public void testFileNamingConventions_2() throws Exception {
		XtendFile xtendFile = loadExampleXtendFile();
		Resource resource = xtendFile.eResource();
		URI resourceURI = resource.getURI();
		URI invalidPackageURI = resourceURI.trimSegments(1).appendSegment("invalid").appendSegment(resourceURI.lastSegment());
		resource.setURI(invalidPackageURI);
		helper.assertError(xtendFile, Xtend2Package.Literals.XTEND_FILE, IssueCodes.WRONG_PACKAGE);
		helper.assertNoError(xtendFile, IssueCodes.WRONG_FILE);
	}
	
	public void testFileNamingConventions_3() throws Exception {
		XtendFile xtendFile = loadExampleXtendFile();
		xtendFile.setPackage(null);
		helper.assertError(xtendFile, Xtend2Package.Literals.XTEND_FILE, IssueCodes.WRONG_PACKAGE);
		helper.assertNoError(xtendFile, IssueCodes.WRONG_FILE);
	}
	
	public void testFileNamingConventions_4() throws Exception {
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
