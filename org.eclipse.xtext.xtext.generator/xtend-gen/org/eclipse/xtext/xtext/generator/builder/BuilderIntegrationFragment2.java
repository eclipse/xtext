/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.builder;

import com.google.inject.name.Names;
import java.util.Collections;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.eclipse.xtext.resource.containers.ResourceSetBasedAllContainersStateProvider;
import org.eclipse.xtext.resource.containers.StateBasedContainerManager;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

@SuppressWarnings("all")
public class BuilderIntegrationFragment2 extends AbstractXtextGeneratorFragment {
  @Override
  public void generate() {
    this.addRuntimeGuiceBindings();
    this.addEclipsePluginGuiceBindings();
    ManifestAccess _manifest = this.getProjectConfig().getEclipsePlugin().getManifest();
    boolean _tripleNotEquals = (_manifest != null);
    if (_tripleNotEquals) {
      this.getProjectConfig().getEclipsePlugin().getManifest().getRequiredBundles().addAll(
        Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("org.eclipse.xtext.builder", "org.eclipse.xtext.ui")));
    }
  }

  protected void addRuntimeGuiceBindings() {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("binder.bind(");
        _builder.append(IResourceDescriptions.class);
        _builder.append(".class).to(");
        _builder.append(ResourceSetBasedResourceDescriptions.class);
        _builder.append(".class);");
      }
    };
    final StringConcatenationClient statement1 = _client;
    StringConcatenationClient _client_1 = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("binder.bind(");
        _builder.append(IResourceDescriptions.class);
        _builder.append(".class).annotatedWith(");
        _builder.append(Names.class);
        _builder.append(".named(");
        _builder.append(ResourceDescriptionsProvider.class);
        _builder.append(".PERSISTED_DESCRIPTIONS)).to(");
        _builder.append(ResourceSetBasedResourceDescriptions.class);
        _builder.append(".class);");
      }
    };
    final StringConcatenationClient statement2 = _client_1;
    GuiceModuleAccess.BindingFactory _addConfiguredBinding = new GuiceModuleAccess.BindingFactory().addTypeToType(TypeReference.typeRef(IContainer.Manager.class), 
      TypeReference.typeRef(StateBasedContainerManager.class)).addTypeToType(TypeReference.typeRef(IAllContainersState.Provider.class), 
      TypeReference.typeRef(ResourceSetBasedAllContainersStateProvider.class)).addConfiguredBinding(IResourceDescriptions.class.getSimpleName(), statement1);
    String _simpleName = IResourceDescriptions.class.getSimpleName();
    String _plus = (_simpleName + "Persisted");
    _addConfiguredBinding.addConfiguredBinding(_plus, statement2).contributeTo(this.getLanguage().getRuntimeGenModule());
  }

  protected void addEclipsePluginGuiceBindings() {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("binder.bind(");
        _builder.append(IResourceDescriptions.class);
        _builder.append(".class).annotatedWith(");
        _builder.append(Names.class);
        _builder.append(".named(");
        _builder.append(ResourceDescriptionsProvider.class);
        _builder.append(".NAMED_BUILDER_SCOPE)).to(");
        TypeReference _typeReference = new TypeReference("org.eclipse.xtext.builder.clustering", "CurrentDescriptions.ResourceSetAware");
        _builder.append(_typeReference);
        _builder.append(".class);");
      }
    };
    final StringConcatenationClient statement1 = _client;
    StringConcatenationClient _client_1 = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("binder.bind(");
        _builder.append(IResourceDescriptions.class);
        _builder.append(".class).annotatedWith(");
        _builder.append(Names.class);
        _builder.append(".named(");
        _builder.append(ResourceDescriptionsProvider.class);
        _builder.append(".PERSISTED_DESCRIPTIONS)).to(");
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.builder.builderState.IBuilderState");
        _builder.append(_typeRef);
        _builder.append(".class);");
      }
    };
    final StringConcatenationClient statement2 = _client_1;
    GuiceModuleAccess.BindingFactory _bindingFactory = new GuiceModuleAccess.BindingFactory();
    String _simpleName = IResourceDescriptions.class.getSimpleName();
    String _plus = (_simpleName + "BuilderScope");
    GuiceModuleAccess.BindingFactory _addTypeToType = _bindingFactory.addConfiguredBinding(_plus, statement1).addTypeToType(TypeReference.typeRef("org.eclipse.xtext.ui.editor.IXtextEditorCallback"), 
      TypeReference.typeRef("org.eclipse.xtext.builder.nature.NatureAddingEditorCallback")).addTypeToType(TypeReference.typeRef("org.eclipse.xtext.generator.IContextualOutputConfigurationProvider"), 
      TypeReference.typeRef("org.eclipse.xtext.builder.EclipseOutputConfigurationProvider"));
    String _simpleName_1 = IResourceDescriptions.class.getSimpleName();
    String _plus_1 = (_simpleName_1 + "Persisted");
    _addTypeToType.addConfiguredBinding(_plus_1, statement2).addTypeToType(TypeReference.typeRef("org.eclipse.xtext.ui.editor.DocumentBasedDirtyResource"), 
      TypeReference.typeRef("org.eclipse.xtext.builder.impl.PersistentDataAwareDirtyResource")).contributeTo(this.getLanguage().getEclipsePluginGenModule());
  }
}
