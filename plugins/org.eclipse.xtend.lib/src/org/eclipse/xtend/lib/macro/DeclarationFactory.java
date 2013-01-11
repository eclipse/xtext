package org.eclipse.xtend.lib.macro;

import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableExecutableDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.type.TypeReference;
import org.eclipse.xtext.xbase.lib.Procedures;

public interface DeclarationFactory {
	
	MutableFieldDeclaration newField(MutableClassDeclaration declarator, String simpleName, Procedures.Procedure1<MutableFieldDeclaration> initializer);
	MutableMethodDeclaration newMethod(MutableTypeDeclaration declarator, String simpleName, Procedures.Procedure1<MutableMethodDeclaration> initializer);
	MutableParameterDeclaration newParameter(MutableExecutableDeclaration declarator, String simpleName, TypeReference type);
	MutableConstructorDeclaration newConstructor(MutableClassDeclaration declarator, Procedures.Procedure1<MutableConstructorDeclaration> initializer);
	
}
