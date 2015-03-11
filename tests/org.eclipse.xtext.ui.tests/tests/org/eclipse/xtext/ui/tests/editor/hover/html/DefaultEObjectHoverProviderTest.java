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
import org.eclipse.jface.internal.text.html.BrowserInformationControlInput;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.TestLanguageRuntimeModule;
import org.eclipse.xtext.ui.tests.foo.File;
import org.eclipse.xtext.ui.tests.parser.keywords.KeywordsUiTestLanguageStandaloneSetup;
import org.eclipse.xtext.ui.tests.ui.TestLanguageUiModule;
import org.eclipse.xtext.util.Modules2;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Christoph Kulla - Initial contribution and API
 */
public class DefaultEObjectHoverProviderTest extends AbstractXtextTests {

	public ISetup getTestLanguageSetup(final IEObjectDocumentationProvider ieObjectDocumentationProvider) {
		return new KeywordsUiTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(Modules2.mixin(
						new TestLanguageRuntimeModule(),
						new TestModule(Activator.getInstance(),ieObjectDocumentationProvider),
						new SharedStateModule()));
			}
		};
	}
	
	static class TestModule extends TestLanguageUiModule {

		private IEObjectDocumentationProvider provider;

		public TestModule(AbstractUIPlugin plugin, final IEObjectDocumentationProvider provider) {
			super(plugin);
			this.provider = provider;
		}
		public IEObjectDocumentationProvider bindIEObjectDocumentationProvider() {
			return provider;		
		}
	}
	
	@Test public void testElementHasNoDocumentation () throws Exception {
		with(getTestLanguageSetup(new IEObjectDocumentationProvider() {			
			@Override
			public String getDocumentation(EObject o) {
				return null;
			}
		}));
		File f = (File) getModel ("stuff test");
		DefaultEObjectHoverProvider cut = get(DefaultEObjectHoverProvider.class);
		assertTrue(getHtml(f.getStuff().get(0), cut).contains("Stuff <b>test</b>"));
	}

	protected String getHtml(EObject obj, DefaultEObjectHoverProvider cut) {
		return ((BrowserInformationControlInput)cut.getHoverInfo(obj,null,null).getInfo()).getHtml();
	}
	
	@Test public void testElementHasDocumentation () throws Exception {
		with(getTestLanguageSetup(new IEObjectDocumentationProvider() {			
			@Override
			public String getDocumentation(EObject o) {
				return "Test";
			}
		}));
		File f = (File) getModel ("stuff test");
		DefaultEObjectHoverProvider cut = get(DefaultEObjectHoverProvider.class);
		assertTrue(getHtml(f.getStuff().get(0), cut).contains("Stuff <b>test</b><p>Test</p>"));
	}
	
}
