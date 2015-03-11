/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class HighlightingReconcilerTest extends AbstractXtendUITestCase {
  private final static long VALIDATION_TIMEOUT = 10000L;
  
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
      ReplaceEdit _replaceEdit = new ReplaceEdit(_indexOf, 2, "  static val foo = 3");
      _replaceEdit.apply(document);
      final IUnitOfWork<Object, XtextResource> _function = new IUnitOfWork<Object, XtextResource>() {
        @Override
        public Object exec(final XtextResource it) throws Exception {
          return null;
        }
      };
      document.<Object>readOnly(_function);
      int _indexOf_1 = model.indexOf("  ");
      ReplaceEdit _replaceEdit_1 = new ReplaceEdit(_indexOf_1, 0, "  ");
      _replaceEdit_1.apply(document);
      final IUnitOfWork<Object, XtextResource> _function_1 = new IUnitOfWork<Object, XtextResource>() {
        @Override
        public Object exec(final XtextResource it) throws Exception {
          return null;
        }
      };
      document.<Object>readOnly(_function_1);
      while (Display.getDefault().readAndDispatch()) {
      }
      String[] _positionCategories = document.getPositionCategories();
      final Function1<String, Boolean> _function_2 = new Function1<String, Boolean>() {
        @Override
        public Boolean apply(final String it) {
          String _canonicalName = HighlightingPresenter.class.getCanonicalName();
          return Boolean.valueOf(it.startsWith(_canonicalName));
        }
      };
      final String highlighterCategory = IterableExtensions.<String>findFirst(((Iterable<String>)Conversions.doWrapArray(_positionCategories)), _function_2);
      Position[] _positions = document.getPositions(highlighterCategory);
      final Function1<Position, String> _function_3 = new Function1<Position, String>() {
        @Override
        public String apply(final Position it) {
          try {
            return document.get(it.offset, it.length);
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      final List<String> semanticSnippets = ListExtensions.<Position, String>map(((List<Position>)Conversions.doWrapArray(_positions)), _function_3);
      int _size = semanticSnippets.size();
      Assert.assertEquals("Highlighting regions broken", 2, _size);
      String _head = IterableExtensions.<String>head(semanticSnippets);
      Assert.assertEquals("foo", _head);
      String _last = IterableExtensions.<String>last(semanticSnippets);
      Assert.assertEquals("3", _last);
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
      final Function0<Boolean> _function = new Function0<Boolean>() {
        @Override
        public Boolean apply() {
          try {
            boolean _xblockexpression = false;
            {
              String[] _positionCategories = document.getPositionCategories();
              final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
                @Override
                public Boolean apply(final String it) {
                  String _canonicalName = HighlightingPresenter.class.getCanonicalName();
                  return Boolean.valueOf(it.startsWith(_canonicalName));
                }
              };
              final String highlighterCategory = IterableExtensions.<String>findFirst(((Iterable<String>)Conversions.doWrapArray(_positionCategories)), _function);
              Position[] _positions = document.getPositions(highlighterCategory);
              final Function1<Position, String> _function_1 = new Function1<Position, String>() {
                @Override
                public String apply(final Position it) {
                  try {
                    return document.get(it.offset, it.length);
                  } catch (Throwable _e) {
                    throw Exceptions.sneakyThrow(_e);
                  }
                }
              };
              final List<String> semanticSnippets = ListExtensions.<Position, String>map(((List<Position>)Conversions.doWrapArray(_positions)), _function_1);
              int _size = semanticSnippets.size();
              _xblockexpression = (_size > 0);
            }
            return Boolean.valueOf(_xblockexpression);
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      this.helper.awaitUIUpdate(_function, HighlightingReconcilerTest.VALIDATION_TIMEOUT);
      String[] _positionCategories = document.getPositionCategories();
      final Function1<String, Boolean> _function_1 = new Function1<String, Boolean>() {
        @Override
        public Boolean apply(final String it) {
          String _canonicalName = HighlightingPresenter.class.getCanonicalName();
          return Boolean.valueOf(it.startsWith(_canonicalName));
        }
      };
      final String highlighterCategory = IterableExtensions.<String>findFirst(((Iterable<String>)Conversions.doWrapArray(_positionCategories)), _function_1);
      Position[] _positions = document.getPositions(highlighterCategory);
      final Function1<Position, String> _function_2 = new Function1<Position, String>() {
        @Override
        public String apply(final Position it) {
          try {
            return document.get(it.offset, it.length);
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      final List<String> semanticSnippets = ListExtensions.<Position, String>map(((List<Position>)Conversions.doWrapArray(_positions)), _function_2);
      String _join = IterableExtensions.join(semanticSnippets, ",");
      String _plus = ("Highlighting regions broken " + _join);
      int _size = semanticSnippets.size();
      Assert.assertEquals(_plus, 1, _size);
      String _head = IterableExtensions.<String>head(semanticSnippets);
      Assert.assertEquals("foo", _head);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
