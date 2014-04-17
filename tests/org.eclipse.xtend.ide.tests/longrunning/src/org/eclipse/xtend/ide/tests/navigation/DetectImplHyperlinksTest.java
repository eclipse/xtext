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
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.xtend.ide.internal.XtendActivator;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.junit4.ui.AbstractEditorTest;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.xbase.ui.navigation.XbaseHyperlinkDetector;
import org.eclipse.xtext.xbase.ui.navigation.XbaseImplementatorsHyperlink;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Holger Schill - Initial contribution and API
 */

public class DetectImplHyperlinksTest extends AbstractEditorTest {

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
		String content = "package foo class Foo { def b|ar(String a) {} }";
		XtextEditor xtextEditor = openEditor(content.replace("|", ""));
		int offset = content.indexOf("|");

		IHyperlink[] detectHyperlinks = hyperlinkDetector.detectHyperlinks(xtextEditor.getInternalSourceViewer(), new Region(offset,1), true);
		assertEquals(1, detectHyperlinks.length);
		IHyperlink hyperlink = detectHyperlinks[0];
		assertTrue(hyperlink instanceof XbaseImplementatorsHyperlink);
		XbaseImplementatorsHyperlink casted = (XbaseImplementatorsHyperlink) hyperlink;
		assertEquals(offset -1, casted.getHyperlinkRegion().getOffset());
		assertEquals(3, casted.getHyperlinkRegion().getLength());
		Field elementField = casted.getClass().getDeclaredField("element");
		elementField.setAccessible(true);
		Object element = elementField.get(casted);
		assertTrue(element instanceof IMethod);
		assertEquals("bar",((IMethod)element).getElementName());
	}

	@Test public void testComputeHyperlink_2() throws Exception {
		String content = "package foo class Foo { def bar(String a) { fo|o() } def foo(){}}";
		XtextEditor xtextEditor = openEditor(content.replace("|", ""));
		int offset = content.indexOf("|");

		IHyperlink[] detectHyperlinks = hyperlinkDetector.detectHyperlinks(xtextEditor.getInternalSourceViewer(), new Region(offset,1), true);
		assertEquals(2, detectHyperlinks.length);
		XbaseImplementatorsHyperlink hyperlink = Iterables.filter(Lists.newArrayList(detectHyperlinks),XbaseImplementatorsHyperlink.class).iterator().next();
		assertEquals(offset -2, hyperlink.getHyperlinkRegion().getOffset());
		assertEquals(3, hyperlink.getHyperlinkRegion().getLength());
		Field elementField = hyperlink.getClass().getDeclaredField("element");
		elementField.setAccessible(true);
		Object element = elementField.get(hyperlink);
		assertTrue(element instanceof IMethod);
		assertEquals("foo",((IMethod)element).getElementName());
	}

	@Test public void testComputeHyperlink_3() throws Exception {
		String content = "package foo class Foo { def bar(S|tring a) { foo() } def foo(){}}";
		XtextEditor xtextEditor = openEditor(content.replace("|", ""));
		int offset = content.indexOf("|");

		IHyperlink[] detectHyperlinks = hyperlinkDetector.detectHyperlinks(xtextEditor.getInternalSourceViewer(), new Region(offset,1), true);
		assertEquals(1, detectHyperlinks.length);
		List<XbaseImplementatorsHyperlink> list = Lists.newArrayList(Iterables.filter(Lists.newArrayList(detectHyperlinks),XbaseImplementatorsHyperlink.class));
		assertEquals(0, list.size());
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
