/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.shared;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.xtext.idea.shared.IdeaSharedModule;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class IdeaSharedInjectorProvider {
  private static Injector injector;
  
  public static synchronized Injector getInjector() {
    Injector _elvis = null;
    if (IdeaSharedInjectorProvider.injector != null) {
      _elvis = IdeaSharedInjectorProvider.injector;
    } else {
      IdeaSharedModule _ideaSharedModule = new IdeaSharedModule();
      Injector _createInjector = Guice.createInjector(_ideaSharedModule);
      Injector _injector = (IdeaSharedInjectorProvider.injector = _createInjector);
      _elvis = _injector;
    }
    return _elvis;
  }
  
  public static void injectMembers(final Object o) {
    Injector _injector = IdeaSharedInjectorProvider.getInjector();
    _injector.injectMembers(o);
  }
}
