/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource.containers;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions;
import org.eclipse.xtext.resource.impl.ProjectDescription;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsBasedContainer;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.9
 */
@Beta
@SuppressWarnings("all")
public class ProjectDescriptionBasedContainerManager implements IContainer.Manager {
  public boolean shouldUseProjectDescriptionBasedContainers(final IResourceDescriptions resourceDescriptions) {
    if ((resourceDescriptions instanceof ChunkedResourceDescriptions)) {
      ResourceSet _resourceSet = ((ChunkedResourceDescriptions)resourceDescriptions).getResourceSet();
      ProjectDescription _findInEmfObject = ProjectDescription.findInEmfObject(_resourceSet);
      boolean _notEquals = (!Objects.equal(_findInEmfObject, null));
      if (_notEquals) {
        return true;
      }
    }
    return false;
  }
  
  @Override
  public IContainer getContainer(final IResourceDescription desc, final IResourceDescriptions resourceDescriptions) {
    if ((resourceDescriptions instanceof ChunkedResourceDescriptions)) {
      final ResourceSet resourceSet = ((ChunkedResourceDescriptions)resourceDescriptions).getResourceSet();
      final ProjectDescription projectDescription = ProjectDescription.findInEmfObject(resourceSet);
      String _name = projectDescription.getName();
      final ResourceDescriptionsData container = ((ChunkedResourceDescriptions)resourceDescriptions).getContainer(_name);
      return new ResourceDescriptionsBasedContainer(container);
    }
    String _name_1 = ChunkedResourceDescriptions.class.getName();
    String _plus = ("expected " + _name_1);
    throw new IllegalArgumentException(_plus);
  }
  
  @Override
  public List<IContainer> getVisibleContainers(final IResourceDescription desc, final IResourceDescriptions resourceDescriptions) {
    if ((resourceDescriptions instanceof ChunkedResourceDescriptions)) {
      final ResourceSet resourceSet = ((ChunkedResourceDescriptions)resourceDescriptions).getResourceSet();
      final ProjectDescription projectDescription = ProjectDescription.findInEmfObject(resourceSet);
      final ArrayList<IContainer> allContainers = CollectionLiterals.<IContainer>newArrayList();
      String _name = projectDescription.getName();
      ResourceDescriptionsData _container = ((ChunkedResourceDescriptions)resourceDescriptions).getContainer(_name);
      ResourceDescriptionsBasedContainer _resourceDescriptionsBasedContainer = new ResourceDescriptionsBasedContainer(_container);
      allContainers.add(_resourceDescriptionsBasedContainer);
      List<String> _dependencies = projectDescription.getDependencies();
      final Function1<String, ResourceDescriptionsBasedContainer> _function = new Function1<String, ResourceDescriptionsBasedContainer>() {
        @Override
        public ResourceDescriptionsBasedContainer apply(final String uri) {
          String _string = uri.toString();
          final ResourceDescriptionsData container = ((ChunkedResourceDescriptions)resourceDescriptions).getContainer(_string);
          return new ResourceDescriptionsBasedContainer(container);
        }
      };
      List<ResourceDescriptionsBasedContainer> _map = ListExtensions.<String, ResourceDescriptionsBasedContainer>map(_dependencies, _function);
      allContainers.addAll(_map);
      return allContainers;
    }
    String _name_1 = ChunkedResourceDescriptions.class.getName();
    String _plus = ("expected " + _name_1);
    throw new IllegalArgumentException(_plus);
  }
}
