/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmStringAnnotationValue;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.TypeReferences;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.7
 */
public class JvmAnnotationReferenceBuilder {
	
	public static class Factory {
		@Inject Provider<JvmAnnotationReferenceBuilder> builderProvider;
		public JvmAnnotationReferenceBuilder create(ResourceSet context) {
			JvmAnnotationReferenceBuilder result = builderProvider.get();
			result.context = context;
			return result;
		}
	}
	
	private ResourceSet context;
	
	@Inject
	private TypeReferences references;
	
	@Inject
	private TypesFactory typesFactory;

	/**
	 * Creates and returns an annotation reference of the given annotation type's name and the given value.
	 * 
	 * @param annotationType
	 *            the type of the created annotation reference.
	 * @param values
	 *            the string values of the annotation reference.
	 *            
	 * @return a result representing an annotation reference to the given annotation type, <code>null<code> if 
	 * 		sourceElement or annotationType are <code>null</code>.  
	 */
	/* @Nullable */
	public JvmAnnotationReference annotationRef(/* @Nullable */ Class<?> annotationType, /* @Nullable */ String... values) {
		if(annotationType == null)
			return null;
		return annotationRef(annotationType.getCanonicalName(), values);
	}

	/**
	 * Creates and returns an annotation reference of the given annotation type's name and the given value.
	 * 
	 * @param annotationTypeName
	 *            the type name of the created annotation.
	 * @param values
	 *            the string value of the annotation's 'values' property.
	 *            
	 * @return a result representing an annotation reference to the given annotation type, <code>null<code> if 
	 * 		annotationType are <code>null</code>.  
	 */
	//TODO Move up the code used in Xtend's CompilationUnitImpl so we can reuse it here.
	//TODO Support other types and setting non default properties
	/* @Nullable */ 
	public JvmAnnotationReference annotationRef(/* @Nullable */ String annotationTypeName, /* @Nullable */ String... values) {
		if (context == null || annotationTypeName == null)
			return null;
		JvmAnnotationReference result = typesFactory.createJvmAnnotationReference();
		JvmType jvmType = references.findDeclaredType(annotationTypeName, context);
		if (jvmType == null) {
			throw new IllegalArgumentException("The type "+annotationTypeName +" is not on the classpath.");
		}
		if (!(jvmType instanceof JvmAnnotationType)) {
			throw new IllegalArgumentException("The given class " + annotationTypeName + " is not an annotation type.");
		}
		result.setAnnotation((JvmAnnotationType) jvmType);
		if (values != null && values.length>0) {
			JvmStringAnnotationValue annotationValue = typesFactory.createJvmStringAnnotationValue();
			for (String value : values) {
				annotationValue.getValues().add(value);
			}
			result.getExplicitValues().add(annotationValue);
		}
		return result;
	}
}
