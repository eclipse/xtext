/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XClosure
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.annotations.formatting2.XbaseWithAnnotationsFormatter

import static org.eclipse.xtend.core.formatting2.XtendFormatterPreferenceKeys.*
import static org.eclipse.xtend.core.xtend.XtendPackage.Literals.*
import static org.eclipse.xtext.xbase.formatting2.XbaseFormatterPreferenceKeys.*

public class XtendFormatter extends XbaseWithAnnotationsFormatter {

	@Inject extension XtendGrammarAccess
	@Inject RichStringFormatter.Factory richStringFormatterFactory

	def dispatch void format(XtendFile xtendFile, extension IFormattableDocument format) {
		xtendFile.prepend[noSpace]
		val pkg = xtendFile.regionForFeature(XTEND_FILE__PACKAGE)
		pkg.prepend[oneSpace]
		val pkgSemicolon = pkg.immediatelyFollowingKeyword(";")
		if (pkgSemicolon != null) {
			pkg.append[noSpace]
			pkgSemicolon.append(blankLinesAfterPackageDecl)
		} else {
			pkg.append(blankLinesAfterPackageDecl)
		}
		xtendFile.importSection?.format(format)
		for (clazz : xtendFile.xtendTypes) {
			clazz.format(format)
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
			a.format(document)
			a.append(configKey)
		}
	}

	def dispatch void format(XtendClass clazz, extension IFormattableDocument format) {
		formatAnnotations(clazz, format, newLineAfterClassAnnotations)
		formatModifiers(clazz, format)
		formatTypeParameters(clazz, clazz.typeParameters, format)
		clazz.regionForKeyword("class").append[oneSpace]
		clazz.regionForKeyword("extends").surround[oneSpace]
		clazz.^extends.format(format)
		clazz.regionForKeyword("implements").surround[oneSpace]
		for (imp : clazz.^implements) {
			imp.immediatelyFollowingKeyword(",").prepend[noSpace].append[oneSpace]
			imp.format(format)
		}
		formatBody(clazz, format)
	}

	def protected formatTypeParameters(XtendMember member, List<? extends JvmTypeParameter> typeParameters,
		extension IFormattableDocument format) {
		if (!typeParameters.empty) {
			member.regionForKeyword("<").surround[noSpace]
			for (arg : typeParameters) {
				arg.format(format)
				arg.immediatelyFollowingKeyword(",").prepend[noSpace].append[oneSpace]
			}
			member.regionForKeyword(">").prepend[noSpace]
		}
	}

	def protected formatBody(XtendTypeDeclaration type, extension IFormattableDocument format) {
		val clazzOpenBrace = type.regionForKeyword("{")
		clazzOpenBrace.prepend(bracesInNewLine)
		if (!type.members.empty) {
			clazzOpenBrace.append[increaseIndentation]
			clazzOpenBrace.append(blankLinesBeforeFirstMember)
			for (i : 0 .. (type.members.size - 1)) {
				val current = type.members.get(i)
				current.format(format)
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
					member.append[decreaseIndentation]
					member.append(blankLinesAfterLastMember)
				}
			}
		} else {
			if (clazzOpenBrace?.nextHiddenRegion?.containsComment)
				clazzOpenBrace.append[newLine increaseIndentation decreaseIndentation]
			else
				clazzOpenBrace.append[newLine]
		}
	}

	def dispatch void format(XtendInterface interfaze, extension IFormattableDocument format) {
		formatAnnotations(interfaze, format, newLineAfterClassAnnotations)
		formatModifiers(interfaze, format)
		formatTypeParameters(interfaze, interfaze.typeParameters, format)
		interfaze.regionForKeyword("interface").append[oneSpace]
		interfaze.regionForKeyword("extends").surround[oneSpace]
		for (imp : interfaze.extends) {
			imp.immediatelyFollowingKeyword(",").prepend[noSpace].append[oneSpace]
			imp.format(format)
		}
		formatBody(interfaze, format)
	}

	def dispatch void format(XtendAnnotationType annotationType, extension IFormattableDocument format) {
		formatAnnotations(annotationType, format, newLineAfterClassAnnotations)
		formatModifiers(annotationType, format)
		annotationType.regionForKeyword("annotation").append[oneSpace]
		formatBody(annotationType, format)
	}

	def dispatch void format(XtendEnum enumeration, extension IFormattableDocument format) {
		formatAnnotations(enumeration, format, newLineAfterClassAnnotations)
		formatModifiers(enumeration, format)
		enumeration.regionForKeyword("enum").append[oneSpace]
		val clazzOpenBrace = enumeration.regionForKeyword("{")
		clazzOpenBrace.prepend(bracesInNewLine)
		if (!enumeration.members.empty) {
			clazzOpenBrace.append[increaseIndentation]
			clazzOpenBrace.append(blankLinesBeforeFirstMember)
			for (i : 0 .. (enumeration.members.size - 1)) {
				val current = enumeration.members.get(i)
				current.format(format)
				if (i < enumeration.members.size - 1) {
					current.immediatelyFollowingKeyword(",").prepend[noSpace].append(blankLinesBetweenEnumLiterals)
				} else {
					current.append[decreaseIndentation]
					current.append(blankLinesAfterLastMember)
				}
			}
		} else {
			clazzOpenBrace.append[newLine]
		}
	}

	def dispatch void format(XtendConstructor func, extension IFormattableDocument format) {
		formatAnnotations(func, format, newLineAfterConstructorAnnotations)
		formatModifiers(func, format)
		func.regionForKeyword("new").append[noSpace]
		if (!func.typeParameters.empty) {
			func.regionForKeyword("<").append[noSpace]
			for (arg : func.typeParameters) {
				arg.format(format)
				arg.immediatelyFollowingKeyword(",").prepend[noSpace].append[oneSpace]
			}
			func.regionForKeyword(">").surround([noSpace])
		}
		val open = func.regionForKeyword("(")
		val close = func.regionForKeyword(")")
		close.append(bracesInNewLine)
		formatCommaSeparatedList(func.parameters, open, close, format)

		func.expression.format(format)
	}

	def dispatch void format(XtendFunction func, extension IFormattableDocument format) {
		formatAnnotations(func, format, newLineAfterMethodAnnotations)
		formatModifiers(func, format)
		if (!func.typeParameters.empty) {
			func.regionForKeyword("<").append[noSpace]
			for (arg : func.typeParameters) {
				arg.format(format)
				arg.immediatelyFollowingKeyword(",").prepend[noSpace].append[oneSpace]
			}
			func.regionForKeyword(">").prepend[noSpace].append[oneSpace]
		}
		val nameNode = func.regionForFeature(XTEND_FUNCTION__NAME)
		val open = nameNode.immediatelyFollowingKeyword("(")
		val close = func.regionForKeyword(")")
		func.returnType.append[oneSpace]
		open.prepend[noSpace]
		if (func.expression != null)
			close.append(bracesInNewLine)
		formatCommaSeparatedList(func.parameters, open, close, format)
		func.returnType.format(format)
		func.expression.format(format)
	}

	def dispatch void format(XtendField field, extension IFormattableDocument document) {
		formatAnnotations(field, document, newLineAfterFieldAnnotations)
		formatModifiers(field, document)
		if (field.name != null)
			field.type.append[oneSpace]
		field.regionForKeyword("=").prepend[oneSpace].append[oneSpace]
		field.type.format(document)
		field.initialValue.format(document)
	}

	def dispatch void format(XtendParameter param, extension IFormattableDocument format) {
		formatAnnotations(param, format, newLineAfterParameterAnnotations)
		param.parameterType.format(format)
		val nameNode = param.regionForFeature(XTEND_PARAMETER__NAME)
		nameNode.prepend[oneSpace]
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
		member.regionsForRuleCallsTo(commonModifierRule, methodModifierRule, fieldModifierRule).forEach [
			append[oneSpace]
		]
	}

	override protected isSingleLineBlock(XBlockExpression expr) {
		return expr.expressions.size <= 1 && preferences.getPreference(keepOneLineMethods) &&
			expr.eContainer instanceof XtendFunction &&
			!expr.trailingHiddenRegion.immediatelyPrecedingKeyword("}").previousHiddenRegion.multiline
	}

	override protected builder(List<XExpression> params) {
		if (params.last != null) {
			val grammarElement = params.last.invokingGrammarElement
			if (grammarElement == XMemberFeatureCallAccess.memberCallArgumentsXClosureParserRuleCall_1_1_4_0 ||
				grammarElement == XFeatureCallAccess.featureCallArgumentsXClosureParserRuleCall_4_0 ||
				grammarElement == xbaseConstructorCallAccess.argumentsXClosureParserRuleCall_5_0)
				params.last as XClosure
		}
	}

}
