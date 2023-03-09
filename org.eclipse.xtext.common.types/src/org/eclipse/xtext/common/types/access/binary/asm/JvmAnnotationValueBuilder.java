/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.binary.asm;

import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.common.types.JvmAnnotationAnnotationValue;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmTypeAnnotationValue;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class JvmAnnotationValueBuilder extends AnnotationVisitor {

	protected final Proxies proxies;

	protected JvmAnnotationValue result;
	
	protected JvmAnnotationValueBuilder(Proxies proxies) {
		super(Opcodes.ASM9);
		this.proxies = proxies;
	}
	
	@Override
	public void visit(String name, Object value) {
		if (name != null) {
			throw new IllegalStateException();
		}
		if (result == null) {
			result = proxies.createAnnotationValue(value);
		} else {
			if (value instanceof Type) {
				Type type = (Type) value;
				BinaryTypeSignature signature;
				if (type.getSort() == Type.OBJECT) {
					String typeName = type.getInternalName();
					signature = BinarySignatures.createObjectTypeSignature(typeName);
				} else {
					String typeName = type.getDescriptor();
					signature = BinarySignatures.createTypeSignature(typeName);
				}
				((InternalEList<JvmTypeReference>) ((JvmTypeAnnotationValue) result).getValues()).addUnique(proxies.createTypeReference(signature, null));
			} else {
				@SuppressWarnings("unchecked")
				InternalEList<Object> list = (InternalEList<Object>) result.eGet(result.eClass().getEStructuralFeature("values"));
				list.addUnique(value);
			}
		}
	}

	@Override
	public void visitEnum(String name, String desc, String value) {
		if (name != null) {
			throw new IllegalStateException();
		}
		if (result == null) {
			result = TypesFactory.eINSTANCE.createJvmEnumAnnotationValue();
		}
		JvmEnumerationLiteral enumLiteralProxy = proxies.createEnumLiteral(value, desc);
		((InternalEList<JvmEnumerationLiteral>) ((JvmEnumAnnotationValue) result).getValues()).addUnique(enumLiteralProxy);
	}

	@Override
	public AnnotationVisitor visitAnnotation(String name, String desc) {
		if (name != null) {
			throw new IllegalStateException();
		}
		if (result == null) {
			result = TypesFactory.eINSTANCE.createJvmAnnotationAnnotationValue();
		}
		InternalEList<JvmAnnotationReference> nestedValues = (InternalEList<JvmAnnotationReference>) ((JvmAnnotationAnnotationValue) result).getValues();
		JvmAnnotationReferenceBuilder annotation = new JvmAnnotationReferenceBuilder(nestedValues, desc, proxies);
		return annotation;
	}

	@Override
	public AnnotationVisitor visitArray(String name) {
		throw new IllegalStateException();
	}

}
