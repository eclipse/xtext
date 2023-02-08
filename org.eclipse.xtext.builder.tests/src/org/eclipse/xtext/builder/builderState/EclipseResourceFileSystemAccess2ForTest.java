/*******************************************************************************
 * Copyright (c) 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import org.eclipse.core.resources.IFile;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.util.StringInputStream;

public class EclipseResourceFileSystemAccess2ForTest extends EclipseResourceFileSystemAccess2 {
	// make method accessible for test
	@Override
	public boolean hasContentsChanged(IFile file, StringInputStream newContent) {
		return super.hasContentsChanged(file, newContent);
	}
}