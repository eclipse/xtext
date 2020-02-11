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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.util.IVisibilityHelper;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * Encapsulates the creation of constructor scopes.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ConstructorScopes {

	public static final int CONSTRUCTOR_BUCKET = 1;
	
	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;
	
	@Inject
	private TypeScopes typeScopes;
	
	/**
	 * Creates the constructor scope for {@link XConstructorCall}.
	 * The scope will likely contain descriptions for {@link JvmConstructor constructors}.
	 * If there is not constructor declared, it may contain {@link JvmType types}.
	 * 
	 * @param session the currently available visibilityHelper data
	 * @param reference the reference that will hold the resolved constructor
	 * @param resolvedTypes the currently known resolved types
	 */
	public IScope createConstructorScope(EObject context, EReference reference, IFeatureScopeSession session, IResolvedTypes resolvedTypes) {
		if (!(context instanceof XConstructorCall)) {
			return IScope.NULLSCOPE;
		}
		/*
		 * We use a type scope here in order to provide better feedback for users,
		 * e.g. if the constructor call refers to an interface or a primitive.
		 */
		final IScope delegateScope = typeScopes.createTypeScope(context, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, session, resolvedTypes);
		IScope result = new ConstructorTypeScopeWrapper(context, session, delegateScope);
		return result;
	}
	
	/**
	 * Custom languages that allow to infer anonymous classes may want to use this helper
	 * to access the constructors of those classes.
	 * @param session subtypes may override and use the given session.
	 */
	protected IScope createAnonymousClassConstructorScope(final JvmGenericType anonymousType, EObject context, final IFeatureScopeSession session) {
		// we don't care about the type scope since the type is well known here
		IVisibilityHelper protectedIsVisible = new IVisibilityHelper() {
			@Override
			public boolean isVisible(/* @NonNull */ JvmMember member) {
				return member.getVisibility() != JvmVisibility.PRIVATE;
			}
		};
		return new ConstructorTypeScopeWrapper(context, protectedIsVisible, IScope.NULLSCOPE) {
			@Override
			public Iterable<IEObjectDescription> getElements(EObject object) {
				throw new UnsupportedOperationException("TODO implement as necessary");
			}
			@Override
			public Iterable<IEObjectDescription> getElements(QualifiedName name) {
				JvmTypeReference superType = Iterables.getLast(anonymousType.getSuperTypes(), null);
				if (superType == null)
					return Collections.emptyList();
				JvmType type = superType.getType();
				if (type == null)
					return Collections.emptyList();
				QualifiedName typeName = qualifiedNameConverter.toQualifiedName(type.getQualifiedName('.'));
				if (typeName.getSegmentCount() > name.getSegmentCount()) {
					typeName = typeName.skipFirst(typeName.getSegmentCount() - name.getSegmentCount());
				}
				if (!typeName.equals(name)) {
					if (name.getSegmentCount() == 1 && name.getFirstSegment().indexOf('$') > 0) {
						QualifiedName splitted = QualifiedName.create(Strings.split(name.getFirstSegment(), '$'));
						typeName = qualifiedNameConverter.toQualifiedName(type.getQualifiedName('.'));
						if (typeName.getSegmentCount() > splitted.getSegmentCount()) {
							typeName = typeName.skipFirst(typeName.getSegmentCount() - splitted.getSegmentCount());
						}
						if (!typeName.equals(splitted)) {
							return Collections.emptyList();
						}
					} else {
						return Collections.emptyList();
					}
				}
				IEObjectDescription typeDescription = EObjectDescription.create(name, anonymousType);
				return createFeatureDescriptions(Collections.singletonList(typeDescription));
			}
			
			@Override
			protected ConstructorDescription createConstructorDescription(IEObjectDescription typeDescription, JvmConstructor constructor, boolean visible) {
				return createAnonmousClassConstructorDescription(typeDescription.getName(), constructor, visible);
			}
		};
	}
	
	protected ConstructorDescription createAnonmousClassConstructorDescription(QualifiedName name, JvmConstructor constructor, boolean visible) {
		ConstructorDescription result = new ConstructorDescription(name, constructor, ConstructorScopes.CONSTRUCTOR_BUCKET, visible, true);
		return result;
	}
	
	public boolean isConstructorCallScope(EReference reference) {
		return reference == XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR;
	}
	
}
