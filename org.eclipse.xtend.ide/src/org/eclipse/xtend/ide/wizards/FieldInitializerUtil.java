/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Adapters;
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
			elem = Adapters.adapt(o, IJavaElement.class);
			if(elem == null){
				elem = getPackage(o);
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
				IFile file = Adapters.adapt(doc, IFile.class);
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

	private IJavaElement getPackage(Object o) {
		IJavaElement elem = null;
		IResource resource = Adapters.adapt(o, IResource.class);
		if (resource != null && resource.getType() != IResource.ROOT) {
			while(elem == null && resource.getType() != IResource.PROJECT){
				resource = resource.getParent();
				elem = Adapters.adapt(resource, IJavaElement.class);
			}
		}
		if (elem == null) {
			elem = JavaCore.create(resource);
		}
		return elem;
	}
}
