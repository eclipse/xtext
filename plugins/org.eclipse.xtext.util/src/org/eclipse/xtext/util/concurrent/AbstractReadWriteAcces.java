/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.WrappedException;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein
 */
public abstract class AbstractReadWriteAcces<P> implements IReadAccess<P> {

	private static Logger log = Logger.getLogger(AbstractReadWriteAcces.class);

	protected abstract P getState();

	/**
	 * This field should be <code>private</code>. It is <code>protected</code> for API compatibility only. Never access
	 * this from the outside.
	 * 
	 * @noreference
	 */
	protected final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

	/**
	 * This field should be <code>private</code>. It is <code>protected</code> for API compatibility only. Never access
	 * this from the outside.
	 * 
	 * @noreference
	 */
	protected final Lock writeLock = rwLock.writeLock();

	/**
	 * This field should be <code>private</code>. It is <code>protected</code> for API compatibility only. Never access
	 * this from the outside.
	 * 
	 * @noreference
	 */
	protected final Lock readLock = rwLock.readLock();

	private ThreadLocal<Integer> readLockCount = new ThreadLocal<Integer>() {
		@Override
		protected Integer initialValue() {
			return 0;
		}
	};

	@Override
	public <T> T readOnly(IUnitOfWork<T, P> work) {
		acquireReadLock();
		try {
			P state = getState();
			beforeReadOnly(state, work);
			T exec = work.exec(state);
			afterReadOnly(state, exec, work);
			return exec;
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new WrappedException(e);
		} finally {
			releaseReadLock();
		}
	}

	public <T> T modify(IUnitOfWork<T, P> work) {
		acquireWriteLock();
		P state = null;
		T exec = null;
		try {
			state = getState();
			beforeModify(state, work);
			exec = work.exec(state);
			return exec;
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new WrappedException(e);
		} finally {
			releaseWriteLock();
			try {
				acquireReadLock();
				afterModify(state, exec, work);
			} finally {
				releaseReadLock();
			}
		}
	}

	/**
	 * Upgrades a read transaction to a write transaction, executes the work then downgrades to a read transaction
	 * again.
	 * 
	 * @since 2.4
	 * @noreference
	 */
	public <T> T process(IUnitOfWork<T, P> work) {
		releaseReadLock();
		acquireWriteLock();
		try {
			if (log.isTraceEnabled())
				log.trace("process - " + Thread.currentThread().getName());
			return modify(work);
		} finally {
			if (log.isTraceEnabled())
				log.trace("Downgrading from write lock to read lock...");
			acquireReadLock();
			releaseWriteLock();
		}
	}

	/**
	 * Is called before a write lock is obtained
	 * 
	 * @param work
	 *            - the unit of work to be processed
	 */
	protected void beforeModify(P state, IUnitOfWork<?, P> work) {
	}

	/**
	 * is called before a read lock is obtained
	 * 
	 * @param work
	 *            - the unit of work to be processed
	 */
	protected void beforeReadOnly(P state, IUnitOfWork<?, P> work) {
	}

	/**
	 * is executed within the transaction right after the unit of work has been executed and delivered the result.
	 * 
	 * @param result - delivered result
	 * @param work  - the unit of work to be processed
	 */
	protected void afterModify(P state, Object result, IUnitOfWork<?, P> work) {
	}

	/**
	 * is executed within the transaction right after the unit of work has been executed and delivered the result.
	 * 
	 * @param result - delivered result
	 * @param work  - the unit of work to be processed
	 */
	protected void afterReadOnly(P state, Object result, IUnitOfWork<?, P> work) {
	}

	/**
	 * Queries the number of reentrant write holds on this lock by the current thread. Delegates to
	 * {@link ReentrantReadWriteLock#getWriteHoldCount()}.
	 * 
	 * @return the number of holds on the write lock by the current thread, or zero if the write lock is not held by the
	 *         current thread
	 * @since 2.4
	 * @noreference
	 */
	protected int getWriteHoldCount() {
		return rwLock.getWriteHoldCount();
	}

	/**
	 * Queries the number of reentrant read holds on this lock by the current thread. A reader thread has a hold on a
	 * lock for each lock action that is not matched by an unlock action.
	 * 
	 * That functionality is implemented in {@link ReentrantReadWriteLock} as well, but not before version 1.6. This is
	 * why we have to find our own way to work around it.
	 * 
	 * @return the number of holds on the read lock by the current thread, or zero if the read lock is not held by the
	 *         current thread
	 * @since 2.4
	 * @noreference
	 */
	protected int getReadHoldCount() {
		return readLockCount.get();
	}

	private void acquireReadLock() {
		if (log.isTraceEnabled())
			log.trace("Trying to acquire read lock...");
		readLock.lock();
		readLockCount.set(readLockCount.get() + 1);
		if (log.isTraceEnabled())
			log.trace("...read lock acquired.");
	}

	private void releaseReadLock() {
		readLock.unlock();
		readLockCount.set(readLockCount.get() - 1);
		if (log.isTraceEnabled())
			log.trace("Read lock released.");
	}

	private void acquireWriteLock() {
		if (log.isTraceEnabled())
			log.trace("Trying to acquire write lock...");
		writeLock.lock();
		if (log.isTraceEnabled())
			log.trace("...write lock acquired.");
	}

	private void releaseWriteLock() {
		writeLock.unlock();
		if (log.isTraceEnabled())
			log.trace("Write lock released.");
	}

}