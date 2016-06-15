/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder;

import static org.eclipse.xtext.ui.util.ResourceUtil.*;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.AbstractFileSystemAccess2;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.generator.trace.ITraceRegionProvider;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.generator.trace.TraceRegionSerializer;
import org.eclipse.xtext.ui.generator.trace.TraceForStorageProvider;
import org.eclipse.xtext.ui.generator.trace.TraceMarkers;
import org.eclipse.xtext.ui.resource.ProjectByResourceProvider;
import org.eclipse.xtext.util.RuntimeIOException;
import org.eclipse.xtext.util.StringInputStream;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.io.ByteStreams;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Michael Clay - https://bugs.eclipse.org/bugs/show_bug.cgi?id=386135
 * @since 2.1
 */
public class EclipseResourceFileSystemAccess2 extends AbstractFileSystemAccess2 {

	private final static Logger log = Logger.getLogger(EclipseResourceFileSystemAccess2.class);

	/**
	 * @noimplement This interface is not intended to be implemented by clients.
	 */
	public interface IFileCallback {
		public void afterFileUpdate(IFile file);

		public void afterFileCreation(IFile file);

		/**
		 * @return whether a deletion is vetoed.
		 */
		public boolean beforeFileDeletion(IFile file);
	}

	private IProject project;

	private IProgressMonitor monitor;

	private IFileCallback callBack;

	@Inject
	private TraceRegionSerializer traceSerializer;

	@Inject
	private TraceMarkers traceMarkers;

	@Inject
	private TraceForStorageProvider fileBasedTraceInformation;

	@Inject
	private IWorkspace workspace;
	
	@Inject
	private ProjectByResourceProvider projectProvider;
	
	private Multimap<SourceRelativeURI, IPath> sourceTraces;

	/**
	 * @since 2.4
	 */
	protected Multimap<SourceRelativeURI, IPath> getSourceTraces() {
		return sourceTraces;
	}

	/**
	 * @since 2.4
	 */
	protected void resetSourceTraces() {
		sourceTraces = null;
	}

	/**
	 * @since 2.4
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	protected TraceMarkers getTraceMarkers() {
		return traceMarkers;
	}

	/**
	 * @since 2.3
	 */
	protected IFileCallback getCallBack() {
		return callBack;
	}

	public void setProject(IProject project) {
		this.project = project;
	}
	
	@Override
	public void setContext(Object context) {
		if (context instanceof IProject) {
			setProject((IProject) context);
		} else if (context instanceof Resource) {
			Resource resource = (Resource) context;
			IProject project = getProjectContext(resource);
			if (project != null) {
				setProject(project);
			}
		} else {
			throw new IllegalArgumentException("Couldn't handle context "+context);
		}
	}

	/**
	 * @since 2.8
	 */
	protected IProject getProjectContext(Resource resource) {
		return projectProvider.getProjectContext(resource);
	}

	/**
	 * @since 2.6
	 */
	protected IProject getProject() {
		return project;
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

	/**
	 * @since 2.4
	 */
	protected boolean ensureOutputConfigurationDirectoryExists(OutputConfiguration outputConfig) {
		IContainer container = getContainer(outputConfig);
		if (container == null) {
			return false;
		}
		if (!container.exists()) {
			if (outputConfig.isCreateOutputDirectory()) {
				try {
					createContainer(container);
					return true;
				} catch (CoreException e) {
					throw new RuntimeIOException(e);
				}
			} else {
				return false;
			}
		}
		return true;
	}

	@Override
	public void generateFile(String fileName, String outputName, CharSequence contents) {
		if (monitor.isCanceled())
			throw new OperationCanceledException();
		OutputConfiguration outputConfig = getOutputConfig(outputName);

		if (!ensureOutputConfigurationDirectoryExists(outputConfig))
			return;

		IFile file = getFile(fileName, outputName);
		if (file == null)
			return;
		
		IFile traceFile = getTraceFile(file);
		try {
			String encoding = getEncoding(file);
			CharSequence postProcessedContent = postProcess(fileName, outputName, contents, encoding);
			String contentsAsString = postProcessedContent.toString();
			StringInputStream newContent = getInputStream(contentsAsString, encoding);
			generateFile(file, newContent, traceFile, postProcessedContent, outputConfig);
		} catch (CoreException e) {
			throw new RuntimeIOException(e);
		}
	}

	/**
	 * @since 2.4
	 */
	@Override
	public void generateFile(String fileName, String outputName, InputStream content) {
		if (monitor.isCanceled())
			throw new OperationCanceledException();
		OutputConfiguration outputConfig = getOutputConfig(outputName);

		if (!ensureOutputConfigurationDirectoryExists(outputConfig))
			return;

		IFile file = getFile(fileName, outputName);
		generateFile(file, content, null, null, outputConfig);
	}
	
	/**
	 * @since 2.9
	 */
	protected void generateFile(IFile file, InputStream content, IFile traceFile, CharSequence traceContent, OutputConfiguration outputConfig) {
		if (file == null) 
			return;
		
		try {
			if (file.exists()) {
				if (outputConfig.isOverrideExistingResources()) {
					if (hasContentsChanged(file, content)) {
						// reset to offset zero allows to reuse internal byte[]
						// no need to convert the string twice
						content.reset();
						file.setContents(content, true, outputConfig.isKeepLocalHistory(), monitor);
					} else {
						file.touch(getMonitor());
					}
					if (file.isDerived() != outputConfig.isSetDerivedProperty()) {
						setDerived(file, outputConfig.isSetDerivedProperty());
					}
					if (traceFile != null)
						updateTraceInformation(traceFile, traceContent, outputConfig.isSetDerivedProperty());
					if (callBack != null)
						callBack.afterFileUpdate(file);
				}
			} else {
				ensureParentExists(file);
				file.create(content, true, monitor);
				if (outputConfig.isSetDerivedProperty()) {
					setDerived(file, true);
				}
				if (traceFile != null)
					updateTraceInformation(traceFile, traceContent, outputConfig.isSetDerivedProperty());
				if (callBack != null)
					callBack.afterFileCreation(file);
			}
		} catch (CoreException e) {
			throw new RuntimeIOException(e);
		} catch (IOException e) {
			throw new RuntimeIOException(e);
		}
	}

	/**
	 * @since 2.3
	 */
	protected String getEncoding(IFile file) throws CoreException {
		return file.getCharset(true);
	}

	/**
	 * @since 2.3
	 */
	@SuppressWarnings("deprecation")
	protected void setDerived(IFile file, boolean derived) throws CoreException {
		file.setDerived(derived);
	}

	/**
	 * @deprecated use {@link #createContainer(IContainer)} instead
	 */
	@Deprecated
	protected void createFolder(IFolder folder) throws CoreException {
		ensureExists(folder);
	}

	/**
	 * @since 2.4
	 */
	protected void createContainer(IContainer container) throws CoreException {
		if (container instanceof IFolder) {
			createFolder((IFolder) container);
		} else {
			ensureExists(container);
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
			((IFolder) container).create(true, true, monitor);
		}
	}

	protected StringInputStream getInputStream(String contentsAsString, String encoding) {
		try {
			return new StringInputStream(contentsAsString, encoding);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeIOException(e);
		}
	}

	/**
	 * @deprecated use {@link #getContainer(OutputConfiguration)} instead
	 */
	@Deprecated
	protected IFolder getFolder(OutputConfiguration outputConfig) {
		return (IFolder) getContainer(outputConfig);
	}

	/**
	 * @since 2.4
	 */
	protected IContainer getContainer(OutputConfiguration outputConfig) {
		String path;
		if (getCurrentSource() == null) {
			path = outputConfig.getOutputDirectory();
		} else {
			path = outputConfig.getOutputDirectory(getCurrentSource());
		}
		if (".".equals(path) || "./".equals(path) || "".equals(path) || project == null) {
			return project;
		}
		return project.getFolder(new Path(path));
	}

	protected boolean hasContentsChanged(IFile file, StringInputStream newContent) {
		return hasContentsChanged(file, (InputStream) newContent);
	}

	/**
	 * @since 2.4
	 */
	protected boolean hasContentsChanged(IFile file, InputStream newContent) {
		boolean contentChanged = false;
		BufferedInputStream oldContent = null;
		try {
			oldContent = new BufferedInputStream(file.getContents());
			int newByte = newContent.read();
			int oldByte = oldContent.read();
			while (newByte != -1 && oldByte != -1 && newByte == oldByte) {
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
		}
		return contentChanged;
	}

	/**
	 * @throws CoreException
	 *             if something unexpected happens during resource access
	 * @throws IOException
	 *             if serialization of the trace data fails
	 * @since 2.3
	 */
	protected void updateTraceInformation(IFile traceFile, CharSequence contents, boolean derived)
			throws CoreException, IOException {
		if (contents instanceof ITraceRegionProvider) {
			AbstractTraceRegion traceRegion = ((ITraceRegionProvider) contents).getTraceRegion();
			if (sourceTraces == null) {
				sourceTraces = HashMultimap.create();
			}
			IPath tracePath = traceFile.getFullPath();
			Iterator<AbstractTraceRegion> iterator = traceRegion.treeIterator();
			while (iterator.hasNext()) {
				AbstractTraceRegion region = iterator.next();
				for (ILocationData location : region.getAssociatedLocations()) {
					SourceRelativeURI path = location.getSrcRelativePath();
					if (path != null) {
						sourceTraces.put(path, tracePath);
					}
				}
			}
			class AccessibleOutputStream extends ByteArrayOutputStream {
				byte[] internalBuffer() {
					return buf;
				}

				int internalLength() {
					return count;
				}
			}
			AccessibleOutputStream data = new AccessibleOutputStream();
			traceSerializer.writeTraceRegionTo(traceRegion, data);
			// avoid copying the byte array
			InputStream input = new ByteArrayInputStream(data.internalBuffer(), 0, data.internalLength());
			if (traceFile.exists()) {
				traceFile.setContents(input, true, false, monitor);
			} else {
				traceFile.create(input, true, monitor);
			}
			setDerived(traceFile, derived);
			return;
		}
		if (traceFile.exists()) {
			traceFile.delete(IResource.FORCE, monitor);
		}
	}

	/**
	 * @since 2.3
	 */
	@Deprecated
	protected IFile getSmapFile(IFile javaSourceFile) {
		log.warn("Smap files are no longer generated on disk.");
		return null;
	}

	/**
	 * Can be used to announce that a builder participant is done with this file system access and all potentially
	 * recorded trace information should be persisted. Uses the default generator name.
	 * 
	 * @since 2.3
	 * @see TraceMarkers#DEFAULT_GENERATOR_NAME
	 */
	public void flushSourceTraces() throws CoreException {
		flushSourceTraces(TraceMarkers.DEFAULT_GENERATOR_NAME);
	}

	/**
	 * Can be used to announce that a builder participant is done with this file system access and all potentially
	 * recorded trace information should be persisted.
	 * 
	 * @param generatorName
	 *            the name of the generator.
	 * @since 2.3
	 */
	public void flushSourceTraces(String generatorName) throws CoreException {
		if (sourceTraces != null) {
			Set<SourceRelativeURI> keys = sourceTraces.keySet();
			for(SourceRelativeURI uri: keys) {
				Collection<IPath> paths = sourceTraces.get(uri);
				IFile sourceFile = workspace.getRoot().getFile(new Path(uri.getURI().path()));
				if (sourceFile.exists()) {
					IPath[] tracePathArray = paths.toArray(new IPath[paths.size()]);
					traceMarkers.installMarker(sourceFile, generatorName, tracePathArray);
				}
			}
		}
		sourceTraces = null;
	}

	/**
	 * @since 2.5
	 */
	protected boolean isTraceFile(IFile file) {
		return fileBasedTraceInformation.isTraceFile(file);
	}

	/**
	 * @since 2.3
	 */
	/* @Nullable */
	protected IFile getTraceFile(IFile file) {
		IStorage traceFile = fileBasedTraceInformation.getTraceFile(file);
		if (traceFile instanceof IFile) {
			IFile result = (IFile) traceFile;
			syncIfNecessary(result);
			return result;
		}
		return null;
	}

	private void syncIfNecessary(IResource result) {
		syncIfNecessary(result, monitor);
	}

	private void syncIfNecessary(IResource result, IProgressMonitor progressMonitor) {
		try {
			sync(result, IResource.DEPTH_ZERO, progressMonitor);
		} catch (CoreException c) {
			// ignore
		}
	}

	@Override
	public void deleteFile(String fileName, String outputName) {
		try {
			IFile file = getFile(fileName, outputName);
			deleteFile(file, outputName, monitor);
		} catch (CoreException e) {
			throw new RuntimeIOException(e);
		}
	}

	/**
	 * @since 2.3
	 */
	public void deleteFile(IFile file, IProgressMonitor monitor) throws CoreException {
		deleteFile(file, DEFAULT_OUTPUT, monitor);
	}

	/**
	 * @since 2.5
	 */
	public void deleteFile(IFile file, String outputName, IProgressMonitor monitor) throws CoreException {
		if (file == null) {
			return;
		}
		OutputConfiguration outputConfig = getOutputConfig(outputName);
		IFileCallback callBack = getCallBack();
		if ((callBack == null || callBack.beforeFileDeletion(file)) && file.exists() && !isTraceFile(file)) {
			IFile traceFile = getTraceFile(file);
			file.delete(true, outputConfig.isKeepLocalHistory(), monitor);
			if (traceFile != null && traceFile.exists()) {
				traceFile.delete(IResource.FORCE, monitor);
			}
		}
	}

	protected IFile getFile(String fileName, String outputName) {
		return getFile(fileName, outputName, monitor);
	}

	/**
	 * @since 2.7
	 */
	protected IFile getFile(String fileName, String outputName, IProgressMonitor progressMonitor) {
		OutputConfiguration configuration = getOutputConfig(outputName);
		IContainer container = getContainer(configuration);
		if (container != null) {
			IFile result = container.getFile(new Path(fileName));
			syncIfNecessary(result, progressMonitor);
			return result;
		}
		return null;
	}
	
	/**
	 * @since 2.7
	 */
	public URI getURI(String path, IProgressMonitor progressMonitor) {
		return getURI(path, DEFAULT_OUTPUT, progressMonitor);
	}

	/**
	 * We cannot use the storage to URI mapper here, as it only works for Xtext based languages
	 * 
	 * @since 2.3
	 */
	@Override
	public URI getURI(String path, String outputConfiguration) {
		return getURI(path, outputConfiguration, monitor);
	}
	
	/**
	 * @since 2.7
	 */
	public URI getURI(String path, String outputName, IProgressMonitor progressMonitor) {
		OutputConfiguration configuration = getOutputConfig(outputName);
		IContainer container = getContainer(configuration);
		if (container != null) {
			IPath childPath = container.getFullPath().append(path).makeAbsolute();
			return URI.createPlatformResourceURI(childPath.toString(), true);
		}
		return null;
	}
	
	/**
	 * @since 2.7
	 */
	public InputStream readBinaryFile(String fileName, IProgressMonitor progressMonitor) {
		return readBinaryFile(fileName, DEFAULT_OUTPUT, progressMonitor);
	}

	/**
	 * @since 2.4
	 */
	@Override
	public InputStream readBinaryFile(String fileName, String outputCfgName) throws RuntimeIOException {
		return readBinaryFile(fileName, outputCfgName, monitor);
	}
	
	/**
	 * @since 2.7
	 */
	public InputStream readBinaryFile(String fileName, String outputCfgName, IProgressMonitor progressMonitor) throws RuntimeIOException {
		try {
			IFile file = getFile(fileName, outputCfgName, progressMonitor);
			return new BufferedInputStream(file.getContents());
		} catch (CoreException e) {
			throw new RuntimeIOException(e);
		}
	}
	
	/**
	 * @since 2.7
	 */
	public CharSequence readTextFile(String fileName, IProgressMonitor progressMonitor) {
		return readTextFile(fileName, DEFAULT_OUTPUT, progressMonitor);
	}
	
	/**
	 * @since 2.4
	 */
	@Override
	public CharSequence readTextFile(String fileName, String outputCfgName) throws RuntimeIOException {
		return readTextFile(fileName, outputCfgName, monitor);
	}

	/**
	 * @since 2.7
	 */
	public CharSequence readTextFile(String fileName, String outputCfgName, IProgressMonitor progressMonitor) throws RuntimeIOException {
		try {
			IFile file = getFile(fileName, outputCfgName, progressMonitor);
			String encoding = getEncoding(file);
			InputStream inputStream = new BufferedInputStream(file.getContents());
			try {
				byte[] bytes = ByteStreams.toByteArray(inputStream);
				return new String(bytes, encoding);
			} finally {
				inputStream.close();
			}
		} catch (IOException e) {
			throw new RuntimeIOException(e);
		} catch (CoreException e) {
			throw new RuntimeIOException(e);
		}
	}

	@Override
	public boolean isFile(String path, String outputConfigurationName) throws RuntimeIOException {
		return isFile(path, outputConfigurationName, monitor);
	}

	@Override
	public boolean isFile(String path) throws RuntimeIOException {
		return isFile(path, DEFAULT_OUTPUT);
	}
	
	/**
	 * @since 2.9
	 */
	public boolean isFile(String path, String outputConfigurationName, IProgressMonitor progressMonitor) {
		return getFile(path, outputConfigurationName, progressMonitor).exists();
	}
	
	/**
	 * @since 2.9
	 */
	public boolean isFile(String path, IProgressMonitor progressMonitor) throws RuntimeIOException {
		return isFile(path, DEFAULT_OUTPUT, progressMonitor);
	}
	
}
