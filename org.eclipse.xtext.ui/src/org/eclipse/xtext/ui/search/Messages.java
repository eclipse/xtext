/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.search;

import org.eclipse.osgi.util.NLS;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.xtext.ui.search.messages"; //$NON-NLS-1$
	public static String XtextEObjectSearchDialog_Matches;
	public static String XtextEObjectSearchDialog_MatchingElementsLabel;
	public static String XtextEObjectSearchDialog_TableLabelDialogTitle;
	public static String XtextEObjectSearchDialog_TableLabelSearchControlLabel;
	public static String XtextEObjectSearchDialog_TypeSearchLabel;
	public static String XtextEObjectSearchDialog_StatusMessageSearching;
	public static String IteratorJob_SearchJobName;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
