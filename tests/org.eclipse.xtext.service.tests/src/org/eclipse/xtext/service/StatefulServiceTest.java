/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.service;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public class StatefulServiceTest extends AbstractServiceTest {

	private class Patient {
		@Inject
		public IService service;
		
	}
	
	private interface IService {
	}
	
	public static abstract class AbstractService implements IService {
		public static int instanceCount = 0;
		
		public AbstractService (){
			instanceCount ++;
		}
	}

	public static class StatelessServiceImpl extends AbstractService {
	}
	
	@StatefulService
	public static class StatefulServiceImpl extends AbstractService {
		
	}
	
	@StatefulService
	public static class StatefulServiceWithCycleImpl extends AbstractService {
		@Inject
		public IService service;
	}
	
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		AbstractService.instanceCount = 0;
	}

	public void testStateless() throws Exception {
		ServiceRegistry.registerService(myScope, IService.class, StatelessServiceImpl.class);
		Patient patient = new Patient();
		
		assertEquals(0, AbstractService.instanceCount);
		ServiceRegistry.injectServices(myScope, patient);
		assertEquals(1, AbstractService.instanceCount);
		ServiceRegistry.injectServices(myScope, patient);
		assertEquals(1, AbstractService.instanceCount);
	}
	
	public void testStateful() throws Exception {
		ServiceRegistry.registerService(myScope, IService.class, StatefulServiceImpl.class);
		Patient patient = new Patient();
		
		assertEquals(0, AbstractService.instanceCount);
		ServiceRegistry.injectServices(myScope, patient);
		assertEquals(1, AbstractService.instanceCount);
		ServiceRegistry.injectServices(myScope, patient);
		assertEquals(2, AbstractService.instanceCount);
	}
	
	public void _testCycle() throws Exception {
		ServiceRegistry.registerService(myScope, IService.class, StatefulServiceWithCycleImpl.class);
		Patient patient = new Patient();
		
		assertEquals(0, AbstractService.instanceCount);
		try {
			ServiceRegistry.injectServices(myScope, patient);
			fail("should lead into out of memory or stack overflow");
		} catch (IllegalStateException e) {
			assertTrue(AbstractService.instanceCount > 1000);
		}
	}
	
}
