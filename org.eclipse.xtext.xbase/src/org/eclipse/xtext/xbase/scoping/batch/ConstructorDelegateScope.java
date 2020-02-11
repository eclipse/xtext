/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;

import com.google.common.collect.Lists;

/**
 * A constructor delegate scope provides the descriptions for {@code this()} and {@code super()}
 * calls in a constructor body.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ConstructorDelegateScope extends AbstractSessionBasedScope implements IFeatureNames {
	
	private Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> receiverTypeParameterMapping;
	private LightweightTypeReference contextType;
	
	public ConstructorDelegateScope(IScope parent, LightweightTypeReference contextType, IFeatureScopeSession session, XAbstractFeatureCall featureCall) {
		super(parent, session, featureCall);
		this.contextType = contextType;
	}
	
	@Override
	protected List<IEObjectDescription> getAllLocalElements() {
		List<IEObjectDescription> result = Lists.newArrayList();
		addToList(getLocalElementsByName(THIS), result);
		addToList(getLocalElementsByName(SUPER), result);
		return result;
	}
	
	@Override
	protected List<IEObjectDescription> getLocalElementsByName(QualifiedName name) {
		if (THIS.equals(name) || SUPER.equals(name)) {
			IEObjectDescription description = getSession().getLocalElement(name);
			if (description != null) {
				EObject objectOrProxy = description.getEObjectOrProxy();
				if (objectOrProxy instanceof JvmGenericType && !objectOrProxy.eIsProxy()) {
					return createConstructorDescriptions(name, (JvmGenericType) objectOrProxy, SUPER.equals(name));
				}
			}
		}
		return Collections.emptyList();
	}
	
	protected Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getReceiverTypeParameterMapping() {
		if (receiverTypeParameterMapping == null) {
			receiverTypeParameterMapping = Collections.emptyMap();
			if (contextType != null) {
				receiverTypeParameterMapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(contextType);
			}
		}
		return receiverTypeParameterMapping;
	}
	
	protected List<IEObjectDescription> createConstructorDescriptions(QualifiedName name, JvmGenericType type, boolean superType) {
		Iterable<JvmConstructor> constructors = type.getDeclaredConstructors();
		List<IEObjectDescription> result = Lists.newArrayListWithCapacity(3);
		for(JvmConstructor constructor: constructors) {
			addToList(createDescription(name, constructor, superType), result);
		}
		return result;
	}

	protected IEObjectDescription createDescription(QualifiedName name, JvmConstructor constructor, boolean superType) {
		if (superType)
			return new SuperConstructorDescription(name, constructor, getReceiverTypeParameterMapping(), 0, getSession().isVisible(constructor));
		return new ConstructorDescription(name, constructor, 0, getSession().isVisible(constructor));
	}

}
