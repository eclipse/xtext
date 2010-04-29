/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import static org.eclipse.xtext.builder.impl.BuilderUtil.*;
import static org.eclipse.xtext.junit.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.junit.util.JavaProjectSetupUtil.*;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.util.StringInputStream;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class SimpleProjectsIntegrationTest extends AbstractBuilderTest {

	private IProject foo_project;
	private IProject bar_project;
	private IFile foo_file;
	private IFile bar_file;

	public void testValidSimpleModel() throws Exception {
		createSimpleProjectWithXtextNature("foo");
		IFile file = createFile("foo/foo"+F_EXT, "object Foo ");
		waitForAutoBuild();
		assertEquals(0, countMarkers(file));
	}

	private IProject createSimpleProjectWithXtextNature(String projectName) throws CoreException {
		IProject project = createSimpleProject(projectName);
		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
		return project;
	}

	public void testSimpleModelWithSyntaxError() throws Exception {
		createSimpleProjectWithXtextNature("foo");
		IFile file = createFile("foo/foo"+F_EXT, "objekt Foo ");
		waitForAutoBuild();
		assertEquals(1, countMarkers(file));
	}

	public void testTwoFilesInSameProject() throws Exception {
		createSimpleProjectWithXtextNature("foo");
		IFile file1 = createFile("foo/foo"+F_EXT, "object Foo ");
		IFile file2 = createFile("foo/bar"+F_EXT, "object Bar references Foo");
		waitForAutoBuild();
		assertEquals(printMarkers(file1), 0, countMarkers(file1));
		assertEquals(printMarkers(file2), 0, countMarkers(file2));
		assertTrue(indexContainsElement(file1.getFullPath().toString(),"Foo"));
		assertTrue(indexContainsElement(file2.getFullPath().toString(),"Bar"));
		assertEquals(2, countResourcesInIndex());
	}
	
	public void testTwoFilesInSameProjectRemoveNature() throws Exception {
		IProject project = createSimpleProjectWithXtextNature("foo");
		createFile("foo/foo"+F_EXT, "object Foo ");
		createFile("foo/bar"+F_EXT, "object Bar references Foo");
		waitForAutoBuild();
		assertEquals(2, countResourcesInIndex());
		removeNature(project.getProject(), XtextProjectHelper.NATURE_ID);
		waitForAutoBuild();
		assertEquals(0, countResourcesInIndex());
	}
	
	protected String printMarkers(IFile file) throws CoreException {
		return printMarkers(file.findMarkers(EValidator.MARKER, true, IResource.DEPTH_INFINITE));
	}
	
	protected String printMarkers(IMarker[] findMarkers) throws CoreException {
		StringBuffer buff = new StringBuffer();
		for (IMarker iMarker : findMarkers) {
			buff.append("\n");
			buff.append(iMarker.getAttribute(IMarker.MESSAGE));
		}
		return buff.toString();
	}

	public void testTwoFilesInSameProjectWithLinkingError() throws Exception {
		createSimpleProjectWithXtextNature("foo");
		createFile("foo/foo"+F_EXT, "object Foo ");
		IFile file = createFile("foo/bar"+F_EXT, "object Bar references Fuu");
		waitForAutoBuild();
		assertEquals(1, countMarkers(file));
	}
	
	public void testTwoFilesInTwoReferencedProjects() throws Exception {
		createTwoFilesInTwoReferencedProjects();
	}
	
	public void testTwoFilesInTwoReferencedProjectsRemoveNature() throws Exception {
		createTwoFilesInTwoReferencedProjects();
		removeNature(foo_project.getProject(), XtextProjectHelper.NATURE_ID);
		waitForAutoBuild();
		assertEquals(1, countMarkers(bar_file));
	}
	
	public void testTwoFilesInTwoReferencedProjectsAddNature() throws Exception {
		foo_project = createSimpleProjectWithXtextNature("foo");
		removeNature(foo_project.getProject(), XtextProjectHelper.NATURE_ID);
		bar_project = createSimpleProjectWithXtextNature("bar");
		foo_file = createFile("foo/foo"+F_EXT, "object Foo ");
		bar_file = createFile("bar/bar"+F_EXT, "object Bar references Foo");
		waitForAutoBuild();
		assertEquals(printMarkers(foo_file), 0, countMarkers(foo_file));
		assertEquals(printMarkers(bar_file), 1, countMarkers(bar_file));
		setReference(bar_project, foo_project);
		waitForAutoBuild();
		assertEquals(printMarkers(foo_file), 0, countMarkers(foo_file));
		assertEquals(printMarkers(bar_file), 1, countMarkers(bar_file));
		addNature(foo_project.getProject(), XtextProjectHelper.NATURE_ID);
		waitForAutoBuild();
		assertEquals(printMarkers(foo_file), 0, countMarkers(foo_file));
		assertEquals(printMarkers(bar_file), 0, countMarkers(bar_file));
	}
	
	protected void createTwoFilesInTwoReferencedProjects() throws Exception {
		foo_project = createSimpleProjectWithXtextNature("foo");
		bar_project = createSimpleProjectWithXtextNature("bar");
		foo_file = createFile("foo/foo"+F_EXT, "object Foo ");
		bar_file = createFile("bar/bar"+F_EXT, "object Bar references Foo");
		waitForAutoBuild();
		setReference(bar_project, foo_project);
		waitForAutoBuild();
		assertEquals(0, countMarkers(foo_file));
		assertEquals(0, countMarkers(bar_file));
	}

	public void testTwoFilesInTwoInversedReferencedProjects() throws Exception {
		createTwoFilesInTwoReferencedProjects();
		removeReference(bar_project, foo_project);
		waitForAutoBuild();
		setReference(foo_project, bar_project);
		waitForAutoBuild();
		assertEquals(0, countMarkers(foo_file));
		assertEquals(1, countMarkers(bar_file));
	}

	public void testTwoFilesInTwoNonReferencedProjects() throws Exception {
		createTwoFilesInTwoReferencedProjects();
		removeReference(bar_project, foo_project);

		waitForAutoBuild();
		assertEquals(0, countMarkers(foo_file));
		assertEquals(1, countMarkers(bar_file));
	}

	public void testChangeReferenceOfProjects() throws Exception {
		createTwoFilesInTwoReferencedProjects();
		
		removeReference(bar_project, foo_project);
		waitForAutoBuild();
		assertEquals(0, countMarkers(foo_file));
		assertEquals(1, countMarkers(bar_file));
		
		setReference(bar_project, foo_project);
		waitForAutoBuild();
		assertEquals(0, countMarkers(foo_file));
		assertEquals(0, countMarkers(bar_file));
	}

	public void testOpenAndCloseReferencedProjects() throws Exception {
		createTwoFilesInTwoReferencedProjects();
		// close project
		foo_project.getProject().close(monitor());
		waitForAutoBuild();
		assertEquals(1, countMarkers(bar_file));
		foo_project.getProject().open(monitor());
		waitForAutoBuild();
		assertEquals(printMarkers(bar_file), 0, countMarkers(bar_file));
	}

	public void testChangeReferencedFile() throws Exception {
		createTwoFilesInTwoReferencedProjects();
		
		// change referenced file
		foo_file.setContents(new StringInputStream("object Baz "),true,true,monitor());
		waitForAutoBuild();
		assertEquals(1, countMarkers(bar_file));
		
		//change back to valid state
		foo_file.setContents(new StringInputStream("object Foo "),true,true,monitor());
		waitForAutoBuild();
		assertEquals(0, countMarkers(bar_file));
	}
	
	public void testDeleteReferencedFile() throws Exception {
		createTwoFilesInTwoReferencedProjects();
		
		// delete referenced file
		foo_file.delete(true, new NullProgressMonitor());
		waitForAutoBuild();
		assertEquals(1, countMarkers(bar_file));
		
		// create new
		foo_file = createFile("foo/foo"+F_EXT, "object Foo ");
		waitForAutoBuild();
		assertEquals(0, countMarkers(foo_file));
		assertEquals(0, countMarkers(bar_file));
	}
	
	public void testUpdateOfReferencedFile() throws Exception {
		IProject project = createSimpleProject("foo");
		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
		IFolder folder = createSubFolder(project, "subFolder");
		IFile file = folder.getFile("Foo" + F_EXT);
		file.create(new StringInputStream("object Foo"), true, monitor());
		IFile fileB = folder.getFile("Boo" + F_EXT);
		fileB.create(new StringInputStream("object Bar references Foo"), true, monitor());
		waitForAutoBuild();
		assertTrue(indexContainsElement(file.getFullPath().toString(),"Foo"));
		assertTrue(indexContainsElement(fileB.getFullPath().toString(),"Bar"));
		assertEquals(2, countResourcesInIndex());
		
		getBuilderState().addListener(this);
		file.setContents(new StringInputStream("object Foo"), true,true, monitor());
		waitForAutoBuild();
		assertEquals(1,getEvents().get(0).getDeltas().size());
		assertNumberOfMarkers(fileB, 0);
		assertEquals(1,getIncomingReferences(URI.createPlatformResourceURI("foo/subFolder/Foo"+F_EXT,true)).size());
		
		file.setContents(new StringInputStream("object Fop"), true,true, monitor());
		waitForAutoBuild();
		assertEquals(2,getEvents().get(1).getDeltas().size());
		assertNumberOfMarkers(fileB, 1);
		assertEquals(0,getIncomingReferences(URI.createPlatformResourceURI("foo/subFolder/Foo"+F_EXT,true)).size());
		
		file.setContents(new StringInputStream("object Foo"), true,true, monitor());
		waitForAutoBuild();
		assertEquals(2,getEvents().get(2).getDeltas().size());
		assertNumberOfMarkers(fileB, 0);
		
		file.setContents(new StringInputStream("object Foo"), true,true, monitor());
		waitForAutoBuild();
		assertEquals(1,getEvents().get(3).getDeltas().size());
		assertNumberOfMarkers(fileB, 0);
	}
	
	public void testDeleteFile() throws Exception {
		IProject project = createSimpleProject("foo");
		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
		IFolder folder = createSubFolder(project, "subFolder");
		IFile file = folder.getFile("Foo" + F_EXT);
		file.create(new StringInputStream("object Foo"), true, monitor());
		waitForAutoBuild();
		assertTrue(indexContainsElement(file.getFullPath().toString(),"Foo"));
		assertEquals(1, countResourcesInIndex());
		
		getBuilderState().addListener(this);
		file.delete(true, monitor());
		waitForAutoBuild();
		assertEquals(1,getEvents().get(0).getDeltas().size());
		assertNull(getEvents().get(0).getDeltas().get(0).getNew());
		assertEquals(0, countResourcesInIndex());
	}
	
	public void testCleanBuild() throws Exception {
		IProject project = createSimpleProject("foo");
		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
		IFolder folder = createSubFolder(project, "subFolder");
		IFile file = folder.getFile("Foo" + F_EXT);
		file.create(new StringInputStream("object Foo"), true, monitor());
		waitForAutoBuild();
		assertTrue(indexContainsElement(file.getFullPath().toString(),"Foo"));
		assertEquals(1, countResourcesInIndex());
		
		getBuilderState().addListener(this);
		project.getProject().build(IncrementalProjectBuilder.CLEAN_BUILD, monitor());
		waitForAutoBuild();
		// clean build should first remove the IResourceDescriptor and then add it again  
		assertEquals(2, getEvents().size());
		assertEquals(1, getEvents().get(0).getDeltas().size());
		assertNotNull(getEvents().get(0).getDeltas().get(0).getOld());
		assertNull(getEvents().get(0).getDeltas().get(0).getNew());
		assertEquals(1,getEvents().get(1).getDeltas().size());
		assertNull(getEvents().get(1).getDeltas().get(0).getOld());
		assertNotNull(getEvents().get(1).getDeltas().get(0).getNew());
	}
	
//	public void testReexportedSource() throws Exception {
//		IProject foo = createSimpleProject("foo");
//		IProject bar = createSimpleProject("bar");
//		IProject baz = createSimpleProject("baz");
//		addNature(foo.getProject(), XtextProjectHelper.NATURE_ID);
//		addNature(bar.getProject(), XtextProjectHelper.NATURE_ID);
//		addNature(baz.getProject(), XtextProjectHelper.NATURE_ID);
//		IFile file = foo.getProject().getFile("foo.jar");
//		file.create(jarInputStream(new TextFile("foo/Foo"+F_EXT, "object Foo")), true, monitor());
//		IClasspathEntry newLibraryEntry = JavaCore.newLibraryEntry(file.getFullPath(), null, null,true);
//		addToClasspath(foo, newLibraryEntry);
//		addToClasspath(bar, JavaCore.newProjectEntry(foo.getPath(), true));
//		addToClasspath(baz, JavaCore.newProjectEntry(bar.getPath(), false));
//		addSourceFolder(baz, "src");
//		IFile bazFile = createFile("baz/src/Baz"+F_EXT, "object Baz references Foo");
//		waitForAutoBuild();
//		assertEquals(0,countMarkers(bazFile));
//		assertEquals(2, countResourcesInIndex());
//		Iterator<IReferenceDescription> references = getContainedReferences(URI.createPlatformResourceURI(bazFile.getFullPath().toString(),true)).iterator();
//		IReferenceDescription next = references.next();
//		assertFalse(references.hasNext());
//		assertEquals("platform:/resource/baz/src/Baz.buildertestlanguage#/",next.getSourceEObjectUri().toString());
//		assertEquals("archive:platform:/resource/foo/foo.jar!/foo/Foo.buildertestlanguage#/",next.getTargetEObjectUri().toString());
//		assertEquals(-1,next.getIndexInList());
//		assertEquals(BuilderTestLanguagePackage.Literals.ELEMENT__REFERENCES,next.getEReference());
//	}
	
//	public void testFullBuild() throws Exception {
//		IProject project = createSimpleProject("foo");
//		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
//		IProject someProject = createProject("bar");
//		assertEquals(0, countResourcesInIndex());
//		waitForAutoBuild();
//		assertEquals(1, countResourcesInIndex());
//
//		getBuilderState().addListener(this);
//		fullBuild();
//		assertEquals(1, countResourcesInIndex());
////		System.out.println(print(getEvents().get(0).getDeltas()));
//		assertEquals(1,getEvents().size());
//	}

	private int countMarkers(IFile file) throws CoreException {
		return file.findMarkers(EValidator.MARKER, true, IResource.DEPTH_INFINITE).length;
	}

	
//	public void testEvents() throws Exception {
//		IProject project = createSimpleProject("foo");
//		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
//		IProject someProject = createProject("bar");
//		IFile file = someProject.getFile("foo.jar");
//		file.create(jarInputStream(new TextFile("foo/Bar"+F_EXT, "object Foo")), true, monitor());
//		addJarToClasspath(project, file);
//		waitForAutoBuild();
////		JavaCore.addElementChangedListener(new IElementChangedListener() {
////			
////			public void elementChanged(ElementChangedEvent event) {
////				System.out.println(event);
////			}
////		});
//		someProject.delete(true, monitor());
//	}
}
