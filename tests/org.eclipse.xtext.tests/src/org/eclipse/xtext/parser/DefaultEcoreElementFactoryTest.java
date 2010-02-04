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
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.ParsetreeFactory;

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
    
    public void testNullInput() throws Exception {
    	EClass eClass = EcoreFactory.eINSTANCE.createEClass();
    	LeafNode node = ParsetreeFactory.eINSTANCE.createLeafNode();
        IValueConverterService converter = EasyMock.createMock(IValueConverterService.class);
        converter.toValue(null, "foo", node);
        EasyMock.expectLastCall().andReturn(null);
        EasyMock.replay(converter);
        
        DefaultEcoreElementFactory factory = new DefaultEcoreElementFactory();
        factory.setConverterService(converter);
        try {
        	factory.set(eClass, "abstract", null, "foo", node);
        	fail("Expected ValueConverterException");
        } catch(ValueConverterException ex) {
        	assertTrue(ex.getCause() instanceof NullPointerException);
        	assertTrue(ex.getMessage().indexOf("NullPointerException") >= 0);
        	assertSame(node, ex.getNode());
        }
        EasyMock.verify(converter);
    }
    
    public void testValueConverterException() throws Exception {
    	EClass eClass = EcoreFactory.eINSTANCE.createEClass();
    	LeafNode node = ParsetreeFactory.eINSTANCE.createLeafNode();
    	ValueConverterException expected = new ValueConverterException("Foo", node, null);
        IValueConverterService converter = EasyMock.createMock(IValueConverterService.class);
        converter.toValue(null, "foo", node);
        EasyMock.expectLastCall().andThrow(expected);
        EasyMock.replay(converter);
        
        DefaultEcoreElementFactory factory = new DefaultEcoreElementFactory();
        factory.setConverterService(converter);
        try {
        	factory.set(eClass, "abstract", null, "foo", node);
        	fail("Expected ValueConverterException");
        } catch(ValueConverterException ex) {
        	assertSame(expected, ex);
        }
        EasyMock.verify(converter);
    }
}
