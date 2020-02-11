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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.typesystem.util.IVisibilityHelper;

import com.google.common.collect.Lists;

/**
 * A constructor scope that is based on type scopes and that is capable of checking
 * the visibility of the scope contents according to the given strategy.
 * 
 * It's intended usage is the type resolution and serialization of expressions.
 * That means, the following methods will throw an {@link UnsupportedOperationException}:
 * <ul>
 * 	<li>{@link #getAllElements()}</li>
 * 	<li>{@link #getSingleElement(QualifiedName)}</li>
 * 	<li>{@link #getSingleElement(EObject)}</li>
 * </ul> 
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ConstructorTypeScopeWrapper implements IScope {
	private final EObject context;
	private final IVisibilityHelper visibilityHelper;
	private final IScope typeScope;
	private final boolean strict;

	public ConstructorTypeScopeWrapper(EObject context, IVisibilityHelper visibilityHelper, IScope typeScope) {
		this(context, visibilityHelper, typeScope, false);
	}
	
	public ConstructorTypeScopeWrapper(EObject context, IVisibilityHelper visibilityHelper, IScope typeScope, boolean strict) {
		this.context = context;
		this.visibilityHelper = visibilityHelper;
		this.typeScope = typeScope;
		this.strict = strict;
	}

	/**
	 * @throws UnsupportedOperationException always
	 */
	@Override
	public Iterable<IEObjectDescription> getAllElements() {
		throw new UnsupportedOperationException();
	}

	protected Iterable<IEObjectDescription> createFeatureDescriptions(Iterable<IEObjectDescription> original) {
		List<IEObjectDescription> result = Lists.newArrayListWithCapacity(3);
		for(IEObjectDescription description: original) {
			addFeatureDescriptions(description, result);
		}
		return result;
	}

	protected void addFeatureDescriptions(IEObjectDescription typeDescription, List<IEObjectDescription> result) {
		EObject proxy = getResolvedProxy(typeDescription);
		if (!proxy.eIsProxy() && proxy instanceof JvmGenericType) {
			JvmGenericType type = (JvmGenericType) proxy;
			if (!type.isInterface()) {
				for(JvmConstructor constructor: type.getDeclaredConstructors()) {
					boolean visible = visibilityHelper.isVisible(constructor);
					ConstructorDescription constructorDescription = createConstructorDescription(typeDescription, constructor, visible);
					result.add(constructorDescription);
				}
			} else if (!strict) {
				result.add(new SimpleIdentifiableElementDescription(typeDescription));
			}
		} else if (proxy instanceof JvmType) {
			if (!strict)
				result.add(new SimpleIdentifiableElementDescription(typeDescription));
		}
	}

	protected EObject getResolvedProxy(IEObjectDescription description) {
		EObject proxy = description.getEObjectOrProxy();
		if (proxy.eIsProxy()) {
			proxy = EcoreUtil.resolve(proxy, context);
		}
		return proxy;
	}

	@Override
	public Iterable<IEObjectDescription> getElements(EObject object) {
		if (!(object instanceof JvmConstructor)) {
			return Collections.emptyList();
		}
		JvmConstructor constructor = (JvmConstructor) object;
		Iterable<IEObjectDescription> typeDescriptions = typeScope.getElements(constructor.getDeclaringType());
		List<IEObjectDescription> result = Lists.newArrayListWithCapacity(3);
		boolean visible = visibilityHelper.isVisible(constructor);
		for(IEObjectDescription typeDescription: typeDescriptions) {
			ConstructorDescription constructorDescription = createConstructorDescription(typeDescription, constructor, visible);
			result.add(constructorDescription);
		}
		return result;
	}

	protected ConstructorDescription createConstructorDescription(IEObjectDescription typeDescription, JvmConstructor constructor, boolean visible) {
		ConstructorDescription constructorDescription = new ConstructorDescription(
				typeDescription.getName(), constructor, ConstructorScopes.CONSTRUCTOR_BUCKET, visible);
		return constructorDescription;
	}

	@Override
	public Iterable<IEObjectDescription> getElements(QualifiedName name) {
		Iterable<IEObjectDescription> original = typeScope.getElements(name);
		return createFeatureDescriptions(original);
	}

	/**
	 * @throws UnsupportedOperationException always
	 */
	@Override
	public IEObjectDescription getSingleElement(EObject object) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @throws UnsupportedOperationException always
	 */
	@Override
	public IEObjectDescription getSingleElement(QualifiedName name) {
		throw new UnsupportedOperationException();
	}
}