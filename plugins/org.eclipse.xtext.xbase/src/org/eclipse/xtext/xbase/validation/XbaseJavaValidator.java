/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation;

import static com.google.common.collect.Sets.*;
import static org.eclipse.xtext.xbase.XbasePackage.Literals.*;
import static org.eclipse.xtext.xbase.lib.IterableExtensions.*;
import static org.eclipse.xtext.xbase.validation.IssueCodes.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.EcoreUtil2.ElementReferenceAcceptor;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ComposedChecks;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAbstractWhileExpression;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBasicForLoopExpression;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XPostfixOperation;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.XbasePackage.Literals;
import org.eclipse.xtext.xbase.controlflow.IEarlyExitComputer;
import org.eclipse.xtext.xbase.imports.IImportsConfiguration;
import org.eclipse.xtext.xbase.imports.ImportedTypesCollector;
import org.eclipse.xtext.xbase.imports.StaticallyImportedMemberProvider;
import org.eclipse.xtext.xbase.imports.TypeUsages;
import org.eclipse.xtext.xbase.interpreter.ConstantExpressionEvaluationException;
import org.eclipse.xtext.xbase.interpreter.SwitchConstantExpressionsInterpreter;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.computation.NumberLiterals;
import org.eclipse.xtext.xbase.typesystem.computation.SynonymTypesProvider;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceComputationArgument;
import org.eclipse.xtext.xbase.typesystem.legacy.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceVisitorWithNonNullResult;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.util.TypesOrderUtil;
import org.eclipse.xtext.xbase.util.XExpressionHelper;
import org.eclipse.xtext.xbase.util.XSwitchExpressions;
import org.eclipse.xtext.xbase.util.XbaseUsageCrossReferencer;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;
import org.eclipse.xtext.xtype.XtypePackage;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Xbase Validator that does use the scope provider or the type argument context. 
 * It basically disables or replaces all call-outs to the scope and some
 * validations that will be superseded by immediate error annotations during type resolution.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ComposedChecks(validators = { EarlyExitValidator.class })
public class XbaseJavaValidator extends AbstractXbaseJavaValidator {
	
	@Inject
	private XbaseGrammarAccess grammarAccess;

	@Inject
	private XExpressionHelper expressionHelper;

	@Inject
	private IEarlyExitComputer earlyExitComputer;

	@Inject
	private ILogicalContainerProvider logicalContainerProvider;
	
	@Inject
	private NumberLiterals numberLiterals;
	
	@Inject
	private IJvmModelAssociations associations;
	
	@Inject
	private CommonTypeComputationServices services;
	
	@Inject
	private IBatchTypeResolver typeResolver;
	
	@Inject 
	private IImportsConfiguration importsConfiguration;
	
	@Inject 
	private XSwitchExpressions switchExpressions;
	
	@Inject 
	private TypesOrderUtil typesOrderUtil;
	
	@Inject
	private SwitchConstantExpressionsInterpreter switchConstantExpressionsInterpreter;
	
	@Inject
	private Provider<ImportedTypesCollector> importedTypesCollectorProvider;
	
	@Inject
	private StaticallyImportedMemberProvider staticallyImportedMemberProvider;
	
	@Inject
	private ReadAndWriteTracking readAndWriteTracking;
	
	protected CommonTypeComputationServices getServices() {
		return services;
	}
	
	protected LightweightTypeReference getActualType(EObject context, JvmIdentifiableElement element) {
		return typeResolver.resolveTypes(context).getActualType(element);
	}

	protected LightweightTypeReference getActualType(XExpression expression) {
		return typeResolver.resolveTypes(expression).getActualType(expression);
	}
	
	protected LightweightTypeReference getActualType(JvmIdentifiableElement identifiable) {
		return typeResolver.resolveTypes(identifiable).getActualType(identifiable);
	}

	protected LightweightTypeReference getExpectedType(XExpression expression) {
		return typeResolver.resolveTypes(expression).getExpectedType(expression);
	}
	
	protected void checkCast(JvmTypeReference concreteSyntax, LightweightTypeReference toType, LightweightTypeReference fromType) {
		if (toType == null || fromType == null)
			return;
		if (fromType.getType() instanceof JvmDeclaredType || fromType.isPrimitive()) {
			// if one of the types is an interface and the other is a non final class (or interface) there always can be a subtype
			if ((!isInterface(fromType) || isFinal(toType)) && (!isInterface(toType) || isFinal(fromType))) { 
				if (!toType.isAssignableFrom(fromType)) {
					if (   isFinal(fromType) || isFinal(toType)
						|| isClass(fromType) && isClass(toType)) {
						if (!fromType.isAssignableFrom(toType)) { // no upcast
							error("Cannot cast from " + getNameOfTypes(fromType) + " to "
									+ canonicalName(toType), concreteSyntax, null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
									INVALID_CAST);
						}
					}
				}
			}
		} else if (fromType.isPrimitiveVoid()) {
			error("Cannot cast from void to "
					+ canonicalName(toType), concreteSyntax, null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
					INVALID_CAST);
		}
		if(toType.isPrimitive() && !(fromType.isPrimitive() || fromType.isWrapper())) {
				error("Cannot cast from " + getNameOfTypes(fromType) + " to "
						+ canonicalName(toType), concreteSyntax, null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
						INVALID_CAST);
		}
		/*
		 * TODO: JDT reports no unnecessary cast of List<?> but for List<String> ... why is there an exception?
		 * 
		 * 
		 */
//			List<? extends String> list = Collections.emptyList();
//			if (((List<? extends String>)list).isEmpty()) {}
//			List<String> list = Collections.emptyList();
//			if (((List<String>)list).isEmpty()) {}
//			List list = Collections.emptyList();
//			if (((List)list).isEmpty()) {}
		if (toType.getIdentifier().equals(fromType.getIdentifier())) {
			addIssue("Unnecessary cast from " + fromType.getHumanReadableName() + " to " + toType.getHumanReadableName(), concreteSyntax, IssueCodes.OBSOLETE_CAST);
		}
	}
	
	private boolean isInterface(LightweightTypeReference typeRef) {
		return isInterface(typeRef.getType());
	}
	
	private boolean isClass(LightweightTypeReference typeRef) {
		return typeRef.getType() instanceof JvmGenericType && !((JvmGenericType)typeRef.getType()).isInterface();
	}
	
	@Check
	protected void checkNumberFormat(XNumberLiteral literal) {
		try {
			numberLiterals.numberValue(literal, numberLiterals.getJavaType(literal));
		} catch (Exception e) {
			error("Invalid number format: " + e.getMessage(), Literals.XNUMBER_LITERAL__VALUE, INVALID_NUMBER_FORMAT);
		}
	}
	
	@Check
	public void checkTypeReferenceIsNotVoid(XExpression expression) {
		for (EObject eObject : expression.eContents()) {
			if (eObject instanceof JvmTypeReference) {
				JvmTypeReference typeRef = (JvmTypeReference) eObject;
				if (isPrimitiveVoid(typeRef)) {
					error("Primitive void cannot be used here.", typeRef, null, INVALID_USE_OF_TYPE);
				}
			}
		}
	}

	protected boolean isPrimitiveVoid(JvmTypeReference typeReference) {
		return typeReference != null && typeReference.getType() != null && !typeReference.getType().eIsProxy() && typeReference.getType() instanceof JvmVoid;
	}

	@Check
	public void checkVariableIsNotInferredAsVoid(XVariableDeclaration declaration) {
		if (declaration.getType() != null)
			return;
		LightweightTypeReference variableType = typeResolver.resolveTypes(declaration).getActualType((JvmIdentifiableElement) declaration);
		// TODO move to type resolver
		if (variableType != null && variableType.isPrimitiveVoid()) {
			error("void is an invalid type for the variable " + declaration.getName(), declaration,
					XbasePackage.Literals.XVARIABLE_DECLARATION__NAME, INVALID_USE_OF_TYPE);
		}
	}
	
	@Check
	public void checkClosureParameterTypes(XClosure closure) {
		if (closure.getFormalParameters().isEmpty())
			return;
		LightweightTypeReference closureType = getActualType(closure);
		if (closureType != null && closureType.isUnknown())
			return;
		boolean checkedClosure = false;
		for (JvmFormalParameter p : closure.getFormalParameters()) {
			if (p.getParameterType() == null) {
				if (!checkedClosure) {
					LightweightTypeReference type = getExpectedType(closure);
					if (type == null) {
						error("There is no context to infer the closure's argument types from. Consider typing the arguments or put the closures into a typed context.",
								closure, null, INSIGNIFICANT_INDEX, TOO_LITTLE_TYPE_INFORMATION);
						return;
					} else {
						JvmOperation operation = getServices().getFunctionTypes().findImplementingOperation(type);
						if (operation == null) {
							error("There is no context to infer the closure's argument types from. Consider typing the arguments or use the closures in a more specific context.",
									closure, null, INSIGNIFICANT_INDEX, TOO_LITTLE_TYPE_INFORMATION);
							return;
						}
					}
					checkedClosure = true;
				}
				LightweightTypeReference parameterType = getActualType(closure, p);
				if (parameterType == null) {
					error("There is no context to infer the closure's argument types from. Consider typing the arguments or use the closures in a more specific context.",
							closure, null, INSIGNIFICANT_INDEX, TOO_LITTLE_TYPE_INFORMATION);
					return;
				}
			}
		}
	}

	@Check
	public void checkTypeArguments(XAbstractFeatureCall expression) {
		for (JvmTypeReference typeRef : expression.getTypeArguments()) {
			ensureNotPrimitiveNorWildcard(typeRef);
		}
	}

	@Check
	public void checkTypeArguments(XConstructorCall expression) {
		for (JvmTypeReference typeRef : expression.getTypeArguments()) {
			ensureNotPrimitiveNorWildcard(typeRef);
		}
	}

	protected void ensureNotPrimitiveNorWildcard(JvmTypeReference typeRef) {
		LightweightTypeReference reference = toLightweightTypeReference(typeRef);
		if (reference.isPrimitive()) {
			error("Primitives cannot be used as type arguments.", typeRef, null, INVALID_USE_OF_TYPE);
		}
		if (reference.isWildcard()) {
			error("Wildcard types are not allowed in this context", typeRef, null, INSIGNIFICANT_INDEX,
					INVALID_USE_OF_WILDCARD);
		}
	}

	protected LightweightTypeReference toLightweightTypeReference(JvmTypeReference typeRef) {
		return toLightweightTypeReference(typeRef, false);
	}
	
	protected LightweightTypeReference toLightweightTypeReference(JvmTypeReference typeRef, boolean keepUnboundWildcardInformation) {
		OwnedConverter converter = new OwnedConverter(new StandardTypeReferenceOwner(getServices(), typeRef), keepUnboundWildcardInformation);
		LightweightTypeReference reference = converter.toLightweightReference(typeRef);
		return reference;
	}
	
	@Check
	public void checkTypeReferenceIsNotVoid(XCasePart expression) {
		if (expression.getTypeGuard() != null) {
			if (toLightweightTypeReference(expression.getTypeGuard()).isPrimitiveVoid()) {
				error("Primitive void cannot be used here.", expression.getTypeGuard(), null, INVALID_USE_OF_TYPE);
			}
		}
	}
	
	@Check
	public void checkReturn(XReturnExpression expr) {
		IResolvedTypes resolvedTypes = typeResolver.resolveTypes(expr);
		LightweightTypeReference expectedReturnType = resolvedTypes.getExpectedReturnType(expr);
		if (expectedReturnType == null) {
			return;
		}
		if (expectedReturnType.isPrimitiveVoid()) {
			if (expr.getExpression() != null)
				error("Void functions cannot return a value.", expr, null,
						ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INVALID_RETURN);
		} else {
			if (expr.getExpression() == null)
				error("The function must return a result of type " + expectedReturnType.getHumanReadableName() + ".", expr, null,
						ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INVALID_RETURN);
			else {
				LightweightTypeReference expressionType = getActualType(expr.getExpression());
				if (expressionType.isPrimitiveVoid()) {
					error("Incompatible types. Expected " + getNameOfTypes(expectedReturnType) + " but was "
							+ canonicalName(expressionType), expr.getExpression(), null,
							ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INCOMPATIBLE_TYPES);
				}
			}

		}
	}

	protected boolean isImplicitReturn(XExpression expr) {
		JvmIdentifiableElement logicalContainer = logicalContainerProvider.getLogicalContainer(expr);
		return (logicalContainer instanceof JvmExecutable || logicalContainer instanceof JvmField || expr.eContainer() instanceof XClosure)
				&& !earlyExitComputer.isEarlyExit(expr);
	}

	protected String getNameOfTypes(LightweightTypeReference expectedType) {
		final StringBuilder result = new StringBuilder(canonicalName(expectedType));
		getServices().getSynonymTypesProvider().collectSynonymTypes(expectedType, new SynonymTypesProvider.Acceptor() {
			@Override
			protected boolean accept(LightweightTypeReference synonym, EnumSet<ConformanceHint> hints) {
				result.append(" or ").append(canonicalName(synonym));
				return true;
			}
		});
		return result.toString();
	}

	@Check
	public void checkTypes(XCatchClause catchClause) {
		LightweightTypeReference parameterType = getActualType(catchClause, catchClause.getDeclaredParam());
		if (parameterType != null && !parameterType.isSubtypeOf(Throwable.class)) {
			error("No exception of type " + parameterType.getHumanReadableName()
					+ " can be thrown; an exception type must be a subclass of Throwable",
					catchClause.getDeclaredParam(), TypesPackage.Literals.JVM_FORMAL_PARAMETER__PARAMETER_TYPE,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INCOMPATIBLE_TYPES);
		}
	}

	@Check 
	public void checkTypeParameterNotUsedInStaticContext(JvmTypeReference ref) {
		if(ref.getType() instanceof JvmTypeParameter) {
			JvmTypeParameter typeParameter = (JvmTypeParameter) ref.getType();
			EObject currentParent = logicalContainerProvider.getNearestLogicalContainer(ref);
			while(currentParent != null) {
				if(currentParent == typeParameter.eContainer())
					return;
				else if(isStaticContext(currentParent)) 
					error("Cannot make a static reference to the non-static type " + typeParameter.getName(), 
							ref, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, -1, STATIC_ACCESS_TO_INSTANCE_MEMBER);
				currentParent = currentParent.eContainer();
			}
		}
	}
		
	protected boolean isStaticContext(EObject element) {
		if(element instanceof JvmConstructor)
			return false;
		if(element instanceof JvmFeature)
			return ((JvmFeature) element).isStatic();
		if(element instanceof JvmDeclaredType)
			return ((JvmDeclaredType) element).isStatic() || (
					((JvmDeclaredType)element).getDeclaringType() == null && !isLocalType(element));
		return false;
	}
	
	protected boolean isLocalType(EObject element) {
		return element instanceof JvmGenericType && ((JvmGenericType)element).isLocal();
	}
	
	@Check
	public void checkTypeParameterConstraintIsValid(JvmTypeParameter typeParameter) {
		if(!typeParameter.getConstraints().isEmpty()) {
			for(JvmTypeConstraint constraint: typeParameter.getConstraints()) {
				JvmTypeReference typeReference = constraint.getTypeReference();
				if(typeReference instanceof JvmGenericArrayTypeReference)
					error(String.format("The array type %s cannot be used as a type parameter bound", typeReference.getSimpleName()),
							typeReference, null, INVALID_TYPE_PARAMETER_BOUNDS);
			}
		}
	}
	
	/**
	 * Java 5 does not allow forward references in type parameters, so we have to validate this, too
	 */
	public void doCheckTypeParameterForwardReference(List<JvmTypeParameter> sourceTypeParameters) {
		if (sourceTypeParameters.size() > 1) {
			final Set<JvmTypeParameter> forbidden = newHashSet(); 
			for (int i=sourceTypeParameters.size()-2; i>=0; --i) {
				JvmTypeParameter current = sourceTypeParameters.get(i);
				for (EObject jvmElement: associations.getJvmElements(sourceTypeParameters.get(i+1))) 
					if(jvmElement instanceof JvmTypeParameter)
						forbidden.add((JvmTypeParameter) jvmElement);
				for (JvmTypeConstraint constraint: current.getConstraints()) {
					EcoreUtil2.findCrossReferences(constraint.getTypeReference(), forbidden, new ElementReferenceAcceptor() {
						public void accept(EObject referrer, EObject referenced, EReference reference, int index) {
							error("Illegal forward reference to type parameter " + ((JvmTypeParameter)referenced).getSimpleName(), 
									referrer, reference, index, TYPE_PARAMETER_FORWARD_REFERENCE);
						}
					});
				}
			}
		}
		// No recursive generics
		for(final JvmTypeParameter parameter : sourceTypeParameters){
			final Set<JvmTypeParameter> forbidden = newHashSet();
			for (EObject jvmElement: associations.getJvmElements(parameter))
				if(jvmElement instanceof JvmTypeParameter)
					forbidden.add((JvmTypeParameter) jvmElement);
			for(JvmTypeConstraint constraint : parameter.getConstraints()){
				EcoreUtil2.findCrossReferences(constraint.getTypeReference(), forbidden, new ElementReferenceAcceptor() {
					public void accept(EObject referrer, EObject referenced, EReference reference, int index) {
						EObject container = referrer.eContainer();
						if(container instanceof JvmTypeConstraint && container.eContainer() instanceof JvmTypeParameter)
							error("Illegal forward reference to type parameter " + ((JvmTypeParameter)referenced).getSimpleName(),
									referrer, reference, index, TYPE_PARAMETER_FORWARD_REFERENCE);
					}
				});
			}
		}
	}
	
	@Check
	public void checkAssignment(XAssignment assignment) {
		checkAssignment(assignment, Literals.XASSIGNMENT__ASSIGNABLE, true);
	}

	/**
	 * can be called by subclasses to have proper final field initialization checks.
	 */
	protected void checkFinalFieldInitialization(JvmGenericType type) {
		final Set<JvmField> finalFields = Sets.newLinkedHashSet(Iterables.filter(type.getDeclaredFields(), new Predicate<JvmField>() {
			public boolean apply(JvmField input) {
				return input.isFinal();
			}
		}));
		if (finalFields.isEmpty())
			return;
		final Set<JvmField> initializedFields = Sets.newLinkedHashSet(Iterables.filter(finalFields, new Predicate<JvmField>() {
			public boolean apply(JvmField input) {
				return isInitialized(input);
			}

		}));
		for (JvmConstructor constr : type.getDeclaredConstructors()) {
			final Set<JvmField> localInitializedFields = Sets.newLinkedHashSet(initializedFields);
			XExpression expression = logicalContainerProvider.getAssociatedExpression(constr);
			if (expression != null) {
				checkInitializationRec(expression, finalFields, localInitializedFields, Sets.newLinkedHashSet(localInitializedFields), Sets.newHashSet(constr));
			}
			for (JvmField field : finalFields) {
				if (!localInitializedFields.contains(field) && !readAndWriteTracking.isInitialized(field)) {
					reportUninitializedField(field);
				}
			}
		}
		if (Iterables.isEmpty(type.getDeclaredConstructors())) {
			finalFields.removeAll(initializedFields);
			for (JvmField jvmField : finalFields) {
				if (!readAndWriteTracking.isInitialized(jvmField)) {
					reportUninitializedField(jvmField);
				}
			}
		}
	}
	
	protected boolean isInitialized(JvmField input) {
		return logicalContainerProvider.getAssociatedExpression(input) != null;
	}
	
	protected void reportUninitializedField(@SuppressWarnings("unused") JvmField field) {
	}

	protected void reportFieldAlreadyInitialized(XAssignment assignment, JvmField field) {
		error("The final field "+field.getSimpleName()+" may already have been assigned", assignment, null, FIELD_ALREADY_INITIALIZED );
	}
	
	
	protected void checkInitializationRec(EObject expr, Set<JvmField> fields, Set<JvmField> initializedForSure, Set<JvmField> initializedMaybe, Set<JvmConstructor> visited) {
		if (expr instanceof XAssignment) {
			XAssignment assignment = (XAssignment) expr;
			if (assignment.getAssignable() != null)
				checkInitializationRec(assignment.getAssignable(), fields, initializedForSure, initializedMaybe, visited);
			if (fields.contains(assignment.getFeature())) {
				JvmField field = (JvmField) assignment.getFeature();
				if (fields.contains(field) && (initializedForSure.contains(field) || initializedMaybe.contains(field))) {
					reportFieldAlreadyInitialized(assignment, field);
				}
				initializedForSure.add(field);
				initializedMaybe.add(field);
			}
		} else if (expr instanceof XForLoopExpression) {
			XForLoopExpression loopExpression = (XForLoopExpression) expr;
			checkInitializationRec(loopExpression.getForExpression(), fields, initializedForSure, initializedMaybe, visited);
			checkInitializationRec(loopExpression.getEachExpression(), fields, initializedMaybe, Sets.newLinkedHashSet(fields), visited);
		} else if (expr instanceof XBasicForLoopExpression) {
			XBasicForLoopExpression loopExpression = (XBasicForLoopExpression) expr;
			for (XExpression initExpression : loopExpression.getInitExpressions()) {
				checkInitializationRec(initExpression, fields, initializedForSure, initializedMaybe, visited);
			}
			XExpression expression = loopExpression.getExpression();
			if (expression != null) {
				checkInitializationRec(expression, fields, initializedForSure, Sets.newLinkedHashSet(fields), visited);
			}
			for (XExpression updateExpression : loopExpression.getUpdateExpressions()) {
				checkInitializationRec(updateExpression, fields, initializedMaybe, Sets.newLinkedHashSet(fields), visited);
			}
			checkInitializationRec(loopExpression.getEachExpression(), fields, initializedMaybe, Sets.newLinkedHashSet(fields), visited);
		} else if (expr instanceof XAbstractWhileExpression) {
			XAbstractWhileExpression loopExpression = (XAbstractWhileExpression) expr;
			checkInitializationRec(loopExpression.getPredicate(), fields, initializedForSure, Sets.newLinkedHashSet(fields), visited);
			checkInitializationRec(loopExpression.getBody(), fields, initializedMaybe, Sets.newLinkedHashSet(fields), visited);
		} else if (expr instanceof XTryCatchFinallyExpression) {
			XTryCatchFinallyExpression tryExpr = (XTryCatchFinallyExpression) expr;
			checkInitializationRec(tryExpr.getExpression(),fields,  initializedForSure, initializedMaybe, visited);
			checkInitializationRec(tryExpr.getFinallyExpression(), fields, initializedForSure, initializedMaybe, visited);
		} else if (expr instanceof XIfExpression) {
			XIfExpression ifExpr = (XIfExpression) expr;
			checkInitializationRec(ifExpr.getIf(), fields, initializedForSure, initializedMaybe, visited);
			
			Set<JvmField> initializedThenForSure = Sets.newLinkedHashSet(initializedForSure);
			Set<JvmField> initializedThenMaybe = Sets.newLinkedHashSet(initializedMaybe);
			checkInitializationRec(ifExpr.getThen(), fields, initializedThenForSure, initializedThenMaybe, visited);
			
			if (ifExpr.getElse() != null) {
				Set<JvmField> initializedElseForSure = Sets.newLinkedHashSet(initializedForSure);
				Set<JvmField> initializedElseMaybe = Sets.newLinkedHashSet(initializedMaybe);
				checkInitializationRec(ifExpr.getElse(), fields, initializedElseForSure, initializedElseMaybe, visited);
				
				initializedThenForSure.retainAll(initializedElseForSure);
				initializedForSure.addAll(initializedThenForSure);
				initializedMaybe.addAll(initializedThenMaybe);
				initializedMaybe.addAll(initializedElseMaybe);
			}
		} else if (expr instanceof XSwitchExpression) {
			XSwitchExpression switchExpr = (XSwitchExpression) expr;
			checkInitializationRec(switchExpr.getSwitch(), fields, initializedForSure, initializedMaybe, visited);
			Set<JvmField> initializedAllCasesForSure = null;
			Set<JvmField> initializedAllCasesMaybe = Sets.newLinkedHashSet(initializedMaybe);
			for (XCasePart casepart : switchExpr.getCases()) {
				if (casepart.getCase() != null) 
					checkInitializationRec(casepart.getCase(), fields, initializedForSure, initializedMaybe, visited);
				Set<JvmField> initializedInCaseForSure = Sets.newLinkedHashSet(initializedForSure);
				Set<JvmField> initializedInCaseMaybe = Sets.newLinkedHashSet(initializedMaybe);
				XExpression then = 	switchExpressions.getThen(casepart, switchExpr);
				checkInitializationRec(then, fields, initializedInCaseForSure, initializedInCaseMaybe, visited);
				if (initializedAllCasesForSure == null)
					initializedAllCasesForSure = initializedInCaseForSure;
				else {
					initializedAllCasesForSure.retainAll(initializedInCaseForSure);
				}
				initializedAllCasesMaybe.addAll(initializedInCaseMaybe);
			}
			if (switchExpr.getDefault() != null) {
				Set<JvmField> initializedInCaseForSure = Sets.newLinkedHashSet(initializedForSure);
				Set<JvmField> initializedInCaseMaybe = Sets.newLinkedHashSet(initializedMaybe);
				checkInitializationRec(switchExpr.getDefault(), fields, initializedInCaseForSure, initializedInCaseMaybe, visited);
				if (initializedAllCasesForSure == null)
					initializedAllCasesForSure = initializedInCaseForSure;
				else {
					initializedAllCasesForSure.retainAll(initializedInCaseForSure);
				}
				initializedAllCasesMaybe.addAll(initializedInCaseMaybe);
				
				initializedForSure.addAll(initializedAllCasesForSure);
			}
			initializedMaybe.addAll(initializedAllCasesMaybe);
		} else if (expr instanceof XFeatureCall) {
			XFeatureCall xFeatureCall = (XFeatureCall) expr;
			if (xFeatureCall.getFeature() instanceof JvmConstructor) {
				JvmConstructor constructor = (JvmConstructor) xFeatureCall.getFeature();
				if (constructor.getDeclaringType() == fields.iterator().next().getDeclaringType()) {
					XExpression expression = logicalContainerProvider.getAssociatedExpression(constructor);
					if (expression != null) {
						HashSet<JvmConstructor> visitedCopy = Sets.newHashSet(visited);
						if (visitedCopy.add(constructor)) {
							checkInitializationRec(expression, fields, initializedForSure, initializedMaybe, visitedCopy);
						} else {
							// recursive compiler invocation is checked elsewhere 
						}
					}
				}
			}
			for (EObject child : expr.eContents()) {
				checkInitializationRec(child, fields, initializedForSure, initializedMaybe, visited);
			}
		} else if (expr instanceof XClosure) {
			// don't go into closures.
			return;
		} else {
			for (EObject child : expr.eContents()) {
				checkInitializationRec(child, fields, initializedForSure, initializedMaybe, visited);
			}
		}
	}


	@Check
	public void checkVariableDeclaration(XVariableDeclaration declaration) {
		if (declaration.getRight() == null) {
			if (!declaration.isWriteable())
				error("Value must be initialized", Literals.XVARIABLE_DECLARATION__WRITEABLE,
						ValidationMessageAcceptor.INSIGNIFICANT_INDEX, MISSING_INITIALIZATION);
			if (declaration.getType() == null)
				error("Type cannot be derived", Literals.XVARIABLE_DECLARATION__NAME,
						ValidationMessageAcceptor.INSIGNIFICANT_INDEX, MISSING_TYPE);
		}
	}
	
	@Check
	public void checkInnerExpressions(XExpression expr) {
		if (!expressionHelper.hasSideEffects(expr) && !isValueExpectedRecursive(expr)) {
			mustBeJavaStatementExpression(expr);
		}
	}
	
	protected boolean isValueExpectedRecursive(XExpression expr) {
		EStructuralFeature feature = expr.eContainingFeature();
		EObject container = expr.eContainer();
		
		// is part of block
		if (container instanceof XBlockExpression) {
			XBlockExpression blockExpression = (XBlockExpression) container;
			final List<XExpression> expressions = blockExpression.getExpressions();
			if (expressions.get(expressions.size()-1) != expr) {
				return false;
			}
		}
		// no expectation cases
		if (feature == XbasePackage.Literals.XTRY_CATCH_FINALLY_EXPRESSION__FINALLY_EXPRESSION
			|| feature == XbasePackage.Literals.XABSTRACT_WHILE_EXPRESSION__BODY
			|| feature == XbasePackage.Literals.XFOR_LOOP_EXPRESSION__EACH_EXPRESSION) {
			return false;
		}
		// is value expected
		if (container instanceof XAbstractFeatureCall 
			|| container instanceof XConstructorCall
			|| container instanceof XAssignment
			|| container instanceof XVariableDeclaration
			|| container instanceof XReturnExpression
			|| container instanceof XThrowExpression
			|| feature == XbasePackage.Literals.XFOR_LOOP_EXPRESSION__FOR_EXPRESSION
			|| feature == XbasePackage.Literals.XSWITCH_EXPRESSION__SWITCH
			|| feature == XbasePackage.Literals.XCASE_PART__CASE
			|| feature == XbasePackage.Literals.XIF_EXPRESSION__IF
			|| feature == XbasePackage.Literals.XABSTRACT_WHILE_EXPRESSION__PREDICATE
			|| feature == XbasePackage.Literals.XBASIC_FOR_LOOP_EXPRESSION__EXPRESSION) {
			return true;
		}
		if (container instanceof XClosure || logicalContainerProvider.getLogicalContainer(expr) != null) {
			LightweightTypeReference expectedReturnType = typeResolver.resolveTypes(expr).getExpectedReturnType(expr);
			return expectedReturnType == null || !expectedReturnType.isPrimitiveVoid();
		}
		if (container instanceof XCasePart || container instanceof XCatchClause) {
			container = container.eContainer();
		}
		if (container instanceof XExpression) {
			return isValueExpectedRecursive((XExpression) container);
		}
		return true;
	}

	protected void mustBeJavaStatementExpression(XExpression expr) {
		if (expr != null) {
			error("This expression is not allowed in this context, since it doesn't cause any side effects.", expr, null,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INVALID_INNER_EXPRESSION);
		}
	}

	@Check
	public void checkCasts(XCastedExpression cast) {
		LightweightTypeReference toType = toLightweightTypeReference(cast.getType());
		LightweightTypeReference fromType = getActualType(cast.getTarget());
		checkCast(cast.getType(), toType, fromType);
	}

	@Check
	public void checkTypeGuards(XCasePart casePart) {
		if (casePart.getTypeGuard() == null)
			return;
		LightweightTypeReference typeGuard = toLightweightTypeReference(casePart.getTypeGuard());
		if (typeGuard.isPrimitive()) {
			error("Primitives are not allowed as type guards", Literals.XCASE_PART__TYPE_GUARD, INVALID_USE_OF_TYPE);
			return;
		}
		LightweightTypeReference targetTypeRef = getActualType(((XSwitchExpression) casePart.eContainer()).getSwitch());
		checkCast(casePart.getTypeGuard(), typeGuard, targetTypeRef);
	}

	@Check
	public void checkInstanceOf(XInstanceOfExpression instanceOfExpression) {
		LightweightTypeReference leftType = getActualType(instanceOfExpression.getExpression());
		final LightweightTypeReference rightType = toLightweightTypeReference(instanceOfExpression.getType(), true);
		if (leftType == null || rightType == null || rightType.getType() == null || rightType.getType().eIsProxy()) {
			return;
		}
		if (containsTypeArgs(rightType)) {
			error("Cannot perform instanceof check against parameterized type " + getNameOfTypes(rightType), null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INVALID_INSTANCEOF);
			return;
		}
		if (leftType.isAny() || leftType.isUnknown()) {
			return; // null / unknown is ok
		}
		if (rightType.isPrimitive()) {
			error("Cannot perform instanceof check against primitive type " + this.getNameOfTypes(rightType), null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INVALID_INSTANCEOF);
			return;
		}
		if (leftType.isPrimitive() 
			|| rightType.isArray() && !(leftType.isArray() || leftType.isType(Object.class) || leftType.isType(Cloneable.class) || leftType.isType(Serializable.class))
			|| isFinal(rightType) && !memberOfTypeHierarchy(rightType, leftType)
			|| isFinal(leftType) && !memberOfTypeHierarchy(leftType, rightType)) {
			error("Incompatible conditional operand types " + this.getNameOfTypes(leftType)+" and "+this.getNameOfTypes(rightType), null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INVALID_INSTANCEOF);
			return;
		}
		if (!isIgnored(OBSOLETE_INSTANCEOF) && rightType.isAssignableFrom(leftType, new TypeConformanceComputationArgument(false, false, true, true, false, false))) {
			addIssueToState(OBSOLETE_INSTANCEOF, "The expression of type " + getNameOfTypes(leftType)
					+ " is already of type " + canonicalName(rightType), null);
		}
	}

	protected boolean memberOfTypeHierarchy(LightweightTypeReference type, LightweightTypeReference potentialMember) {
		return potentialMember.isAssignableFrom(type, new TypeConformanceComputationArgument(false, false, false, true, false, false));
	}

	protected boolean containsTypeArgs(LightweightTypeReference instanceOfType) {
		return instanceOfType.accept(new TypeReferenceVisitorWithNonNullResult<Boolean>() {
			@Override
			protected Boolean doVisitTypeReference(LightweightTypeReference reference) {
				return Boolean.FALSE;
			}
			
			@Override
			protected Boolean doVisitParameterizedTypeReference(ParameterizedTypeReference reference) {
				for(LightweightTypeReference argument: reference.getTypeArguments()) {
					if (argument.isWildcard()) {
						if (!((WildcardTypeReference)argument).isUnbounded()) {
							return Boolean.TRUE;
						}
					} else {
						return Boolean.TRUE;
					}
				}
				return Boolean.FALSE;
			}
			@Override
			protected Boolean doVisitArrayTypeReference(ArrayTypeReference reference) {
				return reference.getComponentType().accept(this);
			}
		});
	}

	protected boolean isFinal(LightweightTypeReference expressionTypeRef) {
		if (expressionTypeRef.isArray()) {
			return isFinal(expressionTypeRef.getComponentType());
		}
		if (expressionTypeRef.isPrimitive())
			return true;
		return expressionTypeRef.getType() instanceof JvmDeclaredType
				&& ((JvmDeclaredType) expressionTypeRef.getType()).isFinal();
	}

	@Check
	public void checkDelegateConstructorIsFirst(XFeatureCall featureCall) {
		JvmIdentifiableElement feature = featureCall.getFeature();
		if (feature != null && !feature.eIsProxy() && feature instanceof JvmConstructor) {
			JvmIdentifiableElement container = logicalContainerProvider.getNearestLogicalContainer(featureCall);
			if (container != null) {
				if (container instanceof JvmConstructor) {
					XExpression body = logicalContainerProvider.getAssociatedExpression(container);
					if (body == featureCall)
						return;
					if (body instanceof XBlockExpression) {
						List<XExpression> expressions = ((XBlockExpression) body).getExpressions();
						if (expressions.isEmpty() || expressions.get(0) != featureCall) {
							error("Constructor call must be the first expression in a constructor", null, INVALID_CONSTRUCTOR_INVOCATION);
						}
					}
				} else {
					error("Constructor call must be the first expression in a constructor", null, INVALID_CONSTRUCTOR_INVOCATION);
				}
			}
		}
	}
	
	@Check
	public void checkConstructorArgumentsAreValid(XFeatureCall featureCall) {
		JvmIdentifiableElement feature = featureCall.getFeature();
		if (feature != null && !feature.eIsProxy() && feature instanceof JvmConstructor) {
			JvmType containerType = EcoreUtil2.getContainerOfType(logicalContainerProvider.getNearestLogicalContainer(featureCall), JvmType.class);
			for(XExpression argument: featureCall.getFeatureCallArguments()) {
				checkIsValidConstructorArgument(argument, containerType);
			}
		}
	}
	
	protected void checkIsValidConstructorArgument(XExpression argument, JvmType containerType) {
		TreeIterator<EObject> iterator = EcoreUtil2.eAll(argument);
		while(iterator.hasNext()) {
			EObject partOfArgumentExpression = iterator.next();
			if (partOfArgumentExpression instanceof XFeatureCall || partOfArgumentExpression instanceof XMemberFeatureCall) {				
				XAbstractFeatureCall featureCall = (XAbstractFeatureCall) partOfArgumentExpression;
				XExpression actualReceiver = featureCall.getActualReceiver();
				if(actualReceiver instanceof XFeatureCall && ((XFeatureCall)actualReceiver).getFeature() == containerType) {
					JvmIdentifiableElement feature = featureCall.getFeature();
					if (feature != null && !feature.eIsProxy()) {
						if (feature instanceof JvmField) {
							if (!((JvmField) feature).isStatic())
								error("Cannot refer to an instance field " + feature.getSimpleName() + " while explicitly invoking a constructor", 
										partOfArgumentExpression, null, INVALID_CONSTRUCTOR_ARGUMENT);
						} else if (feature instanceof JvmOperation) {
							if (!((JvmOperation) feature).isStatic())
								error("Cannot refer to an instance method while explicitly invoking a constructor", 
										partOfArgumentExpression, null, INVALID_CONSTRUCTOR_ARGUMENT);	
						}
					}
				}
			} else if(partOfArgumentExpression instanceof XClosure) {
				iterator.prune();
			}
		}
	}

	
	@Check
	public void checkNoCircularConstructorCall(XFeatureCall featureCall) {
		JvmIdentifiableElement feature = featureCall.getFeature();
		if (feature != null && !feature.eIsProxy() && feature instanceof JvmConstructor) {
			JvmIdentifiableElement logicalContainer = logicalContainerProvider.getNearestLogicalContainer(featureCall);
			if (logicalContainer instanceof JvmConstructor) {
				JvmConstructor currentConstructor = (JvmConstructor) logicalContainer;
				JvmConstructor calledConstructor = (JvmConstructor) feature;
				Set<JvmConstructor> visited = Sets.newHashSet(currentConstructor);
				while(calledConstructor.getDeclaringType() == currentConstructor.getDeclaringType()) {
					if (!visited.add(calledConstructor)) {
						error("Recursive constructor invocation", XABSTRACT_FEATURE_CALL__FEATURE, CIRCULAR_CONSTRUCTOR_INVOCATION);
						return;
					}
					XExpression constructorBody = logicalContainerProvider.getAssociatedExpression(calledConstructor);
					if (constructorBody instanceof XBlockExpression) {
						List<XExpression> expressions = ((XBlockExpression) constructorBody).getExpressions();
						if (expressions.isEmpty())
							return;
						XExpression firstInBody = ((XBlockExpression) constructorBody).getExpressions().get(0);
						if (firstInBody instanceof XFeatureCall) {
							JvmIdentifiableElement calledFeature = ((XFeatureCall) firstInBody).getFeature();
							if (calledFeature != null && !calledFeature.eIsProxy() && calledFeature instanceof JvmConstructor) {
								calledConstructor = (JvmConstructor) calledFeature;
								continue;
							} 
						} 
					} 
					return;
				}
			}
		}
	}

	@Check
	public void checkNoForwardReferences(XExpression fieldInitializer) {
		JvmIdentifiableElement container = logicalContainerProvider.getLogicalContainer(fieldInitializer);
		if (container instanceof JvmField) {
			JvmField field = (JvmField) container;
			boolean staticField = field.isStatic();
			JvmDeclaredType declaredType = field.getDeclaringType();
			Collection<JvmField> illegalFields = Sets.newHashSet();
			for(int i = declaredType.getMembers().size() - 1; i>=0; i--) {
				JvmMember member = declaredType.getMembers().get(i);
				if (member instanceof JvmField) {
					if (((JvmField) member).isStatic() == staticField) {
						illegalFields.add((JvmField) member);
					}
				}
				if (member == field)
					break;
			}
			TreeIterator<EObject> iterator = EcoreUtil2.eAll(fieldInitializer);
			while(iterator.hasNext()) {
				EObject object = iterator.next();
				if (object instanceof XFeatureCall) {
					JvmIdentifiableElement feature = ((XFeatureCall) object).getFeature();
					if (illegalFields.contains(((XFeatureCall) object).getFeature())) {
						error("Cannot reference the field '" + feature.getSimpleName() + "' before it is defined", 
								object, null, INSIGNIFICANT_INDEX, ILLEGAL_FORWARD_REFERENCE);
					}
				} else if (object instanceof XClosure) {
					iterator.prune();
				}
			}
		}
	}

	@Check
	public void checkClosureParams(XClosure closure) {
		if (closure.getFormalParameters().size() > 6) {
			error("The maximum number of parameters for a closure is six.", closure,
					Literals.XCLOSURE__DECLARED_FORMAL_PARAMETERS, 6, TOO_MANY_PARAMS_IN_CLOSURE);
		}
	}

	//TODO switch expression not of type boolean
	//TODO apply cast rules case's type guards
	//TODO null guard is not allowed with any other primitives but boolean (null -> false)

	@Check
	void checkNullSafeFeatureCallWithPrimitives(XMemberFeatureCall featureCall) {
		if (featureCall.isNullSafe() && getActualType(featureCall.getMemberCallTarget()).isPrimitive()) {
			error("Cannot use null-safe feature call on primitive receiver", featureCall,
					Literals.XMEMBER_FEATURE_CALL__NULL_SAFE, NULL_SAFE_FEATURE_CALL_ON_PRIMITIVE);
		}
		if (featureCall.isNullSafe() && getActualType(featureCall).isPrimitive()) {
			addIssue("Null-safe feature call of feature with primitive type", featureCall, 
					NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE);
		}
	}

	@Check
	public  void checkLocalUsageOfDeclared(XVariableDeclaration variableDeclaration) {
		if(!isIgnored(UNUSED_LOCAL_VARIABLE) && !isLocallyUsed(variableDeclaration, variableDeclaration.eContainer())){
			String message = "The value of the local variable " + variableDeclaration.getName() + " is not used";
			addIssueToState(UNUSED_LOCAL_VARIABLE, message, XbasePackage.Literals.XVARIABLE_DECLARATION__NAME);
		}
	}
	
	@Check
	public void checkTypeLiteral(XTypeLiteral typeLiteral) {
		if (!typeLiteral.getArrayDimensions().isEmpty() && typeLiteral.getType().getIdentifier().equals("void")) {
			error("'void"+Joiner.on("").join(typeLiteral.getArrayDimensions()) +"' is not a valid type", null, INVALID_TYPE);
		}
	}

	@Check
	public void checkImports(XImportSection importSection) {
		if (importSection.getImportDeclarations().isEmpty()) {
			return;
		}
		
		final Map<String, List<XImportDeclaration>> imports = Maps.newHashMap();
		final Map<String, List<XImportDeclaration>> staticImports = Maps.newHashMap();
		final Map<String, List<XImportDeclaration>> extensionImports = Maps.newHashMap();
		final Map<String, JvmType> importedNames = Maps.newHashMap();
		
		populateMaps(importSection, imports, staticImports, extensionImports, importedNames);
		checkConflicts(importSection, imports, importedNames);
		if (!isIgnored(IMPORT_UNUSED)) {
			XtextResource xtextResource = (XtextResource) importSection.eResource();
			
			ImportedTypesCollector importedTypesCollector = importedTypesCollectorProvider.get();
			TypeUsages typeUsages = importedTypesCollector.collectTypeUsages(xtextResource);
			for (JvmMember member : typeUsages.getStaticImports()) {
				if (typeUsages.getExtensionImports().contains(member)) {
					if (!removeStaticImport(extensionImports, member)) {
						removeStaticImport(staticImports, member);
					}
				} else {
					if (!removeStaticImport(staticImports, member)) {
						removeStaticImport(extensionImports, member);
					}
				}
			}
			for (JvmMember member : typeUsages.getExtensionImports()) {
				removeStaticImport(extensionImports, member);
			}
			for (JvmDeclaredType type : typeUsages.getSimpleName2Types().values()) {
				if (!removeTypeImport(imports, type)) {
					for (JvmType key : importedNames.values()) {
						if (isNestedTypeOf(key, type)) {
							removeTypeImport(imports, key);
						}
					}
				}
			}
			addImportUnusedIssues(imports);
			addImportUnusedIssues(staticImports);
			addImportUnusedIssues(extensionImports);
		}
	}

	private boolean isNestedTypeOf(JvmType child, JvmDeclaredType parent) {
		if (child instanceof JvmMember) {
			JvmMember member = (JvmMember) child;
			return member.getDeclaringType() == parent;
		}
		return false;
	}

	private boolean removeStaticImport(Map<String, List<XImportDeclaration>> staticImports, JvmMember member) {
		JvmDeclaredType declaringType = member.getDeclaringType();
		String identifier = declaringType.getIdentifier();
		
		List<XImportDeclaration> list = staticImports.get(identifier);
		if (list == null) {
			return false;
		}
		if (list.size() == 1) {
			staticImports.remove(identifier);
			return true;
		}
		int indexToRemove = -1;
		for (int i = 0; i < list.size(); i++) {
			XImportDeclaration staticImportDeclaration = list.get(i);
			if (staticImportDeclaration.isWildcard()) {
				if (indexToRemove == -1) {
					indexToRemove = i;
				}
				continue;
			}
			if (Objects.equal(member.getSimpleName(), staticImportDeclaration.getMemberName())) {
				indexToRemove = i;
				break;
			}
		}
		if (indexToRemove == -1) {
			indexToRemove = 0;
		}
		list.remove(indexToRemove);
		return true;
	}

	private boolean removeTypeImport(Map<String, List<XImportDeclaration>> imports, JvmType declaringType) {
		String identifier = declaringType.getIdentifier();
		List<XImportDeclaration> list = imports.get(identifier);
		if (list == null) {
			return false;
		}
		if (list.size() == 1) {
			imports.remove(identifier);
			return true;
		}
		list.remove(0);
		return true;
	}

	protected void addImportUnusedIssues(final Map<String, List<XImportDeclaration>> imports) {
		for (List<XImportDeclaration> importDeclarations : imports.values()) {
			for (XImportDeclaration importDeclaration : importDeclarations) {
				addIssue("The import '" + importDeclaration.getImportedName() + "' is never used.", importDeclaration, IMPORT_UNUSED);
			}	
		}
	}

	protected void checkConflicts(XImportSection importSection, final Map<String, List<XImportDeclaration>> imports,
			final Map<String, JvmType> importedNames) {
		for (JvmDeclaredType declaredType : importsConfiguration.getLocallyDefinedTypes((XtextResource)importSection.eResource())) {
			if(importedNames.containsKey(declaredType.getSimpleName())){
				JvmType importedType = importedNames.get(declaredType.getSimpleName());
				if (importedType != declaredType  && importedType.eResource() != importSection.eResource()) {
					List<XImportDeclaration> list = imports.get(importedType.getIdentifier());
					if (list != null) {
						for (XImportDeclaration importDeclaration: list ) {
							error("The import '" 
									+ importedType.getIdentifier() 
									+ "' conflicts with a type defined in the same file", 
									importDeclaration, null, IssueCodes.IMPORT_CONFLICT);
						}
					}
				}
			}
		}
	}

	protected void populateMaps(XImportSection importSection, final Map<String, List<XImportDeclaration>> imports,
			final Map<String, List<XImportDeclaration>> staticImports, final Map<String, List<XImportDeclaration>> extensionImports,
			final Map<String, JvmType> importedNames) {
		for (XImportDeclaration imp : importSection.getImportDeclarations()) {
			if (imp.getImportedNamespace() != null) { 
				addIssue("The use of wildcard imports is deprecated.", imp, IMPORT_WILDCARD_DEPRECATED);
				continue;
			}
			
			JvmType importedType = imp.getImportedType();
			if (importedType == null || importedType.eIsProxy()) {
				continue;
			}
			
			Map<String, List<XImportDeclaration>> map = imp.isStatic() ? (imp.isExtension() ? extensionImports : staticImports) : imports;
			List<XImportDeclaration> list = map.get(importedType.getIdentifier());
			if (list != null) {
				list.add(imp);
				continue;
			}
			list = Lists.newArrayListWithCapacity(2);
			list.add(imp);
			map.put(importedType.getIdentifier(), list);
			
			if (!imp.isStatic()) {
				JvmType currentType = importedType;
				String currentSuffix = currentType.getSimpleName();
				JvmType collidingImport = importedNames.put(currentSuffix, importedType);
				if(collidingImport != null)
					error("The import '" + importedType.getIdentifier() + "' collides with the import '" 
							+ collidingImport.getIdentifier() + "'.", imp, null, IssueCodes.IMPORT_COLLISION);
				while (currentType.eContainer() instanceof JvmType) {
					currentType = (JvmType) currentType.eContainer();
					currentSuffix = currentType.getSimpleName()+"$"+currentSuffix;
					JvmType collidingImport2 = importedNames.put(currentSuffix, importedType);
					if(collidingImport2 != null)
						error("The import '" + importedType.getIdentifier() + "' collides with the import '" 
								+ collidingImport2.getIdentifier() + "'.", imp, null, IssueCodes.IMPORT_COLLISION);
				}
			} else if (!imp.isWildcard()) {
				Iterable<JvmFeature> allFeatures = staticallyImportedMemberProvider.getAllFeatures(imp);
				if (!allFeatures.iterator().hasNext()) {
					addIssue("The import " + imp.getImportedName() + " cannot be resolved.", imp, IMPORT_UNRESOLVED);
					continue;
				}
			}
		}
	}
	
	@Check
	public void checkPrimitiveComparedToNull(XBinaryOperation binaryOperation) {
		String operatorSymbol = binaryOperation.getConcreteSyntaxFeatureName();
		XExpression left = binaryOperation.getLeftOperand();
		XExpression right = binaryOperation.getRightOperand();
		boolean equalsComparison = expressionHelper.isOperatorFromExtension(binaryOperation, OperatorMapping.EQUALS, ObjectExtensions.class)
				|| expressionHelper.isOperatorFromExtension(binaryOperation, OperatorMapping.NOT_EQUALS, ObjectExtensions.class);
		if(equalsComparison
				|| expressionHelper.isOperatorFromExtension(binaryOperation, OperatorMapping.TRIPLE_NOT_EQUALS, ObjectExtensions.class)
				|| expressionHelper.isOperatorFromExtension(binaryOperation, OperatorMapping.TRIPLE_EQUALS, ObjectExtensions.class)) {
			if(right instanceof XNullLiteral) {
				LightweightTypeReference leftType = typeResolver.resolveTypes(left).getActualType(left);
				if(leftType != null) {
					if (leftType.isPrimitive()) { 
						error("The operator '" + operatorSymbol + "' is undefined for the argument types " + leftType.getHumanReadableName() + " and null", binaryOperation, null, PRIMITIVE_COMPARED_TO_NULL);
					} else if (equalsComparison) {
						addIssue("The operator '" + operatorSymbol + "' should be replaced by '" + operatorSymbol + "=' when null is one of the arguments.", binaryOperation, EQUALS_WITH_NULL);
					}
				}
			}
			if(left instanceof XNullLiteral) {
				LightweightTypeReference rightType = typeResolver.resolveTypes(right).getActualType(right);
				if(rightType != null) {
					if (rightType.isPrimitive()) { 
						error("The operator '" + operatorSymbol + "' is undefined for the argument types null and " + rightType.getHumanReadableName(), binaryOperation, null, PRIMITIVE_COMPARED_TO_NULL);
					} else if (equalsComparison && !(right instanceof XNullLiteral)) {
						addIssue("The operator '" + operatorSymbol + "' should be replaced by '" + operatorSymbol + "=' when null is one of the arguments.", binaryOperation, EQUALS_WITH_NULL);
					}
				}
			}
		} else if(expressionHelper.isOperatorFromExtension(binaryOperation, OperatorMapping.ELVIS, ObjectExtensions.class)) {
			LightweightTypeReference leftType = getActualType(left);
			if(leftType.isPrimitive()) 
				error("The operator '" + operatorSymbol + "' is undefined for arguments of type " + leftType.getHumanReadableName(), binaryOperation, null, PRIMITIVE_COMPARED_TO_NULL);
		}
	}
		
	protected boolean isLocallyUsed(EObject target, EObject containerToFindUsage) {
		return readAndWriteTracking.isRead(target) || !XbaseUsageCrossReferencer.find(target, containerToFindUsage).isEmpty();
	}

	@Override
	protected List<EPackage> getEPackages() {
		return Lists.newArrayList(XbasePackage.eINSTANCE, XtypePackage.eINSTANCE, TypesPackage.eINSTANCE);
	}

	protected String canonicalName(LightweightTypeReference typeRef) {
		return (typeRef == null) ? "<null>" : typeRef.getHumanReadableName();
	}

	protected boolean isInterface(JvmType type) {
		return type instanceof JvmGenericType && ((JvmGenericType) type).isInterface();
	}
	
	protected XExpressionHelper getExpressionHelper() {
		return expressionHelper;
	}
	
	@Check
	public void checkNoJavaStyleTypeCasting(XBlockExpression blockExpression) {
		if(isIgnored(JAVA_STYLE_TYPE_CAST)) {
			return;
		}
		if (blockExpression.getExpressions().size() <= 1) {
			return;
		}
		ICompositeNode node = NodeModelUtils.getNode(blockExpression);
		if (node == null) {
			return;
		}
		INode expressionNode = null;
		for (INode child : node.getChildren()) {
			if (isSemicolon(child)) {
				expressionNode = null;
			} else if (isXExpressionInsideBlock(child)) {
				if (expressionNode != null) {
					checkNoJavaStyleTypeCasting(expressionNode);
				}
				expressionNode = child;
			}
		}
	}

	protected boolean isXExpressionInsideBlock(INode child) {
		return child.getGrammarElement() == grammarAccess.getXBlockExpressionAccess().getExpressionsXExpressionOrVarDeclarationParserRuleCall_2_0_0()
				|| child.getGrammarElement() == grammarAccess.getXExpressionInClosureAccess().getExpressionsXExpressionOrVarDeclarationParserRuleCall_1_0_0();
	}

	protected boolean isSemicolon(INode child) {
		return child.getGrammarElement() == grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1()
				|| child.getGrammarElement() == grammarAccess.getXExpressionInClosureAccess().getSemicolonKeyword_1_1();
	}

	protected void checkNoJavaStyleTypeCasting(INode node) {
		BidiTreeIterator<INode> iterator = node.getAsTreeIterable().reverse().iterator();
		ILeafNode child = getFirstLeafNode(iterator);
		if (child != null && child.getGrammarElement() == grammarAccess.getXParenthesizedExpressionAccess().getRightParenthesisKeyword_2()) {
			INode expressionNode = getNode(iterator, grammarAccess.getXParenthesizedExpressionAccess().getXExpressionParserRuleCall_1());
			EObject semanticObject = NodeModelUtils.findActualSemanticObjectFor(expressionNode);
			if (semanticObject instanceof XFeatureCall || semanticObject instanceof XMemberFeatureCall) {
				XAbstractFeatureCall featureCall = (XAbstractFeatureCall) semanticObject;
				if (featureCall.isTypeLiteral()) {
					ICompositeNode parenthesizedNode = child.getParent();
					ITextRegion parenthesizedRegion = parenthesizedNode.getTextRegion();
					addIssue("Use 'as' keyword for type casting.", featureCall, parenthesizedRegion.getOffset(), parenthesizedRegion.getLength(), JAVA_STYLE_TYPE_CAST);
				}
			}
		}
	}

	protected INode getNode(BidiTreeIterator<INode> iterator, EObject... grammarElements) {
		while (iterator.hasNext()) {
			INode node = iterator.next();
			EObject grammarElement = node.getGrammarElement();
			for (EObject expectedGrammarElement : grammarElements) {
				if (grammarElement == expectedGrammarElement) {
					return node;
				}
			}
		}
		return null;
	}

	protected ILeafNode getFirstLeafNode(BidiTreeIterator<INode> iterator) {
		while(iterator.hasNext()) {
			INode child = iterator.next();
			if (isHidden(child)) {
				continue;
			}
			if (child instanceof ILeafNode) {
				return (ILeafNode) child;
			}
		}
		return null;
	}

	protected boolean isHidden(INode child) {
		return child instanceof ILeafNode && ((ILeafNode) child).isHidden();
	}
	
	@Check
	public void checkDuplicatedCases(XSwitchExpression switchExpression) {
		LightweightTypeReference switchType = typeResolver.resolveTypes(switchExpression).getActualType(switchExpression.getSwitch());
		if (switchType == null || switchType.isType(Boolean.TYPE)) {
			return;
		}
		Map<String, Multimap<Object, XCasePart>> typeGuards = Maps.newHashMap();
		for (XCasePart casePart : switchExpression.getCases()) {
			XExpression caseExpression = casePart.getCase();
			if (caseExpression == null) {
				continue;
			}
			String typeGuardName = switchType.getType().getQualifiedName();
			JvmTypeReference typeGuard = casePart.getTypeGuard();
			if (typeGuard != null) {
				typeGuardName = typeGuard.getQualifiedName();
			}
			try {
				Object result = switchConstantExpressionsInterpreter.evaluate(caseExpression);
				if (result instanceof JvmTypeReference) {
					JvmTypeReference jvmTypeReference = (JvmTypeReference) result;
					result = jvmTypeReference.getType();
				}
				Multimap<Object, XCasePart> duplicatedCases = typeGuards.get(typeGuardName);
				if (duplicatedCases == null) {
					duplicatedCases = HashMultimap.create();
					typeGuards.put(typeGuardName, duplicatedCases);
				}
				duplicatedCases.put(result, casePart);
			} catch (ConstantExpressionEvaluationException e) {
				// do nothing
			}
		}
		for (Multimap<Object, XCasePart> duplicatedCases : typeGuards.values()) {
			for (Object result : duplicatedCases.keySet()) {
				Collection<XCasePart> cases = duplicatedCases.get(result);
				if (cases.size() > 1) {
					for (XCasePart casePart : cases) {
						error("Duplicate case", casePart.getCase(), null, IssueCodes.DUPLICATE_CASE);
					}
				}
			}
		}
	}
	
	@Check
	public void checkTypeGuardsOrder(XSwitchExpression expression) {
		if (isIgnored(IssueCodes.UNREACHABLE_CASE)) {
			return;
		}
		OwnedConverter converter = new OwnedConverter(new StandardTypeReferenceOwner(getServices(), expression));
		List<LightweightTypeReference> previousTypeReferences = new ArrayList<LightweightTypeReference>();
		for (XCasePart casePart : expression.getCases()) {
			JvmTypeReference typeGuard = casePart.getTypeGuard();
			if (typeGuard == null) {
				continue;
			}
			LightweightTypeReference actualType = converter.toLightweightReference(typeGuard);
			if (actualType == null) {
				continue;
			}
			if (isHandled(actualType, previousTypeReferences)) {
				addIssue("Unreachable code: The case can never match. It is already handled by a previous condition.", typeGuard, IssueCodes.UNREACHABLE_CASE);
				continue;
			}
			if (casePart.getCase() == null) {
				previousTypeReferences.add(actualType);
			}
		}
	}
	
	@Check
	public void checkInstanceOfOrder(XIfExpression expression) {
		if (isIgnored(IssueCodes.UNREACHABLE_IF_BLOCK)) {
			return;
		}
		if (expression.eContainer() instanceof XIfExpression) {
			XIfExpression container = (XIfExpression) expression.eContainer();
			if (container.getElse() == expression) {
				return;
			}
		}
		List<XExpression> ifParts = collectIfParts(expression, new ArrayList<XExpression>());
		OwnedConverter converter = new OwnedConverter(new StandardTypeReferenceOwner(getServices(), expression));
		Multimap<JvmIdentifiableElement, LightweightTypeReference> previousTypeReferences = HashMultimap.create();
		for (XExpression ifPart : ifParts) {
			if (!(ifPart instanceof XInstanceOfExpression)) {
				continue;
			}
			XInstanceOfExpression instanceOfExpression = (XInstanceOfExpression) ifPart;
			if (!(instanceOfExpression.getExpression() instanceof XAbstractFeatureCall)) {
				continue;
			}
			XAbstractFeatureCall featureCall = (XAbstractFeatureCall) instanceOfExpression.getExpression();
			JvmIdentifiableElement feature = featureCall.getFeature();
			if (!(feature instanceof XVariableDeclaration)
					&& !(feature instanceof JvmField)
					&& !(feature instanceof JvmFormalParameter)) {
				continue;
			}
			JvmTypeReference type = instanceOfExpression.getType();
			LightweightTypeReference actualType = converter.toLightweightReference(type);
			if (actualType == null) {
				continue;
			}
			if (isHandled(actualType, previousTypeReferences.get(feature))) {
				addIssue("Unreachable code: The if condition can never match. It is already handled by a previous condition.", type, IssueCodes.UNREACHABLE_IF_BLOCK);
				continue;
			}
			previousTypeReferences.put(feature, actualType);
		}
	}
	
	private List<XExpression> collectIfParts(XIfExpression expression, List<XExpression> result) {
		result.add(expression.getIf());
		if (expression.getElse() instanceof XIfExpression) {
			collectIfParts((XIfExpression) expression.getElse(), result);
		}
		return result;
	}

	@Check
	public void checkCatchClausesOrder(XTryCatchFinallyExpression expression) {
		OwnedConverter converter = new OwnedConverter(new StandardTypeReferenceOwner(getServices(), expression));
		List<LightweightTypeReference> previousTypeReferences = new ArrayList<LightweightTypeReference>();
		for (XCatchClause catchClause : expression.getCatchClauses()) {
			LightweightTypeReference actualTypeReference = converter.toLightweightReference(catchClause.getDeclaredParam().getParameterType());
			if (actualTypeReference == null) {
				continue;
			}
			if (isHandled(actualTypeReference, previousTypeReferences)) {
				error("Unreachable code: The catch block can never match. It is already handled by a previous condition.", catchClause.getDeclaredParam().getParameterType(), null, IssueCodes.UNREACHABLE_CATCH_BLOCK);
				continue;
			}
			previousTypeReferences.add(actualTypeReference);
		}
	}

	protected boolean isHandled(LightweightTypeReference actualTypeReference, Collection<LightweightTypeReference> collection) {
		return typesOrderUtil.isHandled(actualTypeReference, collection);
	}
	
	@Check
	public void checkIncompleteCasesOnEnum(XSwitchExpression switchExpression) {
		if (isIgnored(IssueCodes.INCOMPLETE_CASES_ON_ENUM)) {
			return;
		}
		if (switchExpression.getDefault() != null) {
			return;
		}
		LightweightTypeReference switchType = switchExpressions.getSwitchVariableType(switchExpression);
		if (switchType == null) {
			return;
		}
		if (!switchType.isSubtypeOf(Enum.class)) {
			return;
		}
		JvmEnumerationType enumerationType = (JvmEnumerationType) switchType.getType();
		List<String> expectedEnumerationLiterals = toList(map(enumerationType.getLiterals(), new Functions.Function1<JvmEnumerationLiteral, String>() {

			public String apply(JvmEnumerationLiteral enumerationLiteral) {
				return enumerationLiteral.getSimpleName();
			}
			
		}));
		for (XCasePart casePart : switchExpression.getCases()) {
			if (!switchExpressions.isJavaCaseExpression(switchExpression, casePart)) {
				return;
			}
			try {
				Object result = switchConstantExpressionsInterpreter.evaluate(casePart.getCase());
				if (!(result instanceof JvmEnumerationLiteral)) {
					return;
				}
				JvmEnumerationLiteral enumerationLiteral = (JvmEnumerationLiteral) result;
				expectedEnumerationLiterals.remove(enumerationLiteral.getSimpleName());
			} catch (ConstantExpressionEvaluationException e) {
				// do nothing
			}
		}
		if (expectedEnumerationLiterals.isEmpty()) {
			return;
		}
		StringBuilder builder = new StringBuilder();
		for (String expectedEnumerationLiteral : expectedEnumerationLiterals) {
			if (builder.length() != 0) {
				builder.append(", ");
			}
			builder.append(expectedEnumerationLiteral);
		}
		builder.insert(0, "The enum constants ");
		builder.append(" need a corresponding case labels in this enum switch on ").append(enumerationType.getQualifiedName());
		String message = builder.toString();
		addIssue(message, switchExpression.getSwitch(), null, IssueCodes.INCOMPLETE_CASES_ON_ENUM, expectedEnumerationLiterals.toArray(new String[0]));
	}
	
	@Check
	public void checkAssignment(XBinaryOperation binaryOperation) {
		if (binaryOperation.isReassignFirstArgument()) {
			XExpression leftOperand = binaryOperation.getLeftOperand();
			checkAssignment(leftOperand, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, false);	
		}
	}
	
	@Check
	public void checkOperandTypesForTripleEquals(XBinaryOperation binaryOperation) {
		if(isTripleEqualsOperation(binaryOperation)){
			LightweightTypeReference left = getActualType(binaryOperation.getLeftOperand());
			LightweightTypeReference right = getActualType(binaryOperation.getRightOperand());
			if((left.isArray() && !right.isArray()) || (!left.isArray() && right.isArray()))
				error("Incompatible operand types " + left.getHumanReadableName() + " and " + right.getHumanReadableName(), null, INVALID_OPERAND_TYPES);
		}
	}
	
	protected boolean isTripleEqualsOperation(XBinaryOperation binaryOperation){
		String syntax = binaryOperation.getConcreteSyntaxFeatureName();
		return syntax.equals(OperatorMapping.TRIPLE_EQUALS.toString()) || syntax.equals(OperatorMapping.TRIPLE_NOT_EQUALS.toString());
	}
	
	@Check
	public void checkAssignment(XPostfixOperation postfixOperation) {
		if (expressionHelper.isGetAndAssign(postfixOperation)) {
			XExpression firstArgument = postfixOperation.getActualArguments().get(0);
			checkAssignment(firstArgument, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, false);
		}
	}
	
	@Check
	public void checkExplicitOperationCall(XFeatureCall featureCall) {
		if (featureCall.getFeature() instanceof JvmOperation 
				&& !featureCall.isExplicitOperationCallOrBuilderSyntax()
				&& featureCall.getFeature().getSimpleName().equals(featureCall.getConcreteSyntaxFeatureName())) {
			addIssue("Method call without parentheses", featureCall, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, OPERATION_WITHOUT_PARENTHESES);
		}
	}
	
	@Check
	public void checkExplicitOperationCall(XMemberFeatureCall featureCall) {
		if (featureCall.getFeature() instanceof JvmOperation 
				&& !featureCall.isExplicitOperationCallOrBuilderSyntax()
				&& featureCall.getFeature().getSimpleName().equals(featureCall.getConcreteSyntaxFeatureName())) {
			addIssue("Method call without parentheses", featureCall, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, OPERATION_WITHOUT_PARENTHESES);
		}
	}
	
	@Check
	public void checkExplicitOperationCall(XConstructorCall constructorCall) {
		if (!constructorCall.isExplicitConstructorCall() 
				&& constructorCall.getArguments().isEmpty()) {
			addIssue("Constructor call without parentheses", constructorCall, OPERATION_WITHOUT_PARENTHESES);
		}
	}
	
	protected void checkAssignment(XExpression expression, EStructuralFeature feature, boolean simpleAssignment) {
		if (!(expression instanceof XAbstractFeatureCall)) {
			error("The left-hand side of an assignment must be a variable", expression, null,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX, ASSIGNMENT_TO_NO_VARIABLE);
			return;
		}
		XAbstractFeatureCall assignment = (XAbstractFeatureCall) expression;
		JvmIdentifiableElement assignmentFeature = assignment.getFeature();
		if (assignmentFeature instanceof XVariableDeclaration) {
			XVariableDeclaration variableDeclaration = (XVariableDeclaration) assignmentFeature;
			if (variableDeclaration.isWriteable()) {
				return;
			}
			error("Assignment to final variable", expression, feature,
				ValidationMessageAcceptor.INSIGNIFICANT_INDEX, ASSIGNMENT_TO_FINAL);
		} else if (assignmentFeature instanceof JvmFormalParameter) {
			error("Assignment to final parameter", expression, feature,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX, ASSIGNMENT_TO_FINAL);
		} else if (assignmentFeature instanceof JvmField) {
			JvmField field = (JvmField) assignmentFeature;
			if (!field.isFinal()) {
				return;
			}
			if (simpleAssignment) {
				JvmIdentifiableElement container = logicalContainerProvider.getNearestLogicalContainer(assignment);
				
				// don't issue an error if it's an assignment of a local final field within a constructor.
				if (container != null && container instanceof JvmConstructor) {
					JvmConstructor constructor = (JvmConstructor) container;
					if (field.getDeclaringType() == constructor.getDeclaringType())
						return;
				}
			}
			error("Assignment to final field", expression, feature,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX, ASSIGNMENT_TO_FINAL);
		} else if (!simpleAssignment) {
			error("The left-hand side of an assignment must be a variable", expression, null,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX, ASSIGNMENT_TO_NO_VARIABLE);
		}
	}
}
