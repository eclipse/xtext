package org.eclipse.xtext.xbase.validation;

import static java.util.Collections.*;
import static org.eclipse.xtext.util.Strings.*;
import static org.eclipse.xtext.xbase.XbasePackage.*;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifyableElement;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.IJvmTypeConformanceComputer;
import org.eclipse.xtext.typing.IExpectedTypeProvider;
import org.eclipse.xtext.typing.TypeResolutionException;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ComposedChecks;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.typing.IXbaseTypeProvider;
import org.eclipse.xtext.xbase.typing.TypesService;
import org.eclipse.xtext.xbase.util.XExpressionHelper;

import com.google.inject.Inject;

@ComposedChecks(validators=FeatureCallValidator.class)
public class XbaseJavaValidator extends AbstractXbaseJavaValidator {

	protected static final String ISSUE_CODE_PREFIX = XbaseJavaValidator.class.getCanonicalName() + ".";
	public static final String INCOMPATIBLE_TYPES = ISSUE_CODE_PREFIX + "incompatible_types";
	public static final String ASSIGNMENT_TO_FINAL = ISSUE_CODE_PREFIX + "assignment_to_final";
	public static final String MISSING_INITIALIZATION = ISSUE_CODE_PREFIX + "missing_initialization";
	public static final String MISSING_TYPE = ISSUE_CODE_PREFIX + "missing_type";
	public static final String INVALID_CAST = ISSUE_CODE_PREFIX + "invalid_cast";
	public static final String OBSOLETE_CAST = ISSUE_CODE_PREFIX + "obsolete_cast";
	public static final String INVALID_INSTANCEOF = ISSUE_CODE_PREFIX + "invalid_instanceof";
	public static final String OBSOLETE_INSTANCEOF = ISSUE_CODE_PREFIX + "obsolete_instanceof";
	public static final String INVALID_INNER_EXPRESSION = ISSUE_CODE_PREFIX + "invalid_inner_expression";
	public static final String FEATURE_CALL_ON_VOID = ISSUE_CODE_PREFIX + "feature_call_on_void";
	public static final String ABSTRACT_CLASS_INSTANTIATION = ISSUE_CODE_PREFIX + "abstract_class_instantiation";

	@Inject
	private IXbaseTypeProvider typeProvider;

	@Inject
	private IExpectedTypeProvider<JvmTypeReference> expectedTypeProvider;

	@Inject
	private IJvmTypeConformanceComputer conformanceComputer;

	@Inject
	private XExpressionHelper expressionHelper;

	@Inject
	private TypesService typesService;

	@Inject
	private TypesFactory factory;

	@Check
	public void checkTypes(EObject obj) {
		try {
			JvmTypeReference expectedType = expectedTypeProvider.getExpectedType(obj);
			if (expectedType == null)
				return;
			JvmTypeReference actualType = typeProvider.getType(obj);
			if (!conformanceComputer.isConformant(expectedType, actualType))
				error("Incompatible types. Expected " + canonicalName(expectedType) + " but was "
						+ canonicalName(actualType), obj, -1, INCOMPATIBLE_TYPES);
		} catch (TypeResolutionException e) {
			// do nothing, error should be handled elsewhere
		}
	}

	@Check
	public void checkTypes(XCatchClause catchClause) {
		checkTypes(catchClause.getDeclaredParam());
	}

	@Check
	public void checkAssignment(XAssignment assignment) {
		JvmIdentifyableElement assignmentFeature = assignment.getFeature();
		if (assignmentFeature instanceof XVariableDeclaration
				&& !((XVariableDeclaration) assignmentFeature).isWriteable())
			error("Assignment to final variable", XASSIGNMENT__ASSIGNABLE, ASSIGNMENT_TO_FINAL);
		else if (assignmentFeature instanceof JvmFormalParameter)
			error("Assignment to final parameter", XASSIGNMENT__ASSIGNABLE, ASSIGNMENT_TO_FINAL);
		else if (assignmentFeature instanceof JvmField && ((JvmField) assignmentFeature).isFinal())
			error("Assignment to final feature", XASSIGNMENT__ASSIGNABLE, ASSIGNMENT_TO_FINAL);
	}

	@Check
	public void checkVariableDeclaration(XVariableDeclaration declaration) {
		if (declaration.getRight() == null) {
			if (!declaration.isWriteable())
				error("Value must be initialized", XVARIABLE_DECLARATION, MISSING_INITIALIZATION);
			if (declaration.getType() == null)
				error("Type cannot be derived", XVARIABLE_DECLARATION__NAME, MISSING_TYPE);
		}
	}

	@Check
	public void checkInnerExpressions(XBlockExpression block) {
		for (int i = 0; i < block.getExpressions().size() - 1; ++i) {
			XExpression expr = block.getExpressions().get(i);
			if (expressionHelper.isLiteral(expr)) {
				error("Literals can only appear as the last element of a block expression", expr, -1,
						INVALID_INNER_EXPRESSION);
			} else if (expr instanceof XThrowExpression) {
				error("Throws clause must be last element of a block expression", expr, -1, INVALID_INNER_EXPRESSION);
			}
		}
	}

	@Check
	public void checkInvalidCast(XCastedExpression cast) {
		JvmTypeReference targetTypeRef = typeProvider.getType(cast.getTarget());
		if (targetTypeRef.getType() instanceof JvmDeclaredType) {
			JvmDeclaredType targetType = (JvmDeclaredType) targetTypeRef.getType();
			if (targetType.isFinal() && !conformanceComputer.isConformant(cast.getType(), targetTypeRef)) {
				error("Cannot cast element of sealed type " + canonicalName(targetTypeRef) + " to "
						+ canonicalName(cast.getType()), -1, INVALID_CAST);
			} else if (!isInterface(cast.getType().getType()) && !isInterface(targetType)) {
				if (conformanceComputer.isConformant(cast.getType(), targetTypeRef))
					warning("Cast is obsolete", -1, OBSOLETE_CAST);
				else
					error("Incompatible types " + canonicalName(targetTypeRef) + " and "
							+ canonicalName(cast.getType()), -1, INVALID_CAST);
			}
		}
	}

	@Check
	public void checkInstanceOf(XInstanceOfExpression instanceOfExpression) {
		JvmTypeReference expressionTypeRef = typeProvider.getType(instanceOfExpression.getExpression());
		if (expressionTypeRef.getType() instanceof JvmDeclaredType) {
			JvmDeclaredType targetType = (JvmDeclaredType) expressionTypeRef.getType();
			boolean isConformant = isConformant(instanceOfExpression.getType(), expressionTypeRef);
			if (isConformant) {
				warning("Condition is always true", -1, OBSOLETE_INSTANCEOF);
			} else {
				if (!(isInterface(instanceOfExpression.getType()) || isInterface(targetType)) || targetType.isFinal()) {
					error("Incompatible types " + canonicalName(expressionTypeRef) + " and "
							+ canonicalName(instanceOfExpression.getType()), -1, INVALID_INSTANCEOF);
				}
			}
		}
	}

	@Check
	public void checkFeatureCallOnVoid(XMemberFeatureCall featureCall) {
		if (typesService.isVoid(typeProvider.getType(featureCall.getMemberCallTarget()))) {
			error("Cannot access features of objects of type 'void'", -1, FEATURE_CALL_ON_VOID);
		}
	}

	@Check
	public void checkInstantiationOfAbstractClass(XConstructorCall constructorCall) {
		if (constructorCall.getConstructor().getDeclaringType().isAbstract()) {
			error("Cannot instantiate abstract class", -1, ABSTRACT_CLASS_INSTANTIATION);
		}
	}
	
	//TODO switch expression not of type boolean

		@Override
	protected List<EPackage> getEPackages() {
		return singletonList((EPackage) eINSTANCE);
	}

	protected String canonicalName(JvmTypeReference typeRef) {
		return (typeRef == null) ? "<null>" : notNull(typeRef.getCanonicalName());
	}

	protected String canonicalName(JvmType type) {
		return (type == null) ? "<null>" : notNull(type.getCanonicalName());
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
