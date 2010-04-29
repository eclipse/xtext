/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.linking.lazy;

import java.util.Collections;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.diagnostics.DiagnosticSeverity;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.ParsetreeFactory;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;

import com.google.common.collect.Lists;

/**
 * @author Knut Wannheden - Initial contribution and API
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
        res.setDiagnosticMessageProvider(new LinkingDiagnosticMessageProvider());
        assertEquals(referencedObject, res.getEObject("foo"));
    }
    
    public void testWarningInsteadOfError() throws Exception {
    	final EAnnotation source = EcoreFactory.eINSTANCE.createEAnnotation();
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
                return Collections.emptyList();
            }
        });
        res.setDiagnosticMessageProvider(new LinkingDiagnosticMessageProvider() {
        	@Override
        	public DiagnosticMessage getUnresolvedProxyMessage(ILinkingDiagnosticContext context) {
        		return new DiagnosticMessage("myMessage", DiagnosticSeverity.WARNING, null);
        	}
        });
        assertTrue(res.getWarnings().isEmpty());
        assertNull(res.getEObject("foo"));
        assertEquals(1, res.getWarnings().size());
        assertTrue(res.getErrors().isEmpty());
        assertEquals("myMessage", res.getWarnings().get(0).getMessage());
	}
}
