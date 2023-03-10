/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.example.statemachine.ide;

import org.eclipse.xtext.ide.labels.DecoratedImageDescription;
import org.eclipse.xtext.ide.labels.EClassImageDescriptionProvider;
import org.eclipse.xtext.ide.labels.IImageDescription;
import org.eclipse.xtext.ide.labels.SimpleImageDescription;
import org.eclipse.xtext.web.example.statemachine.statemachine.OutputSignal;

public class StatemachineImageDescriptionProvider extends EClassImageDescriptionProvider {
	@Override
	public IImageDescription getImageDescription(Object element) {
		IImageDescription baseImage = super.getImageDescription(element);
		if (element instanceof OutputSignal) {
			return new DecoratedImageDescription(baseImage, new SimpleImageDescription("output"));
		} else {
			return baseImage;
		}
	}
}
