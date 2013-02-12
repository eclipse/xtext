/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;

import com.google.common.collect.Lists;

/**
 * Encapsulates the creation of constructor scopes.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ConstructorScopes extends DelegatingScopes {

	public static final int CONSTRUCTOR_BUCKET = 1;
	
	/**
	 * Creates the constructor scope for {@link XConstructorCall}.
	 * The scope will likely contain descriptions for {@link JvmConstructor constructors}.
	 * If there is not constructor declared, it may contain {@link JvmType types}.
	 * 
	 * @param session the currently available session data
	 * @param reference the reference that will hold the resolved constructor
	 * @param resolvedTypes the currently known resolved types
	 */
	public IScope createConstructorScope(EObject context, EReference reference, IFeatureScopeSession session, IResolvedTypes resolvedTypes) {
		if (!(context instanceof XConstructorCall)) {
			return IScope.NULLSCOPE;
		}
		IScope result = doCreateConstructorScope(context, session);
		return result;
	}
	
	protected IScope doCreateConstructorScope(final EObject context, final IFeatureScopeSession session) {
		/*
		 * We use a type scope here in order to provide better feedback for users,
		 * e.g. if the constructor call refers to an interface or a primitive.
		 */
		final IScope delegateScope = getDelegate().getScope(context, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
		return new IScope() {

			public Iterable<IEObjectDescription> getAllElements() {
				throw new UnsupportedOperationException();
			}

			protected Iterable<IEObjectDescription> createFeatureDescriptions(Iterable<IEObjectDescription> original) {
				List<IEObjectDescription> result = Lists.newArrayListWithCapacity(3);
				for(IEObjectDescription description: original) {
					EObject proxy = description.getEObjectOrProxy();
					if (proxy.eIsProxy()) {
						proxy = EcoreUtil.resolve(proxy, context);
					}
					if (!proxy.eIsProxy() && proxy instanceof JvmGenericType) {
						JvmGenericType type = (JvmGenericType) proxy;
						if (!type.isInterface()) {
							for(JvmConstructor constructor: type.getDeclaredConstructors()) {
								boolean visible = session.isVisible(constructor);
								ConstructorDescription constructorDescription = new ConstructorDescription(
										description.getName(), constructor, CONSTRUCTOR_BUCKET, visible);
								result.add(constructorDescription);
							}
						} else {
							result.add(new SimpleIdentifiableElementDescription(description));
						}
					} else if (proxy instanceof JvmType) {
						result.add(new SimpleIdentifiableElementDescription(description));
					}
				}
				return result;
			}

			public Iterable<IEObjectDescription> getElements(EObject object) {
				throw new UnsupportedOperationException();
			}

			public Iterable<IEObjectDescription> getElements(QualifiedName name) {
				Iterable<IEObjectDescription> original = delegateScope.getElements(name);
				return createFeatureDescriptions(original);
			}

			public IEObjectDescription getSingleElement(EObject object) {
				throw new UnsupportedOperationException();
			}

			public IEObjectDescription getSingleElement(QualifiedName name) {
				throw new UnsupportedOperationException();
			}

		};
	}
	
	public boolean isConstructorCallScope(EReference reference) {
		return reference == XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR;
	}
	
}
