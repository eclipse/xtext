/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.outline;

import static com.google.common.collect.Lists.*;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider.ModeAware;
import org.eclipse.xtext.ui.editor.outline.impl.BackgroundOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineMode;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public abstract class AbstractMultiModeOutlineTreeProvider extends BackgroundOutlineTreeProvider implements ModeAware {

	protected static final OutlineMode HIDE_INHERITED_MODE = new OutlineMode("hide", "hide inherited members");

	protected static final OutlineMode SHOW_INHERITED_MODE = new OutlineMode("show", "show inherited members");

	private static final List<OutlineMode> MODES = newArrayList(HIDE_INHERITED_MODE, SHOW_INHERITED_MODE);

	private int currentModeIndex = 0;

	public List<OutlineMode> getOutlineModes() {
		return MODES;
	}

	public OutlineMode getCurrentMode() {
		return getOutlineModes().get(currentModeIndex);
	}

	public OutlineMode getNextMode() {
		return getOutlineModes().get((currentModeIndex + 1) % getOutlineModes().size());
	}

	public void setCurrentMode(OutlineMode outlineMode) {
		int newIndex = getOutlineModes().indexOf(outlineMode);
		if (newIndex != -1)
			currentModeIndex = newIndex;
	}

	@Override
	public void internalCreateChildren(DocumentRootNode parentNode, EObject modelElement) {
		super.internalCreateChildren(parentNode, modelElement);
	}
}
