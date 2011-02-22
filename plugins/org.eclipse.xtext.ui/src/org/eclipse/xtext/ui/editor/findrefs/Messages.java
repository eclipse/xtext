/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.findrefs;

import org.eclipse.osgi.util.NLS;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.xtext.ui.editor.findrefs.messages"; //$NON-NLS-1$
	public static String FindReferencesHandler_1;
	public static String FindReferencesHandler_2;
	public static String FindReferencesHandler_3;
	public static String FindReferencesHandler_labelPrefix;
	public static String ReferenceQuery_monitor;
	public static String ReferenceSearchResultContentProvider_label;
	public static String ReferenceSearchResultLabelProvider_invalid;
	public static String ReferenceSearchViewPage_busyLabel;
	public static String ReferenceSearchViewPageActions_collapseAll;
	public static String ReferenceSearchViewPageActions_collapseAll_tooltip;
	public static String ReferenceSearchViewPageActions_expandAll;
	public static String ReferenceSearchViewPageActions_expandAll_tooltip;
	public static String ReferenceSearchViewPageActions_showNextMatch;
	public static String ReferenceSearchViewPageActions_showNextMatch_tooltip;
	public static String ReferenceSearchViewPageActions_showPreviousMatch;
	public static String ReferenceSearchViewPageActions_showPreviousMatch_tooltip;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
