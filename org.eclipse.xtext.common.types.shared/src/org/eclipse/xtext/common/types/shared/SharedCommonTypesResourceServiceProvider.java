/*******************************************************************************
 * Copyright (c) 2010, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.shared;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceDescription.Manager;
import org.eclipse.xtext.resource.impl.DefaultResourceServiceProvider;

public class SharedCommonTypesResourceServiceProvider extends DefaultResourceServiceProvider {
	
	@Override
	public Manager getResourceDescriptionManager() {
		return null;
	}
	
	@Override
	public boolean canHandle(URI uri) {
		return "java".equals(uri.scheme());
	}
}
