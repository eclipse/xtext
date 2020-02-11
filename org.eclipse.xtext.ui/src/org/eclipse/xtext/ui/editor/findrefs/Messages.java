/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
	public static String ReferenceSearchResult_Matches;
	public static String ReferenceSearchResultContentProvider_label;
	public static String ReferenceSearchResultLabelProvider_invalid;
	public static String ReferenceSearchViewPage_busyLabel;
	public static String ReferenceSearchViewPageActions_collapseAll;
	public static String ReferenceSearchViewPageActions_expandAll;
	public static String ReferenceSearchViewPageActions_showNextMatch;
	public static String ReferenceSearchViewPageActions_showPreviousMatch;
	public static String ReferenceSearchViewPageActions_copy;
	public static String ReferenceSearchViewPageActions_removeSelectedMatches;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
