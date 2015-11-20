/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.example.jetty.resource;

import com.google.common.base.Objects;
import org.eclipse.xtext.web.server.generator.DefaultContentTypeProvider;
import org.eclipse.xtext.web.server.generator.GeneratorService;

@SuppressWarnings("all")
public class StatemachineContentTypeProvider extends DefaultContentTypeProvider {
  @Override
  public String getContentType(final String fileName) {
    String _xblockexpression = null;
    {
      boolean _equals = Objects.equal(fileName, GeneratorService.DEFAULT_ARTIFACT);
      if (_equals) {
        return "text/html";
      }
      _xblockexpression = super.getContentType(fileName);
    }
    return _xblockexpression;
  }
}
