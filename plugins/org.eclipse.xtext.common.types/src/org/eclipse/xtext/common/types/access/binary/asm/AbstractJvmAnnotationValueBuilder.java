/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.binary.asm;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmBooleanAnnotationValue;
import org.eclipse.xtext.common.types.JvmByteAnnotationValue;
import org.eclipse.xtext.common.types.JvmCharAnnotationValue;
import org.eclipse.xtext.common.types.JvmDoubleAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmFloatAnnotationValue;
import org.eclipse.xtext.common.types.JvmIntAnnotationValue;
import org.eclipse.xtext.common.types.JvmLongAnnotationValue;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmShortAnnotationValue;
import org.eclipse.xtext.common.types.JvmStringAnnotationValue;
import org.eclipse.xtext.common.types.JvmTypeAnnotationValue;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Type;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractJvmAnnotationValueBuilder extends AbstractJvmElementBuilder implements AnnotationVisitor {

	protected AbstractJvmAnnotationValueBuilder(Proxies proxies) {
		super(proxies);
	}

	protected JvmOperation createMethodProxy(BinaryTypeSignature annotationType, String name) {
		return proxies.createMethodProxy(annotationType, name);
	}

	protected JvmAnnotationValue createAnnotationValue(Object value) {
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
			((InternalEList<JvmTypeReference>) result.getValues()).addUnique(createTypeReference(
					BinarySignatures.createTypeSignature(type.getInternalName()), null));
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
	
	protected JvmEnumerationLiteral createEnumLiteralProxy(String literalName, String typeName) {
		return createEnumLiteralProxy(literalName, BinarySignatures.createTypeSignature(typeName));
	}

	protected JvmEnumerationLiteral createEnumLiteralProxy(String literalName, BinaryTypeSignature typeName) {
		JvmEnumerationLiteral enumLiteralProxy = TypesFactory.eINSTANCE.createJvmEnumerationLiteral();
		InternalEObject internalEObject = (InternalEObject) enumLiteralProxy;
		BinarySimpleMemberSignature fieldSignature = typeName.appendField(literalName);
		URI uri = fieldSignature.getURI();
		internalEObject.eSetProxyURI(uri);
		return enumLiteralProxy;
	}

}
