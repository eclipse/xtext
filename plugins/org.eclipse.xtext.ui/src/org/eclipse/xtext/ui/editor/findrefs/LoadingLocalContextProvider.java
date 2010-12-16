/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.findrefs;

import static com.google.common.collect.Iterables.*;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class LoadingLocalContextProvider implements IReferenceFinder.ILocalContextProvider {

	@Inject
	private IResourceSetProvider resourceSetProvider;
	
	@Inject
	private IStorage2UriMapper storage2UriMapper;
	
	public <R> R readOnly(URI targetURI, IUnitOfWork<R, EObject> work) {
		Iterable<IStorage> storages = storage2UriMapper.getStorages(targetURI.trimFragment());
		if(!isEmpty(storages)) {
			IStorage storage = storages.iterator().next();
			if (storage instanceof IResource) {
				IProject project = ((IResource)storage).getProject();
				ResourceSet resourceSet = resourceSetProvider.get(project);
				EObject target = resourceSet.getEObject(targetURI, true);
				if(target != null)
					try {
						return work.exec(target);
					} catch (Exception e) {
						throw new WrappedException(e);
					}
			}
		}
		return null;
	}
}
