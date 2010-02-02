/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.resource.ecore;

import org.eclipse.xtext.resource.ecore.EcoreResourceServiceProviderImpl;
import org.eclipse.xtext.ui.resource.DefaultResourceUIServiceProvider;

/**
 * @author koehnlein - Initial contribution and API
 */
public class EcoreResourceUIServiceProviderImpl extends DefaultResourceUIServiceProvider {

	public EcoreResourceUIServiceProviderImpl() {
		super(new EcoreResourceServiceProviderImpl());
	}
}
