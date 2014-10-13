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
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class XtextBuildProcessParametersProvider extends BuildProcessParametersProvider {
  public List<String> getClassPath() {
    ArrayList<String> _xblockexpression = null;
    {
      PluginId _id = PluginId.getId("org.xtext.idea");
      final IdeaPluginDescriptor plugin = PluginManager.getPlugin(_id);
      final File pluginFolder = plugin.getPath();
      String _path = pluginFolder.getPath();
      String _plus = (_path + "/../org.xtext.idea.builder/bin");
      final ArrayList<String> result = CollectionLiterals.<String>newArrayList(_plus);
      File _file = new File(pluginFolder, "lib");
      File[] _listFiles = _file.listFiles();
      final Function1<File, Boolean> _function = new Function1<File, Boolean>() {
        public Boolean apply(final File it) {
          boolean _and = false;
          boolean _isFile = it.isFile();
          if (!_isFile) {
            _and = false;
          } else {
            String _name = it.getName();
            boolean _endsWith = _name.endsWith(".jar");
            _and = _endsWith;
          }
          return Boolean.valueOf(_and);
        }
      };
      Iterable<File> _filter = IterableExtensions.<File>filter(((Iterable<File>)Conversions.doWrapArray(_listFiles)), _function);
      final Function1<File, String> _function_1 = new Function1<File, String>() {
        public String apply(final File it) {
          return it.getPath();
        }
      };
      Iterable<String> _map = IterableExtensions.<File, String>map(_filter, _function_1);
      Iterables.<String>addAll(result, _map);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
}
