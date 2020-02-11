/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server.generator;

/**
 * A content type provider is responsible for assigning content types to documents resulting
 * from an {@link org.eclipse.xtext.generator.IGenerator} implementation.
 */
public interface IContentTypeProvider {
  String getContentType(String fileName);
}
