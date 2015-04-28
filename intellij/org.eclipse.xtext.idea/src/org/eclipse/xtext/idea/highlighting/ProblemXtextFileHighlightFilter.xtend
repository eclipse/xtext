/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.highlighting

import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.util.Condition
import com.intellij.openapi.vfs.VirtualFile
import org.eclipse.xtext.idea.lang.IXtextLanguage

/**
 * @author kosyakov - Initial contribution and API
 */
class ProblemXtextFileHighlightFilter implements Condition<VirtualFile> {

	override value(VirtualFile file) {
		val fileType = file.fileType
		if (fileType instanceof LanguageFileType)
			return fileType.language instanceof IXtextLanguage
		else
			false
	}

}