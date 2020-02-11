/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtext.util.JUnitVersion;
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
      JUnitVersion _junitVersion = this.getConfig().getJunitVersion();
      boolean _equals = Objects.equal(_junitVersion, JUnitVersion.JUNIT_4);
      if (_equals) {
        ExternalDependency _createXtextDependency_2 = ExternalDependency.createXtextDependency("org.eclipse.xtext.junit4");
        final Procedure1<ExternalDependency> _function_2 = (ExternalDependency it) -> {
          ExternalDependency.MavenCoordinates _maven = it.getMaven();
          _maven.setScope(Scope.TESTCOMPILE);
        };
        ExternalDependency _doubleArrow_2 = ObjectExtensions.<ExternalDependency>operator_doubleArrow(_createXtextDependency_2, _function_2);
        deps.add(_doubleArrow_2);
      }
      ExternalDependency _createXtextDependency_3 = ExternalDependency.createXtextDependency("org.eclipse.xtext.xbase.junit");
      final Procedure1<ExternalDependency> _function_3 = (ExternalDependency it) -> {
        ExternalDependency.MavenCoordinates _maven = it.getMaven();
        _maven.setScope(Scope.TESTCOMPILE);
      };
      ExternalDependency _doubleArrow_3 = ObjectExtensions.<ExternalDependency>operator_doubleArrow(_createXtextDependency_3, _function_3);
      deps.add(_doubleArrow_3);
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
  
  @Override
  public boolean needsUiHarness() {
    return true;
  }
  
  public UiTestProjectDescriptor(final TestedProjectDescriptor testedProject) {
    super(testedProject);
  }
}
