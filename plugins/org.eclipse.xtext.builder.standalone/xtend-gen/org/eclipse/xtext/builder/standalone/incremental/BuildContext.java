/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone.incremental;

import java.util.Map;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.builder.standalone.LanguageAccess;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.clustering.IResourceClusteringPolicy;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9
 */
@Data
@SuppressWarnings("all")
public class BuildContext {
  private final Map<String, LanguageAccess> languages;
  
  private final boolean needsJava;
  
  private final XtextResourceSet resourceSet;
  
  private final IResourceClusteringPolicy clusteringPolicy;
  
  public BuildContext(final Map<String, LanguageAccess> languages, final boolean needsJava, final XtextResourceSet resourceSet, final IResourceClusteringPolicy clusteringPolicy) {
    super();
    this.languages = languages;
    this.needsJava = needsJava;
    this.resourceSet = resourceSet;
    this.clusteringPolicy = clusteringPolicy;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.languages== null) ? 0 : this.languages.hashCode());
    result = prime * result + (this.needsJava ? 1231 : 1237);
    result = prime * result + ((this.resourceSet== null) ? 0 : this.resourceSet.hashCode());
    result = prime * result + ((this.clusteringPolicy== null) ? 0 : this.clusteringPolicy.hashCode());
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
    BuildContext other = (BuildContext) obj;
    if (this.languages == null) {
      if (other.languages != null)
        return false;
    } else if (!this.languages.equals(other.languages))
      return false;
    if (other.needsJava != this.needsJava)
      return false;
    if (this.resourceSet == null) {
      if (other.resourceSet != null)
        return false;
    } else if (!this.resourceSet.equals(other.resourceSet))
      return false;
    if (this.clusteringPolicy == null) {
      if (other.clusteringPolicy != null)
        return false;
    } else if (!this.clusteringPolicy.equals(other.clusteringPolicy))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("languages", this.languages);
    b.add("needsJava", this.needsJava);
    b.add("resourceSet", this.resourceSet);
    b.add("clusteringPolicy", this.clusteringPolicy);
    return b.toString();
  }
  
  @Pure
  public Map<String, LanguageAccess> getLanguages() {
    return this.languages;
  }
  
  @Pure
  public boolean isNeedsJava() {
    return this.needsJava;
  }
  
  @Pure
  public XtextResourceSet getResourceSet() {
    return this.resourceSet;
  }
  
  @Pure
  public IResourceClusteringPolicy getClusteringPolicy() {
    return this.clusteringPolicy;
  }
}
