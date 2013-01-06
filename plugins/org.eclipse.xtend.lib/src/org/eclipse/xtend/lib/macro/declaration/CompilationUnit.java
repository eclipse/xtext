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
	List<SourceClassDeclaration> getSourceClassDeclarations();
	
	List<GeneratedTypeDeclaration> getGeneratedTypeDeclarations();
	List<GeneratedClassDeclaration> getGeneratedClassDeclarations();
	
	// factory and finder methods
//	GeneratedClassDeclaration modifyClass(String name, Procedures.Procedure1<GeneratedClassDeclaration> initializer);
//	GeneratedClassDeclaration newClass(String name, Procedures.Procedure1<GeneratedClassDeclaration> initializer);
//	
//	
//	// type references
//	TypeReference typeRef(String name, TypeReference ... actualArguments);
//	TypeReference wildCard(TypeReference upperBound, TypeReference lowerBound);
//	TypeReference primitiveVoid();
//	TypeReference primitiveBoolean();
//	TypeReference primitiveInt();
//	TypeReference primitiveLong();
}
