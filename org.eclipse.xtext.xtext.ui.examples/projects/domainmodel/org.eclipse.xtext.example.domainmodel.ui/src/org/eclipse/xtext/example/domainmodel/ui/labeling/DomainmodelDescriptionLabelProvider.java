/**
 * Copyright (c) 2011, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.domainmodel.ui.labeling;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.ui.labeling.XbaseDescriptionLabelProvider;

/**
 * Provides labels for IEObjectDescriptions and IResourceDescriptions.
 * 
 * https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#label-provider
 */
public class DomainmodelDescriptionLabelProvider extends XbaseDescriptionLabelProvider {
	@Override
	public String image(IEObjectDescription description) {
		return description.getEClass().getName() + ".gif";
	}
}
