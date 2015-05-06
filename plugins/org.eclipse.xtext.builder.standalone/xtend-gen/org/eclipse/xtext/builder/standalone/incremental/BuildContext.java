/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone.incremental;

import com.google.common.base.Objects;
import java.io.File;
import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.builder.standalone.LanguageAccess;
import org.eclipse.xtext.builder.standalone.incremental.ClusteringStorageAwareResourceLoader;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.clustering.IResourceClusteringPolicy;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9
 */
@FinalFieldsConstructor
@Accessors
@SuppressWarnings("all")
public class BuildContext {
  private final Map<String, LanguageAccess> languages;
  
  private final XtextResourceSet resourceSet;
  
  private final IResourceClusteringPolicy clusteringPolicy;
  
  private final File tempDir;
  
  private ClusteringStorageAwareResourceLoader loader;
  
  public <T extends Object> Iterable<T> executeClustered(final Iterable<URI> uri, final Function1<? super Resource, ? extends T> operation) {
    Iterable<T> _xblockexpression = null;
    {
      boolean _equals = Objects.equal(this.loader, null);
      if (_equals) {
        ClusteringStorageAwareResourceLoader _clusteringStorageAwareResourceLoader = new ClusteringStorageAwareResourceLoader(this);
        this.loader = _clusteringStorageAwareResourceLoader;
      }
      _xblockexpression = this.loader.<T>executeClustered(uri, operation);
    }
    return _xblockexpression;
  }
  
  public LanguageAccess getLanguageAccess(final URI uri) {
    String _fileExtension = uri.fileExtension();
    return this.languages.get(_fileExtension);
  }
  
  public BuildContext(final Map<String, LanguageAccess> languages, final XtextResourceSet resourceSet, final IResourceClusteringPolicy clusteringPolicy, final File tempDir) {
    super();
    this.languages = languages;
    this.resourceSet = resourceSet;
    this.clusteringPolicy = clusteringPolicy;
    this.tempDir = tempDir;
  }
  
  @Pure
  public Map<String, LanguageAccess> getLanguages() {
    return this.languages;
  }
  
  @Pure
  public XtextResourceSet getResourceSet() {
    return this.resourceSet;
  }
  
  @Pure
  public IResourceClusteringPolicy getClusteringPolicy() {
    return this.clusteringPolicy;
  }
  
  @Pure
  public File getTempDir() {
    return this.tempDir;
  }
  
  @Pure
  public ClusteringStorageAwareResourceLoader getLoader() {
    return this.loader;
  }
  
  public void setLoader(final ClusteringStorageAwareResourceLoader loader) {
    this.loader = loader;
  }
}
