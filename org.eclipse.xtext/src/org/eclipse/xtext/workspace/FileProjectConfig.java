/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.workspace;

import static org.eclipse.xtext.xbase.lib.IterableExtensions.*;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.util.UriUtil;

import com.google.common.base.Objects;

public class FileProjectConfig implements IProjectConfig {
	private final URI path;

	private final String name;

	private final Set<FileSourceFolder> sourceFolders = new HashSet<>();

	private final IWorkspaceConfig workspaceConfig;

	public FileProjectConfig(URI path) {
		this(path, (IWorkspaceConfig) null);
	}

	public FileProjectConfig(URI path, String name) {
		this(path, name, (IWorkspaceConfig) null);
	}

	public FileProjectConfig(File root, String name) {
		this(root, name, (IWorkspaceConfig) null);
	}

	public FileProjectConfig(File root) {
		this(root, (IWorkspaceConfig) null);
	}

	public FileProjectConfig(URI path, IWorkspaceConfig workspaceConfig) {
		this(path, path.lastSegment(), workspaceConfig);
	}

	public FileProjectConfig(URI path, String name, IWorkspaceConfig workspaceConfig) {
		this.path = UriUtil.toFolderURI(path);
		this.name = name;
		this.workspaceConfig = (workspaceConfig != null) ? workspaceConfig : new WorkspaceConfig(this);
	}

	public FileProjectConfig(File root, String name, IWorkspaceConfig workspaceConfig) {
		this(UriUtil.createFolderURI(root), name, workspaceConfig);
	}

	public FileProjectConfig(File root, IWorkspaceConfig workspaceConfig) {
		this(UriUtil.createFolderURI(root), root.getName(), workspaceConfig);
	}

	public FileSourceFolder addSourceFolder(String relativePath) {
		FileSourceFolder sourceFolder = new FileSourceFolder(this, relativePath);
		sourceFolders.add(sourceFolder);
		return sourceFolder;
	}

	@Override
	public FileSourceFolder findSourceFolderContaining(URI member) {
		return findFirst(sourceFolders, f -> f.contains(member));
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof FileProjectConfig) {
			return Objects.equal(path, ((FileProjectConfig) obj).path);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return path.hashCode();
	}

	@Override
	public String toString() {
		return "Project " + name + " (" + path + ")";
	}

	@Override
	public URI getPath() {
		return path;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Set<FileSourceFolder> getSourceFolders() {
		return sourceFolders;
	}

	@Override
	public IWorkspaceConfig getWorkspaceConfig() {
		return workspaceConfig;
	}
}
