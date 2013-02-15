package org.eclipse.xtend.lib.macro.declaration;

import java.util.List;

import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtend.lib.macro.type.TypeReference;

public interface MutableExecutableDeclaration extends MutableTypeParameterDeclarator, ExecutableDeclaration {
	public List<MutableParameterDeclaration> getParameters();
	void setVarArgs(boolean isVarArgs);
	void setBody(Expression body);
	void setBody(CompilationStrategy compilationStrategy);
	void setExceptions(TypeReference... exceptions);
	
	MutableParameterDeclaration addParameter(String name, TypeReference type);
}
