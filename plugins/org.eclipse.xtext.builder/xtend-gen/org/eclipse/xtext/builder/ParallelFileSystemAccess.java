package org.eclipse.xtext.builder;

import com.google.common.base.Objects;
import java.io.InputStream;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.generator.AbstractFileSystemAccess;
import org.eclipse.xtext.generator.FileSystemAccessQueue;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IFileSystemAccessExtension;
import org.eclipse.xtext.generator.IFileSystemAccessExtension2;
import org.eclipse.xtext.generator.IFileSystemAccessExtension3;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.util.RuntimeIOException;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Anton Kosyakov
 * @since 2.7
 */
@SuppressWarnings("all")
public class ParallelFileSystemAccess implements IFileSystemAccess, IFileSystemAccessExtension, IFileSystemAccessExtension2, IFileSystemAccessExtension3 {
  private IResourceDescription.Delta delta;
  
  private String sourceFolder;
  
  private IFileSystemAccess delegate;
  
  private FileSystemAccessQueue fileSystemAccessQueue;
  
  private EclipseResourceFileSystemAccess2.IFileCallback fileCallback;
  
  public ParallelFileSystemAccess(final IFileSystemAccess delegate, final IResourceDescription.Delta delta, final FileSystemAccessQueue fileSystemAccessQueue, final String sourceFolder, final EclipseResourceFileSystemAccess2.IFileCallback fileCallback) {
    this.delta = delta;
    this.delegate = delegate;
    this.fileCallback = fileCallback;
    this.sourceFolder = sourceFolder;
    this.fileSystemAccessQueue = fileSystemAccessQueue;
  }
  
  protected <T extends Object> void sendAsync(final Procedure1<? super T> procedure) {
    URI _uri = this.delta.getUri();
    final Procedure0 _function = new Procedure0() {
      public void apply() {
        if ((ParallelFileSystemAccess.this.delegate instanceof EclipseResourceFileSystemAccess2)) {
          ((EclipseResourceFileSystemAccess2)ParallelFileSystemAccess.this.delegate).setPostProcessor(ParallelFileSystemAccess.this.fileCallback);
        }
        boolean _notEquals = (!Objects.equal(ParallelFileSystemAccess.this.sourceFolder, null));
        if (_notEquals) {
          if ((ParallelFileSystemAccess.this.delegate instanceof AbstractFileSystemAccess)) {
            ((AbstractFileSystemAccess)ParallelFileSystemAccess.this.delegate).setCurrentSource(ParallelFileSystemAccess.this.sourceFolder);
          }
        }
        procedure.apply(((T) ParallelFileSystemAccess.this.delegate));
      }
    };
    this.fileSystemAccessQueue.sendAsync(_uri, _function);
  }
  
  public void deleteFile(final String fileName) {
    final Procedure1<IFileSystemAccess> _function = new Procedure1<IFileSystemAccess>() {
      public void apply(final IFileSystemAccess access) {
        access.deleteFile(fileName);
      }
    };
    this.<IFileSystemAccess>sendAsync(_function);
  }
  
  public void generateFile(final String fileName, final CharSequence contents) {
    final Procedure1<IFileSystemAccess> _function = new Procedure1<IFileSystemAccess>() {
      public void apply(final IFileSystemAccess access) {
        access.generateFile(fileName, contents);
      }
    };
    this.<IFileSystemAccess>sendAsync(_function);
  }
  
  public void generateFile(final String fileName, final String outputConfigurationName, final CharSequence contents) {
    final Procedure1<IFileSystemAccess> _function = new Procedure1<IFileSystemAccess>() {
      public void apply(final IFileSystemAccess access) {
        access.generateFile(fileName, outputConfigurationName, contents);
      }
    };
    this.<IFileSystemAccess>sendAsync(_function);
  }
  
  public void deleteFile(final String fileName, final String outputConfigurationName) {
    final Procedure1<IFileSystemAccessExtension> _function = new Procedure1<IFileSystemAccessExtension>() {
      public void apply(final IFileSystemAccessExtension access) {
        access.deleteFile(fileName, outputConfigurationName);
      }
    };
    this.<IFileSystemAccessExtension>sendAsync(_function);
  }
  
  public URI getURI(final String fileName, final String outputConfiguration) {
    if ((this.delegate instanceof EclipseResourceFileSystemAccess2)) {
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      return ((EclipseResourceFileSystemAccess2)this.delegate).getURI(fileName, outputConfiguration, _nullProgressMonitor);
    }
    return ((IFileSystemAccessExtension2) this.delegate).getURI(fileName, outputConfiguration);
  }
  
  public URI getURI(final String fileName) {
    if ((this.delegate instanceof EclipseResourceFileSystemAccess2)) {
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      return ((EclipseResourceFileSystemAccess2)this.delegate).getURI(fileName, _nullProgressMonitor);
    }
    return ((IFileSystemAccessExtension2) this.delegate).getURI(fileName);
  }
  
  public void generateFile(final String fileName, final String outputCfgName, final InputStream content) throws RuntimeIOException {
    final Procedure1<IFileSystemAccessExtension3> _function = new Procedure1<IFileSystemAccessExtension3>() {
      public void apply(final IFileSystemAccessExtension3 access) {
        access.generateFile(fileName, outputCfgName, content);
      }
    };
    this.<IFileSystemAccessExtension3>sendAsync(_function);
  }
  
  public void generateFile(final String fileName, final InputStream content) throws RuntimeIOException {
    final Procedure1<IFileSystemAccessExtension3> _function = new Procedure1<IFileSystemAccessExtension3>() {
      public void apply(final IFileSystemAccessExtension3 access) {
        access.generateFile(fileName, content);
      }
    };
    this.<IFileSystemAccessExtension3>sendAsync(_function);
  }
  
  public InputStream readBinaryFile(final String fileName, final String outputCfgName) throws RuntimeIOException {
    if ((this.delegate instanceof EclipseResourceFileSystemAccess2)) {
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      return ((EclipseResourceFileSystemAccess2)this.delegate).readBinaryFile(fileName, outputCfgName, _nullProgressMonitor);
    }
    return ((IFileSystemAccessExtension3) this.delegate).readBinaryFile(fileName, outputCfgName);
  }
  
  public InputStream readBinaryFile(final String fileName) throws RuntimeIOException {
    if ((this.delegate instanceof EclipseResourceFileSystemAccess2)) {
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      return ((EclipseResourceFileSystemAccess2)this.delegate).readBinaryFile(fileName, _nullProgressMonitor);
    }
    return ((IFileSystemAccessExtension3) this.delegate).readBinaryFile(fileName);
  }
  
  public CharSequence readTextFile(final String fileName, final String outputCfgName) throws RuntimeIOException {
    if ((this.delegate instanceof EclipseResourceFileSystemAccess2)) {
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      return ((EclipseResourceFileSystemAccess2)this.delegate).readTextFile(fileName, outputCfgName, _nullProgressMonitor);
    }
    return ((IFileSystemAccessExtension3) this.delegate).readTextFile(fileName, outputCfgName);
  }
  
  public CharSequence readTextFile(final String fileName) throws RuntimeIOException {
    if ((this.delegate instanceof EclipseResourceFileSystemAccess2)) {
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      return ((EclipseResourceFileSystemAccess2)this.delegate).readTextFile(fileName, _nullProgressMonitor);
    }
    return ((IFileSystemAccessExtension3) this.delegate).readTextFile(fileName);
  }
}
