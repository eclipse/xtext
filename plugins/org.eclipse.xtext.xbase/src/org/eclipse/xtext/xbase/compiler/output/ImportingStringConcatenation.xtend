/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler.output

import org.eclipse.xtend2.lib.StringConcatenation
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.xbase.compiler.ImportManager
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReferenceSerializer
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter

/**
 * A specialized {@link StringConcatenation} that will properly convert instances of 
 * {@link Class}, {@link JvmType}, {@link JvmTypeReference} or {@link LightweightTypeReference}
 * to their valid serialized representation including import handling.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ImportingStringConcatenation extends StringConcatenation {

	val ImportManager importManager
	val ITypeReferenceOwner typeReferenceOwner

	new(TreeAppendable state, ITypeReferenceOwner typeReferenceOwner) {
		super(state.lineSeparator)
		this.importManager = state.importManager
		this.typeReferenceOwner = typeReferenceOwner
	}
	
	def dispatch protected String getStringRepresentation(Object object) {
		super.getStringRepresentation(object)
	}
	def dispatch protected String getStringRepresentation(JvmType object) {
		return importManager.serialize(object).toString()
	}
	def dispatch protected String getStringRepresentation(JvmTypeReference object) {
		val reference = new OwnedConverter(typeReferenceOwner, true).toLightweightReference(object)
		return _getStringRepresentation(reference)
	}
	def dispatch protected String getStringRepresentation(LightweightTypeReference object) {
		val appender = new StringBuilderBasedAppendable(importManager)
		val serializer = new LightweightTypeReferenceSerializer(appender)
		object.accept(serializer)
		return appender.toString
	}
	def dispatch protected String getStringRepresentation(Class<?> object) {
		return importManager.serialize(object).toString
	}
	
	/**
	 * A potentially contained trailing line delimiter is ignored.
	 */
	override protected getSignificantContent() {
		val result = super.getSignificantContent()
		if (result.size >= 1 && lineDelimiter == result.last) {
			return result.subList(0, result.size - 1)
		}
		return result
	}
	
}