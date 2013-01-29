/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.validation;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Maps.*;
import static com.google.common.collect.Sets.*;
import static org.eclipse.xtend.core.validation.IssueCodes.*;
import static org.eclipse.xtend.core.xtend.XtendPackage.Literals.*;
import static org.eclipse.xtext.util.Strings.*;
import static org.eclipse.xtext.xbase.validation.IssueCodes.*;

import java.lang.annotation.ElementType;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.dispatch.DispatchingSupport;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.richstring.RichStringProcessor;
import org.eclipse.xtend.core.typing.ReturnTypeProvider;
import org.eclipse.xtend.core.typing.XtendOverridesService;
import org.eclipse.xtend.core.xtend.RichString;
import org.eclipse.xtend.core.xtend.RichStringElseIf;
import org.eclipse.xtend.core.xtend.RichStringForLoop;
import org.eclipse.xtend.core.xtend.RichStringIf;
import org.eclipse.xtend.core.xtend.XtendAnnotationTarget;
import org.eclipse.xtend.core.xtend.XtendAnnotationType;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendEnum;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendInterface;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtend.lib.Property;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
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
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.documentation.IEObjectDocumentationProviderExtension;
import org.eclipse.xtext.documentation.IJavaDocTypeReferenceProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.Tuples;
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
import org.eclipse.xtext.xbase.compiler.JavaKeywords;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeExtensions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.scoping.XbaseScopeProvider;
import org.eclipse.xtext.xbase.validation.UIStrings;
import org.eclipse.xtext.xtype.XtypePackage;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
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
@Deprecated
@ComposedChecks(validators = { AnnotationValidation.class })
public class XtendJavaValidator extends XbaseWithAnnotationsJavaValidator {

	@Inject
	private FeatureOverridesService featureOverridesService;

	@Inject
	private TypeArgumentContextProvider typeArgumentContextProvider;

	@Inject
	private RichStringProcessor richStringProcessor;

	@Inject
	private IXtendJvmAssociations associations;

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
	private JavaKeywords javaUtils;
	
	@Inject 
	private UIStrings uiStrings;
	
	@Inject
	private ILogicalContainerProvider containerProvider;
	
	@Inject
	private JvmTypeExtensions typeExtensions;
	
	@Inject
	private ReturnTypeProvider returnTypeProvider;

	@Inject
	private IJavaDocTypeReferenceProvider javaDocTypeReferenceProvider;

	@Inject
	private IScopeProvider scopeProvider;

	@Inject
	private IEObjectDocumentationProvider documentationProvider;

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;


	private final Set<EReference> typeConformanceCheckedReferences = ImmutableSet.copyOf(Iterables.concat(
			super.getTypeConformanceCheckedReferences(), 
			ImmutableSet.of(
					XtendPackage.Literals.RICH_STRING_FOR_LOOP__AFTER, 
					XtendPackage.Literals.RICH_STRING_FOR_LOOP__BEFORE,
					XtendPackage.Literals.RICH_STRING_FOR_LOOP__SEPARATOR, 
					XtendPackage.Literals.RICH_STRING_IF__IF,
					XtendPackage.Literals.RICH_STRING_ELSE_IF__IF)));

	protected final Set<String> visibilityModifers = newHashSet("public", "private", "protected", "package");
	
	@Override
	protected List<EPackage> getEPackages() {
		return newArrayList(XtendPackage.eINSTANCE, XtypePackage.eINSTANCE, XbasePackage.eINSTANCE, XAnnotationsPackage.eINSTANCE);
	}

	@Override
	protected Set<EReference> getTypeConformanceCheckedReferences() {
		return typeConformanceCheckedReferences;
	}
	
	@Check
	public void checkPropertyAnnotation(XtendField field) {
		if (hasAnnotation(field, Property.class) && field.isStatic()) {
			error("A property must not be static", XtendPackage.Literals.XTEND_MEMBER__MODIFIERS, 
					field.getModifiers().indexOf("static"), STATIC_PROPERTY);
		}
	}
	
	protected boolean hasAnnotation(XtendAnnotationTarget source, Class<?> class1) {
		for (XAnnotation anno : source.getAnnotations()) {
			if (anno != null && anno.getAnnotationType() != null && class1.getName().equals(anno.getAnnotationType().getIdentifier()))
				return true;
 		}
		return false;
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
		// skip synthetic container
		if (eContainer.eClass() == XtendPackage.Literals.XTEND_MEMBER || eContainer.eClass() == XtendPackage.Literals.XTEND_TYPE_DECLARATION) {
			return eContainer.eContainer();
		}
		return eContainer;
	}

	protected Map<Class<?>, ElementType> getTargetInfos() {
		Map<Class<?>, ElementType> result = newHashMap();
		result.put(XtendClass.class, ElementType.TYPE);
		result.put(XtendInterface.class, ElementType.TYPE);
		result.put(XtendEnum.class, ElementType.TYPE);
		result.put(XtendAnnotationType.class, ElementType.ANNOTATION_TYPE);
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
						 JvmTypeReference typeReference = field.getType();
						 if (typeReference != null) {
							 JvmType type = typeReference.getType();
							 if(type != null) 
								 type2extension.put(type, field);
						 }
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
					error("Duplicate field " + name, field, XtendPackage.Literals.XTEND_FIELD__NAME, DUPLICATE_FIELD);
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
				error("void is an invalid type for the parameter " + param.getName() + " of the method "
						+ function.getName(), param.getParameterType(), null, INVALID_USE_OF_TYPE);
			else
				error("void is an invalid type for the parameter " + param.getName(), param.getParameterType(), null,
						INVALID_USE_OF_TYPE);
		}
	}
	@Check
	public void checkVarArgComesLast(XtendParameter param) {
		if (param.isVarArg()) {
			@SuppressWarnings("unchecked")
			EList<XtendParameter> params = (EList<XtendParameter>) param.eContainer().eGet(param.eContainingFeature());
			if (param != Iterables.getLast(params)) {
				error("A vararg must be the last parameter.", param, XTEND_PARAMETER__VAR_ARG, INVALID_USE_OF_VAR_ARG);
			}
		}
	}
	
	@Check
	public void checkClassPath(XtendTypeDeclaration type) {
		final JvmGenericType listType = (JvmGenericType) getTypeRefs().findDeclaredType(List.class.getName(), type);
		if (listType == null || listType.getTypeParameters().isEmpty()) {
			error("Xtend requires Java source level 1.5.", type, XTEND_TYPE_DECLARATION__NAME,
					IssueCodes.XBASE_LIB_NOT_ON_CLASSPATH);
		}
		if (getTypeRefs().findDeclaredType(StringConcatenation.class, type) == null || getTypeRefs().findDeclaredType(Exceptions.class, type) == null) {
			error("Mandatory library bundle 'org.eclipse.xtext.xbase.lib' 2.3.0 or higher not found on the classpath.", type,
					XTEND_TYPE_DECLARATION__NAME, IssueCodes.XBASE_LIB_NOT_ON_CLASSPATH);
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
				if (inferredType != null && hasCycleInHierarchy(inferredType, Sets.<JvmGenericType> newHashSet())) {
					error("The inheritance hierarchy of " + notNull(xtendClass.getName()) + " contains cycles",
							XTEND_TYPE_DECLARATION__NAME, CYCLIC_INHERITANCE);
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

	@Check
	public void checkSuperTypes(XtendInterface xtendInterface) {
		for (int i = 0; i < xtendInterface.getExtends().size(); ++i) {
			JvmTypeReference implementedType = xtendInterface.getExtends().get(i);
			if (!(implementedType.getType() instanceof JvmGenericType)
					|| !((JvmGenericType) implementedType.getType()).isInterface()) {
				error("Extended interface must be an interface", XTEND_INTERFACE__EXTENDS, i, INTERFACE_EXPECTED);
			}
		}
		JvmGenericType inferredType = associations.getInferredType(xtendInterface);
		if(inferredType != null && hasCycleInHierarchy(inferredType, Sets.<JvmGenericType> newHashSet())) {
			error("The inheritance hierarchy of " + notNull(xtendInterface.getName()) + " contains cycles",
					XTEND_TYPE_DECLARATION__NAME, CYCLIC_INHERITANCE);
		}
	}

	protected boolean hasCycleInHierarchy(JvmGenericType type, Set<JvmGenericType> processedSuperTypes) {
		if (processedSuperTypes.contains(type))
			return true;
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
							return "XtendJavaValidator.checkDuplicateAndOverriddenFunctions [inferredType="
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
	
	@Check
	public void checkDuplicateAndOverriddenFunctions(XtendInterface xtendInterface) {
		final JvmGenericType inferredType = associations.getInferredType(xtendInterface);
		if (inferredType != null) {
			final JvmParameterizedTypeReference typeReference = typeReferences.createTypeRef(inferredType);
			if (xtendInterface.getTypeParameters().isEmpty())
				typeReference.getArguments().clear();
			final ITypeArgumentContext typeArgumentContext = typeArgumentContextProvider
					.getTypeArgumentContext(new TypeArgumentContextProvider.AbstractRequest() {
						@Override
						public JvmTypeReference getReceiverType() {
							return typeReference;
						}

						@Override
						public String toString() {
							return "XtendJavaValidator.checkDuplicateAndOverriddenFunctions [inferredType="
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
			doCheckOverriddenMethods(xtendInterface, inferredType, typeArgumentContext, operationsPerErasure);
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
	
	
	protected void doCheckOverriddenMethods(XtendTypeDeclaration xtendType, final JvmGenericType inferredType,
			final ITypeArgumentContext typeArgumentContext, Multimap<Object, JvmOperation> operationsPerErasure) {
		List<JvmOperation> operationsMissingImplementation = null;
		boolean doCheckAbstract = !inferredType.isAbstract();
		if (doCheckAbstract) {
			doCheckAbstract = false;
			for (JvmTypeReference superType: inferredType.getSuperTypes()) {
				JvmType type = superType.getType();
				if (type instanceof JvmGenericType) {
					if (((JvmGenericType) type).isAbstract() || ((JvmGenericType) type).isInterface()) {
						doCheckAbstract = true;
						break;
					}
				}
			}
		}
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
				if (doCheckAbstract && operation.isAbstract()) {
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
		if(xtendType instanceof XtendClass && operationsMissingImplementation != null) {
			reportMissingImplementations((XtendClass) xtendType, typeArgumentContext, operationsMissingImplementation);
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
		error(errorMsg.toString(), xtendClass, XTEND_TYPE_DECLARATION__NAME, CLASS_MUST_BE_ABSTRACT, 
						toArray(uris, String.class));
	}
	
	@Check
	protected void checkFunctionOverride(XtendFunction function) {
		JvmOperation operation = associations.getDirectlyInferredOperation(function);
		JvmOperation overriddenOperation = overridesService.findOverriddenOperation(function);
		if (overriddenOperation == null) {
			if (function.isOverride()) {
				error("The method "+ uiStrings.signature(operation) +" of type "+operation.getDeclaringType().getSimpleName()+" must override a superclass method.", 
						function, XTEND_MEMBER__MODIFIERS, function.getModifiers().indexOf("override"), OBSOLETE_OVERRIDE);
			}
			return;
		}
		if (!function.isOverride())
			error("The method " + uiStrings.signature(operation) +" of type "+operation.getDeclaringType().getSimpleName()+" must use override keyword since it actually overrides a supertype method.", function,
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
		JvmTypeReference returnType = function.getReturnType();
		if (returnType == null)
			return;
		ITypeArgumentContext typeArgumentContext = typeArgumentContextProvider
				.getTypeArgumentContext(new TypeArgumentContextProvider.ReceiverRequest(getTypeRefs().createTypeRef(
						inferredOperation.getDeclaringType())));
		JvmTypeReference returnTypeUpperBound = typeArgumentContext.getUpperBound(overriddenOperation.getReturnType(),
				function);
		//TODO: Rethink about this 80% fix when https://bugs.eclipse.org/bugs/show_bug.cgi?id=376037 is fixed
		// T[] and List<T> will result in an error as before but T is fixed with this small workaround
		// There are two failing ignored tests in org.eclipse.xtend.core.tests.validation.OverrideValidationTest that should be green after the fix
		// org.eclipse.xtend.core.tests.validation.OverrideValidationTest.testOverrideReturnType_1()
		// org.eclipse.xtend.core.tests.validation.OverrideValidationTest.testOverrideReturnType_2()
		if(returnType.getType() instanceof JvmTypeParameter && returnTypeUpperBound.getType() instanceof JvmTypeParameter)
			return;

		if (!isConformant(returnTypeUpperBound, returnType)) {
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

	@Check
	public void checkDefaultSuperConstructor(XtendClass xtendClass) {
		JvmGenericType inferredType = associations.getInferredType(xtendClass);
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
							EList<XExpression> expressions = ((XBlockExpression) expression).getExpressions();
							if(expressions.isEmpty() || !isDelegatConstructorCall(expressions.get(0))) {
								XtendConstructor xtendConstructor = associations.getXtendConstructor(constructor);
								error("No default constructor in super type " + superType.getSimpleName() 
										+ ". Another constructor must be invoked explicitly.",
										xtendConstructor, null, MUST_INVOKE_SUPER_CONSTRUCTOR);
							}
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
	public void checkAbstract(XtendFunction function) {
		if (function.getExpression() == null) {
			if(function.getDeclaringType() instanceof XtendClass) {
				XtendClass declarator = (XtendClass) function.getDeclaringType();
				if (function.isDispatch()) {
					error("The dispatch method " + function.getName() + " in type " + declarator.getName() + " must not be abstract",XTEND_FUNCTION__NAME, -1, DISPATCH_FUNCTIONS_MUST_NOT_BE_ABSTRACT);
					return;
				}
				if (function.getCreateExtensionInfo() != null) {
					error("The 'create'-method " + function.getName() + " in type " + declarator.getName() + " must not be abstract",XTEND_FUNCTION__NAME, -1, CREATE_FUNCTIONS_MUST_NOT_BE_ABSTRACT);
					return;
				}
				if (!declarator.isAbstract()) {
					error("The abstract method " + function.getName() + " in type " + declarator.getName() + " can only be defined by an abstract class.", 
							XTEND_FUNCTION__NAME, -1, MISSING_ABSTRACT);
				}
				if(function.getReturnType() == null) {
					error("The abstract method " + function.getName() + " in type " + declarator.getName() + " must declare a return type",
							XTEND_FUNCTION__NAME, -1, ABSTRACT_METHOD_MISSING_RETURN_TYPE);
				}
			} else if(function.eContainer() instanceof XtendInterface) {
				XtendInterface declarator = (XtendInterface) function.eContainer();
				if (function.getCreateExtensionInfo() != null) {
					error("'Create'-method " + function.getName() + " is not permitted in an interface", XTEND_FUNCTION__NAME, -1, CREATE_FUNCTIONS_MUST_NOT_BE_ABSTRACT);
					return;
				}
				if(function.getReturnType() == null && !function.isOverride()) {
					error("The abstract method " + function.getName() + " in type " + declarator.getName() + " must declare a return type",
							XTEND_FUNCTION__NAME, -1, ABSTRACT_METHOD_MISSING_RETURN_TYPE);
				}
			}
		} else if(function.getDeclaringType() instanceof XtendInterface) {
			error("Abstract methods do not specify a body", XTEND_FUNCTION__NAME, -1, ABSTRACT_METHOD_WITH_BODY);
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
			Multimap<Pair<String, Integer>, JvmOperation> dispatchMethods = dispatchingSupport.getDispatchMethods(type);
			checkDispatchNonDispatchConflict(clazz, dispatchMethods);
			for (Pair<String, Integer> key : dispatchMethods.keySet()) {
				Collection<JvmOperation> dispatchOperations = dispatchMethods.get(key);
				JvmOperation syntheticDispatchMethod = dispatchingSupport.findSyntheticDispatchMethod(clazz, key);
				JvmOperation overriddenOperation = overridesService.findOverriddenOperation(syntheticDispatchMethod);
				Boolean expectStatic = null;
				if(overriddenOperation != null) { 
					if (isMorePrivateThan(syntheticDispatchMethod.getVisibility(), overriddenOperation.getVisibility())) {
						String msg = "Synthetic dispatch method reduces visibility of overridden method " + overriddenOperation.getIdentifier();
						addDispatchError(type, dispatchOperations, msg, null, OVERRIDE_REDUCES_VISIBILITY);
					}
					expectStatic = overriddenOperation.isStatic();
				} 
				if (dispatchOperations.size() == 1) {
					JvmOperation singleOp = dispatchOperations.iterator().next();
					XtendFunction function = associations.getXtendFunction(singleOp);
					addIssue(function, SINGLE_DISPATCH_FUNCTION, "Single dispatch method.",
							XTEND_MEMBER__MODIFIERS, function.getModifiers().indexOf("dispatch"));
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
						}
						XtendFunction function = associations.getXtendFunction(jvmOperation);
						if (function != null) {
							JvmTypeReference functionReturnType = returnTypeProvider.computeReturnType(function);
							if (functionReturnType != null) {
								if (!isConformant(jvmOperation.getReturnType(), functionReturnType)) {
									error("Incompatible return type of dispatch method. Expected "
											+ getNameOfTypes(jvmOperation.getReturnType()) + " but was "
											+ canonicalName(functionReturnType), function,
											XtendPackage.Literals.XTEND_FUNCTION__RETURN_TYPE,
											ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INCOMPATIBLE_RETURN_TYPE);
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
								"static", DISPATCH_FUNCTIONS_MIXED_STATIC_AND_NON_STATIC);
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
									error("Duplicate dispatch methods. Primitives cannot overload their wrapper types in dispatch methods.",
											function, null, DUPLICATE_METHOD);
								}
							}
						}
					}
				}
			}
		}
	}

	protected void checkDispatchNonDispatchConflict(XtendClass clazz,
			Multimap<Pair<String, Integer>, JvmOperation> dispatchMethods) {
		if(isIgnored(DISPATCH_PLAIN_FUNCTION_NAME_CLASH)) {
			return;
		}
		Multimap<Pair<String, Integer>, XtendFunction> nonDispatchMethods = HashMultimap.create();
		for(XtendFunction method: filter(clazz.getMembers(), XtendFunction.class)) {
			if(!method.isDispatch()) {
				nonDispatchMethods.put(Tuples.create(method.getName(), method.getParameters().size()), method);
			}
		}
		for(Pair<String, Integer> dispatchSignature: dispatchMethods.keySet()) {
			if(nonDispatchMethods.containsKey(dispatchSignature)) {
				for(XtendFunction function: nonDispatchMethods.get(dispatchSignature)) 
					addIssue(function, DISPATCH_PLAIN_FUNCTION_NAME_CLASH,
							"Non-dispatch method has same name and number of parameters as dispatch method",
							XTEND_FUNCTION__NAME);
				for(JvmOperation operation: dispatchMethods.get(dispatchSignature)) 
					addIssue(associations.getXtendFunction(operation), DISPATCH_PLAIN_FUNCTION_NAME_CLASH,
							"Dispatch method has same name and number of parameters as non-dispatch method",
							XTEND_FUNCTION__NAME);
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
				error("Return with expression is not allowed within an initializer of a create method.", ret, null,
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
				error("void is an invalid type for the create method " + func.getName(), func,
						XtendPackage.Literals.XTEND_FUNCTION__NAME, INVALID_USE_OF_TYPE);
			}
		} else if (getTypeRefs().is(func.getReturnType(), Void.TYPE)) {
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

	@Check
	public void checkUniqueTypeNames(XtendFile file) {
		//TODO this check should not be file local, but instead check for any other sources which might declare a
		// java type with the same name. Also this then belongs to Xbase and should be defined on JvmGenericTypes.
		Set<String> names = newLinkedHashSet();
		for (XtendTypeDeclaration type : file.getXtendTypes()) {	
			if (!names.add(type.getName()))
				error("The type "+type.getName()+" is already defined.", type, XtendPackage.Literals.XTEND_TYPE_DECLARATION__NAME, -1, IssueCodes.DUPLICATE_TYPE_NAME);
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
	public void checkLocalUsageOfDeclaredFields(XtendField field) {
		if(doCheckValidMemberName(field) && !isIgnored(UNUSED_PRIVATE_MEMBER)) {
			JvmField jvmField = associations.getJvmField(field);
			if (jvmField == null || jvmField.getVisibility() != JvmVisibility.PRIVATE)
				return;
			if (hasAnnotation(field.getAnnotations(), Property.class))
				return;
			if (hasAnnotation(((XtendAnnotationTarget)field.eContainer()).getAnnotations(), Data.class))
				return;
			if (isLocallyUsed(jvmField, field.eContainer())) 
				return;
			String message;
			if(field.isExtension()) {
				if(field.getName() == null && jvmField.getType() != null)
					message = "The extension " + jvmField.getType().getIdentifier() 
						+ " is not used in " + jvmField.getDeclaringType().getSimpleName();
				else
					message = "The extension " + jvmField.getDeclaringType().getSimpleName() + "."
							+ jvmField.getSimpleName() + " is not used";
			} else {
				message = "The value of the field " + jvmField.getDeclaringType().getSimpleName() + "."
					+ jvmField.getSimpleName() + " is not used";
			}
			addIssueToState(UNUSED_PRIVATE_MEMBER, message, XtendPackage.Literals.XTEND_FIELD__NAME);
		}
	}
	
	@Check
	public void checkLocalUsageOfDeclaredXtendFunction(XtendFunction function){
		if(doCheckValidMemberName(function) && !isIgnored(UNUSED_PRIVATE_MEMBER)) {
			JvmOperation jvmOperation = function.isDispatch()?associations.getDispatchOperation(function):associations.getDirectlyInferredOperation(function);
			if(jvmOperation != null && jvmOperation.getVisibility() == JvmVisibility.PRIVATE && !isLocallyUsed(jvmOperation, function.eContainer())){
				String message = "The method " + jvmOperation.getSimpleName() 
						+  uiStrings.parameters(jvmOperation)  
						+ " from the type "+jvmOperation.getDeclaringType().getSimpleName()+" is never used locally.";
				addIssueToState(UNUSED_PRIVATE_MEMBER, message, XtendPackage.Literals.XTEND_FUNCTION__NAME);
			}
		}
	}
	
	@Check
	public void checkDeclaredExceptions(XtendConstructor constructor){
		JvmConstructor jvmType = associations.getInferredConstructor(constructor);
		checkExceptions(constructor,jvmType.getExceptions(), XtendPackage.Literals.XTEND_CONSTRUCTOR__EXCEPTIONS);
	}
	
	@Check
	public void checkTypeParametersAreUnsupported(XtendConstructor constructor){
		if (!constructor.getTypeParameters().isEmpty()) {
			error("Type parameters are not supported for constructors", XtendPackage.Literals.XTEND_CONSTRUCTOR__TYPE_PARAMETERS, INSIGNIFICANT_INDEX, CONSTRUCTOR_TYPE_PARAMS_NOT_SUPPORTED);
		}
	}
	
	@Check
	public void checkDeclaredExceptions(XtendFunction function){
		JvmOperation jvmType = associations.getDirectlyInferredOperation(function);
		if (jvmType != null) {
			checkExceptions(function,jvmType.getExceptions(), XtendPackage.Literals.XTEND_FUNCTION__EXCEPTIONS);
		}
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
	
	@Check
    public void checkLeftHandSideIsVariable(XAssignment assignment){
        String concreteSyntaxFeatureName = assignment.getConcreteSyntaxFeatureName();
        if(concreteSyntaxFeatureName.equals(XbaseScopeProvider.THIS.toString()))
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
	public void checkFinalFieldInitialization(XtendClass clazz) {
		JvmGenericType inferredType = associations.getInferredType(clazz);
		JvmConstructor inferredConstructor = associations.getInferredConstructor(clazz);
		if(inferredConstructor != null)
			for (XAnnotation anno : clazz.getAnnotations()) {
				if (anno.getAnnotationType() != null && Data.class.getName().equals(anno.getAnnotationType().getIdentifier()))
					return;
			}
		super.checkFinalFieldInitialization(inferredType);
	}
	
	@Check
	public void checkFinalFieldInitialization(XtendInterface xtendInterface) {
		JvmGenericType inferredType = associations.getInferredType(xtendInterface);
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
					if(candidate == null)
						addIssue(member, IssueCodes.JAVA_DOC_LINKING_DIAGNOSTIC,  "javaDoc: " + typeRefString + " cannot be resolved to a type", region.getOffset(), region.getLength());
				}
			}
		}
	}


	@Override
	protected void reportUninitializedField(JvmField field) {
		EObject element = associations.getPrimarySourceElement(field);
		if (element instanceof XtendField) {
			XtendField xtendField = (XtendField) element;
			error("The blank final field "+xtendField.getName()+" may not have been initialized.", xtendField, XTEND_FIELD__NAME, FIELD_NOT_INITIALIZED);
		}
	}
	
	protected boolean hasAnnotation(Iterable<? extends XAnnotation> annotations, Class<?> annotationType) {
		for (XAnnotation anno : annotations) {
			if (annotationType.getName().equals(anno.getAnnotationType().getIdentifier()))
				return true;
		}
		return false;
	}
	
	private ModifierValidator classModifierValidator = new ModifierValidator(
			newArrayList("public", "static", "final", "abstract"), this);
		
	private ModifierValidator interfaceModifierValidator = new ModifierValidator(
			newArrayList("public", "abstract"), this);
		
	private ModifierValidator enumModifierValidator = new ModifierValidator(
			newArrayList("public"), this);
		
	private ModifierValidator fieldModifierValidator = new ModifierValidator(
			newArrayList("public", "protected", "package", "private", "static", "final", "val", "var", "extension"), this);
		
	private ModifierValidator fieldInInterfaceModifierValidator = new ModifierValidator(
			newArrayList("public", "static", "final", "val"), this);
		
	private ModifierValidator constructorModifierValidator = new ModifierValidator(
			newArrayList(visibilityModifers), this);
		
	private ModifierValidator methodModifierValidator = new ModifierValidator(
			newArrayList("public", "protected", "package", "private", "static", "abstract", "dispatch", "final", "def", "override"), this);
		
	private ModifierValidator methodInInterfaceModifierValidator = new ModifierValidator(
			newArrayList("public", "abstract", "def", "override"), this);
		
	private ModifierValidator annotationTypeModifierValidator = new ModifierValidator(
			newArrayList("public", "abstract"), this);
		
	@Check
	protected void checkModifiers(XtendClass xtendClass) {
		classModifierValidator.checkModifiers(xtendClass, "class " + xtendClass.getName());
	}
	
	@Check
	protected void checkModifiers(XtendInterface xtendInterface) {
		interfaceModifierValidator.checkModifiers(xtendInterface, "interface " + xtendInterface.getName());
	}
	
	@Check
	protected void checkModifiers(XtendEnum xtendEnum) {
		enumModifierValidator.checkModifiers(xtendEnum, "enum " + xtendEnum.getName());
	}
	
	@Check
	protected void checkModifiers(XtendField field) {
		if(field.getDeclaringType() instanceof XtendClass)
			fieldModifierValidator.checkModifiers(field, "field " + field.getName());
		else if(field.getDeclaringType() instanceof XtendInterface 
				|| field.getDeclaringType() instanceof XtendAnnotationType)
			fieldInInterfaceModifierValidator.checkModifiers(field,  "field " + field.getName());
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
		if(method.getDeclaringType() instanceof XtendClass) {
			methodModifierValidator.checkModifiers(method, "method " + method.getName());
			int abstractIndex = method.getModifiers().indexOf("abstract");
			if (method.getExpression() != null) {
				if (abstractIndex != -1) 
					error("Method " + method.getName() + " with a body cannot be abstract", XTEND_MEMBER__MODIFIERS, abstractIndex, INVALID_MODIFIER);
			} else {
				int finalIndex = method.getModifiers().indexOf("final");
				if(finalIndex != -1) 
					error("Abstract method " + method.getName() + " cannot be final", XTEND_MEMBER__MODIFIERS, finalIndex, INVALID_MODIFIER);
			}
		} else if(method.getDeclaringType() instanceof XtendInterface) {
			methodInInterfaceModifierValidator.checkModifiers(method, "method " + method.getName());			
		}
	}

	@Check
	protected void checkModifiers(XtendAnnotationType annotation) {
		annotationTypeModifierValidator.checkModifiers(annotation, "annotation type " + annotation.getName());
	}

}
