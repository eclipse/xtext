/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IEncodedStorage;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.service.DispatchingProvider;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.Pair;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Resolves the encoding for {@link IEncodedStorage} behind the given {@link URI}s and falls back to the
 * {@link IEncodingProvider} configured for in the runtime module otherwise.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
@Singleton
public class WorkspaceEncodingProvider implements IEncodingProvider {

	private static final Logger LOG = Logger.getLogger(WorkspaceEncodingProvider.class);

	@Inject
	private IWorkspace workspace;

	@Inject
	private IStorage2UriMapper storage2UriMapper;

	@Inject
	@DispatchingProvider.Runtime
	private IEncodingProvider runtimeEncodingProvider;

	public String getEncoding(URI uri) {
		if (workspace != null) {
			if (uri != null) {
				Iterator<Pair<IStorage, IProject>> storages = storage2UriMapper.getStorages(uri).iterator();
				while (storages.hasNext()) {
					Pair<IStorage, IProject> storage = storages.next();
					if (storage.getFirst() instanceof IEncodedStorage) {
						try {
							return ((IEncodedStorage) storage.getFirst()).getCharset();
						} catch (CoreException e) {
							LOG.error("Error getting file encoding", e);
						}
					}
					try {
						String result = storage.getSecond().getDefaultCharset(true);
						return result;
					} catch (CoreException e) {
						LOG.error("Error getting project's default encoding", e);
					}
				}
			}
			try {
				return workspace.getRoot().getDefaultCharset();
			} catch (CoreException e) {
				LOG.error("Error getting project's default encoding", e);
			}
		}
		// fallback to runtime encoding provider
		return runtimeEncodingProvider.getEncoding(uri);
	}

}
