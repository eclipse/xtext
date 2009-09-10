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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EValidator.Registry;
import org.eclipse.xtext.XtextGrammarTestLanguageStandaloneSetup;
import org.eclipse.xtext.XtextGrammarTestLanguageUiModule;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.concurrent.IStateAccess;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.common.service.UIPluginModule;
import org.eclipse.xtext.ui.common.tests.Activator;
import org.eclipse.xtext.ui.core.editor.validation.DefaultValidationJobFactory;
import org.eclipse.xtext.ui.core.editor.validation.ValidationJob;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.xtextTest.Grammar;
import org.eclipse.xtext.xtextTest.XtextTestPackage;

import com.google.common.collect.Maps;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ValidationJobFactoryTest extends AbstractXtextTests {

	private Registry validatorRegistry;

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
	}
	
	@Override
	protected void tearDown() throws Exception {
		validatorRegistry = null;
		super.tearDown();
	}
	
	public void testBug_286114() throws Exception {
		final XtextResource resource = getResourceFromString("grammar org.foo.bar terminal ZONK: 'a';");
		IStateAccess<XtextResource> resourceAccess = new IStateAccess.AbstractImpl<XtextResource>() {
			@Override
			protected XtextResource getState() {
				return resource;
			}
		};
		validatorRegistry.put(XtextTestPackage.eINSTANCE, new Bug286114Validator());
		ValidationJob job = get(Bug286114ValidationJobFactory.class).create(resourceAccess, null, CheckMode.ALL, true);
		List<Map<String,Object>> issues = job.createIssues(new NullProgressMonitor());
		assertTrue(issues.toString(), issues.isEmpty());
	}
	
	public class Bug286114Validator extends AbstractDeclarativeValidator {
		@Check
		protected void create101Errors(Grammar grammar) {
			assertEquals("Message", grammar, XtextPackage.GRAMMAR__NAME, "TEST_VALUE", getContext().get("TEST_KEY"));
		}
	}
	
	public static class Bug286114ValidationJobFactory extends DefaultValidationJobFactory {
		@Override
		public ValidationJob create(IStateAccess<XtextResource> xtextDocument, IFile iFile, CheckMode checkMode,
				boolean deleteOldMarkers) {
			return new ValidationJob(getXtextResourceChecker(), xtextDocument, iFile, checkMode, deleteOldMarkers) {
				@Override
				protected Map<Object, Object> getValidationContext() {
					Map<Object, Object> result = Maps.newHashMap(super.getValidationContext());
					result.put("TEST_KEY", "TEST_VALUE");
					return result;
				}
			};
		}
	}
}
