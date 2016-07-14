/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.findUsages;

import com.intellij.facet.Facet;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;
import org.eclipse.xtend.idea.findUsages.XtendFindUsagesTest;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.FacetProvider;
import org.eclipse.xtext.idea.facet.GeneratorConfigurationState;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendFindUsagesTest2 extends XtendFindUsagesTest {
  @Override
  protected void configureModule(final Module module, final ModifiableRootModel model, final ContentEntry contentEntry) {
    super.configureModule(module, model, contentEntry);
    final FacetProvider facetProvider = XtendLanguage.INSTANCE.<FacetProvider>getInstance(FacetProvider.class);
    final Facet<? extends AbstractFacetConfiguration> facet = facetProvider.getFacet(module);
    VirtualFile[] _contentRoots = model.getContentRoots();
    final VirtualFile base = IterableExtensions.<VirtualFile>head(((Iterable<VirtualFile>)Conversions.doWrapArray(_contentRoots)));
    AbstractFacetConfiguration _configuration = facet.getConfiguration();
    GeneratorConfigurationState _state = _configuration.getState();
    String _outputDirectory = _state.getOutputDirectory();
    final VirtualFile file = VfsUtil.findRelativeFile(_outputDirectory, base);
    AbstractFacetConfiguration _configuration_1 = facet.getConfiguration();
    GeneratorConfigurationState _state_1 = _configuration_1.getState();
    String _path = file.getPath();
    _state_1.setOutputDirectory(_path);
  }
}
