/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel;

import static com.google.common.collect.Maps.*;

import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmAnnotationAnnotationValue;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmBooleanAnnotationValue;
import org.eclipse.xtext.common.types.JvmCustomAnnotationValue;
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
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JvmTypesBuilder {
	
	@Inject
	private IJvmModelAssociator associator;
	
	@Inject
	private TypeReferences references;
	
	public void associate(XExpression expr, JvmIdentifiableElement element) {
		associator.associateLogicalContainer(expr, element);
	}

	public JvmField toField(EObject ctx, String name, JvmTypeReference typeRef) {
		JvmField result = create(name, JvmField.class, null);
		if (!result.eIsSet(TypesPackage.Literals.JVM_MEMBER__VISIBILITY))
			result.setVisibility(JvmVisibility.PRIVATE);
		result.setType(cloneWithProxies(typeRef));
		return associate(ctx,result);
	}
	
	public <T extends JvmIdentifiableElement> T associate(EObject source, T target) {
		associator.associatePrimary(source, target);
		return target;
	}

	public JvmOperation toMethod(EObject ctx, String name, JvmTypeReference typeRef, Function1<JvmOperation, Void> init) {
		JvmOperation result = create(name, JvmOperation.class, init);
		if (!result.eIsSet(TypesPackage.Literals.JVM_MEMBER__VISIBILITY))
			result.setVisibility(JvmVisibility.PUBLIC);
		result.setReturnType(cloneWithProxies(typeRef));
		return associate(ctx,result);
	}

	public JvmOperation toGetter(EObject ctx, final String name, JvmTypeReference typeRef) {
		JvmOperation result = create(JvmOperation.class, null);
		result.setVisibility(JvmVisibility.PUBLIC);
		result.setSimpleName("get" + Strings.toFirstUpper(name));
		result.setReturnType(cloneWithProxies(typeRef));
		body(result, new Functions.Function1<ImportManager, CharSequence>() {
			public CharSequence apply(ImportManager p) {
				return "return this."+name+";";
			}
		});
		return associate(ctx,result);
	}

	public JvmOperation toSetter(EObject ctx, final String name, JvmTypeReference typeRef) {
		JvmOperation result = create(name, JvmOperation.class, null);
		result.setVisibility(JvmVisibility.PUBLIC);
		result.setSimpleName("set" + Strings.toFirstUpper(name));
		result.getParameters().add(toParameter(ctx, name, cloneWithProxies(typeRef)));
		body(result, new Functions.Function1<ImportManager, CharSequence>() {
			public CharSequence apply(ImportManager p) {
				return "this."+name+" = "+name+";";
			}
		});
		return associate(ctx,result);
	}

	public JvmFormalParameter toParameter(EObject ctx, String name, JvmTypeReference typeRef) {
		JvmFormalParameter result = create(JvmFormalParameter.class, null);
		result.setName(name);
		result.setParameterType(cloneWithProxies(typeRef));
		return associate(ctx,result);
	}

	public JvmGenericType toClazz(EObject ctx, String name, Function1<JvmGenericType, Void> init) {
		String simpleName = name;
		String packageName = null;
		final int dotIdx = name.lastIndexOf('.');
		if (dotIdx != -1) {
			simpleName = name.substring(dotIdx+1);
			packageName = name.substring(0, dotIdx);
		}
		final JvmGenericType create = create(simpleName, JvmGenericType.class, init);
		if (packageName!=null)
			create.setPackageName(packageName);
		create.setVisibility(JvmVisibility.PUBLIC);
		if (create.getSuperTypes().isEmpty()) {
			JvmTypeReference objectType = references.getTypeForName(Object.class, ctx);
			if (objectType != null)
				create.getSuperTypes().add(objectType);
		}
		return associate(ctx,create);
	}
	
	public JvmAnnotationReference toAnnotation(EObject ctx, Class<?> annotationType) {
		return toAnnotation(ctx, annotationType, null);
	}
	
	public JvmAnnotationReference toAnnotation(EObject ctx, String annotationTypeName) {
		return toAnnotation(ctx, annotationTypeName, null);
	}
	
	public JvmAnnotationReference toAnnotation(EObject ctx, Class<?> annotationType, Object value) {
		return toAnnotation(ctx, annotationType.getCanonicalName(), value);
	}
	
	public JvmAnnotationReference toAnnotation(EObject ctx, String annotationTypeName, Object value) {
		JvmAnnotationReference result = TypesFactory.eINSTANCE.createJvmAnnotationReference();
		JvmType jvmType = references.findDeclaredType(annotationTypeName, ctx);
		if (!(jvmType instanceof JvmAnnotationType)) {
			throw new IllegalArgumentException("The given class "+ annotationTypeName + " is not an annotation type.");
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
		if (typeRef instanceof JvmParameterizedTypeReference && !typeRef.eIsSet(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE))
			throw new IllegalArgumentException("typeref#type was null");
		return EcoreUtil2.cloneWithProxies(typeRef);
	}

	public <T extends JvmMember> T create(String name, Class<T> clazz, Function1<T, Void> init) {
		T result = create(clazz, init);
		result.setSimpleName(name);
		return result;
	}

	@SuppressWarnings("unchecked")
	protected <T> T create(Class<T> clazz, Function1<T, Void> init) {
		EList<EClassifier> classifiers = TypesFactory.eINSTANCE.getEPackage().getEClassifiers();
		for (EClassifier eClassifier : classifiers) {
			if (eClassifier instanceof EClass && eClassifier.getInstanceClass() == clazz) {
				T result = (T) TypesFactory.eINSTANCE.create((EClass) eClassifier);
				if (init != null)
					init.apply(result);
				return result;
			}
		}
		throw new IllegalArgumentException();
	}
	
	public void body(JvmOperation op, Functions.Function1<ImportManager, ? extends CharSequence> strategy) {
		addCompilationStrategy(op, strategy);
	}
	
	public void initialization(JvmField field, Functions.Function1<ImportManager, ? extends CharSequence> strategy) {
		addCompilationStrategy(field, strategy);
	}
	
	protected void addCompilationStrategy( JvmMember member, Functions.Function1<ImportManager, ? extends CharSequence> strategy) {
		CompilationStrategyAdapter adapter = new CompilationStrategyAdapter();
		adapter.setCompilationStrategy(strategy);
		member.eAdapters().add(adapter);		
	}
	
	public JvmTypeReference newTypeRef(EObject ctx, Class<?> clazz, JvmTypeReference ...typeArgs) {
		return references.getTypeForName(clazz, ctx, typeArgs);
	}
	
	public JvmTypeReference newTypeRef(EObject ctx, String name, JvmTypeReference ...typeArgs) {
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

	protected JvmAnnotationReference getJvmAnnotationReference(XAnnotation anno) {
		JvmAnnotationReference reference = TypesFactory.eINSTANCE.createJvmAnnotationReference();
		final JvmAnnotationType annotation = (JvmAnnotationType) anno.eGet(XAnnotationsPackage.Literals.XANNOTATION__ANNOTATION_TYPE, false);
		reference.setAnnotation(annotation);
		for (XAnnotationElementValuePair val : anno.getElementValuePairs()) {
			JvmAnnotationValue annotationValue = getJvmAnnotationValue(val.getValue());
			JvmOperation op = (JvmOperation) val.eGet(XAnnotationsPackage.Literals.XANNOTATION_ELEMENT_VALUE_PAIR__ELEMENT, false);
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
					throw new IllegalArgumentException("expression "+value+" is not supported in annotation literals");
				if (result == null) {
					result = translator.createValue(expr);
				}
				translator.appendValue(result, expr);
			}
			return result;
		} else {
			AnnotationValueTranslator translator = translator(value);
			if (translator == null)
				throw new IllegalArgumentException("expression "+value+" is not supported in annotation literals");
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
						JvmParameterizedTypeReference reference = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
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
