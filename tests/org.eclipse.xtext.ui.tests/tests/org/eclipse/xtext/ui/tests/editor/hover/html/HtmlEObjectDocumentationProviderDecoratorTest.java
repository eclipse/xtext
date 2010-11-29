/*******************************************************************************
 * Copyright (c) 2010 Christoph Kulla
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Christoph Kulla - Initial API and implementation
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.hover.html;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.ui.editor.hover.html.HtmlEObjectDocumentationProviderDecorator;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.TestLanguageRuntimeModule;
import org.eclipse.xtext.ui.tests.foo.File;
import org.eclipse.xtext.ui.tests.parser.keywords.KeywordsUiTestLanguageStandaloneSetup;
import org.eclipse.xtext.ui.tests.ui.TestLanguageUiModule;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Names;

/**
 * @author Christoph Kulla - Initial contribution and API
 */
public class HtmlEObjectDocumentationProviderDecoratorTest extends AbstractXtextTests {

	public ISetup getTestLanguageSetup(final IEObjectDocumentationProvider ieObjectDocumentationProvider) {
		return new KeywordsUiTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(Modules2.mixin(
						new TestLanguageRuntimeModule(),
						new TestLanguageUiModule(Activator.getInstance()) {
							@Override
							public void configureDefaultHtmlEObjectDocumentationProvider(Binder binder) {
								binder.bind(IEObjectDocumentationProvider.class).annotatedWith
								(Names.named(HtmlEObjectDocumentationProviderDecorator.DELEGATE))
								.toInstance(ieObjectDocumentationProvider);		
							}							
						},
						new SharedStateModule()));
			}
		};
	}
	
	public void testElementHasNoDocumentation () throws Exception {
		with(getTestLanguageSetup(new IEObjectDocumentationProvider() {			
			public String getDocumentation(EObject o) {
				return null;
			}
		}));
		File f = (File) getModel ("stuff test");
		HtmlEObjectDocumentationProviderDecorator cut = get(HtmlEObjectDocumentationProviderDecorator.class);
		assertEquals ("Stuff <b>test</b>", cut.getDocumentation(f.getStuff().get(0)));
	}
	
	public void testElementHasDocumentation () throws Exception {
		with(getTestLanguageSetup(new IEObjectDocumentationProvider() {			
			public String getDocumentation(EObject o) {
				return "Test";
			}
		}));
		File f = (File) getModel ("stuff test");
		HtmlEObjectDocumentationProviderDecorator cut = get(HtmlEObjectDocumentationProviderDecorator.class);
		assertEquals ("Stuff <b>test</b><p>Test</p>", cut.getDocumentation(f.getStuff().get(0)));
	}
	
}
