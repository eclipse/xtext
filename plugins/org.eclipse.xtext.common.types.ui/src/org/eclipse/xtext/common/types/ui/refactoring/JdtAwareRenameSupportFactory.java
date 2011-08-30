/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.refactoring;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.refactoring.descriptors.RenameJavaElementDescriptor;
import org.eclipse.jdt.ui.refactoring.RenameSupport;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.ui.refactoring.ui.DefaultRenameSupport.Factory;
import org.eclipse.xtext.ui.refactoring.ui.IRenameSupport;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class JdtAwareRenameSupportFactory extends Factory {

	@Inject
	private JvmRenameRefactoringProvider jvmRenameRefactorigProvider;

	@Override
	public IRenameSupport create(Object context, String newName) {
		if (context instanceof DelegateToJavaRefactoringContext) {
			try {
				RenameJavaElementDescriptor descriptor = createDescriptor((DelegateToJavaRefactoringContext) context, newName);
				return new JdtRenameSupportWrapper(descriptor);
			} catch (Exception exc) {
				throw new WrappedException(exc);
			}
		}
		return super.create(context, newName);
	}

	protected RenameJavaElementDescriptor createDescriptor(DelegateToJavaRefactoringContext renameElementContext,
			String newName) throws JavaModelException {
		List<IJavaElement> javaElements = renameElementContext.getJavaElements();
		// TODO handle multiple java elements gracefully
		IJavaElement referencedJavaElement = javaElements.get(0);
		return jvmRenameRefactorigProvider.createRenameDescriptor(referencedJavaElement, newName);
	}

	protected static class JdtRenameSupportWrapper implements IRenameSupport {

		private RenameSupport renameSupport;

		public JdtRenameSupportWrapper(RenameJavaElementDescriptor renameDescriptor) throws CoreException {
			renameSupport = RenameSupport.create(renameDescriptor);
		}

		public void startRefactoringWithDialog(boolean previewOnly) throws InterruptedException {
			try {
				renameSupport.openDialog(getShell(), previewOnly);
			} catch (CoreException e) {
				throw new WrappedException(e);
			}
		}

		public void startDirectRefactoring() throws InterruptedException {
			try {
				renameSupport.perform(getShell(), PlatformUI.getWorkbench().getActiveWorkbenchWindow());
			} catch (InvocationTargetException e) {
				throw new WrappedException(e);
			}
		}

		protected Shell getShell() {
			Shell activeShell = Display.getDefault().getActiveShell();
			return activeShell != null ? activeShell : Display.getDefault().getShells()[0];
		}
	}
}
