/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.arithmetics.ui.tests.autoedit;

import com.google.inject.Inject;
import java.util.Collections;
import java.util.List;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.example.arithmetics.ui.internal.ArithmeticsActivator;
import org.eclipse.xtext.example.arithmetics.ui.tests.ArithmeticsUiInjectorProvider;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.ui.AbstractAutoEditTest;
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
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
      final Procedure1<XtextEditor> _function = new Procedure1<XtextEditor>() {
        @Override
        public void apply(final XtextEditor it) {
          try {
            AutoEditTest.this.pressKey(it, '\n');
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("module MyModule");
            _builder.newLine();
            _builder.newLine();
            _builder.append("1 + 2;");
            _builder.newLine();
            _builder.append("// = 3");
            _builder.newLine();
            _builder.append("|");
            _builder.newLine();
            AutoEditTest.this.assertState(it, _builder.toString());
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
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
    try {
      this.createPluginProject("foo");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  protected String getFileExtension() {
    return this.extensionProvider.getPrimaryFileExtension();
  }
  
  @Override
  protected String getEditorId() {
    return ArithmeticsActivator.ORG_ECLIPSE_XTEXT_EXAMPLE_ARITHMETICS_ARITHMETICS;
  }
  
  protected IProject createPluginProject(final String name) throws CoreException {
    this.projectFactory.setBreeToUse(JREContainerProvider.PREFERRED_BREE);
    this.projectFactory.setProjectName(name);
    List<String> _singletonList = Collections.<String>singletonList("src");
    this.projectFactory.addFolders(_singletonList);
    this.projectFactory.addBuilderIds(XtextProjectHelper.BUILDER_ID);
    this.projectFactory.addProjectNatures(XtextProjectHelper.NATURE_ID);
    NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
    IProject result = this.projectFactory.createProject(_nullProgressMonitor, null);
    JavaProjectSetupUtil.setUnixLineEndings(result);
    return result;
  }
}
