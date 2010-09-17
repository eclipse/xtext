/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.outline;

import org.eclipse.xtext.Constants;
import org.eclipse.xtext.ui.editor.outline.actions.AbstractToggleAction;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer;
import org.eclipse.xtext.xtext.ui.Activator;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class FilterReturnTypesAction extends AbstractToggleAction {

	public static final String PREFERENCE_KEY = "org.eclipse.xtext.xtext.ui.outline.showReturnTypes";

	public FilterReturnTypesAction() {
		setText(Messages.FilterReturnTypesAction_title);
		setToolTipText(Messages.FilterReturnTypesAction_tooltip);
		setDescription(Messages.FilterReturnTypesAction_description);
		setImageDescriptor(Activator.getImageDescriptor("icons/filter_rule.gif")); //$NON-NLS-1$
		setDisabledImageDescriptor(Activator.getImageDescriptor("icons/filter_rule.gif")); //$NON-NLS-1$
	}

	@Override
	public String getPreferenceKey() {
		return PREFERENCE_KEY;
	}

	@Override
	protected void stateChanged(boolean newState) {
	}
	
	public static class PropertyInitializer implements IPreferenceStoreInitializer {

		@Inject@Named(Constants.LANGUAGE_NAME) 
		private String languageName; 
		
		public void initialize(IPreferenceStoreAccess access) {
			access.getWritablePreferenceStore().setDefault(languageName + "." + PREFERENCE_KEY, true);
		}
	}

}