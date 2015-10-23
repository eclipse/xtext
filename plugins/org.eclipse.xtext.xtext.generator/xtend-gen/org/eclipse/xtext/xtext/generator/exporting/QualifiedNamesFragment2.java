/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.exporting;

import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.IXtextGeneratorLanguage;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

@SuppressWarnings("all")
public class QualifiedNamesFragment2 extends AbstractXtextGeneratorFragment {
  @Override
  public void generate() {
    GuiceModuleAccess.BindingFactory _bindingFactory = new GuiceModuleAccess.BindingFactory();
    TypeReference _typeRef = TypeReference.typeRef(IQualifiedNameProvider.class);
    TypeReference _typeRef_1 = TypeReference.typeRef(DefaultDeclarativeQualifiedNameProvider.class);
    GuiceModuleAccess.BindingFactory _addTypeToType = _bindingFactory.addTypeToType(_typeRef, _typeRef_1);
    IXtextGeneratorLanguage _language = this.getLanguage();
    GuiceModuleAccess _runtimeGenModule = _language.getRuntimeGenModule();
    _addTypeToType.contributeTo(_runtimeGenModule);
    GuiceModuleAccess.BindingFactory _bindingFactory_1 = new GuiceModuleAccess.BindingFactory();
    TypeReference _typeRef_2 = TypeReference.typeRef("org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher");
    TypeReference _typeRef_3 = TypeReference.typeRef("org.eclipse.xtext.ui.editor.contentassist.FQNPrefixMatcher");
    GuiceModuleAccess.BindingFactory _addTypeToType_1 = _bindingFactory_1.addTypeToType(_typeRef_2, _typeRef_3);
    TypeReference _typeRef_4 = TypeReference.typeRef("org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator");
    TypeReference _typeRef_5 = TypeReference.typeRef("org.eclipse.xtext.ui.refactoring.impl.DefaultDependentElementsCalculator");
    GuiceModuleAccess.BindingFactory _addTypeToType_2 = _addTypeToType_1.addTypeToType(_typeRef_4, _typeRef_5);
    IXtextGeneratorLanguage _language_1 = this.getLanguage();
    GuiceModuleAccess _eclipsePluginGenModule = _language_1.getEclipsePluginGenModule();
    _addTypeToType_2.contributeTo(_eclipsePluginGenModule);
  }
}
