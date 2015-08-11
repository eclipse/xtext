/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.config;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.intellij.framework.FrameworkTypeEx;
import com.intellij.framework.addSupport.FrameworkSupportInModuleConfigurable;
import com.intellij.framework.addSupport.FrameworkSupportInModuleProvider;
import com.intellij.ide.util.frameworkSupport.FrameworkSupportModel;
import com.intellij.openapi.module.JavaModuleType;
import com.intellij.openapi.module.ModuleType;
import org.eclipse.xtend.core.idea.config.XtendFrameworkType;
import org.eclipse.xtend.core.idea.config.XtendSupportConfigurable;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendFrameworkSupportProvider extends FrameworkSupportInModuleProvider {
  @Inject
  private Provider<XtendSupportConfigurable> xtendSupportConfigurableProvider;
  
  public XtendFrameworkSupportProvider() {
    XtendLanguage.INSTANCE.injectMembers(this);
  }
  
  @Override
  public FrameworkTypeEx getFrameworkType() {
    return FrameworkTypeEx.EP_NAME.<XtendFrameworkType>findExtension(XtendFrameworkType.class);
  }
  
  @Override
  public FrameworkSupportInModuleConfigurable createConfigurable(final FrameworkSupportModel model) {
    return this.xtendSupportConfigurableProvider.get();
  }
  
  @Override
  public boolean isEnabledForModuleType(final ModuleType moduleType) {
    return (moduleType instanceof JavaModuleType);
  }
}
