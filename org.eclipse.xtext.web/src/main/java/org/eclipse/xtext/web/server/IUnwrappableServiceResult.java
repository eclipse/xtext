/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server;

/**
 * Service results that implement this interface are unwrapped, i.e. the content of the result object
 * is sent to the client instead of a Json object.
 */
public interface IUnwrappableServiceResult extends IServiceResult {
  /**
   * The actual content to write into the request response.
   */
  String getContent();
  
  /**
   * The content type of the text content.
   */
  String getContentType();
}
