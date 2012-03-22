/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.hover;

import org.eclipse.xtext.Constants;
import org.eclipse.xtext.ui.codetemplates.ui.partialEditing.HighlightingHelper;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.3
 */
public class XbaseHoverConfiguration {

	@Inject
	private EmbeddedEditorFactory editorFactory;
	
	@Inject
	private HighlightingHelper highlightingHelper;
	
	@Inject
	@Named(Constants.FILE_EXTENSIONS)
	private String fileExtension;

	
	public EmbeddedEditorFactory getEditorFactory() {
		return editorFactory;
	}

	public HighlightingHelper getHighlightingHelper() {
		return highlightingHelper;
	}

	public String getFileExtension() {
		return fileExtension;
	}
}
