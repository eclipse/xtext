/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.ng.debug;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.xtext.builder.ng.debug.ResourceDeltaToString;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("all")
public class ResourceChangeEventToString implements Function1<IResourceChangeEvent, String> {
  private String getBuildKindString(final IResourceChangeEvent event) {
    String _switchResult = null;
    int _buildKind = event.getBuildKind();
    final int kind = _buildKind;
    switch (kind) {
      case IncrementalProjectBuilder.AUTO_BUILD:
        _switchResult = "AUTO_BUILD";
        break;
      case IncrementalProjectBuilder.FULL_BUILD:
        _switchResult = "FULL_BUILD";
        break;
      case IncrementalProjectBuilder.INCREMENTAL_BUILD:
        _switchResult = "INCREMENTAL_BUILD";
        break;
      case IncrementalProjectBuilder.CLEAN_BUILD:
        _switchResult = "CLEAN_BUILD";
        break;
      default:
        _switchResult = Integer.valueOf(kind).toString();
        break;
    }
    return _switchResult;
  }
  
  private String getTypeString(final IResourceChangeEvent event) {
    String _switchResult = null;
    int _type = event.getType();
    final int kind = _type;
    switch (kind) {
      case IResourceChangeEvent.POST_BUILD:
        _switchResult = "POST_BUILD";
        break;
      case IResourceChangeEvent.POST_CHANGE:
        _switchResult = "POST_CHANGE";
        break;
      case IResourceChangeEvent.PRE_BUILD:
        _switchResult = "PRE_BUILD";
        break;
      case IResourceChangeEvent.PRE_CLOSE:
        _switchResult = "PRE_CLOSE";
        break;
      case IResourceChangeEvent.PRE_DELETE:
        _switchResult = "PRE_DELETE";
        break;
      case IResourceChangeEvent.PRE_REFRESH:
        _switchResult = "PRE_REFRESH";
        break;
      default:
        _switchResult = Integer.valueOf(kind).toString();
        break;
    }
    return _switchResult;
  }
  
  public String apply(final IResourceChangeEvent p) {
    Class<? extends IResourceChangeEvent> _class = p.getClass();
    String _simpleName = _class.getSimpleName();
    String _plus = (_simpleName + " buildKind=");
    String _buildKindString = this.getBuildKindString(p);
    String _plus_1 = (_plus + _buildKindString);
    String _plus_2 = (_plus_1 + " type=");
    String _typeString = this.getTypeString(p);
    String _plus_3 = (_plus_2 + _typeString);
    String _plus_4 = (_plus_3 + " {\n delta=");
    ResourceDeltaToString _resourceDeltaToString = new ResourceDeltaToString();
    IResourceDelta _delta = p.getDelta();
    String _apply = _resourceDeltaToString.apply(_delta);
    String _replace = _apply.replace("\n", "\n  ");
    String _plus_5 = (_plus_4 + _replace);
    return (_plus_5 + "\n}");
  }
}
