/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public abstract class AbstractToggleActionContributor {

	protected static class InternalToggleAction extends Action {

		private final AbstractToggleActionContributor contribution;

		protected InternalToggleAction(AbstractToggleActionContributor contribution) {
			this.contribution = contribution;
			setId(contribution.getPreferenceKey());
			setChecked(contribution.isPropertySet());
		}

		@Override
		public void run() {
			boolean newState = !contribution.isPropertySet();
			setChecked(newState);
			contribution.toggle();
		}
	}

	@Inject
	private IPreferenceStoreAccess preferenceStoreAccess;

	private IPropertyChangeListener propertyChangeListener;

	private Action action;

	private IPreferenceStore preferenceStore;

	public abstract String getPreferenceKey();

	protected abstract void stateChanged(boolean newState);

	protected boolean isPropertySet() {
		return preferenceStoreAccess.getPreferenceStore().getBoolean(getPreferenceKey());
	}
	
	protected IPreferenceStoreAccess getPreferenceStoreAccess() {
		return preferenceStoreAccess;
	}
	
	protected void toggle() {
		boolean newState = !isPropertySet();
		preferenceStoreAccess.getWritablePreferenceStore().setValue(getPreferenceKey(), newState);
		stateChanged(newState);
	}

	/**
	 * Subclasses must set text, image, description, tooltip etc. here.
	 */
	protected abstract void configureAction(Action action);

	protected Action getAction() {
		if (action == null) {
			action = new InternalToggleAction(this);
			configureAction(action);
		}
		return action;
	}

	public void initialize(IPreferenceStoreAccess preferenceStoreAccess) {
		preferenceStoreAccess.getWritablePreferenceStore().setDefault(getPreferenceKey(), false);
	}

	protected void addPropertyChangeListener() {
		propertyChangeListener = new IPropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent event) {
				if (getPreferenceKey().equals(event.getProperty()) && event.getOldValue() != event.getNewValue()) {
					boolean newValue = Boolean.parseBoolean(event.getNewValue().toString());
					stateChanged(newValue);
					getAction().setChecked(newValue);
				}
			}
		};
		preferenceStore = preferenceStoreAccess.getPreferenceStore();
		preferenceStore.addPropertyChangeListener(propertyChangeListener);
	}
	
	protected void removePropertyChangeListener() {
		preferenceStore.removePropertyChangeListener(propertyChangeListener);
	}
	
}
