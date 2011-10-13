/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import junit.framework.Test;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.ui.junit.editor.contentassist.AbstractContentAssistProcessorTest;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.Bug291022TestLanguageUiModule;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug291022Test extends AbstractContentAssistProcessorTest {

	@Override
	public ISetup doGetSetup() {
		return new Bug291022TestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(Modules2.mixin(new Bug291022TestLanguageRuntimeModule(), new Bug291022TestLanguageUiModule(Activator
						.getInstance()), new SharedStateModule()));
			}
		};
	}

	public void testBug291022_01() throws Exception {
		newBuilder().append(
				"rootModelElement {\n" +
				"  rootModelElement modelElement {" +
				"  }\n" + 
				"}").assertTextAtCursorPosition("modelElement {", "rootModelElement", ":", "=", ";", "{");
	}
	
	public void testBug291022_02() throws Exception {
		newBuilder().append(
				"rootModelElement {\n" +
				"  rootModelElement : modelElement {" +
				"    modelElement findMe {" +
				"    }\n" +
				"  }\n" + 
				"}").assertTextAtCursorPosition("findMe", "modelElement", ":", "=", ";", "{");
	}

	public static Test suite() {
		return AbstractContentAssistProcessorTest.suite(Bug291022Test.class);
	}
}