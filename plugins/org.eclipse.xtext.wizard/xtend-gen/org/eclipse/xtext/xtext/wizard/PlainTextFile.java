package org.eclipse.xtext.xtext.wizard;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.wizard.Outlet;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.TextFile;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class PlainTextFile extends TextFile {
  @Accessors
  private final CharSequence content;
  
  public PlainTextFile(final Outlet outlet, final String relativePath, final ProjectDescriptor project, final CharSequence content) {
    super(outlet, relativePath, project);
    this.content = content;
  }
  
  @Pure
  public CharSequence getContent() {
    return this.content;
  }
}
