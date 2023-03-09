/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.labels;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.IEObjectDescription;

public class EClassImageDescriptionProvider implements IImageDescriptionProvider {
	@Override
	public IImageDescription getImageDescription(Object element) {
		if (element instanceof EClass) {
			List<String> images = new ArrayList<>();
			images.add(((EClass) element).getName());
			for (EClass superType : ((EClass) element).getEAllSuperTypes()) {
				images.add(superType.getName());
			}
			images.add(IImageDescription.DEFAULT.getImageID());
			return new AlternativeImageDescription(images);
		} else if (element instanceof EObject) {
			return getImageDescription(((EObject) element).eClass());
		} else if (element instanceof IEObjectDescription) {
			return getImageDescription(((IEObjectDescription) element).getEClass());
		} else {
			return IImageDescription.DEFAULT;
		}
	}
}
