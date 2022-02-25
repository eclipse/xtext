/*******************************************************************************
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.refactoring;

import static java.util.Collections.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.refactoring.IChangeRedirector;
import org.eclipse.xtext.ui.refactoring.impl.AbstractProcessorBasedRenameParticipant;
import org.eclipse.xtext.ui.refactoring.ui.IRenameContextFactory;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.inject.Inject;

public class XtendFileRenameParticipant extends AbstractProcessorBasedRenameParticipant {

	@Inject
	private IResourceSetProvider resourceSetProvider;

	@Inject
	private IRenameContextFactory renameContextFactory;

	@Override
	protected List<? extends IRenameElementContext> createRenameElementContexts(Object element) {
		if(super.getNewName().endsWith(".xtend")) {
			IFile file = (IFile) element;
			final IPath filePath = file.getFullPath();
			final IPath newPath = file.getFullPath().removeLastSegments(1).append(getNewName() + ".xtend");
			String className = trimFileExtension(file.getName());
			if(className != null) {
				ResourceSet resourceSet = resourceSetProvider.get(file.getProject());
				URI resourceURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
				Resource resource = resourceSet.getResource(resourceURI, true);
				if (resource != null && !resource.getContents().isEmpty()) {
					for (XtendTypeDeclaration type : EcoreUtil2.eAllOfType(resource.getContents().get(0), XtendTypeDeclaration.class)) {
						if (equal(className, type.getName())) {
							IRenameElementContext renameElementContext = renameContextFactory.createRenameElementContext(type, null, null,
									(XtextResource) resource);
							if(renameElementContext instanceof IChangeRedirector.Aware) 
								((IChangeRedirector.Aware) renameElementContext).setChangeRedirector(new IChangeRedirector() {
									@Override
									public IPath getRedirectedPath(IPath source) {
										return source.equals(filePath) ? newPath : source;
									}
									
								});
							return singletonList(renameElementContext);
						}
					}
				}
			}
		}
		return super.createRenameElementContexts(element);
	}

	@Override
	protected String getNewName() {
		return trimFileExtension(super.getNewName());
	}
	
	protected String trimFileExtension(String fileName) {
		if (fileName.lastIndexOf('.') == -1)
			return fileName;
		return fileName.substring(0, fileName.lastIndexOf('.'));
	}
	
	@Override
	protected List<EObject> getRenamedElementsOrProxies(EObject originalTarget) {
		return singletonList(originalTarget);
	}
}
