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
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Accessors
@SuppressWarnings("all")
public class ContentAssistResult implements IServiceResult {
  @Data
  public static class Entry {
    private final String proposal;
    
    private final String name;
    
    private final String description;
    
    /**
     * Available styles: 'default', 'emphasis', 'noemphasis', 'hr'
     */
    private final String style;
    
    private final ArrayList<ContentAssistResult.TextReplacement> textReplacements = new ArrayList<ContentAssistResult.TextReplacement>();
    
    private final ArrayList<ContentAssistResult.EditPosition> editPositions = new ArrayList<ContentAssistResult.EditPosition>();
    
    public Entry(final String proposal, final String name, final String description, final String style) {
      super();
      this.proposal = proposal;
      this.name = name;
      this.description = description;
      this.style = style;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.proposal== null) ? 0 : this.proposal.hashCode());
      result = prime * result + ((this.name== null) ? 0 : this.name.hashCode());
      result = prime * result + ((this.description== null) ? 0 : this.description.hashCode());
      result = prime * result + ((this.style== null) ? 0 : this.style.hashCode());
      result = prime * result + ((this.textReplacements== null) ? 0 : this.textReplacements.hashCode());
      result = prime * result + ((this.editPositions== null) ? 0 : this.editPositions.hashCode());
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
      ContentAssistResult.Entry other = (ContentAssistResult.Entry) obj;
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
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("proposal", this.proposal);
      b.add("name", this.name);
      b.add("description", this.description);
      b.add("style", this.style);
      b.add("textReplacements", this.textReplacements);
      b.add("editPositions", this.editPositions);
      return b.toString();
    }
    
    @Pure
    public String getProposal() {
      return this.proposal;
    }
    
    @Pure
    public String getName() {
      return this.name;
    }
    
    @Pure
    public String getDescription() {
      return this.description;
    }
    
    @Pure
    public String getStyle() {
      return this.style;
    }
    
    @Pure
    public ArrayList<ContentAssistResult.TextReplacement> getTextReplacements() {
      return this.textReplacements;
    }
    
    @Pure
    public ArrayList<ContentAssistResult.EditPosition> getEditPositions() {
      return this.editPositions;
    }
  }
  
  @Data
  public static class TextReplacement {
    private final String text;
    
    private final int offset;
    
    private final int length;
    
    public TextReplacement(final String text, final int offset, final int length) {
      super();
      this.text = text;
      this.offset = offset;
      this.length = length;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.text== null) ? 0 : this.text.hashCode());
      result = prime * result + this.offset;
      result = prime * result + this.length;
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
      ContentAssistResult.TextReplacement other = (ContentAssistResult.TextReplacement) obj;
      if (this.text == null) {
        if (other.text != null)
          return false;
      } else if (!this.text.equals(other.text))
        return false;
      if (other.offset != this.offset)
        return false;
      if (other.length != this.length)
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("text", this.text);
      b.add("offset", this.offset);
      b.add("length", this.length);
      return b.toString();
    }
    
    @Pure
    public String getText() {
      return this.text;
    }
    
    @Pure
    public int getOffset() {
      return this.offset;
    }
    
    @Pure
    public int getLength() {
      return this.length;
    }
  }
  
  @Data
  public static class EditPosition {
    private final int offset;
    
    private final int length;
    
    public EditPosition(final int offset, final int length) {
      super();
      this.offset = offset;
      this.length = length;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + this.offset;
      result = prime * result + this.length;
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
      ContentAssistResult.EditPosition other = (ContentAssistResult.EditPosition) obj;
      if (other.offset != this.offset)
        return false;
      if (other.length != this.length)
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("offset", this.offset);
      b.add("length", this.length);
      return b.toString();
    }
    
    @Pure
    public int getOffset() {
      return this.offset;
    }
    
    @Pure
    public int getLength() {
      return this.length;
    }
  }
  
  private final ArrayList<ContentAssistResult.Entry> entries = new ArrayList<ContentAssistResult.Entry>();
  
  @Pure
  public ArrayList<ContentAssistResult.Entry> getEntries() {
    return this.entries;
  }
}
