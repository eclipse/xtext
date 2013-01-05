package org.eclipse.xtend.lib.macro.declaration;

import java.util.List;

public interface SourceExecutableDeclaration extends SourceTypeParameterDeclarator, ExecutableDeclaration {
	public List<SourceParameterDeclaration> getParameters();
}
