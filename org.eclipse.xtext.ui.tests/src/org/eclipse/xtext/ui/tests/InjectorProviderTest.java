/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.xtext.ui.tests.folding.FoldingPackage;
import org.eclipse.xtext.ui.tests.tests.FoldingTestLanguageInjectorProvider;
import org.eclipse.xtext.ui.tests.ui.tests.FoldingTestLanguageUiInjectorProvider;
import org.eclipse.xtext.validation.CompositeEValidator;
import org.eclipse.xtext.validation.CompositeEValidator.EValidatorEqualitySupport;
import org.junit.Assert;
import org.junit.Test;

import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class InjectorProviderTest {

	private static final String EXTENSION = "foldingtestlanguage";
	
	@Test
	public void testUiTestBetweenTwoRuntimeTests() {
		URI workWithMe = URI.createURI("dummy:/sample." + EXTENSION);
		Assert.assertEquals(EXTENSION, workWithMe.fileExtension());
		
		// the first test is a runtime test
		FoldingTestLanguageInjectorProvider runtime = new FoldingTestLanguageInjectorProvider();
		runtime.setupRegistry();
		Injector runtimeInjector = runtime.getInjector();
		EValidator.Registry runtimeRegistry = runtimeInjector.getInstance(EValidator.Registry.class);
		EValidator validator = runtimeRegistry.getEValidator(FoldingPackage.eINSTANCE);
		runtime.restoreRegistry();
		
		// trigger ui injector initialization from second test case
		FoldingTestLanguageUiInjectorProvider ui = new FoldingTestLanguageUiInjectorProvider();
		Injector uiInjector = ui.getInjector();
		EValidator.Registry uiValidatorRegistry = uiInjector.getInstance(EValidator.Registry.class);
		
		Assert.assertSame(runtimeRegistry, uiValidatorRegistry);
		
		CompositeEValidator uiValidator = (CompositeEValidator) uiValidatorRegistry.getEValidator(FoldingPackage.eINSTANCE);
		List<EValidatorEqualitySupport> validators = new ArrayList<>(uiValidator.getContents());
		Assert.assertNotNull(validator);
		
		// run next runtime test 
		runtime.setupRegistry();
		runtime.restoreRegistry();
		
		// run next ui test and check that we see the correct validator configuration
		
		CompositeEValidator newValidator = (CompositeEValidator) uiValidatorRegistry.getEValidator(FoldingPackage.eINSTANCE);
		Assert.assertEquals(validators, newValidator.getContents());
	}
	
}
