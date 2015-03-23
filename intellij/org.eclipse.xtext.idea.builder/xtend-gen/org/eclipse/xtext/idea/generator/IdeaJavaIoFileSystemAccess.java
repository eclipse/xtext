package org.eclipse.xtext.idea.generator;

import com.google.common.base.Objects;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.idea.build.XtextIdeaRefreshComponent;
import org.eclipse.xtext.idea.build.incremental.IdeaBuildData;
import org.eclipse.xtext.util.RuntimeIOException;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.jetbrains.jps.ModuleChunk;
import org.jetbrains.jps.incremental.CompileContext;
import org.jetbrains.jps.incremental.FSOperations;
import org.jetbrains.jps.incremental.ModuleBuildTarget;
import org.jetbrains.jps.incremental.ModuleLevelBuilder;
import org.jetbrains.jps.incremental.fs.CompilationRound;
import org.jetbrains.jps.model.java.JavaSourceRootProperties;
import org.jetbrains.jps.model.java.JavaSourceRootType;
import org.jetbrains.jps.model.module.JpsModule;
import org.jetbrains.jps.model.module.JpsModuleSourceRoot;
import org.jetbrains.jps.model.module.JpsTypedModuleSourceRoot;

@SuppressWarnings("all")
public class IdeaJavaIoFileSystemAccess extends JavaIoFileSystemAccess {
  @Accessors
  private IdeaBuildData buildData;
  
  @Override
  public void generateFile(final String fileName, final String outputConfigName, final CharSequence contents) throws RuntimeIOException {
    super.generateFile(fileName, outputConfigName, contents);
    this.markDirty(fileName, outputConfigName);
  }
  
  @Override
  public void generateFile(final String fileName, final CharSequence contents) {
    super.generateFile(fileName, contents);
    this.markDirty(fileName, IFileSystemAccess.DEFAULT_OUTPUT);
  }
  
  @Override
  public void generateFile(final String fileName, final InputStream content) {
    super.generateFile(fileName, content);
    this.markDirty(fileName, IFileSystemAccess.DEFAULT_OUTPUT);
  }
  
  @Override
  public void generateFile(final String fileName, final String outputConfigName, final InputStream content) throws RuntimeIOException {
    super.generateFile(fileName, outputConfigName, content);
    this.markDirty(fileName, outputConfigName);
  }
  
  @Override
  protected void generateTrace(final String generatedFile, final String outputConfigName, final CharSequence contents) {
    super.generateTrace(generatedFile, outputConfigName, contents);
  }
  
  @Override
  public void deleteFile(final String fileName, final String outputConfiguration) {
    super.deleteFile(fileName, outputConfiguration);
    this.markDeleted(fileName, outputConfiguration);
  }
  
  @Override
  public void deleteFile(final String fileName) {
    super.deleteFile(fileName);
    this.markDeleted(fileName, IFileSystemAccess.DEFAULT_OUTPUT);
  }
  
  protected void registerOutputFile(final File file, final String outputConfigName) {
    Map<String, String> _pathes = this.getPathes();
    String outlet = _pathes.get(outputConfigName);
    try {
      ModuleLevelBuilder.OutputConsumer _outputConsumer = this.buildData.getOutputConsumer();
      ModuleChunk _chunk = this.buildData.getChunk();
      ModuleBuildTarget _representativeTarget = _chunk.representativeTarget();
      List<String> _asList = Arrays.<String>asList(outlet);
      _outputConsumer.registerOutputFile(_representativeTarget, file, _asList);
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException e = (IOException)_t;
        throw new RuntimeException(e);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  /**
   * mark dirty to re-compile
   * @param file
   */
  protected void markDirty(final String fileName, final String outputConfigName) {
    try {
      this.createSourceRoot(fileName, outputConfigName);
      File file = this.getFile(fileName, outputConfigName);
      String _path = file.getPath();
      this.refresh(_path);
      CompileContext _context = this.buildData.getContext();
      FSOperations.markDirty(_context, CompilationRound.CURRENT, file);
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException e = (IOException)_t;
        throw new RuntimeException(e);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  protected JpsModuleSourceRoot createSourceRoot(final String fileName, final String outputConfigName) {
    JpsModuleSourceRoot _xblockexpression = null;
    {
      URI _uRI = this.getURI(fileName, outputConfigName);
      final String outletUrl = _uRI.toString();
      JpsModuleSourceRoot _xifexpression = null;
      JpsModule _module = this.buildData.getModule();
      Iterable<JpsTypedModuleSourceRoot<JavaSourceRootProperties>> _sourceRoots = _module.<JavaSourceRootProperties>getSourceRoots(JavaSourceRootType.SOURCE);
      final Function1<JpsTypedModuleSourceRoot<JavaSourceRootProperties>, Boolean> _function = new Function1<JpsTypedModuleSourceRoot<JavaSourceRootProperties>, Boolean>() {
        @Override
        public Boolean apply(final JpsTypedModuleSourceRoot<JavaSourceRootProperties> it) {
          String _url = it.getUrl();
          return Boolean.valueOf(Objects.equal(_url, outletUrl));
        }
      };
      boolean _exists = IterableExtensions.<JpsTypedModuleSourceRoot<JavaSourceRootProperties>>exists(_sourceRoots, _function);
      boolean _not = (!_exists);
      if (_not) {
        JpsModule _module_1 = this.buildData.getModule();
        _xifexpression = _module_1.<JavaSourceRootProperties>addSourceRoot(outletUrl, JavaSourceRootType.SOURCE);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  /**
   * mark deleted
   * @param file
   */
  protected void markDeleted(final String fileName, final String outputConfiguration) {
    try {
      File file = this.getFile(fileName, outputConfiguration);
      String _path = file.getPath();
      this.refresh(_path);
      CompileContext _context = this.buildData.getContext();
      FSOperations.markDeleted(_context, file);
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException e = (IOException)_t;
        throw new RuntimeException(e);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  /**
   * refresh virtual file in IDEA
   * @param file
   */
  protected void refresh(final String path) {
    XtextIdeaRefreshComponent _refreshComponent = this.buildData.getRefreshComponent();
    _refreshComponent.refresh(path);
  }
  
  @Pure
  public IdeaBuildData getBuildData() {
    return this.buildData;
  }
  
  public void setBuildData(final IdeaBuildData buildData) {
    this.buildData = buildData;
  }
}
