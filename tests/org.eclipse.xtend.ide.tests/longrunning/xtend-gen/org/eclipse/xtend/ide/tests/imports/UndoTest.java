package org.eclipse.xtend.ide.tests.imports;

import com.google.inject.Inject;
import org.eclipse.jface.text.ITextViewerExtension6;
import org.eclipse.jface.text.IUndoManager;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.ui.imports.OrganizeImportsHandler;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class UndoTest extends AbstractXtendUITestCase {
  @Inject
  @Extension
  private WorkbenchTestHelper _workbenchTestHelper;
  
  @Inject
  @Extension
  private OrganizeImportsHandler _organizeImportsHandler;
  
  @Test
  public void testUndo() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val java.lang.String x");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val java.util.ArrayList<String> y");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtextEditor editor = this._workbenchTestHelper.openEditor("Foo", _builder.toString());
      IXtextDocument _document = editor.getDocument();
      this._organizeImportsHandler.doOrganizeImports(_document);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("import java.util.ArrayList");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("class Foo {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("val String x");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("val ArrayList<String> y");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      String _string = _builder_1.toString();
      IXtextDocument _document_1 = editor.getDocument();
      String _get = _document_1.get();
      Assert.assertEquals(_string, _get);
      final ISourceViewer viewer = editor.getInternalSourceViewer();
      Assert.assertTrue((viewer instanceof ITextViewerExtension6));
      final IUndoManager undoManager = ((ITextViewerExtension6) viewer).getUndoManager();
      undoManager.undo();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("class Foo {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("val java.lang.String x");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("val java.util.ArrayList<String> y");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      String _string_1 = _builder_2.toString();
      IXtextDocument _document_2 = editor.getDocument();
      String _get_1 = _document_2.get();
      Assert.assertEquals(_string_1, _get_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
