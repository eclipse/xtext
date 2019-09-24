/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.domainmodel.ui.tests;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.example.domainmodel.ui.tests.DomainmodelUiInjectorProvider;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.testing.AbstractAutoEditTest;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(DomainmodelUiInjectorProvider.class)
@SuppressWarnings("all")
public class AutoEditTest extends AbstractAutoEditTest {
  @Inject
  @Extension
  private FileExtensionProvider _fileExtensionProvider;
  
  @Override
  public void setUp() {
    try {
      super.setUp();
      this.createTestProjectWithXtextNature();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void fantasting_autoedit() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Xtex|");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.newLineIfNotEmpty();
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM  MMMMMMMMM");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM      MMMMMMMM");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("MMMMMM   MMMMMMMMMMMMMMMMMMMMMMMMMMMMMM     MMMMMMMM");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("MMMM       MMMMMMMMMMMMMMMMMMMMMMMMMMMMM    MMMMMMMM");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("MMM          MMMMMMMMMMMMMMMMMMMMMMMMMMMM   MMMMMMMM");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("M              MMMMMMMMMMMMMMMMMMMMMMMMM   MMMMMMMMM");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("MM                MMMMMMMMMMMMMMMMMMMMM   MMMMMMMMMM");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("MMMM                 MMMMMMMMMMMMMMMM   MMMMMMMMMMMM");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("MMMMMM                   MMMMMMMMM     MMMMMMMMMMMMM");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("MMMMMMMM                             MMMMMMMMMMMMMMM");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("MMMMMMMMMM                        MMMMMMMMMMMMMMMMMM");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("MMMMMMMMMMMMMM                MMMMMMMMMMMMMMMMMMMMMM");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("MMMMMMMMMMMMMMMMMMMM            MMMMMMMMMMMMMMMMMMMM");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("MMMMMMMMMMMMMMMMM                     MMMMMMMMMMMMMM");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("MMMMMMMMMMMMMM                           MMMMMMMMMMM");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("MMMMMMMMMMMM       MMM                      MMMMMMMM");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("MMMMMMMMMM    MMMMMMMMMMMMMMM                 MMMMMM");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("MMMMMMMMM   MMMMMMMMMMMMMMMMMMMM                MMMM");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("MMMMMMMM  MMMMMMMMMMMMMMMMMMMMMMMMM               MM");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("MMMMMMM   MMMMMMMMMMMMMMMMMMMMMMMMMMM            MMM");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("MMMMMM    MMMMMMMMMMMMMMMMMMMMMMMMMMMMM        MMMMM");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("MMMMMM      MMMMMMMMMMMMMMMMMMMMMMMMMMMMM    MMMMMMM");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("MMMMMM      MMMMMMMMMMMMMMMMMMMMMMMMMMMMMM  MMMMMMMM");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("MMMMMMM    MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM|");
    _builder_1.newLine();
    this.testAutoEdit(_builder, 't', _builder_1);
  }
  
  private void testAutoEdit(final CharSequence it, final char key, final CharSequence newContent) {
    this.dslFileHasContent(this.press(this.dslFile(it), key), newContent);
  }
  
  private XtextEditor dslFile(final CharSequence it) {
    try {
      return this.openEditor(it.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private XtextEditor press(final XtextEditor it, final char c) {
    try {
      XtextEditor _xblockexpression = null;
      {
        this.pressKey(it, c);
        _xblockexpression = it;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void dslFileHasContent(final XtextEditor editor, final CharSequence it) {
    this.assertState(it.toString(), editor);
  }
  
  private void createTestProjectWithXtextNature() {
    try {
      IResourcesSetupUtil.addNature(IResourcesSetupUtil.createProject("foo"), XtextProjectHelper.NATURE_ID);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  protected String getFileExtension() {
    return this._fileExtensionProvider.getPrimaryFileExtension();
  }
}
