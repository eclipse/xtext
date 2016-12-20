/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
    TopologicalSorter _topologicalSorter = new TopologicalSorter();
    final Procedure1<ProjectDescription> _function_4 = (ProjectDescription it) -> {
      Assert.fail();
    };
    List<ProjectDescription> _sortByDependencies = _topologicalSorter.sortByDependencies(Collections.<ProjectDescription>unmodifiableList(CollectionLiterals.<ProjectDescription>newArrayList(a, b, c, d)), _function_4);
    this.assertEquals(Collections.<ProjectDescription>unmodifiableList(CollectionLiterals.<ProjectDescription>newArrayList(d, c, b, a)), _sortByDependencies);
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
    TopologicalSorter _topologicalSorter = new TopologicalSorter();
    final Procedure1<ProjectDescription> _function_4 = (ProjectDescription it) -> {
      Assert.fail();
    };
    List<ProjectDescription> _sortByDependencies = _topologicalSorter.sortByDependencies(Collections.<ProjectDescription>unmodifiableList(CollectionLiterals.<ProjectDescription>newArrayList(a, b, c, d)), _function_4);
    this.assertEquals(Collections.<ProjectDescription>unmodifiableList(CollectionLiterals.<ProjectDescription>newArrayList(d, c, b, a)), _sortByDependencies);
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
    TopologicalSorter _topologicalSorter = new TopologicalSorter();
    final Procedure1<ProjectDescription> _function_4 = (ProjectDescription it) -> {
      Assert.fail();
    };
    List<ProjectDescription> _sortByDependencies = _topologicalSorter.sortByDependencies(Collections.<ProjectDescription>unmodifiableList(CollectionLiterals.<ProjectDescription>newArrayList(a, b, c, d)), _function_4);
    this.assertEquals(Collections.<ProjectDescription>unmodifiableList(CollectionLiterals.<ProjectDescription>newArrayList(d, c, b, a)), _sortByDependencies);
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
    TopologicalSorter _topologicalSorter = new TopologicalSorter();
    final Procedure1<ProjectDescription> _function_2 = (ProjectDescription it) -> {
      Assert.fail();
    };
    List<ProjectDescription> _sortByDependencies = _topologicalSorter.sortByDependencies(Collections.<ProjectDescription>unmodifiableList(CollectionLiterals.<ProjectDescription>newArrayList(a)), _function_2);
    this.assertEquals(Collections.<ProjectDescription>unmodifiableList(CollectionLiterals.<ProjectDescription>newArrayList(a)), _sortByDependencies);
    TopologicalSorter _topologicalSorter_1 = new TopologicalSorter();
    final Procedure1<ProjectDescription> _function_3 = (ProjectDescription it) -> {
      Assert.fail();
    };
    List<ProjectDescription> _sortByDependencies_1 = _topologicalSorter_1.sortByDependencies(Collections.<ProjectDescription>unmodifiableList(CollectionLiterals.<ProjectDescription>newArrayList(b)), _function_3);
    this.assertEquals(Collections.<ProjectDescription>unmodifiableList(CollectionLiterals.<ProjectDescription>newArrayList(b)), _sortByDependencies_1);
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
    TopologicalSorter _topologicalSorter = new TopologicalSorter();
    final Procedure1<ProjectDescription> _function_5 = (ProjectDescription it) -> {
      cyclic.add(it);
    };
    List<ProjectDescription> _sortByDependencies = _topologicalSorter.sortByDependencies(Collections.<ProjectDescription>unmodifiableList(CollectionLiterals.<ProjectDescription>newArrayList(a, b, c, d, e)), _function_5);
    this.assertEquals(Collections.<ProjectDescription>unmodifiableList(CollectionLiterals.<ProjectDescription>newArrayList(e)), _sortByDependencies);
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
    TopologicalSorter _topologicalSorter = new TopologicalSorter();
    final Procedure1<ProjectDescription> _function_1 = (ProjectDescription it) -> {
      cyclic.add(it);
    };
    List<ProjectDescription> _sortByDependencies = _topologicalSorter.sortByDependencies(Collections.<ProjectDescription>unmodifiableList(CollectionLiterals.<ProjectDescription>newArrayList(a)), _function_1);
    this.assertEquals(Collections.<ProjectDescription>unmodifiableList(CollectionLiterals.<ProjectDescription>newArrayList()), _sortByDependencies);
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
    List<String> _map = ListExtensions.<ProjectDescription, String>map(list, _function);
    return IterableExtensions.join(_map, ", ");
  }
}
