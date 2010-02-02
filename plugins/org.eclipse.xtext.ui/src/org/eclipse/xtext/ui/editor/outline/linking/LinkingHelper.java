/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.linking;

/**
 * @author Peter Friese - Initial contribution and API
 */
public final class LinkingHelper extends ToggleHelper {

	public static final String TOGGLE_LINK_WITH_EDITOR_ACTION_IS_CHECKED = "ToggleLinkWithEditorAction.isChecked"; //$NON-NLS-1$

	public static boolean isLinkingEnabled() {
		return isToggleEnabled(TOGGLE_LINK_WITH_EDITOR_ACTION_IS_CHECKED);
	}

	public static void setLinkingEnabled(boolean enabled) {
		setToggleEnabled(TOGGLE_LINK_WITH_EDITOR_ACTION_IS_CHECKED, enabled);
	}
	
}
