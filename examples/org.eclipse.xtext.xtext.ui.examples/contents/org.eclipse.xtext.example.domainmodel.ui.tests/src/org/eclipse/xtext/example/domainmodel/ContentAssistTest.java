/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.example.DomainmodelRuntimeModule;
import org.eclipse.xtext.example.DomainmodelStandaloneSetup;
import org.eclipse.xtext.example.ui.DomainmodelUiModule;
import org.eclipse.xtext.example.ui.internal.DomainmodelActivator;
import org.eclipse.xtext.ui.junit.editor.contentassist.AbstractContentAssistProcessorTest;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ContentAssistTest extends AbstractContentAssistProcessorTest {

	public ISetup getSetup() {
		return new DomainmodelStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(Modules2.mixin(
						new DomainmodelRuntimeModule(),
						new DomainmodelUiModule(DomainmodelActivator.getInstance()), 
						new SharedStateModule()));
			}
		};
	}

	public void testContentAssist() throws Exception {
		newBuilder(getSetup()).append(
				"entity X {}\n" +
				"entity Y extends X {}").assertTextAtCursorPosition("extends", 1, "extends");
	}
	
}
