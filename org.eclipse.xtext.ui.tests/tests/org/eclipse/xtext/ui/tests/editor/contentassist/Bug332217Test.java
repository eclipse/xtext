/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractContentAssistTest;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.tests.Bug332217TestLanguageUiInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@InjectWith(Bug332217TestLanguageUiInjectorProvider.class)
@RunWith(XtextRunner.class)
public class Bug332217Test extends AbstractContentAssistTest {
	
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
