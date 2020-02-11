/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.junit;

import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.resource.SynchronizedXtextResourceSet;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Yields an empty resource set that is configured with an injected class loader
 * and a classpath based {@link IJvmTypeProvider}. 
 * 
 * @author Sebastian Zarnekow
 * @since 2.4
 */
public class SynchronizedXtextResourceSetProvider implements Provider<SynchronizedXtextResourceSet> {

	@Inject
	private ClassLoader classLoader;

	@Inject
	private IJvmTypeProvider.Factory typeProviderFactory;

	@Override
	public SynchronizedXtextResourceSet get() {
		SynchronizedXtextResourceSet result = new SynchronizedXtextResourceSet();
		result.setClasspathURIContext(classLoader);
		typeProviderFactory.findOrCreateTypeProvider(result);
		return result;
	}

}