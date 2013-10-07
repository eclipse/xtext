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
import org.eclipse.xtext.xbase.lib.Procedures;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
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
		waitForEvent(new Procedure0() {

			public void apply() {
				try {
					int lastBrace = document.get().lastIndexOf("}");
					document.replace(lastBrace, 0, " ");
				} catch (BadLocationException e) {
					Assert.fail(e.getMessage());
				}
			}

		});
		assertNull(String.valueOf(firedElementChangedEvents), event);
	}
	
	@Test public void testCloseEditor() throws InterruptedException {
		waitForEvent(new Procedure0() {

			public void apply() {
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeEditor(editor, false);
			}

		});
		assertNull(String.valueOf(firedElementChangedEvents), event);
	}
	
	@Test public void testCloseAndReopenEditor() throws InterruptedException, PartInitException, JavaModelException {
		waitForEvent(new Procedure0() {
			
			public void apply() {
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeEditor(editor, false);
				try {
					editor = JavaUI.openInEditor(compilationUnit);
				} catch (PartInitException e) {
					fail(e.getMessage());
				} catch (JavaModelException e) {
					fail(e.getMessage());
				}		
			}
		});
		assertNull(String.valueOf(firedElementChangedEvents), event);
	}
	
	@Test
	public void testNonStructuralChange() throws BadLocationException, InterruptedException {
		waitForEvent(new Procedure0() {
			
			public void apply() {
				int methodBody = document.get().indexOf("{}") + 1;
				assertNull("event is null before the document was modified", event);
				try {
					document.replace(methodBody, 0, "ignored.toString();");
				} catch (BadLocationException e) {
					fail(e.getMessage());
				}
				
			}
		});
		assertNull(String.valueOf(firedElementChangedEvents), event);
	}
	
	@Test public void testTypeParameterAdded() throws BadLocationException, JavaModelException, InterruptedException {
		waitForEvent(new Procedure0() {

			public void apply() {
				String lookup = "NestedTypes";
				int idx = document.get().indexOf(lookup) + "NestedTypes".length();
				assertNull("event is null before the document was modified", event);
				try {
					document.replace(idx, 0, "<Abc>");
				} catch (BadLocationException e) {
					fail(e.getMessage());
				}
			}

		});
		assertNotNull(String.valueOf(firedElementChangedEvents), event);
		assertTrue(subsequentEvents.toString(), subsequentEvents.isEmpty());
		assertEquals("" + event.getDeltas(), 3, event.getDeltas().size());
		IResourceDescription.Delta delta = event.getDeltas().get(0);
		assertNotNull(delta.getNew());
		assertNotNull(delta.getOld());
		assertEquals("java:/Objects/" + NESTED_TYPES, delta.getUri().toString());
		Collection<String> allNames = getNames(event.getDeltas());
		assertOriginalValues(allNames);
		assertEquals("" + allNames, 3, allNames.size());
	}
	
	@Test public void testRemoveMethod() throws BadLocationException, JavaModelException, InterruptedException {
		waitForEvent(new Procedure0() {

			public void apply() {
				String lookup = "abstract boolean method();";
				int idx = document.get().lastIndexOf(lookup);
				assertNull("event is null before the document was modified", event);
				try {
					document.replace(idx, lookup.length(), "");
				} catch (BadLocationException e) {
					fail(e.getMessage());
				}
			}

		});
		assertNotNull(String.valueOf(firedElementChangedEvents), event);
		assertTrue(subsequentEvents.toString(), subsequentEvents.isEmpty());
		assertEquals("" + event.getDeltas(), 3, event.getDeltas().size());
		IResourceDescription.Delta delta = event.getDeltas().get(0);
		assertNotNull(delta.getNew());
		assertNotNull(delta.getOld());
		assertEquals("java:/Objects/" + NESTED_TYPES, delta.getUri().toString());
		Collection<String> allNames = getNames(event.getDeltas());
		assertOriginalValues(allNames);
		assertEquals("" + allNames, 3, allNames.size());
	}

	protected void assertOriginalValues(Collection<String> allNames) {
		assertTrue(allNames.toString(), allNames.contains(NESTED_TYPES));
		assertTrue(allNames.toString(), allNames.contains(NESTED_TYPES + "$Outer"));
		assertTrue(allNames.toString(), allNames.contains(NESTED_TYPES + "$Outer$Inner"));
	}
	
	@Test public void testAddParam() throws BadLocationException, JavaModelException, InterruptedException {
		waitForEvent(new Procedure0() {

			public void apply() {
				int idx = document.get().lastIndexOf("(");
				assertNull("event is null before the document was modified", event);
				try {
					document.replace(idx + 1, 0, "int foobar");
				} catch (BadLocationException e) {
					fail(e.getMessage());
				}
			}

		});
		assertNotNull(String.valueOf(firedElementChangedEvents), event);
		assertTrue(subsequentEvents.toString(), subsequentEvents.isEmpty());
		assertEquals("" + event.getDeltas(), 3, event.getDeltas().size());
		Collection<String> allNames = getNames(event.getDeltas());
		assertOriginalValues(allNames);
		assertEquals("" + allNames, 3, allNames.size());
	}
	
	@Test public void testAddMethod() throws BadLocationException, JavaModelException, InterruptedException {
		waitForEvent(new Procedure0() {

			public void apply() {
				String lookup = "abstract boolean method();";
				int idx = document.get().lastIndexOf(lookup);
				assertNull("event is null before the document was modified", event);
				try {
					document.replace(idx + lookup.length(), 0, "abstract int foobar();");
				} catch (BadLocationException e) {
					fail(e.getMessage());
				}
			}

		});
		assertNotNull(String.valueOf(firedElementChangedEvents), event);
		assertTrue(subsequentEvents.toString(), subsequentEvents.isEmpty());
		assertEquals("" + event.getDeltas(), 3, event.getDeltas().size());
		Collection<String> allNames = getNames(event.getDeltas());
		assertOriginalValues(allNames);
		assertEquals("" + allNames, 3, allNames.size());
	}
	
	@Test public void testRenameMethod() throws BadLocationException, JavaModelException, InterruptedException {
		waitForEvent(new Procedure0() {

			public void apply() {
				int idx = document.get().lastIndexOf("method(");
				assertNull("event is null before the document was modified", event);
				try {
					document.replace(idx + "method".length(), 0, "2");
				} catch (BadLocationException e) {
					fail(e.getMessage());
				}
			}

		});
		assertNotNull(String.valueOf(firedElementChangedEvents), event);
		assertTrue(subsequentEvents.toString(), subsequentEvents.isEmpty());
		assertEquals("" + event.getDeltas(), 3, event.getDeltas().size());
		Collection<String> allNames = getNames(event.getDeltas());
		assertOriginalValues(allNames);
		assertEquals("" + allNames, 3, allNames.size());
	}
	
	@Test public void testRenameInnerMethod() throws BadLocationException, JavaModelException, InterruptedException {
		waitForEvent(new Procedure0() {

			public void apply() {
				int idx = document.get().indexOf("method(");
				assertNull("event is null before the document was modified", event);
				try {
					document.replace(idx + "method".length(), 0, "2");
				} catch (BadLocationException e) {
					fail(e.getMessage());
				}
			}

		});
		assertNotNull(String.valueOf(firedElementChangedEvents), event);
		assertTrue(subsequentEvents.toString(), subsequentEvents.isEmpty());
		assertEquals("" + event.getDeltas(), 3, event.getDeltas().size());
		Collection<String> allNames = getNames(event.getDeltas());
		assertOriginalValues(allNames);
		assertEquals("" + allNames, 3, allNames.size());
	}
	
	@Test public void testRenameClass() throws BadLocationException, JavaModelException, InterruptedException {
		waitForEvent(new Procedure0() {

			public void apply() {
				int idx = document.get().indexOf("NestedTypes");
				assertNull("event is null before the document was modified", event);
				try {
					document.replace(idx, "NestedTypes".length(), "FooBar");
				} catch (BadLocationException e) {
					fail(e.getMessage());
				}
			}

		});
		String foobar = "org.eclipse.xtext.common.types.testSetups.FooBar";
		assertNotNull(String.valueOf(firedElementChangedEvents), event);
		assertTrue(subsequentEvents.toString(), subsequentEvents.isEmpty());
		assertEquals("" + event.getDeltas(), 6, event.getDeltas().size());
		IResourceDescription.Delta delta = event.getDeltas().get(0);
		
		Set<String> expectedURIs = Sets.newHashSet("java:/Objects/" + NESTED_TYPES,
				"java:/Objects/" + NESTED_TYPES + "$Outer", 
				"java:/Objects/" + NESTED_TYPES + "$Outer$Inner",
				"java:/Objects/" + foobar,
				"java:/Objects/" + foobar + "$Outer", 
				"java:/Objects/" + foobar + "$Outer$Inner");
		assertTrue("" + delta.getUri(), expectedURIs.remove(delta.getUri().toString()));
		for (int i = 1; i < 6; i++) {
			String uri = event.getDeltas().get(i).getUri().toString();
			assertTrue(uri, expectedURIs.remove(uri));
		}
		assertTrue(expectedURIs.isEmpty());
		
		Collection<String> allNames = getNames(delta);
		addNames(event.getDeltas().get(0).getNew(), allNames); //FooBar
		addNames(event.getDeltas().get(1).getNew(), allNames); //FooBar$Outer
		addNames(event.getDeltas().get(2).getNew(), allNames); //FooBar$Outer$Inner
		addNames(event.getDeltas().get(3).getOld(), allNames); //NestedTypes
		addNames(event.getDeltas().get(4).getOld(), allNames); //NestedTypes$Outer
		addNames(event.getDeltas().get(5).getOld(), allNames); //NestedTypes$Outer$Inner
		assertTrue(allNames.toString(), allNames.contains(foobar));
		assertTrue(allNames.toString(), allNames.contains(foobar + "$Outer"));
		assertTrue(allNames.toString(), allNames.contains(foobar + "$Outer$Inner"));
		assertTrue(allNames.toString(), allNames.contains(NESTED_TYPES));
		assertTrue(allNames.toString(), allNames.contains(NESTED_TYPES + "$Outer"));
		assertTrue(allNames.toString(), allNames.contains(NESTED_TYPES + "$Outer$Inner"));
		assertEquals("" + allNames, 6, allNames.size());
	}
	
	protected Collection<String> getNames(List<IResourceDescription.Delta> deltas) {
		Set<String> result = Sets.newHashSet();
		for (IResourceDescription.Delta delta : deltas) {
			addNames(delta.getNew(), result);
			addNames(delta.getOld(), result);
		}
		return result;
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
	
	protected void waitForEvent(Procedures.Procedure0 procedure) throws InterruptedException {
		try {
			JavaCore.addElementChangedListener(this);
			procedure.apply();
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
