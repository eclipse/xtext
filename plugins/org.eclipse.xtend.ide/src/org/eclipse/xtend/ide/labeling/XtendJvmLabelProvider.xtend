package org.eclipse.xtend.ide.labeling

import com.google.inject.Inject
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider
import org.eclipse.jface.viewers.StyledString
import org.eclipse.xtext.common.types.JvmEnumerationLiteral
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.xbase.ui.labeling.XbaseLabelProvider
import org.eclipse.xtext.xbase.validation.UIStrings

/**
 * Provides labels for Xtend elements.
 * 
 * @author Dennis Huebner
 */
public class XtendJvmLabelProvider extends XbaseLabelProvider {

	@Inject UIStrings uiStrings

	@Inject
	new(AdapterFactoryLabelProvider delegate) {
		super(delegate)
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

	protected override text(JvmField element) {
		return new StyledString(element.simpleName).append(
			new StyledString(" : " + element.type.simpleName, StyledString.DECORATIONS_STYLER))
	}

	protected def text(JvmEnumerationLiteral element) {
		element.simpleName
	}

}
