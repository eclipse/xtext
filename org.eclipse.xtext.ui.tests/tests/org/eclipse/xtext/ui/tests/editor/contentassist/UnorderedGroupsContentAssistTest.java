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
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.tests.UnorderedGroupsTestLanguageUiInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@InjectWith(UnorderedGroupsTestLanguageUiInjectorProvider.class)
@RunWith(XtextRunner.class)
public class UnorderedGroupsContentAssistTest extends AbstractContentAssistTest {

	@Test public void testEmptyModel() throws Exception {
		newBuilder().assertText("1", "2", "3", "4", "5", "bug304681");
	}

	@Test public void testEmptySimpleModel() throws Exception {
		newBuilder().appendNl("1").assertText("public", "protected", "private", "synchronized", "abstract",
				"final", "static", "class");
	}

	@Test public void testSimpleAfterVisibility() throws Exception {
		newBuilder().appendNl("1").appendNl("public").assertText("synchronized", "abstract", "final",
				"static", "class");
	}

	@Test public void testSimpleAfterStatic() throws Exception {
		newBuilder().appendNl("1").appendNl("static").assertText("public", "protected", "private",
				"synchronized", "abstract", "final", "class");
	}

	@Test public void testSimpleAfterPrivateFinal() throws Exception {
		newBuilder().appendNl("1").appendNl("private final").assertText("synchronized", "static", "class");
	}

	@Test public void testSimpleAfterStaticSynchronizedProtectedAbstract() throws Exception {
		newBuilder().appendNl("1").appendNl("static synchronized protected abstract").assertText("class");
	}

	@Test public void testEmptyMandatoryModel() throws Exception {
		newBuilder().appendNl("2").assertText("public", "protected", "private", "synchronized", "abstract",
				"final", "static");
	}

	@Test public void testMandatoryAfterVisibility() throws Exception {
		newBuilder().appendNl("2").appendNl("public").assertText("synchronized", "abstract", "final",
				"static");
	}

	@Test public void testMandatoryAfterStatic() throws Exception {
		newBuilder().appendNl("2").appendNl("static").assertText("public", "protected", "private",
				"synchronized", "abstract", "final");
	}

	@Test public void testMandatoryAfterPrivateFinal() throws Exception {
		newBuilder().appendNl("2").appendNl("private final").assertText("synchronized", "static");
	}

	@Test public void testMandatoryAfterStaticSynchronizedProtected() throws Exception {
		newBuilder().appendNl("2").appendNl("static synchronized public ").assertText("abstract", "final",
				"class");
	}

	@Test public void testMandatoryAfterStaticSynchronizedProtectedAbstract() throws Exception {
		newBuilder().appendNl("2").appendNl("static synchronized protected abstract").assertText("class");
	}

	@Test public void testEmptyLoopedModel() throws Exception {
		newBuilder().appendNl("3").assertText("public", "protected", "private", "synchronized", "abstract",
				"final", "static", "class");
	}

	@Test public void testLoopedAfterVisibility() throws Exception {
		newBuilder().appendNl("3").appendNl("public").assertText("public", "protected", "private",
				"synchronized", "abstract", "final", "static", "class");
	}

	@Test public void testLoopedAfterStatic() throws Exception {
		newBuilder().appendNl("3").appendNl("static").assertText("public", "protected", "private",
				"synchronized", "abstract", "final", "static", "class");
	}

	@Test public void testLoopedAfterPrivateFinal() throws Exception {
		newBuilder().appendNl("3").appendNl("private final").assertText(
				"abstract", "final",
				"static", 
				"synchronized",
				"class");
	}

	@Test public void testLoopedAfterStaticSynchronizedProtected() throws Exception {
		newBuilder().appendNl("3").appendNl("static synchronized public ").assertText(
				"public", "protected", "private", 
				"abstract",	"final", 
				"class");
	}

	@Test public void testLoopedAfterStaticSynchronizedProtectedAbstract() throws Exception {
		newBuilder().appendNl("3").appendNl("static synchronized protected abstract").assertText(
				"abstract", "final", 
				"class");
	}

	@Test public void testEmptyGroupedLoopedModel() throws Exception {
		newBuilder().appendNl("4").assertText("public", "protected", "private", "synchronized", "abstract",
				"final", "static", "class");
	}

	@Test public void testGroupedLoopedAfterVisibility() throws Exception {
		newBuilder().appendNl("4").appendNl("public").assertText("synchronized", "abstract", "final",
				"static");
	}

	@Test public void testGroupedLoopedAfterStatic() throws Exception {
		newBuilder().appendNl("4").appendNl("static").assertText("public", "protected", "private",
				"synchronized", "abstract", "final");
	}

	@Test public void testGroupedLoopedAfterPrivateFinal() throws Exception {
		newBuilder().appendNl("4").appendNl("private final").assertText("synchronized", "static");
	}

	@Test public void testGroupedLoopedAfterStaticSynchronizedProtected() throws Exception {
		newBuilder().appendNl("4").appendNl("static synchronized public ").assertText("abstract", "final");
	}

	@Test public void testGroupedLoopedAfterStaticSynchronizedProtectedAbstract() throws Exception {
		newBuilder().appendNl("4").appendNl("static synchronized protected abstract").assertText("public",
				"protected", "private", "synchronized", "abstract", "final", "static", "class");
	}
	
	@Test public void testLoopedAlternative() throws Exception {
		newBuilder().appendNl("5").appendNl("before").assertText(
				"public", "protected", "private", 
				"synchronized", 
				"abstract", "final", 
				"static",
				"before", "after",
				"class");
	}
	
	@Test public void testBug304681_01() throws Exception {
		newBuilder().appendNl("bug304681")
			.assertText("{");
	}
	
	@Test public void testBug304681_02() throws Exception {
		newBuilder().appendNl("bug304681")
			.appendNl("{")
			.assertText("attr", "ref", "flag", "long", "short", "uid", "}");
	}
	
	@Test public void testBug304681_03() throws Exception {
		newBuilder().appendNl("bug304681")
			.appendNl("{")
			.appendNl("attr name;")
			.assertText("attr", "ref", "flag", "long", "short", "uid", "}");
	}
	
	@Test public void testBug304681_04() throws Exception {
		newBuilder().appendNl("bug304681")
			.appendNl("{")
			.appendNl("uid 'String';")
			.assertText("attr", "ref", "flag", "long", "short", "}");
	}
	
	@Test public void testBug304681_05() throws Exception {
		newBuilder().appendNl("bug304681")
			.appendNl("{")
			.appendNl("uid 'String';")
			.appendNl("attr name;")
			.assertText("attr", "ref", "flag", "long", "short", "}");
	}
	
	@Test public void testBug304681_06() throws Exception {
		newBuilder().appendNl("bug304681")
			.appendNl("{")
			.appendNl("attr name;")
			.appendNl("uid 'String';")
			.assertText("flag", "long", "short", "}");
	}
	
	@Test public void testBug304681_07() throws Exception {
		newBuilder().appendNl("bug304681")
			.appendNl("{")
			.appendNl("attr name")
			.assertText(";");
	}
	
	@Test public void testBug304681_08() throws Exception {
		newBuilder().appendNl("bug304681")
			.appendNl("{")
			.appendNl("attr name;")
			.appendNl("uid 'String';")
			.appendNl("short 'String';")
			.appendNl("long 'String';")
			.appendNl("flag;")
			.assertText("}");
	}
	
	@Test public void testBug304681_09() throws Exception {
		newBuilder().appendNl("bug304681")
			.appendNl("{")
			.appendNl("uid 'String';")
			.appendNl("short 'String';")
			.appendNl("long 'String';")
			.appendNl("flag;")
			.appendNl("attr name;")
			.assertText("attr", "ref", "}");
	}
	
	@Test public void testBug304681_10() throws Exception {
		newBuilder().appendNl("bug304681")
			.appendNl("{")
			.appendNl("uid 'String';")
			.append("attr name;")
			.assertText("attr", "ref", "flag", "long", "short", "}", ";");
	}

}
