/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.override;

import java.util.List;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.typesystem.override.IOverrideCheckResult.OverrideCheckDetails;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.IVisibilityHelper;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;

import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * The implemented algorithm pretty much mirrors the one from
 * class <code>org.eclipse.jdt.internal.corext.util.MethodOverrideTester</code>.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class OverrideTester {

	@Inject
	private IVisibilityHelper visibilityHelper;
	
	public IOverrideCheckResult isSubsignature(AbstractResolvedOperation overriding, JvmOperation overridden, boolean checkInheritance) {
		JvmOperation declaration = overriding.getDeclaration();
		if (declaration == overridden) {
			return new StandardOverrideCheckResult(overriding, overridden, OverrideCheckDetails.CURRENT);
		}
		if (overridden.getDeclaringType() == declaration.getDeclaringType()) {
			return new StandardOverrideCheckResult(overriding, overridden, OverrideCheckDetails.SAME_DECLARATOR);
		}
		if (checkInheritance) {
			// here we use the raw types intentionally
			ParameterizedTypeReference currentDeclarator = new ParameterizedTypeReference(overriding.getContextType().getOwner(), declaration.getDeclaringType());
			if (!currentDeclarator.isSubtypeOf(overridden.getDeclaringType())) {
				return new StandardOverrideCheckResult(overriding, overridden, OverrideCheckDetails.NO_INHERITANCE);	
			}
		}
		if (!Strings.equal(overridden.getSimpleName(), declaration.getSimpleName())) {
			return new StandardOverrideCheckResult(overriding, overridden, OverrideCheckDetails.NAME_MISMATCH);
		}
		int parameterCount = overridden.getParameters().size();
		if (parameterCount != declaration.getParameters().size()) {
			return new StandardOverrideCheckResult(overriding, overridden, OverrideCheckDetails.ARITY_MISMATCH);
		}
		AbstractResolvedOperation overriddenInHierarchy = new ResolvedOperationInHierarchy(overridden, overriding.getBottom());
		if (parameterCount != 0 && !isMatchingParameterList(overriding, overriddenInHierarchy)) {
			return new LazyOverrideCheckResult(overriding, overridden, OverrideCheckDetails.PARAMETER_TYPE_MISMATCH);
		}			
		if (!isMatchingTypeParameters(overriding, overriddenInHierarchy))
			return new LazyOverrideCheckResult(overriding, overridden, OverrideCheckDetails.TYPE_PARAMETER_MISMATCH);
		return new LazyOverrideCheckResult(overriding, overridden, getPrimaryValidDetail(overriding, overridden));
	}
	
	protected boolean isMatchingParameterList(AbstractResolvedOperation overriding,
			AbstractResolvedOperation overridden) {
		List<LightweightTypeReference> overridingParameterTypes = overriding.getParameterTypes();
		List<LightweightTypeReference> overriddenParameterTypes = overridden.getParameterTypes();
		for(int i = 0; i < overridingParameterTypes.size(); i++) {
			LightweightTypeReference overridingParameterType = overridingParameterTypes.get(i);
			LightweightTypeReference overriddenParameterType = overriddenParameterTypes.get(i);
			String overridingParameterTypeIdentifier = overridingParameterType.getIdentifier();
			if (!overridingParameterTypeIdentifier.equals(overriddenParameterType.getIdentifier())) {
				LightweightTypeReference erasureType = overriddenParameterType.getRawTypeReference();
				if (!overridingParameterTypeIdentifier.equals(erasureType.getIdentifier())) {
					return false;
				}
			}
		}
		return true;
	}
	
	protected boolean isMatchingTypeParameters(AbstractResolvedOperation overriding, AbstractResolvedOperation overridden) {
		int overridingTypeParameterCount = overriding.getTypeParameters().size();
		if (overridingTypeParameterCount != overridden.getTypeParameters().size()) {
			return overridingTypeParameterCount == 0;
		}
		TypeParameterSubstitutor<?> substitutor = overridden.getSubstitutor();
		ITypeReferenceOwner owner = overriding.getContextType().getOwner();
		for(int i = 0; i < overridingTypeParameterCount; i++) {
			JvmTypeParameter overridingTypeParameter = overriding.getTypeParameters().get(i);
			JvmTypeParameter overriddenTypeParameter = overridden.getTypeParameters().get(i);
			List<LightweightTypeReference> overridingSuperTypes = new ParameterizedTypeReference(owner, overridingTypeParameter).getSuperTypes();
			List<LightweightTypeReference> overriddenSuperTypes = new ParameterizedTypeReference(owner, overriddenTypeParameter).getSuperTypes();
			if (overridingSuperTypes.size() != overriddenSuperTypes.size()) {
				return false;
			}
			if (overridingSuperTypes.size() == 1) {
				LightweightTypeReference resolved = substitutor.substitute(overriddenSuperTypes.get(0));
				if (!overridingSuperTypes.get(0).getIdentifier().equals(resolved.getIdentifier())) {
					return false;
				}
			} else {
				Set<String> overridingSuperTypeNames = Sets.newHashSet();
				for(LightweightTypeReference overridingSuperType: overridingSuperTypes) {
					overridingSuperTypeNames.add(overridingSuperType.getIdentifier());
				}
				for(LightweightTypeReference overriddenSuperType: overriddenSuperTypes) {
					LightweightTypeReference resolved = substitutor.substitute(overriddenSuperType);
					if (!overridingSuperTypeNames.contains(resolved.getIdentifier())) {
						return false;
					}
				}
			}
		}
		return true;
	}

	protected OverrideCheckDetails getPrimaryValidDetail(IResolvedOperation overriding, JvmOperation overridden) {
		OverrideCheckDetails result = OverrideCheckDetails.IMPLEMENTATION;
		JvmOperation declaration = overriding.getDeclaration();
		if (declaration.isAbstract()) {
			if (overridden.isAbstract()) {
				result = OverrideCheckDetails.REPEATED;
			} else {
				result = OverrideCheckDetails.REDECLARATION;
			}
		} else {
			if (!overridden.isAbstract()) {
				result = OverrideCheckDetails.OVERRIDE;
			}
		}
		return result;
	}
//	
//	class A {
//		<T extends CharSequence> void m(Iterable<String> i) {}
//		void m2() throws IOException {}
//	}
//	class B extends A {
//		@Override
//		void m(Iterable<String> i) {}
//		@Override
//		void m2() throws FileNotFoundException, RuntimeException, OutOfMemoryError, Throwable {}
//	}
//	
//	class A2 {
//		<T extends CharSequence> void m(Iterable<T> i) {}
//		<T extends CharSequence> void m2(Iterable<T> i) {}
//	}
//	class B2<V extends CharSequence> extends A2 {
//		<T extends CharSequence> void m(Iterable<CharSequence> i) {}
//		 void m2(Iterable<V> i) {}
//	}
//	class A3 {
//		<T extends CharSequence> void m(T t2, T t) {
//		}
//	}
//
//	class B2 extends A3 {
//		@Override
//		void m(CharSequence t1, CharSequence t2) {
//		}
//	}
//	protected EnumSet<OverrideCheckDetails> getProblems(EnumSet<OverrideCheckDetails> initial, IResolvedOperation overriding, JvmOperation overridden) {
//		if (overridden.isFinal()) {
//			initial.add(OverrideCheckDetails.IS_FINAL);
//		}
//	}
//	class A5 {
//        <T extends CharSequence> void m() {
//        }
//        <T extends Comparable<T>> void m2() {}
//        <T extends Object & CharSequence & Cloneable> void m3() {
//        }
//    }
//
//        class B5<Y> extends A5 {
//            @Override
//            <T1 extends CharSequence> void m() {
//            }
//            @Override
//            <T1 extends Comparable<T1>> void m2() {}
//            @Override
//            <T extends Object & Cloneable & CharSequence> void m3() {
//            }
//        }
}
