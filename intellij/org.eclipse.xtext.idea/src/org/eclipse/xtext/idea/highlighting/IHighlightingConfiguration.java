/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.highlighting;

import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles;

import com.intellij.openapi.editor.colors.TextAttributesKey;

/**
 * @author dhubner - Initial contribution and API
 */
public interface IHighlightingConfiguration {

	/**
	 * 
	 * @param style
	 *            xtext highlighting style identifier, default attributes are in {@link HighlightingStyles}
	 * @return {@link TextAttributesKey} for the given style key.
	 * 
	 * @see HighlightingStyles
	 */
	TextAttributesKey getTextAttributesKey(String style);
}
