/*******************************************************************************
 * Copyright (c) 2014, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.junit4.smoketest.internal;

import java.util.Map;

import org.eclipse.xtext.junit4.IInjectorProvider;

import com.google.common.collect.Maps;

/**
 * Caches the wrapped injectors per injector provider.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated(forRemoval = true, since = "2.30")
public class InjectorCache {
	private static Map<IInjectorProvider, WrappingInjectorProvider> cachedInjectors = Maps.newHashMap();
	
	public static WrappingInjectorProvider wrap(IInjectorProvider delegate) {
		WrappingInjectorProvider result = cachedInjectors.get(delegate);
		if (result == null) {
			result = new WrappingInjectorProvider(delegate);
			cachedInjectors.put(delegate, result);
		}
		return result;
	}
}