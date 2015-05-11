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
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend.lib.annotations.ToString;
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
  public static class Entry {
    /**
     * One of the constants defined in {@link ContentAssistResult}
     */
    private final String type;
    
    private final String prefix;
    
    private String proposal;
    
    private String name;
    
    private String description;
    
    /**
     * Available styles: 'default', 'emphasis', 'noemphasis', 'hr'
     */
    private String style;
    
    private int escapePosition;
    
    private final ArrayList<ContentAssistResult.TextReplacement> textReplacements = new ArrayList<ContentAssistResult.TextReplacement>();
    
    private final ArrayList<ContentAssistResult.EditPosition> editPositions = new ArrayList<ContentAssistResult.EditPosition>();
    
    public Entry(final String type, final String prefix) {
      super();
      this.type = type;
      this.prefix = prefix;
    }
    
    @Pure
    public String getType() {
      return this.type;
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
    public ArrayList<ContentAssistResult.TextReplacement> getTextReplacements() {
      return this.textReplacements;
    }
    
    @Pure
    public ArrayList<ContentAssistResult.EditPosition> getEditPositions() {
      return this.editPositions;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.skipNulls();
      b.add("type", this.type);
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
  
  public final static String KEYWORD = "keyword";
  
  public final static String PARSER_RULE = "parser-rule";
  
  public final static String FEATURE = "feature";
  
  public final static String TERMINAL = "terminal";
  
  public final static String CROSSREF = "cross-ref";
  
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
