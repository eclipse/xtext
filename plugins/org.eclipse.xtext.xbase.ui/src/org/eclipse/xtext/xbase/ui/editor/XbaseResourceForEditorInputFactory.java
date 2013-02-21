/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.editor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IStorage;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.ui.editor.model.JavaClassPathResourceForIEditorInputFactory;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XbaseResourceForEditorInputFactory extends JavaClassPathResourceForIEditorInputFactory{

	@Override
	protected boolean isValidationDisabled(IStorage storage) {
		if (storage instanceof IFile) {
			IFile file = (IFile) storage;
			IJavaProject javaProject = JavaCore.create(file.getProject());
			if (javaProject == null || !javaProject.exists() || !javaProject.isOpen()) {
				return true;
			}
		}
		return super.isValidationDisabled(storage);
	}
}
