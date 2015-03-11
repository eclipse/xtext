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
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.Bug381381TestLanguageUiModule;
import org.eclipse.xtext.util.Modules2;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug381381Test extends AbstractContentAssistProcessorTest {

	@Override
	protected ISetup doGetSetup() {
		return new Bug381381TestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(Modules2.mixin(new Bug381381TestLanguageRuntimeModule(), new Bug381381TestLanguageUiModule(Activator
						.getInstance()), new SharedStateModule()));
			}
		};
	}
	
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
