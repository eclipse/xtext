package org.eclipse.xtext.xtext.wizard;

import java.util.Collections;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtext.wizard.GradleBuildFile;
import org.eclipse.xtext.xtext.wizard.IdeProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.Outlet;
import org.eclipse.xtext.xtext.wizard.PomFile;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.RuntimeProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.WizardConfiguration;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class IntellijProjectDescriptor extends ProjectDescriptor {
  @Override
  public String getNameQualifier() {
    return ".idea";
  }
  
  @Override
  public Set<? extends ProjectDescriptor> getUpstreamProjects() {
    WizardConfiguration _config = this.getConfig();
    RuntimeProjectDescriptor _runtimeProject = _config.getRuntimeProject();
    WizardConfiguration _config_1 = this.getConfig();
    IdeProjectDescriptor _ideProject = _config_1.getIdeProject();
    return Collections.<ProjectDescriptor>unmodifiableSet(CollectionLiterals.<ProjectDescriptor>newHashSet(_runtimeProject, _ideProject));
  }
  
  @Override
  public Set<String> getSourceFolders() {
    final Function1<Outlet, String> _function = new Function1<Outlet, String>() {
      @Override
      public String apply(final Outlet it) {
        return IntellijProjectDescriptor.this.sourceFolder(it);
      }
    };
    Iterable<String> _map = IterableExtensions.<Outlet, String>map(Collections.<Outlet>unmodifiableSet(CollectionLiterals.<Outlet>newHashSet(Outlet.MAIN_JAVA, Outlet.MAIN_RESOURCES)), _function);
    return IterableExtensions.<String>toSet(_map);
  }
  
  @Override
  public GradleBuildFile buildGradle() {
    GradleBuildFile _buildGradle = super.buildGradle();
    final Procedure1<GradleBuildFile> _function = new Procedure1<GradleBuildFile>() {
      @Override
      public void apply(final GradleBuildFile it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("plugins {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("id \'org.xtext.idea-plugin\' version \'0.3.17\'");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        it.setPluginsSection(_builder.toString());
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("ideaDevelopment {");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("ideaVersion = \'141.814.3\'");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("pluginRepositories {");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("url \'http://download.eclipse.org/modeling/tmf/xtext/idea/");
        WizardConfiguration _config = IntellijProjectDescriptor.this.getConfig();
        String _xtextVersion = _config.getXtextVersion();
        _builder_1.append(_xtextVersion, "\t\t");
        _builder_1.append("/updatePlugins.xml\'");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("\t");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("pluginDependencies {");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("id \'org.eclipse.xtext.idea\' version \'");
        WizardConfiguration _config_1 = IntellijProjectDescriptor.this.getConfig();
        String _xtextVersion_1 = _config_1.getXtextVersion();
        _builder_1.append(_xtextVersion_1, "\t\t");
        _builder_1.append("\'");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("\t");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        it.setAdditionalContent(_builder_1.toString());
      }
    };
    return ObjectExtensions.<GradleBuildFile>operator_doubleArrow(_buildGradle, _function);
  }
  
  @Override
  public PomFile pom() {
    throw new UnsupportedOperationException("IntelliJ projects cannot be built with Maven");
  }
  
  public IntellijProjectDescriptor(final WizardConfiguration config) {
    super(config);
  }
}
