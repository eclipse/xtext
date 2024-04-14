/**
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.refactoring;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Objects;
import java.util.function.Consumer;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class DependentElementsCalculatorTests extends AbstractXtendUITestCase {
  @Inject
  private IDependentElementsCalculator dependentElementsCalculator;

  @Inject
  @Extension
  private IXtendJvmAssociations associations;

  @Inject
  private WorkbenchTestHelper testHelper;

  @Test
  public void testDependentElements() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def Foo foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Foo()");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.testHelper.xtendFile("Foo", _builder.toString());
      XtendTypeDeclaration _get = file.getXtendTypes().get(0);
      final XtendClass fooClass = ((XtendClass) _get);
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      final Iterable<URI> dependentElementURIs = this.dependentElementsCalculator.getDependentElementURIs(fooClass, _nullProgressMonitor);
      Assert.assertEquals(3, IterableExtensions.size(dependentElementURIs));
      XtendMember _get_1 = fooClass.getMembers().get(0);
      final XtendFunction fooFunction = ((XtendFunction) _get_1);
      final Consumer<EObject> _function = (EObject it) -> {
        final Function1<URI, Boolean> _function_1 = (URI element) -> {
          URI _uRI = EcoreUtil.getURI(it);
          return Boolean.valueOf(Objects.equals(element, _uRI));
        };
        Assert.assertTrue(it.toString(), IterableExtensions.<URI>exists(dependentElementURIs, _function_1));
      };
      CollectionLiterals.<EObject>newArrayList(fooFunction, this.associations.getInferredType(fooClass), this.associations.getInferredConstructor(fooClass)).forEach(_function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testPolymorphicDispatch() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Number it) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(String it) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile fooFile = this.testHelper.xtendFile("Foo", _builder.toString());
      IResourcesSetupUtil.waitForBuild();
      XtendTypeDeclaration _get = fooFile.getXtendTypes().get(0);
      final XtendClass fooClass = ((XtendClass) _get);
      final XtendMember fooMethod1 = fooClass.getMembers().get(1);
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      final Iterable<URI> dependentElementURIs = this.dependentElementsCalculator.getDependentElementURIs(fooMethod1, _nullProgressMonitor);
      Assert.assertEquals(5, IterableExtensions.size(dependentElementURIs));
      EList<XtendMember> _members = fooClass.getMembers();
      EList<JvmMember> _members_1 = this.associations.getInferredType(fooClass).getMembers();
      final Function1<EObject, Boolean> _function = (EObject it) -> {
        return Boolean.valueOf((!(it instanceof JvmConstructor)));
      };
      final Consumer<EObject> _function_1 = (EObject it) -> {
        final Function1<URI, Boolean> _function_2 = (URI element) -> {
          URI _uRI = EcoreUtil.getURI(it);
          return Boolean.valueOf(Objects.equals(element, _uRI));
        };
        Assert.assertTrue(it.toString(), IterableExtensions.<URI>exists(dependentElementURIs, _function_2));
      };
      IterableExtensions.<EObject>toList(IterableExtensions.<EObject>filter(Iterables.<EObject>concat(_members, _members_1), _function)).forEach(_function_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
