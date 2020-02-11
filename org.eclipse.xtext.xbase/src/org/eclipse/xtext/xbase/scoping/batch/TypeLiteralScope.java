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
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.AliasedEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;

/**
 * A scope that returns types, e.g. for member feature calls that are actually type references like
 * {@code java.lang.String}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeLiteralScope extends AbstractSessionBasedScope {

	private final QualifiedName parentSegments;
	private final IResolvedTypes resolvedTypes;

	public TypeLiteralScope(IScope parent, IFeatureScopeSession session, XAbstractFeatureCall featureCall, IResolvedTypes resolvedTypes, QualifiedName parentSegments) {
		super(parent, session, featureCall);
		this.resolvedTypes = resolvedTypes;
		this.parentSegments = parentSegments;
	}

	@Override
	protected List<IEObjectDescription> getLocalElementsByName(QualifiedName name) {
		XAbstractFeatureCall featureCall = getFeatureCall();
		if (featureCall.isExplicitOperationCallOrBuilderSyntax())
			return Collections.emptyList();
		QualifiedName fqn = parentSegments.append(name);
		IScope typeScope = getSession().getScope(getFeatureCall(), TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, resolvedTypes);
		IEObjectDescription typeDescription = typeScope.getSingleElement(fqn);
		if (typeDescription != null) {
			EObject type = typeDescription.getEObjectOrProxy();
			if (type instanceof JvmType)
				return Collections.<IEObjectDescription>singletonList(new TypeLiteralDescription(
						new AliasedEObjectDescription(name, typeDescription), isVisible((JvmType) type)));
		}
		return Collections.emptyList();
	}
	
	@Override
	protected boolean isShadowed(IEObjectDescription fromParent) {
		if (fromParent.getName() == null)
			return true;
		return super.isShadowed(fromParent);
	}

	protected boolean isVisible(JvmType type) {
		if (type instanceof JvmMember)
			return getSession().isVisible((JvmMember) type);
		return true; // primitives et. al
	}

	@Override
	protected List<IEObjectDescription> getAllLocalElements() {
		return Collections.emptyList();
	}

}
