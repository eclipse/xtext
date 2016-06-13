package org.eclipse.xtext.idea.tests;

import com.intellij.ide.ClipboardSynchronizer;
import com.intellij.openapi.actionSystem.IdeActions;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiFile;
import java.awt.datatransfer.StringSelection;
import junit.framework.Assert;
import org.eclipse.xtext.idea.tests.LightToolingTest;
import org.eclipse.xtext.junit4.internal.LineDelimiters;

@SuppressWarnings("all")
public abstract class AbstractAutoEditTest extends LightToolingTest {
  public AbstractAutoEditTest(final LanguageFileType fileType) {
    super(fileType);
  }
  
  protected void assertAutoIndentOnNewLine(final CharSequence model, final CharSequence expectedModel) {
    String _string = model.toString();
    this.configureByText(_string);
    this.newLine();
    String _string_1 = expectedModel.toString();
    this.assertState(_string_1);
  }
  
  protected void selectText(final int relativeToCurrentOffset, final int length) {
    Editor _editor = this.myFixture.getEditor();
    CaretModel _caretModel = _editor.getCaretModel();
    final int offset = _caretModel.getOffset();
    final int startOffset = (offset + relativeToCurrentOffset);
    final int endOffset = (startOffset + length);
    Editor _editor_1 = this.myFixture.getEditor();
    SelectionModel _selectionModel = _editor_1.getSelectionModel();
    _selectionModel.setSelection(startOffset, endOffset);
  }
  
  protected void pasteText(final String text) {
    final StringSelection content = new StringSelection(text);
    ClipboardSynchronizer _instance = ClipboardSynchronizer.getInstance();
    _instance.setContent(content, content);
    this.myFixture.performEditorAction(IdeActions.ACTION_EDITOR_PASTE);
  }
  
  @Override
  protected PsiFile configureByText(final String code) {
    String _replace = code.replace("|", "<caret>");
    return super.configureByText(_replace);
  }
  
  protected void assertState(final String editorState) {
    final String expectedState = LineDelimiters.toUnix(editorState);
    String _xblockexpression = null;
    {
      Editor _editor = this.myFixture.getEditor();
      CaretModel _caretModel = _editor.getCaretModel();
      Caret _primaryCaret = _caretModel.getPrimaryCaret();
      final int caretOffset = _primaryCaret.getOffset();
      Editor _editor_1 = this.myFixture.getEditor();
      final Document document = _editor_1.getDocument();
      Editor _editor_2 = this.myFixture.getEditor();
      Document _document = _editor_2.getDocument();
      TextRange _textRange = new TextRange(0, caretOffset);
      final String beforeCaret = _document.getText(_textRange);
      Editor _editor_3 = this.myFixture.getEditor();
      Document _document_1 = _editor_3.getDocument();
      int _textLength = document.getTextLength();
      TextRange _textRange_1 = new TextRange(caretOffset, _textLength);
      final String afterCaret = _document_1.getText(_textRange_1);
      _xblockexpression = ((beforeCaret + "|") + afterCaret);
    }
    final String actualState = _xblockexpression;
    String _dumpFormattingModel = this.dumpFormattingModel();
    Assert.assertEquals(_dumpFormattingModel, expectedState, actualState);
  }
  
  protected void newLine() {
    this.myFixture.type("\n");
  }
  
  protected void backspace() {
    this.myFixture.type("\b");
  }
}
