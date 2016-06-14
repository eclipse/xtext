/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource.persistence;

import com.google.common.base.Objects;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionManager;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.8
 */
@SuppressWarnings("all")
public class StorageAwareResourceDescriptionManager extends DefaultResourceDescriptionManager {
  @Override
  public IResourceDescription getResourceDescription(final Resource resource) {
    IResourceDescription _switchResult = null;
    boolean _matched = false;
    if (resource instanceof StorageAwareResource) {
      IResourceDescription _resourceDescription = ((StorageAwareResource)resource).getResourceDescription();
      boolean _notEquals = (!Objects.equal(_resourceDescription, null));
      if (_notEquals) {
        _matched=true;
        _switchResult = ((StorageAwareResource)resource).getResourceDescription();
      }
    }
    if (!_matched) {
      _switchResult = super.getResourceDescription(resource);
    }
    return _switchResult;
  }
}
