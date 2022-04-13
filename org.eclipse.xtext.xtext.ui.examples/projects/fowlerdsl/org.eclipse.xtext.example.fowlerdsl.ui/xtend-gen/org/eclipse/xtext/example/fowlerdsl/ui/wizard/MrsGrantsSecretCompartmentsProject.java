/**
 * Copyright (c) 2019, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.fowlerdsl.ui.wizard;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Collections;
import java.util.List;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.example.fowlerdsl.ui.internal.FowlerdslActivator;
import org.eclipse.xtext.ui.PluginImageHelper;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.util.PluginProjectFactory;
import org.eclipse.xtext.ui.wizard.template.AbstractProjectTemplate;
import org.eclipse.xtext.ui.wizard.template.BooleanTemplateVariable;
import org.eclipse.xtext.ui.wizard.template.GroupTemplateVariable;
import org.eclipse.xtext.ui.wizard.template.IProjectGenerator;
import org.eclipse.xtext.ui.wizard.template.ProjectTemplate;
import org.eclipse.xtext.ui.wizard.template.StringTemplateVariable;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@ProjectTemplate(label = "Mrs Grant\'s Secret Compartments", icon = "project_template.png", description = ("<p><b>Mrs Grant\'s Secret Compartments</b></p>" + 
  "<p>A Fowler Statemachine representing Mrs Grant\'s Secret Compartments.</p><p><img href=\"mrsgrantssecretcompartment.png\"/></p>"))
@SuppressWarnings("all")
public final class MrsGrantsSecretCompartmentsProject extends AbstractProjectTemplate {
  private final BooleanTemplateVariable advanced = this.check("Advanced:", false);

  private final GroupTemplateVariable advancedGroup = this.group("Properties");

  private final StringTemplateVariable path = this.text("Package:", "mydsl", "The package path to place the files in", this.advancedGroup);

  @Inject
  private PluginImageHelper pluginImageHelper;

  @Override
  protected void updateVariables() {
    this.path.setEnabled(this.advanced.getValue());
    boolean _value = this.advanced.getValue();
    boolean _not = (!_value);
    if (_not) {
      this.path.setValue("statemachine");
    }
  }

  @Override
  protected IStatus validate() {
    Status _xifexpression = null;
    boolean _matches = this.path.getValue().matches("[a-z][a-z0-9_]*(/[a-z][a-z0-9_]*)*");
    if (_matches) {
      _xifexpression = null;
    } else {
      _xifexpression = new Status(IStatus.ERROR, "Wizard", (("\'" + this.path) + "\' is not a valid package name"));
    }
    return _xifexpression;
  }

  @Override
  public void generateProjects(final IProjectGenerator generator) {
    PluginProjectFactory _pluginProjectFactory = new PluginProjectFactory();
    final Procedure1<PluginProjectFactory> _function = (PluginProjectFactory it) -> {
      it.setProjectName(this.getProjectInfo().getProjectName());
      it.setLocation(this.getProjectInfo().getLocationPath());
      List<String> _projectNatures = it.getProjectNatures();
      Iterables.<String>addAll(_projectNatures, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(JavaCore.NATURE_ID, "org.eclipse.pde.PluginNature", XtextProjectHelper.NATURE_ID)));
      List<String> _builderIds = it.getBuilderIds();
      Iterables.<String>addAll(_builderIds, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(JavaCore.BUILDER_ID, XtextProjectHelper.BUILDER_ID)));
      List<String> _folders = it.getFolders();
      _folders.add("src");
      List<String> _folders_1 = it.getFolders();
      _folders_1.add("src-gen");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("src/");
      _builder.append(this.path);
      _builder.append("/MrsGrantsSecretCompartments.statemachine");
      this.addFile(it, _builder, TemplateContent.MrsGrantsSecretCompartments);
    };
    PluginProjectFactory _doubleArrow = ObjectExtensions.<PluginProjectFactory>operator_doubleArrow(_pluginProjectFactory, _function);
    generator.generate(_doubleArrow);
  }

  @Override
  protected List<Pair<String, Image>> getImages() {
    Pair<String, Image> _image = this.image("mrsgrantssecretcompartment.png");
    return Collections.<Pair<String, Image>>unmodifiableList(CollectionLiterals.<Pair<String, Image>>newArrayList(_image));
  }

  private Pair<String, Image> image(final String id) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("platform:/plugin/");
    _builder.append(FowlerdslActivator.PLUGIN_ID);
    _builder.append("/");
    _builder.append(id);
    Image _image = this.pluginImageHelper.getImage(_builder.toString());
    return Pair.<String, Image>of(id, _image);
  }
}
