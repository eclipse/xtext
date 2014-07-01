package org.eclipse.xtend.lib

import com.google.common.annotations.GwtCompatible
import java.lang.annotation.ElementType
import java.lang.annotation.Target
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.AccessorsProcessor
import org.eclipse.xtend.lib.macro.AbstractFieldProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.Visibility

/**
 * Creates a getter and setter method for the annotated field.
 * Prepends the field name with an underscore (e.g. <code>_myField</code>)
 * 
 * @author Sven Efftinge
 * @deprecated use {@link Accessors} instead
 */
@GwtCompatible
@Target(ElementType.FIELD)
@Active(PropertyProcessor)
@Deprecated
annotation Property {
}

/**
 * @since 2.7
 */
@Deprecated
@GwtCompatible
class PropertyProcessor extends AbstractFieldProcessor {
	
	override doTransform(MutableFieldDeclaration it, extension TransformationContext context) {
		extension val util = new AccessorsProcessor.Util(context)
		if (!hasGetter && canAddGetter) {
			addGetter(Visibility.PUBLIC)
		}
		if (!final && !hasSetter && canAddSetter) {
			addSetter(Visibility.PUBLIC)
		}
		simpleName = "_" + simpleName.toFirstLower
	}
}
