package org.eclipse.xtext.xbase.ui.labeling

import com.google.inject.Inject
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider
import org.eclipse.jface.resource.ImageDescriptor
import org.eclipse.jface.viewers.StyledString
import org.eclipse.xtext.common.types.JvmAnnotationType
import org.eclipse.xtext.common.types.JvmConstructor
import org.eclipse.xtext.common.types.JvmEnumerationType
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider
import org.eclipse.xtext.xbase.XVariableDeclaration
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.eclipse.xtext.xbase.typesystem.^override.IResolvedConstructor
import org.eclipse.xtext.xbase.typesystem.^override.IResolvedField
import org.eclipse.xtext.xbase.typesystem.^override.IResolvedOperation
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices
import org.eclipse.xtext.xbase.validation.UIStrings
import org.eclipse.xtext.xtype.XImportDeclaration
import org.eclipse.xtext.xtype.XImportSection
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner

class XbaseLabelProvider extends DefaultEObjectLabelProvider {
	
	@Inject XbaseImages2 images

	@Inject UIStrings uiStrings

	@Inject IBatchTypeResolver typeResolver

	@Inject XbaseImageAdornments adornments
	
	@Inject CommonTypeComputationServices services
	
	@Inject
	new(AdapterFactoryLabelProvider delegate) {
		super(delegate)
	}

	protected def dispatch ImageDescriptor imageDescriptor(XImportSection importSection) {
		images.forImportContainer
	}

	protected def dispatch ImageDescriptor imageDescriptor(XImportDeclaration importDeclaration) {
		images.forImport
	}

	protected def dispatch ImageDescriptor imageDescriptor(JvmGenericType genericType) {
		if (genericType.interface)
			images.forInterface(genericType.visibility, adornments.get(genericType))
		else
			images.forClass(genericType.visibility, adornments.get(genericType))
	}

	protected def dispatch ImageDescriptor imageDescriptor(JvmEnumerationType enumerationType) {
		images.forEnum(enumerationType.visibility, adornments.get(enumerationType))
	}

	protected def dispatch ImageDescriptor imageDescriptor(JvmAnnotationType annotationType) {
		images.forAnnotation(annotationType.visibility, adornments.get(annotationType))
	}

	protected def String text(JvmGenericType genericType) {
		genericType.simpleName
	}

	protected def dispatch ImageDescriptor imageDescriptor(JvmOperation operation) {
		images.forOperation(operation.visibility, adornments.get(operation))
	}
	
	protected def dispatch ImageDescriptor imageDescriptor(IResolvedOperation operation) {
		imageDescriptor(operation.declaration)
	}

	protected def Object text(JvmOperation element) {
		signature(element.simpleName, element)
	}
	
	protected def Object text(IResolvedOperation element) {
		val returnTypeString = element.resolvedReturnType.simpleName
		var decoratedPart = " : " + returnTypeString
		if (!element.typeParameters.isEmpty) {
			decoratedPart = " <" + uiStrings.toString(element.typeParameters) + "> : " + returnTypeString
		}
		
		return new StyledString(element.declaration.simpleName+"("+element.resolvedParameterTypes.map[humanReadableName].join(', ')+")").append(
			new StyledString(decoratedPart, StyledString.DECORATIONS_STYLER))
	}

	protected def dispatch ImageDescriptor imageDescriptor(JvmConstructor constructor) {
		images.forConstructor(constructor.visibility, adornments.get(constructor))
	}

	protected def String text(JvmConstructor constructor) {
		"new" + uiStrings.parameters(constructor)
	}
	
	protected def dispatch ImageDescriptor imageDescriptor(IResolvedConstructor constructor) {
		_imageDescriptor(constructor.declaration)
	}

	protected def Object text(IResolvedConstructor constructor) {
		return new StyledString("new("+constructor.resolvedParameterTypes.map[humanReadableName].join(', ')+")")
	}
	
	protected def dispatch ImageDescriptor imageDescriptor(IResolvedField field) {
		_imageDescriptor(field.declaration)
	}

	protected def Object text(IResolvedField field) {
		return new StyledString(field.simpleSignature+" : "+field.resolvedType.humanReadableName)
	}

	protected def dispatch ImageDescriptor imageDescriptor(JvmField field) {
		images.forField(field.visibility, adornments.get(field))
	}

	protected def Object text(JvmField field) {
		field.simpleName + " : " + field.type.simpleName
	}

	protected def dispatch ImageDescriptor imageDescriptor(JvmFormalParameter parameter) {
		images.forLocalVariable(adornments.get(parameter))
	}

	protected def String text(JvmFormalParameter parameter) {
		val parameterType = parameter.parameterType
		if (parameterType == null)
			parameter.name
		else
			parameterType.getSimpleName + " " + parameter.name
	}

	protected def dispatch ImageDescriptor imageDescriptor(XVariableDeclaration variableDeclaration) {
		images.forLocalVariable(adornments.get(variableDeclaration))
	}

	protected def String text(XImportDeclaration it) 
		'''«importedTypeName»«IF wildcard».*«ELSEIF memberName != null».«memberName»«ENDIF»'''

	protected def String text(XImportSection importSection) {
		return "import declarations";
	}

	protected def String text(XVariableDeclaration variableDeclaration) {
		val resolvedTypes = typeResolver.resolveTypes(variableDeclaration)
		val type = resolvedTypes.getActualType(variableDeclaration as JvmIdentifiableElement)
		if (type != null)
			type.humanReadableName + " " + variableDeclaration.name
		else 
			variableDeclaration.name
	}
	
	protected def dispatch ImageDescriptor imageDescriptor(JvmTypeParameter parameter) {
		images.forTypeParameter(adornments.get(parameter))
	}

	protected def StyledString signature(String simpleName, JvmIdentifiableElement element) {
		val returnType = if (element instanceof JvmOperation) {
			element.returnType
		} else if (element instanceof JvmField) {
			element.type
		} else {
			null
		}
		val owner = new StandardTypeReferenceOwner(services, element);
		val returnTypeString = if (returnType == null) {
				"void"
			} else {
				owner.toLightweightTypeReference(returnType).humanReadableName
			}
		var decoratedPart = " : " + returnTypeString
		val typeParam = uiStrings.typeParameters(element) ?: ""
		if (typeParam != "") {
			decoratedPart = " " + typeParam + " : " + returnTypeString
		}
		return new StyledString(simpleName + uiStrings.parameters(element)).append(
			new StyledString(decoratedPart, StyledString.DECORATIONS_STYLER))
	}
	
	protected def dispatch ImageDescriptor imageDescriptor(Object element) {
		null
	}

	override protected doGetImage(Object element) {
		element?.imageDescriptor() ?: super.doGetImage(element)
	}
	
	protected def getTypeResolver() {
		return typeResolver
	}
}
