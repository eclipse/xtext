/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.framework;

import com.google.inject.Inject;
import com.intellij.framework.FrameworkTypeEx;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.roots.ModifiableModelsProvider;
import com.intellij.openapi.roots.ModifiableRootModel;
import org.eclipse.xtend.core.idea.config.XtendLibraryConfigurator;
import org.eclipse.xtend.core.idea.config.XtendProjectConfigurator;
import org.eclipse.xtend.core.idea.facet.XtendFacetConfiguration;
import org.eclipse.xtend.core.idea.framework.XtendFrameworkType;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.XtextVersion;
import org.jetbrains.plugins.gradle.frameworkSupport.BuildScriptDataBuilder;
import org.jetbrains.plugins.gradle.frameworkSupport.GradleFrameworkSupportProvider;

/**
 * @author Dennis Huebner (dhuebner) - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendGradleFrameworkSupportProvider extends GradleFrameworkSupportProvider {
  @Inject
  private XtendProjectConfigurator projectConfigurator;
  
  public XtendGradleFrameworkSupportProvider() {
    XtendLanguage.INSTANCE.injectMembers(this);
  }
  
  @Override
  public FrameworkTypeEx getFrameworkType() {
    return FrameworkTypeEx.EP_NAME.<XtendFrameworkType>findExtension(XtendFrameworkType.class);
  }
  
  @Override
  public void addSupport(final Module module, final ModifiableRootModel rootModel, final ModifiableModelsProvider modifiableModelsProvider, final BuildScriptDataBuilder script) {
    final boolean snapshot = XtextVersion.getCurrent().isSnapshot();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("buildscript {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("repositories {");
    _builder.newLine();
    {
      if (snapshot) {
        _builder.append("\t\t");
        _builder.append("maven {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("url \'http://oss.sonatype.org/content/repositories/snapshots\'");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t    ");
    _builder.append("jcenter()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("dependencies {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("classpath \'org.xtend:xtend-gradle-plugin:");
    String _xtendGradlePluginVersion = XtextVersion.getCurrent().getXtendGradlePluginVersion();
    _builder.append(_xtendGradlePluginVersion, "        ");
    _builder.append("\'");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    script.addOther(_builder.toString());
    BuildScriptDataBuilder _addRepositoriesDefinition = script.addPluginDefinition("apply plugin: \'java\'").addPluginDefinition("apply plugin: \'org.xtend.xtend\'").addPropertyDefinition("sourceCompatibility = 1.5").addRepositoriesDefinition("jcenter()");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("compile \'");
    String _key = XtendLibraryConfigurator.xtendLibMavenId().getKey();
    _builder_1.append(_key);
    _builder_1.append("\' ");
    _addRepositoriesDefinition.addDependencyNotation(_builder_1.toString());
    if (snapshot) {
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("maven {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("url \'http://oss.sonatype.org/content/repositories/snapshots\'");
      _builder_2.newLine();
      _builder_2.append("}");
      script.addRepositoriesDefinition(_builder_2.toString());
    }
    final XtendFacetConfiguration conf = this.projectConfigurator.createOrGetXtendFacetConf(rootModel.getModule());
    this.projectConfigurator.presetGradleOutputDirectories(conf.getState(), rootModel);
    this.projectConfigurator.createOutputFolders(rootModel, conf.getState());
  }
}
