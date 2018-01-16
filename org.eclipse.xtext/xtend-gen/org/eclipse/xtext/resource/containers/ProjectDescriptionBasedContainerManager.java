/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtext.resource.containers.LiveShadowedChunkedContainer;
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions;
import org.eclipse.xtext.resource.impl.LiveShadowedChunkedResourceDescriptions;
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
    final ChunkedResourceDescriptions chunkedResourceDescriptions = this.getChunkedResourceDescriptions(resourceDescriptions);
    return (((chunkedResourceDescriptions != null) && (chunkedResourceDescriptions.getResourceSet() != null)) && (ProjectDescription.findInEmfObject(chunkedResourceDescriptions.getResourceSet()) != null));
  }
  
  @Override
  public IContainer getContainer(final IResourceDescription desc, final IResourceDescriptions resourceDescriptions) {
    final ChunkedResourceDescriptions chunkedResourceDescriptions = this.getChunkedResourceDescriptions(resourceDescriptions);
    if ((chunkedResourceDescriptions == null)) {
      String _name = ChunkedResourceDescriptions.class.getName();
      String _plus = ("expected " + _name);
      throw new IllegalArgumentException(_plus);
    }
    final ResourceSet resourceSet = chunkedResourceDescriptions.getResourceSet();
    final ProjectDescription projectDescription = ProjectDescription.findInEmfObject(resourceSet);
    final IContainer container = this.createContainer(resourceDescriptions, chunkedResourceDescriptions, projectDescription.getName());
    return container;
  }
  
  @Override
  public List<IContainer> getVisibleContainers(final IResourceDescription desc, final IResourceDescriptions resourceDescriptions) {
    final ChunkedResourceDescriptions chunkedResourceDescriptions = this.getChunkedResourceDescriptions(resourceDescriptions);
    if ((chunkedResourceDescriptions == null)) {
      String _name = ChunkedResourceDescriptions.class.getName();
      String _plus = ("expected " + _name);
      throw new IllegalArgumentException(_plus);
    }
    final ResourceSet resourceSet = chunkedResourceDescriptions.getResourceSet();
    final ProjectDescription projectDescription = ProjectDescription.findInEmfObject(resourceSet);
    final ArrayList<IContainer> allContainers = CollectionLiterals.<IContainer>newArrayList();
    allContainers.add(this.createContainer(resourceDescriptions, chunkedResourceDescriptions, projectDescription.getName()));
    List<String> _dependencies = projectDescription.getDependencies();
    for (final String name : _dependencies) {
      allContainers.add(this.createContainer(resourceDescriptions, chunkedResourceDescriptions, name));
    }
    return allContainers;
  }
  
  protected ChunkedResourceDescriptions getChunkedResourceDescriptions(final IResourceDescriptions resourceDescriptions) {
    ChunkedResourceDescriptions _switchResult = null;
    boolean _matched = false;
    if (resourceDescriptions instanceof ChunkedResourceDescriptions) {
      _matched=true;
      _switchResult = ((ChunkedResourceDescriptions)resourceDescriptions);
    }
    if (!_matched) {
      if (resourceDescriptions instanceof LiveShadowedChunkedResourceDescriptions) {
        _matched=true;
        _switchResult = this.getChunkedResourceDescriptions(((LiveShadowedChunkedResourceDescriptions)resourceDescriptions).getGlobalDescriptions());
      }
    }
    if (!_matched) {
      _switchResult = null;
    }
    return _switchResult;
  }
  
  protected IContainer createContainer(final IResourceDescriptions resourceDescriptions, final ChunkedResourceDescriptions chunkedResourceDescriptions, final String projectName) {
    IContainer _xifexpression = null;
    if ((resourceDescriptions instanceof LiveShadowedChunkedResourceDescriptions)) {
      _xifexpression = new LiveShadowedChunkedContainer(((LiveShadowedChunkedResourceDescriptions)resourceDescriptions), projectName);
    } else {
      ResourceDescriptionsData _elvis = null;
      ResourceDescriptionsData _container = chunkedResourceDescriptions.getContainer(projectName);
      if (_container != null) {
        _elvis = _container;
      } else {
        Set<IResourceDescription> _emptySet = CollectionLiterals.<IResourceDescription>emptySet();
        ResourceDescriptionsData _resourceDescriptionsData = new ResourceDescriptionsData(_emptySet);
        _elvis = _resourceDescriptionsData;
      }
      _xifexpression = new ResourceDescriptionsBasedContainer(_elvis);
    }
    return _xifexpression;
  }
}
