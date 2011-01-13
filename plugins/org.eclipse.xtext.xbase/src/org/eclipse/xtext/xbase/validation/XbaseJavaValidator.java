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
import org.eclipse.xtext.common.types.JvmIdentifyableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.IJvmTypeConformanceComputer;
import org.eclipse.xtext.typing.IExpectedTypeProvider;
import org.eclipse.xtext.typing.TypeResolutionException;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.typing.IXbaseTypeProvider;
import org.eclipse.xtext.xbase.typing.TypesService;
import org.eclipse.xtext.xbase.util.XExpressionHelper;

import com.google.inject.Inject;

public class XbaseJavaValidator extends AbstractXbaseJavaValidator {

	public static final String INCOMPATIBLE_TYPES = XbaseJavaValidator.class.getCanonicalName() + ".incompatible_types";
	public static final String ASSIGNMENT_TO_FINAL = XbaseJavaValidator.class.getCanonicalName()
			+ ".assignment_to_final";
	public static final String MISSING_INITIALIZATION = XbaseJavaValidator.class.getCanonicalName()
			+ ".missing_initialization";
	public static final String MISSING_TYPE = XbaseJavaValidator.class.getCanonicalName() + ".missing_type";
	public static final String INVALID_CAST = XbaseJavaValidator.class.getCanonicalName() + ".invalid_cast";
	public static final String INVALID_INNER_EXPRESSION = XbaseJavaValidator.class.getCanonicalName() + ".invalid_inner_expression";
	public static final String FEATURE_CALL_ON_VOID = XbaseJavaValidator.class.getCanonicalName() + ".feature_call_on_void";
	public static final String ABSTRACT_CLASS_INSTANTIATION = XbaseJavaValidator.class.getCanonicalName() + ".abstract_class_instantiation";
	
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
		else if (assignmentFeature instanceof JvmField && ((JvmField)assignmentFeature).isFinal())
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
		for(int i=0; i< block.getExpressions().size()-1; ++i) {
			XExpression expr = block.getExpressions().get(i);
			if(expressionHelper.isLiteral(expr)) {
				error("Literals can only appear as the last element of a block expression", expr, -1, INVALID_INNER_EXPRESSION);
			} else if(expr instanceof XThrowExpression) {
				error("Throws clause must be last element of a block expression", expr, -1, INVALID_INNER_EXPRESSION);
			}
		}
	}
	
	@Check
	public void checkInvalidCast(XCastedExpression cast) {
		JvmTypeReference targetTypeRef = typeProvider.getType(cast.getTarget());
		if (targetTypeRef.getType() instanceof JvmDeclaredType) {
			if (((JvmDeclaredType) targetTypeRef.getType()).isFinal()
					&& !conformanceComputer.isConformant(cast.getType(), targetTypeRef)) {
				error("Element of sealed type " + canonicalName(targetTypeRef) + " cannot be cast to "
						+ canonicalName(cast.getType()), XCASTED_EXPRESSION__TYPE, INVALID_CAST);
			}
		}
	}
	
	@Check
	public void checkFeatureCallOnVoid(XMemberFeatureCall featureCall) {
		if(typesService.isVoid(typeProvider.getType(featureCall.getMemberCallTarget()))) {
			error("Cannot access features of objects of type 'void'", -1, FEATURE_CALL_ON_VOID);
		}
	}
	
	@Check
	public void checkInstantiationOfAbstractClass(XConstructorCall constructorCall) {
		if(constructorCall.getConstructor().getDeclaringType().isAbstract()) {
			error("Cannot instantiate abstract class", -1, ABSTRACT_CLASS_INSTANTIATION);
		}
	}
	
	@Override
	protected List<EPackage> getEPackages() {
		return singletonList((EPackage) eINSTANCE);
	}

	protected String canonicalName(JvmTypeReference typeRef) {
		return (typeRef == null) ? "<null>" : notNull(typeRef.getCanonicalName());
	}

}
