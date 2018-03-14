/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.refactoring2;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.List;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.TextChange;
import org.eclipse.ltk.core.refactoring.TextFileChange;
import org.eclipse.ltk.core.refactoring.resource.MoveResourceChange;
import org.eclipse.ltk.core.refactoring.resource.RenameResourceChange;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor;
import org.eclipse.xtext.ide.serializer.IEmfResourceChange;
import org.eclipse.xtext.ide.serializer.ITextDocumentChange;
import org.eclipse.xtext.ui.refactoring.impl.EditorDocumentChange;
import org.eclipse.xtext.ui.refactoring2.ReplaceFileContentChange;
import org.eclipse.xtext.ui.refactoring2.ResourceURIConverter;
import org.eclipse.xtext.ui.refactoring2.TryWithResource;
import org.eclipse.xtext.ui.util.DisplayRunnableWithResult;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * Converts {@link IEmfResourceChange}s to LTK {@link Change}s.
 * 
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@SuppressWarnings("all")
public class ChangeConverter implements IAcceptor<IEmfResourceChange> {
  public static class Factory {
    @Inject
    private ResourceURIConverter resourceURIConverter;
    
    @Inject(optional = true)
    private IWorkbench workbench;
    
    public ChangeConverter create(final String name, final Predicate<Change> changeFilter, final RefactoringIssueAcceptor issues) {
      return new ChangeConverter(name, changeFilter, issues, this.resourceURIConverter, this.workbench);
    }
  }
  
  private CompositeChange currentChange;
  
  private RefactoringIssueAcceptor issues;
  
  private Predicate<Change> changeFilter;
  
  @Extension
  private ResourceURIConverter resourceUriConverter;
  
  private IWorkbench workbench;
  
  protected ChangeConverter(final String name, final Predicate<Change> changeFilter, final RefactoringIssueAcceptor issues, final ResourceURIConverter uriConverter, final IWorkbench workbench) {
    CompositeChange _compositeChange = new CompositeChange(name);
    this.currentChange = _compositeChange;
    this.issues = issues;
    this.changeFilter = changeFilter;
    this.resourceUriConverter = uriConverter;
    this.workbench = workbench;
  }
  
  @Override
  public void accept(final IEmfResourceChange emfResourceChange) {
    this.doConvert(emfResourceChange);
  }
  
  public Change getChange() {
    int _length = this.currentChange.getChildren().length;
    boolean _tripleEquals = (_length == 0);
    if (_tripleEquals) {
      return null;
    } else {
      return this.currentChange;
    }
  }
  
  protected void doConvert(final IEmfResourceChange change) {
    this.handleReplacements(change);
    this.handleUriChange(change);
    boolean _affectsPersistedFiles = this.affectsPersistedFiles();
    if (_affectsPersistedFiles) {
      this.saveEditorsAfterApply();
    }
  }
  
  protected void _handleReplacements(final IEmfResourceChange change) {
    final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    final Procedure0 _function = () -> {
      try {
        final IFile file = this.resourceUriConverter.toFile(change.getResource().getURI());
        boolean _canWrite = this.canWrite(file);
        boolean _not = (!_canWrite);
        if (_not) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Affected file \'");
          IPath _fullPath = file.getFullPath();
          _builder.append(_fullPath);
          _builder.append("\' is read-only");
          this.issues.add(RefactoringIssueAcceptor.Severity.ERROR, _builder.toString());
        }
        this.checkDerived(file);
        change.getResource().save(outputStream, null);
        final byte[] newContent = outputStream.toByteArray();
        String _lastSegment = change.getOldURI().lastSegment();
        final ReplaceFileContentChange ltkChange = new ReplaceFileContentChange(_lastSegment, file, newContent);
        this.addChange(ltkChange);
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    TryWithResource.tryWith(outputStream, _function);
  }
  
  protected void _handleReplacements(final ITextDocumentChange change) {
    int _size = change.getReplacements().size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      final IFile file = this.resourceUriConverter.toFile(change.getOldURI());
      boolean _canWrite = this.canWrite(file);
      boolean _not = (!_canWrite);
      if (_not) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Affected file \'");
        IPath _fullPath = file.getFullPath();
        _builder.append(_fullPath);
        _builder.append("\' is read-only");
        this.issues.add(RefactoringIssueAcceptor.Severity.FATAL, _builder.toString());
      }
      this.checkDerived(file);
      final Function1<ITextReplacement, ReplaceEdit> _function = (ITextReplacement replacement) -> {
        int _offset = replacement.getOffset();
        int _length = replacement.getLength();
        String _replacementText = replacement.getReplacementText();
        return new ReplaceEdit(_offset, _length, _replacementText);
      };
      final List<ReplaceEdit> textEdits = ListExtensions.<ITextReplacement, ReplaceEdit>map(change.getReplacements(), _function);
      final MultiTextEdit textEdit = new MultiTextEdit();
      textEdit.addChildren(((TextEdit[])Conversions.unwrapArray(textEdits, TextEdit.class)));
      final ITextEditor openEditor = this.findOpenEditor(file);
      TextChange _xifexpression = null;
      if ((openEditor == null)) {
        String _lastSegment = change.getOldURI().lastSegment();
        TextFileChange _textFileChange = new TextFileChange(_lastSegment, file);
        final Procedure1<TextFileChange> _function_1 = (TextFileChange it) -> {
          it.setSaveMode(TextFileChange.FORCE_SAVE);
        };
        _xifexpression = ObjectExtensions.<TextFileChange>operator_doubleArrow(_textFileChange, _function_1);
      } else {
        String _name = this.currentChange.getName();
        _xifexpression = new EditorDocumentChange(_name, openEditor, false);
      }
      final TextChange ltkChange = _xifexpression;
      ltkChange.setEdit(textEdit);
      ltkChange.setTextType(change.getOldURI().fileExtension());
      this.addChange(ltkChange);
    }
  }
  
  protected void handleUriChange(final IEmfResourceChange change) {
    URI _newURI = change.getNewURI();
    URI _oldURI = change.getOldURI();
    boolean _notEquals = (!Objects.equal(_newURI, _oldURI));
    if (_notEquals) {
      String _lastSegment = change.getNewURI().lastSegment();
      String _lastSegment_1 = change.getOldURI().lastSegment();
      boolean _equals = Objects.equal(_lastSegment, _lastSegment_1);
      if (_equals) {
        final IFile oldFile = this.resourceUriConverter.toFile(change.getOldURI());
        boolean _canWrite = this.canWrite(oldFile);
        boolean _not = (!_canWrite);
        if (_not) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Cannot move read-only file \'");
          IPath _fullPath = oldFile.getFullPath();
          _builder.append(_fullPath);
          _builder.append("\'");
          this.issues.add(RefactoringIssueAcceptor.Severity.FATAL, _builder.toString());
        }
        this.checkDerived(oldFile);
        final IFile newFile = this.resourceUriConverter.toFile(change.getNewURI());
        final IContainer newContainer = newFile.getParent();
        final MoveResourceChange ltkChange = new MoveResourceChange(oldFile, newContainer);
        this.addChange(ltkChange);
      } else {
        URI _trimSegments = change.getNewURI().trimSegments(1);
        URI _trimSegments_1 = change.getOldURI().trimSegments(1);
        boolean _equals_1 = Objects.equal(_trimSegments, _trimSegments_1);
        if (_equals_1) {
          IPath _fullPath_1 = this.resourceUriConverter.toFile(change.getOldURI()).getFullPath();
          String _lastSegment_2 = change.getNewURI().lastSegment();
          final RenameResourceChange ltkChange_1 = new RenameResourceChange(_fullPath_1, _lastSegment_2);
          this.addChange(ltkChange_1);
        }
      }
    }
  }
  
  protected void addChange(final Change change) {
    if (((this.changeFilter == null) || this.changeFilter.apply(change))) {
      this.currentChange.add(change);
    }
  }
  
  protected boolean canWrite(final IFile file) {
    return file.getWorkspace().validateEdit(new IFile[] { file }, IWorkspace.VALIDATE_PROMPT).isOK();
  }
  
  protected void checkDerived(final IFile file) {
    boolean _isDerived = file.isDerived();
    if (_isDerived) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Affected file \'");
      IPath _fullPath = file.getFullPath();
      _builder.append(_fullPath);
      _builder.append("\' is derived");
      this.issues.add(RefactoringIssueAcceptor.Severity.WARNING, _builder.toString());
    }
  }
  
  protected ITextEditor findOpenEditor(final IFile file) {
    return new DisplayRunnableWithResult<ITextEditor>() {
      @Override
      protected ITextEditor run() throws Exception {
        final FileEditorInput editorInput = new FileEditorInput(file);
        final Function1<IEditorReference, IEditorPart> _function = (IEditorReference it) -> {
          return it.getEditor(false);
        };
        final Function1<ITextEditor, Boolean> _function_1 = (ITextEditor it) -> {
          IEditorInput _editorInput = it.getEditorInput();
          return Boolean.valueOf(Objects.equal(_editorInput, editorInput));
        };
        return IterableExtensions.<ITextEditor>findFirst(Iterables.<ITextEditor>filter(ListExtensions.<IEditorReference, IEditorPart>map(((List<IEditorReference>)Conversions.doWrapArray(ChangeConverter.this.workbench.getActiveWorkbenchWindow().getActivePage().getEditorReferences())), _function), ITextEditor.class), _function_1);
      }
    }.syncExec();
  }
  
  protected boolean affectsPersistedFiles() {
    final Function1<Change, Boolean> _function = (Change it) -> {
      return Boolean.valueOf((!(it instanceof EditorDocumentChange)));
    };
    return IterableExtensions.<Change>exists(((Iterable<Change>)Conversions.doWrapArray(this.currentChange.getChildren())), _function);
  }
  
  protected void saveEditorsAfterApply() {
    Iterable<EditorDocumentChange> _filter = Iterables.<EditorDocumentChange>filter(((Iterable<?>)Conversions.doWrapArray(this.currentChange.getChildren())), EditorDocumentChange.class);
    for (final EditorDocumentChange change : _filter) {
      change.setDoSave(true);
    }
  }
  
  protected void handleReplacements(final IEmfResourceChange change) {
    if (change instanceof ITextDocumentChange) {
      _handleReplacements((ITextDocumentChange)change);
      return;
    } else if (change != null) {
      _handleReplacements(change);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(change).toString());
    }
  }
}
