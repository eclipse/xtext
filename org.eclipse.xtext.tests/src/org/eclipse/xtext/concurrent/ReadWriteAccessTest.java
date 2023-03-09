/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.concurrent;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.util.concurrent.AbstractReadWriteAcces;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class ReadWriteAccessTest extends Assert {

	public static class Foo {
		public String val = "foo";
	}

	@Test public void testModifyAndRead() throws Exception {
		final Foo foo = new Foo();
		final AbstractReadWriteAcces<Foo> access = new AbstractReadWriteAcces<Foo>() {
			@Override
			protected Foo getState() {
				return foo;
			}
		};
		final List<Throwable> exceptions = new ArrayList<Throwable>();
		UncaughtExceptionHandler eh = new UncaughtExceptionHandler(){
			@Override
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

	private Runnable changer(final AbstractReadWriteAcces<Foo> access, final int n) {
		return new Runnable() {
			@Override
			public void run() {
				access.modify(new IUnitOfWork<Object, Foo>() {
					@Override
					public Object exec(Foo state) throws Exception {
						state.val = "foo-" + n;
						return null;
					}
				});
			}
		};
	}

	private Runnable reader(final AbstractReadWriteAcces<Foo> access) {
		return new Runnable() {
			@Override
			public void run() {
				access.readOnly(new IUnitOfWork<Object, Foo>() {
					
					// iterate 20 times { checking the state remains, wait 50 ms}
					@Override
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
