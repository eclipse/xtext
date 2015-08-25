package org.eclipse.xtext.xtext.wizard;

import java.nio.charset.Charset;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.wizard.GeneratedFile;
import org.eclipse.xtext.xtext.wizard.Outlet;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.WizardConfiguration;

@FinalFieldsConstructor
@SuppressWarnings("all")
public abstract class TextFile extends GeneratedFile {
  @Accessors
  private final ProjectDescriptor project;
  
  @Override
  public byte[] getBytes() {
    CharSequence _content = this.getContent();
    String _string = _content.toString();
    WizardConfiguration _config = this.project.getConfig();
    Charset _encoding = _config.getEncoding();
    return _string.getBytes(_encoding);
  }
  
  public abstract CharSequence getContent();
  
  public TextFile(final Outlet outlet, final String relativePath, final ProjectDescriptor project) {
    super(outlet, relativePath);
    this.project = project;
  }
  
  @Pure
  public ProjectDescriptor getProject() {
    return this.project;
  }
}
