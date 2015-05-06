/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.build.client;

import com.google.common.collect.Iterables;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.builder.standalone.incremental.FilesAndURIs;
import org.eclipse.xtext.builder.standalone.incremental.IClassFileBasedDependencyFinder;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.jetbrains.jps.builders.java.JavaBuilderUtil;
import org.jetbrains.jps.builders.java.dependencyView.Callbacks;
import org.jetbrains.jps.builders.java.dependencyView.Mappings;
import org.jetbrains.jps.cmdline.ProjectDescriptor;
import org.jetbrains.jps.incremental.CompileContext;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class IdeaClassFileDependencyFinder implements IClassFileBasedDependencyFinder {
  private final CompileContext context;
  
  @Override
  public Iterable<? extends URI> getDependentJavaFiles(final Iterable<URI> dirtyJavaFiles, final Iterable<URI> deletedJavaFiles) {
    ProjectDescriptor projectDescriptor = this.context.getProjectDescriptor();
    Mappings globalMappings = projectDescriptor.dataManager.getMappings();
    Mappings delta = globalMappings.createDelta();
    final Function1<URI, File> _function = new Function1<URI, File>() {
      @Override
      public File apply(final URI it) {
        return FilesAndURIs.asFile(it);
      }
    };
    Iterable<File> _map = IterableExtensions.<URI, File>map(dirtyJavaFiles, _function);
    final Set<File> affected = IterableExtensions.<File>toSet(_map);
    final Function1<URI, String> _function_1 = new Function1<URI, String>() {
      @Override
      public String apply(final URI it) {
        return FilesAndURIs.asPath(it);
      }
    };
    Iterable<String> _map_1 = IterableExtensions.<URI, String>map(deletedJavaFiles, _function_1);
    final Set<String> deleted = IterableExtensions.<String>toSet(_map_1);
    final Callbacks.ConstantAffectionResolver constantSearch = JavaBuilderUtil.CONSTANT_SEARCH_SERVICE.get(this.context);
    final Mappings.DependentFilesFilter moduleBasedFilter = new Mappings.DependentFilesFilter() {
      @Override
      public boolean accept(final File file) {
        return true;
      }
      
      @Override
      public boolean belongsToCurrentTargetChunk(final File file) {
        return true;
      }
    };
    final HashSet<File> allAffected = CollectionLiterals.<File>newHashSet();
    Iterables.<File>addAll(allAffected, affected);
    globalMappings.differentiateOnIncrementalMake(delta, deleted, affected, affected, allAffected, moduleBasedFilter, constantSearch);
    allAffected.removeAll(affected);
    final Function1<File, URI> _function_2 = new Function1<File, URI>() {
      @Override
      public URI apply(final File it) {
        return FilesAndURIs.asURI(it);
      }
    };
    final Iterable<URI> result = IterableExtensions.<File, URI>map(allAffected, _function_2);
    return result;
  }
  
  public IdeaClassFileDependencyFinder(final CompileContext context) {
    super();
    this.context = context;
  }
}
