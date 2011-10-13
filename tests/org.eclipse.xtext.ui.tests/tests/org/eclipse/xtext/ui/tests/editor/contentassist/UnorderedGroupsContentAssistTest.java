/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import junit.framework.Test;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.ui.junit.editor.contentassist.AbstractContentAssistProcessorTest;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.UnorderedGroupsTestLanguageUiModule;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class UnorderedGroupsContentAssistTest extends AbstractContentAssistProcessorTest {

	@Override
	public ISetup doGetSetup() {
		return new UnorderedGroupsTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(Modules2.mixin(new UnorderedGroupsTestLanguageRuntimeModule(),
						new UnorderedGroupsTestLanguageUiModule(Activator.getInstance()), new SharedStateModule()));
			}
		};
	}

	public void testEmptyModel() throws Exception {
		newBuilder().assertText("1", "2", "3", "4", "5", "bug304681");
	}

	public void testEmptySimpleModel() throws Exception {
		newBuilder().appendNl("1").assertText("public", "protected", "private", "synchronized", "abstract",
				"final", "static", "class");
	}

	public void testSimpleAfterVisibility() throws Exception {
		newBuilder().appendNl("1").appendNl("public").assertText("synchronized", "abstract", "final",
				"static", "class");
	}

	public void testSimpleAfterStatic() throws Exception {
		newBuilder().appendNl("1").appendNl("static").assertText("public", "protected", "private",
				"synchronized", "abstract", "final", "class");
	}

	public void testSimpleAfterPrivateFinal() throws Exception {
		newBuilder().appendNl("1").appendNl("private final").assertText("synchronized", "static", "class");
	}

	public void testSimpleAfterStaticSynchronizedProtectedAbstract() throws Exception {
		newBuilder().appendNl("1").appendNl("static synchronized protected abstract").assertText("class");
	}

	public void testEmptyMandatoryModel() throws Exception {
		newBuilder().appendNl("2").assertText("public", "protected", "private", "synchronized", "abstract",
				"final", "static");
	}

	public void testMandatoryAfterVisibility() throws Exception {
		newBuilder().appendNl("2").appendNl("public").assertText("synchronized", "abstract", "final",
				"static");
	}

	public void testMandatoryAfterStatic() throws Exception {
		newBuilder().appendNl("2").appendNl("static").assertText("public", "protected", "private",
				"synchronized", "abstract", "final");
	}

	public void testMandatoryAfterPrivateFinal() throws Exception {
		newBuilder().appendNl("2").appendNl("private final").assertText("synchronized", "static");
	}

	public void testMandatoryAfterStaticSynchronizedProtected() throws Exception {
		newBuilder().appendNl("2").appendNl("static synchronized public ").assertText("abstract", "final",
				"class");
	}

	public void testMandatoryAfterStaticSynchronizedProtectedAbstract() throws Exception {
		newBuilder().appendNl("2").appendNl("static synchronized protected abstract").assertText("class");
	}

	public void testEmptyLoopedModel() throws Exception {
		newBuilder().appendNl("3").assertText("public", "protected", "private", "synchronized", "abstract",
				"final", "static", "class");
	}

	public void testLoopedAfterVisibility() throws Exception {
		newBuilder().appendNl("3").appendNl("public").assertText("public", "protected", "private",
				"synchronized", "abstract", "final", "static", "class");
	}

	public void testLoopedAfterStatic() throws Exception {
		newBuilder().appendNl("3").appendNl("static").assertText("public", "protected", "private",
				"synchronized", "abstract", "final", "static", "class");
	}

	public void testLoopedAfterPrivateFinal() throws Exception {
		newBuilder().appendNl("3").appendNl("private final").assertText(
				"abstract", "final",
				"static", 
				"synchronized",
				"class");
	}

	public void testLoopedAfterStaticSynchronizedProtected() throws Exception {
		newBuilder().appendNl("3").appendNl("static synchronized public ").assertText(
				"public", "protected", "private", 
				"abstract",	"final", 
				"class");
	}

	public void testLoopedAfterStaticSynchronizedProtectedAbstract() throws Exception {
		newBuilder().appendNl("3").appendNl("static synchronized protected abstract").assertText(
				"abstract", "final", 
				"class");
	}

	public void testEmptyGroupedLoopedModel() throws Exception {
		newBuilder().appendNl("4").assertText("public", "protected", "private", "synchronized", "abstract",
				"final", "static", "class");
	}

	public void testGroupedLoopedAfterVisibility() throws Exception {
		newBuilder().appendNl("4").appendNl("public").assertText("synchronized", "abstract", "final",
				"static");
	}

	public void testGroupedLoopedAfterStatic() throws Exception {
		newBuilder().appendNl("4").appendNl("static").assertText("public", "protected", "private",
				"synchronized", "abstract", "final");
	}

	public void testGroupedLoopedAfterPrivateFinal() throws Exception {
		newBuilder().appendNl("4").appendNl("private final").assertText("synchronized", "static");
	}

	public void testGroupedLoopedAfterStaticSynchronizedProtected() throws Exception {
		newBuilder().appendNl("4").appendNl("static synchronized public ").assertText("abstract", "final");
	}

	public void testGroupedLoopedAfterStaticSynchronizedProtectedAbstract() throws Exception {
		newBuilder().appendNl("4").appendNl("static synchronized protected abstract").assertText("public",
				"protected", "private", "synchronized", "abstract", "final", "static", "class");
	}
	
	public void testLoopedAlternative() throws Exception {
		newBuilder().appendNl("5").appendNl("before").assertText(
				"public", "protected", "private", 
				"synchronized", 
				"abstract", "final", 
				"static",
				"before", "after",
				"class");
	}
	
	public void testBug304681_01() throws Exception {
		newBuilder().appendNl("bug304681")
			.assertText("{");
	}
	
	public void testBug304681_02() throws Exception {
		newBuilder().appendNl("bug304681")
			.appendNl("{")
			.assertText("attr", "ref", "flag", "long", "short", "uid", "}");
	}
	
	public void testBug304681_03() throws Exception {
		newBuilder().appendNl("bug304681")
			.appendNl("{")
			.appendNl("attr name;")
			.assertText("attr", "ref", "flag", "long", "short", "uid", "}");
	}
	
	public void testBug304681_04() throws Exception {
		newBuilder().appendNl("bug304681")
			.appendNl("{")
			.appendNl("uid 'String';")
			.assertText("attr", "ref", "flag", "long", "short", "}");
	}
	
	public void testBug304681_05() throws Exception {
		newBuilder().appendNl("bug304681")
			.appendNl("{")
			.appendNl("uid 'String';")
			.appendNl("attr name;")
			.assertText("attr", "ref", "flag", "long", "short", "}");
	}
	
	public void testBug304681_06() throws Exception {
		newBuilder().appendNl("bug304681")
			.appendNl("{")
			.appendNl("attr name;")
			.appendNl("uid 'String';")
			.assertText("flag", "long", "short", "}");
	}
	
	public void testBug304681_07() throws Exception {
		newBuilder().appendNl("bug304681")
			.appendNl("{")
			.appendNl("attr name")
			.assertText(";");
	}
	
	public void testBug304681_08() throws Exception {
		newBuilder().appendNl("bug304681")
			.appendNl("{")
			.appendNl("attr name;")
			.appendNl("uid 'String';")
			.appendNl("short 'String';")
			.appendNl("long 'String';")
			.appendNl("flag;")
			.assertText("}");
	}
	
	public void testBug304681_09() throws Exception {
		newBuilder().appendNl("bug304681")
			.appendNl("{")
			.appendNl("uid 'String';")
			.appendNl("short 'String';")
			.appendNl("long 'String';")
			.appendNl("flag;")
			.appendNl("attr name;")
			.assertText("attr", "ref", "}");
	}
	
	public void testBug304681_10() throws Exception {
		newBuilder().appendNl("bug304681")
			.appendNl("{")
			.appendNl("uid 'String';")
			.append("attr name;")
			.assertText("attr", "ref", "flag", "long", "short", "}", ";");
	}

	public static Test suite() {
		return AbstractContentAssistProcessorTest.suite(UnorderedGroupsContentAssistTest.class);
	}
}
