/**
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.wizard;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtext.wizard.BuildSystem;
import org.eclipse.xtext.xtext.wizard.ExternalDependency;
import org.eclipse.xtext.xtext.wizard.Scope;
import org.eclipse.xtext.xtext.wizard.TestProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.TestedProjectDescriptor;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class RuntimeTestProjectDescriptor extends TestProjectDescriptor {
  @Override
  public Set<ExternalDependency> getExternalDependencies() {
    LinkedHashSet<ExternalDependency> _xblockexpression = null;
    {
      final LinkedHashSet<ExternalDependency> deps = CollectionLiterals.<ExternalDependency>newLinkedHashSet();
      Set<ExternalDependency> _externalDependencies = super.getExternalDependencies();
      Iterables.<ExternalDependency>addAll(deps, _externalDependencies);
      ExternalDependency _createXtextDependency = ExternalDependency.createXtextDependency("org.eclipse.xtext.testing");
      final Procedure1<ExternalDependency> _function = (ExternalDependency it) -> {
        ExternalDependency.MavenCoordinates _maven = it.getMaven();
        _maven.setScope(Scope.TESTCOMPILE);
      };
      ExternalDependency _doubleArrow = ObjectExtensions.<ExternalDependency>operator_doubleArrow(_createXtextDependency, _function);
      deps.add(_doubleArrow);
      ExternalDependency _createXtextDependency_1 = ExternalDependency.createXtextDependency("org.eclipse.xtext.xbase.testing");
      final Procedure1<ExternalDependency> _function_1 = (ExternalDependency it) -> {
        ExternalDependency.MavenCoordinates _maven = it.getMaven();
        _maven.setScope(Scope.TESTCOMPILE);
      };
      ExternalDependency _doubleArrow_1 = ObjectExtensions.<ExternalDependency>operator_doubleArrow(_createXtextDependency_1, _function_1);
      deps.add(_doubleArrow_1);
      _xblockexpression = deps;
    }
    return _xblockexpression;
  }
  
  @Override
  public boolean isPartOfGradleBuild() {
    BuildSystem _preferredBuildSystem = this.getConfig().getPreferredBuildSystem();
    return Objects.equal(_preferredBuildSystem, BuildSystem.GRADLE);
  }
  
  @Override
  public boolean isPartOfMavenBuild() {
    BuildSystem _preferredBuildSystem = this.getConfig().getPreferredBuildSystem();
    return Objects.equal(_preferredBuildSystem, BuildSystem.MAVEN);
  }
  
  public RuntimeTestProjectDescriptor(final TestedProjectDescriptor testedProject) {
    super(testedProject);
  }
}
