/**
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.util;

import com.intellij.ide.plugins.PluginManager;
import com.intellij.openapi.extensions.PluginId;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class PlatformUtil {
  public boolean isMavenInstalled() {
    return this.isPluginInstalled("org.jetbrains.idea.maven");
  }
  
  public boolean isGradleInstalled() {
    return this.isPluginInstalled("org.jetbrains.plugins.gradle");
  }
  
  public boolean isPluginInstalled(final String pluginId) {
    PluginId _id = PluginId.getId(pluginId);
    return PluginManager.isPluginInstalled(_id);
  }
}
