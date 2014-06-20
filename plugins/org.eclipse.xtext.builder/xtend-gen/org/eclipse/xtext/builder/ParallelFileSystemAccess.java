package org.eclipse.xtext.builder;

import com.google.common.base.Objects;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.builder.FileSystemAccessQueue;
import org.eclipse.xtext.generator.AbstractFileSystemAccess;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

/**
 * @author Anton Kosyakov
 * @since 2.7
 */
@SuppressWarnings("all")
public class ParallelFileSystemAccess implements IFileSystemAccess {
  private IResourceDescription.Delta delta;
  
  private String sourceFolder;
  
  private EclipseResourceFileSystemAccess2.IFileCallback fileCallback;
  
  private FileSystemAccessQueue fileSystemAccessQueue;
  
  public ParallelFileSystemAccess(final IResourceDescription.Delta delta, final FileSystemAccessQueue fileSystemAccessQueue, final String sourceFolder, final EclipseResourceFileSystemAccess2.IFileCallback fileCallback) {
    this.delta = delta;
    this.fileCallback = fileCallback;
    this.sourceFolder = sourceFolder;
    this.fileSystemAccessQueue = fileSystemAccessQueue;
  }
  
  public void deleteFile(final String fileName) {
    final Procedure2<IFileSystemAccess, IProgressMonitor> _function = new Procedure2<IFileSystemAccess, IProgressMonitor>() {
      public void apply(final IFileSystemAccess access, final IProgressMonitor monitor) {
        boolean _matched = false;
        if (!_matched) {
          if (access instanceof EclipseResourceFileSystemAccess2) {
            _matched=true;
            ((EclipseResourceFileSystemAccess2)access).setCurrentSource(ParallelFileSystemAccess.this.sourceFolder);
          }
        }
        boolean _notEquals = (!Objects.equal(ParallelFileSystemAccess.this.sourceFolder, null));
        if (_notEquals) {
          boolean _matched_1 = false;
          if (!_matched_1) {
            if (access instanceof AbstractFileSystemAccess) {
              _matched_1=true;
              ((AbstractFileSystemAccess)access).setCurrentSource(ParallelFileSystemAccess.this.sourceFolder);
            }
          }
        }
        access.deleteFile(fileName);
      }
    };
    this.fileSystemAccessQueue.put(this.delta, _function);
  }
  
  public void generateFile(final String fileName, final CharSequence contents) {
    final Procedure2<IFileSystemAccess, IProgressMonitor> _function = new Procedure2<IFileSystemAccess, IProgressMonitor>() {
      public void apply(final IFileSystemAccess access, final IProgressMonitor monitor) {
        boolean _matched = false;
        if (!_matched) {
          if (access instanceof EclipseResourceFileSystemAccess2) {
            _matched=true;
            ((EclipseResourceFileSystemAccess2)access).setPostProcessor(ParallelFileSystemAccess.this.fileCallback);
          }
        }
        boolean _notEquals = (!Objects.equal(ParallelFileSystemAccess.this.sourceFolder, null));
        if (_notEquals) {
          boolean _matched_1 = false;
          if (!_matched_1) {
            if (access instanceof AbstractFileSystemAccess) {
              _matched_1=true;
              ((AbstractFileSystemAccess)access).setCurrentSource(ParallelFileSystemAccess.this.sourceFolder);
            }
          }
        }
        access.generateFile(fileName, contents);
      }
    };
    this.fileSystemAccessQueue.put(this.delta, _function);
  }
  
  public void generateFile(final String fileName, final String outputConfigurationName, final CharSequence contents) {
    final Procedure2<IFileSystemAccess, IProgressMonitor> _function = new Procedure2<IFileSystemAccess, IProgressMonitor>() {
      public void apply(final IFileSystemAccess access, final IProgressMonitor monitor) {
        boolean _matched = false;
        if (!_matched) {
          if (access instanceof EclipseResourceFileSystemAccess2) {
            _matched=true;
            ((EclipseResourceFileSystemAccess2)access).setPostProcessor(ParallelFileSystemAccess.this.fileCallback);
          }
        }
        boolean _notEquals = (!Objects.equal(ParallelFileSystemAccess.this.sourceFolder, null));
        if (_notEquals) {
          boolean _matched_1 = false;
          if (!_matched_1) {
            if (access instanceof AbstractFileSystemAccess) {
              _matched_1=true;
              ((AbstractFileSystemAccess)access).setCurrentSource(ParallelFileSystemAccess.this.sourceFolder);
            }
          }
        }
        access.generateFile(fileName, outputConfigurationName, contents);
      }
    };
    this.fileSystemAccessQueue.put(this.delta, _function);
  }
}
