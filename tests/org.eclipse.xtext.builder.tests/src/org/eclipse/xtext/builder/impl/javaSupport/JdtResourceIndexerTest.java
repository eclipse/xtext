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
import org.eclipse.jdt.core.IJarEntryResource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.builder.IResourceIndexer;
import org.eclipse.xtext.builder.builderState.BuilderState;
import org.eclipse.xtext.builder.builderState.BuilderStateManager;
import org.eclipse.xtext.builder.builderState.Container;
import org.eclipse.xtext.builder.builderState.ResourceDescriptor;
import org.eclipse.xtext.builder.impl.javasupport.JarWalker;
import org.eclipse.xtext.builder.impl.javasupport.JdtBuilderModule;
import org.eclipse.xtext.builder.impl.javasupport.JdtResourceIndexer;
import org.eclipse.xtext.ui.core.builder.internal.XtextNature;
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
	
	public void testAddFromJarFile() throws Exception{
		IJavaProject project = createJavaProject("foo");
		addNature(project.getProject(), XtextNature.NATURE_ID);
		IFile file = project.getProject().getFile("myjar.jar");
		file.create(jarInputStream(new TextFile("foo/bar."+EXT, "namespace foo { object bar }"),
								   new TextFile("foo2/bar2."+EXT, "namespace foo2 { object bar2 }")), true, monitor());
		addJarToClasspath(project, file);
		new JarWalker() {
			@Override
			protected void handle(IJarEntryResource jarEntry) {
				indexer.addOrUpdate(jarEntry);
			}
		}.traverseAllJars(project);
		
		stateManager.readOnly(new IUnitOfWork<Void, BuilderState>() {

			public java.lang.Void exec(BuilderState state) throws Exception {
				assertEquals(1,state.getContainers().size());
				Container container = state.getContainers().get(0);
				
				assertEquals("java:myjar.jar", container.getName());
				assertEquals("foo", container.getProject());
				
				assertEquals(2,container.getResourceDescriptors().size());
				
				ResourceDescriptor resourceDescriptor = container.getResourceDescriptors().get(0);
				System.out.println(resourceDescriptor.getURI());
				
				return null;
			}});
	}
	
	public void testAddAndUpdateFromJarFile() throws Exception{
		IJavaProject project = createJavaProject("foo");
		IFile file = project.getProject().getFile("myjar.jar");
		file.create(jarInputStream(new TextFile("foo/bar."+EXT, "namespace foo { object bar }"),
				new TextFile("foo2/bar2."+EXT, "namespace foo2 { object bar2 }")), true, monitor());
		addJarToClasspath(project, file);
		new JarWalker() {
			@Override
			protected void handle(IJarEntryResource jarEntry) {
				indexer.addOrUpdate(jarEntry);
			}
		}.traverseAllJars(project);
		
		stateManager.readOnly(new IUnitOfWork<Void, BuilderState>() {
			
			public java.lang.Void exec(BuilderState state) throws Exception {
				assertEquals(1,state.getContainers().size());
				Container container = state.getContainers().get(0);
				
				assertEquals("java:myjar.jar", container.getName());
				assertEquals("foo", container.getProject());
				
				assertEquals(2,container.getResourceDescriptors().size());
				
				ResourceDescriptor resourceDescriptor = container.getResourceDescriptors().get(0);
				System.out.println(resourceDescriptor.getURI());
				
				return null;
			}});
	}
	
	public void testSimpleAddInSourceFolder() throws Exception {
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
	
	public void testAddInMultipleSourceFolders() throws Exception {
		IJavaProject project = createJavaProject("foo");
		addSourceFolder(project, "src");
		addSourceFolder(project, "src-gen");
		IFile file1 = createFile("/foo/src/bar."+EXT, "namespace foo { object bar }");
		IFile file2 = createFile("/foo/src-gen/bar."+EXT, "namespace foo { object bar }");
		
		assertContents(indexer.addOrUpdate(file1), "foo","bar");
		assertContents(indexer.addOrUpdate(file2), "foo","bar");
		
		stateManager.readOnly(new IUnitOfWork<Void, BuilderState>() {
			
			public java.lang.Void exec(BuilderState state) throws Exception {
				assertEquals(2,state.getContainers().size());
				Container src = state.getContainers().get(0);
				Container src_gen = state.getContainers().get(1);
				
				assertEquals("java:src", src.getName());
				assertEquals("foo", src.getProject());
				assertEquals("java:src-gen", src_gen.getName());
				assertEquals("foo", src_gen.getProject());
				
				assertEquals(1,src.getResourceDescriptors().size());
				assertEquals(1,src_gen.getResourceDescriptors().size());
				return null;
			}});
	}
	
	public void testSimpleAdd() throws Exception {
		IJavaProject project = createJavaProject("foo");
		addSourceFolder(project, "src");
		IFile file1 = createFile("/foo/baz/bar."+EXT, "namespace foo { object bar }");
		
		assertContents(indexer.addOrUpdate(file1), "foo","bar");
		
		stateManager.readOnly(new IUnitOfWork<Void, BuilderState>() {
			
			public java.lang.Void exec(BuilderState state) throws Exception {
				assertEquals(1,state.getContainers().size());
				Container container = state.getContainers().get(0);
				
				assertEquals("foo", container.getName());
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

	public void testDeleteProject() throws Exception {
		IJavaProject project = createJavaProject("foo");
		addSourceFolder(project, "src");
		IFile file1 = createFile("/foo/bar."+EXT, "namespace foo { object bar }");
		IFile file2 = createFile("/foo/src/bar."+EXT, "namespace foo { object baz }");
		
		assertContents(indexer.addOrUpdate(file1), "foo","bar");
		assertContents(indexer.addOrUpdate(file2), "foo","baz");
		
		stateManager.readOnly(new IUnitOfWork<Void, BuilderState>() {
			
			public java.lang.Void exec(BuilderState state) throws Exception {
				assertEquals(2,state.getContainers().size());
				return null;
			}});

		assertContents(indexer.cleanProject("foo"), "foo", "bar","baz");
		
		stateManager.readOnly(new IUnitOfWork<Void, BuilderState>() {
			
			public java.lang.Void exec(BuilderState state) throws Exception {
				assertEquals(0,state.getContainers().size());
				return null;
			}});
		
	}
	
}
