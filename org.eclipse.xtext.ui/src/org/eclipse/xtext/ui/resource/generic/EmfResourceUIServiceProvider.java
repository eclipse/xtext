/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.resource.generic;

import org.eclipse.xtext.resource.generic.GenericResourceServiceProvider;
import org.eclipse.xtext.ui.resource.DefaultResourceUIServiceProvider;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class EmfResourceUIServiceProvider extends DefaultResourceUIServiceProvider {

	@Inject
	public EmfResourceUIServiceProvider(GenericResourceServiceProvider runtimeDelegate) {
		super(runtimeDelegate);
	}
	
}
