/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScope;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractSessionBasedScope extends AbstractScope {

	protected interface NameAcceptor {
		// TODO implementations should consider the order indicator in order to shadow properly
		// TODO define constants for the order indicator
		void accept(String simpleName, int order);
	}
	
	private final IFeatureScopeSession session;
	private final XAbstractFeatureCall featureCall;
	
	protected AbstractSessionBasedScope(IScope parent, IFeatureScopeSession session, XAbstractFeatureCall featureCall) {
		// ignore case feature linking is currently not supported
		super(parent, false);
		if (session == null)
			throw new IllegalArgumentException("session may not be null");
		this.session = session;
		this.featureCall = featureCall;
	}
	
	protected IFeatureScopeSession getSession() {
		return session;
	}
	
	protected XAbstractFeatureCall getFeatureCall() {
		return featureCall;
	}
	
	protected void processFeatureNames(QualifiedName name, NameAcceptor acceptor) {
		acceptor.accept(name.toString(), 1);
	}
	
	protected void processAsPropertyNames(QualifiedName name, NameAcceptor acceptor) {
		if (getFeatureCall() instanceof XAssignment) {
			String aliasedSetter = "set" + Strings.toFirstUpper(name.toString());
			acceptor.accept(aliasedSetter, 2);
		} else {
			String aliasedGetter = "get" + Strings.toFirstUpper(name.toString());
			acceptor.accept(aliasedGetter, 2);
			String aliasedBooleanGetter = "is" + Strings.toFirstUpper(name.toString());
			acceptor.accept(aliasedBooleanGetter, 2);
		}
	}
	
	@Override
	protected abstract Collection<IEObjectDescription> getLocalElementsByName(QualifiedName name);
	
	@Override
	public Iterable<IEObjectDescription> getElements(final QualifiedName name) {
		Collection<IEObjectDescription> localElements = getLocalElementsByName(name);
		if (localElements.isEmpty())
			return getParent().getElements(name);
		Iterable<IEObjectDescription> parentElements = getParentElements(new Provider<Iterable<IEObjectDescription>>() {
			public Iterable<IEObjectDescription> get() {
				return getParent().getElements(name);
			}
		});
		// TODO evaluate optimizing this by avoiding the concat thing and doing something smarter than the ParentIterable 
		Iterable<IEObjectDescription> result = Iterables.concat(localElements, parentElements);
		return result;
	}
	
	@Override
	protected Iterable<IEObjectDescription> getLocalElementsByEObject(final EObject object, final URI uri) {
		Iterable<IEObjectDescription> localElements = getAllLocalElements();
		Iterable<IEObjectDescription> result = Iterables.filter(localElements, new Predicate<IEObjectDescription>() {
			public boolean apply(IEObjectDescription input) {
				if (input.getEObjectOrProxy() == object)
					return canBeFoundByNameAndShadowingKey(input);
				if (uri.equals(input.getEObjectURI())) {
					return canBeFoundByNameAndShadowingKey(input);
				}
				return false;
			}
			
			public boolean canBeFoundByNameAndShadowingKey(IEObjectDescription input) {
				Iterable<IEObjectDescription> lookUp = getLocalElementsByName(input.getName());
				Object myShadowingKey = getShadowingKey(input);
				for(IEObjectDescription other: lookUp) {
					if (myShadowingKey.equals(getShadowingKey(other))) {
						if (other == input)
							return true;
						if (other.getEObjectOrProxy() == object)
							return true;
						if (uri.equals(other.getEObjectURI()))
							return true;
						return false;
					}
				}
				return false;
			}
		});
		return result;
	}
	
	protected String getShadowingKey(IEObjectDescription description) {
		if (description instanceof BucketedEObjectDescription) {
			return ((BucketedEObjectDescription) description).getShadowingKey();
		}
		return description.getName().toString();
	}
	
	@Override
	protected boolean isShadowed(IEObjectDescription fromParent) {
		Collection<IEObjectDescription> localElements = getLocalElementsByName(fromParent.getName());
		if (localElements.isEmpty())
			return false;
		Object shadowingKey = getShadowingKey(fromParent);
		for(IEObjectDescription local: localElements) {
			if (shadowingKey.equals(getShadowingKey(local))) {
				return true;
			}
		}
		return false;
	}

}
