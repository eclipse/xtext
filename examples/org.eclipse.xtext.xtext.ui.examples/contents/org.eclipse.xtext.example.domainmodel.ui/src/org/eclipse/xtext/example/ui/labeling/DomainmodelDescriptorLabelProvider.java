/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.ui.labeling;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.core.resource.DefaultDescriptionLabelProvider;

import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class DomainmodelDescriptorLabelProvider extends DefaultDescriptionLabelProvider {

	@Inject
	private ILabelProvider delegateLabelProvider;
	
	@Override
	public Image getImage(Object description) {
		if (description instanceof IEObjectDescription) {
			return delegateLabelProvider.getImage(((IEObjectDescription) description).getEObjectOrProxy());
		}
		return super.getImage(description);
	}
}
