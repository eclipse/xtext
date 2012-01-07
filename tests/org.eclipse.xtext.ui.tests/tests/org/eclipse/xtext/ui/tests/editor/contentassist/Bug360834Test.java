/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.junit4.ui.AbstractContentAssistProcessorTest;
import org.eclipse.xtext.junit4.ui.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.Bug360834TestLanguageUiModule;
import org.eclipse.xtext.util.Modules2;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug360834Test extends AbstractContentAssistProcessorTest {

	@Override
	public ISetup doGetSetup() {
		return new Bug360834TestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(Modules2.mixin(new Bug360834TestLanguageRuntimeModule(), 
						new Bug360834TestLanguageUiModule(Activator.getInstance()), new SharedStateModule()));
			}
		};
	}
	
	@Test public void testEmptyDocument() throws Exception {
		newBuilder().assertText(
				"alternative", "unordered");
	}
	
	@Test public void testAlternative_package() throws Exception {
		newBuilder("alternative").assertText(
				"package");
	}
	
	@Test public void testAlternative_ClassModifiers() throws Exception {
		newBuilder("alternative package zonk;").assertText(
				"abstract", "final",
				"extern",
				"public", "protected", "private",
				"class");
	}
	
	@Test public void testAlternative_Class() throws Exception {
		newBuilder("alternative package zonk; class ").assertText(
				"Name");
	}
	
	@Test public void testAlternative_Visibility() throws Exception {
		newBuilder("alternative package zonk; protected ").assertText(
				"class");
	}
	
	@Test public void testUnordered_package() throws Exception {
		newBuilder("unordered").assertText(
				"package");
	}
	
	@Test public void testUnordered_ClassModifiers() throws Exception {
		newBuilder("unordered package zonk;").assertText(
				"abstract", "final",
				"extern",
				"public", "protected", "private",
				"class");
	}
	
	@Test public void testUnordered_Class() throws Exception {
		newBuilder("unordered package zonk; class ").assertText(
				"Name");
	}
	
	@Test public void testUnordered_Visibility_01() throws Exception {
		newBuilder("unordered package zonk; protected ").assertText(
				"class",
				"abstract", "final", "extern");
	}
	
	@Test public void testUnordered_Visibility_02() throws Exception {
		newBuilder("unordered package zonk; protected abstract ").assertText(
				"class",
				"final", "extern");
	}
	
	@Test public void testUnordered_Visibility_03() throws Exception {
		newBuilder("unordered package zonk; protected abstract final ").assertText(
				"class",
				"extern");
	}
	
	public ContentAssistProcessorTestBuilder newBuilder(String initial) throws Exception {
		return newBuilder().appendNl(initial);
	}

}
