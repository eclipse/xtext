/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.persistence;

import org.eclipse.emf.common.util.URI;

/**
 * Translates resource identifiers into file URIs that can be used to load and save files.
 */
@SuppressWarnings("all")
public interface IResourceBaseProvider {
  public abstract URI getFileURI(final String resourceId);
}
