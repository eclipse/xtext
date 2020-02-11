/**
 * Copyright (c) 2012, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource;

import java.io.IOException;
import java.util.Map;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

@SuppressWarnings("all")
public class NullResource extends ResourceImpl {
  @Override
  public void load(final Map<?, ?> options) throws IOException {
  }
}
