/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server.coloring;

import java.util.List;
import org.eclipse.lsp4j.jsonrpc.validation.NonNull;
import org.eclipse.xtext.ide.server.coloring.ColoringInformation;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Representation of a computed mapping from ranges to the appropriate
 * highlighting style.
 * 
 * @author akos.kitta - Initial contribution and API
 */
@SuppressWarnings("all")
public class ColoringParams {
  /**
   * The URI for which coloring information is reported.
   */
  @NonNull
  private String uri;
  
  /**
   * A list of coloring information instances.
   */
  private List<? extends ColoringInformation> infos;
  
  /**
   * The URI for which coloring information is reported.
   */
  @Pure
  public String getUri() {
    return this.uri;
  }
  
  /**
   * The URI for which coloring information is reported.
   */
  public void setUri(final String uri) {
    this.uri = uri;
  }
  
  /**
   * A list of coloring information instances.
   */
  @Pure
  public List<? extends ColoringInformation> getInfos() {
    return this.infos;
  }
  
  /**
   * A list of coloring information instances.
   */
  public void setInfos(final List<? extends ColoringInformation> infos) {
    this.infos = infos;
  }
  
  public ColoringParams() {
    
  }
  
  public ColoringParams(final String uri, final List<? extends ColoringInformation> infos) {
    this.uri = uri;
    this.infos = infos;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("uri", this.uri);
    b.add("infos", this.infos);
    return b.toString();
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
    if (!super.equals(obj))
      return false;
    ColoringParams other = (ColoringParams) obj;
    if (this.uri == null) {
      if (other.uri != null)
        return false;
    } else if (!this.uri.equals(other.uri))
      return false;
    if (this.infos == null) {
      if (other.infos != null)
        return false;
    } else if (!this.infos.equals(other.infos))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.uri== null) ? 0 : this.uri.hashCode());
    result = prime * result + ((this.infos== null) ? 0 : this.infos.hashCode());
    return result;
  }
}
