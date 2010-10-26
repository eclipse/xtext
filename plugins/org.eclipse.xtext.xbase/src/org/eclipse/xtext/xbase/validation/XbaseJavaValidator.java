package org.eclipse.xtext.xbase.validation;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.typing.ITypeProvider;
import org.eclipse.xtext.typing.ITypeProvider.Context;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.XExpression;

import com.google.inject.Inject;

public class XbaseJavaValidator extends AbstractXbaseJavaValidator {

	@Inject
	private ITypeProvider<JvmTypeReference> typeProvider;

	@Check
	public void checkTypes(XExpression expression) {
		if (expression.eContainer() == null) 
			typeProvider.getType(expression, Context.<JvmTypeReference>newCtx(getMessageAcceptor()));
	}

}
