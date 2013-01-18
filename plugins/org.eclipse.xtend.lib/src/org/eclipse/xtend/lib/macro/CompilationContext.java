package org.eclipse.xtend.lib.macro;

import org.eclipse.xtend.lib.macro.type.TypeReference;

public interface CompilationContext {
	
	String toJavaCode(TypeReference typeref);
	
}
