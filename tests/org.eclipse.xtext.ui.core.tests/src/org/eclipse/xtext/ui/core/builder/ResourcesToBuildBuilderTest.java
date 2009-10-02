/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.builder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import com.google.common.collect.Lists;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ResourcesToBuildBuilderTest extends TestCase {
	/**
	 * @author Sven Efftinge - Initial contribution and API
	 */
	public static class SimpleTestBuilder implements ILanguageBuilder {
		private XMIResourceImpl resource;
		private boolean validated;
		private boolean built;

		public void doBuild(Resource res, IProgressMonitor monitor) {
			assertTrue(validated);
			assertSame(resource,res);
			built = true;
		}

		public Resource load(org.eclipse.emf.common.util.URI uri, ResourceSet resourceSet, IProgressMonitor monitor) {
			this.resource = new XMIResourceImpl(uri);
			resourceSet.getResources().add(resource);
			return resource;
		}

		public List<Map<String, Object>> validate(Resource res, IProgressMonitor monitor) {
			assertSame(resource,res);
			validated = true;
			return null;
		}
		
		public boolean isBuilt() {
			return built;
		}

		public void indexEObjectDescriptors(Resource resource, IEObjectDescriptorIndexer feeder,
				IProgressMonitor monitor) {
		}

		public void indexEReferenceDescriptors(Resource resource, IEReferenceDescriptorIndexer feeder,
				IProgressMonitor monitor) {
		}
	}

	public void testSimple() throws Exception {
		ResourceSetImpl rs = new ResourceSetImpl();
		
		SimpleTestBuilder builder = new SimpleTestBuilder();
		SimpleTestBuilder builder2 = new SimpleTestBuilder();
		SimpleTestBuilder builder3 = new SimpleTestBuilder();
		
		List<ResourceToBuild> list = Lists.newArrayList(	
				new ResourceToBuild(rs,URI.createURI("foo.bar1"), mockResource(), builder,false),
				new ResourceToBuild(rs,URI.createURI("foo.bar2"), mockResource(),builder2,true),
				new ResourceToBuild(rs,URI.createURI("foo.bar3"), mockResource(),builder3,false));
		
		new ResourcesToBuildBuilder(null).doBuild("bar",list, new org.eclipse.core.runtime.NullProgressMonitor());
		
		assertTrue(builder.isBuilt());
		assertFalse(builder2.isBuilt());
		assertTrue(builder3.isBuilt());
	}
	
	private IResource mockResource() {
		return (IResource) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[] {IResource.class}, new InvocationHandler() {
			
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				if (method.getName().equals("exists"))
					return false;
				return null;
			}
		});
	}

	public void testCanceledProgressMonitor() throws Exception {
		ResourceSetImpl rs = new ResourceSetImpl();
		
		SimpleTestBuilder builder = new SimpleTestBuilder();
		SimpleTestBuilder builder2 = new SimpleTestBuilder();
		SimpleTestBuilder builder3 = new SimpleTestBuilder();
		
		List<ResourceToBuild> list = Lists.newArrayList(	
				new ResourceToBuild(rs,URI.createURI("foo.bar1"),mockResource(), builder,false),
				new ResourceToBuild(rs,URI.createURI("foo.bar2"),mockResource(), builder2,true),
				new ResourceToBuild(rs,URI.createURI("foo.bar3"),mockResource(), builder3,false));
		
		new ResourcesToBuildBuilder(null).doBuild("bar",list, new org.eclipse.core.runtime.NullProgressMonitor() {
			@Override
			public boolean isCanceled() {
				return true;
			}
		});
		
		assertFalse(builder.isBuilt());
		assertFalse(builder2.isBuilt());
		assertFalse(builder3.isBuilt());
	}
	
	public void testEverythingIsLoadedBeforeValidate() throws Exception {
		final ResourceSetImpl rs = new ResourceSetImpl();
		
		SimpleTestBuilder builder = new SimpleTestBuilder() {
			@Override
			public List<Map<String, Object>> validate(Resource res, IProgressMonitor monitor) {
				assertEquals(2,rs.getResources().size());
				return super.validate(res, monitor);
			}
		};
		SimpleTestBuilder builder2 = new SimpleTestBuilder();
		SimpleTestBuilder builder3 = new SimpleTestBuilder();
		
		List<ResourceToBuild> list = Lists.newArrayList(	
				new ResourceToBuild(rs,URI.createURI("foo.bar1"),mockResource(), builder,false),
				new ResourceToBuild(rs,URI.createURI("foo.bar2"),mockResource(), builder2,true),
				new ResourceToBuild(rs,URI.createURI("foo.bar3"), mockResource(),builder3,false));
		
		new ResourcesToBuildBuilder(null).doBuild("bar",list, new org.eclipse.core.runtime.NullProgressMonitor());
		
		assertTrue(builder.isBuilt());
		assertFalse(builder2.isBuilt());
		assertTrue(builder3.isBuilt());
	}
	
}
