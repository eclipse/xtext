/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.exporting;

import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.SimpleNameProvider;
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.IXtextGeneratorLanguage;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

@SuppressWarnings("all")
public class SimpleNamesFragment2 extends AbstractXtextGeneratorFragment {
  @Override
  public void generate() {
    GuiceModuleAccess.BindingFactory _bindingFactory = new GuiceModuleAccess.BindingFactory();
    TypeReference _typeRef = TypeReference.typeRef(IQualifiedNameProvider.class);
    TypeReference _typeRef_1 = TypeReference.typeRef(SimpleNameProvider.class);
    GuiceModuleAccess.BindingFactory _addfinalTypeToType = _bindingFactory.addfinalTypeToType(_typeRef, _typeRef_1);
    IXtextGeneratorLanguage _language = this.getLanguage();
    GuiceModuleAccess _runtimeGenModule = _language.getRuntimeGenModule();
    _addfinalTypeToType.contributeTo(_runtimeGenModule);
    GuiceModuleAccess.BindingFactory _bindingFactory_1 = new GuiceModuleAccess.BindingFactory();
    TypeReference _typeRef_2 = TypeReference.typeRef("org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator");
    TypeReference _typeRef_3 = TypeReference.typeRef("org.eclipse.xtext.ui.refactoring.impl.DefaultDependentElementsCalculator");
    GuiceModuleAccess.BindingFactory _addTypeToType = _bindingFactory_1.addTypeToType(_typeRef_2, _typeRef_3);
    IXtextGeneratorLanguage _language_1 = this.getLanguage();
    GuiceModuleAccess _eclipsePluginGenModule = _language_1.getEclipsePluginGenModule();
    _addTypeToType.contributeTo(_eclipsePluginGenModule);
  }
}
