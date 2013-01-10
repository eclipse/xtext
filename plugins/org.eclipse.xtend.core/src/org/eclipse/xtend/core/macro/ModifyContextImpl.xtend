package org.eclipse.xtend.core.macro

import com.google.inject.Inject
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl
import org.eclipse.xtend.core.macro.declaration.XtendClassDeclarationImpl
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.lib.macro.ModifyContext
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.ConstructorDeclaration
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableConstructorDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration
import org.eclipse.xtend.lib.macro.declaration.NamedElement
import org.eclipse.xtext.xbase.lib.Procedures$Procedure1
import org.eclipse.xtend.core.macro.declaration.AbstractDeclarationImpl
import org.eclipse.emf.ecore.EObject

class ModifyContextImpl implements ModifyContext {
	
	@Inject IXtendJvmAssociations associations
	
	def private CompilationUnitImpl unit(NamedElement element) {
		element.compilationUnit as CompilationUnitImpl
	}
	
	def private EObject delegate(NamedElement element) {
//		switch element { 
//			AbstractDeclarationImpl : element.delegate
//		}
	}
	
	override getGeneratedClass(ClassDeclaration source) {
		val inferred = associations.getInferredType((source as XtendClassDeclarationImpl).delegate as XtendClass)
		return source.unit.toTypeDeclaration(inferred) as MutableClassDeclaration
	}
	
	override getGeneratedConstructor(ConstructorDeclaration source) {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override getGeneratedElement(NamedElement source) {
//		source.unit.toMemberDeclaration(associations.getJvmElements(source.def).head as JvmMember)
	}
	
	override getGeneratedField(FieldDeclaration source) {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override getGeneratedMethod(MethodDeclaration source) {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override isExternal(NamedElement element) {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override isGenerated(NamedElement element) {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override isSource(NamedElement element) {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}

	override newClass(Procedure1<MutableClassDeclaration> initializer) {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override newConstructor(Procedure1<MutableConstructorDeclaration> initializer) {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override newField(Procedure1<MutableFieldDeclaration> initializer) {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override newMethod(Procedure1<MutableMethodDeclaration> initializer) {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	
}