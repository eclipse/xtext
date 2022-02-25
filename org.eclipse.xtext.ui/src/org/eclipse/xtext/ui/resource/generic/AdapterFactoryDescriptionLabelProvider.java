/*******************************************************************************
 * Copyright (c) 2010, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.resource.generic;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.label.DefaultDescriptionLabelProvider;

import com.google.inject.Inject;

public class AdapterFactoryDescriptionLabelProvider extends DefaultDescriptionLabelProvider {

	@Inject
	private AdapterFactoryLabelProvider delegate;
	
	@Override
	public Object image(IEObjectDescription element) {
		return delegate.getImage(element.getEObjectOrProxy());
	}
	
}
