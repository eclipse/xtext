/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collection;
import java.util.List;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.common.collect.Lists;

class FeatureScopeSessionToResolvedTypes {
	private final IFeatureScopeSession session;
	private final IResolvedTypes types;
	private int hashCode;
	
	FeatureScopeSessionToResolvedTypes(IFeatureScopeSession session, IResolvedTypes types) {
		this.session = session;
		this.types = types;
	}
	
	IFeatureScopeSession getSession() {
		return session;
	}
	
	IResolvedTypes getTypes() {
		return types;
	}
	
	@Override
	public boolean equals(Object obj) {
		FeatureScopeSessionToResolvedTypes other = (FeatureScopeSessionToResolvedTypes) obj;
		if (other == this)
			return true;
		if (other == null || hashCode() != other.hashCode())
			return false;
		List<QualifiedName> localNames = Lists.newArrayList();
		List<String> localTypes = Lists.newArrayList();
		populateLists(localNames, localTypes);
		List<QualifiedName> otherLocalNames = Lists.newArrayList();
		List<String> otherLocalTypes = Lists.newArrayList();
		other.populateLists(otherLocalNames, otherLocalTypes);
		return 
				   localNames.equals(otherLocalNames)
				&& localTypes.equals(otherLocalTypes);
	}
	
	@Override
	public int hashCode() {
		if (hashCode != 0)
			return hashCode;
		List<QualifiedName> localNames = Lists.newArrayList();
		List<String> localTypes = Lists.newArrayList();
		populateLists(localNames, localTypes);
		return hashCode = (localNames.hashCode() ^ localTypes.hashCode());
	}

	protected void populateLists(List<QualifiedName> localNames, List<String> localTypes) {
		Collection<IEObjectDescription> elements = session.getLocalElements();
		for(IEObjectDescription desc: elements) {
			if (TypesPackage.Literals.JVM_IDENTIFIABLE_ELEMENT.isSuperTypeOf(desc.getEClass())) {
				localNames.add(desc.getName());
				JvmIdentifiableElement identifiable = (JvmIdentifiableElement) desc.getEObjectOrProxy();
				LightweightTypeReference type = types.getActualType(identifiable);
				if (type != null) {
					localTypes.add(type.getRawTypeReference().getIdentifier());
				} else {
					localTypes.add(null);
				}
			}
		}
	}
}