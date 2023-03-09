/*******************************************************************************
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import org.eclipse.xtext.common.types.access.CachingClasspathTypeProviderFactory;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CachingClasspathTypeProviderTest extends ClasspathTypeProviderTest {

	@Inject
	private CachingClasspathTypeProviderFactory typeProviderFactory;
	
	@Override
	protected ClasspathTypeProvider createTypeProvider() {
		return typeProviderFactory.createTypeProvider(getResourceSet());
	}
	
}
