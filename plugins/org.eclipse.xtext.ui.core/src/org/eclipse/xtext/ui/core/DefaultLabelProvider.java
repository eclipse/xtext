/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.graphics.Image;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Peter Friese - Implementation
 * @author Sebastian Zarnekow
 */
public class DefaultLabelProvider extends SimpleLabelProvider {
	
	@Inject
	private AdapterFactoryLabelProvider adapterFactoryLabelProvider;
	
	@Override
	public Image getImage(Object element) {
		String imageName = getImageDispatcher().invoke(element);
		if (imageName == null && adapterFactoryLabelProvider != null)
			return adapterFactoryLabelProvider.getImage(element);
		return getImageHelper().getImage(imageName);
	}
	
	public AdapterFactoryLabelProvider getAdapterFactoryLabelProvider() {
		return adapterFactoryLabelProvider;
	}

	public void setAdapterFactoryLabelProvider(AdapterFactoryLabelProvider adapterFactoryLabelProvider) {
		this.adapterFactoryLabelProvider = adapterFactoryLabelProvider;
	}
	
}
