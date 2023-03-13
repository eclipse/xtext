/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
    this.document = this.<XtextDocument>get(XtextDocument.class);
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
    Assert.assertTrue(
      this.wouldAddImport(
        "|/*\n\t\t\t *\n\t\t\t */\n\t\t\tclass Simple {\n\t\t\t}"));
    Assert.assertFalse(
      this.wouldAddImport(
        "/*|\n\t\t\t *\n\t\t\t */\n\t\t\tclass Simple {\n\t\t\t}"));
    Assert.assertTrue(
      this.wouldAddImport(
        "/*\n\t\t\t *\n\t\t\t */|\n\t\t\tclass Simple {\n\t\t\t}"));
    Assert.assertTrue(
      this.wouldAddImport(
        "/**|\n\t\t\t * \n\t\t\t */\n\t\t\tclass Simple {\n\t\t\t}"));
    Assert.assertTrue(
      this.wouldAddImport(
        "\n\t\t\t/**\n\t\t\t * \n\t\t\t */|\n\t\t\tclass Simple {\n\t\t\t}"));
    Assert.assertFalse(
      this.wouldAddImport(
        "class Simple {\n\t\t\t\t// sl comment|\n\t\t\t\tString s2 = \'d\'\n\t\t\t}"));
    Assert.assertTrue(
      this.wouldAddImport(
        "class Simple {\n\t\t\t\t// sl comment\n\t\t\t\tString s2 = \'d\'\n\t\t\t}|"));
    Assert.assertFalse(
      this.wouldAddImport(
        "class Simple {\n\t\t\t\t// sl comment\n\t\t\t\tString s2 = \'d\'\n\t\t\t}\n\t\t\t//sl comment|"));
  }

  @Test
  public void testShouldAddImportsString() {
    Assert.assertFalse(
      this.wouldAddImport(
        "class Simple {\n\t\t\t\tString s2 = \'|d\'\n\t\t\t}"));
    Assert.assertTrue(
      this.wouldAddImport(
        "\n\t\t\tclass Simple {\n\t\t\t\t// sl comment\n\t\t\t\tString s2 = |\'d\'\n\t\t\t\tString s3 = \'\'\'«s2» «s2»\'\'\'\n\t\t\t}"));
    Assert.assertTrue(
      this.wouldAddImport(
        "\n\t\t\tclass Simple {\n\t\t\t\tString s2 = \'d\'|\n\t\t\t\tString s3 = \'\'\'«s2» «s2»\'\'\'\n\t\t\t}"));
  }

  @Test
  public void testShouldAddImportsRichString() {
    Assert.assertFalse(
      this.wouldAddImport(
        "\n\t\t\tclass Simple {\n\t\t\t\tString s2 = \'d\'\n\t\t\t\tString s3 = \'\'\'|«s2» «s2»\'\'\'\n\t\t\t}"));
    Assert.assertFalse(
      this.wouldAddImport(
        "\n\t\t\tclass Simple {\n\t\t\t\tString s2 = \'d\'\n\t\t\t\tString s3 = \'\'\'|«s2» «s2»\'\'\'\n\t\t\t}"));
    Assert.assertTrue(
      this.wouldAddImport(
        "\n\t\t\tclass Simple {\n\t\t\t\tString s2 = \'d\'\n\t\t\t\tString s3 = \'\'\'«|s2» «s2»\'\'\'\n\t\t\t}"));
    Assert.assertTrue(
      this.wouldAddImport(
        "\n\t\t\tclass Simple {\n\t\t\t\tString s2 = \'d\'\n\t\t\t\tString s3 = \'\'\'«s2» «s2»\'\'\'|\n\t\t\t}"));
    Assert.assertTrue(
      this.wouldAddImport(
        "\n\t\t\tclass Simple {\n\t\t\t\tString s2 = \'d\'\n\t\t\t\tString s3 = |\'\'\'«s2» «s2»\'\'\'\n\t\t\t}"));
  }

  public boolean wouldAddImport(final String string) {
    boolean _xblockexpression = false;
    {
      final int index = string.indexOf("|");
      this.document.set(string.replace("|", ""));
      final ImportAwareActionTest.ImportsAwareTestClipboardAction action = new ImportAwareActionTest.ImportsAwareTestClipboardAction();
      _xblockexpression = action.shouldAddImports(this.document, index);
    }
    return _xblockexpression;
  }
}
