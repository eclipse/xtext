/*******************************************************************************
 * Copyright (c) 2013, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.junit.ui;

import static com.google.common.collect.Lists.*;

import java.util.Queue;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.impl.DefaultReferenceDescription;
import org.eclipse.xtext.ui.editor.findrefs.IReferenceFinder;
import org.eclipse.xtext.ui.editor.findrefs.ResourceAccess;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.ui.jvmmodel.findrefs.JvmModelReferenceQueryExecutor;
import org.junit.Assert;

import com.google.common.base.Predicate;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @deprecated Use org.eclipse.xtext.xbase.ui.testing.FindReferencesTestUtil instead
 */
@Deprecated(forRemoval = true)
public class FindReferencesTestUtil extends Assert {

	@Inject
	private Provider<CheckingReferenceQueryExecutor> executorProvider;
	
	public void checkFindReferences(EObject target, String expectedLabel, final MockAcceptor mockAcceptor) {
		CheckingReferenceQueryExecutor executor = executorProvider.get();
		executor.init(target, expectedLabel, mockAcceptor);
		executor.execute();
		mockAcceptor.assertFinished();
	}

	public static class CheckingReferenceQueryExecutor extends JvmModelReferenceQueryExecutor {

		@Inject
		private IReferenceFinder referenceFinder;
		
		@Inject
		private Provider<ResourceAccess> resourceAccessProvider;
		
		private Iterable<URI> targetURIs;
		private Predicate<IReferenceDescription> filter;
		private ResourceAccess localResourceAccess;
		private IAcceptor<IReferenceDescription> filteringAcceptor;

		@Override
		public void init(EObject target) {
		}

		public void init(EObject target, String expectedLabel, final IAcceptor<IReferenceDescription> acceptor) {
			targetURIs = getTargetURIs(target);
			filter = getFilter(target);
			assertEquals(expectedLabel, getLabel(target));
			this.filteringAcceptor = new IAcceptor<IReferenceDescription>() {
				@Override
				public void accept(IReferenceDescription t) {
					if (filter.apply(t))
						acceptor.accept(t);
				}
			};
			localResourceAccess = resourceAccessProvider.get();
			localResourceAccess.registerResourceSet(target.eResource().getResourceSet());
		}

		@Override
		public void execute() {
			referenceFinder.findAllReferences(targetURIs, localResourceAccess, filteringAcceptor, null);
		}
	}

	public static class MockAcceptor implements IAcceptor<IReferenceDescription> {

		private Queue<IReferenceDescription> expectationQueue = newLinkedList();

		public void expect(EObject from, EObject to, EReference eReference) {
			expectationQueue.add(new DefaultReferenceDescription(from, to, eReference, 0, null));
		}

		public void assertFinished() {
			IReferenceDescription nextExpected = expectationQueue.poll();
			if (nextExpected != null)
				fail("Expected " + toString(nextExpected));
		}

		private String toString(IReferenceDescription rd) {
			return rd.getSourceEObjectUri() + " ---" + rd.getEReference().getName() + "---> "
					+ rd.getTargetEObjectUri();
		}

		private String toString(IReferenceDescription expected, IReferenceDescription actual) {
			return "Expected: \n" + toString(expected) + "\n but got:\n" + toString(actual) + "\n queueSize="
					+ expectationQueue.size() + "\n";
		}

		@Override
		public void accept(IReferenceDescription description) {
			IReferenceDescription nextExpected = expectationQueue.poll();
			assertNotNull(nextExpected);
			assertEquals(toString(nextExpected, description), nextExpected.getSourceEObjectUri(),
					description.getSourceEObjectUri());
			assertEquals(toString(nextExpected, description), nextExpected.getTargetEObjectUri(),
					description.getTargetEObjectUri());
			assertEquals(toString(nextExpected, description), nextExpected.getEReference(), description.getEReference());
		}

	}
}
