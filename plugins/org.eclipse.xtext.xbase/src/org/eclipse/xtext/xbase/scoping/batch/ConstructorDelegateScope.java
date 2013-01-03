/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ConstructorDelegateScope extends AbstractSessionBasedScope implements IFeatureNames {
	
	public ConstructorDelegateScope(IScope parent, IFeatureScopeSession session, XAbstractFeatureCall featureCall) {
		super(parent, session, featureCall);
	}
	
	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	protected Collection<IEObjectDescription> getLocalElementsByName(QualifiedName name) {
		if (THIS.equals(name) || SUPER.equals(name)) {
			IEObjectDescription description = getSession().getLocalElement(name);
			if (description != null) {
				EObject objectOrProxy = description.getEObjectOrProxy();
				if (objectOrProxy instanceof JvmGenericType && !objectOrProxy.eIsProxy()) {
					return createConstructorDescriptions(name, (JvmGenericType) objectOrProxy);
				}
			}
		}
		return Collections.emptyList();
	}
	
	protected Collection<IEObjectDescription> createConstructorDescriptions(QualifiedName name, JvmGenericType type) {
		Iterable<JvmConstructor> constructors = type.getDeclaredConstructors();
		List<IEObjectDescription> result = Lists.newArrayListWithCapacity(3);
		for(JvmConstructor constructor: constructors) {
			result.add(createDescription(name, constructor));
		}
		return result;
	}

	protected IEObjectDescription createDescription(QualifiedName name, JvmConstructor constructor) {
		return new ConstructorDescription(name, constructor, 0, getSession().isVisible(constructor));
	}

}
