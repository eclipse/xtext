/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.tests.util;

import org.eclipse.xtext.ui.util.PluginProjectFactory;

@SuppressWarnings("all")
public class TestablePluginProjectFactory extends PluginProjectFactory {
  @Override
  public void addToBuildProperties(final StringBuilder content, final Iterable<String> entries, final String entryName) {
    super.addToBuildProperties(content, entries, entryName);
  }
}
