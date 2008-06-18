/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.services.bearing;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.xtext.ui.services.AbstractServiceTest;


/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class ServiceInjectionTest extends AbstractServiceTest {
    public void testInjection() throws Exception {  
        IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
        IConfigurationElement[] configurationElements = extensionRegistry.getConfigurationElementsFor("org.eclipse.xtext.ui.tests", "testExtensionPoint", "org.eclipse.xtext.ui.tests.myid");
        assertEquals(1, configurationElements.length);
        Object executableExtension = configurationElements[0].createExecutableExtension("class");
        assertTrue(executableExtension instanceof SampleServiceDependentClass);
        assertNotNull(((SampleServiceDependentClass) executableExtension).getParser());
    }
}
