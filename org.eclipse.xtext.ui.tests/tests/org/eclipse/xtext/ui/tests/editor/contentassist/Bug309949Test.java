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
import org.eclipse.xtext.ui.testing.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.tests.Bug309949TestLanguageUiInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@InjectWith(Bug309949TestLanguageUiInjectorProvider.class)
@RunWith(XtextRunner.class)
public class Bug309949Test extends AbstractContentAssistTest {

	@Test public void testEmptyModel() throws Exception {
		newBuilder().assertText("#1*", "#1+", "#2*", "#2+", "#3*", "#3+", "#4*", "#4+", "#5*", "#5+");
	}
	
	@Test public void testScenario1_Optional_01() throws Exception {
		newBuilder_1_Optional().assertText("@uuid", "error", "operation", "}");
	}
	
	@Test public void testScenario1_Optional_02() throws Exception {
		newBuilder_1_Optional()
			.appendNl("@uuid")
			.assertText("Name");
	}
	
	@Test public void testScenario1_Optional_03() throws Exception {
		newBuilder_1_Optional()
			.appendNl("@uuid Name")
			.assertText("@uuid", "error", "operation");
	}
	
	@Test public void testScenario1_Optional_04() throws Exception {
		newBuilder_1_Optional()
			.appendNl("@uuid Name")
			.appendNl("@uuid")
			.assertText("Name");
	}
	
	@Test public void testScenario1_Optional_05() throws Exception {
		newBuilder_1_Optional()
			.appendNl("@uuid Name")
			.appendNl("@uuid Name")
			.assertText("@uuid", "error", "operation");
	}

	@Test public void testScenario1_Optional_06() throws Exception {
		newBuilder_1_Optional()
			.appendNl("error")
			.assertText("Name");
	}
	
	@Test public void testScenario1_Optional_07() throws Exception {
		newBuilder_1_Optional()
			.appendNl("error Name")
			.assertText("@uuid", "error", "operation", "}");
	}
	
	@Test public void testScenario1_Optional_08() throws Exception {
		newBuilder_1_Optional()
			.appendNl("error Name")
			.appendNl("@uuid Name")
			.assertText("@uuid", "error", "operation");
	}
	
	@Test public void testScenario1_Optional_09() throws Exception {
		newBuilder_1_Optional()
			.appendNl("error Name")
			.appendNl("@uuid Name")
			.appendNl("@uuid Name")
			.assertText("@uuid", "error", "operation");
	}
	
	@Test public void testScenario1_Optional_10() throws Exception {
		newBuilder_1_Optional()
			.appendNl("operation")
			.assertText("Name");
	}
	
	@Test public void testScenario1_Optional_11() throws Exception {
		newBuilder_1_Optional()
			.appendNl("operation Name")
			.assertText("@uuid", "operation", "}");
	}
	
	@Test public void testScenario1_Optional_12() throws Exception {
		newBuilder_1_Optional()
			.appendNl("operation Name")
			.appendNl("@uuid Name")
			.assertText("@uuid", "operation");
	}
	
	@Test public void testScenario1_Optional_13() throws Exception {
		newBuilder_1_Optional()
			.appendNl("operation Name")
			.appendNl("@uuid Name")
			.appendNl("@uuid Name")
			.assertText("@uuid", "operation");
	}
	
	@Test public void testScenario1_Optional_14() throws Exception {
		newBuilder_1_Optional()
			.appendNl("error Name")
			.appendNl("operation Name")
			.assertText("@uuid", "operation", "}");
	}
	
	protected ContentAssistProcessorTestBuilder newBuilder_1_Optional() throws Exception {
		return newBuilder().appendNl("#1* {");
	}
	
	@Test public void testScenario1_Mandatory_01() throws Exception {
		newBuilder_1_Mandatory().assertText("@uuid", "error");
	}
	
	@Test public void testScenario1_Mandatory_02() throws Exception {
		newBuilder_1_Mandatory()
			.appendNl("@uuid")
			.assertText("Name");
	}
	
	@Test public void testScenario1_Mandatory_03() throws Exception {
		newBuilder_1_Mandatory()
			.appendNl("@uuid Name")
			.assertText("@uuid", "error");
	}
	
	@Test public void testScenario1_Mandatory_04() throws Exception {
		newBuilder_1_Mandatory()
			.appendNl("@uuid Name")
			.appendNl("@uuid")
			.assertText("Name");
	}
	
	@Test public void testScenario1_Mandatory_05() throws Exception {
		newBuilder_1_Mandatory()
			.appendNl("@uuid Name")
			.appendNl("@uuid Name")
			.assertText("@uuid", "error");
	}

	@Test public void testScenario1_Mandatory_06() throws Exception {
		newBuilder_1_Mandatory()
			.appendNl("error")
			.assertText("Name");
	}
	
	@Test public void testScenario1_Mandatory_07() throws Exception {
		newBuilder_1_Mandatory()
			.appendNl("error Name")
			.assertText("@uuid", "error", "operation");
	}
	
	@Test public void testScenario1_Mandatory_08() throws Exception {
		newBuilder_1_Mandatory()
			.appendNl("error Name")
			.appendNl("@uuid Name")
			.assertText("@uuid", "error", "operation");
	}
	
	@Test public void testScenario1_Mandatory_09() throws Exception {
		newBuilder_1_Mandatory()
			.appendNl("error Name")
			.appendNl("@uuid Name")
			.appendNl("@uuid Name")
			.assertText("@uuid", "error", "operation");
	}
	
	@Test public void testScenario1_Mandatory_10() throws Exception {
		newBuilder_1_Mandatory()
			.appendNl("error Name")
			.appendNl("operation")
			.assertText("Name");
	}
	
	@Test public void testScenario1_Mandatory_11() throws Exception {
		newBuilder_1_Mandatory()
			.appendNl("error Name")
			.appendNl("operation Name")
			.assertText("@uuid", "operation", "}");
	}
	
	@Test public void testScenario1_Mandatory_12() throws Exception {
		newBuilder_1_Mandatory()
			.appendNl("error Name")
			.appendNl("operation Name")
			.appendNl("@uuid Name")
			.assertText("@uuid", "operation");
	}
	
	@Test public void testScenario1_Mandatory_13() throws Exception {
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

	@Test public void testScenario2_Optional_01() throws Exception {
		newBuilder_2_Optional().assertText("@uuid", "}");
	}
	
	@Test public void testScenario2_Optional_02() throws Exception {
		newBuilder_2_Optional()
		.appendNl("@uuid")
		.assertText("Name");
	}
	
	@Test public void testScenario2_Optional_03() throws Exception {
		newBuilder_2_Optional()
		.appendNl("@uuid Name")
		.assertText("@uuid", "error", "operation");
	}
	
	@Test public void testScenario2_Optional_04() throws Exception {
		newBuilder_2_Optional()
		.appendNl("@uuid Name")
		.appendNl("@uuid")
		.assertText("Name");
	}
	
	@Test public void testScenario2_Optional_05() throws Exception {
		newBuilder_2_Optional()
		.appendNl("@uuid Name")
		.appendNl("@uuid Name")
		.assertText("@uuid", "error", "operation");
	}
	
	@Test public void testScenario2_Optional_06() throws Exception {
		newBuilder_2_Optional()
		.appendNl("@uuid Name")
		.appendNl("error")
		.assertText("Name");
	}
	
	@Test public void testScenario2_Optional_07() throws Exception {
		newBuilder_2_Optional()
		.appendNl("@uuid Name")
		.appendNl("error Name")
		.assertText("@uuid", "}");
	}
	
	@Test public void testScenario2_Optional_08() throws Exception {
		newBuilder_2_Optional()
		.appendNl("@uuid Name")
		.appendNl("error Name")
		.appendNl("@uuid Name")
		.assertText("@uuid", "error", "operation");
	}
	
	@Test public void testScenario2_Optional_09() throws Exception {
		newBuilder_2_Optional()
		.appendNl("@uuid Name")
		.appendNl("error Name")
		.appendNl("@uuid Name")
		.appendNl("@uuid Name")
		.assertText("@uuid", "error", "operation");
	}
	
	@Test public void testScenario2_Optional_10() throws Exception {
		newBuilder_2_Optional()
		.appendNl("@uuid Name")
		.appendNl("operation")
		.assertText("Name");
	}
	
	@Test public void testScenario2_Optional_11() throws Exception {
		newBuilder_2_Optional()
		.appendNl("@uuid Name")
		.appendNl("operation Name")
		.assertText("@uuid", "}");
	}
	
	@Test public void testScenario2_Optional_12() throws Exception {
		newBuilder_2_Optional()
		.appendNl("@uuid Name")
		.appendNl("operation Name")
		.appendNl("@uuid Name")
		.assertText("@uuid", "operation");
	}
	
	@Test public void testScenario2_Optional_13() throws Exception {
		newBuilder_2_Optional()
		.appendNl("@uuid Name")
		.appendNl("operation Name")
		.appendNl("@uuid Name")
		.appendNl("@uuid Name")
		.assertText("@uuid", "operation");
	}
	
	@Test public void testScenario2_Optional_14() throws Exception {
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
	
	@Test public void testScenario2_Mandatory_01() throws Exception {
		newBuilder_2_Mandatory().assertText("@uuid");
	}
	
	@Test public void testScenario2_Mandatory_02() throws Exception {
		newBuilder_2_Mandatory()
		.appendNl("@uuid")
		.assertText("Name");
	}
	
	@Test public void testScenario2_Mandatory_03() throws Exception {
		newBuilder_2_Mandatory()
		.appendNl("@uuid Name")
		.assertText("@uuid", "error");
	}
	
	@Test public void testScenario2_Mandatory_04() throws Exception {
		newBuilder_2_Mandatory()
		.appendNl("@uuid Name")
		.appendNl("@uuid")
		.assertText("Name");
	}
	
	@Test public void testScenario2_Mandatory_05() throws Exception {
		newBuilder_2_Mandatory()
		.appendNl("@uuid Name")
		.appendNl("@uuid Name")
		.assertText("@uuid", "error");
	}
	
	@Test public void testScenario2_Mandatory_06() throws Exception {
		newBuilder_2_Mandatory()
		.appendNl("@uuid Name")
		.appendNl("error")
		.assertText("Name");
	}
	
	@Test public void testScenario2_Mandatory_07() throws Exception {
		newBuilder_2_Mandatory()
		.appendNl("@uuid Name")
		.appendNl("error Name")
		.assertText("@uuid");
	}
	
	@Test public void testScenario2_Mandatory_08() throws Exception {
		newBuilder_2_Mandatory()
		.appendNl("@uuid Name")
		.appendNl("error Name")
		.appendNl("@uuid Name")
		.assertText("@uuid", "error", "operation");
	}
	
	@Test public void testScenario2_Mandatory_09() throws Exception {
		newBuilder_2_Mandatory()
		.appendNl("@uuid Name")
		.appendNl("error Name")
		.appendNl("@uuid Name")
		.appendNl("@uuid Name")
		.assertText("@uuid", "error", "operation");
	}
	
	@Test public void testScenario2_Mandatory_10() throws Exception {
		newBuilder_2_Mandatory()
		.appendNl("@uuid Name")
		.appendNl("error Name")
		.appendNl("@uuid Name")
		.appendNl("operation")
		.assertText("Name");
	}
	
	@Test public void testScenario2_Mandatory_11() throws Exception {
		newBuilder_2_Mandatory()
		.appendNl("@uuid Name")
		.appendNl("error Name")
		.appendNl("@uuid Name")
		.appendNl("operation Name")
		.assertText("@uuid", "}");
	}
	
	@Test public void testScenario2_Mandatory_12() throws Exception {
		newBuilder_2_Mandatory()
		.appendNl("@uuid Name")
		.appendNl("error Name")
		.appendNl("@uuid Name")
		.appendNl("operation Name")
		.appendNl("@uuid Name")
		.assertText("@uuid", "operation");
	}
	
	@Test public void testScenario2_Mandatory_13() throws Exception {
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
	
	@Test public void testScenario3_Optional_01() throws Exception {
		newBuilder_3_Optional().assertText("@uuid", "error", "operation", "}");
	}
	
	@Test public void testScenario3_Optional_02() throws Exception {
		newBuilder_3_Optional()
		.appendNl("@uuid")
		.assertText("Name");
	}
	
	@Test public void testScenario3_Optional_03() throws Exception {
		newBuilder_3_Optional()
		.appendNl("@uuid Name")
		.assertText("error", "operation");
	}
	
	@Test public void testScenario3_Optional_04() throws Exception {
		newBuilder_3_Optional()
		.appendNl("error")
		.assertText("Name");
	}
	
	@Test public void testScenario3_Optional_05() throws Exception {
		newBuilder_3_Optional()
		.appendNl("@uuid Name")
		.appendNl("error")
		.assertText("Name");
	}
	
	@Test public void testScenario3_Optional_06() throws Exception {
		newBuilder_3_Optional()
		.appendNl("@uuid Name")
		.appendNl("error Name")
		.assertText("@uuid", "error", "operation", "}");
	}
	
	@Test public void testScenario3_Optional_07() throws Exception {
		newBuilder_3_Optional()
		.appendNl("@uuid Name")
		.appendNl("error Name")
		.appendNl("@uuid Name")
		.assertText("error", "operation");
	}
	
	@Test public void testScenario3_Optional_08() throws Exception {
		newBuilder_3_Optional()
		.appendNl("@uuid Name")
		.appendNl("operation")
		.assertText("Name");
	}
	
	@Test public void testScenario3_Optional_09() throws Exception {
		newBuilder_3_Optional()
		.appendNl("@uuid Name")
		.appendNl("operation Name")
		.assertText("@uuid", "operation", "}");
	}
	
	@Test public void testScenario3_Optional_10() throws Exception {
		newBuilder_3_Optional()
		.appendNl("@uuid Name")
		.appendNl("operation Name")
		.appendNl("@uuid Name")
		.assertText("operation");
	}
	
	@Test public void testScenario3_Optional_11() throws Exception {
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
	
	@Test public void testScenario3_Mandatory_01() throws Exception {
		newBuilder_3_Mandatory().assertText("@uuid", "error");
	}
	
	@Test public void testScenario3_Mandatory_02() throws Exception {
		newBuilder_3_Mandatory()
		.appendNl("@uuid")
		.assertText("Name");
	}
	
	@Test public void testScenario3_Mandatory_03() throws Exception {
		newBuilder_3_Mandatory()
		.appendNl("@uuid Name")
		.assertText("error");
	}
	
	@Test public void testScenario3_Mandatory_04() throws Exception {
		newBuilder_3_Mandatory()
		.appendNl("error")
		.assertText("Name");
	}
	
	@Test public void testScenario3_Mandatory_05() throws Exception {
		newBuilder_3_Mandatory()
		.appendNl("@uuid Name")
		.appendNl("error")
		.assertText("Name");
	}
	
	@Test public void testScenario3_Mandatory_06() throws Exception {
		newBuilder_3_Mandatory()
		.appendNl("@uuid Name")
		.appendNl("error Name")
		.assertText("@uuid", "error", "operation");
	}
	
	@Test public void testScenario3_Mandatory_07() throws Exception {
		newBuilder_3_Mandatory()
		.appendNl("@uuid Name")
		.appendNl("error Name")
		.appendNl("@uuid Name")
		.assertText("error", "operation");
	}
	
	@Test public void testScenario3_Mandatory_08() throws Exception {
		newBuilder_3_Mandatory()
		.appendNl("@uuid Name")
		.appendNl("error Name")
		.appendNl("@uuid Name")
		.appendNl("operation")
		.assertText("Name");
	}
	
	@Test public void testScenario3_Mandatory_09() throws Exception {
		newBuilder_3_Mandatory()
		.appendNl("@uuid Name")
		.appendNl("error Name")
		.appendNl("@uuid Name")
		.appendNl("operation Name")
		.assertText("@uuid", "operation", "}");
	}
	
	@Test public void testScenario3_Mandatory_10() throws Exception {
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
	
	@Test public void testScenario4_Optional_01() throws Exception {
		newBuilder_4_Optional().assertText("@uuid", "}");
	}
	
	@Test public void testScenario4_Optional_02() throws Exception {
		newBuilder_4_Optional()
			.appendNl("@uuid")
			.assertText("Name");
	}
	
	@Test public void testScenario4_Optional_03() throws Exception {
		newBuilder_4_Optional()
			.appendNl("@uuid Name")
			.assertText("error", "operation");
	}
	
	@Test public void testScenario4_Optional_04() throws Exception {
		newBuilder_4_Optional()
			.appendNl("@uuid Name")
			.appendNl("error Name")
			.assertText("@uuid", "}");
	}
	
	@Test public void testScenario4_Optional_05() throws Exception {
		newBuilder_4_Optional()
			.appendNl("@uuid Name")
			.appendNl("error Name")
			.appendNl("@uuid Name")
			.assertText("error", "operation");
	}
	
	@Test public void testScenario4_Optional_06() throws Exception {
		newBuilder_4_Optional()
			.appendNl("@uuid Name")
			.appendNl("operation")
			.assertText("Name");
	}
	
	@Test public void testScenario4_Optional_07() throws Exception {
		newBuilder_4_Optional()
			.appendNl("@uuid Name")
			.appendNl("operation Name")
			.assertText("@uuid", "}");
	}
	
	@Test public void testScenario4_Optional_08() throws Exception {
		newBuilder_4_Optional()
			.appendNl("@uuid Name")
			.appendNl("operation Name")
			.appendNl("@uuid Name")
			.assertText("operation");
	}
	
	@Test public void testScenario4_Optional_09() throws Exception {
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
	
	@Test public void testScenario4_Mandatory_01() throws Exception {
		newBuilder_4_Mandatory().assertText("@uuid");
	}
	
	@Test public void testScenario4_Mandatory_02() throws Exception {
		newBuilder_4_Mandatory()
			.appendNl("@uuid")
			.assertText("Name");
	}
	
	@Test public void testScenario4_Mandatory_03() throws Exception {
		newBuilder_4_Mandatory()
			.appendNl("@uuid Name")
			.assertText("error");
	}
	
	@Test public void testScenario4_Mandatory_04() throws Exception {
		newBuilder_4_Mandatory()
			.appendNl("@uuid Name")
			.appendNl("error")
			.assertText("Name");
	}
	
	@Test public void testScenario4_Mandatory_05() throws Exception {
		newBuilder_4_Mandatory()
			.appendNl("@uuid Name")
			.appendNl("error Name")
			.assertText("@uuid");
	}
	
	@Test public void testScenario4_Mandatory_06() throws Exception {
		newBuilder_4_Mandatory()
			.appendNl("@uuid Name")
			.appendNl("error Name")
			.appendNl("@uuid Name")
			.assertText("error", "operation");
	}
	
	@Test public void testScenario4_Mandatory_07() throws Exception {
		newBuilder_4_Mandatory()
			.appendNl("@uuid Name")
			.appendNl("error Name")
			.appendNl("@uuid Name")
			.appendNl("operation")
			.assertText("Name");
	}
	
	@Test public void testScenario4_Mandatory_08() throws Exception {
		newBuilder_4_Mandatory()
			.appendNl("@uuid Name")
			.appendNl("error Name")
			.appendNl("@uuid Name")
			.appendNl("operation Name")
			.assertText("@uuid", "}");
	}
	
	@Test public void testScenario4_Mandatory_09() throws Exception {
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
	
	@Test public void testScenario5_Optional_01() throws Exception {
		newBuilder_5_Optional().assertText("error", "operation", "}");
	}
	
	@Test public void testScenario5_Optional_02() throws Exception {
		newBuilder_5_Optional()
			.appendNl("error")
			.assertText("Name");
	}
	
	@Test public void testScenario5_Optional_03() throws Exception {
		newBuilder_5_Optional()
			.appendNl("error Name")
			.assertText("error", "operation", "}");
	}
	
	@Test public void testScenario5_Optional_04() throws Exception {
		newBuilder_5_Optional()
			.appendNl("operation")
			.assertText("Name");
	}
	
	@Test public void testScenario5_Optional_05() throws Exception {
		newBuilder_5_Optional()
			.appendNl("operation Name")
			.assertText("operation", "}");
	}
	
	@Test public void testScenario5_Optional_06() throws Exception {
		newBuilder_5_Optional()
			.appendNl("error Name")
			.appendNl("operation Name")
			.assertText("operation", "}");
	}
	
	protected ContentAssistProcessorTestBuilder newBuilder_5_Optional() throws Exception {
		return newBuilder().appendNl("#5* {");
	}
	
	@Test public void testScenario5_Mandatory_01() throws Exception {
		newBuilder_5_Mandatory().assertText("error");
	}
	
	@Test public void testScenario5_Mandatory_02() throws Exception {
		newBuilder_5_Mandatory()
			.appendNl("error")
			.assertText("Name");
	}
	
	@Test public void testScenario5_Mandatory_03() throws Exception {
		newBuilder_5_Mandatory()
			.appendNl("error Name")
			.assertText("error", "operation");
	}
	
	@Test public void testScenario5_Mandatory_04() throws Exception {
		newBuilder_5_Mandatory()
			.appendNl("error Name")
			.appendNl("operation")
			.assertText("Name");
	}
	
	@Test public void testScenario5_Mandatory_05() throws Exception {
		newBuilder_5_Mandatory()
			.appendNl("error Name")
			.appendNl("operation Name")
			.assertText("operation", "}");
	}
	
	@Test public void testScenario5_Mandatory_06() throws Exception {
		newBuilder_5_Mandatory()
			.appendNl("error Name")
			.appendNl("operation Name")
			.appendNl("operation Name")
			.assertText("operation", "}");
	}
	
	protected ContentAssistProcessorTestBuilder newBuilder_5_Mandatory() throws Exception {
		return newBuilder().appendNl("#5+ {");
	}

}
