package org.eclipse.xtext.xtext.generator.model;

import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xtext.generator.IGuiceAwareGeneratorComponent;

@SuppressWarnings("all")
public interface IXtextGeneratorFileSystemAccess extends IFileSystemAccess2, IGuiceAwareGeneratorComponent {
  public abstract String getPath();
  
  public abstract boolean isOverwrite();
}
