/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.build.daemon;

import com.google.common.base.Objects;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.common.types.xtext.AbstractProjectAwareResourceDescriptionsProvider;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class IdeaBuilderResourceDescriptionsProvider extends AbstractProjectAwareResourceDescriptionsProvider {
  @Data
  public static class ModuleAdapter extends AdapterImpl {
    private final String moduleBaseURL;
    
    @Override
    public boolean isAdapterForType(final Object type) {
      return Objects.equal(type, IdeaBuilderResourceDescriptionsProvider.ModuleAdapter.class);
    }
    
    public ModuleAdapter(final String moduleBaseURL) {
      super();
      this.moduleBaseURL = moduleBaseURL;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.moduleBaseURL== null) ? 0 : this.moduleBaseURL.hashCode());
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
      IdeaBuilderResourceDescriptionsProvider.ModuleAdapter other = (IdeaBuilderResourceDescriptionsProvider.ModuleAdapter) obj;
      if (this.moduleBaseURL == null) {
        if (other.moduleBaseURL != null)
          return false;
      } else if (!this.moduleBaseURL.equals(other.moduleBaseURL))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      String result = new ToStringBuilder(this)
      	.addAllFields()
      	.toString();
      return result;
    }
    
    @Pure
    public String getModuleBaseURL() {
      return this.moduleBaseURL;
    }
  }
  
  @Override
  protected boolean isProjectLocal(final URI uri, final String encodedProjectName) {
    String _string = uri.toString();
    return _string.startsWith(encodedProjectName);
  }
  
  @Override
  protected String getProjectName(final ResourceSet resourceSet) {
    EList<Adapter> _eAdapters = resourceSet.eAdapters();
    Adapter _adapter = EcoreUtil.getAdapter(_eAdapters, IdeaBuilderResourceDescriptionsProvider.ModuleAdapter.class);
    String _moduleBaseURL = null;
    if (((IdeaBuilderResourceDescriptionsProvider.ModuleAdapter) _adapter)!=null) {
      _moduleBaseURL=((IdeaBuilderResourceDescriptionsProvider.ModuleAdapter) _adapter).moduleBaseURL;
    }
    return _moduleBaseURL;
  }
}
