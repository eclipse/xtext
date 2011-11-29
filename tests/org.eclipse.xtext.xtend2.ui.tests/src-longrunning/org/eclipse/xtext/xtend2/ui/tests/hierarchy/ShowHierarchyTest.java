/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.tests.hierarchy;

import static org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.util.Strings.*;
import junit.framework.Test;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.junit.editor.AbstractEditorTest;
import org.eclipse.xtext.xbase.ui.hierarchy.AbstractTypeHierarchyHandler;
import org.eclipse.xtext.xtend2.ui.internal.Xtend2Activator;
import org.eclipse.xtext.xtend2.ui.tests.WorkbenchTestHelper;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class ShowHierarchyTest extends AbstractEditorTest {

	private static final String LANGUAGE_NAME = "org.eclipse.xtext.xtend2.Xtend2";
	private static final String COMMAND_ID = "org.eclipse.xtext.xbase.ui.hierarchy.OpenTypeHierarchy";
	private static Injector injector = Xtend2Activator.getInstance().getInjector(LANGUAGE_NAME);
	
	@Inject
	private IWorkspace workspace;
	
	@Inject
	private WorkbenchTestHelper testHelper;
	
	public static Test suite() {
		return WorkbenchTestHelper.suite(ShowHierarchyTest.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		getInjector().injectMembers(this);
		closeWelcomePage();
		closeEditors();
	}
	
	@Override
	protected void tearDown() throws Exception {
		testHelper.tearDown();
	}
	
	public void testOpenTypeHierarchyOnXtendClass() throws Exception {
		XtextEditor xtextEditor = openEditor("package foo class Fo|o { def bar(String a)}");
		assertEquals("Foo", invokeTestingHandler(xtextEditor, COMMAND_ID).getResolvedTypeName());
	}
	
	public void testOpenTypeHierarchyOnTypeReference() throws Exception {
		XtextEditor xtextEditor = openEditor("package foo class Foo { def bar(Str|ing a)}");
		assertEquals("String", invokeTestingHandler(xtextEditor, COMMAND_ID).getResolvedTypeName());
	}
	
	public void testOpenTypeHierarchyOnFunction() throws Exception {
		XtextEditor xtextEditor = openEditor("package foo class Foo { def b|ar(String a)}");
		assertEquals("bar", invokeTestingHandler(xtextEditor, COMMAND_ID).getResolvedTypeName());
	}
	
	public void testOpenTypeHierarchyOnCollectionsLiterals() throws Exception {
		XtextEditor xtextEditor = openEditor("package foo class Foo { def bar(String a) { newArr|ayList() }");
		assertEquals("newArrayList", invokeTestingHandler(xtextEditor, COMMAND_ID).getResolvedTypeName());
	}
	
	@Override
	protected String getEditorId() {
		return LANGUAGE_NAME;
	}
	
	protected XtextEditor openEditor(String string) throws Exception {
		int cursor = string.indexOf('|');
		IFile sourceFile = testHelper.createFile("foo/Foo", string.replace("|", ""));
		sourceFile.getProject().setDefaultCharset(getNonDefaultEncoding(), null);
		assertTrue(sourceFile.exists());
		waitForAutoBuild();
		XtextEditor editor = openEditor(sourceFile);
		editor.getInternalSourceViewer().setSelectedRange(cursor, 0);
		editor.getInternalSourceViewer().getTextWidget().setFocus();
		return editor;
	}
	
	private TestingTypeHierarchyHandler invokeTestingHandler(XtextEditor xtextEditor, String commandID) throws Exception {
		IHandlerService handlerService = (IHandlerService) xtextEditor.getSite().getService(IHandlerService.class);
		final ICommandService commandService = (ICommandService) xtextEditor.getSite()
				.getService(ICommandService.class);
		Command command = commandService.getCommand("org.eclipse.xtext.xbase.ui.hierarchy.OpenTypeHierarchy");
		TestingTypeHierarchyHandler testingHandler = new TestingTypeHierarchyHandler();
		getInjector().injectMembers(testingHandler);
		IHandler originalHandler = command.getHandler();
		command.setHandler(testingHandler);
		handlerService.executeCommand(COMMAND_ID, null);
		command.setHandler(originalHandler);
		return testingHandler;
	}
	
	public Injector getInjector() {
		return injector;
	}
	
	public <T> T get(Class<T> clazz) {
		return getInjector().getInstance(clazz);
	}
	
	private final class TestingTypeHierarchyHandler extends AbstractTypeHierarchyHandler {
		private IJavaElement resolvedType = null;
		public String getResolvedTypeName(){
			return resolvedType.getElementName();
		}
		@Override
		protected void openPresentation(XtextEditor editor, IJavaElement javaElement, EObject selectedElement) {
			resolvedType = javaElement;
		}
	}
	
	protected String getNonDefaultEncoding() throws CoreException {
		String defaultCharset = workspace.getRoot().getDefaultCharset();
		if (equal(defaultCharset,"UTF-8"))
			return "ISO-8859-1";
		else
			return "UTF-8";
	}
}
