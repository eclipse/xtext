/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.contentassist;

import java.util.ArrayList;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.EqualsHashCode;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend.lib.annotations.ToString;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Accessors
@ToString(skipNulls = true)
@SuppressWarnings("all")
public class ContentAssistResult implements IServiceResult {
  @Accessors
  @FinalFieldsConstructor
  @ToString(skipNulls = true)
  @EqualsHashCode
  public static class Entry {
    private final String prefix;
    
    private String proposal;
    
    private String name;
    
    private String description;
    
    /**
     * Available styles: 'default', 'emphasis', 'noemphasis', 'hr'
     */
    private String style;
    
    private int escapePosition;
    
    private final ArrayList<ReplaceRegion> textReplacements = new ArrayList<ReplaceRegion>();
    
    private final ArrayList<TextRegion> editPositions = new ArrayList<TextRegion>();
    
    public Entry(final String prefix) {
      super();
      this.prefix = prefix;
    }
    
    @Pure
    public String getPrefix() {
      return this.prefix;
    }
    
    @Pure
    public String getProposal() {
      return this.proposal;
    }
    
    public void setProposal(final String proposal) {
      this.proposal = proposal;
    }
    
    @Pure
    public String getName() {
      return this.name;
    }
    
    public void setName(final String name) {
      this.name = name;
    }
    
    @Pure
    public String getDescription() {
      return this.description;
    }
    
    public void setDescription(final String description) {
      this.description = description;
    }
    
    @Pure
    public String getStyle() {
      return this.style;
    }
    
    public void setStyle(final String style) {
      this.style = style;
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
      b.add("name", this.name);
      b.add("description", this.description);
      b.add("style", this.style);
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
      ContentAssistResult.Entry other = (ContentAssistResult.Entry) obj;
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
      if (this.name == null) {
        if (other.name != null)
          return false;
      } else if (!this.name.equals(other.name))
        return false;
      if (this.description == null) {
        if (other.description != null)
          return false;
      } else if (!this.description.equals(other.description))
        return false;
      if (this.style == null) {
        if (other.style != null)
          return false;
      } else if (!this.style.equals(other.style))
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
      result = prime * result + ((this.name== null) ? 0 : this.name.hashCode());
      result = prime * result + ((this.description== null) ? 0 : this.description.hashCode());
      result = prime * result + ((this.style== null) ? 0 : this.style.hashCode());
      result = prime * result + this.escapePosition;
      result = prime * result + ((this.textReplacements== null) ? 0 : this.textReplacements.hashCode());
      result = prime * result + ((this.editPositions== null) ? 0 : this.editPositions.hashCode());
      return result;
    }
  }
  
  private String stateId;
  
  private final ArrayList<ContentAssistResult.Entry> entries = new ArrayList<ContentAssistResult.Entry>();
  
  @Pure
  public String getStateId() {
    return this.stateId;
  }
  
  public void setStateId(final String stateId) {
    this.stateId = stateId;
  }
  
  @Pure
  public ArrayList<ContentAssistResult.Entry> getEntries() {
    return this.entries;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.skipNulls();
    b.add("stateId", this.stateId);
    b.add("entries", this.entries);
    return b.toString();
  }
}
