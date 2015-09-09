/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import org.eclipse.xtext.junit4.ui.AbstractContentAssistProcessorTest;
import org.eclipse.xtext.util.Strings;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractParametersContentAssistTest extends AbstractContentAssistProcessorTest {

	@Test public void testEmptyModel() throws Exception {
		newBuilder().assertText(
				"#1", "#2", "#3", "#4", "#5", "#6", "#7", "#8", "#9", "#10", "#11", "#12");
	}
	
	@Test public void test_01() throws Exception {
		newBuilder().append("#1 ").assertText(
				"First");
	}

	@Test public void test_02() throws Exception {
		newBuilder().append("#2 ").assertText(
				"Second");
	}

	@Test public void test_03() throws Exception {
		newBuilder().append("#3 ").assertText(Strings.EMPTY_ARRAY);
	}

	@Test public void test_04() throws Exception {
		newBuilder().append("#4 ").assertText(Strings.EMPTY_ARRAY);
	}
	
	@Test public void test_05() throws Exception {
		newBuilder().append("#5 ").assertText(Strings.EMPTY_ARRAY);
	}
	
	@Test public void test_06() throws Exception {
		newBuilder().append("#6 ").assertText(Strings.EMPTY_ARRAY);
	}
	
	@Test public void test_07() throws Exception {
		newBuilder().append("#7 ").assertText(
				"scenario3");
	}

	@Test public void test_08() throws Exception {
		newBuilder().append("#8 ").assertText(
				"scenario3");
	}

	@Test public void test_09a() throws Exception {
		newBuilder().append("#9 ").assertText(Strings.EMPTY_ARRAY);
	}
	
	@Test public void test_09b() throws Exception {
		newBuilder().append("#9 keyword ").assertText("scenario4", "trailing");
	}

	@Test public void test_09c() throws Exception {
		newBuilder().append("#9 ID ").assertText("scenario4", "trailing");
	}
	
	@Test public void test_10a() throws Exception {
		newBuilder().append("#10 ").assertText(Strings.EMPTY_ARRAY);
	}
	
	@Test public void test_10b() throws Exception {
		newBuilder().append("#10 keyword ").assertText("scenario4");
	}

	@Test public void test_10c() throws Exception {
		newBuilder().append("#10 ID ").assertText("scenario4", "trailing");
	}
	@Test public void test_11a() throws Exception {
		newBuilder().append("#11 ").assertText(Strings.EMPTY_ARRAY);
	}
	
	@Test public void test_11b() throws Exception {
		newBuilder().append("#11 keyword ").assertText("trailing");
	}

	@Test public void test_11c() throws Exception {
		newBuilder().append("#11 ID ").assertText("scenario4", "trailing");
	}
	
	@Test public void test_12a() throws Exception {
		newBuilder().append("#12 ").assertText(Strings.EMPTY_ARRAY);
	}
	
	@Test public void test_12b() throws Exception {
		newBuilder().append("#12 keyword ").assertText(Strings.EMPTY_ARRAY);
	}

	@Test public void test_12c() throws Exception {
		newBuilder().append("#12 ID ").assertText("scenario4", "trailing");
	}
}
