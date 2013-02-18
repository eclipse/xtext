package org.eclipse.xtend.core.macro

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations
import org.eclipse.xtend.core.macro.declaration.AbstractNamedElementImpl
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.ConstructorDeclaration
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableConstructorDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableNamedElement
import org.eclipse.xtend.lib.macro.declaration.NamedElement
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtend.lib.macro.declaration.Element
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.TypeReference
import org.eclipse.xtend.lib.macro.declaration.Type

class TransformationContextImpl implements TransformationContext {
	
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

	override findGeneratedClass(String name) {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override getTypeReferenceProvider() {
		return unit
	}

	override addError(Element element, String message) {
		unit.addError(element, message)
	}
	
	override addInfo(Element element, String message) {
		unit.addInfo(element, message)
	}
	
	override addWarning(Element element, String message) {
		unit.addWarning(element, message)
	}
	
	override getProblems(Element element) {
		unit.getProblems(element)
	}
	
	override getAnyType() {
		unit.anyType
	}
	
	override getList(TypeReference param) {
		unit.getList(param)
	}
	
	override getObject() {
		unit.getObject
	}
	
	override getPrimitiveBoolean() {
		unit.primitiveBoolean
	}
	
	override getPrimitiveByte() {
		unit.primitiveByte
	}
	
	override getPrimitiveChar() {
		unit.primitiveChar
	}
	
	override getPrimitiveDouble() {
		unit.primitiveDouble
	}
	
	override getPrimitiveFloat() {
		unit.primitiveFloat
	}
	
	override getPrimitiveInt() {
		unit.primitiveInt
	}
	
	override getPrimitiveLong() {
		unit.primitiveLong
	}
	
	override getPrimitiveShort() {
		unit.primitiveShort
	}
	
	override getPrimitiveVoid() {
		unit.primitiveVoid
	}
	
	override getSet(TypeReference param) {
		unit.getSet(param)
	}
	
	override getString() {
		unit.string
	}
	
	override newArrayTypeReference(TypeReference componentType) {
		unit.newArrayTypeReference(componentType)
	}
	
	override newTypeReference(String typeName, TypeReference... typeArguments) {
		unit.newTypeReference(typeName, typeArguments)
	}
	
	override newTypeReference(Type typeDeclaration, TypeReference... typeArguments) {
		unit.newTypeReference(typeDeclaration, typeArguments)
	}
	
	override newWildcardTypeReference() {
		unit.newWildcardTypeReference
	}
	
	override newWildcardTypeReference(TypeReference upperBound) {
		unit.newWildcardTypeReference(upperBound)
	}
	
}

