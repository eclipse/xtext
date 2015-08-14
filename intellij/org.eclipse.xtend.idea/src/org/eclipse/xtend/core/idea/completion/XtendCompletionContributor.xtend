/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.completion

import com.google.inject.Inject
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.codeInsight.completion.InsertHandler
import com.intellij.codeInsight.completion.InsertionContext
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.icons.AllIcons
import com.intellij.openapi.editor.ScrollType
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.codeStyle.CodeStyleManager
import org.eclipse.xtend.core.idea.editorActions.XtendTokenSetProvider
import org.eclipse.xtend.core.idea.lang.XtendLanguage
import org.eclipse.xtend.core.xtend.XtendPackage
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.idea.document.DocumentUtils
import org.eclipse.xtext.idea.lang.AbstractXtextLanguage
import org.eclipse.xtext.psi.XtextPsiExtensions
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.xbase.ide.contentassist.OverrideProposalUtil
import org.eclipse.xtext.xbase.imports.RewritableImportSection
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.eclipse.xtext.xbase.typesystem.^override.IResolvedConstructor
import org.eclipse.xtext.xbase.typesystem.^override.IResolvedExecutable
import org.eclipse.xtext.xbase.typesystem.^override.IResolvedOperation

import static extension com.intellij.openapi.editor.EditorModificationUtil.*
import static extension org.eclipse.xtext.EcoreUtil2.*

class XtendCompletionContributor extends AbstractXtendCompletionContributor {

	@Inject extension XtextPsiExtensions
	@Inject XtendTokenSetProvider tokenSetProvider
	@Inject IJvmModelAssociations jvmModelAssociations
	@Inject OverrideProposalUtil overrideProposalUtil
	@Inject RewritableImportSection.Factory importSectionfactory
	@Inject extension DocumentUtils documentUtils

	new() {
		this(XtendLanguage.INSTANCE)
	}

	new(AbstractXtextLanguage lang) {
		super(lang)
		completeAbstractSuperMethods
		completeFrenchQuote
	}
	
	protected def void completeFrenchQuote() {
		extend(
			CompletionType.BASIC,
			#[tokenSetProvider.richStringLiteralTokens]
		) [
			$2 += LookupElementBuilder.create('«').withInsertHandler[ context, item |
				context.editor.insertStringAtCaret('»', false, false)
			]
		]
	}

	protected def completeAbstractSuperMethods() {
		extend(
			CompletionType.BASIC,
			XtendPackage.Literals.XTEND_TYPE_DECLARATION__MEMBERS
		) [
			val psiElement = $0.position
			val clazz = psiElement.findEObject?.getContainerOfType(XtendTypeDeclaration)
			if (clazz == null) {
				return
			}
			val jvmType = jvmModelAssociations.getPrimaryJvmElement(clazz)
			if (jvmType instanceof JvmGenericType) {
				val candidates = overrideProposalUtil.getImplementationCandidates(jvmType, clazz.isAnonymous)
				for (candidate : candidates) {
					if (candidate instanceof IResolvedOperation) {
						$2.addElement(createOverrideMethodElement(candidate) [InsertionContext context, LookupElement item|
							// delete typed prefix string
							context.getDocument().deleteString(context.getStartOffset(), context.getTailOffset());
	    					context.commitDocument();
	    					// insert method
	    					val importSection = importSectionfactory.parse(clazz.eResource as XtextResource)
	    					context.insertAndAdjust('''
	    						override «candidate.typeParameters.join('<',',','> ')[name]»«candidate.declaration.simpleName»(«candidate.getParameterText(importSection).join(', ')») «candidate.declaration.exceptions.join('throws ',', ',' ', [toImportableString(importSection)])»{
	    							«START_SELECTION_MARKER»throw new UnsupportedOperationException()«END_SELECTION_MARKER»
	    						}
	    					''')
	    					context.document.updateImportSection(importSection)
						])
					} else if (candidate instanceof IResolvedConstructor) {
						$2.addElement(createOverrideConstructorElement(candidate) [InsertionContext context, LookupElement item|
							// delete typed prefix string
							context.getDocument().deleteString(context.getStartOffset(), context.getTailOffset());
	    					context.commitDocument();
	    					//  insert constructor
	    					val importSection = importSectionfactory.parse(clazz.eResource as XtextResource)
	    					context.insertAndAdjust('''
	    						new («candidate.getParameterText(importSection).join(', ')») «candidate.declaration.exceptions.join('throws ',', ',' ', [toImportableString(importSection)])»{
	    							super(«candidate.declaration.parameters.join(', ')[name]»)«SELECTION_MARKER»
	    						}
	    					''')
	    					// insert imports
	    					context.document.updateImportSection(importSection)
						])
					}
				}
			}
		]
	}

	private final static String START_SELECTION_MARKER = "<START_SELECTION>"
	private final static String END_SELECTION_MARKER = "<END_SELECTION>"
	private final static String SELECTION_MARKER = "<CURSOR>"
	
	protected def void insertAndAdjust(InsertionContext context, String toInsert) {
		val startIndex = toInsert.indexOf(START_SELECTION_MARKER)
		var cleanedText = toInsert.replace(START_SELECTION_MARKER,"")
		val endIndex = cleanedText.indexOf(END_SELECTION_MARKER)
		cleanedText = cleanedText.replace(END_SELECTION_MARKER,"")
		val cursorIndex = cleanedText.indexOf(SELECTION_MARKER)
		cleanedText = cleanedText.replace(SELECTION_MARKER,"") 
		val start = if (cursorIndex != -1) cursorIndex else startIndex
		val end = if (cursorIndex != -1) cursorIndex else endIndex
		context.document.insertString(context.startOffset, cleanedText)
		var fullChange = context.document.createRangeMarker(context.startOffset, context.startOffset+cleanedText.length) 
	    val editor = context.editor
	    editor.getCaretModel().moveToOffset(fullChange.startOffset + Math.min(start, end)) 
	    editor.getScrollingModel().scrollToCaret(ScrollType.RELATIVE) 
	    if (start < end) {
			editor.getSelectionModel().setSelection(fullChange.startOffset + start, fullChange.startOffset + end)
		}
		context.commitDocument
		PsiDocumentManager.getInstance(context.project).doPostponedOperationsAndUnblockDocument(context.document) 
		if (fullChange.isValid()) {
			CodeStyleManager.getInstance(context.project).adjustLineIndent(context.file, new TextRange(fullChange.startOffset, fullChange.endOffset)) 
		}
	}
	
	protected def getParameterText(IResolvedExecutable executable, RewritableImportSection importSection) {
		val result = newArrayList
		for (var i =0; i < executable.declaration.parameters.size; i++) {
			result += '''«executable.resolvedParameterTypes.get(i).toImportableString(importSection)» «executable.declaration.parameters.get(i).simpleName»'''
		}
		return result
	}
	
	protected def LookupElementBuilder createOverrideMethodElement(IResolvedOperation prototype, InsertHandler<LookupElement> insertHandler) {
		var methodName = prototype.declaration.simpleName
		var signature = '''override «methodName»(«prototype.resolvedParameterTypes.join(',')[humanReadableName]»)'''
		var String overrideSignature = '''override «signature»'''
		var LookupElementBuilder element = LookupElementBuilder.create(prototype, signature)
			.withLookupString(methodName)
			.withLookupString(overrideSignature)
			.withInsertHandler(insertHandler)
			.appendTailText(" {...}", true).
			withTypeText(prototype.resolvedDeclarator.humanReadableName)
			.withIcon(AllIcons.Nodes.Method)
		return element
	}
	
	protected def LookupElementBuilder createOverrideConstructorElement(IResolvedConstructor prototype, InsertHandler<LookupElement> insertHandler) {
		var signature = '''new («prototype.resolvedParameterTypes.join(',')[humanReadableName]»)'''
		var LookupElementBuilder element = LookupElementBuilder.create(prototype, signature)
			.withLookupString(signature)
			
			.withInsertHandler(insertHandler)
			.appendTailText(" {...}", true)
			.withTypeText(prototype.resolvedDeclarator.humanReadableName)
			.withIcon(AllIcons.Nodes.Method) // IDEA seems to use the method icon for constructors, too
		return element
	}

}

