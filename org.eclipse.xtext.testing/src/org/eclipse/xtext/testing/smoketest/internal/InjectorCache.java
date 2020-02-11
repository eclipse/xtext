/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testing.smoketest.internal;

import java.util.Map;

import org.eclipse.xtext.testing.IInjectorProvider;

import com.google.common.annotations.Beta;
import com.google.common.collect.Maps;

/**
 * Caches the wrapped injectors per injector provider.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Beta
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