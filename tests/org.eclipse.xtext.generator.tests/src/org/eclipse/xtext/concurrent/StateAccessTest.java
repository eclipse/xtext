/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.concurrent;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.util.concurrent.IStateAccess;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import junit.framework.TestCase;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class StateAccessTest extends TestCase {

	public static class Foo {
		public String val = "foo";
	}

	public void testModifyAndRead() throws Exception {
		final Foo foo = new Foo();
		final IStateAccess.AbstractImpl<Foo> access = new IStateAccess.AbstractImpl<Foo>() {
			@Override
			protected Foo getState() {
				return foo;
			}
		};
		final List<Throwable> exceptions = new ArrayList<Throwable>();
		UncaughtExceptionHandler eh = new UncaughtExceptionHandler(){
			public void uncaughtException(Thread t, Throwable e) {
				exceptions.add(e);
			}
		};
		
		List<Thread> threads = new ArrayList<Thread>();

		for (int x = 0; x < 50; x++) {
			final int n = x;
			Thread thread2 = new Thread(reader(access));
			thread2.setUncaughtExceptionHandler(eh);
			thread2.start();
			threads.add(thread2);
			Thread thread = new Thread(changer(access, n));
			thread.setUncaughtExceptionHandler(eh);
			thread.start();
			threads.add(thread);
		}
		// wait for the threads to finish;
		for (Thread thread : threads) {
			thread.join();
		}
		assertTrue(exceptions.toString(),exceptions.isEmpty());
	}

	private Runnable changer(final IStateAccess<Foo> access, final int n) {
		return new Runnable() {
			public void run() {
				access.modify(new IUnitOfWork<Object, Foo>() {
					public Object exec(Foo state) throws Exception {
						state.val = "foo-" + n;
						return null;
					}
				});
			}
		};
	}

	private Runnable reader(final IStateAccess<Foo> access) {
		return new Runnable() {
			public void run() {
				access.readOnly(new IUnitOfWork<Object, Foo>() {
					
					// iterate 20 times { checking the state remains, wait 50 ms}
					public Object exec(Foo state) throws Exception {
						String val = state.val;
						for (int i = 0; i < 10; i++) {
							assertEquals(val, state.val);
							Thread.sleep(50);
						}
						return null;
					}
				});
			}
		};
	}

}
