/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.outline;

import org.eclipse.xtext.ui.common.internal.Activator;

/**
 * @author Peter Friese - Initial contribution and API
 */
public final class LinkingHelper {

	private static final String TOGGLE_LINK_WITH_EDITOR_ACTION_IS_CHECKED = "ToggleLinkWithEditorAction.isChecked"; //$NON-NLS-1$

	public static boolean isLinkingEnabled() {
		boolean isLinkingEnabled = Activator.getDefault().getPreferenceStore().getBoolean(
				TOGGLE_LINK_WITH_EDITOR_ACTION_IS_CHECKED); 
		return isLinkingEnabled;
	}

	public static void setLinkingEnabled(boolean enabled) {
		Activator.getDefault().getPreferenceStore().setValue(TOGGLE_LINK_WITH_EDITOR_ACTION_IS_CHECKED, enabled);
	}

}
