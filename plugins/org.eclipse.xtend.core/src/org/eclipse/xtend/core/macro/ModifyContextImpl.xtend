package org.eclipse.xtend.core.macro

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations
import org.eclipse.xtend.core.macro.declaration.AbstractNamedElementImpl
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl
import org.eclipse.xtend.lib.macro.ModifyContext
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.ConstructorDeclaration
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableConstructorDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableExecutableDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableNamedElement
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.NamedElement
import org.eclipse.xtend.lib.macro.type.TypeReference
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtext.xbase.lib.Procedures$Procedure1

class ModifyContextImpl implements ModifyContext {
	
	@Inject IXtendJvmAssociations associations
	
	@Property CompilationUnitImpl unit
	
	def private CompilationUnitImpl unit(NamedElement element) {
		element.compilationUnit as CompilationUnitImpl
	}
	
	def private EObject delegate(NamedElement element) {
		switch element { 
			AbstractNamedElementImpl<? extends EObject> : element.delegate
		}
	}
	
	override getGeneratedClass(ClassDeclaration source) {
		getGeneratedElement(source) as MutableClassDeclaration
	}
	
	override getGeneratedConstructor(ConstructorDeclaration source) {
		getGeneratedElement(source) as MutableConstructorDeclaration
	}
	
	override getGeneratedElement(NamedElement source) {
		val generated = associations.getJvmElements(source.delegate).head as JvmMember
		source.unit.toMemberDeclaration(generated) as MutableNamedElement
	}
	
	override getGeneratedField(FieldDeclaration source) {
		getGeneratedElement(source) as MutableFieldDeclaration
	}
	
	override getGeneratedMethod(MethodDeclaration source) {
		getGeneratedElement(source) as MutableMethodDeclaration
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

	override newConstructor(MutableClassDeclaration container, Procedure1<MutableConstructorDeclaration> initializer) {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override findGeneratedClass(String name) {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}

	override newField(MutableClassDeclaration declarator, String simpleName, Procedure1<MutableFieldDeclaration> initializer) {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override newMethod(MutableTypeDeclaration declarator, String simpleName, Procedure1<MutableMethodDeclaration> initializer) {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override newParameter(MutableExecutableDeclaration declarator, String simpleName, TypeReference type) {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
}