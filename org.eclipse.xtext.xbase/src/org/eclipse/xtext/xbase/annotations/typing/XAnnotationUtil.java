/*******************************************************************************
 * Copyright (c) 2011, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.annotations.typing;

import static com.google.common.collect.Sets.*;
import static java.util.Collections.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;


/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XAnnotationUtil {
	
	public JvmOperation findSingleValueAttribute(JvmAnnotationType type) {
		Iterable<JvmOperation> operations = type.getDeclaredOperations();
		for (JvmOperation operation : operations) {
			if (operation.getSimpleName().equals("value")) {
				return operation;
			}
		}
		return null;
	}
	
	public XExpression findValue(XAnnotation annotation, JvmOperation jvmOperation) {
		if (jvmOperation.getSimpleName().equals("value") && annotation.getValue() != null) {
			return annotation.getValue();
		}
		for (XAnnotationElementValuePair pair : annotation.getElementValuePairs()) {
			if (pair.getElement() == jvmOperation)
				return pair.getValue();
		}
		return null;
	}
	
	public Set<ElementType> getAnnotationTargets(JvmAnnotationType annotation) {
		EList<JvmAnnotationReference> annotations = annotation.getAnnotations();
		for (JvmAnnotationReference annoRef : annotations) {
			if (Target.class.getName().equals(annoRef.getAnnotation().getIdentifier())) {
				EList<JvmAnnotationValue> values = annoRef.getValues();
				JvmAnnotationValue value = values.isEmpty() ? null : values.get(0);
				if (value instanceof JvmEnumAnnotationValue) {
					Set<ElementType> result = newHashSet();
					for (JvmEnumerationLiteral elementType : ((JvmEnumAnnotationValue) value).getValues()) {
						final String simpleName = elementType.getSimpleName();
						result.add(ElementType.valueOf(simpleName));
					}
					return result;
				}
			}
		}
		return emptySet();
	}

	/**
	 * @param qualifiedNames
	 *            The annotations' qualified names to search for.
	 * 
	 * @param annotationTarget
	 *            The element the annotations are search on.
	 * 
	 * @return The annotations that are applied on the <i>annotationTarget</i>
	 *         and their qualified names appear in the <i>qualifiedNames</i> set.
	 *         The annotations are returned in the order of their appearance.
	 * 
	 * @since 2.15
	 */
	public List<JvmAnnotationReference> findAnnotations(Set<String> qualifiedNames,	JvmAnnotationTarget annotationTarget) {
		List<JvmAnnotationReference> result = new ArrayList<>();

		if (annotationTarget != null) {
			for (JvmAnnotationReference annotation : annotationTarget.getAnnotations()) {
				String id = annotation.getAnnotation().getIdentifier();
				if (qualifiedNames.contains(id)) {
					result.add(annotation);
				}
			}
		}
		return result;
	}
}
