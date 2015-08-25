package org.eclipse.xtext.xtext.wizard;

import com.google.common.base.Objects;
import java.util.Collections;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.SourceLayout;
import org.eclipse.xtext.xtext.wizard.TestedProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.WizardConfiguration;

@SuppressWarnings("all")
public abstract class TestProjectDescriptor extends ProjectDescriptor {
  @Accessors
  private final ProjectDescriptor testedProject;
  
  public TestProjectDescriptor(final TestedProjectDescriptor testedProject) {
    super(testedProject.getConfig());
    this.testedProject = testedProject;
  }
  
  public boolean isInlined() {
    boolean _and = false;
    boolean _isEnabled = this.isEnabled();
    if (!_isEnabled) {
      _and = false;
    } else {
      WizardConfiguration _config = this.getConfig();
      SourceLayout _sourceLayout = _config.getSourceLayout();
      boolean _notEquals = (!Objects.equal(_sourceLayout, SourceLayout.PLAIN));
      _and = _notEquals;
    }
    return _and;
  }
  
  public boolean isSeparate() {
    boolean _and = false;
    boolean _isEnabled = this.isEnabled();
    if (!_isEnabled) {
      _and = false;
    } else {
      WizardConfiguration _config = this.getConfig();
      SourceLayout _sourceLayout = _config.getSourceLayout();
      boolean _equals = Objects.equal(_sourceLayout, SourceLayout.PLAIN);
      _and = _equals;
    }
    return _and;
  }
  
  @Override
  public String getNameQualifier() {
    String _nameQualifier = this.testedProject.getNameQualifier();
    return (_nameQualifier + ".tests");
  }
  
  @Override
  public Set<? extends ProjectDescriptor> getUpstreamProjects() {
    return Collections.<ProjectDescriptor>unmodifiableSet(CollectionLiterals.<ProjectDescriptor>newHashSet(this.testedProject));
  }
  
  @Pure
  public ProjectDescriptor getTestedProject() {
    return this.testedProject;
  }
}
