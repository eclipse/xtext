/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.linking.lazy;

import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.ParsetreeFactory;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;

import com.google.common.collect.Lists;

/**
 * @author Knut Wannheden - Initial contribution and API
 *
 */
public class LazyLinkingResourceTest extends TestCase {

    public void testEObjectReference() throws Exception {
        final EAnnotation source = EcoreFactory.eINSTANCE.createEAnnotation();
        final EObject referencedObject = XtextFactory.eINSTANCE.createGrammar();

        LazyLinkingResource res = new LazyLinkingResource();
        res.setEncoder(new LazyURIEncoder() {
            @Override
            public boolean isCrossLinkFragment(Resource res, String s) {
                return "foo".equals(s);
            }

            @Override
            public Triple<EObject, EReference, AbstractNode> decode(Resource res, String uriFragment) {
                return Tuples.create((EObject) source, EcorePackage.Literals.EANNOTATION__REFERENCES,
                        (AbstractNode) ParsetreeFactory.eINSTANCE.createLeafNode());
            }
        });
        res.setLinkingService(new ILinkingService() {
            public List<EObject> getLinkedObjects(EObject context, EReference reference, AbstractNode node)
                    throws IllegalNodeException {
                return Lists.newArrayList(referencedObject);
            }
        });

        assertEquals(referencedObject, res.getEObject("foo"));
    }
}
