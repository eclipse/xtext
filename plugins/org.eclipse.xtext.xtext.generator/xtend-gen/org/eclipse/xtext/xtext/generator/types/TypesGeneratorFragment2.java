/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.types;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.AbstractGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.IBundleProjectConfig;
import org.eclipse.xtext.xtext.generator.ILanguageConfig;
import org.eclipse.xtext.xtext.generator.IRuntimeProjectConfig;
import org.eclipse.xtext.xtext.generator.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.xbase.XbaseUsageDetector;

@SuppressWarnings("all")
public class TypesGeneratorFragment2 extends AbstractGeneratorFragment2 {
  @Inject
  private XbaseUsageDetector xbaseUsageDetector;
  
  @Accessors
  private boolean onlyEnabledIfGrammarIsUsed = false;
  
  @Override
  public void generate() {
    boolean _and = false;
    if (!this.onlyEnabledIfGrammarIsUsed) {
      _and = false;
    } else {
      ILanguageConfig _language = this.getLanguage();
      Grammar _grammar = _language.getGrammar();
      boolean _inheritsXtype = this.xbaseUsageDetector.inheritsXtype(_grammar);
      boolean _not = (!_inheritsXtype);
      _and = _not;
    }
    if (_and) {
      return;
    }
    GuiceModuleAccess.BindingFactory _bindingFactory = new GuiceModuleAccess.BindingFactory();
    TypeReference _typeRef = TypeReference.typeRef(IGlobalScopeProvider.class);
    TypeReference _typeRef_1 = TypeReference.typeRef("org.eclipse.xtext.common.types.xtext.TypesAwareDefaultGlobalScopeProvider");
    GuiceModuleAccess.BindingFactory _addTypeToType = _bindingFactory.addTypeToType(_typeRef, _typeRef_1);
    ILanguageConfig _language_1 = this.getLanguage();
    GuiceModuleAccess _runtimeGenModule = _language_1.getRuntimeGenModule();
    _addTypeToType.contributeTo(_runtimeGenModule);
    ILanguageConfig _language_2 = this.getLanguage();
    GuiceModuleAccess _runtimeGenModule_1 = _language_2.getRuntimeGenModule();
    TypeReference _typeRef_2 = TypeReference.typeRef("org.eclipse.xtext.common.types.DefaultCommonTypesRuntimeModule");
    _runtimeGenModule_1.setSuperClass(_typeRef_2);
    GuiceModuleAccess.BindingFactory _bindingFactory_1 = new GuiceModuleAccess.BindingFactory();
    TypeReference _typeRef_3 = TypeReference.typeRef("org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher");
    TypeReference _typeRef_4 = TypeReference.typeRef("org.eclipse.xtext.ui.editor.contentassist.FQNPrefixMatcher");
    GuiceModuleAccess.BindingFactory _addTypeToType_1 = _bindingFactory_1.addTypeToType(_typeRef_3, _typeRef_4);
    ILanguageConfig _language_3 = this.getLanguage();
    GuiceModuleAccess _eclipsePluginGenModule = _language_3.getEclipsePluginGenModule();
    _addTypeToType_1.contributeTo(_eclipsePluginGenModule);
    ILanguageConfig _language_4 = this.getLanguage();
    GuiceModuleAccess _eclipsePluginGenModule_1 = _language_4.getEclipsePluginGenModule();
    TypeReference _typeRef_5 = TypeReference.typeRef("org.eclipse.xtext.common.types.ui.DefaultCommonTypesUiModule");
    _eclipsePluginGenModule_1.setSuperClass(_typeRef_5);
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IRuntimeProjectConfig _runtime = _projectConfig.getRuntime();
    ManifestAccess _manifest = _runtime.getManifest();
    boolean _tripleNotEquals = (_manifest != null);
    if (_tripleNotEquals) {
      IXtextProjectConfig _projectConfig_1 = this.getProjectConfig();
      IRuntimeProjectConfig _runtime_1 = _projectConfig_1.getRuntime();
      ManifestAccess _manifest_1 = _runtime_1.getManifest();
      Set<String> _requiredBundles = _manifest_1.getRequiredBundles();
      CollectionExtensions.<String>addAll(_requiredBundles, 
        "org.eclipse.xtext.common.types", 
        "org.objectweb.asm;bundle-version=\"[5.0.1,6.0.0)\";resolution:=optional");
    }
    IXtextProjectConfig _projectConfig_2 = this.getProjectConfig();
    IBundleProjectConfig _runtimeTest = _projectConfig_2.getRuntimeTest();
    ManifestAccess _manifest_2 = _runtimeTest.getManifest();
    boolean _tripleNotEquals_1 = (_manifest_2 != null);
    if (_tripleNotEquals_1) {
      IXtextProjectConfig _projectConfig_3 = this.getProjectConfig();
      IBundleProjectConfig _runtimeTest_1 = _projectConfig_3.getRuntimeTest();
      ManifestAccess _manifest_3 = _runtimeTest_1.getManifest();
      Set<String> _requiredBundles_1 = _manifest_3.getRequiredBundles();
      _requiredBundles_1.add(
        "org.objectweb.asm;bundle-version=\"[5.0.1,6.0.0)\";resolution:=optional");
    }
    IXtextProjectConfig _projectConfig_4 = this.getProjectConfig();
    IBundleProjectConfig _eclipsePlugin = _projectConfig_4.getEclipsePlugin();
    ManifestAccess _manifest_4 = _eclipsePlugin.getManifest();
    boolean _tripleNotEquals_2 = (_manifest_4 != null);
    if (_tripleNotEquals_2) {
      IXtextProjectConfig _projectConfig_5 = this.getProjectConfig();
      IBundleProjectConfig _eclipsePlugin_1 = _projectConfig_5.getEclipsePlugin();
      ManifestAccess _manifest_5 = _eclipsePlugin_1.getManifest();
      Set<String> _requiredBundles_2 = _manifest_5.getRequiredBundles();
      _requiredBundles_2.add(
        "org.eclipse.xtext.common.types.ui");
    }
  }
  
  @Pure
  public boolean isOnlyEnabledIfGrammarIsUsed() {
    return this.onlyEnabledIfGrammarIsUsed;
  }
  
  public void setOnlyEnabledIfGrammarIsUsed(final boolean onlyEnabledIfGrammarIsUsed) {
    this.onlyEnabledIfGrammarIsUsed = onlyEnabledIfGrammarIsUsed;
  }
}
