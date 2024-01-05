/*******************************************************************************
 * Copyright (c) 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation;

import static com.google.common.collect.Iterables.*;
import static org.eclipse.xtext.util.Strings.*;
import static org.eclipse.xtext.xbase.validation.IssueCodes.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmSpecializedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.util.JavaVersion;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.EValidatorRegistrar;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.compiler.GeneratorConfig;
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeExtensions;
import org.eclipse.xtext.xbase.typesystem.override.ConflictingDefaultOperation;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedConstructor;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedExecutable;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedOperation;
import org.eclipse.xtext.xbase.typesystem.override.OverrideHelper;
import org.eclipse.xtext.xbase.typesystem.override.ResolvedFeatures;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.ContextualVisibilityHelper;
import org.eclipse.xtext.xbase.typesystem.util.IVisibilityHelper;
import org.eclipse.xtext.xbase.typesystem.util.RecursionGuard;
import org.eclipse.xtext.xtype.XComputedTypeReference;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Lorenzo Bettini - Initial contribution and API
 * @author Sebastian Zarnekow - Author of the original Java code in XtendValidator extracted here.
 */
public class JvmGenericTypeValidator extends AbstractDeclarativeValidator {
	@Inject
	private IJvmModelAssociations associations;

	@Inject
	private IGeneratorConfigProvider generatorConfigProvider;

	@Inject
	private OverrideHelper overrideHelper;

	@Inject
	private IVisibilityHelper visibilityHelper;

	@Inject
	private JvmTypeExtensions typeExtensions;

	@Inject
	private ILogicalContainerProvider containerProvider;

	@Override
	public void register(EValidatorRegistrar registrar) {
		// library validator is not registered for a specific language
	}

	@Check
	public void interceptRoot(EObject o) {
		var contents = o.eResource().getContents();
		if (contents.get(0) != o)
			return;
		checkJvmGenericTypes(contents);
	}

	protected void checkJvmGenericTypes(List<? extends EObject> contents) {
		contents.stream()
				.filter(this::isAssociatedToSource)
				.filter(JvmGenericType.class::isInstance)
				.map(JvmGenericType.class::cast)
				.forEach(this::checkJvmGenericType);
	}

	private boolean isAssociatedToSource(EObject e) {
		return !associations.getSourceElements(e).isEmpty();
	}

	protected void checkJvmGenericType(JvmGenericType type) {
		var sourceType = associations.getPrimarySourceElement(type);
		handleExceptionDuringValidation(() -> checkDefaultSuperConstructor(sourceType, type));
		handleExceptionDuringValidation(() -> checkSuperTypes(sourceType, type));
		type.getDeclaredFields().forEach(field -> {
			if (isAssociatedToSource(field))
				handleExceptionDuringValidation(() -> checkField(field));
		});
		handleExceptionDuringValidation(() -> checkMemberNamesAreUnique(type));
		handleExceptionDuringValidation(() -> checkDuplicateAndOverriddenFunctions(sourceType, type));
		var members = type.getMembers();
		handleExceptionDuringValidation(() -> checkJvmExecutables(members));
		if (isAnonymous(type))
			handleExceptionDuringValidation(() -> checkAnonymousClassStaticMembers(type));
		members.forEach(member -> {
			EcoreUtil2.eAllOfType(member, JvmGenericType.class).
				forEach(nestedType ->
					handleExceptionDuringValidation(() -> checkJvmGenericType(nestedType)));
		});
	}

	protected void checkJvmExecutables(List<? extends JvmMember> contents) {
		contents.stream()
				.filter(this::isAssociatedToSource)
				.filter(JvmExecutable.class::isInstance)
				.map(JvmExecutable.class::cast)
				.forEach(this::checkJvmExecutable);
	}

	protected void checkSuperTypes(EObject sourceType, JvmGenericType type) {
		if (sourceType == null)
			return;
		if (hasCycleInHierarchy(type, new HashSet<>())) {
			error("The inheritance hierarchy of " + notNull(type.getSimpleName()) + " contains cycles",
					sourceType,
					getFeatureForIssue(sourceType), CYCLIC_INHERITANCE);
		}
		var superTypes = type.getSuperTypes();
		if (type.isInterface()) {
			for (int i = 0; i < superTypes.size(); ++i) {
				JvmTypeReference extendedType = superTypes.get(i);
				var associated = associations.getPrimarySourceElement(extendedType);
				var eContainingFeature = associated.eContainingFeature();
				if (!isInterface(extendedType.getType()) && !isAnnotation(extendedType.getType())) {
					error("Extended interface must be an interface",
						sourceType,
						eContainingFeature, i, INTERFACE_EXPECTED);
				}
				checkWildcardSupertype(sourceType, notNull(type.getSimpleName()),
						extendedType,
						eContainingFeature, i);
			}
		} else if (isAnonymous(type)) {
			JvmTypeReference extendedType = Iterables.getLast(superTypes);
			var associated = getSuperTypeSourceElement(extendedType);
			var eContainingFeature = associated.eContainingFeature();
			if (((JvmDeclaredType) extendedType.getType()).isFinal()) {
				error("Attempt to override final class",
					sourceType,
					eContainingFeature, OVERRIDDEN_FINAL);
			}
			checkWildcardSupertype(sourceType, notNull(type.getSimpleName()),
					extendedType,
					eContainingFeature, INSIGNIFICANT_INDEX);
		} else {
			var expectedInterfaceIndex = -1;
			for (int i = 0; i < superTypes.size(); ++i) {
				JvmTypeReference extendedType = superTypes.get(i);
				var associated = getSuperTypeSourceElement(extendedType);
				if (associated == null)
					continue; // synthetic superclass (e.g., Object)
				var eContainingFeature = associated.eContainingFeature();
				// there's no direct way to tell whether the supertype is meant
				// to be an extended class or an implemented interface, so we
				// check whether the original source element's containing feature
				// is single or multiple, assuming that the source element allows
				// for a single extended class
				if (eContainingFeature.isMany()) { // assume to be expected as an interface
					expectedInterfaceIndex++;
					if (!isInterface(extendedType.getType()) && !isAnnotation(extendedType.getType())) {
						error("Implemented interface must be an interface",
							sourceType,
							eContainingFeature, expectedInterfaceIndex, INTERFACE_EXPECTED);
					}
					checkWildcardSupertype(sourceType, notNull(type.getSimpleName()),
							extendedType,
							eContainingFeature, expectedInterfaceIndex);
				} else { // assume to be expected as a class
					if (!(extendedType.getType() instanceof JvmGenericType)
							|| ((JvmGenericType) extendedType.getType()).isInterface()) {
						error("Superclass must be a class",
							sourceType,
							eContainingFeature, CLASS_EXPECTED);
					} else {
						if (((JvmGenericType) extendedType.getType()).isFinal()) {
							error("Attempt to override final class",
								sourceType,
								eContainingFeature, OVERRIDDEN_FINAL);
						}
						checkWildcardSupertype(sourceType, notNull(type.getSimpleName()),
								extendedType,
								eContainingFeature, INSIGNIFICANT_INDEX);
					}
				}
			}
		}
	}

	/**
	 * Workaround for https://github.com/eclipse/xtext/issues/2886
	 */
	protected boolean isAnonymous(JvmGenericType type) {
		return type.isAnonymous() ||
			Iterables.getLast(type.getSuperTypes()) instanceof XComputedTypeReference;
	}

	protected EObject getSuperTypeSourceElement(JvmTypeReference extendedType) {
		var associated = associations.getPrimarySourceElement(extendedType);
		while (associated == null && extendedType instanceof XComputedTypeReference) {
			extendedType = ((XComputedTypeReference) extendedType).getEquivalent();
			associated = associations.getPrimarySourceElement(extendedType);
		}
		return associated;
	}

	protected void checkAnonymousClassStaticMembers(JvmGenericType type) {
		type.getMembers().stream().filter(this::isAssociatedToSource).forEach(member -> {
			var source = associations.getPrimarySourceElement(member);
			if (member instanceof JvmOperation) {
				JvmOperation operation = (JvmOperation) member;
				if (operation.isStatic())
					error("A method of an anonymous class cannot be static.", source, getFeatureForIssue(source),
						INSIGNIFICANT_INDEX, ANONYMOUS_CLASS_STATIC_METHOD);
			} else if (member instanceof JvmField) {
				JvmField field = (JvmField) member;
				if (field.isStatic()) {
					if (!field.isFinal()) {
						error("A static field of an anonymous class must be final.", source, getFeatureForIssue(source),
							INSIGNIFICANT_INDEX, ANONYMOUS_CLASS_STATIC_FIELD);
					} else if (!field.isConstant()) {
						var initExpression = Iterables.getLast(filter(source.eContents(), XExpression.class));
						error("A static field of an anonymous class must be initialized with a constant expression.",
							source, initExpression.eContainingFeature(), INSIGNIFICANT_INDEX, ANONYMOUS_CLASS_STATIC_FIELD);
					}
				}
			}
		});
	}

	protected void checkDefaultSuperConstructor(EObject sourceType, JvmGenericType type) {
		Iterable<JvmConstructor> constructors = filter(type.getMembers(), JvmConstructor.class);
		if(type.getExtendedClass() != null) {
			JvmType superType = type.getExtendedClass().getType();
			if(superType instanceof JvmGenericType) {
				Iterable<JvmConstructor> superConstructors = ((JvmGenericType) superType).getDeclaredConstructors();
				for(JvmConstructor superConstructor: superConstructors) {
					if(superConstructor.getParameters().isEmpty()) 
						// there is a default super constructor. nothing more to check
						return;
				}
				if(size(constructors) == 1 && typeExtensions.isSingleSyntheticDefaultConstructor(constructors.iterator().next())) {
					List<String> issueData = new ArrayList<>();
					for(JvmConstructor superConstructor:superConstructors) {
						issueData.add(EcoreUtil.getURI(superConstructor).toString());
						issueData.add(doGetReadableSignature(type.getSimpleName(), superConstructor.getParameters()));
					}
					error("No default constructor in super type " + superType.getSimpleName() + "." +
							type.getSimpleName() + " must define an explicit constructor.",
							sourceType, getFeatureForIssue(sourceType), MISSING_CONSTRUCTOR,
							toArray(issueData, String.class));
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

	protected String doGetReadableSignature(String simpleName, List<JvmFormalParameter> parameters) {
		return getReadableSignature(simpleName,
			parameters.stream()
				.map(JvmFormalParameter::getParameterType)
				.collect(Collectors.toList()));
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

	protected boolean isDelegateConstructorCall(XExpression expression) {
		if(expression instanceof XFeatureCall) {
			JvmIdentifiableElement feature = ((XFeatureCall)expression).getFeature();
			return (feature != null && !feature.eIsProxy() && feature instanceof JvmConstructor);
		}
		return false;
	}

	protected void checkMemberNamesAreUnique(JvmGenericType type) {
		Map<String, List<JvmField>> fieldsByName = groupMembersByName(type.getMembers(),
				JvmField.class);
		Map<String, List<JvmDeclaredType>> typesByName = groupMembersByName(type.getMembers(),
				JvmDeclaredType.class);
		for (String name : fieldsByName.keySet()) {
			var withSameName = fieldsByName.get(name);
			if (withSameName.size() > 1) {
				for (var duplicate : withSameName) {
					var originalSource = associations.getPrimarySourceElement(duplicate);
					error("Duplicate field " + name,
						originalSource, getFeatureForIssue(originalSource), DUPLICATE_FIELD);
				}
			}
		}
		for (String name : typesByName.keySet()) {
			var withSameName = typesByName.get(name);
			if (withSameName.size() > 1) {
				for (var duplicate : withSameName) {
					var originalSource = associations.getPrimarySourceElement(duplicate);
					error("Duplicate nested type " + name,
							originalSource, getFeatureForIssue(originalSource), DUPLICATE_TYPE);
				}
			}
		}
	}

	protected void checkDuplicateAndOverriddenFunctions(EObject sourceType, JvmGenericType type) {
		JavaVersion targetVersion = getGeneratorConfig(sourceType).getJavaSourceVersion();
		ResolvedFeatures resolvedFeatures = overrideHelper.getResolvedFeatures(type, targetVersion);
		
		Set<EObject> flaggedOperations = Sets.newHashSet();
		doCheckDuplicateExecutables(type, resolvedFeatures, flaggedOperations);
		doCheckOverriddenMethods(sourceType, type, resolvedFeatures, flaggedOperations);
	}

	private <T1 extends JvmMember, T2 extends T1> Map<String, List<T2>> groupMembersByName(
			List<T1> members,
			Class<T2> memberType) {
		return members.stream()
			.filter(this::isAssociatedToSource)
			.filter(memberType::isInstance)
			.map(memberType::cast)
			.filter(e -> Objects.nonNull(e.getSimpleName()))
			.collect(Collectors.groupingBy(JvmMember::getSimpleName));
	}

	protected void checkField(JvmField field) {
		var declaredFieldType = field.getType();
		if (isPrimitiveVoid(declaredFieldType)) {
			var associated = associations.getPrimarySourceElement(declaredFieldType);
			error("void is an invalid type for the field " + field.getSimpleName(),
					associated, null, INVALID_USE_OF_TYPE);
		}
	}

	protected void checkJvmExecutable(JvmExecutable executable) {
		var parameters = executable.getParameters();
		var sourceExecutable = associations.getPrimarySourceElement(executable);
		for (int i = 0; i < parameters.size(); ++i) {
			var parameter = parameters.get(i);
			var sourceParameter = associations.getPrimarySourceElement(parameter);
			if (sourceParameter == null)
				continue; // synthetic parameter
			var leftParameterName = parameter.getName();
			var sourceParametersFeature = sourceParameter.eContainingFeature();
			for (int j = i + 1; j < parameters.size(); ++j) {
				if (equal(leftParameterName, parameters.get(j).getName())) {
					error("Duplicate parameter " + leftParameterName,
						sourceExecutable, sourceParametersFeature, i, DUPLICATE_PARAMETER_NAME);
					error("Duplicate parameter " + leftParameterName,
						sourceExecutable, sourceParametersFeature, j, DUPLICATE_PARAMETER_NAME);
				}
			}
			var parameterType = parameter.getParameterType();
			var sourceParameterType = associations.getPrimarySourceElement(parameterType);
			if (sourceParameterType == null)
				continue; // synthetic type (e.g., computed/inferred)
			if (isPrimitiveVoid(parameterType)) {
				error("void is an invalid type for the parameter " + parameter.getName() + " of the method "
						+ executable.getSimpleName(), sourceParameterType, null, INVALID_USE_OF_TYPE);
			}
		}
	}

	/**
	 * Copied from {@link XbaseValidator#isPrimitiveVoid(JvmTypeReference)}
	 */
	protected boolean isPrimitiveVoid(JvmTypeReference typeReference) {
		return typeReference != null && typeReference.getType() != null && !typeReference.getType().eIsProxy() && typeReference.getType() instanceof JvmVoid;
	}

	private boolean hasCycleInHierarchy(JvmGenericType type, Set<JvmGenericType> processedSuperTypes) {
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

	protected boolean isInterface(JvmType type) {
		return type instanceof JvmGenericType && ((JvmGenericType) type).isInterface();
	}

	protected boolean isAnnotation(JvmType jvmType) {
		return jvmType instanceof JvmAnnotationType;
	}

	protected void checkWildcardSupertype(EObject sourceElement,
			String name,
			JvmTypeReference superTypeReference,
			EStructuralFeature feature, int index) { 
		if(isInvalidWildcard(superTypeReference)) 
			error("The type "
					+ name
					+ " cannot extend or implement "
					+ superTypeReference.getIdentifier() 
					+ ". A supertype may not specify any wildcard",
				sourceElement,
				feature,
				index,
				WILDCARD_IN_SUPERTYPE);
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

	/**
	 * The default implementation returns the feature "name" or null if it does not exist.
	 */
	protected EStructuralFeature getFeatureForIssue(EObject object) {
		return object.eClass().getEStructuralFeature("name");
	}

	protected void doCheckDuplicateExecutables(JvmGenericType inferredType,	final ResolvedFeatures resolvedFeatures, Set<EObject> flaggedOperations) {
		List<IResolvedOperation> declaredOperations = resolvedFeatures.getDeclaredOperations();
		doCheckDuplicateExecutables(inferredType, declaredOperations,
			erasedSignature -> resolvedFeatures.getDeclaredOperations(erasedSignature),
			flaggedOperations);
		final List<IResolvedConstructor> declaredConstructors = resolvedFeatures.getDeclaredConstructors();
		doCheckDuplicateExecutables(inferredType, declaredConstructors, erasedSignature -> {
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
												getFeatureForIssue(otherSource), DUPLICATE_METHOD);
									} else {
										error("The " + typeLabel(executable) + " " + operationWithSameSignature.getSimpleSignature()
												+ " has the same erasure "
												+ operationWithSameSignature.getResolvedErasureSignature()
												+ " as another " + typeLabel(executable) + " in type " + inferredType.getSimpleName(), otherSource,
												getFeatureForIssue(otherSource), DUPLICATE_METHOD);
									}
								}
							}
						}
					}
				}
			}
		}
	}

	protected void doCheckOverriddenMethods(EObject sourceType, JvmGenericType inferredType, ResolvedFeatures resolvedFeatures,
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
												source, getFeatureForIssue(source), DUPLICATE_METHOD);
									}
								}
							} else if (!operation.getDeclaration().isStatic() && localOperation.getDeclaration().isStatic()) {
								if (flaggedOperations.add(source)) {
									error("The static method "
											+ localOperation.getSimpleSignature()
											+ " cannot hide the instance method "
											+ operation.getSimpleSignature() + " of type "
											+ getDeclaratorName(operation.getDeclaration()) + ".",
											source, getFeatureForIssue(source), DUPLICATE_METHOD);
								}
							} else if (flaggedOperations.add(source)) {
								error("Name clash: The method "
										+ localOperation.getSimpleSignature() + " of type "
										+ inferredType.getSimpleName()
										+ " has the same erasure as "
										+ operation.getSimpleSignature() + " of type "
										+ getDeclaratorName(operation.getDeclaration()) + " but does not override it.",
										source, getFeatureForIssue(source), DUPLICATE_METHOD);
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
									+ getDeclaratorName(operation.getDeclaration()) + ".",
									sourceType,
									getFeatureForIssue(sourceType),
									CONFLICTING_DEFAULT_METHODS, uris);
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
									+ ".",
									sourceType,
									getFeatureForIssue(sourceType),
									CONFLICTING_DEFAULT_METHODS, uris);
						}
						flaggedType = true;
					}
				}
			}
		}
		if (operationsMissingImplementation != null && !operationsMissingImplementation.isEmpty() && !flaggedType) {
			reportMissingImplementations(sourceType, inferredType, operationsMissingImplementation);
		}
	}

	protected EObject findPrimarySourceElement(IResolvedOperation operation) {
		return associations.getPrimarySourceElement(operation.getDeclaration());
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

	protected void reportMissingImplementations(
			EObject sourceType,
			JvmGenericType inferredType, List<IResolvedOperation> operationsMissingImplementation) {
		StringBuilder errorMsg = new StringBuilder();
		String name = inferredType.getSimpleName();
		boolean needsNewLine = operationsMissingImplementation.size() > 1;
		if (isAnonymous(inferredType)) {
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
		List<String> uris = operationsMissingImplementation.stream()
			.map(from -> EcoreUtil.getURI(from.getDeclaration()).toString())
			.collect(Collectors.toList());
		if (isAnonymous(inferredType)) {
			JvmTypeReference superType = Iterables.getLast(inferredType.getSuperTypes());
			var associated = getSuperTypeSourceElement(superType);
			var eContainingFeature = associated.eContainingFeature();
			error(errorMsg.toString(), sourceType, eContainingFeature, ANONYMOUS_CLASS_MISSING_MEMBERS, 
					toArray(uris, String.class));
		} else {
			error(errorMsg.toString(), sourceType, getFeatureForIssue(sourceType), CLASS_MUST_BE_ABSTRACT, 
							toArray(uris, String.class));
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

	protected String getDeclaratorName(JvmFeature feature) {
		JvmDeclaredType declarator = feature.getDeclaringType();
		if (declarator.isLocal()) {
			return "new " + Iterables.getLast(declarator.getSuperTypes()).getType().getSimpleName()+ "(){}";
		} else {
			return declarator.getSimpleName();
		}
	}

	protected GeneratorConfig getGeneratorConfig(EObject element) {
		GeneratorConfig result = (GeneratorConfig) getContext().get(GeneratorConfig.class);
		if (result == null) {
			result = generatorConfigProvider.get(element);
			getContext().put(GeneratorConfig.class, result);
		}
		return result;
	}

	/**
	 * When the {@link AbstractDeclarativeValidator} executes {@link Check} methods,
	 * it swallows some runtime exceptions so that other methods can be executed.
	 * In this class we only have a {@link Check} method that calls other methods, so for th
	 * other methods we simulate the same behavior.
	 */
	protected void handleExceptionDuringValidation(Runnable code) {
		try {
			code.run();
		} catch (Throwable e) {
			handleExceptionDuringValidation(e);
		}
	}
}
