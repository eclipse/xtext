/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.util;

import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.archive.ArchiveURLConnection;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;

import com.google.common.base.Preconditions;

/**
 * Copied from org.eclipse.emf.workspace.util.WorkspaceSynchronizer to avoid dependencies to EMFT.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ResourceUtil {
	
	/**
	 * @since 2.9
	 */
	public static void sync(IResource resource, int depth, IProgressMonitor progressMonitor) throws CoreException {
		if (canSync(resource)) {
			resource.refreshLocal(depth, progressMonitor);
		}
	}

	private static boolean canSync(IResource resource) {
		return resource.getType() != IResource.PROJECT && resource.getType() != IResource.ROOT;
	}

	/**
	 * @return the handle to the member container of the given project or the project itself
	 * @since 2.4
	 */
	public static IContainer getContainer(IProject project, String path) {
		Preconditions.checkNotNull(project, "parameter 'project' must not be null");
		Preconditions.checkNotNull(path, "parameter 'path' must not be null");
		if (".".equals(path) || "./".equals(path) || "".equals(path)) {
			return project;
		}
		return project.getFolder(path);
	}
	/**
	 * Obtains the workspace file corresponding to the specified resource, if it has a platform-resource URI. Note that
	 * the resulting file, if not <code>null</code>, may nonetheless not actually exist (as the file is just a handle).
	 * <p>
	 * Note that, if the <tt>resource</tt> is in an archive (such as a ZIP file) then it does not map to a workspace
	 * file. In this case, however, the workspace file (if any) corresponding to the containing archive can be obtained
	 * via the {@link #getUnderlyingFile(Resource)} method.
	 * </p>
	 * 
	 * @param resource
	 *            an EMF resource
	 * 
	 * @return the corresponding workspace file, or <code>null</code> if the resource's URI is not a platform-resource
	 *         URI
	 * 
	 * @see #getUnderlyingFile(Resource)
	 */
	public static IFile getFile(Resource resource) {
		ResourceSet rset = resource.getResourceSet();

		return getFile(resource.getURI(), (rset != null) ? rset.getURIConverter() : null, false);
	}

	/**
	 * Obtains the workspace file underlying the specified resource. If the resource has an {@link URI#isArchive()
	 * archive} scheme, the {@linkplain URI#authority() authority} is considered instead. If the URI has a file scheme,
	 * it's looked up in the workspace, just as in the {@link #getFile(Resource)} method. Otherwise, a platform scheme
	 * is assumed.
	 * <p>
	 * Note that the resulting file, if not <code>null</code>, may nonetheless not actually exist (as the file is just a
	 * handle).
	 * </p>
	 * 
	 * @param resource
	 *            an EMF resource
	 * 
	 * @return the underlying workspace file, or <code>null</code> if the resource's URI is not a platform-resource URI
	 * 
	 * @see #getFile(Resource)
	 * @since 1.2
	 */
	public static IFile getUnderlyingFile(Resource resource) {
		ResourceSet rset = resource.getResourceSet();

		return getFile(resource.getURI(), (rset != null) ? rset.getURIConverter() : null, true);
	}

	/**
	 * Finds the file corresponding to the specified URI, using a URI converter if necessary (and provided) to normalize
	 * it.
	 * 
	 * @param uri
	 *            a URI
	 * @param converter
	 *            an optional URI converter (may be <code>null</code>)
	 * 
	 * @return the file, if available in the workspace
	 */
	private static IFile getFile(URI uri, URIConverter converter, boolean considerArchives) {
		IFile result = null;

		if (considerArchives && uri.isArchive()) {
			class MyArchiveURLConnection extends ArchiveURLConnection {
				public MyArchiveURLConnection(String url) {
					super(url);
				}

				public String getNestedURI() {
					try {
						return getNestedURL();
					} catch (IOException exception) {
						return ""; //$NON-NLS-1$
					}
				}
			}
			MyArchiveURLConnection archiveURLConnection = new MyArchiveURLConnection(uri.toString());
			result = getFile(URI.createURI(archiveURLConnection.getNestedURI()), converter, considerArchives);
		} else if (uri.isPlatformResource()) {
			IPath path = new Path(uri.toPlatformString(true));
			result = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		} else if (uri.isFile() && !uri.isRelative()) {
			result = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(new Path(uri.toFileString()));
		} else {
			// normalize, to see whether we can resolve it this time
			if (converter != null) {
				URI normalized = converter.normalize(uri);

				if (!uri.equals(normalized)) {
					// recurse on the new URI
					result = getFile(normalized, converter, considerArchives);
				}
			}
		}

		if ((result == null) && !uri.isRelative()) {
			try {
				IFile[] files = ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(
						new java.net.URI(uri.toString()));
				if (files.length > 0) {
					// set the result to be the first file found
					result = files[0];
				}
			} catch (URISyntaxException e) {
				// won't get this because EMF provides a well-formed URI
			}
		}

		return result;
	}

}
