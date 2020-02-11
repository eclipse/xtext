/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder;

import static org.eclipse.xtext.util.Strings.*;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.generator.AbstractFileSystemAccess2;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.RuntimeIOException;
import org.eclipse.xtext.util.StringInputStream;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein
 * @deprecated use {@link EclipseResourceFileSystemAccess2} instead
 */
@Deprecated
public class EclipseResourceFileSystemAccess extends AbstractFileSystemAccess2 {

	@Inject
	private IWorkspaceRoot root;
	
	private IAcceptor<String> newFileAcceptor;

	public void setRoot(IWorkspaceRoot root) {
		this.root = root;
	}

	@Override
	public void deleteFile(String fileName) {
		try {
			IFile file = root.getFile(new Path(fileName));
			file.delete(true, new NullProgressMonitor());
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void generateFile(String fileName, String slot, CharSequence contents) {
		IFile file = getFile(fileName, slot);
		try {
			createFolder(file.getParent());
			final String defaultCharset = file.getCharset();
			String newContentAsString = postProcess(fileName, slot, contents, defaultCharset).toString();
			if (file.exists()) {
				boolean contentChanged = false;
				BufferedInputStream oldContent = null;
				StringInputStream newContent = new StringInputStream(newContentAsString, defaultCharset);
				try {
					oldContent = new BufferedInputStream(file.getContents());
					int newByte = newContent.read();
					int oldByte = oldContent.read();
					while(newByte != -1 && oldByte != -1 && newByte == oldByte) {
						newByte = newContent.read();
						oldByte = oldContent.read();
					}
					contentChanged = newByte != oldByte;
				} catch (CoreException e) {
					contentChanged = true;
				} catch (IOException e) {
					contentChanged = true;
				} finally {
					if (oldContent != null) {
						try {
							oldContent.close();
						} catch (IOException e) {
							// ignore
						}
					}
					// reset to offset zero allows to reuse internal byte[]
					newContent.reset();
				}
				if (contentChanged)
					file.setContents(newContent, true, true, null);
			} else
				file.create(new StringInputStream(newContentAsString, defaultCharset), true, null);
			file.setDerived(true);
			if(newFileAcceptor != null)
				newFileAcceptor.accept(file.getFullPath().toString());
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @since 2.3
	 */
	protected IFile getFile(String fileName, String slot) {
		String outletPath = getPathes().get(slot);
		return root.getFile(new Path(outletPath + "/" + fileName));
	}

	protected void createFolder(IContainer parent) throws CoreException {
		if(!parent.exists()) {
			if(!(parent instanceof IFolder)) 
				throw new RuntimeException("IContainer " + notNull(parent) + " does not exist");
			createFolder(parent.getParent());
			((IFolder)parent).create(true, false, new NullProgressMonitor());
		}
	}

	public void setNewFileAcceptor(IAcceptor<String> newFileAcceptor) {
		this.newFileAcceptor = newFileAcceptor;
	}
	
	/**
	 * We cannot use the storage to URI mapper here, as it only works for Xtext based languages 
	 * @since 2.3
	 */
	@Override
	public URI getURI(String fileName, String outputConfiguration) {
		IFile file = getFile(fileName, outputConfiguration);
		return URI.createPlatformResourceURI(file.getFullPath().toString(), true);
	}

	/**
	 * @since 2.4
	 */
	@Override
	public void generateFile(String fileName, String outputCfgName, InputStream content) throws RuntimeIOException {
		throw new UnsupportedOperationException();
	}

	/**
	 * @since 2.4
	 */
	@Override
	public InputStream readBinaryFile(String fileName, String outputCfgName) throws RuntimeIOException {
		throw new UnsupportedOperationException();
	}

	/**
	 * @since 2.4
	 */
	@Override
	public CharSequence readTextFile(String fileName, String outputCfgName) throws RuntimeIOException {
		throw new UnsupportedOperationException();
	}
}
