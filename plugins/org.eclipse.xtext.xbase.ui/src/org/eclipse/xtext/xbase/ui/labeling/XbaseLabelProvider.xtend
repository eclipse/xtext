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
import org.eclipse.xtext.xbase.validation.UIStrings
import org.eclipse.xtext.xtype.XImportDeclaration
import org.eclipse.xtext.xtype.XImportSection

class XbaseLabelProvider extends DefaultEObjectLabelProvider {
	
	@Inject XbaseImages2 images

	@Inject UIStrings uiStrings

	@Inject IBatchTypeResolver typeResolver

	@Inject XbaseImageAdornments adornments
	
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

	protected def Object text(JvmOperation element) {
		signature(element.simpleName, element)
	}

	protected def dispatch ImageDescriptor imageDescriptor(JvmConstructor constructor) {
		images.forConstructor(constructor.visibility, adornments.get(constructor))
	}

	protected def String text(JvmConstructor constructor) {
		"new" + uiStrings.parameters(constructor)
	}

	protected def dispatch ImageDescriptor imageDescriptor(JvmField field) {
		images.forField(field.visibility, adornments.get(field))
	}

	protected def String text(JvmField field) {
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

	protected def String text(XImportDeclaration importDeclaration) {
		if (importDeclaration.getImportedNamespace() != null) 
			importDeclaration.getImportedNamespace()
		else
			importDeclaration.getImportedTypeName()
	}

	protected def String text(XImportSection importSection) {
		return "import declarations";
	}

	protected def String text(XVariableDeclaration variableDeclaration) {
		val resolvedTypes = typeResolver.resolveTypes(variableDeclaration)
		val type = resolvedTypes.getActualType(variableDeclaration as JvmIdentifiableElement)
		if (type != null)
			type.getSimpleName + " " + variableDeclaration.name
		else 
			variableDeclaration.name
	}

	protected def dispatch ImageDescriptor imageDescriptor(JvmTypeParameter parameter) {
		images.forTypeParameter(adornments.get(parameter))
	}

	protected def StyledString signature(String simpleName, JvmIdentifiableElement element) {
		val returnType = typeResolver.resolveTypes(element).getActualType(element)
		val returnTypeString = if (returnType == null) 
				"void" 
			else
				returnType.getSimpleName
		new StyledString(simpleName + uiStrings.parameters(element))
			.append(new StyledString(" : " + returnTypeString, StyledString.DECORATIONS_STYLER))
	}
	
	protected def dispatch ImageDescriptor imageDescriptor(Object element) {
		null
	}

	override protected doGetImage(Object element) {
		element?.imageDescriptor() ?: super.doGetImage(element)
	}
}
