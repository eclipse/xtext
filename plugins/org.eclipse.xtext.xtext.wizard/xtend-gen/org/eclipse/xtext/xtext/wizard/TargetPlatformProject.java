/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.wizard;

import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.XtextVersion;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtext.wizard.AbstractFile;
import org.eclipse.xtext.xtext.wizard.GradleBuildFile;
import org.eclipse.xtext.xtext.wizard.Outlet;
import org.eclipse.xtext.xtext.wizard.PlainTextFile;
import org.eclipse.xtext.xtext.wizard.PomFile;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.WizardConfiguration;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class TargetPlatformProject extends ProjectDescriptor {
  @Override
  public String getNameQualifier() {
    return ".target";
  }
  
  @Override
  public boolean isEclipsePluginProject() {
    return false;
  }
  
  @Override
  public boolean isPartOfGradleBuild() {
    return false;
  }
  
  @Override
  public boolean isPartOfMavenBuild() {
    return true;
  }
  
  @Override
  public boolean isEnabled() {
    WizardConfiguration _config = this.getConfig();
    return _config.needsTychoBuild();
  }
  
  @Override
  public void setEnabled(final boolean enabled) {
    throw new UnsupportedOperationException("The target platform project is activated automatically for Tycho builds");
  }
  
  @Override
  public Iterable<? extends AbstractFile> getFiles() {
    ArrayList<AbstractFile> _xblockexpression = null;
    {
      final ArrayList<AbstractFile> files = CollectionLiterals.<AbstractFile>newArrayList();
      Iterable<? extends AbstractFile> _files = super.getFiles();
      Iterables.<AbstractFile>addAll(files, _files);
      String _name = this.getName();
      String _plus = (_name + ".target");
      CharSequence _target = this.target();
      PlainTextFile _file = this.file(Outlet.ROOT, _plus, _target);
      files.add(_file);
      _xblockexpression = files;
    }
    return _xblockexpression;
  }
  
  @Override
  public Set<String> getSourceFolders() {
    return Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet());
  }
  
  public CharSequence target() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
    _builder.newLine();
    _builder.append("<?pde version=\"3.8\"?>");
    _builder.newLine();
    _builder.append("<target name=\"");
    String _name = this.getName();
    _builder.append(_name, "");
    _builder.append("\" sequenceNumber=\"1\">");
    _builder.newLineIfNotEmpty();
    _builder.append("<locations>");
    _builder.newLine();
    _builder.append("<location includeAllPlatforms=\"false\" includeConfigurePhase=\"false\" includeMode=\"planner\" includeSource=\"false\" type=\"InstallableUnit\">");
    _builder.newLine();
    _builder.append("<unit id=\"org.eclipse.jdt.feature.group\" version=\"0.0.0\"/>");
    _builder.newLine();
    _builder.append("<unit id=\"org.eclipse.platform.feature.group\" version=\"0.0.0\"/>");
    _builder.newLine();
    _builder.append("<unit id=\"org.eclipse.pde.feature.group\" version=\"0.0.0\"/>");
    _builder.newLine();
    _builder.append("<unit id=\"org.eclipse.draw2d.feature.group\" version=\"0.0.0\"/>");
    _builder.newLine();
    _builder.append("<unit id=\"org.eclipse.emf.sdk.feature.group\" version=\"0.0.0\"/>");
    _builder.newLine();
    _builder.append("<unit id=\"org.eclipse.xpand\" version=\"0.0.0\"/>");
    _builder.newLine();
    _builder.append("<unit id=\"org.eclipse.xtend\" version=\"0.0.0\"/>");
    _builder.newLine();
    _builder.append("<unit id=\"org.eclipse.xtend.typesystem.emf\" version=\"0.0.0\"/>");
    _builder.newLine();
    _builder.append("<repository location=\"http://download.eclipse.org/releases/mars/201506241002/\"/>");
    _builder.newLine();
    _builder.append("</location>");
    _builder.newLine();
    _builder.append("<location includeAllPlatforms=\"false\" includeConfigurePhase=\"false\" includeMode=\"planner\" includeSource=\"false\" type=\"InstallableUnit\">");
    _builder.newLine();
    _builder.append("<unit id=\"org.eclipse.emf.mwe2.launcher.feature.group\" version=\"0.0.0\"/>");
    _builder.newLine();
    _builder.append("<repository location=\"http://download.eclipse.org/modeling/emft/mwe/updates/releases/2.8.1/\"/>");
    _builder.newLine();
    _builder.append("</location>");
    _builder.newLine();
    _builder.append("<location includeAllPlatforms=\"false\" includeConfigurePhase=\"false\" includeMode=\"planner\" includeSource=\"false\" type=\"InstallableUnit\">");
    _builder.newLine();
    _builder.append("<unit id=\"org.eclipse.xtext.sdk.feature.group\" version=\"0.0.0\"/>");
    _builder.newLine();
    {
      WizardConfiguration _config = this.getConfig();
      XtextVersion _xtextVersion = _config.getXtextVersion();
      boolean _isSnapshot = _xtextVersion.isSnapshot();
      if (_isSnapshot) {
        _builder.append("<repository location=\"http://download.eclipse.org/modeling/tmf/xtext/updates/nightly/\"/>");
        _builder.newLine();
      } else {
        WizardConfiguration _config_1 = this.getConfig();
        XtextVersion _xtextVersion_1 = _config_1.getXtextVersion();
        boolean _isStable = _xtextVersion_1.isStable();
        if (_isStable) {
          _builder.append("<repository location=\"http://download.eclipse.org/modeling/tmf/xtext/updates/milestones/\"/>");
          _builder.newLine();
        } else {
          _builder.append("<repository location=\"http://download.eclipse.org/modeling/tmf/xtext/updates/releases/");
          WizardConfiguration _config_2 = this.getConfig();
          XtextVersion _xtextVersion_2 = _config_2.getXtextVersion();
          _builder.append(_xtextVersion_2, "");
          _builder.append("/\"/>");
          _builder.newLineIfNotEmpty();
        }
      }
    }
    _builder.append("</location>");
    _builder.newLine();
    _builder.append("</locations>");
    _builder.newLine();
    _builder.append("</target>");
    _builder.newLine();
    return _builder;
  }
  
  @Override
  public GradleBuildFile buildGradle() {
    throw new UnsupportedOperationException("Eclipse target platforms are not yet supported in Gradle");
  }
  
  @Override
  public PomFile pom() {
    PomFile _pom = super.pom();
    final Procedure1<PomFile> _function = new Procedure1<PomFile>() {
      @Override
      public void apply(final PomFile it) {
        it.setPackaging("eclipse-target-definition");
      }
    };
    return ObjectExtensions.<PomFile>operator_doubleArrow(_pom, _function);
  }
  
  public TargetPlatformProject(final WizardConfiguration config) {
    super(config);
  }
}
