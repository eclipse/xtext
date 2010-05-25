/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtend.validation;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator.DiagnosticImpl;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.xtend.TreeTestLanguageRuntimeModule;
import org.eclipse.xtext.xtend.TreeTestLanguageStandaloneSetup;
import org.eclipse.xtext.xtend.treeXtendTestLanguage.TreeXtendTestLanguagePackage;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class CheckValidatorTest extends AbstractXtextTests {

	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(new TreeTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new TreeTestLanguageRuntimeModule());
			}
		});
	}
	
	public void testErrorValidation() throws Exception {
		EObject model = getModel("foo ('A') { a('A'){}; b('A'){}; c('A'){}; d('A'){}; e('A'){}; };");
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(model);
		assertEquals(diagnostic.toString(), 1, diagnostic.getChildren().size());
		diagnostic = diagnostic.getChildren().get(0);
		assertEquals(TreeXtendTestLanguagePackage.NODE__CHILDREN, diagnostic.getData().get(1));
		assertTrue(diagnostic.getSeverity() == Diagnostic.ERROR);
	}

	public void testWarningValidation() throws Exception {
		EObject model = getModel("foo ('A') { a('A'){}; b('A'){}; c('A'){}; };");
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(model);
		assertEquals(diagnostic.toString(), 1, diagnostic.getChildren().size());
		diagnostic = diagnostic.getChildren().get(0);
		assertEquals(1,diagnostic.getData().size()); // no feature
		assertTrue(diagnostic.getSeverity() == Diagnostic.WARNING);
	}
	
	public void testCheckTypeFastValidation() throws Exception {
		EObject model = getModel("FOO ('A') { };");
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(model);
		assertEquals(diagnostic.toString(), 1, diagnostic.getChildren().size());
		diagnostic = diagnostic.getChildren().get(0);
		assertTrue(diagnostic instanceof DiagnosticImpl);
		DiagnosticImpl diagnosticImpl = (DiagnosticImpl) diagnostic;
		assertEquals(CheckType.FAST, diagnosticImpl.getCheckType());
	}
	
	public void testCheckTypeNormalValidation() throws Exception {
		EObject model = getModel("foo ('A') { a('A'){}; b('A'){}; c('A'){}; };");
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(model);
		assertEquals(diagnostic.toString(), 1, diagnostic.getChildren().size());
		diagnostic = diagnostic.getChildren().get(0);
		assertTrue(diagnostic instanceof DiagnosticImpl);
		DiagnosticImpl diagnosticImpl = (DiagnosticImpl) diagnostic;
		assertEquals(CheckType.NORMAL, diagnosticImpl.getCheckType());
	}
	
	public void testCheckTypeExpensiveValidation() throws Exception {
		EObject model = getModel("bar ('A') {  };");
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(model);
		assertEquals(diagnostic.toString(), 1, diagnostic.getChildren().size());
		diagnostic = diagnostic.getChildren().get(0);
		assertTrue(diagnostic instanceof DiagnosticImpl);
		DiagnosticImpl diagnosticImpl = (DiagnosticImpl) diagnostic;
		assertEquals(CheckType.EXPENSIVE, diagnosticImpl.getCheckType());
	}

}
