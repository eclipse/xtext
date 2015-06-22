/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.sdomain.idea.facet;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.facet.Facet;
import com.intellij.facet.FacetConfiguration;
import com.intellij.facet.ui.FacetEditorContext;
import com.intellij.facet.ui.FacetEditorTab;
import com.intellij.facet.ui.FacetValidatorsManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.components.StorageScheme;
import com.intellij.openapi.util.InvalidDataException;
import com.intellij.openapi.util.WriteExternalException;
import java.util.Set;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.idea.sdomain.idea.facet.SDomainFacet;
import org.eclipse.xtext.idea.sdomain.idea.facet.SDomainFacetEditorTab;
import org.eclipse.xtext.idea.sdomain.idea.facet.SDomainGeneratorConfigurationState;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.jdom.Element;

/**
 * @author dhuebner - Initial contribution and API
 */
@State(name = "SDomainGenerator", storages = { @Storage(id = "ipr", file = "$PROJECT_FILE$"), @Storage(id = "prjDir", file = "${PROJECT_CONFIG_DIR$/SDomainGeneratorConfig.xml", scheme = StorageScheme.DIRECTORY_BASED) })
@SuppressWarnings("all")
public class SDomainFacetConfiguration implements FacetConfiguration, PersistentStateComponent<SDomainGeneratorConfigurationState> {
  @Inject
  private IOutputConfigurationProvider outputConfiguration;
  
  private SDomainGeneratorConfigurationState state;
  
  @Override
  public FacetEditorTab[] createEditorTabs(final FacetEditorContext editorContext, final FacetValidatorsManager validatorsManager) {
    Facet _facet = editorContext.getFacet();
    SDomainFacetEditorTab sdomainFacetEditorTab = new SDomainFacetEditorTab(((SDomainFacet) _facet), 
      "SDomain facet");
    return new FacetEditorTab[] { sdomainFacetEditorTab };
  }
  
  @Override
  public SDomainGeneratorConfigurationState getState() {
    boolean _equals = Objects.equal(this.state, null);
    if (_equals) {
      SDomainGeneratorConfigurationState _createDefaultSet = this.createDefaultSet();
      this.state = _createDefaultSet;
    }
    return this.state;
  }
  
  public SDomainGeneratorConfigurationState createDefaultSet() {
    final SDomainGeneratorConfigurationState state = new SDomainGeneratorConfigurationState();
    state.setActivated(true);
    boolean _notEquals = (!Objects.equal(this.outputConfiguration, null));
    if (_notEquals) {
      Set<OutputConfiguration> _outputConfigurations = this.outputConfiguration.getOutputConfigurations();
      final Function1<OutputConfiguration, Boolean> _function = new Function1<OutputConfiguration, Boolean>() {
        @Override
        public Boolean apply(final OutputConfiguration it) {
          String _name = it.getName();
          return Boolean.valueOf((_name == IFileSystemAccess.DEFAULT_OUTPUT));
        }
      };
      final OutputConfiguration defaults = IterableExtensions.<OutputConfiguration>findFirst(_outputConfigurations, _function);
      boolean _isOverrideExistingResources = defaults.isOverrideExistingResources();
      state.setOverwriteExisting(_isOverrideExistingResources);
      boolean _isCreateOutputDirectory = defaults.isCreateOutputDirectory();
      state.setCreateDirectory(_isCreateOutputDirectory);
      boolean _isCanClearOutputDirectory = defaults.isCanClearOutputDirectory();
      state.setDeleteGenerated(_isCanClearOutputDirectory);
      String _outputDirectory = defaults.getOutputDirectory();
      state.setDirectory(_outputDirectory);
    }
    return state;
  }
  
  @Override
  public void loadState(final SDomainGeneratorConfigurationState state) {
    this.state = state;
  }
  
  @Override
  public void readExternal(final Element element) throws InvalidDataException {
  }
  
  @Override
  public void writeExternal(final Element element) throws WriteExternalException {
  }
}
