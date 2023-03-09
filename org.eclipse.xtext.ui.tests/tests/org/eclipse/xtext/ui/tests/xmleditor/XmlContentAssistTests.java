/**
 * Copyright (c) 2019, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tests.xmleditor;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractContentAssistTest;
import org.eclipse.xtext.ui.tests.xmleditor.ui.tests.XmlUiInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(XmlUiInjectorProvider.class)
public class XmlContentAssistTests extends AbstractContentAssistTest {
	@Test
	public void test01() throws Exception {
		newBuilder().assertText("");
	}

	@Test
	public void test02() throws Exception {
		newBuilder().append("<a b=\"\" />").assertTextAtCursorPosition(6, "");
	}
}
