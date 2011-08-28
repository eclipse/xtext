/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.selection;

import org.eclipse.osgi.util.NLS;

/**
 * Helper class to get NLSed messages.
 *
 * @author Michael Clay - Initial contribution and API
 */
public final class NodeSelectionMessages extends NLS {

	private static final String BUNDLE_NAME= NodeSelectionMessages.class.getName();

	private NodeSelectionMessages() {
		// Do not instantiate
	}

	public static String NodeSelect_error_title;
	public static String NodeSelect_error_message;
	public static String NodeSelectNext_label;
	public static String NodeSelectNext_tooltip;
	public static String NodeSelectNext_description;
	public static String NodeSelectPrevious_label;
	public static String NodeSelectPrevious_tooltip;
	public static String NodeSelectPrevious_description;
	public static String NodeSelectEnclosing_label;
	public static String NodeSelectEnclosing_tooltip;
	public static String NodeSelectEnclosing_description;
	public static String NodeSelectHistory_label;
	public static String NodeSelectHistory_tooltip;
	public static String NodeSelectHistory_description;

	static {
		NLS.initializeMessages(BUNDLE_NAME, NodeSelectionMessages.class);
	}
}
