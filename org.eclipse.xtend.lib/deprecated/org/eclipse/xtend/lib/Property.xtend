/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
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
import java.lang.annotation.Documented

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
@Documented
annotation Property {
}

/**
 * @since 2.7
 * @noextend
 * @noreference
 */
@Deprecated
class PropertyProcessor extends AbstractFieldProcessor {
	
	override doTransform(MutableFieldDeclaration it, extension TransformationContext context) {
		extension val util = new AccessorsProcessor.Util(context)
		if (!hasGetter) {
			addGetter(Visibility.PUBLIC)
		}
		if (!final && !hasSetter) {
			addSetter(Visibility.PUBLIC)
		}
		simpleName = "_" + simpleName.toFirstLower
	}
}
