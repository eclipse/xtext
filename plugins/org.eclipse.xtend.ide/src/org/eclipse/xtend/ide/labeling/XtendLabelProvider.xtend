package org.eclipse.xtend.ide.labeling

import com.google.inject.Inject
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider
import org.eclipse.jface.viewers.StyledString
import org.eclipse.xtend.core.jvmmodel.DispatchHelper
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations
import org.eclipse.xtend.core.xtend.AnonymousClass
import org.eclipse.xtend.core.xtend.XtendAnnotationType
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendConstructor
import org.eclipse.xtend.core.xtend.XtendEnum
import org.eclipse.xtend.core.xtend.XtendEnumLiteral
import org.eclipse.xtend.core.xtend.XtendField
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtend.core.xtend.XtendInterface
import org.eclipse.xtext.common.types.JvmEnumerationLiteral
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping
import org.eclipse.xtext.xbase.ui.labeling.XbaseImageAdornments
import org.eclipse.xtext.xbase.ui.labeling.XbaseLabelProvider
import org.eclipse.xtext.xbase.validation.UIStrings

/**
 * Provides labels for Xtend elements.
 * 
 * @author Jan Koehnlein
 */
public class XtendLabelProvider extends XbaseLabelProvider {

	@Inject UIStrings uiStrings

	@Inject XtendImages images

	@Inject extension IXtendJvmAssociations

	@Inject XbaseImageAdornments adornments

	@Inject extension DispatchHelper

	@Inject OperatorMapping operatorMapping

	@Inject
	new(AdapterFactoryLabelProvider delegate) {
		super(delegate)
	}

	protected def dispatch imageDescriptor(XtendFile element) {
		images.forFile
	}

	protected def dispatch imageDescriptor(XtendClass element) {
		images.forClass(element.visibility, adornments.get(element.inferredType))
	}

	protected def dispatch imageDescriptor(XtendInterface element) {
		images.forInterface(element.visibility, adornments.get(element.inferredType))
	}

	protected def dispatch imageDescriptor(XtendEnum element) {
		images.forEnum(element.visibility, adornments.get(element.inferredType))
	}

	protected def dispatch imageDescriptor(XtendAnnotationType element) {
		images.forAnnotation(element.visibility, adornments.get(element.inferredType))
	}

	protected def dispatch imageDescriptor(XtendFunction element) {
		images.forOperation(element.visibility, adornments.get(element.directlyInferredOperation))
	}

	protected def dispatch imageDescriptor(AnonymousClass element) {
		images.forClass(element.inferredType.visibility, adornments.get(element.inferredType))
	}

	protected override dispatch imageDescriptor(JvmOperation operation) {
		if (operation.dispatcherFunction)
			images.forDispatcherFunction(operation.visibility, adornments.get(operation))
		else
			images.forOperation(operation.visibility, adornments.get(operation))
	}

	protected def dispatch imageDescriptor(XtendConstructor element) {
		images.forConstructor(element.visibility, adornments.get(element.inferredConstructor))
	}

	protected def dispatch imageDescriptor(XtendField element) {
		images.forField(element.visibility, adornments.get(element.jvmField))
	}

	protected def dispatch imageDescriptor(XtendEnumLiteral element) {
		images.forField(element.visibility, adornments.get(element.jvmField))
	}

	protected def text(XtendFile element) {
		element.eResource.URI.trimFileExtension.lastSegment
	}

	protected def text(XtendClass element) {
		element.name + if (element.typeParameters.empty)
			""
		else
			uiStrings.typeParameters(element.typeParameters)
	}

	protected def text(XtendInterface element) {
		element.name + if (element.typeParameters.empty)
			""
		else
			uiStrings.typeParameters(element.typeParameters)
	}

	protected def text(AnonymousClass element) {
		text(element.inferredType)
	}

	protected override text(JvmGenericType element) {
		val local = element.isLocal()
		if (local) {
			val supertype = element.superTypes.head
			return '''new «supertype.simpleName»() {...}'''
		}
		element.simpleName + if (element.typeParameters.empty)
			""
		else
			uiStrings.typeParameters(element.typeParameters)
	}

	protected def text(XtendConstructor element) {
		"new" + uiStrings.parameters(element.inferredConstructor)
	}

	protected def text(XtendFunction element) {
		val simpleName = element.name
		if (simpleName != null) {
			val qnName = QualifiedName.create(simpleName)
			val operator = operatorMapping.getOperator(qnName)
			if (operator != null) {
				val result = signature(operator.firstSegment, element.directlyInferredOperation)
				result.append(' (' + simpleName + ')', StyledString.COUNTER_STYLER)
				return result
			}
		}
		return signature(element.name, element.directlyInferredOperation)
	}

	protected def text(XtendField element) {
		if (element.name == null && element.extension)
			return new StyledString(uiStrings.referenceToString(element.type, "extension"),
				StyledString.DECORATIONS_STYLER)
		val fieldType = element.displayedType
		if (fieldType != null) {
			val type = uiStrings.referenceToString(fieldType, "")
			if (type.length != 0) {
				return new StyledString(element.name).append(
					new StyledString(" : " + type, StyledString.DECORATIONS_STYLER))
			}
		}
		new StyledString(element.name)
	}

	protected override text(JvmField element) {
		return new StyledString(element.simpleName).append(
			new StyledString(" : " + element.type.simpleName, StyledString.DECORATIONS_STYLER))
	}

	protected def text(XtendEnumLiteral element) {
		element.name
	}
	
	protected def text(JvmEnumerationLiteral element) {
		element.simpleName
	}

	protected def JvmTypeReference getDisplayedType(XtendField field) {
		val jvmField = field.jvmField
		if (jvmField != null) {
			return jvmField.getType
		} else {
			val i = field.jvmElements.iterator
			if (i.hasNext) {
				val next = i.next
				if (next instanceof JvmOperation)
					return next.getReturnType
			}
		}
		null
	}

}
