/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.hover;

import org.eclipse.xtext.ui.codetemplates.ui.partialEditing.HighlightingHelper;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;

import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.3
 */
@SuppressWarnings("restriction")
public class XtendHoverConfiguration {

	
	@Inject
	private EmbeddedEditorFactory editorFactory;
	
	@Inject
	private HighlightingHelper highlightingHelper;

	
	public EmbeddedEditorFactory getEditorFactory() {
		return editorFactory;
	}

	public HighlightingHelper getHighlightingHelper() {
		return highlightingHelper;
	}
	
	
}
