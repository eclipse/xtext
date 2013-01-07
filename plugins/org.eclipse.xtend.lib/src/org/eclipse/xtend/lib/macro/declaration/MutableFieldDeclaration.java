package org.eclipse.xtend.lib.macro.declaration;

import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtend.lib.macro.type.TypeReference;

public interface MutableFieldDeclaration extends MutableMemberDeclaration, FieldDeclaration {
	public MutableClassDeclaration getDeclaringType();
	void setFinal(boolean isFinal);

	void setStatic(boolean isStatic);
	
	void setInitializer(Expression initializer);
	
	void setType(TypeReference type);
}
