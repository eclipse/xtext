package org.eclipse.xtext.xbase.validation;

import static com.google.common.collect.Sets.*;
import static java.util.Collections.*;
import static org.eclipse.xtext.util.Strings.*;
import static org.eclipse.xtext.xbase.XbasePackage.*;
import static org.eclipse.xtext.xbase.validation.IssueCodes.*;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
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
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.TypeConformanceComputer;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ComposedChecks;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XIntLiteral;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.XbasePackage.Literals;
import org.eclipse.xtext.xbase.controlflow.IEarlyExitComputer;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.lib.Procedures;
import org.eclipse.xtext.xbase.scoping.XbaseScopeProvider;
import org.eclipse.xtext.xbase.typing.Closures;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xbase.typing.JvmExceptions;
import org.eclipse.xtext.xbase.typing.SynonymTypesProvider;
import org.eclipse.xtext.xbase.util.XExpressionHelper;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Inject;

@ComposedChecks(validators = { FeatureCallValidator.class, EarlyExitValidator.class })
public class XbaseJavaValidator extends AbstractXbaseJavaValidator {

	@Inject
	private ITypeProvider typeProvider;

	@Inject
	private TypeConformanceComputer conformanceComputer;

	@Inject
	private XExpressionHelper expressionHelper;

	@Inject
	private TypeReferences typeRefs;

	@Inject
	private TypesFactory factory;

	@Inject
	private SynonymTypesProvider synonymTypeProvider;

	@Inject
	private IEarlyExitComputer earlyExitComputer;

	@Inject
	private IScopeProvider scopeProvider;

	@Inject
	private Primitives primitives;

	@Inject
	private ILogicalContainerProvider logicalContainerProvider;
	
	@Inject
	private JvmExceptions jvmExceptions;
	
	@Inject
	private Closures closures;

	private final Set<EReference> typeConformanceCheckedReferences = ImmutableSet.of(
			XbasePackage.Literals.XVARIABLE_DECLARATION__RIGHT, XbasePackage.Literals.XIF_EXPRESSION__IF,
			XbasePackage.Literals.XTHROW_EXPRESSION__EXPRESSION, XbasePackage.Literals.XRETURN_EXPRESSION__EXPRESSION,
			XbasePackage.Literals.XSWITCH_EXPRESSION__SWITCH, XbasePackage.Literals.XCASE_PART__CASE,
			XbasePackage.Literals.XASSIGNMENT__ASSIGNABLE, XbasePackage.Literals.XABSTRACT_WHILE_EXPRESSION__PREDICATE,
			XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS,
			XbasePackage.Literals.XCONSTRUCTOR_CALL__ARGUMENTS,
			XbasePackage.Literals.XFEATURE_CALL__FEATURE_CALL_ARGUMENTS,
			//TODO these references might point to the receiver, which is the basis of why a certain feature was picked in scoping.
			// Should be checked in case of extension methods only (i.e. when they are arguments)
			//			XbasePackage.Literals.XBINARY_OPERATION__LEFT_OPERAND,
			//			XbasePackage.Literals.XUNARY_OPERATION__OPERAND
			XbasePackage.Literals.XASSIGNMENT__VALUE, XbasePackage.Literals.XBINARY_OPERATION__RIGHT_OPERAND);

	protected Set<EReference> getTypeConformanceCheckedReferences() {
		return typeConformanceCheckedReferences;
	}

	@Check
	public void checkNoSideffectFreeExpressionsInBlockExpression(XBlockExpression blockExpression) {
		for (int i = 0; i < blockExpression.getExpressions().size() - 1; i++) {
			XExpression expr = blockExpression.getExpressions().get(i);
			if (isSideEffectFree(expr)) {
				error("The expression does not cause any side effects and therefore doesn't do anything in this context.",
						expr, null, INSIGNIFICANT_INDEX, IssueCodes.SIDE_EFFECT_FREE_EXPRESSION_IN_BLOCK);
			}
		}
	}

	//TODO extract and put in separate class for general reuse (see also AbstractXbaseCompiler#isVariableDeclarationRequired )
	protected boolean isSideEffectFree(XExpression expr) {
		if (expr instanceof XMemberFeatureCall) {
			return ((XMemberFeatureCall) expr).getFeature() instanceof JvmField;
		}
		if (expr instanceof XFeatureCall) {
			return !(((XFeatureCall) expr).getFeature() instanceof JvmOperation);
		}
		if (expr instanceof XCastedExpression) {
			return isSideEffectFree(((XCastedExpression) expr).getTarget());
		}
		return expr instanceof XStringLiteral || expr instanceof XTypeLiteral || expr instanceof XIntLiteral
				|| expr instanceof XNullLiteral || expr instanceof XBooleanLiteral || expr instanceof XClosure;
	}

	@Check
	public void checkTypeReferenceIsNotVoid(XExpression expression) {
		EList<EObject> list = expression.eContents();
		for (EObject eObject : list) {
			if (eObject instanceof JvmTypeReference) {
				JvmTypeReference typeRef = (JvmTypeReference) eObject;
				if (typeRefs.is(typeRef, Void.TYPE)) {
					error("Primitive void cannot be used here.", typeRef, null, INVALID_USE_OF_TYPE);
				}
			}
		}
	}

	@Check
	public void checkVariableIsNotInferredAsVoid(XVariableDeclaration declaration) {
		if (declaration.getType() != null)
			return;
		JvmTypeReference inferredType = getTypeProvider().getTypeForIdentifiable(declaration);
		if (typeRefs.is(inferredType, Void.TYPE)) {
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
					JvmTypeReference type = getTypeProvider().getExpectedType(closure);
					if (type == null) {
						error("There is no context to infer the closure's argument types from. Consider typing the arguments or put the closures into a typed context.",
								closure, null, INSIGNIFICANT_INDEX, TOO_LITTLE_TYPE_INFORMATION);
						return;
					} else {
						JvmOperation operation = closures.findImplementingOperation(type, closure.eResource());
						if (operation == null) {
							error("There is no context to infer the closure's argument types from. Consider typing the arguments or use the closures in a more specific context.",
									closure, null, INSIGNIFICANT_INDEX, TOO_LITTLE_TYPE_INFORMATION);
							return;
						}
					}
					checkedClosure = true;
				}
				if (getTypeProvider().getTypeForIdentifiable(p, true) == null) {
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
		if (primitives.isPrimitive(typeRef)) {
			error("Primitives cannot be used as type arguments.", typeRef, null, INVALID_USE_OF_TYPE);
		}
		if (typeRef instanceof JvmWildcardTypeReference) {
			error("Wildcard types are not allowed in this context", typeRef, null, INSIGNIFICANT_INDEX,
					INVALID_USE_OF_WILDCARD);
		}
	}

	@Check
	public void checkTypeReferenceIsNotVoid(XCasePart expression) {
		if (expression.getTypeGuard() != null && typeRefs.is(expression.getTypeGuard(), Void.TYPE)) {
			error("Primitive void cannot be used here.", expression.getTypeGuard(), null, INVALID_USE_OF_TYPE);
		}
	}

	@Check
	public void checkUniqueVariableName(XVariableDeclaration decl) {
		checkDeclaredVariableName(decl, XbasePackage.Literals.XVARIABLE_DECLARATION__NAME);
	}

	@Check
	public void checkUniqueVariableName(XSwitchExpression decl) {
		checkDeclaredVariableName(decl, XbasePackage.Literals.XSWITCH_EXPRESSION__LOCAL_VAR_NAME);
	}

	@Check
	public void checkUniqueVariableName(XForLoopExpression forLoop) {
		checkDeclaredVariableName(forLoop, forLoop.getDeclaredParam(), TypesPackage.Literals.JVM_FORMAL_PARAMETER__NAME);
	}

	@Check
	public void checkUniqueVariableName(XClosure closure) {
		for (JvmFormalParameter param : closure.getFormalParameters()) {
			checkDeclaredVariableName(closure, param, TypesPackage.Literals.JVM_FORMAL_PARAMETER__NAME);
		}
	}

	@Check
	public void checkUniqueVariableName(XTryCatchFinallyExpression tryCatch) {
		for (XCatchClause param : tryCatch.getCatchClauses()) {
			checkDeclaredVariableName(tryCatch, param.getDeclaredParam(),
					TypesPackage.Literals.JVM_FORMAL_PARAMETER__NAME);
		}
	}

	protected void checkDeclaredVariableName(EObject nameAndAttributeDeclarator, EAttribute attr) {
		checkDeclaredVariableName(nameAndAttributeDeclarator, nameAndAttributeDeclarator, attr);
	}

	protected void checkDeclaredVariableName(EObject nameDeclarator, EObject attributeHolder, EAttribute attr) {
		if (nameDeclarator.eContainer() == null)
			return;
		if (attr.getEContainingClass().isInstance(attributeHolder)) {
			String name = (String) attributeHolder.eGet(attr);
			// shadowing 'it' is allowed
			if(name == null || equal(name, XbaseScopeProvider.IT.toString()))
				return;
			if (getDisallowedVariableNames().contains(name)) {
				error("'" + name + "' is not a valid name.", attributeHolder, attr, -1,
						IssueCodes.VARIABLE_NAME_SHADOWING);
				return;
			}
			int idx = 0;
			if (nameDeclarator.eContainer() instanceof XBlockExpression) {
				idx = ((XBlockExpression) nameDeclarator.eContainer()).getExpressions().indexOf(nameDeclarator);
			}
			IScope scope = getScopeProvider().createSimpleFeatureCallScope(nameDeclarator.eContainer(),
					XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, nameDeclarator.eResource(), true, idx);
			Iterable<IEObjectDescription> elements = scope.getElements(QualifiedName.create(name));
			for (IEObjectDescription desc : elements) {
				if (desc.getEObjectOrProxy() != nameDeclarator && !(desc.getEObjectOrProxy() instanceof JvmFeature)) {
					error("Duplicate variable name '" + name + "'", attributeHolder, attr,
							IssueCodes.VARIABLE_NAME_SHADOWING);
				}
			}
		}
	}

	private Set<String> disallowedNames = newHashSet(XbaseScopeProvider.THIS.toString(), XbaseScopeProvider.SUPER.toString());
	protected Set<String> getDisallowedVariableNames() {
		return disallowedNames;
	}

	protected XbaseScopeProvider getScopeProvider() {
		return (XbaseScopeProvider) scopeProvider;
	}

	@Check
	public void checkTypes(final XExpression obj) {
		if (obj instanceof XAbstractFeatureCall) {
			XExpression firstArgument = ((XAbstractFeatureCall) obj).getImplicitFirstArgument();
			if (firstArgument != null) {
				validateType(firstArgument, new Procedures.Procedure2<JvmTypeReference, JvmTypeReference>() {
					public void apply(JvmTypeReference expectedType, JvmTypeReference actualType) {
						error("Incompatible implicit first argument. Expected " + getNameOfTypes(expectedType)
								+ " but was " + canonicalName(actualType), obj, null,
								ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INCOMPATIBLE_TYPES);
					}
				});
			}
		}
		if (!getTypeConformanceCheckedReferences().contains(obj.eContainingFeature())) {
			return;
		}
		try {
			validateType(obj, new Procedures.Procedure2<JvmTypeReference, JvmTypeReference>() {
				public void apply(JvmTypeReference expectedType, JvmTypeReference actualType) {
					error("Incompatible types. Expected " + getNameOfTypes(expectedType) + " but was "
							+ canonicalName(actualType), obj, null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
							INCOMPATIBLE_TYPES);
				}
			});
		} catch (WrappedException e) {
			throw new WrappedException("XbaseJavaValidator#checkTypes for " + obj + " caused: "
					+ e.getCause().getMessage(), e);
		}
	}

	protected void validateType(XExpression expression,
			Procedures.Procedure2<JvmTypeReference, JvmTypeReference> messageProducer) {
		JvmTypeReference expectedType = typeProvider.getExpectedType(expression);
		if (expectedType == null || expectedType.getType() == null)
			return;
		JvmTypeReference actualType = typeProvider.getType(expression);
		if (actualType == null || actualType.getType() == null)
			return;
		boolean valid = conformanceComputer.isConformant(expectedType, actualType);
		if (!valid) {
			messageProducer.apply(expectedType, actualType);
		}
	}

	@Check
	public void checkReceiverOfStaticFeature(XMemberFeatureCall featureCall) {
		doCheckReceiverOfStaticFeature(featureCall, featureCall.getMemberCallTarget());
	}

	@Check
	public void checkReceiverOfStaticFeature(XFeatureCall featureCall) {
		doCheckReceiverOfStaticFeature(featureCall, featureCall.getImplicitReceiver());
	}

	protected void doCheckReceiverOfStaticFeature(final XAbstractFeatureCall featureCall, XExpression receiver) {
		if (receiver != null && featureCall.getFeature() instanceof JvmOperation) {
			JvmOperation operation = (JvmOperation) featureCall.getFeature();
			if (operation.isStatic()) {
				try {
					validateType(receiver, new Procedures.Procedure2<JvmTypeReference, JvmTypeReference>() {
						public void apply(JvmTypeReference expectedType, JvmTypeReference actualType) {
							error("Incompatible receiver type. Expected " + getNameOfTypes(expectedType) + " but was "
									+ canonicalName(actualType), featureCall,
									XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE,
									ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INCOMPATIBLE_TYPES);
						}
					});
				} catch (WrappedException e) {
					throw new WrappedException("XbaseJavaValidator#checkTypes for " + receiver + " caused: "
							+ e.getCause().getMessage(), e);
				}
			}
		}
	}

	@Check
	public void checkImplicitReturn(XExpression expr) {
		if (!isImplicitReturn(expr))
			return;
		JvmTypeReference expectedType = typeProvider.getExpectedType(expr);
		// TODO what's this special case here?
		if (expectedType == null || typeRefs.is(expectedType, Void.TYPE))
			return;
		JvmTypeReference type = typeProvider.getType(expr);
		// TODO what's this special case here?
		if (typeRefs.is(expectedType, Void.class) && EcoreUtil2.getContainerOfType(expr, XClosure.class) != null) {
			if (typeRefs.is(type, Void.TYPE))
				return;
		}
		if (!conformanceComputer.isConformant(expectedType, type)) {
			error("Incompatible implicit return type. Expected " + getNameOfTypes(expectedType) + " but was "
					+ canonicalName(type), expr, null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
					INCOMPATIBLE_RETURN_TYPE);
		}
	}

	@Check
	public void checkReturn(XReturnExpression expr) {
		JvmTypeReference returnType = typeProvider.getExpectedReturnType(expr, true);
		if (returnType == null) {
			if (expr.getExpression() != null) {
				JvmTypeReference expressionType = typeProvider.getType(expr.getExpression());
				if (typeRefs.is(expressionType, Void.TYPE)) {
					error("Incompatible types. Expected java.lang.Object but was " + canonicalName(expressionType),
							expr.getExpression(), null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
							INCOMPATIBLE_TYPES);
				}
			}
			return;
		}
		if (typeRefs.is(returnType, Void.TYPE)) {
			if (expr.getExpression() != null)
				error("Void functions cannot return a value.", expr, null,
						ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INVALID_RETURN);
		} else {
			if (expr.getExpression() == null)
				error("The function must return a result of type " + returnType.getSimpleName() + ".", expr, null,
						ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INVALID_RETURN);
			else {
				JvmTypeReference expressionType = typeProvider.getType(expr.getExpression());
				if (typeRefs.is(expressionType, Void.TYPE)) {
					error("Incompatible types. Expected " + getNameOfTypes(returnType) + " but was "
							+ canonicalName(expressionType), expr.getExpression(), null,
							ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INCOMPATIBLE_TYPES);
				}
			}

		}
	}

	protected boolean isImplicitReturn(XExpression expr) {
		return (logicalContainerProvider.getLogicalContainer(expr) instanceof JvmOperation || expr.eContainer() instanceof XClosure)
				&& !earlyExitComputer.isEarlyExit(expr);
	}

	protected String getNameOfTypes(JvmTypeReference expectedType) {
		StringBuilder result = new StringBuilder(canonicalName(expectedType));
		Iterable<JvmTypeReference> types = synonymTypeProvider.getSynonymTypes(expectedType, false);
		for (JvmTypeReference jvmTypeReference : types) {
			result.append(" or ").append(canonicalName(jvmTypeReference));
		}
		return result.toString();
	}

	@Check
	public void checkTypes(XForLoopExpression obj) {
		try {
			JvmTypeReference actualType = typeProvider.getType(obj.getForExpression());
			if (actualType == null || actualType.getType() == null)
				return;

			JvmType iterable = typeRefs.findDeclaredType(Iterable.class, obj);
			JvmTypeReference argument = typeRefs.wildCard();
			JvmTypeReference expected = obj.getDeclaredParam().getParameterType();
			if (expected != null) {
				argument = typeRefs.wildCardExtends(EcoreUtil2.cloneIfContained(expected));
			}
			JvmParameterizedTypeReference expectedType = typeRefs.createTypeRef(iterable, argument);
			if (!conformanceComputer.isConformant(expectedType, actualType))
				error("Incompatible types. Expected " + getNameOfTypes(expectedType) + " but was "
						+ canonicalName(actualType), obj.getForExpression(), null,
						ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INCOMPATIBLE_TYPES);
			else if (actualType instanceof JvmParameterizedTypeReference) {
				// TODO create type argument context and check bound value of iterable's type parameter
				// rawType - check expectation for Object
				if (((JvmParameterizedTypeReference) actualType).getArguments().isEmpty()) {
					if (obj.getDeclaredParam().getParameterType() != null) {
						if (!typeRefs.is(obj.getDeclaredParam().getParameterType(), Object.class)) {
							error("Incompatible types. Expected " + getNameOfTypes(expectedType) + " but was "
									+ canonicalName(actualType), obj.getForExpression(), null,
									ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INCOMPATIBLE_TYPES);
						}
					}
				}
			}
		} catch (WrappedException e) {
			throw new WrappedException("XbaseJavaValidator#checkTypes for " + obj + " caused: "
					+ e.getCause().getMessage(), e);
		}
	}

	@Check
	public void checkTypes(XCatchClause catchClause) {
		JvmTypeReference parameterType = catchClause.getDeclaredParam().getParameterType();
		JvmTypeReference throwable = typeRefs.getTypeForName(Throwable.class, catchClause);
		if (!conformanceComputer.isConformant(throwable, parameterType)) {
			error("No exception of type " + parameterType.getQualifiedName('.')
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
		else if (assignmentFeature instanceof JvmField && ((JvmField) assignmentFeature).isFinal())
			error("Assignment to final feature", Literals.XASSIGNMENT__ASSIGNABLE,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX, ASSIGNMENT_TO_FINAL);
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
	public void checkInnerExpressions(XBlockExpression block) {
		for (int i = 0; i < block.getExpressions().size() - 1; ++i) {
			XExpression expr = block.getExpressions().get(i);
			if (expressionHelper.isLiteral(expr)) {
				error("Literals can only appear as the last element of a block expression", expr, null,
						ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INVALID_INNER_EXPRESSION);
			}
		}
	}

	@Check
	public void checkCasts(XCastedExpression cast) {
		JvmTypeReference toType = cast.getType();
		JvmTypeReference fromType = typeProvider.getType(cast.getTarget());
		checkCast(toType, fromType);
	}

	protected void checkCast(JvmTypeReference toType, JvmTypeReference fromType) {
		if (fromType != null && fromType.getType() instanceof JvmDeclaredType) {
			JvmDeclaredType targetType = (JvmDeclaredType) fromType.getType();
			if (targetType.isFinal()) {
				if (!conformanceComputer.isConformant(toType, fromType)) {
					error("Cannot cast element of sealed type " + getNameOfTypes(fromType) + " to "
							+ canonicalName(toType), toType, null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
							INVALID_CAST);
				} else if (conformanceComputer.isConformant(toType, fromType)) {
					//					warning("Cast is obsolete", null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, OBSOLETE_CAST);
				}
			} else {
				if (conformanceComputer.isConformant(toType, fromType)) {
					//					warning("Cast is obsolete", null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, OBSOLETE_CAST);
				} else {
					JvmType type = toType.getType();
					if (type instanceof JvmGenericType && !((JvmGenericType) type).isInterface()) {
						if (!conformanceComputer.isConformant(fromType, toType)) {
							error("type mismatch: cannot convert from " + getNameOfTypes(fromType) + " to "
									+ canonicalName(toType), toType, null,
									ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INVALID_CAST);
						}
					}
				}
			}
		}
	}

	@Check
	public void checkTypeGuards(XCasePart casePart) {
		if (casePart.getTypeGuard() == null)
			return;
		JvmTypeReference typeGuard = casePart.getTypeGuard();
		if (primitives.isPrimitive(typeGuard))
			error("Primitives are not allowed as type guards", Literals.XCASE_PART__TYPE_GUARD, INVALID_USE_OF_TYPE);
		JvmTypeReference targetTypeRef = typeProvider.getType(((XSwitchExpression) casePart.eContainer()).getSwitch());
		checkCast(typeGuard, targetTypeRef);
	}

	@Check
	public void checkInstanceOf(XInstanceOfExpression instanceOfExpression) {
		JvmTypeReference expressionTypeRef = typeProvider.getType(instanceOfExpression.getExpression());
		if (expressionTypeRef != null && expressionTypeRef.getType() instanceof JvmDeclaredType) {
			boolean isConformant = isConformant(instanceOfExpression.getType(), expressionTypeRef);
			if (isConformant) {
				warning("The expression of type " + getNameOfTypes(expressionTypeRef) + " is already of type "
						+ canonicalName(instanceOfExpression.getType()), null,
						ValidationMessageAcceptor.INSIGNIFICANT_INDEX, OBSOLETE_INSTANCEOF);
			} else {
				if (isFinal(expressionTypeRef)) {
					error("Incompatible conditional operand types " + getNameOfTypes(expressionTypeRef) + " and "
							+ canonicalName(instanceOfExpression.getType()), null,
							ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INVALID_INSTANCEOF);
				}
			}
		}
	}

	protected boolean isFinal(JvmTypeReference expressionTypeRef) {
		return expressionTypeRef.getType() instanceof JvmDeclaredType
				&& ((JvmDeclaredType) expressionTypeRef.getType()).isFinal();
	}

	@Check
	public void checkInstantiationOfAbstractClass(XConstructorCall constructorCall) {
		if (constructorCall.getConstructor().getDeclaringType().isAbstract()) {
			error("Cannot instantiate abstract class", null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
					ABSTRACT_CLASS_INSTANTIATION);
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
		for(JvmTypeReference unhandledException: findUnhandledExceptions(expression, typeProvider.getThrownExceptionTypes(expression), declaredExceptions)) {
			reportUnhandledException(expression, unhandledException);
		}
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
			error("Unhandled exception type " + thrownException.getIdentifier(), childThrowingException, null,
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
		if (featureCall.isNullSafe() && primitives.isPrimitive(typeProvider.getType(featureCall.getMemberCallTarget()))) {
			error("Cannot use null safe feature call on primitive receiver", featureCall,
					Literals.XMEMBER_FEATURE_CALL__NULL_SAFE, NULL_SAFE_FEATURE_CALL_ON_PRIMITIVE);
		}
	}

	@Override
	protected List<EPackage> getEPackages() {
		return singletonList((EPackage) eINSTANCE);
	}

	protected String canonicalName(JvmTypeReference typeRef) {
		return (typeRef == null) ? "<null>" : notNull(typeRef.getQualifiedName('.'));
	}

	protected String canonicalName(JvmType type) {
		return (type == null) ? "<null>" : notNull(type.getQualifiedName('.'));
	}

	protected boolean isInterface(JvmType type) {
		return type instanceof JvmGenericType && ((JvmGenericType) type).isInterface();
	}

	protected boolean isConformant(JvmType leftType, JvmTypeReference right) {
		JvmParameterizedTypeReference left = factory.createJvmParameterizedTypeReference();
		left.setType(leftType);
		return conformanceComputer.isConformant(left, right);
	}

	protected boolean isConformant(JvmTypeReference left, JvmTypeReference right) {
		return conformanceComputer.isConformant(left, right);
	}

	protected ITypeProvider getTypeProvider() {
		return typeProvider;
	}

	protected TypeReferences getTypeRefs() {
		return typeRefs;
	}

	protected TypesFactory getTypesFactory() {
		return factory;
	}

	protected IEarlyExitComputer getEarlyExitComputer() {
		return earlyExitComputer;
	}
}
