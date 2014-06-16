package org.eclipse.xtext.xbase.file;

import java.util.Map;
import org.eclipse.xtend.lib.Property;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class ProjectConfig {
  @Property
  private final Path _rootPath;
  
  @Property
  private final String _name;
  
  @Property
  private final Map<Path, Path> _sourceFolderMappings = CollectionLiterals.<Path, Path>newLinkedHashMap();
  
  public ProjectConfig(final String name) {
    this._name = name;
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(Path.SEGMENT_SEPARATOR, "");
    _builder.append(name, "");
    Path _path = new Path(_builder.toString());
    this._rootPath = _path;
  }
  
  public void addSourceFolderMapping(final String from, final String to) {
    Map<Path, Path> _sourceFolderMappings = this.getSourceFolderMappings();
    Path _rootPath = this.getRootPath();
    Path _append = _rootPath.append(from);
    Path _rootPath_1 = this.getRootPath();
    Path _append_1 = _rootPath_1.append(to);
    _sourceFolderMappings.put(_append, _append_1);
  }
  
  public Path getRootPath() {
    return this._rootPath;
  }
  
  public String getName() {
    return this._name;
  }
  
  public Map<Path, Path> getSourceFolderMappings() {
    return this._sourceFolderMappings;
  }
}
