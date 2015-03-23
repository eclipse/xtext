package org.eclipse.xtext.idea.build.incremental;

import java.io.File;
import java.util.Collection;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.xtext.builder.standalone.LanguageAccess;
import org.eclipse.xtext.builder.standalone.StandaloneBuilder;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.idea.build.incremental.IdeaBuildData;
import org.eclipse.xtext.idea.build.incremental.IdeaIssueHandler;
import org.eclipse.xtext.idea.generator.IdeaJavaIoFileSystemAccess;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class IdeaStandaloneBuilder extends StandaloneBuilder {
  private final static Logger LOG = Logger.getLogger(IdeaStandaloneBuilder.class);
  
  private IdeaBuildData buildData;
  
  public void setBuildData(final IdeaBuildData buildData) {
    this.buildData = buildData;
    String _baseDir = buildData.getBaseDir();
    this.setBaseDir(_baseDir);
    Collection<File> _classpath = buildData.getClasspath();
    final Function1<File, String> _function = new Function1<File, String>() {
      @Override
      public String apply(final File it) {
        return it.getPath();
      }
    };
    Iterable<String> _map = IterableExtensions.<File, String>map(_classpath, _function);
    this.setClassPathEntries(_map);
    String _encoding = buildData.getEncoding();
    this.setEncoding(_encoding);
    File _orCreateTmpDir = this.getOrCreateTmpDir();
    String _path = _orCreateTmpDir.getPath();
    this.setTempDir(_path);
    Set<File> _sourceRoots = buildData.getSourceRoots();
    final Function1<File, String> _function_1 = new Function1<File, String>() {
      @Override
      public String apply(final File it) {
        return it.getPath();
      }
    };
    Iterable<String> _map_1 = IterableExtensions.<File, String>map(_sourceRoots, _function_1);
    this.setSourceDirs(_map_1);
    ((IdeaIssueHandler) this.issueHandler).setBuildData(buildData);
  }
  
  @Override
  protected JavaIoFileSystemAccess configureFileSystemAccess(final JavaIoFileSystemAccess fsa, final LanguageAccess language) {
    JavaIoFileSystemAccess _xblockexpression = null;
    {
      if ((fsa instanceof IdeaJavaIoFileSystemAccess)) {
        ((IdeaJavaIoFileSystemAccess)fsa).setBuildData(this.buildData);
      }
      _xblockexpression = fsa;
    }
    return _xblockexpression;
  }
  
  private File getOrCreateTmpDir() {
    final String contentRoot = this.getBaseDir();
    final File tmpDir = new File(contentRoot, "xtend-stubs");
    boolean _exists = tmpDir.exists();
    boolean _not = (!_exists);
    if (_not) {
      tmpDir.mkdir();
    } else {
      boolean _isDirectory = tmpDir.isDirectory();
      boolean _not_1 = (!_isDirectory);
      if (_not_1) {
        IdeaStandaloneBuilder.LOG.error((("Compilation tmpDir " + tmpDir) + " exists and is a file"));
      }
    }
    return tmpDir;
  }
}
