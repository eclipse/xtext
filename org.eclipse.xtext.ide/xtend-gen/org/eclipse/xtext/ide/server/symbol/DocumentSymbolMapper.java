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
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.lsp4j.DocumentSymbol;
import org.eclipse.lsp4j.Location;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.SymbolKind;
import org.eclipse.xtext.ide.server.DocumentExtensions;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * Maps an EObject to the corresponding {@link DocumentSymbol document symbol}.
 */
@Beta
@Singleton
@SuppressWarnings("all")
public class DocumentSymbolMapper {
  /**
   * Provides {@link DocumentSymbol#detail detail} for a {@link DocumentSymbol document symbol}.
   * <p>
   * Always returns with an empty string by default.
   * 
   * @see DocumentSymbol#detail
   */
  @Beta
  @Singleton
  public static class DocumentSymbolDetailsProvider {
    public String getDetails(final EObject object) {
      return "";
    }
  }
  
  /**
   * Provides a human-readable name for the document symbol.
   * 
   * @see DocumentSymbol#name
   */
  @Beta
  @Singleton
  public static class DocumentSymbolNameProvider {
    @Inject
    @Extension
    private IQualifiedNameProvider _iQualifiedNameProvider;
    
    public String getName(final EObject object) {
      QualifiedName _fullyQualifiedName = null;
      if (object!=null) {
        _fullyQualifiedName=this._iQualifiedNameProvider.getFullyQualifiedName(object);
      }
      return this.getName(_fullyQualifiedName);
    }
    
    public String getName(final IEObjectDescription description) {
      QualifiedName _name = null;
      if (description!=null) {
        _name=description.getName();
      }
      return this.getName(_name);
    }
    
    protected String getName(final QualifiedName qualifiedName) {
      String _string = null;
      if (qualifiedName!=null) {
        _string=qualifiedName.toString();
      }
      return _string;
    }
  }
  
  /**
   * Provides the {@link SymbolKind symbol kind} information for the document symbol.
   * 
   * @see DocumentSymbol#kind
   */
  @Beta
  @Singleton
  public static class DocumentSymbolKindProvider {
    public SymbolKind getSymbolKind(final EObject object) {
      EClass _eClass = null;
      if (object!=null) {
        _eClass=object.eClass();
      }
      return this.getSymbolKind(_eClass);
    }
    
    public SymbolKind getSymbolKind(final IEObjectDescription description) {
      EClass _eClass = null;
      if (description!=null) {
        _eClass=description.getEClass();
      }
      return this.getSymbolKind(_eClass);
    }
    
    protected SymbolKind getSymbolKind(final EClass clazz) {
      return SymbolKind.Property;
    }
  }
  
  /**
   * Provides {@link DocumentSymbol#range range} and {@link DocumentSymbol#selectionRange selection range} for a document symbol.
   * 
   * @see DocumentSymbol#range
   * @see DocumentSymbol#selectionRange
   */
  @Beta
  @Singleton
  public static class DocumentSymbolRangeProvider {
    @Inject
    @Extension
    private DocumentExtensions _documentExtensions;
    
    /**
     * The range enclosing this symbol not including leading/trailing whitespace but everything else
     * like comments.
     */
    public Range getRange(final EObject object) {
      Location _newFullLocation = this._documentExtensions.newFullLocation(object);
      Range _range = null;
      if (_newFullLocation!=null) {
        _range=_newFullLocation.getRange();
      }
      return _range;
    }
    
    /**
     * The range that should be selected and revealed when this symbol is being picked, e.g the name of a function.
     */
    public Range getSelectionRange(final EObject object) {
      Location _newLocation = this._documentExtensions.newLocation(object);
      Range _range = null;
      if (_newLocation!=null) {
        _range=_newLocation.getRange();
      }
      return _range;
    }
  }
  
  /**
   * Determines whether a document symbol can be marked as {@link DocumentSymbol#deprecated deprecated}.
   * 
   * @see DocumentSymbol#deprecated
   */
  @Beta
  @Singleton
  public static class DocumentSymbolDeprecationInfoProvider {
    public boolean isDeprecated(final EObject object) {
      return false;
    }
    
    public boolean isDeprecated(final IEObjectDescription description) {
      return false;
    }
  }
  
  @Inject
  private DocumentSymbolMapper.DocumentSymbolNameProvider nameProvider;
  
  @Inject
  private DocumentSymbolMapper.DocumentSymbolKindProvider kindProvider;
  
  @Inject
  private DocumentSymbolMapper.DocumentSymbolRangeProvider rangeProvider;
  
  @Inject
  private DocumentSymbolMapper.DocumentSymbolDetailsProvider detailsProvider;
  
  @Inject
  private DocumentSymbolMapper.DocumentSymbolDeprecationInfoProvider deprecationInfoProvider;
  
  /**
   * Converts the {@code EObject} argument into a {@link DocumentSymbol document symbol} without
   * the {@link DocumentSymbol#children children} information filled in.
   */
  public DocumentSymbol toDocumentSymbol(final EObject object) {
    DocumentSymbol _documentSymbol = new DocumentSymbol();
    final Procedure1<DocumentSymbol> _function = (DocumentSymbol it) -> {
      final String objectName = this.nameProvider.getName(object);
      if ((objectName != null)) {
        it.setName(objectName);
      }
      final SymbolKind objectKind = this.kindProvider.getSymbolKind(object);
      if ((objectKind != null)) {
        it.setKind(objectKind);
      }
      final Range objectRange = this.rangeProvider.getRange(object);
      if ((objectRange != null)) {
        it.setRange(objectRange);
      }
      final Range objectSelectionRange = this.rangeProvider.getSelectionRange(object);
      if ((objectSelectionRange != null)) {
        it.setSelectionRange(objectSelectionRange);
      }
      it.setDetail(this.detailsProvider.getDetails(object));
      it.setDeprecated(Boolean.valueOf(this.deprecationInfoProvider.isDeprecated(object)));
      it.setChildren(CollectionLiterals.<DocumentSymbol>newArrayList());
    };
    return ObjectExtensions.<DocumentSymbol>operator_doubleArrow(_documentSymbol, _function);
  }
}
