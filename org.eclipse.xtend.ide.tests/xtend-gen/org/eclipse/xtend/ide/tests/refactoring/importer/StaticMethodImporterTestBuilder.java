/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.refactoring.importer;

import com.google.inject.Inject;
import java.util.regex.Pattern;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.xtend.ide.refactoring.importer.StaticMethodImporter;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;

/**
 * Usage is:
 * 
 * <pre>
 * 'test.Test.xtend'.create('''
 *      package test
 * 
 *      import test.other.Other
 * 
 *      class Test {
 *          def test() {
 *              Other.doSo|mething('test')
 *          }
 *      }
 * ''').assertResult('''
 *      package test
 * 
 *      import static test.other.Other.doSomething
 * 
 *      class Test {
 *          def test() {
 *              doSomething('test')
 *          }
 *      }
 * ''')
 * </pre>
 * 
 * | or <|> are used to mark the selection in the document.
 * 
 * @author vivien.jovet - Initial contribution and API
 */
@SuppressWarnings("all")
public class StaticMethodImporterTestBuilder {
  @Inject
  private SyncUtil syncUtil;

  @Inject
  @Extension
  private StaticMethodImporter staticMethodImporter;

  @Inject
  @Extension
  private WorkbenchTestHelper workbenchTestHelper;

  private final String primaryPositionMarker = "<|>";

  private final String secondaryPositionMarker = "|";

  private String result;

  /**
   * Creates an Xtend file with the given content and perform the import static operation on it.
   */
  public StaticMethodImporterTestBuilder create(final String fileName, final String content) {
    try {
      StaticMethodImporterTestBuilder _xblockexpression = null;
      {
        final String positionMarker = this.getPositionMarker(content);
        final IFile file = this.workbenchTestHelper.createFile(fileName, content.replace(positionMarker, ""));
        final int caretOffset = content.indexOf(positionMarker);
        final IXtextDocument document = this.workbenchTestHelper.openEditor(file).getDocument();
        this.syncUtil.totalSync(true);
        this.doImportStaticMethod(document, caretOffset);
        this.result = document.get();
        _xblockexpression = this;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  protected boolean doImportStaticMethod(final IXtextDocument document, final int caretOffset) {
    TextSelection _textSelection = new TextSelection(caretOffset, 1);
    return this.staticMethodImporter.importStaticMethod(document, _textSelection);
  }

  /**
   * Asserts that the given string is the same as the refactored document content.
   */
  public void assertResult(final String expected) {
    Assert.assertEquals(expected, this.result);
  }

  protected String getPositionMarker(final String content) {
    String _xifexpression = null;
    int _count = this.count(content, this.primaryPositionMarker);
    boolean _equals = (_count == 1);
    if (_equals) {
      _xifexpression = this.primaryPositionMarker;
    } else {
      String _xifexpression_1 = null;
      int _count_1 = this.count(content, this.secondaryPositionMarker);
      boolean _equals_1 = (_count_1 == 1);
      if (_equals_1) {
        _xifexpression_1 = this.secondaryPositionMarker;
      } else {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(this.primaryPositionMarker);
        _builder.append(" may be used to disambiguate ordinary ");
        _builder.append(this.secondaryPositionMarker);
        _builder.append(" from a position marker!");
        Assert.fail(_builder.toString());
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }

  protected int count(final String model, final String positionMarker) {
    int _xblockexpression = (int) 0;
    {
      final String regex = Pattern.quote(positionMarker);
      int _length = model.split(regex).length;
      _xblockexpression = (_length - 1);
    }
    return _xblockexpression;
  }
}
