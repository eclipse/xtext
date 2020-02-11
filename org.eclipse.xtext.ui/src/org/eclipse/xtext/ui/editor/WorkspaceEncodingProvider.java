/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IEncodedStorage;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
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

	@Override
	public String getEncoding(URI uri) {
		if (workspace != null) {
			if (uri != null) {
				if (uri.isPlatformResource()) {
					IFile file = workspace.getRoot().getFile(new Path(uri.toPlatformString(true)));
					try {
						return file.getCharset(true);
					} catch (CoreException e) {
						LOG.error("Error getting file encoding for "+uri, e);
					}
				} else {
					Iterator<Pair<IStorage, IProject>> storages = storage2UriMapper.getStorages(uri).iterator();
					if (storages.hasNext()) {
						Pair<IStorage,IProject> next = storages.next();
						IStorage storage = next.getFirst();
						if (storage instanceof IEncodedStorage) {
							try {
								return ((IEncodedStorage) storage).getCharset();
							} catch (CoreException e) {
								LOG.error("Error getting file encoding for "+uri, e);
							}
						} else {
							try {
								String result = next.getSecond().getDefaultCharset(true);
								return result;
							} catch (CoreException e) {
								LOG.error("Error getting file encoding for "+uri, e);
							}
						}
					}
				}
			}
			try {
				return workspace.getRoot().getDefaultCharset();
			} catch (CoreException e) {
				LOG.error("Error getting file encoding for "+uri, e);
			}
		}
		// fallback to runtime encoding provider
		return runtimeEncodingProvider.getEncoding(uri);
	}

}
