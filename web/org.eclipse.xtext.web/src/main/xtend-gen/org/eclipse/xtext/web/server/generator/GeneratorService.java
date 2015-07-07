/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.generator;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.generator.GeneratorResult;
import org.eclipse.xtext.web.server.generator.IContentTypeProvider;
import org.eclipse.xtext.web.server.generator.ResponseFileSystemAccess;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * Service class for code generation. The resulting documents are sent back to the client;
 * if exactly one document is generated, the result is unwrapped, i.e. the response body
 * is the generated document.
 */
@Singleton
@SuppressWarnings("all")
public class GeneratorService {
  @Inject
  private IGenerator generator;
  
  @Inject
  private IContentTypeProvider contentTypeProvider;
  
  public GeneratorResult generate(final XtextWebDocumentAccess document) throws InvalidRequestException {
    final CancelableUnitOfWork<ResponseFileSystemAccess, IXtextWebDocument> _function = new CancelableUnitOfWork<ResponseFileSystemAccess, IXtextWebDocument>() {
      @Override
      public ResponseFileSystemAccess exec(final IXtextWebDocument it, final CancelIndicator cancelIndicator) throws Exception {
        final ResponseFileSystemAccess fileSystemAccess = new ResponseFileSystemAccess();
        XtextResource _resource = it.getResource();
        GeneratorService.this.generator.doGenerate(_resource, fileSystemAccess);
        return fileSystemAccess;
      }
    };
    final ResponseFileSystemAccess fileSystemAccess = document.<ResponseFileSystemAccess>readOnly(_function);
    final GeneratorResult result = new GeneratorResult();
    List<GeneratorResult.GeneratedDocument> _entries = result.getEntries();
    List<ResponseFileSystemAccess.ResponseFile> _files = fileSystemAccess.getFiles();
    final Function1<ResponseFileSystemAccess.ResponseFile, GeneratorResult.GeneratedDocument> _function_1 = new Function1<ResponseFileSystemAccess.ResponseFile, GeneratorResult.GeneratedDocument>() {
      @Override
      public GeneratorResult.GeneratedDocument apply(final ResponseFileSystemAccess.ResponseFile it) {
        GeneratorResult.GeneratedDocument _xblockexpression = null;
        {
          String _name = it.getName();
          final String contentType = GeneratorService.this.contentTypeProvider.getContentType(_name);
          String _name_1 = it.getName();
          CharSequence _content = it.getContent();
          String _string = _content.toString();
          _xblockexpression = new GeneratorResult.GeneratedDocument(_name_1, contentType, _string);
        }
        return _xblockexpression;
      }
    };
    List<GeneratorResult.GeneratedDocument> _map = ListExtensions.<ResponseFileSystemAccess.ResponseFile, GeneratorResult.GeneratedDocument>map(_files, _function_1);
    _entries.addAll(_map);
    return result;
  }
}
