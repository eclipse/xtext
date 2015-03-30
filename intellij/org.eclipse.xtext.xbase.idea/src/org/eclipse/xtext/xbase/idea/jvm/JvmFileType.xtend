/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.jvm

import com.intellij.ide.highlighter.JavaFileType
import com.intellij.openapi.fileTypes.LanguageFileType

/**
 * @author kosyakov - Initial contribution and API
 */
class JvmFileType extends LanguageFileType {

	public static val INSTANCE = new JvmFileType

	private new() {
		super(JvmLanguage.INSTANCE)
	}

	override getDefaultExtension() {
		JavaFileType.INSTANCE.defaultExtension
	}

	override getDescription() {
		JavaFileType.INSTANCE.description
	}

	override getIcon() {
		JavaFileType.INSTANCE.icon
	}

	override getName() {
		JavaFileType.INSTANCE.name
	}

}