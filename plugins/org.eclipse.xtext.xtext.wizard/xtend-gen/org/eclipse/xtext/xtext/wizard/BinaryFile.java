package org.eclipse.xtext.xtext.wizard;

import java.net.URL;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.xtext.wizard.AbstractFile;
import org.eclipse.xtext.xtext.wizard.Outlet;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class BinaryFile extends AbstractFile {
  @Accessors
  private final URL content;
  
  public URL getContent() {
    return this.content;
  }
  
  public BinaryFile(final Outlet outlet, final String relativePath, final ProjectDescriptor project, final boolean executable, final URL content) {
    super(outlet, relativePath, project, executable);
    this.content = content;
  }
}
