/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.edit;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtend.core.conversion.JavaConverter;

import com.google.inject.Inject;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class ConvertJavaCodeHandler extends AbstractHandler {
	@Inject
	private JavaConverter converter;

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		if (currentSelection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) currentSelection;
			Set<ICompilationUnit> compilationUnits = getCompilationUnits(structuredSelection);
			if (compilationUnits.size() > 0) {
				doConvert(compilationUnits);
			}
		}
		return null;
	}

	private void doConvert(Set<ICompilationUnit> compilationUnits) throws ExecutionException {
		for (ICompilationUnit iCompilationUnit : compilationUnits) {
			IContainer parent = iCompilationUnit.getResource().getParent();
			IFile file = parent.getFile(new Path(iCompilationUnit.getElementName() + ".xtend"));
			if (!file.exists()) {
				String content = converter.toXtend(iCompilationUnit).getXtendCode();
				try {
					InputStream source = new ByteArrayInputStream(content.getBytes(file.getCharset()));
					file.create(source, IResource.NONE, null);
				} catch (CoreException e) {
					throw new ExecutionException("Failed to create file. " + file.getFullPath(), e);
				} catch (UnsupportedEncodingException e) {
					throw new ExecutionException("Failed to write to file. " + file.getFullPath(), e);
				}
			}
		}
	}

	private Set<ICompilationUnit> getCompilationUnits(IStructuredSelection structuredSelection) {
		Set<ICompilationUnit> result = new HashSet<ICompilationUnit>();
		for (Object element : structuredSelection.toList()) {
			if (element instanceof IJavaElement) {
				IJavaElement elem = (IJavaElement) element;
				if (elem.exists()) {
					switch (elem.getElementType()) {
						case IJavaElement.TYPE:
							if (elem.getParent().getElementType() == IJavaElement.COMPILATION_UNIT) {
								result.add((ICompilationUnit) elem.getParent());
							}
							break;
						case IJavaElement.COMPILATION_UNIT:
							result.add((ICompilationUnit) elem);
							break;
					}
				}
			}
		}
		return result;
	}
}
