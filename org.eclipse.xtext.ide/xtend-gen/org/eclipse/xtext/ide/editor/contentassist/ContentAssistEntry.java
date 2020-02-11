/**
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
   * Documentation for the proposal proposals.
   * <p>This property may not be supported by all editor frameworks.</p>
   */
  private String documentation;
  
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
  
  /**
   * The EObject or IEObjectDescription for which this entry has been created, if any.
   * This field is <em>not</em> serialized when the entry is sent over a communication channel.
   */
  private transient Object source;
  
  /**
   * The kind of element that is proposed. Could be one of the constants below or something specific a concrete client understands.
   * Must not be null.
   */
  private String kind = ContentAssistEntry.KIND_UNKNOWN;
  
  public static final String KIND_TEXT = "TEXT";
  
  public static final String KIND_METHOD = "METHOD";
  
  public static final String KIND_FUNCTION = "FUNCTION";
  
  public static final String KIND_CONSTRUCTOR = "CONSTRUCTOR";
  
  public static final String KIND_FIELD = "FIELD";
  
  public static final String KIND_VARIABLE = "VARIABLE";
  
  public static final String KIND_CLASS = "CLASS";
  
  public static final String KIND_INTERFACE = "INTERFACE";
  
  public static final String KIND_MODULE = "MODULE";
  
  public static final String KIND_PROPERTY = "PROPERTY";
  
  public static final String KIND_UNIT = "UNIT";
  
  public static final String KIND_VALUE = "VALUE";
  
  public static final String KIND_ENUM = "ENUM";
  
  public static final String KIND_KEYWORD = "KEYWORD";
  
  public static final String KIND_SNIPPET = "SNIPPET";
  
  public static final String KIND_COLOR = "COLOR";
  
  public static final String KIND_FILE = "FILE";
  
  public static final String KIND_REFERENCE = "REFERENCE";
  
  public static final String KIND_UNKNOWN = "UNKNOWN";
  
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
  public String getDocumentation() {
    return this.documentation;
  }
  
  public void setDocumentation(final String documentation) {
    this.documentation = documentation;
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
  
  @Pure
  public Object getSource() {
    return this.source;
  }
  
  public void setSource(final Object source) {
    this.source = source;
  }
  
  @Pure
  public String getKind() {
    return this.kind;
  }
  
  public void setKind(final String kind) {
    this.kind = kind;
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
    b.add("documentation", this.documentation);
    b.add("escapePosition", this.escapePosition);
    b.add("textReplacements", this.textReplacements);
    b.add("editPositions", this.editPositions);
    b.add("kind", this.kind);
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
    if (this.documentation == null) {
      if (other.documentation != null)
        return false;
    } else if (!this.documentation.equals(other.documentation))
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
    if (this.kind == null) {
      if (other.kind != null)
        return false;
    } else if (!this.kind.equals(other.kind))
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
    result = prime * result + ((this.documentation== null) ? 0 : this.documentation.hashCode());
    result = prime * result + ((this.escapePosition== null) ? 0 : this.escapePosition.hashCode());
    result = prime * result + ((this.textReplacements== null) ? 0 : this.textReplacements.hashCode());
    result = prime * result + ((this.editPositions== null) ? 0 : this.editPositions.hashCode());
    return prime * result + ((this.kind== null) ? 0 : this.kind.hashCode());
  }
}
