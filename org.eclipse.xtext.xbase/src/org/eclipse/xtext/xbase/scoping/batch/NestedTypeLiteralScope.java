/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.common.collect.Lists;

/**
 * A scope that returns nested types.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NestedTypeLiteralScope extends AbstractSessionBasedScope {

	private final JvmType rawEnclosingType;
	private final LightweightTypeReference enclosingType;

	public NestedTypeLiteralScope(IScope parent, IFeatureScopeSession session, XAbstractFeatureCall featureCall, LightweightTypeReference enclosingType, JvmType rawEnclosingType) {
		super(parent, session, featureCall);
		this.rawEnclosingType = rawEnclosingType;
		this.enclosingType = enclosingType;
	}

	@Override
	protected List<IEObjectDescription> getLocalElementsByName(QualifiedName name) {
		XAbstractFeatureCall featureCall = getFeatureCall();
		if (featureCall.isExplicitOperationCallOrBuilderSyntax())
			return Collections.emptyList();
		if (rawEnclosingType instanceof JvmDeclaredType && name.getSegmentCount() == 1) {
			String singleSegment = name.getFirstSegment();
			List<String> lookup = Collections.singletonList(singleSegment);
			if (singleSegment.indexOf('$') != -1) {
				lookup = Strings.split(singleSegment, '$');
			}
			JvmType result = findNestedType((JvmDeclaredType)rawEnclosingType, lookup.iterator());
			if (result != null) {
				IEObjectDescription description = EObjectDescription.create(name, result);
				return Collections.<IEObjectDescription>singletonList(new TypeLiteralDescription(description, enclosingType, isVisible(result)));
			}
		}
		return Collections.emptyList();
	}
	
	protected JvmType findNestedType(JvmDeclaredType outerType, Iterator<String> iterator) {
		String current = iterator.next();
		for(JvmMember member: outerType.getMembers()) {
			if (member instanceof JvmDeclaredType && member.getSimpleName().equals(current)) {
				if (iterator.hasNext()) {
					return findNestedType((JvmDeclaredType) member, iterator);
				}
				return (JvmDeclaredType) member;
			}
		}
		return null;
	}

	protected boolean isVisible(JvmType type) {
		if (type instanceof JvmMember)
			return getSession().isVisible((JvmMember) type);
		return true; // primitives et. al
	}

	@Override
	protected List<IEObjectDescription> getAllLocalElements() {
		List<IEObjectDescription> result = Lists.newArrayListWithExpectedSize(2);
		if (rawEnclosingType instanceof JvmDeclaredType) {
			for(JvmMember member: ((JvmDeclaredType) rawEnclosingType).getMembers()) {
				if (member instanceof JvmDeclaredType) {
					IEObjectDescription description = EObjectDescription.create(member.getSimpleName(), member);
					addToList(new TypeLiteralDescription(description, enclosingType, isVisible((JvmType) member)), result);
				}
			}
		}
		return result;
	}

}
