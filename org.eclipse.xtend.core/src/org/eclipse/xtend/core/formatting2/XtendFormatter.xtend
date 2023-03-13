/*******************************************************************************
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.formatting2

import com.google.inject.Inject
import java.util.List
import org.eclipse.xtend.core.services.XtendGrammarAccess
import org.eclipse.xtend.core.xtend.AnonymousClass
import org.eclipse.xtend.core.xtend.RichString
import org.eclipse.xtend.core.xtend.XtendAnnotationTarget
import org.eclipse.xtend.core.xtend.XtendAnnotationType
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendConstructor
import org.eclipse.xtend.core.xtend.XtendEnum
import org.eclipse.xtend.core.xtend.XtendField
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtend.core.xtend.XtendInterface
import org.eclipse.xtend.core.xtend.XtendMember
import org.eclipse.xtend.core.xtend.XtendParameter
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XClosure
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XVariableDeclaration
import org.eclipse.xtext.xbase.annotations.formatting2.XbaseWithAnnotationsFormatter

import static org.eclipse.xtend.core.formatting2.XtendFormatterPreferenceKeys.*
import static org.eclipse.xtend.core.xtend.XtendPackage.Literals.*
import static org.eclipse.xtext.xbase.formatting2.XbaseFormatterPreferenceKeys.*
import org.eclipse.xtext.xbase.XIfExpression

/**
 * @author Moritz Eysholdt - Initial implementation and API
 */
class XtendFormatter extends XbaseWithAnnotationsFormatter {

	@Inject extension XtendGrammarAccess
	@Inject RichStringFormatter.Factory richStringFormatterFactory

	def dispatch void format(XtendFile xtendFile, extension IFormattableDocument format) {
		xtendFile.prepend[noSpace]
		val pkg = xtendFile.regionFor.feature(XTEND_FILE__PACKAGE)
		if(pkg !== null) {
			pkg.prepend[oneSpace]
			val pkgSemicolon = pkg.immediatelyFollowing.keyword(";")
			if (pkgSemicolon !== null) {
				pkg.append[noSpace]
				pkgSemicolon.append(blankLinesAfterPackageDecl)
			} else {
				pkg.append(blankLinesAfterPackageDecl)
			}
		}
		xtendFile.importSection?.format
		for (clazz : xtendFile.xtendTypes) {
			clazz.format
			if (clazz != xtendFile.xtendTypes.last)
				clazz.append(blankLinesBetweenClasses)
		}
		xtendFile.append[newLine]
	}

	def protected void formatAnnotations(XtendAnnotationTarget target, extension IFormattableDocument document,
		(IHiddenRegionFormatter)=>void configKey) {
		if (target.annotations.isEmpty)
			return;
		for (a : target.annotations) {
			a.format
			a.append(configKey)
		}
	}

	def dispatch void format(XtendClass clazz, extension IFormattableDocument format) {
		formatAnnotations(clazz, format, newLineAfterClassAnnotations)
		formatModifiers(clazz, format)
		formatTypeParameters(clazz, clazz.typeParameters, format)
		clazz.regionFor.keyword("class").append[oneSpace]
		clazz.regionFor.keyword("extends").surround[oneSpace]
		clazz.^extends.format
		clazz.regionFor.keyword("implements").surround[oneSpace]
		for (imp : clazz.^implements) {
			imp.immediatelyFollowing.keyword(",").prepend[noSpace].append[oneSpace]
			imp.format
		}
		formatBody(clazz, format)
	}

	def protected formatTypeParameters(XtendMember member, List<? extends JvmTypeParameter> typeParameters,
		extension IFormattableDocument format) {
		if (!typeParameters.empty) {
			member.regionFor.keyword("<").surround[noSpace]
			for (arg : typeParameters) {
				arg.format
				arg.immediatelyFollowing.keyword(",").prepend[noSpace].append[oneSpace]
			}
			member.regionFor.keyword(">").prepend[noSpace]
		}
	}

	def protected formatBody(XtendTypeDeclaration type, extension IFormattableDocument format) {
		val open = type.regionFor.keyword("{")
		val close = type.regionFor.keyword("}")
		interior(open, close) [indent]
		open.prepend(bracesInNewLine)
		if (!type.members.empty) {
			open.append(blankLinesBeforeFirstMember)
			for (i : 0 .. (type.members.size - 1)) {
				val current = type.members.get(i)
				current.format
				if (i < type.members.size - 1) {
					val next = type.members.get(i + 1)
					if (current instanceof XtendField && next instanceof XtendField)
						current.append(blankLinesBetweenFields)
					else if (current instanceof XtendFunction && next instanceof XtendFunction)
						current.append(blankLinesBetweenMethods)
					else
						current.append(blankLinesBetweenFieldsAndMethods)
				} else {
					val member = type.members.get(i)
					member.append(blankLinesAfterLastMember)
				}
			}
		} else {
			open.append[newLine]
		}
	}

	def dispatch void format(XtendInterface interfaze, extension IFormattableDocument format) {
		formatAnnotations(interfaze, format, newLineAfterClassAnnotations)
		formatModifiers(interfaze, format)
		formatTypeParameters(interfaze, interfaze.typeParameters, format)
		interfaze.regionFor.keyword("interface").append[oneSpace]
		interfaze.regionFor.keyword("extends").surround[oneSpace]
		for (imp : interfaze.extends) {
			imp.immediatelyFollowing.keyword(",").prepend[noSpace].append[oneSpace]
			imp.format
		}
		formatBody(interfaze, format)
	}

	def dispatch void format(XtendAnnotationType annotationType, extension IFormattableDocument format) {
		formatAnnotations(annotationType, format, newLineAfterClassAnnotations)
		formatModifiers(annotationType, format)
		annotationType.regionFor.keyword("annotation").append[oneSpace]
		formatBody(annotationType, format)
	}

	def dispatch void format(XtendEnum enumeration, extension IFormattableDocument format) {
		formatAnnotations(enumeration, format, newLineAfterClassAnnotations)
		formatModifiers(enumeration, format)
		enumeration.regionFor.keyword("enum").append[oneSpace]
		val open = enumeration.regionFor.keyword("{")
		val close = enumeration.regionFor.keyword("}")
		interior(open, close)[indent]
		open.prepend(bracesInNewLine)
		if (!enumeration.members.empty) {
			open.append(blankLinesBeforeFirstMember)
			for (i : 0 .. (enumeration.members.size - 1)) {
				val current = enumeration.members.get(i)
				current.format
				if (i < enumeration.members.size - 1) {
					current.immediatelyFollowing.keyword(",").prepend[noSpace].append(blankLinesBetweenEnumLiterals)
				} else {
					current.append(blankLinesAfterLastMember)
				}
			}
		} else {
			open.append[newLine]
		}
	}

	def dispatch void format(XtendConstructor func, extension IFormattableDocument format) {
		formatAnnotations(func, format, newLineAfterConstructorAnnotations)
		formatModifiers(func, format)
		func.regionFor.keyword("new").append[noSpace]
		if (!func.typeParameters.empty) {
			func.regionFor.keyword("<").append[noSpace]
			for (arg : func.typeParameters) {
				arg.format
				arg.immediatelyFollowing.keyword(",").prepend[noSpace].append[oneSpace]
			}
			func.regionFor.keyword(">").surround([noSpace])
		}
		val open = func.regionFor.keyword("(")
		val close = func.regionFor.keyword(")")
		close.append(bracesInNewLine)
		formatCommaSeparatedList(func.parameters, open, close, format)

		func.expression.format
	}

	def dispatch void format(XtendFunction func, extension IFormattableDocument format) {
		formatAnnotations(func, format, newLineAfterMethodAnnotations)
		formatModifiers(func, format)
		if (!func.typeParameters.empty) {
			func.regionFor.keyword("<").append[noSpace]
			for (arg : func.typeParameters) {
				arg.format
				arg.immediatelyFollowing.keyword(",").prepend[noSpace].append[oneSpace]
			}
			func.regionFor.keyword(">").prepend[noSpace].append[oneSpace]
		}
		val nameNode = func.regionFor.feature(XTEND_FUNCTION__NAME)
		val open = nameNode?.immediatelyFollowing?.keyword("(")
		val close = func.regionFor.keyword(")")
		func.returnType.append[oneSpace]
		open.prepend[noSpace]
		if (func.expression !== null)
			close.append(bracesInNewLine)
		formatCommaSeparatedList(func.parameters, open, close, format)
		func.returnType.format
		func.expression.format
	}

	def dispatch void format(XtendField field, extension IFormattableDocument document) {
		field.regionFor.keyword("extension").append[oneSpace]
		formatAnnotations(field, document, newLineAfterFieldAnnotations)
		formatModifiers(field, document)
		if (field.name !== null)
			field.type.append[oneSpace]
		field.regionFor.keyword("=").prepend[oneSpace].append[oneSpace]
		field.type.format
		field.initialValue.format
	}

	def dispatch void format(XtendParameter param, extension IFormattableDocument format) {
		param.regionFor.keyword("extension").append[oneSpace]
		formatAnnotations(param, format, newLineAfterParameterAnnotations)
		param.parameterType.format
		val nameNode = param.regionFor.feature(XTEND_PARAMETER__NAME)
		nameNode.prepend[oneSpace]
	}

	override dispatch void format(XVariableDeclaration expr, extension IFormattableDocument format) {
		expr.regionFor.keyword("extension").append[oneSpace]
		super._format(expr,format)
	}
	
	override dispatch void format(XIfExpression expr, extension IFormattableDocument format) {
		if (!expr.conditionalExpression) {
			super._format(expr, format)
		} else {
			if (expr.eContainer instanceof XVariableDeclaration) {
				expr.surround[indent]
			}
			val multiline = expr.then.multilineOrInNewLine || expr.^else.multilineOrInNewLine
			if (expr.then instanceof XBlockExpression || multiline)
				expr.regionFor.keyword("?").prepend[newLine].surround[indent].append[oneSpace]
			else
				expr.regionFor.keyword("?").surround[oneSpace]
			expr.^if.format
			// missing paranthesis around the condition cannot be added
			if (expr.^else === null) {
				expr.then.formatBody(multiline, format)
			} else {
				expr.then.formatBodyInline(multiline, format)
				
				if (expr.^else instanceof XIfExpression || !multiline) {
					expr.^else.prepend[oneSpace]
					expr.^else.format
				} else {
					expr.regionFor.keyword(":").prepend[newLine].surround[indent].append[oneSpace]
					expr.^else.formatBody(multiline, format)
				}
			}
		}
	}

	override dispatch void format(JvmFormalParameter expr, extension IFormattableDocument format) {
		expr.regionFor.keyword("extension").append[oneSpace]
		super._format(expr, format)
	}

	def dispatch void format(RichString rs, extension IFormattableDocument format) {
		val richStringFormatter = richStringFormatterFactory.create(request.textRegionAccess)
		richStringFormatter.format(rs, format)
	}

	def dispatch void format(AnonymousClass anonymousClass, extension IFormattableDocument format) {
		format(anonymousClass.constructorCall, format)
		formatBody(anonymousClass, format)
	}

	/** 
	 * Always put existing modifiers into this fixed order
	 */
	def protected formatModifiers(XtendMember member, extension IFormattableDocument document) {
		member.regionFor.ruleCallsTo(commonModifierRule, methodModifierRule, fieldModifierRule).forEach [
			append[oneSpace]
		]
	}

	override protected isSingleLineBlock(XBlockExpression expr) {
		return expr.expressions.size <= 1 && preferences.getPreference(keepOneLineMethods) &&
			expr.eContainer instanceof XtendFunction &&
			!expr.nextHiddenRegion.immediatelyPreceding.keyword("}").previousHiddenRegion.multiline
	}

	override protected void formatBodyInline(XExpression expr, boolean forceMultiline, extension IFormattableDocument doc) {
		if (expr === null)
			return;
		if (expr instanceof XBlockExpression && (!(expr instanceof RichString) || !forceMultiline)) {
			expr.prepend(bracesInNewLine).append(bracesInNewLine)
		} else if (forceMultiline || expr.previousHiddenRegion.isMultiline) {
			if (!(expr.eContainer instanceof XIfExpression && (expr.eContainer as XIfExpression).conditionalExpression))
				expr.prepend[newLine].surround[indent].append[newLine]
		} else {
			expr.surround[oneSpace]
		}
		expr.format
	}

	override protected void formatBody(XExpression expr, boolean forceMultiline, extension IFormattableDocument doc) {
		if (expr === null)
			return;
		if (expr instanceof XBlockExpression && (!(expr instanceof RichString) || !forceMultiline)) {
			expr.prepend(bracesInNewLine)
		} else if (forceMultiline || expr.previousHiddenRegion.isMultiline) {
			if (!(expr.eContainer instanceof XIfExpression && (expr.eContainer as XIfExpression).conditionalExpression))
				expr.prepend[newLine].surround[indent]
		} else {
			expr.prepend[oneSpace]
		}
		expr.format
	}

	override protected builder(List<XExpression> params) {
		if (params.last !== null) {
			val grammarElement = params.last.grammarElement
			if (grammarElement == XMemberFeatureCallAccess.memberCallArgumentsXClosureParserRuleCall_1_1_4_0 ||
				grammarElement == XFeatureCallAccess.featureCallArgumentsXClosureParserRuleCall_4_0 ||
				grammarElement == xbaseConstructorCallAccess.argumentsXClosureParserRuleCall_5_0)
				params.last as XClosure
		}
	}

}
