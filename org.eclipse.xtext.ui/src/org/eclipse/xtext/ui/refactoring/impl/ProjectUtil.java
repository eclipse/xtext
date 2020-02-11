/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import java.util.NoSuchElementException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.Pair;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * Converts {@link URI}s to {@link IFile}s and {@link IProject}s.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ProjectUtil {

	@Inject
	private IWorkspace workspace;

	@Inject
	private IStorage2UriMapper mapper;

	/**
	 * @return null if there is no such project or the file is not accessible
	 */
	public IProject getProject(URI uri) {
		IFile file = findFileStorage(uri, false);
		if(file == null)
			return null;
		return file.getProject();
	}

	/**
	 * @return null if there is no such file or the file is not editable
	 */
	public IFile findFileStorage(final URI uri, final boolean validateEdit) {
		Iterable<Pair<IStorage, IProject>> storages = mapper.getStorages(uri);
		try {
			Pair<IStorage, IProject> fileStorage = Iterables.find(storages, new Predicate<Pair<IStorage, IProject>>() {
				@Override
				public boolean apply(Pair<IStorage, IProject> input) {
					IStorage storage = input.getFirst();
					if (storage instanceof IFile) {
						IFile file = (IFile) storage;
						return file.isAccessible()
								&& (!validateEdit || !file.isReadOnly() || workspace.validateEdit(new IFile[] { file },
										null).isOK());
					}
					return false;
				}
			});
			return (IFile) fileStorage.getFirst();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

}
