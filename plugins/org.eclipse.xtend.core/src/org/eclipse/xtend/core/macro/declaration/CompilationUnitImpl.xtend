/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.macro.declaration

import java.util.Map
import javax.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations
import org.eclipse.xtend.core.macro.CompilationContextImpl
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendConstructor
import org.eclipse.xtend.core.xtend.XtendField
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtend.core.xtend.XtendMember
import org.eclipse.xtend.core.xtend.XtendPackage
import org.eclipse.xtend.core.xtend.XtendParameter
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.CompilationStrategy
import org.eclipse.xtend.lib.macro.declaration.CompilationUnit
import org.eclipse.xtend.lib.macro.declaration.Element
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration
import org.eclipse.xtend.lib.macro.declaration.PrimitiveType
import org.eclipse.xtend.lib.macro.declaration.Type
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration
import org.eclipse.xtend.lib.macro.declaration.TypeReference
import org.eclipse.xtend.lib.macro.declaration.Visibility
import org.eclipse.xtend.lib.macro.services.Problem
import org.eclipse.xtend.lib.macro.services.ProblemSupport
import org.eclipse.xtend.lib.macro.services.TypeReferenceProvider
import org.eclipse.xtext.common.types.JvmAnnotationType
import org.eclipse.xtext.common.types.JvmConstructor
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmEnumerationType
import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmPrimitiveType
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.JvmVoid
import org.eclipse.xtext.common.types.TypesPackage
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.validation.EObjectDiagnosticImpl
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.xbase.typesystem.legacy.StandardTypeReferenceOwner
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices

class CompilationUnitImpl implements CompilationUnit, TypeReferenceProvider, ProblemSupport {

	override getDocComment() {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}

	override getPackageName() {
		xtendFile.getPackage()
	}

	override getSourceTypeDeclarations() {
		xtendFile.xtendTypes.map[toXtendTypeDeclaration(it)]
	}

	override getSourceClassDeclarations() {
		sourceTypeDeclarations.filter(typeof(XtendClassDeclarationImpl)).toList
	}

	override getGeneratedTypeDeclarations() {
		xtendFile.eResource.contents.filter(typeof(JvmDeclaredType)).map[toTypeDeclaration(it) as MutableTypeDeclaration].
			toList
	}

	override getGeneratedClassDeclarations() {
		generatedTypeDeclarations.filter(typeof(MutableClassDeclaration)).toList
	}

	@Property XtendFile xtendFile
	@Inject CommonTypeComputationServices services;
	@Inject TypeReferences typeReferences
	@Inject JvmTypesBuilder typesBuilder
	@Inject TypeReferenceSerializer typeRefSerializer
	@Inject IXtendJvmAssociations associations
	
	Map<EObject, Object> identityCache = newHashMap
	OwnedConverter typeRefConverter

	def void setXtendFile(XtendFile xtendFile) {
		this._xtendFile = xtendFile
		this.typeRefConverter = new OwnedConverter(
			new StandardTypeReferenceOwner(services, xtendFile.eResource.resourceSet))
	}

	def private <IN extends EObject, OUT> OUT getOrCreate(IN in, (IN)=>OUT provider) {
		if (identityCache.containsKey(in))
			return identityCache.get(in) as OUT
		val result = provider.apply(in)
		identityCache.put(in, result)
		return result
	}

	def Visibility toVisibility(JvmVisibility delegate) {
		switch delegate {
			case JvmVisibility::DEFAULT: Visibility::DEFAULT
			case JvmVisibility::PRIVATE: Visibility::PRIVATE
			case JvmVisibility::PROTECTED: Visibility::PROTECTED
			case JvmVisibility::PUBLIC: Visibility::PUBLIC
		}
	}

	def Type toType(JvmType delegate) {
		getOrCreate(delegate) [
			switch delegate {
				JvmDeclaredType:
					toTypeDeclaration(delegate)
				JvmTypeParameter:
					toTypeParameterDeclaration(delegate)
				JvmVoid:
					new VoidTypeImpl => [
						it.delegate = delegate
						it.compilationUnit = this
					]
				JvmPrimitiveType:
					new PrimitiveTypeImpl => [
						it.delegate = delegate
						it.compilationUnit = this
					]
			}
		]}

	def TypeDeclaration toTypeDeclaration(JvmDeclaredType delegate) {
		getOrCreate(delegate) [
			switch delegate {
				JvmGenericType case delegate.isInterface:
					null
				//					new InterfaceDeclarationJavaImpl => [
				//						it.delegate = delegate 
				//						it.compilationUnit = this
				//					]
				JvmGenericType:
					new JvmClassDeclarationImpl => [
						it.delegate = delegate
						it.compilationUnit = this
					]
				JvmAnnotationType:
					null //TODO
				JvmEnumerationType:
					null //TODO
			}
		]}

	def TypeParameterDeclaration toTypeParameterDeclaration(JvmTypeParameter delegate) {
		getOrCreate(delegate) [
			new JvmTypeParameterDeclarationImpl => [
				it.delegate = delegate
				it.compilationUnit = this
			]
		]}

	def ParameterDeclaration toParameterDeclaration(JvmFormalParameter delegate) {
		getOrCreate(delegate) [
			new JvmParameterDeclarationImpl => [
				it.delegate = delegate
				it.compilationUnit = this
			]
		]}

	def MemberDeclaration toMemberDeclaration(JvmMember delegate) {
		getOrCreate(delegate) [
			switch delegate {
				JvmDeclaredType:
					toTypeDeclaration(delegate)
				JvmOperation: 
					// TODO handle annotation properties	
					new JvmMethodDeclarationImpl => [
						it.delegate = delegate
						it.compilationUnit = this
					]
				JvmConstructor:
					new JvmConstructorDeclarationImpl => [
						it.delegate = delegate
						it.compilationUnit = this
					]
				JvmField:
					new JvmFieldDeclarationImpl => [
						it.delegate = delegate
						it.compilationUnit = this
					]
			//TODO JvmEnumerationLiteral
			}
		]}

	def TypeReference toTypeReference(JvmTypeReference delegate) {

		/*
		 * Nested JvmTypeReference's identity will not be preserved
		 * i.e. given 'List<String> myField' we will get the same TypeReference instance when asking
		 * the field for its type. But when asking for type arguments on that TypeReference we will 
		 * get a new instance representing 'String' each time.
		 */
		if (delegate == null)
			return null
		getOrCreate(delegate) [
			toTypeReference(typeRefConverter.toLightweightReference(delegate))
		]}

	def TypeReference toTypeReference(LightweightTypeReference delegate) {
		if (delegate == null)
			return null
		new TypeReferenceImpl => [
			it.delegate = delegate
			it.compilationUnit = this
		]
	}

	def XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> toXtendTypeDeclaration(XtendTypeDeclaration delegate) {
		getOrCreate(delegate) [
			switch (delegate) {
				XtendClass:
					new XtendClassDeclarationImpl => [
						it.delegate = delegate
						it.compilationUnit = this
					]
			//TODO XtendAnnotationType 
			}
		]}

	def XtendMemberDeclarationImpl toXtendMemberDeclaration(XtendMember delegate) {
		getOrCreate(delegate) [
			switch (delegate) {
				XtendTypeDeclaration:
					toXtendTypeDeclaration(delegate)
				XtendFunction:
					new XtendMethodDeclarationImpl => [
						it.delegate = delegate
						it.compilationUnit = this
					]
				XtendConstructor:
					new XtendConstructorDeclarationImpl => [
						it.delegate = delegate
						it.compilationUnit = this
					]
				XtendField:
					new XtendFieldDeclarationImpl => [
						it.delegate = delegate
						it.compilationUnit = this
					]
			}
		]}

	def XtendParameterDeclarationImpl toXtendParameterDeclaration(XtendParameter delegate) {
		getOrCreate(delegate) [
			new XtendParameterDeclarationImpl => [
				it.delegate = delegate
				it.compilationUnit = this
			]
		]}

	def XtendTypeParameterDeclarationImpl toXtendTypeParameterDeclaration(JvmTypeParameter delegate) {
		getOrCreate(delegate) [
			new XtendTypeParameterDeclarationImpl => [
				it.delegate = delegate
				it.compilationUnit = this
			]
		]}

	override getAnyType() {
		toTypeReference(typeReferences.createAnyTypeReference(xtendFile))
	}
	
	override getList(TypeReference param) {
		newTypeReference("java.util.List", param)
	}
	
	override getObject() {
		toTypeReference(typeReferences.createTypeRef(typeReferences.findDeclaredType(typeof(Object), xtendFile)))
	}
	
	override getPrimitiveBoolean() {
		newTypeReference("boolean")
	}
	
	override getPrimitiveByte() {
		newTypeReference("byte")
	}
	
	override getPrimitiveChar() {
		newTypeReference("char")
	}
	
	override getPrimitiveDouble() {
		newTypeReference("double")
	}
	
	override getPrimitiveFloat() {
		newTypeReference("float")
	}
	
	override getPrimitiveInt() {
		newTypeReference("int")
	}
	
	override getPrimitiveLong() {
		newTypeReference("long")
	}
	
	override getPrimitiveShort() {
		newTypeReference("short")
	}
	
	override getPrimitiveVoid() {
		newTypeReference("void")
	}
	
	override getSet(TypeReference param) {
		newTypeReference("java.util.Set", param)
	}
	
	override getString() {
		newTypeReference("java.lang.String")
	}
	
	override newArrayTypeReference(TypeReference componentType) {
		toTypeReference(typeReferences.createArrayType(componentType.toJvmTypeReference))
	}
	
	override newTypeReference(String typeName, TypeReference... typeArguments) {
		val type = typeReferences.findDeclaredType(typeName, xtendFile)
		if (type == null)
			return null
		toTypeReference(typeReferences.createTypeRef(type, typeArguments.map[toJvmTypeReference] as JvmTypeReference[]))
	}
	
	override newTypeReference(Type typeDeclaration, TypeReference... typeArguments) {
		val type = switch typeDeclaration {
			JvmTypeDeclarationImpl<? extends JvmDeclaredType> : {
				typeDeclaration.delegate
			}
			XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> : {
				associations.getInferredType(typeDeclaration.delegate)
			}
			JvmTypeParameterDeclarationImpl : {
				typeDeclaration.delegate
			}
			PrimitiveTypeImpl : {
				return switch typeDeclaration.kind {
					case PrimitiveType$Kind::BOOLEAN : primitiveBoolean
					case PrimitiveType$Kind::BYTE : primitiveByte
					case PrimitiveType$Kind::CHAR : primitiveChar
					case PrimitiveType$Kind::DOUBLE : primitiveDouble
					case PrimitiveType$Kind::FLOAT : primitiveFloat
					case PrimitiveType$Kind::INT : primitiveInt
					case PrimitiveType$Kind::LONG : primitiveLong
					case PrimitiveType$Kind::SHORT : primitiveShort
				}
			}
			VoidTypeImpl : {
				return primitiveVoid
			}
			default : {
				throw new IllegalArgumentException("couln't construct type refernce for type "+typeDeclaration)
			}
		}
		
		if (type == null)
			return null
		toTypeReference(typeReferences.createTypeRef(type, typeArguments.map[toJvmTypeReference] as JvmTypeReference[]))
	}
	
	override newWildcardTypeReference() {
		newWildcardTypeReference(null);
	}
	
	override newWildcardTypeReference(TypeReference upperBound) {
		if (upperBound == null) {
			toTypeReference(typeReferences.wildCard())
		} else {
			toTypeReference(typeReferences.wildCardExtends(upperBound.toJvmTypeReference))
		}
	}
	
	def JvmTypeReference toJvmTypeReference(TypeReference typeRef) {
		return (typeRef as TypeReferenceImpl).lightWeightTypeReference.toJavaCompliantTypeReference
	}
	
	def void setCompilationStrategy(JvmExecutable executable, CompilationStrategy compilationStrategy) {
		typesBuilder.setBody(executable) [
			val context = new CompilationContextImpl(it, this, typeRefSerializer)
			it.append(compilationStrategy.compile(context))
		]
	}
	
	override addError(Element element, String message) {
		val resAndObj = getResourceAndEObject(element)
		resAndObj.key.errors.add(new EObjectDiagnosticImpl(Severity::ERROR, 'user.issue', message, resAndObj.value, getSignificantFeature(resAndObj.value), -1, null))
	}
	
	override addInfo(Element element, String message) {
//		val resAndObj = getResourceAndEObject(element)
//		resAndObj.key.errors.add(new EObjectDiagnosticImpl(Severity::INFO, 'user.issue', message, resAndObj.value, getSignificantFeature(resAndObj.value), -1, null))
	}
	
	override addWarning(Element element, String message) {
		val resAndObj = getResourceAndEObject(element)
		resAndObj.key.warnings.add(new EObjectDiagnosticImpl(Severity::WARNING, 'user.issue', message, resAndObj.value, getSignificantFeature(resAndObj.value), -1, null))
	}
	
	override getProblems(Element element) {
		val resAndObj = getResourceAndEObject(element)
		val resource = resAndObj.key
		val issues = (resource.errors + resource.warnings).filter(typeof(EObjectDiagnosticImpl))
		
		val result = issues.filter[diag | diag.problematicObject == resAndObj.value ].map[ diag |
			new ProblemImpl(diag.code, diag.message, translateSeverity(diag.severity)) as Problem
		]
		return result.toList
	}
	
	def EStructuralFeature getSignificantFeature(EObject obj) {
		return switch obj {
			XtendTypeDeclaration : XtendPackage::eINSTANCE.xtendTypeDeclaration_Name
			XtendField : XtendPackage::eINSTANCE.xtendField_Name
			XtendFunction : XtendPackage::eINSTANCE.xtendFunction_Name
			// FIXME: find something appropriate for constructors
			//XtendConstructor : XtendPackage::eINSTANCE.xtendConstructor_Name
			JvmFormalParameter : TypesPackage::eINSTANCE.jvmFormalParameter_Name
		}
	}
	
	def private getResourceAndEObject(Element element) {
		switch element {
			XtendNamedElementImpl<? extends EObject>: {
				val resource = element.delegate.eResource
				val eobject = element.delegate
				return resource -> eobject
			}
			JvmNamedElementImpl<JvmIdentifiableElement> : {
				val resource = element.delegate.eResource
				if (resource == xtendFile.eResource) {
					val eobject = associations.getPrimarySourceElement(element.delegate)
					return resource -> eobject
				}
			} 
		}
		throw new IllegalArgumentException("You can only add issues on locally declared elements.")
	}
	
	def private Problem$Severity translateSeverity(Severity severity) {
		switch (severity) {
			case Severity::ERROR : Problem$Severity::ERROR
			case Severity::WARNING : Problem$Severity::WARNING
			case Severity::INFO : Problem$Severity::INFO
			case Severity::IGNORE : Problem$Severity::IGNORE
		}
	}
}

class ProblemImpl implements Problem {
	
	String id
	String message
	Problem$Severity severity	
	
	new(String id,
	String message,
	Problem$Severity severity) {
		this.id = id
		this.message = message
		this.severity = severity
	}

	override getId() {
		return id
	}
	
	override getMessage() {
		return message
	}
	
	override getSeverity() {
		return severity
	}
	
}