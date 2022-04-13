/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.emf.common.util.URI;

@SuppressWarnings("all")
public class NopResourceChangeRegistry implements IResourceChangeRegistry {
  @Override
  public void registerExists(final String path, final URI uri) {
  }

  @Override
  public void registerGetCharset(final String string, final URI uri) {
  }

  @Override
  public void registerGetChildren(final String string, final URI uri) {
  }

  @Override
  public void registerGetContents(final String string, final URI uri) {
  }

  @Override
  public void registerCreateOrModify(final String string, final URI uri) {
  }

  @Override
  public void discardCreateOrModifyInformation(final URI uri) {
  }
}
