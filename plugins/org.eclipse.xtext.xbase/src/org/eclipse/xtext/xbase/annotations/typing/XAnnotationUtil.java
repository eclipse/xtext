/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.annotations.typing;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Maps.*;
import static com.google.common.collect.Sets.*;
import static java.util.Collections.*;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.util.FeatureOverridesService;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XAnnotationUtil {
	
	@Inject
	private FeatureOverridesService overridesService;
	
	@Inject
	private TypeArgumentContextProvider typeArgumentContextProvider;
	
	public JvmOperation findSingleValueAttribute(JvmAnnotationType type) {
		Iterable<JvmFeature> features = overridesService.getAllJvmFeatures(type, typeArgumentContextProvider.getNullContext());
		for (JvmFeature jvmFeature : features) {
			if (jvmFeature.getSimpleName().equals("value")) {
				return (JvmOperation) jvmFeature;
			}
		}
		return null;
	}
	
	private final static Set<String> ignoredTypes = newHashSet(Object.class.getName(), Annotation.class.getName());
	
	public Iterable<JvmOperation> findAllAttributes(JvmAnnotationType type) {
		final Iterable<JvmFeature> allJvmFeatures = overridesService.getAllJvmFeatures(type, typeArgumentContextProvider.getNullContext());
		final Iterable<JvmOperation> result = filter(allJvmFeatures, JvmOperation.class);
		Iterable<JvmOperation> withoutObjectMembers = filter(result, new Predicate<JvmOperation>() {
			public boolean apply(JvmOperation input) {
				final String identifier = input.getDeclaringType().getIdentifier();
				return !ignoredTypes.contains(identifier);
			}});
		return withoutObjectMembers;
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
	
	private final static Map<String, ElementType> mapping = newHashMap();
	static {
		mapping.put(ElementType.ANNOTATION_TYPE.name(), ElementType.ANNOTATION_TYPE);
		mapping.put(ElementType.CONSTRUCTOR.name(), ElementType.CONSTRUCTOR);
		mapping.put(ElementType.FIELD.name(), ElementType.FIELD);
		mapping.put(ElementType.LOCAL_VARIABLE.name(), ElementType.LOCAL_VARIABLE);
		mapping.put(ElementType.METHOD.name(), ElementType.METHOD);
		mapping.put(ElementType.PACKAGE.name(), ElementType.PACKAGE);
		mapping.put(ElementType.PARAMETER.name(), ElementType.PARAMETER);
		mapping.put(ElementType.TYPE.name(), ElementType.TYPE);
	}
	
	public Set<ElementType> getAnnotationTargets(JvmAnnotationType annotation) {
		EList<JvmAnnotationReference> annotations = annotation.getAnnotations();
		for (JvmAnnotationReference annoRef : annotations) {
			if (Target.class.getName().equals(annoRef.getAnnotation().getIdentifier())) {
				EList<JvmAnnotationValue> values = annoRef.getValues();
				JvmAnnotationValue value = values.get(0);
				if (value instanceof JvmEnumAnnotationValue) {
					Set<ElementType> result = newHashSet();
					for (JvmEnumerationLiteral elementType : ((JvmEnumAnnotationValue) value).getValues()) {
						final String simpleName = elementType.getSimpleName();
						result.add(mapping.get(simpleName));
					}
					return result;
				}
			}
		}
		return emptySet();
	}
	
}
