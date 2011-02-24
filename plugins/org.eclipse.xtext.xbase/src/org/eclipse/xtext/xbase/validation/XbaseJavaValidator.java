package org.eclipse.xtext.xbase.validation;

import static java.util.Collections.*;
import static org.eclipse.xtext.util.Strings.*;
import static org.eclipse.xtext.xbase.XbasePackage.*;
import static org.eclipse.xtext.xbase.validation.IssueCodes.*;

import java.util.List;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ComposedChecks;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XbasePackage.Literals;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xbase.typing.SynonymTypesProvider;
import org.eclipse.xtext.xbase.typing.XbaseTypeConformanceComputer;
import org.eclipse.xtext.xbase.util.XExpressionHelper;

import com.google.inject.Inject;

@ComposedChecks(validators = { FeatureCallValidator.class, EarlyExitValidator.class })
public class XbaseJavaValidator extends AbstractXbaseJavaValidator {

	@Inject
	private ITypeProvider typeProvider;

	@Inject
	private XbaseTypeConformanceComputer conformanceComputer;

	@Inject
	private XExpressionHelper expressionHelper;

	@Inject
	private TypeReferences typeRefs;

	@Inject
	private TypesFactory factory;
	
	@Inject
	private SynonymTypesProvider synonymTypeProvider;

	@Check
	public void checkTypes(XExpression obj) {
		try {
			JvmTypeReference expectedType = typeProvider.getExpectedType(obj);
			if (expectedType == null || expectedType.getType() == null)
				return;
			JvmTypeReference actualType = typeProvider.getType(obj);
			if (actualType == null || actualType.getType() == null)
				return;
			if (!conformanceComputer.isConformant(expectedType, actualType))
				error("Incompatible types. Expected " + getNameOfTypes(expectedType) + " but was "
						+ canonicalName(actualType), obj, null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
						INCOMPATIBLE_TYPES);
		} catch (WrappedException e) {
			throw new WrappedException("XbaseJavaValidator#checkTypes for " + obj + " caused: "
					+ e.getCause().getMessage(), e);
		}
	}
	
	protected String getNameOfTypes(JvmTypeReference expectedType) {
		StringBuilder result = new StringBuilder(canonicalName(expectedType));
		Iterable<JvmTypeReference> types = synonymTypeProvider.getSynonymTypes(expectedType);
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
			if (expected!=null) {
				argument = typeRefs.wildCardExtends(expected);
			}
			JvmParameterizedTypeReference expectedType = typeRefs.createTypeRef(iterable, argument);
			if (!conformanceComputer.isConformant(expectedType, actualType))
				error("Incompatible types. Expected " + getNameOfTypes(expectedType) + " but was "
						+ canonicalName(actualType), obj.getForExpression(), null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
						INCOMPATIBLE_TYPES);
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
			error("No exception of type " + parameterType.getIdentifier()
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
		JvmTypeReference targetTypeRef = typeProvider.getType(cast.getTarget());
		if (targetTypeRef.getType() instanceof JvmDeclaredType) {
			JvmDeclaredType targetType = (JvmDeclaredType) targetTypeRef.getType();
			if (targetType.isFinal()) {
				if (!conformanceComputer.isConformant(cast.getType(), targetTypeRef)) {
					error("Cannot cast element of sealed type " + getNameOfTypes(targetTypeRef) + " to "
							+ canonicalName(cast.getType()), null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
							INVALID_CAST);
				} else if (conformanceComputer.isConformant(cast.getType(), targetTypeRef)) {
					warning("Cast is obsolete", null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, OBSOLETE_CAST);
				}
			} else {
				if (conformanceComputer.isConformant(cast.getType(), targetTypeRef)) {
					warning("Cast is obsolete", null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, OBSOLETE_CAST);
				} else {
					JvmType type = cast.getType().getType();
					if (type instanceof JvmGenericType && !((JvmGenericType) type).isInterface()) {
						if (!conformanceComputer.isConformant(targetTypeRef, cast.getType())) {
							error("type mismatch: cannot convert from " + getNameOfTypes(targetTypeRef) + " to "
									+ canonicalName(cast.getType()), null,
									ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INVALID_CAST);
						}
					}
				}
			}
		}
	}

	@Check
	public void checkInstanceOf(XInstanceOfExpression instanceOfExpression) {
		JvmTypeReference expressionTypeRef = typeProvider.getType(instanceOfExpression.getExpression());
		if (expressionTypeRef.getType() instanceof JvmDeclaredType) {
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
	public void checkFeatureCallOnVoid(XMemberFeatureCall featureCall) {
		if (typeRefs.is(typeProvider.getType(featureCall.getMemberCallTarget()), Void.class)) {
			error("Cannot access features of objects of type 'void'", null,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX, FEATURE_CALL_ON_VOID);
		}
	}

	@Check
	public void checkInstantiationOfAbstractClass(XConstructorCall constructorCall) {
		if (constructorCall.getConstructor().getDeclaringType().isAbstract()) {
			error("Cannot instantiate abstract class", null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
					ABSTRACT_CLASS_INSTANTIATION);
		}
	}

	//TODO switch expression not of type boolean
	//TODO apply cast rules case's type guards

	@Override
	protected List<EPackage> getEPackages() {
		return singletonList((EPackage) eINSTANCE);
	}

	protected String canonicalName(JvmTypeReference typeRef) {
		return (typeRef == null) ? "<null>" : notNull(typeRef.getIdentifier());
	}

	protected String canonicalName(JvmType type) {
		return (type == null) ? "<null>" : notNull(type.getIdentifier());
	}

	protected boolean isInterface(JvmType type) {
		return type instanceof JvmGenericType && ((JvmGenericType) type).isInterface();
	}

	protected boolean isConformant(JvmType leftType, JvmTypeReference right) {
		JvmParameterizedTypeReference left = factory.createJvmParameterizedTypeReference();
		left.setType(leftType);
		return conformanceComputer.isConformant(left, right);
	}
}
