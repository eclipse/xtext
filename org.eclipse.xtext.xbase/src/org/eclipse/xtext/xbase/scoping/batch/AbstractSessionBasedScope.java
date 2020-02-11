/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.Collection;
import java.util.List;
import java.util.Locale;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScope;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedFeatures;
import org.eclipse.xtext.xbase.util.PropertyUtil;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Provider;

/**
 * Abstract scope implementation that is based on an {@link IFeatureScopeSession}.
 * The scope can only handle {@link XAbstractFeatureCall#getFeature() feature} references.
 * It does not support case insensitivity.
 * 
 * Clients may extend concrete subtypes and adjust the name processing or apply general
 * filtering by overriding {@link #addToList(IEObjectDescription, List)} or {@link #addToList(List, List)}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractSessionBasedScope extends AbstractScope {

	protected interface NameAcceptor {
		// TODO implementations may consider the order indicator to implement proper shadowing
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
	
	@Override
	protected abstract List<IEObjectDescription> getAllLocalElements();
	
	protected IFeatureScopeSession getSession() {
		return session;
	}
	
	protected XAbstractFeatureCall getFeatureCall() {
		return featureCall;
	}
	
	protected void processFeatureNames(QualifiedName name, NameAcceptor acceptor) {
		acceptor.accept(name.toString(), 1);
	}
	
	protected List<JvmFeature> findAllFeaturesByName(JvmType type, String simpleName, IResolvedFeatures.Provider resolvedFeaturesProvider) {
		IResolvedFeatures resolvedFeatures = resolvedFeaturesProvider.getResolvedFeatures(type);
		return resolvedFeatures.getAllFeatures(simpleName);
	}
	
	/**
	 * Considers the given name to be a property name. If the concrete syntax of the
	 * processed feature matches a feature call or assignment, a prefix is added to the
	 * name and that one is used as a variant that should be processed. 
	 */
	protected void processAsPropertyNames(QualifiedName name, NameAcceptor acceptor) {
		String nameAsPropertyName = tryGetAsPropertyName(name.toString());
		if (nameAsPropertyName != null) {
			if (featureCall == null || featureCall instanceof XAssignment) {
				String aliasedSetter = "set" + nameAsPropertyName;
				acceptor.accept(aliasedSetter, 2);
			}
			if (!(featureCall instanceof XAssignment)) {
				if (featureCall == null || !getFeatureCall().isExplicitOperationCallOrBuilderSyntax()) {
					String aliasedGetter = "get" + nameAsPropertyName;
					acceptor.accept(aliasedGetter, 2);
					String aliasedBooleanGetter = "is" + nameAsPropertyName;
					acceptor.accept(aliasedBooleanGetter, 2);
				}
			}
		}
	}
	
	protected String toProperty(String methodName, JvmFeature feature) {
		return toProperty(methodName, feature, 0, 1);
	}
	
	protected String toProperty(String methodName, JvmFeature feature, int getterParams, int setterParams) {
		return PropertyUtil.getPropertyName(feature, methodName, getterParams, setterParams);
	}
	
	/**
	 * Returns the name as a property name, e.g. a prefix {@code get}, {@code is} or {@code set}
	 * can be used with the result of this method.
	 * If the given name is invalid, the result is <code>null</code>.
	 */
	/* @Nullable */
	protected String tryGetAsPropertyName(String name) {
		if (name.length() == 1) { // e.g. Point.getX()
			if (Character.isUpperCase(name.charAt(0))) {
				// X is not a valid sugar for getX()
				return null;
			}
			// x is a valid sugar for getX
			return name.toUpperCase(Locale.ENGLISH);
		} else if (name.length() > 1) {
			if (Character.isUpperCase(name.charAt(1))) { // e.g. Resource.getURI
				// if second char is uppercase, the name itself is the sugar variant
				// URI is the property name for getURI
				if (Character.isUpperCase(name.charAt(0))) {
					return name;
				}
				// if the first character is not upper case, it's not a valid sugar variant
				// e.g. uRI is no sugar access for getURI
				return null;
			} else if (Character.isUpperCase(name.charAt(0))) {
				// the first character is upper case, it is not valid property sugar, e.g.
				// Class.CanonicalName does not map to Class.getCanonicalName
				return null;
			} else {
				// code from java.beans.NameGenerator.capitalize()
				return name.substring(0, 1).toUpperCase(Locale.ENGLISH) + name.substring(1);
			}
		}
		// length 0 is invalid
		return null;
	}

	/**
	 * Clients may override to reject certain descriptions from the result. All subtypes of {@link AbstractSessionBasedScope}
	 * in the framework code will delegate to this method to accumulate descriptions in a list.
	 * 
	 * @see #addToList(List, List)
	 */
	protected void addToList(IEObjectDescription description, List<IEObjectDescription> result) {
		result.add(description);
	}
	
	/**
	 * Clients may override to reject certain descriptions from the result. All subtypes of {@link AbstractSessionBasedScope}
	 * in the framework code will delegate to this method to accumulate descriptions in a list.
	 * 
	 * @see #addToList(IEObjectDescription, List)
	 */
	protected void addToList(List<IEObjectDescription> descriptions, List<IEObjectDescription> result) {
		result.addAll(descriptions);
	}
	
	@Override
	protected abstract List<IEObjectDescription> getLocalElementsByName(QualifiedName name);
	
	@Override
	public Iterable<IEObjectDescription> getElements(final QualifiedName name) {
		Collection<IEObjectDescription> localElements = getLocalElementsByName(name);
		if (localElements.isEmpty())
			return getParent().getElements(name);
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
	protected Iterable<IEObjectDescription> getLocalElementsByEObject(final EObject object, final URI uri) {
		Iterable<IEObjectDescription> localElements = getAllLocalElements();
		Iterable<IEObjectDescription> result = Iterables.filter(localElements, new Predicate<IEObjectDescription>() {
			@Override
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
