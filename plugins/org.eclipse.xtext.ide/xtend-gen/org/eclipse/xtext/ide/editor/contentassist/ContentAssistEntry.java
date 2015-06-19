/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.editor.contentassist;

import java.util.ArrayList;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.EqualsHashCode;
import org.eclipse.xtend.lib.annotations.ToString;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Accessors
@ToString(skipNulls = true)
@EqualsHashCode
@SuppressWarnings("all")
public class ContentAssistEntry {
  private String prefix;
  
  private String proposal;
  
  private String label;
  
  private String description;
  
  private int escapePosition;
  
  private final ArrayList<ReplaceRegion> textReplacements = new ArrayList<ReplaceRegion>();
  
  private final ArrayList<TextRegion> editPositions = new ArrayList<TextRegion>();
  
  @Pure
  public String getPrefix() {
    return this.prefix;
  }
  
  public void setPrefix(final String prefix) {
    this.prefix = prefix;
  }
  
  @Pure
  public String getProposal() {
    return this.proposal;
  }
  
  public void setProposal(final String proposal) {
    this.proposal = proposal;
  }
  
  @Pure
  public String getLabel() {
    return this.label;
  }
  
  public void setLabel(final String label) {
    this.label = label;
  }
  
  @Pure
  public String getDescription() {
    return this.description;
  }
  
  public void setDescription(final String description) {
    this.description = description;
  }
  
  @Pure
  public int getEscapePosition() {
    return this.escapePosition;
  }
  
  public void setEscapePosition(final int escapePosition) {
    this.escapePosition = escapePosition;
  }
  
  @Pure
  public ArrayList<ReplaceRegion> getTextReplacements() {
    return this.textReplacements;
  }
  
  @Pure
  public ArrayList<TextRegion> getEditPositions() {
    return this.editPositions;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.skipNulls();
    b.add("prefix", this.prefix);
    b.add("proposal", this.proposal);
    b.add("label", this.label);
    b.add("description", this.description);
    b.add("escapePosition", this.escapePosition);
    b.add("textReplacements", this.textReplacements);
    b.add("editPositions", this.editPositions);
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
    ContentAssistEntry other = (ContentAssistEntry) obj;
    if (this.prefix == null) {
      if (other.prefix != null)
        return false;
    } else if (!this.prefix.equals(other.prefix))
      return false;
    if (this.proposal == null) {
      if (other.proposal != null)
        return false;
    } else if (!this.proposal.equals(other.proposal))
      return false;
    if (this.label == null) {
      if (other.label != null)
        return false;
    } else if (!this.label.equals(other.label))
      return false;
    if (this.description == null) {
      if (other.description != null)
        return false;
    } else if (!this.description.equals(other.description))
      return false;
    if (other.escapePosition != this.escapePosition)
      return false;
    if (this.textReplacements == null) {
      if (other.textReplacements != null)
        return false;
    } else if (!this.textReplacements.equals(other.textReplacements))
      return false;
    if (this.editPositions == null) {
      if (other.editPositions != null)
        return false;
    } else if (!this.editPositions.equals(other.editPositions))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.prefix== null) ? 0 : this.prefix.hashCode());
    result = prime * result + ((this.proposal== null) ? 0 : this.proposal.hashCode());
    result = prime * result + ((this.label== null) ? 0 : this.label.hashCode());
    result = prime * result + ((this.description== null) ? 0 : this.description.hashCode());
    result = prime * result + this.escapePosition;
    result = prime * result + ((this.textReplacements== null) ? 0 : this.textReplacements.hashCode());
    result = prime * result + ((this.editPositions== null) ? 0 : this.editPositions.hashCode());
    return result;
  }
}
