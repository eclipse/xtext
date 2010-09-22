/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.outline;

import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.xtext.ui.editor.outline.impl.OutlinePage;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;

import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class XtextOutlinePage extends OutlinePage {

	@Inject
	private FilterReturnTypesAction filterReturnTypesAction;
	
	@Inject 
	private IPreferenceStoreAccess preferenceStoreAccess;
	
	private IPropertyChangeListener propertyChangeListener;
	
	@Override
	protected void configureActions() {
		super.configureActions();
		IToolBarManager toolBarManager = getSite().getActionBars().getToolBarManager();
		toolBarManager.add(filterReturnTypesAction);
		filterReturnTypesAction.activate(this);
		propertyChangeListener = new IPropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent event) {
				if(event.getProperty() == FilterReturnTypesAction.PREFERENCE_KEY)
					scheduleRefresh();
			}
		};
		preferenceStoreAccess.getPreferenceStore().addPropertyChangeListener(propertyChangeListener);
	}
	
	@Override
	public void dispose() {
		preferenceStoreAccess.getPreferenceStore().removePropertyChangeListener(propertyChangeListener);
		super.dispose();
	}
}
