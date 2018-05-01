/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.testing;

import com.google.inject.Inject;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.texteditor.AbstractTextEditor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.XtextEditorInfo;
import org.eclipse.xtext.ui.testing.AbstractEditorTest;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;

/**
 * @since 2.14
 */
@SuppressWarnings("all")
public abstract class AbstractEditorDoubleClickTextSelectionTest extends AbstractEditorTest {
  @Inject
  private XtextEditorInfo xtextEditorInfo;
  
  @Inject
  @Extension
  private FileExtensionProvider _fileExtensionProvider;
  
  /**
   * Special symbol indicating the current cursor position.
   */
  public String c() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("|");
    return _builder.toString();
  }
  
  /**
   * @param it - The editor's input text. The text must contain the {@link #c}
   * 	special symbol indicating the current cursor position.
   * 
   * @param expected - The text that is expected to be selected after double
   * 	clicking in the Xtext editor on the current cursor position.
   */
  public void assertSelectedTextAfterDoubleClicking(final CharSequence it, final String expected) {
    try {
      this.assertSelectedText(this.doubleClick(this.openEditor(this.createFile(this.getContent(it))), this.getCursorPosition(it)), expected);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected String getContent(final CharSequence text) {
    return text.toString().replace(this.c(), "");
  }
  
  protected IFile createFile(final String content) {
    try {
      return IResourcesSetupUtil.createFile(this.getProjectName(), this.getFileName(), this.getFileExtension(), content);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected String getProjectName() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Test");
    return _builder.toString();
  }
  
  protected String getFileName() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Foo");
    return _builder.toString();
  }
  
  protected String getFileExtension() {
    return this._fileExtensionProvider.getPrimaryFileExtension();
  }
  
  protected int getCursorPosition(final CharSequence text) {
    int _xblockexpression = (int) 0;
    {
      final int cursorPosition = text.toString().indexOf(this.c());
      if ((cursorPosition == (-1))) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("The input text");
        _builder.newLine();
        _builder.append(text);
        _builder.newLineIfNotEmpty();
        _builder.append("must contain the \'");
        String _c = this.c();
        _builder.append(_c);
        _builder.append("\' special symbol indicating the current cursor position!");
        _builder.newLineIfNotEmpty();
        Assert.fail(_builder.toString());
      }
      _xblockexpression = cursorPosition;
    }
    return _xblockexpression;
  }
  
  protected XtextEditor doubleClick(final XtextEditor xtextEditor, final int cursorPosition) {
    XtextEditor _xblockexpression = null;
    {
      final ISourceViewer viewer = xtextEditor.getInternalSourceViewer();
      viewer.setSelectedRange(cursorPosition, 0);
      StyledText _textWidget = viewer.getTextWidget();
      Event _event = new Event();
      final Procedure1<Event> _function = (Event it) -> {
        it.button = 1;
      };
      Event _doubleArrow = ObjectExtensions.<Event>operator_doubleArrow(_event, _function);
      _textWidget.notifyListeners(
        SWT.MouseDown, _doubleArrow);
      _xblockexpression = xtextEditor;
    }
    return _xblockexpression;
  }
  
  protected void assertSelectedText(final AbstractTextEditor textEditor, final CharSequence expectedSelectedText) {
    ISelection _selection = textEditor.getSelectionProvider().getSelection();
    final String actualSelectedText = ((ITextSelection) _selection).getText();
    Assert.assertEquals(expectedSelectedText, actualSelectedText);
  }
  
  @Override
  protected String getEditorId() {
    return this.xtextEditorInfo.getEditorId();
  }
}
