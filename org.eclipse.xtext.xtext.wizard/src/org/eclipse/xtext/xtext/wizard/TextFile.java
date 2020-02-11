/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.wizard;

public abstract class TextFile extends AbstractFile {
	public TextFile(Outlet outlet, String relativePath, ProjectDescriptor project) {
		super(outlet, relativePath, project, false);
	}

	public abstract String getContent();

	public TextFile(Outlet outlet, String relativePath, ProjectDescriptor project, boolean executable) {
		super(outlet, relativePath, project, executable);
	}
}
