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

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XFeatureCall;

import com.google.common.collect.Iterables;
import com.google.inject.Provider;

/**
 * A scope for the local variables that have been registered in the given session.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LocalVariableScope extends AbstractSessionBasedScope {
	
	public LocalVariableScope(IScope parent, IFeatureScopeSession session, XAbstractFeatureCall featureCall) {
		super(parent, session, featureCall);
	}
	
	@Override
	protected List<IEObjectDescription> getAllLocalElements() {
		return getSession().getLocalElements();
	}
	
	@Override
	public IEObjectDescription getSingleElement(QualifiedName name) {
		IEObjectDescription localElement = getSession().getLocalElement(name);
		if (localElement != null)
			return localElement;
		return super.getSingleElement(name);
	}
	
	@Override
	protected List<IEObjectDescription> getLocalElementsByName(QualifiedName name) {
		if (!canBeLocalVariable())
			return Collections.emptyList();
		IEObjectDescription element = getSession().getLocalElement(name);
		if (element == null)
			return Collections.emptyList();
		return Collections.singletonList(element);
	}

	protected boolean canBeLocalVariable() {
		XAbstractFeatureCall featureCall = getFeatureCall();
		if (featureCall != null) {
			return looksLikeLocalVariable(featureCall) || featureCall instanceof XAssignment;
		}
		return true;
	}
	
	protected boolean looksLikeLocalVariable(XAbstractFeatureCall featureCall) {
		if (featureCall instanceof XFeatureCall) {
			boolean result = !featureCall.isExplicitOperationCallOrBuilderSyntax() && featureCall.getTypeArguments().isEmpty();
			return result;
		}
		return false;
	}
	
	/**
	 * @param localElements subclasses may use that. 
	 */
	protected boolean looksLikeLocalVariable(XAbstractFeatureCall featureCall, List<IEObjectDescription> localElements) {
		return looksLikeLocalVariable(featureCall);
	}
	
	@Override
	public Iterable<IEObjectDescription> getElements(final QualifiedName name) {
		List<IEObjectDescription> localElements = getLocalElementsByName(name);
		if (localElements.isEmpty())
			return getParent().getElements(name);
		if (looksLikeLocalVariable(getFeatureCall(), localElements)) {
			return localElements;
		}
		Iterable<IEObjectDescription> parentElements = getParentElements(new Provider<Iterable<IEObjectDescription>>() {
			@Override
			public Iterable<IEObjectDescription> get() {
				return getParent().getElements(name);
			}
		});
		// TODO evaluate optimizing this by avoiding the concat thing and doing something smarter than the ParentIterable 
		Iterable<IEObjectDescription> result = Iterables.concat(localElements, parentElements);
		return result;
	}
	
	@Override
	protected boolean isShadowed(IEObjectDescription fromParent) {
		if (getShadowingKey(fromParent).equals(fromParent.getName().toString())) {
			boolean result = getSession().getLocalElement(fromParent.getName()) != null;
			return result;
		}
		return false;
	}

}
