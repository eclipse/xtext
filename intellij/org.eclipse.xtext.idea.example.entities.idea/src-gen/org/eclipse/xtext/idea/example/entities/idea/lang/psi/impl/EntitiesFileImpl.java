/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.example.entities.idea.lang.psi.impl;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesFileType;
import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage;
import org.eclipse.xtext.psi.impl.BaseXtextFile;

public final class EntitiesFileImpl extends BaseXtextFile {

	public EntitiesFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, EntitiesLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return EntitiesFileType.INSTANCE;
	}
}
