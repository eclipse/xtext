/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.findrefs;

import java.util.Iterator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.3
 */
public class LoadingResourceAccess implements IReferenceFinder.ILocalResourceAccess {

	@Inject
	private IResourceSetProvider resourceSetProvider;
	
	@Inject
	private IStorage2UriMapper storage2UriMapper;
	
	@Override
	public <R> R readOnly(URI targetURI, IUnitOfWork<R, ResourceSet> work) {
		URI resourceURI = targetURI.trimFragment();
		Iterable<Pair<IStorage, IProject>> storages = storage2UriMapper.getStorages(resourceURI);
		Iterator<Pair<IStorage, IProject>> iterator = storages.iterator();
		while(iterator.hasNext()) {
			Pair<IStorage, IProject> pair = iterator.next();
			IProject project = pair.getSecond();
			if (project != null) {
				ResourceSet resourceSet = resourceSetProvider.get(project);
				if(resourceSet != null)
					resourceSet.getResource(resourceURI, true);
					try {
						return work.exec(resourceSet);
					} catch (Exception e) {
						throw new WrappedException(e);
					}
			}
		}
		return null;
	}
}
