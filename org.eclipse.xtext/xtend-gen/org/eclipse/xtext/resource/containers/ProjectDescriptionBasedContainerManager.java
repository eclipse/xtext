/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource.containers;

import com.google.common.annotations.Beta;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions;
import org.eclipse.xtext.resource.impl.ProjectDescription;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsBasedContainer;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

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
      ProjectDescription _findInEmfObject = ProjectDescription.findInEmfObject(((ChunkedResourceDescriptions)resourceDescriptions).getResourceSet());
      boolean _tripleNotEquals = (_findInEmfObject != null);
      if (_tripleNotEquals) {
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
      final ResourceDescriptionsData container = ((ChunkedResourceDescriptions)resourceDescriptions).getContainer(projectDescription.getName());
      return new ResourceDescriptionsBasedContainer(container);
    }
    String _name = ChunkedResourceDescriptions.class.getName();
    String _plus = ("expected " + _name);
    throw new IllegalArgumentException(_plus);
  }
  
  @Override
  public List<IContainer> getVisibleContainers(final IResourceDescription desc, final IResourceDescriptions resourceDescriptions) {
    if ((resourceDescriptions instanceof ChunkedResourceDescriptions)) {
      final ResourceSet resourceSet = ((ChunkedResourceDescriptions)resourceDescriptions).getResourceSet();
      final ProjectDescription projectDescription = ProjectDescription.findInEmfObject(resourceSet);
      final ArrayList<IContainer> allContainers = CollectionLiterals.<IContainer>newArrayList();
      ResourceDescriptionsData _elvis = null;
      ResourceDescriptionsData _container = ((ChunkedResourceDescriptions)resourceDescriptions).getContainer(projectDescription.getName());
      if (_container != null) {
        _elvis = _container;
      } else {
        Set<IResourceDescription> _emptySet = CollectionLiterals.<IResourceDescription>emptySet();
        ResourceDescriptionsData _resourceDescriptionsData = new ResourceDescriptionsData(_emptySet);
        _elvis = _resourceDescriptionsData;
      }
      final ResourceDescriptionsData container = _elvis;
      ResourceDescriptionsBasedContainer _resourceDescriptionsBasedContainer = new ResourceDescriptionsBasedContainer(container);
      allContainers.add(_resourceDescriptionsBasedContainer);
      List<String> _dependencies = projectDescription.getDependencies();
      for (final String name : _dependencies) {
        {
          ResourceDescriptionsData _elvis_1 = null;
          ResourceDescriptionsData _container_1 = ((ChunkedResourceDescriptions)resourceDescriptions).getContainer(name);
          if (_container_1 != null) {
            _elvis_1 = _container_1;
          } else {
            Set<IResourceDescription> _emptySet_1 = CollectionLiterals.<IResourceDescription>emptySet();
            ResourceDescriptionsData _resourceDescriptionsData_1 = new ResourceDescriptionsData(_emptySet_1);
            _elvis_1 = _resourceDescriptionsData_1;
          }
          final ResourceDescriptionsData containerDep = _elvis_1;
          ResourceDescriptionsBasedContainer _resourceDescriptionsBasedContainer_1 = new ResourceDescriptionsBasedContainer(containerDep);
          allContainers.add(_resourceDescriptionsBasedContainer_1);
        }
      }
      return allContainers;
    }
    String _name = ChunkedResourceDescriptions.class.getName();
    String _plus = ("expected " + _name);
    throw new IllegalArgumentException(_plus);
  }
}
