/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScope;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NestedTypeScope extends AbstractScope {
	private final Map<QualifiedName, JvmDeclaredType> nestedTypes;

	public NestedTypeScope(IScope parent, Map<QualifiedName, JvmDeclaredType> nestedTypes) {
		super(parent, false);
		this.nestedTypes = nestedTypes;
	}

	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		List<IEObjectDescription> result = Lists.newArrayListWithExpectedSize(nestedTypes.size());
		for(Map.Entry<QualifiedName, JvmDeclaredType> nestedType: nestedTypes.entrySet()) {
			result.add(EObjectDescription.create(nestedType.getKey(), nestedType.getValue()));
		}
		return result;
	}

	@Override
	protected Iterable<IEObjectDescription> getLocalElementsByName(QualifiedName name) {
		JvmDeclaredType result = nestedTypes.get(name);
		if (result != null) {
			return Collections.singletonList(EObjectDescription.create(name, result));
		}
		return Collections.emptyList();
	}
}