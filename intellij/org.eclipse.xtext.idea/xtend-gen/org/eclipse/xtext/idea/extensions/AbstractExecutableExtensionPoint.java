/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.extensions;

import com.google.common.base.Objects;
import com.intellij.openapi.extensions.AbstractExtensionPointBean;
import com.intellij.openapi.extensions.ExtensionFactory;
import com.intellij.openapi.extensions.PluginDescriptor;
import com.intellij.openapi.extensions.PluginId;
import com.intellij.util.xmlb.annotations.Attribute;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractExecutableExtensionPoint extends AbstractExtensionPointBean {
  @Attribute("factoryClass")
  private String factoryClass;
  
  @Attribute("class")
  private String implementationClass;
  
  public String getContributor() {
    PluginDescriptor _pluginDescriptor = this.getPluginDescriptor();
    PluginId _pluginId = null;
    if (_pluginDescriptor!=null) {
      _pluginId=_pluginDescriptor.getPluginId();
    }
    String _string = null;
    if (_pluginId!=null) {
      _string=_pluginId.toString();
    }
    return _string;
  }
  
  public Object createInstance() {
    try {
      Object _xblockexpression = null;
      {
        boolean _equals = Objects.equal(this.implementationClass, null);
        if (_equals) {
          throw this.asRuntimeException("Class is not specified");
        }
        Object _xifexpression = null;
        boolean _equals_1 = Objects.equal(this.factoryClass, null);
        if (_equals_1) {
          Class<Object> _findClass = this.<Object>findClass(this.implementationClass);
          _xifexpression = _findClass.newInstance();
        } else {
          Class<ExtensionFactory> _findClass_1 = this.<ExtensionFactory>findClass(this.factoryClass);
          ExtensionFactory _newInstance = _findClass_1.newInstance();
          _xifexpression = _newInstance.createInstance(null, this.implementationClass);
        }
        _xblockexpression = _xifexpression;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected RuntimeException asRuntimeException(final CharSequence message) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(message, "");
    _builder.append(", plugin id: ");
    String _contributor = this.getContributor();
    _builder.append(_contributor, "");
    _builder.append(".");
    return new RuntimeException(_builder.toString());
  }
}
