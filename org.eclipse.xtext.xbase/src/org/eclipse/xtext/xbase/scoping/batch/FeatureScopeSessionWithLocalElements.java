/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.List;
import java.util.Map;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FeatureScopeSessionWithLocalElements extends AbstractNestedFeatureScopeSession {

	private final Map<QualifiedName, JvmIdentifiableElement> map;

	public FeatureScopeSessionWithLocalElements(AbstractFeatureScopeSession parent, Map<QualifiedName, JvmIdentifiableElement> map) {
		super(parent);
		this.map = map;
	}
	
	/* @Nullable */
	@Override
	public IEObjectDescription getLocalElement(QualifiedName name) {
		JvmIdentifiableElement result = map.get(name);
		if (result != null)
			return EObjectDescription.create(name, result);
		return super.getLocalElement(name);
	}
	
	@Override
	protected void addLocalElements(List<IEObjectDescription> result) {
		for(Map.Entry<QualifiedName, JvmIdentifiableElement> entry: map.entrySet()) {
			result.add(EObjectDescription.create(entry.getKey(), entry.getValue()));
		}
		super.addLocalElements(result);
	}
}
