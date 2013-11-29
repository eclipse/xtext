package org.eclipse.xtext.m2e;

import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class OutputConfiguration {
  private String _name = IFileSystemAccess.DEFAULT_OUTPUT;
  
  public String getName() {
    return this._name;
  }
  
  public void setName(final String name) {
    this._name = name;
  }
  
  private String _description = "";
  
  public String getDescription() {
    return this._description;
  }
  
  public void setDescription(final String description) {
    this._description = description;
  }
  
  private String _outputDirectory;
  
  public String getOutputDirectory() {
    return this._outputDirectory;
  }
  
  public void setOutputDirectory(final String outputDirectory) {
    this._outputDirectory = outputDirectory;
  }
  
  private boolean _createOutputDirectory = true;
  
  public boolean isCreateOutputDirectory() {
    return this._createOutputDirectory;
  }
  
  public void setCreateOutputDirectory(final boolean createOutputDirectory) {
    this._createOutputDirectory = createOutputDirectory;
  }
  
  private boolean _overrideExistingResources = true;
  
  public boolean isOverrideExistingResources() {
    return this._overrideExistingResources;
  }
  
  public void setOverrideExistingResources(final boolean overrideExistingResources) {
    this._overrideExistingResources = overrideExistingResources;
  }
  
  private boolean _installDslAsPrimarySource = false;
  
  public boolean isInstallDslAsPrimarySource() {
    return this._installDslAsPrimarySource;
  }
  
  public void setInstallDslAsPrimarySource(final boolean installDslAsPrimarySource) {
    this._installDslAsPrimarySource = installDslAsPrimarySource;
  }
  
  private boolean _hideSyntheticLocalVariables = true;
  
  public boolean isHideSyntheticLocalVariables() {
    return this._hideSyntheticLocalVariables;
  }
  
  public void setHideSyntheticLocalVariables(final boolean hideSyntheticLocalVariables) {
    this._hideSyntheticLocalVariables = hideSyntheticLocalVariables;
  }
  
  private boolean _canClearOutputDirectory = false;
  
  public boolean isCanClearOutputDirectory() {
    return this._canClearOutputDirectory;
  }
  
  public void setCanClearOutputDirectory(final boolean canClearOutputDirectory) {
    this._canClearOutputDirectory = canClearOutputDirectory;
  }
  
  private boolean _cleanUpDerivedResources = true;
  
  public boolean isCleanUpDerivedResources() {
    return this._cleanUpDerivedResources;
  }
  
  public void setCleanUpDerivedResources(final boolean cleanUpDerivedResources) {
    this._cleanUpDerivedResources = cleanUpDerivedResources;
  }
  
  public org.eclipse.xtext.generator.OutputConfiguration toGeneratorConfiguration() {
    String _name = this.getName();
    org.eclipse.xtext.generator.OutputConfiguration _outputConfiguration = new org.eclipse.xtext.generator.OutputConfiguration(_name);
    final Procedure1<org.eclipse.xtext.generator.OutputConfiguration> _function = new Procedure1<org.eclipse.xtext.generator.OutputConfiguration>() {
      public void apply(final org.eclipse.xtext.generator.OutputConfiguration it) {
        String _description = OutputConfiguration.this.getDescription();
        it.setDescription(_description);
        String _outputDirectory = OutputConfiguration.this.getOutputDirectory();
        it.setOutputDirectory(_outputDirectory);
        boolean _isCreateOutputDirectory = OutputConfiguration.this.isCreateOutputDirectory();
        it.setCreateOutputDirectory(_isCreateOutputDirectory);
        boolean _isOverrideExistingResources = OutputConfiguration.this.isOverrideExistingResources();
        it.setOverrideExistingResources(_isOverrideExistingResources);
        boolean _isInstallDslAsPrimarySource = OutputConfiguration.this.isInstallDslAsPrimarySource();
        it.setInstallDslAsPrimarySource(_isInstallDslAsPrimarySource);
        boolean _isInstallDslAsPrimarySource_1 = OutputConfiguration.this.isInstallDslAsPrimarySource();
        it.setHideSyntheticLocalVariables(_isInstallDslAsPrimarySource_1);
        boolean _isCanClearOutputDirectory = OutputConfiguration.this.isCanClearOutputDirectory();
        it.setCanClearOutputDirectory(_isCanClearOutputDirectory);
        boolean _isCleanUpDerivedResources = OutputConfiguration.this.isCleanUpDerivedResources();
        it.setCleanUpDerivedResources(_isCleanUpDerivedResources);
      }
    };
    org.eclipse.xtext.generator.OutputConfiguration _doubleArrow = ObjectExtensions.<org.eclipse.xtext.generator.OutputConfiguration>operator_doubleArrow(_outputConfiguration, _function);
    return _doubleArrow;
  }
}
