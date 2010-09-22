/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.xtext.ui.editor.outline.impl.OutlinePage;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;

import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public abstract class AbstractToggleAction extends Action {

	@Inject 
	private IPreferenceStoreAccess preferenceStoreAccess;
	
	protected AbstractToggleAction() {
	}
	
	public abstract String getPreferenceKey();
	
	protected boolean isPropertySet() {
		return preferenceStoreAccess.getPreferenceStore().getBoolean(getPreferenceKey());
	}
	
	@Override
	public void run() {
		boolean newState = !isPropertySet();
		preferenceStoreAccess.getWritablePreferenceStore().setValue(getPreferenceKey(), newState);
		setChecked(newState);
		stateChanged(newState);
	}
	
	protected abstract void stateChanged(boolean newState);

	public void activate(OutlinePage outlinePage) {
		setChecked(isPropertySet());
	}
	
	public void deactivate() {
	}

}
