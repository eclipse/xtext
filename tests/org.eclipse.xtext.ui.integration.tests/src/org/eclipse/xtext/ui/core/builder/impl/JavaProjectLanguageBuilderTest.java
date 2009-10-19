/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.builder.impl;

import static org.eclipse.xtext.junit.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.junit.util.JavaProjectSetupUtil.*;

import java.io.File;
import java.io.InputStream;

import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.emfindex.ContainerDescriptor;
import org.eclipse.emf.emfindex.EObjectDescriptor;
import org.eclipse.emf.emfindex.EReferenceDescriptor;
import org.eclipse.emf.emfindex.Index;
import org.eclipse.emf.emfindex.ResourceDescriptor;
import org.eclipse.emf.emfindex.query.ContainerDescriptorQuery;
import org.eclipse.emf.emfindex.query.EObjectDescriptorQuery;
import org.eclipse.emf.emfindex.query.EReferenceDescriptorQuery;
import org.eclipse.emf.emfindex.query.QueryCommand;
import org.eclipse.emf.emfindex.query.QueryExecutor;
import org.eclipse.emf.emfindex.query.QueryResult;
import org.eclipse.emf.emfindex.query.ResourceDescriptorQuery;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.ui.core.builder.internal.XtextNature;
import org.eclipse.xtext.ui.core.index.IndexAccess;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.util.StringInputStream;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JavaProjectLanguageBuilderTest extends TestCase {
	
	@Override
	protected void setUp() throws Exception {
		assertEquals(0,countResourcesInIndex());
		assertEquals(0,root().getProjects().length);
		super.setUp();
	}
	
	@Override
	protected void tearDown() throws Exception {
		cleanWorkspace();
		waitForAutoBuild();
		super.tearDown();
	}

	public void testTwoReferencedFilesInSameProject() throws Exception {
		IJavaProject project = createJavaProject("foo");
		addNature(project.getProject(), XtextNature.NATURE_ID);
		IFolder folder = addSourceFolder(project, "src");
		IFile file = folder.getFile("Foo.testlanguage");
		file.create(new StringInputStream("stuff Foo"), true, monitor());
		IFile fileB = folder.getFile("Boo.testlanguage");
		fileB.create(new StringInputStream("stuff Bar refs Foo"), true, monitor());

		waitForAutoBuild();
		assertTrue(indexContainsElement("Foo"));
		assertTrue(indexContainsElement("Bar"));
		assertIsReferenced("Foo",1);
		assertEquals(2, countResourcesInIndex());

		IMarker[] markers = fileB.findMarkers(EValidator.MARKER, true, IResource.DEPTH_ONE);
		assertEquals(printMarker(markers), 0, markers.length);
	}
	
	public void testMoveReferencedFileOutOfSourceFolder() throws Exception {
		IJavaProject project = createJavaProject("foo");
		addNature(project.getProject(), XtextNature.NATURE_ID);
		IFolder folder = addSourceFolder(project, "src");
		IFile file = folder.getFile("Foo.testlanguage");
		file.create(new StringInputStream("stuff Foo"), true, monitor());
		IFile fileB = folder.getFile("Boo.testlanguage");
		fileB.create(new StringInputStream("stuff Bar refs Foo"), true, monitor());
		
		waitForAutoBuild();
		assertTrue(indexContainsElement("Foo"));
		assertTrue(indexContainsElement("Bar"));
		assertIsReferenced("Foo",1);
		assertEquals(2, countResourcesInIndex());
		
		IMarker[] markers = fileB.findMarkers(EValidator.MARKER, true, IResource.DEPTH_ONE);
		assertEquals(printMarker(markers), 0, markers.length);
		
		file.move(new Path("foo"), true, monitor());
		waitForAutoBuild();
		assertEquals(1, countResourcesInIndex());
		assertTrue(indexContainsElement("Bar"));
		assertFalse(indexContainsElement("Foo"));
		
		markers = fileB.findMarkers(EValidator.MARKER, true, IResource.DEPTH_ONE);
		assertEquals(printMarker(markers), 1, markers.length);
	}
	
	public void testMakeExistingFolderToSourceFolder() throws Exception {
		IJavaProject project = createJavaProject("foo");
		addNature(project.getProject(), XtextNature.NATURE_ID);
		IFolder folder = deleteSourceFolder(project,"src");
		folder.create(true, true, monitor());
		IFile file = folder.getFile("Foo.testlanguage");
		file.create(new StringInputStream("stuff Foo"), true, monitor());
		IFile fileB = folder.getFile("Boo.testlanguage");
		fileB.create(new StringInputStream("stuff Bar refs Foo"), true, monitor());
		
		waitForAutoBuild();
		assertEquals(0, countResourcesInIndex());
		
		IClasspathEntry srcFolderClasspathEntry = JavaCore
		.newSourceEntry(folder.getFullPath());
		addToClasspath(project, srcFolderClasspathEntry);
		
		waitForAutoBuild();
		assertTrue(indexContainsElement("Foo"));
		assertTrue(indexContainsElement("Bar"));
		assertIsReferenced("Foo",1);
		assertEquals(2, countResourcesInIndex());
	}
	
	public void testReferencingFilesInDifferentProjects() throws Exception {
		IJavaProject p_foo = createJavaProject("foo");
		IJavaProject p_bar = createJavaProject("bar");
		addNature(p_foo.getProject(), XtextNature.NATURE_ID);
		addNature(p_bar.getProject(), XtextNature.NATURE_ID);
		
		createFile("foo/src/Foo.testlanguage", "stuff Foo");
		IFile bar = createFile("bar/src/Bar.testlanguage", "stuff Bar refs Foo");
		
		waitForAutoBuild();
		assertTrue(indexContainsElement("Foo"));
		assertTrue(indexContainsElement("Bar"));
		assertIsReferenced("Foo",0);
		assertEquals(2, countResourcesInIndex());
		assertEquals(1,bar.findMarkers(EValidator.MARKER, true, IResource.DEPTH_ONE).length);
		
		addProjectReference(p_bar.getProject(), p_foo.getProject());
		waitForAutoBuild();
		assertIsReferenced("Foo",1);
		assertEquals(0,bar.findMarkers(EValidator.MARKER, true, IResource.DEPTH_ONE).length);
	}
	
	public void testDeleteProject() throws Exception {
		IJavaProject p_foo = createJavaProject("foo");
		addNature(p_foo.getProject(), XtextNature.NATURE_ID);
		createFile("foo/src/Foo.testlanguage", "stuff Foo");
		
		waitForAutoBuild();
		assertTrue(indexContainsElement("Foo"));
		
		p_foo.getProject().delete(true, true, monitor());
		waitForAutoBuild();
		assertFalse(indexContainsElement("Foo"));
	}
	
	public void testDeleteReferencedProject() throws Exception {
		IJavaProject p_foo = createJavaProject("foo");
		IJavaProject p_bar = createJavaProject("bar");
		addNature(p_foo.getProject(), XtextNature.NATURE_ID);
		addNature(p_bar.getProject(), XtextNature.NATURE_ID);
		addProjectReference(p_bar.getProject(), p_foo.getProject());
		
		createFile("foo/src/Foo.testlanguage", "stuff Foo");
		IFile bar = createFile("bar/src/Bar.testlanguage", "stuff Bar refs Foo");
		
		waitForAutoBuild();
		assertTrue(indexContainsElement("Foo"));
		assertTrue(indexContainsElement("Bar"));
		assertIsReferenced("Foo",1);
		assertEquals(2, countResourcesInIndex());
		assertEquals(0,bar.findMarkers(EValidator.MARKER, true, IResource.DEPTH_ONE).length);

		// delete
		p_foo.getProject().delete(true, true, monitor());
		waitForAutoBuild();
		assertFalse(indexContainsElement("Foo"));
		assertTrue(indexContainsElement("Bar"));
		assertIsReferenced("Foo",0);
		assertEquals(1, countResourcesInIndex());
//TODO		assertEquals(1,bar.findMarkers(EValidator.MARKER, true, IResource.DEPTH_ONE).length);
		
	}
	
	public void testCloseProject() throws Exception {
		IJavaProject p_foo = createJavaProject("foo");
		addNature(p_foo.getProject(), XtextNature.NATURE_ID);
		createFile("foo/src/Foo.testlanguage", "stuff Foo");
		
		waitForAutoBuild();
		assertTrue(indexContainsElement("Foo"));
		
		p_foo.getProject().close(monitor());
		waitForAutoBuild();
		assertFalse(indexContainsElement("Foo"));
	}
	
	public void testOpenClosedProject() throws Exception {
		IJavaProject p_foo = createJavaProject("foo");
		addNature(p_foo.getProject(), XtextNature.NATURE_ID);
		createFile("foo/src/Foo.testlanguage", "stuff Foo");
		
		waitForAutoBuild();
		assertTrue(indexContainsElement("Foo"));
		
		p_foo.getProject().close(monitor());
		waitForAutoBuild();
		assertFalse(indexContainsElement("Foo"));
		
		//TODO handle project open
//		p_foo.getProject().open(monitor());
//		waitForAutoBuild();
//		assertTrue(indexContainsElement("Foo"));
	}
	
	public void testCloseReferencedProject() throws Exception {
		IJavaProject p_foo = createJavaProject("foo");
		IJavaProject p_bar = createJavaProject("bar");
		addNature(p_foo.getProject(), XtextNature.NATURE_ID);
		addNature(p_bar.getProject(), XtextNature.NATURE_ID);
		addProjectReference(p_bar.getProject(), p_foo.getProject());
		
		createFile("foo/src/Foo.testlanguage", "stuff Foo");
		IFile bar = createFile("bar/src/Bar.testlanguage", "stuff Bar refs Foo");
		
		waitForAutoBuild();
		assertTrue(indexContainsElement("Foo"));
		assertTrue(indexContainsElement("Bar"));
		assertIsReferenced("Foo",1);
		assertEquals(2, countResourcesInIndex());
		assertEquals(0,bar.findMarkers(EValidator.MARKER, true, IResource.DEPTH_ONE).length);

		// delete
		p_foo.getProject().close(monitor());
		waitForAutoBuild();
		assertFalse(indexContainsElement("Foo"));
		assertTrue(indexContainsElement("Bar"));
		assertIsReferenced("Foo",0);
		assertEquals(1, countResourcesInIndex());
//TODO		assertEquals(1,bar.findMarkers(EValidator.MARKER, true, IResource.DEPTH_ONE).length);
	}
	
	public void testProjectWithExternalJar() throws Exception {
		IJavaProject p_foo = createJavaProject("foo");
		addNature(p_foo.getProject(), XtextNature.NATURE_ID);
		waitForAutoBuild();
		
		InputStream data = getClass().getResourceAsStream(getClass().getSimpleName()+".jar");
		File tempFile = createExternalJar(data,"externalLib");
		IClasspathEntry entry = JavaCore.newLibraryEntry(new Path(tempFile.getCanonicalPath()),null,null);
		addToClasspath(p_foo, entry);
		
		waitForAutoBuild();
		assertTrue(indexContainsElement("Foo"));
		assertEquals(1, countResourcesInIndex());
	}
	
	public void testProjectWithLocalJar() throws Exception {
		IJavaProject p_foo = createJavaProject("foo");
		addNature(p_foo.getProject(), XtextNature.NATURE_ID);
		IFile file = p_foo.getProject().getFile("my.jar");
		file.create(getClass().getResourceAsStream(getClass().getSimpleName()+".jar"), true, monitor());
		waitForAutoBuild();
		addJarToClasspath(p_foo, file);
		
		waitForAutoBuild();
		assertTrue(indexContainsElement("Foo"));
		assertEquals(1, countResourcesInIndex());
	}
	
	public void testReferenceWithinProjectWithLocalJar() throws Exception {
		IJavaProject p_foo = createJavaProject("foo");
		addNature(p_foo.getProject(), XtextNature.NATURE_ID);
		IFile file = p_foo.getProject().getFile("my.jar");
		file.create(getClass().getResourceAsStream(getClass().getSimpleName()+".jar"), true, monitor());
		waitForAutoBuild();
		addJarToClasspath(p_foo, file);
		waitForAutoBuild();

		createFile("foo/src/Bar.testlanguage","stuff Bar refs Foo");
		waitForAutoBuild();

		assertTrue(indexContainsElement("Foo"));
		assertTrue(indexContainsElement("Bar"));
		assertIsReferenced("Foo",1);
		assertEquals(2, countResourcesInIndex());
	}
	
	
	@SuppressWarnings("unused")
	private String toString(Index index) {
		return index.executeQueryCommand(new QueryCommand<String>() {

			public String execute(QueryExecutor queryExecutor) {
				ContainerDescriptorQuery descriptorQuery = new ContainerDescriptorQuery();
				QueryResult<ContainerDescriptor> result = queryExecutor.execute(descriptorQuery);
				StringBuffer buff = new StringBuffer();
				for (ContainerDescriptor containerDescriptor : result) {
					buff.append(EmfFormatter.objToStr(containerDescriptor, new EStructuralFeature[0]));
				}
				return buff.toString();
			}
		});
	}

	private void assertIsReferenced(final String name, final int i) {
		assertEquals((Integer)i,IndexAccess.getIndex().executeQueryCommand(new QueryCommand<Integer>() {

			public Integer execute(QueryExecutor queryExecutor) {
				EObjectDescriptorQuery oquery = new EObjectDescriptorQuery();
				oquery.setNameEquals(name);
				QueryResult<EObjectDescriptor> result = queryExecutor.execute(oquery);
				if (result.isEmpty()) {
					return 0;
				}
				EObjectDescriptor next = result.iterator().next();
				
				EReferenceDescriptorQuery query = new EReferenceDescriptorQuery();
				query.setTargetResourceURIEquals(next.getResourceDescriptor().getURI());
				query.setTargetFragmentEquals(next.getFragment());
				
				QueryResult<EReferenceDescriptor> refDesc = queryExecutor.execute(query);
				int count = 0;
				for (@SuppressWarnings("unused") EReferenceDescriptor ref : refDesc) {
					count++;
				}
				return count;
			}
		}));
		
	}

	private boolean indexContainsElement(final String name) {
		return IndexAccess.getIndex().executeQueryCommand(new QueryCommand<Boolean>() {

			public Boolean execute(QueryExecutor queryExecutor) {
				EObjectDescriptorQuery query = new EObjectDescriptorQuery();
				query.setNameEquals(name);
				QueryResult<EObjectDescriptor> result = queryExecutor.execute(query);
				for (@SuppressWarnings("unused") EObjectDescriptor d : result) {
//					System.out.println(d.getName()+" : "+d.getFragmentURI());
				}
				return !result.isEmpty();
			}
		});
	}

	private int countResourcesInIndex() {
		int numberOfResources = IndexAccess.getIndex().executeQueryCommand(new QueryCommand<Integer>() {

			public Integer execute(QueryExecutor queryExecutor) {
				QueryResult<ResourceDescriptor> result = queryExecutor.execute(new ResourceDescriptorQuery());
				int count = 0;
				for (@SuppressWarnings("unused") ResourceDescriptor rsd : result) {
//					System.out.println(rsd.getURI());
					count++;
				}
				return count;
			}
		});
		return numberOfResources;
	}

	private String printMarker(IMarker[] markers) throws CoreException {
		String s = "";
		for (IMarker iMarker : markers) {
			s += "," + iMarker.getAttribute(IMarker.MESSAGE);
		}
		return s;
	}
}
