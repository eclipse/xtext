/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server.persistence;

import org.eclipse.emf.common.util.URI;

/**
 * Translates resource identifiers into file URIs that can be used to load and save files.
 */
public interface IResourceBaseProvider {
  URI getFileURI(String resourceId);
}
