/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.naming;

import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.naming.ICopyQualifiedNameService;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

/**
 * Default implementation for {@link ICopyQualifiedNameService}. Clients might use this implementation as base class.
 * 
 * @author Anton Kosyakov - Initial contribution and API
 * @author Arne Deutsch - Moved to new package
 * @since 2.14
 */
@SuppressWarnings("all")
public class DefaultCopyQualifiedNameService implements ICopyQualifiedNameService {
  @Inject
  private IQualifiedNameProvider qualifiedNameProvider;
  
  @Inject
  private IQualifiedNameConverter qualifiedNameConverter;
  
  protected String _getQualifiedName(final EObject it, final EObject context) {
    return this.toFullyQualifiedName(it);
  }
  
  protected String _getQualifiedName(final EObject it, final Void context) {
    return this.toFullyQualifiedName(it);
  }
  
  protected String _getQualifiedName(final Void it, final EObject context) {
    return null;
  }
  
  protected String _getQualifiedName(final Void it, final Void context) {
    return null;
  }
  
  protected <T extends Object> CharSequence toQualifiedNames(final List<T> it, final Function1<? super T, ? extends String> toQualifiedNameFunction) {
    CharSequence _xblockexpression = null;
    {
      if (((it == null) || (it.size() == 0))) {
        return "";
      }
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _hasElements = false;
        for(final T element : it) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate(", ", "");
          }
          String _apply = toQualifiedNameFunction.apply(element);
          _builder.append(_apply);
        }
      }
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  protected String toFullyQualifiedName(final EObject it) {
    String _xblockexpression = null;
    {
      boolean _eIsProxy = it.eIsProxy();
      if (_eIsProxy) {
        return null;
      }
      _xblockexpression = this.toString(it, this.getFullyQualifiedName(it));
    }
    return _xblockexpression;
  }
  
  protected QualifiedName getFullyQualifiedName(final EObject it) {
    QualifiedName _xblockexpression = null;
    {
      if ((it == null)) {
        return null;
      }
      _xblockexpression = this.qualifiedNameProvider.getFullyQualifiedName(it);
    }
    return _xblockexpression;
  }
  
  protected String toString(final EObject it, final QualifiedName fullyQualifiedName) {
    String _xblockexpression = null;
    {
      if ((fullyQualifiedName == null)) {
        return null;
      }
      _xblockexpression = this.qualifiedNameConverter.toString(fullyQualifiedName);
    }
    return _xblockexpression;
  }
  
  public String getQualifiedName(final EObject it, final EObject context) {
    if (it != null
         && context != null) {
      return _getQualifiedName(it, context);
    } else if (it != null
         && context == null) {
      return _getQualifiedName(it, (Void)null);
    } else if (it == null
         && context != null) {
      return _getQualifiedName((Void)null, context);
    } else if (it == null
         && context == null) {
      return _getQualifiedName((Void)null, (Void)null);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, context).toString());
    }
  }
}
