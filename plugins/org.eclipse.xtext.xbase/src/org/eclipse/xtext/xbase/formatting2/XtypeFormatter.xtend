package org.eclipse.xtext.xbase.formatting2;

import org.eclipse.xtext.common.types.JvmParameterizedTypeReference
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.common.types.JvmWildcardTypeReference
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.eclipse.xtext.xtype.XFunctionTypeRef
import org.eclipse.xtext.xtype.XImportDeclaration
import org.eclipse.xtext.xtype.XImportSection

import static org.eclipse.xtext.xbase.formatting2.XbaseFormatterPreferenceKeys.*
import static org.eclipse.xtext.xtype.XtypePackage.Literals.*

class XtypeFormatter extends AbstractFormatter2 {

	def dispatch void format(XFunctionTypeRef func, extension IFormattableDocument document) {
		func.regionForKeyword("(").append[noSpace]
		for (param : func.paramTypes) {
			param.format(document)
			param.immediatelyFollowingKeyword(",").prepend[noSpace].append[oneSpace]
		}
		func.regionForKeyword(")").prepend[if(!func.paramTypes.empty) noSpace].append[noSpace]
		func.regionForKeyword("=>").append[noSpace]
		func.returnType.format(document)
	}

	def dispatch void format(JvmParameterizedTypeReference ref, extension IFormattableDocument document) {
		ref.regionForKeyword("<").surround[noSpace]
		for (arg : ref.arguments) {
			arg.format(document)
			arg.immediatelyFollowingKeyword(",").prepend[noSpace].append[oneSpace]
		}
		if (!ref.arguments.empty)
			ref.regionForKeyword(">").prepend[noSpace]
	}

	def dispatch void format(JvmWildcardTypeReference ref, extension IFormattableDocument document) {
		if (!ref.constraints.empty)
			ref.regionForKeyword("?").append[oneSpace]
		for (c : ref.constraints)
			c.format(document)
	}

	def dispatch void format(JvmTypeParameter ref, extension IFormattableDocument document) {
		for (c : ref.constraints) {
			c.prepend[oneSpace]
			c.format(document)
		}
	}

	def dispatch format(XImportSection section, extension IFormattableDocument format) {
		for (imp : section.importDeclarations) {
			imp.format(format)
			if (imp != section.importDeclarations.last)
				imp.append(blankLinesBetweenImports)
			else
				imp.append(blankLinesAfterImports)
		}
	}

	def dispatch void format(XImportDeclaration imp, extension IFormattableDocument document) {
		imp.regionForKeyword("import").append[oneSpace]
		imp.regionForFeature(XIMPORT_DECLARATION__STATIC).append[oneSpace]
		imp.regionForFeature(XIMPORT_DECLARATION__EXTENSION).append[oneSpace]
		for (node : imp.regionsForKeywords("."))
			node.surround[noSpace]
		imp.regionForKeyword(";").prepend[noSpace]
	}
}
