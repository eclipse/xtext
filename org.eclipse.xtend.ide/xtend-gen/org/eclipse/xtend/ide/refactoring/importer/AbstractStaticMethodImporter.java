/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.refactoring.importer;

import com.google.common.base.Objects;
import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.DocumentRewriteSession;
import org.eclipse.jface.text.DocumentRewriteSessionType;
import org.eclipse.jface.text.IDocumentExtension4;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtend.core.services.XtendGrammarAccess;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.imports.ImportOrganizer;
import org.eclipse.xtext.xbase.imports.RewritableImportSection;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.ui.document.DocumentRewriter;
import org.eclipse.xtext.xbase.ui.imports.ReplaceConverter;
import org.eclipse.xtext.xbase.ui.refactoring.ExpressionUtil;
import org.eclipse.xtext.xbase.ui.refactoring.RefactoredResourceCopier;

/**
 * Base class for static method importers, it takes care of finding the expression
 * from a text selection and determine if it's a candidate for static import, as well
 * as finding all the occurrences.
 * 
 * @author vivien.jovet - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractStaticMethodImporter {
  @Inject
  @Extension
  protected ExpressionUtil expressionUtil;

  @Inject
  @Extension
  protected ReplaceConverter replaceConverter;

  @Inject
  @Extension
  protected RefactoredResourceCopier resourceCopier;

  @Inject
  protected DocumentRewriter.Factory rewriterFactory;

  @Inject
  protected XtendGrammarAccess grammar;

  @Inject
  protected ImportOrganizer importOrganizer;

  /**
   * Returns whether or not the import should be an extension
   */
  protected boolean useExtension() {
    return false;
  }

  /**
   * Computes the changes necessary to use the given call as static. Changes should be added to the rewriter.
   * 
   * @param call the call to change
   * @param rewriter the DocumentRewriter that will apply the changes
   */
  protected abstract void computeChange(final XMemberFeatureCall call, final DocumentRewriter rewriter);

  /**
   * Computes the changes necessary for all the given calls. Changes should be added to the rewriter.
   * 
   * @param calls the calls to change
   * @param rewriter the DocumentRewriter that will apply the changes
   */
  protected void computeChanges(final List<XMemberFeatureCall> calls, final DocumentRewriter rewriter) {
    final Consumer<XMemberFeatureCall> _function = (XMemberFeatureCall it) -> {
      this.computeChange(it, rewriter);
    };
    calls.forEach(_function);
  }

  /**
   * Imports the selected method in the document as static method is possible.
   * 
   * @param document the document to modify
   * @param selection the selection in the document
   */
  public boolean importStaticMethod(final IXtextDocument document, final ITextSelection selection) {
    try {
      boolean _xblockexpression = false;
      {
        final IUnitOfWork<XtextResource, XtextResource> _function = (XtextResource it) -> {
          return this.resourceCopier.loadIntoNewResourceSet(it);
        };
        final XtextResource resource = document.<XtextResource>priorityReadOnly(_function);
        final XExpression expression = this.expressionUtil.findSelectedExpression(resource, selection);
        if ((expression instanceof XMemberFeatureCall)) {
          final XMemberFeatureCall call = ((XMemberFeatureCall)expression);
          if ((call.isStatic() && (!call.isExtension()))) {
            final Pair<String, String> toImport = this.computeImport(call);
            final Function1<XMemberFeatureCall, Boolean> _function_1 = (XMemberFeatureCall it) -> {
              return Boolean.valueOf((Objects.equal(call.getFeature(), it.getFeature()) && (!it.isExtension())));
            };
            final Function1<XMemberFeatureCall, Boolean> _function_2 = (XMemberFeatureCall it) -> {
              return Boolean.valueOf((it != call));
            };
            final List<XMemberFeatureCall> calls = IterableExtensions.<XMemberFeatureCall, Boolean>sortBy(IteratorExtensions.<XMemberFeatureCall>toList(IteratorExtensions.<XMemberFeatureCall>filter(Iterators.<XMemberFeatureCall>filter(resource.getAllContents(), XMemberFeatureCall.class), _function_1)), _function_2);
            final DocumentRewriter documentRewriter = this.rewriterFactory.create(document, resource);
            DocumentRewriteSession _xifexpression = null;
            if ((document instanceof IDocumentExtension4)) {
              _xifexpression = ((IDocumentExtension4)document).startRewriteSession(DocumentRewriteSessionType.UNRESTRICTED);
            }
            final DocumentRewriteSession rewriteSession = _xifexpression;
            RewritableImportSection _importSection = documentRewriter.newSection(0, 0).getImportSection();
            final Procedure1<RewritableImportSection> _function_3 = (RewritableImportSection it) -> {
              boolean _useExtension = this.useExtension();
              if (_useExtension) {
                it.addStaticExtensionImport(toImport.getKey(), toImport.getValue());
              } else {
                it.addStaticImport(toImport.getKey(), toImport.getValue());
              }
            };
            ObjectExtensions.<RewritableImportSection>operator_doubleArrow(_importSection, _function_3);
            this.computeChanges(calls, documentRewriter);
            final List<ReplaceRegion> changes = documentRewriter.getChanges();
            TextEdit _convertToTextEdit = this.replaceConverter.convertToTextEdit(changes);
            if (_convertToTextEdit!=null) {
              _convertToTextEdit.apply(document);
            }
            final IUnitOfWork<XtextResource, XtextResource> _function_4 = (XtextResource it) -> {
              return this.resourceCopier.loadIntoNewResourceSet(it);
            };
            List<ReplaceRegion> _organizedImportChanges = this.importOrganizer.getOrganizedImportChanges(document.<XtextResource>priorityReadOnly(_function_4));
            TextEdit _convertToTextEdit_1 = null;
            if (_organizedImportChanges!=null) {
              _convertToTextEdit_1=this.replaceConverter.convertToTextEdit(_organizedImportChanges);
            }
            if (_convertToTextEdit_1!=null) {
              _convertToTextEdit_1.apply(document);
            }
            if ((rewriteSession != null)) {
              ((IDocumentExtension4) document).stopRewriteSession(rewriteSession);
            }
          }
        }
        _xblockexpression = false;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Returns the import that should be added for the given call.
   * 
   * @param call the call to import
   * @return a Pair where the key is the is the type fqn and the value the member
   */
  private Pair<String, String> computeImport(final XMemberFeatureCall call) {
    EObject _eContainer = call.getFeature().eContainer();
    String _identifier = ((JvmGenericType) _eContainer).getIdentifier();
    String _simpleName = call.getFeature().getSimpleName();
    return Pair.<String, String>of(_identifier, _simpleName);
  }
}
