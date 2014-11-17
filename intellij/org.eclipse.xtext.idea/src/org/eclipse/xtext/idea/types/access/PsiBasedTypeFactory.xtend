package org.eclipse.xtext.idea.types.access

import com.google.inject.Inject
import com.intellij.openapi.progress.ProgressIndicatorProvider
import com.intellij.openapi.project.Project
import com.intellij.psi.JavaPsiFacade
import com.intellij.psi.PsiAnnotation
import com.intellij.psi.PsiAnnotationMemberValue
import com.intellij.psi.PsiAnnotationMethod
import com.intellij.psi.PsiAnonymousClass
import com.intellij.psi.PsiArrayInitializerMemberValue
import com.intellij.psi.PsiArrayType
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiClassObjectAccessExpression
import com.intellij.psi.PsiClassType
import com.intellij.psi.PsiClassType.ClassResolveResult
import com.intellij.psi.PsiEnumConstant
import com.intellij.psi.PsiField
import com.intellij.psi.PsiJavaFile
import com.intellij.psi.PsiMethod
import com.intellij.psi.PsiModifier
import com.intellij.psi.PsiModifierListOwner
import com.intellij.psi.PsiParameter
import com.intellij.psi.PsiPrimitiveType
import com.intellij.psi.PsiReferenceExpression
import com.intellij.psi.PsiType
import com.intellij.psi.PsiTypeParameter
import com.intellij.psi.PsiTypeParameterListOwner
import com.intellij.psi.PsiWildcardType
import java.util.Map
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.ecore.util.InternalEList
import org.eclipse.xtext.common.types.JvmAnnotationAnnotationValue
import org.eclipse.xtext.common.types.JvmAnnotationReference
import org.eclipse.xtext.common.types.JvmAnnotationTarget
import org.eclipse.xtext.common.types.JvmAnnotationType
import org.eclipse.xtext.common.types.JvmAnnotationValue
import org.eclipse.xtext.common.types.JvmBooleanAnnotationValue
import org.eclipse.xtext.common.types.JvmByteAnnotationValue
import org.eclipse.xtext.common.types.JvmCharAnnotationValue
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmDoubleAnnotationValue
import org.eclipse.xtext.common.types.JvmEnumAnnotationValue
import org.eclipse.xtext.common.types.JvmEnumerationLiteral
import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.common.types.JvmFloatAnnotationValue
import org.eclipse.xtext.common.types.JvmIntAnnotationValue
import org.eclipse.xtext.common.types.JvmLongAnnotationValue
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference
import org.eclipse.xtext.common.types.JvmShortAnnotationValue
import org.eclipse.xtext.common.types.JvmStringAnnotationValue
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.JvmTypeAnnotationValue
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.common.types.access.impl.ITypeFactory
import org.eclipse.xtext.common.types.impl.JvmTypeConstraintImplCustom
import org.eclipse.xtext.psi.IPsiModelAssociator
import org.eclipse.xtext.util.internal.Stopwatches

class PsiBasedTypeFactory implements ITypeFactory<PsiClass, JvmDeclaredType> {

	val final createTypeTask = Stopwatches.forTask("PsiClassFactory.createType")

	val Map<PsiType, JvmType> typeProxies

	val Map<PsiMethod, JvmOperation> operationProxies

	val Map<PsiType, JvmAnnotationType> annotationProxies
	
	val Map<PsiEnumConstant, JvmEnumerationLiteral> enumerationLiteralProxies

	val extension TypesFactory = TypesFactory.eINSTANCE

	val extension StubURIHelper uriHelper
	
	val extension IPsiModelAssociator psiModelAssociator

	@Inject
	new(StubURIHelper uriHelper, IPsiModelAssociator psiModelAssociator) {
		this.uriHelper = uriHelper
		this.typeProxies = newHashMap
		this.operationProxies = newHashMap
		this.annotationProxies = newHashMap
		this.enumerationLiteralProxies = newHashMap
		this.psiModelAssociator = psiModelAssociator
	}

	override createType(PsiClass psiClass) {
		try {
			createTypeTask.start
			val fqn = new StringBuilder(100)
			val packageName = psiClass.packageName
			if (packageName != null) {
				fqn.append(packageName).append('.')
			}
			val type = psiClass.createType(fqn)
			type.packageName = packageName
			type
		} finally {
			createTypeTask.stop
		}
	}

	protected def JvmDeclaredType createType(PsiClass psiClass, StringBuilder fqn) {
		ProgressIndicatorProvider.checkCanceled
		if (psiClass.anonymous || psiClass.synthetic) {
			throw new IllegalStateException("Cannot create type for anonymous or synthetic classes")
		}
		switch psiClass {
			case psiClass.annotationType:
				createJvmAnnotationType
			case psiClass.enum:
				createJvmEnumerationType
			default:
				createJvmGenericType => [
					interface = psiClass.interface
					strictFloatingPoint = psiClass.modifierList.hasModifierProperty(PsiModifier.STRICTFP)
					createTypeParameters(psiClass)
				]
		} => [
			ProgressIndicatorProvider.checkCanceled
			setTypeModifiers(psiClass)
			setVisibility(psiClass)
			deprecated = psiClass.deprecated
			simpleName = psiClass.name
			fqn.append(psiClass.name)
			internalSetIdentifier(fqn.toString)
			fqn.append('$') [ |
				createNestedTypes(psiClass, fqn)
			]
			fqn.append('.')
			createMethods(psiClass, fqn)
			if (!psiClass.annotationType) {
				createFields(psiClass, fqn)
			}
			createSuperTypes(psiClass)
			createAnnotationValues(psiClass)
			associate[|psiClass]
		]
	}

	protected def createAnnotationValues(JvmAnnotationTarget it, PsiModifierListOwner psiModifierListOwner) {
		val modifierList = psiModifierListOwner.modifierList
		for (annotation : modifierList.annotations) {
			val annotationReference = annotation.createAnnotationReference
			if (annotationReference != null) { 
				annotations.addUnique(annotationReference)
			}
		}
	}

	protected def JvmAnnotationReference createAnnotationReference(PsiAnnotation annotation) {
		val project = annotation.project
		val type = project.psiElementFactory.createTypeByFQClassName(annotation.qualifiedName)
		val psiClass = type.resolve
		if (psiClass == null) {
			return null	
		}
		createJvmAnnotationReference => [
			it.annotation = type.craeteAnnotationProxy
			for (attribute : annotation.parameterList.attributes) {
				val attributeName = attribute.name ?: 'value'
				val value = attribute.value.computeAnnotationValue(project)
				val method = psiClass.methods.findFirst[name == attributeName]
				val annotationValue = value.createAnnotationValue(method)
				annotationValue.operation = method.createMethodProxy
				explicitValues.addUnique(annotationValue)
			}
		]
	}

	protected def createMethodProxy(PsiMethod method) {
		operationProxies.get(method) ?: createJvmOperation => [
			val uri = method.fullURI
			if (it instanceof InternalEObject) {
				eSetProxyURI(uri)
			}
			operationProxies.put(method, it)
		]
	}
	
	protected def JvmEnumerationLiteral createEnumLiteralProxy(PsiEnumConstant constant) {
		enumerationLiteralProxies.get(constant) ?: createJvmEnumerationLiteral => [
			val uri = constant.fullURI
			if (it instanceof InternalEObject) {
				eSetProxyURI(uri)
			}
			enumerationLiteralProxies.put(constant, it)
		]
	}

	protected def craeteAnnotationProxy(PsiType annotationType) {
		annotationProxies.get(annotationType) ?: createJvmAnnotationType => [
			val uri = annotationType.fullURI
			if (it instanceof InternalEObject) {
				eSetProxyURI(uri)
			}
			annotationProxies.put(annotationType, it)
		]
	}

	protected def createFields(JvmDeclaredType it, PsiClass psiClass, StringBuilder fqn) {
		for (field : psiClass.fields) {
			fqn.preserve [ |
				members.addUnique(field.createField(fqn))
			]
		}
	}

	protected def Object createField(PsiField field, StringBuilder fqn) {
		ProgressIndicatorProvider.checkCanceled
		switch field {
			PsiEnumConstant:
				createJvmEnumerationLiteral
			default:
				createJvmField => [
					val value = field.computeConstantValue
					if (value != null) {
						constant = true
						constantValue = value
					} else {
						constant = false
					}
				]
		} => [
			internalSetIdentifier(fqn.append(field.name).toString)
			simpleName = field.name
			final = field.hasModifierProperty(PsiModifier.FINAL)
			static = field.hasModifierProperty(PsiModifier.STATIC)
			transient = field.hasModifierProperty(PsiModifier.TRANSIENT)
			volatile = field.hasModifierProperty(PsiModifier.VOLATILE)
			deprecated = field.deprecated
			setVisibility(field)
			type = field.type.createTypeReference
			createAnnotationValues(field)
			associate[|field]
		]
	}

	protected def createSuperTypes(JvmDeclaredType it, PsiClass psiClass) {
		for (superType : psiClass.superTypes) {
			superTypes.addUnique(superType.createTypeReference)
		}
	}

	protected def createMethods(JvmDeclaredType it, PsiClass psiClass, StringBuilder fqn) {
		for (method : psiClass.methods) {
			fqn.preserve [ |
				val operation = if (method.constructor) {
						method.createConstructor(fqn)
					} else {
						method.createOperation(fqn) => [
							setDefaultValue(method)
						]
					}
				members.addUnique(operation)
			]
		}
		if (psiClass.hasDefaultConstructor) {
			fqn.preserve [ |
				members.addUnique(psiClass.createDefaultConstructor(fqn))
			]
		}
		if (psiClass.enum) {
			fqn.preserve [ |
				members.addUnique(psiClass.createValuesOperation(fqn))
			]
			fqn.preserve [ |
				members.addUnique(psiClass.createValueOfOperation(fqn))
			]
		}
	}

	protected def hasDefaultConstructor(PsiClass psiClass) {
		!psiClass.interface && !psiClass.annotationType && !psiClass.methods.exists[constructor]
	}

	protected def setDefaultValue(JvmOperation operation, PsiMethod method) {
		if (method instanceof PsiAnnotationMethod) {
			val defaultValue = method.defaultValue.computeAnnotationValue(method.project)
			if (defaultValue != null) {
				val annotationValue = defaultValue.createAnnotationValue(method)
				operation.defaultValue = annotationValue
				annotationValue.operation = operation
			}
		}
	}

	protected def createAnnotationValue(Object value, PsiMethod method) {
		val returnType = method.returnType
		if (returnType.array)
			createArrayAnnotationValue(value, returnType)
		else
			createAnnotationValue(value, returnType)
	}

	protected def createAnnotationValue(Object value, PsiType type) {
		type.createAnnotationValue => [
			addValue(value)
		]
	}

	protected def createArrayAnnotationValue(Object value, PsiType type) {
		if (type instanceof PsiArrayType) {
			val componentType = type.componentType
			return componentType.createAnnotationValue => [
				if (value instanceof Object[]) {
					for (Object element : value as Object[]) {
						addValue(element)
					}
				} else {
					addValue(value)
				}
			]
		}
		throw new IllegalArgumentException("type is not an array type: " + type.canonicalText)
	}

	protected def addValue(JvmAnnotationValue it, Object value) {
		switch it {
			JvmBooleanAnnotationValue:
				values.addUnique(value as Boolean)
			JvmIntAnnotationValue:
				values.addUnique(value.asInteger)
			JvmLongAnnotationValue:
				values.addUnique(value.asLong)
			JvmShortAnnotationValue:
				values.addUnique(value.asShort)
			JvmFloatAnnotationValue:
				values.addUnique(value.asFloat)
			JvmDoubleAnnotationValue:
				values.addUnique(value.asDouble)
			JvmCharAnnotationValue:
				values.addUnique(value.asCharacter)
			JvmByteAnnotationValue:
				values.addUnique(value.asByte)
			JvmStringAnnotationValue:
				values.addUnique(value as String)
			JvmTypeAnnotationValue:
				values.addUnique((value as PsiType).createTypeReference)
			JvmAnnotationAnnotationValue:
				values.addUnique((value as PsiAnnotation).createAnnotationReference)
			JvmEnumAnnotationValue:
				values.addUnique((value as PsiEnumConstant).createEnumLiteralProxy)
		}
	}

	protected def asInteger(Object value) {
		switch value {
			Integer: value
			Number: value.intValue
			default: value as Integer
		}
	}

	protected def asLong(Object value) {
		switch value {
			Long: value
			Number: value.longValue
			default: value as Long
		}
	}

	protected def asShort(Object value) {
		switch value {
			Short: value
			Number: value.shortValue
			default: value as Short
		}
	}

	protected def asFloat(Object value) {
		switch value {
			Float: value
			Number: value.floatValue
			default: value as Float
		}
	}

	protected def asDouble(Object value) {
		switch value {
			Double: value
			Number: value.doubleValue
			default: value as Double
		}
	}

	protected def asCharacter(Object value) {
		switch value {
			Character: value
			Number: value.byteValue as char
			default: value as Character
		}
	}

	protected def asByte(Object value) {
		switch value {
			Byte: value
			Number: value.byteValue
			default: value as Byte
		}
	}

	protected def createAnnotationValue(PsiType type) {
		switch type {
			case PsiType.BOOLEAN: createJvmBooleanAnnotationValue
			case PsiType.INT: createJvmIntAnnotationValue
			case PsiType.LONG: createJvmLongAnnotationValue
			case PsiType.SHORT: createJvmShortAnnotationValue
			case PsiType.FLOAT: createJvmFloatAnnotationValue
			case PsiType.DOUBLE: createJvmDoubleAnnotationValue
			case PsiType.CHAR: createJvmCharAnnotationValue
			case PsiType.BYTE: createJvmByteAnnotationValue
			case type.isClassType(String): createJvmStringAnnotationValue
			case type.isClassType(Class): createJvmTypeAnnotationValue
			case type.annotation: createJvmAnnotationAnnotationValue
			case type.enum: createJvmEnumAnnotationValue
			default: throw new IllegalArgumentException("Unexpected type: " + type.canonicalText)
		}
	}

	protected def Object computeAnnotationValue(PsiAnnotationMemberValue value, Project project) {
		val extension constantEvaluationHelper = JavaPsiFacade.getInstance(project).constantEvaluationHelper
		switch value {
			PsiAnnotation: value
			PsiReferenceExpression: value.resolve
			PsiClassObjectAccessExpression: value.operand.type
			PsiArrayInitializerMemberValue: value.initializers.map[computeAnnotationValue(project)].toArray
			default: value.computeConstantExpression
		}
	}

	protected def getPackageName(PsiClass psiClass) {
		val javaFile = psiClass.containingFile as PsiJavaFile
		val psiPackageName = javaFile.getPackageName
		if (!psiPackageName.empty) {
			return psiPackageName
		}
		return null
	}

	protected def createValuesOperation(PsiClass psiClass, StringBuilder fqn) {
		createJvmOperation => [
			internalSetIdentifier(fqn.append('values()').toString)
			simpleName = 'values'
			visibility = JvmVisibility.PUBLIC
			static = true
			returnType = psiClass.project.psiElementFactory.createType(psiClass).createTypeReference
			deprecated = false
			associate[|psiClass]
		]
	}

	protected def createValueOfOperation(PsiClass psiClass, StringBuilder fqn) {
		val psiElementFactory = psiClass.project.psiElementFactory
		createJvmOperation => [
			internalSetIdentifier(fqn.append('valueOf(java.lang.String)').toString)
			simpleName = 'valueOf'
			visibility = JvmVisibility.PUBLIC
			static = true
			returnType = psiElementFactory.createType(psiClass).createTypeReference
			parameters.addUnique(
				createJvmFormalParameter => [
					name = 'name'
					parameterType = psiElementFactory.createTypeByFQClassName(String.name).createTypeReference
				])
			deprecated = false
			associate[|psiClass]
		]
	}

	protected def createDefaultConstructor(PsiClass psiClass, StringBuilder fqn) {
		createJvmConstructor => [
			internalSetIdentifier(fqn.append(psiClass.name).append('()').toString)
			simpleName = psiClass.name
			visibility = JvmVisibility.PUBLIC
			deprecated = false
			associate[|psiClass]
		]
	}

	protected def createConstructor(PsiMethod psiMethod, StringBuilder fqn) {
		createJvmConstructor => [
			enhanceExecutable(psiMethod, fqn)
			createAnnotationValues(psiMethod)
		]
	}

	protected def createOperation(PsiMethod method, StringBuilder fqn) {
		ProgressIndicatorProvider.checkCanceled
		createJvmOperation => [
			enhanceExecutable(method, fqn)
			abstract = method.hasModifierProperty(PsiModifier.ABSTRACT)
			final = method.hasModifierProperty(PsiModifier.FINAL)
			static = method.hasModifierProperty(PsiModifier.STATIC)
			strictFloatingPoint = method.hasModifierProperty(PsiModifier.STRICTFP)
			synchronized = method.hasModifierProperty(PsiModifier.SYNCHRONIZED)
			native = method.hasModifierProperty(PsiModifier.NATIVE)
			returnType = method.returnType.createTypeReference
			createAnnotationValues(method)
			associate[|method]
		]
	}

	protected def enhanceExecutable(JvmExecutable it, PsiMethod psiMethod, StringBuilder fqn) {
		createTypeParameters(psiMethod)
		fqn.append(psiMethod.name).append('(')
		createFormalParameters(psiMethod, fqn)
		val identifier = fqn.append(')').toString
		internalSetIdentifier(identifier)
		simpleName = psiMethod.name
		setVisibility(psiMethod)
		deprecated = psiMethod.deprecated
		varArgs = psiMethod.varArgs
	}

	protected def createFormalParameters(JvmExecutable it, PsiMethod psiMethod, StringBuilder fqn) {
		val parameterList = psiMethod.parameterList
		for (var i = 0; i < parameterList.parametersCount; i++) {
			val parameter = parameterList.parameters.get(i)
			if (i != 0) {
				fqn.append(',')
			}
			fqn.appendTypeName(parameter.type)
			parameters.addUnique(parameter.createFormalParameter)
		}
	}

	protected def createTypeParameters(JvmTypeParameterDeclarator it,
		PsiTypeParameterListOwner psiTypeParameterListOwner) {
		for (typeParameter : psiTypeParameterListOwner.typeParameters) {
			typeParameters.addUnique(typeParameter.createTypeParameter)
		}
	}

	protected def createFormalParameter(PsiParameter parameter) {
		createJvmFormalParameter => [
			name = parameter.name
			parameterType = parameter.type.createTypeReference
			createAnnotationValues(parameter)
		]
	}

	protected def createTypeParameter(PsiTypeParameter parameter) {
		createJvmTypeParameter => [
			name = parameter.name
			val extendsListTypes = parameter.extendsListTypes
			if (!extendsListTypes.empty) {
				for (upperBound : extendsListTypes) {
					val jvmUpperBound = createJvmUpperBound as JvmTypeConstraintImplCustom
					jvmUpperBound.internalSetTypeReference(upperBound.createTypeReference)
					constraints.addUnique(jvmUpperBound)
				}
			} else {
				val jvmUpperBound = createJvmUpperBound as JvmTypeConstraintImplCustom
				jvmUpperBound.internalSetTypeReference(parameter.project.createObjectClassReference)
				constraints.addUnique(jvmUpperBound)
			}
		]
	}

	protected def createObjectClassReference(Project it) {
		psiElementFactory.createTypeByFQClassName(Object.name).createTypeReference
	}

	protected def JvmTypeReference createTypeReference(PsiType psiType) {
		switch psiType {
			PsiArrayType:
				psiType.componentType.createArrayTypeReference
			PsiClassType: {
				val resolveResult = psiType.resolveGenerics
				val psiClass = resolveResult.element
				if (psiClass == null) {
					createJvmUnknownTypeReference
				} else if (psiType.parameterCount == 0) {
					resolveResult.createClassTypeReference => [
						type = psiType.createProxy
					]
				} else {
					resolveResult.createClassTypeReference => [
						type = psiType.rawType.createProxy
						for (parameter : psiType.parameters) {
							arguments.addUnique(parameter.createTypeArgument)
						}
					]
				}
			}
			default:
				createJvmParameterizedTypeReference => [
					type = psiType.createProxy
				]
		}
	}

	protected def createClassTypeReference(ClassResolveResult resolveResult) {
		val psiClass = resolveResult.element
		if (psiClass.innerTypeReference)
			createJvmInnerTypeReference => [
				val containingClass = psiClass.containingClass
				val psiElementFactory = psiClass.project.psiElementFactory
				val outerType = psiElementFactory.createType(containingClass, resolveResult.substitutor)
				outer = outerType.createTypeReference as JvmParameterizedTypeReference
			]
		else
			createJvmParameterizedTypeReference
	}

	protected def isInnerTypeReference(PsiClass psiClass) {
		psiClass.containingClass != null && !psiClass.hasModifierProperty(PsiModifier.STATIC)
	}

	protected def createTypeArgument(PsiType type) {
		switch type {
			PsiWildcardType:
				createJvmWildcardTypeReference => [
					val upperBound = createJvmUpperBound as JvmTypeConstraintImplCustom
					upperBound.internalSetTypeReference(type.createUpperBoundReference)
					constraints.addUnique(upperBound)
					
					val superBound = type.superBound
					if (superBound != PsiType.NULL) {
						val lowerBound = createJvmLowerBound as JvmTypeConstraintImplCustom
						lowerBound.internalSetTypeReference(superBound.createTypeReference)
						constraints.addUnique(lowerBound)
					}
				]
			default:
				type.createTypeReference
		}
	}

	protected def createUpperBoundReference(PsiWildcardType type) {
		val extendsBound = type.extendsBound
		if (extendsBound != PsiType.NULL) {
			extendsBound.createTypeReference
		} else {
			createObjectClassReference(type.manager.project)
		}
	}

	protected def createArrayTypeReference(PsiType psiComponentType) {
		createJvmGenericArrayTypeReference => [
			componentType = psiComponentType.createTypeReference
		]
	}

	protected def JvmType createProxy(PsiType psiType) {
		typeProxies.get(psiType) ?: createJvmVoid => [
			val uri = psiType.fullURI
			if (it instanceof InternalEObject) {
				eSetProxyURI(uri)
			}
			typeProxies.put(psiType, it)
		]
	}

	protected def createNestedTypes(JvmDeclaredType it, PsiClass psiClass, StringBuilder fqn) {
		for (innerClass : psiClass.innerClasses.filter [
			!anonymous && !synthetic
		]) {
			fqn.preserve [ |
				members.addUnique(innerClass.createType(fqn))
			]
		}
	}

	protected def isAnonymous(PsiClass psiClass) {
		psiClass instanceof PsiAnonymousClass
	}

	protected def isSynthetic(PsiClass psiClass) {
		//		psiClass instanceof PsiSyntheticClass
		false
	}

	protected def setVisibility(JvmMember it, PsiModifierListOwner modifierListOwner) {
		visibility = switch modifierListOwner {
			case modifierListOwner.hasModifierProperty(PsiModifier.PRIVATE): JvmVisibility.PRIVATE
			case modifierListOwner.hasModifierProperty(PsiModifier.PROTECTED): JvmVisibility.PROTECTED
			case modifierListOwner.hasModifierProperty(PsiModifier.PUBLIC): JvmVisibility.PUBLIC
		}
	}

	protected def setTypeModifiers(JvmDeclaredType it, PsiClass psiClass) {
		abstract = psiClass.hasModifierProperty(PsiModifier.ABSTRACT)
		static = psiClass.hasModifierProperty(PsiModifier.STATIC)
		if (!psiClass.enum) {
			final = psiClass.hasModifierProperty(PsiModifier.FINAL)
		}
	}

	protected def void addUnique(EList<?> list, Object object) {
		(list as InternalEList<Object>).addUnique(object)
	}

	protected def append(StringBuilder builder, String value, ()=>void procedure) {
		val length = builder.length
		builder.append(value)
		procedure.apply
		builder.setLength(length)
		builder
	}

	protected def preserve(StringBuilder builder, ()=>void procedure) {
		val length = builder.length
		procedure.apply
		builder.setLength(length)
		builder
	}
	
	protected def isPrimitive(PsiType type) {
		type instanceof PsiPrimitiveType
	}
	
	protected def isClassType(PsiType type, Class<?> clazz) {
		if (type instanceof PsiClassType) {
			type.resolve.qualifiedName == clazz.name
		} else {
			false
		}
	}
	
	protected def isAnnotation(PsiType type) {
		if (type instanceof PsiClassType) {
			type.resolve.annotationType
		} else {
			false
		}
	}
	
	protected def isEnum(PsiType type) {
		if (type instanceof PsiClassType) {
			type.resolve.enum
		} else {
			false
		}
	}
	
	protected def isArray(PsiType type) {
		type instanceof PsiArrayType
	}

}
