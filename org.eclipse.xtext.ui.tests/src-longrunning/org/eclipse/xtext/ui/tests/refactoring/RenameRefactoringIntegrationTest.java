/*******************************************************************************
 * Copyright (c) 2010, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring;

import static com.google.common.collect.Lists.*;
import static org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.refactoring.impl.RenameElementProcessor;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.ui.testing.AbstractEditorTest;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.tests.internal.TestsActivator;
import org.eclipse.xtext.ui.tests.refactoring.refactoring.RefactoringPackage;
import org.eclipse.xtext.ui.tests.refactoring.referring.Reference;
import org.eclipse.xtext.ui.tests.refactoring.referring.ReferringFactory;
import org.eclipse.xtext.ui.tests.refactoring.resource.RefactoringTestLanguageFragmentProvider;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.junit.Test;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class RenameRefactoringIntegrationTest extends AbstractEditorTest {

	@Inject
	private Provider<RenameElementProcessor> processorProvider;

	@Inject
	private RefactoringTestLanguageFragmentProvider fragmentProvider;

	private static final String TEST_PROJECT = "refactoring.test";
	private static final String TEST_FILE0_NAME = TEST_PROJECT + "/" + "File0.refactoringtestlanguage";
	private static final String TEST_FILE1_NAME = TEST_PROJECT + "/" + "File1.refactoringtestlanguage";
	private String initialModel0;
	private IFile testFile0;
	private String initialModel1;
	private IFile testFile1;
	private URI uriB;
	private IProject project;
	protected Change undoChange;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		project = createProject(TEST_PROJECT);
		IJavaProject javaProject = makeJavaProject(project);
		addNature(javaProject.getProject(), XtextProjectHelper.NATURE_ID);
		Injector injector = TestsActivator.getInstance().getInjector(getEditorId());
		injector.injectMembers(this);
		fragmentProvider.setUseNames(true);
		initialModel0 = "B A { ref B }";
		testFile0 = IResourcesSetupUtil.createFile(TEST_FILE0_NAME, initialModel0);
		initialModel1 = "X { ref B }";
		testFile1 = IResourcesSetupUtil.createFile(TEST_FILE1_NAME, initialModel1);
		uriB = URI.createPlatformResourceURI(testFile0.getFullPath().toString(), true).appendFragment("B");
	}

	@Override
	public void tearDown() throws Exception {
		fragmentProvider.setUseNames(false);
		super.tearDown();
	}

	@Override
	protected String getEditorId() {
		return TestsActivator.ORG_ECLIPSE_XTEXT_UI_TESTS_REFACTORING_REFACTORINGTESTLANGUAGE;
	}

	@Test public void testFileFileRename() throws Exception {
		doRename();
		assertEquals(initialModel0.replaceAll("B", "C"), fileToString(testFile0));
		assertEquals(initialModel1.replaceAll("B", "C"), fileToString(testFile1));
		undoRename();
		assertEquals(initialModel0, fileToString(testFile0));
		assertEquals(initialModel1, fileToString(testFile1));
	}

	@Test public void testEditorFileRename() throws Exception {
		XtextEditor editor = openEditor(testFile0);
		doRename();
		testFile0.refreshLocal(-1, null);
		waitForBuild();
		assertEquals(initialModel0.replaceAll("B", "C"), editor.getDocument().get());
		assertEquals(initialModel1.replaceAll("B", "C"), fileToString(testFile1));
		undoRename();
		assertEquals(initialModel0, editor.getDocument().get());
		assertEquals(initialModel1, fileToString(testFile1));
	}

	@Test public void testEditorEditorRename() throws Exception {
		XtextEditor editor0 = openEditor(testFile0);
		XtextEditor editor1 = openEditor(testFile1);
		doRename();
		assertEquals(initialModel0.replaceAll("B", "C"), editor0.getDocument().get());
		assertEquals(initialModel1.replaceAll("B", "C"), editor1.getDocument().get());
		undoRename();
		assertEquals(initialModel0, editor0.getDocument().get());
		assertEquals(initialModel1, editor1.getDocument().get());
	}

	@Test public void testDirtyEditorRename() throws Exception {
		XtextEditor editor0 = openEditor(testFile0);
		XtextEditor editor1 = openEditor(testFile1);
		new ReplaceEdit(0, 0, " ").apply(editor0.getDocument());
		new ReplaceEdit(0, 0, " ").apply(editor1.getDocument());
		waitForReconciler(editor0);
		waitForReconciler(editor1);
		doRename();
		assertEquals(" " + initialModel0.replaceAll("B", "C"), editor0.getDocument().get());
		assertEquals(" " + initialModel1.replaceAll("B", "C"), editor1.getDocument().get());
		undoRename();
		assertEquals(" " + initialModel0, editor0.getDocument().get());
		assertEquals(" " + initialModel1, editor1.getDocument().get());
	}

	@Test public void testFileEditorRename() throws Exception {
		XtextEditor editor1 = openEditor(testFile1);
		doRename();
		assertEquals(initialModel0.replaceAll("B", "C"), fileToString(testFile0));
		assertEquals(initialModel1.replaceAll("B", "C"), editor1.getDocument().get());
		undoRename();
		assertEquals(initialModel0, fileToString(testFile0));
		assertEquals(initialModel1, editor1.getDocument().get());
	}

	@Test public void testDirtyEditor() throws Exception {
		XtextEditor editor = openEditor(testFile0);
		String dirtyModel = "Y B A { ref B }";
		editor.getDocument().set(dirtyModel);
		waitForReconciler(editor);
		assertTrue(editor.isDirty());
		doRename();
		assertTrue(editor.isDirty());
		assertEquals(dirtyModel.replace("B", "C"), editor.getDocument().get());
	}

	@Test public void testRefFromOtherXtextLanguage() throws Exception {
		String initialModel = "ref B";
		IFile otherLanguageFile = IResourcesSetupUtil.createFile(TEST_PROJECT
				+ "/otherLanguageFile.referringtestlanguage", initialModel);
		doRename();
		assertEquals(initialModel.replaceAll("B", "C"), fileToString(otherLanguageFile));
	}
	
	@Test public void testRefFromOtherXtextLanguage2() throws Exception {
		String initialModel = "refx = B";
		IFile otherLanguageFile = IResourcesSetupUtil.createFile(TEST_PROJECT
				+ "/otherLanguageFile.referringtestlanguage", initialModel);
		doRename();
		assertEquals(initialModel.replaceAll("B", "C"), fileToString(otherLanguageFile));
	}

	@Test public void testRefFromOtherNonXtextLanguage() throws Exception {
		ResourceSet resourceSet = new ResourceSetImpl();
		EObject elementB = resourceSet.getEObject(uriB, true);
		String xmiFileName = "otherLanguageFile.referring_xmi";
		Resource referringResource = resourceSet.createResource(URI.createPlatformResourceURI(TEST_PROJECT + "/"
				+ xmiFileName, true));
		Reference ref = ReferringFactory.eINSTANCE.createReference();
		ref.setReferenced(elementB);
		referringResource.getContents().add(ref);
		referringResource.save(null);
		project.refreshLocal(IResource.DEPTH_INFINITE, null);
		IFile referringXmiFile = project.getFile(xmiFileName);
		String originalContent = fileToString(referringXmiFile);
		doRename();
		assertEquals(originalContent.replaceAll("#B", "#C"), fileToString(referringXmiFile));
	}

	@Test public void testClusteringReferenceUpdater() throws Exception {
		List<IFile> referringFiles = newArrayList();
		for (int i = 0; i < 41; ++i) {
			createFile(TEST_PROJECT + "/ref" + i + ".refactoringtestlanguage", "foo" + i + " {ref B}");
		}
		waitForBuild();
		doRename();
		waitForBuild();
		int i = 0;
		for (IFile file : referringFiles) {
			assertEquals("foo" + i++ + " {ref C}", fileToString(file));
		}
		undoRename();
		waitForBuild();
		i = 0;
		for (IFile file : referringFiles) {
			assertEquals("foo" + i++ + " {ref B}", fileToString(file));
		}
	}

	protected void doRename() throws Exception {
		IResourcesSetupUtil.waitForBuild();
		final Change change = createChange(uriB, "C");
		new WorkspaceModifyOperation() {
			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException,
					InterruptedException {
				undoChange = change.perform(monitor);
			}
		}.run(null);
	}

	protected void undoRename() throws Exception {
		IResourcesSetupUtil.waitForBuild();
		new WorkspaceModifyOperation() {
			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException,
					InterruptedException {
				undoChange.perform(monitor);
			}
		}.run(null);
	}

	protected Change createChange(URI targetElementURI, String newName) throws Exception {
		RenameElementProcessor processor = processorProvider.get();
		processor.initialize(new IRenameElementContext.Impl(targetElementURI, RefactoringPackage.Literals.ELEMENT,
				null, null, null));
		processor.setNewName(newName);
		RefactoringStatus initialStatus = processor.checkInitialConditions(new NullProgressMonitor());
		assertTrue("Initial RefactoringStatus is OK", initialStatus.isOK());
		RefactoringStatus finalStatus = processor.checkFinalConditions(new NullProgressMonitor(), null);
		assertTrue("Final RefactoringStatus is OK", finalStatus.isOK());
		final Change change = processor.createChange(new NullProgressMonitor());
		assertNotNull("RenameElementProcessor created changes", change);
		return change;
	}

	protected void waitForReconciler(XtextEditor editor) {
		editor.getDocument().readOnly(new IUnitOfWork.Void<XtextResource>() {
			@Override
			public void process(XtextResource state) throws Exception {
				// just wait for the reconciler to announce the dirty state
			}
		});
	}
}
