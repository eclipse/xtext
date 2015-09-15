package org.eclipse.xtext.xtext.wizard;

import com.google.common.collect.Iterables;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtext.wizard.ExternalDependency;
import org.eclipse.xtext.xtext.wizard.Scope;
import org.eclipse.xtext.xtext.wizard.TestProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.TestedProjectDescriptor;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class UiTestProjectDescriptor extends TestProjectDescriptor {
  @Override
  public Set<ExternalDependency> getExternalDependencies() {
    HashSet<ExternalDependency> _xblockexpression = null;
    {
      final HashSet<ExternalDependency> deps = CollectionLiterals.<ExternalDependency>newHashSet();
      Set<ExternalDependency> _externalDependencies = super.getExternalDependencies();
      Iterables.<ExternalDependency>addAll(deps, _externalDependencies);
      ExternalDependency _createXtextDependency = ExternalDependency.createXtextDependency("org.eclipse.xtext.junit4");
      final Procedure1<ExternalDependency> _function = new Procedure1<ExternalDependency>() {
        @Override
        public void apply(final ExternalDependency it) {
          ExternalDependency.MavenCoordinates _maven = it.getMaven();
          _maven.setScope(Scope.TESTCOMPILE);
        }
      };
      ExternalDependency _doubleArrow = ObjectExtensions.<ExternalDependency>operator_doubleArrow(_createXtextDependency, _function);
      deps.add(_doubleArrow);
      ExternalDependency _createXtextDependency_1 = ExternalDependency.createXtextDependency("org.eclipse.xtext.xbase.junit");
      final Procedure1<ExternalDependency> _function_1 = new Procedure1<ExternalDependency>() {
        @Override
        public void apply(final ExternalDependency it) {
          ExternalDependency.MavenCoordinates _maven = it.getMaven();
          _maven.setScope(Scope.TESTCOMPILE);
        }
      };
      ExternalDependency _doubleArrow_1 = ObjectExtensions.<ExternalDependency>operator_doubleArrow(_createXtextDependency_1, _function_1);
      deps.add(_doubleArrow_1);
      _xblockexpression = deps;
    }
    return _xblockexpression;
  }
  
  @Override
  public boolean isPartOfGradleBuild() {
    return false;
  }
  
  @Override
  public boolean isPartOfMavenBuild() {
    return true;
  }
  
  public UiTestProjectDescriptor(final TestedProjectDescriptor testedProject) {
    super(testedProject);
  }
}
