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
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.tests.Bug307519TestLanguageUiInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@InjectWith(Bug307519TestLanguageUiInjectorProvider.class)
@RunWith(XtextRunner.class)
public class Bug307519Test extends AbstractContentAssistTest {
	
	@Test public void testEmptyModel() throws Exception {
		newBuilder().assertText("T1", "T2");
	}
	
	@Test public void testAfterT1() throws Exception {
		newBuilder()
			.appendNl("T1")
			.assertText("T1", "T2", "foo");
	}
	
	@Test public void testAfterT2() throws Exception {
		newBuilder()
			.appendNl("T2")
			.assertText("T1", "T2", "foo");
	}
	
	@Test public void testAfterFoo() throws Exception {
		newBuilder()
			.appendNl("T1 foo")
			.assertText("%");
	}
	
	@Test public void testAfterPercent() throws Exception {
		newBuilder()
			.appendNl("T1 foo %")
			.assertText("$");
	}

}