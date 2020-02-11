/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.server.TopologicalSorter;
import org.eclipse.xtext.resource.impl.ProjectDescription;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class BuildOrderTest {
  @Test
  public void testChain() {
    ProjectDescription _projectDescription = new ProjectDescription();
    final Procedure1<ProjectDescription> _function = (ProjectDescription it) -> {
      it.setName("a");
      it.setDependencies(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("b")));
    };
    final ProjectDescription a = ObjectExtensions.<ProjectDescription>operator_doubleArrow(_projectDescription, _function);
    ProjectDescription _projectDescription_1 = new ProjectDescription();
    final Procedure1<ProjectDescription> _function_1 = (ProjectDescription it) -> {
      it.setName("b");
      it.setDependencies(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("c")));
    };
    final ProjectDescription b = ObjectExtensions.<ProjectDescription>operator_doubleArrow(_projectDescription_1, _function_1);
    ProjectDescription _projectDescription_2 = new ProjectDescription();
    final Procedure1<ProjectDescription> _function_2 = (ProjectDescription it) -> {
      it.setName("c");
      it.setDependencies(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("d")));
    };
    final ProjectDescription c = ObjectExtensions.<ProjectDescription>operator_doubleArrow(_projectDescription_2, _function_2);
    ProjectDescription _projectDescription_3 = new ProjectDescription();
    final Procedure1<ProjectDescription> _function_3 = (ProjectDescription it) -> {
      it.setName("d");
      it.setDependencies(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList()));
    };
    final ProjectDescription d = ObjectExtensions.<ProjectDescription>operator_doubleArrow(_projectDescription_3, _function_3);
    final Procedure1<ProjectDescription> _function_4 = (ProjectDescription it) -> {
      Assert.fail();
    };
    this.assertEquals(Collections.<ProjectDescription>unmodifiableList(CollectionLiterals.<ProjectDescription>newArrayList(d, c, b, a)), new TopologicalSorter().sortByDependencies(Collections.<ProjectDescription>unmodifiableList(CollectionLiterals.<ProjectDescription>newArrayList(a, b, c, d)), _function_4));
  }
  
  @Test
  public void testDiamond() {
    ProjectDescription _projectDescription = new ProjectDescription();
    final Procedure1<ProjectDescription> _function = (ProjectDescription it) -> {
      it.setName("a");
      it.setDependencies(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("b", "c")));
    };
    final ProjectDescription a = ObjectExtensions.<ProjectDescription>operator_doubleArrow(_projectDescription, _function);
    ProjectDescription _projectDescription_1 = new ProjectDescription();
    final Procedure1<ProjectDescription> _function_1 = (ProjectDescription it) -> {
      it.setName("b");
      it.setDependencies(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("c")));
    };
    final ProjectDescription b = ObjectExtensions.<ProjectDescription>operator_doubleArrow(_projectDescription_1, _function_1);
    ProjectDescription _projectDescription_2 = new ProjectDescription();
    final Procedure1<ProjectDescription> _function_2 = (ProjectDescription it) -> {
      it.setName("c");
      it.setDependencies(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("d")));
    };
    final ProjectDescription c = ObjectExtensions.<ProjectDescription>operator_doubleArrow(_projectDescription_2, _function_2);
    ProjectDescription _projectDescription_3 = new ProjectDescription();
    final Procedure1<ProjectDescription> _function_3 = (ProjectDescription it) -> {
      it.setName("d");
      it.setDependencies(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList()));
    };
    final ProjectDescription d = ObjectExtensions.<ProjectDescription>operator_doubleArrow(_projectDescription_3, _function_3);
    final Procedure1<ProjectDescription> _function_4 = (ProjectDescription it) -> {
      Assert.fail();
    };
    this.assertEquals(Collections.<ProjectDescription>unmodifiableList(CollectionLiterals.<ProjectDescription>newArrayList(d, c, b, a)), new TopologicalSorter().sortByDependencies(Collections.<ProjectDescription>unmodifiableList(CollectionLiterals.<ProjectDescription>newArrayList(a, b, c, d)), _function_4));
  }
  
  @Test
  public void testDiamond_1() {
    ProjectDescription _projectDescription = new ProjectDescription();
    final Procedure1<ProjectDescription> _function = (ProjectDescription it) -> {
      it.setName("a");
      it.setDependencies(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("b", "c", "d")));
    };
    final ProjectDescription a = ObjectExtensions.<ProjectDescription>operator_doubleArrow(_projectDescription, _function);
    ProjectDescription _projectDescription_1 = new ProjectDescription();
    final Procedure1<ProjectDescription> _function_1 = (ProjectDescription it) -> {
      it.setName("b");
      it.setDependencies(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("c")));
    };
    final ProjectDescription b = ObjectExtensions.<ProjectDescription>operator_doubleArrow(_projectDescription_1, _function_1);
    ProjectDescription _projectDescription_2 = new ProjectDescription();
    final Procedure1<ProjectDescription> _function_2 = (ProjectDescription it) -> {
      it.setName("c");
      it.setDependencies(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("d")));
    };
    final ProjectDescription c = ObjectExtensions.<ProjectDescription>operator_doubleArrow(_projectDescription_2, _function_2);
    ProjectDescription _projectDescription_3 = new ProjectDescription();
    final Procedure1<ProjectDescription> _function_3 = (ProjectDescription it) -> {
      it.setName("d");
      it.setDependencies(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList()));
    };
    final ProjectDescription d = ObjectExtensions.<ProjectDescription>operator_doubleArrow(_projectDescription_3, _function_3);
    final Procedure1<ProjectDescription> _function_4 = (ProjectDescription it) -> {
      Assert.fail();
    };
    this.assertEquals(Collections.<ProjectDescription>unmodifiableList(CollectionLiterals.<ProjectDescription>newArrayList(d, c, b, a)), new TopologicalSorter().sortByDependencies(Collections.<ProjectDescription>unmodifiableList(CollectionLiterals.<ProjectDescription>newArrayList(a, b, c, d)), _function_4));
  }
  
  @Test
  public void testJustOne() {
    ProjectDescription _projectDescription = new ProjectDescription();
    final Procedure1<ProjectDescription> _function = (ProjectDescription it) -> {
      it.setName("a");
      it.setDependencies(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("b")));
    };
    final ProjectDescription a = ObjectExtensions.<ProjectDescription>operator_doubleArrow(_projectDescription, _function);
    ProjectDescription _projectDescription_1 = new ProjectDescription();
    final Procedure1<ProjectDescription> _function_1 = (ProjectDescription it) -> {
      it.setName("b");
    };
    final ProjectDescription b = ObjectExtensions.<ProjectDescription>operator_doubleArrow(_projectDescription_1, _function_1);
    final Procedure1<ProjectDescription> _function_2 = (ProjectDescription it) -> {
      Assert.fail();
    };
    this.assertEquals(Collections.<ProjectDescription>unmodifiableList(CollectionLiterals.<ProjectDescription>newArrayList(a)), new TopologicalSorter().sortByDependencies(Collections.<ProjectDescription>unmodifiableList(CollectionLiterals.<ProjectDescription>newArrayList(a)), _function_2));
    final Procedure1<ProjectDescription> _function_3 = (ProjectDescription it) -> {
      Assert.fail();
    };
    this.assertEquals(Collections.<ProjectDescription>unmodifiableList(CollectionLiterals.<ProjectDescription>newArrayList(b)), new TopologicalSorter().sortByDependencies(Collections.<ProjectDescription>unmodifiableList(CollectionLiterals.<ProjectDescription>newArrayList(b)), _function_3));
  }
  
  @Test
  public void testCycle() {
    ProjectDescription _projectDescription = new ProjectDescription();
    final Procedure1<ProjectDescription> _function = (ProjectDescription it) -> {
      it.setName("a");
      it.setDependencies(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("b", "c")));
    };
    final ProjectDescription a = ObjectExtensions.<ProjectDescription>operator_doubleArrow(_projectDescription, _function);
    ProjectDescription _projectDescription_1 = new ProjectDescription();
    final Procedure1<ProjectDescription> _function_1 = (ProjectDescription it) -> {
      it.setName("b");
      it.setDependencies(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("c", "d")));
    };
    final ProjectDescription b = ObjectExtensions.<ProjectDescription>operator_doubleArrow(_projectDescription_1, _function_1);
    ProjectDescription _projectDescription_2 = new ProjectDescription();
    final Procedure1<ProjectDescription> _function_2 = (ProjectDescription it) -> {
      it.setName("c");
      it.setDependencies(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("d")));
    };
    final ProjectDescription c = ObjectExtensions.<ProjectDescription>operator_doubleArrow(_projectDescription_2, _function_2);
    ProjectDescription _projectDescription_3 = new ProjectDescription();
    final Procedure1<ProjectDescription> _function_3 = (ProjectDescription it) -> {
      it.setName("d");
      it.setDependencies(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("b")));
    };
    final ProjectDescription d = ObjectExtensions.<ProjectDescription>operator_doubleArrow(_projectDescription_3, _function_3);
    ProjectDescription _projectDescription_4 = new ProjectDescription();
    final Procedure1<ProjectDescription> _function_4 = (ProjectDescription it) -> {
      it.setName("e");
      it.setDependencies(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList()));
    };
    final ProjectDescription e = ObjectExtensions.<ProjectDescription>operator_doubleArrow(_projectDescription_4, _function_4);
    final ArrayList<ProjectDescription> cyclic = CollectionLiterals.<ProjectDescription>newArrayList();
    final Procedure1<ProjectDescription> _function_5 = (ProjectDescription it) -> {
      cyclic.add(it);
    };
    this.assertEquals(Collections.<ProjectDescription>unmodifiableList(CollectionLiterals.<ProjectDescription>newArrayList(e)), new TopologicalSorter().sortByDependencies(Collections.<ProjectDescription>unmodifiableList(CollectionLiterals.<ProjectDescription>newArrayList(a, b, c, d, e)), _function_5));
    this.assertEquals(Collections.<ProjectDescription>unmodifiableList(CollectionLiterals.<ProjectDescription>newArrayList(b, d, c, a)), cyclic);
  }
  
  @Test
  public void testCycle1() {
    ProjectDescription _projectDescription = new ProjectDescription();
    final Procedure1<ProjectDescription> _function = (ProjectDescription it) -> {
      it.setName("a");
      it.setDependencies(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("a")));
    };
    final ProjectDescription a = ObjectExtensions.<ProjectDescription>operator_doubleArrow(_projectDescription, _function);
    final ArrayList<ProjectDescription> cyclic = CollectionLiterals.<ProjectDescription>newArrayList();
    final Procedure1<ProjectDescription> _function_1 = (ProjectDescription it) -> {
      cyclic.add(it);
    };
    this.assertEquals(Collections.<ProjectDescription>unmodifiableList(CollectionLiterals.<ProjectDescription>newArrayList()), new TopologicalSorter().sortByDependencies(Collections.<ProjectDescription>unmodifiableList(CollectionLiterals.<ProjectDescription>newArrayList(a)), _function_1));
    this.assertEquals(Collections.<ProjectDescription>unmodifiableList(CollectionLiterals.<ProjectDescription>newArrayList(a)), cyclic);
  }
  
  public void assertEquals(final List<ProjectDescription> expected, final List<ProjectDescription> actual) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Expected: ");
    String _asString = this.asString(expected);
    _builder.append(_asString);
    _builder.append(" but was ");
    String _asString_1 = this.asString(actual);
    _builder.append(_asString_1);
    Assert.assertEquals(_builder.toString(), expected, actual);
  }
  
  public String asString(final List<ProjectDescription> list) {
    final Function1<ProjectDescription, String> _function = (ProjectDescription it) -> {
      return it.getName();
    };
    return IterableExtensions.join(ListExtensions.<ProjectDescription, String>map(list, _function), ", ");
  }
}
