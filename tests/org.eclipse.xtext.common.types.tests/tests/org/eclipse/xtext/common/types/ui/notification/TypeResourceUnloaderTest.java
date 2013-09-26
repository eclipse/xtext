/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.notification;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.core.ElementChangedEvent;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IElementChangedListener;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtext.common.types.access.jdt.MockJavaProjectProvider;
import org.eclipse.xtext.common.types.tests.AbstractActivator;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.ui.notification.IStateChangeEventBroker;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeResourceUnloaderTest extends Assert implements IResourceDescription.Event.Listener, IElementChangedListener {

	private static final String NESTED_TYPES = "org.eclipse.xtext.common.types.testSetups.NestedTypes";

	private static final String DUMMY_LANG_NAME = "org.eclipse.xtext.common.types.xtext.ui.ContentAssistTestLanguage";
	
	private MockJavaProjectProvider projectProvider;
	private IEditorPart editor;
	private IType type;
	private IJavaProject project;
	private volatile List<String> firedElementChangedEvents;

	private IStateChangeEventBroker eventBroker;

	private volatile IResourceDescription.Event event;
	private List<IResourceDescription.Event> subsequentEvents;

	private ICompilationUnit compilationUnit;

	private IDocument document;

	private String originalContent;

	@BeforeClass public static void createMockJavaProject() throws Exception {
		MockJavaProjectProvider.setUp();
	}
	
	@Before
	public void setUp() throws Exception {
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
		firedElementChangedEvents = Lists.newArrayList();
		subsequentEvents = Lists.newArrayList();
	}
	
	@After
	public void tearDown() throws Exception {
		document.set(originalContent);
		editor.doSave(null);
		closeEditors();
		eventBroker.removeListener(this);
		eventBroker = null;
		projectProvider = null;
		compilationUnit.discardWorkingCopy();
		compilationUnit = null;
		editor = null;
		type = null;
		project = null;
		event = null;
		firedElementChangedEvents = null;
		subsequentEvents = null;
	}
	
	@Test public void testNullChange() throws BadLocationException, InterruptedException {
		int lastBrace = document.get().lastIndexOf("}");
		document.replace(lastBrace, 0, " ");
		waitForEvent();
		assertNull(String.valueOf(firedElementChangedEvents), event);
	}
	
	@Test public void testCloseEditor() throws InterruptedException {
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeEditor(editor, false);
		waitForEvent();
		assertNull(String.valueOf(firedElementChangedEvents), event);
	}
	
	@Test public void testCloseAndReopenEditor() throws InterruptedException, PartInitException, JavaModelException {
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeEditor(editor, false);
		editor = JavaUI.openInEditor(compilationUnit);
		waitForEvent();
		assertNull(String.valueOf(firedElementChangedEvents), event);
	}
	
	@Test
	public void testNonStructuralChange() throws BadLocationException, InterruptedException {
		int methodBody = document.get().indexOf("{}") + 1;
		assertNull("event is null before the document was modified", event);
		document.replace(methodBody, 0, "ignored.toString();");
		waitForEvent();
		assertNull(String.valueOf(firedElementChangedEvents), event);
	}
	
	@Test public void testTypeParameterAdded() throws BadLocationException, JavaModelException, InterruptedException {
		String lookup = "NestedTypes";
		int idx = document.get().indexOf(lookup) + "NestedTypes".length();
		assertNull("event is null before the document was modified", event);
		document.replace(idx, 0, "<Abc>");
		waitForEvent();
		assertNotNull(String.valueOf(firedElementChangedEvents), event);
		assertTrue(subsequentEvents.toString(), subsequentEvents.isEmpty());
		assertFalse(event.toString(), event instanceof DeltaConverter.ThrowableWrapper);
		assertEquals(1, event.getDeltas().size());
		IResourceDescription.Delta delta = event.getDeltas().get(0);
		assertNotNull(delta.getNew());
		assertNotNull(delta.getOld());
		assertEquals("java:/Objects/" + NESTED_TYPES, delta.getUri().toString());
		Collection<String> allNames = getNames(delta);
		assertOriginalValues(allNames);
		assertEquals(7, allNames.size());
	}
	
	@Test public void testRemoveMethod() throws BadLocationException, JavaModelException, InterruptedException {
		String lookup = "abstract boolean method();";
		int idx = document.get().lastIndexOf(lookup);
		assertNull("event is null before the document was modified", event);
		document.replace(idx, lookup.length(), "");
		waitForEvent();
		assertNotNull(String.valueOf(firedElementChangedEvents), event);
		assertTrue(subsequentEvents.toString(), subsequentEvents.isEmpty());
		assertFalse(event.toString(), event instanceof DeltaConverter.ThrowableWrapper);
		assertEquals(1, event.getDeltas().size());
		IResourceDescription.Delta delta = event.getDeltas().get(0);
		assertNotNull(delta.getNew());
		assertNotNull(delta.getOld());
		assertEquals("java:/Objects/" + NESTED_TYPES, delta.getUri().toString());
		Collection<String> allNames = getNames(delta);
		assertOriginalValues(allNames);
		assertEquals(7, allNames.size());
	}

	protected void assertOriginalValues(Collection<String> allNames) {
		assertTrue(allNames.toString(), allNames.contains(NESTED_TYPES + ".method"));
		assertTrue(allNames.toString(), allNames.contains(NESTED_TYPES + "$Outer.method"));
		assertTrue(allNames.toString(), allNames.contains(NESTED_TYPES + "$Outer$Inner.method"));
		assertTrue(allNames.toString(), allNames.contains(NESTED_TYPES));
		assertTrue(allNames.toString(), allNames.contains(NESTED_TYPES + "$Outer"));
		assertTrue(allNames.toString(), allNames.contains(NESTED_TYPES + "$Outer$Inner"));
		assertTrue(allNames.toString(), allNames.contains(NESTED_TYPES + "$Outer$Inner.Inner"));
	}
	
	@Test public void testAddParam() throws BadLocationException, JavaModelException, InterruptedException {
		int idx = document.get().lastIndexOf("(");
		assertNull("event is null before the document was modified", event);
		document.replace(idx + 1, 0, "int foobar");
		waitForEvent();
		assertNotNull(String.valueOf(firedElementChangedEvents), event);
		assertTrue(subsequentEvents.toString(), subsequentEvents.isEmpty());
		assertFalse(event.toString(), event instanceof DeltaConverter.ThrowableWrapper);
		assertEquals(1, event.getDeltas().size());
		IResourceDescription.Delta delta = event.getDeltas().get(0);
		Collection<String> allNames = getNames(delta);
		assertOriginalValues(allNames);
		assertEquals(7, allNames.size());
	}
	
	@Test public void testAddMethod() throws BadLocationException, JavaModelException, InterruptedException {
		String lookup = "abstract boolean method();";
		int idx = document.get().lastIndexOf(lookup);
		assertNull("event is null before the document was modified", event);
		document.replace(idx + lookup.length(), 0, "abstract int foobar();");
		waitForEvent();
		assertNotNull(String.valueOf(firedElementChangedEvents), event);
		assertTrue(subsequentEvents.toString(), subsequentEvents.isEmpty());
		assertFalse(event.toString(), event instanceof DeltaConverter.ThrowableWrapper);
		assertEquals(1, event.getDeltas().size());
		IResourceDescription.Delta delta = event.getDeltas().get(0);
		Collection<String> allNames = getNames(delta);
		assertOriginalValues(allNames);
		assertTrue(allNames.contains(NESTED_TYPES + ".foobar"));
		assertEquals(8, allNames.size());
	}
	
	@Test public void testRenameMethod() throws BadLocationException, JavaModelException, InterruptedException {
		int idx = document.get().lastIndexOf("method(");
		assertNull("event is null before the document was modified", event);
		document.replace(idx + "method".length(), 0, "2");
		waitForEvent();
		assertNotNull(String.valueOf(firedElementChangedEvents), event);
		assertTrue(subsequentEvents.toString(), subsequentEvents.isEmpty());
		assertFalse(event.toString(), event instanceof DeltaConverter.ThrowableWrapper);
		assertEquals(1, event.getDeltas().size());
		IResourceDescription.Delta delta = event.getDeltas().get(0);
		Collection<String> allNames = getNames(delta);
		assertOriginalValues(allNames);
		assertTrue(allNames.contains(NESTED_TYPES + ".method2"));
		assertEquals(8, allNames.size());
	}
	
	@Test public void testRenameInnerMethod() throws BadLocationException, JavaModelException, InterruptedException {
		int idx = document.get().indexOf("method(");
		assertNull("event is null before the document was modified", event);
		document.replace(idx + "method".length(), 0, "2");
		waitForEvent();
		assertNotNull(String.valueOf(firedElementChangedEvents), event);
		assertTrue(subsequentEvents.toString(), subsequentEvents.isEmpty());
		assertFalse(event.toString(), event instanceof DeltaConverter.ThrowableWrapper);
		assertEquals("" + event.getDeltas(), 3, event.getDeltas().size());
		IResourceDescription.Delta delta = event.getDeltas().get(2);
		Collection<String> allNames = getNames(delta);
		assertOriginalValues(allNames);
		assertTrue(allNames.contains(NESTED_TYPES + "$Outer$Inner.method2"));
		assertEquals(8, allNames.size());
	}
	
	@Test public void testRenameClass() throws BadLocationException, JavaModelException, InterruptedException {
		String foobar = "org.eclipse.xtext.common.types.testSetups.FooBar";
		int idx = document.get().indexOf("NestedTypes");
		assertNull("event is null before the document was modified", event);
		document.replace(idx, "NestedTypes".length(), "FooBar");
		waitForEvent();
		assertNotNull(String.valueOf(firedElementChangedEvents), event);
		assertTrue(subsequentEvents.toString(), subsequentEvents.isEmpty());
		assertFalse(event.toString(), event instanceof DeltaConverter.ThrowableWrapper);
		assertEquals("" + event.getDeltas(), 3, event.getDeltas().size());
		IResourceDescription.Delta delta = event.getDeltas().get(0);
		
		Set<String> expectedURIs = Sets.newHashSet("java:/Objects/" + NESTED_TYPES, "java:/Objects/" + foobar, "java:/Objects/" + foobar + "$Outer");
		assertTrue(expectedURIs.remove(delta.getUri().toString()));
		assertTrue(expectedURIs.remove(event.getDeltas().get(1).getUri().toString()));
		assertTrue(expectedURIs.remove(event.getDeltas().get(2).getUri().toString()));
		assertTrue(expectedURIs.isEmpty());
		
		Collection<String> allNames = getNames(delta);
		addNames(event.getDeltas().get(1).getNew(), allNames); //FooBar
		addNames(event.getDeltas().get(2).getOld(), allNames); //NestedTypes
		assertTrue(allNames.toString(), allNames.contains(foobar + ".method"));
		assertTrue(allNames.toString(), allNames.contains(foobar + "$Outer.method"));
		assertTrue(allNames.toString(), allNames.contains(foobar + "$Outer$Inner.method"));
		assertTrue(allNames.toString(), allNames.contains(foobar));
		assertTrue(allNames.toString(), allNames.contains(foobar + "$Outer"));
		assertTrue(allNames.toString(), allNames.contains(foobar + "$Outer$Inner"));
		assertTrue(allNames.toString(), allNames.contains(foobar + "$Outer$Inner.Inner"));
		assertTrue(allNames.toString(), allNames.contains(NESTED_TYPES));
		assertEquals(8, allNames.size());
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
		try {
			JavaCore.addElementChangedListener(this);
			// the Java reconciler is blazingly fast, it should never
			// be necessary to increase the counter here
			int counter = 50;
			while(event == null && counter > 0) {
				counter--;
				Thread.sleep(15);
			}
		} finally {
			JavaCore.removeElementChangedListener(this);
		}
	}
	
	public void elementChanged(ElementChangedEvent elementChanged) {
		if (firedElementChangedEvents != null)
			firedElementChangedEvents.add(String.valueOf(elementChanged));
	}
	
	public void descriptionsChanged(IResourceDescription.Event event) {
		if (this.event != null && subsequentEvents != null) {
			subsequentEvents.add(event);
		}
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
