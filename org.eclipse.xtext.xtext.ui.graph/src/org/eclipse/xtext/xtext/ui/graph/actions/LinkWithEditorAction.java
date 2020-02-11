/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu)
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors:
 *   Jan Koehnlein - Initial API and implementation
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.graph.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.xtext.ui.graph.RailroadViewPreferences;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class LinkWithEditorAction extends Action {

	private RailroadViewPreferences preferences;
	
	public LinkWithEditorAction() {
		setText("Link with editor");
		setDescription("Links this view to the editor");
		setToolTipText("Links this view to the editor");
		setImageDescriptor(getSharedImage(ISharedImages.IMG_ELCL_SYNCED));
		setDisabledImageDescriptor(getSharedImage(ISharedImages.IMG_ELCL_SYNCED_DISABLED));
	}
	
	protected ImageDescriptor getSharedImage(String name) {
		return PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(name);
	}

	@Inject
	public void setPreferences(RailroadViewPreferences preferences) {
		this.preferences = preferences;	
		setChecked(preferences.isLinkWithEditor());
	}

	@Override
	public void run() {
		boolean newState = !preferences.isLinkWithEditor();
		preferences.setLinkWithEditor(newState);
		setChecked(newState);
	}
}
