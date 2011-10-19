/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Maps.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmAnnotationAnnotationValue;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmBooleanAnnotationValue;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmCustomAnnotationValue;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmIntAnnotationValue;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmStringAnnotationValue;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeAnnotationValue;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XIntLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationValueArray;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.compiler.CompilationStrategyAdapter;
import org.eclipse.xtext.xbase.compiler.DocumentationAdapter;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.inject.Inject;

/**
 * A set of factory and builder functions, used to create an instance of the Jvm model ({@link TypesPackage}).
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class JvmTypesBuilder {

	@Inject
	private IJvmModelAssociator associator;

	@Inject
	private TypeReferences references;

	@Inject
	private IEObjectDocumentationProvider documentationProvider;

	/**
	 * Establishes a logical containment relation ship between the expression and {@link JvmIdentifiableElement}. A
	 * typical example would be an association between an expression and a {@link JvmOperation}, which has the effect
	 * that the expression's scope and type expectation are defined by the {@link JvmOperation}.
	 * 
	 * The {@link org.eclipse.xtext.xbase.compiler.JvmModelGenerator} also makes use of the logical containment and will
	 * compile the given expression in the context of the given JvmElement.
	 * 
	 * @param expr
	 *            - the expression. Must not be <code>null</code>.
	 * @param element
	 *            - the jvm element the expression is associated with. Must not be <code>null</code>.
	 */
	public void isLogicallyContainedIn(XExpression expr, JvmIdentifiableElement logicalContainer) {
		associator.associateLogicalContainer(expr, logicalContainer);
	}

	/**
	 * Creates a public class declaration, associated to the given sourceElement. It sets the given name, which might be fully
	 * qualified using the standard Java notation.
	 */
	public JvmGenericType toClass(EObject sourceElement, String name, Procedure1<JvmGenericType> init) {
		String simpleName = name;
		String packageName = null;
		final int dotIdx = name.lastIndexOf('.');
		if (dotIdx != -1) {
			simpleName = name.substring(dotIdx + 1);
			packageName = name.substring(0, dotIdx);
		}
		final JvmGenericType result = TypesFactory.eINSTANCE.createJvmGenericType();
		result.setSimpleName(simpleName);
		if (packageName != null)
			result.setPackageName(packageName);
		result.setVisibility(JvmVisibility.PUBLIC);
		init.apply(result);

		// if no super type add Object
		if (result.getSuperTypes().isEmpty()) {
			JvmTypeReference objectType = references.getTypeForName(Object.class, sourceElement);
			if (objectType != null)
				result.getSuperTypes().add(objectType);
		}
		// if no constructors have been added, add a default constructor
		if (isEmpty(result.getDeclaredConstructors())) {
			result.getMembers().add(toConstructor(sourceElement, simpleName, null));
		}
		return associate(sourceElement, result);
	}

	/**
	 * Creates a private field with the given name and the given type associated to the given sourceElement.
	 */
	public JvmField toField(EObject sourceElement, String name, JvmTypeReference typeRef) {
		JvmField result = TypesFactory.eINSTANCE.createJvmField();
		result.setSimpleName(name);
		result.setVisibility(JvmVisibility.PRIVATE);
		result.setType(cloneWithProxies(typeRef));
		return associate(sourceElement, result);
	}

	/**
	 * Associates a source element with a target element. This association is used for tracing. Navigation, for
	 * instance, uses this information to find the real declaration of a Jvm element.
	 * @see IJvmModelAssociator
	 * @see IJvmModelAssociations
	 */
	public <T extends JvmIdentifiableElement> T associate(EObject sourceElement, T target) {
		associator.associatePrimary(sourceElement, target);
		return target;
	}

	/**
	 * Creates a public method with the given name and the given return type and associates it with the given sourceElement.
	 */
	public JvmOperation toMethod(EObject sourceElement, String name, JvmTypeReference returnType, Procedure1<JvmOperation> init) {
		JvmOperation result = TypesFactory.eINSTANCE.createJvmOperation();
		result.setSimpleName(name);
		result.setVisibility(JvmVisibility.PUBLIC);
		result.setReturnType(cloneWithProxies(returnType));
		init.apply(result);
		return associate(sourceElement, result);
	}

	public JvmOperation toGetter(EObject sourceElement, final String name, JvmTypeReference typeRef) {
		JvmOperation result = TypesFactory.eINSTANCE.createJvmOperation();
		result.setVisibility(JvmVisibility.PUBLIC);
		result.setSimpleName("get" + Strings.toFirstUpper(name));
		result.setReturnType(cloneWithProxies(typeRef));
		body(result, new Functions.Function1<ImportManager, CharSequence>() {
			public CharSequence apply(ImportManager p) {
				return "return this." + name + ";";
			}
		});
		return associate(sourceElement, result);
	}

	public JvmOperation toSetter(EObject sourceElement, final String name, JvmTypeReference typeRef) {
		JvmOperation result = TypesFactory.eINSTANCE.createJvmOperation();
		result.setVisibility(JvmVisibility.PUBLIC);
		result.setSimpleName("set" + Strings.toFirstUpper(name));
		result.getParameters().add(toParameter(sourceElement, name, cloneWithProxies(typeRef)));
		body(result, new Functions.Function1<ImportManager, CharSequence>() {
			public CharSequence apply(ImportManager p) {
				return "this." + name + " = " + name + ";";
			}
		});
		return associate(sourceElement, result);
	}

	public JvmFormalParameter toParameter(EObject sourceElement, String name, JvmTypeReference typeRef) {
		JvmFormalParameter result = TypesFactory.eINSTANCE.createJvmFormalParameter();
		result.setName(name);
		result.setParameterType(cloneWithProxies(typeRef));
		return associate(sourceElement, result);
	}

	public JvmConstructor toConstructor(EObject sourceElement, String simpleName, Procedure1<JvmConstructor> init) {
		JvmConstructor constructor = TypesFactory.eINSTANCE.createJvmConstructor();
		constructor.setSimpleName(simpleName);
		body(constructor, new Function1<ImportManager, CharSequence>() {
			public CharSequence apply(ImportManager p) {
				return "{}";
			}
		});
		if (init != null)
			init.apply(constructor);
		return associate(sourceElement, constructor);
	}

	public JvmAnnotationReference toAnnotation(EObject sourceElement, Class<?> annotationType) {
		return toAnnotation(sourceElement, annotationType, null);
	}

	public JvmAnnotationReference toAnnotation(EObject sourceElement, String annotationTypeName) {
		return toAnnotation(sourceElement, annotationTypeName, null);
	}

	public JvmAnnotationReference toAnnotation(EObject sourceElement, Class<?> annotationType, Object value) {
		return toAnnotation(sourceElement, annotationType.getCanonicalName(), value);
	}

	public JvmAnnotationReference toAnnotation(EObject sourceElement, String annotationTypeName, Object value) {
		JvmAnnotationReference result = TypesFactory.eINSTANCE.createJvmAnnotationReference();
		JvmType jvmType = references.findDeclaredType(annotationTypeName, sourceElement);
		if (!(jvmType instanceof JvmAnnotationType)) {
			throw new IllegalArgumentException("The given class " + annotationTypeName + " is not an annotation type.");
		}
		result.setAnnotation((JvmAnnotationType) jvmType);
		if (value != null) {
			if (value instanceof String) {
				JvmStringAnnotationValue annotationValue = TypesFactory.eINSTANCE.createJvmStringAnnotationValue();
				annotationValue.getValues().add((String) value);
				result.getValues().add(annotationValue);
			}
		}
		return result;
	}

	public JvmTypeReference cloneWithProxies(JvmTypeReference typeRef) {
		if (typeRef instanceof JvmParameterizedTypeReference
				&& !typeRef.eIsSet(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE))
			throw new IllegalArgumentException("typeref#type was null");
		return EcoreUtil2.cloneWithProxies(typeRef);
	}

	public void body(JvmExecutable op, Functions.Function1<ImportManager, ? extends CharSequence> strategy) {
		addCompilationStrategy(op, strategy);
	}

	public void initialization(JvmField field, Functions.Function1<ImportManager, ? extends CharSequence> strategy) {
		addCompilationStrategy(field, strategy);
	}

	protected void addCompilationStrategy(JvmMember member,
			Functions.Function1<ImportManager, ? extends CharSequence> strategy) {
		CompilationStrategyAdapter adapter = new CompilationStrategyAdapter();
		adapter.setCompilationStrategy(strategy);
		member.eAdapters().add(adapter);
	}

	public JvmTypeReference newTypeRef(EObject ctx, Class<?> clazz, JvmTypeReference... typeArgs) {
		return references.getTypeForName(clazz, ctx, typeArgs);
	}

	public JvmTypeReference newTypeRef(EObject ctx, String name, JvmTypeReference... typeArgs) {
		return references.getTypeForName(name, ctx, typeArgs);
	}

	public JvmTypeReference addArrayTypeDimension(JvmTypeReference componentType) {
		return references.createArrayType(componentType);
	}

	public void translateAnnotationsTo(Iterable<? extends XAnnotation> annotations, JvmAnnotationTarget target) {
		for (XAnnotation anno : annotations) {
			JvmAnnotationReference annotationReference = getJvmAnnotationReference(anno);
			target.getAnnotations().add(annotationReference);
		}
	}

	public void translateDocumentationTo(EObject source, EObject jvmElement) {
		String documentation = documentationProvider.getDocumentation(source).trim();
		if (!isEmpty(documentation)) {
			DocumentationAdapter documentationAdapter = new DocumentationAdapter();
			documentationAdapter.setDocumentation(documentation);
			jvmElement.eAdapters().add(documentationAdapter);
		}
	}

	protected JvmAnnotationReference getJvmAnnotationReference(XAnnotation anno) {
		JvmAnnotationReference reference = TypesFactory.eINSTANCE.createJvmAnnotationReference();
		final JvmAnnotationType annotation = (JvmAnnotationType) anno.eGet(
				XAnnotationsPackage.Literals.XANNOTATION__ANNOTATION_TYPE, false);
		reference.setAnnotation(annotation);
		for (XAnnotationElementValuePair val : anno.getElementValuePairs()) {
			JvmAnnotationValue annotationValue = getJvmAnnotationValue(val.getValue());
			JvmOperation op = (JvmOperation) val.eGet(
					XAnnotationsPackage.Literals.XANNOTATION_ELEMENT_VALUE_PAIR__ELEMENT, false);
			annotationValue.setOperation(op);
			reference.getValues().add(annotationValue);
		}
		if (anno.getValue() != null) {
			JvmAnnotationValue value = getJvmAnnotationValue(anno.getValue());
			reference.getValues().add(value);
		}
		return reference;
	}

	protected JvmAnnotationValue getJvmAnnotationValue(XExpression value) {
		if (value instanceof XAnnotationValueArray) {
			EList<XExpression> values = ((XAnnotationValueArray) value).getValues();
			JvmAnnotationValue result = null;
			for (XExpression expr : values) {
				AnnotationValueTranslator translator = translator(expr);
				if (translator == null)
					throw new IllegalArgumentException("expression " + value
							+ " is not supported in annotation literals");
				if (result == null) {
					result = translator.createValue(expr);
				}
				translator.appendValue(result, expr);
			}
			return result;
		} else {
			AnnotationValueTranslator translator = translator(value);
			if (translator == null)
				throw new IllegalArgumentException("expression " + value + " is not supported in annotation literals");
			JvmAnnotationValue result = translator.createValue(value);
			translator.appendValue(result, value);
			return result;
		}
	}

	private Map<EClass, AnnotationValueTranslator> translators = newLinkedHashMap();

	protected AnnotationValueTranslator translator(XExpression obj) {
		synchronized (translators) {
			if (translators.isEmpty()) {
				translators.put(XAnnotationsPackage.Literals.XANNOTATION, new AnnotationValueTranslator() {
					public JvmAnnotationValue createValue(XExpression expr) {
						return TypesFactory.eINSTANCE.createJvmAnnotationAnnotationValue();
					}

					public void appendValue(JvmAnnotationValue value, XExpression expr) {
						JvmAnnotationAnnotationValue annotationValue = (JvmAnnotationAnnotationValue) value;
						JvmAnnotationReference annotationReference = getJvmAnnotationReference((XAnnotation) expr);
						annotationValue.getAnnotations().add(annotationReference);
					}
				});
				translators.put(XbasePackage.Literals.XSTRING_LITERAL, new AnnotationValueTranslator() {
					public JvmAnnotationValue createValue(XExpression expr) {
						return TypesFactory.eINSTANCE.createJvmStringAnnotationValue();
					}

					public void appendValue(JvmAnnotationValue value, XExpression expr) {
						JvmStringAnnotationValue annotationValue = (JvmStringAnnotationValue) value;
						String string = ((XStringLiteral) expr).getValue();
						annotationValue.getValues().add(string);
					}
				});
				translators.put(XbasePackage.Literals.XBOOLEAN_LITERAL, new AnnotationValueTranslator() {
					public JvmAnnotationValue createValue(XExpression expr) {
						return TypesFactory.eINSTANCE.createJvmBooleanAnnotationValue();
					}

					public void appendValue(JvmAnnotationValue value, XExpression expr) {
						JvmBooleanAnnotationValue annotationValue = (JvmBooleanAnnotationValue) value;
						boolean isTrue = ((XBooleanLiteral) expr).isIsTrue();
						annotationValue.getValues().add(isTrue);
					}
				});
				translators.put(XbasePackage.Literals.XTYPE_LITERAL, new AnnotationValueTranslator() {
					public JvmAnnotationValue createValue(XExpression expr) {
						return TypesFactory.eINSTANCE.createJvmTypeAnnotationValue();
					}

					public void appendValue(JvmAnnotationValue value, XExpression expr) {
						JvmTypeAnnotationValue annotationValue = (JvmTypeAnnotationValue) value;
						final XTypeLiteral literal = (XTypeLiteral) expr;
						JvmType proxy = (JvmType) literal.eGet(XbasePackage.Literals.XTYPE_LITERAL__TYPE, false);
						JvmParameterizedTypeReference reference = TypesFactory.eINSTANCE
								.createJvmParameterizedTypeReference();
						reference.setType(proxy);
						annotationValue.getValues().add(reference);
					}
				});
				translators.put(XbasePackage.Literals.XINT_LITERAL, new AnnotationValueTranslator() {
					public JvmAnnotationValue createValue(XExpression expr) {
						return TypesFactory.eINSTANCE.createJvmIntAnnotationValue();
					}

					public void appendValue(JvmAnnotationValue value, XExpression expr) {
						JvmIntAnnotationValue annotationValue = (JvmIntAnnotationValue) value;
						annotationValue.getValues().add(((XIntLiteral) expr).getValue());
					}
				});
				translators.put(XbasePackage.Literals.XFEATURE_CALL, new AnnotationValueTranslator() {
					public JvmAnnotationValue createValue(XExpression expr) {
						return TypesFactory.eINSTANCE.createJvmCustomAnnotationValue();
					}

					public void appendValue(JvmAnnotationValue value, XExpression expr) {
						JvmCustomAnnotationValue annotationValue = (JvmCustomAnnotationValue) value;
						annotationValue.getValues().add(expr);
					}
				});
			}
		}
		return translators.get(obj.eClass());
	}

	static interface AnnotationValueTranslator {
		JvmAnnotationValue createValue(XExpression expr);

		void appendValue(JvmAnnotationValue value, XExpression expr);
	}
}
