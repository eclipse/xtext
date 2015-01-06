/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.presentation

import com.google.inject.Inject
import org.eclipse.xtext.common.types.JvmEnumerationLiteral
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.xbase.idea.presentation.XbaseItemPresentationProvider
import org.eclipse.xtext.xbase.validation.UIStrings

/**
 * @author kosyakov - Initial contribution and API
 */
class XtendJvmItemPresentationProvider extends XbaseItemPresentationProvider {

	@Inject UIStrings uiStrings
	
	override protected _text(JvmGenericType genericType) {
		val local = genericType.isLocal()
		if (local) {
			val supertype = genericType.superTypes.last
			return '''new «supertype.simpleName»() {...}'''
		}
		genericType.simpleName + if (genericType.typeParameters.empty)
			""
		else
			uiStrings.typeParameters(genericType.typeParameters)
	}

	def dispatch text(JvmEnumerationLiteral element) {
		element.simpleName
	}
	
}