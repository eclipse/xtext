/*******************************************************************************
 * Copyright (c) 2016 TypeFox (https://typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.jvmmodel

import com.google.inject.Inject
import java.util.List
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.common.types.access.JvmTypeChangeDispatcher
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions
import org.junit.Test
import org.eclipse.xtext.resource.XtextResource

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class JvmTypeChangeDispatcherNotLeakingTest extends AbstractJvmModelTest {
    
    @Inject extension ReflectExtensions
    @Inject org.eclipse.xtext.xbase.jvmmodel.JvmElementsProxifyingUnloader unloader
 
    @Test def void testNoLeaking() {
        var contents = '''
            {val x = "foo"
            print(x)}
        '''.toString
        val resource = newResource(contents) as XtextResource
        EcoreUtil2.resolveAll(resource)
        val dispatcher = JvmTypeChangeDispatcher.findResourceChangeDispatcher(resource.resourceSet)
        var List<Runnable> listeners = dispatcher.get('listeners')
        assertEquals(2, listeners.size)
        
        // after reparse there still should only be two listeners
        resource.reparse(contents)
        EcoreUtil2.resolveAll(resource)
        listeners = dispatcher.get('listeners')
        assertEquals(2, listeners.size)
        
        // now unload, which should remove the listeners
        val jvmType = resource.contents.get(1)
        unloader.unloadRoot(jvmType)
        resource.contents.remove(jvmType)
        listeners = dispatcher.get('listeners')
        assertEquals(0, listeners.size)
    }
}