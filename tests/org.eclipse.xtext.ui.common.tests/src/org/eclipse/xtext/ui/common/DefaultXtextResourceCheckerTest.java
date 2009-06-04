/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common;

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EValidator.Registry;
import org.eclipse.xtext.XtextGrammarTestLanguageStandaloneSetup;
import org.eclipse.xtext.XtextGrammarTestLanguageUiModule;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.common.editor.contentassist.DefaultContentAssistContextFactory;
import org.eclipse.xtext.ui.common.service.UIPluginModule;
import org.eclipse.xtext.ui.common.tests.Activator;
import org.eclipse.xtext.ui.core.editor.IXtextResourceChecker;
import org.eclipse.xtext.ui.core.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xtextTest.Grammar;
import org.eclipse.xtext.xtextTest.XtextTestPackage;

import com.google.common.collect.Maps;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DefaultXtextResourceCheckerTest extends AbstractXtextTests {

	private Registry validatorRegistry;
	private IXtextResourceChecker resourceChecker;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(new XtextGrammarTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new XtextGrammarTestLanguageUiModule() {
				}, new UIPluginModule(Activator.getInstance()));
			}
		});
		validatorRegistry = get(EValidator.Registry.class);
		validatorRegistry.put(XtextTestPackage.eINSTANCE, new TestValidator());
		resourceChecker = get(IXtextResourceChecker.class);
	}
	
	@Override
	protected void tearDown() throws Exception {
		validatorRegistry = null;
		resourceChecker = null;
		super.tearDown();
	}
	
	public void testManyErrors() throws Exception {
		XtextResource resource = getResourceFromString("grammar org.foo.bar");
		int errors = resource.getErrors().size();
		assertEquals(1, errors);
		List<Map<String, Object>> markers = resourceChecker.check(resource, Maps.newHashMap(), new NullProgressMonitor());
		assertEquals(errors + 101, markers.size());
	}
	
	public static class TestValidator extends AbstractDeclarativeValidator {
		@Check
		protected void create101Errors(Grammar grammar) {
			for (int i = 0; i < 101; i++) {
				error("Error " + 101, null);
			}
		}
	}
}
