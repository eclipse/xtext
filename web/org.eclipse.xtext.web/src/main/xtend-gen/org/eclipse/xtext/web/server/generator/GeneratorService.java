/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.generator.GeneratorDelegate;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.generator.GeneratorResult;
import org.eclipse.xtext.web.server.generator.IContentTypeProvider;
import org.eclipse.xtext.web.server.model.AbstractCachedService;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Service class for code generation. The resulting documents are sent back to the client;
 * if exactly one document is generated, the result should be unwrapped, i.e. the response body
 * is the generated document.
 * 
 * <p>Results of this service are cached in the session state. However, the service is <em>not</em>
 * invoked automatically after a document change (in contrast to e.g. validation), but only after
 * an explicit request.</p>
 */
@Singleton
@SuppressWarnings("all")
public class GeneratorService extends AbstractCachedService<GeneratorService.GeneratedArtifacts> {
  /**
   * This service result class is just a wrapper to store all generated documents.
   */
  @Data
  public static class GeneratedArtifacts implements IServiceResult {
    private final List<GeneratorResult> artifacts = CollectionLiterals.<GeneratorResult>newArrayList();
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.artifacts== null) ? 0 : this.artifacts.hashCode());
      return result;
    }
    
    @Override
    @Pure
    public boolean equals(final Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      GeneratorService.GeneratedArtifacts other = (GeneratorService.GeneratedArtifacts) obj;
      if (this.artifacts == null) {
        if (other.artifacts != null)
          return false;
      } else if (!this.artifacts.equals(other.artifacts))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("artifacts", this.artifacts);
      return b.toString();
    }
    
    @Pure
    public List<GeneratorResult> getArtifacts() {
      return this.artifacts;
    }
  }
  
  /**
   * The default artifact name that is accessed when no specific artifact is requested.
   */
  public final static String DEFAULT_ARTIFACT = (IFileSystemAccess.DEFAULT_OUTPUT + "/DEFAULT_ARTIFACT");
  
  @Inject
  private GeneratorDelegate generator;
  
  @Inject
  private IContentTypeProvider contentTypeProvider;
  
  @Inject
  private Provider<InMemoryFileSystemAccess> fileSystemAccessProvider;
  
  /**
   * Generate artifacts for the given document.
   */
  @Override
  public GeneratorService.GeneratedArtifacts compute(final IXtextWebDocument it, final CancelIndicator cancelIndicator) {
    final InMemoryFileSystemAccess fileSystemAccess = this.fileSystemAccessProvider.get();
    XtextResource _resource = it.getResource();
    final IGeneratorContext _function = new IGeneratorContext() {
      @Override
      public CancelIndicator getCancelIndicator() {
        return cancelIndicator;
      }
    };
    this.generator.generate(_resource, fileSystemAccess, _function);
    final GeneratorService.GeneratedArtifacts result = new GeneratorService.GeneratedArtifacts();
    Map<String, CharSequence> _textFiles = fileSystemAccess.getTextFiles();
    Set<Map.Entry<String, CharSequence>> _entrySet = _textFiles.entrySet();
    final Function1<Map.Entry<String, CharSequence>, GeneratorResult> _function_1 = new Function1<Map.Entry<String, CharSequence>, GeneratorResult>() {
      @Override
      public GeneratorResult apply(final Map.Entry<String, CharSequence> it) {
        GeneratorResult _xblockexpression = null;
        {
          String _key = it.getKey();
          final String contentType = GeneratorService.this.contentTypeProvider.getContentType(_key);
          String _key_1 = it.getKey();
          CharSequence _value = it.getValue();
          String _string = _value.toString();
          _xblockexpression = new GeneratorResult(_key_1, contentType, _string);
        }
        return _xblockexpression;
      }
    };
    Iterable<GeneratorResult> _map = IterableExtensions.<Map.Entry<String, CharSequence>, GeneratorResult>map(_entrySet, _function_1);
    Iterables.<GeneratorResult>addAll(result.artifacts, _map);
    return result;
  }
  
  public GeneratorResult getArtifact(final XtextWebDocumentAccess document, final String artifactId) {
    GeneratorService.GeneratedArtifacts _result = this.getResult(document);
    final List<GeneratorResult> artifacts = _result.artifacts;
    String _elvis = null;
    if (artifactId != null) {
      _elvis = artifactId;
    } else {
      _elvis = GeneratorService.DEFAULT_ARTIFACT;
    }
    final String searchString = _elvis;
    final Function1<GeneratorResult, Boolean> _function = new Function1<GeneratorResult, Boolean>() {
      @Override
      public Boolean apply(final GeneratorResult it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, searchString));
      }
    };
    GeneratorResult result = IterableExtensions.<GeneratorResult>findFirst(artifacts, _function);
    boolean _and = false;
    if (!(result == null)) {
      _and = false;
    } else {
      boolean _startsWith = searchString.startsWith(IFileSystemAccess.DEFAULT_OUTPUT);
      boolean _not = (!_startsWith);
      _and = _not;
    }
    if (_and) {
      final String defaultSearchString = (IFileSystemAccess.DEFAULT_OUTPUT + searchString);
      final Function1<GeneratorResult, Boolean> _function_1 = new Function1<GeneratorResult, Boolean>() {
        @Override
        public Boolean apply(final GeneratorResult it) {
          String _name = it.getName();
          return Boolean.valueOf(Objects.equal(_name, defaultSearchString));
        }
      };
      GeneratorResult _findFirst = IterableExtensions.<GeneratorResult>findFirst(artifacts, _function_1);
      result = _findFirst;
    }
    if ((result == null)) {
      throw new InvalidRequestException.ResourceNotFoundException("The requested generator artifact was not found.");
    }
    return result;
  }
}
