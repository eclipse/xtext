/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.jvm

import com.intellij.lang.LighterASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.lang.PsiBuilder.Marker
import com.intellij.psi.impl.source.tree.JavaElementType
import com.intellij.psi.tree.IElementType
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Delegate
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

import static extension org.eclipse.xtext.xbase.idea.jvm.JvmPsiBuilderExtensions.*

/**
 * @author kosyakov - Initial contribution and API
 */
@FinalFieldsConstructor
class JvmPsiBuilder implements PsiBuilder {

	@Delegate
	val PsiBuilder delegate

	override mark() {
		delegate.mark.wrap
	}

}

@FinalFieldsConstructor
class JvmMarker implements Marker {

	@Delegate
	@Accessors
	val Marker originalMarker

	override precede() {
		originalMarker.precede.wrap
	}

	override done(IElementType type) {
		originalMarker.done(type.jvmType)
	}

	override doneBefore(IElementType type, Marker before) {
		originalMarker.doneBefore(type.jvmType, before.unwrap)
	}

	override doneBefore(IElementType type, Marker before, String errorMessage) {
		originalMarker.doneBefore(type.jvmType, before, errorMessage)
	}

}

class LighterJvmMarker extends JvmMarker implements LighterASTNode {

	@Delegate
	@Accessors
	val LighterASTNode originalLighterASTNode

	new(Marker marker, LighterASTNode lighterASTNode) {
		super(marker)
		this.originalLighterASTNode = lighterASTNode
	}

}

class JvmPsiBuilderExtensions {

	static def wrap(Marker marker) {
		switch marker {
			LighterASTNode: new LighterJvmMarker(marker, marker)
			default: new JvmMarker(marker)
		}
	}

	static def unwrap(Marker marker) {
		switch marker {
			JvmMarker: marker.originalMarker
			default: marker
		}
	}

	static def getJvmType(IElementType type) {
		switch type {
			case JavaElementType.PARAMETER: JvmElementTypes.PARAMETER
			case JavaElementType.RECEIVER_PARAMETER : JvmElementTypes.RECEIVER_PARAMETER
			case JavaElementType.CLASS: JvmElementTypes.CLASS
			case JavaElementType.ANONYMOUS_CLASS: JvmElementTypes.ANONYMOUS_CLASS
			case JavaElementType.ENUM_CONSTANT_INITIALIZER: JvmElementTypes.ENUM_CONSTANT_INITIALIZER
			case JavaElementType.METHOD: JvmElementTypes.METHOD
			case JavaElementType.ANNOTATION_METHOD: JvmElementTypes.ANNOTATION_METHOD
			case JavaElementType.FIELD: JvmElementTypes.FIELD
			case JavaElementType.ENUM_CONSTANT: JvmElementTypes.ENUM_CONSTANT
			default: type
		}
	}

}