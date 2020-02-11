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
import org.eclipse.xtext.common.types.TypesFactory;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmAnnotationReferenceBuilder extends AnnotationVisitor {

	protected final Proxies proxies;

	private final InternalEList<JvmAnnotationReference> target;

	private final JvmAnnotationReference result;

	private final InternalEList<JvmAnnotationValue> values;

	private final BinaryTypeSignature annotationType;

	public JvmAnnotationReferenceBuilder(InternalEList<JvmAnnotationReference> target, String desc, Proxies proxies) {
		super(Opcodes.ASM7);
		this.proxies = proxies;
		this.target = target;
		this.annotationType = BinarySignatures.createTypeSignature(desc);
		result = TypesFactory.eINSTANCE.createJvmAnnotationReference();
		result.setAnnotation(proxies.createAnnotationProxy(annotationType));
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
	@Override
	public void visit(final String name, final Object value) {
		JvmAnnotationValue annotationValue = proxies.createAnnotationValue(value);
		annotationValue.setOperation(proxies.createMethodProxy(annotationType, name));
		values.addUnique(annotationValue);
	}

	@Override
	public void visitEnum(final String name, final String desc, final String value) {
		JvmEnumAnnotationValue result = TypesFactory.eINSTANCE.createJvmEnumAnnotationValue();
		JvmEnumerationLiteral enumLiteralProxy = proxies.createEnumLiteral(value, desc);
		((InternalEList<JvmEnumerationLiteral>) result.getValues()).addUnique(enumLiteralProxy);
		result.setOperation(proxies.createMethodProxy(annotationType, name));
		values.addUnique(result);
	}
	
	@Override
	public AnnotationVisitor visitAnnotation(final String name, final String desc) {
		JvmAnnotationAnnotationValue annotationValue = TypesFactory.eINSTANCE.createJvmAnnotationAnnotationValue();
		InternalEList<JvmAnnotationReference> nestedValues = (InternalEList<JvmAnnotationReference>) annotationValue
				.getValues();
		annotationValue.setOperation(proxies.createMethodProxy(annotationType, name));
		JvmAnnotationReferenceBuilder annotation = new JvmAnnotationReferenceBuilder(nestedValues, desc, proxies);
		values.addUnique(annotationValue);
		return annotation;
	}

	@Override
	public AnnotationVisitor visitArray(final String name) {
		return new JvmAnnotationValueBuilder(proxies) {
			@Override
			public void visitEnd() {
				if (result == null) {
					result = TypesFactory.eINSTANCE.createJvmCustomAnnotationValue();
				}
				result.setOperation(proxies.createMethodProxy(annotationType, name));
				values.addUnique(result);
			}
		};
	}

	@Override
	public void visitEnd() {
		target.addUnique(result);
	}

}
