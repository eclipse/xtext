/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.server;

import com.google.common.collect.Iterables;
import com.intellij.compiler.server.BuildProcessParametersProvider;
import com.intellij.ide.plugins.IdeaPluginDescriptor;
import com.intellij.ide.plugins.PluginManager;
import com.intellij.openapi.extensions.PluginId;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class XtextBuildProcessParametersProvider extends BuildProcessParametersProvider {
  @Override
  public List<String> getClassPath() {
    ArrayList<String> _xblockexpression = null;
    {
      final PluginId pluginId = PluginId.getId("org.eclipse.xtext.idea");
      final IdeaPluginDescriptor plugin = PluginManager.getPlugin(pluginId);
      final ArrayList<String> libs = CollectionLiterals.<String>newArrayList();
      File _path = plugin.getPath();
      File _file = new File(_path, "lib");
      File[] _listFiles = _file.listFiles();
      final Function1<File, String> _function = new Function1<File, String>() {
        @Override
        public String apply(final File it) {
          return it.getAbsolutePath();
        }
      };
      List<String> _map = ListExtensions.<File, String>map(((List<File>)Conversions.doWrapArray(_listFiles)), _function);
      Iterables.<String>addAll(libs, _map);
      File _path_1 = plugin.getPath();
      File _file_1 = new File(_path_1, "builder");
      File[] _listFiles_1 = _file_1.listFiles();
      final Function1<File, String> _function_1 = new Function1<File, String>() {
        @Override
        public String apply(final File it) {
          return it.getAbsolutePath();
        }
      };
      List<String> _map_1 = ListExtensions.<File, String>map(((List<File>)Conversions.doWrapArray(_listFiles_1)), _function_1);
      Iterables.<String>addAll(libs, _map_1);
      _xblockexpression = libs;
    }
    return _xblockexpression;
  }
}
