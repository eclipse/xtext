/*******************************************************************************
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.tests.Bug381381TestLanguageUiInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@InjectWith(Bug381381TestLanguageUiInjectorProvider.class)
@RunWith(XtextRunner.class)
public class Bug381381Test extends AbstractContentAssistTest {
	
	@Test 
	public void testEmpty() throws Exception {
		newBuilder().assertText("FIELD-NAME-TO-VARIABLE");
	}
	
	@Test 
	public void testComma_01() throws Exception {
		newBuilder().append("FIELD-NAME-TO-VARIABLE ").assertText(",");
	}
	@Test 
	public void testComma_02() throws Exception {
		newBuilder().append("FIELD-NAME-TO-VARIABLE,SCREEN=(1,1) ").assertText(",");
	}
	@Test 
	public void testComma_03() throws Exception {
		newBuilder().append("FIELD-NAME-TO-VARIABLE,VAR=name ").assertText(",");
	}
	@Test 
	public void testComma_04() throws Exception {
		newBuilder().append("FIELD-NAME-TO-VARIABLE,TYPE=REPLACE ").assertText(",");
	}
	@Test 
	public void testComma_05() throws Exception {
		newBuilder().append("FIELD-NAME-TO-VARIABLE,SCREEN=(1,1),VAR=name ").assertText(",");
	}
	@Test 
	public void testComma_06() throws Exception {
		newBuilder().append("FIELD-NAME-TO-VARIABLE,VAR=name,SCREEN=(1,1) ").assertText(",");
	}
	@Test 
	public void testComma_07() throws Exception {
		newBuilder().append("FIELD-NAME-TO-VARIABLE,TYPE=REPLACE,VAR=name ").assertText(",");
	}
	@Test 
	public void testComma_08() throws Exception {
		newBuilder().append("FIELD-NAME-TO-VARIABLE,TYPE=REPLACE,SCREEN=(1,1) ").assertText(",");
	}
	@Test 
	public void testComma_09() throws Exception {
		newBuilder().append("FIELD-NAME-TO-VARIABLE,SCREEN=(1,1),TYPE=REPLACE ").assertText(",");
	}
	@Test 
	public void testComma_10() throws Exception {
		newBuilder().append("FIELD-NAME-TO-VARIABLE,VAR=name,TYPE=REPLACE ").assertText(",");
	}
	
	@Test 
	public void testComma_ScreenVarType() throws Exception {
		newBuilder().append("FIELD-NAME-TO-VARIABLE, ").assertText("SCREEN", "VAR", "TYPE");
	}
	@Test 
	public void testComma_VarType() throws Exception {
		newBuilder().append("FIELD-NAME-TO-VARIABLE,SCREEN=(1,1), ").assertText("VAR", "TYPE");
	}
	@Test 
	public void testComma_ScreenType() throws Exception {
		newBuilder().append("FIELD-NAME-TO-VARIABLE,VAR=name, ").assertText("SCREEN", "TYPE");
	}
	@Test 
	public void testComma_ScreenVAr() throws Exception {
		newBuilder().append("FIELD-NAME-TO-VARIABLE,TYPE=REPLACE, ").assertText("SCREEN", "VAR");
	}
	@Test 
	public void testComma_Type_01() throws Exception {
		newBuilder().append("FIELD-NAME-TO-VARIABLE,SCREEN=(1,1),VAR=name, ").assertText("TYPE");
	}
	@Test 
	public void testComma_Type_02() throws Exception {
		newBuilder().append("FIELD-NAME-TO-VARIABLE,VAR=name,SCREEN=(1,1), ").assertText("TYPE");
	}
	@Test 
	public void testComma_Screen_01() throws Exception {
		newBuilder().append("FIELD-NAME-TO-VARIABLE,TYPE=REPLACE,VAR=name, ").assertText("SCREEN");
	}
	@Test 
	public void testComma_Screen_02() throws Exception {
		newBuilder().append("FIELD-NAME-TO-VARIABLE,VAR=name,TYPE=REPLACE, ").assertText("SCREEN");
	}
	@Test 
	public void testComma_Var_01() throws Exception {
		newBuilder().append("FIELD-NAME-TO-VARIABLE,TYPE=REPLACE,SCREEN=(1,1), ").assertText("VAR");
	}
	@Test 
	public void testComma_Var_02() throws Exception {
		newBuilder().append("FIELD-NAME-TO-VARIABLE,SCREEN=(1,1),TYPE=REPLACE, ").assertText("VAR");
	}
	
	@Test 
	public void testAssignScreen_01() throws Exception {
		newBuilder().append("FIELD-NAME-TO-VARIABLE,SCREEN ").assertText("=");
	}
	@Test 
	public void testAssignScreen_02() throws Exception {
		newBuilder().append("FIELD-NAME-TO-VARIABLE,VAR=name,SCREEN ").assertText("=");
	}
	@Test 
	public void testAssignScreen_03() throws Exception {
		newBuilder().append("FIELD-NAME-TO-VARIABLE,TYPE=REPLACE,SCREEN ").assertText("=");
	}
	@Test 
	public void testAssignScreen_04() throws Exception {
		newBuilder().append("FIELD-NAME-TO-VARIABLE,VAR=name,TYPE=REPLACE,SCREEN ").assertText("=");
	}
	@Test 
	public void testAssignScreen_05() throws Exception {
		newBuilder().append("FIELD-NAME-TO-VARIABLE,TYPE=REPLACE,VAR=name,SCREEN ").assertText("=");
	}
	@Test 
	public void testAssignType_01() throws Exception {
		newBuilder().append("FIELD-NAME-TO-VARIABLE,TYPE ").assertText("=");
	}
	@Test 
	public void testAssignType_02() throws Exception {
		newBuilder().append("FIELD-NAME-TO-VARIABLE,SCREEN=(1,1),TYPE ").assertText("=");
	}
	@Test 
	public void testAssignType_03() throws Exception {
		newBuilder().append("FIELD-NAME-TO-VARIABLE,VAR=name,TYPE ").assertText("=");
	}
	@Test 
	public void testAssignType_04() throws Exception {
		newBuilder().append("FIELD-NAME-TO-VARIABLE,VAR=name,SCREEN=(1,1),TYPE ").assertText("=");
	}
	@Test 
	public void testAssignType_05() throws Exception {
		newBuilder().append("FIELD-NAME-TO-VARIABLE,SCREEN=(1,1),VAR=name,TYPE ").assertText("=");
	}
	@Test 
	public void testAssignVar_01() throws Exception {
		newBuilder().append("FIELD-NAME-TO-VARIABLE,VAR ").assertText("=");
	}
	@Test 
	public void testAssignVar_02() throws Exception {
		newBuilder().append("FIELD-NAME-TO-VARIABLE,SCREEN=(1,1),VAR ").assertText("=");
	}
	@Test 
	public void testAssignVar_03() throws Exception {
		newBuilder().append("FIELD-NAME-TO-VARIABLE,TYPE=REPLACE,VAR ").assertText("=");
	}
	@Test 
	public void testAssignVar_04() throws Exception {
		newBuilder().append("FIELD-NAME-TO-VARIABLE,TYPE=REPLACE,SCREEN=(1,1),VAR ").assertText("=");
	}
	@Test 
	public void testAssignVar_05() throws Exception {
		newBuilder().append("FIELD-NAME-TO-VARIABLE,SCREEN=(1,1),TYPE=REPLACE,VAR ").assertText("=");
	}
}
