/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone.incremental;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.builder.standalone.LanguageAccess;
import org.eclipse.xtext.builder.standalone.incremental.BuildContext;
import org.eclipse.xtext.builder.standalone.incremental.BuildRequest;
import org.eclipse.xtext.builder.standalone.incremental.IndexerResult;
import org.eclipse.xtext.builder.standalone.incremental.JavaSupport;
import org.eclipse.xtext.builder.standalone.incremental.ResourceSetClearer;
import org.eclipse.xtext.builder.standalone.incremental.ResourceURICollector;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.clustering.IResourceClusteringPolicy;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9
 */
@SuppressWarnings("all")
public class Indexer {
  private final static Logger LOG = Logger.getLogger(Indexer.class);
  
  @Inject
  @Extension
  private ResourceURICollector uriCollector;
  
  @Inject
  @Extension
  private ResourceSetClearer _resourceSetClearer;
  
  @Inject
  private JavaSupport javaSupport;
  
  public IndexerResult computeAffected(final BuildRequest request, final BuildContext context) {
    Indexer.LOG.info("Collecting source models.");
    final long startedAt = System.currentTimeMillis();
    List<File> _sourceRoots = request.getSourceRoots();
    final List<URI> sourceResourceURIs = this.uriCollector.collectResources(_sourceRoots, context);
    List<File> _classPath = request.getClassPath();
    List<URI> _collectResources = this.uriCollector.collectResources(_classPath, context);
    final Iterable<URI> allResourcesURIs = Iterables.<URI>concat(sourceResourceURIs, _collectResources);
    long _currentTimeMillis = System.currentTimeMillis();
    long _minus = (_currentTimeMillis - startedAt);
    String _plus = ("Finished collecting source models. Took: " + Long.valueOf(_minus));
    String _plus_1 = (_plus + " ms.");
    Indexer.LOG.info(_plus_1);
    List<File> _sourceRoots_1 = request.getSourceRoots();
    List<File> _classPath_1 = request.getClassPath();
    final Iterable<File> allClassPathEntries = Iterables.<File>concat(_sourceRoots_1, _classPath_1);
    boolean _isNeedsJava = context.isNeedsJava();
    if (_isNeedsJava) {
      Indexer.LOG.info("Installing type provider.");
      XtextResourceSet _resourceSet = context.getResourceSet();
      this.javaSupport.installLocalOnlyTypeProvider(allClassPathEntries, _resourceSet);
    }
    ArrayList<IResourceDescription> _newArrayList = CollectionLiterals.<IResourceDescription>newArrayList();
    ResourceDescriptionsData index = new ResourceDescriptionsData(_newArrayList);
    Iterator<URI> allResourceIterator = allResourcesURIs.iterator();
    while (allResourceIterator.hasNext()) {
      {
        List<Resource> resources = CollectionLiterals.<Resource>newArrayList();
        int clusterIndex = 0;
        boolean continue_ = true;
        while ((allResourceIterator.hasNext() && continue_)) {
          {
            final URI uri = allResourceIterator.next();
            XtextResourceSet _resourceSet_1 = context.getResourceSet();
            final Resource resource = _resourceSet_1.getResource(uri, true);
            resources.add(resource);
            this.fillIndex(uri, resource, index, context);
            clusterIndex++;
            IResourceClusteringPolicy _clusteringPolicy = context.getClusteringPolicy();
            XtextResourceSet _resourceSet_2 = context.getResourceSet();
            boolean _continueProcessing = _clusteringPolicy.continueProcessing(_resourceSet_2, null, clusterIndex);
            boolean _not = (!_continueProcessing);
            if (_not) {
              continue_ = false;
            }
          }
        }
        if ((!continue_)) {
          XtextResourceSet _resourceSet_1 = context.getResourceSet();
          this._resourceSetClearer.clearResourceSet(_resourceSet_1);
        }
      }
    }
    XtextResourceSet _resourceSet_1 = context.getResourceSet();
    this.installIndex(_resourceSet_1, index);
    List<URI> _deletedFiles = request.getDeletedFiles();
    return new IndexerResult(sourceResourceURIs, _deletedFiles, index);
  }
  
  protected void installIndex(final XtextResourceSet resourceSet, final ResourceDescriptionsData index) {
    ResourceDescriptionsData.ResourceSetAdapter.installResourceDescriptionsData(resourceSet, index);
  }
  
  protected void fillIndex(final URI uri, final Resource resource, final ResourceDescriptionsData index, final BuildContext context) {
    Map<String, LanguageAccess> _languages = context.getLanguages();
    String _fileExtension = uri.fileExtension();
    LanguageAccess _get = _languages.get(_fileExtension);
    IResourceDescription.Manager _resourceDescriptionManager = _get.getResourceDescriptionManager();
    final IResourceDescription description = _resourceDescriptionManager.getResourceDescription(resource);
    index.addDescription(uri, description);
  }
}
