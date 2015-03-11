/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.junit4.ui.AbstractContentAssistProcessorTest;
import org.eclipse.xtext.junit4.ui.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.Bug348427TestLanguageUiModule;
import org.eclipse.xtext.util.Modules2;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractBug348427Test extends AbstractContentAssistProcessorTest {

	@Override
	public ISetup doGetSetup() {
		return new Bug348427TestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(Modules2.mixin(new Bug348427TestLanguageRuntimeModule(), new Bug348427TestLanguageUiModule(Activator
						.getInstance()), new SharedStateModule()));
			}
		};
	}
	
	@Test public void testEmptyDocument() throws Exception {
		super.newBuilder().assertText(
				"1.1", "1.2", "1.3", "1.4",  
				"2.1", "2.2", "2.3", "2.4", "2.5", "2.6", "2.7", "2.8");
	}
	
	@Test public void testExpectName() throws Exception {
		newBuilder().assertText("Name");
	}
	
	@Test public void testExpectColon() throws Exception {
		newBuilder().append("Name ").assertText(":");
	}
	
	@Test public void testDontProposeNext_1() throws Exception {
		newBuilder().append("Name : ").assertText("a", "b", "bool");
	}
	
	@Test public void testDontProposeNext_2() throws Exception {
		newBuilder().append("Name : bool keyword ").assertText("a", "b");
	}
	
	@Test public void testExpectChildKeyword_1() throws Exception {
		newBuilder().append("Name : a ").assertText("child1", "child2", "child3");
	}
	
	@Test public void testExpectChildKeyword_2() throws Exception {
		newBuilder().append("Name : b ").assertText("child1", "child2", "child3");
	}
	
	@Test public void testExpectChildKeyword_3() throws Exception {
		newBuilder().append("Name : bool keyword a ").assertText("child1", "child2", "child3");
	}
	
	@Test public void testExpectChildKeyword_4() throws Exception {
		newBuilder().append("Name : bool keyword b ").assertText("child1", "child2", "child3");
	}
	
	@Test public void testExpectEndKeyword_1() throws Exception {
		newBuilder().append("Name : a child1 ").assertText("end");
	}
	
	@Test public void testExpectEndKeyword_2() throws Exception {
		newBuilder().append("Name : b child2 ").assertText("end");
	}
	
	@Test public void testExpectEndKeyword_3() throws Exception {
		newBuilder().append("Name : bool keyword a child3 ").assertText("end");
	}
	
	@Test public void testExpectedKeyword() throws Exception {
		newBuilder().append("Name : bool ").assertText("keyword");
	}
	
	@Test public void testExpectNextKeyword_1() throws Exception {
		newBuilder().append("Name : a child1 end ").assertText("next");
	}
	
	@Test public void testExpectNextKeyword_2() throws Exception {
		newBuilder().append("Name : b child2 end ").assertText("next");
	}
	
	@Test public void testExpectNextKeyword_3() throws Exception {
		newBuilder().append("Name : bool keyword a child3 end ").assertText("next");
	}
	
	protected abstract String getScenario();
	
	@Override
	public ContentAssistProcessorTestBuilder newBuilder() throws Exception {
		return super.newBuilder().appendNl(getScenario());
	}
	
}
