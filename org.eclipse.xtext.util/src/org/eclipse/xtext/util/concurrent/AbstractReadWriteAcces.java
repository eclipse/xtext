/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
public abstract class AbstractReadWriteAcces<State> implements IReadAccess<State>, IWriteAccess<State> {

	private static Logger log = Logger.getLogger(AbstractReadWriteAcces.class);

	protected abstract State getState();

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
	public <Result> Result readOnly(IUnitOfWork<Result, State> work) {
		acquireReadLock();
		try {
			State state = getState();
			beforeReadOnly(state, work);
			Result exec = work.exec(state);
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

	@Override
	public <Result> Result modify(IUnitOfWork<Result, State> work) {
		acquireWriteLock();
		State state = null;
		Result exec = null;
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
	public <Result> Result process(IUnitOfWork<Result, State> work) {
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
	protected void beforeModify(State state, IUnitOfWork<?, State> work) {
	}

	/**
	 * is called before a read lock is obtained
	 * 
	 * @param work
	 *            - the unit of work to be processed
	 */
	protected void beforeReadOnly(State state, IUnitOfWork<?, State> work) {
	}

	/**
	 * is executed within the transaction right after the unit of work has been executed and delivered the result.
	 * 
	 * @param result - delivered result
	 * @param work  - the unit of work to be processed
	 */
	protected void afterModify(State state, Object result, IUnitOfWork<?, State> work) {
	}

	/**
	 * is executed within the transaction right after the unit of work has been executed and delivered the result.
	 * 
	 * @param result - delivered result
	 * @param work  - the unit of work to be processed
	 */
	protected void afterReadOnly(State state, Object result, IUnitOfWork<?, State> work) {
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