/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
	
	public abstract List<OutlineMode> getOutlineModes();
	
	public OutlineMode getCurrentMode() {
		return getOutlineModes().get(currentModeIndex);
	}
	
	public OutlineMode getNextMode() {
		return getOutlineModes().get((currentModeIndex + 1) % getOutlineModes().size());
	}
	
	public void setCurrentMode(OutlineMode outlineMode) {
		int newIndex = getOutlineModes().indexOf(outlineMode);
		if(newIndex != -1)
			currentModeIndex = newIndex;
	}
}
