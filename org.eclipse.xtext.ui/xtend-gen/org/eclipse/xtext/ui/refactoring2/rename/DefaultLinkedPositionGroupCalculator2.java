/**
 * Copyright (c) 2017 by TypeFox (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.refactoring2.rename;

import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.link.LinkedPosition;
import org.eclipse.jface.text.link.LinkedPositionGroup;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.ide.refactoring.IRenameStrategy2;
import org.eclipse.xtext.ide.refactoring.RenameChange;
import org.eclipse.xtext.ide.refactoring.RenameContext;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.ide.serializer.IEmfResourceChange;
import org.eclipse.xtext.ide.serializer.ITextDocumentChange;
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.refactoring.ILinkedPositionGroupCalculator;
import org.eclipse.xtext.ui.refactoring.impl.CachingResourceSetProvider;
import org.eclipse.xtext.ui.refactoring.impl.ProjectUtil;
import org.eclipse.xtext.ui.refactoring.impl.RefactoringResourceSetProvider;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.ui.refactoring2.LtkIssueAcceptor;
import org.eclipse.xtext.ui.refactoring2.rename.ISimpleNameProvider;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * Calculates the linked positions for simultaneous editing when a refactoring is triggered in linked mode.
 * 
 * @author Jan Koehnlein
 */
@SuppressWarnings("all")
public class DefaultLinkedPositionGroupCalculator2 implements ILinkedPositionGroupCalculator {
  private static final Logger LOG = Logger.getLogger(DefaultLinkedPositionGroupCalculator2.class);
  
  @Inject
  private ProjectUtil projectUtil;
  
  @Inject
  private RefactoringResourceSetProvider resourceSetProvider;
  
  @Inject
  private ISimpleNameProvider simpleNameProvider;
  
  @Inject
  private IGlobalServiceProvider globalServiceProvider;
  
  @Inject
  private IResourceServiceProvider.Registry resourceServiceProviderRegistry;
  
  @Override
  public Provider<LinkedPositionGroup> getLinkedPositionGroup(final IRenameElementContext renameElementContext, final IProgressMonitor monitor) {
    final SubMonitor progress = SubMonitor.convert(monitor, 100);
    IEditorPart _triggeringEditor = renameElementContext.getTriggeringEditor();
    final XtextEditor editor = ((XtextEditor) _triggeringEditor);
    final IProject project = this.projectUtil.getProject(renameElementContext.getContextResourceURI());
    if ((project == null)) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Could not determine project for context resource ");
      URI _contextResourceURI = renameElementContext.getContextResourceURI();
      _builder.append(_contextResourceURI);
      String _string = _builder.toString();
      throw new IllegalStateException(_string);
    }
    final CachingResourceSetProvider resourceSetProvider = new CachingResourceSetProvider(this.resourceSetProvider);
    final ResourceSet resourceSet = resourceSetProvider.get(project);
    final EObject targetElement = resourceSet.getEObject(renameElementContext.getTargetElementURI(), true);
    if ((targetElement == null)) {
      throw new IllegalStateException("Target element could not be loaded");
    }
    boolean _isCanceled = monitor.isCanceled();
    if (_isCanceled) {
      throw new OperationCanceledException();
    }
    IRenameStrategy2 renameStrategy = this.globalServiceProvider.<IRenameStrategy2>findService(targetElement, IRenameStrategy2.class);
    if ((renameStrategy == null)) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Cannot find a rename strategy for ");
      URI _targetElementURI = renameElementContext.getTargetElementURI();
      _builder_1.append(_targetElementURI);
      throw new IllegalArgumentException(_builder_1.toString());
    }
    final String oldName = this.simpleNameProvider.getSimpleName(targetElement);
    final String newName = this.getNewDummyName(oldName);
    final IResourceServiceProvider resourceServiceProvider = this.resourceServiceProviderRegistry.getResourceServiceProvider(
      renameElementContext.getTargetElementURI());
    final LtkIssueAcceptor issues = resourceServiceProvider.<LtkIssueAcceptor>get(LtkIssueAcceptor.class);
    final IChangeSerializer changeSerializer = resourceServiceProvider.<IChangeSerializer>get(IChangeSerializer.class);
    changeSerializer.setUpdateRelatedFiles(false);
    URI _targetElementURI_1 = renameElementContext.getTargetElementURI();
    final RenameChange change = new RenameChange(newName, _targetElementURI_1);
    final RenameContext renameContext = new RenameContext(Collections.<RenameChange>unmodifiableList(CollectionLiterals.<RenameChange>newArrayList(change)), resourceSet, changeSerializer, issues);
    renameStrategy.applyRename(renameContext);
    final ArrayList<ReplaceEdit> replaceEdits = CollectionLiterals.<ReplaceEdit>newArrayList();
    final IAcceptor<IEmfResourceChange> _function = (IEmfResourceChange c) -> {
      if ((c instanceof ITextDocumentChange)) {
        final Function1<ITextReplacement, ReplaceEdit> _function_1 = (ITextReplacement replacement) -> {
          int _offset = replacement.getOffset();
          int _length = replacement.getLength();
          String _replacementText = replacement.getReplacementText();
          return new ReplaceEdit(_offset, _length, _replacementText);
        };
        List<ReplaceEdit> _map = ListExtensions.<ITextReplacement, ReplaceEdit>map(((ITextDocumentChange)c).getReplacements(), _function_1);
        Iterables.<ReplaceEdit>addAll(replaceEdits, _map);
      }
    };
    changeSerializer.applyModifications(_function);
    boolean _isCanceled_1 = monitor.isCanceled();
    if (_isCanceled_1) {
      throw new OperationCanceledException();
    }
    final Provider<LinkedPositionGroup> _function_1 = () -> {
      return this.createLinkedGroupFromReplaceEdits(replaceEdits, editor, oldName, progress.newChild(10));
    };
    return _function_1;
  }
  
  protected String getNewDummyName(final String oldName) {
    return (oldName + oldName);
  }
  
  protected LinkedPositionGroup createLinkedGroupFromReplaceEdits(final List<ReplaceEdit> edits, final XtextEditor xtextEditor, final String originalName, final SubMonitor progress) {
    if ((edits == null)) {
      return null;
    }
    final IXtextDocument document = xtextEditor.getDocument();
    final LinkedPositionGroup group = new LinkedPositionGroup();
    final Function1<ReplaceEdit, LinkedPosition> _function = (ReplaceEdit it) -> {
      try {
        final String textToReplace = document.get(it.getOffset(), it.getLength());
        final int indexOf = textToReplace.indexOf(originalName);
        if ((indexOf != (-1))) {
          int _offset = it.getOffset();
          final int calculatedOffset = (_offset + indexOf);
          int _length = originalName.length();
          return new LinkedPosition(document, calculatedOffset, _length);
        }
      } catch (final Throwable _t) {
        if (_t instanceof BadLocationException) {
          final BadLocationException exc = (BadLocationException)_t;
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Skipping invalid text edit ");
          _builder.append(it);
          DefaultLinkedPositionGroupCalculator2.LOG.error(_builder, exc);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      return null;
    };
    final Iterable<LinkedPosition> linkedPositions = IterableExtensions.<LinkedPosition>filterNull(ListExtensions.<ReplaceEdit, LinkedPosition>map(edits, _function));
    progress.worked(10);
    final int invocationOffset = xtextEditor.getInternalSourceViewer().getSelectedRange().x;
    int i = 0;
    Iterable<LinkedPosition> _sortPositions = this.sortPositions(linkedPositions, invocationOffset);
    for (final LinkedPosition position : _sortPositions) {
      try {
        position.setSequenceNumber(i);
        i++;
        group.addPosition(position);
      } catch (final Throwable _t) {
        if (_t instanceof BadLocationException) {
          final BadLocationException e = (BadLocationException)_t;
          DefaultLinkedPositionGroupCalculator2.LOG.error(e.getMessage(), e);
          return null;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
    return group;
  }
  
  protected Iterable<LinkedPosition> sortPositions(final Iterable<LinkedPosition> linkedPositions, final int invocationOffset) {
    abstract class __DefaultLinkedPositionGroupCalculator2_1 implements Comparator<LinkedPosition> {
      abstract int rank(final LinkedPosition o1);
    }
    
    final __DefaultLinkedPositionGroupCalculator2_1 comparator = new __DefaultLinkedPositionGroupCalculator2_1() {
      @Override
      public int compare(final LinkedPosition left, final LinkedPosition right) {
        int _rank = this.rank(left);
        int _rank_1 = this.rank(right);
        return (_rank - _rank_1);
      }
      
      int rank(final LinkedPosition o1) {
        final int relativeRank = ((o1.offset + o1.length) - invocationOffset);
        if ((relativeRank < 0)) {
          return (Integer.MAX_VALUE + relativeRank);
        } else {
          return relativeRank;
        }
      }
    };
    return ImmutableSortedSet.<LinkedPosition>copyOf(comparator, linkedPositions);
  }
}
