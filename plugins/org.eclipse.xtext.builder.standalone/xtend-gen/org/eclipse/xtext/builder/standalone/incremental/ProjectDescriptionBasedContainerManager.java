/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone.incremental;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.builder.standalone.incremental.ContextualChunkedResourceDescriptions;
import org.eclipse.xtext.builder.standalone.incremental.ProjectDescription;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
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
@SuppressWarnings("all")
public class ProjectDescriptionBasedContainerManager implements IContainer.Manager {
  @Override
  public IContainer getContainer(final IResourceDescription desc, final IResourceDescriptions resourceDescriptions) {
    if ((resourceDescriptions instanceof ContextualChunkedResourceDescriptions)) {
      final ResourceSet resourceSet = ((ContextualChunkedResourceDescriptions)resourceDescriptions).getResourceSet();
      final ProjectDescription projectDescription = ProjectDescription.findInEmfObject(resourceSet);
      String _name = projectDescription.getName();
      final ResourceDescriptionsData container = ((ContextualChunkedResourceDescriptions)resourceDescriptions).getContainer(_name);
      return new ResourceDescriptionsBasedContainer(container);
    }
    String _name_1 = ContextualChunkedResourceDescriptions.class.getName();
    String _plus = ("expected " + _name_1);
    throw new IllegalArgumentException(_plus);
  }
  
  @Override
  public List<IContainer> getVisibleContainers(final IResourceDescription desc, final IResourceDescriptions resourceDescriptions) {
    if ((resourceDescriptions instanceof ContextualChunkedResourceDescriptions)) {
      final ResourceSet resourceSet = ((ContextualChunkedResourceDescriptions)resourceDescriptions).getResourceSet();
      final ProjectDescription projectDescription = ProjectDescription.findInEmfObject(resourceSet);
      final ArrayList<IContainer> allContainers = CollectionLiterals.<IContainer>newArrayList();
      String _name = projectDescription.getName();
      ResourceDescriptionsData _container = ((ContextualChunkedResourceDescriptions)resourceDescriptions).getContainer(_name);
      ResourceDescriptionsBasedContainer _resourceDescriptionsBasedContainer = new ResourceDescriptionsBasedContainer(_container);
      allContainers.add(_resourceDescriptionsBasedContainer);
      List<String> _dependencies = projectDescription.getDependencies();
      final Function1<String, ResourceDescriptionsBasedContainer> _function = new Function1<String, ResourceDescriptionsBasedContainer>() {
        @Override
        public ResourceDescriptionsBasedContainer apply(final String uri) {
          String _string = uri.toString();
          final ResourceDescriptionsData container = ((ContextualChunkedResourceDescriptions)resourceDescriptions).getContainer(_string);
          return new ResourceDescriptionsBasedContainer(container);
        }
      };
      List<ResourceDescriptionsBasedContainer> _map = ListExtensions.<String, ResourceDescriptionsBasedContainer>map(_dependencies, _function);
      allContainers.addAll(_map);
      return allContainers;
    }
    String _name_1 = ContextualChunkedResourceDescriptions.class.getName();
    String _plus = ("expected " + _name_1);
    throw new IllegalArgumentException(_plus);
  }
}
