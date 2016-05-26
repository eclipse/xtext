/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server.symbol;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.typefox.lsapi.LocationImpl;
import io.typefox.lsapi.SymbolInformation;
import io.typefox.lsapi.SymbolInformationImpl;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.ide.server.DocumentExtensions;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
@SuppressWarnings("all")
public class DocumentSymbolService {
  @Inject
  @Extension
  private DocumentExtensions _documentExtensions;
  
  @Inject
  @Extension
  private IQualifiedNameProvider qualifiedNameProvider;
  
  public List<? extends SymbolInformation> getSymbols(final XtextResource resource) {
    final LinkedHashMap<EObject, SymbolInformationImpl> symbols = CollectionLiterals.<EObject, SymbolInformationImpl>newLinkedHashMap();
    final TreeIterator<EObject> contents = EcoreUtil.<EObject>getAllProperContents(resource, true);
    while (contents.hasNext()) {
      {
        final EObject obj = contents.next();
        final SymbolInformationImpl symbol = this.createSymbol(obj);
        if ((symbol != null)) {
          symbols.put(obj, symbol);
          final EObject container = this.getContainer(obj);
          final SymbolInformationImpl containerSymbol = symbols.get(container);
          String _name = null;
          if (containerSymbol!=null) {
            _name=containerSymbol.getName();
          }
          symbol.setContainer(_name);
        }
      }
    }
    Collection<SymbolInformationImpl> _values = symbols.values();
    return IterableExtensions.<SymbolInformationImpl>toList(_values);
  }
  
  protected EObject getContainer(final EObject obj) {
    return obj.eContainer();
  }
  
  protected SymbolInformationImpl createSymbol(final EObject object) {
    final String symbolName = this.getSymbolName(object);
    if ((symbolName == null)) {
      return null;
    }
    final SymbolInformationImpl symbol = new SymbolInformationImpl();
    symbol.setName(symbolName);
    int _symbolKind = this.getSymbolKind(object);
    symbol.setKind(_symbolKind);
    LocationImpl _newLocation = this._documentExtensions.newLocation(object);
    symbol.setLocation(_newLocation);
    return symbol;
  }
  
  protected String getSymbolName(final EObject object) {
    QualifiedName _fullyQualifiedName = this.qualifiedNameProvider.getFullyQualifiedName(object);
    String _string = null;
    if (_fullyQualifiedName!=null) {
      _string=_fullyQualifiedName.toString();
    }
    return _string;
  }
  
  protected int getSymbolKind(final EObject object) {
    return 0;
  }
}
