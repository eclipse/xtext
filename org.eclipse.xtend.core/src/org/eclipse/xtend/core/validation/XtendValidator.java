/*******************************************************************************
 * Copyright (c) 2011, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.validation;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Lists.transform;
import static org.eclipse.xtend.core.validation.IssueCodes.*;
import static org.eclipse.xtend.core.xtend.XtendPackage.Literals.*;
import static org.eclipse.xtext.util.JavaVersion.*;
import static org.eclipse.xtext.util.Strings.*;
import static org.eclipse.xtext.util.Strings.isEmpty;
import static org.eclipse.xtext.xbase.XbasePackage.Literals.*;
import static org.eclipse.xtext.xbase.validation.IssueCodes.*;

import java.lang.annotation.ElementType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.jvmmodel.DispatchHelper;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.richstring.RichStringProcessor;
import org.eclipse.xtend.core.typesystem.LocalClassAwareTypeNames;
import org.eclipse.xtend.core.xtend.AnonymousClass;
import org.eclipse.xtend.core.xtend.RichString;
import org.eclipse.xtend.core.xtend.RichStringElseIf;
import org.eclipse.xtend.core.xtend.RichStringForLoop;
import org.eclipse.xtend.core.xtend.RichStringIf;
import org.eclipse.xtend.core.xtend.XtendAnnotationTarget;
import org.eclipse.xtend.core.xtend.XtendAnnotationType;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendEnum;
import org.eclipse.xtend.core.xtend.XtendExecutable;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFormalParameter;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendInterface;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.core.xtend.XtendVariableDeclaration;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmSpecializedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.util.AnnotationLookup;
import org.eclipse.xtext.common.types.util.DeprecationUtil;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.documentation.IEObjectDocumentationProviderExtension;
import org.eclipse.xtext.documentation.IJavaDocTypeReferenceProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.util.JavaVersion;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ComposedChecks;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.annotations.typing.XAnnotationUtil;
import org.eclipse.xtext.xbase.annotations.validation.XbaseWithAnnotationsValidator;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.compiler.GeneratorConfig;
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider;
import org.eclipse.xtext.xbase.compiler.JavaKeywords;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureNames;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.override.ConflictingDefaultOperation;
import org.eclipse.xtext.xbase.typesystem.override.IOverrideCheckResult.OverrideCheckDetails;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedConstructor;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedExecutable;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedOperation;
import org.eclipse.xtext.xbase.typesystem.override.OverrideHelper;
import org.eclipse.xtext.xbase.typesystem.override.ResolvedFeatures;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.ContextualVisibilityHelper;
import org.eclipse.xtext.xbase.typesystem.util.IVisibilityHelper;
import org.eclipse.xtext.xbase.typesystem.util.RecursionGuard;
import org.eclipse.xtext.xbase.validation.ImplicitReturnFinder;
import org.eclipse.xtext.xbase.validation.ImplicitReturnFinder.Acceptor;
import org.eclipse.xtext.xbase.validation.ProxyAwareUIStrings;
import org.eclipse.xtext.xbase.validation.UIStrings;
import org.eclipse.xtext.xtype.XComputedTypeReference;
import org.eclipse.xtext.xtype.XImportDeclaration;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sebastian Zarnekow
 * @author Sven Efftinge
 * @author Holger Schill
 * @author Stephane Galland
 */
@ComposedChecks(validators = { AnnotationValidation.class })
public class XtendValidator extends XbaseWithAnnotationsValidator {

	@Inject
	private RichStringProcessor richStringProcessor;

	@Inject
	private IXtendJvmAssociations associations;

	@Inject
	private OverrideHelper overrideHelper;

	@Inject
	private DispatchHelper dispatchHelper;

	@Inject
	private XAnnotationUtil annotationUtil;
	
	@Inject 
	private JavaKeywords javaUtils;
	
	@Inject 
	private UIStrings uiStrings;
	
	@Inject
	private ILogicalContainerProvider containerProvider;
	
	@Inject
	private JvmTypeExtensions typeExtensions;
	
	@Inject
	private IJvmModelAssociations jvmModelAssociations;
	
	@Inject
	private IVisibilityHelper visibilityHelper;
	
	@Inject
	private IJavaDocTypeReferenceProvider javaDocTypeReferenceProvider;

	@Inject
	private IScopeProvider scopeProvider;

	@Inject
	private IEObjectDocumentationProvider documentationProvider;

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;
	
	@Inject
	private OperatorMapping operatorMapping;
	
	@Inject
	private ImplicitReturnFinder implicitReturnFinder;
	
	@Inject
	private LocalClassAwareTypeNames localClassAwareTypeNames;
	
	@Inject
	private IBatchTypeResolver batchTypeResolver;
	
	@Inject
	private ProxyAwareUIStrings proxyAwareUIStrings;
	
	@Inject
	private AnnotationLookup annotationLookup;
	
	@Inject
	private IGeneratorConfigProvider generatorConfigProvider;
	
	protected final Set<String> visibilityModifers = ImmutableSet.of("public", "private", "protected", "package");
	
	protected final Set<String> junitAnnotations = ImmutableSet.of(
		// JUnit4 annotations
		"org.junit.Test",
		"org.junit.Before",
		"org.junit.After",
		"org.junit.BeforeClass",
		"org.junit.AfterClass",
		
		// JUnit5 annotations
		"org.junit.jupiter.api.Test",
		"org.junit.jupiter.api.BeforeEach",
		"org.junit.jupiter.api.AfterEach",
		"org.junit.jupiter.api.BeforeAll",
		"org.junit.jupiter.api.AfterAll"
		);
	
	protected final Multimap<Class<?>, ElementType> targetInfos;
	
	{
		ImmutableMultimap.Builder<Class<?>, ElementType> result = ImmutableMultimap.builder();
		result.put(XtendClass.class, ElementType.TYPE);
		result.put(XtendInterface.class, ElementType.TYPE);
		result.put(XtendEnum.class, ElementType.TYPE);
		result.putAll(XtendAnnotationType.class, ElementType.ANNOTATION_TYPE, ElementType.TYPE);
		result.put(XtendField.class, ElementType.FIELD);
		result.put(XtendFunction.class, ElementType.METHOD);
		result.put(XtendParameter.class, ElementType.PARAMETER);
		targetInfos = result.build();
	}

	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> ePackages = newArrayList(super.getEPackages());
		ePackages.add(XtendPackage.eINSTANCE);
		return ePackages;
	}
	
	protected GeneratorConfig getGeneratorConfig(EObject element) {
		GeneratorConfig result = (GeneratorConfig) getContext().get(GeneratorConfig.class);
		if (result == null) {
			result = generatorConfigProvider.get(element);
			getContext().put(GeneratorConfig.class, result);
			if (result.getJavaSourceVersion().isAtLeast(JAVA8)) {
				methodInInterfaceModifierValidator = new ModifierValidator(
						newArrayList("public", "abstract", "static", "def", "override"), this);
			} else {
				methodInInterfaceModifierValidator = new ModifierValidator(
						newArrayList("public", "abstract", "def", "override"), this);
			}
		}
		return result;
	}

	protected boolean hasAnnotation(XtendAnnotationTarget source, Class<?> class1) {
		for (XAnnotation anno : source.getAnnotations()) {
			if (anno != null && anno.getAnnotationType() != null && class1.getName().equals(anno.getAnnotationType().getIdentifier()))
				return true;
 		}
		return false;
	}
	
	@Check
	public void checkValidExtension(XtendField field) {
		if (field.isExtension()) {
			JvmField jvmField = associations.getJvmField(field);
			if (jvmField != null) {
				checkValidExtensionType(jvmField, field, XtendPackage.Literals.XTEND_FIELD__TYPE);
			}
		}
	}
	
	@Check
	public void checkNonRawTypeInferred(XtendField field) {
		if (field.getType() == null) {
			JvmField jvmField = associations.getJvmField(field);
			// field could have been removed by AA, thus the resource is possibly null
			if (jvmField != null && jvmField.eResource() != null) {
				JvmTypeReference fieldType = jvmField.getType();
				validateInferredType(fieldType, field, "The inferred field type ", XTEND_FIELD__NAME);
			}
		}
	}
	
	@Check
	public void checkNonRawTypeInferred(XtendFunction function) {
		if (function.getReturnType() == null) {
			JvmOperation operation = associations.getDirectlyInferredOperation(function);
			// operation could have been removed by AA, thus the resource is possibly null
			if (operation != null && operation.eResource() != null) {
				JvmTypeReference returnType = operation.getReturnType();
				validateInferredType(returnType, function, "The inferred return type ", XTEND_FUNCTION__NAME);
			}
		}
	}
	
	@Check
	public void checkJUnitMethodReturnType(XtendFunction function) {
		JvmOperation operation = associations.getDirectlyInferredOperation(function);
		
		/*
		 * Active annotations could also change the return type.
		 * Checking that the JvmOperation really has a JUnit annotation.
		 */
		if(hasJUnitAnnotation(operation)) {
			LightweightTypeReference actualType = determineReturnType(operation);
			if(actualType !=null && !actualType.isUnknown() && !actualType.isPrimitiveVoid()) {
				String message = String.format("JUnit method %s() must be void but is %s.", function.getName(), actualType.getHumanReadableName());
				EAttribute location = XTEND_FUNCTION__NAME;
				error(message, function, location, INVALID_RETURN_TYPE_IN_CASE_OF_JUNIT_ANNOTATION);
			}
		}
	}
	
	private LightweightTypeReference determineReturnType(JvmOperation operation) {
		// operation could have been removed by AA, thus the resource is possibly null
		if(operation != null && operation.eResource() != null) {
			return batchTypeResolver.resolveTypes(operation).getActualType(operation);
		}
		return null;
	}
	
	private boolean hasJUnitAnnotation(JvmOperation operation) {
		return !annotationUtil.findAnnotations(junitAnnotations, operation).isEmpty();
	}
	
	protected void validateInferredType(JvmTypeReference inferredType, XtendMember member, String messagePrefix,
			EAttribute location) {
		if (inferredType != null) {
			TreeIterator<EObject> iterator = EcoreUtil2.eAll(inferredType);
			while(iterator.hasNext()) {
				EObject next = iterator.next();
				if (next instanceof JvmParameterizedTypeReference) {
					JvmParameterizedTypeReference candidate = (JvmParameterizedTypeReference) next;
					JvmType type = candidate.getType();
					if (type instanceof JvmGenericType && !((JvmGenericType) type).getTypeParameters().isEmpty()) {
						if (candidate.getArguments().isEmpty()) {
							StringBuilder message = new StringBuilder(messagePrefix);
							message = proxyAwareUIStrings.visit(inferredType, message);
							if (message != null) {
								message.append(" uses the raw type ");
								message.append(type.getSimpleName());
								message.append(". References to generic type ");
								message = proxyAwareUIStrings.appendTypeSignature(type, message);
								message.append(" should be parameterized");
								warning(message.toString(), member, location, org.eclipse.xtext.xbase.validation.IssueCodes.RAW_TYPE);
							}
							return;
						}
					}
				} else if (next instanceof XComputedTypeReference) {
					validateInferredType(((XComputedTypeReference) next).getEquivalent(), member, messagePrefix, location);
					iterator.prune();
				}
			}
		}
	}
	
	@Check
	public void checkValidExtension(XtendFormalParameter parameter) {
		// catch clauses validate their types against java.lang.Throwable
		if (parameter.isExtension() && !(parameter.eContainer() instanceof XCatchClause))
			checkValidExtensionType(parameter, parameter, TypesPackage.Literals.JVM_FORMAL_PARAMETER__PARAMETER_TYPE);
	}
	
	@Check
	public void checkValidExtension(XtendVariableDeclaration variableDeclaration) {
		if (variableDeclaration.isExtension())
			checkValidExtensionType(variableDeclaration, variableDeclaration, XbasePackage.Literals.XVARIABLE_DECLARATION__NAME);
	}
	
	@Check
	public void checkValidExtension(XtendParameter parameter) {
		if (parameter.isExtension()) {
			JvmFormalParameter jvmParameter = associations.getJvmParameter(parameter);
			if (jvmParameter != null)
				checkValidExtensionType(jvmParameter, parameter, XtendPackage.Literals.XTEND_PARAMETER__PARAMETER_TYPE);
		}
	}
	
	protected void checkValidExtensionType(JvmIdentifiableElement identifiable, EObject source, EStructuralFeature feature) {
		LightweightTypeReference type = getActualType(identifiable);
		if (type != null && type.isPrimitive()) {
			error(String.format("The primitive type %s is not a valid extension", type.getHumanReadableName()), source, feature, INVALID_EXTENSION_TYPE);
		}
	}

	@Check
	public void checkAnnotationTarget(XAnnotation annotation) {
		JvmType annotationType = annotation.getAnnotationType();
		if (annotationType == null || annotationType.eIsProxy() || !(annotationType instanceof JvmAnnotationType)) {
			return;
		}
		Set<ElementType> targets = annotationUtil.getAnnotationTargets((JvmAnnotationType) annotationType);
		if (targets.isEmpty())
			return;
		final EObject eContainer = getContainingAnnotationTarget(annotation);
		Class<? extends EObject> clazz = eContainer.getClass();
		if (eContainer instanceof XtendField && eContainer.eContainer() instanceof XtendAnnotationType) {
			clazz = XtendFunction.class;
		}
		for (Entry<Class<?>, Collection<ElementType>> mapping : targetInfos.asMap().entrySet()) {
			if (mapping.getKey().isAssignableFrom(clazz)) {
				targets.retainAll(mapping.getValue());
				if (targets.isEmpty()) {
					error("The annotation @" + annotation.getAnnotationType().getSimpleName()
							+ " is disallowed for this location.", annotation, null, INSIGNIFICANT_INDEX,
							ANNOTATION_WRONG_TARGET);
				}
			}
		}
	}
	
	@Check
	public void checkMultipleAnnotations(final XtendAnnotationTarget annotationTarget) {
		if (annotationTarget.getAnnotations().size() <= 1 || !isRelevantAnnotationTarget(annotationTarget)) {
			return;
		}
		
		ImmutableListMultimap<String, XAnnotation> groupByIdentifier = Multimaps.index(annotationTarget.getAnnotations(),
				new Function<XAnnotation, String>() {
					@Override
					public String apply(XAnnotation input) {
						return input.getAnnotationType().getIdentifier();
					}
				});

		for (String qName : groupByIdentifier.keySet()) {
			ImmutableList<XAnnotation> sameType = groupByIdentifier.get(qName);
			if (sameType.size() > 1) {
				JvmType type = sameType.get(0).getAnnotationType();
				if (type instanceof JvmAnnotationType && !type.eIsProxy()
						&& !annotationLookup.isRepeatable((JvmAnnotationType) type)) {
					for (XAnnotation xAnnotation : sameType) {
						error("Multiple annotations of non-repeatable type @"
								+ xAnnotation.getAnnotationType().getSimpleName()
								+ ". Only annotation types marked @Repeatable can be used multiple times at one target.",
								xAnnotation, XAnnotationsPackage.Literals.XANNOTATION__ANNOTATION_TYPE, INSIGNIFICANT_INDEX, ANNOTATION_MULTIPLE);
					}
				}
			}
		}
	}


	protected boolean isRelevantAnnotationTarget(final XtendAnnotationTarget annotationTarget) {
		return any(targetInfos.keySet(), new Predicate<Class<?>>() {
			@Override
			public boolean apply(Class<?> input) {
				return input.isInstance(annotationTarget);
			}
		});
	}

	protected EObject getContainingAnnotationTarget(XAnnotation annotation) {
		final EObject eContainer = annotation.eContainer();
		// skip synthetic container
		if (eContainer.eClass() == XtendPackage.Literals.XTEND_MEMBER || eContainer.eClass() == XtendPackage.Literals.XTEND_TYPE_DECLARATION) {
			return eContainer.eContainer();
		}
		return eContainer;
	}

	@Check
	public void checkNoVoidInDependencyDeclaration(XtendField dep) {
		JvmTypeReference declaredFieldType = dep.getType();
		if (isPrimitiveVoid(declaredFieldType)) {
			error("Primitive void cannot be a dependency.", dep.getType(), null, INVALID_USE_OF_TYPE);
		}
	}
	
	@Check
	public void checkNoTypeNameShadowing(XtendTypeDeclaration type) {
		String name = type.getName();
		if (name != null && name.length() > 0) {
			XtendTypeDeclaration outer = EcoreUtil2.getContainerOfType(type.eContainer(), XtendTypeDeclaration.class);
			while(outer != null) {
				if (name.equals(outer.getName())) {
					acceptError("The nested type " + name + " cannot hide an enclosing type",
							type, XtendPackage.Literals.XTEND_TYPE_DECLARATION__NAME, INSIGNIFICANT_INDEX, INVALID_MEMBER_NAME);
					return;
				}
				outer = EcoreUtil2.getContainerOfType(outer.eContainer(), XtendTypeDeclaration.class);
			}
		}
	}
	
	@Check
	public void checkMemberNamesAreUnique(XtendTypeDeclaration xtendType) {
		final Multimap<String, XtendField> name2field = HashMultimap.create();
		final Multimap<String, XtendTypeDeclaration> name2type = HashMultimap.create();
		final Multimap<JvmType, XtendField> type2extension = HashMultimap.create();
		for (XtendMember member : xtendType.getMembers()) {
			if (member instanceof XtendField) {
				XtendField field = (XtendField) member;
				if (isEmpty(field.getName())) {
					if (field.isExtension()) {
						JvmTypeReference typeReference = field.getType();
						if (typeReference != null) {
							JvmType type = typeReference.getType();
							if (type != null)
								type2extension.put(type, field);
						}
					}
				} else {
					name2field.put(field.getName(), field);
				}
			} else if (member instanceof XtendTypeDeclaration) {
				String name = ((XtendTypeDeclaration) member).getName();
				if (name != null && name.length() > 0) {
					name2type.put(name, (XtendTypeDeclaration) member);
				}
			}
		}
		for(String name: name2field.keySet()) {
			Collection<XtendField> fields = name2field.get(name);
			if(fields.size() >1) {
				for(XtendField field: fields)
					error("Duplicate field " + name, field, XtendPackage.Literals.XTEND_FIELD__NAME, DUPLICATE_FIELD);
			}
		}
		for(String name: name2type.keySet()) {
			Collection<XtendTypeDeclaration> types = name2type.get(name);
			if(types.size() >1) {
				for(XtendTypeDeclaration type: types)
					error("Duplicate nested type " + name, type, XtendPackage.Literals.XTEND_TYPE_DECLARATION__NAME, DUPLICATE_TYPE_NAME);
			}
		}
		for(JvmType type: type2extension.keySet()) {
			Collection<XtendField> fields = type2extension.get(type);
			if(fields.size() >1) {
				for(XtendField field: fields)
					error("Duplicate extension with same type", field, XTEND_FIELD__TYPE, DUPLICATE_FIELD);
			}
		}
	}


	@Check
	public void checkXtendParameterNotPrimitiveVoid(XtendParameter param) {
		if (isPrimitiveVoid(param.getParameterType())) {
			XtendFunction function = (XtendFunction) (param.eContainer() instanceof XtendFunction ? param.eContainer()
					: null);
			if (function != null)
				error("void is an invalid type for the parameter " + param.getName() + " of the method "
						+ function.getName(), param.getParameterType(), null, INVALID_USE_OF_TYPE);
			else
				error("void is an invalid type for the parameter " + param.getName(), param.getParameterType(), null,
						INVALID_USE_OF_TYPE);
		}
	}
	
	@Check
	public void checkVarArgIsNotExtension(XtendParameter param) {
		if (param.isVarArg() && param.isExtension()) {
			error("A vararg may not be an extension.", param, XTEND_PARAMETER__EXTENSION, INVALID_USE_OF_VAR_ARG);
		}
	}
	
	@Check
	public void checkVarArgComesLast(XtendParameter param) {
		if (param.isVarArg()) {
			@SuppressWarnings("unchecked")
			List<XtendParameter> params = (List<XtendParameter>) param.eContainer().eGet(param.eContainingFeature());
			if (param != Iterables.getLast(params)) {
				error("A vararg must be the last parameter.", param, XTEND_PARAMETER__VAR_ARG, INVALID_USE_OF_VAR_ARG);
			}
		}
	}
	
	@Check
	public void checkClassPath(XtendFile xtendFile) {
		TypeReferences typeReferences = getServices().getTypeReferences();
		final JvmGenericType listType = (JvmGenericType) typeReferences.findDeclaredType(List.class, xtendFile);
		if (listType == null || listType.getTypeParameters().isEmpty()) {
			error("Couldn't find a JDK 1.5 or higher on the project's classpath.", xtendFile, XTEND_FILE__PACKAGE,
					IssueCodes.JDK_NOT_ON_CLASSPATH);
		} else if (typeReferences.findDeclaredType(ToStringBuilder.class, xtendFile) == null) {
			error("Couldn't find the mandatory library 'org.eclipse.xtext.xbase.lib' 2.8.0 or higher on the project's classpath.",
					xtendFile, XTEND_FILE__PACKAGE, IssueCodes.XBASE_LIB_NOT_ON_CLASSPATH);
		}
	}
	
	@Check
	public void checkWhitespaceInRichStrings(RichString richString) {
		// don't check the indentation of nested rich strings in 
		// IF and FOR individually
		if (richString.eContainer() instanceof RichStringIf) {
			RichStringIf container = (RichStringIf) richString.eContainer();
			if (container.getThen() == richString || container.getElse() == richString)
				return;
		}
		if (richString.eContainer() instanceof RichStringElseIf) {
			RichStringElseIf container = (RichStringElseIf) richString.eContainer();
			if (container.getThen() == richString)
				return;
		}
		if (richString.eContainer() instanceof RichStringForLoop) {
			RichStringForLoop container = (RichStringForLoop) richString.eContainer();
			if (container.getEachExpression() == richString)
				return;
		}
		doCheckWhitespaceIn(richString);
	}

	protected void doCheckWhitespaceIn(RichString richString) {
		ValidatingRichStringAcceptor helper = new ValidatingRichStringAcceptor(this);
		richStringProcessor.process(richString, helper, helper);
	}

	@Check
	public void checkSuperTypes(XtendClass xtendClass) {
		JvmTypeReference superClass = xtendClass.getExtends();
		if (superClass != null && superClass.getType() != null) {
			if (!(superClass.getType() instanceof JvmGenericType)
					|| ((JvmGenericType) superClass.getType()).isInterface()) {
				error("Superclass must be a class", XTEND_CLASS__EXTENDS, CLASS_EXPECTED);
			} else {
				if (((JvmGenericType) superClass.getType()).isFinal()) {
					error("Attempt to override final class", XTEND_CLASS__EXTENDS, OVERRIDDEN_FINAL);
				}
				checkWildcardSupertype(xtendClass, superClass, XTEND_CLASS__EXTENDS, INSIGNIFICANT_INDEX);
			}
		}
		for (int i = 0; i < xtendClass.getImplements().size(); ++i) {
			JvmTypeReference implementedType = xtendClass.getImplements().get(i);
			if (!isInterface(implementedType.getType()) && !isAnnotation(implementedType.getType())) {
				error("Implemented interface must be an interface", XTEND_CLASS__IMPLEMENTS, i, INTERFACE_EXPECTED);
			}
			checkWildcardSupertype(xtendClass, implementedType, XTEND_CLASS__IMPLEMENTS, i);
		}
		JvmGenericType inferredType = associations.getInferredType(xtendClass);
		if (inferredType != null && hasCycleInHierarchy(inferredType, Sets.<JvmGenericType> newHashSet())) {
			error("The inheritance hierarchy of " + notNull(xtendClass.getName()) + " contains cycles",
					XTEND_TYPE_DECLARATION__NAME, CYCLIC_INHERITANCE);
		}
	}

	@Check
	public void checkSuperTypes(XtendInterface xtendInterface) {
		for (int i = 0; i < xtendInterface.getExtends().size(); ++i) {
			JvmTypeReference extendedType = xtendInterface.getExtends().get(i);
			if (!isInterface(extendedType.getType()) && !isAnnotation(extendedType.getType())) {
				error("Extended interface must be an interface", XTEND_INTERFACE__EXTENDS, i, INTERFACE_EXPECTED);
			}
			checkWildcardSupertype(xtendInterface, extendedType, XTEND_INTERFACE__EXTENDS, i);
		}
		JvmGenericType inferredType = associations.getInferredType(xtendInterface);
		if(inferredType != null && hasCycleInHierarchy(inferredType, Sets.<JvmGenericType> newHashSet())) {
			error("The inheritance hierarchy of " + notNull(xtendInterface.getName()) + " contains cycles",
					XTEND_TYPE_DECLARATION__NAME, CYCLIC_INHERITANCE);
		}
	}
	
	protected boolean isAnnotation(JvmType jvmType) {
		return jvmType instanceof JvmAnnotationType;
	}
	
	@Check
	public void checkSuperTypes(AnonymousClass anonymousClass) {
		JvmGenericType inferredType = associations.getInferredType(anonymousClass);
		if (inferredType != null) {
			JvmTypeReference superTypeRef = Iterables.getLast(inferredType.getSuperTypes());
			JvmType superType = superTypeRef.getType();
			if(superType instanceof JvmGenericType && ((JvmGenericType) superType).isFinal())
				error("Attempt to override final class", anonymousClass.getConstructorCall(), XCONSTRUCTOR_CALL__CONSTRUCTOR, INSIGNIFICANT_INDEX, OVERRIDDEN_FINAL);
		}
	}
	
	@Check
	public void checkStaticMembers(AnonymousClass anonymousClass) {
		for (XtendMember member : anonymousClass.getMembers()) {
			if (member.isStatic()) {
				if (member instanceof XtendExecutable) {
					error("A method of an anonymous class cannot be static.", member, XTEND_MEMBER__MODIFIERS,
							INSIGNIFICANT_INDEX, ANONYMOUS_CLASS_STATIC_METHOD);
				} else if (member instanceof XtendField) {
					JvmField field = (JvmField) jvmModelAssociations.getPrimaryJvmElement(member);
					if (!member.isFinal()) {
						error("A static field of an anonymous class must be final.", member, XTEND_MEMBER__MODIFIERS,
								INSIGNIFICANT_INDEX, ANONYMOUS_CLASS_STATIC_FIELD);
					} else if (!field.isConstant()) {
						error("A static field of an anonymous class must be initialized with a constant expression.",
								member, XTEND_FIELD__INITIAL_VALUE, INSIGNIFICANT_INDEX, ANONYMOUS_CLASS_STATIC_FIELD);
					}
				}
			}
		}
	}
	
	protected void checkWildcardSupertype(XtendTypeDeclaration xtendType, JvmTypeReference superTypeReference,
			EStructuralFeature feature, int index) { 
		if(isInvalidWildcard(superTypeReference)) 
			error("The type " 
					+ notNull(xtendType.getName()) 
					+ " cannot extend or implement "
					+ superTypeReference.getIdentifier() 
					+ ". A supertype may not specify any wildcard", feature, index, WILDCARD_IN_SUPERTYPE);
	}
	
	protected boolean isInvalidWildcard(JvmTypeReference typeRef) {
		if (typeRef instanceof JvmWildcardTypeReference)
			return true;
		else if (typeRef instanceof JvmParameterizedTypeReference) {
			for(JvmTypeReference typeArgument: ((JvmParameterizedTypeReference) typeRef).getArguments()) {
				if(typeArgument instanceof JvmWildcardTypeReference) 
					return true;
			}
		} else if (typeRef instanceof JvmSpecializedTypeReference) {
			return isInvalidWildcard(((JvmSpecializedTypeReference) typeRef).getEquivalent());
		}
		return false;
	}

	protected boolean hasCycleInHierarchy(JvmGenericType type, Set<JvmGenericType> processedSuperTypes) {
		JvmDeclaredType container = type;
		do {
			if (processedSuperTypes.contains(container))
				return true;
			container = container.getDeclaringType();
		} while (container != null);
		processedSuperTypes.add(type);
		for (JvmTypeReference superTypeRef : type.getSuperTypes()) {
			if (superTypeRef.getType() instanceof JvmGenericType) {
				if (hasCycleInHierarchy((JvmGenericType) superTypeRef.getType(), processedSuperTypes))
					return true;
			}
		}
		processedSuperTypes.remove(type);
		return false;
	}
	
	@Check
	public void checkDuplicateAndOverriddenFunctions(XtendTypeDeclaration xtendType) {
		final JvmDeclaredType inferredType = associations.getInferredType(xtendType);
		if (inferredType instanceof JvmGenericType) {
			JavaVersion targetVersion = getGeneratorConfig(xtendType).getJavaSourceVersion();
			ResolvedFeatures resolvedFeatures = overrideHelper.getResolvedFeatures(inferredType, targetVersion);
			
			Set<EObject> flaggedOperations = Sets.newHashSet();
			doCheckDuplicateExecutables((JvmGenericType) inferredType, resolvedFeatures, flaggedOperations);
			doCheckOverriddenMethods(xtendType, (JvmGenericType) inferredType, resolvedFeatures, flaggedOperations);
			doCheckFunctionOverrides(resolvedFeatures, flaggedOperations);
		}
	}
	
	protected void doCheckDuplicateExecutables(JvmGenericType inferredType,	final ResolvedFeatures resolvedFeatures, Set<EObject> flaggedOperations) {
		List<IResolvedOperation> declaredOperations = resolvedFeatures.getDeclaredOperations();
		doCheckDuplicateExecutables(inferredType, declaredOperations, new Function<String, List<IResolvedOperation>>() {
			@Override
			public List<IResolvedOperation> apply(String erasedSignature) {
				return resolvedFeatures.getDeclaredOperations(erasedSignature);
			}
		}, flaggedOperations);
		final List<IResolvedConstructor> declaredConstructors = resolvedFeatures.getDeclaredConstructors();
		doCheckDuplicateExecutables(inferredType, declaredConstructors, new Function<String, List<IResolvedConstructor>>() {
			@Override
			public List<IResolvedConstructor> apply(String erasedSignature) {
				if (declaredConstructors.size() == 1) {
					if (erasedSignature.equals(declaredConstructors.get(0).getResolvedErasureSignature())) {
						return declaredConstructors;
					}
					return Collections.emptyList();
				}
				List<IResolvedConstructor> result = Lists.newArrayListWithCapacity(declaredConstructors.size());
				for(IResolvedConstructor constructor: declaredConstructors) {
					if (erasedSignature.equals(constructor.getResolvedErasureSignature())) {
						result.add(constructor);
					}
				}
				return result;
			}
		}, flaggedOperations);
	}

	protected <Executable extends IResolvedExecutable> void doCheckDuplicateExecutables(JvmGenericType inferredType,
			List<Executable> declaredOperations, Function<String, List<Executable>> bySignature, Set<EObject> flaggedOperations) {
		Set<Executable> processed = Sets.newHashSet();
		for(Executable declaredExecutable: declaredOperations) {
			if (!processed.contains(declaredExecutable)) {
				List<Executable> sameErasure = bySignature.apply(declaredExecutable.getResolvedErasureSignature());
				if (sameErasure.size() > 1) {
					Multimap<String, Executable> perSignature = HashMultimap.create(sameErasure.size(), 2);
					outer: for(Executable executable: sameErasure) {
						for(LightweightTypeReference parameterType: executable.getResolvedParameterTypes()) {
							if (parameterType.isUnknown())
								continue outer;
						}
						perSignature.put(executable.getResolvedSignature(), executable);
					}
					if (perSignature.size() > 1) {
						for(Collection<Executable> sameSignature: perSignature.asMap().values()) {
							for(Executable operationWithSameSignature: sameSignature) {
								JvmExecutable executable = operationWithSameSignature.getDeclaration();
								EObject otherSource = associations.getPrimarySourceElement(executable);
								if (flaggedOperations.add(otherSource)) {
									if (sameSignature.size() > 1) {
										error("Duplicate " + typeLabel(executable) + " " + operationWithSameSignature.getSimpleSignature()
												+ " in type " + inferredType.getSimpleName(), otherSource,
												nameFeature(otherSource), DUPLICATE_METHOD);
									} else {
										error("The " + typeLabel(executable) + " " + operationWithSameSignature.getSimpleSignature()
												+ " has the same erasure "
												+ operationWithSameSignature.getResolvedErasureSignature()
												+ " as another " + typeLabel(executable) + " in type " + inferredType.getSimpleName(), otherSource,
												nameFeature(otherSource), DUPLICATE_METHOD);
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	protected String typeLabel(JvmExecutable executable) {
		if (executable instanceof JvmOperation) 
			return "method";
		else if(executable instanceof JvmConstructor) 
			return "constructor";
		else 
			return "?";
	}
	
	protected EStructuralFeature nameFeature(EObject member) {
		if (member instanceof XtendFunction) 
			return XTEND_FUNCTION__NAME;
		else if(member instanceof XtendConstructor)
			return null;
		else if(member instanceof XtendField)
			return XTEND_FIELD__NAME;
		else
			return null;
	}
	
	protected EStructuralFeature exceptionsFeature(EObject member) {
		if (member instanceof XtendExecutable) 
			return XTEND_EXECUTABLE__EXCEPTIONS;
		else
			return null;
	}
	
	protected EStructuralFeature returnTypeFeature(EObject member) {
		if (member instanceof XtendFunction) 
			return XTEND_FUNCTION__RETURN_TYPE;
		else
			return null;
	}
	
	protected void doCheckOverriddenMethods(XtendTypeDeclaration xtendType, JvmGenericType inferredType, ResolvedFeatures resolvedFeatures,
			Set<EObject> flaggedOperations) {
		List<IResolvedOperation> operationsMissingImplementation = null;
		boolean doCheckAbstract = !inferredType.isAbstract();
		if (doCheckAbstract) {
			operationsMissingImplementation = Lists.newArrayList();
		}
		IVisibilityHelper visibilityHelper = new ContextualVisibilityHelper(this.visibilityHelper, resolvedFeatures.getType());
		boolean flaggedType = false;
		for (IResolvedOperation operation : resolvedFeatures.getAllOperations()) {
			JvmDeclaredType operationDeclaringType = operation.getDeclaration().getDeclaringType();
			if (operationDeclaringType != inferredType) {
				if (operationsMissingImplementation != null && operation.getDeclaration().isAbstract()) {
					operationsMissingImplementation.add(operation);
				}
				if (visibilityHelper.isVisible(operation.getDeclaration())) {
					String erasureSignature = operation.getResolvedErasureSignature();
					List<IResolvedOperation> declaredOperationsWithSameErasure = resolvedFeatures.getDeclaredOperations(erasureSignature);
					for (IResolvedOperation localOperation : declaredOperationsWithSameErasure) {
						if (!localOperation.isOverridingOrImplementing(operation.getDeclaration()).isOverridingOrImplementing()) {
							EObject source = findPrimarySourceElement(localOperation);
							if (operation.getDeclaration().isStatic() && !localOperation.getDeclaration().isStatic()) {
								if (!isInterface(operationDeclaringType)) {
									if (flaggedOperations.add(source)) {
										error("The instance method "
												+ localOperation.getSimpleSignature()
												+ " cannot override the static method "
												+ operation.getSimpleSignature() + " of type "
												+ getDeclaratorName(operation.getDeclaration()) + ".",
												source, nameFeature(source), DUPLICATE_METHOD);
									}
								}
							} else if (!operation.getDeclaration().isStatic() && localOperation.getDeclaration().isStatic()) {
								if (flaggedOperations.add(source)) {
									error("The static method "
											+ localOperation.getSimpleSignature()
											+ " cannot hide the instance method "
											+ operation.getSimpleSignature() + " of type "
											+ getDeclaratorName(operation.getDeclaration()) + ".",
											source, nameFeature(source), DUPLICATE_METHOD);
								}
							} else if (flaggedOperations.add(source)) {
								error("Name clash: The method "
										+ localOperation.getSimpleSignature() + " of type "
										+ inferredType.getSimpleName()
										+ " has the same erasure as "
										+ operation.getSimpleSignature() + " of type "
										+ getDeclaratorName(operation.getDeclaration()) + " but does not override it.",
										source, nameFeature(source), DUPLICATE_METHOD);
							}
						}
					}
					if (operation instanceof ConflictingDefaultOperation
							&& contributesToConflict(inferredType, (ConflictingDefaultOperation) operation) && !flaggedType) {
						IResolvedOperation conflictingOperation = ((ConflictingDefaultOperation) operation).getConflictingOperations()
								.get(0);
						// Include the declaring class in the issue code in order to give better quick fixes
						String[] uris = new String[] {
								getDeclaratorName(operation.getDeclaration()) + "|"
										+ EcoreUtil.getURI(operation.getDeclaration()).toString(),
								getDeclaratorName(conflictingOperation.getDeclaration()) + "|"
										+ EcoreUtil.getURI(conflictingOperation.getDeclaration()).toString() };
						if (!operation.getDeclaration().isAbstract() && !conflictingOperation.getDeclaration().isAbstract()) {
							error("The type " + inferredType.getSimpleName() + " inherits multiple implementations of the method "
									+ conflictingOperation.getSimpleSignature() + " from "
									+ getDeclaratorName(conflictingOperation.getDeclaration()) + " and "
									+ getDeclaratorName(operation.getDeclaration()) + ".", xtendType,
									XtendPackage.Literals.XTEND_TYPE_DECLARATION__NAME, CONFLICTING_DEFAULT_METHODS, uris);
						} else {
							// At least one of the operations is non-abstract
							IResolvedOperation abstractOp, nonabstractOp;
							if (operation.getDeclaration().isAbstract()) {
								abstractOp = operation;
								nonabstractOp = conflictingOperation;
							} else {
								abstractOp = conflictingOperation;
								nonabstractOp = operation;
							}
							error("The non-abstract method " + nonabstractOp.getSimpleSignature() + " inherited from "
									+ getDeclaratorName(nonabstractOp.getDeclaration()) + " conflicts with the method "
									+ abstractOp.getSimpleSignature() + " inherited from " + getDeclaratorName(abstractOp.getDeclaration())
									+ ".", xtendType, XtendPackage.Literals.XTEND_TYPE_DECLARATION__NAME, CONFLICTING_DEFAULT_METHODS,
									uris);
						}
						flaggedType = true;
					}
				}
			}
		}
		if (operationsMissingImplementation != null && !operationsMissingImplementation.isEmpty() && !flaggedType) {
			reportMissingImplementations(xtendType, inferredType, operationsMissingImplementation);
		}
	}
	
	/**
	 * Determine whether the given type contributes to the conflict caused by the given default interface implementation.
	 */
	private boolean contributesToConflict(JvmGenericType rootType, ConflictingDefaultOperation conflictingDefaultOperation) {
		Set<JvmDeclaredType> involvedInterfaces = Sets.newHashSet();
		involvedInterfaces.add(conflictingDefaultOperation.getDeclaration().getDeclaringType());
		for (IResolvedOperation conflictingOperation : conflictingDefaultOperation.getConflictingOperations()) {
			involvedInterfaces.add(conflictingOperation.getDeclaration().getDeclaringType());
		}
		RecursionGuard<JvmDeclaredType> recursionGuard = new RecursionGuard<JvmDeclaredType>();
		if (rootType.isInterface()) {
			int contributingCount = 0;
			for (JvmTypeReference typeRef : rootType.getExtendedInterfaces()) {
				JvmType rawType = typeRef.getType();
				if (rawType instanceof JvmDeclaredType && contributesToConflict((JvmDeclaredType) rawType, involvedInterfaces, recursionGuard)) {
					contributingCount++;
				}
			}
			return contributingCount >= 2;
		} else {
			return contributesToConflict(rootType, involvedInterfaces, recursionGuard);
		}
	}
	
	private boolean contributesToConflict(JvmDeclaredType type, Set<JvmDeclaredType> involvedInterfaces,
			RecursionGuard<JvmDeclaredType> guard) {
		if (!guard.tryNext(type)) {
			return false;
		}
		if (involvedInterfaces.contains(type)) {
			return true;
		}
		for (JvmTypeReference typeRef : type.getExtendedInterfaces()) {
			JvmType rawType = typeRef.getType();
			if (rawType instanceof JvmDeclaredType && contributesToConflict((JvmDeclaredType) rawType, involvedInterfaces, guard)) {
				return true;
			}
		}
		return false;
	}
	
	protected void reportMissingImplementations(XtendTypeDeclaration xtendClass, JvmGenericType inferredType, List<IResolvedOperation> operationsMissingImplementation) {
		StringBuilder errorMsg = new StringBuilder();
		String name = xtendClass.getName();
		boolean needsNewLine = operationsMissingImplementation.size() > 1;
		if (xtendClass.isAnonymous()) {
			JvmTypeReference superType = Iterables.getLast(inferredType.getSuperTypes());
			errorMsg.append("The anonymous subclass of ").append(superType.getSimpleName());
			errorMsg.append(" does not implement ");
		} else {
			errorMsg.append("The class ").append(name);	
			errorMsg.append(" must be defined abstract because it does not implement ");
		}
			if (needsNewLine) {
				errorMsg.append("its inherited abstract methods ");
			}
		IResolvedOperation operation;
		for(int i=0; i<operationsMissingImplementation.size() && i<3; ++i) {
			operation = operationsMissingImplementation.get(i);
			if(needsNewLine)
				errorMsg.append("\n- ");
			errorMsg.append(operation.getSimpleSignature());
		}
		int numUnshownOperations = operationsMissingImplementation.size() - 3;
		if(numUnshownOperations >0)
			errorMsg.append("\nand " +  numUnshownOperations + " more.");
		List<String> uris = transform(operationsMissingImplementation, new Function<IResolvedOperation, String>() {
			@Override
			public String apply(IResolvedOperation from) {
				return EcoreUtil.getURI(from.getDeclaration()).toString();
			}
		});
		if (xtendClass.isAnonymous()) {
			error(errorMsg.toString(), xtendClass, ANONYMOUS_CLASS__CONSTRUCTOR_CALL, ANONYMOUS_CLASS_MISSING_MEMBERS, 
					toArray(uris, String.class));
		} else {
			error(errorMsg.toString(), xtendClass, XTEND_TYPE_DECLARATION__NAME, CLASS_MUST_BE_ABSTRACT, 
							toArray(uris, String.class));
		}
	}
	
	protected void doCheckFunctionOverrides(ResolvedFeatures resolvedFeatures, Set<EObject> flaggedOperations) {
		for(IResolvedOperation operation: resolvedFeatures.getDeclaredOperations()) {
			doCheckFunctionOverrides(operation, flaggedOperations);
		}
	}

	protected void doCheckFunctionOverrides(IResolvedOperation operation, Set<EObject> flaggedOperations) {
		EObject sourceElement = findPrimarySourceElement(operation);
		if (sourceElement != null) {
			List<IResolvedOperation> allInherited = operation.getOverriddenAndImplementedMethods();
			if (allInherited.isEmpty()) {
				if (sourceElement instanceof XtendFunction && flaggedOperations.add(sourceElement)) {
					XtendFunction function = (XtendFunction) sourceElement;
					if (function.isOverride()) {
						error("The method "+ operation.getSimpleSignature() +" of type "+getDeclaratorName(operation.getDeclaration())+" must override a superclass method.", 
								function, XTEND_MEMBER__MODIFIERS, function.getModifiers().indexOf("override"), OBSOLETE_OVERRIDE);
					} else {
						for (XAnnotation anno : function.getAnnotations()) {
							if (anno != null && anno.getAnnotationType() != null && Override.class.getName().equals(anno.getAnnotationType().getIdentifier())) {
								error("Superfluous @Override annotation", anno, null, OBSOLETE_ANNOTATION_OVERRIDE);
							}
						}
					}
				}
			} else if (flaggedOperations.add(sourceElement)) {
				doCheckFunctionOverrides(sourceElement, operation, allInherited);
			}
		}
	}

	protected void doCheckFunctionOverrides(EObject sourceElement, IResolvedOperation resolved,
			List<IResolvedOperation> allInherited) {
		boolean overrideProblems = false;
		List<IResolvedOperation> exceptionMismatch = null;
		for(IResolvedOperation inherited: allInherited) {
			if (inherited.getOverrideCheckResult().hasProblems()) {
				overrideProblems = true;
				EnumSet<OverrideCheckDetails> details = inherited.getOverrideCheckResult().getDetails();
				if (details.contains(OverrideCheckDetails.IS_FINAL)) {
					error("Attempt to override final method " + inherited.getSimpleSignature(), sourceElement,
							nameFeature(sourceElement), OVERRIDDEN_FINAL);
				} else if (details.contains(OverrideCheckDetails.REDUCED_VISIBILITY)) {
					error("Cannot reduce the visibility of the overridden method " + inherited.getSimpleSignature(),
							sourceElement, nameFeature(sourceElement), OVERRIDE_REDUCES_VISIBILITY);
				} else if (details.contains(OverrideCheckDetails.EXCEPTION_MISMATCH)) {
					if (exceptionMismatch == null)
						exceptionMismatch = Lists.newArrayListWithCapacity(allInherited.size());
					exceptionMismatch.add(inherited);
				} else if (details.contains(OverrideCheckDetails.RETURN_MISMATCH)) {
					error("The return type is incompatible with " + inherited.getSimpleSignature(), sourceElement,
							returnTypeFeature(sourceElement), INCOMPATIBLE_RETURN_TYPE);
				} else if (details.contains(OverrideCheckDetails.SYNCHRONIZED_MISMATCH)) {
					warning("The overridden method is synchronized, the current one is not synchronized.", sourceElement,
							nameFeature(sourceElement), MISSING_SYNCHRONIZED);
				}
			}
		}
		if (exceptionMismatch != null) {
			createExceptionMismatchError(resolved, sourceElement, exceptionMismatch);
		}
		if (sourceElement instanceof XtendFunction) {
			XtendFunction function = (XtendFunction) sourceElement;
			if (!overrideProblems && !function.isOverride() && !function.isStatic()) {
				error("The method " + resolved.getSimpleSignature() + " of type " + getDeclaratorName(resolved) +
						" must use override keyword since it actually overrides a supertype method.", function,
						XTEND_FUNCTION__NAME, MISSING_OVERRIDE);
			} 
			if (!overrideProblems && function.isOverride() && function.isStatic()) {
				for(IResolvedOperation inherited: allInherited) {
					error("The method " + resolved.getSimpleSignature() + " of type " + getDeclaratorName(resolved) + 
							" shadows the method " + resolved.getSimpleSignature() + " of type " + getDeclaratorName(inherited) + 
							", but does not override it.", function, XTEND_FUNCTION__NAME, function.getModifiers().indexOf("override"), OBSOLETE_OVERRIDE);
				}
			}
			if (function.isOverride()) {
				for (XAnnotation anno : function.getAnnotations()) {
					if (anno != null && anno.getAnnotationType() != null && Override.class.getName().equals(anno.getAnnotationType().getIdentifier())) {
						warning("Superfluous @Override annotation", anno, null, OBSOLETE_ANNOTATION_OVERRIDE);
					}
				}
			}
		}
	}

	protected String getDeclaratorName(IResolvedOperation resolved) {
		return getDeclaratorName(resolved.getDeclaration());
	}
	
	protected void createExceptionMismatchError(IResolvedOperation operation, EObject sourceElement,
			List<IResolvedOperation> exceptionMismatch) {
		List<LightweightTypeReference> exceptions = operation.getIllegallyDeclaredExceptions();
		StringBuilder message = new StringBuilder(100);
		message.append("The declared exception");
		if (exceptions.size() > 1) {
			message.append('s');
		}
		message.append(' ');
		for(int i = 0; i < exceptions.size(); i++) {
			if (i != 0) {
				if (i != exceptions.size() - 1)
					message.append(", ");
				else
					message.append(" and ");
			}
			message.append(exceptions.get(i).getHumanReadableName());
		}
		if (exceptions.size() > 1) {
			message.append(" are");
		} else {
			message.append(" is");
		}
		message.append(" not compatible with throws clause in ");
		for(int i = 0; i < exceptionMismatch.size(); i++) {
			if (i != 0) {
				if (i != exceptionMismatch.size() - 1)
					message.append(", ");
				else
					message.append(" and ");
			}
			IResolvedOperation resolvedOperation = exceptionMismatch.get(i);
			message.append(getDeclaratorName(resolvedOperation));
			message.append('.');
			message.append(exceptionMismatch.get(i).getSimpleSignature());
		}
		error(message.toString(), sourceElement, exceptionsFeature(sourceElement), INCOMPATIBLE_THROWS_CLAUSE);
	}

	protected EObject findPrimarySourceElement(IResolvedOperation operation) {
		return associations.getPrimarySourceElement(operation.getDeclaration());
	}
	
	protected boolean isMorePrivateThan(JvmVisibility o1, JvmVisibility o2) {
		if (o1 == o2) {
			return false;
		} else {
			switch (o1) {
				case DEFAULT:
					return o2 != JvmVisibility.PRIVATE;
				case PRIVATE:
					return true;
				case PROTECTED:
					return o2 == JvmVisibility.PUBLIC;
				case PUBLIC:
					return false;
				default:
					throw new IllegalArgumentException("Unknown JvmVisibility " + o1);
			}
		}
	}

	@Check
	public void checkDefaultSuperConstructor(XtendClass xtendClass) {
		JvmGenericType inferredType = associations.getInferredType(xtendClass);
		if (inferredType == null)
			return;
		Iterable<JvmConstructor> constructors = filter(inferredType.getMembers(), JvmConstructor.class);
		if(inferredType.getExtendedClass() != null) {
			JvmType superType = inferredType.getExtendedClass().getType();
			if(superType instanceof JvmGenericType) {
				Iterable<JvmConstructor> superConstructors = ((JvmGenericType) superType).getDeclaredConstructors();
				for(JvmConstructor superConstructor: superConstructors) {
					if(superConstructor.getParameters().isEmpty()) 
						// there is a default super constructor. nothing more to check
						return;
				}
				if(size(constructors) == 1 && typeExtensions.isSingleSyntheticDefaultConstructor(constructors.iterator().next())) {
					List<String> issueData = newArrayList();
					for(JvmConstructor superConstructor:superConstructors) {
						issueData.add(EcoreUtil.getURI(superConstructor).toString());
						issueData.add(doGetReadableSignature(xtendClass.getName(), superConstructor.getParameters()));
					}
					error("No default constructor in super type " + superType.getSimpleName() + "." +
							xtendClass.getName() + " must define an explicit constructor.",
							xtendClass, XTEND_TYPE_DECLARATION__NAME, MISSING_CONSTRUCTOR, toArray(issueData, String.class));
				} else {
					for(JvmConstructor constructor: constructors) {
						XExpression expression = containerProvider.getAssociatedExpression(constructor);
						if (expression instanceof XBlockExpression) {
							List<XExpression> expressions = ((XBlockExpression) expression).getExpressions();
							if(expressions.isEmpty() || !isDelegateConstructorCall(expressions.get(0))) {
								EObject source = associations.getPrimarySourceElement(constructor);
								error("No default constructor in super type " + superType.getSimpleName() 
										+ ". Another constructor must be invoked explicitly.",
										source, null, MUST_INVOKE_SUPER_CONSTRUCTOR);
							}
						}
					}
				}
			}
		} 
	}

	protected boolean isDelegateConstructorCall(XExpression expression) {
		if(expression instanceof XFeatureCall) {
			JvmIdentifiableElement feature = ((XFeatureCall)expression).getFeature();
			return (feature != null && !feature.eIsProxy() && feature instanceof JvmConstructor);
		}
		return false;
	}

	protected boolean isInterface(JvmDeclaredType type) {
		return type instanceof JvmGenericType && ((JvmGenericType) type).isInterface();
	}

	protected String canonicalName(JvmIdentifiableElement element) {
		return (element != null) ? notNull(element.getIdentifier()) : null;
	}

	protected String getReadableSignature(JvmExecutable executable) {
		if (executable == null)
			return "null";
		return doGetReadableSignature(executable.getSimpleName(), executable.getParameters());
	}

	protected String doGetReadableSignature(String simpleName, List<JvmFormalParameter> parameters) {
		return getReadableSignature(simpleName,
				Lists.transform(parameters, new Function<JvmFormalParameter, JvmTypeReference>() {
					@Override
					public JvmTypeReference apply(JvmFormalParameter from) {
						return from.getParameterType();
					}
				}));
	}

	protected String getReadableSignature(String elementName, List<JvmTypeReference> parameterTypes) {
		StringBuilder result = new StringBuilder(elementName);
		result.append('(');
		for (int i = 0; i < parameterTypes.size(); i++) {
			if (i != 0) {
				result.append(", ");
			}
			JvmTypeReference parameterType = parameterTypes.get(i);
			if (parameterType != null)
				result.append(parameterType.getSimpleName());
			else
				result.append("null");
		}
		result.append(')');
		return result.toString();
	}

	@Check
	public void checkParameterNames(XtendFunction function) {
		for (int i = 0; i < function.getParameters().size(); ++i) {
			String leftParameterName = function.getParameters().get(i).getName();
			for (int j = i + 1; j < function.getParameters().size(); ++j) {
				if (equal(leftParameterName, function.getParameters().get(j).getName())) {
					error("Duplicate parameter " + leftParameterName, XTEND_EXECUTABLE__PARAMETERS, i, DUPLICATE_PARAMETER_NAME);
					error("Duplicate parameter " + leftParameterName, XTEND_EXECUTABLE__PARAMETERS, j, DUPLICATE_PARAMETER_NAME);
				}
			}
			if (function.getCreateExtensionInfo() != null) {
				if (equal(leftParameterName, function.getCreateExtensionInfo().getName())) {
					error("Duplicate parameter " + leftParameterName, XTEND_EXECUTABLE__PARAMETERS, i, DUPLICATE_PARAMETER_NAME);
					if (function.getCreateExtensionInfo().eIsSet(CREATE_EXTENSION_INFO__NAME))
						error("Duplicate parameter " + leftParameterName, function.getCreateExtensionInfo(),
								CREATE_EXTENSION_INFO__NAME, DUPLICATE_PARAMETER_NAME);
					else
						error("Duplicate implicit parameter 'it'", function.getCreateExtensionInfo(),
								CREATE_EXTENSION_INFO__NAME, DUPLICATE_PARAMETER_NAME);
				}
			}
		}
	}
	
	@Check
	public void checkAbstract(XtendFunction function) {
		XtendTypeDeclaration declarator = function.getDeclaringType();
		if (function.getExpression() == null) {
			if (declarator instanceof XtendClass || declarator.isAnonymous()) {
				if (function.isDispatch()) {
					error("The dispatch method " + function.getName() + " in type " + localClassAwareTypeNames.getReadableName(declarator) + " must not be abstract",
							XTEND_FUNCTION__NAME, -1, DISPATCH_FUNCTIONS_MUST_NOT_BE_ABSTRACT);
					return;
				}
				if (function.getCreateExtensionInfo() != null) {
					error("The 'create'-method " + function.getName() + " in type " + localClassAwareTypeNames.getReadableName(declarator) + " must not be abstract",
							XTEND_FUNCTION__NAME, -1, CREATE_FUNCTIONS_MUST_NOT_BE_ABSTRACT);
					return;
				}
				if (declarator.isAnonymous()) {
					error("The abstract method " + function.getName() + " in type " + localClassAwareTypeNames.getReadableName(declarator) + " can only be defined by an abstract class.", 
							XTEND_FUNCTION__NAME, -1, MISSING_ABSTRACT_IN_ANONYMOUS);
				} else if (!((XtendClass) declarator).isAbstract() && !function.isNative()) {
					error("The abstract method " + function.getName() + " in type " + localClassAwareTypeNames.getReadableName(declarator) + " can only be defined by an abstract class.", 
							XTEND_FUNCTION__NAME, -1, MISSING_ABSTRACT);
				}
				if (function.getReturnType() == null && !function.isOverride()) {
					error("The "+(function.isNative()?"native":"abstract")+" method " + function.getName() + " in type " + localClassAwareTypeNames.getReadableName(declarator) + " must declare a return type",
							XTEND_FUNCTION__NAME, -1, ABSTRACT_METHOD_MISSING_RETURN_TYPE);
				}
			} else if (declarator instanceof XtendInterface) {
				if (function.getCreateExtensionInfo() != null) {
					error("'Create'-method " + function.getName() + " is not permitted in an interface",
							XTEND_FUNCTION__NAME, -1, CREATE_FUNCTIONS_MUST_NOT_BE_ABSTRACT);
					return;
				}
				if (function.getReturnType() == null && !function.isOverride()) {
					error("The abstract method " + function.getName() + " in type " + localClassAwareTypeNames.getReadableName(declarator) + " must declare a return type",
							XTEND_FUNCTION__NAME, -1, ABSTRACT_METHOD_MISSING_RETURN_TYPE);
				}
			}
		} else if (declarator instanceof XtendInterface) {
			if (!getGeneratorConfig(function).getJavaSourceVersion().isAtLeast(JAVA8)) {
				error("Abstract methods do not specify a body", XTEND_FUNCTION__NAME, -1, ABSTRACT_METHOD_WITH_BODY);
			}
		}
	}
	
	@Check
	public void checkOperatorSignature(XtendFunction function) {
		String functionName = function.getName();
		if (functionName != null) {
			QualifiedName qualifiedName = QualifiedName.create(functionName);
			QualifiedName operator = operatorMapping.getOperator(qualifiedName);
			if (operator != null) {
				JvmOperation operation = associations.getDirectlyInferredOperation(function);
				if (operation != null) {
					int parameterSize = operation.getParameters().size();
					if (function.isStatic()) {
						if (operatorMapping.isUnaryOperator(operator) && operatorMapping.isBinaryOperator(operator)) {
							if (parameterSize < 1) {
								addIssue("The static operator '" + operator + "' requires at least one argument.", function, XtendPackage.Literals.XTEND_FUNCTION__NAME, INVALID_OPERATOR_SIGNATURE);
							} else if (parameterSize > 2) {
								addIssue("The static operator '" + operator + "' allows at most two arguments.", function, XtendPackage.Literals.XTEND_FUNCTION__NAME, INVALID_OPERATOR_SIGNATURE);
							}
						} else if (operatorMapping.isUnaryOperator(operator)) {
							if (parameterSize != 1) {
								addIssue("The static unary operator '"+ operator + "' requires exactly one argument.", function, XtendPackage.Literals.XTEND_FUNCTION__NAME, INVALID_OPERATOR_SIGNATURE);
							}
						} else  if (parameterSize != 2) {
							addIssue("The static binary operator '" + operator + "' requires exactly two arguments.", function, XtendPackage.Literals.XTEND_FUNCTION__NAME, INVALID_OPERATOR_SIGNATURE);
						}
					} else {
						if (operatorMapping.isUnaryOperator(operator) && operatorMapping.isBinaryOperator(operator)) {
							if (parameterSize > 2) {
								addIssue("The operator '" + operator + "' allows at most two arguments.", function, XtendPackage.Literals.XTEND_FUNCTION__NAME, INVALID_OPERATOR_SIGNATURE);
							}
						} else if (operatorMapping.isUnaryOperator(operator)) {
							if (parameterSize > 1) {
								addIssue("The unary operator '"+ operator + "' allows at most one argument.", function, XtendPackage.Literals.XTEND_FUNCTION__NAME, INVALID_OPERATOR_SIGNATURE);
							}
						} else if (parameterSize == 0) {
							addIssue("The binary operator '" + operator + "' requires at least one argument.", function, XtendPackage.Literals.XTEND_FUNCTION__NAME, INVALID_OPERATOR_SIGNATURE);
							
						} else if (parameterSize > 2) {
							addIssue("The binary operator '" + operator + "' allows at most two arguments.", function, XtendPackage.Literals.XTEND_FUNCTION__NAME, INVALID_OPERATOR_SIGNATURE);
						}
					}
				}
			}
		}
	}
	
	@Check
	public void checkParameterNames(XtendConstructor constructor) {
		for (int i = 0; i < constructor.getParameters().size(); ++i) {
			String leftParameterName = constructor.getParameters().get(i).getName();
			for (int j = i + 1; j < constructor.getParameters().size(); ++j) {
				if (equal(leftParameterName, constructor.getParameters().get(j).getName())) {
					error("Duplicate parameter " + leftParameterName, XTEND_EXECUTABLE__PARAMETERS, i, DUPLICATE_PARAMETER_NAME);
					error("Duplicate parameter " + leftParameterName, XTEND_EXECUTABLE__PARAMETERS, j, DUPLICATE_PARAMETER_NAME);
				}
			}
		}
	}

	@Check
	public void dispatchFuncWithTypeParams(XtendFunction func) {
		if (func.isDispatch()) {
			if (func.getParameters().isEmpty()) {
				error("A dispatch method must at least have one parameter declared.", func, 
						XTEND_MEMBER__MODIFIERS, func.getModifiers().indexOf("dispatch"),
						IssueCodes.DISPATCH_FUNC_WITHOUT_PARAMS);
			}
			if (!func.getTypeParameters().isEmpty()) {
				error("A dispatch method must not declare any type parameters.", func,
						XTEND_MEMBER__MODIFIERS, func.getModifiers().indexOf("dispatch"),
						IssueCodes.DISPATCH_FUNC_WITH_TYPE_PARAMS);
			}
			if (func.getName().startsWith("_")) {
				error("A dispatch method's name must not start with an underscore.", func, XTEND_FUNCTION__NAME,
						IssueCodes.DISPATCH_FUNC_NAME_STARTS_WITH_UNDERSCORE);
			}
		}
	}

	@Check
	public void checkDispatchFunctions(XtendClass clazz) {
		JvmGenericType type = associations.getInferredType(clazz);
		if (type != null) {
			Multimap<DispatchHelper.DispatchSignature, JvmOperation> dispatchMethods = dispatchHelper.getDeclaredOrEnhancedDispatchMethods(type);
			checkDispatchNonDispatchConflict(clazz, dispatchMethods);
			for (DispatchHelper.DispatchSignature signature : dispatchMethods.keySet()) {
				Collection<JvmOperation> dispatchOperations = dispatchMethods.get(signature);
				JvmOperation syntheticDispatchMethod = dispatchHelper.getDispatcherOperation(type, signature);
				if (syntheticDispatchMethod != null) {
					JvmOperation overriddenOperation = overrideHelper.findOverriddenOperation(syntheticDispatchMethod);
					Boolean expectStatic = null;
					if(overriddenOperation != null) { 
						if (isMorePrivateThan(syntheticDispatchMethod.getVisibility(), overriddenOperation.getVisibility())) {
							String msg = "Synthetic dispatch method reduces visibility of overridden method " + overriddenOperation.getIdentifier();
							addDispatchError(type, dispatchOperations, msg, null, OVERRIDE_REDUCES_VISIBILITY);
						}
						expectStatic = overriddenOperation.isStatic();
					} 
					LightweightTypeReference dispatchMethodReturnType = getActualType(clazz, syntheticDispatchMethod);
					if (dispatchOperations.size() == 1) {
						JvmOperation singleOp = dispatchOperations.iterator().next();
						XtendFunction function = associations.getXtendFunction(singleOp);
						addIssue("Single dispatch method.", function, XTEND_MEMBER__MODIFIERS,
								function.getModifiers().indexOf("dispatch"), SINGLE_DISPATCH_FUNCTION);
					} else {
						Multimap<List<JvmType>, JvmOperation> signatures = HashMultimap.create();
						boolean[] allPrimitive = new boolean[signature.getArity()];
						Arrays.fill(allPrimitive, true);
						boolean isFirstLocalOperation = true;
						JvmVisibility commonVisibility = null;
						Boolean commonStatic = null;
						for (JvmOperation jvmOperation : dispatchOperations) {
							signatures.put(getParamTypes(jvmOperation, true), jvmOperation);
							for (int i = 0; i < jvmOperation.getParameters().size(); i++) {
								JvmFormalParameter parameter = jvmOperation.getParameters().get(i);
								if (!(parameter.getParameterType().getType() instanceof JvmPrimitiveType)) {
									allPrimitive[i] = false;
								}
							}
							if(jvmOperation.getDeclaringType() == type) {
								if(expectStatic != null) {
									if (expectStatic && !jvmOperation.isStatic()) {
										String msg = "The dispatch method must be static because the dispatch methods in the superclass are static.";
										addDispatchError(jvmOperation, msg, "static", DISPATCH_FUNCTIONS_STATIC_EXPECTED);
									}
									if (!expectStatic && jvmOperation.isStatic()) {
										String msg = "The dispatch method must not be static because the dispatch methods in the superclass are not static.";
										addDispatchError(jvmOperation, msg, "static", DISPATCH_FUNCTIONS_NON_STATIC_EXPECTED);
									}
								}
								if (isFirstLocalOperation) {
									commonVisibility = jvmOperation.getVisibility();
									commonStatic = jvmOperation.isStatic();
									isFirstLocalOperation = false;
								} else {
									if (jvmOperation.getVisibility() != commonVisibility) {
										commonVisibility = null;
									}
									if (commonStatic != null && commonStatic != jvmOperation.isStatic()) {
										commonStatic = null;
									}
								}
								// TODO move validation to type computation
								if (dispatchMethodReturnType != null) {
									XtendFunction function = associations.getXtendFunction(jvmOperation);
									if (function != null) {
										LightweightTypeReference operationType = getActualType(function.getExpression(), jvmOperation);
										if (!dispatchMethodReturnType.isAssignableFrom(operationType)) {
											error("Incompatible return type of dispatch method. Expected "
													+ dispatchMethodReturnType.getHumanReadableName() + " but was "
													+ operationType.getHumanReadableName(), function,
													XtendPackage.Literals.XTEND_FUNCTION__RETURN_TYPE,
													ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INCOMPATIBLE_RETURN_TYPE);
										}
									}
								}
							}
						}
						if (commonVisibility == null) {
							addDispatchError(type, dispatchOperations, "All local dispatch methods must have the same visibility.", 
									null, DISPATCH_FUNCTIONS_WITH_DIFFERENT_VISIBILITY);
						}
						if (expectStatic == null && commonStatic == null) {
							addDispatchError(type, dispatchOperations, "Static and non-static dispatch methods can not be mixed.", 
									"static",	DISPATCH_FUNCTIONS_MIXED_STATIC_AND_NON_STATIC);
						}
						for (final List<JvmType> paramTypes : signatures.keySet()) {
							Collection<JvmOperation> ops = signatures.get(paramTypes);
							if (ops.size() > 1) {
								if (Iterables.any(ops, new Predicate<JvmOperation>() {
									@Override
									public boolean apply(JvmOperation input) {
										return !getParamTypes(input, false).equals(paramTypes);
									}
								})) {
									for (JvmOperation jvmOperation : ops) {
										XtendFunction function = associations.getXtendFunction(jvmOperation);
										error("Duplicate dispatch methods. Primitives cannot overload their wrapper types in dispatch methods.",
												function, null, DUPLICATE_METHOD);
									}
								}
							}
						}
						for (int i = 0; i < allPrimitive.length; i++) {
							if (allPrimitive[i]) {
								Iterator<JvmOperation> operationIter = dispatchOperations.iterator();
								JvmType paramType1 = operationIter.next().getParameters().get(i).getParameterType().getType();
								while (operationIter.hasNext()) {
									JvmType paramType2 = operationIter.next().getParameters().get(i).getParameterType().getType();
									if (!paramType2.equals(paramType1)) {
										for (JvmOperation jvmOperation : dispatchOperations) {
											XtendFunction function = associations.getXtendFunction(jvmOperation);
											addIssue("Dispatch methods have arguments with different primitive types.",
													function, XTEND_EXECUTABLE__PARAMETERS, i, DISPATCH_FUNCTIONS_DIFFERENT_PRIMITIVE_ARGS);
										}
										break;
									}
								}
							}
						}
					}
				}
			}
		}
	}

	protected void checkDispatchNonDispatchConflict(XtendClass clazz,
			Multimap<DispatchHelper.DispatchSignature, JvmOperation> dispatchMethods) {
		if(isIgnored(DISPATCH_PLAIN_FUNCTION_NAME_CLASH)) {
			return;
		}
		Multimap<DispatchHelper.DispatchSignature, XtendFunction> nonDispatchMethods = HashMultimap.create();
		for(XtendFunction method: filter(clazz.getMembers(), XtendFunction.class)) {
			if(!method.isDispatch()) {
				nonDispatchMethods.put(new DispatchHelper.DispatchSignature(method.getName(), method.getParameters().size()), method);
			}
		}
		for (DispatchHelper.DispatchSignature dispatchSignature : dispatchMethods.keySet()) {
			if (nonDispatchMethods.containsKey(dispatchSignature)) {
				for (XtendFunction function : nonDispatchMethods.get(dispatchSignature))
					addIssue("Non-dispatch method has same name and number of parameters as dispatch method", function,
							XTEND_FUNCTION__NAME,
							DISPATCH_PLAIN_FUNCTION_NAME_CLASH);
				for (JvmOperation operation : dispatchMethods.get(dispatchSignature)) {
					XtendFunction function = associations.getXtendFunction(operation);
					if (function.eResource() == clazz.eResource()) {
						addIssue("Dispatch method has same name and number of parameters as non-dispatch method", function,
								XTEND_FUNCTION__NAME,
								DISPATCH_PLAIN_FUNCTION_NAME_CLASH);
					}
				}
			}
		}
	}

	protected void addDispatchError(JvmGenericType type, Iterable<JvmOperation> operations, String message, String modifier, String ISSUE_ID) {
		for (JvmOperation jvmOperation : operations)
			if (jvmOperation.getDeclaringType() == type)
				addDispatchError(jvmOperation, message, modifier, ISSUE_ID);
	}
	
	protected void addDispatchError(JvmOperation jvmOperation, String message, String modifier, String ISSUE_ID) {
		XtendFunction function = associations.getXtendFunction(jvmOperation);
		if (function != null) {
			int modifierIndex = -1;
			if(modifier != null) {
				modifierIndex = function.getModifiers().indexOf(modifier);
			} else {
				for(int i = 0; i < function.getModifiers().size(); ++i) {
					if(visibilityModifers.contains(function.getModifiers().get(i))) {
						modifierIndex = i;
						break;
					}
				}
			}
			if(modifierIndex == -1)
				modifierIndex = function.getModifiers().indexOf("dispatch");
			error(message, function, XTEND_MEMBER__MODIFIERS, modifierIndex, ISSUE_ID);
		}
	}

	protected List<JvmType> getParamTypes(JvmOperation jvmOperation, boolean wrapPrimitives) {
		List<JvmType> types = newArrayList();
		for (JvmFormalParameter p : jvmOperation.getParameters()) {
			LightweightTypeReference typeReference = toLightweightTypeReference(p.getParameterType());
			if (wrapPrimitives) {
				typeReference = typeReference.getWrapperTypeIfPrimitive();
			}
			types.add(typeReference.getType());
		}
		return types;
	}

	@Check
	public void checkNoReturnsInCreateExtensions(XtendFunction func) {
		if (func.getCreateExtensionInfo() == null)
			return;
		List<XReturnExpression> found = newArrayList();
		collectReturnExpressions(func.getCreateExtensionInfo().getCreateExpression(), found);
		for (XReturnExpression xReturnExpression : found) {
			error("Return is not allowed in creation expression", xReturnExpression, null, INVALID_EARLY_EXIT);
		}
	}

	@Check
	public void checkCreateFunctionIsNotTypeVoid(XtendFunction func) {
		if (func.getCreateExtensionInfo() == null)
			return;
		if (func.getReturnType() == null) {
			JvmOperation operation = associations.getDirectlyInferredOperation(func);
			if (operation != null && isPrimitiveVoid(operation.getReturnType())) {
				error("void is an invalid type for the create method " + func.getName(), func,
						XtendPackage.Literals.XTEND_FUNCTION__NAME, INVALID_USE_OF_TYPE);
			}
		} else if (isPrimitiveVoid(func.getReturnType())) {
			if (func.getReturnType() != null)
				error("Create method " + func.getName() + " may not declare return type void.", func.getReturnType(),
						null, INVALID_USE_OF_TYPE);
			else
				error("The inherited return type void of " + func.getName() + " is invalid for create method.",
						func.getReturnType(), null, INVALID_USE_OF_TYPE);
		}
	}
	
	@Check
	public void checkCreateFunctionIsNotGeneric(XtendFunction func) {
		if (func.getCreateExtensionInfo() == null)
			return;
		if (!func.getTypeParameters().isEmpty())
			error("Create methods can not have type parameters.", func, 
					XTEND_MEMBER__MODIFIERS, func.getModifiers().indexOf("static"),
					INVALID_USE_OF_STATIC);
	}
	
	@Check
	public void checkCreateFunctionIsNotStatic(XtendFunction func) {
		if (func.getCreateExtensionInfo() == null)
			return;
		if (func.isStatic())
			error("Create methods can not be static.", func, 
					XTEND_MEMBER__MODIFIERS, func.getModifiers().indexOf("static"),
					INVALID_USE_OF_STATIC);
	}

	@Override
	protected boolean isValueExpectedRecursive(XExpression expr) {
		EObject container = expr.eContainer();
		if (container instanceof RichString 
			|| container instanceof RichStringForLoop
			|| container instanceof XtendField) {
			return true;
		}
		return super.isValueExpectedRecursive(expr);
	}

	protected void collectReturnExpressions(EObject expr, List<XReturnExpression> found) {
		if (expr instanceof XReturnExpression) {
			found.add((XReturnExpression) expr);
		} else if (expr instanceof XClosure) {
			return;
		}
		for (EObject child : expr.eContents()) {
			collectReturnExpressions(child, found);
		}
	}
	
	public boolean doCheckValidMemberName(XtendMember member) {
		EStructuralFeature nameAttribute = member.eClass().getEStructuralFeature("name");
		if(nameAttribute != null) {
			String name = (String) member.eGet(nameAttribute);
			if(name != null && (name.equals("this") || name.equals("it"))) { 
				error("'it' and 'this' are not allowed as member names", nameAttribute, INVALID_MEMBER_NAME);
				return false;
			}
		}
		return true;
	}
	
	@Check
	public void checkLocalUsageOfDeclaredFields(XtendField field){
		if(doCheckValidMemberName(field) && !isIgnored(UNUSED_PRIVATE_MEMBER)) {
			JvmField jvmField = associations.getJvmField(field);
			if (jvmField == null || jvmField.getVisibility() != JvmVisibility.PRIVATE || jvmField.eContainer() == null)
				return;
			if (isLocallyUsed(jvmField, getOutermostType(field))) 
				return;
			String message;
			if(field.isExtension()) {
				if(field.getName() == null && jvmField.getType() != null)
					message = "The extension " + jvmField.getType().getIdentifier() 
						+ " is not used in " + getDeclaratorName(jvmField);
				else
					message = "The extension " + getDeclaratorName(jvmField) + "."
							+ jvmField.getSimpleName() + " is not used";
			} else {
				message = "The value of the field " + getDeclaratorName(jvmField) + "."
					+ jvmField.getSimpleName() + " is not used";
			}
			addIssueToState(UNUSED_PRIVATE_MEMBER, message, XtendPackage.Literals.XTEND_FIELD__NAME);
		}
	}

	/** Replies the outer-most type of the given member.
	 * @return the container of {@code XtendTypeDeclaration} type if it exists, or the direct container.
	 */
	protected final EObject getOutermostType(XtendMember member) {
		XtendTypeDeclaration result = EcoreUtil2.getContainerOfType(member, XtendTypeDeclaration.class);
		if (result == null) {
			return member.eContainer();
		}
		while(!(result.eContainer() instanceof XtendFile)) {
			XtendTypeDeclaration next = EcoreUtil2.getContainerOfType(result.eContainer(), XtendTypeDeclaration.class);
			if (next == null) {
				return result;
			}
			result = next;
		}
		return result;
	}

	protected String getDeclaratorName(JvmFeature feature) {
		JvmDeclaredType declarator = feature.getDeclaringType();
		if (declarator.isLocal()) {
			return "new " + Iterables.getLast(declarator.getSuperTypes()).getType().getSimpleName()+ "(){}";
		} else {
			return declarator.getSimpleName();
		}
	}
	
	@Check
	public void checkLocalUsageOfDeclaredXtendFunction(XtendFunction function){
		if(doCheckValidMemberName(function) && !isIgnored(UNUSED_PRIVATE_MEMBER)) {
			JvmOperation jvmOperation = function.isDispatch()?associations.getDispatchOperation(function):associations.getDirectlyInferredOperation(function);
			if(jvmOperation != null && jvmOperation.getVisibility() == JvmVisibility.PRIVATE && !isLocallyUsed(jvmOperation, getOutermostType(function))) {
				String message = "The method " + jvmOperation.getSimpleName() 
						+  uiStrings.parameters(jvmOperation)  
						+ " from the type "+ getDeclaratorName(jvmOperation)+" is never used locally.";
				addIssueToState(UNUSED_PRIVATE_MEMBER, message, XtendPackage.Literals.XTEND_FUNCTION__NAME);
			}
		}
	}
	
	@Check
	public void checkDeclaredExceptions(XtendConstructor constructor){
		JvmConstructor jvmConstructor = associations.getInferredConstructor(constructor);
		if (jvmConstructor != null) {
			checkExceptions(constructor, jvmConstructor.getExceptions(), XtendPackage.Literals.XTEND_EXECUTABLE__EXCEPTIONS);
		}
	}
	
	@Check
	public void checkTypeParameterForwardReferences(XtendClass xtendClass) {
		doCheckTypeParameterForwardReference(xtendClass.getTypeParameters());
	}
	
	@Check
	public void checkTypeParameterForwardReferences(XtendInterface xtendInterface) {
		doCheckTypeParameterForwardReference(xtendInterface.getTypeParameters());
	}
	
	@Check
	public void checkTypeParameterForwardReferences(XtendFunction xtendFunction) {
		doCheckTypeParameterForwardReference(xtendFunction.getTypeParameters());
	}
	
	@Check
	public void checkTypeParametersAreUnsupported(XtendConstructor constructor){
		if (!constructor.getTypeParameters().isEmpty()) {
			error("Type parameters are not supported for constructors", XtendPackage.Literals.XTEND_EXECUTABLE__TYPE_PARAMETERS, INSIGNIFICANT_INDEX, CONSTRUCTOR_TYPE_PARAMS_NOT_SUPPORTED);
		}
	}
	
	@Check
	public void checkDeclaredExceptions(XtendFunction function){
		JvmOperation jvmOperation = associations.getDirectlyInferredOperation(function);
		if (jvmOperation != null) {
			checkExceptions(function,jvmOperation.getExceptions(), XtendPackage.Literals.XTEND_EXECUTABLE__EXCEPTIONS);
		}
	}
	
	private void checkExceptions(EObject context, List<JvmTypeReference> exceptions, EReference reference) {
		Set<String> declaredExceptionNames = Sets.newHashSet();
		JvmTypeReference throwableType = getServices().getTypeReferences().getTypeForName(Throwable.class, context);
		if (throwableType == null) {
			return;
		}
		ITypeReferenceOwner owner = new StandardTypeReferenceOwner(getServices(), context);
		LightweightTypeReference throwableReference = owner.toLightweightTypeReference(throwableType);
		for(int i = 0; i < exceptions.size(); i++) {
			JvmTypeReference exception = exceptions.get(i);
			// throwables may not carry generics thus the raw comparison is sufficient
			if (exception.getType() != null && !exception.getType().eIsProxy()) {
				if(!throwableReference.isAssignableFrom(exception.getType()))
					error("No exception of type " + exception.getSimpleName() + " can be thrown; an exception type must be a subclass of Throwable",
							reference, i, EXCEPTION_NOT_THROWABLE);
				if(!declaredExceptionNames.add(exception.getQualifiedName()))
					error("Exception " + exception.getSimpleName() + " is declared twice", reference, i, EXCEPTION_DECLARED_TWICE);
			}
		}
	}
	
	@Check
    public void checkLeftHandSideIsVariable(XAssignment assignment){
        String concreteSyntaxFeatureName = assignment.getConcreteSyntaxFeatureName();
        if(concreteSyntaxFeatureName.equals(IFeatureNames.THIS.toString()))
            error("Left-hand side of an assignment must be an variable", XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, LEFT_HAND_SIDE_MUST_BE_VARIABLE);
    }
	
	@Check
	public void checkJavaKeywordConflict(XtendField member) {
		checkNoJavaKeyword(member, XtendPackage.Literals.XTEND_FIELD__NAME);
	}
	
	@Check
	public void checkJavaKeywordConflict(XtendFunction member) {
		if (member.eContainer() instanceof XtendAnnotationType && "do".equals(member.getName()))
			return;
		checkNoJavaKeyword(member, XtendPackage.Literals.XTEND_FUNCTION__NAME);
		for (JvmTypeParameter p : member.getTypeParameters()) {
			checkNoJavaKeyword(p, TypesPackage.Literals.JVM_TYPE_PARAMETER__NAME);
		}
	}
	
	@Check
	public void checkJavaKeywordConflict(XtendConstructor member) {
		for (JvmTypeParameter p : member.getTypeParameters()) {
			checkNoJavaKeyword(p, TypesPackage.Literals.JVM_TYPE_PARAMETER__NAME);
		}
	}
	
	@Check
	public void checkJavaKeywordConflict(XtendTypeDeclaration member) {
		checkNoJavaKeyword(member, XtendPackage.Literals.XTEND_TYPE_DECLARATION__NAME);
	}

	@Check
	public void checkJavaKeywordConflict(XtendClass member) {
		for (JvmTypeParameter p : member.getTypeParameters()) {
			checkNoJavaKeyword(p, TypesPackage.Literals.JVM_TYPE_PARAMETER__NAME);
		}
	}
	
	@Check
	public void checkJavaKeywordConflict(XtendInterface member) {
		for (JvmTypeParameter p : member.getTypeParameters()) {
			checkNoJavaKeyword(p, TypesPackage.Literals.JVM_TYPE_PARAMETER__NAME);
		}
	}
	
	protected void checkNoJavaKeyword(EObject obj, EAttribute attribute) {
		Object name = obj.eGet(attribute);
		if (name != null) {
			if (javaUtils.isJavaKeyword(name.toString()))
				error("'"+name+"' is not a valid identifier.", obj, attribute, -1, INVALID_IDENTIFIER);
		}
	}
	
	@Check
	public void checkNonInitializedFieldsHaveAType(XtendField field) {
		if (field.getType() == null && field.getInitialValue() == null) {
			error("The field "+field.getName()+" needs an explicit type since there is no initialization expression to infer the type from.", field, XTEND_FIELD__NAME, TOO_LITTLE_TYPE_INFORMATION);
		}
	}
	
	@Check
	public void checkFieldsAreCalledSelf(XtendField field) {
		if ("self".equals(field.getName())) {
			addIssue("'self' is a discouraged name", field, XTEND_FIELD__NAME, VARIABLE_NAME_DISCOURAGED);
		}
	}
	
	@Check
	public void checkFinalFieldInitialization(XtendClass clazz) {
		JvmGenericType inferredType = associations.getInferredType(clazz);
		if (inferredType == null)
			return;
		super.checkFinalFieldInitialization(inferredType);
	}
	
	@Check
	public void checkFinalFieldInitialization(XtendInterface xtendInterface) {
		JvmGenericType inferredType = associations.getInferredType(xtendInterface);
		if (inferredType == null)
			return;
		super.checkFinalFieldInitialization(inferredType);
	}
	
	@Check
	public void checkJavaDocRefs(XtendMember member){
		if(isIgnored(IssueCodes.JAVA_DOC_LINKING_DIAGNOSTIC))
			return;
		List<INode> documentationNodes = ((IEObjectDocumentationProviderExtension) documentationProvider).getDocumentationNodes(member);
		for(INode node : documentationNodes){
			for(ReplaceRegion region : javaDocTypeReferenceProvider.computeTypeRefRegions(node)){
				String typeRefString = region.getText();
				if(typeRefString != null && typeRefString.length() > 0){
					IScope scope = scopeProvider.getScope(member, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
					IEObjectDescription candidate = scope.getSingleElement(qualifiedNameConverter.toQualifiedName(typeRefString));
					if(candidate == null){
						Severity severity = getIssueSeverities(getContext(), getCurrentObject()).getSeverity(IssueCodes.JAVA_DOC_LINKING_DIAGNOSTIC);
						if (severity != null)
							getChain().add(createDiagnostic(severity, "javaDoc: " + typeRefString + " cannot be resolved to a type", member, region.getOffset(), region.getLength(), IssueCodes.JAVA_DOC_LINKING_DIAGNOSTIC));
					}
				}
			}
		}
	}

	@Override
	protected void reportUninitializedField(JvmField field) {
		EObject element = associations.getPrimarySourceElement(field);
		if (element instanceof XtendField) {
			error("The blank final field " + field.getSimpleName() + " may not have been initialized.", element, XTEND_FIELD__NAME, FIELD_NOT_INITIALIZED);
		} else {
			error("The blank final derived field " + field.getSimpleName() + " may not have been initialized.", element, null, FIELD_NOT_INITIALIZED);
		}
	}
	
	@Override
	protected void reportUninitializedField(JvmField field, JvmConstructor constructor) {
		EObject sourceElement = associations.getPrimarySourceElement(constructor);
		if (sourceElement != null) {
			if (associations.getXtendField(field) != null) {
				error("The blank final field " + field.getSimpleName() + " may not have been initialized.", sourceElement, null, FIELD_NOT_INITIALIZED);
			} else {
				error("The blank final derived field " + field.getSimpleName() + " may not have been initialized.", sourceElement, null, FIELD_NOT_INITIALIZED);
			}
		}
	}
	
	protected boolean hasAnnotation(Iterable<? extends XAnnotation> annotations, Class<?> annotationType) {
		for (XAnnotation anno : annotations) {
			if (anno.getAnnotationType() != null && annotationType.getName().equals(anno.getAnnotationType().getIdentifier()))
				return true;
		}
		return false;
	}
	
	private final ModifierValidator classModifierValidator = new ModifierValidator(
			newArrayList("public", "package", "final", "abstract", "strictfp"), this);
	
	private final ModifierValidator interfaceModifierValidator = new ModifierValidator(
			newArrayList("public", "package", "abstract", "strictfp"), this);
		
	private final ModifierValidator enumModifierValidator = new ModifierValidator(
			newArrayList("public", "package"), this);
	
	private final ModifierValidator annotationTypeModifierValidator = new ModifierValidator(
			newArrayList("public", "package", "abstract"), this);
	
	private final ModifierValidator nestedClassModifierValidator = new ModifierValidator(
			newArrayList("public", "package", "protected", "private", "static", "final", "abstract", "strictfp"), this);
	
	private final ModifierValidator nestedInterfaceModifierValidator = new ModifierValidator(
			newArrayList("public", "package", "protected", "private", "static", "abstract", "strictfp"), this);
		
	private final ModifierValidator nestedEnumModifierValidator = new ModifierValidator(
			newArrayList("public", "package", "protected", "private", "static"), this);
	
	private final ModifierValidator nestedAnnotationTypeModifierValidator = new ModifierValidator(
			newArrayList("public", "package", "protected", "private", "static", "abstract"), this);
		
	private final ModifierValidator fieldModifierValidator = new ModifierValidator(
			newArrayList("public", "protected", "package", "private", "static", "final", "val", "var", "extension", "volatile", "transient"), this);
		
	private final ModifierValidator fieldInInterfaceModifierValidator = new ModifierValidator(
			newArrayList("public", "static", "final", "val"), this);
		
	private final ModifierValidator constructorModifierValidator = new ModifierValidator(
			newArrayList(visibilityModifers), this);
		
	private final ModifierValidator methodModifierValidator = new ModifierValidator(
			newArrayList("public", "protected", "package", "private", "static", "abstract", "dispatch", "final", "def", "override", "strictfp", "native", "synchronized"), this);

	private ModifierValidator methodInInterfaceModifierValidator;
	
	@Check
	protected void checkModifiers(XtendClass xtendClass) {
		EObject eContainer = xtendClass.eContainer();
		if (eContainer instanceof XtendFile) {
			classModifierValidator.checkModifiers(xtendClass, "class " + xtendClass.getName());
		} else {
			nestedClassModifierValidator.checkModifiers(xtendClass, "class " + xtendClass.getName());
			// TODO remove this constraint
			if (!xtendClass.isStatic()) {
				if (eContainer instanceof XtendClass) { // types in interfaces and annotations are implicitely static
					error("Nested classes must be static", XTEND_TYPE_DECLARATION__NAME, -1, MISSING_STATIC_MODIFIER);
				}
			}
		}
	}
	
	@Check
	protected void checkModifiers(XtendInterface xtendInterface) {
		EObject eContainer = xtendInterface.eContainer();
		if (eContainer instanceof XtendFile) {
			interfaceModifierValidator.checkModifiers(xtendInterface, "interface " + xtendInterface.getName());
		} else {
			nestedInterfaceModifierValidator.checkModifiers(xtendInterface, "interface " + xtendInterface.getName());
		}
	}
	
	@Check
	protected void checkModifiers(XtendEnum xtendEnum) {
		EObject eContainer = xtendEnum.eContainer();
		if (eContainer instanceof XtendFile) {
			enumModifierValidator.checkModifiers(xtendEnum, "enum " + xtendEnum.getName());
		} else {
			nestedEnumModifierValidator.checkModifiers(xtendEnum, "enum " + xtendEnum.getName());
		}
	}
	
	@Check
	protected void checkModifiers(XtendAnnotationType annotation) {
		EObject eContainer = annotation.eContainer();
		if (eContainer instanceof XtendFile) {
			annotationTypeModifierValidator.checkModifiers(annotation, "annotation type " + annotation.getName());
		} else {
			nestedAnnotationTypeModifierValidator.checkModifiers(annotation, "annotation type " + annotation.getName());
		}
	}
	
	@Check
	protected void checkModifiers(XtendField field) {
		XtendTypeDeclaration declaringType = field.getDeclaringType();
		if(declaringType instanceof XtendClass || declaringType instanceof AnonymousClass) {
			if (field.isFinal() && field.isVolatile()) {
				error("The field " + field.getName() + " can be either final or volatile, not both.", XTEND_FIELD__NAME, -1, INVALID_MODIFIER);
			}
			fieldModifierValidator.checkModifiers(field, getMemberName(field));
		}
		else if(declaringType instanceof XtendInterface || declaringType instanceof XtendAnnotationType)
			fieldInInterfaceModifierValidator.checkModifiers(field,  "field " + field.getName());
	}
	
	protected String getMemberName(XtendField field) {
		String memberName = "field " + field.getName();
		
		/*
		 * Determine the member name of an extension field where the field name is not explicitly set.
		 */
		if(field.isExtension() && field.getName() == null) {
			JvmField jvmField = associations.getJvmField(field);
			if(jvmField != null) {
				LightweightTypeReference type = getActualType(jvmField);
				if(type != null) {
					memberName = "extension field " + type.getHumanReadableName();
				}
			}
		}
		
		return memberName;
	}
	
	@Check
	protected void checkModifiers(XtendConstructor constructor) {
		if(!(constructor.getDeclaringType() instanceof XtendClass)) {
			error("Contructors are only permitted within classes", null, CONSTRUCTOR_NOT_PERMITTED);
		} else {
			String typeName = ((XtendTypeDeclaration) constructor.eContainer()).getName();
			constructorModifierValidator.checkModifiers(constructor, "type " + typeName);
		}
	}
	
	@Check
	protected void checkModifiers(XtendFunction method) {
		XtendTypeDeclaration declaringType = method.getDeclaringType();
		if(declaringType instanceof XtendClass || declaringType instanceof AnonymousClass) {
			methodModifierValidator.checkModifiers(method, "method " + method.getName());
			int abstractIndex = method.getModifiers().indexOf("abstract");
			int nativeIndex = method.getModifiers().indexOf("native");
			if (method.getExpression() != null) {
				if (abstractIndex != -1) {
					error("Method " + method.getName() + " with a body cannot be abstract", XTEND_MEMBER__MODIFIERS, abstractIndex, INVALID_MODIFIER);
				} else if (method.isNative()) 
					error("Native methods do not specify a body", XTEND_FUNCTION__NAME, -1, INVALID_MODIFIER);
			} else if (nativeIndex == -1) {
				int finalIndex = method.getModifiers().indexOf("final");
				if(finalIndex != -1) 
					error("Abstract method " + method.getName() + " cannot be final", XTEND_MEMBER__MODIFIERS, finalIndex, INVALID_MODIFIER);
				int privateIndex = method.getModifiers().indexOf("private");
				if(privateIndex != -1) 
					error("Abstract method " + method.getName() + " cannot be private", XTEND_MEMBER__MODIFIERS, privateIndex, INVALID_MODIFIER);
				int staticIndex = method.getModifiers().indexOf("static");
				if(staticIndex != -1) 
					error("Abstract method " + method.getName() + " cannot be static", XTEND_MEMBER__MODIFIERS, staticIndex, INVALID_MODIFIER);
			}
		} else if (declaringType instanceof XtendInterface) {
			// The validator for interface methods is created lazily when the generator configuration is loaded
			GeneratorConfig config = getGeneratorConfig(method);
			methodInInterfaceModifierValidator.checkModifiers(method, "method " + method.getName());
			int abstractIndex = method.getModifiers().indexOf("abstract");
			if (config.getJavaSourceVersion().isAtLeast(JAVA8) && method.getExpression() != null && abstractIndex != -1) {
				error("Method " + method.getName() + " with a body cannot be abstract", XTEND_MEMBER__MODIFIERS, abstractIndex, INVALID_MODIFIER);
			}
		}
	}

	@Check
	protected void checkInferedApi(XtendFunction method) {
		if (isIgnored(API_TYPE_INFERENCE)) return;
		if (isApi(method) && method.getReturnType() == null && !method.isOverride()) {
			addIssue("API method needs explicit return type", method, XTEND_FUNCTION__NAME, API_TYPE_INFERENCE);
		}
	}
	
	@Check
	protected void checkInferedApi(XtendField field) {
		if (isApi(field) && field.getType() == null && field.getInitialValue() != null) {
			addIssue("API field needs explicit type", field, XTEND_FIELD__NAME, API_TYPE_INFERENCE);
		}
	}

	protected boolean isApi(XtendMember member) {
		if (!isApi(member.getDeclaringType())) return false;
		return member.getVisibility() == JvmVisibility.PUBLIC 
				|| member.getVisibility() == JvmVisibility.PROTECTED && !member.getDeclaringType().isFinal();
	}
	
	protected boolean isApi(XtendTypeDeclaration type) {
		if (type.isAnonymous())
			return false;
		boolean api = type.getVisibility() == JvmVisibility.PUBLIC;
		if (type.getDeclaringType() != null) {
			api = api || (type.getVisibility() == JvmVisibility.PROTECTED && ! type.getDeclaringType().isFinal()); 
			api = api && isApi(type.getDeclaringType());
		}
		return api;
	}

	@Check
	protected void checkModifierMatchesTypename(XtendClass xtendClass) {
		String name = xtendClass.getName();
		if (name != null) {
			if (name.startsWith("Abstract") && !xtendClass.isAbstract()) {
				addIssue("The class \"" + name + "\" is not declared abstract.", xtendClass, XTEND_TYPE_DECLARATION__NAME, -1,
						MODIFIER_DOES_NOT_MATCH_TYPENAME);
			}
		}
	}

	@Check
	protected void checkImplicitReturn(final XtendFunction method) {
		if (isIgnored(IMPLICIT_RETURN)) 
			return;
		JvmOperation jvmOperation = associations.getDirectlyInferredOperation(method);
		IResolvedTypes types = batchTypeResolver.resolveTypes(method);
		if (jvmOperation != null && types.getActualType(jvmOperation).isPrimitiveVoid()) 
			return;
		implicitReturnFinder.findImplicitReturns(method.getExpression(), new Acceptor() {
			@Override
			public void accept(XExpression implicitReturn) {
				if (method.getExpression() == implicitReturn) return;
				addIssue("Implicit return", implicitReturn, IMPLICIT_RETURN);
			}
		});
	}
	
	@Override
	protected boolean isLocalClassSemantics(EObject object) {
		return super.isLocalClassSemantics(object) || (object instanceof XtendMember && !(object instanceof AnonymousClass));
	}
	
	@Override
	public void checkDeprecated(XImportDeclaration decl) {
		XtendFile file = EcoreUtil2.getContainerOfType(decl, XtendFile.class);
		if (file != null) {
			for (XtendTypeDeclaration t : file.getXtendTypes()) {
				
				for (EObject e : jvmModelAssociations.getJvmElements(t)) {
					if  (e instanceof JvmAnnotationTarget) {
						if (DeprecationUtil.isDeprecated((JvmAnnotationTarget) e)) {
							return;
						}
					}
				}
				
				if (hasAnnotation(t, Deprecated.class)) {
					return;
				}
			}
		}
		super.checkDeprecated(decl);
	}
	
	@Check
	public void checkTernaryExpressionUsed(XIfExpression exp) {
		if (exp.isConditionalExpression()) {
			//Check if this expression is nested in another already marked ternary expression
			EObject container = exp.eContainer();
			if (container instanceof XIfExpression && ((XIfExpression) container).isConditionalExpression()) {
				return;
			}
			//Raise issue
			addIssue("The ternary operator is not allowed. Use a normal if-expression.", exp, TERNARY_EXPRESSION_NOT_ALLOWED);
		}
	}

	// makes it possible to create issues with configurable severity from delegates e.g. ModifierValidator
	@Override
	protected void addIssue(String message, EObject source, EStructuralFeature feature, int index, String issueCode, String... issueData) {
		super.addIssue(message, source, feature, index, issueCode, issueData);
	}
	
}
