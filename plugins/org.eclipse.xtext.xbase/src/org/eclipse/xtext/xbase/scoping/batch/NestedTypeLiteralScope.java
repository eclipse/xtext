/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NestedTypeLiteralScope extends AbstractSessionBasedScope {

	private JvmType outerType;

	protected NestedTypeLiteralScope(IScope parent, IFeatureScopeSession session, XAbstractFeatureCall featureCall, JvmType outerType) {
		super(parent, session, featureCall);
		this.outerType = outerType;
	}

	@Override
	protected Collection<IEObjectDescription> getLocalElementsByName(QualifiedName name) {
		XAbstractFeatureCall featureCall = getFeatureCall();
		if (featureCall.isExplicitOperationCallOrBuilderSyntax())
			return Collections.emptyList();
		if (outerType instanceof JvmDeclaredType && name.getSegmentCount() == 1) {
			List<JvmMember> members = ((JvmDeclaredType) outerType).getMembers();
			String singleSegment = name.getFirstSegment();
			for(JvmMember member: members) {
				if (member instanceof JvmType && member.getSimpleName().equals(singleSegment)) {
					IEObjectDescription description = EObjectDescription.create(name, member);
					return Collections.<IEObjectDescription>singletonList(new TypeLiteralDescription(description, isVisible((JvmType) member)));
				}
			}
		}
		return Collections.emptyList();
	}
	
	protected boolean isVisible(JvmType type) {
		if (type instanceof JvmMember)
			return getSession().isVisible((JvmMember) type);
		return true; // primitives et. al
	}

	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		return Collections.emptyList();
	}

}
