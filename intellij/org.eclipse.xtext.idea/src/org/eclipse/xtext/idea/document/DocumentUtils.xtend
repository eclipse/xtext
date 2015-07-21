/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.document

import com.intellij.openapi.editor.Document
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.xbase.compiler.ISourceAppender
import org.eclipse.xtext.xbase.imports.RewritableImportSection
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReferenceSerializer

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class DocumentUtils {

	def updateImportSection(Document document, RewritableImportSection importSection) {
		for (reg : importSection.rewrite) {
			document.replaceString(reg.offset, reg.endOffset, reg.text)
		}
	}

	def String toImportableString(LightweightTypeReference ref, RewritableImportSection importSection) {
		val appender = new ImportingSourceAppender(importSection)
		appender.append(ref)
		return appender.toString
	}
	
	def String toImportableString(JvmTypeReference ref, RewritableImportSection importSection) {
		val appender = new ImportingSourceAppender(importSection)
		appender.append(ref.type)
		return appender.toString
	}

	@FinalFieldsConstructor private static class ImportingSourceAppender implements ISourceAppender {

		val RewritableImportSection importSection
		val StringBuilder result = new StringBuilder

		override append(CharSequence string) {
			result.append(string)
			return this
		}

		override append(JvmType object) {
			if (object instanceof JvmGenericType) {
				if (importSection.addImport(object) 
				|| importSection.hasImportedType(object)
				|| !importSection.needsImport(object)) {
					result.append(object.simpleName)
					return this
				}
			}
			result.append(object.qualifiedName)
			return this
		}

		override append(LightweightTypeReference typeRef) {
			val nested = new ImportingSourceAppender(importSection)
			val serializer = new LightweightTypeReferenceSerializer(nested)
			typeRef.accept(serializer)
			result.append(nested.toString)
			return this
		}

		override toString() {
			result.toString
		}

		override isJava() {
			false
		}

		override decreaseIndentation() {
			throw new UnsupportedOperationException("TODO: auto-generated method stub")
		}

		override increaseIndentation() {
			throw new UnsupportedOperationException("TODO: auto-generated method stub")
		}

		override newLine() {
			throw new UnsupportedOperationException("TODO: auto-generated method stub")
		}

	}
}