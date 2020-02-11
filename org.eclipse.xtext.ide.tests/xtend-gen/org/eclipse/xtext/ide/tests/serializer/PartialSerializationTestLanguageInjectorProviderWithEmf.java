/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.serializer;

import com.google.inject.Injector;
import org.eclipse.xtext.ide.tests.testlanguage.tests.PartialSerializationTestLanguageInjectorProvider;
import org.eclipse.xtext.testlanguages.ecore.EcoreSupport;

@SuppressWarnings("all")
public class PartialSerializationTestLanguageInjectorProviderWithEmf extends PartialSerializationTestLanguageInjectorProvider {
  @Override
  protected Injector internalCreateInjector() {
    final Injector result = super.internalCreateInjector();
    new EcoreSupport().createInjectorAndDoEMFRegistration();
    return result;
  }
}
