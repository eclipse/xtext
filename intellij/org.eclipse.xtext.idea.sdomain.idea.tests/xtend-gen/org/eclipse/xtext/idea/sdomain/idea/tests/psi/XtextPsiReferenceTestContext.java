/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.sdomain.idea.tests.psi;

import com.google.common.base.Objects;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class XtextPsiReferenceTestContext {
  private String text;
  
  private int caretOffset;
  
  private int startCrossReferenceOffset;
  
  private int endCrossReferenceOffset;
  
  private int startReferenceOffset;
  
  private int endReferenceOffset;
  
  private int startReferenceToHighlightOffset;
  
  private int endReferenceToHighlightOffset;
  
  public XtextPsiReferenceTestContext(final String text) {
    this.text = text;
    int startIndex = this.text.indexOf("<");
    while ((startIndex != (-1))) {
      {
        final int endIndex = this.text.indexOf(">");
        final String name = this.text.substring((startIndex + 1), endIndex);
        boolean _matched = false;
        if (Objects.equal(name, "caret")) {
          _matched=true;
          this.caretOffset = startIndex;
        }
        if (!_matched) {
          if (Objects.equal(name, "crossReference")) {
            _matched=true;
            this.startCrossReferenceOffset = startIndex;
          }
        }
        if (!_matched) {
          if (Objects.equal(name, "/crossReference")) {
            _matched=true;
            this.endCrossReferenceOffset = startIndex;
          }
        }
        if (!_matched) {
          if (Objects.equal(name, "reference")) {
            _matched=true;
            this.startReferenceOffset = startIndex;
          }
        }
        if (!_matched) {
          if (Objects.equal(name, "/reference")) {
            _matched=true;
            this.endReferenceOffset = startIndex;
          }
        }
        if (!_matched) {
          if (Objects.equal(name, "referenceToHighlight")) {
            _matched=true;
            this.startReferenceToHighlightOffset = startIndex;
          }
        }
        if (!_matched) {
          if (Objects.equal(name, "/referenceToHighlight")) {
            _matched=true;
            this.endReferenceToHighlightOffset = startIndex;
          }
        }
        String _substring = this.text.substring(0, startIndex);
        String _substring_1 = this.text.substring((endIndex + 1));
        String _plus = (_substring + _substring_1);
        this.text = _plus;
        int _indexOf = this.text.indexOf("<");
        startIndex = _indexOf;
      }
    }
  }
  
  @Pure
  public String getText() {
    return this.text;
  }
  
  public void setText(final String text) {
    this.text = text;
  }
  
  @Pure
  public int getCaretOffset() {
    return this.caretOffset;
  }
  
  public void setCaretOffset(final int caretOffset) {
    this.caretOffset = caretOffset;
  }
  
  @Pure
  public int getStartCrossReferenceOffset() {
    return this.startCrossReferenceOffset;
  }
  
  public void setStartCrossReferenceOffset(final int startCrossReferenceOffset) {
    this.startCrossReferenceOffset = startCrossReferenceOffset;
  }
  
  @Pure
  public int getEndCrossReferenceOffset() {
    return this.endCrossReferenceOffset;
  }
  
  public void setEndCrossReferenceOffset(final int endCrossReferenceOffset) {
    this.endCrossReferenceOffset = endCrossReferenceOffset;
  }
  
  @Pure
  public int getStartReferenceOffset() {
    return this.startReferenceOffset;
  }
  
  public void setStartReferenceOffset(final int startReferenceOffset) {
    this.startReferenceOffset = startReferenceOffset;
  }
  
  @Pure
  public int getEndReferenceOffset() {
    return this.endReferenceOffset;
  }
  
  public void setEndReferenceOffset(final int endReferenceOffset) {
    this.endReferenceOffset = endReferenceOffset;
  }
  
  @Pure
  public int getStartReferenceToHighlightOffset() {
    return this.startReferenceToHighlightOffset;
  }
  
  public void setStartReferenceToHighlightOffset(final int startReferenceToHighlightOffset) {
    this.startReferenceToHighlightOffset = startReferenceToHighlightOffset;
  }
  
  @Pure
  public int getEndReferenceToHighlightOffset() {
    return this.endReferenceToHighlightOffset;
  }
  
  public void setEndReferenceToHighlightOffset(final int endReferenceToHighlightOffset) {
    this.endReferenceToHighlightOffset = endReferenceToHighlightOffset;
  }
}
