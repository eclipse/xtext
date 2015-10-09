/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.builder;

import com.google.inject.name.Names;
import java.util.Collections;
import java.util.Set;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.eclipse.xtext.resource.containers.ResourceSetBasedAllContainersStateProvider;
import org.eclipse.xtext.resource.containers.StateBasedContainerManager;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xtext.generator.AbstractGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.BundleProjectConfig;
import org.eclipse.xtext.xtext.generator.ILanguageConfig;
import org.eclipse.xtext.xtext.generator.XtextProjectConfig;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

@SuppressWarnings("all")
public class BuilderIntegrationFragment2 extends AbstractGeneratorFragment2 {
  @Override
  public void generate() {
    this.addRuntimeGuiceBindings();
    this.addEclipsePluginGuiceBindings();
    XtextProjectConfig _projectConfig = this.getProjectConfig();
    BundleProjectConfig _eclipsePlugin = _projectConfig.getEclipsePlugin();
    ManifestAccess _manifest = _eclipsePlugin.getManifest();
    boolean _tripleNotEquals = (_manifest != null);
    if (_tripleNotEquals) {
      XtextProjectConfig _projectConfig_1 = this.getProjectConfig();
      BundleProjectConfig _eclipsePlugin_1 = _projectConfig_1.getEclipsePlugin();
      ManifestAccess _manifest_1 = _eclipsePlugin_1.getManifest();
      Set<String> _requiredBundles = _manifest_1.getRequiredBundles();
      _requiredBundles.addAll(
        Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("org.eclipse.xtext.builder", "org.eclipse.xtext.ui")));
    }
  }
  
  protected void addRuntimeGuiceBindings() {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("binder.bind(");
        _builder.append(IResourceDescriptions.class, "");
        _builder.append(".class).to(");
        _builder.append(ResourceSetBasedResourceDescriptions.class, "");
        _builder.append(".class);");
      }
    };
    final StringConcatenationClient statement1 = _client;
    StringConcatenationClient _client_1 = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("binder.bind(");
        _builder.append(IResourceDescriptions.class, "");
        _builder.append(".class).annotatedWith(");
        _builder.append(Names.class, "");
        _builder.append(".named(");
        _builder.append(ResourceDescriptionsProvider.class, "");
        _builder.append(".PERSISTED_DESCRIPTIONS)).to(");
        _builder.append(ResourceSetBasedResourceDescriptions.class, "");
        _builder.append(".class);");
      }
    };
    final StringConcatenationClient statement2 = _client_1;
    GuiceModuleAccess.BindingFactory _bindingFactory = new GuiceModuleAccess.BindingFactory();
    TypeReference _typeRef = TypeReference.typeRef(IContainer.Manager.class);
    TypeReference _typeRef_1 = TypeReference.typeRef(StateBasedContainerManager.class);
    GuiceModuleAccess.BindingFactory _addTypeToType = _bindingFactory.addTypeToType(_typeRef, _typeRef_1);
    TypeReference _typeRef_2 = TypeReference.typeRef(IAllContainersState.Provider.class);
    TypeReference _typeRef_3 = TypeReference.typeRef(ResourceSetBasedAllContainersStateProvider.class);
    GuiceModuleAccess.BindingFactory _addTypeToType_1 = _addTypeToType.addTypeToType(_typeRef_2, _typeRef_3);
    String _simpleName = IResourceDescriptions.class.getSimpleName();
    GuiceModuleAccess.BindingFactory _addConfiguredBinding = _addTypeToType_1.addConfiguredBinding(_simpleName, statement1);
    String _simpleName_1 = IResourceDescriptions.class.getSimpleName();
    String _plus = (_simpleName_1 + "Persisted");
    GuiceModuleAccess.BindingFactory _addConfiguredBinding_1 = _addConfiguredBinding.addConfiguredBinding(_plus, statement2);
    ILanguageConfig _language = this.getLanguage();
    GuiceModuleAccess _runtimeGenModule = _language.getRuntimeGenModule();
    _addConfiguredBinding_1.contributeTo(_runtimeGenModule);
  }
  
  protected void addEclipsePluginGuiceBindings() {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("binder.bind(");
        _builder.append(IResourceDescriptions.class, "");
        _builder.append(".class).annotatedWith(");
        _builder.append(Names.class, "");
        _builder.append(".named(");
        _builder.append(ResourceDescriptionsProvider.class, "");
        _builder.append(".NAMED_BUILDER_SCOPE)).to(");
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.builder.clustering.CurrentDescriptions.ResourceSetAware");
        _builder.append(_typeRef, "");
        _builder.append(".class);");
      }
    };
    final StringConcatenationClient statement1 = _client;
    StringConcatenationClient _client_1 = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("binder.bind(");
        _builder.append(IResourceDescriptions.class, "");
        _builder.append(".class).annotatedWith(");
        _builder.append(Names.class, "");
        _builder.append(".named(");
        _builder.append(ResourceDescriptionsProvider.class, "");
        _builder.append(".PERSISTED_DESCRIPTIONS)).to(");
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.builder.builderState.IBuilderState");
        _builder.append(_typeRef, "");
        _builder.append(".class);");
      }
    };
    final StringConcatenationClient statement2 = _client_1;
    GuiceModuleAccess.BindingFactory _bindingFactory = new GuiceModuleAccess.BindingFactory();
    String _simpleName = IResourceDescriptions.class.getSimpleName();
    String _plus = (_simpleName + "BuilderScope");
    GuiceModuleAccess.BindingFactory _addConfiguredBinding = _bindingFactory.addConfiguredBinding(_plus, statement1);
    TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.ui.editor.IXtextEditorCallback");
    TypeReference _typeRef_1 = TypeReference.typeRef("org.eclipse.xtext.builder.nature.NatureAddingEditorCallback");
    GuiceModuleAccess.BindingFactory _addTypeToType = _addConfiguredBinding.addTypeToType(_typeRef, _typeRef_1);
    TypeReference _typeRef_2 = TypeReference.typeRef("org.eclipse.xtext.generator.IContextualOutputConfigurationProvider");
    TypeReference _typeRef_3 = TypeReference.typeRef("org.eclipse.xtext.builder.EclipseOutputConfigurationProvider");
    GuiceModuleAccess.BindingFactory _addTypeToType_1 = _addTypeToType.addTypeToType(_typeRef_2, _typeRef_3);
    String _simpleName_1 = IResourceDescriptions.class.getSimpleName();
    String _plus_1 = (_simpleName_1 + "Persisted");
    GuiceModuleAccess.BindingFactory _addConfiguredBinding_1 = _addTypeToType_1.addConfiguredBinding(_plus_1, statement2);
    TypeReference _typeRef_4 = TypeReference.typeRef("org.eclipse.xtext.ui.editor.DocumentBasedDirtyResource");
    TypeReference _typeRef_5 = TypeReference.typeRef("org.eclipse.xtext.builder.impl.PersistentDataAwareDirtyResource");
    GuiceModuleAccess.BindingFactory _addTypeToType_2 = _addConfiguredBinding_1.addTypeToType(_typeRef_4, _typeRef_5);
    ILanguageConfig _language = this.getLanguage();
    GuiceModuleAccess _eclipsePluginGenModule = _language.getEclipsePluginGenModule();
    _addTypeToType_2.contributeTo(_eclipsePluginGenModule);
  }
}
