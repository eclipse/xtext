/**
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server;

import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.web.server.generator.DefaultContentTypeProvider;
import org.eclipse.xtext.web.server.generator.IContentTypeProvider;

/**
 * Default Guice bindings for the web integration of Xtext.
 */
public class DefaultWebModule extends AbstractGenericModule {
  public Class<? extends IContentTypeProvider> bindIContentTypeProvider() {
    return DefaultContentTypeProvider.class;
  }
}
