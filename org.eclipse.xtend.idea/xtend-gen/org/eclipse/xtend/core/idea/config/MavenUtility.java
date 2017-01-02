/**
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.config;

import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import com.intellij.util.xml.DomUtil;
import java.util.List;
import org.eclipse.xtend.core.idea.config.XtendLibraryConfigurator;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.idea.util.PlatformUtil;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.jetbrains.idea.maven.dom.MavenDomUtil;
import org.jetbrains.idea.maven.dom.model.MavenDomDependency;
import org.jetbrains.idea.maven.dom.model.MavenDomProjectModel;
import org.jetbrains.idea.maven.model.MavenId;
import org.jetbrains.idea.maven.project.MavenProject;
import org.jetbrains.idea.maven.project.MavenProjectsManager;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class MavenUtility {
  public void addXtendLibMavenDependency(final Module module, final boolean isTestScope) {
    boolean _isMavenizedModule = this.isMavenizedModule(module);
    boolean _not = (!_isMavenizedModule);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Can\'t add maven dependency to a non maven module ");
      String _name = module.getName();
      _builder.append(_name);
      throw new IllegalArgumentException(_builder.toString());
    }
    final Project project = module.getProject();
    final MavenProjectsManager mavenProjectsManager = MavenProjectsManager.getInstance(project);
    final MavenProject mavenProject = mavenProjectsManager.findProject(module);
    if ((mavenProject == null)) {
      return;
    }
    final MavenDomProjectModel model = MavenDomUtil.getMavenDomProjectModel(project, mavenProject.getFile());
    if ((model == null)) {
      return;
    }
    List<PsiFile> _newImmutableList = CollectionLiterals.<PsiFile>newImmutableList(DomUtil.getFile(model));
    new WriteCommandAction.Simple(project, "Add Xtend lib Maven Dependency", ((PsiFile[])Conversions.unwrapArray(_newImmutableList, PsiFile.class))) {
      @Override
      protected void run() throws Throwable {
        String _groupId = XtendLibraryConfigurator.xtendLibMavenId().getGroupId();
        String _artifactId = XtendLibraryConfigurator.xtendLibMavenId().getArtifactId();
        String _version = XtendLibraryConfigurator.xtendLibMavenId().getVersion();
        MavenId _mavenId = new MavenId(_groupId, _artifactId, _version);
        MavenDomDependency dependency = MavenDomUtil.createDomDependency(model, null, _mavenId);
        if (isTestScope) {
          dependency.getScope().setStringValue("test");
        }
      }
    }.execute();
  }
  
  public boolean isMavenizedModule(final Module module) {
    boolean _isMavenInstalled = new PlatformUtil().isMavenInstalled();
    if (_isMavenInstalled) {
      MavenProjectsManager mavenProjectsManager = MavenProjectsManager.getInstance(module.getProject());
      boolean _xifexpression = false;
      if ((mavenProjectsManager != null)) {
        _xifexpression = mavenProjectsManager.isMavenizedModule(module);
      } else {
        _xifexpression = false;
      }
      return _xifexpression;
    }
    return false;
  }
}
