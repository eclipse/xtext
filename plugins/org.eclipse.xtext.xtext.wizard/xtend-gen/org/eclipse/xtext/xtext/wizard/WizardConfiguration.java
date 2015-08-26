package org.eclipse.xtext.xtext.wizard;

import com.google.common.collect.Iterables;
import java.nio.charset.Charset;
import java.util.Collections;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.wizard.BuildSystem;
import org.eclipse.xtext.xtext.wizard.IdeProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.IntellijProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.LanguageDescriptor;
import org.eclipse.xtext.xtext.wizard.ParentProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.ProjectLayout;
import org.eclipse.xtext.xtext.wizard.RuntimeProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.SourceLayout;
import org.eclipse.xtext.xtext.wizard.TargetPlatformProject;
import org.eclipse.xtext.xtext.wizard.TestProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.TestedProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.UiProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.WebProjectDescriptor;

@Accessors
@SuppressWarnings("all")
public class WizardConfiguration {
  private String rootLocation;
  
  private String baseName;
  
  private String xtextVersion = "2.8.4";
  
  private Charset encoding = Charset.defaultCharset();
  
  private BuildSystem buildSystem = BuildSystem.ECLIPSE;
  
  private SourceLayout sourceLayout = SourceLayout.PLAIN;
  
  private ProjectLayout projectLayout = ProjectLayout.FLAT;
  
  private final LanguageDescriptor language = new LanguageDescriptor();
  
  private final RuntimeProjectDescriptor runtimeProject = new RuntimeProjectDescriptor(this);
  
  private final IdeProjectDescriptor ideProject = new IdeProjectDescriptor(this);
  
  private final UiProjectDescriptor uiProject = new UiProjectDescriptor(this);
  
  private final IntellijProjectDescriptor intellijProject = new IntellijProjectDescriptor(this);
  
  private final WebProjectDescriptor webProject = new WebProjectDescriptor(this);
  
  private final ParentProjectDescriptor parentProject = new ParentProjectDescriptor(this);
  
  private final TargetPlatformProject targetPlatformProject = new TargetPlatformProject(this);
  
  public Iterable<ProjectDescriptor> getEnabledProjects() {
    Iterable<ProjectDescriptor> _xblockexpression = null;
    {
      final Function1<ProjectDescriptor, Boolean> _function = new Function1<ProjectDescriptor, Boolean>() {
        @Override
        public Boolean apply(final ProjectDescriptor it) {
          return Boolean.valueOf(it.isEnabled());
        }
      };
      final Iterable<? extends ProjectDescriptor> productionProjects = IterableExtensions.filter(Collections.<ProjectDescriptor>unmodifiableList(CollectionLiterals.<ProjectDescriptor>newArrayList(this.runtimeProject, this.ideProject, this.uiProject, this.intellijProject, this.webProject, this.parentProject, this.targetPlatformProject)), _function);
      Iterable<TestedProjectDescriptor> _filter = Iterables.<TestedProjectDescriptor>filter(productionProjects, TestedProjectDescriptor.class);
      final Function1<TestedProjectDescriptor, TestProjectDescriptor> _function_1 = new Function1<TestedProjectDescriptor, TestProjectDescriptor>() {
        @Override
        public TestProjectDescriptor apply(final TestedProjectDescriptor it) {
          return it.getTestProject();
        }
      };
      Iterable<TestProjectDescriptor> _map = IterableExtensions.<TestedProjectDescriptor, TestProjectDescriptor>map(_filter, _function_1);
      final Function1<TestProjectDescriptor, Boolean> _function_2 = new Function1<TestProjectDescriptor, Boolean>() {
        @Override
        public Boolean apply(final TestProjectDescriptor it) {
          boolean _and = false;
          boolean _isEnabled = it.isEnabled();
          if (!_isEnabled) {
            _and = false;
          } else {
            boolean _isSeparate = it.isSeparate();
            _and = _isSeparate;
          }
          return Boolean.valueOf(_and);
        }
      };
      final Iterable<TestProjectDescriptor> testProjects = IterableExtensions.<TestProjectDescriptor>filter(_map, _function_2);
      _xblockexpression = Iterables.<ProjectDescriptor>concat(productionProjects, testProjects);
    }
    return _xblockexpression;
  }
  
  @Pure
  public String getRootLocation() {
    return this.rootLocation;
  }
  
  public void setRootLocation(final String rootLocation) {
    this.rootLocation = rootLocation;
  }
  
  @Pure
  public String getBaseName() {
    return this.baseName;
  }
  
  public void setBaseName(final String baseName) {
    this.baseName = baseName;
  }
  
  @Pure
  public String getXtextVersion() {
    return this.xtextVersion;
  }
  
  public void setXtextVersion(final String xtextVersion) {
    this.xtextVersion = xtextVersion;
  }
  
  @Pure
  public Charset getEncoding() {
    return this.encoding;
  }
  
  public void setEncoding(final Charset encoding) {
    this.encoding = encoding;
  }
  
  @Pure
  public BuildSystem getBuildSystem() {
    return this.buildSystem;
  }
  
  public void setBuildSystem(final BuildSystem buildSystem) {
    this.buildSystem = buildSystem;
  }
  
  @Pure
  public SourceLayout getSourceLayout() {
    return this.sourceLayout;
  }
  
  public void setSourceLayout(final SourceLayout sourceLayout) {
    this.sourceLayout = sourceLayout;
  }
  
  @Pure
  public ProjectLayout getProjectLayout() {
    return this.projectLayout;
  }
  
  public void setProjectLayout(final ProjectLayout projectLayout) {
    this.projectLayout = projectLayout;
  }
  
  @Pure
  public LanguageDescriptor getLanguage() {
    return this.language;
  }
  
  @Pure
  public RuntimeProjectDescriptor getRuntimeProject() {
    return this.runtimeProject;
  }
  
  @Pure
  public IdeProjectDescriptor getIdeProject() {
    return this.ideProject;
  }
  
  @Pure
  public UiProjectDescriptor getUiProject() {
    return this.uiProject;
  }
  
  @Pure
  public IntellijProjectDescriptor getIntellijProject() {
    return this.intellijProject;
  }
  
  @Pure
  public WebProjectDescriptor getWebProject() {
    return this.webProject;
  }
  
  @Pure
  public ParentProjectDescriptor getParentProject() {
    return this.parentProject;
  }
  
  @Pure
  public TargetPlatformProject getTargetPlatformProject() {
    return this.targetPlatformProject;
  }
}
