/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.linking.lazy;

import static com.google.common.collect.Iterables.*;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.index.IndexTestLanguageStandaloneSetup;
import org.eclipse.xtext.index.indexTestLanguage.Entity;
import org.eclipse.xtext.index.indexTestLanguage.IndexTestLanguagePackage;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider;
import org.eclipse.xtext.linking.impl.LinkingHelper;
import org.eclipse.xtext.linking.lazy.lazyLinking.Model;
import org.eclipse.xtext.linking.lazy.lazyLinking.Property;
import org.eclipse.xtext.linking.lazy.lazyLinking.Type;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.LeafNode;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class LazyLinkingResourceTest extends AbstractXtextTests {

    @Test public void testEObjectReference() throws Exception {
        final EAnnotation source = EcoreFactory.eINSTANCE.createEAnnotation();
        final EObject referencedObject = XtextFactory.eINSTANCE.createGrammar();

        LazyLinkingResource res = new LazyLinkingResource();
        res.setLinkingHelper(new LinkingHelper() {
        	@Override
        	public String getCrossRefNodeAsString(INode node, boolean convert) {
        		return node.getText();
        	}
        });
        res.setEncoder(new LazyURIEncoder() {
            @Override
            public boolean isCrossLinkFragment(Resource res, String s) {
                return "foo".equals(s);
            }

            @Override
            public Triple<EObject, EReference, INode> decode(Resource res, String uriFragment) {
                return Tuples.create((EObject) source, EcorePackage.Literals.EANNOTATION__REFERENCES,
                        (INode)new LeafNode());
            }
        });
        res.setLinkingService(new ILinkingService() {
            @Override
			public List<EObject> getLinkedObjects(EObject context, EReference reference, INode node)
                    throws IllegalNodeException {
                return Lists.newArrayList(referencedObject);
            }
        });
        res.setDiagnosticMessageProvider(new LinkingDiagnosticMessageProvider());
        assertEquals(referencedObject, res.getEObject("foo"));
    }
    
    @Test public void testWarningInsteadOfError() throws Exception {
    	final EAnnotation source = EcoreFactory.eINSTANCE.createEAnnotation();
        LazyLinkingResource res = new LazyLinkingResource();
        res.setEncoder(new LazyURIEncoder() {
            @Override
            public boolean isCrossLinkFragment(Resource res, String s) {
                return "foo".equals(s);
            }

            @Override
            public Triple<EObject, EReference, INode> decode(Resource res, String uriFragment) {
                return Tuples.create((EObject) source, EcorePackage.Literals.EANNOTATION__REFERENCES,
                        (INode) new LeafNode());
            }
        });
        res.setLinkingService(new ILinkingService() {
            @Override
			public List<EObject> getLinkedObjects(EObject context, EReference reference, INode node)
                    throws IllegalNodeException {
                return Collections.emptyList();
            }
        });
        res.setDiagnosticMessageProvider(new LinkingDiagnosticMessageProvider() {
        	@Override
        	public DiagnosticMessage getUnresolvedProxyMessage(ILinkingDiagnosticContext context) {
        		return new DiagnosticMessage("myMessage", Severity.WARNING, null);
        	}
        });
        assertTrue(res.getWarnings().isEmpty());
        assertNull(res.getEObject("foo"));
        assertEquals(1, res.getWarnings().size());
        assertTrue(res.getErrors().isEmpty());
        assertEquals("myMessage", res.getWarnings().get(0).getMessage());
	}
    
    public static class ProxyfyingResourceDecriptions extends ResourceSetBasedResourceDescriptions {
    	@Override
    	public IResourceDescription getResourceDescription(URI uri) {
    		final IResourceDescription resourceDescription = super.getResourceDescription(uri);
    		Iterable<IEObjectDescription> objects = resourceDescription.getExportedObjects();
    		for (IEObjectDescription ieObjectDescription : objects) {
				EObject eObject = ieObjectDescription.getEClass().getEPackage().getEFactoryInstance().create(ieObjectDescription.getEClass());
				((InternalEObject)eObject).eSetProxyURI(ieObjectDescription.getEObjectURI());
				try {
					Field field = ieObjectDescription.getClass().getDeclaredField("element");
					field.setAccessible(true);
					field.set(ieObjectDescription, eObject);
				} catch (Exception e) {}
			}
			return resourceDescription;
    	}
    }
    
    final EContentAdapter notificationAlert = new EContentAdapter(){
    	@Override
    	public void notifyChanged(Notification notification) {
    		if (notification.getFeature()!=null)
    			fail("Unexpected notification "+notification.toString());
    	}
    };
    
    @Test public void testResolveLazyCrossReferences() throws Exception {
    	with(testLangaugeSetup());
    	ResourceSetImpl rs = new ResourceSetImpl();
		final Resource res1 = rs.createResource(URI.createURI("file1.indextestlanguage"));
		Resource res2 = rs.createResource(URI.createURI("file2.indextestlanguage"));
		res1.load(new StringInputStream(
				  "foo { " 
				+ "  import bar.Bar" 
				+ "  entity Foo {" 
				+ "    Bar a1" 
				+ "    Foo a2" 
				+ "  }"
				+ "}"), null);
		res2.load(new StringInputStream(
				  "bar {" 
				+ "  entity Bar{}" 
				+ "}"), null);
		res1.eAdapters().add(notificationAlert);
		
		Entity e = (Entity) find(EcoreUtil2.eAllContents(res1.getContents().get(0)),new Predicate<EObject>() {
			@Override
			public boolean apply(EObject input) {
				return input instanceof Entity;
			}
		});
		
		assertTrue(((EObject)e.getProperties().get(0).eGet(IndexTestLanguagePackage.Literals.PROPERTY__TYPE, false)).eIsProxy());
		assertTrue(((EObject)e.getProperties().get(1).eGet(IndexTestLanguagePackage.Literals.PROPERTY__TYPE, false)).eIsProxy());
		((LazyLinkingResource)res1).resolveLazyCrossReferences(CancelIndicator.NullImpl);
		assertTrue(((EObject)e.getProperties().get(0).eGet(IndexTestLanguagePackage.Literals.PROPERTY__TYPE, false)).eIsProxy());
		assertFalse(((EObject)e.getProperties().get(1).eGet(IndexTestLanguagePackage.Literals.PROPERTY__TYPE, false)).eIsProxy());
		res1.eAdapters().remove(notificationAlert);
		EcoreUtil.resolveAll(res1);
		assertFalse(((EObject)e.getProperties().get(0).eGet(IndexTestLanguagePackage.Literals.PROPERTY__TYPE, false)).eIsProxy());
		assertFalse(((EObject)e.getProperties().get(1).eGet(IndexTestLanguagePackage.Literals.PROPERTY__TYPE, false)).eIsProxy());
	}
    
    @Test public void testResolveLazyCrossReferences_01() throws Exception {
    	with(testLangaugeSetup());
    	ResourceSetImpl rs = new ResourceSetImpl();
    	final Resource res1 = rs.createResource(URI.createURI("file1.indextestlanguage"));
    	Resource res2 = rs.createResource(URI.createURI("file2.indextestlanguage"));
    	res1.load(new StringInputStream(
    			"foo { " 
    			+ "  import bar.Bar" 
    			+ "  entity Foo {" 
    			+ "    Bar a1" 
    			+ "    Foo a2" 
    			+ "    Unresolvable a2" 
    			+ "  }"
    			+ "}"), null);
    	res2.load(new StringInputStream(
    			"bar {" 
    			+ "  entity Bar{}" 
    			+ "}"), null);
    	res1.eAdapters().add(notificationAlert);
    	Entity e = (Entity) find(EcoreUtil2.eAllContents(res1.getContents().get(0)),new Predicate<EObject>() {
    		@Override
			public boolean apply(EObject input) {
    			return input instanceof Entity;
    		}
    	});
    	assertEquals(0,res1.getErrors().size());
    	assertTrue(((EObject)e.getProperties().get(0).eGet(IndexTestLanguagePackage.Literals.PROPERTY__TYPE, false)).eIsProxy());
    	assertTrue(((EObject)e.getProperties().get(1).eGet(IndexTestLanguagePackage.Literals.PROPERTY__TYPE, false)).eIsProxy());
    	assertTrue(((EObject)e.getProperties().get(2).eGet(IndexTestLanguagePackage.Literals.PROPERTY__TYPE, false)).eIsProxy());
    	((LazyLinkingResource)res1).resolveLazyCrossReferences(CancelIndicator.NullImpl);
    	assertEquals(1,res1.getErrors().size());
    	assertTrue(((EObject)e.getProperties().get(0).eGet(IndexTestLanguagePackage.Literals.PROPERTY__TYPE, false)).eIsProxy());
    	assertFalse(((EObject)e.getProperties().get(1).eGet(IndexTestLanguagePackage.Literals.PROPERTY__TYPE, false)).eIsProxy());
    	assertTrue(((EObject)e.getProperties().get(2).eGet(IndexTestLanguagePackage.Literals.PROPERTY__TYPE, false)).eIsProxy());
    	res1.eAdapters().remove(notificationAlert);
    	EcoreUtil.resolveAll(res1);
    	assertEquals(1,res1.getErrors().size());
    	assertFalse(((EObject)e.getProperties().get(0).eGet(IndexTestLanguagePackage.Literals.PROPERTY__TYPE, false)).eIsProxy());
    	assertFalse(((EObject)e.getProperties().get(1).eGet(IndexTestLanguagePackage.Literals.PROPERTY__TYPE, false)).eIsProxy());
    	assertTrue(((EObject)e.getProperties().get(2).eGet(IndexTestLanguagePackage.Literals.PROPERTY__TYPE, false)).eIsProxy());
    }

	protected IndexTestLanguageStandaloneSetup testLangaugeSetup() {
		return new IndexTestLanguageStandaloneSetup(){
    		 @Override
    		public Injector createInjector() {
    			 return Guice.createInjector(new org.eclipse.xtext.index.IndexTestLanguageRuntimeModule() {
    				 @Override
    				public void configureIResourceDescriptions(Binder binder) {
    					 binder.bind(org.eclipse.xtext.resource.IResourceDescriptions.class).to(ProxyfyingResourceDecriptions.class);
    				}
    			 });
    		}
    	};
	}

	@Test public void testResolveLazyCrossReferences_02() throws Exception {
		with(lazyLinkingTestLangaugeSetup());
		ResourceSetImpl rs = new ResourceSetImpl();
		final Resource res1 = rs.createResource(URI.createURI("file1.lazylinkingtestlanguage"));
		Resource res2 = rs.createResource(URI.createURI("file2.lazylinkingtestlanguage"));
		res1.load(new StringInputStream("type Foo { } type Baz { Foo Bar prop; } }"), null);
		res2.load(new StringInputStream("type Bar { }"), null);
		res1.eAdapters().add(notificationAlert);
		
		Model m = (Model) res1.getContents().get(0);
		Type t = m.getTypes().get(1);
		Property p = t.getProperties().get(0);
		final InternalEList<Type> types = (InternalEList<Type>) p.getType();
		assertEquals(2, types.size());
		for (Iterator<Type> it = types.basicIterator(); it.hasNext();) {
			final Type tt = it.next();
			assertTrue(tt.eIsProxy());
		}
		((LazyLinkingResource) res1).resolveLazyCrossReferences(CancelIndicator.NullImpl);
		assertFalse(types.basicGet(0).eIsProxy());
		assertTrue(types.basicGet(1).eIsProxy());
		res1.eAdapters().remove(notificationAlert);
    	EcoreUtil.resolveAll(res1);
		assertFalse(types.basicGet(0).eIsProxy());
		assertFalse(types.basicGet(1).eIsProxy());
	}

	protected ISetup lazyLinkingTestLangaugeSetup() {
		return new LazyLinkingTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new org.eclipse.xtext.linking.lazy.LazyLinkingTestLanguageRuntimeModule() {
					@Override
					public void configureIResourceDescriptions(Binder binder) {
						binder.bind(org.eclipse.xtext.resource.IResourceDescriptions.class).to(
								ProxyfyingResourceDecriptions.class);
					}

					@Override
					public Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
						return org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider.class;
					}
				});
			}
		};
	}
}
