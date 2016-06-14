/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.formatting;

import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend.lib.annotations.ToString;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Result object returned by the formatting service.
 */
@Data
@ToString(skipNulls = true)
@SuppressWarnings("all")
public class FormattingResult implements IServiceResult {
  private final String stateId;
  
  private final String formattedText;
  
  private final TextRegion replaceRegion;
  
  public FormattingResult(final String stateId, final String formattedText, final TextRegion replaceRegion) {
    super();
    this.stateId = stateId;
    this.formattedText = formattedText;
    this.replaceRegion = replaceRegion;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.stateId== null) ? 0 : this.stateId.hashCode());
    result = prime * result + ((this.formattedText== null) ? 0 : this.formattedText.hashCode());
    result = prime * result + ((this.replaceRegion== null) ? 0 : this.replaceRegion.hashCode());
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
    FormattingResult other = (FormattingResult) obj;
    if (this.stateId == null) {
      if (other.stateId != null)
        return false;
    } else if (!this.stateId.equals(other.stateId))
      return false;
    if (this.formattedText == null) {
      if (other.formattedText != null)
        return false;
    } else if (!this.formattedText.equals(other.formattedText))
      return false;
    if (this.replaceRegion == null) {
      if (other.replaceRegion != null)
        return false;
    } else if (!this.replaceRegion.equals(other.replaceRegion))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.skipNulls();
    b.add("stateId", this.stateId);
    b.add("formattedText", this.formattedText);
    b.add("replaceRegion", this.replaceRegion);
    return b.toString();
  }
  
  @Pure
  public String getStateId() {
    return this.stateId;
  }
  
  @Pure
  public String getFormattedText() {
    return this.formattedText;
  }
  
  @Pure
  public TextRegion getReplaceRegion() {
    return this.replaceRegion;
  }
}
