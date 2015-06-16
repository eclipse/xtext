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
import org.eclipse.xtend.lib.annotations.ToString;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Accessors
@ToString(skipNulls = true)
@SuppressWarnings("all")
public class ContentAssistResult implements IServiceResult {
  private String stateId;
  
  private final ArrayList<ContentAssistEntry> entries = new ArrayList<ContentAssistEntry>();
  
  @Pure
  public String getStateId() {
    return this.stateId;
  }
  
  public void setStateId(final String stateId) {
    this.stateId = stateId;
  }
  
  @Pure
  public ArrayList<ContentAssistEntry> getEntries() {
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
