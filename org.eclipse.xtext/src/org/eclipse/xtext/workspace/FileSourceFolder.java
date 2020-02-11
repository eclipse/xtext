/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.workspace;

import org.eclipse.emf.common.util.URI;

import com.google.common.base.Objects;

public class FileSourceFolder implements ISourceFolder {
	private final FileProjectConfig parent;

	private final String name;

	public FileSourceFolder(FileProjectConfig parent, String name) {
		this.parent = parent;
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public URI getPath() {
		final URI result = URI.createFileURI(name).resolve(parent.getPath());
		if (result.hasTrailingPathSeparator()) {
			return result;
		} else {
			return result.appendSegment("");
		}
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj instanceof FileSourceFolder) {
			URI path1 = this.getPath();
			URI path2 = ((FileSourceFolder) obj).getPath();
			return Objects.equal(path1, path2);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.getPath().hashCode();
	}

	@Override
	public String toString() {
		return name + " (" + getPath() + ")";
	}

}
