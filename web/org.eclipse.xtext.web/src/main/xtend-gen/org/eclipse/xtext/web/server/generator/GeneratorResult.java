/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.generator;

import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend.lib.annotations.ToString;
import org.eclipse.xtext.web.server.IUnwrappableServiceResult;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Result object returned by the generator service. This object is usually not sent in
 * JSON format, but the content itself is returned to the client.
 */
@Data
@ToString(skipNulls = true)
@SuppressWarnings("all")
public class GeneratorResult implements IUnwrappableServiceResult {
  private final String name;
  
  private final String contentType;
  
  private final String content;
  
  public GeneratorResult(final String name, final String contentType, final String content) {
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
    GeneratorResult other = (GeneratorResult) obj;
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
    b.skipNulls();
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
