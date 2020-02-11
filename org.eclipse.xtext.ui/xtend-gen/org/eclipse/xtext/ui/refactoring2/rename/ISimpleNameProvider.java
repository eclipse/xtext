/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.refactoring2.rename;

import com.google.common.base.Objects;
import com.google.inject.ImplementedBy;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author koehnlein - Initial contribution and API
 */
@ImplementedBy(ISimpleNameProvider.DefaultImpl.class)
@SuppressWarnings("all")
public interface ISimpleNameProvider {
  class DefaultImpl implements ISimpleNameProvider {
    @Override
    public String getSimpleName(final EObject target) {
      EAttribute _nameEAttribute = null;
      if (target!=null) {
        _nameEAttribute=this.getNameEAttribute(target);
      }
      final EAttribute nameAttribute = _nameEAttribute;
      if ((nameAttribute != null)) {
        Object _eGet = target.eGet(nameAttribute);
        return ((String) _eGet);
      } else {
        return null;
      }
    }
    
    @Override
    public boolean canRename(final EObject target) {
      EAttribute _nameEAttribute = null;
      if (target!=null) {
        _nameEAttribute=this.getNameEAttribute(target);
      }
      return (_nameEAttribute != null);
    }
    
    protected EAttribute getNameEAttribute(final EObject target) {
      final Function1<EAttribute, Boolean> _function = (EAttribute it) -> {
        return Boolean.valueOf((Objects.equal(it.getName(), "name") && Objects.equal(it.getEType(), EcorePackage.Literals.ESTRING)));
      };
      return IterableExtensions.<EAttribute>head(IterableExtensions.<EAttribute>filter(target.eClass().getEAllAttributes(), _function));
    }
  }
  
  String getSimpleName(final EObject target);
  
  boolean canRename(final EObject target);
}
