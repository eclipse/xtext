package org.eclipse.xtext.xtext.wizard;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.wizard.Outlet;

@FinalFieldsConstructor
@SuppressWarnings("all")
public abstract class GeneratedFile {
  @Accessors
  private final Outlet outlet;
  
  @Accessors
  private final String relativePath;
  
  public abstract byte[] getBytes();
  
  public GeneratedFile(final Outlet outlet, final String relativePath) {
    super();
    this.outlet = outlet;
    this.relativePath = relativePath;
  }
  
  @Pure
  public Outlet getOutlet() {
    return this.outlet;
  }
  
  @Pure
  public String getRelativePath() {
    return this.relativePath;
  }
}
