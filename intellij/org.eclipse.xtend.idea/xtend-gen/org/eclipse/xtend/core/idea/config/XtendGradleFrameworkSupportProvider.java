/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.config;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.intellij.framework.FrameworkTypeEx;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.roots.ModifiableModelsProvider;
import com.intellij.openapi.roots.ModifiableRootModel;
import org.eclipse.xtend.core.idea.config.XtendFrameworkType;
import org.eclipse.xtend.core.idea.config.XtendLibraryManager;
import org.eclipse.xtend.core.idea.config.XtendSupportConfigurable;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.jetbrains.idea.maven.model.MavenId;
import org.jetbrains.plugins.gradle.frameworkSupport.BuildScriptDataBuilder;
import org.jetbrains.plugins.gradle.frameworkSupport.GradleFrameworkSupportProvider;

/**
 * @author Dennis Huebner (dhuebner) - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendGradleFrameworkSupportProvider extends GradleFrameworkSupportProvider {
  private final static String XTEND_GRADLE_PLUGIN_VERSION = "0.4.7";
  
  @Inject
  private Provider<XtendSupportConfigurable> xtendSupportConfigurableProvider;
  
  public XtendGradleFrameworkSupportProvider() {
    XtendLanguage.INSTANCE.injectMembers(this);
  }
  
  @Override
  public FrameworkTypeEx getFrameworkType() {
    return FrameworkTypeEx.EP_NAME.<XtendFrameworkType>findExtension(XtendFrameworkType.class);
  }
  
  @Override
  public void addSupport(final Module module, final ModifiableRootModel rootModel, final ModifiableModelsProvider modifiableModelsProvider, final BuildScriptDataBuilder script) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("buildscript {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("repositories {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("mavenCentral()");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("dependencies {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("classpath \'org.xtend:xtend-gradle-plugin:");
    _builder.append(XtendGradleFrameworkSupportProvider.XTEND_GRADLE_PLUGIN_VERSION, "        ");
    _builder.append("\'");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    script.addOther(_builder.toString());
    BuildScriptDataBuilder _addPluginDefinition = script.addPluginDefinition("apply plugin: \'java\'");
    BuildScriptDataBuilder _addPluginDefinition_1 = _addPluginDefinition.addPluginDefinition("apply plugin: \'org.xtend.xtend\'");
    BuildScriptDataBuilder _addPropertyDefinition = _addPluginDefinition_1.addPropertyDefinition("sourceCompatibility = 1.5");
    BuildScriptDataBuilder _addRepositoriesDefinition = _addPropertyDefinition.addRepositoriesDefinition("mavenCentral()");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("compile \'");
    MavenId _xtendLibMavenId = XtendLibraryManager.xtendLibMavenId();
    String _key = _xtendLibMavenId.getKey();
    _builder_1.append(_key, "");
    _builder_1.append("\' ");
    _addRepositoriesDefinition.addDependencyNotation(_builder_1.toString());
    MavenId _xtendLibMavenId_1 = XtendLibraryManager.xtendLibMavenId();
    String _version = _xtendLibMavenId_1.getVersion();
    boolean _endsWith = false;
    if (_version!=null) {
      _endsWith=_version.endsWith("-SNAPSHOT");
    }
    if (_endsWith) {
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("maven {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("url \'http://oss.sonatype.org/content/repositories/snapshots\'");
      _builder_2.newLine();
      _builder_2.append("}");
      script.addRepositoriesDefinition(_builder_2.toString());
    }
    XtendSupportConfigurable _get = this.xtendSupportConfigurableProvider.get();
    _get.addSupport(module, rootModel, modifiableModelsProvider);
  }
}
