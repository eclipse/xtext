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
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.IXtextGeneratorLanguage;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.project.IBundleProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.xbase.XbaseUsageDetector;

@SuppressWarnings("all")
public class XtypeGeneratorFragment2 extends AbstractXtextGeneratorFragment {
  @Inject
  @Extension
  private XbaseUsageDetector _xbaseUsageDetector;
  
  @Override
  public void generate() {
    boolean _and = false;
    IXtextGeneratorLanguage _language = this.getLanguage();
    Grammar _grammar = _language.getGrammar();
    boolean _inheritsXtype = this._xbaseUsageDetector.inheritsXtype(_grammar);
    if (!_inheritsXtype) {
      _and = false;
    } else {
      IXtextProjectConfig _projectConfig = this.getProjectConfig();
      IBundleProjectConfig _eclipsePlugin = _projectConfig.getEclipsePlugin();
      ManifestAccess _manifest = _eclipsePlugin.getManifest();
      boolean _tripleNotEquals = (_manifest != null);
      _and = _tripleNotEquals;
    }
    if (_and) {
      IXtextProjectConfig _projectConfig_1 = this.getProjectConfig();
      IBundleProjectConfig _eclipsePlugin_1 = _projectConfig_1.getEclipsePlugin();
      ManifestAccess _manifest_1 = _eclipsePlugin_1.getManifest();
      Set<String> _requiredBundles = _manifest_1.getRequiredBundles();
      _requiredBundles.add("org.eclipse.xtext.xbase.ui");
    }
  }
}
