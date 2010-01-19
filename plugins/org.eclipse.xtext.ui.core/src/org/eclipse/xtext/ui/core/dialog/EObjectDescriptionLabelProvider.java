/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.dialog;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * @author koehnlein - Initial contribution and API
 */
public class EObjectDescriptionLabelProvider implements ILabelProvider {

	public Image getImage(Object element) {
		return null;
	}

	public String getText(Object element) {
		if(element instanceof IEObjectDescription) {
			StringBuilder b = new StringBuilder();
			IEObjectDescription eObjectDescription = (IEObjectDescription) element;
			b.append(eObjectDescription.getQualifiedName());
			b.append(" - ");
			b.append(eObjectDescription.getEClass().getName());
			return b.toString();
		}
		return element.toString();
	}

	public void addListener(ILabelProviderListener listener) {
	}

	public void dispose() {
	}

	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
	}

}