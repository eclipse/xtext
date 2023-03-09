/**
 * Copyright (c) 2015-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.trace;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.ISourceFolder;

import com.google.common.base.Objects;

/**
 * An absolute URI that allows to obtain a resource in a {@link IProjectConfig project}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AbsoluteURI extends AbstractURIWrapper {
	public AbsoluteURI(URI absoluteURI) {
		super(absoluteURI);
		if (absoluteURI.isRelative() || !absoluteURI.isHierarchical()) {
			throw new IllegalArgumentException(absoluteURI.toString());
		}
	}

	public AbsoluteURI(String absoluteURI) {
		this(URI.createURI(absoluteURI));
	}

	public SourceRelativeURI deresolve(URI sourceFolderURI) {
		try {
			return new SourceRelativeURI(getURI().deresolve(sourceFolderURI));
		} catch (IllegalArgumentException t) {
			throw new IllegalArgumentException("Base URI was " + getURI(), t);
		}
	}

	public SourceRelativeURI deresolve(ISourceFolder sourceFolder) {
		return deresolve(sourceFolder.getPath());
	}

	public SourceRelativeURI deresolve(IProjectConfig projectConfig) {
		ISourceFolder sourceFolder = projectConfig.findSourceFolderContaining(getURI());
		return sourceFolder != null ? deresolve(sourceFolder) : null;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && !Objects.equal(obj.getClass(), AbsoluteURI.class)) {
			throw new IllegalArgumentException(obj.toString() + " instanceof " + obj.getClass().getName());
		}
		return super.equals(obj);
	}
}
