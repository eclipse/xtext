/*******************************************************************************
 * Copyright (c) 2024 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.tests.linking.ui.tests.ImportUriUiTestLanguageUiInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(ImportUriUiTestLanguageUiInjectorProvider.class)
public class ContentAssistWithSeveralResourcesTest extends AbstractContentAssistTest {

	@Test public void test_with_one_resource() {
		assertContentAssistant("type A extends " + c, new String[]{("A")});
	}
	
	@Test public void test_with_two_resources() {
		createDslFile("types", "type A extends A");
		IResourcesSetupUtil.waitForBuild();
		assertContentAssistant("import \"types.importuriuitestlanguage\" type B extends " + c, "A\nB");
	}
	
	@Test public void test_with_three_resources() {
		createDslFile("types1", "type A extends A");
		createDslFile("types2", "type B extends B");
		IResourcesSetupUtil.waitForBuild();
		assertContentAssistant("import \"types1.importuriuitestlanguage\" import \"types2.importuriuitestlanguage\" type C extends " + c, new String[]{"A", "B", "C"});
	}
}
