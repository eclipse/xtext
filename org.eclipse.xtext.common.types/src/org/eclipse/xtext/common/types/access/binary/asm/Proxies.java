/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.binary.asm;

import static org.objectweb.asm.Opcodes.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmBooleanAnnotationValue;
import org.eclipse.xtext.common.types.JvmByteAnnotationValue;
import org.eclipse.xtext.common.types.JvmCharAnnotationValue;
import org.eclipse.xtext.common.types.JvmDoubleAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmFloatAnnotationValue;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmInnerTypeReference;
import org.eclipse.xtext.common.types.JvmIntAnnotationValue;
import org.eclipse.xtext.common.types.JvmLongAnnotationValue;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmShortAnnotationValue;
import org.eclipse.xtext.common.types.JvmStringAnnotationValue;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeAnnotationValue;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.impl.JvmTypeConstraintImplCustom;
import org.objectweb.asm.Type;

import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class Proxies {

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
		BinaryTypeSignature outer = type.getOuter();
		JvmParameterizedTypeReference result = null;
		if (outer == null) {
			result = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
		} else {
			JvmParameterizedTypeReference outerReference = (JvmParameterizedTypeReference) createTypeReference(outer, typeParameters);
			result = TypesFactory.eINSTANCE.createJvmInnerTypeReference();
			((JvmInnerTypeReference) result).setOuter(outerReference);
		}
		result.setType(createProxy(type.getTypeErasure(), typeParameters));
		List<BinaryTypeArgumentSignature> typeArguments = type.getTypeArguments();
		if (typeArguments.size() == 0) {
			return result;
		} else {
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
		return createTypeReference(BinarySignatures.createObjectTypeSignature(JAVA_LANG_OBJECT), null);
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
	 
	 public JvmAnnotationValue createAnnotationValue(Object value) {
		Class<?> valueClass = value.getClass();
		if (valueClass == Byte.class) {
			JvmByteAnnotationValue result = TypesFactory.eINSTANCE.createJvmByteAnnotationValue();
			((InternalEList<Byte>) result.getValues()).addUnique((Byte) value);
			return result;
		}
		if (valueClass == Boolean.class) {
			JvmBooleanAnnotationValue result = TypesFactory.eINSTANCE.createJvmBooleanAnnotationValue();
			((InternalEList<Boolean>) result.getValues()).addUnique((Boolean) value);
			return result;
		}
		if (valueClass == Character.class) {
			JvmCharAnnotationValue result = TypesFactory.eINSTANCE.createJvmCharAnnotationValue();
			((InternalEList<Character>) result.getValues()).addUnique((Character) value);
			return result;
		}
		if (valueClass == Short.class) {
			JvmShortAnnotationValue result = TypesFactory.eINSTANCE.createJvmShortAnnotationValue();
			((InternalEList<Short>) result.getValues()).addUnique((Short) value);
			return result;
		}
		if (valueClass == Integer.class) {
			JvmIntAnnotationValue result = TypesFactory.eINSTANCE.createJvmIntAnnotationValue();
			((InternalEList<Integer>) result.getValues()).addUnique((Integer) value);
			return result;
		}
		if (valueClass == Long.class) {
			JvmLongAnnotationValue result = TypesFactory.eINSTANCE.createJvmLongAnnotationValue();
			((InternalEList<Long>) result.getValues()).addUnique((Long) value);
			return result;
		}
		if (valueClass == Float.class) {
			JvmFloatAnnotationValue result = TypesFactory.eINSTANCE.createJvmFloatAnnotationValue();
			((InternalEList<Float>) result.getValues()).addUnique((Float) value);
			return result;
		}
		if (valueClass == Double.class) {
			JvmDoubleAnnotationValue result = TypesFactory.eINSTANCE.createJvmDoubleAnnotationValue();
			((InternalEList<Double>) result.getValues()).addUnique((Double) value);
			return result;
		}
		if (valueClass == String.class) {
			JvmStringAnnotationValue result = TypesFactory.eINSTANCE.createJvmStringAnnotationValue();
			((InternalEList<String>) result.getValues()).addUnique((String) value);
			return result;
		}
		if (valueClass == Type.class) {
			JvmTypeAnnotationValue result = TypesFactory.eINSTANCE.createJvmTypeAnnotationValue();
			Type type = (Type) value;
			BinaryTypeSignature signature;
			if (type.getSort() == Type.OBJECT) {
				String typeName = type.getInternalName();
				signature = BinarySignatures.createObjectTypeSignature(typeName);
			} else {
				String typeName = type.getDescriptor();
				signature = BinarySignatures.createTypeSignature(typeName);
			}
			((InternalEList<JvmTypeReference>) result.getValues()).addUnique(createTypeReference(signature, null));
			return result;
		}
		String className = valueClass.getName();
		if (className.startsWith("[") && className.length() == 2) {
			switch (className.charAt(1)) {
				case 'Z': {
					JvmBooleanAnnotationValue result = TypesFactory.eINSTANCE.createJvmBooleanAnnotationValue();
					boolean[] booleanValues = (boolean[]) value;
					for (boolean b : booleanValues)
						((InternalEList<Boolean>) result.getValues()).addUnique(b);
					return result;
				}
				case 'C': {
					JvmCharAnnotationValue result = TypesFactory.eINSTANCE.createJvmCharAnnotationValue();
					char[] charValues = (char[]) value;
					for (char c : charValues)
						((InternalEList<Character>) result.getValues()).addUnique(c);
					return result;
				}
				case 'B': {
					JvmByteAnnotationValue result = TypesFactory.eINSTANCE.createJvmByteAnnotationValue();
					byte[] byteValues = (byte[]) value;
					for (byte b : byteValues)
						((InternalEList<Byte>) result.getValues()).addUnique(b);
					return result;
				}
				case 'S': {
					JvmShortAnnotationValue result = TypesFactory.eINSTANCE.createJvmShortAnnotationValue();
					short[] shortValues = (short[]) value;
					for (short s : shortValues)
						((InternalEList<Short>) result.getValues()).addUnique(s);
					return result;
				}
				case 'I': {
					JvmIntAnnotationValue result = TypesFactory.eINSTANCE.createJvmIntAnnotationValue();
					int[] intValues = (int[]) value;
					for (int i : intValues)
						((InternalEList<Integer>) result.getValues()).addUnique(i);
					return result;
				}
				case 'F': {
					JvmFloatAnnotationValue result = TypesFactory.eINSTANCE.createJvmFloatAnnotationValue();
					float[] floatValues = (float[]) value;
					for (float f : floatValues)
						((InternalEList<Float>) result.getValues()).addUnique(f);
					return result;
				}
				case 'J': {
					JvmLongAnnotationValue result = TypesFactory.eINSTANCE.createJvmLongAnnotationValue();
					long[] longValues = (long[]) value;
					for (long l : longValues)
						((InternalEList<Long>) result.getValues()).addUnique(l);
					return result;
				}
				case 'D': {
					JvmDoubleAnnotationValue result = TypesFactory.eINSTANCE.createJvmDoubleAnnotationValue();
					double[] doubleValues = (double[]) value;
					for (double d : doubleValues)
						((InternalEList<Double>) result.getValues()).addUnique(d);
					return result;
				}
			}
		}
		throw new IllegalArgumentException(String.valueOf(value));
	}
	
	public JvmEnumerationLiteral createEnumLiteral(String literalName, String typeName) {
		return createEnumLiteral(literalName, BinarySignatures.createObjectTypeSignature(typeName));
	}

	protected JvmEnumerationLiteral createEnumLiteral(String literalName, BinaryTypeSignature typeName) {
		JvmEnumerationLiteral enumLiteralProxy = TypesFactory.eINSTANCE.createJvmEnumerationLiteral();
		InternalEObject internalEObject = (InternalEObject) enumLiteralProxy;
		BinarySimpleMemberSignature fieldSignature = typeName.appendField(literalName);
		URI uri = fieldSignature.getURI();
		internalEObject.eSetProxyURI(uri);
		return enumLiteralProxy;
	}

	public Map<String, JvmTypeParameter> createTypeParameters(AbstractBinarySignature signature,
			JvmTypeParameterDeclarator container, Map<String, JvmTypeParameter> knownTypeParameters) {

		List<BinaryTypeParameter> typeParameters = signature.getTypeParameters();
		if (typeParameters.size() != 0) {
			Map<String, JvmTypeParameter> result = Maps
					.newHashMapWithExpectedSize((knownTypeParameters != null ? knownTypeParameters.size() : 0)
							+ typeParameters.size());
			if (knownTypeParameters != null)
				result.putAll(knownTypeParameters);
			InternalEList<JvmTypeParameter> jvmTypeParameters = (InternalEList<JvmTypeParameter>) container
					.getTypeParameters();
			for (int i = 0; i < typeParameters.size(); i++) {
				JvmTypeParameter typeParameter = TypesFactory.eINSTANCE.createJvmTypeParameter();
				String name = typeParameters.get(i).getName();
				typeParameter.setName(name);
				jvmTypeParameters.addUnique(typeParameter);
				result.put(name, typeParameter);
			}

			for (int i = 0; i < typeParameters.size(); i++) {
				List<BinaryGenericTypeSignature> bounds = typeParameters.get(i).getBounds();
				JvmTypeParameter typeParameter = jvmTypeParameters.get(i);
				InternalEList<JvmTypeConstraint> constraints = (InternalEList<JvmTypeConstraint>) typeParameter
						.getConstraints();
				for (int j = 0; j < bounds.size(); j++) {
					JvmUpperBound upperBound = TypesFactory.eINSTANCE.createJvmUpperBound();
					((JvmTypeConstraintImplCustom) upperBound).internalSetTypeReference(createTypeReference(bounds.get(j), result));
					constraints.addUnique(upperBound);
				}
			}
			return result;
		}
		return knownTypeParameters;
	}
	
	public void setVisibility(int accessFlags, JvmMember result) {
		switch (accessFlags & (ACC_PRIVATE | ACC_PROTECTED | ACC_PUBLIC)) {
			case ACC_PRIVATE:
				result.setVisibility(JvmVisibility.PRIVATE);
				return;
			case ACC_PROTECTED:
				result.setVisibility(JvmVisibility.PROTECTED);
				return;
			case ACC_PUBLIC:
				result.setVisibility(JvmVisibility.PUBLIC);
				return;
			default:
				result.setVisibility(JvmVisibility.DEFAULT);
				return;
		}
	}
}
