/*******************************************************************************
 * Copyright (c) 2010-2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.lang.psi.impl;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.eclipse.xtend.core.idea.lang.XtendFileType;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;
import org.eclipse.xtext.psi.impl.BaseXtextFile;

public final class XtendFileImpl extends BaseXtextFile {

	public XtendFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, XtendLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return XtendFileType.INSTANCE;
	}
}
