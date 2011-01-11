package org.eclipse.xtext.xbase.validation;

import static java.util.Collections.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.IJvmTypeConformanceComputer;
import org.eclipse.xtext.typing.IExpectedTypeProvider;
import org.eclipse.xtext.typing.TypeResolutionException;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.typing.IXbaseTypeProvider;

import com.google.inject.Inject;

public class XbaseJavaValidator extends AbstractXbaseJavaValidator {

	public static final String INCOMPATIBLE_TYPES = "xbase.incompatible_types";
	public static final String ASSIGNMENT_TO_FINAL = "xbase.assignment_to_final";
	public static final String MISSING_INITIALIZATION = "xbase.missing_initialization";
	public static final String MISSING_TYPE = "xbase.missing_type";

	@Inject
	private IXbaseTypeProvider typeProvider;
	
	@Inject
	private IExpectedTypeProvider<JvmTypeReference> expectedTypeProvider;

	@Inject
	private IJvmTypeConformanceComputer conformanceComputer;

	@Check
	public void checkTypes(EObject obj) {
		try {
			JvmTypeReference expectedType = expectedTypeProvider.getExpectedType(obj);
			if (expectedType == null)
				return;
			JvmTypeReference actualType = typeProvider.getType(obj);
			if (!conformanceComputer.isConformant(expectedType, actualType)) 
				error("Incompatible types. Expected " + getTypeCanonicalName(expectedType) + " but was "
						+ getTypeCanonicalName(actualType), obj, -1, INCOMPATIBLE_TYPES);
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
		if (assignment.getFeature() instanceof XVariableDeclaration
				&& !((XVariableDeclaration) assignment.getFeature()).isWriteable())
			error("Assignment to final variable", XbasePackage.XASSIGNMENT__ASSIGNABLE, ASSIGNMENT_TO_FINAL);
		else if (assignment.getFeature() instanceof JvmFormalParameter)
			error("Assignment to final parameter", XbasePackage.XASSIGNMENT__ASSIGNABLE, ASSIGNMENT_TO_FINAL);
	}

	@Check
	public void checkVariableDeclaration(XVariableDeclaration declaration) {
		if (declaration.getRight() == null) {
			if (!declaration.isWriteable())
				error("Value must be initialized", XbasePackage.XVARIABLE_DECLARATION, MISSING_INITIALIZATION);
			if (declaration.getType() == null)
				error("Type cannot be derived",
						XbasePackage.XVARIABLE_DECLARATION, MISSING_TYPE);
		}
	}

	@Check
	public void checkBlockExpression(XBlockExpression block) {
		//TODO simple literals are not allowed as an n-1 expression.
		// also check nested expressions (i.e. if statement's then and else, casts, etc.) for literals
	}
	
	@Override
	protected List<EPackage> getEPackages() {
		return singletonList((EPackage) XbasePackage.eINSTANCE);
	}

	protected String getTypeCanonicalName(JvmTypeReference typeRef) {
		return (typeRef == null) ? "<null>" : notNull(typeRef.getCanonicalName());
	}
	
	
	

}
