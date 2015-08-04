/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.trace;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.internal.compiler.util.Util;
import org.eclipse.jdt.internal.core.JavaModelManager;
import org.eclipse.xtext.generator.trace.AbsoluteURI;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ZipFileAwareTrace extends AbstractTraceWithoutStorage {
	private static final Logger log = Logger.getLogger(ZipFileAwareTrace.class);

	private IPath zipFilePath;

	protected void setZipFilePath(IPath zipFilePath) {
		this.zipFilePath = zipFilePath;
	}

	@Override
	protected AbsoluteURI resolvePath(SourceRelativeURI path) {
		IResource member = getWorkspace().getRoot().findMember(zipFilePath);
		if (member != null) {
			String uri = "archive:platform:/resource" + member.getFullPath().toString() + "!/" + path;
			return new AbsoluteURI(URI.createURI(uri));
		}
		return new AbsoluteURI(URI.createURI("archive:file:" + zipFilePath.toString() + "!/" + path));
	}

	@Override
	public InputStream getContents(SourceRelativeURI uri, IProject project) {
		// inspired by org.eclipse.jdt.internal.core.JarEntryFile.getContents()
		JavaModelManager modelManager = JavaModelManager.getJavaModelManager();
		ZipFile zipFile = null;
		try {
			zipFile = modelManager.getZipFile(zipFilePath);
			ZipEntry zipEntry = zipFile.getEntry(uri.getURI().toString());
			if (zipEntry != null) {
				byte[] contents = Util.getZipEntryByteContent(zipEntry, zipFile);
				return new ByteArrayInputStream(contents);
			}
		} catch (IOException e) {
			log.debug("Could not read zip file " + uri, e);
		} catch (CoreException e) {
			log.debug("Could not read zip file " + uri, e);
		} finally {
			if (zipFile != null) {
				modelManager.closeZipFile(zipFile);
			}
		}
		return null;
	}

	@Override
	protected Reader getContentsAsText(SourceRelativeURI uri, IProject project) {
		InputStream contents = getContents(uri, project);
		if (contents != null)
			return new InputStreamReader(contents, getEncoding());
		return null;
	}

}
