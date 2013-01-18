package org.eclipse.xtend.lib.macro.declaration;

import java.util.List;

import org.eclipse.xtend.lib.macro.TypeReferenceProvider;

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
	
	List<? extends TypeDeclaration> getSourceTypeDeclarations();
	List<? extends ClassDeclaration> getSourceClassDeclarations();
	
	List<? extends TypeDeclaration> getGeneratedTypeDeclarations();
	List<? extends ClassDeclaration> getGeneratedClassDeclarations();
	
	TypeReferenceProvider getTypeReferenceProvider();
}
