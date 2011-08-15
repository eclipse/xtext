/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.notification;

import static org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.ui.junit.util.JavaProjectSetupUtil.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.builder.builderState.IBuilderState;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.shared.Access;
import org.eclipse.xtext.util.StringInputStream;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RebuildDependentResourcesTest extends TestCase {
	
	private static final String extension = ".typesAssistTest";

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		assertEquals(0, countResourcesInIndex());
		createJavaProjectWithRootSrc("RebuildDependentResourcesTest");
	}

	@Override
	protected void tearDown() throws Exception {
		root().getProject("RebuildDependentResourcesTest").delete(true, null);
		waitForAutoBuild();
		assertEquals(0, countResourcesInIndex());
		super.tearDown();
	}
	
	public void testValidJavaReference() throws Exception {
		IFile file = createFile("src/foo"+extension, "default ExistingClass");
		createFile("src/ExistingClass.java", "class ExistingClass {}");
		waitForAutoBuild();
		assertEquals(printMarkers(file), 0, countMarkers(file));
	}
	
	public void testMissingJavaReference() throws Exception {
		IFile file = createFile("src/foo"+extension, "default MissingClass");
		waitForAutoBuild();
		assertEquals(printMarkers(file), 2, countMarkers(file));
	}

	public void testFixedJavaReference_01() throws Exception {
		IFile file = createFile("src/foo"+extension, "default WillBeCreated");
		waitForAutoBuild();
		assertEquals(printMarkers(file), 2, countMarkers(file));
		createFile("src/WillBeCreated.java", "class WillBeCreated {}");
		waitForAutoBuild();
		assertEquals(printMarkers(file), 0, countMarkers(file));
	}
	
	public void testFixedJavaReference_02() throws Exception {
		IFile file = createFile("src/foo"+extension, "default WillBeCreated");
		IFile javaFile = createFile("src/WillBeCreated.java", "class WillBeCreate {}");
		waitForAutoBuild();
		assertEquals(printMarkers(file), 2, countMarkers(file));
		javaFile.setContents(new StringInputStream("class WillBeCreated {}"),true,true,monitor());
		waitForAutoBuild();
		assertEquals(printMarkers(file), 0, countMarkers(file));
	}
	
	public void testFixedJavaReference_03() throws Exception {
		IFile file = createFile("src/foo"+extension, "default pack.WillBeDeleted");
		waitForAutoBuild();
		assertEquals(printMarkers(file), 2, countMarkers(file));
		createFile("src/pack/WillBeDeleted.java", "package pack; class WillBeDeleted {}");
		waitForAutoBuild();
		assertEquals(printMarkers(file), 0, countMarkers(file));
	}
	
	public void testFixedJavaReference_04() throws Exception {
		IFile file = createFile("src/foo"+extension, "default pack.SomeFile$Nested");
		waitForAutoBuild();
		assertEquals(printMarkers(file), 2, countMarkers(file));
		IFile javaFile = createFile("src/pack/SomeFile.java", "package pack; class SomeFile {}");
		assertEquals(printMarkers(file), 2, countMarkers(file));
		javaFile.setContents(new StringInputStream("package pack; class SomeFile { class Nested {} }"), true, true,	monitor());
		waitForAutoBuild();
		assertEquals(printMarkers(file), 0, countMarkers(file));
	}
	
	public void testBrokenJavaReference_01() throws Exception {
		IFile file = createFile("src/foo"+extension, "default WillBeDeleted");
		IFile javaFile = createFile("src/WillBeDeleted.java", "class WillBeDeleted {}");
		waitForAutoBuild();
		assertEquals(printMarkers(file), 0, countMarkers(file));
		javaFile.delete(true, monitor());
		waitForAutoBuild();
		assertEquals(printMarkers(file), 2, countMarkers(file));
	}
	
	public void testBrokenJavaReference_02() throws Exception {
		IFile file = createFile("src/foo"+extension, "default pack.WillBeDeleted");
		IFile javaFile = createFile("src/pack/WillBeDeleted.java", "package pack; class WillBeDeleted {}");
		waitForAutoBuild();
		assertEquals(printMarkers(file), 0, countMarkers(file));
		javaFile.getParent().delete(true, monitor());
		waitForAutoBuild();
		assertEquals(printMarkers(file), 2, countMarkers(file));
	}
	
	private IJavaProject createJavaProjectWithRootSrc(String string) throws CoreException {
		IJavaProject project = createJavaProject(string);
		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
		return project;
	}
	
	public static IFile createFile(String projectRelative, String content) throws CoreException, InvocationTargetException,
		InterruptedException {
		return IResourcesSetupUtil.createFile(new Path("RebuildDependentResourcesTest/" + projectRelative), content);
	}

	protected int countMarkers(IFile file) throws CoreException {
		return file.findMarkers(EValidator.MARKER, true, IResource.DEPTH_INFINITE).length;
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
	
	public static int countResourcesInIndex() {
		Collection<IResourceDescription> forIterable = Lists.newArrayList(getBuilderState().getAllResourceDescriptions());
		return forIterable.size();
	}
	
	public static IBuilderState getBuilderState() {
		return Access.getIBuilderState().get();
	}
}
