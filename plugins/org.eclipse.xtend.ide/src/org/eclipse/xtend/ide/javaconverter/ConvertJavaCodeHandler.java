/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.javaconverter;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class ConvertJavaCodeHandler extends AbstractHandler {
	/**
	 * Handler should be lightweight. Use a Provider.
	 */
	@Inject
	private Provider<ConvertJavaCode> javaConverterProvider;

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		if (currentSelection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) currentSelection;
			final Set<ICompilationUnit> compilationUnits = getCompilationUnits(structuredSelection);
			if (compilationUnits.size() > 0) {
				Shell activeShell = HandlerUtil.getActiveShell(event);
				javaConverterProvider.get().runJavaConverter(compilationUnits, activeShell);
			}
		}
		return null;
	}

	private Set<ICompilationUnit> getCompilationUnits(IStructuredSelection structuredSelection) {
		Set<ICompilationUnit> result = new HashSet<ICompilationUnit>();
		for (Object element : structuredSelection.toList()) {
			if (element instanceof IJavaElement) {
				IJavaElement elem = (IJavaElement) element;
				if (elem.exists()) {
					collectCompilationUnits(elem, result);

				}
			}
		}
		return result;
	}

	private void collectCompilationUnits(IJavaElement elem, Set<ICompilationUnit> result) {
		try {
			switch (elem.getElementType()) {
				case IJavaElement.TYPE:
					if (elem.getParent().getElementType() == IJavaElement.COMPILATION_UNIT) {
						result.add((ICompilationUnit) elem.getParent());
					}
					break;
				case IJavaElement.COMPILATION_UNIT:
					result.add((ICompilationUnit) elem);
					break;
				case IJavaElement.PACKAGE_FRAGMENT:
					Collections.addAll(result, ((IPackageFragment) elem).getCompilationUnits());
					break;
				case IJavaElement.PACKAGE_FRAGMENT_ROOT:
					for (IJavaElement child : ((IPackageFragmentRoot) elem).getChildren()) {
						collectCompilationUnits(child, result);
					}
					break;
			}
		} catch (JavaModelException e) {
		}
	}

}
