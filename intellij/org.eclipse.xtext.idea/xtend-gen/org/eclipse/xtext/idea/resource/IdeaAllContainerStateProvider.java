/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.resource;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@SuppressWarnings("all")
public class IdeaAllContainerStateProvider implements IAllContainersState.Provider {
  @Data
  public static class FlatContainerState implements IAllContainersState {
    private final static String HANDLE = "ALL";
    
    private final IResourceDescriptions descriptions;
    
    @Override
    public Collection<URI> getContainedURIs(final String containerHandle) {
      Iterable<IResourceDescription> _allResourceDescriptions = this.descriptions.getAllResourceDescriptions();
      final Function1<IResourceDescription, URI> _function = new Function1<IResourceDescription, URI>() {
        @Override
        public URI apply(final IResourceDescription it) {
          return it.getURI();
        }
      };
      Iterable<URI> _map = IterableExtensions.<IResourceDescription, URI>map(_allResourceDescriptions, _function);
      return IterableExtensions.<URI>toList(_map);
    }
    
    @Override
    public String getContainerHandle(final URI uri) {
      return IdeaAllContainerStateProvider.FlatContainerState.HANDLE;
    }
    
    @Override
    public List<String> getVisibleContainerHandles(final String handle) {
      return Collections.<String>singletonList(IdeaAllContainerStateProvider.FlatContainerState.HANDLE);
    }
    
    @Override
    public boolean isEmpty(final String containerHandle) {
      boolean _equals = IdeaAllContainerStateProvider.FlatContainerState.HANDLE.equals(containerHandle);
      return (!_equals);
    }
    
    public FlatContainerState(final IResourceDescriptions descriptions) {
      super();
      this.descriptions = descriptions;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.descriptions== null) ? 0 : this.descriptions.hashCode());
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
      IdeaAllContainerStateProvider.FlatContainerState other = (IdeaAllContainerStateProvider.FlatContainerState) obj;
      if (this.descriptions == null) {
        if (other.descriptions != null)
          return false;
      } else if (!this.descriptions.equals(other.descriptions))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("descriptions", this.descriptions);
      return b.toString();
    }
    
    @Pure
    public IResourceDescriptions getDescriptions() {
      return this.descriptions;
    }
  }
  
  @Override
  public IAllContainersState get(final IResourceDescriptions context) {
    return new IdeaAllContainerStateProvider.FlatContainerState(context);
  }
}
