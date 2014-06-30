package org.eclipse.xtend.lib.annotations

import com.google.common.annotations.Beta
import com.google.common.annotations.GwtCompatible
import java.lang.annotation.ElementType
import java.lang.annotation.Target
import org.eclipse.xtend.lib.annotations.GetterProcessor
import org.eclipse.xtend.lib.annotations.SetterProcessor
import org.eclipse.xtend.lib.macro.AbstractFieldProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration

/**
 * Creates a getter and setter method for the annotated field.
 * @since 2.7
 */
@GwtCompatible
@Target(ElementType.FIELD)
@Active(PropertyProcessor)
annotation Property {
}

/**
 * @since 2.7
 */
@Beta
@GwtCompatible
class PropertyProcessor extends AbstractFieldProcessor {
	
	override doTransform(MutableFieldDeclaration it, extension TransformationContext context) {
		extension val getterUtil = new GetterProcessor.Util(context)
		extension val setterUtil = new SetterProcessor.Util(context)
		if (!hasGetter && canAddGetter) {
			addGetter
		}
		if (!final && !hasSetter && canAddSetter) {
			addSetter
		}
	}
}
