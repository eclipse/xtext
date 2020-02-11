/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.server;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.resource.impl.ProjectDescription;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.11
 */
@SuppressWarnings("all")
public class TopologicalSorter {
  @FinalFieldsConstructor
  protected static class Entry {
    private final ProjectDescription description;
    
    private boolean marked;
    
    private boolean cyclic;
    
    @Override
    public String toString() {
      return this.description.getName();
    }
    
    public Entry(final ProjectDescription description) {
      super();
      this.description = description;
    }
  }
  
  private LinkedHashSet<ProjectDescription> result;
  
  private Map<String, TopologicalSorter.Entry> name2entry;
  
  private IAcceptor<ProjectDescription> cyclicAcceptor;
  
  public List<ProjectDescription> sortByDependencies(final Iterable<ProjectDescription> descriptions, final Procedure1<? super ProjectDescription> cyclicAcceptor) {
    List<ProjectDescription> _xblockexpression = null;
    {
      this.cyclicAcceptor = new IAcceptor<ProjectDescription>() {
          public void accept(ProjectDescription t) {
            cyclicAcceptor.apply(t);
          }
      };
      final Function1<ProjectDescription, TopologicalSorter.Entry> _function = (ProjectDescription it) -> {
        return new TopologicalSorter.Entry(it);
      };
      final Function1<TopologicalSorter.Entry, String> _function_1 = (TopologicalSorter.Entry it) -> {
        return it.description.getName();
      };
      this.name2entry = IterableExtensions.<String, TopologicalSorter.Entry>toMap(IterableExtensions.<ProjectDescription, TopologicalSorter.Entry>map(descriptions, _function), _function_1);
      this.result = CollectionLiterals.<ProjectDescription>newLinkedHashSet();
      final Consumer<TopologicalSorter.Entry> _function_2 = (TopologicalSorter.Entry it) -> {
        this.visit(it);
      };
      this.name2entry.values().forEach(_function_2);
      _xblockexpression = IterableExtensions.<ProjectDescription>toList(this.result);
    }
    return _xblockexpression;
  }
  
  protected boolean visit(final TopologicalSorter.Entry current) {
    if (((!this.result.contains(current.description)) && (!current.cyclic))) {
      if (current.marked) {
        this.markCyclic(current);
        return false;
      }
      current.marked = true;
      List<String> _dependencies = current.description.getDependencies();
      for (final String it : _dependencies) {
        {
          final TopologicalSorter.Entry depEntry = this.name2entry.get(it);
          if (((depEntry != null) && (!this.visit(depEntry)))) {
            this.markCyclic(current);
            return false;
          }
        }
      }
      current.marked = false;
      this.result.add(current.description);
    }
    return true;
  }
  
  protected void markCyclic(final TopologicalSorter.Entry it) {
    if ((!it.cyclic)) {
      it.cyclic = true;
      this.cyclicAcceptor.accept(it.description);
    }
  }
}
