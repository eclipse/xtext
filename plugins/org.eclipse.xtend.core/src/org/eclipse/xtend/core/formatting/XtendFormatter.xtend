/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.formatting

import com.google.inject.Inject
import java.util.Collection
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.core.xtend.RichString
import org.eclipse.xtend.core.xtend.XtendAnnotationTarget
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendConstructor
import org.eclipse.xtend.core.xtend.XtendField
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtend.core.xtend.XtendImport
import org.eclipse.xtend.core.xtend.XtendParameter
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.xbase.configuration.IConfigurationKey
import org.eclipse.xtext.xbase.formatting.FormattableDocument
import org.eclipse.xtext.xbase.formatting.FormattingDataFactory
import org.eclipse.xtext.xbase.formatting.HiddenLeafAccess
import org.eclipse.xtext.xbase.formatting.NodeModelAccess
import org.eclipse.xtext.xbase.formatting.XbaseFormatter2

import static org.eclipse.xtend.core.xtend.XtendPackage$Literals.*

@SuppressWarnings("restriction")
public class XtendFormatter extends XbaseFormatter2 {

	@Inject extension NodeModelAccess
	@Inject extension HiddenLeafAccess
	@Inject extension FormattingDataFactory
	@Inject extension XtendFormatterConfigKeys

	@Inject RichStringFormatter richStringFormatter

	def protected dispatch void format(XtendFile xtendFile, FormattableDocument format) {
		format += xtendFile.nodeForEObject.prepend[noSpace]
		val pkg = xtendFile.nodeForFeature(XTEND_FILE__PACKAGE)
		format += pkg.prepend[oneSpace]
		val pkgSemicolon = pkg.immediatelyFollowingKeyword(";")
		if (pkgSemicolon != null) {
			format += pkg.append[space = ""]
			format += pkgSemicolon.append[cfg(blankLinesAfterPackageDecl)]
		} else {
			format += pkg.append[cfg(blankLinesAfterPackageDecl)]
		}
		for (imp : xtendFile.imports) {
			imp.format(format)
			if (imp != xtendFile.imports.last)
				format += imp.nodeForEObject.append[cfg(blankLinesBetweenImports)]
			else
				format += imp.nodeForEObject.append[cfg(blankLinesAfterImports)]
		}
		for (clazz : xtendFile.xtendTypes) {
			clazz.format(format)
			if (clazz != xtendFile.xtendTypes.last)
				format += clazz.nodeForEObject.append[cfg(blankLinesBetweenClasses)]
		}

		format += xtendFile.nodeForEObject.append[newLine]
	}
	
	def protected void formatAnnotations(XtendAnnotationTarget target, FormattableDocument document,
		IConfigurationKey<?> configKey) {
		if (target.annotations.isEmpty)
			return;
		for (a : target.annotations) {
			a.format(document)
			document += a.nodeForEObject.append[cfg(configKey)]
		}
	}

	def protected dispatch void format(XtendImport imp, FormattableDocument document) {
		document += imp.nodeForKeyword("import").append[oneSpace]
		document += imp.nodeForFeature(XTEND_IMPORT__STATIC).append[oneSpace]
		document += imp.nodeForFeature(XTEND_IMPORT__EXTENSION).append[oneSpace]
		for (node : imp.nodesForKeyword("."))
			document += node.surround[noSpace]
		document += imp.nodeForKeyword(";").prepend[noSpace]
	}

	def protected dispatch void format(XtendClass clazz, FormattableDocument format) {
		formatAnnotations(clazz, format, newLineAfterClassAnnotations)
		format += clazz.nodeForKeyword("public").append[oneSpace]
		format += clazz.nodeForKeyword("abstract").append[oneSpace]
		if (!clazz.typeParameters.empty) {
			format += clazz.nodeForKeyword("<").surround[noSpace]
			for (arg : clazz.typeParameters) {
				arg.format(format)
				format += arg.immediatelyFollowingKeyword(",").surround([noSpace], [oneSpace])
			}
			format += clazz.nodeForKeyword(">").prepend[noSpace]
		}
		format += clazz.nodeForKeyword("class").append[oneSpace]
		format += clazz.nodeForKeyword("extends").surround[oneSpace]
		clazz.^extends.format(format)
		format += clazz.nodeForKeyword("implements").surround[oneSpace]
		for (imp : clazz.^implements) {
			format += imp.nodeForEObject.immediatelyFollowingKeyword(",").surround([noSpace], [oneSpace])
			imp.format(format)
		}
		val clazzOpenBrace = clazz.nodeForKeyword("{")
		format += clazzOpenBrace.prepend[cfg(bracesInNewLine)]
		if (!clazz.members.empty) {
			format += clazzOpenBrace.append[increaseIndentation]
			format += clazzOpenBrace.append[cfg(blankLinesBeforeFirstMember)]
			for (i : 0 .. (clazz.members.size - 1)) {
				val current = clazz.members.get(i)
				current.format(format)
				if (i < clazz.members.size - 1) {
					val next = clazz.members.get(i + 1)
					if (current instanceof XtendField && next instanceof XtendField)
						format += current.nodeForEObject.append[cfg(blankLinesBetweenFields)]
					else if (current instanceof XtendFunction && next instanceof XtendFunction)
						format += current.nodeForEObject.append[cfg(blankLinesBetweenMethods)]
					else
						format += current.nodeForEObject.append[cfg(blankLinesBetweenFieldsAndMethods)]
				} else {
					val node = clazz.members.get(i).nodeForEObject
					format += node.append[decreaseIndentation]
					format += node.append[cfg(blankLinesAfterLastMember)]
				}
			}
		} else {
			format += clazzOpenBrace.append[newLine]
		}
	}

	def protected dispatch void format(XtendConstructor func, FormattableDocument format) {
		formatAnnotations(func, format, newLineAfterConstructorAnnotations)
		format += func.nodeForKeyword("new").append[noSpace]
		if (!func.typeParameters.empty) {
			format += func.nodeForKeyword("<").append[noSpace]
			for (arg : func.typeParameters) {
				arg.format(format)
				format += arg.immediatelyFollowingKeyword(",").surround([noSpace], [oneSpace])
			}
			format += func.nodeForKeyword(">").surround([noSpace])
		}
		val open = func.nodeForKeyword("(")
		val close = func.nodeForKeyword(")")
		format += close.append[cfg(bracesInNewLine)]
		formatMemberParameter(func.parameters, open, close, format)

		func.expression.format(format)
	}

	def protected formatMemberParameter(Collection<XtendParameter> parameters, INode open, INode close,
		FormattableDocument format) {
		if (close?.hiddenLeafsBefore?.newLines > 0) {
			var INode comma = null
			if (parameters.empty)
				format += open.append[noSpace]
			else
				for (param : parameters) {
					if (param == parameters.head)
						format += open.append[newLine; increaseIndentation]
					else if (comma != null)
						format += comma.append[newLine]
					if (param == parameters.last)
						format += param.nodeForEObject.append[newLine; decreaseIndentation]
					param.format(format)
					comma = param.nodeForEObject.immediatelyFollowingKeyword(",")
					format += comma.prepend[noSpace]
				}
		} else {
			var INode comma = null
			var indented = false
			for (param : parameters) {
				if (format.fitsIntoLine(param)) {
					if (comma == null)
						format += open.append[noSpace]
					else
						format += comma.append[oneSpace]
				} else {
					val n = if (comma == null) open else comma
					format += n.append[newLine]
					if (!indented)
						format += n.append[increaseIndentation]
					indented = true
				}
				param.format(format)
				comma = param.nodeForEObject.immediatelyFollowingKeyword(",")
				format += comma.prepend[noSpace]
			}
			if (parameters.size > 0) {
				val last = parameters.last.nodeForEObject
				format += last.append[noSpace]
				if (indented)
					format += last.append[decreaseIndentation]
			} else
				format += open.append[noSpace]
		}
	}

	def protected dispatch void format(XtendFunction func, FormattableDocument format) {
		formatAnnotations(func, format, newLineAfterMethodAnnotations)
		format += func.nodeForKeyword("def").append[oneSpace]
		if (!func.typeParameters.empty) {
			format += func.nodeForKeyword("<").append[noSpace]
			for (arg : func.typeParameters) {
				arg.format(format)
				format += arg.immediatelyFollowingKeyword(",").surround([noSpace], [oneSpace])
			}
			format += func.nodeForKeyword(">").surround([noSpace], [oneSpace])
		}
		val nameNode = func.nodeForFeature(XTEND_FUNCTION__NAME)
		val open = nameNode.immediatelyFollowingKeyword("(")
		val close = func.nodeForKeyword(")")
		format += func.nodeForFeature(XTEND_FUNCTION__RETURN_TYPE).append[oneSpace]
		format += open.prepend[noSpace]
		format += close.append[cfg(bracesInNewLine)]
		formatMemberParameter(func.parameters, open, close, format)
		func.returnType.format(format)
		func.expression.format(format)
	}

	def protected dispatch void format(XtendField field, FormattableDocument document) {
		formatAnnotations(field, document, newLineAfterFieldAnnotations)
		if (field.name != null)
			document += field.nodeForFeature(XTEND_FIELD__TYPE).append[oneSpace]
		document += field.nodeForKeyword("static").append[oneSpace]
		document += field.nodeForKeyword("extension").append[oneSpace]
		document += field.nodeForKeyword("val").append[oneSpace]
		document += field.nodeForKeyword("var").append[oneSpace]
		document += field.nodeForKeyword("=").surround([oneSpace], [oneSpace])
		field.type.format(document)
		field.initialValue.format(document)
	}

	def protected dispatch void format(XtendParameter param, FormattableDocument format) {
		formatAnnotations(param, format, newLineAfterParameterAnnotations)
		param.parameterType.format(format)
		val nameNode = param.nodeForFeature(XTEND_PARAMETER__NAME)
		format += nameNode.prepend[oneSpace]
	}

	def protected dispatch void format(RichString rs, FormattableDocument format) {
		val callback = [EObject obj, FormattableDocument doc|obj.format(doc)]
		richStringFormatter.format(callback, format, rs)
	}

}
