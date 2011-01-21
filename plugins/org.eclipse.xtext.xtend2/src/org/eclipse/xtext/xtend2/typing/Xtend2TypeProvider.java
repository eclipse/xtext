package org.eclipse.xtext.xtend2.typing;

import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.typing.XExpressionTypeProvider;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.inject.Inject;

public class Xtend2TypeProvider extends XExpressionTypeProvider {
	
	protected JvmTypeReference _type(XtendFunction function) {
		JvmTypeReference returnType = function.getReturnType();
		if (returnType!=null)
			return returnType;
		return getConvertedType(function.getExpression());
	}
	
	@Inject
	private TypesFactory factory;
	
	protected JvmTypeReference _type(XtendClass clazz) {
		JvmParameterizedTypeReference reference = factory.createJvmParameterizedTypeReference();
		reference.setType(clazz);
		return reference;
	}
}
