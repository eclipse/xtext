/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.xtext.generator.AbstractFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.util.StringInputStream;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.1
 */
public class EclipseResourceFileSystemAccess2 extends AbstractFileSystemAccess {
	
	public interface IFileCallback {
		public void afterFileUpdate(IFile file);
		public void afterFileCreation(IFile file);
		public boolean beforeFileDeletion(IFile file);
	}
	
	private IProject project;
	
	private IProgressMonitor monitor;
	
	private IFileCallback callBack;
	
	public void setProject(IProject project) {
		this.project = project;
	}
	
	public void setMonitor(IProgressMonitor monitor) {
		this.monitor = monitor;
	}
	
	public void setPostProcessor(IFileCallback callBack) {
		this.callBack = callBack;
	}
	
	protected IProgressMonitor getMonitor() {
		return monitor;
	}

	public void generateFile(String fileName, String outputName, CharSequence contents) {
		OutputConfiguration outputConfig = getOutputConfig(outputName);
		
		// check output folder exists
		IFolder folder = getFolder(outputConfig);
		if (!folder.exists()) {
			if (outputConfig.isCreateOutputDirectory()) {
				try {
					createFolder(folder);
				} catch (CoreException e) {
					throw new RuntimeException(e);
				}
			} else {
				return;
			}
		}
		
		IFile file = getFile(fileName, outputName);
		String contentsAsString = contents.toString(); 
		if (file.exists()) {
			if (outputConfig.isOverrideExistingResources()
				&& hasContentsChanged(file, contentsAsString)){
				try {
					file.setContents(getInputStream(contentsAsString), true, true, monitor);
					if (!file.isDerived() && outputConfig.isSetDerivedProperty()) {
						file.setDerived(true);
					}
				} catch (CoreException e) {
					throw new RuntimeException(e);
				} 
			}
			callBack.afterFileUpdate(file);
		} else {
			try {
				ensureParentExists(file);
				file.create(getInputStream(contentsAsString), true, monitor);
				if (outputConfig.isSetDerivedProperty()) {
					file.setDerived(true);
				}
			} catch (CoreException e) {
				throw new RuntimeException(e);
			}
			callBack.afterFileCreation(file);
		}
	}

	protected void createFolder(IFolder folder) throws CoreException {
		try {
			folder.create(true, true, monitor);
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
	}

	protected void ensureParentExists(IFile file) throws CoreException {
		if (!file.exists()) {
			ensureExists(file.getParent());
		}
	}
	
	protected void ensureExists(IContainer container) throws CoreException {
		if (container.exists())
			return;
		if (container instanceof IFolder) {
			ensureExists(container.getParent());
			((IFolder)container).create(true,  true, monitor);
		}
	}

	protected ByteArrayInputStream getInputStream(String contentsAsString) {
		try {
			return new ByteArrayInputStream(contentsAsString.getBytes(project.getDefaultCharset()));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
	}

	protected IFolder getFolder(OutputConfiguration outputConfig) {
		return project.getFolder(new Path(outputConfig.getOutputDirectory()));
	}

	protected boolean hasContentsChanged(IFile file, String newContents) {
		boolean contentChanged = false;
		BufferedInputStream oldContent = null;
		StringInputStream newContent;
		try {
			newContent = new StringInputStream(newContents, file.getCharset());
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
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
		return contentChanged;
	}

	@Override
	public void deleteFile(String fileName, String outputName) {
		try {
			IFile file = getFile(fileName, outputName);
			if (callBack.beforeFileDeletion(file) && file.exists())
				file.delete(true, new NullProgressMonitor());
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
	}
	
	protected IFile getFile(String fileName, String outputName) {
		OutputConfiguration configuration = getOutputConfig(outputName);
		final Path path = new Path(configuration.getOutputDirectory()+"/"+fileName);
		return project.getFile(path);
	}
	
}
