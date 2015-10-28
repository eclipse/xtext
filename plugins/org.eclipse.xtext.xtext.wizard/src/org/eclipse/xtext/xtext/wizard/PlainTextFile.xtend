/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.wizard

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

@FinalFieldsConstructor
class PlainTextFile extends TextFile {
	@Accessors val CharSequence content
	
	new(Outlet outlet, String relativePath, ProjectDescriptor project, CharSequence content, boolean executable) {
		super(outlet, relativePath, project, executable)
		this.content = content
	}
	
	override String getContent() {
		content.toString
	}
}