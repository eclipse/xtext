/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl.javaSupport;

import static org.eclipse.xtext.junit.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.junit.util.JavaProjectSetupUtil.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.builder.IResourceIndexer;
import org.eclipse.xtext.builder.builderState.BuilderState;
import org.eclipse.xtext.builder.builderState.BuilderStateManager;
import org.eclipse.xtext.builder.builderState.Container;
import org.eclipse.xtext.builder.impl.javasupport.JdtBuilderModule;
import org.eclipse.xtext.builder.impl.javasupport.JdtResourceIndexer;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class JdtResourceIndexerTest extends TestCase {
	
	private static final String EXT = "buildertestlanguage";
	private JdtResourceIndexer indexer;
	private BuilderStateManager stateManager;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Injector injector = Guice.createInjector(new JdtBuilderModule());
		indexer = (JdtResourceIndexer) injector.getInstance(IResourceIndexer.class);
		stateManager = injector.getInstance(BuilderStateManager.class);
	}
	
	public void testSimpleAdd() throws Exception {
		IJavaProject project = createJavaProject("foo");
		addSourceFolder(project, "src");
		IFile file1 = createFile("/foo/src/bar."+EXT, "namespace foo { object bar }");
		
		assertContents(indexer.addOrUpdate(file1), "foo","bar");
		
		stateManager.readOnly(new IUnitOfWork<Void, BuilderState>() {

			public java.lang.Void exec(BuilderState state) throws Exception {
				assertEquals(1,state.getContainers().size());
				Container container = state.getContainers().get(0);
				
				assertEquals("java:src", container.getName());
				assertEquals("foo", container.getProject());
				
				return null;
			}});
	}
	
	protected <T> void assertContents(Set<T> setOfElements, T ...elements) {
		for (T ele: elements) {
			assertTrue("set does not contain '"+ele+"'",setOfElements.contains(ele));
		}
		List<T> elementsAsList = Arrays.asList(elements);
		Set<T> copyOfSet = new HashSet<T>(setOfElements);
		copyOfSet.removeAll(elementsAsList);
		assertTrue("unmatched elements :"+copyOfSet,copyOfSet.isEmpty());
	}

	
}
