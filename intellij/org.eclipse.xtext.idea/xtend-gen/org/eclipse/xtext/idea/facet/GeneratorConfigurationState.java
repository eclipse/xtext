package org.eclipse.xtext.idea.facet;

import com.google.common.base.Objects;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class GeneratorConfigurationState {
  public GeneratorConfigurationState() {
  }
  
  public GeneratorConfigurationState(final OutputConfiguration defOutput) {
    this.activated = true;
    boolean _notEquals = (!Objects.equal(defOutput, null));
    if (_notEquals) {
      String outputDir = defOutput.getOutputDirectory();
      boolean _equals = Objects.equal("./src-gen", outputDir);
      if (_equals) {
        outputDir = "src-gen";
      }
      this.outputDirectory = outputDir;
      this.testOutputDirectory = outputDir;
      boolean _isCreateOutputDirectory = defOutput.isCreateOutputDirectory();
      this.createDirectory = _isCreateOutputDirectory;
      boolean _isCanClearOutputDirectory = defOutput.isCanClearOutputDirectory();
      this.deleteGenerated = _isCanClearOutputDirectory;
      boolean _isOverrideExistingResources = defOutput.isOverrideExistingResources();
      this.overwriteExisting = _isOverrideExistingResources;
    }
  }
  
  private boolean activated;
  
  private boolean createDirectory;
  
  private boolean deleteGenerated;
  
  private boolean overwriteExisting;
  
  private String outputDirectory;
  
  private String testOutputDirectory;
  
  @Pure
  public boolean isActivated() {
    return this.activated;
  }
  
  public void setActivated(final boolean activated) {
    this.activated = activated;
  }
  
  @Pure
  public boolean isCreateDirectory() {
    return this.createDirectory;
  }
  
  public void setCreateDirectory(final boolean createDirectory) {
    this.createDirectory = createDirectory;
  }
  
  @Pure
  public boolean isDeleteGenerated() {
    return this.deleteGenerated;
  }
  
  public void setDeleteGenerated(final boolean deleteGenerated) {
    this.deleteGenerated = deleteGenerated;
  }
  
  @Pure
  public boolean isOverwriteExisting() {
    return this.overwriteExisting;
  }
  
  public void setOverwriteExisting(final boolean overwriteExisting) {
    this.overwriteExisting = overwriteExisting;
  }
  
  @Pure
  public String getOutputDirectory() {
    return this.outputDirectory;
  }
  
  public void setOutputDirectory(final String outputDirectory) {
    this.outputDirectory = outputDirectory;
  }
  
  @Pure
  public String getTestOutputDirectory() {
    return this.testOutputDirectory;
  }
  
  public void setTestOutputDirectory(final String testOutputDirectory) {
    this.testOutputDirectory = testOutputDirectory;
  }
}
