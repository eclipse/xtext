package org.eclipse.xtext.xtend2.typing;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.typing.XbaseTypeProvider;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

public class Xtend2TypeProvider extends XbaseTypeProvider {
	
	protected JvmTypeReference _type(XtendFunction function, org.eclipse.xtext.typing.ITypeProvider.Context<JvmTypeReference> context) {
		JvmTypeReference returnType = function.getReturnType();
		JvmTypeReference expressionsType = internalGetType(function.getExpression(), context.newWithExpectedType(returnType));
		return returnType==null?expressionsType:returnType;
	}
}
