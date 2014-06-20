package org.eclipse.xtext.builder;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

/**
 * @author Anton Kosyakov
 * @since 2.7
 */
@SuppressWarnings("all")
public class FileSystemAccessRequest {
  public IResourceDescription.Delta delta;
  
  public Procedure2<? super IFileSystemAccess, ? super IProgressMonitor> procedure;
}
