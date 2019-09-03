/**
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.testlanguage;

import com.google.inject.Injector;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.ide.tests.testlanguage.PartialSerializationTestLanguageStandaloneSetupGenerated;
import org.eclipse.xtext.ide.tests.testlanguage.withtransient.WithtransientPackage;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
@SuppressWarnings("all")
public class PartialSerializationTestLanguageStandaloneSetup extends PartialSerializationTestLanguageStandaloneSetupGenerated {
  public static void doSetup() {
    new PartialSerializationTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
  }
  
  @Override
  public void register(final Injector injector) {
    super.register(injector);
    boolean _containsKey = EPackage.Registry.INSTANCE.containsKey(
      "http://www.eclipse.org/xtext/ide/tests/testlanguage/mm/withtransient");
    boolean _not = (!_containsKey);
    if (_not) {
      EPackage.Registry.INSTANCE.put("http://www.eclipse.org/xtext/ide/tests/testlanguage/mm/withtransient", 
        WithtransientPackage.eINSTANCE);
    }
  }
}
