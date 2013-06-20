/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.ecore.EcoreRuntimeModule;
import org.eclipse.xtext.junit4.ui.AbstractContentAssistProcessorTest;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.generic.GenericResourceServiceProvider;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.Bug287941TestLanguageUiModule;
import org.eclipse.xtext.util.Modules2;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug287941Test extends AbstractContentAssistProcessorTest {
	
	private GenericResourceServiceProvider getEmfServiceProvider() {
		Injector injector = Guice.createInjector(new EcoreRuntimeModule());
		return injector.getInstance(GenericResourceServiceProvider.class);
	}

	@Override
	public ISetup doGetSetup() {
		IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", getEmfServiceProvider());
		return new Bug287941TestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(Modules2.mixin(new Bug287941TestLanguageRuntimeModule(), 
						new Bug287941TestLanguageUiModule(Activator
						.getInstance()), new SharedStateModule()));
			}
		};
	}

	@Test public void testBug287941_01() throws Exception {
		newBuilder().append(
				"import \"classpath:/org/eclipse/xtext/ui/tests/editor/contentassist/Bug287941TestModel.ecore\"\n"
						+ "select t from Test as t \n" + "	where t. testAttr like \"\"").assertTextAtCursorPosition(
				"t. testAttr", 3, "testAttr", "testRef");
	}

	@Test public void testBug287941_02() throws Exception {
		newBuilder().append(
				"import \"classpath:/org/eclipse/xtext/ui/tests/editor/contentassist/Bug287941TestModel.ecore\"\n"
						+ "select t from Test as t \n" + "	where t.testAttr like \"\"").assertTextAtCursorPosition(
				"t.testAttr", 2, "testAttr", "testRef", ".");
	}
	
	@Test public void testBug309449() throws Exception {
		newBuilder().append(
				"import \"classpath:/org/eclipse/xtext/ui/tests/editor/contentassist/Bug287941TestModel.ecore\"\n"
			  + "select t from Test as t \n" 
			  + "	where t.testAttr like \"\"").assertTextAtCursorPosition(
				"like", 0, "<", ">", "<=", ">=", "=", "!=", "like", "notlike", "not", "in");
	}

}
