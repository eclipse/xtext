/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.types;

import com.google.inject.Inject;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.util.BooleanGeneratorOption;
import org.eclipse.xtext.xtext.generator.xbase.XbaseUsageDetector;

@SuppressWarnings("all")
public class TypesGeneratorFragment2 extends AbstractXtextGeneratorFragment {
  @Inject
  private XbaseUsageDetector xbaseUsageDetector;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final BooleanGeneratorOption onlyEnabledIfGrammarIsUsed = new BooleanGeneratorOption(false);
  
  public void setOnlyEnabledIfGrammarIsUsed(final boolean onlyEnabledIfGrammarIsUsed) {
    this.onlyEnabledIfGrammarIsUsed.set(onlyEnabledIfGrammarIsUsed);
  }
  
  @Override
  public void generate() {
    if ((this.onlyEnabledIfGrammarIsUsed.get() && (!this.xbaseUsageDetector.inheritsXtype(this.getLanguage().getGrammar())))) {
      return;
    }
    new GuiceModuleAccess.BindingFactory().addTypeToType(TypeReference.typeRef(IGlobalScopeProvider.class), 
      TypeReference.typeRef("org.eclipse.xtext.common.types.xtext.TypesAwareDefaultGlobalScopeProvider")).contributeTo(this.getLanguage().getRuntimeGenModule());
    GuiceModuleAccess _runtimeGenModule = this.getLanguage().getRuntimeGenModule();
    _runtimeGenModule.setSuperClass(TypeReference.typeRef("org.eclipse.xtext.common.types.DefaultCommonTypesRuntimeModule"));
    new GuiceModuleAccess.BindingFactory().addTypeToType(TypeReference.typeRef("org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher"), 
      TypeReference.typeRef("org.eclipse.xtext.ui.editor.contentassist.FQNPrefixMatcher")).contributeTo(this.getLanguage().getEclipsePluginGenModule());
    GuiceModuleAccess _eclipsePluginGenModule = this.getLanguage().getEclipsePluginGenModule();
    _eclipsePluginGenModule.setSuperClass(TypeReference.typeRef("org.eclipse.xtext.common.types.ui.DefaultCommonTypesUiModule"));
    ManifestAccess _manifest = this.getProjectConfig().getRuntime().getManifest();
    boolean _tripleNotEquals = (_manifest != null);
    if (_tripleNotEquals) {
      CollectionExtensions.<String>addAll(this.getProjectConfig().getRuntime().getManifest().getRequiredBundles(), 
        "org.eclipse.xtext.common.types", 
        "org.objectweb.asm;bundle-version=\"[8.0.1,8.1.0)\";resolution:=optional");
    }
    ManifestAccess _manifest_1 = this.getProjectConfig().getRuntimeTest().getManifest();
    boolean _tripleNotEquals_1 = (_manifest_1 != null);
    if (_tripleNotEquals_1) {
      this.getProjectConfig().getRuntimeTest().getManifest().getRequiredBundles().add(
        "org.objectweb.asm;bundle-version=\"[8.0.1,8.1.0)\";resolution:=optional");
    }
    ManifestAccess _manifest_2 = this.getProjectConfig().getEclipsePlugin().getManifest();
    boolean _tripleNotEquals_2 = (_manifest_2 != null);
    if (_tripleNotEquals_2) {
      this.getProjectConfig().getEclipsePlugin().getManifest().getRequiredBundles().add(
        "org.eclipse.xtext.common.types.ui");
    }
  }
  
  @Pure
  public BooleanGeneratorOption getOnlyEnabledIfGrammarIsUsed() {
    return this.onlyEnabledIfGrammarIsUsed;
  }
}
