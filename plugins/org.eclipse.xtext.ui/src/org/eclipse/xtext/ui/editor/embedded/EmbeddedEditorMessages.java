/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.embedded;

import org.eclipse.osgi.util.NLS;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class EmbeddedEditorMessages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorMessages";//$NON-NLS-1$

	private EmbeddedEditorMessages() {
		// Do not instantiate
	}

	static {
		NLS.initializeMessages(BUNDLE_NAME, EmbeddedEditorMessages.class);
	}

	public static String EmbeddedEditor_content_assist;

	public static String EmbeddedEditor_undo;

	public static String EmbeddedEditor_redo;

	public static String EmbeddedEditor_cut;

	public static String EmbeddedEditor_copy;

	public static String EmbeddedEditor_paste;

	public static String EmbeddedEditor_select_all;

}
