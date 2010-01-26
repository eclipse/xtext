/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.search;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.core.resource.IDescriptionLabelProvider;
import org.eclipse.xtext.ui.core.resource.IResourceUIServiceProvider;

/**
 * Delegates to the {@link IDescriptionLabelProvider} looked up in the {@link IResourceServiceProvider.Registry}
 * 
 * @author koehnlein - Initial contribution and API
 */
public class GenericDescriptionLabelProvider extends BaseLabelProvider implements ILabelProvider {

	public Image getImage(Object element) {
		IDescriptionLabelProvider descriptionLabelProvider = lookupDescriptionLabelProvider(element);
		if (descriptionLabelProvider != null) {
			return descriptionLabelProvider.getImage(element);
		} else {
			return null;
		}
	}

	public String getText(Object element) {
		if (element == null) {
			return "<null>";
		} else {
			IDescriptionLabelProvider descriptionLabelProvider = lookupDescriptionLabelProvider(element);
			if (descriptionLabelProvider != null) {
				return descriptionLabelProvider.getText(element);
			} else {
				return element.toString();
			}
		}
	}

	private IDescriptionLabelProvider lookupDescriptionLabelProvider(Object description) {
		URI uri = uri(description);
		if (uri != null) {
			IResourceUIServiceProvider resourceServiceProvider = (IResourceUIServiceProvider) IResourceServiceProvider.Registry.INSTANCE
					.getResourceServiceProvider(uri);
			return resourceServiceProvider.getDescriptionLabelProvider();
		} else {
			return null;
		}
	}

	private URI uri(Object description) {
		if (description instanceof IEObjectDescription) {
			return ((IEObjectDescription) description).getEObjectURI();
		} else if (description instanceof IResourceDescription) {
			return ((IResourceDescription) description).getURI();
		} else {
			return null;
		}
	}

}