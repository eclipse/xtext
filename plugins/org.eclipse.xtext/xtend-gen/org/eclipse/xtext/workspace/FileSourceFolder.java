/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.workspace;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend.lib.annotations.ToString;
import org.eclipse.xtext.workspace.FileProjectConfig;
import org.eclipse.xtext.workspace.ISourceFolder;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@FinalFieldsConstructor
@ToString
@SuppressWarnings("all")
public class FileSourceFolder implements ISourceFolder {
  private final FileProjectConfig parent;
  
  private final String name;
  
  @Override
  public String getName() {
    return this.name;
  }
  
  @Override
  public URI getPath() {
    URI _path = this.parent.getPath();
    String[] _split = this.name.split("/");
    final Function1<String, String> _function = new Function1<String, String>() {
      @Override
      public String apply(final String it) {
        return URI.encodeSegment(it, true);
      }
    };
    List<String> _map = ListExtensions.<String, String>map(((List<String>)Conversions.doWrapArray(_split)), _function);
    URI _appendSegments = _path.appendSegments(((String[])Conversions.unwrapArray(_map, String.class)));
    return _appendSegments.appendSegment("");
  }
  
  @Override
  public boolean equals(final Object obj) {
    if ((obj instanceof FileSourceFolder)) {
      URI _path = this.getPath();
      URI _path_1 = ((FileSourceFolder)obj).getPath();
      return Objects.equal(_path, _path_1);
    }
    return false;
  }
  
  @Override
  public int hashCode() {
    URI _path = this.getPath();
    return _path.hashCode();
  }
  
  public FileSourceFolder(final FileProjectConfig parent, final String name) {
    super();
    this.parent = parent;
    this.name = name;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("parent", this.parent);
    b.add("name", this.name);
    return b.toString();
  }
}
