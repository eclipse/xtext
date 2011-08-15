/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.notification;

import java.util.Collection;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtext.common.types.access.jdt.MockJavaProjectProvider;
import org.eclipse.xtext.common.types.tests.AbstractActivator;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.ui.notification.IStateChangeEventBroker;

import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeResourceUnloaderTest extends TestCase implements IResourceDescription.Event.Listener {

	private static final String NESTED_TYPES = "org.eclipse.xtext.common.types.testSetups.NestedTypes";

	private static final String DUMMY_LANG_NAME = "org.eclipse.xtext.common.types.xtext.ui.ContentAssistTestLanguage";
	
	private MockJavaProjectProvider projectProvider;
	private IEditorPart editor;
	private IType type;
	private IJavaProject project;

	private IStateChangeEventBroker eventBroker;

	private volatile IResourceDescription.Event event;

	private ICompilationUnit compilationUnit;

	private IDocument document;

	private String originalContent;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		eventBroker = AbstractActivator.getInstance().getInjector(DUMMY_LANG_NAME).getInstance(IStateChangeEventBroker.class);
		projectProvider = new MockJavaProjectProvider();
		projectProvider.setUseSource(true);
		project = projectProvider.getJavaProject(null);
		type = project.findType(NESTED_TYPES);
		compilationUnit = type.getCompilationUnit();
		compilationUnit.becomeWorkingCopy(null);
		editor = JavaUI.openInEditor(compilationUnit);
		eventBroker.addListener(this);
		document = getDocument();
		originalContent = document.get();
	}
	
	@Override
	protected void tearDown() throws Exception {
		document.set(originalContent);
		editor.doSave(null);
		closeEditors();
		eventBroker.removeListener(this);
		eventBroker = null;
		projectProvider = null;
		compilationUnit = null;
		editor = null;
		type = null;
		project = null;
		event = null;
		super.tearDown();
	}
	
	public void testNullChange() throws BadLocationException, InterruptedException {
		int lastBrace = document.get().lastIndexOf("}");
		document.replace(lastBrace, 0, " ");
		waitForEvent();
		assertNull(event);
	}
	
	public void testRemoveMethod() throws BadLocationException, JavaModelException, InterruptedException {
		String lookup = "abstract boolean method();";
		int idx = document.get().lastIndexOf(lookup);
		document.replace(idx, lookup.length(), "");
		waitForEvent();
		assertNotNull(event);
		assertEquals(1, event.getDeltas().size());
		IResourceDescription.Delta delta = event.getDeltas().get(0);
		assertNotNull(delta.getNew());
		assertNotNull(delta.getOld());
		assertEquals("java:/Objects/" + NESTED_TYPES, delta.getUri().toString());
		Collection<String> allNames = getNames(delta);
		assertOriginalValues(allNames);
		assertEquals(6, allNames.size());
	}

	protected void assertOriginalValues(Collection<String> allNames) {
		assertTrue(allNames.toString(), allNames.contains(NESTED_TYPES + ".method"));
		assertTrue(allNames.toString(), allNames.contains(NESTED_TYPES + "$Outer.method"));
		assertTrue(allNames.toString(), allNames.contains(NESTED_TYPES + "$Outer$Inner.method"));
		assertTrue(allNames.toString(), allNames.contains(NESTED_TYPES));
		assertTrue(allNames.toString(), allNames.contains(NESTED_TYPES + "$Outer"));
		assertTrue(allNames.toString(), allNames.contains(NESTED_TYPES + "$Outer$Inner"));
	}
	
	public void testAddParam() throws BadLocationException, JavaModelException, InterruptedException {
		int idx = document.get().lastIndexOf("(");
		document.replace(idx + 1, 0, "int foobar");
		waitForEvent();
		assertNotNull(event);
		assertEquals(1, event.getDeltas().size());
		IResourceDescription.Delta delta = event.getDeltas().get(0);
		Collection<String> allNames = getNames(delta);
		assertOriginalValues(allNames);
		assertEquals(6, allNames.size());
	}
	
	public void testAddMethod() throws BadLocationException, JavaModelException, InterruptedException {
		String lookup = "abstract boolean method();";
		int idx = document.get().lastIndexOf(lookup);
		document.replace(idx + lookup.length(), 0, "abstract int foobar();");
		waitForEvent();
		assertNotNull(event);
		assertEquals(1, event.getDeltas().size());
		IResourceDescription.Delta delta = event.getDeltas().get(0);
		Collection<String> allNames = getNames(delta);
		assertOriginalValues(allNames);
		assertTrue(allNames.contains(NESTED_TYPES + ".foobar"));
		assertEquals(7, allNames.size());
	}
	
	public void testRenameMethod() throws BadLocationException, JavaModelException, InterruptedException {
		int idx = document.get().lastIndexOf("method(");
		document.replace(idx + "method".length(), 0, "2");
		waitForEvent();
		assertNotNull(event);
		assertEquals(1, event.getDeltas().size());
		IResourceDescription.Delta delta = event.getDeltas().get(0);
		Collection<String> allNames = getNames(delta);
		assertOriginalValues(allNames);
		assertTrue(allNames.contains(NESTED_TYPES + ".method2"));
		assertEquals(7, allNames.size());
	}
	
	public void testRenameInnerMethod() throws BadLocationException, JavaModelException, InterruptedException {
		int idx = document.get().indexOf("method(");
		document.replace(idx + "method".length(), 0, "2");
		waitForEvent();
		assertNotNull(event);
		assertEquals(1, event.getDeltas().size());
		IResourceDescription.Delta delta = event.getDeltas().get(0);
		Collection<String> allNames = getNames(delta);
		assertOriginalValues(allNames);
		assertTrue(allNames.contains(NESTED_TYPES + "$Outer$Inner.method2"));
		assertEquals(7, allNames.size());
	}
	
	public void testRenameClass() throws BadLocationException, JavaModelException, InterruptedException {
		String foobar = "org.eclipse.xtext.common.types.testSetups.FooBar";
		int idx = document.get().indexOf("NestedTypes");
		document.replace(idx, "NestedTypes".length(), "FooBar");
		waitForEvent();
		assertNotNull(event);
		assertEquals(2, event.getDeltas().size());
		IResourceDescription.Delta delta = event.getDeltas().get(0);
		
		Set<String> expectedURIs = Sets.newHashSet("java:/Objects/" + NESTED_TYPES, "java:/Objects/" + foobar);
		assertTrue(expectedURIs.remove(delta.getUri().toString()));
		assertTrue(expectedURIs.remove(event.getDeltas().get(1).getUri().toString()));
		assertTrue(expectedURIs.isEmpty());
		
		Collection<String> allNames = getNames(delta);
		addNames(event.getDeltas().get(1).getOld(), allNames);
		addNames(event.getDeltas().get(1).getNew(), allNames);
		assertTrue(allNames.toString(), allNames.contains(foobar + ".method"));
		assertTrue(allNames.toString(), allNames.contains(foobar + "$Outer.method"));
		assertTrue(allNames.toString(), allNames.contains(foobar + "$Outer$Inner.method"));
		assertTrue(allNames.toString(), allNames.contains(foobar));
		assertTrue(allNames.toString(), allNames.contains(foobar + "$Outer"));
		assertTrue(allNames.toString(), allNames.contains(foobar + "$Outer$Inner"));
		assertTrue(allNames.contains(NESTED_TYPES));
		assertEquals(7, allNames.size());
	}
	
	protected Collection<String> getNames(IResourceDescription.Delta delta) {
		Set<String> result = Sets.newHashSet();
		addNames(delta.getNew(), result);
		addNames(delta.getOld(), result);
		return result;
	}
	
	protected void addNames(IResourceDescription description, Collection<String> names) {
		if (description == null)
			return;
		Iterable<IEObjectDescription> iterable = description.getExportedObjects();
		for (IEObjectDescription object : iterable) {
			names.add(object.getName().toString());
		}
	}
	
	protected void waitForEvent() throws InterruptedException {
		int counter = 500;
		while(event == null && counter > 0) {
			counter--;
			Thread.sleep(15);
		}
	}
	
	public void descriptionsChanged(IResourceDescription.Event event) {
		assertNull("given event has to be the first and only event", this.event);
		this.event = event;
	}

	protected IDocument getDocument() {
		ITextEditor textEditor = (ITextEditor) editor;
		IDocument document = textEditor.getDocumentProvider().getDocument(editor.getEditorInput());
		return document;
	}
	
	protected void closeEditors() {
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeAllEditors(false);
	}

}
