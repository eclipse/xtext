/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.xbase;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.xtext.generator.AbstractGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.LanguageConfig2;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;

@SuppressWarnings("all")
public class XtypeGeneratorFragment2 extends AbstractGeneratorFragment2 {
  public static boolean inheritsXtype(final Grammar grammar) {
    return GrammarUtil.inherits(grammar, "org.eclipse.xtext.xbase.Xtype");
  }
  
  @Inject
  private IXtextProjectConfig projectConfig;
  
  @Override
  public void generate(final LanguageConfig2 language) {
    boolean _and = false;
    Grammar _grammar = language.getGrammar();
    boolean _inheritsXtype = XtypeGeneratorFragment2.inheritsXtype(_grammar);
    if (!_inheritsXtype) {
      _and = false;
    } else {
      ManifestAccess _eclipsePluginManifest = this.projectConfig.getEclipsePluginManifest();
      boolean _tripleNotEquals = (_eclipsePluginManifest != null);
      _and = _tripleNotEquals;
    }
    if (_and) {
      ManifestAccess _eclipsePluginManifest_1 = this.projectConfig.getEclipsePluginManifest();
      Set<String> _requiredBundles = _eclipsePluginManifest_1.getRequiredBundles();
      _requiredBundles.add("org.eclipse.xtext.xbase.ui");
    }
  }
}
