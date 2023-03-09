/**
 * Copyright (c) 2017, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource.containers;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.workspace.ISourceFolder;

public class SourceFolder implements ISourceFolder {
	private final URI path;

	public SourceFolder(URI path) {
		this.path = path;
	}

	@Override
	public String getName() {
		return "src";
	}

	public URI getPath() {
		return path;
	}
}
