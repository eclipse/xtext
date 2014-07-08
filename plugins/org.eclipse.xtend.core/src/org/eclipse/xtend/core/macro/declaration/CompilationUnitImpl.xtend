/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.macro.declaration

import com.google.common.collect.Iterables
import com.google.common.primitives.Booleans
import com.google.common.primitives.Bytes
import com.google.common.primitives.Chars
import com.google.common.primitives.Doubles
import com.google.common.primitives.Floats
import com.google.common.primitives.Ints
import com.google.common.primitives.Longs
import com.google.common.primitives.Shorts
import com.google.inject.Inject
import java.util.Collection
import java.util.List
import java.util.Map
import java.util.concurrent.CancellationException
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations
import org.eclipse.xtend.core.macro.CompilationContextImpl
import org.eclipse.xtend.core.macro.ConstantExpressionsInterpreter
import org.eclipse.xtend.core.xtend.XtendAnnotationType
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendConstructor
import org.eclipse.xtend.core.xtend.XtendEnum
import org.eclipse.xtend.core.xtend.XtendEnumLiteral
import org.eclipse.xtend.core.xtend.XtendField
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtend.core.xtend.XtendInterface
import org.eclipse.xtend.core.xtend.XtendMember
import org.eclipse.xtend.core.xtend.XtendParameter
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference
import org.eclipse.xtend.lib.macro.declaration.CompilationStrategy
import org.eclipse.xtend.lib.macro.declaration.CompilationUnit
import org.eclipse.xtend.lib.macro.declaration.EnumerationValueDeclaration
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration
import org.eclipse.xtend.lib.macro.declaration.NamedElement
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration
import org.eclipse.xtend.lib.macro.declaration.ResolvedConstructor
import org.eclipse.xtend.lib.macro.declaration.ResolvedMethod
import org.eclipse.xtend.lib.macro.declaration.Type
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration
import org.eclipse.xtend.lib.macro.declaration.TypeReference
import org.eclipse.xtend.lib.macro.declaration.Visibility
import org.eclipse.xtend.lib.macro.expression.Expression
import org.eclipse.xtend.lib.macro.file.FileLocations
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport
import org.eclipse.xtend.lib.macro.file.Path
import org.eclipse.xtend.lib.macro.services.AnnotationReferenceProvider
import org.eclipse.xtend.lib.macro.services.ProblemSupport
import org.eclipse.xtend.lib.macro.services.TypeReferenceProvider
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtext.common.types.JvmAnnotationAnnotationValue
import org.eclipse.xtext.common.types.JvmAnnotationReference
import org.eclipse.xtext.common.types.JvmAnnotationType
import org.eclipse.xtext.common.types.JvmAnnotationValue
import org.eclipse.xtext.common.types.JvmArrayType
import org.eclipse.xtext.common.types.JvmBooleanAnnotationValue
import org.eclipse.xtext.common.types.JvmByteAnnotationValue
import org.eclipse.xtext.common.types.JvmCharAnnotationValue
import org.eclipse.xtext.common.types.JvmConstructor
import org.eclipse.xtext.common.types.JvmCustomAnnotationValue
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmDoubleAnnotationValue
import org.eclipse.xtext.common.types.JvmEnumAnnotationValue
import org.eclipse.xtext.common.types.JvmEnumerationLiteral
import org.eclipse.xtext.common.types.JvmEnumerationType
import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmFloatAnnotationValue
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmIntAnnotationValue
import org.eclipse.xtext.common.types.JvmLongAnnotationValue
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmPrimitiveType
import org.eclipse.xtext.common.types.JvmShortAnnotationValue
import org.eclipse.xtext.common.types.JvmStringAnnotationValue
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.JvmTypeAnnotationValue
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.JvmVoid
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.documentation.IFileHeaderProvider
import org.eclipse.xtext.generator.FileSystemAccessQueue
import org.eclipse.xtext.resource.CompilerPhases
import org.eclipse.xtext.util.Strings
import org.eclipse.xtext.validation.EObjectDiagnosticImpl
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XListLiteral
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation
import org.eclipse.xtext.xbase.file.AbstractFileSystemSupport
import org.eclipse.xtext.xbase.file.ParallelFileSystemSupport
import org.eclipse.xtext.xbase.interpreter.ConstantExpressionEvaluationException
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeExtensions
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.xbase.typesystem.legacy.StandardTypeReferenceOwner
import org.eclipse.xtext.xbase.typesystem.^override.IResolvedConstructor
import org.eclipse.xtext.xbase.typesystem.^override.IResolvedOperation
import org.eclipse.xtext.xbase.typesystem.^override.OverrideHelper
import org.eclipse.xtext.xbase.typesystem.references.IndexingOwnedConverter
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices
import org.eclipse.xtext.xbase.validation.ReadAndWriteTracking
import org.eclipse.xtext.xtype.impl.XComputedTypeReferenceImplCustom
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociator

class CompilationUnitImpl implements CompilationUnit {
	
	override getAnnotations() {
		emptyList
	}
	
	override findAnnotation(Type annotationType) {
		null
	}
	
	override getSimpleName() {
		xtendFile.eResource.URI.lastSegment.toString
	}
	
	override getCompilationUnit() {
		this
	}

	override getDocComment() {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}

	override getPackageName() {
		xtendFile.getPackage()
	}

	override getSourceTypeDeclarations() {
		xtendFile.xtendTypes.map[toXtendTypeDeclaration(it)]
	}

	boolean canceled = false
	
	def setCanceled(boolean canceled) {
		this.canceled = canceled
	}
	
	def checkCanceled() {
		if (canceled)
			throw new CancellationException("compilation was canceled.")
	}
	
	@Inject TypesFactory typesFactory
	
	@Inject CompilerPhases compilerPhases;

	@Property XtendFile xtendFile
	@Property boolean modifyAllowed = true
	@Inject CommonTypeComputationServices services;
	@Inject TypeReferences typeReferences
	@Inject JvmTypesBuilder typesBuilder
	@Inject IXtendJvmAssociations associations
	@Inject IJvmModelAssociator jvmAssociator
	@Inject ConstantExpressionsInterpreter interpreter
	@Inject IEObjectDocumentationProvider documentationProvider
	@Inject IFileHeaderProvider fileHeaderProvider
	@Inject JvmTypeExtensions typeExtensions
	@Inject OverrideHelper overrideHelper

	@Inject AbstractFileSystemSupport fileSystemSupport
	@Inject FileLocations fileLocations
	@Inject ReadAndWriteTracking readAndWriteTracking
	
	@Property val ProblemSupport problemSupport= new ProblemSupportImpl(this)
	@Property val TypeReferenceProvider typeReferenceProvider = new TypeReferenceProviderImpl(this)
	@Property val AnnotationReferenceProvider annotationReferenceProvider = new AnnotationReferenceProviderImpl(this)
	@Property val TypeLookupImpl typeLookup = new TypeLookupImpl(this)
	@Property val TracabilityImpl tracability = new TracabilityImpl(this)
	@Property val AssociatorImpl associator = new AssociatorImpl(this)
	
	Map<Object, Object> identityCache = newHashMap
	OwnedConverter typeRefConverter
	
	def IXtendJvmAssociations getJvmAssociations() {
		return associations
	}
	
	def IJvmModelAssociator getJvmAssociator() {
		return jvmAssociator
	}
	
	def TypeReferences getTypeReferences() {
		typeReferences
	}
	
	def OverrideHelper getOverrideHelper() {
		overrideHelper
	}
	def IEObjectDocumentationProvider getDocumentationProvider() {
		documentationProvider
	}
	
	def getFileHeaderProvider() {
		fileHeaderProvider
	}
	
	def getJvmTypesBuilder() {
		typesBuilder
	}
	
	def getTypeExtensions() {
		typeExtensions
	}
	
	ParallelFileSystemSupport parallelFileSystemSupport
	
	def MutableFileSystemSupport getFileSystemSupport() {
		if (parallelFileSystemSupport == null) {
			val fileSystemAccessQueue = xtendFile.eResource.resourceSet.eAdapters.filter(FileSystemAccessQueue).head
			if (fileSystemAccessQueue == null) {
				return fileSystemSupport
			}
			parallelFileSystemSupport = new ParallelFileSystemSupport(xtendFile.eResource.URI, fileSystemSupport, fileSystemAccessQueue)
		}
		parallelFileSystemSupport
	}
	
	def FileLocations getFileLocations() {
		fileLocations
	}
	
	def ReadAndWriteTracking getReadAndWriteTracking() {
		return readAndWriteTracking;
	}
	
	override Path getFilePath() {
		return fileSystemSupport.getPath(xtendFile.eResource)
	}
	
	def void setXtendFile(XtendFile xtendFile) {
		this._xtendFile = xtendFile
		val standardTypeReferenceOwner = new StandardTypeReferenceOwner(services, xtendFile.eResource.resourceSet)
		if (indexing) {
			this.typeRefConverter = new IndexingOwnedConverter(standardTypeReferenceOwner)	
		} else {
			this.typeRefConverter = new OwnedConverter(standardTypeReferenceOwner)
		}
	}
	
	def getTypeRefConverter() {
		typeRefConverter
	}
	
	def isIndexing() {
		compilerPhases.isIndexing(xtendFile)
	}

	def private <IN, OUT> OUT getOrCreate(IN in, (IN)=>OUT provider) {
		checkCanceled
		if (in == null)
			return null
		if (identityCache.containsKey(in))
			return identityCache.get(in) as OUT
		val result = provider.apply(in)
		identityCache.put(in, result)
		return result
	}

	def Visibility toVisibility(JvmVisibility delegate) {
		switch delegate {
			case JvmVisibility.DEFAULT: Visibility.DEFAULT
			case JvmVisibility.PRIVATE: Visibility.PRIVATE
			case JvmVisibility.PROTECTED: Visibility.PROTECTED
			case JvmVisibility.PUBLIC: Visibility.PUBLIC
		}
	}
	
	def ResolvedMethod toResolvedMethod(IResolvedOperation delegate) {
		getOrCreate(delegate) [
			new ResolvedMethodImpl => [
				it.delegate = delegate
				compilationUnit = this
			]
		]
	}
	
	def ResolvedConstructor toResolvedConstructor(IResolvedConstructor delegate) {
		getOrCreate[
			new ResolvedConstructorImpl => [
				it.delegate = delegate
				compilationUnit = this
			]
		]
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
					if (delegate.belongedToCompilationUnit && modifyAllowed) {
						new MutableJvmInterfaceDeclarationImpl => [
							it.delegate = delegate 
							it.compilationUnit = this
						]
					} else {
						new JvmInterfaceDeclarationImpl => [
							it.delegate = delegate 
							it.compilationUnit = this
						]
					}
				JvmGenericType:
					if (delegate.belongedToCompilationUnit && modifyAllowed) {
						new MutableJvmClassDeclarationImpl => [
							it.delegate = delegate
							it.compilationUnit = this
						]
					} else {
						new JvmClassDeclarationImpl => [
							it.delegate = delegate
							it.compilationUnit = this
						]
					}
				JvmAnnotationType:
					if (delegate.belongedToCompilationUnit && modifyAllowed) {
						new MutableJvmAnnotationTypeDeclarationImpl => [
							it.delegate = delegate
							it.compilationUnit = this
						]
					} else {
						new JvmAnnotationTypeDeclarationImpl => [
							it.delegate = delegate
							it.compilationUnit = this
						]
					}
				JvmEnumerationType:
					if (delegate.belongedToCompilationUnit && modifyAllowed) {
						new MutableJvmEnumerationTypeDeclarationImpl => [
							it.delegate = delegate
							it.compilationUnit = this
						]
					} else {
						new JvmEnumerationTypeDeclarationImpl => [
							it.delegate = delegate
							it.compilationUnit = this
						]
					}
			} as TypeDeclaration
		]}

	def TypeParameterDeclaration toTypeParameterDeclaration(JvmTypeParameter delegate) {
		getOrCreate(delegate) [
			if (delegate.belongedToCompilationUnit && modifyAllowed) {
				new MutableJvmTypeParameterDeclarationImpl => [
					it.delegate = delegate
					it.compilationUnit = this
				]
			} else {
				new JvmTypeParameterDeclarationImpl => [
					it.delegate = delegate
					it.compilationUnit = this
				]
			}
		]}

	def ParameterDeclaration toParameterDeclaration(JvmFormalParameter delegate) {
		getOrCreate(delegate) [
			if (delegate.belongedToCompilationUnit && modifyAllowed) {
				new MutableJvmParameterDeclarationImpl => [
					it.delegate = delegate
					it.compilationUnit = this
				]
			} else {
				new JvmParameterDeclarationImpl => [
					it.delegate = delegate
					it.compilationUnit = this
				]
			}
		]}

	def MemberDeclaration toMemberDeclaration(JvmMember delegate) {
		getOrCreate(delegate) [
			switch delegate {
				JvmDeclaredType:
					toTypeDeclaration(delegate)
				JvmOperation: {
					if (delegate.declaringType instanceof JvmAnnotationType) {
						if (delegate.belongedToCompilationUnit && modifyAllowed) {
							new MutableJvmAnnotationTypeElementDeclarationImpl => [
								it.delegate = delegate
								it.compilationUnit = this
							]
						} else {
							new JvmAnnotationTypeElementDeclarationImpl => [
								it.delegate = delegate
								it.compilationUnit = this
							]
						}
					} else {
						if (delegate.belongedToCompilationUnit && modifyAllowed) {
							new MutableJvmMethodDeclarationImpl => [
								it.delegate = delegate
								it.compilationUnit = this
							]
						} else {
							new JvmMethodDeclarationImpl => [
								it.delegate = delegate
								it.compilationUnit = this
							]
						}
					} as MemberDeclaration
				} 
				JvmConstructor:
					if (delegate.belongedToCompilationUnit && modifyAllowed) {
						new MutableJvmConstructorDeclarationImpl => [
							it.delegate = delegate
							it.compilationUnit = this
						]
					} else {
						new JvmConstructorDeclarationImpl => [
							it.delegate = delegate
							it.compilationUnit = this
						]
					}
				JvmEnumerationLiteral:
					if (delegate.belongedToCompilationUnit && modifyAllowed) {
						new MutableJvmEnumerationValueDeclarationImpl => [
							it.delegate = delegate
							it.compilationUnit = this		
						]
					} else {
						new JvmEnumerationValueDeclarationImpl => [
							it.delegate = delegate
							it.compilationUnit = this		
						]
					}
				JvmField:
					if (delegate.belongedToCompilationUnit && modifyAllowed) {
						new MutableJvmFieldDeclarationImpl => [
							it.delegate = delegate
							it.compilationUnit = this
						]
					} else {
						new JvmFieldDeclarationImpl => [
							it.delegate = delegate
							it.compilationUnit = this
						]
					}
			}
		]}
	
	def isBelongedToCompilationUnit(EObject element) {
		element.eResource == xtendFile.eResource
	}
	
	def NamedElement toNamedElement(JvmIdentifiableElement delegate) {
		getOrCreate(delegate) [
			switch delegate {
				JvmMember : toMemberDeclaration(delegate)
				JvmTypeParameter : toTypeParameterDeclaration(delegate)
				JvmFormalParameter : toParameterDeclaration(delegate)
				default : throw new UnsupportedOperationException("Couldn't translate '"+delegate)
			}
		]
	}

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
			switch delegate {
				XComputedTypeReferenceImplCustom case !delegate.isEquivalentComputed: {
					new InferredTypeReferenceImpl => [
						it.delegate = delegate
						compilationUnit = this
					]
				}
				default : toTypeReference(typeRefConverter.toLightweightReference(delegate))
			}
		]
	}

	def TypeReference toTypeReference(LightweightTypeReference delegate) {
		checkCanceled
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
				XtendInterface:
					new XtendInterfaceDeclarationImpl => [
						it.delegate = delegate
						it.compilationUnit = this
					]
				XtendAnnotationType:
					new XtendAnnotationTypeDeclarationImpl => [
						it.delegate = delegate
						it.compilationUnit = this
					]
				XtendEnum:
					new XtendEnumerationDeclarationImpl => [
						it.delegate = delegate
						it.compilationUnit = this
					]
			}
		]}

	def MemberDeclaration toXtendMemberDeclaration(XtendMember delegate) {
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
				XtendField: {
					if (delegate.eContainer instanceof XtendAnnotationType) {
						new XtendAnnotationTypeElementDeclarationImpl => [
							it.delegate = delegate
							it.compilationUnit = this
						]
					} else {	
						new XtendFieldDeclarationImpl => [
							it.delegate = delegate
							it.compilationUnit = this
						]
					}
				}
				XtendEnumLiteral:
					new XtendEnumerationValueDeclarationImpl => [
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
	
	def JvmTypeReference toJvmTypeReference(TypeReference typeRef) {
		checkCanceled
		return switch typeRef {
			TypeReferenceImpl : typeRef.lightWeightTypeReference.toJavaCompliantTypeReference
			InferredTypeReferenceImpl : EcoreUtil.copy(typeRef.delegate)
		}
	}
	
	def LightweightTypeReference toLightweightTypeReference(TypeReference typeRef) {
		checkCanceled
		return switch typeRef {
			TypeReferenceImpl : typeRef.lightWeightTypeReference
			InferredTypeReferenceImpl : typeRef.lightweightTypeReference
		}
	}
	
	def Expression toExpression(XExpression delegate) {
		getOrCreate(delegate) [
			new ExpressionImpl => [
				it.delegate = delegate
				it.compilationUnit = this
			]
		]
	}
	
	def void setCompilationStrategy(JvmExecutable executable, CompilationStrategy compilationStrategy) {
		checkCanceled
		typesBuilder.setBody(executable) [
			val context = new CompilationContextImpl(it, this)
			it.append(compilationStrategy.compile(context).trimTrailingLinebreak(executable))
		]
	}
	
	def void setCompilationTemplate(JvmExecutable executable, StringConcatenationClient compilationTemplate) {
		checkCanceled
		typesBuilder.setBody(executable, compilationTemplate)
	}
	
	protected def trimTrailingLinebreak(CharSequence sequence, EObject context) {
		Strings.trimTrailingLineBreak(sequence)
	} 
	
	def void setCompilationStrategy(JvmField field, CompilationStrategy compilationStrategy) {
		checkCanceled
		typesBuilder.setInitializer(field) [
			val context = new CompilationContextImpl(it, this)
			it.append(compilationStrategy.compile(context))
		]
	}
	
	def void setCompilationTemplate(JvmField field, StringConcatenationClient compilationTemplate) {
		checkCanceled
		typesBuilder.setInitializer(field, compilationTemplate)
	}
	
	def AnnotationReference toAnnotationReference(XAnnotation delegate) {
		getOrCreate(delegate) [
			new XtendAnnotationReferenceImpl => [
				it.delegate = delegate
				it.compilationUnit = this
			]
		]
	}
	
	def AnnotationReference toAnnotationReference(JvmAnnotationReference delegate) {
		getOrCreate(delegate) [
			new JvmAnnotationReferenceImpl => [
				it.delegate = delegate
				it.compilationUnit = this
			]
		]
	}
	
	def Object translateAnnotationValue(XExpression expression, JvmTypeReference expectedType, boolean isArray) {
		val value = evaluate(expression, expectedType)
		translateAnnotationValue(value, expectedType, isArray)
	}
	
	def Object translateAnnotationValue(JvmAnnotationValue value, boolean isArray) {
		val Pair<List<?>, Class<?>> result = switch value {
			JvmCustomAnnotationValue case value.values.empty && isArray: {
				emptyList -> findExpectedType(value).toArrayComponentType
			}
			JvmCustomAnnotationValue : {
				// custom values always contain a single expression and will already return an array if it's a multi value.
				val expectedType = findExpectedType(value)
				val result = value.values.filter(XExpression).map[evaluate(it, expectedType)].head
				return translateAnnotationValue(result, expectedType, isArray)
			}
			JvmTypeAnnotationValue : value.values.map[toTypeReference(it)] -> TypeReference 
			JvmAnnotationAnnotationValue : value.values.map[toAnnotationReference(it)] -> AnnotationReference   
			JvmStringAnnotationValue : value.values -> String
			JvmBooleanAnnotationValue : value.values -> boolean
			JvmIntAnnotationValue : value.values  -> int
			JvmByteAnnotationValue : value.values -> byte
			JvmCharAnnotationValue : value.values -> char
			JvmDoubleAnnotationValue : value.values -> double
			JvmEnumAnnotationValue : value.values.map[toNamedElement(it)] -> EnumerationValueDeclaration
			JvmFloatAnnotationValue : value.values -> float
			JvmLongAnnotationValue : value.values -> long
			JvmShortAnnotationValue : value.values -> short
			default : emptyList -> Object
		}
		if (isArray) {
			return toArrayOfType(result.key, result.value)
		} else {
			return result.key.head
		}
	}
	
	protected def translateAnnotationValue(Object value, JvmTypeReference expectedType, boolean isArray) {
		if (value == null) {
			return null
		}
		if (!isArray || value.class.array) { 
			return value
		}
		toArrayOfType(newArrayList(value), expectedType.toArrayComponentType)
	}
	
	protected def toArrayComponentType(JvmTypeReference valueExpectedType) {
		val expectedType = valueExpectedType.type as JvmArrayType
		val componentType = expectedType.componentType
		val componentTypeName = componentType.identifier
		switch(componentTypeName) {
			case 'java.lang.Class': TypeReference
			case 'java.lang.String': String
			case 'boolean': boolean
			case 'int': int
			case 'byte': byte
			case 'char': char
			case 'double': double
			case 'float': float
			case 'long': long
			case 'short': short
			default:
				switch(componentType) {
					JvmEnumerationType: EnumerationValueDeclaration
					JvmAnnotationType: AnnotationReference
					default: Object
				}
		}
	}
	
	protected def findExpectedType(JvmAnnotationValue value) {
		if (value.operation != null) {
			return value.operation.returnType
		}
		return switch container : value.eContainer {
			JvmOperation : {
				container.returnType
			}
			JvmAnnotationReference : {
				val defaultOp = container.annotation.findAllFeaturesByName('value').filter(JvmOperation).head
				if (defaultOp != null) {
					defaultOp.returnType
				}
			}
		}
	}
	
	private def Object toArrayOfType(Iterable<?> iterable, Class<?> componentType) {
		val Collection<?> collection = if (iterable instanceof Collection<?>) iterable else iterable.toList
		return switch componentType {
			case int : Ints.toArray(collection as List<Integer>)
			case long : Longs.toArray(collection as List<Long>)
			case char : Chars.toArray(collection as List<Character>)
			case boolean : Booleans.toArray(collection as List<Boolean>)
			case byte : Bytes.toArray(collection as List<Byte>)
			case short : Shorts.toArray(collection as List<Short>)
			case float : Floats.toArray(collection as List<Float>)
			case double : Doubles.toArray(collection as List<Double>)
			default : Iterables.toArray(collection, componentType as Class<Object>) 
		}
	}
	
	def Object evaluate(XExpression expression, JvmTypeReference expectedType) {
		try {
			val result = interpreter.evaluate(expression, expectedType)
			return translate(result)
		} catch (ConstantExpressionEvaluationException e) {
			val error = new EObjectDiagnosticImpl(Severity.ERROR, 'constant_expression_evaluation_problem', e.message, expression, null, -1, null)
			expression.eResource.errors.add(error)
			return null
		}
	}
	
	protected def Object translate(Object object) {
		if (object instanceof XAnnotation[]) {
			val AnnotationReference[] result = newArrayOfSize(object.length)
			for (i : 0..<object.length) {
				result.set(i, object.get(i).translateAnnotation)
			}
			return result
		}
		if (object instanceof XAnnotation) {
			return object.translateAnnotation
		}
		if (object instanceof JvmTypeReference[]) {
			val TypeReference[] result = newArrayOfSize(object.length)
			for (i : 0..<object.length) {
				result.set(i, translate(object.get(i)) as TypeReference)
			}
			return result
		}
		if (object instanceof JvmTypeReference) {
			return toTypeReference(object)
		}
		if (object instanceof JvmEnumerationLiteral[]) {
			val EnumerationValueDeclaration[] result = newArrayOfSize(object.length)
			for (i : 0..<object.length) {
				result.set(i, translate(object.get(i)) as EnumerationValueDeclaration)
			}
			return result
		}
		if (object instanceof JvmEnumerationLiteral) {
			return toMemberDeclaration(object)
		}
		return object
	}
	
	protected def translateAnnotation(XAnnotation annotation) {
		val buildContext = new AnnotationReferenceBuildContextImpl => [
			compilationUnit = this
			delegate = typesFactory.createJvmAnnotationReference => [ reference |
				reference.annotation = annotation.annotationType as JvmAnnotationType
			]
		]
		for (valuePair : annotation.elementValuePairs) {
			val value = valuePair.value
			if (value != null) {
				val operation = valuePair.element
				val annotationValue = value.translateAnnotationValue(operation.returnType)
				buildContext.set(operation.simpleName, annotationValue)
			}
		}
		if (annotation.value != null) {
			val annotationValue = annotation.value.translateAnnotationValue(null)
			buildContext.set('value', annotationValue)
		}
		buildContext.delegate.toAnnotationReference
	} 
	
	protected def Object translateAnnotationValue(XExpression value, JvmTypeReference expectedType) {
		if (value instanceof XAnnotation) {
			return value.translateAnnotation
		}
		if (value instanceof XListLiteral) {
			val annotations = value.elements.filter(XAnnotation)
			if (value.elements.size == annotations.size) {
				val annotationReferences = newArrayList
				for (annotation : annotations) {
					annotationReferences += annotation.translateAnnotation
				}
				return annotationReferences
			}
		}
		value.evaluate(expectedType).translate
	}
	
}