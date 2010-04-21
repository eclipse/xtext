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
import org.eclipse.xtext.ui.junit.editor.contentassist.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.Bug309949TestLanguageUiModule;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug309949Test extends AbstractContentAssistProcessorTest {

	public ISetup getSetup() {
		return new Bug309949TestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(
						Modules2.mixin(
								new Bug309949TestLanguageRuntimeModule(), 
								new Bug309949TestLanguageUiModule(Activator.getInstance()), 
								new SharedStateModule()));
			}
		};
	}
	
	public void testEmptyModel() throws Exception {
		newBuilder().assertText("#1*", "#1+", "#2*", "#2+", "#3*", "#3+", "#4*", "#4+", "#5*", "#5+");
	}
	
	public void testScenario1_Optional_01() throws Exception {
		newBuilder_1_Optional().assertText("@uuid", "error", "operation", "}");
	}
	
	public void testScenario1_Optional_02() throws Exception {
		newBuilder_1_Optional()
			.appendNl("@uuid")
			.assertText("Name");
	}
	
	public void testScenario1_Optional_03() throws Exception {
		newBuilder_1_Optional()
			.appendNl("@uuid Name")
			.assertText("@uuid", "error", "operation");
	}
	
	public void testScenario1_Optional_04() throws Exception {
		newBuilder_1_Optional()
			.appendNl("@uuid Name")
			.appendNl("@uuid")
			.assertText("Name");
	}
	
	public void testScenario1_Optional_05() throws Exception {
		newBuilder_1_Optional()
			.appendNl("@uuid Name")
			.appendNl("@uuid Name")
			.assertText("@uuid", "error", "operation");
	}

	public void testScenario1_Optional_06() throws Exception {
		newBuilder_1_Optional()
			.appendNl("error")
			.assertText("Name");
	}
	
	public void testScenario1_Optional_07() throws Exception {
		newBuilder_1_Optional()
			.appendNl("error Name")
			.assertText("@uuid", "error", "operation", "}");
	}
	
	public void testScenario1_Optional_08() throws Exception {
		newBuilder_1_Optional()
			.appendNl("error Name")
			.appendNl("@uuid Name")
			.assertText("@uuid", "error", "operation");
	}
	
	public void testScenario1_Optional_09() throws Exception {
		newBuilder_1_Optional()
			.appendNl("error Name")
			.appendNl("@uuid Name")
			.appendNl("@uuid Name")
			.assertText("@uuid", "error", "operation");
	}
	
	public void testScenario1_Optional_10() throws Exception {
		newBuilder_1_Optional()
			.appendNl("operation")
			.assertText("Name");
	}
	
	public void testScenario1_Optional_11() throws Exception {
		newBuilder_1_Optional()
			.appendNl("operation Name")
			.assertText("@uuid", "operation", "}");
	}
	
	public void testScenario1_Optional_12() throws Exception {
		newBuilder_1_Optional()
			.appendNl("operation Name")
			.appendNl("@uuid Name")
			.assertText("@uuid", "operation");
	}
	
	public void testScenario1_Optional_13() throws Exception {
		newBuilder_1_Optional()
			.appendNl("operation Name")
			.appendNl("@uuid Name")
			.appendNl("@uuid Name")
			.assertText("@uuid", "operation");
	}
	
	public void testScenario1_Optional_14() throws Exception {
		newBuilder_1_Optional()
			.appendNl("error Name")
			.appendNl("operation Name")
			.assertText("@uuid", "operation", "}");
	}
	
	protected ContentAssistProcessorTestBuilder newBuilder_1_Optional() throws Exception {
		return newBuilder().appendNl("#1* {");
	}
	
	public void testScenario1_Mandatory_01() throws Exception {
		newBuilder_1_Mandatory().assertText("@uuid", "error");
	}
	
	public void testScenario1_Mandatory_02() throws Exception {
		newBuilder_1_Mandatory()
			.appendNl("@uuid")
			.assertText("Name");
	}
	
	public void testScenario1_Mandatory_03() throws Exception {
		newBuilder_1_Mandatory()
			.appendNl("@uuid Name")
			.assertText("@uuid", "error");
	}
	
	public void testScenario1_Mandatory_04() throws Exception {
		newBuilder_1_Mandatory()
			.appendNl("@uuid Name")
			.appendNl("@uuid")
			.assertText("Name");
	}
	
	public void testScenario1_Mandatory_05() throws Exception {
		newBuilder_1_Mandatory()
			.appendNl("@uuid Name")
			.appendNl("@uuid Name")
			.assertText("@uuid", "error");
	}

	public void testScenario1_Mandatory_06() throws Exception {
		newBuilder_1_Mandatory()
			.appendNl("error")
			.assertText("Name");
	}
	
	public void testScenario1_Mandatory_07() throws Exception {
		newBuilder_1_Mandatory()
			.appendNl("error Name")
			.assertText("@uuid", "error", "operation");
	}
	
	public void testScenario1_Mandatory_08() throws Exception {
		newBuilder_1_Mandatory()
			.appendNl("error Name")
			.appendNl("@uuid Name")
			.assertText("@uuid", "error", "operation");
	}
	
	public void testScenario1_Mandatory_09() throws Exception {
		newBuilder_1_Mandatory()
			.appendNl("error Name")
			.appendNl("@uuid Name")
			.appendNl("@uuid Name")
			.assertText("@uuid", "error", "operation");
	}
	
	public void testScenario1_Mandatory_10() throws Exception {
		newBuilder_1_Mandatory()
			.appendNl("error Name")
			.appendNl("operation")
			.assertText("Name");
	}
	
	public void testScenario1_Mandatory_11() throws Exception {
		newBuilder_1_Mandatory()
			.appendNl("error Name")
			.appendNl("operation Name")
			.assertText("@uuid", "operation", "}");
	}
	
	public void testScenario1_Mandatory_12() throws Exception {
		newBuilder_1_Mandatory()
			.appendNl("error Name")
			.appendNl("operation Name")
			.appendNl("@uuid Name")
			.assertText("@uuid", "operation");
	}
	
	public void testScenario1_Mandatory_13() throws Exception {
		newBuilder_1_Mandatory()
			.appendNl("error Name")
			.appendNl("operation Name")
			.appendNl("@uuid Name")
			.appendNl("@uuid Name")
			.assertText("@uuid", "operation");
	}
	
	protected ContentAssistProcessorTestBuilder newBuilder_1_Mandatory() throws Exception {
		return newBuilder().appendNl("#1+ {");
	}

	public void testScenario2_Optional_01() throws Exception {
		newBuilder_2_Optional().assertText("@uuid", "}");
	}
	
	public void testScenario2_Optional_02() throws Exception {
		newBuilder_2_Optional()
		.appendNl("@uuid")
		.assertText("Name");
	}
	
	public void testScenario2_Optional_03() throws Exception {
		newBuilder_2_Optional()
		.appendNl("@uuid Name")
		.assertText("@uuid", "error", "operation");
	}
	
	public void testScenario2_Optional_04() throws Exception {
		newBuilder_2_Optional()
		.appendNl("@uuid Name")
		.appendNl("@uuid")
		.assertText("Name");
	}
	
	public void testScenario2_Optional_05() throws Exception {
		newBuilder_2_Optional()
		.appendNl("@uuid Name")
		.appendNl("@uuid Name")
		.assertText("@uuid", "error", "operation");
	}
	
	public void testScenario2_Optional_06() throws Exception {
		newBuilder_2_Optional()
		.appendNl("@uuid Name")
		.appendNl("error")
		.assertText("Name");
	}
	
	public void testScenario2_Optional_07() throws Exception {
		newBuilder_2_Optional()
		.appendNl("@uuid Name")
		.appendNl("error Name")
		.assertText("@uuid", "}");
	}
	
	public void testScenario2_Optional_08() throws Exception {
		newBuilder_2_Optional()
		.appendNl("@uuid Name")
		.appendNl("error Name")
		.appendNl("@uuid Name")
		.assertText("@uuid", "error", "operation");
	}
	
	public void testScenario2_Optional_09() throws Exception {
		newBuilder_2_Optional()
		.appendNl("@uuid Name")
		.appendNl("error Name")
		.appendNl("@uuid Name")
		.appendNl("@uuid Name")
		.assertText("@uuid", "error", "operation");
	}
	
	public void testScenario2_Optional_10() throws Exception {
		newBuilder_2_Optional()
		.appendNl("@uuid Name")
		.appendNl("operation")
		.assertText("Name");
	}
	
	public void testScenario2_Optional_11() throws Exception {
		newBuilder_2_Optional()
		.appendNl("@uuid Name")
		.appendNl("operation Name")
		.assertText("@uuid", "}");
	}
	
	public void testScenario2_Optional_12() throws Exception {
		newBuilder_2_Optional()
		.appendNl("@uuid Name")
		.appendNl("operation Name")
		.appendNl("@uuid Name")
		.assertText("@uuid", "operation");
	}
	
	public void testScenario2_Optional_13() throws Exception {
		newBuilder_2_Optional()
		.appendNl("@uuid Name")
		.appendNl("operation Name")
		.appendNl("@uuid Name")
		.appendNl("@uuid Name")
		.assertText("@uuid", "operation");
	}
	
	public void testScenario2_Optional_14() throws Exception {
		newBuilder_2_Optional()
		.appendNl("@uuid Name")
		.appendNl("error Name")
		.appendNl("@uuid Name")
		.appendNl("operation Name")
		.assertText("@uuid", "}");
	}
	
	protected ContentAssistProcessorTestBuilder newBuilder_2_Optional() throws Exception {
		return newBuilder().appendNl("#2* {");
	}
	
	public void testScenario2_Mandatory_01() throws Exception {
		newBuilder_2_Mandatory().assertText("@uuid");
	}
	
	public void testScenario2_Mandatory_02() throws Exception {
		newBuilder_2_Mandatory()
		.appendNl("@uuid")
		.assertText("Name");
	}
	
	public void testScenario2_Mandatory_03() throws Exception {
		newBuilder_2_Mandatory()
		.appendNl("@uuid Name")
		.assertText("@uuid", "error");
	}
	
	public void testScenario2_Mandatory_04() throws Exception {
		newBuilder_2_Mandatory()
		.appendNl("@uuid Name")
		.appendNl("@uuid")
		.assertText("Name");
	}
	
	public void testScenario2_Mandatory_05() throws Exception {
		newBuilder_2_Mandatory()
		.appendNl("@uuid Name")
		.appendNl("@uuid Name")
		.assertText("@uuid", "error");
	}
	
	public void testScenario2_Mandatory_06() throws Exception {
		newBuilder_2_Mandatory()
		.appendNl("@uuid Name")
		.appendNl("error")
		.assertText("Name");
	}
	
	public void testScenario2_Mandatory_07() throws Exception {
		newBuilder_2_Mandatory()
		.appendNl("@uuid Name")
		.appendNl("error Name")
		.assertText("@uuid");
	}
	
	public void testScenario2_Mandatory_08() throws Exception {
		newBuilder_2_Mandatory()
		.appendNl("@uuid Name")
		.appendNl("error Name")
		.appendNl("@uuid Name")
		.assertText("@uuid", "error", "operation");
	}
	
	public void testScenario2_Mandatory_09() throws Exception {
		newBuilder_2_Mandatory()
		.appendNl("@uuid Name")
		.appendNl("error Name")
		.appendNl("@uuid Name")
		.appendNl("@uuid Name")
		.assertText("@uuid", "error", "operation");
	}
	
	public void testScenario2_Mandatory_10() throws Exception {
		newBuilder_2_Mandatory()
		.appendNl("@uuid Name")
		.appendNl("error Name")
		.appendNl("@uuid Name")
		.appendNl("operation")
		.assertText("Name");
	}
	
	public void testScenario2_Mandatory_11() throws Exception {
		newBuilder_2_Mandatory()
		.appendNl("@uuid Name")
		.appendNl("error Name")
		.appendNl("@uuid Name")
		.appendNl("operation Name")
		.assertText("@uuid", "}");
	}
	
	public void testScenario2_Mandatory_12() throws Exception {
		newBuilder_2_Mandatory()
		.appendNl("@uuid Name")
		.appendNl("error Name")
		.appendNl("@uuid Name")
		.appendNl("operation Name")
		.appendNl("@uuid Name")
		.assertText("@uuid", "operation");
	}
	
	public void testScenario2_Mandatory_13() throws Exception {
		newBuilder_2_Mandatory()
		.appendNl("@uuid Name")
		.appendNl("error Name")
		.appendNl("@uuid Name")
		.appendNl("operation Name")
		.appendNl("@uuid Name")
		.appendNl("@uuid Name")
		.assertText("@uuid", "operation");
	}
	
	protected ContentAssistProcessorTestBuilder newBuilder_2_Mandatory() throws Exception {
		return newBuilder().appendNl("#2+ {");
	}
	
	public void testScenario3_Optional_01() throws Exception {
		newBuilder_3_Optional().assertText("@uuid", "error", "operation", "}");
	}
	
	public void testScenario3_Optional_02() throws Exception {
		newBuilder_3_Optional()
		.appendNl("@uuid")
		.assertText("Name");
	}
	
	public void testScenario3_Optional_03() throws Exception {
		newBuilder_3_Optional()
		.appendNl("@uuid Name")
		.assertText("error", "operation");
	}
	
	public void testScenario3_Optional_04() throws Exception {
		newBuilder_3_Optional()
		.appendNl("error")
		.assertText("Name");
	}
	
	public void testScenario3_Optional_05() throws Exception {
		newBuilder_3_Optional()
		.appendNl("@uuid Name")
		.appendNl("error")
		.assertText("Name");
	}
	
	public void testScenario3_Optional_06() throws Exception {
		newBuilder_3_Optional()
		.appendNl("@uuid Name")
		.appendNl("error Name")
		.assertText("@uuid", "error", "operation", "}");
	}
	
	public void testScenario3_Optional_07() throws Exception {
		newBuilder_3_Optional()
		.appendNl("@uuid Name")
		.appendNl("error Name")
		.appendNl("@uuid Name")
		.assertText("error", "operation");
	}
	
	public void testScenario3_Optional_08() throws Exception {
		newBuilder_3_Optional()
		.appendNl("@uuid Name")
		.appendNl("operation")
		.assertText("Name");
	}
	
	public void testScenario3_Optional_09() throws Exception {
		newBuilder_3_Optional()
		.appendNl("@uuid Name")
		.appendNl("operation Name")
		.assertText("@uuid", "operation", "}");
	}
	
	public void testScenario3_Optional_10() throws Exception {
		newBuilder_3_Optional()
		.appendNl("@uuid Name")
		.appendNl("operation Name")
		.appendNl("@uuid Name")
		.assertText("operation");
	}
	
	public void testScenario3_Optional_11() throws Exception {
		newBuilder_3_Optional()
		.appendNl("@uuid Name")
		.appendNl("error Name")
		.appendNl("@uuid Name")
		.appendNl("operation Name")
		.assertText("@uuid", "operation", "}");
	}
	
	protected ContentAssistProcessorTestBuilder newBuilder_3_Optional() throws Exception {
		return newBuilder().appendNl("#3* {");
	}
	
	public void testScenario3_Mandatory_01() throws Exception {
		newBuilder_3_Mandatory().assertText("@uuid", "error");
	}
	
	public void testScenario3_Mandatory_02() throws Exception {
		newBuilder_3_Mandatory()
		.appendNl("@uuid")
		.assertText("Name");
	}
	
	public void testScenario3_Mandatory_03() throws Exception {
		newBuilder_3_Mandatory()
		.appendNl("@uuid Name")
		.assertText("error");
	}
	
	public void testScenario3_Mandatory_04() throws Exception {
		newBuilder_3_Mandatory()
		.appendNl("error")
		.assertText("Name");
	}
	
	public void testScenario3_Mandatory_05() throws Exception {
		newBuilder_3_Mandatory()
		.appendNl("@uuid Name")
		.appendNl("error")
		.assertText("Name");
	}
	
	public void testScenario3_Mandatory_06() throws Exception {
		newBuilder_3_Mandatory()
		.appendNl("@uuid Name")
		.appendNl("error Name")
		.assertText("@uuid", "error", "operation");
	}
	
	public void testScenario3_Mandatory_07() throws Exception {
		newBuilder_3_Mandatory()
		.appendNl("@uuid Name")
		.appendNl("error Name")
		.appendNl("@uuid Name")
		.assertText("error", "operation");
	}
	
	public void testScenario3_Mandatory_08() throws Exception {
		newBuilder_3_Mandatory()
		.appendNl("@uuid Name")
		.appendNl("error Name")
		.appendNl("@uuid Name")
		.appendNl("operation")
		.assertText("Name");
	}
	
	public void testScenario3_Mandatory_09() throws Exception {
		newBuilder_3_Mandatory()
		.appendNl("@uuid Name")
		.appendNl("error Name")
		.appendNl("@uuid Name")
		.appendNl("operation Name")
		.assertText("@uuid", "operation", "}");
	}
	
	public void testScenario3_Mandatory_10() throws Exception {
		newBuilder_3_Mandatory()
		.appendNl("@uuid Name")
		.appendNl("error Name")
		.appendNl("@uuid Name")
		.appendNl("operation Name")
		.appendNl("@uuid Name")
		.assertText("operation");
	}
	
	protected ContentAssistProcessorTestBuilder newBuilder_3_Mandatory() throws Exception {
		return newBuilder().appendNl("#3+ {");
	}
	
	public void testScenario4_Optional_01() throws Exception {
		newBuilder_4_Optional().assertText("@uuid", "}");
	}
	
	public void testScenario4_Optional_02() throws Exception {
		newBuilder_4_Optional()
			.appendNl("@uuid")
			.assertText("Name");
	}
	
	public void testScenario4_Optional_03() throws Exception {
		newBuilder_4_Optional()
			.appendNl("@uuid Name")
			.assertText("error", "operation");
	}
	
	public void testScenario4_Optional_04() throws Exception {
		newBuilder_4_Optional()
			.appendNl("@uuid Name")
			.appendNl("error Name")
			.assertText("@uuid", "}");
	}
	
	public void testScenario4_Optional_05() throws Exception {
		newBuilder_4_Optional()
			.appendNl("@uuid Name")
			.appendNl("error Name")
			.appendNl("@uuid Name")
			.assertText("error", "operation");
	}
	
	public void testScenario4_Optional_06() throws Exception {
		newBuilder_4_Optional()
			.appendNl("@uuid Name")
			.appendNl("operation")
			.assertText("Name");
	}
	
	public void testScenario4_Optional_07() throws Exception {
		newBuilder_4_Optional()
			.appendNl("@uuid Name")
			.appendNl("operation Name")
			.assertText("@uuid", "}");
	}
	
	public void testScenario4_Optional_08() throws Exception {
		newBuilder_4_Optional()
			.appendNl("@uuid Name")
			.appendNl("operation Name")
			.appendNl("@uuid Name")
			.assertText("operation");
	}
	
	public void testScenario4_Optional_09() throws Exception {
		newBuilder_4_Optional()
			.appendNl("@uuid Name")
			.appendNl("error Name")
			.appendNl("@uuid Name")
			.appendNl("operation Name")
			.assertText("@uuid", "}");
	}
	
	protected ContentAssistProcessorTestBuilder newBuilder_4_Optional() throws Exception {
		return newBuilder().appendNl("#4* {");
	}
	
	public void testScenario4_Mandatory_01() throws Exception {
		newBuilder_4_Mandatory().assertText("@uuid");
	}
	
	public void testScenario4_Mandatory_02() throws Exception {
		newBuilder_4_Mandatory()
			.appendNl("@uuid")
			.assertText("Name");
	}
	
	public void testScenario4_Mandatory_03() throws Exception {
		newBuilder_4_Mandatory()
			.appendNl("@uuid Name")
			.assertText("error");
	}
	
	public void testScenario4_Mandatory_04() throws Exception {
		newBuilder_4_Mandatory()
			.appendNl("@uuid Name")
			.appendNl("error")
			.assertText("Name");
	}
	
	public void testScenario4_Mandatory_05() throws Exception {
		newBuilder_4_Mandatory()
			.appendNl("@uuid Name")
			.appendNl("error Name")
			.assertText("@uuid");
	}
	
	public void testScenario4_Mandatory_06() throws Exception {
		newBuilder_4_Mandatory()
			.appendNl("@uuid Name")
			.appendNl("error Name")
			.appendNl("@uuid Name")
			.assertText("error", "operation");
	}
	
	public void testScenario4_Mandatory_07() throws Exception {
		newBuilder_4_Mandatory()
			.appendNl("@uuid Name")
			.appendNl("error Name")
			.appendNl("@uuid Name")
			.appendNl("operation")
			.assertText("Name");
	}
	
	public void testScenario4_Mandatory_08() throws Exception {
		newBuilder_4_Mandatory()
			.appendNl("@uuid Name")
			.appendNl("error Name")
			.appendNl("@uuid Name")
			.appendNl("operation Name")
			.assertText("@uuid", "}");
	}
	
	public void testScenario4_Mandatory_09() throws Exception {
		newBuilder_4_Mandatory()
			.appendNl("@uuid Name")
			.appendNl("error Name")
			.appendNl("@uuid Name")
			.appendNl("operation Name")
			.appendNl("@uuid Name")
			.assertText("operation");
	}
	
	protected ContentAssistProcessorTestBuilder newBuilder_4_Mandatory() throws Exception {
		return newBuilder().appendNl("#4+ {");
	}
	
	public void testScenario5_Optional_01() throws Exception {
		newBuilder_5_Optional().assertText("error", "operation", "}");
	}
	
	public void testScenario5_Optional_02() throws Exception {
		newBuilder_5_Optional()
			.appendNl("error")
			.assertText("Name");
	}
	
	public void testScenario5_Optional_03() throws Exception {
		newBuilder_5_Optional()
			.appendNl("error Name")
			.assertText("error", "operation", "}");
	}
	
	public void testScenario5_Optional_04() throws Exception {
		newBuilder_5_Optional()
			.appendNl("operation")
			.assertText("Name");
	}
	
	public void testScenario5_Optional_05() throws Exception {
		newBuilder_5_Optional()
			.appendNl("operation Name")
			.assertText("operation", "}");
	}
	
	public void testScenario5_Optional_06() throws Exception {
		newBuilder_5_Optional()
			.appendNl("error Name")
			.appendNl("operation Name")
			.assertText("operation", "}");
	}
	
	protected ContentAssistProcessorTestBuilder newBuilder_5_Optional() throws Exception {
		return newBuilder().appendNl("#5* {");
	}
	
	public void testScenario5_Mandatory_01() throws Exception {
		newBuilder_5_Mandatory().assertText("error");
	}
	
	public void testScenario5_Mandatory_02() throws Exception {
		newBuilder_5_Mandatory()
			.appendNl("error")
			.assertText("Name");
	}
	
	public void testScenario5_Mandatory_03() throws Exception {
		newBuilder_5_Mandatory()
			.appendNl("error Name")
			.assertText("error", "operation");
	}
	
	public void testScenario5_Mandatory_04() throws Exception {
		newBuilder_5_Mandatory()
			.appendNl("error Name")
			.appendNl("operation")
			.assertText("Name");
	}
	
	public void testScenario5_Mandatory_05() throws Exception {
		newBuilder_5_Mandatory()
			.appendNl("error Name")
			.appendNl("operation Name")
			.assertText("operation", "}");
	}
	
	public void testScenario5_Mandatory_06() throws Exception {
		newBuilder_5_Mandatory()
			.appendNl("error Name")
			.appendNl("operation Name")
			.appendNl("operation Name")
			.assertText("operation", "}");
	}
	
	protected ContentAssistProcessorTestBuilder newBuilder_5_Mandatory() throws Exception {
		return newBuilder().appendNl("#5+ {");
	}
	
	protected ContentAssistProcessorTestBuilder newBuilder() throws Exception {
		return newBuilder(getSetup());
	}
	
}
