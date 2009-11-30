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

import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.builder.BuilderAccess;
import org.eclipse.xtext.builder.nature.XtextNature;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.IResourceDescription.Event;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.util.StringInputStream;

import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

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
		System.out.println(toString(getBuilderState()));
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
		assertEquals(1,print(events.get(0).getDeltas()).size());
		
		file.setContents(new StringInputStream("object Fop"), true,true, monitor());
		waitForAutoBuild();
		assertEquals(2,events.get(1).getDeltas().size());
		
		file.setContents(new StringInputStream("object Foo"), true,true, monitor());
		waitForAutoBuild();
		assertEquals(2,events.get(2).getDeltas().size());
		
		file.setContents(new StringInputStream("object Foo"), true,true, monitor());
		waitForAutoBuild();
		assertEquals(1,events.get(3).getDeltas().size());
	}

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

	private String toString(IResourceDescriptions index) {
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

	@SuppressWarnings("unused")
	private String printMarker(IMarker[] markers) throws CoreException {
		String s = "";
		for (IMarker iMarker : markers) {
			s += "," + iMarker.getAttribute(IMarker.MESSAGE);
		}
		return s;
	}

	public void descriptionsChanged(Event event) {
		this.events.add(event);
	}
}
