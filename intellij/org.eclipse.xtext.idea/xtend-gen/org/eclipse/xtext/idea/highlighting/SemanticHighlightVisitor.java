/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.highlighting;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.intellij.codeInsight.daemon.impl.HighlightInfo;
import com.intellij.codeInsight.daemon.impl.HighlightInfoType;
import com.intellij.codeInsight.daemon.impl.HighlightVisitor;
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder;
import com.intellij.lang.Language;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.progress.ProgressIndicatorProvider;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.idea.highlighting.IdeaHighlightingAttributesProvider;
import org.eclipse.xtext.idea.util.CancelProgressIndicator;
import org.eclipse.xtext.psi.XtextPsiUtils;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.OperationCanceledError;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class SemanticHighlightVisitor implements HighlightVisitor {
  @Inject
  @Named(Constants.LANGUAGE_NAME)
  private String languageId;
  
  @Inject
  private ISemanticHighlightingCalculator highlightCalculator;
  
  @Inject
  @Extension
  private IdeaHighlightingAttributesProvider _ideaHighlightingAttributesProvider;
  
  @Inject
  private OperationCanceledManager operationCanceledManager;
  
  private IHighlightedPositionAcceptor acceptor;
  
  @Override
  public boolean analyze(final PsiFile file, final boolean updateWholeFile, final HighlightInfoHolder holder, final Runnable action) {
    final VirtualFile virtualFile = XtextPsiUtils.findVirtualFile(file);
    Project _project = file.getProject();
    FileEditorManager _instance = FileEditorManager.getInstance(_project);
    boolean _isFileOpen = _instance.isFileOpen(virtualFile);
    boolean _not = (!_isFileOpen);
    if (_not) {
      return true;
    }
    try {
      final IHighlightedPositionAcceptor _function = new IHighlightedPositionAcceptor() {
        @Override
        public void addPosition(final int offset, final int length, final String[] styles) {
          ProgressIndicatorProvider.checkCanceled();
          if ((length > 0)) {
            for (final String it : styles) {
              {
                HighlightInfoType _highlightInfoType = SemanticHighlightVisitor.this._ideaHighlightingAttributesProvider.getHighlightInfoType(it);
                HighlightInfo.Builder _newHighlightInfo = HighlightInfo.newHighlightInfo(_highlightInfoType);
                HighlightInfo.Builder _range = _newHighlightInfo.range(offset, (offset + length));
                HighlightInfo.Builder _description = _range.description(it);
                final HighlightInfo info = _description.create();
                holder.add(info);
              }
            }
          }
        }
      };
      this.acceptor = _function;
      ProgressIndicatorProvider.checkCanceled();
      action.run();
    } finally {
      this.acceptor = null;
    }
    return true;
  }
  
  @Override
  public int order() {
    return 0;
  }
  
  @Override
  public boolean suitableForFile(final PsiFile file) {
    boolean _and = false;
    if (!(file instanceof BaseXtextFile)) {
      _and = false;
    } else {
      Language _language = file.getLanguage();
      String _iD = _language.getID();
      boolean _equals = Objects.equal(this.languageId, _iD);
      _and = _equals;
    }
    return _and;
  }
  
  private volatile long lastRun;
  
  @Override
  public void visit(final PsiElement element) {
    try {
      if ((element instanceof BaseXtextFile)) {
        final XtextResource resource = ((BaseXtextFile)element).getResource();
        long _modificationStamp = resource.getModificationStamp();
        this.lastRun = _modificationStamp;
        CancelProgressIndicator _cancelProgressIndicator = new CancelProgressIndicator();
        this.highlightCalculator.provideHighlightingFor(resource, this.acceptor, _cancelProgressIndicator);
      }
    } catch (final Throwable _t) {
      if (_t instanceof OperationCanceledError) {
        final OperationCanceledError error = (OperationCanceledError)_t;
        this.operationCanceledManager.propagateIfCancelException(error);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Override
  public HighlightVisitor clone() {
    try {
      Class<? extends SemanticHighlightVisitor> _class = this.getClass();
      SemanticHighlightVisitor _newInstance = _class.newInstance();
      final Procedure1<SemanticHighlightVisitor> _function = new Procedure1<SemanticHighlightVisitor>() {
        @Override
        public void apply(final SemanticHighlightVisitor it) {
          it.acceptor = SemanticHighlightVisitor.this.acceptor;
        }
      };
      return ObjectExtensions.<SemanticHighlightVisitor>operator_doubleArrow(_newInstance, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
