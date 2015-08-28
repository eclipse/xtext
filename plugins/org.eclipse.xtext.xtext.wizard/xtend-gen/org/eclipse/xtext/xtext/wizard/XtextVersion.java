package org.eclipse.xtext.xtext.wizard;

import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;

@Data
@SuppressWarnings("all")
public class XtextVersion {
  private final String version;
  
  public boolean isSnapshot() {
    return this.version.endsWith("-SNAPSHOT");
  }
  
  @Override
  public String toString() {
    return this.version;
  }
  
  public XtextVersion(final String version) {
    super();
    this.version = version;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.version== null) ? 0 : this.version.hashCode());
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
    XtextVersion other = (XtextVersion) obj;
    if (this.version == null) {
      if (other.version != null)
        return false;
    } else if (!this.version.equals(other.version))
      return false;
    return true;
  }
  
  @Pure
  public String getVersion() {
    return this.version;
  }
}
