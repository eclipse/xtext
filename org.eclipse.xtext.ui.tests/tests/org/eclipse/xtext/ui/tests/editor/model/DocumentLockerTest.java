/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tests.editor.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.parser.antlr.internal.InternalXtextLexer;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.model.DocumentTokenSource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.ITextEditComposer;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein
 */
public class DocumentLockerTest extends AbstractXtextDocumentTest {
	@Test
	public void testNoUpdateContentProcessOnReentrant() {
		List<String> s = new ArrayList<>();
		XtextDocument document = new XtextDocument(createTokenSource(), createTextEditComposer(), outdatedStateManager,
				operationCanceledManager) {
			@Override
			protected boolean updateContentBeforeRead() {
				return s.add("x");
			}
		};
		XtextResource resource = new XtextResource();
		new XtextResourceSet().getResources().add(resource);
		document.setInput(resource);
		Assert.assertEquals(0, s.size());
		document.readOnly(r1 -> {
			Assert.assertEquals(1, s.size());
			document.readOnly(r2 -> {
				Assert.assertEquals(1, s.size());
				document.readOnly(r3 -> {
					Assert.assertEquals(1, s.size());
					return null;
				});
				return null;
			});
			return null;
		});
		Assert.assertEquals(1, s.size());
	}

	@Test
	public void testModifySetsOutdatedFalse() {
		XtextDocument document = new XtextDocument(createTokenSource(), createTextEditComposer(), outdatedStateManager,
				operationCanceledManager);
		XtextResource resource = new XtextResource();
		new XtextResourceSet().getResources().add(resource);
		document.setInput(resource);
		document.internalModify((XtextResource it) -> {
			Assert.assertFalse(document.getCancelIndicator().isCanceled());
			return null;
		});
		CancelIndicator indicator = document.getCancelIndicator();
		Assert.assertFalse(indicator.isCanceled());
		document.set("fupp");
		Assert.assertTrue(indicator.isCanceled());
		document.internalModify((XtextResource it) -> {
			Assert.assertFalse(document.getCancelIndicator().isCanceled());
			return null;
		});
	}

	@Test
	public void testPriorityReadOnlyCancelsReaders() throws Exception {
		Thread.interrupted(); // prevent random test failures: https://github.com/junit-team/junit4/issues/1365
		XtextDocument document = new XtextDocument(createTokenSource(), null, outdatedStateManager, operationCanceledManager);
		XtextResource resource = new XtextResource();
		new XtextResourceSet().getResources().add(resource);
		document.setInput(resource);
		CountDownLatch check = new CountDownLatch(1);
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				document.readOnly(new CancelableUnitOfWork<Object, XtextResource>() {
					@Override
					public Object exec(XtextResource state, CancelIndicator cancelIndicator) throws Exception {
						check.countDown();
						int wait = 4000;
						int i = 0;
						while (!cancelIndicator.isCanceled()) {
							Thread.sleep(10L);
							if (i > wait) {
								throw new InterruptedException();
							}
							i = i + 1;
						}
						return null;
					}
				});
			}

		};
		Thread thread = new Thread(runnable);
		thread.start();
		check.await();
		document.priorityReadOnly(r -> null);
		Assert.assertFalse(thread.isInterrupted());
	}

	@Test
	public void testReadOnlyDoesntCancelReaders() {
		XtextDocument document = new XtextDocument(createTokenSource(), null, outdatedStateManager, operationCanceledManager);
		XtextResource resource = new XtextResource();
		new XtextResourceSet().getResources().add(resource);
		document.setInput(resource);
		List<CancelIndicator> cancelIndicators = new ArrayList<>();
		addReaderCancelationListener(document, cancelIndicators);
		Assert.assertTrue(cancelIndicators.isEmpty());
		document.readOnly(r -> null);
		Assert.assertTrue(cancelIndicators.isEmpty());
		document.readOnly(r -> null);
		Assert.assertTrue(cancelIndicators.isEmpty());
	}

	private DocumentTokenSource createTokenSource() {
		DocumentTokenSource tokenSource = new DocumentTokenSource();
		tokenSource.setLexer(() -> new InternalXtextLexer());
		return tokenSource;
	}

	private ITextEditComposer createTextEditComposer() {
		return new ITextEditComposer() {
			@Override
			public void beginRecording(Resource resource) {
			}

			@Override
			public TextEdit endRecording() {
				return null;
			}

			@Override
			public TextEdit getTextEdit() {
				return null;
			}
		};
	}

	private void addReaderCancelationListener(IXtextDocument document, List<CancelIndicator> cancelIndicators) {
		document.addModelListener((XtextResource it) -> {
			CancelableUnitOfWork<Boolean, XtextResource> work = new CancelableUnitOfWork<Boolean, XtextResource>() {
				@Override
				public Boolean exec(XtextResource state, CancelIndicator cancelIndicator) throws Exception {
					Assert.assertFalse(cancelIndicator.isCanceled());
					return cancelIndicators.add(cancelIndicator);
				}
			};
			document.readOnly(work);
		});
	}
}
