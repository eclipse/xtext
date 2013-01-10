package org.eclipse.xtend.lib.macro;

import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtext.xbase.lib.Procedures;

public interface DeclarationFactory {
	
	FieldDeclaration newField(Procedures.Procedure1<MutableFieldDeclaration> initializer);
	MethodDeclaration newMethod(Procedures.Procedure1<MutableMethodDeclaration> initializer);
	ConstructorDeclaration newConstructor(Procedures.Procedure1<MutableConstructorDeclaration> initializer);
	ClassDeclaration newClass(Procedures.Procedure1<MutableClassDeclaration> initializer);
	
}
