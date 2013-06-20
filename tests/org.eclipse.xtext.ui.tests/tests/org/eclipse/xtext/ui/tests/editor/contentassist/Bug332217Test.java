/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.Bug332217TestLanguageUiModule;
import org.eclipse.xtext.util.Modules2;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug332217Test extends AbstractContentAssistProcessorTest {

	@Override
	public ISetup doGetSetup() {
		return new Bug332217TestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(
						Modules2.mixin(
								new Bug332217TestLanguageRuntimeModule(), 
								new Bug332217TestLanguageUiModule(Activator.getInstance()), 
								new SharedStateModule()));
			}
		};
	}
	
	@Test public void testInString() throws Exception {
		String model =  
				"tableview InventorDetail(Inventor inventor) {\n" + 
				"	title: inventor.name\n" + 
				"	style: Grouped\n" + 
				"\n" + 
				"	section {\n" + 
				"		cell Value2 {\n" + 
				"			text: \"ValueName\"\n" + 
				"			details: inventor.name\n" + 
				"		}\n" + 
				"	}\n" + 
				"";
		newBuilder().append(model).assertTextAtCursorPosition(model.indexOf("\"ValueName\"") + 1, "\"Value\"");
	}

}
