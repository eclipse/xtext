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

/**
 * @noreference
 */
@Accessors
@ToString(skipNulls = true)
@EqualsHashCode
@SuppressWarnings("all")
public class ContentAssistEntry {
  /**
   * The prefix that should be replaced with this proposal.
   */
  private String prefix;
  
  /**
   * The proposed text to be inserted.
   */
  private String proposal;
  
  /**
   * The text seen by the user in the list of proposals.
   */
  private String label;
  
  /**
   * Additional description to include in the list of proposals.
   * <p>This property may not be supported by all editor frameworks.</p>
   */
  private String description;
  
  /**
   * The absolute cursor position to apply after the proposal has been inserted.
   * If omitted, the cursor it set to the end of the inserted proposal.
   * <p>This property may not be supported by all editor frameworks.</p>
   */
  private Integer escapePosition;
  
  /**
   * Additional text replacements to apply when this proposal is selected.
   * <p>This property may not be supported by all editor frameworks.</p>
   */
  private final ArrayList<ReplaceRegion> textReplacements = new ArrayList<ReplaceRegion>();
  
  /**
   * Regions to be edited by the user after the proposal has been inserted.
   * Usually the <em>tab</em> key navigates through the edit positions, and <em>enter</em>
   * jumps to the {@code escapePosition}.
   * <p>This property may not be supported by all editor frameworks.</p>
   */
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
  public Integer getEscapePosition() {
    return this.escapePosition;
  }
  
  public void setEscapePosition(final Integer escapePosition) {
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
    if (this.escapePosition == null) {
      if (other.escapePosition != null)
        return false;
    } else if (!this.escapePosition.equals(other.escapePosition))
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
    result = prime * result + ((this.escapePosition== null) ? 0 : this.escapePosition.hashCode());
    result = prime * result + ((this.textReplacements== null) ? 0 : this.textReplacements.hashCode());
    result = prime * result + ((this.editPositions== null) ? 0 : this.editPositions.hashCode());
    return result;
  }
}
