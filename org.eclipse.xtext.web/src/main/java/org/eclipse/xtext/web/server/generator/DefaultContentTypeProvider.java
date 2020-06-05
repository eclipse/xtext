/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server.generator;

import java.net.URLConnection;

/**
 * The default content type provider uses {@link URLConnection#guessContentTypeFromName(String)}
 * to determine content types.
 */
public class DefaultContentTypeProvider implements IContentTypeProvider {
  @Override
  public String getContentType(String fileName) {
    if (fileName != null) {
      return URLConnection.guessContentTypeFromName(fileName);
    }
    return null;
  }
}
