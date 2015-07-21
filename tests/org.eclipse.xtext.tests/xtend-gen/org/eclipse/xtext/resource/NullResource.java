/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
