/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.completion

import com.google.inject.Inject
import com.intellij.codeInsight.completion.AllClassesGetter
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.codeInsight.completion.InsertHandler
import com.intellij.codeInsight.completion.InsertionContext
import com.intellij.codeInsight.completion.JavaClassNameCompletionContributor
import com.intellij.codeInsight.completion.JavaCompletionSorting
import com.intellij.codeInsight.completion.JavaPsiClassReferenceElement
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.PsiModifier
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.TypesPackage
import org.eclipse.xtext.common.types.access.IJvmTypeProvider
import org.eclipse.xtext.idea.lang.AbstractXtextLanguage
import org.eclipse.xtext.psi.impl.BaseXtextFile
import org.eclipse.xtext.xbase.XbasePackage
import org.eclipse.xtext.xbase.imports.RewritableImportSection
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess
import org.eclipse.xtext.xtype.XtypePackage
import com.intellij.codeInsight.completion.CompletionSorter

class XbaseCompletionContributor extends XtypeCompletionContributor {
	
	@Inject XbaseGrammarAccess grammarAccess
	
	@Inject ImportAddingInsertHandler importAddingInsertHandler

	new(AbstractXtextLanguage lang) {
		super(lang)
		completeJvmParameterizedTypeReference_Type
		completeXImportDeclaration_ImportedType
		completeXConstructorCall_Constructor
		completeXTypeLiteral_Type
		completeJavaTypeWithinMultiLineComment
		completeJavaTypeWithinExpressionContext
	}

	protected override getCompletionSorter(CompletionParameters parameters, CompletionResultSet result) {
		CompletionSorter.defaultSorter(parameters, result.prefixMatcher).weighBefore("liftShorter", new XbaseLookupElementWeigher)
	}
	
	protected def void completeJavaTypeWithinExpressionContext() {
		for (expressionContextFollowElement : expressionContextFollowElements) {
			extend(CompletionType.BASIC, expressionContextFollowElement) [
				completeJavaTypes($0, $2, true) [true]
			]
		}
	}
	
	protected def getExpressionContextFollowElements() {
		#{grammarAccess.XPrimaryExpressionAccess.XFeatureCallParserRuleCall_4}
	}
	
	protected def void completeJavaTypeWithinMultiLineComment() {
		for (mlCommentTokenType : multiLineCommentTokens.types) {
			extend(CompletionType.BASIC, PlatformPatterns.psiElement(mlCommentTokenType)) [
				completeJavaTypes($0, $2, false) [true]
			]
		}
	}

	protected def completeJvmParameterizedTypeReference_Type() {
		completeJavaTypes(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE)
	}

	protected def completeXImportDeclaration_ImportedType() {
		completeJavaTypes(XtypePackage.Literals.XIMPORT_DECLARATION__IMPORTED_TYPE, false)[true]
	}

	protected def completeXConstructorCall_Constructor() {
		completeJavaTypes(XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR, true) [
			val type = object
			!type.hasModifierProperty(PsiModifier.ABSTRACT) && !type.interface
		]
	}

	protected def completeXTypeLiteral_Type() {
		completeJavaTypes(XbasePackage.Literals.XTYPE_LITERAL__TYPE)
	}

	protected def void completeJavaTypes(EReference reference) {
		completeJavaTypes(reference, true)
	}
	
	protected def void completeJavaTypes(EReference reference, boolean addImport) {
		completeJavaTypes(reference, addImport)[true]
	}

	protected def void completeJavaTypes(EReference reference, boolean addImport, (JavaPsiClassReferenceElement)=>boolean filter) {
		extend(CompletionType.BASIC, reference) [
			completeJavaTypes($0, $2, addImport, filter)
		]
	}

	protected def completeJavaTypes(
		CompletionParameters completionParameters,
		CompletionResultSet completionResultSet,
		boolean addImport,
		(JavaPsiClassReferenceElement)=>boolean filter
	) {
		JavaClassNameCompletionContributor.addAllClasses(
			completionParameters,
			completionParameters.invocationCount <= 2,
			JavaCompletionSorting.addJavaSorting(completionParameters, completionResultSet).prefixMatcher
		) [
			if (it instanceof JavaPsiClassReferenceElement) {
				if (filter.apply(it)) {
					if (addImport) {
						insertHandler = importAddingInsertHandler
					}
					completionResultSet.addElement(it)
				}
			}
		]
	}
	
	static class ImportAddingInsertHandler implements InsertHandler<JavaPsiClassReferenceElement> {
		
		@Inject RewritableImportSection.Factory factory
		
		override handleInsert(InsertionContext context, JavaPsiClassReferenceElement item) {
			val file = context.file
			if (file instanceof BaseXtextFile) {
				val resource = file.resource
				val typeProvider = resource.resourceServiceProvider.get(IJvmTypeProvider.Factory).findTypeProvider(resource.resourceSet)
				val jvmType = typeProvider.findTypeByName(item.qualifiedName)
				if (jvmType instanceof JvmDeclaredType) {
					val String simpleName = jvmType.simpleName 
					context.document.replaceString(context.startOffset, context.tailOffset, simpleName) 
					val importSection = factory.parse(resource)
					if (importSection.addImport(jvmType)) {
						val regions = importSection.rewrite
						for (reg : regions) {
							context.document.replaceString(reg.offset, reg.endOffset, reg.text)
						}
					}
				} else {
					AllClassesGetter.INSERT_FQN.handleInsert(context, item)
				}
			} else {
				throw new IllegalStateException("Not an Xtext psi file "+file) 
			}
		}
		
	}

}


