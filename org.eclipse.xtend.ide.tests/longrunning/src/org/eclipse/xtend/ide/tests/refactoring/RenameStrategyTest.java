/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.refactoring;

import static com.google.common.collect.Iterables.*;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.ide.editor.OverrideIndicatorAnnotation;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy.Provider.NoSuchStrategyException;
import org.eclipse.xtext.ui.refactoring.ui.IRenameContextFactory;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */

public class RenameStrategyTest extends AbstractXtendUITestCase {

	@Inject
	private IRenameStrategy.Provider renameStrategyProvider;

	@Inject
	private IRenameContextFactory renameContextFactory;

	@Inject
	private IXtendJvmAssociations associations;

	@Inject
	private WorkbenchTestHelper testHelper;

	@Test public void testOverrideIndicatorAnnotationAfterFileRename() throws Exception {
		testHelper.createFile("test/SuperClass","package test\nclass SuperClass { def foo() {}}");
		final IFile subClassFile = testHelper.createFile("test/SubClass","package test\nclass SubClass extends SuperClass { override foo () {}}");
		IResourcesSetupUtil.waitForBuild();
		XtextEditor openEditor = testHelper.openEditor(subClassFile);
		final OverrideIndicatorAnnotation[] annotationBeforeFileRename = new OverrideIndicatorAnnotation[]{null};
		final OverrideIndicatorAnnotation[] annotationAfterFileRename = new OverrideIndicatorAnnotation[]{null};
		final ISourceViewer sourceViewer = openEditor.getInternalSourceViewer();
		sleepWhile(Predicates.isNull(), new Provider<Object>() {

			@Override
			public OverrideIndicatorAnnotation get() {
				annotationBeforeFileRename[0] = Iterators.getOnlyElement(Iterators.filter(sourceViewer.getAnnotationModel().getAnnotationIterator(), OverrideIndicatorAnnotation.class), null);
				return annotationBeforeFileRename[0];
			}
		},TimeUnit.SECONDS.toMillis(10));
		assertNotNull(annotationBeforeFileRename[0]);
		new WorkspaceModifyOperation() {
			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException,
					InterruptedException {
				subClassFile.move(subClassFile.getFullPath().removeLastSegments(1).append("Test.xtend"), true, monitor);
			}
		}.run(new NullProgressMonitor());
		IResourcesSetupUtil.waitForBuild();
		sleepWhile(Predicates.isNull(), new Provider<Object>() {

			@Override
			public OverrideIndicatorAnnotation get() {
				OverrideIndicatorAnnotation ann = Iterators.getOnlyElement(Iterators.filter(sourceViewer.getAnnotationModel().getAnnotationIterator(), OverrideIndicatorAnnotation.class), null);
				if (ann != annotationBeforeFileRename[0])
					annotationAfterFileRename[0] = ann;
				return annotationAfterFileRename[0];
			}
		},TimeUnit.SECONDS.toMillis(10));
		assertNotNull(annotationAfterFileRename[0]);
		assertNotSame(annotationBeforeFileRename[0], annotationAfterFileRename[0]);
	}

	private <T> void sleepWhile(Predicate<T> test, Provider<T> input, long timeOutInMillis) {
		Display display = Display.getCurrent();
		long timeToGo = System.currentTimeMillis() + timeOutInMillis;
		while (System.currentTimeMillis() < timeToGo && test.apply(input.get())) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.update();
	}

	@Test public void testInferredClassRenamed() throws Exception {
		XtendClass fooClass = (XtendClass) testHelper.xtendFile("Foo", "class Foo { }").getXtendTypes().get(0);
		IRenameStrategy renameStrategy = createRenameStrategy(fooClass);
		renameStrategy.applyDeclarationChange("Bar", fooClass.eResource().getResourceSet());
		JvmGenericType inferredType = associations.getInferredType(fooClass);
		JvmConstructor inferredConstructor = associations.getInferredConstructor(fooClass);
		assertEquals("Bar", fooClass.getName());
		assertEquals("Bar", inferredType.getSimpleName());
		assertEquals("Bar", inferredConstructor.getSimpleName());
		renameStrategy.revertDeclarationChange(fooClass.eResource().getResourceSet());
		inferredType = associations.getInferredType(fooClass);
		inferredConstructor = associations.getInferredConstructor(fooClass);
		assertEquals("Foo", fooClass.getName());
		assertEquals("Foo", inferredType.getSimpleName());
		assertEquals("Foo", inferredConstructor.getSimpleName());
	}

	@Test public void testInferredMethodRenamed() throws Exception {
		XtendFunction fooMethod = (XtendFunction) ((XtendClass)testHelper.xtendFile("Foo", "class Foo { def Foo foo() {this} }")
				.getXtendTypes().get(0)).getMembers().get(0);
		IRenameStrategy renameStrategy = createRenameStrategy(fooMethod);
		renameStrategy.applyDeclarationChange("bar", fooMethod.eResource().getResourceSet());
		assertEquals("bar", fooMethod.getName());
		JvmOperation inferredOperation = associations.getDirectlyInferredOperation(fooMethod);
		assertEquals("bar", inferredOperation.getSimpleName());
		renameStrategy.revertDeclarationChange(fooMethod.eResource().getResourceSet());
		inferredOperation = associations.getDirectlyInferredOperation(fooMethod);
		assertEquals("foo", fooMethod.getName());
		assertEquals("foo", inferredOperation.getSimpleName());
	}

	@Test public void testXtendConstructorIgnored() throws Exception {
		XtendConstructor constructor = (XtendConstructor) ((XtendClass)testHelper.xtendFile("Foo", "class Foo { new() {} }")
				.getXtendTypes().get(0)).getMembers().get(0);
		IRenameStrategy renameStrategy = createRenameStrategy(constructor);
		assertNull(renameStrategy);
	}
	
	@Test public void testDispatchMethods() throws Exception {
		XtendClass fooClass = (XtendClass) testHelper.xtendFile("Foo", 
				"class Foo { def dispatch foo(Number it) {} def dispatch foo(String it) {} }")
				.getXtendTypes().get(0);
		IResourcesSetupUtil.waitForBuild();
		XtendFunction fooMethod0 = (XtendFunction) fooClass.getMembers().get(0);
		IRenameStrategy renameStrategy = createRenameStrategy(fooMethod0);
		assertNotNull(renameStrategy);
		renameStrategy.applyDeclarationChange("bar", fooMethod0.eResource().getResourceSet());
		for(XtendFunction f: filter(fooClass.getMembers(), XtendFunction.class)) { 
			assertEquals("bar", f.getName());
			assertEquals("_bar", associations.getDirectlyInferredOperation(f).getSimpleName());
			assertEquals("bar", associations.getDispatchOperation(f).getSimpleName());
		}
		renameStrategy.revertDeclarationChange(fooMethod0.eResource().getResourceSet());
		for(XtendFunction f: filter(fooClass.getMembers(), XtendFunction.class)) { 
			assertEquals("foo", f.getName());
			assertEquals("_foo", associations.getDirectlyInferredOperation(f).getSimpleName());
			assertEquals("foo", associations.getDispatchOperation(f).getSimpleName());
		}
	}

	protected IRenameStrategy createRenameStrategy(EObject target) throws NoSuchStrategyException {
		IRenameElementContext renameElementContext = renameContextFactory.createRenameElementContext(target, null, null, 
				(XtextResource) target.eResource());
		return renameStrategyProvider.get(target, renameElementContext);
	}
}
