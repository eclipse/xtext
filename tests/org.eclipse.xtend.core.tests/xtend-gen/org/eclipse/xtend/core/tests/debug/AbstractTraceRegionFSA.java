package org.eclipse.xtend.core.tests.debug;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IFileSystemAccessExtension;
import org.eclipse.xtext.generator.IFileSystemAccessExtension2;

@SuppressWarnings("all")
public class AbstractTraceRegionFSA implements IFileSystemAccessExtension2, IFileSystemAccessExtension, IFileSystemAccess {
  public URI getURI(final String fileName, final String outputConfiguration) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
  }
  
  public URI getURI(final String fileName) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
  }
  
  public void deleteFile(final String fileName, final String outputConfigurationName) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
  }
  
  public void deleteFile(final String fileName) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
  }
  
  public void generateFile(final String fileName, final CharSequence contents) {
    this.charSequence = contents;
  }
  
  public void generateFile(final String fileName, final String outputConfigurationName, final CharSequence contents) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
  }
  
  public CharSequence charSequence;
}
