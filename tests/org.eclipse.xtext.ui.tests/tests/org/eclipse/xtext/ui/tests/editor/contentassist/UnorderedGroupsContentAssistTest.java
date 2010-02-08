/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.ui.UIPluginModule;
import org.eclipse.xtext.ui.junit.editor.contentassist.AbstractContentAssistProcessorTest;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.UnorderedGroupsTestLanguageUiModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class UnorderedGroupsContentAssistTest extends AbstractContentAssistProcessorTest {

	public ISetup getSetup() {
		return new UnorderedGroupsTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new UnorderedGroupsTestLanguageUiModule(), new UIPluginModule(Activator.getInstance()));
			}
		};
	}
	
	public void testEmptyModel() throws Exception {
		newBuilder(getSetup())
			.assertText(
					"1", "2", "3", "4"
			);
	}
	
	public void testEmptySimpleModel() throws Exception {
		newBuilder(getSetup()).appendNl("1")
			.assertText(
					"public",
					"protected",
					"private",
					"synchronized",
					"abstract",
					"final",
					"static",
					"class"
			);
	}
	
	public void testSimpleAfterVisibility() throws Exception {
		newBuilder(getSetup()).appendNl("1")
			.appendNl("public")
			.assertText(
					"synchronized",
					"abstract",
					"final",
					"static",
					"class"
			);
	}
	
	public void testSimpleAfterStatic() throws Exception {
		newBuilder(getSetup()).appendNl("1")
			.appendNl("static")
			.assertText(
					"public",
					"protected",
					"private",
					"synchronized",
					"abstract",
					"final",
					"class"
			);
	}
	
	public void testSimpleAfterPrivateFinal() throws Exception {
		newBuilder(getSetup()).appendNl("1")
			.appendNl("private final")
			.assertText(
					"synchronized",
					"static",
					"class"
			);
	}
	
	public void testSimpleAfterStaticSynchronizedProtectedAbstract() throws Exception {
		newBuilder(getSetup()).appendNl("1")
			.appendNl("static synchronized protected abstract")
			.assertText(
					"class"
			);
	}
	
	public void testEmptyMandatoryModel() throws Exception {
		newBuilder(getSetup()).appendNl("2")
			.assertText(
					"public",
					"protected",
					"private",
					"synchronized",
					"abstract",
					"final",
					"static"
			);
	}
	
	public void testMandatoryAfterVisibility() throws Exception {
		newBuilder(getSetup()).appendNl("2")
			.appendNl("public")
			.assertText(
					"synchronized",
					"abstract",
					"final",
					"static"
			);
	}
	
	public void testMandatoryAfterStatic() throws Exception {
		newBuilder(getSetup()).appendNl("2")
			.appendNl("static")
			.assertText(
					"public",
					"protected",
					"private",
					"synchronized",
					"abstract",
					"final"
			);
	}
	
	public void testMandatoryAfterPrivateFinal() throws Exception {
		newBuilder(getSetup()).appendNl("2")
			.appendNl("private final")
			.assertText(
					"synchronized",
					"static"
			);
	}
	
	public void testMandatoryAfterStaticSynchronizedProtected() throws Exception {
		newBuilder(getSetup()).appendNl("2")
			.appendNl("static synchronized public ")
			.assertText(
					"abstract",
					"final",
					"class"
			);
	}
	
	public void testMandatoryAfterStaticSynchronizedProtectedAbstract() throws Exception {
		newBuilder(getSetup()).appendNl("2")
			.appendNl("static synchronized protected abstract")
			.assertText(
					"class"
			);
	}
	
	public void testEmptyLoopedModel() throws Exception {
		newBuilder(getSetup()).appendNl("3")
			.assertText(
					"public",
					"protected",
					"private",
					"synchronized",
					"abstract",
					"final",
					"static",
					"class"
			);
	}
	
	public void testLoopedAfterVisibility() throws Exception {
		newBuilder(getSetup()).appendNl("3")
			.appendNl("public")
			.assertText(
					"public",
					"protected",
					"private",
					"synchronized",
					"abstract",
					"final",
					"static",
					"class"
			);
	}
	
	public void testLoopedAfterStatic() throws Exception {
		newBuilder(getSetup()).appendNl("3")
			.appendNl("static")
			.assertText(
					"public",
					"protected",
					"private",
					"synchronized",
					"abstract",
					"final",
					"static",
					"class"
			);
	}
	
	public void testLoopedAfterPrivateFinal() throws Exception {
		newBuilder(getSetup()).appendNl("3")
			.appendNl("private final")
			.assertText(
					"public",
					"protected",
					"private",
					"synchronized",
					"abstract",
					"final",
					"static",
					"class"
			);
	}
	
	public void testLoopedAfterStaticSynchronizedProtected() throws Exception {
		newBuilder(getSetup()).appendNl("3")
			.appendNl("static synchronized public ")
			.assertText(
					"public",
					"protected",
					"private",
					"synchronized",
					"abstract",
					"final",
					"static",
					"class"
			);
	}
	
	public void testLoopedAfterStaticSynchronizedProtectedAbstract() throws Exception {
		newBuilder(getSetup()).appendNl("3")
			.appendNl("static synchronized protected abstract")
			.assertText(
					"public",
					"protected",
					"private",
					"synchronized",
					"abstract",
					"final",
					"static",
					"class"
			);
	}
	
	public void testEmptyGroupedLoopedModel() throws Exception {
		newBuilder(getSetup()).appendNl("4")
			.assertText(
					"public",
					"protected",
					"private",
					"synchronized",
					"abstract",
					"final",
					"static",
					"class"
			);
	}
	
	public void testGroupedLoopedAfterVisibility() throws Exception {
		newBuilder(getSetup()).appendNl("4")
			.appendNl("public")
			.assertText(
					"synchronized",
					"abstract",
					"final",
					"static"
			);
	}
	
	public void testGroupedLoopedAfterStatic() throws Exception {
		newBuilder(getSetup()).appendNl("4")
			.appendNl("static")
			.assertText(
					"public",
					"protected",
					"private",
					"synchronized",
					"abstract",
					"final"
			);
	}
	
	public void testGroupedLoopedAfterPrivateFinal() throws Exception {
		newBuilder(getSetup()).appendNl("4")
			.appendNl("private final")
			.assertText(
					"synchronized",
					"static"
			);
	}
	
	public void testGroupedLoopedAfterStaticSynchronizedProtected() throws Exception {
		newBuilder(getSetup()).appendNl("4")
			.appendNl("static synchronized public ")
			.assertText(
					"abstract",
					"final"
			);
	}
	
	public void testGroupedLoopedAfterStaticSynchronizedProtectedAbstract() throws Exception {
		newBuilder(getSetup()).appendNl("4")
			.appendNl("static synchronized protected abstract")
			.assertText(
					"public",
					"protected",
					"private",
					"synchronized",
					"abstract",
					"final",
					"static",
					"class"
			);
	}
}
