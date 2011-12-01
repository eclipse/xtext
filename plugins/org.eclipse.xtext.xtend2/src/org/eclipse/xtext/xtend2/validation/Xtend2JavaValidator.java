/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.validation;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Maps.*;
import static java.util.Collections.*;
import static org.eclipse.xtext.util.Strings.*;
import static org.eclipse.xtext.xbase.validation.IssueCodes.*;
import static org.eclipse.xtext.xtend2.validation.IssueCodes.*;
import static org.eclipse.xtext.xtend2.xtend2.Xtend2Package.Literals.*;

import java.lang.annotation.ElementType;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.CrossReference;
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
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.util.FeatureOverridesService;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.common.types.util.TypeConformanceComputer;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ComposedChecks;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.XbasePackage.Literals;
import org.eclipse.xtext.xbase.annotations.typing.XAnnotationUtil;
import org.eclipse.xtext.xbase.annotations.validation.XbaseWithAnnotationsJavaValidator;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.validation.UIStrings;
import org.eclipse.xtext.xtend2.dispatch.DispatchingSupport;
import org.eclipse.xtext.xtend2.jvmmodel.IXtend2JvmAssociations;
import org.eclipse.xtext.xtend2.richstring.RichStringProcessor;
import org.eclipse.xtext.xtend2.typing.XtendOverridesService;
import org.eclipse.xtext.xtend2.xtend2.RichString;
import org.eclipse.xtext.xtend2.xtend2.RichStringElseIf;
import org.eclipse.xtext.xtend2.xtend2.RichStringForLoop;
import org.eclipse.xtext.xtend2.xtend2.RichStringIf;
import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendConstructor;
import org.eclipse.xtext.xtend2.xtend2.XtendField;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;
import org.eclipse.xtext.xtend2.xtend2.XtendImport;
import org.eclipse.xtext.xtend2.xtend2.XtendMember;
import org.eclipse.xtext.xtend2.xtend2.XtendParameter;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sebastian Zarnekow
 * @author Sven Efftinge
 * @author Holger Schill
 */
@ComposedChecks(validators = { ClasspathBasedChecks.class })
public class Xtend2JavaValidator extends XbaseWithAnnotationsJavaValidator {

	@Inject
	private FeatureOverridesService featureOverridesService;

	@Inject
	private TypeArgumentContextProvider typeArgumentContextProvider;

	@Inject
	private RichStringProcessor richStringProcessor;

	@Inject
	private IXtend2JvmAssociations associations;

	@Inject
	private XtendOverridesService overridesService;

	@Inject
	private DispatchingSupport dispatchingSupport;

	@Inject
	private Primitives primitives;

	@Inject
	private TypeReferences typeReferences;

	@Inject
	private TypeErasedSignature.Provider signatureProvider; 
	
	@Inject
	private TypeConformanceComputer typeConformanceComputer;

	@Inject
	private XAnnotationUtil annotationUtil;
	
	@Inject 
	private UIStrings uiStrings;

	private final Set<EReference> typeConformanceCheckedReferences = ImmutableSet.copyOf(Iterables.concat(
			super.getTypeConformanceCheckedReferences(), 
			ImmutableSet.of(
					Xtend2Package.Literals.RICH_STRING_FOR_LOOP__AFTER, 
					Xtend2Package.Literals.RICH_STRING_FOR_LOOP__BEFORE,
					Xtend2Package.Literals.RICH_STRING_FOR_LOOP__SEPARATOR, 
					Xtend2Package.Literals.RICH_STRING_IF__IF,
					Xtend2Package.Literals.RICH_STRING_ELSE_IF__IF)));

	@Override
	protected List<EPackage> getEPackages() {
		return newArrayList(Xtend2Package.eINSTANCE, XbasePackage.eINSTANCE, XAnnotationsPackage.eINSTANCE);
	}

	@Override
	protected Set<EReference> getTypeConformanceCheckedReferences() {
		return typeConformanceCheckedReferences;
	}

	@Check
	@Override
	public void checkNoSideffectFreeExpressionsInBlockExpression(XBlockExpression blockExpression) {
		if (blockExpression instanceof RichString)
			return;
		super.checkNoSideffectFreeExpressionsInBlockExpression(blockExpression);
	}

	@Check
	public void checkAnnotationTarget(XAnnotation annotation) {
		JvmAnnotationType annotationType = annotation.getAnnotationType();
		Set<ElementType> targets = annotationUtil.getAnnotationTargets(annotationType);
		if (targets.isEmpty())
			return;
		final EObject eContainer = getContainingAnnotationTarget(annotation);
		final Map<Class<?>, ElementType> targetInfos = getTargetInfos();
		for (Entry<Class<?>, ElementType> mapping : targetInfos.entrySet()) {
			if (mapping.getKey().isInstance(eContainer)) {
				if (!targets.contains(mapping.getValue())) {
					error("The annotation @" + annotation.getAnnotationType().getSimpleName()
							+ " is disallowed for this location.", annotation, null, INSIGNIFICANT_INDEX,
							ANNOTATION_WRONG_TARGET);
				}
			}
		}
	}

	protected EObject getContainingAnnotationTarget(XAnnotation annotation) {
		final EObject eContainer = annotation.eContainer();
		// in fields and functions annotations are contained in a synthetic container
		if (eContainer.eClass() == Xtend2Package.Literals.XTEND_MEMBER) {
			return eContainer.eContainer();
		}
		return eContainer;
	}

	protected Map<Class<?>, ElementType> getTargetInfos() {
		Map<Class<?>, ElementType> result = newHashMap();
		result.put(XtendClass.class, ElementType.TYPE);
		result.put(XtendField.class, ElementType.FIELD);
		result.put(XtendFunction.class, ElementType.METHOD);
		result.put(XtendParameter.class, ElementType.PARAMETER);
		return result;
	}

	@Override
	@Check
	public void checkAssignment(XAssignment assignment) {
		JvmIdentifiableElement assignmentFeature = assignment.getFeature();
		if (assignmentFeature instanceof XtendParameter)
			error("Assignment to final parameter", Literals.XASSIGNMENT__ASSIGNABLE,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX, ASSIGNMENT_TO_FINAL);
		else
			super.checkAssignment(assignment);
	}

	@Check
	public void checkVariableNameShadowing(XtendFunction func) {
		for (XtendParameter p : func.getParameters()) {
			super.checkDeclaredVariableName(func, p, XTEND_PARAMETER__NAME);
		}
	}

	@Check
	public void checkNoVoidInDependencyDeclaration(XtendField dep) {
		if (typeReferences.is(dep.getType(), Void.TYPE)) {
			error("Primitive void cannot be a dependency.", dep.getType(), null, INVALID_USE_OF_TYPE);
		}
	}
	
	@Check
	public void checkMemberNamesAreUnique(XtendClass xtendClass) {
		final Multimap<String, XtendField> name2field = HashMultimap.create();
		final Multimap<JvmType, XtendField> type2extension = HashMultimap.create();
		for(XtendMember member: xtendClass.getMembers()) {
			if(member instanceof XtendField) {
				XtendField field = (XtendField)member;
				 if(isEmpty(field.getName())) {
					 if(field.isExtension()) {
						 JvmType type = field.getType().getType();
						 if(type != null) 
							 type2extension.put(type, field);
					 }
				 } else {
					 name2field.put(field.getName(), field);
				 }
			}
		}
		for(String name: name2field.keySet()) {
			Collection<XtendField> fields = name2field.get(name);
			if(fields.size() >1) {
				for(XtendField field: fields)
					error("Duplicate field " + name, field, Xtend2Package.Literals.XTEND_FIELD__NAME, DUPLICATE_FIELD);
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
		if (typeReferences.is(param.getParameterType(), Void.TYPE)) {
			XtendFunction function = (XtendFunction) (param.eContainer() instanceof XtendFunction ? param.eContainer()
					: null);
			if (function != null)
				error("void is an invalid type for the parameter " + param.getName() + " of the function "
						+ function.getName(), param.getParameterType(), null, INVALID_USE_OF_TYPE);
			else
				error("void is an invalid type for the parameter " + param.getName(), param.getParameterType(), null,
						INVALID_USE_OF_TYPE);
		}
	}

	@Check
	public void checkClassPath(XtendClass clazz) {
		final JvmGenericType listType = (JvmGenericType) getTypeRefs().findDeclaredType(List.class.getName(), clazz);
		if (listType == null || listType.getTypeParameters().isEmpty()) {
			error("Xtend requires Java source level 1.5.", clazz, XTEND_CLASS__NAME,
					IssueCodes.XBASE_LIB_NOT_ON_CLASSPATH);
		}
		if (getTypeRefs().findDeclaredType("org.eclipse.xtend2.lib.StringConcatenation", clazz) == null) {
			error("Mandatory library bundle 'org.eclipse.xtend2.lib' not found on the classpath.", clazz,
					XTEND_CLASS__NAME, IssueCodes.XTEND_LIB_NOT_ON_CLASSPATH);
		}
		if (getTypeRefs().findDeclaredType("org.eclipse.xtext.xbase.lib.ObjectExtensions", clazz) == null) {
			error("Mandatory library bundle 'org.eclipse.xtext.xbase.lib' not found on the classpath.", clazz,
					XTEND_CLASS__NAME, IssueCodes.XBASE_LIB_NOT_ON_CLASSPATH);
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
				JvmGenericType inferredType = associations.getInferredType(xtendClass);
				if (inferredType != null && hasCycleInHierarchy(inferredType, Lists.<JvmGenericType> newArrayList())) {
					error("The inheritance hierarchy of " + notNull(xtendClass.getName()) + " contains cycles",
							XTEND_CLASS__NAME, CYCLIC_INHERITANCE);
				}
			}
		}
		for (int i = 0; i < xtendClass.getImplements().size(); ++i) {
			JvmTypeReference implementedType = xtendClass.getImplements().get(i);
			if (!(implementedType.getType() instanceof JvmGenericType)
					|| !((JvmGenericType) implementedType.getType()).isInterface()) {
				error("Implemented interface must be an interface", XTEND_CLASS__IMPLEMENTS, i, INTERFACE_EXPECTED);
			}
		}
	}

	protected boolean hasCycleInHierarchy(JvmGenericType type, List<JvmGenericType> processedSuperTypes) {
		if (type.isInterface())
			return false;
		if (processedSuperTypes.contains(type))
			return true;
		processedSuperTypes.add(type);
		for (JvmTypeReference superTypeRef : type.getSuperTypes()) {
			if (superTypeRef.getType() instanceof JvmGenericType) {
				if (hasCycleInHierarchy((JvmGenericType) superTypeRef.getType(), processedSuperTypes))
					return true;
			}
		}
		return false;
	}
	
	@Override
	protected boolean supportsCheckedExceptions() {
		return false;
	}

	@Check
	public void checkDuplicateAndOverriddenFunctions(XtendClass xtendClass) {
		final JvmGenericType inferredType = associations.getInferredType(xtendClass);
		if (inferredType != null) {
			final JvmParameterizedTypeReference typeReference = typeReferences.createTypeRef(inferredType);
			if (xtendClass.getTypeParameters().isEmpty())
				typeReference.getArguments().clear();
			final ITypeArgumentContext typeArgumentContext = typeArgumentContextProvider
					.getTypeArgumentContext(new TypeArgumentContextProvider.AbstractRequest() {
						@Override
						public JvmTypeReference getReceiverType() {
							return typeReference;
						}

						@Override
						public String toString() {
							return "Xtend2JavaValidator.checkDuplicateAndOverriddenFunctions [inferredType="
									+ inferredType.getIdentifier() + "]";
						}

						@Override
						public JvmTypeParameterDeclarator getNearestDeclarator() {
							return inferredType;
						}
					});
			Multimap<Object, JvmOperation> operationsPerErasure = HashMultimap.create();
			for (JvmOperation operation : inferredType.getDeclaredOperations()) {
				TypeErasedSignature signature = signatureProvider.get(operation);
				operationsPerErasure.put(signature, operation);
			}
			doCheckDuplicateExecutables(inferredType, operationsPerErasure);
			doCheckOverriddenMethods(xtendClass, inferredType, typeArgumentContext, operationsPerErasure);
			
			Multimap<Object, JvmConstructor> constructorsPerErasure = HashMultimap.create();
			for (JvmConstructor constructor : inferredType.getDeclaredConstructors()) {
				TypeErasedSignature signature = signatureProvider.get(constructor);
				constructorsPerErasure.put(signature, constructor);
			}
			doCheckDuplicateExecutables(inferredType, constructorsPerErasure);
		}
	}
	
	protected void doCheckDuplicateExecutables(final JvmGenericType inferredType,
			Multimap<Object, ? extends JvmExecutable> executablesPerErasure) {
		for (Collection<? extends JvmExecutable> executablesWithSameSignature : executablesPerErasure.asMap().values()) {
			if (executablesWithSameSignature.size() > 1) {
				Multimap<String, JvmExecutable> executablesPerReadableSignature = HashMultimap.create();
				for (JvmExecutable executable : executablesWithSameSignature) {
					String readableSignature = getReadableSignature(executable);
					executablesPerReadableSignature.put(readableSignature, executable);
				}
				for (Collection<JvmExecutable> executablesWithSameReadableSignature : executablesPerReadableSignature
						.asMap().values()) {
					if (executablesWithSameReadableSignature.size() > 1) {
						for (JvmExecutable executable : executablesWithSameReadableSignature) {
							EObject otherSource = associations.getPrimarySourceElement(executable);
							error("Duplicate " + typeLabel(executable) + " " + getReadableSignature(executable)
									+ " in type " + inferredType.getSimpleName(), otherSource,
									nameFeature(otherSource), DUPLICATE_METHOD);
						}
					} else {
						for (JvmExecutable executable : executablesWithSameReadableSignature) {
							EObject otherSource = associations.getPrimarySourceElement(executable);
							error("The " + typeLabel(executable) + " " + getReadableSignature(executable)
									+ " has the same erasure "
									+ signatureProvider.get(executable).toString()
									+ " as another method in type " + inferredType.getSimpleName(), otherSource,
									nameFeature(otherSource), DUPLICATE_METHOD);
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
	
	
	protected void doCheckOverriddenMethods(XtendClass xtendClass, final JvmGenericType inferredType,
			final ITypeArgumentContext typeArgumentContext, Multimap<Object, JvmOperation> operationsPerErasure) {
		List<JvmOperation> operationsMissingImplementation = null;
		for (JvmOperation operation : filter(
				featureOverridesService.getAllJvmFeatures(inferredType, typeArgumentContext), JvmOperation.class)) {
			if (operation.getDeclaringType() != inferredType) {
				TypeErasedSignature signature = signatureProvider.get(operation);
				if (operationsPerErasure.containsKey(signature)) {
					Collection<JvmOperation> myOperations = operationsPerErasure.get(signature);
					if (myOperations.size() == 1) {
						JvmOperation myOperation = Iterables.getOnlyElement(myOperations);
						if (!featureOverridesService.isOverridden(myOperation, operation, typeArgumentContext,
								false)) {
							XtendFunction source = associations.getXtendFunction(myOperation);
							error("Name clash: The method "
									+ getReadableSignature(myOperation) + " of type "
									+ inferredType.getSimpleName()
									+ " has the same erasure as "
									+
									// use source with other operations parameters to avoid confusion
									// due to name transformations in JVM model inference
									getReadableSignature(operation) + " of type "
									+ operation.getDeclaringType().getSimpleName() + " but does not override it.",
									source, XTEND_FUNCTION__NAME, DUPLICATE_METHOD);
						}
					}
				}
				if (operation.isAbstract() && !inferredType.isAbstract()) {
					boolean overridden = false;
					if (operationsPerErasure.containsKey(signature)) {
						for (JvmOperation myOperation : operationsPerErasure.get(signature)) {
							if (featureOverridesService.isOverridden(myOperation, operation, typeArgumentContext,
									false)) {
								overridden = true;
								break;
							}
						}
					}
					if (!overridden) {
						if(operationsMissingImplementation == null)
							operationsMissingImplementation = newArrayList();
						operationsMissingImplementation.add(operation);
					}
				}
			}
		}
		if(operationsMissingImplementation != null) {
			reportMissingImplementations(xtendClass, typeArgumentContext, operationsMissingImplementation);
		}
	}

	protected void reportMissingImplementations(XtendClass xtendClass, final ITypeArgumentContext typeArgumentContext,
			List<JvmOperation> operationsMissingImplementation) {
		StringBuilder errorMsg = new StringBuilder();
		errorMsg.append("The class ").append(xtendClass.getName())
			.append(" must be defined abstract because it does not implement ");
		boolean needsNewLine = operationsMissingImplementation.size() > 1;
		JvmOperation operation;
		for(int i=0; i<operationsMissingImplementation.size() && i<3; ++i) {
			operation = operationsMissingImplementation.get(i);
			if(needsNewLine)
				errorMsg.append("\n- ");
			errorMsg.append(getReadableSignature(operation.getSimpleName(), Lists.transform(
						operation.getParameters(),
						new Function<JvmFormalParameter, JvmTypeReference>() {
							public JvmTypeReference apply(JvmFormalParameter from) {
								JvmTypeReference parameterType = from.getParameterType();
								JvmTypeReference result = typeArgumentContext
										.resolve(parameterType);
								return result;
							}
						})));
		}
		int numUnshownOperations = operationsMissingImplementation.size() - 3;
		if(numUnshownOperations >0)
			errorMsg.append("\nand " +  numUnshownOperations + " more.");
		List<String> uris = transform(operationsMissingImplementation, new Function<JvmOperation, String>() {
			public String apply(JvmOperation from) {
				return EcoreUtil.getURI(from).toString();
			}
		});
		error(errorMsg.toString(), xtendClass, XTEND_CLASS__NAME, CLASS_MUST_BE_ABSTRACT, 
						toArray(uris, String.class));
	}

	@Check
	protected void checkFunctionOverride(XtendFunction function) {
		JvmOperation overriddenOperation = overridesService.findOverriddenOperation(function);
		if (overriddenOperation == null) {
			if (function.isOverride()) {
				error("Function does not override any function", function, XTEND_FUNCTION__OVERRIDE, OBSOLETE_OVERRIDE);
			}
			return;
		}
		if (!function.isOverride())
			error("Missing 'override'. Function overrides " + canonicalName(overriddenOperation), function,
					XTEND_FUNCTION__NAME, MISSING_OVERRIDE);
		if (overriddenOperation.isFinal())
			error("Attempt to override final method " + canonicalName(overriddenOperation), function,
					XTEND_FUNCTION__NAME, OVERRIDDEN_FINAL);
		JvmOperation inferredOperation = associations.getDirectlyInferredOperation(function);
		if (isMorePrivateThan(inferredOperation.getVisibility(), overriddenOperation.getVisibility())) {
			error("Cannot reduce the visibility of the overridden method " + overriddenOperation.getIdentifier(),
					function, XTEND_FUNCTION__NAME, OVERRIDE_REDUCES_VISIBILITY);
		}
		for(JvmTypeReference unhandledException: findUnhandledExceptions(function, function.getExceptions(),overriddenOperation.getExceptions()))
			error("Exception " + unhandledException.getSimpleName() + " is not compatible with throws clause in " +
					overriddenOperation.getIdentifier(), XTEND_FUNCTION__EXCEPTIONS, INCOMPATIBLE_THROWS_CLAUSE);
		if (function.getReturnType() == null)
			return;
		ITypeArgumentContext typeArgumentContext = typeArgumentContextProvider
				.getTypeArgumentContext(new TypeArgumentContextProvider.ReceiverRequest(getTypeRefs().createTypeRef(
						inferredOperation.getDeclaringType())));
		JvmTypeReference returnTypeUpperBound = typeArgumentContext.getUpperBound(overriddenOperation.getReturnType(),
				function);
		if (!isConformant(returnTypeUpperBound, function.getReturnType())) {
			error("The return type is incompatible with " + overriddenOperation.getIdentifier(), function,
					XTEND_FUNCTION__RETURN_TYPE, INCOMPATIBLE_RETURN_TYPE);
		}
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

	protected Iterable<JvmOperation> allSuperOperations(final XtendClass xtendClass) {
		// I love Google collections
		Iterable<JvmOperation> result = filter(
				concat(transform(
						filter(concat(singleton(xtendClass.getExtends()), xtendClass.getImplements()),
								Predicates.notNull()), new Function<JvmTypeReference, Iterable<JvmFeature>>() {
							public Iterable<JvmFeature> apply(JvmTypeReference from) {
								return featureOverridesService.getAllJvmFeatures(from);
							}
						})), JvmOperation.class);
		return result;
	}
	
	@Check
	public void checkDefaultSuperConstructor(XtendClass xtendClass) {
		Iterable<XtendConstructor> xtendConstructors = filter(xtendClass.getMembers(), XtendConstructor.class);
		JvmGenericType inferredType = associations.getInferredType(xtendClass);
		if(inferredType.getExtendedClass() != null) {
			JvmType superType = inferredType.getExtendedClass().getType();
			if(superType instanceof JvmGenericType) {
				Iterable<JvmConstructor> superConstructors = ((JvmGenericType) superType).getDeclaredConstructors();
				for(JvmConstructor superConstructor: superConstructors) {
					if(superConstructor.getParameters().isEmpty()) 
						// there is a default super constructor. nothing more to check
						return;
				}
				if(isEmpty(xtendConstructors)) {
					List<String> issueData = newArrayList();
					for(JvmConstructor superConstructor:superConstructors) {
						issueData.add(EcoreUtil.getURI(superConstructor).toString());
						issueData.add(doGetReadableSignature(xtendClass.getSimpleName(), superConstructor.getParameters()));
					}
					error("No default constructor in super type " + superType.getSimpleName() + "." +
							xtendClass.getName() + " must define an explicit constructor.",
							xtendClass, XTEND_CLASS__NAME, MISSING_CONSTRUCTOR, toArray(issueData, String.class));
				} else {
					for(XtendConstructor xtendConstructor: xtendConstructors) {
						EList<XExpression> expressions = ((XBlockExpression) xtendConstructor.getExpression()).getExpressions();
						if(expressions.isEmpty() || !isDelegatConstructorCall(expressions.get(0))) {
							error("No default constructor in super type " + superType.getSimpleName() 
									+ ". Another constructor must be invoked explicitly.",
									xtendConstructor, null, MUST_INVOKE_SUPER_CONSTRUCTOR);
							
						}
					}
				}
			}
		} 
	}

	protected boolean isDelegatConstructorCall(XExpression expression) {
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
					error("Duplicate parameter " + leftParameterName, XTEND_FUNCTION__PARAMETERS, i, DUPLICATE_PARAMETER_NAME);
					error("Duplicate parameter " + leftParameterName, XTEND_FUNCTION__PARAMETERS, j, DUPLICATE_PARAMETER_NAME);
				}
			}
			if (function.getCreateExtensionInfo() != null) {
				if (equal(leftParameterName, function.getCreateExtensionInfo().getName())) {
					error("Duplicate parameter " + leftParameterName, XTEND_FUNCTION__PARAMETERS, i, DUPLICATE_PARAMETER_NAME);
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
	public void checkParameterNames(XtendConstructor constructor) {
		for (int i = 0; i < constructor.getParameters().size(); ++i) {
			String leftParameterName = constructor.getParameters().get(i).getName();
			for (int j = i + 1; j < constructor.getParameters().size(); ++j) {
				if (equal(leftParameterName, constructor.getParameters().get(j).getName())) {
					error("Duplicate parameter " + leftParameterName, XTEND_CONSTRUCTOR__PARAMETERS, i, DUPLICATE_PARAMETER_NAME);
					error("Duplicate parameter " + leftParameterName, XTEND_CONSTRUCTOR__PARAMETERS, j, DUPLICATE_PARAMETER_NAME);
				}
			}
		}
	}

	@Check
	public void dispatchFuncWithTypeParams(XtendFunction func) {
		if (func.isDispatch()) {
			if (func.getParameters().isEmpty()) {
				error("A dispatch function must at least have one parameter declared.", func, XTEND_FUNCTION__DISPATCH,
						IssueCodes.DISPATCH_FUNC_WITHOUT_PARAMS);
			}
			if (!func.getTypeParameters().isEmpty()) {
				error("A dispatch function must not declare any type parameters.", func, XTEND_FUNCTION__DISPATCH,
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
			Multimap<Pair<String, Integer>, JvmOperation> dispatchMethods = dispatchingSupport.getDispatchMethods(type);
			for (Pair<String, Integer> key : dispatchMethods.keySet()) {
				Collection<JvmOperation> dispatchOperations = dispatchMethods.get(key);
				JvmOperation syntheticDispatchMethod = dispatchingSupport.findSyntheticDispatchMethod(clazz, key);
				JvmOperation overriddenOperation = overridesService.findOverriddenOperation(syntheticDispatchMethod);
				Boolean expectStatic = null;
				if(overriddenOperation != null) { 
					if (isMorePrivateThan(syntheticDispatchMethod.getVisibility(), overriddenOperation.getVisibility())) {
						String msg = "Synthetic dispatch method reduces visibility of overridden function " + overriddenOperation.getIdentifier();
						addDispatchError(type, dispatchOperations, msg, XTEND_FUNCTION__VISIBILITY, OVERRIDE_REDUCES_VISIBILITY);
					}
					expectStatic = overriddenOperation.isStatic();
				} 
				if (dispatchOperations.size() == 1) {
					JvmOperation singleOp = dispatchOperations.iterator().next();
					XtendFunction function = associations.getXtendFunction(singleOp);
					warning("Single dispatch function.", function, XTEND_FUNCTION__DISPATCH,
							IssueCodes.SINGLE_DISPATCH_FUNCTION);
				} else {
					Multimap<List<JvmType>, JvmOperation> signatures = HashMultimap.create();
					boolean isFirstLocalOperation = true;
					JvmVisibility commonVisibility = null;
					Boolean commonStatic = null;
					for (JvmOperation jvmOperation : dispatchOperations) {
						signatures.put(getParamTypes(jvmOperation, true), jvmOperation);
						if(jvmOperation.getDeclaringType() == type) {
							if(expectStatic != null) {
								if (expectStatic && !jvmOperation.isStatic()) {
									String msg = "The dispatch method must be static because the dispatch methods in the super-class are static.";
									addDispatchError(jvmOperation, msg, XTEND_FUNCTION__STATIC, DISPATCH_FUNCTIONS_STATIC_EXPECTED);
								}
								if (!expectStatic && jvmOperation.isStatic()) {
									String msg = "The dispatch method must not be static because the dispatch methods in the super-class are not static.";
									addDispatchError(jvmOperation, msg, XTEND_FUNCTION__STATIC, DISPATCH_FUNCTIONS_NON_STATIC_EXPECTED);
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
						}
						XtendFunction function = associations.getXtendFunction(jvmOperation);
						if (function != null) {
							JvmTypeReference functionReturnType = function.getReturnType();
							if (functionReturnType == null)
								functionReturnType = getTypeProvider().getCommonReturnType(function.getExpression(),
										true);
							if (functionReturnType != null) {
								if (!isConformant(jvmOperation.getReturnType(), functionReturnType)) {
									error("Incompatible return type of dispatch method. Expected "
											+ getNameOfTypes(jvmOperation.getReturnType()) + " but was "
											+ canonicalName(functionReturnType), function,
											Xtend2Package.Literals.XTEND_FUNCTION__RETURN_TYPE,
											ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INCOMPATIBLE_RETURN_TYPE);
								}
							}
						}
					}
					if (commonVisibility == null) {
						addDispatchError(type, dispatchOperations, "All local dispatch functions must have the same visibility.", 
								XTEND_FUNCTION__VISIBILITY, DISPATCH_FUNCTIONS_WITH_DIFFERENT_VISIBILITY);
					}
					if (expectStatic == null && commonStatic == null) {
						addDispatchError(type, dispatchOperations, "Static and non-static dispatch functions can not be mixed.", 
								XTEND_FUNCTION__STATIC,	DISPATCH_FUNCTIONS_MIXED_STATIC_AND_NON_STATIC);
					}
					for (final List<JvmType> paramTypes : signatures.keySet()) {
						Collection<JvmOperation> ops = signatures.get(paramTypes);
						if (ops.size() > 1) {
							if (Iterables.any(ops, new Predicate<JvmOperation>() {
								public boolean apply(JvmOperation input) {
									return !getParamTypes(input, false).equals(paramTypes);
								}
							})) {
								for (JvmOperation jvmOperation : ops) {
									XtendFunction function = associations.getXtendFunction(jvmOperation);
									error("Duplicate dispatch function. Primitives cannot overload their wrapper types in dispatch functions.",
											function, null, DUPLICATE_METHOD);
								}
							}
						}
					}
				}
			}
		}
	}

	protected void addDispatchError(JvmGenericType type, Iterable<JvmOperation> operations, String message, EStructuralFeature preferredFeature, String ISSUE_ID) {
		for (JvmOperation jvmOperation : operations)
			if (jvmOperation.getDeclaringType() == type)
				addDispatchError(jvmOperation, message, preferredFeature, ISSUE_ID);
	}
	
	protected void addDispatchError(JvmOperation jvmOperation, String message, EStructuralFeature preferredFeature, String ISSUE_ID) {
		XtendFunction function = associations.getXtendFunction(jvmOperation);
		if (function != null) {
			EStructuralFeature feature = (function.eIsSet(preferredFeature)) ? preferredFeature : XTEND_FUNCTION__DISPATCH;
			error(message, function, feature, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, ISSUE_ID);
		}
	}

	protected List<JvmType> getParamTypes(JvmOperation jvmOperation, boolean wrapPrimitives) {
		List<JvmType> types = newArrayList();
		for (JvmFormalParameter p : jvmOperation.getParameters()) {
			JvmTypeReference reference = wrapPrimitives ? primitives.asWrapperTypeIfPrimitive(p.getParameterType()) : p
					.getParameterType();
			types.add(reference.getType());
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

		found.clear();
		collectReturnExpressions(func.getExpression(), found);
		for (XReturnExpression ret : found) {
			if (ret.getExpression() != null) {
				error("Return with expression is not allowed within an initializer of a create function.", ret, null,
						INVALID_EARLY_EXIT);
			}
		}
	}

	@Check
	public void checkCreateFunctionIsNotTypeVoid(XtendFunction func) {
		if (func.getCreateExtensionInfo() == null)
			return;
		JvmOperation operation = associations.getDirectlyInferredOperation(func);
		if (func.getReturnType() == null) {
			if (getTypeRefs().is(operation.getReturnType(), Void.TYPE)) {
				error("void is an invalid type for the create function " + func.getName(), func,
						Xtend2Package.Literals.XTEND_FUNCTION__NAME, INVALID_USE_OF_TYPE);
			}
		} else if (getTypeRefs().is(func.getReturnType(), Void.TYPE)) {
			if (func.getReturnType() != null)
				error("Create function " + func.getName() + " may not declare return type void.", func.getReturnType(),
						null, INVALID_USE_OF_TYPE);
			else
				error("The inherited return type void of " + func.getName() + " is invalid for create functions.",
						func.getReturnType(), null, INVALID_USE_OF_TYPE);
		}
	}
	
	@Check
	public void checkCreateFunctionIsNotGeneric(XtendFunction func) {
		if (func.getCreateExtensionInfo() == null)
			return;
		if (!func.getTypeParameters().isEmpty())
			error("Create methods can not have type parameters.", func, Xtend2Package.Literals.XTEND_FUNCTION__STATIC,
					INVALID_USE_OF_STATIC);
	}
	
	@Check
	public void checkCreateFunctionIsNotStatic(XtendFunction func) {
		if (func.getCreateExtensionInfo() == null)
			return;
		if (func.isStatic())
			error("Create methods can not be static.", func, Xtend2Package.Literals.XTEND_FUNCTION__STATIC,
					INVALID_USE_OF_STATIC);
	}

	@Override
	public void checkInnerExpressions(XBlockExpression block) {
		if (block instanceof RichString)
			return;
		super.checkInnerExpressions(block);
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

	@Check
	public void checkImports(XtendFile file) {
		final Map<JvmType, XtendImport> imports = newHashMap();
		final Map<JvmType, XtendImport> staticImports = newHashMap();
		final Map<String, JvmType> importedNames = newHashMap();
		
		for (XtendImport imp : file.getImports()) {
			if (imp.getImportedNamespace() != null) {
				warning("The use of wildcard imports is deprecated.", imp, null, IssueCodes.IMPORT_WILDCARD_DEPRECATED);
			} else {
				JvmType importedType = imp.getImportedType();
				if (importedType != null && !importedType.eIsProxy()) {
					Map<JvmType, XtendImport> map = imp.isStatic() ? staticImports : imports;
					if (map.containsKey(importedType)) {
						warning("Duplicate import of '" + importedType.getSimpleName() + "'.", imp, null,
								IssueCodes.IMPORT_DUPLICATE);
					} else {
						map.put(importedType, imp);
						if (!imp.isStatic()) {
							JvmType currentType = importedType;
							String currentSuffix = currentType.getSimpleName();
							importedNames.put(currentSuffix, importedType);
							while (currentType.eContainer() instanceof JvmType) {
								currentType = (JvmType) currentType.eContainer();
								currentSuffix = currentType.getSimpleName()+"$"+currentSuffix;
								importedNames.put(currentSuffix, importedType);
							}
						}
					}
				}
			}
		}
		ICompositeNode node = NodeModelUtils.findActualNodeFor(file.getXtendClass());
		for (INode n : node.getAsTreeIterable()) {
			if (n.getGrammarElement() instanceof CrossReference) {
				EClassifier classifier = ((CrossReference) n.getGrammarElement()).getType().getClassifier();
				if (classifier instanceof EClass
						&& (TypesPackage.Literals.JVM_TYPE.isSuperTypeOf((EClass) classifier) || TypesPackage.Literals.JVM_CONSTRUCTOR
								.isSuperTypeOf((EClass) classifier))) {
					String simpleName = n.getText().trim();
					// handle StaticQualifier Workaround (see Xbase grammar)
					if (simpleName.endsWith("::"))
						simpleName = simpleName.substring(0, simpleName.length() - 2);
					if (importedNames.containsKey(simpleName)) {
						JvmType type = importedNames.remove(simpleName);
						imports.remove(type);
					} else {
						while (simpleName.contains("$")) {
							simpleName = simpleName.substring(0, simpleName.lastIndexOf('$'));
							if (importedNames.containsKey(simpleName)) {
								imports.remove(importedNames.remove(simpleName));
								break;
							}
						}
					}
				}
			}
		}
		for (XtendImport imp : imports.values()) {
			warning("The import '" + imp.getImportedTypeName() + "' is never used.", imp, null,
					IssueCodes.IMPORT_UNUSED);
		}
	}
	
	@Check
	public void checkLocalUsageOfDeclaredFields(XtendField field){
		JvmField jvmField = associations.getJvmField(field);
		if(jvmField.getVisibility() == JvmVisibility.PRIVATE && !isLocallyUsed(jvmField, field.eContainer())){
				String message = "The value of the field " + jvmField.getDeclaringType().getSimpleName()+"."
							+ jvmField.getSimpleName() + " is not used";
				warning(message, Xtend2Package.Literals.XTEND_FIELD__NAME, FIELD_LOCALLY_NEVER_READ);
		}
	}
	
	@Check
	public void checkLocalUsageOfDeclaredXtendFunction(XtendFunction function){
		JvmOperation jvmOperation = function.isDispatch()?associations.getDispatchOperation(function):associations.getDirectlyInferredOperation(function);
		if(jvmOperation.getVisibility() == JvmVisibility.PRIVATE && !isLocallyUsed(jvmOperation, function.eContainer())){
			String message = "The method " + jvmOperation.getSimpleName() 
					+  uiStrings.parameters(jvmOperation)  
					+ " from the type "+jvmOperation.getDeclaringType().getSimpleName()+" is never used locally.";
			warning(message, Xtend2Package.Literals.XTEND_FUNCTION__NAME, FUNCTION_LOCALLY_NEVER_USED);
		}
	}
	
	@Check
	public void checkDeclaredExceptions(XtendConstructor constructor){
		JvmConstructor jvmType = associations.getInferredConstructor(constructor);
		checkExceptions(constructor,jvmType.getExceptions(), Xtend2Package.Literals.XTEND_CONSTRUCTOR__EXCEPTIONS);
	}
	
	@Check
	public void checkDeclaredExceptions(XtendFunction function){
		JvmOperation jvmType = associations.getDirectlyInferredOperation(function);
		checkExceptions(function,jvmType.getExceptions(), Xtend2Package.Literals.XTEND_FUNCTION__EXCEPTIONS);
	}
	
	private void checkExceptions(EObject context, EList<JvmTypeReference> exceptions, EReference reference){
		Set<String> declaredExceptionNames = Sets.newHashSet();
		JvmTypeReference throwableType = typeReferences.getTypeForName(Throwable.class, context);
		for(JvmTypeReference exception : exceptions){
			if(!typeConformanceComputer.isConformant(throwableType, exception))
				error("No exception of type " + exception.getSimpleName() + " can be thrown; an exception type must be a subclass of Throwable"
						, reference, exceptions.indexOf(exception), EXCEPTION_NOT_THROWABLE);
			if(!declaredExceptionNames.add(exception.getQualifiedName()))
				error("Exception " + exception.getSimpleName() + " is declared twice", reference, exceptions.indexOf(exception), EXCEPTION_DECLARED_TWICE);
		}
	}
	
}
