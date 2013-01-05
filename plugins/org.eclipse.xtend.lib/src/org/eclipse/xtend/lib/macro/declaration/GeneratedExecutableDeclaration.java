package org.eclipse.xtend.lib.macro.declaration;

import java.util.List;

public interface GeneratedExecutableDeclaration extends ExecutableDeclaration, GeneratedMemberDeclaration {
	public List<GeneratedParameterDeclaration> getParameters();
}
