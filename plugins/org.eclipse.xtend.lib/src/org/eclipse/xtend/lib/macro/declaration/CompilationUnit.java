package org.eclipse.xtend.lib.macro.declaration;

import java.util.List;

import com.google.common.annotations.Beta;

/**
 * @author Sven Efftinge
 */
@Beta
public interface CompilationUnit extends AnnotationTarget {

	String getPackageName();

	/**
	 * @return the JavaDoc comment
	 */
	String getDocComment();
	
	List<SourceTypeDeclaration> getSourceTypeDeclarations();
	
	List<GeneratedTypeDeclaration> getGeneratedTypeDeclarations();
}
