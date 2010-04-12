/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.ignorecase;

import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.SimpleLocalScopeProvider;

import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class IgnoreCaseSimpleLocalScopeProvider extends SimpleLocalScopeProvider {

	@Override
	protected Map<String, IEObjectDescription> toMap(EObject context, EReference reference) {
		TreeIterator<EObject> iterator = context.eResource().getAllContents();
		Map<String, IEObjectDescription> result = Maps.newHashMap();
		while (iterator.hasNext()) {
			EObject next = iterator.next();
			if (reference.getEReferenceType().isInstance(next)) {
				String name = getNameProvider().getQualifiedName(next);
				if (name != null) {
					String key = name.toLowerCase();
					if (!result.containsKey(key)) {
						EObjectDescription description = createEObjectDescription(next, name);
						if (description != null)
							result.put(key, description);
					}
				}
			}
		}
		return result;
	}
	
	@Override
	protected IScope createMapBasedScope(IScope parent,	Map<String, IEObjectDescription> map) {
		return new IgnoreCaseMapBasedScope(parent, map);
	}
}
