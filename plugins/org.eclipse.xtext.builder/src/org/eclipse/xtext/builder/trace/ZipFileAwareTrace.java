/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.trace;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.internal.compiler.util.Util;
import org.eclipse.jdt.internal.core.JavaModelManager;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ZipFileAwareTrace extends AbstractTrace {

	private IProject project;
	private URI uri;
	private IPath zipFilePath;

	@Override
	public IProject getLocalProject() {
		return project;
	}

	@Override
	public URI getLocalURI() {
		return uri;
	}

	protected void setProject(IProject project) {
		this.project = project;
	}

	protected void setUri(URI uri) {
		this.uri = uri;
	}

	@Override
	protected IStorage findStorage(URI uri, IProject project) {
		// there are no storages inside a zip file.
		return null;
	}

	protected void setZipFilePath(IPath zipFilePath) {
		this.zipFilePath = zipFilePath;
	}
	
	@Override
	protected URI resolvePath(URI path) {
		IResource member = getWorkspace().getRoot().findMember(zipFilePath);
		if (member != null)
			return URI.createURI("archive:platform:/resource" + member.getFullPath().toString() + "!/" + path);
		return URI.createURI("archive:file:" + zipFilePath.toString() + "!/" + path);
	}

	@Override
	protected InputStream getContents(URI uri, IProject project) throws CoreException {
		// inspired by org.eclipse.jdt.internal.core.JarEntryFile.getContents()
		JavaModelManager modelManager = JavaModelManager.getJavaModelManager();
		ZipFile zipFile = modelManager.getZipFile(zipFilePath);
		try {
			ZipEntry zipEntry = zipFile.getEntry(uri.toString());
			if (zipEntry != null) {
				byte[] contents = Util.getZipEntryByteContent(zipEntry, zipFile);
				return new ByteArrayInputStream(contents);
			}
		} catch (IOException e) {
			throw new CoreException(new Status(IStatus.ERROR, "", e.getMessage(), e));
		} finally {
			modelManager.closeZipFile(zipFile);
		}
		return null;
	}

}
