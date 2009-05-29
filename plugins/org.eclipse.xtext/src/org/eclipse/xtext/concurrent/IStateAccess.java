/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.eclipse.emf.common.util.WrappedException;


/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public interface IStateAccess<P> {
	
	public <T> T readOnly(IUnitOfWork<T,P> work);

	public <T> T modify(IUnitOfWork<T,P> work);
	
	public static abstract class AbstractImpl<P> implements IStateAccess<P> {

		protected abstract P getState();

		protected final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
		protected final Lock writeLock = rwLock.writeLock();
		protected final Lock readLock = rwLock.readLock();

		public <T> T readOnly(IUnitOfWork<T, P> work) {
			readLock.lock();
			try {
				P state = getState();
				beforeReadOnly(state,work);
				T exec = work.exec(state);
				afterReadOnly(state,exec,work);
				return exec;
			} catch (RuntimeException e) {
				throw e;
			} catch (Exception e) {
				throw new WrappedException(e);
			} finally {
				readLock.unlock();
			}
		}

		public <T> T modify(IUnitOfWork<T, P> work) {
			writeLock.lock();
			try {
				P state = getState();
				beforeModify(state, work);
				T exec = work.exec(state);
				afterModify(state,exec,work);
				return exec;
			} catch (RuntimeException e) {
				throw e;
			} catch (Exception e) {
				throw new WrappedException(e);
			} finally {
				writeLock.unlock();
			}
		}
		
		/**
		 * Is called before a write lock is obtained
		 * @param work - the unit of work to be processed
		 */
		protected void beforeModify(P state, IUnitOfWork<?, P> work) {}
		
		
		/**
		 * is called before a read lock is obtained
		 * @param work - the unit of work to be processed
		 */
		protected void beforeReadOnly(P state, IUnitOfWork<?, P> work) {}
		
		/**
		 * is executed within the transaction right after the unit of work has been executed and delivered the result.
		 * @param result
		 * @param work
		 */
		protected void afterModify(P state, Object result, IUnitOfWork<?, P> work) {}
		
		/**
		 * is executed within the transaction right after the unit of work has been executed and delivered the result.
		 * @param result
		 * @param work
		 */
		protected void afterReadOnly(P state, Object result, IUnitOfWork<?, P> work) {}

	}
}
