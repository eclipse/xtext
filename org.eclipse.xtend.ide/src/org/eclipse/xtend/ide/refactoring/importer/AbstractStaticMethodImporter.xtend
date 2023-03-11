/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.refactoring.importer

import com.google.inject.Inject
import java.util.List
import org.eclipse.jface.text.DocumentRewriteSessionType
import org.eclipse.jface.text.IDocumentExtension4
import org.eclipse.jface.text.ITextSelection
import org.eclipse.xtend.core.services.XtendGrammarAccess
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.ui.editor.model.IXtextDocument
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.imports.ImportOrganizer
import org.eclipse.xtext.xbase.ui.document.DocumentRewriter
import org.eclipse.xtext.xbase.ui.imports.ReplaceConverter
import org.eclipse.xtext.xbase.ui.refactoring.ExpressionUtil
import org.eclipse.xtext.xbase.ui.refactoring.RefactoredResourceCopier

/**
 * Base class for static method importers, it takes care of finding the expression
 * from a text selection and determine if it's a candidate for static import, as well
 * as finding all the occurrences.
 * 
 * @author vivien.jovet - Initial contribution and API
 */
abstract class AbstractStaticMethodImporter {

    @Inject
    protected extension ExpressionUtil expressionUtil

    @Inject
    protected extension ReplaceConverter replaceConverter

    @Inject
    protected extension RefactoredResourceCopier resourceCopier

    @Inject
    protected DocumentRewriter.Factory rewriterFactory

    @Inject
    protected XtendGrammarAccess grammar

    @Inject
    protected ImportOrganizer importOrganizer

    /**
     * Returns whether or not the import should be an extension
     */
    def protected boolean useExtension() { false }

    /**
     * Computes the changes necessary to use the given call as static. Changes should be added to the rewriter.
     * 
     * @param call the call to change
     * @param rewriter the DocumentRewriter that will apply the changes
     */
    def protected void computeChange(XMemberFeatureCall call, DocumentRewriter rewriter)

    /**
     * Computes the changes necessary for all the given calls. Changes should be added to the rewriter.
     * 
     * @param calls the calls to change
     * @param rewriter the DocumentRewriter that will apply the changes
     */
    def protected void computeChanges(List<XMemberFeatureCall> calls, DocumentRewriter rewriter) {
        calls.forEach[computeChange(rewriter)]
    }

    /**
     * Imports the selected method in the document as static method is possible.
     * 
     * @param document the document to modify
     * @param selection the selection in the document
     */
    def boolean importStaticMethod(IXtextDocument document, ITextSelection selection) {
        val resource = document.priorityReadOnly[loadIntoNewResourceSet]
        val expression = resource.findSelectedExpression(selection)

        if (expression instanceof XMemberFeatureCall) {
            val call = expression

            if (call.static && !call.extension) {
                val toImport = call.computeImport

                // find all the occurrences of that call in the resource
                // order it so that the selected call is the first in the list
                val calls = resource.allContents.filter(XMemberFeatureCall).filter [
                    call.feature == feature && !extension
                ].toList.sortBy[it !== call]

                val documentRewriter = rewriterFactory.create(document, resource)

                val rewriteSession = if (document instanceof IDocumentExtension4)
                        document.startRewriteSession(DocumentRewriteSessionType.UNRESTRICTED)

                // add the static import or static extension import
                // calling newSection is necessary to have access to the importSection
                documentRewriter.newSection(0, 0).importSection => [
                    if (useExtension)
                        addStaticExtensionImport(toImport.key, toImport.value)
                    else
                        addStaticImport(toImport.key, toImport.value)
                ]

                // leave changes computation to the sub classes
                calls.computeChanges(documentRewriter)

                val changes = documentRewriter.changes
                changes.convertToTextEdit?.apply(document)

                // organize imports after the changes are applied to remove the probable unused import
                importOrganizer.getOrganizedImportChanges(document.priorityReadOnly[loadIntoNewResourceSet])?.
                    convertToTextEdit?.apply(document)

                if (rewriteSession !== null)
                    (document as IDocumentExtension4).stopRewriteSession(rewriteSession)
            }
        }

        false
    }

    /**
     * Returns the import that should be added for the given call.
     * 
     * @param call the call to import
     * @return a Pair where the key is the is the type fqn and the value the member
     */
    def private Pair<String, String> computeImport(XMemberFeatureCall call) {
        (call.feature.eContainer as JvmGenericType).identifier -> call.feature.simpleName
    }

}
