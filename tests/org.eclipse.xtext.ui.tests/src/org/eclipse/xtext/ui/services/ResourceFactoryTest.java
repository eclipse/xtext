/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.services;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;

/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class ResourceFactoryTest extends AbstractServiceTest {
    
    public static final String REFERENCE_GRAMMAR_FILE_EXTENSION = "tst";
    public void testResourceFactoryRegistration() throws Exception {
        ResourceSet rs = new ResourceSetImpl();
        Resource resource = rs.createResource(URI.createFileURI("test." + REFERENCE_GRAMMAR_FILE_EXTENSION));
        assertNotNull(resource);
        assertTrue(resource instanceof XtextResource);
        
        Object factoryFromEmfRegistry = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().get(REFERENCE_GRAMMAR_FILE_EXTENSION);
        IResourceFactory resourceFactory = getServiceForDefaultLanguage(IResourceFactory.class);
        assertEquals(resourceFactory, factoryFromEmfRegistry);
    }
}
