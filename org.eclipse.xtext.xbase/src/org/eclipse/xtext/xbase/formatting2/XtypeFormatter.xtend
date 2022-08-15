/*******************************************************************************
 * Copyright (c) 2014, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.formatting2;

import org.eclipse.xtext.common.types.JvmParameterizedTypeReference
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.common.types.JvmWildcardTypeReference
import org.eclipse.xtext.formatting2.AbstractJavaFormatter
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.eclipse.xtext.xtype.XFunctionTypeRef
import org.eclipse.xtext.xtype.XImportDeclaration
import org.eclipse.xtext.xtype.XImportSection

import static org.eclipse.xtext.xbase.formatting2.XbaseFormatterPreferenceKeys.*
import static org.eclipse.xtext.xtype.XtypePackage.Literals.*

/**
 * @author Moritz Eysholdt - Initial implementation and API
 */
class XtypeFormatter extends AbstractJavaFormatter {

	def dispatch void format(XFunctionTypeRef func, extension IFormattableDocument document) {
		func.regionFor.keyword("(").append[noSpace]
		for (param : func.paramTypes) {
			param.format
			param.immediatelyFollowing.keyword(",").prepend[noSpace].append[oneSpace]
		}
		func.regionFor.keyword(")").prepend[if(!func.paramTypes.empty) noSpace].append[noSpace]
		func.regionFor.keyword("=>").append[noSpace]
		func.returnType.format
	}

	def dispatch void format(JvmParameterizedTypeReference ref, extension IFormattableDocument document) {
		ref.regionFor.keyword("<").surround[noSpace]
		for (arg : ref.arguments) {
			arg.format
			arg.immediatelyFollowing.keyword(",").prepend[noSpace].append[oneSpace]
		}
		if (!ref.arguments.empty)
			ref.regionFor.keyword(">").prepend[noSpace]
	}

	def dispatch void format(JvmWildcardTypeReference ref, extension IFormattableDocument document) {
		if (!ref.constraints.empty)
			ref.regionFor.keyword("?").append[oneSpace]
		for (c : ref.constraints)
			c.format
	}

	def dispatch void format(JvmTypeParameter ref, extension IFormattableDocument document) {
		for (c : ref.constraints) {
			c.prepend[oneSpace]
			c.format
		}
	}

	def dispatch format(XImportSection section, extension IFormattableDocument format) {
		for (imp : section.importDeclarations) {
			imp.format
			if (imp != section.importDeclarations.last)
				imp.append(blankLinesBetweenImports)
			else
				imp.append(blankLinesAfterImports)
		}
	}

	def dispatch void format(XImportDeclaration imp, extension IFormattableDocument document) {
		imp.regionFor.keyword("import").append[oneSpace]
		imp.regionFor.feature(XIMPORT_DECLARATION__STATIC).append[oneSpace]
		imp.regionFor.feature(XIMPORT_DECLARATION__EXTENSION).append[oneSpace]
		for (node : imp.regionFor.keywords("."))
			node.surround[noSpace]
		imp.regionFor.keyword(";").prepend[noSpace]
	}
}
