/**
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.config;

import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author dhuebner - Initial contribution and API
 */
@Data
@SuppressWarnings("all")
public class MavenArtifact {
  private final String groupId;
  
  private final String artifactId;
  
  private final String version;
  
  public String getKey() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(this.groupId, "");
    _builder.append(":");
    _builder.append(this.artifactId, "");
    _builder.append(":");
    _builder.append(this.version, "");
    return _builder.toString();
  }
  
  @Override
  public String toString() {
    return this.getKey();
  }
  
  public MavenArtifact(final String groupId, final String artifactId, final String version) {
    super();
    this.groupId = groupId;
    this.artifactId = artifactId;
    this.version = version;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.groupId== null) ? 0 : this.groupId.hashCode());
    result = prime * result + ((this.artifactId== null) ? 0 : this.artifactId.hashCode());
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
    MavenArtifact other = (MavenArtifact) obj;
    if (this.groupId == null) {
      if (other.groupId != null)
        return false;
    } else if (!this.groupId.equals(other.groupId))
      return false;
    if (this.artifactId == null) {
      if (other.artifactId != null)
        return false;
    } else if (!this.artifactId.equals(other.artifactId))
      return false;
    if (this.version == null) {
      if (other.version != null)
        return false;
    } else if (!this.version.equals(other.version))
      return false;
    return true;
  }
  
  @Pure
  public String getGroupId() {
    return this.groupId;
  }
  
  @Pure
  public String getArtifactId() {
    return this.artifactId;
  }
  
  @Pure
  public String getVersion() {
    return this.version;
  }
}
