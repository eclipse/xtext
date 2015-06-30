/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.editorActions

import com.intellij.lang.LanguageExtension

/**
 * @author kosyakov - Initial contribution and API
 */
class IdeaAutoEditHandlerExtension extends LanguageExtension<IdeaAutoEditHandler> {

	public static val INSTANCE = new IdeaAutoEditHandlerExtension

	new() {
		super('org.eclipse.xtext.idea.lang.editor.autoEditHandler')
	}

}