/*******************************************************************************
 * Copyright (c) 2009, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProviderFactory;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractContentAssistTest;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.tests.Bug287941TestLanguageUiInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(Bug287941TestLanguageUiInjectorProvider.class)
public class Bug287941Test extends AbstractContentAssistTest {

	@Override
	protected void initializeTypeProvider(XtextResourceSet set) {
		IJvmTypeProvider.Factory typeProviderFactory = new JdtTypeProviderFactory(this);
		typeProviderFactory.findOrCreateTypeProvider(set);
		set.setClasspathURIContext(this);
	}

    @Test public void testBug287941_01() throws Exception {
        newBuilder().append(
                "import \"classpath:/org/eclipse/xtext/ui/tests/editor/contentassist/Bug287941TestModel.ecore\"\n"
                        + "select t from Test as t \n" + "  where t. testAttr like \"\"").assertTextAtCursorPosition(
                "t. testAttr", 3, "testAttr", "testRef");
    }

    @Test public void testBug287941_02() throws Exception {
        newBuilder().append(
                "import \"classpath:/org/eclipse/xtext/ui/tests/editor/contentassist/Bug287941TestModel.ecore\"\n"
                        + "select t from Test as t \n" + "  where t.testAttr like \"\"").assertTextAtCursorPosition(
                "t.testAttr", 2, "testAttr", "testRef", ".");
    }
    
    @Test public void testBug309449() throws Exception {
        newBuilder().append(
                "import \"classpath:/org/eclipse/xtext/ui/tests/editor/contentassist/Bug287941TestModel.ecore\"\n"
              + "select t from Test as t \n" 
              + "   where t.testAttr like \"\"").assertTextAtCursorPosition(
                "like", 0, "<", ">", "<=", ">=", "=", "!=", "like", "notlike", "not", "in");
    }

}
