/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.view;

import org.eclipse.osgi.util.NLS;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.xtend.ide.view.messages"; //$NON-NLS-1$
	public static String DerivedSourceView_EditorDirty;
	public static String DerivedSourceView_RefreshJobTitle;
	public static String OpenEditorAction_Description;
	public static String OpenEditorAction_Label;
	public static String OpenEditorAction_ToolTip;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
