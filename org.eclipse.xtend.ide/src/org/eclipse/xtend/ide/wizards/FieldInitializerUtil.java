/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;

/**
 * @author Robert von Massow - Initial contribution and API
 */
public class FieldInitializerUtil {

	public IJavaElement getSelectedResource(IStructuredSelection selection) {
		IJavaElement elem = null;
		if(selection != null && !selection.isEmpty()){
			Object o = selection.getFirstElement();
			if(o instanceof IAdaptable) {
				IAdaptable adaptable = (IAdaptable)o;
				elem = adaptable.getAdapter(IJavaElement.class);
				if(elem == null){
					elem = getPackage(adaptable);
				}
			}
		}
		if (elem == null) {
			IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			IWorkbenchPart part = activePage.getActivePart();
			if (part instanceof ContentOutline) {
				part= activePage.getActiveEditor();
			}
			if (part instanceof XtextEditor) {
				IXtextDocument doc = ((XtextEditor)part).getDocument();
				IFile file = doc.getAdapter(IFile.class);
				elem = getPackage(file);
			}
		}
		if (elem == null || elem.getElementType() == IJavaElement.JAVA_MODEL) {
			try {
				IJavaProject[] projects= JavaCore.create(ResourcesPlugin.getWorkspace().getRoot()).getJavaProjects();
				if (projects.length == 1) {
					elem= projects[0];
				}
			} catch (JavaModelException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return elem;
	}

	private IJavaElement getPackage(IAdaptable adaptable) {
		IJavaElement elem = null;
		IResource resource = adaptable.getAdapter(IResource.class);
		if (resource != null && resource.getType() != IResource.ROOT) {
			while(elem == null && resource.getType() != IResource.PROJECT){
				resource = resource.getParent();
				elem = resource.getAdapter(IJavaElement.class);
			}
		}
		if (elem == null) {
			elem = JavaCore.create(resource);
		}
		return elem;
	}
}
