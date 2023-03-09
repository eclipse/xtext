/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.builder;

import java.io.InputStream;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.generator.AbstractFileSystemAccess;
import org.eclipse.xtext.generator.FileSystemAccessQueue;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.util.RuntimeIOException;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Anton Kosyakov
 * @since 2.7
 */
public class ParallelFileSystemAccess implements IFileSystemAccess2 {

	private final IFileSystemAccess2 delegate;

	private final IResourceDescription.Delta delta;

	private final FileSystemAccessQueue fileSystemAccessQueue;

	private final EclipseResourceFileSystemAccess2.IFileCallback fileCallback;

	private final String sourceFolder;

	/**
	 * @since 2.9
	 */
	public ParallelFileSystemAccess(IFileSystemAccess2 delegate, IResourceDescription.Delta delta,
			FileSystemAccessQueue fileSystemAccessQueue, String sourceFolder, EclipseResourceFileSystemAccess2.IFileCallback fileCallback) {
		this.delegate = delegate;
		this.delta = delta;
		this.fileSystemAccessQueue = fileSystemAccessQueue;
		this.sourceFolder = sourceFolder;
		this.fileCallback = fileCallback;
	}

	protected void sendAsync(Procedure1<? super IFileSystemAccess2> procedure) {
		Runnable runnable = () -> {
			if (delegate instanceof EclipseResourceFileSystemAccess2) {
				((EclipseResourceFileSystemAccess2) delegate).setPostProcessor(fileCallback);
			}
			if (sourceFolder != null) {
				if (delegate instanceof AbstractFileSystemAccess) {
					((AbstractFileSystemAccess) delegate).setCurrentSource(sourceFolder);
				}
			}
			procedure.apply(delegate);
		};
		fileSystemAccessQueue.sendAsync(delta.getUri(), runnable);
	}

	@Override
	public void deleteFile(String fileName) {
		sendAsync((fsa) -> fsa.deleteFile(fileName));
	}

	@Override
	public void generateFile(String fileName, CharSequence contents) {
		sendAsync((fsa) -> fsa.generateFile(fileName, contents));
	}

	@Override
	public void generateFile(String fileName, String outputConfigurationName, CharSequence contents) {
		sendAsync((fsa) -> fsa.generateFile(fileName, outputConfigurationName, contents));
	}

	@Override
	public void deleteFile(String fileName, String outputConfigurationName) {
		sendAsync((fsa) -> fsa.deleteFile(fileName, outputConfigurationName));
	}

	@Override
	public URI getURI(String path, String outputConfiguration) {
		if (delegate instanceof EclipseResourceFileSystemAccess2) {
			return ((EclipseResourceFileSystemAccess2) delegate).getURI(path, outputConfiguration, new NullProgressMonitor());
		}
		return delegate.getURI(path, outputConfiguration);
	}

	@Override
	public URI getURI(String path) {
		if (delegate instanceof EclipseResourceFileSystemAccess2) {
			return ((EclipseResourceFileSystemAccess2) delegate).getURI(path, new NullProgressMonitor());
		}
		return delegate.getURI(path);
	}

	@Override
	public void generateFile(String fileName, String outputCfgName, InputStream content) throws RuntimeIOException {
		sendAsync((fsa) -> fsa.generateFile(fileName, outputCfgName, content));
	}

	@Override
	public void generateFile(String fileName, InputStream content) throws RuntimeIOException {
		sendAsync((fsa) -> fsa.generateFile(fileName, content));
	}

	@Override
	public InputStream readBinaryFile(String fileName, String outputCfgName) throws RuntimeIOException {
		if (delegate instanceof EclipseResourceFileSystemAccess2) {
			return ((EclipseResourceFileSystemAccess2) delegate).readBinaryFile(fileName, outputCfgName, new NullProgressMonitor());
		}
		return delegate.readBinaryFile(fileName, outputCfgName);
	}

	@Override
	public InputStream readBinaryFile(String fileName) throws RuntimeIOException {
		if (delegate instanceof EclipseResourceFileSystemAccess2) {
			return ((EclipseResourceFileSystemAccess2) delegate).readBinaryFile(fileName, new NullProgressMonitor());
		}
		return delegate.readBinaryFile(fileName);
	}

	@Override
	public CharSequence readTextFile(String fileName, String outputCfgName) throws RuntimeIOException {
		if (delegate instanceof EclipseResourceFileSystemAccess2) {
			return ((EclipseResourceFileSystemAccess2) delegate).readTextFile(fileName, outputCfgName, new NullProgressMonitor());
		}
		return delegate.readTextFile(fileName, outputCfgName);
	}

	@Override
	public CharSequence readTextFile(String fileName) throws RuntimeIOException {
		if (delegate instanceof EclipseResourceFileSystemAccess2) {
			return ((EclipseResourceFileSystemAccess2) delegate).readTextFile(fileName, new NullProgressMonitor());
		}
		return delegate.readTextFile(fileName);
	}

	/**
	 * @since 2.9
	 */
	@Override
	public boolean isFile(String path, String outputConfigurationName) throws RuntimeIOException {
		if (delegate instanceof EclipseResourceFileSystemAccess2) {
			return ((EclipseResourceFileSystemAccess2) delegate).isFile(path, outputConfigurationName, new NullProgressMonitor());
		}
		return delegate.isFile(path, outputConfigurationName);
	}

	/**
	 * @since 2.9
	 */
	@Override
	public boolean isFile(String path) throws RuntimeIOException {
		if (delegate instanceof EclipseResourceFileSystemAccess2) {
			return ((EclipseResourceFileSystemAccess2) delegate).isFile(path, new NullProgressMonitor());
		}
		return delegate.isFile(path);
	}
}
