/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.hover;

import com.google.inject.Inject;
import org.apache.log4j.Level;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.text.ITextHoverExtension2;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.logging.LoggingTester;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.hover.IEObjectHover;
import org.eclipse.xtext.ui.editor.hover.html.XtextBrowserInformationControlInput;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.typesystem.internal.AbstractBatchTypeResolver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendHoverInEditorTest extends AbstractXtendUITestCase {
  @Inject
  @Extension
  private WorkbenchTestHelper helper;
  
  @Inject
  @Extension
  private SyncUtil _syncUtil;
  
  @Inject
  private IEObjectHover hoverer;
  
  @After
  @Override
  public void tearDown() {
    try {
      this.helper.tearDown();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testHoverOfReferencedElement() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* Hello Foo");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("class Foo {}");
      _builder.newLine();
      final String contentFoo = _builder.toString();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Bar extends Foo {}");
      _builder_1.newLine();
      final String contentBar = _builder_1.toString();
      final IFile fileFoo = this.helper.createFile("Foo.xtend", contentFoo);
      final IFile fileBar = this.helper.createFile("Bar.xtend", contentBar);
      this._syncUtil.waitForBuild(null);
      final XtextEditor editor = this.helper.openEditor(fileBar);
      ISourceViewer _internalSourceViewer = editor.getInternalSourceViewer();
      Region _region = new Region(19, 1);
      Object _hoverInfo2 = ((ITextHoverExtension2) this.hoverer).getHoverInfo2(((ITextViewer) _internalSourceViewer), _region);
      final XtextBrowserInformationControlInput info = ((XtextBrowserInformationControlInput) _hoverInfo2);
      String _html = info.getHtml();
      boolean _contains = _html.contains("Hello Foo");
      Assert.assertTrue(_contains);
      final XtextEditor fooEditor = this.helper.openEditor(fileFoo);
      IXtextDocument _document = fooEditor.getDocument();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("/**");
      _builder_2.newLine();
      _builder_2.append(" ");
      _builder_2.append("* Hello BAZ");
      _builder_2.newLine();
      _builder_2.append(" ");
      _builder_2.append("*/");
      _builder_2.newLine();
      _builder_2.append("class Foo {}");
      _builder_2.newLine();
      _document.set(_builder_2.toString());
      this._syncUtil.waitForReconciler(fooEditor);
      this._syncUtil.waitForReconciler(editor);
      ISourceViewer _internalSourceViewer_1 = editor.getInternalSourceViewer();
      Region _region_1 = new Region(19, 1);
      Object _hoverInfo2_1 = ((ITextHoverExtension2) this.hoverer).getHoverInfo2(((ITextViewer) _internalSourceViewer_1), _region_1);
      final XtextBrowserInformationControlInput info2 = ((XtextBrowserInformationControlInput) _hoverInfo2_1);
      String _html_1 = info2.getHtml();
      boolean _contains_1 = _html_1.contains("Hello Foo");
      Assert.assertFalse(_contains_1);
      String _html_2 = info2.getHtml();
      boolean _contains_2 = _html_2.contains("Hello BAZ");
      Assert.assertTrue(_contains_2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testHoverOfReferencedElementWithAnnotation() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* Hello Foo");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("@SuppressWarnings(\"foo\")");
      _builder.newLine();
      _builder.append("class Foo {}");
      _builder.newLine();
      final String contentFoo = _builder.toString();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Bar extends Foo {}");
      _builder_1.newLine();
      final String contentBar = _builder_1.toString();
      final IFile fileFoo = this.helper.createFile("Foo.xtend", contentFoo);
      final IFile fileBar = this.helper.createFile("Bar.xtend", contentBar);
      this._syncUtil.waitForBuild(null);
      final XtextEditor editor = this.helper.openEditor(fileBar);
      final Runnable _function = new Runnable() {
        @Override
        public void run() {
          ISourceViewer _internalSourceViewer = editor.getInternalSourceViewer();
          Region _region = new Region(19, 1);
          Object _hoverInfo2 = ((ITextHoverExtension2) XtendHoverInEditorTest.this.hoverer).getHoverInfo2(((ITextViewer) _internalSourceViewer), _region);
          final XtextBrowserInformationControlInput info = ((XtextBrowserInformationControlInput) _hoverInfo2);
          String _html = info.getHtml();
          String _html_1 = info.getHtml();
          boolean _contains = _html_1.contains("Hello Foo");
          Assert.assertTrue(_html, _contains);
          String _html_2 = info.getHtml();
          String _html_3 = info.getHtml();
          boolean _contains_1 = _html_3.contains("SuppressWarnings</a>(\"foo\")");
          Assert.assertTrue(_html_2, _contains_1);
        }
      };
      final LoggingTester.LogCapture loggings = LoggingTester.captureLogging(Level.ERROR, AbstractBatchTypeResolver.class, _function);
      loggings.assertNoLogEntries();
      final XtextEditor fooEditor = this.helper.openEditor(fileFoo);
      IXtextDocument _document = fooEditor.getDocument();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("/**");
      _builder_2.newLine();
      _builder_2.append(" ");
      _builder_2.append("* Hello BAZ");
      _builder_2.newLine();
      _builder_2.append(" ");
      _builder_2.append("*/");
      _builder_2.newLine();
      _builder_2.append("@SuppressWarnings(\"bar\")");
      _builder_2.newLine();
      _builder_2.append("class Foo {}");
      _builder_2.newLine();
      _document.set(_builder_2.toString());
      this._syncUtil.waitForReconciler(fooEditor);
      this._syncUtil.waitForReconciler(editor);
      final Runnable _function_1 = new Runnable() {
        @Override
        public void run() {
          ISourceViewer _internalSourceViewer = editor.getInternalSourceViewer();
          Region _region = new Region(19, 1);
          Object _hoverInfo2 = ((ITextHoverExtension2) XtendHoverInEditorTest.this.hoverer).getHoverInfo2(((ITextViewer) _internalSourceViewer), _region);
          final XtextBrowserInformationControlInput info2 = ((XtextBrowserInformationControlInput) _hoverInfo2);
          String _html = info2.getHtml();
          boolean _contains = _html.contains("Hello Foo");
          Assert.assertFalse(_contains);
          String _html_1 = info2.getHtml();
          boolean _contains_1 = _html_1.contains("Hello BAZ");
          Assert.assertTrue(_contains_1);
          String _html_2 = info2.getHtml();
          String _html_3 = info2.getHtml();
          boolean _contains_2 = _html_3.contains("SuppressWarnings</a>(\"bar\")");
          Assert.assertTrue(_html_2, _contains_2);
        }
      };
      final LoggingTester.LogCapture moreLoggings = LoggingTester.captureLogging(Level.ERROR, AbstractBatchTypeResolver.class, _function_1);
      moreLoggings.assertNoLogEntries();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
