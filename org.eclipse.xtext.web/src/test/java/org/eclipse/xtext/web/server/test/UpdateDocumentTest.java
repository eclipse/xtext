/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server.test;

import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.ResourceValidatorImpl;
import org.eclipse.xtext.web.example.statemachine.StatemachineRuntimeModule;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.web.server.ServiceConflictResult;
import org.eclipse.xtext.web.server.XtextServiceDispatcher;
import org.eclipse.xtext.web.server.model.DocumentStateResult;
import org.eclipse.xtext.web.server.model.XtextWebDocument;
import org.eclipse.xtext.web.server.persistence.ResourceContentResult;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Pair;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;

public class UpdateDocumentTest extends AbstractWebServerTest {
	/**
	 * The resource validator is applied asynchronously after each update.
	 */
	@Singleton
	public static class TestResourceValidator extends ResourceValidatorImpl {
		private Thread workerThread;

		private long sleepTime;

		private volatile boolean canceled;

		private int entryCounter;

		private int exitCounter;

		@Override
		public List<Issue> validate(Resource resource, CheckMode mode, CancelIndicator mon) {
			try {
				workerThread = Thread.currentThread();
				synchronized (this) {
					entryCounter++;
					notifyAll();
				}
				long startTime = System.currentTimeMillis();
				while (System.currentTimeMillis() - startTime < sleepTime && !mon.isCanceled()
						&& !workerThread.isInterrupted()) {
					Thread.sleep(30);
				}
				if (mon.isCanceled()) {
					canceled = true;
				}
				synchronized (this) {
					exitCounter++;
					notifyAll();
				}
				return super.validate(resource, mode, mon);
			} catch (InterruptedException e) {
				throw Exceptions.sneakyThrow(e);
			}
		}

		public int reset(long sleepTime) {
			if (workerThread != null) {
				workerThread.interrupt();
			}
			workerThread = null;
			this.sleepTime = sleepTime;
			canceled = false;
			entryCounter = 0;
			return exitCounter = 0;
		}

		public synchronized void waitUntil(
				Function1<? super UpdateDocumentTest.TestResourceValidator, ? extends Boolean> condition) {
			try {
				long startTime = System.currentTimeMillis();
				while (!condition.apply(this).booleanValue()) {
					Assert.assertTrue(System.currentTimeMillis() - startTime < 8000);
					this.wait(3000);
				}
			} catch (InterruptedException e) {
				throw Exceptions.sneakyThrow(e);
			}
		}

		public Thread getWorkerThread() {
			return workerThread;
		}

		public long getSleepTime() {
			return sleepTime;
		}

		public boolean isCanceled() {
			return canceled;
		}

		public int getEntryCounter() {
			return entryCounter;
		}

		public int getExitCounter() {
			return exitCounter;
		}
	}

	@Inject
	private UpdateDocumentTest.TestResourceValidator resourceValidator;

	@Inject
	private ExecutorService executorService;

	@Override
	protected com.google.inject.Module getRuntimeModule() {
		return new StatemachineRuntimeModule() {
			@SuppressWarnings("unused")
			public Class<? extends IResourceValidator> bindIResourceValidator() {
				return UpdateDocumentTest.TestResourceValidator.class;
			}
		};
	}

	@Test
	public void testCorrectStateId() {
		resourceValidator.reset(0);
		File file = createFile("input signal x state foo end");
		HashMapSession session = new HashMapSession();
		XtextServiceDispatcher.ServiceDescriptor update = getService(
				ImmutableMap.<String, String>builder()
						.put("serviceType", "update")
						.put("resource", file.getName())
						.put("deltaText", "bar")
						.put("deltaOffset", "21")
						.put("deltaReplaceLength", "3")
						.build(),
				session);
		Assert.assertTrue(update.isHasSideEffects());
		DocumentStateResult updateResult = (DocumentStateResult) update.getService().apply();
		update = getService(
				ImmutableMap.<String, String>builder()
						.put("serviceType", "update")
						.put("resource", file.getName())
						.put("deltaText", " set x = true")
						.put("deltaOffset", "24")
						.put("deltaReplaceLength", "0")
						.put("requiredStateId", updateResult.getStateId())
						.build(), session);
		update.getService().apply();
		XtextServiceDispatcher.ServiceDescriptor load = getService(
				ImmutableMap.<String, String>builder()
						.put("serviceType", "load")
						.put("resource", file.getName())
						.build(), session);
		ResourceContentResult loadResult = (ResourceContentResult) load.getService().apply();
		assertEquals("input signal x state bar set x = true end", loadResult.getFullText());
	}

	@Test
	public void testIncorrectStateId1() {
		resourceValidator.reset(0);
		File file = createFile("state foo end");
		XtextServiceDispatcher.ServiceDescriptor update = this
				.getService(
				ImmutableMap.<String, String>builder()
						.put("serviceType", "update")
						.put("resource", file.getName())
						.put("deltaText", " set x = true")
						.put("deltaOffset", "10")
						.put("deltaReplaceLength", "0")
						.put("requiredStateId", "totalerquatsch")
						.build());
		Assert.assertTrue(update.isHasConflict());
		IServiceResult result = update.getService().apply();
		MatcherAssert.assertThat(result, IsInstanceOf.<IServiceResult>instanceOf(ServiceConflictResult.class));
		assertEquals(((ServiceConflictResult) result).getConflict(), "invalidStateId");
	}

	@Test
	public void testIncorrectStateId2() {
		resourceValidator.reset(0);
		File file = createFile("input signal x state foo end");
		HashMapSession session = new HashMapSession();
		XtextServiceDispatcher.ServiceDescriptor update1 = getService(
				ImmutableMap.<String, String>builder()
						.put("serviceType", "update")
						.put("resource", file.getName())
						.put("deltaText", "bar")
						.put("deltaOffset", "21")
						.put("deltaReplaceLength", "3")
						.build(),
				session);
		DocumentStateResult updateResult = (DocumentStateResult) update1.getService().apply();
		XtextServiceDispatcher.ServiceDescriptor update2 = getService(
				ImmutableMap.<String, String>builder()
						.put("serviceType", "update")
						.put("resource", file.getName())
						.put("deltaText", " set x = true")
						.put("deltaOffset", "24")
						.put("deltaReplaceLength", "0")
						.put("requiredStateId", updateResult.getStateId())
						.build(),
				session);
		XtextServiceDispatcher.ServiceDescriptor update3 = getService(
				ImmutableMap.<String, String>builder()
						.put("serviceType", "update")
						.put("resource", file.getName())
						.put("deltaText", "y")
						.put("deltaOffset", "12")
						.put("deltaReplaceLength", "1")
						.put("requiredStateId", updateResult.getStateId())
						.build(),
				session);
		update2.getService().apply();
		IServiceResult result = update3.getService().apply();
		MatcherAssert.assertThat(result, IsInstanceOf.<IServiceResult>instanceOf(ServiceConflictResult.class));
		assertEquals(((ServiceConflictResult) result).getConflict(), "invalidStateId");
	}

	@Test
	public void testNoBackgroundWorkWhenConflict() {
		resourceValidator.reset(0);
		File file = createFile("input signal x state foo end");
		HashMapSession session = new HashMapSession();
		XtextServiceDispatcher.ServiceDescriptor update = getService(
				ImmutableMap.<String, String>builder()
						.put("serviceType", "update")
						.put("resource", file.getName())
						.put("deltaText", "bar")
						.put("deltaOffset", "21")
						.put("deltaReplaceLength", "3")
						.build(),
				session);
		Assert.assertTrue(update.isHasSideEffects());
		DocumentStateResult updateResult = (DocumentStateResult) update.getService().apply();
		update = getService(
				ImmutableMap.<String, String>builder()
						.put("serviceType", "update")
						.put("resource", file.getName())
						.put("deltaText", " set x = true")
						.put("deltaOffset", "24")
						.put("deltaReplaceLength", "0")
						.put("requiredStateId", updateResult.getStateId())
						.build(), session);
		XtextWebDocument document = session.get(Pair.of(XtextWebDocument.class, file.getName()));
		document.getResource().setModificationStamp(1234);
		IServiceResult result = update.getService().apply();
		MatcherAssert.assertThat(result, IsInstanceOf.<IServiceResult>instanceOf(ServiceConflictResult.class));
		XtextServiceDispatcher.ServiceDescriptor load = getService(
				ImmutableMap.<String, String>builder()
						.put("serviceType", "load")
						.put("resource", file.getName())
						.build(), session);
		ResourceContentResult loadResult = (ResourceContentResult) load.getService().apply();
		assertEquals("input signal x state bar end", loadResult.getFullText());
	}

	@Test
	public void testCancelBackgroundWork1() {
		resourceValidator.reset(300);
		File file = createFile("input signal x state foo end");
		HashMapSession session = new HashMapSession();
		XtextServiceDispatcher.ServiceDescriptor update1 = getService(
				ImmutableMap.<String, String>builder()
						.put("serviceType", "update")
						.put("resource", file.getName())
						.put("deltaText", "bar")
						.put("deltaOffset", "21")
						.put("deltaReplaceLength", "3")
						.build(),
				session);
		DocumentStateResult updateResult = (DocumentStateResult) update1.getService().apply();
		XtextServiceDispatcher.ServiceDescriptor update2 = getService(
				ImmutableMap.<String, String>builder()
						.put("serviceType", "update")
						.put("resource", file.getName())
						.put("deltaText", " set x = true")
						.put("deltaOffset", "24")
						.put("deltaReplaceLength", "0")
						.put("requiredStateId", updateResult.getStateId())
						.build(),
				session);
		resourceValidator.waitUntil(it -> it.entryCounter == 1);
		executorService.submit(() -> update2.getService().apply());
		resourceValidator.waitUntil(it -> it.exitCounter == 1);
		Assert.assertTrue(resourceValidator.canceled);
		resourceValidator.waitUntil(it -> it.entryCounter == 2);
	}

	@Test
	public void testCancelBackgroundWork2() {
		resourceValidator.reset(300);
		File file = createFile("input signal x state foo end");
		HashMapSession session = new HashMapSession();
		XtextServiceDispatcher.ServiceDescriptor update = getService(
				ImmutableMap.<String, String>builder()
						.put("serviceType", "update")
						.put("resource", file.getName())
						.put("deltaText", "bar")
						.put("deltaOffset", "21")
						.put("deltaReplaceLength", "3")
						.build(),
				session);
		DocumentStateResult updateResult = (DocumentStateResult) update.getService().apply();
		XtextServiceDispatcher.ServiceDescriptor contentAssist = getService(
				ImmutableMap.<String, String>builder()
						.put("serviceType", "assist")
						.put("resource", file.getName())
						.put("caretOffset", "15")
						.put("requiredStateId", updateResult.getStateId())
						.build(),
				session);
		resourceValidator.waitUntil(it -> it.entryCounter == 1);
		executorService.submit(() -> contentAssist.getService().apply());
		resourceValidator.waitUntil(it -> it.exitCounter == 1);
		Assert.assertTrue(resourceValidator.canceled);
		resourceValidator.waitUntil(it -> it.entryCounter == 2);
	}

	@Test
	public void testCancelLowPriorityService1() {
		resourceValidator.reset(3000);
		File file = createFile("state foo end");
		HashMapSession session = new HashMapSession();
		XtextServiceDispatcher.ServiceDescriptor validate = getService(
				ImmutableMap.<String, String>builder()
						.put("serviceType", "validate")
						.put("resource", file.getName())
						.build(), session);
		XtextServiceDispatcher.ServiceDescriptor update = getService(
				ImmutableMap.<String, String>builder()
						.put("serviceType", "update")
						.put("resource", file.getName())
						.put("deltaText", "bar")
						.put("deltaOffset", "6")
						.put("deltaReplaceLength", "3")
						.build(),
				session);
		executorService.submit(() -> validate.getService().apply());
		resourceValidator.waitUntil(it -> it.entryCounter == 1);
		update.getService().apply();
		resourceValidator.waitUntil(it -> it.exitCounter == 1);
		Assert.assertTrue(resourceValidator.canceled);
		resourceValidator.waitUntil(it -> it.entryCounter == 2);
	}

	@Test
	public void testCancelLowPriorityService2() {
		resourceValidator.reset(3000);
		File file = createFile("state foo end");
		HashMapSession session = new HashMapSession();
		XtextServiceDispatcher.ServiceDescriptor validate = getService(
				ImmutableMap.<String, String>builder()
						.put("serviceType", "validate")
						.put("resource", file.getName())
						.build(), session);
		XtextServiceDispatcher.ServiceDescriptor contentAssist = getService(
				ImmutableMap.<String, String>builder()
						.put("serviceType", "assist")
						.put("resource", file.getName())
						.put("caretOffset", "0")
						.build(), session);
		executorService.submit(() -> validate.getService().apply());
		resourceValidator.waitUntil(it -> it.entryCounter == 1);
		contentAssist.getService().apply();
		resourceValidator.waitUntil(it -> it.exitCounter == 1);
		Assert.assertTrue(resourceValidator.canceled);
		resourceValidator.waitUntil(it -> it.entryCounter == 2);
	}

	@Test
	public void testContentAssistWithUpdate() {
		resourceValidator.reset(0);
		File file = createFile("input signal x state foo end");
		HashMapSession session = new HashMapSession();
		XtextServiceDispatcher.ServiceDescriptor update = getService(
				ImmutableMap.<String, String>builder()
						.put("serviceType", "update")
						.put("resource", file.getName())
						.put("deltaText", "bar")
						.put("deltaOffset", "21")
						.put("deltaReplaceLength", "3")
						.build(),
				session);
		DocumentStateResult updateResult = (DocumentStateResult) update.getService().apply();
		XtextServiceDispatcher.ServiceDescriptor contentAssist = getService(
				ImmutableMap.<String, String>builder()
						.put("serviceType", "assist")
						.put("resource", file.getName())
						.put("caretOffset", "34")
						.put("deltaText", " set x = ")
						.put("deltaOffset", "24")
						.put("deltaReplaceLength", "0")
						.put("requiredStateId", updateResult.getStateId())
						.build(),
				session);
		contentAssist.getService().apply();
		XtextServiceDispatcher.ServiceDescriptor load = getService(
				ImmutableMap.<String, String>builder()
						.put("serviceType", "load")
						.put("resource", file.getName())
						.build(), session);
		ResourceContentResult loadResult = (ResourceContentResult) load.getService().apply();
		assertEquals("input signal x state bar set x =  end", loadResult.getFullText());
	}

	@Test
	public void testNoPrecomputationInStatelessMode() {
		resourceValidator.reset(0);
		File file = createFile("");
		HashMapSession session = new HashMapSession();
		getService(
				ImmutableMap.<String, String>builder()
						.put("serviceType", "assist")
						.put("resource", file.getName())
						.put("caretOffset", "6")
						.put("fullText", "input signal x state foo end")
						.build(), session).getService()
						.apply();
		getService(
				ImmutableMap.<String, String>builder()
						.put("serviceType", "assist")
						.put("resource", file.getName())
						.put("caretOffset", "6")
						.put("fullText", "input signal x state foo end")
						.build(), session).getService()
						.apply();
		Assert.assertEquals(0, resourceValidator.entryCounter);
	}
}
