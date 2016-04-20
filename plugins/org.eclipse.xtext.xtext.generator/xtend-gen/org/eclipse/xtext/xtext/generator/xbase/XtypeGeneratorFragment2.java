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
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment;
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
    if ((this._xbaseUsageDetector.inheritsXtype(this.getLanguage().getGrammar()) && (this.getProjectConfig().getEclipsePlugin().getManifest() != null))) {
      IXtextProjectConfig _projectConfig = this.getProjectConfig();
      IBundleProjectConfig _eclipsePlugin = _projectConfig.getEclipsePlugin();
      ManifestAccess _manifest = _eclipsePlugin.getManifest();
      Set<String> _requiredBundles = _manifest.getRequiredBundles();
      _requiredBundles.add("org.eclipse.xtext.xbase.ui");
    }
  }
}
