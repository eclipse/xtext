/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser;

import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.xtext.conversion.IValueConverterService;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class DefaultEcoreElementFactoryTest extends TestCase {

    public void testConvertNullInput() throws Exception {
        EClass eClass = EcoreFactory.eINSTANCE.createEClass();
        IValueConverterService converter = EasyMock.createMock(IValueConverterService.class);

        converter.toValue(null, "foo", null);
        EasyMock.expectLastCall().andReturn("FOO");

        EasyMock.replay(converter);
        DefaultEcoreElementFactory factory = new DefaultEcoreElementFactory();
        factory.setConverterService(converter);
        factory.set(eClass, "name", null, "foo", null);

        EasyMock.verify(converter);
        assertEquals("FOO", eClass.getName());
    }
}
