package org.eclipse.xtend.lib.macro.services;

import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableNamedElement;
import org.eclipse.xtend.lib.macro.declaration.NamedElement;

public interface Tracability {
	
	boolean isSource(NamedElement element);
	boolean isGenerated(NamedElement element);
	boolean isExternal(NamedElement element);
	
	MutableNamedElement getGeneratedElement(NamedElement source);
	MutableClassDeclaration getGeneratedClass(ClassDeclaration source);
	MutableMethodDeclaration getGeneratedMethod(MethodDeclaration source);
	MutableConstructorDeclaration getGeneratedConstructor(ConstructorDeclaration source);
	MutableFieldDeclaration getGeneratedField(FieldDeclaration source);
}
