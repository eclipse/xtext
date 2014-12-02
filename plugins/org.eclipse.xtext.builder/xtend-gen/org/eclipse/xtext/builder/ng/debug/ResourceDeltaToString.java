/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.ng.debug;

import java.util.List;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("all")
public class ResourceDeltaToString implements Function1<IResourceDelta, String> {
  private String getKindString(final IResourceDelta delta) {
    String _switchResult = null;
    int _kind = delta.getKind();
    final int kind = _kind;
    switch (kind) {
      case IResourceDelta.ADDED:
        _switchResult = "ADDED";
        break;
      case IResourceDelta.REMOVED:
        _switchResult = "REMOVED";
        break;
      case IResourceDelta.CHANGED:
        _switchResult = "CHANGED";
        break;
      case IResourceDelta.ADDED_PHANTOM:
        _switchResult = "ADDED_PHANTOM";
        break;
      case IResourceDelta.REMOVED_PHANTOM:
        _switchResult = "REMOVED_PHANTOM";
        break;
      default:
        _switchResult = Integer.valueOf(kind).toString();
        break;
    }
    return _switchResult;
  }
  
  public String apply(final IResourceDelta delta) {
    Class<? extends IResourceDelta> _class = delta.getClass();
    String _simpleName = _class.getSimpleName();
    String _plus = (_simpleName + " ");
    Path _path = new Path("/");
    String _apply = this.apply(_path, delta);
    return (_plus + _apply);
  }
  
  private String apply(final IPath parent, final IResourceDelta delta) {
    final IResourceDelta[] children = delta.getAffectedChildren();
    int _size = ((List<IResourceDelta>)Conversions.doWrapArray(children)).size();
    boolean _equals = (_size == 1);
    if (_equals) {
      IResourceDelta _head = IterableExtensions.<IResourceDelta>head(((Iterable<IResourceDelta>)Conversions.doWrapArray(children)));
      return this.apply(parent, _head);
    }
    final String kind = this.getKindString(delta);
    IResource _resource = delta.getResource();
    Class<? extends IResource> _class = null;
    if (_resource!=null) {
      _class=_resource.getClass();
    }
    final String type = _class.getSimpleName();
    IPath _fullPath = delta.getFullPath();
    IPath _makeRelativeTo = _fullPath.makeRelativeTo(parent);
    final String name = _makeRelativeTo.toString();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(kind, "");
    _builder.append(" ");
    _builder.append(type, "");
    _builder.append(" ");
    _builder.append(name, "");
    final String body = _builder.toString();
    boolean _isEmpty = ((List<IResourceDelta>)Conversions.doWrapArray(children)).isEmpty();
    if (_isEmpty) {
      return body;
    }
    final Function1<IResourceDelta, String> _function = new Function1<IResourceDelta, String>() {
      public String apply(final IResourceDelta it) {
        IPath _fullPath = delta.getFullPath();
        return ResourceDeltaToString.this.apply(_fullPath, it);
      }
    };
    List<String> _map = ListExtensions.<IResourceDelta, String>map(((List<IResourceDelta>)Conversions.doWrapArray(children)), _function);
    String _join = IterableExtensions.join(_map, "\n");
    String _replace = _join.replace("\n", "\n  ");
    String _plus = ((body + " {\n  ") + _replace);
    return (_plus + "\n}");
  }
}
