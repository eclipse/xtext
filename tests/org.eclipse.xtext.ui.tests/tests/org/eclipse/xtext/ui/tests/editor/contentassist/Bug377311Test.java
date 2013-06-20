/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.junit4.ui.AbstractContentAssistProcessorTest;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.Bug377311TestLanguageUiModule;
import org.eclipse.xtext.util.Modules2;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class Bug377311Test extends AbstractContentAssistProcessorTest {

	@Override
	protected ISetup doGetSetup() {
		return new Bug377311TestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(Modules2.mixin(new Bug377311TestLanguageRuntimeModule(), new Bug377311TestLanguageUiModule(Activator
						.getInstance()), new SharedStateModule()));
			}
		};
	}
	@Test public void testBug377311_01() throws Exception {
		newBuilder().appendNl("child 'Foo' \n").assertText("child");
	}
}
