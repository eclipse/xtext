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
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.resource.Resource.Factory.Descriptor;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.reference.services.ReferenceGrammarResourceFactory;
import org.eclipse.xtext.resource.XtextResource;

/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class ResourceFactoryTest extends AbstractServiceTest {
    
    public static final String REFERENCE_GRAMMAR_FILE_EXTENSION = "xtext";
    public void testResourceFactoryRegistration() throws Exception {
        // activate UI plugin
        Class.forName("org.eclipse.xtext.ui.editor.BaseTextEditor");
        ResourceSet rs = new ResourceSetImpl();
        Resource resource = rs.createResource(URI.createFileURI("test." + REFERENCE_GRAMMAR_FILE_EXTENSION));
        assertNotNull(resource);
        assertTrue(resource instanceof XtextResource);
        
        Resource.Factory.Descriptor factoryFromEmfRegistry = (Descriptor) Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().get(REFERENCE_GRAMMAR_FILE_EXTENSION);
        Factory factory = factoryFromEmfRegistry.createFactory();
        assertTrue(factory instanceof ReferenceGrammarResourceFactory);
    }
}
