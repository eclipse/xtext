/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.ui.junit.editor.contentassist.AbstractContentAssistProcessorTest;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.Bug307519TestLanguageUiModule;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug307519Test extends AbstractContentAssistProcessorTest {
	
	public ISetup getSetup() {
		return new Bug307519TestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(
						Modules2.mixin(
								new Bug307519TestLanguageRuntimeModule(), 
								new Bug307519TestLanguageUiModule(Activator.getInstance()), 
								new SharedStateModule()));
			}
		};
	}
	
	public void testEmptyModel() throws Exception {
		newBuilder(getSetup()).assertText("T1", "T2");
	}
	
	public void testAfterT1() throws Exception {
		newBuilder(getSetup())
			.appendNl("T1")
			.assertText("T1", "T2", "foo");
	}
	
	public void testAfterT2() throws Exception {
		newBuilder(getSetup())
			.appendNl("T2")
			.assertText("T1", "T2", "foo");
	}
	
}