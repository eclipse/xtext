/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.refactoring.participant;

import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.xtext.ide.refactoring.IResourceRelocationStrategy;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@SuppressWarnings("all")
public class ResourceRelocationStrategyRegistry {
  private static Logger LOG = Logger.getLogger(ResourceRelocationStrategyRegistry.class);
  
  private final static String EXTENSION_POINT_ID = "org.eclipse.xtext.ui.resourceRelocationStrategy";
  
  private List<IResourceRelocationStrategy> strategies;
  
  public List<? extends IResourceRelocationStrategy> getStrategies() {
    List<? extends IResourceRelocationStrategy> _elvis = null;
    if (this.strategies != null) {
      _elvis = this.strategies;
    } else {
      List<IResourceRelocationStrategy> _xblockexpression = null;
      {
        final IConfigurationElement[] configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(ResourceRelocationStrategyRegistry.EXTENSION_POINT_ID);
        this.strategies = CollectionLiterals.<IResourceRelocationStrategy>newArrayList();
        for (final IConfigurationElement configurationElement : configurationElements) {
          try {
            Object _createExecutableExtension = configurationElement.createExecutableExtension("class");
            this.strategies.add(((IResourceRelocationStrategy) _createExecutableExtension));
          } catch (final Throwable _t) {
            if (_t instanceof CoreException) {
              final CoreException e = (CoreException)_t;
              ResourceRelocationStrategyRegistry.LOG.error("Error instantiating participant strategy", e);
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        }
        _xblockexpression = this.strategies;
      }
      _elvis = _xblockexpression;
    }
    return _elvis;
  }
}
