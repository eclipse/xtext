/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.scoping;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CachingTypeScope extends AbstractScope {

	private final AbstractScope parent;
	private final Map<QualifiedName, IEObjectDescription> cache;

	public CachingTypeScope(AbstractScope parent) {
		this.parent = parent;
		this.cache = Maps.newHashMapWithExpectedSize(50);
	}
	
	@Override
	public IEObjectDescription getSingleElement(QualifiedName name) {
		IEObjectDescription cached = cache.get(name);
		if (cached == null) {
			if (cache.containsKey(name)) {
				return null;
			}
			cached = parent.getSingleElement(name);
			cache.put(name, cached);
		}
		return cached;
	}

	@Override
	public Iterable<IEObjectDescription> getElements(QualifiedName name) {
		IEObjectDescription element = getSingleElement(name);
		if (element == null)
			return Collections.emptyList();
		return Collections.singletonList(element);
	}
	
	@Override
	protected void doGetElements(JvmType type, List<IEObjectDescription> result) {
		parent.doGetElements(type, result);
	}

}