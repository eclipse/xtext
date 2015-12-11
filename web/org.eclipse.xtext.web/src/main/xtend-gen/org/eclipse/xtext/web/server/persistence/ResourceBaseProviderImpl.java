/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.persistence;

import java.io.File;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.persistence.IResourceBaseProvider;

/**
 * Default resource base provider that assumes all resource identifiers are relative
 * paths inside a certain resource base path, which has to be given when creating
 * this provider.
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class ResourceBaseProviderImpl implements IResourceBaseProvider {
  private final String resourceBase;
  
  @Override
  public URI getFileURI(final String resourceId) {
    URI _xblockexpression = null;
    {
      boolean _contains = resourceId.contains("..");
      if (_contains) {
        throw new InvalidRequestException.InvalidParametersException("Invalid resource path.");
      }
      URI _xifexpression = null;
      boolean _endsWith = this.resourceBase.endsWith(File.separator);
      if (_endsWith) {
        _xifexpression = URI.createFileURI((this.resourceBase + resourceId));
      } else {
        _xifexpression = URI.createFileURI(((this.resourceBase + File.separator) + resourceId));
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public ResourceBaseProviderImpl(final String resourceBase) {
    super();
    this.resourceBase = resourceBase;
  }
}
