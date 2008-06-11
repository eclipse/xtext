/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.services;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.xtext.ui.service.LanguageDescriptorHierarchyUtil;
import org.eclipse.xtext.ui.service.LanguageDescriptorHierarchyUtil.LanguageDescriptorDescriptor;
/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class LanguageDescriptorRegistrationTest extends TestCase {
    public void testCyclicHierarchy() throws Exception {
        LanguageDescriptorDescriptor l0 = new LanguageDescriptorDescriptor();
        l0.languageId="X";
        l0.superLanguageID="Y";
        LanguageDescriptorDescriptor l1 = new LanguageDescriptorDescriptor();
        l1.languageId="Y";
        l1.superLanguageID="X";
        LanguageDescriptorDescriptor l2 = new LanguageDescriptorDescriptor();
        l2.languageId="Z";
        ArrayList<LanguageDescriptorDescriptor> ldds = new ArrayList<LanguageDescriptorDescriptor>();
        ldds.add(l0); ldds.add(l2); ldds.add(l1);
        List<LanguageDescriptorDescriptor> sortedLDDs = LanguageDescriptorHierarchyUtil.sortLanguageDescriptors(ldds);
        assertEquals(1, sortedLDDs.size());
    }
    
    public void testSorting() throws Exception {
        LanguageDescriptorDescriptor x = new LanguageDescriptorDescriptor();
        x.languageId="X";
        x.superLanguageID="Y";
        LanguageDescriptorDescriptor y = new LanguageDescriptorDescriptor();
        y.languageId="Y";
        y.superLanguageID="Z";
        LanguageDescriptorDescriptor z = new LanguageDescriptorDescriptor();
        z.languageId="Z";
        LanguageDescriptorDescriptor a = new LanguageDescriptorDescriptor();
        a.languageId="A";
        a.superLanguageID="Y";
        ArrayList<LanguageDescriptorDescriptor> ldds = new ArrayList<LanguageDescriptorDescriptor>();
        ldds.add(x); ldds.add(y); ldds.add(z); ldds.add(a);
        List<LanguageDescriptorDescriptor> sortedLDDs = LanguageDescriptorHierarchyUtil.sortLanguageDescriptors(ldds);
        assertTrue(sortedLDDs.indexOf(x) > sortedLDDs.indexOf(y));
        assertTrue(sortedLDDs.indexOf(y) > sortedLDDs.indexOf(z));
        assertTrue(sortedLDDs.indexOf(a) > sortedLDDs.indexOf(y));
        assertEquals(0,sortedLDDs.indexOf(z));
    }
}
