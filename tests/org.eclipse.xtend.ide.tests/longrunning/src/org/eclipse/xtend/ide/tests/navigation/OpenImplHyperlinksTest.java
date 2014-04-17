/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.navigation;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.util.Strings.*;

import java.lang.reflect.Field;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.xtend.ide.internal.XtendActivator;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.junit4.ui.AbstractEditorTest;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.xbase.ui.navigation.JvmImplementationOpener;
import org.eclipse.xtext.xbase.ui.navigation.XbaseHyperlinkDetector;
import org.eclipse.xtext.xbase.ui.navigation.XbaseImplementatorsHyperlink;
import org.junit.Test;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Holger Schill - Initial contribution and API
 */

public class OpenImplHyperlinksTest extends AbstractEditorTest {

	private static final String LANGUAGE_NAME = "org.eclipse.xtend.core.Xtend";
	private static Injector injector = XtendActivator.getInstance().getInjector(LANGUAGE_NAME);

	@Inject
	private IWorkspace workspace;
	@Inject
	private WorkbenchTestHelper testHelper;
	@Inject
	private XbaseHyperlinkDetector hyperlinkDetector;

	@Override
	public void setUp() throws Exception {
		getInjector().injectMembers(this);
		closeWelcomePage();
		closeEditors();
	}

	@Override
	public void tearDown() throws Exception {
		testHelper.tearDown();
	}

	@Test public void testComputeHyperlink_1() throws Exception {
		String content = "package foo class Foo implements IBar { override b|ar(String a) {} } interface IBar { def bar(String a) }";
		XtextEditor xtextEditor = openEditor(content.replace("|", ""));
		int offset = content.indexOf("|");
		IHyperlink[] detectHyperlinks = hyperlinkDetector.detectHyperlinks(xtextEditor.getInternalSourceViewer(), new Region(offset,1), true);
		assertEquals(1, detectHyperlinks.length);
		IHyperlink hyperlink = detectHyperlinks[0];
		assertTrue(hyperlink instanceof XbaseImplementatorsHyperlink);
		XbaseImplementatorsHyperlink casted = (XbaseImplementatorsHyperlink) hyperlink;
		Field field = casted.getClass().getDeclaredField("opener");
		field.setAccessible(true);
		TestJvmImplementationOpener testOpener = new TestJvmImplementationOpener();
		field.set(casted, testOpener);
		casted.open();
		assertTrue(testOpener.isOpenInEditor);
		assertFalse(testOpener.isOpenQuickHierarchy);

	}

	@Test public void testComputeHyperlink_2() throws Exception {
		String content = "package foo interface IBar {def void b|ar(String a)} class Foo implements IBar { override bar(String a){} } class Foo2 implements IBar { override bar(String a) {} }";
		XtextEditor xtextEditor = openEditor(content.replace("|", ""));
		int offset = content.indexOf("|");
		IHyperlink[] detectHyperlinks = hyperlinkDetector.detectHyperlinks(xtextEditor.getInternalSourceViewer(), new Region(offset,1), true);
		assertEquals(1, detectHyperlinks.length);
		IHyperlink hyperlink = detectHyperlinks[0];
		assertTrue(hyperlink instanceof XbaseImplementatorsHyperlink);
		XbaseImplementatorsHyperlink casted = (XbaseImplementatorsHyperlink) hyperlink;
		Field field = casted.getClass().getDeclaredField("opener");
		field.setAccessible(true);
		TestJvmImplementationOpener testOpener = new TestJvmImplementationOpener();
		field.set(casted, testOpener);
		casted.open();
		assertFalse(testOpener.isOpenInEditor);
		assertTrue(testOpener.isOpenQuickHierarchy);

	}

	@Override
	protected String getEditorId() {
		return LANGUAGE_NAME;
	}

	protected XtextEditor openEditor(String content) throws Exception {
		IFile sourceFile = testHelper.createFile("foo/Foo", content);
		sourceFile.getProject().setDefaultCharset(getNonDefaultEncoding(), null);
		assertTrue(sourceFile.exists());
		waitForAutoBuild();
		XtextEditor editor = openEditor(sourceFile);
		return editor;
	}

	class TestJvmImplementationOpener extends JvmImplementationOpener {
		boolean isOpenQuickHierarchy = false;

		boolean isOpenInEditor = false;

		@Override
		protected void openQuickHierarchy(ITextViewer textViewer, IJavaElement element, IRegion region) {
			isOpenQuickHierarchy = true;
			assertNotNull(element);
			assertTrue(element instanceof IMethod);
		}
		@Override
		protected IEditorPart openEditor(IJavaElement element) throws JavaModelException, PartInitException {
			assertNotNull(element);
			assertTrue(element instanceof IMethod);
			isOpenInEditor = true;
			return null;
		}
	}

	public Injector getInjector() {
		return injector;
	}

	public <T> T get(Class<T> clazz) {
		return getInjector().getInstance(clazz);
	}

	protected String getNonDefaultEncoding() throws CoreException {
		String defaultCharset = workspace.getRoot().getDefaultCharset();
		if (equal(defaultCharset,"UTF-8"))
			return "ISO-8859-1";
		else
			return "UTF-8";
	}
}
