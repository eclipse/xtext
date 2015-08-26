/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.model;

import com.google.common.base.Objects;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

@Log
@Accessors
@SuppressWarnings("all")
public class PluginXmlAccess {
  private String path = "plugin.xml";
  
  private final List<CharSequence> entries = CollectionLiterals.<CharSequence>newArrayList();
  
  /**
   * Merge the contents of the given plugin.xml into this one.
   */
  public boolean merge(final PluginXmlAccess other) {
    boolean _xblockexpression = false;
    {
      boolean _notEquals = (!Objects.equal(this.path, other.path));
      if (_notEquals) {
        PluginXmlAccess.LOG.warn(((("Merging plugin.xml files with different paths: " + this.path) + ", ") + other.path));
      }
      _xblockexpression = this.entries.addAll(other.entries);
    }
    return _xblockexpression;
  }
  
  private final static Logger LOG = Logger.getLogger(PluginXmlAccess.class);
  
  @Pure
  public String getPath() {
    return this.path;
  }
  
  public void setPath(final String path) {
    this.path = path;
  }
  
  @Pure
  public List<CharSequence> getEntries() {
    return this.entries;
  }
}
