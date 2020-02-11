/*******************************************************************************
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.example.arithmetics.ui.labeling;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.label.DefaultDescriptionLabelProvider;

import com.google.inject.Inject;

/**
 * Provides labels for IEObjectDescriptions and IResourceDescriptions.
 * 
 * https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#label-provider
 */
public class ArithmeticsDescriptionLabelProvider extends DefaultDescriptionLabelProvider {
	@Inject
	private ILabelProvider labelProvider;

	@Override
	public Image getImage(Object element) {
		if (element instanceof IEObjectDescription) {
			return labelProvider.getImage(((IEObjectDescription) element).getEObjectOrProxy());
		} else {
			return super.getImage(element);
		}
	}
}
