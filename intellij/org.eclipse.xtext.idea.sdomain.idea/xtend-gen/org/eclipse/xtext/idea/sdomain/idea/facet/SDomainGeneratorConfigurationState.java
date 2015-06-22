package org.eclipse.xtext.idea.sdomain.idea.facet;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class SDomainGeneratorConfigurationState {
  private boolean activated;
  
  private boolean createDirectory;
  
  private boolean deleteGenerated;
  
  private boolean overwriteExisting;
  
  private String directory;
  
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
  public String getDirectory() {
    return this.directory;
  }
  
  public void setDirectory(final String directory) {
    this.directory = directory;
  }
}
