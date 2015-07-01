/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;

@SuppressWarnings("all")
public class XtextGeneratorNaming {
  public String getRuntimeBasePackage(final Grammar grammar) {
    return GrammarUtil.getNamespace(grammar);
  }
  
  public String getRuntimeGuiceModuleSimple(final Grammar grammar) {
    String _name = GrammarUtil.getName(grammar);
    return (_name + "RuntimeModule");
  }
  
  public String getRuntimeGuiceModuleFull(final Grammar grammar) {
    String _runtimeBasePackage = this.getRuntimeBasePackage(grammar);
    String _runtimeGuiceModuleSimple = this.getRuntimeGuiceModuleSimple(grammar);
    return (_runtimeBasePackage + _runtimeGuiceModuleSimple);
  }
  
  public String getRuntimeSetupSimple(final Grammar grammar) {
    String _name = GrammarUtil.getName(grammar);
    return (_name + "StandaloneSetup");
  }
  
  public String getRuntimeSetupFull(final Grammar grammar) {
    String _runtimeBasePackage = this.getRuntimeBasePackage(grammar);
    String _runtimeSetupSimple = this.getRuntimeSetupSimple(grammar);
    return (_runtimeBasePackage + _runtimeSetupSimple);
  }
  
  public String getRuntimeSetupImplSimple(final Grammar grammar) {
    String _name = GrammarUtil.getName(grammar);
    return (_name + "StandaloneSetupGenerated");
  }
  
  public String getRuntimeSetupImplFull(final Grammar grammar) {
    String _runtimeBasePackage = this.getRuntimeBasePackage(grammar);
    String _runtimeSetupImplSimple = this.getRuntimeSetupImplSimple(grammar);
    return (_runtimeBasePackage + _runtimeSetupImplSimple);
  }
}
