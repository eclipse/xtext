/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.xtext.ui.editor.outline.impl.OutlinePage;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;

import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public abstract class AbstractToggleActionContribution implements IOutlineContribution {

	protected static class ToggleAction extends Action {

		private final AbstractToggleActionContribution contribution;

		protected ToggleAction(AbstractToggleActionContribution contribution) {
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

	public abstract String getPreferenceKey();

	protected abstract void stateChanged(boolean newState);

	protected boolean isPropertySet() {
		return preferenceStoreAccess.getPreferenceStore().getBoolean(getPreferenceKey());
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
			action = new ToggleAction(this);
			configureAction(action);
		}
		return action;
	}

	public void register(OutlinePage outlinePage) {
		propertyChangeListener = new IPropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent event) {
				if (getPreferenceKey().equals(event.getProperty()) && event.getOldValue() != event.getNewValue()) {
					stateChanged(Boolean.parseBoolean(event.getNewValue().toString()));
				}
			}
		};
		preferenceStoreAccess.getPreferenceStore().addPropertyChangeListener(propertyChangeListener);
		IToolBarManager toolBarManager = outlinePage.getSite().getActionBars().getToolBarManager();
		toolBarManager.add(getAction());
	}

	public void deregister(OutlinePage outlinePage) {
		preferenceStoreAccess.getPreferenceStore().removePropertyChangeListener(propertyChangeListener);
	}

	public void initialize(IPreferenceStoreAccess preferenceStoreAccess) {
		preferenceStoreAccess.getWritablePreferenceStore().setDefault(getPreferenceKey(), false);
	}
}