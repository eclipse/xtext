/**
 * Copyright (c) 2018 TypeFox and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.server.symbol;

import com.google.common.annotations.Beta;
import com.google.common.base.Optional;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.lsp4j.DocumentSymbol;
import org.eclipse.lsp4j.DocumentSymbolParams;
import org.eclipse.lsp4j.SymbolInformation;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.lsp4j.jsonrpc.validation.NonNull;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.symbol.DocumentSymbolMapper;
import org.eclipse.xtext.ide.server.symbol.IDocumentSymbolService;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * Document symbol service that is comply with the LSP <a href="https://microsoft.github.io/language-server-protocol/specification#version_3_10_0">3.10.0</a>
 * version. Unlike the {@link DocumentSymbolService}, this service can provide hierarchical document symbols.
 */
@Beta
@Singleton
@SuppressWarnings("all")
public class HierarchicalDocumentSymbolService implements IDocumentSymbolService {
  @Inject
  private DocumentSymbolMapper symbolMapper;
  
  @Inject
  private OperationCanceledManager operationCanceledManager;
  
  /**
   * {@code false} if the argument is {@code null} or any of the {@link NonNull} properties
   * are {@code null}. Otherwise, {@code true}.
   */
  public static boolean isValid(final DocumentSymbol symbol) {
    return ((symbol != null) && (!IterableExtensions.<Object>exists(IterableExtensions.<Field, Object>map(IterableExtensions.<Field, Field>map(IterableExtensions.<Field>filter(((Iterable<Field>)Conversions.doWrapArray(DocumentSymbol.class.getDeclaredFields())), ((Function1<Field, Boolean>) (Field it) -> {
      final Function1<Annotation, Boolean> _function = (Annotation it_1) -> {
        Class<? extends Annotation> _annotationType = it_1.annotationType();
        return Boolean.valueOf((_annotationType == NonNull.class));
      };
      return Boolean.valueOf(IterableExtensions.<Annotation>exists(((Iterable<Annotation>)Conversions.doWrapArray(it.getAnnotations())), _function));
    })), ((Function1<Field, Field>) (Field it) -> {
      Field _xblockexpression = null;
      {
        it.setAccessible(true);
        _xblockexpression = it;
      }
      return _xblockexpression;
    })), ((Function1<Field, Object>) (Field it) -> {
      try {
        return it.get(symbol);
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    })), ((Function1<Object, Boolean>) (Object it) -> {
      return Boolean.valueOf((it == null));
    }))));
  }
  
  @Override
  public List<Either<SymbolInformation, DocumentSymbol>> getSymbols(final Document document, final XtextResource resource, final DocumentSymbolParams params, final CancelIndicator cancelIndicator) {
    return this.getSymbols(resource, cancelIndicator);
  }
  
  public List<Either<SymbolInformation, DocumentSymbol>> getSymbols(final XtextResource resource, final CancelIndicator cancelIndicator) {
    final HashMap<EObject, DocumentSymbol> allSymbols = CollectionLiterals.<EObject, DocumentSymbol>newHashMap();
    final ArrayList<DocumentSymbol> rootSymbols = CollectionLiterals.<DocumentSymbol>newArrayList();
    final Iterator<Object> itr = this.getAllContents(resource);
    while (itr.hasNext()) {
      {
        this.operationCanceledManager.checkCanceled(cancelIndicator);
        final Optional<EObject> next = this.toEObject(itr.next());
        boolean _isPresent = next.isPresent();
        if (_isPresent) {
          final EObject object = next.get();
          final DocumentSymbol symbol = this.symbolMapper.toDocumentSymbol(object);
          boolean _isValid = HierarchicalDocumentSymbolService.isValid(symbol);
          if (_isValid) {
            allSymbols.put(object, symbol);
            EObject parent = object.eContainer();
            if ((parent == null)) {
              rootSymbols.add(symbol);
            } else {
              DocumentSymbol parentSymbol = allSymbols.get(parent);
              while (((parentSymbol == null) && (parent != null))) {
                {
                  parent = parent.eContainer();
                  parentSymbol = allSymbols.get(parent);
                }
              }
              if ((parentSymbol == null)) {
                rootSymbols.add(symbol);
              } else {
                parentSymbol.getChildren().add(symbol);
              }
            }
          }
        }
      }
    }
    final Function1<DocumentSymbol, Either<SymbolInformation, DocumentSymbol>> _function = (DocumentSymbol it) -> {
      return Either.<SymbolInformation, DocumentSymbol>forRight(it);
    };
    return ListExtensions.<DocumentSymbol, Either<SymbolInformation, DocumentSymbol>>map(rootSymbols, _function);
  }
  
  protected Iterator<Object> getAllContents(final Resource resource) {
    return EcoreUtil.<Object>getAllProperContents(resource, true);
  }
  
  protected Optional<EObject> toEObject(final Object object) {
    if ((object instanceof EObject)) {
      return Optional.<EObject>of(((EObject)object));
    }
    return Optional.<EObject>absent();
  }
}
