/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.outline;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.xtext.ui.PluginImageHelper;
import org.eclipse.xtext.ui.editor.outline.actions.AbstractToggleOutlineContribution;
import org.eclipse.xtext.ui.editor.outline.impl.OutlinePage;

import com.google.inject.Inject;

/**
 * @author dhuebner - Initial contribution and API
 */
public class SwitchOutlineModeContribution extends AbstractToggleOutlineContribution {
	public static final String PREFERENCE_KEY = "ui.outline.switchMode";

	@Inject
	private PluginImageHelper imageHelper;

	private OutlinePage outlinePage;

	@Override
	protected void configureAction(Action action) {
		action.setText("Jvm View");
		action.setToolTipText("Jvm Model View");
		action.setDescription("Switch between Source and Jvm model perspectives.");
		action.setImageDescriptor(imageHelper.getImageDescriptor("jvm_mode.gif"));
		action.setDisabledImageDescriptor(imageHelper.getImageDescriptor("jvm_mode.gif"));
	}

	@Override
	public String getPreferenceKey() {
		return PREFERENCE_KEY;
	}

	@Override
	protected void stateChanged(boolean newState) {
		if (outlinePage != null) {
			TreeViewer treeViewer = outlinePage.getTreeViewer();
			if (treeViewer != null && !outlinePage.getTreeViewer().getTree().isDisposed()) {
				outlinePage.scheduleRefresh();
			}
		}
	}

	@Override
	public void register(OutlinePage outlinePage) {
		super.register(outlinePage);
		this.outlinePage = outlinePage;
	}

	@Override
	public void deregister(OutlinePage outlinePage) {
		super.deregister(outlinePage);
		this.outlinePage = null;
	}
}
