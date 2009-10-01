/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.ui.common.editor.contentassist.Bug291022TestLanguageStandaloneSetup;
import org.eclipse.xtext.ui.common.service.UIPluginModule;
import org.eclipse.xtext.ui.common.tests.Activator;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug291022Test extends AbstractContentAssistProcessorTest {

	public ISetup getBug291022TestLanguageSetup() {
		return new Bug291022TestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new Bug291022TestLanguageUiModule(), new UIPluginModule(Activator
						.getInstance()));
			}
		};
	}

	public void testBug291022_01() throws Exception {
		newBuilder(getBug291022TestLanguageSetup()).append(
				"rootModelElement {\n" +
				"  rootModelElement modelElement {" +
				"  }\n" + 
				"}").assertTextAtCursorPosition("modelElement {", "rootModelElement", ":", "=", ";", "{");
	}
	
	public void testBug291022_02() throws Exception {
		newBuilder(getBug291022TestLanguageSetup()).append(
				"rootModelElement {\n" +
				"  rootModelElement : modelElement {" +
				"    modelElement findMe {" +
				"    }\n" +
				"  }\n" + 
				"}").assertTextAtCursorPosition("findMe", "modelElement", ":", "=", ";", "{");
	}
}