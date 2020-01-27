/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.wizard;

import org.eclipse.xtext.xtext.wizard.Outlet;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.TextFile;

public class PlainTextFile extends TextFile {
	private final CharSequence content;

	public PlainTextFile(Outlet outlet, String relativePath, ProjectDescriptor project, CharSequence content,
			boolean executable) {
		super(outlet, relativePath, project, executable);
		this.content = content;
	}

	@Override
	public String getContent() {
		return this.content.toString();
	}

	public PlainTextFile(Outlet outlet, String relativePath, ProjectDescriptor project, CharSequence content) {
		super(outlet, relativePath, project);
		this.content = content;
	}
}
