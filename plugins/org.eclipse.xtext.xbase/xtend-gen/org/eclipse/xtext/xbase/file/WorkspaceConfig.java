package org.eclipse.xtext.xbase.file;

import java.util.Map;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.file.ProjectConfig;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class WorkspaceConfig {
  private final String _absoluteFileSystemPath;
  
  public String getAbsoluteFileSystemPath() {
    return this._absoluteFileSystemPath;
  }
  
  private final Map<String, ProjectConfig> _projects = CollectionLiterals.<String, ProjectConfig>newLinkedHashMap();
  
  public Map<String, ProjectConfig> getProjects() {
    return this._projects;
  }
  
  public ProjectConfig addProjectConfig(final ProjectConfig config) {
    Map<String, ProjectConfig> _projects = this.getProjects();
    String _name = config.getName();
    return _projects.put(_name, config);
  }
  
  public WorkspaceConfig(final String absoluteFileSystemPath) {
    super();
    this._absoluteFileSystemPath = absoluteFileSystemPath;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this._absoluteFileSystemPath== null) ? 0 : this._absoluteFileSystemPath.hashCode());
    result = prime * result + ((this._projects== null) ? 0 : this._projects.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    WorkspaceConfig other = (WorkspaceConfig) obj;
    if (this._absoluteFileSystemPath == null) {
      if (other._absoluteFileSystemPath != null)
        return false;
    } else if (!this._absoluteFileSystemPath.equals(other._absoluteFileSystemPath))
      return false;
    if (this._projects == null) {
      if (other._projects != null)
        return false;
    } else if (!this._projects.equals(other._projects))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
