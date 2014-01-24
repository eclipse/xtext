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
import org.eclipse.xtext.common.types.TypesFactory;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Type;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmAnnotationReferenceBuilder extends AbstractJvmAnnotationValueBuilder {

	private final InternalEList<JvmAnnotationReference> target;

	private final JvmAnnotationReference result;

	private final InternalEList<JvmAnnotationValue> values;

	private final BinaryTypeSignature annotationType;

	public JvmAnnotationReferenceBuilder(InternalEList<JvmAnnotationReference> target, String desc, Proxies proxies) {
		super(proxies);
		this.target = target;
		this.annotationType = BinarySignatures.createTypeSignature(desc);
		result = TypesFactory.eINSTANCE.createJvmAnnotationReference();
		result.setAnnotation(createAnnotationProxy(annotationType));
		values = (InternalEList<JvmAnnotationValue>) result.getExplicitValues();
	}

	/**
	 * Visits a primitive value of the annotation.
	 * 
	 * @param name
	 *            the value name.
	 * @param value
	 *            the actual value, whose type must be {@link Byte}, {@link Boolean}, {@link Character}, {@link Short},
	 *            {@link Integer}, {@link Long}, {@link Float}, {@link Double}, {@link String} or {@link Type}. This
	 *            value can also be an array of byte, boolean, short, char, int, long, float or double values (this is
	 *            equivalent to using {@link #visitArray visitArray} and visiting each array element in turn, but is
	 *            more convenient).
	 */
	public void visit(final String name, final Object value) {
		JvmAnnotationValue annotationValue = createAnnotationValue(value);
		annotationValue.setOperation(createMethodProxy(annotationType, name));
		values.addUnique(annotationValue);
	}

	public void visitEnum(final String name, final String desc, final String value) {
		JvmEnumAnnotationValue result = TypesFactory.eINSTANCE.createJvmEnumAnnotationValue();
		JvmEnumerationLiteral enumLiteralProxy = createEnumLiteralProxy(value, desc);
		((InternalEList<JvmEnumerationLiteral>) result.getValues()).addUnique(enumLiteralProxy);
		result.setOperation(createMethodProxy(annotationType, name));
		values.addUnique(result);
	}
	
	public AnnotationVisitor visitAnnotation(final String name, final String desc) {
		JvmAnnotationAnnotationValue annotationValue = TypesFactory.eINSTANCE.createJvmAnnotationAnnotationValue();
		InternalEList<JvmAnnotationReference> nestedValues = (InternalEList<JvmAnnotationReference>) annotationValue
				.getValues();
		annotationValue.setOperation(createMethodProxy(annotationType, name));
		JvmAnnotationReferenceBuilder annotation = new JvmAnnotationReferenceBuilder(nestedValues, desc, proxies);
		values.addUnique(annotationValue);
		return annotation;
	}

	public AnnotationVisitor visitArray(final String name) {
		return new JvmAnnotationValueBuilder(proxies) {
			public void visitEnd() {
				result.setOperation(createMethodProxy(annotationType, name));
				values.addUnique(result);
			}
		};
	}

	public void visitEnd() {
		target.addUnique(result);
	}

}
