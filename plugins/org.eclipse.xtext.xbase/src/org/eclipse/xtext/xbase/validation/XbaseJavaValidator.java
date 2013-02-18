/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;
import static org.eclipse.xtext.xbase.XbasePackage.*;
import static org.eclipse.xtext.xbase.validation.IssueCodes.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.TerminalRule;
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
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.documentation.IJavaDocTypeReferenceProvider;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ComposedChecks;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAbstractWhileExpression;
import org.eclipse.xtext.xbase.XAssignment;
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
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.XbasePackage.Literals;
import org.eclipse.xtext.xbase.controlflow.IEarlyExitComputer;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.lib.Procedures;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.computation.NumberLiterals;
import org.eclipse.xtext.xbase.typesystem.computation.SynonymTypesProvider;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceComputationArgument;
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceResult;
import org.eclipse.xtext.xbase.typesystem.legacy.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceVisitorWithNonNullResult;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typing.JvmExceptions;
import org.eclipse.xtext.xbase.util.XExpressionHelper;
import org.eclipse.xtext.xbase.util.XbaseUsageCrossReferencer;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;
import org.eclipse.xtext.xtype.XtypePackage;

import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * Xbase Validator that does use the scope provider or the type argument context. 
 * It basically disables or replaces all call-outs to the scope and some
 * validations that will be superseded by immediate error annotations during type resolution.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ComposedChecks(validators = { FeatureCallValidator.class, EarlyExitValidator.class })
public class XbaseJavaValidator extends AbstractXbaseJavaValidator {

	@Inject
	private XExpressionHelper expressionHelper;

	@Inject
	private IEarlyExitComputer earlyExitComputer;

	@Inject
	private ILogicalContainerProvider logicalContainerProvider;
	
	@Inject
	private JvmExceptions jvmExceptions;
	
	@Inject
	private NumberLiterals numberLiterals;
	
	@Inject
	private IJvmModelAssociations associations;
	
	@Inject
	private CommonTypeComputationServices services;
	
	@Inject
	private IBatchTypeResolver typeResolver;
	
	@Inject
	private IJavaDocTypeReferenceProvider javaDocTypeReferenceProvider;
	
	private final Set<EReference> typeConformanceCheckedReferences;
	
	{
		ImmutableSet.Builder<EReference> builder = ImmutableSet.builder();
		initTypeConformanceCheckedReferences(builder);
		typeConformanceCheckedReferences = builder.build();
		for(EReference reference: typeConformanceCheckedReferences) {
			if (!XbasePackage.Literals.XEXPRESSION.isSuperTypeOf(reference.getEReferenceType())) {
				throw new IllegalStateException("not a subtype of XExpression: " + reference);
			}
		}
	}

	protected void initTypeConformanceCheckedReferences(ImmutableSet.Builder<EReference> acceptor) {
		acceptor.add(
			XbasePackage.Literals.XVARIABLE_DECLARATION__RIGHT, 
			XbasePackage.Literals.XIF_EXPRESSION__IF,
			XbasePackage.Literals.XIF_EXPRESSION__THEN,
			XbasePackage.Literals.XIF_EXPRESSION__ELSE,
			XbasePackage.Literals.XTHROW_EXPRESSION__EXPRESSION, 
			XbasePackage.Literals.XRETURN_EXPRESSION__EXPRESSION,
			XbasePackage.Literals.XSWITCH_EXPRESSION__SWITCH, 
			XbasePackage.Literals.XCASE_PART__CASE,
			XbasePackage.Literals.XASSIGNMENT__ASSIGNABLE,
			XbasePackage.Literals.XASSIGNMENT__VALUE,
			XbasePackage.Literals.XABSTRACT_WHILE_EXPRESSION__PREDICATE,
			XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS,
			XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET,
			// those are not part of eContents in EMF < 2.9 thus we validate them explicitly.
//			XbasePackage.Literals.XABSTRACT_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT,
//			XbasePackage.Literals.XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER,
			XbasePackage.Literals.XCONSTRUCTOR_CALL__ARGUMENTS,
			XbasePackage.Literals.XFEATURE_CALL__FEATURE_CALL_ARGUMENTS,
			//TODO these references might point to the receiver, which is the basis of why a certain feature was picked in scoping.
			// Should be checked in case of extension methods only (i.e. when they are arguments)
			XbasePackage.Literals.XBINARY_OPERATION__LEFT_OPERAND,
			XbasePackage.Literals.XBINARY_OPERATION__RIGHT_OPERAND,
			XbasePackage.Literals.XUNARY_OPERATION__OPERAND,
			XbasePackage.Literals.XFOR_LOOP_EXPRESSION__FOR_EXPRESSION,
			XbasePackage.Literals.XCOLLECTION_LITERAL__ELEMENTS);
	}
	
	protected final Set<EReference> getTypeConformanceCheckedReferences() {
		return typeConformanceCheckedReferences;
	}
	
	protected CommonTypeComputationServices getServices() {
		return services;
	}
	
	protected void doValidateType(XExpression expression, Procedures.Procedure2<LightweightTypeReference, LightweightTypeReference> messageProducer) {
		LightweightTypeReference expectedType = getExpectedType(expression);
		if (expectedType == null) {
			if (!typeResolver.resolveTypes(expression).isVoidTypeAllowed(expression)) {
				LightweightTypeReference actualType = getActualType(expression);
				if (actualType == null)
					return;
				if (actualType.isPrimitiveVoid() && !isDefiniteEarlyExit(expression)) {
					messageProducer.apply(null, actualType);
				}
			}
			return;
		}
		LightweightTypeReference actualType = getActualType(expression);
		if (actualType == null)
			return;
		if (actualType.isPrimitiveVoid() && isDefiniteEarlyExit(expression)) {
			return;
		}
		if (isRawConformanceAllowed(expression)) {
			boolean valid = expectedType.isAssignableFrom(actualType);
			if (!valid) {
				messageProducer.apply(expectedType, actualType);
			}
		} else {
			TypeConformanceResult assignability = expectedType.internalIsAssignableFrom(actualType, new TypeConformanceComputationArgument());
			if (!assignability.isConformant() || assignability.getConformanceHints().contains(ConformanceHint.RAWTYPE_CONVERSION)) {
				messageProducer.apply(expectedType, actualType);
			}
		}
	}
	
	protected boolean isDefiniteEarlyExit(XExpression expression) {
		if (expression == null) {
			return true;
		}
		if (expression instanceof XBlockExpression) {
			XBlockExpression block = (XBlockExpression) expression;
			List<XExpression> children = block.getExpressions();
			for(XExpression child: children) {
				if (isDefiniteEarlyExit(child)) {
					return true;
				}
			}
		} else if (expression instanceof XIfExpression) {
			return isDefiniteEarlyExit(((XIfExpression) expression).getThen()) && isDefiniteEarlyExit(((XIfExpression) expression).getElse());
		}
		return expression instanceof XReturnExpression || expression instanceof XThrowExpression;
	}
	
	protected boolean isRawConformanceAllowed(XExpression expression) {
		if (expression.eContainingFeature() == XbasePackage.Literals.XFOR_LOOP_EXPRESSION__FOR_EXPRESSION) {
			return false;
		}
		return true;
	}
	
	protected LightweightTypeReference getActualType(EObject context, JvmIdentifiableElement element) {
		return typeResolver.resolveTypes(context).getActualType(element);
	}

	protected LightweightTypeReference getActualType(XExpression expression) {
		return typeResolver.resolveTypes(expression).getActualType(expression);
	}

	protected LightweightTypeReference getExpectedType(XExpression expression) {
		return typeResolver.resolveTypes(expression).getExpectedType(expression);
	}
	
	protected void checkCast(JvmTypeReference concreteSyntax, LightweightTypeReference toType, LightweightTypeReference fromType) {
		if (toType == null || fromType == null)
			return;
		if (fromType.getType() instanceof JvmDeclaredType) {
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
		}
		/*
		 * TODO: JDT reports no unncessary cast of List<?> but for List<String> ... why is there an exception?
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
			addIssue(concreteSyntax, IssueCodes.OBSOLETE_CAST, "Unnecessary cast from " + fromType.getSimpleName() + " to " + toType.getSimpleName());
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
	public void checkTypes(final XExpression obj) {
		final EStructuralFeature containingReference = obj.eContainingFeature();
		if (!getTypeConformanceCheckedReferences().contains(containingReference)) {
			return;
		}
		doCheckTypes(obj, containingReference);
	}
	
	@Check
	public void checkImplicitTypes(final XAbstractFeatureCall obj) {
		EStructuralFeature containingFeature = obj.eContainingFeature();
		if (containingFeature == XbasePackage.Literals.XABSTRACT_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT
				|| containingFeature == XbasePackage.Literals.XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER)
			return;
		doCheckTypes(obj.getImplicitFirstArgument(), XbasePackage.Literals.XABSTRACT_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT);
		doCheckTypes(obj.getImplicitReceiver(), XbasePackage.Literals.XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER);
	}

	protected void doCheckTypes(final XExpression obj, final EStructuralFeature containingReference) {
		if (obj == null)
			return;
		doValidateType(obj, new Procedures.Procedure2<LightweightTypeReference, LightweightTypeReference>() {
			public void apply(LightweightTypeReference expectedType, LightweightTypeReference actualType) {
				String firstPart = "Incompatible types.";
				XExpression errorModel = obj;
				if (containingReference == XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET) {
					firstPart = "Incompatible receiver type.";
					errorModel = (XExpression) errorModel.eContainer();
				} else if (containingReference == XbasePackage.Literals.XABSTRACT_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT) {
					firstPart = "Incompatible implicit first argument.";
				}
				if (expectedType != null) {
					error(firstPart + " Expected " + getNameOfTypes(expectedType) + " but was "
							+ canonicalName(actualType), errorModel, null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
							INCOMPATIBLE_TYPES);
				} else {
					error(firstPart + " Unexpected type primitive void.", errorModel, null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
							INCOMPATIBLE_TYPES);
				}
			}
		});
	}



	@Check
	public void checkImplicitReturn(XExpression expr) {
		if (!isImplicitReturn(expr))
			return;
		LightweightTypeReference expectedType = getExpectedType(expr);
		// TODO what's this special case here?
		if (expectedType == null || expectedType.isPrimitiveVoid())
			return;
		LightweightTypeReference type = typeResolver.resolveTypes(expr).getReturnType(expr);
		if (type == null)
			return;
		if (!expectedType.isAssignableFrom(type)) {
			error("Incompatible implicit return type. Expected " + getNameOfTypes(expectedType) + " but was "
					+ canonicalName(type), expr, null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
					INCOMPATIBLE_RETURN_TYPE);
		}
	}

	@Check
	public void checkReturn(XReturnExpression expr) {
		LightweightTypeReference expectedReturnType = typeResolver.resolveTypes(expr).getExpectedReturnType(expr);
		if (expectedReturnType == null) {
			return;
		}
		if (expectedReturnType.isPrimitiveVoid()) {
			if (expr.getExpression() != null)
				error("Void functions cannot return a value.", expr, null,
						ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INVALID_RETURN);
		} else {
			if (expr.getExpression() == null)
				error("The function must return a result of type " + expectedReturnType.getSimpleName() + ".", expr, null,
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
			@NonNullByDefault
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
			error("No exception of type " + parameterType.getSimpleName()
					+ " can be thrown; an exception type must be a subclass of Throwable",
					catchClause.getDeclaredParam(), TypesPackage.Literals.JVM_FORMAL_PARAMETER__PARAMETER_TYPE,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INCOMPATIBLE_TYPES);
		}
	}

	@Check
	public void checkAssignment(XAssignment assignment) {
		JvmIdentifiableElement assignmentFeature = assignment.getFeature();
		if (assignmentFeature instanceof XVariableDeclaration
				&& !((XVariableDeclaration) assignmentFeature).isWriteable())
			error("Assignment to final variable", Literals.XASSIGNMENT__ASSIGNABLE,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX, ASSIGNMENT_TO_FINAL);
		else if (assignmentFeature instanceof JvmFormalParameter)
			error("Assignment to final parameter", Literals.XASSIGNMENT__ASSIGNABLE,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX, ASSIGNMENT_TO_FINAL);
		else if (assignmentFeature instanceof JvmField && ((JvmField) assignmentFeature).isFinal()) {
			JvmField field = (JvmField) assignmentFeature;
			JvmIdentifiableElement container = logicalContainerProvider.getNearestLogicalContainer(assignment);
			
			// don't issue an error if it's an assignment of a local final field within a constructor.
			if (container != null && container instanceof JvmConstructor) {
				JvmConstructor constructor = (JvmConstructor) container;
				if (field.getDeclaringType() == constructor.getDeclaringType())
					return;
			}
			error("Assignment to final field", Literals.XASSIGNMENT__ASSIGNABLE,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX, ASSIGNMENT_TO_FINAL);
		}
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
				if (!localInitializedFields.contains(field)) {
					reportUninitializedField(field);
				}
			}
		}
		if (Iterables.isEmpty(type.getDeclaredConstructors())) {
			finalFields.removeAll(initializedFields);
			for (JvmField jvmField : finalFields) {
				reportUninitializedField(jvmField);
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
				checkInitializationRec(casepart.getThen(), fields, initializedInCaseForSure, initializedInCaseMaybe, visited);
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
			|| feature == XbasePackage.Literals.XABSTRACT_WHILE_EXPRESSION__PREDICATE) {
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

	@SuppressWarnings("null")
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
		if (leftType.isAny()) {
			return; // null is ok
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

	@NonNullByDefault
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
			for(XExpression argument: featureCall.getFeatureCallArguments()) {
				checkIsValidConstructorArgument(argument);
			}
		}
	}
	
	protected void checkIsValidConstructorArgument(XExpression argument) {
		Iterator<EObject> iterator = EcoreUtil2.eAll(argument);
		while(iterator.hasNext()) {
			EObject partOfArgumentExpression = iterator.next();
			if (partOfArgumentExpression instanceof XFeatureCall) {
				JvmIdentifiableElement feature = ((XFeatureCall) partOfArgumentExpression).getFeature();
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
						error("Recursive constructor invocation", null, CIRCULAR_CONSTRUCTOR_INVOCATION);
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

	@Check
	public void checkExceptionsInClosure(XClosure closure) {
		if (supportsCheckedExceptions())
			doCheckUnhandledException(closure.getExpression(), Collections.<JvmTypeReference> emptyList());
	}
	
	@Check
	public void checkUnhandledException(XExpression expression) {
		if (supportsCheckedExceptions()) {
			final JvmIdentifiableElement logicalContainer = logicalContainerProvider.getLogicalContainer(expression);
			if (logicalContainer instanceof JvmExecutable) {
				JvmExecutable executable = (JvmExecutable) logicalContainer;
				doCheckUnhandledException(expression, executable.getExceptions());
			}
		}
	}

	protected boolean supportsCheckedExceptions() {
		return true;
	}

	@Inject
	private ExceptionInExpressionFinder exceptionInExpressionFinder;

	protected void doCheckUnhandledException(XExpression expression, List<JvmTypeReference> declaredExceptions) {
		// TODO implement
//		for(JvmTypeReference unhandledException: findUnhandledExceptions(expression, typeProvider.getThrownExceptionTypes(expression), declaredExceptions)) {
//			reportUnhandledException(expression, unhandledException);
//		}
	}
	
	

	protected Iterable<JvmTypeReference> findUnhandledExceptions(EObject context,
			Iterable<JvmTypeReference> thrownExceptions, List<JvmTypeReference> declaredExceptions) {
		return jvmExceptions.findUnhandledExceptions(context, thrownExceptions, declaredExceptions);
	}

	protected void reportUnhandledException(XExpression element, JvmTypeReference thrownException) {
		for (EObject childThrowingException : exceptionInExpressionFinder.findChildrenThrowingException(element,
				thrownException)) {
			String expressionTypeURI = EcoreUtil.getURI(thrownException.getType()).toString();
			String childURI = EcoreUtil.getURI(childThrowingException).toString();
			error("Unhandled exception type " + thrownException.getSimpleName(), childThrowingException, null,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX, UNHANDLED_EXCEPTION, expressionTypeURI, childURI);
		}
	}

	//TODO switch expression not of type boolean
	//TODO apply cast rules case's type guards
	//TODO null guard is not allowed with any other primitives but boolean (null -> false)

	/*
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=341048
	 */
	@Check
	public void checkSpreadOperatorNotUsed(XMemberFeatureCall featureCall) {
		if (featureCall.isSpreading()) {
			error("The spreading operator is not yet supported.", featureCall,
					Literals.XMEMBER_FEATURE_CALL__SPREADING, "unssupported_spread_operator");
		}
	}

	@Check
	void checkNullSafeFeatureCallWithPrimitives(XMemberFeatureCall featureCall) {
		if (featureCall.isNullSafe() && getActualType(featureCall.getMemberCallTarget()).isPrimitive()) {
			error("Cannot use null safe feature call on primitive receiver", featureCall,
					Literals.XMEMBER_FEATURE_CALL__NULL_SAFE, NULL_SAFE_FEATURE_CALL_ON_PRIMITIVE);
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
		final Map<JvmType, XImportDeclaration> imports = Maps.newHashMap();
		final Map<JvmType, XImportDeclaration> staticImports = Maps.newHashMap();
		final Map<JvmType, XImportDeclaration> extensionImports = Maps.newHashMap();
		final Map<String, JvmType> importedNames = Maps.newHashMap();
		
		for (XImportDeclaration imp : importSection.getImportDeclarations()) {
			if (imp.getImportedNamespace() != null) { 
				addIssue(imp, IMPORT_WILDCARD_DEPRECATED, "The use of wildcard imports is deprecated.");
			} else {
				JvmType importedType = imp.getImportedType();
				if (importedType != null && !importedType.eIsProxy()) {
					Map<JvmType, XImportDeclaration> map = imp.isStatic() 
							? (imp.isExtension() ? extensionImports : staticImports) 
						    : imports;
					if(imp.isStatic()) {
						if(imp.isExtension()) {
							XImportDeclaration staticImport = staticImports.get(importedType);
							if(staticImport != null) {
								addIssue(staticImport, IssueCodes.IMPORT_DUPLICATE, "Obsolete static import of '" + importedType.getSimpleName() + "'.");
							}
						} else if(extensionImports.containsKey(importedType)) {
							addIssue(imp, IssueCodes.IMPORT_DUPLICATE, "Obsolete static import of '" + importedType.getSimpleName() + "'.");
						}
					}
					if (map.containsKey(importedType)) {
						addIssue(imp, IssueCodes.IMPORT_DUPLICATE, "Duplicate import of '" + importedType.getSimpleName() + "'.");
					} else {
						map.put(importedType, imp);
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
						}
					}
				}
			}
		}
		Set<EObject> primarySourceElements = Sets.newHashSet();
		for (JvmDeclaredType declaredType : getAllDeclaredTypes(importSection.eResource())) {
			if(importedNames.containsKey(declaredType.getSimpleName())){
				JvmType importedType = importedNames.get(declaredType.getSimpleName());
				if (importedType != declaredType  && importedType.eResource() != importSection.eResource()) {
					XImportDeclaration importDeclaration = imports.get(importedType);
					if(importDeclaration != null)
						error("The import '" 
								+ importedType.getIdentifier() 
								+ "' conflicts with a type defined in the same file", 
								importDeclaration, null, IssueCodes.IMPORT_CONFLICT );
				}
			}
			EObject primarySourceElement = associations.getPrimarySourceElement(declaredType);
			if(primarySourceElement != null)
				primarySourceElements.add(primarySourceElement);
		}
		for(EObject primarySourceElement: primarySourceElements) {
			ICompositeNode node = NodeModelUtils.findActualNodeFor(primarySourceElement);
			if (node != null) {
				for (INode n : node.getAsTreeIterable()) {
					if (n.getGrammarElement() instanceof CrossReference) {
						EClassifier classifier = ((CrossReference) n.getGrammarElement()).getType().getClassifier();
						if (classifier instanceof EClass
							 && (TypesPackage.Literals.JVM_TYPE.isSuperTypeOf((EClass) classifier) 
									|| TypesPackage.Literals.JVM_CONSTRUCTOR.isSuperTypeOf((EClass) classifier))) {
							// Filter out HiddenLeafNodes to avoid confusion by comments etc.
							StringBuilder builder = new StringBuilder();
							for(ILeafNode leafNode : n.getLeafNodes()){
								if(!leafNode.isHidden()){
									builder.append(leafNode.getText());
								}
							}
							String simpleName = builder.toString().trim();
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
					} else if (n.getGrammarElement() instanceof TerminalRule && ((TerminalRule) n.getGrammarElement()).getName().equals("ML_COMMENT")){
						List<ReplaceRegion> typeRefRegions = javaDocTypeReferenceProvider.computeTypeRefRegions(n);
						for(ReplaceRegion replaceRegion : typeRefRegions){
							String simpleName = replaceRegion.getText();
							if (importedNames.containsKey(simpleName)) {
								imports.remove(importedNames.remove(simpleName));
							}
						}
					} else if (n.getSemanticElement() instanceof XAbstractFeatureCall) {
						XAbstractFeatureCall featureCall = (XAbstractFeatureCall) n.getSemanticElement();
						if(featureCall.isStatic()
								&& (featureCall.getFeature() instanceof JvmField ||
									featureCall.getFeature() instanceof JvmOperation)) {
							JvmFeature feature = (JvmFeature) featureCall.getFeature();
							if(feature.getDeclaringType() != null) {
								JvmIdentifiableElement logicalContainer = logicalContainerProvider.getNearestLogicalContainer(featureCall);
								JvmDeclaredType featureCallOwner = EcoreUtil2.getContainerOfType(logicalContainer, JvmDeclaredType.class);
								if(featureCallOwner != feature.getDeclaringType()) {
									if(featureCall.isExtension() || staticImports.remove(feature.getDeclaringType()) == null) {
										extensionImports.remove(feature.getDeclaringType());
									}
								}
							}
						}
					}
				}
			}
		}
		if(!isIgnored(IMPORT_UNUSED)) {
			Iterable<XImportDeclaration> obsoleteImports = concat(imports.values(), staticImports.values(), extensionImports.values());
			for (XImportDeclaration imp : obsoleteImports) {
				addIssue(imp, IMPORT_UNUSED, "The import '" + imp.getImportedTypeName() + "' is never used.");
			}
		}
	}
	
	protected Iterable<JvmDeclaredType> getAllDeclaredTypes(Resource resource) {
		final List<JvmDeclaredType> allDeclaredTypes = newArrayList();
		addDeclaredTypes(resource.getContents(), new IAcceptor<JvmDeclaredType>() {
			public void accept(JvmDeclaredType t) {
				allDeclaredTypes.add(t);
			}
		});
		return allDeclaredTypes;
	}
	
	protected void addDeclaredTypes(List<? extends EObject> elements, IAcceptor<JvmDeclaredType> result) {
		for(EObject element: elements) {
			if (element instanceof JvmDeclaredType) {
				result.accept((JvmDeclaredType) element);
				addDeclaredTypes(((JvmDeclaredType) element).getMembers(), result);
			}
		}
	}
	
	protected boolean isLocallyUsed(EObject target, EObject containerToFindUsage) {
		return !XbaseUsageCrossReferencer.find(target, containerToFindUsage).isEmpty();
	}

	@Override
	protected List<EPackage> getEPackages() {
		return Lists.newArrayList(eINSTANCE, XtypePackage.eINSTANCE);
	}

	protected String canonicalName(LightweightTypeReference typeRef) {
		return (typeRef == null) ? "<null>" : typeRef.getSimpleName();
	}

	protected boolean isInterface(JvmType type) {
		return type instanceof JvmGenericType && ((JvmGenericType) type).isInterface();
	}

	protected IEarlyExitComputer getEarlyExitComputer() {
		return earlyExitComputer;
	}
	
	protected XExpressionHelper getExpressionHelper() {
		return expressionHelper;
	}
}