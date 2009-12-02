/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import static org.eclipse.xtext.junit.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.junit.util.JavaProjectSetupUtil.*;

import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.builder.BuilderAccess;
import org.eclipse.xtext.builder.nature.XtextNature;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.IResourceDescription.Event;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.util.StringInputStream;

import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class BuilderTest extends TestCase implements IResourceDescription.Event.Listener {
	private static final String F_EXT = ".buildertestlanguage";
	private volatile List<Event> events = Lists.newArrayList();

	@Override
	protected void setUp() throws Exception {
		assertEquals(0, countResourcesInIndex());
		assertEquals(0, root().getProjects().length);
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		cleanWorkspace();
		waitForAutoBuild();
		events.clear();
		getBuilderState().removeListener(this);
		super.tearDown();
	}

	public void testTwoReferencedFilesInSameProject() throws Exception {
		IJavaProject project = createJavaProject("foo");
		addNature(project.getProject(), XtextNature.NATURE_ID);
		IFolder folder = addSourceFolder(project, "src");
		IFile file = folder.getFile("Foo" + F_EXT);
		file.create(new StringInputStream("object Foo"), true, monitor());
		IFile fileB = folder.getFile("Boo" + F_EXT);
		fileB.create(new StringInputStream("object Bar references Foo"), true, monitor());

		waitForAutoBuild();
		assertTrue(indexContainsElement(file.getFullPath().toString(),"Foo"));
		assertTrue(indexContainsElement(fileB.getFullPath().toString(),"Bar"));
		assertEquals(2, countResourcesInIndex());
	}
	
	public void testUpdateOfReferencedFile() throws Exception {
		IJavaProject project = createJavaProject("foo");
		addNature(project.getProject(), XtextNature.NATURE_ID);
		IFolder folder = addSourceFolder(project, "src");
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
		assertEquals(1,events.get(0).getDeltas().size());
		assertNumberOfMarkers(fileB, 0);
		assertEquals(1,getReferences(URI.createPlatformResourceURI("foo/src/Foo"+F_EXT,true)).size());
		
		file.setContents(new StringInputStream("object Fop"), true,true, monitor());
		waitForAutoBuild();
		assertEquals(2,events.get(1).getDeltas().size());
		assertNumberOfMarkers(fileB, 1);
		assertEquals(0,getReferences(URI.createPlatformResourceURI("foo/src/Foo"+F_EXT,true)).size());
		
		file.setContents(new StringInputStream("object Foo"), true,true, monitor());
		waitForAutoBuild();
		assertEquals(2,events.get(2).getDeltas().size());
		assertNumberOfMarkers(fileB, 0);
		
		file.setContents(new StringInputStream("object Foo"), true,true, monitor());
		waitForAutoBuild();
		assertEquals(1,events.get(3).getDeltas().size());
		assertNumberOfMarkers(fileB, 0);
	}
	
	public void testDeleteFile() throws Exception {
		IJavaProject project = createJavaProject("foo");
		addNature(project.getProject(), XtextNature.NATURE_ID);
		IFolder folder = addSourceFolder(project, "src");
		IFile file = folder.getFile("Foo" + F_EXT);
		file.create(new StringInputStream("object Foo"), true, monitor());
		waitForAutoBuild();
		assertTrue(indexContainsElement(file.getFullPath().toString(),"Foo"));
		assertEquals(1, countResourcesInIndex());
		
		getBuilderState().addListener(this);
		file.delete(true, monitor());
		waitForAutoBuild();
		assertEquals(1,events.get(0).getDeltas().size());
		assertNull(events.get(0).getDeltas().get(0).getNew());
		assertEquals(0, countResourcesInIndex());
	}
	
	public void testDeleteReferencedFile() throws Exception {
		IJavaProject project = createJavaProject("foo");
		addNature(project.getProject(), XtextNature.NATURE_ID);
		IFolder folder = addSourceFolder(project, "src");
		IFile file = folder.getFile("Foo" + F_EXT);
		file.create(new StringInputStream("object Foo"), true, monitor());
		IFile fileB = folder.getFile("Bar" + F_EXT);
		fileB.create(new StringInputStream("object Bar references Foo"), true, monitor());
		waitForAutoBuild();
		assertTrue(indexContainsElement(file.getFullPath().toString(),"Foo"));
		assertEquals(2, countResourcesInIndex());
		assertNumberOfMarkers(file, 0);
		assertNumberOfMarkers(fileB, 0);
		
		file.delete(true, monitor());
		waitForAutoBuild();
		assertNumberOfMarkers(fileB, 1);
		assertEquals(1, countResourcesInIndex());
	}
	
	public void testFileInJar() throws Exception {
		IJavaProject project = createJavaProject("foo");
		addNature(project.getProject(), XtextNature.NATURE_ID);
		IFile file = project.getProject().getFile("foo.jar");
		file.create(jarInputStream(new TextFile("foo/Bar"+F_EXT, "object Foo")), true, monitor());
		assertEquals(0, countResourcesInIndex());
		addJarToClasspath(project, file);
		waitForAutoBuild();
		assertEquals(1, countResourcesInIndex());
	}
	
	public void testTwoJars() throws Exception {
		IJavaProject project = createJavaProject("foo");
		addNature(project.getProject(), XtextNature.NATURE_ID);
		IFile file = project.getProject().getFile("foo.jar");
		file.create(jarInputStream(new TextFile("foo/Bar"+F_EXT, "object Foo")), true, monitor());
		IFile file2 = project.getProject().getFile("bar.jar");
		file2.create(jarInputStream(new TextFile("foo/Bar"+F_EXT, "object Foo"), new TextFile("foo/Bar2"+F_EXT, "object Bar references Foo")), true, monitor());

		addJarToClasspath(project, file);
		addJarToClasspath(project, file2);
		
		waitForAutoBuild();
		assertEquals(3, countResourcesInIndex());
	}

	@SuppressWarnings("unused")
	private ImmutableList<Delta> print(ImmutableList<Delta> deltas) {
		int i = 1;
		String buff = "Deltas : \n";
		for (Delta delta : deltas) {
			buff+= "Delta "+i+"["+delta.getUri()+"]: {\n";
			buff+= " old : "+toString(delta.getOld())+"\n";
			buff+= " new : "+toString(delta.getNew())+"\n";
			buff+= "}\n\n";
			i++;
		}
		System.out.println(buff);
		return deltas;
	}

	private String toString(IResourceDescription desc) {
		if (desc==null)
			return "null";
		return EmfFormatter.objToStr(desc, new EStructuralFeature[0]);
	}

	protected String toString(IResourceDescriptions index) {
		StringBuffer buff = new StringBuffer();
		for (IResourceDescription desc : index.getAllResourceDescriptions()) {
			buff.append(EmfFormatter.objToStr(desc, new EStructuralFeature[0]));
		}
		return buff.toString();
	}

	private boolean indexContainsElement(final String fileUri, final String eObjectName) {
		IResourceDescriptions descriptions = getBuilderState();
		URI uri = URI.createURI("platform:/resource"+fileUri);
		IResourceDescription description = descriptions.getResourceDescription(uri);
		if (description!=null) {
			return description.getExportedObjects(EcorePackage.Literals.EOBJECT, eObjectName).iterator().hasNext();
		}
		return false;
	}

	private IResourceDescriptions getBuilderState() {
		return BuilderAccess.getResourceDescriptions().get();
	}

	private int countResourcesInIndex() {
		return Collections2.forIterable(getBuilderState().getAllResourceDescriptions()).size();
	}

	private String printMarker(IMarker[] markers) throws CoreException {
		String s = "";
		for (IMarker iMarker : markers) {
			s += "," + iMarker.getAttribute(IMarker.MESSAGE);
		}
		return s;
	}
	
	private void assertNumberOfMarkers(IFile file, int numberOfMarkers) throws CoreException {
		IMarker[] markers = file.findMarkers(EValidator.MARKER, true, 1);
		assertEquals(printMarker(markers),numberOfMarkers,markers.length);
	}

	public void descriptionsChanged(Event event) {
		this.events.add(event);
	}
	
	public Set<IReferenceDescription> getReferences(URI uri) {
		Set<IReferenceDescription> desc = Sets.newHashSet();
		Iterable<IResourceDescription> descriptions = getBuilderState().getAllResourceDescriptions();
		for (IResourceDescription res : descriptions) {
			Iterable<IReferenceDescription> descriptions2 = res.getReferenceDescriptions();
			for (IReferenceDescription ref : descriptions2) {
				if (uri.hasFragment()) {
					if (ref.getTargetEObjectUri().equals(uri))
						desc.add(ref);
				} else {
					if (ref.getTargetEObjectUri().trimFragment().equals(uri.trimFragment()))
						desc.add(ref);
				}
			}
		}
		return desc;
	}
}
