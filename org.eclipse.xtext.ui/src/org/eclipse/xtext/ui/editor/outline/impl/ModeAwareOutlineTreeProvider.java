/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.impl;

import java.util.List;

import org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.2
 */
public abstract class ModeAwareOutlineTreeProvider extends DefaultOutlineTreeProvider implements IOutlineTreeProvider.ModeAware {

	private int currentModeIndex = 0;
	
	@Override
	public abstract List<OutlineMode> getOutlineModes();
	
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
		if(newIndex != -1)
			currentModeIndex = newIndex;
	}
}
