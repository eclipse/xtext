package org.eclipse.xtext.builder;

import com.google.common.base.Objects;
import java.io.InputStream;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.builder.FileSystemAccessQueue;
import org.eclipse.xtext.generator.AbstractFileSystemAccess;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IFileSystemAccessExtension;
import org.eclipse.xtext.generator.IFileSystemAccessExtension2;
import org.eclipse.xtext.generator.IFileSystemAccessExtension3;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.util.RuntimeIOException;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

/**
 * @author Anton Kosyakov
 * @since 2.7
 */
@SuppressWarnings("all")
public class ParallelFileSystemAccess implements IFileSystemAccess, IFileSystemAccessExtension, IFileSystemAccessExtension2, IFileSystemAccessExtension3 {
  private IResourceDescription.Delta delta;
  
  private String sourceFolder;
  
  private EclipseResourceFileSystemAccess2.IFileCallback fileCallback;
  
  private IFileSystemAccess delegate;
  
  private FileSystemAccessQueue fileSystemAccessQueue;
  
  public ParallelFileSystemAccess(final IFileSystemAccess delegate, final IResourceDescription.Delta delta, final FileSystemAccessQueue fileSystemAccessQueue, final String sourceFolder, final EclipseResourceFileSystemAccess2.IFileCallback fileCallback) {
    this.delta = delta;
    this.delegate = delegate;
    this.fileCallback = fileCallback;
    this.sourceFolder = sourceFolder;
    this.fileSystemAccessQueue = fileSystemAccessQueue;
  }
  
  protected <T extends Object> void put(final Procedure2<? super T, ? super IProgressMonitor> procedure) {
    final Procedure2<IFileSystemAccess, IProgressMonitor> _function = new Procedure2<IFileSystemAccess, IProgressMonitor>() {
      public void apply(final IFileSystemAccess access, final IProgressMonitor monitor) {
        if ((access instanceof EclipseResourceFileSystemAccess2)) {
          ((EclipseResourceFileSystemAccess2)access).setPostProcessor(ParallelFileSystemAccess.this.fileCallback);
        }
        boolean _notEquals = (!Objects.equal(ParallelFileSystemAccess.this.sourceFolder, null));
        if (_notEquals) {
          if ((access instanceof AbstractFileSystemAccess)) {
            ((AbstractFileSystemAccess)access).setCurrentSource(ParallelFileSystemAccess.this.sourceFolder);
          }
        }
        procedure.apply(((T) access), monitor);
      }
    };
    this.fileSystemAccessQueue.put(this.delta, _function);
  }
  
  public void deleteFile(final String fileName) {
    final Procedure2<IFileSystemAccess, IProgressMonitor> _function = new Procedure2<IFileSystemAccess, IProgressMonitor>() {
      public void apply(final IFileSystemAccess access, final IProgressMonitor monitor) {
        access.deleteFile(fileName);
      }
    };
    this.<IFileSystemAccess>put(_function);
  }
  
  public void generateFile(final String fileName, final CharSequence contents) {
    final Procedure2<IFileSystemAccess, IProgressMonitor> _function = new Procedure2<IFileSystemAccess, IProgressMonitor>() {
      public void apply(final IFileSystemAccess access, final IProgressMonitor monitor) {
        access.generateFile(fileName, contents);
      }
    };
    this.<IFileSystemAccess>put(_function);
  }
  
  public void generateFile(final String fileName, final String outputConfigurationName, final CharSequence contents) {
    final Procedure2<IFileSystemAccess, IProgressMonitor> _function = new Procedure2<IFileSystemAccess, IProgressMonitor>() {
      public void apply(final IFileSystemAccess access, final IProgressMonitor monitor) {
        access.generateFile(fileName, outputConfigurationName, contents);
      }
    };
    this.<IFileSystemAccess>put(_function);
  }
  
  public void deleteFile(final String fileName, final String outputConfigurationName) {
    final Procedure2<IFileSystemAccessExtension, IProgressMonitor> _function = new Procedure2<IFileSystemAccessExtension, IProgressMonitor>() {
      public void apply(final IFileSystemAccessExtension access, final IProgressMonitor monitor) {
        access.deleteFile(fileName, outputConfigurationName);
      }
    };
    this.<IFileSystemAccessExtension>put(_function);
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
    final Procedure2<IFileSystemAccessExtension3, IProgressMonitor> _function = new Procedure2<IFileSystemAccessExtension3, IProgressMonitor>() {
      public void apply(final IFileSystemAccessExtension3 access, final IProgressMonitor monitor) {
        access.generateFile(fileName, outputCfgName, content);
      }
    };
    this.<IFileSystemAccessExtension3>put(_function);
  }
  
  public void generateFile(final String fileName, final InputStream content) throws RuntimeIOException {
    final Procedure2<IFileSystemAccessExtension3, IProgressMonitor> _function = new Procedure2<IFileSystemAccessExtension3, IProgressMonitor>() {
      public void apply(final IFileSystemAccessExtension3 access, final IProgressMonitor monitor) {
        access.generateFile(fileName, content);
      }
    };
    this.<IFileSystemAccessExtension3>put(_function);
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
