package org.eclipse.xtext.xbase.file;

import java.util.Map;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class ProjectConfig {
  private final Path rootPath;
  
  private final String name;
  
  private final Map<Path, Path> sourceFolderMappings = CollectionLiterals.<Path, Path>newLinkedHashMap();
  
  public ProjectConfig(final String name) {
    this.name = name;
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(Path.SEGMENT_SEPARATOR, "");
    _builder.append(name, "");
    Path _path = new Path(_builder.toString());
    this.rootPath = _path;
  }
  
  public void addSourceFolderMapping(final String from, final String to) {
    Path _append = this.rootPath.append(from);
    Path _append_1 = this.rootPath.append(to);
    this.sourceFolderMappings.put(_append, _append_1);
  }
  
  @Pure
  public Path getRootPath() {
    return this.rootPath;
  }
  
  @Pure
  public String getName() {
    return this.name;
  }
  
  @Pure
  public Map<Path, Path> getSourceFolderMappings() {
    return this.sourceFolderMappings;
  }
}
