/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.types;

import java.util.Set;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xtext.generator.AbstractGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.ILanguageConfig;
import org.eclipse.xtext.xtext.generator.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

@SuppressWarnings("all")
public class TypesGeneratorFragment2 extends AbstractGeneratorFragment2 {
  @Override
  public void generate() {
    GuiceModuleAccess.BindingFactory _bindingFactory = new GuiceModuleAccess.BindingFactory();
    TypeReference _typeRef = TypeReference.typeRef(IGlobalScopeProvider.class);
    TypeReference _typeRef_1 = TypeReference.typeRef("org.eclipse.xtext.common.types.xtext.TypesAwareDefaultGlobalScopeProvider");
    GuiceModuleAccess.BindingFactory _addTypeToType = _bindingFactory.addTypeToType(_typeRef, _typeRef_1);
    ILanguageConfig _language = this.getLanguage();
    GuiceModuleAccess _runtimeGenModule = _language.getRuntimeGenModule();
    _addTypeToType.contributeTo(_runtimeGenModule);
    ILanguageConfig _language_1 = this.getLanguage();
    GuiceModuleAccess _runtimeGenModule_1 = _language_1.getRuntimeGenModule();
    TypeReference _typeRef_2 = TypeReference.typeRef("org.eclipse.xtext.common.types.DefaultCommonTypesRuntimeModule");
    _runtimeGenModule_1.setSuperClass(_typeRef_2);
    GuiceModuleAccess.BindingFactory _bindingFactory_1 = new GuiceModuleAccess.BindingFactory();
    TypeReference _typeRef_3 = TypeReference.typeRef("org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher");
    TypeReference _typeRef_4 = TypeReference.typeRef("org.eclipse.xtext.ui.editor.contentassist.FQNPrefixMatcher");
    GuiceModuleAccess.BindingFactory _addTypeToType_1 = _bindingFactory_1.addTypeToType(_typeRef_3, _typeRef_4);
    ILanguageConfig _language_2 = this.getLanguage();
    GuiceModuleAccess _eclipsePluginGenModule = _language_2.getEclipsePluginGenModule();
    _addTypeToType_1.contributeTo(_eclipsePluginGenModule);
    ILanguageConfig _language_3 = this.getLanguage();
    GuiceModuleAccess _eclipsePluginGenModule_1 = _language_3.getEclipsePluginGenModule();
    TypeReference _typeRef_5 = TypeReference.typeRef("org.eclipse.xtext.common.types.ui.DefaultCommonTypesUiModule");
    _eclipsePluginGenModule_1.setSuperClass(_typeRef_5);
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    ManifestAccess _runtimeManifest = _projectConfig.getRuntimeManifest();
    boolean _tripleNotEquals = (_runtimeManifest != null);
    if (_tripleNotEquals) {
      IXtextProjectConfig _projectConfig_1 = this.getProjectConfig();
      ManifestAccess _runtimeManifest_1 = _projectConfig_1.getRuntimeManifest();
      Set<String> _requiredBundles = _runtimeManifest_1.getRequiredBundles();
      CollectionExtensions.<String>addAll(_requiredBundles, 
        "org.eclipse.xtext.common.types", 
        "org.objectweb.asm;bundle-version=\"[5.0.1,6.0.0)\";resolution:=optional");
    }
    IXtextProjectConfig _projectConfig_2 = this.getProjectConfig();
    ManifestAccess _runtimeTestManifest = _projectConfig_2.getRuntimeTestManifest();
    boolean _tripleNotEquals_1 = (_runtimeTestManifest != null);
    if (_tripleNotEquals_1) {
      IXtextProjectConfig _projectConfig_3 = this.getProjectConfig();
      ManifestAccess _runtimeTestManifest_1 = _projectConfig_3.getRuntimeTestManifest();
      Set<String> _requiredBundles_1 = _runtimeTestManifest_1.getRequiredBundles();
      _requiredBundles_1.add(
        "org.objectweb.asm;bundle-version=\"[5.0.1,6.0.0)\";resolution:=optional");
    }
    IXtextProjectConfig _projectConfig_4 = this.getProjectConfig();
    ManifestAccess _eclipsePluginManifest = _projectConfig_4.getEclipsePluginManifest();
    boolean _tripleNotEquals_2 = (_eclipsePluginManifest != null);
    if (_tripleNotEquals_2) {
      IXtextProjectConfig _projectConfig_5 = this.getProjectConfig();
      ManifestAccess _eclipsePluginManifest_1 = _projectConfig_5.getEclipsePluginManifest();
      Set<String> _requiredBundles_2 = _eclipsePluginManifest_1.getRequiredBundles();
      _requiredBundles_2.add(
        "org.eclipse.xtext.common.types.ui");
    }
  }
}
