/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.xtext.ui.core.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.core.editor.contentassist.ICompletionProposalAcceptor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextProposalProvider extends org.eclipse.xtext.AbstractXtextProposalProvider {

	@Override
	public void completeGrammar_Name(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		Resource resource = model.eResource();
		URI uri = resource.getURI();
		IPath path = new Path(uri.toPlatformString(true));
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		IProject project = file.getProject();
		IJavaProject javaProject = JavaCore.create(project);
		if (javaProject != null) {
			try {
				for (IPackageFragmentRoot packageFragmentRoot: javaProject.getPackageFragmentRoots()) {
					IPath packageFragmentRootPath = packageFragmentRoot.getPath();
					if (packageFragmentRootPath.isPrefixOf(path)) {
						IPath relativePath = path.makeRelativeTo(packageFragmentRootPath);
						relativePath = relativePath.removeFileExtension();
						String result = relativePath.toString();
						result = result.replace('/', '.');
						acceptor.accept(createCompletionProposal(result, context));
						return;
					}
				}
			} catch (JavaModelException ex) {
				// nothing to do
			}
		}
	}
	
}
