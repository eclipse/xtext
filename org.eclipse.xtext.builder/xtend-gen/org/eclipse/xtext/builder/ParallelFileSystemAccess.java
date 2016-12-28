package org.eclipse.xtext.builder;

import java.io.InputStream;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.generator.AbstractFileSystemAccess;
import org.eclipse.xtext.generator.FileSystemAccessQueue;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.util.RuntimeIOException;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Anton Kosyakov
 * @since 2.7
 */
@SuppressWarnings("all")
public class ParallelFileSystemAccess implements IFileSystemAccess2 {
  private final IFileSystemAccess2 delegate;
  
  private final IResourceDescription.Delta delta;
  
  private final FileSystemAccessQueue fileSystemAccessQueue;
  
  private final String sourceFolder;
  
  private final EclipseResourceFileSystemAccess2.IFileCallback fileCallback;
  
  /**
   * @since 2.9
   */
  @FinalFieldsConstructor
  public ParallelFileSystemAccess(final IFileSystemAccess2 delegate, final IResourceDescription.Delta delta, final FileSystemAccessQueue fileSystemAccessQueue, final String sourceFolder, final EclipseResourceFileSystemAccess2.IFileCallback fileCallback) {
    super();
    this.delegate = delegate;
    this.delta = delta;
    this.fileSystemAccessQueue = fileSystemAccessQueue;
    this.sourceFolder = sourceFolder;
    this.fileCallback = fileCallback;
  }
  
  protected void sendAsync(final Procedure1<? super IFileSystemAccess2> procedure) {
    final Runnable _function = () -> {
      if ((this.delegate instanceof EclipseResourceFileSystemAccess2)) {
        ((EclipseResourceFileSystemAccess2)this.delegate).setPostProcessor(this.fileCallback);
      }
      if ((this.sourceFolder != null)) {
        if ((this.delegate instanceof AbstractFileSystemAccess)) {
          ((AbstractFileSystemAccess)this.delegate).setCurrentSource(this.sourceFolder);
        }
      }
      procedure.apply(this.delegate);
    };
    this.fileSystemAccessQueue.sendAsync(this.delta.getUri(), _function);
  }
  
  @Override
  public void deleteFile(final String fileName) {
    final Procedure1<IFileSystemAccess2> _function = (IFileSystemAccess2 it) -> {
      it.deleteFile(fileName);
    };
    this.sendAsync(_function);
  }
  
  @Override
  public void generateFile(final String fileName, final CharSequence contents) {
    final Procedure1<IFileSystemAccess2> _function = (IFileSystemAccess2 it) -> {
      it.generateFile(fileName, contents);
    };
    this.sendAsync(_function);
  }
  
  @Override
  public void generateFile(final String fileName, final String outputConfigurationName, final CharSequence contents) {
    final Procedure1<IFileSystemAccess2> _function = (IFileSystemAccess2 it) -> {
      it.generateFile(fileName, outputConfigurationName, contents);
    };
    this.sendAsync(_function);
  }
  
  @Override
  public void deleteFile(final String fileName, final String outputConfigurationName) {
    final Procedure1<IFileSystemAccess2> _function = (IFileSystemAccess2 it) -> {
      it.deleteFile(fileName, outputConfigurationName);
    };
    this.sendAsync(_function);
  }
  
  @Override
  public URI getURI(final String path, final String outputConfiguration) {
    if ((this.delegate instanceof EclipseResourceFileSystemAccess2)) {
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      return ((EclipseResourceFileSystemAccess2)this.delegate).getURI(path, outputConfiguration, _nullProgressMonitor);
    }
    return this.delegate.getURI(path, outputConfiguration);
  }
  
  @Override
  public URI getURI(final String path) {
    if ((this.delegate instanceof EclipseResourceFileSystemAccess2)) {
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      return ((EclipseResourceFileSystemAccess2)this.delegate).getURI(path, _nullProgressMonitor);
    }
    return this.delegate.getURI(path);
  }
  
  @Override
  public void generateFile(final String fileName, final String outputCfgName, final InputStream content) throws RuntimeIOException {
    final Procedure1<IFileSystemAccess2> _function = (IFileSystemAccess2 it) -> {
      it.generateFile(fileName, outputCfgName, content);
    };
    this.sendAsync(_function);
  }
  
  @Override
  public void generateFile(final String fileName, final InputStream content) throws RuntimeIOException {
    final Procedure1<IFileSystemAccess2> _function = (IFileSystemAccess2 it) -> {
      it.generateFile(fileName, content);
    };
    this.sendAsync(_function);
  }
  
  @Override
  public InputStream readBinaryFile(final String fileName, final String outputCfgName) throws RuntimeIOException {
    if ((this.delegate instanceof EclipseResourceFileSystemAccess2)) {
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      return ((EclipseResourceFileSystemAccess2)this.delegate).readBinaryFile(fileName, outputCfgName, _nullProgressMonitor);
    }
    return this.delegate.readBinaryFile(fileName, outputCfgName);
  }
  
  @Override
  public InputStream readBinaryFile(final String fileName) throws RuntimeIOException {
    if ((this.delegate instanceof EclipseResourceFileSystemAccess2)) {
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      return ((EclipseResourceFileSystemAccess2)this.delegate).readBinaryFile(fileName, _nullProgressMonitor);
    }
    return this.delegate.readBinaryFile(fileName);
  }
  
  @Override
  public CharSequence readTextFile(final String fileName, final String outputCfgName) throws RuntimeIOException {
    if ((this.delegate instanceof EclipseResourceFileSystemAccess2)) {
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      return ((EclipseResourceFileSystemAccess2)this.delegate).readTextFile(fileName, outputCfgName, _nullProgressMonitor);
    }
    return this.delegate.readTextFile(fileName, outputCfgName);
  }
  
  @Override
  public CharSequence readTextFile(final String fileName) throws RuntimeIOException {
    if ((this.delegate instanceof EclipseResourceFileSystemAccess2)) {
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      return ((EclipseResourceFileSystemAccess2)this.delegate).readTextFile(fileName, _nullProgressMonitor);
    }
    return this.delegate.readTextFile(fileName);
  }
  
  /**
   * @since 2.9
   */
  @Override
  public boolean isFile(final String path, final String outputConfigurationName) throws RuntimeIOException {
    if ((this.delegate instanceof EclipseResourceFileSystemAccess2)) {
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      return ((EclipseResourceFileSystemAccess2)this.delegate).isFile(path, outputConfigurationName, _nullProgressMonitor);
    }
    return this.delegate.isFile(path, outputConfigurationName);
  }
  
  /**
   * @since 2.9
   */
  @Override
  public boolean isFile(final String path) throws RuntimeIOException {
    if ((this.delegate instanceof EclipseResourceFileSystemAccess2)) {
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      return ((EclipseResourceFileSystemAccess2)this.delegate).isFile(path, _nullProgressMonitor);
    }
    return this.delegate.isFile(path);
  }
}
