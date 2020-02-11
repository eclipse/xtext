/**
 * Copyright (c) 2012, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource;

import org.eclipse.xtext.resource.AbstractXtextResourceSetTest;
import org.eclipse.xtext.resource.XtextResourceSet;

@SuppressWarnings("all")
public class XtextResourceSetTest extends AbstractXtextResourceSetTest {
  @Override
  protected XtextResourceSet createEmptyResourceSet() {
    return new XtextResourceSet();
  }
}
