package org.eclipse.xtend.lib.macro.declaration;

import java.util.List;

public interface GeneratedExecutableDeclaration extends GeneratedTypeParameterDeclarator, ExecutableDeclaration {
	public List<GeneratedParameterDeclaration> getParameters();
}
