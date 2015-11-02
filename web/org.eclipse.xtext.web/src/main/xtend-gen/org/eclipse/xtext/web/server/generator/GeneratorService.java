/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.generator;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtext.generator.GeneratorDelegate;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.web.server.generator.GeneratorResult;
import org.eclipse.xtext.web.server.generator.IContentTypeProvider;
import org.eclipse.xtext.web.server.model.AbstractCachedService;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

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
public class GeneratorService extends AbstractCachedService<GeneratorResult> {
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
  public GeneratorResult compute(final IXtextWebDocument it, final CancelIndicator cancelIndicator) {
    final InMemoryFileSystemAccess fileSystemAccess = this.fileSystemAccessProvider.get();
    XtextResource _resource = it.getResource();
    final IGeneratorContext _function = new IGeneratorContext() {
      @Override
      public CancelIndicator getCancelIndicator() {
        return cancelIndicator;
      }
    };
    this.generator.generate(_resource, fileSystemAccess, _function);
    final GeneratorResult result = new GeneratorResult();
    List<GeneratorResult.GeneratedDocument> _documents = result.getDocuments();
    Map<String, CharSequence> _textFiles = fileSystemAccess.getTextFiles();
    Set<Map.Entry<String, CharSequence>> _entrySet = _textFiles.entrySet();
    final Function1<Map.Entry<String, CharSequence>, GeneratorResult.GeneratedDocument> _function_1 = new Function1<Map.Entry<String, CharSequence>, GeneratorResult.GeneratedDocument>() {
      @Override
      public GeneratorResult.GeneratedDocument apply(final Map.Entry<String, CharSequence> it) {
        GeneratorResult.GeneratedDocument _xblockexpression = null;
        {
          String _key = it.getKey();
          final String contentType = GeneratorService.this.contentTypeProvider.getContentType(_key);
          String _key_1 = it.getKey();
          CharSequence _value = it.getValue();
          String _string = _value.toString();
          _xblockexpression = new GeneratorResult.GeneratedDocument(_key_1, contentType, _string);
        }
        return _xblockexpression;
      }
    };
    Iterable<GeneratorResult.GeneratedDocument> _map = IterableExtensions.<Map.Entry<String, CharSequence>, GeneratorResult.GeneratedDocument>map(_entrySet, _function_1);
    Iterables.<GeneratorResult.GeneratedDocument>addAll(_documents, _map);
    return result;
  }
}
