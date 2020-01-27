/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.wizard;

import java.net.URL;
import org.eclipse.xtext.xtext.wizard.AbstractFile;
import org.eclipse.xtext.xtext.wizard.Outlet;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;

public class BinaryFile extends AbstractFile {
	private final URL content;

	public URL getContent() {
		return this.content;
	}

	public BinaryFile(Outlet outlet, String relativePath, ProjectDescriptor project, boolean executable, URL content) {
		super(outlet, relativePath, project, executable);
		this.content = content;
	}
}
