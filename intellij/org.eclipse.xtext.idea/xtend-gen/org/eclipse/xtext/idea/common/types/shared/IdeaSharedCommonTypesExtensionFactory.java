/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.common.types.shared;

import com.intellij.openapi.extensions.ExtensionFactory;
import org.eclipse.xtext.idea.common.types.shared.IdeaSharedCommonTypesLanguage;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class IdeaSharedCommonTypesExtensionFactory implements ExtensionFactory {
  @Override
  public Object createInstance(final String factoryArgument, final String implementationClass) {
    try {
      Object _xblockexpression = null;
      {
        final Class<?> clazz = Class.forName(implementationClass);
        _xblockexpression = IdeaSharedCommonTypesLanguage.INSTANCE.<Object>getInstance(clazz);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
