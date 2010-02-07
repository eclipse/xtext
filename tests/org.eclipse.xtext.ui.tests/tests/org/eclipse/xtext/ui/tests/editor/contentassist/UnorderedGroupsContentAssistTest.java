/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.ui.UIPluginModule;
import org.eclipse.xtext.ui.junit.editor.contentassist.AbstractContentAssistProcessorTest;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.UnorderedGroupsTestLanguageUiModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class UnorderedGroupsContentAssistTest extends AbstractContentAssistProcessorTest {

	public ISetup getSetup() {
		return new UnorderedGroupsTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new UnorderedGroupsTestLanguageUiModule(), new UIPluginModule(Activator.getInstance()));
			}
		};
	}
	
	public void testCompleteEmptyModel() throws Exception {
		newBuilder(getSetup())
			.assertText(
					"public",
					"protected",
					"private",
					"synchronized",
					"abstract",
					"final",
					"static",
					"class"
			);
	}
	
	// FIXME
	public void testAfterVisibility() throws Exception {
		newBuilder(getSetup())
			.appendNl("public")
			.assertText(
					"public",
					"protected",
					"private",
					"synchronized",
					"abstract",
					"final",
					"static",
					"class"
			);
	}
	
	// FIXME
	public void testAfterStatic() throws Exception {
		newBuilder(getSetup())
			.appendNl("static")
			.assertText(
					"public",
					"protected",
					"private",
					"synchronized",
					"abstract",
					"final",
					"static",
					"class"
			);
	}
	
	// FIXME
	public void testAfterPrivateFinal() throws Exception {
		newBuilder(getSetup())
			.appendNl("private final")
			.assertText(
					"public",
					"protected",
					"private",
					"synchronized",
					"abstract",
					"final",
					"static",
					"class"
			);
	}
	
	// FIXME
	public void testAfterStaticSynchronizedProtectedAbstract() throws Exception {
		newBuilder(getSetup())
			.appendNl("static synchronized protected abstract")
			.assertText(
					"public",
					"protected",
					"private",
					"synchronized",
					"abstract",
					"final",
					"static",
					"class"
			);
	}
}
