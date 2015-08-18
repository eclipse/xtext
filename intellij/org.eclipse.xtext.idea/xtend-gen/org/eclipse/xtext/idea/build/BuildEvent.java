/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.build;

import com.intellij.openapi.vfs.VirtualFile;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.idea.resource.VirtualFileURIUtil;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @author koehnlein - Initial contribution and API
 */
@Data
@SuppressWarnings("all")
public class BuildEvent {
  public enum Type {
    DELETED,
    
    MODIFIED,
    
    ADDED;
  }
  
  private final BuildEvent.Type type;
  
  private final Map<URI, VirtualFile> filesByURI;
  
  public BuildEvent(final BuildEvent.Type type, final VirtualFile... files) {
    this.type = type;
    LinkedHashMap<URI, VirtualFile> _newLinkedHashMap = CollectionLiterals.<URI, VirtualFile>newLinkedHashMap();
    this.filesByURI = _newLinkedHashMap;
    for (final VirtualFile file : files) {
      URI _uRI = VirtualFileURIUtil.getURI(file);
      this.filesByURI.put(_uRI, file);
    }
  }
  
  public Set<URI> getURIs() {
    return this.filesByURI.keySet();
  }
  
  public VirtualFile getFile(final URI uri) {
    return this.filesByURI.get(uri);
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.type== null) ? 0 : this.type.hashCode());
    result = prime * result + ((this.filesByURI== null) ? 0 : this.filesByURI.hashCode());
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
    BuildEvent other = (BuildEvent) obj;
    if (this.type == null) {
      if (other.type != null)
        return false;
    } else if (!this.type.equals(other.type))
      return false;
    if (this.filesByURI == null) {
      if (other.filesByURI != null)
        return false;
    } else if (!this.filesByURI.equals(other.filesByURI))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("type", this.type);
    b.add("filesByURI", this.filesByURI);
    return b.toString();
  }
  
  @Pure
  public BuildEvent.Type getType() {
    return this.type;
  }
  
  @Pure
  public Map<URI, VirtualFile> getFilesByURI() {
    return this.filesByURI;
  }
}
