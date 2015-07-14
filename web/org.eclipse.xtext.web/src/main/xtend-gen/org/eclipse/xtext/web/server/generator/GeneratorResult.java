/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.generator;

import java.util.List;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend.lib.annotations.ToString;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Result object returned by the generator service. If the result contains exactly one entry,
 * the content of that entry should be sent as response to the client instead of wrapping
 * it in a result object. This allows to conveniently view generator results by pointing a
 * web browser to the generator service URL.
 */
@Data
@ToString(skipNulls = true)
@SuppressWarnings("all")
public class GeneratorResult implements IServiceResult {
  @Data
  public static class GeneratedDocument {
    private final String name;
    
    private final String contentType;
    
    private final String content;
    
    public GeneratedDocument(final String name, final String contentType, final String content) {
      super();
      this.name = name;
      this.contentType = contentType;
      this.content = content;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.name== null) ? 0 : this.name.hashCode());
      result = prime * result + ((this.contentType== null) ? 0 : this.contentType.hashCode());
      result = prime * result + ((this.content== null) ? 0 : this.content.hashCode());
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
      GeneratorResult.GeneratedDocument other = (GeneratorResult.GeneratedDocument) obj;
      if (this.name == null) {
        if (other.name != null)
          return false;
      } else if (!this.name.equals(other.name))
        return false;
      if (this.contentType == null) {
        if (other.contentType != null)
          return false;
      } else if (!this.contentType.equals(other.contentType))
        return false;
      if (this.content == null) {
        if (other.content != null)
          return false;
      } else if (!this.content.equals(other.content))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("name", this.name);
      b.add("contentType", this.contentType);
      b.add("content", this.content);
      return b.toString();
    }
    
    @Pure
    public String getName() {
      return this.name;
    }
    
    @Pure
    public String getContentType() {
      return this.contentType;
    }
    
    @Pure
    public String getContent() {
      return this.content;
    }
  }
  
  private final List<GeneratorResult.GeneratedDocument> documents = CollectionLiterals.<GeneratorResult.GeneratedDocument>newArrayList();
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.documents== null) ? 0 : this.documents.hashCode());
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
    GeneratorResult other = (GeneratorResult) obj;
    if (this.documents == null) {
      if (other.documents != null)
        return false;
    } else if (!this.documents.equals(other.documents))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.skipNulls();
    b.add("documents", this.documents);
    return b.toString();
  }
  
  @Pure
  public List<GeneratorResult.GeneratedDocument> getDocuments() {
    return this.documents;
  }
}
