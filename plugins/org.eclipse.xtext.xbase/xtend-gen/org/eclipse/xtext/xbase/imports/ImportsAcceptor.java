/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.imports;

import java.util.Set;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public interface ImportsAcceptor {
  @Accessors(AccessorType.PUBLIC_GETTER)
  public static class DefaultImportsAcceptor implements ImportsAcceptor {
    private Set<String> types = CollectionLiterals.<String>newHashSet();
    
    private Set<String> staticImport = CollectionLiterals.<String>newHashSet();
    
    private Set<String> extensions = CollectionLiterals.<String>newHashSet();
    
    @Override
    public void acceptTypeImport(final JvmType typeImport) {
      String _qualifiedNameWithout$ = this.qualifiedNameWithout$(typeImport);
      this.types.add(_qualifiedNameWithout$);
    }
    
    @Override
    public void acceptStaticImport(final XAbstractFeatureCall statImport) {
      JvmIdentifiableElement _feature = statImport.getFeature();
      String _qualifiedNameWithout$ = this.qualifiedNameWithout$(_feature);
      this.staticImport.add(_qualifiedNameWithout$);
    }
    
    @Override
    public void acceptStaticExtensionImport(final XAbstractFeatureCall extImport) {
      JvmIdentifiableElement _feature = extImport.getFeature();
      String _qualifiedNameWithout$ = this.qualifiedNameWithout$(_feature);
      this.extensions.add(_qualifiedNameWithout$);
    }
    
    private String qualifiedNameWithout$(final JvmIdentifiableElement ele) {
      return ele.getQualifiedName('.');
    }
    
    @Pure
    public Set<String> getTypes() {
      return this.types;
    }
    
    @Pure
    public Set<String> getStaticImport() {
      return this.staticImport;
    }
    
    @Pure
    public Set<String> getExtensions() {
      return this.extensions;
    }
  }
  
  public abstract void acceptTypeImport(final JvmType typeImport);
  
  public abstract void acceptStaticImport(final XAbstractFeatureCall staticImport);
  
  public abstract void acceptStaticExtensionImport(final XAbstractFeatureCall staticExtImport);
}
