/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DelegatingScopeProviderTest implements IScopeWrapper {

	static class TestableDelegatingScopeProvider implements IDelegatingScopeProvider {

		private final IScopeProvider delegate;

		private int invocationCount = 0;
		
		TestableDelegatingScopeProvider(IScopeProvider delegate) {
			this.delegate = delegate;
		}
		
		TestableDelegatingScopeProvider() {
			this(new IScopeProvider() {
				@Override
				public IScope getScope(EObject context, EReference reference) {
					return IScope.NULLSCOPE;
				}
			});
		}
		
		@Override
		public void setWrapper(IScopeWrapper wrapper) {
			invocationCount++;
			IDelegatingScopeProvider.super.setWrapper(wrapper);
		}
		
		@Override
		public IScope getScope(EObject context, EReference reference) {
			Assert.fail("Unexpected invocation");
			return null;
		}

		@Override
		public IScopeProvider getDelegate() {
			return delegate;
		}
		
	}
	
	@Override
	public IScope wrap(IScope scope) {
		Assert.fail("Unexpected invocation");
		return null;
	}
	
	@Test
	public void testNoSuitableDelegate() {
		TestableDelegatingScopeProvider testMe = new TestableDelegatingScopeProvider();
		testMe.setWrapper(this);
		Assert.assertEquals(1, testMe.invocationCount);
		
		IDelegatingScopeProvider.setWrapper(testMe, null);
		Assert.assertEquals(2, testMe.invocationCount);
	}
	
	@Test
	public void testOneSuitableDelegate_01() {
		TestableDelegatingScopeProvider root = new TestableDelegatingScopeProvider();
		TestableDelegatingScopeProvider delegating = new TestableDelegatingScopeProvider(root);
		
		delegating.setWrapper(this);
		Assert.assertEquals(1, delegating.invocationCount);
		Assert.assertEquals(1, root.invocationCount);
		
		IDelegatingScopeProvider.setWrapper(delegating, null);
		Assert.assertEquals(2, delegating.invocationCount);
		Assert.assertEquals(2, root.invocationCount);
	}
	
	@Test
	public void testOneSuitableDelegate_02() {
		final int[] invocationCount = new int[] { 0 };
		AbstractGlobalScopeDelegatingScopeProvider root = new AbstractGlobalScopeDelegatingScopeProvider() {
			
			@Override
			public IScope getScope(EObject context, EReference reference) {
				return IScope.NULLSCOPE;
			}
			
			@Override
			public void setWrapper(IScopeWrapper wrapper) {
				invocationCount[0]++;
				Assert.assertEquals(DelegatingScopeProviderTest.this, wrapper);
				super.setWrapper(wrapper);
			}
		};
		TestableDelegatingScopeProvider delegating = new TestableDelegatingScopeProvider(root);
		
		delegating.setWrapper(this);
		Assert.assertEquals(1, delegating.invocationCount);
		Assert.assertEquals(1, invocationCount[0]);
	}
	
	@Test
	public void testTwoSuitableDelegates_02() {
		final int[] invocationCount = new int[] { 0 };
		AbstractGlobalScopeDelegatingScopeProvider first = new AbstractGlobalScopeDelegatingScopeProvider() {
			
			@Override
			public IScope getScope(EObject context, EReference reference) {
				return IScope.NULLSCOPE;
			}
			
			@Override
			public void setWrapper(IScopeWrapper wrapper) {
				invocationCount[0]++;
				Assert.assertEquals(DelegatingScopeProviderTest.this, wrapper);
				super.setWrapper(wrapper);
			}
		};
		AbstractGlobalScopeDelegatingScopeProvider second = new AbstractGlobalScopeDelegatingScopeProvider() {
			
			@Override
			public IScope getScope(EObject context, EReference reference) {
				return IScope.NULLSCOPE;
			}
			
			@Override
			public void setWrapper(IScopeWrapper wrapper) {
				invocationCount[0]++;
				Assert.assertEquals(DelegatingScopeProviderTest.this, wrapper);
				super.setWrapper(wrapper);
			}
		};
		
		TestableDelegatingScopeProvider delegating = new TestableDelegatingScopeProvider(first) {
			@Override
			public void setWrapper(IScopeWrapper wrapper) {
				IDelegatingScopeProvider.setWrapper(second, wrapper);
				super.setWrapper(wrapper);
			};
		};
		
		delegating.setWrapper(this);
		Assert.assertEquals(1, delegating.invocationCount);
		Assert.assertEquals(2, invocationCount[0]);
	}

}
