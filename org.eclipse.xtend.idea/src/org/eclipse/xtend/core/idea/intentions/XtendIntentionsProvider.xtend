/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.intentions

import com.google.inject.Inject
import com.google.inject.Provider
import com.intellij.lang.annotation.Annotation
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.module.ModuleUtil
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiFile
import com.intellij.psi.codeStyle.CodeStyleManager
import com.intellij.util.IncorrectOperationException
import org.eclipse.xtend.core.services.XtendGrammarAccess
import org.eclipse.xtend.core.validation.IssueCodes
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.idea.document.DocumentUtils
import org.eclipse.xtext.idea.intentions.AbstractIssueIntentionAction
import org.eclipse.xtext.idea.intentions.IdeaIntentionsProvider
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.psi.XtextPsiExtensions
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.validation.Issue
import org.eclipse.xtext.xbase.ide.contentassist.OverrideProposalUtil
import org.eclipse.xtext.xbase.imports.RewritableImportSection
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.eclipse.xtext.xbase.typesystem.^override.IResolvedConstructor
import org.eclipse.xtext.xbase.typesystem.^override.IResolvedExecutable
import org.eclipse.xtext.xbase.typesystem.^override.IResolvedOperation

import static extension org.eclipse.xtext.EcoreUtil2.*
import org.eclipse.xtend.core.idea.config.XtendLibraryConfigurator

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class XtendIntentionsProvider extends IdeaIntentionsProvider {

	@Inject Provider<InsertXtendMethodsIntentionAction> insertXtendMethodsIntentionActionProvider
	@Inject Provider<InsertSuperConstructorsIntentionAction> insertSuperConstructorsIntentionActionProvider
	@Inject Provider<AddXtendLibToClassPathIntentionAction> addXtendLibToClassPathIntentionAction

	override registerFixes(Annotation anno, Issue issue) {
		if (issue.code == IssueCodes.MISSING_CONSTRUCTOR) {
			anno.registerFix(insertSuperConstructorsIntentionActionProvider.get => [
				it.issue = issue
			])
		} else if (issue.code == IssueCodes.CLASS_MUST_BE_ABSTRACT ||
			issue.code == IssueCodes.ANONYMOUS_CLASS_MISSING_MEMBERS) {
			anno.registerFix(insertXtendMethodsIntentionActionProvider.get => [
				it.issue = issue
			])
		} else if (issue.code == IssueCodes.XBASE_LIB_NOT_ON_CLASSPATH) {
			anno.registerFix(addXtendLibToClassPathIntentionAction.get => [
				it.issue = issue
			])
		}
	}

	abstract static class AbstractMemberAddingIntentionAction extends AbstractIssueIntentionAction {
		@Inject protected OverrideProposalUtil overrideProposalUtil
		@Inject protected RewritableImportSection.Factory importSectionfactory
		@Inject protected extension XtextPsiExtensions
		@Inject protected XtendGrammarAccess grammarAccess
		@Inject protected IJvmModelAssociations jvmModelAssociations
		@Inject protected extension DocumentUtils

		override invoke(Project project, Editor editor, PsiFile file) throws IncorrectOperationException {
			val psiElement = file.findEObjectAssociatedPsiElement(issue.offset)
			if (psiElement === null) {
				return
			}
			val clazz = psiElement.findEObject.getContainerOfType(XtendTypeDeclaration)
			if (clazz === null) {
				return
			}
			val jvmType = jvmModelAssociations.getPrimaryJvmElement(clazz)
			val docMnr = PsiDocumentManager.getInstance(project)
			if (jvmType instanceof JvmGenericType) {
				val insertOffset = findInsertionOffSet(clazz, editor)
				val importSection = importSectionfactory.parse(clazz.eResource as XtextResource)
				val toInsert = getMembersToBeInserted(importSection, jvmType)
				editor.document.insertString(insertOffset, toInsert)
				docMnr.commitDocument(editor.document);
				docMnr.doPostponedOperationsAndUnblockDocument(editor.document)
				CodeStyleManager.getInstance(project).adjustLineIndent(file,
					new TextRange(insertOffset, insertOffset + toInsert.length))
				editor.document.updateImportSection(importSection)
				docMnr.commitDocument(editor.document);
			}
		}

		abstract def String getMembersToBeInserted(RewritableImportSection section, JvmGenericType type)

		protected def getParameters(IResolvedExecutable executable, RewritableImportSection importSection) {
			val result = newArrayList
			for (var i = 0; i < executable.declaration.parameters.size; i++) {
				result +=
					'''«executable.resolvedParameterTypes.get(i).toImportableString(importSection)» «executable.declaration.parameters.get(i).simpleName»'''
			}
			return result
		}

		def findInsertionOffSet(XtendTypeDeclaration class1, Editor editor) {
			val last = class1.members.last
			if (last != null) {
				val n = NodeModelUtils.getNode(last)
				return n.totalOffset + n.totalLength
			} else {
				val n = NodeModelUtils.getNode(class1)
				val openingBracket = n.asTreeIterable.findFirst[it.text == '{']
				if (openingBracket != null) {
					return openingBracket.offset + 1
				}
			}
			// fall back
			return editor.document.text.lastIndexOf('}')
		}
	}

	static class InsertXtendMethodsIntentionAction extends AbstractMemberAddingIntentionAction {
		public static val TEXT = "Implement methods"

		override getText() {
			TEXT
		}

		override getMembersToBeInserted(RewritableImportSection importSection, JvmGenericType jvmType) {
			val candidates = overrideProposalUtil.getImplementationCandidates(jvmType, false)
			val abstractMethods = candidates.filter(IResolvedOperation).filter[it.declaration.isAbstract]
			return '''
				
					«FOR candidate : abstractMethods»
						
						override «candidate.typeParameters.join('<',',','> ')[name]»«candidate.declaration.simpleName»(«candidate.getParameters(importSection).join(', ')») «candidate.declaration.exceptions.join('throws ',', ',' ', [toImportableString(importSection)])»{
							throw new UnsupportedOperationException()
						}
					«ENDFOR»
			'''
		}

	}

	static class InsertSuperConstructorsIntentionAction extends AbstractMemberAddingIntentionAction {
		public static val TEXT = "Create constructors matching super"

		override getText() {
			TEXT
		}

		override getMembersToBeInserted(RewritableImportSection importSection, JvmGenericType jvmType) {
			val candidates = overrideProposalUtil.getImplementationCandidates(jvmType, false)
			val constructors = candidates.filter(IResolvedConstructor)
			return '''
				
					«FOR candidate : constructors»
						
						new («candidate.getParameters(importSection).join(', ')») «candidate.declaration.exceptions.join('throws ',', ',' ', [toImportableString(importSection)])»{
							super(«candidate.declaration.parameters.join(', ')[name]»)
						}
					«ENDFOR»
			'''
		}

	}

	static class AddXtendLibToClassPathIntentionAction extends AbstractIssueIntentionAction {
		@Inject XtendLibraryConfigurator libraryManager
		public static val TEXT = "Add Xtend runtime Library"

		override getText() {
			TEXT
		}

		override invoke(Project project, Editor editor, PsiFile file) throws IncorrectOperationException {
			val module = ModuleUtil.findModuleForPsiElement(file)
			if (module !== null) {
				val model = ModuleRootManager.getInstance(module).modifiableModel
				libraryManager.ensureXtendLibAvailable(model, file)
				model.commit
			}
		}

	}

}
			