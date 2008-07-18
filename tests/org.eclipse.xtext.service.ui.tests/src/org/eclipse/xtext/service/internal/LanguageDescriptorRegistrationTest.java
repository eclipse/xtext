/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.service.internal;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.xtext.service.ui.internal.ScopeDescriptor;
import org.eclipse.xtext.service.ui.internal.ScopeUtil;

/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class LanguageDescriptorRegistrationTest extends TestCase {
    public void testCyclicHierarchy() throws Exception {
        ScopeDescriptor l0 = new ScopeDescriptor();
        l0.id="X";
        l0.parentScope="Y";
        ScopeDescriptor l1 = new ScopeDescriptor();
        l1.id="Y";
        l1.parentScope="X";
        ScopeDescriptor l2 = new ScopeDescriptor();
        l2.id="Z";
        ArrayList<ScopeDescriptor> ldds = new ArrayList<ScopeDescriptor>();
        ldds.add(l0); ldds.add(l2); ldds.add(l1);
        List<ScopeDescriptor> sortedLDDs = ScopeUtil.sortScopeDescriptors(ldds);
        assertEquals(1, sortedLDDs.size());
    }
    
    public void testSorting() throws Exception {
        ScopeDescriptor x = new ScopeDescriptor();
        x.id="X";
        x.parentScope="Y";
        ScopeDescriptor y = new ScopeDescriptor();
        y.id="Y";
        y.parentScope="Z";
        ScopeDescriptor z = new ScopeDescriptor();
        z.id="Z";
        ScopeDescriptor a = new ScopeDescriptor();
        a.id="A";
        a.parentScope="Y";
        ArrayList<ScopeDescriptor> ldds = new ArrayList<ScopeDescriptor>();
        ldds.add(x); ldds.add(y); ldds.add(z); ldds.add(a);
        List<ScopeDescriptor> sortedLDDs = ScopeUtil.sortScopeDescriptors(ldds);
        assertTrue(sortedLDDs.indexOf(x) > sortedLDDs.indexOf(y));
        assertTrue(sortedLDDs.indexOf(y) > sortedLDDs.indexOf(z));
        assertTrue(sortedLDDs.indexOf(a) > sortedLDDs.indexOf(y));
        assertEquals(0,sortedLDDs.indexOf(z));
    }
}
