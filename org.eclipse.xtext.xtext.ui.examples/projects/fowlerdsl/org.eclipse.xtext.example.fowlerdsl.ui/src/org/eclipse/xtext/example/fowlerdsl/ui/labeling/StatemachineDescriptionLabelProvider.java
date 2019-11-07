/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.fowlerdsl.ui.labeling;

import org.eclipse.xtext.ui.label.DefaultDescriptionLabelProvider;

/**
 * Provides labels for IEObjectDescriptions and IResourceDescriptions.
 * 
 * https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#label-provider
 */
public class StatemachineDescriptionLabelProvider extends DefaultDescriptionLabelProvider {

	// Labels and icons can be computed like this:
	
//	String text(IEObjectDescription ele) {
//		return ele.getName().toString();
//	}
//	 
//	String image(IEObjectDescription ele) {
//		return ele.getEClass().getName() + ".gif";
//	}
}
