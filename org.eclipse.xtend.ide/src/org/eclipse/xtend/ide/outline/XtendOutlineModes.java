/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.outline;

import static com.google.common.collect.Lists.*;

import java.util.List;

import org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider.ModeAware;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineMode;

/**
 * Xtend QuickOutline Mode manager
 * 
 */
public class XtendOutlineModes implements ModeAware {
	public static final OutlineMode HIDE_INHERITED_MODE = new OutlineMode("hide", "hide inherited members");

	public static final OutlineMode SHOW_INHERITED_MODE = new OutlineMode("show", "show inherited members");

	private static final List<OutlineMode> MODES = newArrayList(HIDE_INHERITED_MODE, SHOW_INHERITED_MODE);

	private int currentModeIndex = 0;

	@Override
	public List<OutlineMode> getOutlineModes() {
		return MODES;
	}

	@Override
	public OutlineMode getCurrentMode() {
		return getOutlineModes().get(currentModeIndex);
	}

	@Override
	public OutlineMode getNextMode() {
		return getOutlineModes().get((currentModeIndex + 1) % getOutlineModes().size());
	}

	@Override
	public void setCurrentMode(OutlineMode outlineMode) {
		int newIndex = getOutlineModes().indexOf(outlineMode);
		if (newIndex != -1)
			currentModeIndex = newIndex;
	}

}