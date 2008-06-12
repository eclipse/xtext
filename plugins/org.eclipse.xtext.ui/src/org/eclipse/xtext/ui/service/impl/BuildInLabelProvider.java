/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.service.impl;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ReflectiveItemProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.service.ILabelProvider;

/**
 * 
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class BuildInLabelProvider extends ReflectiveItemProvider implements ILabelProvider {
	private AdapterFactoryLabelProvider slave = new AdapterFactoryLabelProvider(
			new ReflectiveItemProviderAdapterFactory());

	/**
	 * Extends ReflectiveItemProvider to use it useful stuff ;)
	 * 
	 * @param adapterFactory
	 */
	private BuildInLabelProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	public BuildInLabelProvider() {
		this(new ReflectiveItemProviderAdapterFactory());
	}

	public Image getIcon(EObject eObject) {
		return slave.getImage(eObject);
	}

	// TODO make it configurable
	public StyledString getLabel(EObject eObject) {
		String clazzName = format(capName(eObject.eClass().getName()), ' ');
		EStructuralFeature feature = getLabelFeature(eObject.eClass());
		String objectName = "";
		if (feature != null) {
			Object value = eObject.eGet(feature);
			if (value != null) {
				objectName = value.toString();

			}
		}
		StyledString retVal = new StyledString(objectName);
		retVal.append(" (" + clazzName + ")", StyledString.DECORATIONS_STYLER);
		return retVal;
	}
}
