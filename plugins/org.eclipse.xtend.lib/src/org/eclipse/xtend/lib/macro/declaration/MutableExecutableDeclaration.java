package org.eclipse.xtend.lib.macro.declaration;

import java.util.List;

import org.eclipse.xtend.lib.macro.CompilationContext;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtend.lib.macro.type.TypeReference;
import org.eclipse.xtext.xbase.lib.Functions;

public interface MutableExecutableDeclaration extends MutableTypeParameterDeclarator, ExecutableDeclaration {
	public List<MutableParameterDeclaration> getParameters();
	void setVarArgs(boolean isVarArgs);
	void setBody(Expression body);
	void setBody(Functions.Function1<? super CompilationContext, ? extends CharSequence> compilationStrategy);
	void setExceptions(List<TypeReference> exceptions);
}
