package org.eclipse.xtext.xbase.validation;

import static java.util.Collections.*;
import static org.eclipse.xtext.util.Strings.*;
import static org.eclipse.xtext.xbase.XbasePackage.*;

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
import org.eclipse.xtext.common.types.util.IJvmTypeConformanceComputer;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ComposedChecks;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
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
import org.eclipse.xtext.xbase.XbasePackage.Literals;
import org.eclipse.xtext.xbase.typing.IXExpressionExpectedTypeProvider;
import org.eclipse.xtext.xbase.typing.IXExpressionTypeProvider;
import org.eclipse.xtext.xbase.typing.TypeConverter;
import org.eclipse.xtext.xbase.typing.TypesService;
import org.eclipse.xtext.xbase.util.XExpressionHelper;

import com.google.inject.Inject;

@ComposedChecks(validators = FeatureCallValidator.class)
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
	private IXExpressionTypeProvider typeProvider;

	@Inject
	private IXExpressionExpectedTypeProvider expectedTypeProvider;

	@Inject
	private IJvmTypeConformanceComputer conformanceComputer;

	@Inject
	private XExpressionHelper expressionHelper;

	@Inject
	private TypesService typesService;

	@Inject
	private TypesFactory factory;
	
	@Inject
	private TypeConverter converter;

	@Check
	public void checkTypes(XExpression obj) {
		try {
			JvmTypeReference expectedType = expectedTypeProvider.getExpectedType(obj);
			if (expectedType == null || expectedType.getType() == null)
				return;
			expectedType = converter.convert(expectedType, obj);
			JvmTypeReference actualType = typeProvider.getConvertedType(obj);
			if (actualType == null || actualType.getType() == null)
				return;
			if (!conformanceComputer.isConformant(expectedType, actualType))
				error("Incompatible types. Expected " + canonicalName(expectedType) + " but was "
						+ canonicalName(actualType), obj, null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INCOMPATIBLE_TYPES);
		} catch (WrappedException e) {
			throw new WrappedException("XbaseJavaValidator#checkTypes for " + obj + " caused: " + e.getCause().getMessage(), e);
		}
	}

	@Check
	public void checkTypes(XCatchClause catchClause) {
		JvmTypeReference parameterType = catchClause.getDeclaredParam().getParameterType();
		JvmTypeReference throwable = typesService.getTypeForName(TypesService.JAVA_LANG_THROWABLE, catchClause);
		if (!conformanceComputer.isConformant(throwable, parameterType)) {
			error("No exception of type "+parameterType.getCanonicalName()+" can be thrown; an exception type must be a subclass of Throwable",
					catchClause.getDeclaredParam(),
					TypesPackage.Literals.JVM_FORMAL_PARAMETER__PARAMETER_TYPE,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
					INCOMPATIBLE_TYPES);
		}
	}

	@Check
	public void checkAssignment(XAssignment assignment) {
		JvmIdentifiableElement assignmentFeature = assignment.getFeature();
		if (assignmentFeature instanceof XVariableDeclaration
				&& !((XVariableDeclaration) assignmentFeature).isWriteable())
			error("Assignment to final variable", Literals.XASSIGNMENT__ASSIGNABLE, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, ASSIGNMENT_TO_FINAL);
		else if (assignmentFeature instanceof JvmFormalParameter)
			error("Assignment to final parameter", Literals.XASSIGNMENT__ASSIGNABLE, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, ASSIGNMENT_TO_FINAL);
		else if (assignmentFeature instanceof JvmField && ((JvmField) assignmentFeature).isFinal())
			error("Assignment to final feature", Literals.XASSIGNMENT__ASSIGNABLE, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, ASSIGNMENT_TO_FINAL);
	}

	@Check
	public void checkVariableDeclaration(XVariableDeclaration declaration) {
		if (declaration.getRight() == null) {
			if (!declaration.isWriteable())
				error("Value must be initialized", Literals.XVARIABLE_DECLARATION__WRITEABLE, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, MISSING_INITIALIZATION);
			if (declaration.getType() == null)
				error("Type cannot be derived", Literals.XVARIABLE_DECLARATION__NAME, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, MISSING_TYPE);
		}
	}

	@Check
	public void checkInnerExpressions(XBlockExpression block) {
		for (int i = 0; i < block.getExpressions().size() - 1; ++i) {
			XExpression expr = block.getExpressions().get(i);
			if (expressionHelper.isLiteral(expr)) {
				error("Literals can only appear as the last element of a block expression", expr, null,
						ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
						INVALID_INNER_EXPRESSION);
			} else if (expr instanceof XThrowExpression) {
				error("Throws clause must be last element of a block expression", expr, null,
						ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
						INVALID_INNER_EXPRESSION);
			}
		}
	}

	@Check
	public void checkCasts(XCastedExpression cast) {
		JvmTypeReference targetTypeRef = typeProvider.getConvertedType(cast.getTarget());
		if (targetTypeRef.getType() instanceof JvmDeclaredType) {
			JvmDeclaredType targetType = (JvmDeclaredType) targetTypeRef.getType();
			if (targetType.isFinal()) {
				if (!conformanceComputer.isConformant(cast.getType(), targetTypeRef)) {
					error("Cannot cast element of sealed type " + canonicalName(targetTypeRef) + " to "
							+ canonicalName(cast.getType()), null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INVALID_CAST);
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
							error("type mismatch: cannot convert from "+canonicalName(targetTypeRef)+" to "+canonicalName(cast.getType()),null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INVALID_CAST);
						}
					}
				}
			}
		}
	}

	@Check
	public void checkInstanceOf(XInstanceOfExpression instanceOfExpression) {
		JvmTypeReference expressionTypeRef = typeProvider.getConvertedType(instanceOfExpression.getExpression());
		if (expressionTypeRef.getType() instanceof JvmDeclaredType) {
			boolean isConformant = isConformant(instanceOfExpression.getType(), expressionTypeRef);
			if (isConformant) {
				warning("The expression of type " + canonicalName(expressionTypeRef) + " is already of type "
						+ canonicalName(instanceOfExpression.getType()), null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, OBSOLETE_INSTANCEOF);
			} else {
				if (isFinal(expressionTypeRef)) {
					error("Incompatible conditional operand types " + canonicalName(expressionTypeRef) + " and "
							+ canonicalName(instanceOfExpression.getType()), null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INVALID_INSTANCEOF);
				}
			}
		}
	}

	protected boolean isFinal(JvmTypeReference expressionTypeRef) {
		return expressionTypeRef.getType() instanceof JvmDeclaredType && ((JvmDeclaredType)expressionTypeRef.getType()).isFinal();
	}

	@Check
	public void checkFeatureCallOnVoid(XMemberFeatureCall featureCall) {
		if (typesService.isVoid(typeProvider.getConvertedType(featureCall.getMemberCallTarget()))) {
			error("Cannot access features of objects of type 'void'", null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, FEATURE_CALL_ON_VOID);
		}
	}

	@Check
	public void checkInstantiationOfAbstractClass(XConstructorCall constructorCall) {
		if (constructorCall.getConstructor().getDeclaringType().isAbstract()) {
			error("Cannot instantiate abstract class", null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, ABSTRACT_CLASS_INSTANTIATION);
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
