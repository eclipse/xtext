/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.xtext.linking.ImportUriTestLanguageRuntimeModule;
import org.eclipse.xtext.linking.ImportUriTestLanguageStandaloneSetup;
import org.eclipse.xtext.linking.importedURI.ImportedURIPackage;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ImportUriValidatorTest extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(createStandaloneSetup());
	}
	
	@Test public void testValidURI() throws Exception {
		String model = "import 'classpath:/org/eclipse/xtext/linking/ImportUriTestLanguage.xtext'";
		Resource resource = getResourceFromString(model);
		Diagnostic diagnostics = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertEquals(Diagnostic.OK, diagnostics.getSeverity());
	}
	
	@Test public void testInvalidURI() throws Exception {
		String model = "import 'classpath:/org/eclipse/xtext/linking/ImportUriTestLanguage.unknown'";
		Resource resource = getResourceFromString(model);
		Diagnostic diagnostics = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertEquals(Diagnostic.ERROR, diagnostics.getSeverity());
	}
	
	/**
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=385620
	 */
	@Test public void emptyImportURIStringShouldBeInvalid() throws Exception {
		String model = "import ''";
		Resource resource = getResourceFromString(model);
		Diagnostic diagnostics = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertEquals(Diagnostic.ERROR, diagnostics.getSeverity());
	}
	
	@ComposedChecks(validators=ImportUriValidator.class)
	public static class Validator extends AbstractDeclarativeValidator {
		
		@Override
		protected List<EPackage> getEPackages() {
			return Collections.<EPackage>singletonList(ImportedURIPackage.eINSTANCE);
		}
		
	}
	
	protected ImportUriTestLanguageStandaloneSetup createStandaloneSetup() {
		return new ImportUriTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new ImportUriTestLanguageRuntimeModule() {
					
					@Override
					public void configure(Binder binder) {
						super.configure(binder);
						binder.bind(Validator.class).asEagerSingleton();
					}
					
				});
			}
		};
	}
}
