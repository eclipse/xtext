/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.refactoring.participant;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.xtext.ide.refactoring.XtextMoveResourceStrategy;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@SuppressWarnings("all")
public class XtextMoveResourceStrategyRegistry {
  private static Logger LOG = Logger.getLogger(XtextMoveResourceStrategyRegistry.class);
  
  private List<XtextMoveResourceStrategy> strategies;
  
  public List<? extends XtextMoveResourceStrategy> getStrategies() {
    List<? extends XtextMoveResourceStrategy> _elvis = null;
    if (this.strategies != null) {
      _elvis = this.strategies;
    } else {
      ArrayList<XtextMoveResourceStrategy> _xblockexpression = null;
      {
        final IConfigurationElement[] configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(this.getExtensionPointID());
        final ArrayList<XtextMoveResourceStrategy> strategies = CollectionLiterals.<XtextMoveResourceStrategy>newArrayList();
        for (final IConfigurationElement configurationElement : configurationElements) {
          try {
            Object _createExecutableExtension = configurationElement.createExecutableExtension("class");
            strategies.add(((XtextMoveResourceStrategy) _createExecutableExtension));
          } catch (final Throwable _t) {
            if (_t instanceof CoreException) {
              final CoreException e = (CoreException)_t;
              XtextMoveResourceStrategyRegistry.LOG.error("Error instantiating participant strategy", e);
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        }
        _xblockexpression = strategies;
      }
      _elvis = _xblockexpression;
    }
    return _elvis;
  }
  
  protected String getExtensionPointID() {
    return "org.eclipse.xtext.ui.resourceMoveStrategy";
  }
}
