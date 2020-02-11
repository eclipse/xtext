/**
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.idea;

import org.eclipse.xtext.xtext.generator.AbstractStubGeneratingFragment;

@Deprecated
@SuppressWarnings("all")
public class IdeaPluginGenerator extends AbstractStubGeneratingFragment {
  @Override
  public void generate() {
    boolean _isEnabled = this.getProjectConfig().getIdeaPlugin().isEnabled();
    boolean _not = (!_isEnabled);
    if (_not) {
      return;
    }
    System.err.println("The support for Idea has been removed!");
  }
}
