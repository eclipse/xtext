/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.notification;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.builder.builderState.IBuilderState;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.shared.Access;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RebuildDependentResourcesTest extends Assert {
	
	private static final String extension = ".typesAssistTest";

	@Before
	public void setUp() throws Exception {
		assertEquals(0, countResourcesInIndex());
		createJavaProjectWithRootSrc("RebuildDependentResourcesTest");
	}

	@After
	public void tearDown() throws Exception {
		root().getProject("RebuildDependentResourcesTest").delete(true, null);
		reallyWaitForAutoBuild();
		assertEquals(0, countResourcesInIndex());
	}
	
	@Test public void testValidJavaReference() throws Exception {
		IFile file = createFile("src/foo"+extension, "default ExistingClass");
		createFile("src/ExistingClass.java", "class ExistingClass {}");
		waitForBuild();
		assertEquals(printMarkers(file), 0, countMarkers(file));
	}
	
	@Test public void testMissingJavaReference() throws Exception {
		IFile file = createFile("src/foo"+extension, "default MissingClass");
		waitForBuild();
		assertEquals(printMarkers(file), 2, countMarkers(file));
	}

	@Test public void testFixedJavaReference_01() throws Exception {
		IFile file = createFile("src/foo"+extension, "default WillBeCreated");
		waitForBuild();
		assertEquals(printMarkers(file), 2, countMarkers(file));
		createFile("src/WillBeCreated.java", "class WillBeCreated {}");
		waitForBuild();
		assertEquals(printMarkers(file), 0, countMarkers(file));
	}
	
	@Test public void testFixedJavaReference_02() throws Exception {
		IFile file = createFile("src/foo"+extension, "default WillBeCreated");
		IFile javaFile = createFile("src/WillBeCreated.java", "class WillBeCreate {}");
		waitForBuild();
		assertEquals(printMarkers(file), 2, countMarkers(file));
		javaFile.setContents(new StringInputStream("class WillBeCreated {}"),true,true,monitor());
		waitForBuild();
		assertEquals(printMarkers(file), 0, countMarkers(file));
	}
	
	@Test public void testFixedJavaReference_03() throws Exception {
		IFile file = createFile("src/foo"+extension, "default pack.WillBeDeleted");
		waitForBuild();
		assertEquals(printMarkers(file), 2, countMarkers(file));
		createFile("src/pack/WillBeDeleted.java", "package pack; class WillBeDeleted {}");
		waitForBuild();
		assertEquals(printMarkers(file), 0, countMarkers(file));
	}
	
	@Test public void testFixedJavaReference_04() throws Exception {
		IFile file = createFile("src/foo"+extension, "default pack.SomeFile$Nested");
		waitForBuild();
		assertEquals(printMarkers(file), 2, countMarkers(file));
		IFile javaFile = createFile("src/pack/SomeFile.java", "package pack; class SomeFile {}");
		assertEquals(printMarkers(file), 2, countMarkers(file));
		javaFile.setContents(new StringInputStream("package pack; class SomeFile { class Nested {} }"), true, true,	monitor());
		waitForBuild();
		assertEquals(printMarkers(file), 0, countMarkers(file));
	}
	
	@Test public void testBrokenJavaReference_01() throws Exception {
		IFile file = createFile("src/foo"+extension, "default WillBeDeleted");
		IFile javaFile = createFile("src/WillBeDeleted.java", "class WillBeDeleted {}");
		waitForBuild();
		assertEquals(printMarkers(file), 0, countMarkers(file));
		javaFile.delete(true, monitor());
		waitForBuild();
		assertEquals(printMarkers(file), 2, countMarkers(file));
	}
	
	@Test public void testBrokenJavaReference_02() throws Exception {
		IFile file = createFile("src/foo"+extension, "default pack.WillBeDeleted");
		IFile javaFile = createFile("src/pack/WillBeDeleted.java", "package pack; class WillBeDeleted {}");
		waitForBuild();
		assertEquals(printMarkers(file), 0, countMarkers(file));
		javaFile.getParent().delete(true, monitor());
		waitForBuild();
		assertEquals(printMarkers(file), 2, countMarkers(file));
	}
	
	public void testBrokenJavaReference_03() throws Exception {
		IFile file = createFile("src/foo"+extension, "default WillBeDeleted");
		IFile javaFile = createFile("src/WillBeDeleted.java", "class WillBeDeleted {}");
		waitForBuild();
		assertEquals(printMarkers(file), 0, countMarkers(file));
		javaFile.setContents(new StringInputStream(""), true, true,	monitor());
		waitForBuild();
		assertEquals(printMarkers(file), 2, countMarkers(file));
	}
	
	public void testBrokenJavaReference_04() throws Exception {
		IFile file = createFile("src/foo"+extension, "default pack.WillBeDeleted");
		IFile javaFile = createFile("src/pack/WillBeDeleted.java", "package pack; class WillBeDeleted {}");
		waitForBuild();
		assertEquals(printMarkers(file), 0, countMarkers(file));
		javaFile.setContents(new StringInputStream(""), true, true,	monitor());
		waitForBuild();
		assertEquals(printMarkers(file), 2, countMarkers(file));
	}
	
	public void testBrokenJavaReference_05() throws Exception {
		IFile genFile = createFile("src/foo"+extension, "generate WillBeDeleted");
		waitForBuild();
		IFile file = createFile("src/bar"+extension, "default WillBeDeleted");
		waitForBuild();
		assertEquals(printMarkers(file), 0, countMarkers(file));
		genFile.setContents(new StringInputStream(""), true, true,	monitor());
		waitForBuild();
		assertEquals(printMarkers(file), 2, countMarkers(file));
	}
	
	public void testBrokenJavaReference_06() throws Exception {
		IFile genFile = createFile("src/foo"+extension, "generate pack.WillBeDeleted");
		waitForBuild();
		IFile file = createFile("src/bar"+extension, "default pack.WillBeDeleted");
		waitForBuild();
		assertEquals(printMarkers(file), 0, countMarkers(file));
		genFile.setContents(new StringInputStream(""), true, true,	monitor());
		waitForBuild();
		assertEquals(printMarkers(file), 2, countMarkers(file));
	}
	
	private IJavaProject createJavaProjectWithRootSrc(String string) throws CoreException {
		IJavaProject project = createJavaProject(string);
		addSourceFolder(project, "src-gen");
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
