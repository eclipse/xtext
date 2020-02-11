/*******************************************************************************
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel;

import static com.google.common.collect.Iterables.*;

import java.lang.annotation.Annotation;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmStringAnnotationValue;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.AnnotationLookup;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.compiler.GeneratorConfig;
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;

import com.google.common.base.Strings;
import com.google.inject.Inject;

/**
 * Adds expected default values to a created JvmModel.
 * This is not meant to be enhanced in a language specific way, but really just to add things which
 * are implicit in the Java language, such as default constructors or that a class extends java.lang.Object
 * 
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 * @noreference This class is not intended to be referenced by clients.
 * 
 * @since 2.7
 */
public class JvmModelCompleter {
	
	private static final String JAVAX_ANNOTATION_GENERATED = "javax.annotation.Generated";

	protected static final String GENERATED_COMMENT_VAR_SOURCE_FILE = "${sourcefile}";
	
	@Inject 
	private TypeReferences references;
	
	@Inject 
	private TypesFactory typesFactory;
	
	@Inject 
	private JvmTypeExtensions typeExtensions;  
	
	@Inject
	private IJvmModelAssociations associations;
	
	@Inject
	private IJvmModelAssociator associator;

	@Inject
	private JvmAnnotationReferenceBuilder.Factory annotationRefBuilderFactory;
	
	@Inject
	private IGeneratorConfigProvider generatorConfigProvider;
	
	@Inject
	private AnnotationLookup annotationLookup;
	
	/** The generator is used to fill information of the <code>@Generated</code> annotation. */
	@Inject
	private JvmModelGenerator generator;
	
	private DateFormat dateFormat;
	
	public void complete(Iterable<? extends JvmIdentifiableElement> elements) {
		for (JvmIdentifiableElement element : elements) {
			complete(element);
		}
	}
	
	public void complete(JvmIdentifiableElement element) {
		if (element instanceof JvmGenericType) {
			completeJvmGenericType((JvmGenericType)element);
		}
		if (element instanceof JvmDeclaredType) {
			JvmDeclaredType declaredType = (JvmDeclaredType) element;
			complete(declaredType.getMembers());
		}
		if(element instanceof JvmConstructor) {
			completeJvmConstructor((JvmConstructor) element);
		}
		if (element instanceof JvmEnumerationType) {
			completeJvmEnumerationType((JvmEnumerationType)element);
		}
		if (element instanceof JvmEnumerationLiteral) {
			completeJvmEnumerationLiteral((JvmEnumerationLiteral)element);
		}
		if (element instanceof JvmAnnotationType) {
			completeJvmAnnotationType((JvmAnnotationType)element);
		}
	}
	
	protected void completeJvmEnumerationType(JvmEnumerationType element) {
		if (element.getSuperTypes().isEmpty()) {
			JvmTypeReference objectType = references.getTypeForName(Enum.class, element,
					references.createTypeRef(element));
			if (objectType != null)
				element.getSuperTypes().add(objectType);
		}
		addAnnotations(element);
		EObject primarySourceElement = associations.getPrimarySourceElement(element);
		JvmOperation values = typesFactory.createJvmOperation();
		values.setVisibility(JvmVisibility.PUBLIC);
		values.setStatic(true);
		values.setSimpleName("values");
		values.setReturnType(references.createArrayType(references.createTypeRef(element)));
		typeExtensions.setSynthetic(values, true);
		if (primarySourceElement != null) {
			associator.associate(primarySourceElement, values);
		}
		element.getMembers().add(values);
		
		JvmOperation valueOf = typesFactory.createJvmOperation();
		valueOf.setVisibility(JvmVisibility.PUBLIC);
		valueOf.setStatic(true);
		valueOf.setSimpleName("valueOf");
		valueOf.setReturnType(references.createTypeRef(element));
		JvmFormalParameter param = typesFactory.createJvmFormalParameter();
		param.setName("name");
		param.setParameterType(references.getTypeForName(String.class, element));
		valueOf.getParameters().add(param);
		typeExtensions.setSynthetic(valueOf, true);
		if (primarySourceElement != null) {
			associator.associate(primarySourceElement, valueOf);
		}
		element.getMembers().add(valueOf);
	}

	protected void completeJvmEnumerationLiteral(JvmEnumerationLiteral element) {
		if (element.getType() == null) {
			element.setType(references.createTypeRef(element.getDeclaringType()));
		}
		element.setStatic(true);
	}

	protected void completeJvmAnnotationType(JvmAnnotationType element) {
		addAnnotations(element);
		if (element.getSuperTypes().isEmpty()) {
			JvmTypeReference objectType = references.getTypeForName(Annotation.class, element);
			if (objectType != null)
				element.getSuperTypes().add(objectType);
		}
	}
	
	public void completeJvmConstructor(JvmConstructor constructor) {
		JvmDeclaredType declaringType = constructor.getDeclaringType();
		if(declaringType != null) {
			String simpleName = declaringType.getSimpleName();
			if(simpleName != null) {
				constructor.setSimpleName(simpleName);
				return;
			}
		}
		constructor.setSimpleName("unset");
	}
	
	protected void completeJvmGenericType(JvmGenericType element) {
		// if no super type add Object
		ensureSuperTypeObject(element);
		addAnnotations(element);
		if (!element.isInterface()) {
			// if no constructors have been added, add a default constructor
			if (isEmpty(element.getDeclaredConstructors())) {
				JvmConstructor constructor = TypesFactory.eINSTANCE.createJvmConstructor();
				constructor.setSimpleName(element.getSimpleName());
				constructor.setVisibility(JvmVisibility.PUBLIC);
				typeExtensions.setSynthetic(constructor, true);
				EObject primarySourceElement = associations.getPrimarySourceElement(element);
				if (primarySourceElement != null) {
					associator.associate(primarySourceElement, constructor);
				}
				element.getMembers().add(constructor);
			}
		}
	}

	protected void ensureSuperTypeObject(JvmDeclaredType element) {
		if (element.getSuperTypes().isEmpty()) {
			JvmTypeReference objectType = references.getTypeForName(Object.class, element);
			if (objectType != null)
				element.getSuperTypes().add(objectType);
		}
	}

	/**
	 * @since 2.8
	 */
	protected void addAnnotations(JvmDeclaredType jvmType) {
		if (jvmType.getDeclaringType() == null) {
			GeneratorConfig generatorConfig = generatorConfigProvider.get(jvmType);
			boolean generateSuppressWarnings = !(jvmType instanceof JvmAnnotationType)
					&& generatorConfig.isGenerateSyntheticSuppressWarnings()
					&& annotationLookup.findAnnotation(jvmType, SuppressWarnings.class) == null
					&& references.findDeclaredType(SuppressWarnings.class, jvmType) instanceof JvmAnnotationType;
			JvmType generatedJvmType = references.findDeclaredType(JAVAX_ANNOTATION_GENERATED, jvmType);
			boolean generateGenerated = generatorConfig.isGenerateGeneratedAnnotation()
					&& generatedJvmType instanceof JvmAnnotationType;
			if (generateSuppressWarnings || generateGenerated) {
				JvmAnnotationReferenceBuilder annotationRefBuilder = annotationRefBuilderFactory.create(jvmType.eResource().getResourceSet());
				if (generateSuppressWarnings) {
					JvmAnnotationReference annotationRef = annotationRefBuilder.annotationRef(SuppressWarnings.class, "all");
					typeExtensions.setSynthetic(annotationRef, true);
					jvmType.getAnnotations().add(annotationRef);
				}
				if (generateGenerated) {
					JvmAnnotationType generatedAnnotationType = (JvmAnnotationType) generatedJvmType;
					JvmAnnotationReference annotationRef = annotationRefBuilder.annotationRef(JAVAX_ANNOTATION_GENERATED);
					JvmStringAnnotationValue annotationValue = typesFactory.createJvmStringAnnotationValue();
					annotationValue.getValues().add(generator.getClass().getName());
					annotationRef.getExplicitValues().add(annotationValue);
					if (generatorConfig.isIncludeDateInGeneratedAnnotation()) {
						if (dateFormat == null) {
						    dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ");
						}
						String date = dateFormat.format(new Date());
						annotationValue = typesFactory.createJvmStringAnnotationValue();
						annotationValue.setOperation(getOperation(generatedAnnotationType, "date"));
						annotationValue.getValues().add(date);
						annotationRef.getExplicitValues().add(annotationValue);
					}
					if (!Strings.isNullOrEmpty(generatorConfig.getGeneratedAnnotationComment())) {
						String transformedComment = replaceVariables(generatorConfig.getGeneratedAnnotationComment(), jvmType);
						annotationValue = typesFactory.createJvmStringAnnotationValue();
						annotationValue.setOperation(getOperation(generatedAnnotationType, "comments"));
						annotationValue.getValues().add(transformedComment);
						annotationRef.getExplicitValues().add(annotationValue);
					}
					typeExtensions.setSynthetic(annotationRef, true);
					annotationLookup.removeAnnotation(jvmType, JAVAX_ANNOTATION_GENERATED);
					jvmType.getAnnotations().add(annotationRef);
				}
			}
		}
	}
	
	private JvmOperation getOperation(JvmAnnotationType annotationType, String operationName) {
		for (JvmOperation operation : annotationType.getDeclaredOperations()) {
			if (operationName.equals(operation.getSimpleName()))
				return operation;
		}
		return null;
	}
	
	/**
	 * Replace the variables contained in the comment to be written to the <code>@Generated</code> annotation.
	 */
	protected String replaceVariables(String commentForGenerated, JvmDeclaredType jvmType) {
		String result = commentForGenerated;
		if (result.contains(GENERATED_COMMENT_VAR_SOURCE_FILE)) {
			Resource resource = jvmType.eResource();
			if (resource != null) {
				URI uri = resource.getURI();
				if (uri != null) {
					String sourceFile = uri.lastSegment();
					if (sourceFile == null)
						sourceFile = uri.toString();
					result = result.replace(GENERATED_COMMENT_VAR_SOURCE_FILE, sourceFile);
				}
			}
		}
		return result;
	}
	
}
