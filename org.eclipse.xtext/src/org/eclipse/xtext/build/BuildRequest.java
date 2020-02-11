/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.build;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.UriUtil;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9
 */
public class BuildRequest {
	/**
	 * Callback after a resource was validated.
	 */
	public interface IPostValidationCallback {
		/**
		 * @return whether the build can proceed, <code>false</code> if the build should be interrupted
		 */
		boolean afterValidate(URI validated, Iterable<Issue> issues);
	}

	private static class DefaultValidationCallback implements IPostValidationCallback {
		private static final Logger LOG = Logger.getLogger(DefaultValidationCallback.class);

		@Override
		public boolean afterValidate(URI validated, Iterable<Issue> issues) {
			for (Issue issue : issues) {
				Severity severity = issue.getSeverity();
				if (severity != null) {
					switch (severity) {
					case ERROR:
						LOG.error(issue.toString());
						return false;
					case WARNING:
						LOG.warn(issue.toString());
						break;
					case INFO:
						LOG.info(issue.toString());
						break;
					case IGNORE:
						LOG.debug(issue.toString());
						break;
					}
				}
			}
			return true;
		}
	}

	private URI baseDir;

	private List<URI> dirtyFiles = new ArrayList<>();

	private List<URI> deletedFiles = new ArrayList<>();

	private List<IResourceDescription.Delta> externalDeltas = new ArrayList<>();

	/**
	 * Callback after validation, return <code>false</code> will stop the build.
	 */
	private BuildRequest.IPostValidationCallback afterValidate = new BuildRequest.DefaultValidationCallback();

	private Procedure2<? super URI, ? super URI> afterGenerateFile = (source, generated) -> {
		/* nothing to do */
	};

	private Procedure1<? super URI> afterDeleteFile = (file) -> {
		/* nothing to do */
	};

	private IndexState state = new IndexState();

	private boolean writeStorageResources = false;

	private boolean indexOnly = false;

	private XtextResourceSet resourceSet;

	private CancelIndicator cancelIndicator = CancelIndicator.NullImpl;

	public void setBaseDir(URI baseDir) {
		this.baseDir = baseDir;
	}

	public URI getBaseDir() {
		if (baseDir == null) {
			String userDir = System.getProperty("user.dir");
			baseDir = UriUtil.createFolderURI(new File(userDir));
		}
		return baseDir;
	}

	public List<URI> getDirtyFiles() {
		return dirtyFiles;
	}

	public void setDirtyFiles(List<URI> dirtyFiles) {
		this.dirtyFiles = dirtyFiles;
	}

	public List<URI> getDeletedFiles() {
		return deletedFiles;
	}

	public void setDeletedFiles(List<URI> deletedFiles) {
		this.deletedFiles = deletedFiles;
	}

	public List<IResourceDescription.Delta> getExternalDeltas() {
		return externalDeltas;
	}

	public void setExternalDeltas(List<IResourceDescription.Delta> externalDeltas) {
		this.externalDeltas = externalDeltas;
	}

	public BuildRequest.IPostValidationCallback getAfterValidate() {
		return afterValidate;
	}

	public void setAfterValidate(BuildRequest.IPostValidationCallback afterValidate) {
		this.afterValidate = afterValidate;
	}

	public Procedure2<? super URI, ? super URI> getAfterGenerateFile() {
		return afterGenerateFile;
	}

	public void setAfterGenerateFile(Procedure2<? super URI, ? super URI> afterGenerateFile) {
		this.afterGenerateFile = afterGenerateFile;
	}

	public Procedure1<? super URI> getAfterDeleteFile() {
		return afterDeleteFile;
	}

	public void setAfterDeleteFile(Procedure1<? super URI> afterDeleteFile) {
		this.afterDeleteFile = afterDeleteFile;
	}

	public IndexState getState() {
		return state;
	}

	public void setState(IndexState state) {
		this.state = state;
	}

	public boolean isWriteStorageResources() {
		return writeStorageResources;
	}

	public void setWriteStorageResources(boolean writeStorageResources) {
		this.writeStorageResources = writeStorageResources;
	}

	public boolean isIndexOnly() {
		return indexOnly;
	}

	public void setIndexOnly(boolean indexOnly) {
		this.indexOnly = indexOnly;
	}

	public XtextResourceSet getResourceSet() {
		return resourceSet;
	}

	public void setResourceSet(XtextResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}

	public CancelIndicator getCancelIndicator() {
		return cancelIndicator;
	}

	public void setCancelIndicator(CancelIndicator cancelIndicator) {
		this.cancelIndicator = cancelIndicator;
	}
}
