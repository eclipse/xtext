/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.binary.asm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.impl.JvmTypeConstraintImplCustom;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Proxies {

	protected static final String JAVA_LANG_OBJECT = "java/lang/Object";
	
	protected final Map<BinaryTypeSignature, JvmType> typeProxies = new HashMap<BinaryTypeSignature, JvmType>();

	protected final Map<BinarySimpleMemberSignature, JvmOperation> operationProxies = new HashMap<BinarySimpleMemberSignature, JvmOperation>();
	
	protected JvmOperation createMethodProxy(BinaryTypeSignature type, String methodName) {
		BinarySimpleMemberSignature method = type.appendMethod(methodName);
		JvmOperation proxy = operationProxies.get(method);
		if (proxy == null) {
			proxy = TypesFactory.eINSTANCE.createJvmOperation();
			URI uri = method.getURI();
			((InternalEObject) proxy).eSetProxyURI(uri);
			operationProxies.put(method, proxy);
		}
		return proxy;
	}
	
	public JvmTypeReference createTypeReference(BinaryTypeSignature type,
			Map<String, JvmTypeParameter> typeParameters) {
		int arrayCount = type.getArrayDimensions();
		if (arrayCount > 0) {
			BinaryTypeSignature elementType = type.getArrayComponentType();
			JvmTypeReference result = createTypeReference(elementType, typeParameters);
			for (int i = 0; i < arrayCount; i++) {
				JvmGenericArrayTypeReference array = TypesFactory.eINSTANCE.createJvmGenericArrayTypeReference();
				array.setComponentType(result);
				result = array;
			}
			return result;
		}
		List<BinaryTypeArgumentSignature> typeArguments = type.getTypeArguments();
		if (typeArguments.size() == 0) {
			JvmParameterizedTypeReference result = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
			result.setType(createProxy(type.getTypeErasure(), typeParameters));
			return result;
		} else {
			JvmParameterizedTypeReference result = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
			result.setType(createProxy(type.getTypeErasure(), typeParameters));
			InternalEList<JvmTypeReference> arguments = (InternalEList<JvmTypeReference>) result.getArguments();
			for (int i = 0; i < typeArguments.size(); i++) {
				JvmTypeReference argument = createTypeArgument(typeArguments.get(i), typeParameters);
				arguments.addUnique(argument);
			}
			return result;
		}
	}

	public JvmTypeReference createTypeArgument(BinaryTypeArgumentSignature actualTypeArgument,
			Map<String, JvmTypeParameter> typeParameters) {
		if (actualTypeArgument.isWildcard()) {
			JvmWildcardTypeReference result = TypesFactory.eINSTANCE.createJvmWildcardTypeReference();
			InternalEList<JvmTypeConstraint> constraints = (InternalEList<JvmTypeConstraint>) result.getConstraints();
			BinaryGenericTypeSignature upperBound = actualTypeArgument.getUpperBound();
			if (upperBound != null) {
				JvmUpperBound jvmUpperBound = TypesFactory.eINSTANCE.createJvmUpperBound();
				JvmTypeReference upperBoundType = createTypeReference(upperBound, typeParameters);
				((JvmTypeConstraintImplCustom) jvmUpperBound).internalSetTypeReference(upperBoundType);
				constraints.addUnique(jvmUpperBound);
			} else {
				JvmUpperBound jvmUpperBound = TypesFactory.eINSTANCE.createJvmUpperBound();
				// TODO this might be bogus due to constrained type information on the declarator
				((JvmTypeConstraintImplCustom) jvmUpperBound).internalSetTypeReference(createObjectTypeReference());
				constraints.addUnique(jvmUpperBound);
			}
			BinaryGenericTypeSignature lowerBound = actualTypeArgument.getLowerBound();
			if (lowerBound != null) {
				JvmLowerBound jvmLowerBound = TypesFactory.eINSTANCE.createJvmLowerBound();
				JvmTypeReference boundType = createTypeReference(lowerBound, typeParameters);
				((JvmTypeConstraintImplCustom) jvmLowerBound).internalSetTypeReference(boundType);
				constraints.addUnique(jvmLowerBound);
			}
			return result;
		} else {
			return createTypeReference(actualTypeArgument, typeParameters);
		}
	}
	
	public JvmTypeReference createObjectTypeReference() {
		return createTypeReference(BinarySignatures.createTypeSignature(JAVA_LANG_OBJECT), null);
	}

	public JvmType createProxy(BinaryTypeSignature type, Map<String, JvmTypeParameter> typeParameters) {
		String variableName = type.getTypeVariableName();
		if (variableName != null) {
			if (typeParameters == null) {
				throw new IllegalStateException(type.toString());
			}
			JvmType result = typeParameters.get(variableName);
			if (result == null) {
				throw new IllegalStateException(type.toString());
			}
			return result;
		}
		JvmType proxy = typeProxies.get(type);
		if (proxy == null) {
			proxy = TypesFactory.eINSTANCE.createJvmVoid();
			URI uri = type.getURI();
			((InternalEObject) proxy).eSetProxyURI(uri);
			typeProxies.put(type, proxy);
		}
		return proxy;
	}
	
	 public JvmAnnotationType createAnnotationProxy(BinaryTypeSignature type) {
			JvmType proxy = typeProxies.get(type);
			if (proxy == null) {
				JvmAnnotationType result = TypesFactory.eINSTANCE.createJvmAnnotationType();
				URI uri = type.getURI();
				((InternalEObject) result).eSetProxyURI(uri);
				typeProxies.put(type, result);
				return result;
			} else if (proxy.eClass() != TypesPackage.Literals.JVM_ANNOTATION_TYPE) {
				JvmAnnotationType result = TypesFactory.eINSTANCE.createJvmAnnotationType();
				((InternalEObject) result).eSetProxyURI(((InternalEObject) proxy).eProxyURI());
				typeProxies.put(type, result);
				return result;
			}
			return (JvmAnnotationType) proxy;
		}
}
