package org.eclipse.xtend.core.tests.debug;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IFileSystemAccessExtension;
import org.eclipse.xtext.generator.IFileSystemAccessExtension2;

@SuppressWarnings("all")
public class AbstractTraceRegionFSA implements IFileSystemAccessExtension2, IFileSystemAccessExtension, IFileSystemAccess {
  public URI getURI(final String fileName, final String outputConfiguration) {
    throw new UnsupportedOperationException("Auto-generated function stub");
  }
  
  public URI getURI(final String fileName) {
    throw new UnsupportedOperationException("Auto-generated function stub");
  }
  
  public void deleteFile(final String fileName, final String outputConfigurationName) {
    throw new UnsupportedOperationException("Auto-generated function stub");
  }
  
  public void deleteFile(final String fileName) {
    throw new UnsupportedOperationException("Auto-generated function stub");
  }
  
  public void generateFile(final String fileName, final CharSequence contents) {
    this.charSequence = contents;
  }
  
  public void generateFile(final String fileName, final String outputConfigurationName, final CharSequence contents) {
    throw new UnsupportedOperationException("Auto-generated function stub");
  }
  
  public CharSequence charSequence;
}
