/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.objectweb.asm.Type;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class JvmAnnotationValueBuilder extends AbstractJvmAnnotationValueBuilder {

	protected JvmAnnotationValue result;
	
	protected JvmAnnotationValueBuilder(Proxies proxies) {
		super(proxies);
	}
	
	public void visit(String name, Object value) {
		if (name != null) {
			throw new IllegalStateException();
		}
		if (result == null) {
			result = createAnnotationValue(value);
		} else {
			if (value instanceof Type) {
				Type type = (Type) value;
				((InternalEList<JvmTypeReference>) ((JvmTypeAnnotationValue) result).getValues()).addUnique(createTypeReference(
						BinarySignatures.createTypeSignature(type.getInternalName()), null));
			} else {
				@SuppressWarnings("unchecked")
				InternalEList<Object> list = (InternalEList<Object>) result.eGet(result.eClass().getEStructuralFeature("values"));
				list.addUnique(value);
			}
		}
	}

	public void visitEnum(String name, String desc, String value) {
		if (name != null) {
			throw new IllegalStateException();
		}
		if (result == null) {
			result = TypesFactory.eINSTANCE.createJvmEnumAnnotationValue();
		}
		JvmEnumerationLiteral enumLiteralProxy = createEnumLiteralProxy(value, desc);
		((InternalEList<JvmEnumerationLiteral>) ((JvmEnumAnnotationValue) result).getValues()).addUnique(enumLiteralProxy);
	}

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

	public AnnotationVisitor visitArray(String name) {
		throw new IllegalStateException();
	}

}
