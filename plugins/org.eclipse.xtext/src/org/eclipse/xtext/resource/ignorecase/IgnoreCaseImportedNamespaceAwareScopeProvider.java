/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.ignorecase;

import java.util.Map;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;

import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class IgnoreCaseImportedNamespaceAwareScopeProvider extends ImportedNamespaceAwareLocalScopeProvider {

	@Override
	protected Map<String, IEObjectDescription> toMap(Iterable<IEObjectDescription> scopedElementsFor) {
		Map<String, IEObjectDescription> result = Maps.newHashMap();
		for (IEObjectDescription ieObjectDescription : scopedElementsFor) {
			String key = ieObjectDescription.getName().toLowerCase();
			if (!result.containsKey(key))
				result.put(key, ieObjectDescription);
		}
		return result;
	}
	
	@Override
	protected IScope createMapBasedScope(IScope parentScope, Map<String, IEObjectDescription> map) {
		return new IgnoreCaseMapBasedScope(parentScope, map);
	}
	
}
