/**
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.arithmetics.ui.tests.autoedit;

import com.google.inject.Inject;
import java.util.Collections;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.example.arithmetics.ui.tests.ArithmeticsUiInjectorProvider;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.testing.AbstractAutoEditTest;
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.util.JREContainerProvider;
import org.eclipse.xtext.ui.util.PluginProjectFactory;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(ArithmeticsUiInjectorProvider.class)
@SuppressWarnings("all")
public class AutoEditTest extends AbstractAutoEditTest {
  @Test
  public void testCalculatorAutoEdit() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("module MyModule");
      _builder.newLine();
      _builder.newLine();
      _builder.append("1 + 2;|");
      _builder.newLine();
      XtextEditor _openEditor = this.openEditor(_builder.toString());
      final Procedure1<XtextEditor> _function = (XtextEditor it) -> {
        try {
          this.pressKey(it, '\n');
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("module MyModule");
          _builder_1.newLine();
          _builder_1.newLine();
          _builder_1.append("1 + 2;");
          _builder_1.newLine();
          _builder_1.append("// = 3");
          _builder_1.newLine();
          _builder_1.append("|");
          _builder_1.newLine();
          this.assertState(it, _builder_1.toString());
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      ObjectExtensions.<XtextEditor>operator_doubleArrow(_openEditor, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Inject
  private FileExtensionProvider extensionProvider;
  
  @Inject
  private PluginProjectFactory projectFactory;
  
  @Before
  public void doSetup() {
    this.createPluginProject("foo");
  }
  
  @Override
  protected String getFileExtension() {
    return this.extensionProvider.getPrimaryFileExtension();
  }
  
  private IProject createPluginProject(final String name) {
    this.projectFactory.setBreeToUse(JREContainerProvider.PREFERRED_BREE);
    this.projectFactory.setProjectName(name);
    this.projectFactory.addFolders(Collections.<String>singletonList("src"));
    this.projectFactory.addBuilderIds(XtextProjectHelper.BUILDER_ID);
    this.projectFactory.addProjectNatures(XtextProjectHelper.NATURE_ID);
    NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
    final IProject result = this.projectFactory.createProject(_nullProgressMonitor, null);
    JavaProjectSetupUtil.setUnixLineEndings(result);
    return result;
  }
}
