/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.noJdt;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class TwoProjectsTest extends AbstractBuilderTest {

	private IProject first;
	private IFile firstFile;
	
	private IProject second;
	private IFile secondFile;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		first = createEmptyProject("first");
		second = createEmptyProject("second");
	}
	
	protected void addProjectReference(IProject from, IProject referencedProject) throws CoreException {
		IProjectDescription description = from.getDescription();
		description.setReferencedProjects(new IProject[] { referencedProject });
		from.setDescription(description, null);
	}
	
	protected void removeProjectReference(IProject from) throws CoreException {
		IProjectDescription description = from.getDescription();
		description.setReferencedProjects(new IProject[0]);
		from.setDescription(description, null);
	}
	
	@Override
	public void tearDown() throws Exception {
		first = null;
		firstFile = null;
		second = null;
		secondFile = null;
		super.tearDown();
	}
	
	@Test public void testTwoFilesInTwoReferencedProjects() throws Exception {
		createTwoFilesInTwoReferencedProjects();
	}

	@Test public void testTwoFilesInTwoReferencedProjectsRemoveNature() throws Exception {
		createTwoFilesInTwoReferencedProjects();
		removeNature(first, XtextProjectHelper.NATURE_ID);
		waitForAutoBuild();
		assertEquals(1, countMarkers(secondFile));
	}

	@Test public void testTwoFilesInTwoReferencedProjectsAddNature() throws Exception {
		removeNature(first, XtextProjectHelper.NATURE_ID);
		firstFile = createFile("first/first" + F_EXT, "Hello First!");
		secondFile = createFile("second/second" + F_EXT, "Hello Second ( from First )!");
		waitForAutoBuild();
		assertEquals(printMarkers(firstFile), 0, countMarkers(firstFile));
		assertEquals(printMarkers(secondFile), 1, countMarkers(secondFile));
		addProjectReference(second, first);
		waitForAutoBuild();
		assertEquals(printMarkers(firstFile), 0, countMarkers(firstFile));
		assertEquals(printMarkers(secondFile), 1, countMarkers(secondFile));
		addNature(first.getProject(), XtextProjectHelper.NATURE_ID);
		waitForAutoBuild();
		assertEquals(printMarkers(firstFile), 0, countMarkers(firstFile));
		assertEquals(printMarkers(secondFile), 0, countMarkers(secondFile));
	}

	protected void createTwoFilesInTwoReferencedProjects() throws Exception {
		firstFile = createFile("first/first" + F_EXT, "Hello First!");
		secondFile = createFile("second/second" + F_EXT, "Hello Second ( from First )!");
		waitForAutoBuild();
		addProjectReference(second, first);
		waitForAutoBuild();
		assertEquals(0, countMarkers(firstFile));
		assertEquals(0, countMarkers(secondFile));
	}

	@Test public void testTwoFilesInTwoInversedReferencedProjects() throws Exception {
		createTwoFilesInTwoReferencedProjects();
		removeProjectReference(second);
		waitForAutoBuild();
		addProjectReference(first, second);
		waitForAutoBuild();
		assertEquals(0, countMarkers(firstFile));
		assertEquals(1, countMarkers(secondFile));
	}

	@Test public void testTwoFilesInTwoNonReferencedProjects() throws Exception {
		createTwoFilesInTwoReferencedProjects();
		removeProjectReference(second);

		waitForAutoBuild();
		assertEquals(0, countMarkers(firstFile));
		assertEquals(1, countMarkers(secondFile));
	}

	@Test public void testChangeReferenceOfProjects() throws Exception {
		createTwoFilesInTwoReferencedProjects();
		removeProjectReference(second);
		waitForAutoBuild();
		assertEquals(0, countMarkers(firstFile));
		assertEquals(1, countMarkers(secondFile));
		addProjectReference(second, first);
		waitForAutoBuild();
		assertEquals(0, countMarkers(firstFile));
		assertEquals(0, countMarkers(secondFile));
	}

	@Test public void testOpenAndCloseReferencedProjects() throws Exception {
		createTwoFilesInTwoReferencedProjects();
		// close project
		first.getProject().close(monitor());
		waitForAutoBuild();
		assertEquals(1, countMarkers(secondFile));
		first.getProject().open(monitor());
		waitForAutoBuild();
		assertEquals(printMarkers(secondFile), 0, countMarkers(secondFile));
	}

	@Test public void testChangeReferencedFile() throws Exception {
		createTwoFilesInTwoReferencedProjects();

		// change referenced file
		firstFile.setContents(new StringInputStream("Hello Third!"), true, true, monitor());
		waitForAutoBuild();
		assertEquals(1, countMarkers(secondFile));

		//change back to valid state
		firstFile.setContents(new StringInputStream("Hello First!"), true, true, monitor());
		waitForAutoBuild();
		assertEquals(0, countMarkers(secondFile));
	}

	@Test public void testDeleteReferencedFile() throws Exception {
		createTwoFilesInTwoReferencedProjects();

		// delete referenced file
		firstFile.delete(true, new NullProgressMonitor());
		waitForAutoBuild();
		assertEquals(1, countMarkers(secondFile));

		// create new
		firstFile = createFile("first/first" + F_EXT, "Hello First!");
		waitForAutoBuild();
		assertEquals(0, countMarkers(firstFile));
		assertEquals(0, countMarkers(secondFile));
	}

//	@Test public void testUpdateOfReferencedFile() throws Exception {
//		IJavaProject project = createJavaProject("foo");
//		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
//		IFolder folder = project.getProject().getFolder("src");
//		IFile file = folder.getFile("Foo" + F_EXT);
//		file.create(new StringInputStream("object Foo"), true, monitor());
//		IFile fileB = folder.getFile("Boo" + F_EXT);
//		fileB.create(new StringInputStream("object Bar references Foo"), true, monitor());
//		waitForAutoBuild();
//		assertTrue(indexContainsElement(file.getFullPath().toString(), "Foo"));
//		assertTrue(indexContainsElement(fileB.getFullPath().toString(), "Bar"));
//		assertEquals(2, countResourcesInIndex());
//
//		getBuilderState().addListener(this);
//		file.setContents(new StringInputStream("object Foo"), true, true, monitor());
//		waitForAutoBuild();
//		assertEquals(1, getEvents().get(0).getDeltas().size());
//		assertNumberOfMarkers(fileB, 0);
//		assertEquals(1, getIncomingReferences(URI.createPlatformResourceURI("foo/src/Foo" + F_EXT, true)).size());
//
//		file.setContents(new StringInputStream("object Fop"), true, true, monitor());
//		waitForAutoBuild();
//		assertEquals(2, getEvents().get(1).getDeltas().size());
//		assertNumberOfMarkers(fileB, 1);
//		assertEquals(0, getIncomingReferences(URI.createPlatformResourceURI("foo/src/Foo" + F_EXT, true)).size());
//
//		file.setContents(new StringInputStream("object Foo"), true, true, monitor());
//		waitForAutoBuild();
//		assertEquals(2, getEvents().get(2).getDeltas().size());
//		assertNumberOfMarkers(fileB, 0);
//
//		file.setContents(new StringInputStream("object Foo"), true, true, monitor());
//		waitForAutoBuild();
//		assertEquals(1, getEvents().get(3).getDeltas().size());
//		assertNumberOfMarkers(fileB, 0);
//	}
//
//	@Test public void testDeleteFile() throws Exception {
//		IJavaProject project = createJavaProject("foo");
//		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
//		IFolder folder = project.getProject().getFolder("src");
//		IFile file = folder.getFile("Foo" + F_EXT);
//		file.create(new StringInputStream("object Foo"), true, monitor());
//		waitForAutoBuild();
//		assertTrue(indexContainsElement(file.getFullPath().toString(), "Foo"));
//		assertEquals(1, countResourcesInIndex());
//
//		getBuilderState().addListener(this);
//		file.delete(true, monitor());
//		waitForAutoBuild();
//		assertEquals(1, getEvents().get(0).getDeltas().size());
//		assertNull(getEvents().get(0).getDeltas().get(0).getNew());
//		assertEquals(0, countResourcesInIndex());
//	}

//	@Test public void testCleanBuild() throws Exception {
//		IJavaProject project = createJavaProject("foo");
//		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
//		IFolder folder = project.getProject().getFolder("src");
//		IFile file = folder.getFile("Foo" + F_EXT);
//		file.create(new StringInputStream("object Foo"), true, monitor());
//		waitForAutoBuild();
//		assertTrue(indexContainsElement(file.getFullPath().toString(), "Foo"));
//		assertEquals(1, countResourcesInIndex());
//
//		getBuilderState().addListener(this);
//		project.getProject().build(IncrementalProjectBuilder.CLEAN_BUILD, monitor());
//		waitForAutoBuild();
//		// clean build should first remove the IResourceDescriptor and then add it again  
//		assertEquals(2, getEvents().size());
//		assertEquals(1, getEvents().get(0).getDeltas().size());
//		assertNotNull(getEvents().get(0).getDeltas().get(0).getOld());
//		assertNull(getEvents().get(0).getDeltas().get(0).getNew());
//		assertEquals(1, getEvents().get(1).getDeltas().size());
//		assertNull(getEvents().get(1).getDeltas().get(0).getOld());
//		assertNotNull(getEvents().get(1).getDeltas().get(0).getNew());
//	}
//
//	@Test public void testCleanIsNotTransitive() throws Exception {
//		createTwoFilesInTwoReferencedProjects();
//		waitForAutoBuild();
//		assertTrue(indexContainsElement(firstFile.getFullPath().toString(), "Foo"));
//		assertTrue(indexContainsElement(secondFile.getFullPath().toString(), "Bar"));
//		first.getProject().build(IncrementalProjectBuilder.CLEAN_BUILD, monitor());
//		assertFalse(indexContainsElement(firstFile.getFullPath().toString(), "Foo"));
//		assertTrue(indexContainsElement(secondFile.getFullPath().toString(), "Bar"));
//		waitForAutoBuild();
//		assertTrue(indexContainsElement(firstFile.getFullPath().toString(), "Foo"));
//		assertTrue(indexContainsElement(secondFile.getFullPath().toString(), "Bar"));
//	}
//
//	@Test public void testCleanRemovesMarkers() throws Exception {
//		IJavaProject javaProject = createJavaProjectWithRootSrc("foo");
//		IFile file = createFile("foo/src/bar" + F_EXT, "object Bar references Foo");
//		waitForAutoBuild();
//		assertEquals(printMarkers(file), 1, countMarkers(file));
//		javaProject.getProject().build(IncrementalProjectBuilder.CLEAN_BUILD, monitor());
//		assertEquals(printMarkers(file), 0, countMarkers(file));
//		waitForAutoBuild();
//		assertEquals(printMarkers(file), 1, countMarkers(file));
//	}
//
//	@Test public void testFileInJar() throws Exception {
//		IJavaProject project = createJavaProject("foo");
//		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
//		IFile file = project.getProject().getFile("foo.jar");
//		file.create(jarInputStream(new TextFile("foo/Bar" + F_EXT, "object Foo")), true, monitor());
//		assertEquals(0, countResourcesInIndex());
//		addJarToClasspath(project, file);
//		waitForAutoBuild();
//		assertEquals(1, countResourcesInIndex());
//	}
//
//	@Test public void testFullBuild() throws Exception {
//		IJavaProject project = createJavaProject("foo");
//		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
//		IProject someProject = createProject("bar");
//		IFile file = someProject.getFile("foo.jar");
//		file.create(jarInputStream(new TextFile("foo/Bar" + F_EXT, "object Foo")), true, monitor());
//		assertEquals(0, countResourcesInIndex());
//		addJarToClasspath(project, file);
//		waitForAutoBuild();
//		assertEquals(1, countResourcesInIndex());
//
//		getBuilderState().addListener(this);
//		fullBuild();
//		assertEquals(1, countResourcesInIndex());
//		//		System.out.println(print(getEvents().get(0).getDeltas()));
//		assertEquals(1, getEvents().size());
//	}

	

//	@Test public void testEvents() throws Exception {
//		IJavaProject project = createJavaProject("foo");
//		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
//		IProject someProject = createProject("bar");
//		IFile file = someProject.getFile("foo.jar");
//		file.create(jarInputStream(new TextFile("foo/Bar" + F_EXT, "object Foo")), true, monitor());
//		addJarToClasspath(project, file);
//		waitForAutoBuild();
//		//		JavaCore.addElementChangedListener(new IElementChangedListener() {
//		//			
//		//			public void elementChanged(ElementChangedEvent event) {
//		//				System.out.println(event);
//		//			}
//		//		});
//		someProject.delete(true, monitor());
//	}

//	@Test public void testIgnoreFilesInOutputFolder() throws Exception {
//		IJavaProject javaProject = createJavaProjectWithRootSrc("foo");
//		createFile("foo/src/foo" + F_EXT, "object Foo ");
//		createFile("foo/bar" + F_EXT, "object Bar references Foo");
//		waitForAutoBuild();
//		IProject project = javaProject.getProject();
//		IResource resourceFromBin = project.findMember(new Path("/bin/foo" + F_EXT));
//		assertNotNull(resourceFromBin);
//		assertTrue(resourceFromBin instanceof IStorage);
//		assertTrue(resourceFromBin.exists());
//		IResourceUIServiceProvider serviceProvider = getInstance(IResourceUIServiceProvider.class);
//		URI fakeBinURI = URI.createPlatformResourceURI("/" + project.getName() + "/bin/foo" + F_EXT, true);
//		assertFalse(serviceProvider.canHandle(fakeBinURI, (IStorage) resourceFromBin));
//		assertTrue(serviceProvider.canHandle(fakeBinURI));
//		IResource resourceFromRoot = project.findMember(new Path("/bar" + F_EXT));
//		assertNotNull(resourceFromRoot);
//		assertTrue(resourceFromRoot instanceof IStorage);
//		URI fromRootURI = URI.createPlatformResourceURI("/" + project.getName() + "/bar" + F_EXT, true);
//		assertFalse(serviceProvider.canHandle(fromRootURI, (IStorage) resourceFromBin));
//		assertTrue(serviceProvider.canHandle(fromRootURI));
//	}
//
//	@SuppressWarnings("deprecation")
//	@Test public void testModelWithSyntaxErrorInDerivedSrcFolder() throws Exception {
//		IJavaProject javaProject = createJavaProjectWithRootSrc("foo");
//		IProject project = javaProject.getProject();
//		IFolder sourceFolder = project.getFolder("src");
//		sourceFolder.setDerived(true);
//		IFile file = createFile("foo/src/foo" + F_EXT, "objekt Foo ");
//		file.setDerived(true);
//		waitForAutoBuild();
//		assertEquals(1, countMarkers(file));
//		file.setContents(new StringInputStream("object Foo"), true, true, monitor());
//		assertTrue(file.isDerived());
//		waitForAutoBuild();
//		assertEquals(0, countMarkers(file));
//	}
//
//	@SuppressWarnings("deprecation")
//	@Test public void testModelWithSyntaxErrorInDerivedFolder() throws Exception {
//		IJavaProject javaProject = createJavaProjectWithRootSrc("foo");
//		IProject project = javaProject.getProject();
//		IFolder folder = project.getFolder("non-src");
//		folder.create(true, true, monitor());
//		folder.setDerived(true);
//		IFile file = createFile("foo/non-src/foo" + F_EXT, "objekt Foo ");
//		file.setDerived(true);
//		waitForAutoBuild();
//		assertEquals(1, countMarkers(file));
//		file.setContents(new StringInputStream("object Foo"), true, true, monitor());
//		assertTrue(file.isDerived());
//		waitForAutoBuild();
//		assertEquals(0, countMarkers(file));
//	}

	@Test public void testOpenAndCloseReferencedProjectsTogether_01() throws Exception {
		createTwoFilesInTwoReferencedProjects();
		waitForAutoBuild();
		assertEquals(printMarkers(secondFile), 0, countMarkers(secondFile));
		assertEquals(printMarkers(firstFile), 0, countMarkers(firstFile));
		new WorkspaceModifyOperation() {
			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException,
					InterruptedException {
				first.getProject().close(monitor);
				second.getProject().close(monitor);
			}
		}.run(monitor());
		waitForAutoBuild();
		new WorkspaceModifyOperation() {
			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException,
					InterruptedException {
				first.getProject().open(monitor);
				second.getProject().open(monitor);
			}
		}.run(monitor());
		waitForAutoBuild();
		assertEquals(printMarkers(secondFile), 0, countMarkers(secondFile));
		assertEquals(printMarkers(firstFile), 0, countMarkers(firstFile));
	}

	@Test public void testOpenAndCloseReferencedProjectsTogether_02() throws Exception {
		createTwoFilesInTwoReferencedProjects();
		waitForAutoBuild();
		assertEquals(printMarkers(secondFile), 0, countMarkers(secondFile));
		assertEquals(printMarkers(firstFile), 0, countMarkers(firstFile));
		first.getProject().close(monitor());
		second.getProject().close(monitor());
		waitForAutoBuild();
		first.getProject().open(monitor());
		second.getProject().open(monitor());
		waitForAutoBuild();
		assertEquals(printMarkers(secondFile), 0, countMarkers(secondFile));
		assertEquals(printMarkers(firstFile), 0, countMarkers(firstFile));
	}

}
