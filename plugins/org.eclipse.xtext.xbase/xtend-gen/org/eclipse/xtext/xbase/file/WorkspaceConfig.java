package org.eclipse.xtext.xbase.file;

import java.util.Map;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.file.ProjectConfig;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class WorkspaceConfig {
  private final String absoluteFileSystemPath;
  
  private final Map<String, ProjectConfig> projects = CollectionLiterals.<String, ProjectConfig>newLinkedHashMap();
  
  public ProjectConfig addProjectConfig(final ProjectConfig config) {
    String _name = config.getName();
    return this.projects.put(_name, config);
  }
  
  public WorkspaceConfig(final String absoluteFileSystemPath) {
    super();
    this.absoluteFileSystemPath = absoluteFileSystemPath;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.absoluteFileSystemPath== null) ? 0 : this.absoluteFileSystemPath.hashCode());
    result = prime * result + ((this.projects== null) ? 0 : this.projects.hashCode());
    return result;
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    WorkspaceConfig other = (WorkspaceConfig) obj;
    if (this.absoluteFileSystemPath == null) {
      if (other.absoluteFileSystemPath != null)
        return false;
    } else if (!this.absoluteFileSystemPath.equals(other.absoluteFileSystemPath))
      return false;
    if (this.projects == null) {
      if (other.projects != null)
        return false;
    } else if (!this.projects.equals(other.projects))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("absoluteFileSystemPath", this.absoluteFileSystemPath);
    b.add("projects", this.projects);
    return b.toString();
  }
  
  @Pure
  public String getAbsoluteFileSystemPath() {
    return this.absoluteFileSystemPath;
  }
  
  @Pure
  public Map<String, ProjectConfig> getProjects() {
    return this.projects;
  }
}
