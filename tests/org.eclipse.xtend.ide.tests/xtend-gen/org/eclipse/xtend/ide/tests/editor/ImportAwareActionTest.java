/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.editor;

import java.util.ResourceBundle;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.ITextOperationTarget;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.xbase.ui.editor.XbaseEditorMessages;
import org.eclipse.xtext.xbase.ui.editor.actions.ImportsAwareClipboardAction;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class ImportAwareActionTest extends AbstractXtendUITestCase {
  public static final class ImportsAwareTestClipboardAction extends ImportsAwareClipboardAction {
    public ImportsAwareTestClipboardAction() {
      this(XbaseEditorMessages.getBundleForConstructedKeys(), "", null, ITextOperationTarget.PASTE);
    }
    
    public ImportsAwareTestClipboardAction(final ResourceBundle bundle, final String prefix, final ITextEditor editor, final int operationCode) {
      super(bundle, prefix, editor, operationCode);
    }
    
    @Override
    public boolean shouldAddImports(final IDocument document, final int caretOffset) {
      return super.shouldAddImports(document, caretOffset);
    }
  }
  
  private XtextDocument document;
  
  @Override
  public void setUp() throws Exception {
    super.setUp();
    XtextDocument _get = this.<XtextDocument>get(XtextDocument.class);
    this.document = _get;
    IDocumentPartitioner partitioner = this.<IDocumentPartitioner>get(IDocumentPartitioner.class);
    partitioner.connect(this.document);
    this.document.setDocumentPartitioner(partitioner);
  }
  
  @Override
  public void tearDown() throws Exception {
    this.document = null;
    super.tearDown();
  }
  
  @Test
  public void testShouldAddImportsComment() {
    boolean _wouldAddImport = this.wouldAddImport(
      "|/*\r\n\t\t\t *\r\n\t\t\t */\r\n\t\t\tclass Simple {\r\n\t\t\t}");
    Assert.assertTrue(_wouldAddImport);
    boolean _wouldAddImport_1 = this.wouldAddImport(
      "/*|\r\n\t\t\t *\r\n\t\t\t */\r\n\t\t\tclass Simple {\r\n\t\t\t}");
    Assert.assertFalse(_wouldAddImport_1);
    boolean _wouldAddImport_2 = this.wouldAddImport(
      "/*\r\n\t\t\t *\r\n\t\t\t */|\r\n\t\t\tclass Simple {\r\n\t\t\t}");
    Assert.assertTrue(_wouldAddImport_2);
    boolean _wouldAddImport_3 = this.wouldAddImport(
      "/**|\r\n\t\t\t * \r\n\t\t\t */\r\n\t\t\tclass Simple {\r\n\t\t\t}");
    Assert.assertTrue(_wouldAddImport_3);
    boolean _wouldAddImport_4 = this.wouldAddImport(
      "\r\n\t\t\t/**\r\n\t\t\t * \r\n\t\t\t */|\r\n\t\t\tclass Simple {\r\n\t\t\t}");
    Assert.assertTrue(_wouldAddImport_4);
    boolean _wouldAddImport_5 = this.wouldAddImport(
      "class Simple {\r\n\t\t\t\t// sl comment|\r\n\t\t\t\tString s2 = \'d\'\r\n\t\t\t}");
    Assert.assertFalse(_wouldAddImport_5);
    boolean _wouldAddImport_6 = this.wouldAddImport(
      "class Simple {\r\n\t\t\t\t// sl comment\r\n\t\t\t\tString s2 = \'d\'\r\n\t\t\t}|");
    Assert.assertTrue(_wouldAddImport_6);
    boolean _wouldAddImport_7 = this.wouldAddImport(
      "class Simple {\r\n\t\t\t\t// sl comment\r\n\t\t\t\tString s2 = \'d\'\r\n\t\t\t}\r\n\t\t\t//sl comment|");
    Assert.assertFalse(_wouldAddImport_7);
  }
  
  @Test
  public void testShouldAddImportsString() {
    boolean _wouldAddImport = this.wouldAddImport(
      "class Simple {\r\n\t\t\t\tString s2 = \'|d\'\r\n\t\t\t}");
    Assert.assertFalse(_wouldAddImport);
    boolean _wouldAddImport_1 = this.wouldAddImport(
      "\r\n\t\t\tclass Simple {\r\n\t\t\t\t// sl comment\r\n\t\t\t\tString s2 = |\'d\'\r\n\t\t\t\tString s3 = \'\'\'«s2» «s2»\'\'\'\r\n\t\t\t}");
    Assert.assertTrue(_wouldAddImport_1);
    boolean _wouldAddImport_2 = this.wouldAddImport(
      "\r\n\t\t\tclass Simple {\r\n\t\t\t\tString s2 = \'d\'|\r\n\t\t\t\tString s3 = \'\'\'«s2» «s2»\'\'\'\r\n\t\t\t}");
    Assert.assertTrue(_wouldAddImport_2);
  }
  
  @Test
  public void testShouldAddImportsRichString() {
    boolean _wouldAddImport = this.wouldAddImport(
      "\r\n\t\t\tclass Simple {\r\n\t\t\t\tString s2 = \'d\'\r\n\t\t\t\tString s3 = \'\'\'|«s2» «s2»\'\'\'\r\n\t\t\t}");
    Assert.assertFalse(_wouldAddImport);
    boolean _wouldAddImport_1 = this.wouldAddImport(
      "\r\n\t\t\tclass Simple {\r\n\t\t\t\tString s2 = \'d\'\r\n\t\t\t\tString s3 = \'\'\'|«s2» «s2»\'\'\'\r\n\t\t\t}");
    Assert.assertFalse(_wouldAddImport_1);
    boolean _wouldAddImport_2 = this.wouldAddImport(
      "\r\n\t\t\tclass Simple {\r\n\t\t\t\tString s2 = \'d\'\r\n\t\t\t\tString s3 = \'\'\'«|s2» «s2»\'\'\'\r\n\t\t\t}");
    Assert.assertTrue(_wouldAddImport_2);
    boolean _wouldAddImport_3 = this.wouldAddImport(
      "\r\n\t\t\tclass Simple {\r\n\t\t\t\tString s2 = \'d\'\r\n\t\t\t\tString s3 = \'\'\'«s2» «s2»\'\'\'|\r\n\t\t\t}");
    Assert.assertTrue(_wouldAddImport_3);
    boolean _wouldAddImport_4 = this.wouldAddImport(
      "\r\n\t\t\tclass Simple {\r\n\t\t\t\tString s2 = \'d\'\r\n\t\t\t\tString s3 = |\'\'\'«s2» «s2»\'\'\'\r\n\t\t\t}");
    Assert.assertTrue(_wouldAddImport_4);
  }
  
  public boolean wouldAddImport(final String string) {
    boolean _xblockexpression = false;
    {
      final int index = string.indexOf("|");
      String _replace = string.replace("|", "");
      this.document.set(_replace);
      final ImportAwareActionTest.ImportsAwareTestClipboardAction action = new ImportAwareActionTest.ImportsAwareTestClipboardAction();
      _xblockexpression = action.shouldAddImports(this.document, index);
    }
    return _xblockexpression;
  }
}
