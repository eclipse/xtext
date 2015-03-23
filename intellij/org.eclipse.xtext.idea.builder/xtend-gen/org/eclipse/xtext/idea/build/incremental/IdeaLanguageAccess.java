package org.eclipse.xtext.idea.build.incremental;

import java.io.File;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtext.builder.standalone.LanguageAccess;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.idea.generator.IdeaJavaIoFileSystemAccess;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class IdeaLanguageAccess extends LanguageAccess {
  public IdeaLanguageAccess(final Set<OutputConfiguration> outputConfigurations, final IResourceServiceProvider resourceServiceProvider) {
    super(outputConfigurations, resourceServiceProvider, false);
  }
  
  public IdeaLanguageAccess(final Set<OutputConfiguration> outputConfigurations, final IResourceServiceProvider resourceServiceProvider, final boolean linksAgainstJavaTypes) {
    super(outputConfigurations, resourceServiceProvider, linksAgainstJavaTypes);
  }
  
  @Override
  public JavaIoFileSystemAccess createFileSystemAccess(final File baseDir) {
    IdeaJavaIoFileSystemAccess _get = this.resourceServiceProvider.<IdeaJavaIoFileSystemAccess>get(IdeaJavaIoFileSystemAccess.class);
    final Procedure1<IdeaJavaIoFileSystemAccess> _function = new Procedure1<IdeaJavaIoFileSystemAccess>() {
      @Override
      public void apply(final IdeaJavaIoFileSystemAccess it) {
        JavaIoFileSystemAccess _createFileSystemAccess = IdeaLanguageAccess.super.createFileSystemAccess(baseDir);
        Map<String, OutputConfiguration> _outputConfigurations = _createFileSystemAccess.getOutputConfigurations();
        it.setOutputConfigurations(_outputConfigurations);
      }
    };
    return ObjectExtensions.<IdeaJavaIoFileSystemAccess>operator_doubleArrow(_get, _function);
  }
}
