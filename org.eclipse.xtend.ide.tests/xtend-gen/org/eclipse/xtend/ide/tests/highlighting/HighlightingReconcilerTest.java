/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.highlighting;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.jface.text.Position;
import org.eclipse.swt.widgets.Display;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.syntaxcoloring.HighlightingPresenter;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@Ignore("https://github.com/eclipse/xtext-xtend/issues/880")
@SuppressWarnings("all")
public class HighlightingReconcilerTest extends AbstractXtendUITestCase {
  private static final long VALIDATION_TIMEOUT = 10000L;

  @Inject
  @Extension
  private WorkbenchTestHelper helper;

  @Before
  public void start() {
    try {
      this.helper.closeWelcomePage();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @After
  public void close() {
    try {
      this.helper.tearDown();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=449948
   */
  @Test
  public void testHighlightingRace() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("  ");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String model = _builder.toString();
      final XtextEditor editor = this.helper.openEditor("Foo.xtend", model);
      final IXtextDocument document = editor.getDocument();
      int _indexOf = model.indexOf("  ");
      new ReplaceEdit(_indexOf, 2, "  static val foo = 3").apply(document);
      final IUnitOfWork<Object, XtextResource> _function = (XtextResource it) -> {
        return null;
      };
      document.<Object>readOnly(_function);
      int _indexOf_1 = model.indexOf("  ");
      new ReplaceEdit(_indexOf_1, 0, "  ").apply(document);
      final IUnitOfWork<Object, XtextResource> _function_1 = (XtextResource it) -> {
        return null;
      };
      document.<Object>readOnly(_function_1);
      while (Display.getDefault().readAndDispatch()) {
      }
      final Function1<String, Boolean> _function_2 = (String it) -> {
        return Boolean.valueOf(it.startsWith(HighlightingPresenter.class.getCanonicalName()));
      };
      final String highlighterCategory = IterableExtensions.<String>findFirst(((Iterable<String>)Conversions.doWrapArray(document.getPositionCategories())), _function_2);
      final Function1<Position, String> _function_3 = (Position it) -> {
        try {
          return document.get(it.offset, it.length);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      final List<String> semanticSnippets = ListExtensions.<Position, String>map(((List<Position>)Conversions.doWrapArray(document.getPositions(highlighterCategory))), _function_3);
      Assert.assertEquals("Highlighting regions broken", 3, semanticSnippets.size());
      Assert.assertEquals("Foo", IterableExtensions.<String>head(semanticSnippets));
      Assert.assertEquals("foo", IterableExtensions.<String>head(IterableExtensions.<String>tail(semanticSnippets)));
      Assert.assertEquals("3", IterableExtensions.<String>lastOrNull(semanticSnippets));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testOpenedEditorHasSemanticHighlighting() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("static val foo = \'\'");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String model = _builder.toString();
      final XtextEditor editor = this.helper.openEditor("Foo.xtend", model);
      final IXtextDocument document = editor.getDocument();
      final Function0<Boolean> _function = () -> {
        try {
          boolean _xblockexpression = false;
          {
            final Function1<String, Boolean> _function_1 = (String it) -> {
              return Boolean.valueOf(it.startsWith(HighlightingPresenter.class.getCanonicalName()));
            };
            final String highlighterCategory = IterableExtensions.<String>findFirst(((Iterable<String>)Conversions.doWrapArray(document.getPositionCategories())), _function_1);
            final Function1<Position, String> _function_2 = (Position it) -> {
              try {
                return document.get(it.offset, it.length);
              } catch (Throwable _e) {
                throw Exceptions.sneakyThrow(_e);
              }
            };
            final List<String> semanticSnippets = ListExtensions.<Position, String>map(((List<Position>)Conversions.doWrapArray(document.getPositions(highlighterCategory))), _function_2);
            int _size = semanticSnippets.size();
            _xblockexpression = (_size > 0);
          }
          return Boolean.valueOf(_xblockexpression);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      this.helper.awaitUIUpdate(_function, HighlightingReconcilerTest.VALIDATION_TIMEOUT);
      final Function1<String, Boolean> _function_1 = (String it) -> {
        return Boolean.valueOf(it.startsWith(HighlightingPresenter.class.getCanonicalName()));
      };
      final String highlighterCategory = IterableExtensions.<String>findFirst(((Iterable<String>)Conversions.doWrapArray(document.getPositionCategories())), _function_1);
      final Function1<Position, String> _function_2 = (Position it) -> {
        try {
          return document.get(it.offset, it.length);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      final List<String> semanticSnippets = ListExtensions.<Position, String>map(((List<Position>)Conversions.doWrapArray(document.getPositions(highlighterCategory))), _function_2);
      String _join = IterableExtensions.join(semanticSnippets, ",");
      String _plus = ("Highlighting regions broken " + _join);
      Assert.assertEquals(_plus, 2, semanticSnippets.size());
      Assert.assertEquals("Foo", IterableExtensions.<String>head(semanticSnippets));
      Assert.assertEquals("foo", IterableExtensions.<String>lastOrNull(semanticSnippets));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
