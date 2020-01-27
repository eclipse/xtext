/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
