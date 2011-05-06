/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.common.types.access.jdt.MockJavaProjectProvider;
import org.eclipse.xtext.common.types.tests.AbstractActivator;
import org.eclipse.xtext.common.types.xtext.ui.ui.ContentAssistTestLanguageUiModule;
import org.eclipse.xtext.ui.junit.editor.contentassist.AbstractContentAssistProcessorTest;
import org.eclipse.xtext.ui.junit.editor.contentassist.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ContentAssistTest extends AbstractContentAssistProcessorTest {

	public ISetup getSetup() {
		return new ContentAssistTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(Modules2.mixin(
						new ContentAssistTestLanguageRuntimeModule(),
						new ContentAssistTestLanguageUiModule(AbstractActivator.getInstance()) {
							@Override
							public Class<? extends IJavaProjectProvider> bindIJavaProjectProvider() {
								return MockJavaProjectProvider.class;
							}
						}, 
						new SharedStateModule()));
			}
		};
	}
	
	public void testDefaultArrayList_01() throws Exception {
		newBuilder().append("default ArrayLis").assertText("java.util.ArrayList", "com.google.common.collect.ArrayListMultimap");
	}
	
	public void testDefaultArrayList_02() throws Exception {
		newBuilder().append("import java.util.* default ArrayLis").assertText("ArrayList", "com.google.common.collect.ArrayListMultimap");
	}

	public void testDefaultBlockingQueue_01() throws Exception {
		newBuilder().append("import java.util.* default BlockingQ").assertText("concurrent.BlockingQueue");
	}
	
	public void testDefaultBlockingQueue_02() throws Exception {
		newBuilder().append("import java.* default BlockingQ").assertText("util.concurrent.BlockingQueue");
	}
	
	public void testCustomArrayList_01() throws Exception {
		newBuilder().append("custom ArrayLis").assertText("java.util.ArrayList", "com.google.common.collect.ArrayListMultimap");
	}
	
	public void testCustomArrayList_02() throws Exception {
		newBuilder().append("import java.util.* custom ArrayLis").assertText("ArrayList", "com.google.common.collect.ArrayListMultimap");
	}
	
	public void testCustomArrayList_03() throws Exception {
		newBuilder().append("import java.util.* custom java.util.ArrayLis").assertText("ArrayList");
	}

	public void testCustomBlockingQueue_01() throws Exception {
		newBuilder().append("import java.util.* custom BlockingQ").assertText("concurrent.BlockingQueue");
	}
	
	public void testCustomBlockingQueue_02() throws Exception {
		newBuilder().append("import java.* custom BlockingQ").assertText("util.concurrent.BlockingQueue");
	}
	
	public void testCustomBlockingQueue_03() throws Exception {
		newBuilder().append("import java.* custom concurrent.BlockingQ").assertText("util.concurrent.BlockingQueue");
	}
	
	public void testSubtypeArrayList_01() throws Exception {
		newBuilder().append("subtype ArrayLis").assertText("java.util.ArrayList");
	}
	
	public void testSubtypeArrayList_02() throws Exception {
		newBuilder().append("import java.util.* subtype ArrayLis").assertText("ArrayList");
	}

	public void testSubtypeBlockingQueue_01() throws Exception {
		newBuilder().append("import java.util.* subtype BlockingQ").assertText("concurrent.BlockingQueue");
	}
	
	public void testSubtypeBlockingQueue_02() throws Exception {
		newBuilder().append("import java.* subtype BlockingQ").assertText("util.concurrent.BlockingQueue");
	}
	
	public void testSubtypeBlockingQueue_03() throws Exception {
		newBuilder().append("import java.* subtype concurrent.BlockingQ").assertText("util.concurrent.BlockingQueue");
	}
	
	public void testMap_01() throws Exception {
		newBuilder().append("import java.util.* import javax.swing.text.html.* custom java.util.Map").assertText(
				"java.util.Map");
	}
	
	public void testMap_02() throws Exception {
		newBuilder().append("import javax.swing.text.html.* import java.util.* custom java.util.Map").assertText(
				"java.util.Map");
	}
	
	public void testMap_03() throws Exception {
		newBuilder().append("import java.util.* custom java.util.Map").assertText("Map");
	}
	
	protected ContentAssistProcessorTestBuilder newBuilder() throws Exception {
		return newBuilder(getSetup());
	}
	
}
