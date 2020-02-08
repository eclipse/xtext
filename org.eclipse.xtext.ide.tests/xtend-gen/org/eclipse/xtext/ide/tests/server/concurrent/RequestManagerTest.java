/**
 * Copyright (c) 2016, 2017, 2018 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server.concurrent;

import com.google.common.base.Objects;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.log4j.Level;
import org.eclipse.xtext.ide.server.ServerModule;
import org.eclipse.xtext.ide.server.concurrent.AbstractRequest;
import org.eclipse.xtext.ide.server.concurrent.ReadRequest;
import org.eclipse.xtext.ide.server.concurrent.RequestManager;
import org.eclipse.xtext.ide.server.concurrent.WriteRequest;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.testing.RepeatedTest;
import org.eclipse.xtext.testing.logging.LoggingTester;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class RequestManagerTest {
  @Rule
  public RepeatedTest.Rule rule = new RepeatedTest.Rule(false);
  
  @Inject
  private RequestManager requestManager;
  
  @Inject
  private Provider<ExecutorService> executorServiceProvider;
  
  @Inject
  private Provider<OperationCanceledManager> cancelManagerProvider;
  
  private AtomicInteger sharedState;
  
  @Before
  public void setUp() {
    AtomicInteger _atomicInteger = new AtomicInteger();
    this.sharedState = _atomicInteger;
    ServerModule _serverModule = new ServerModule();
    Guice.createInjector(_serverModule).injectMembers(this);
  }
  
  @After
  public void tearDown() {
    this.requestManager.shutdown();
    this.sharedState = null;
  }
  
  @Test(timeout = 1000)
  public void testRunWriteLogExceptionNonCancellable() {
    final Runnable _function = () -> {
      final Function0<Object> _function_1 = () -> {
        return null;
      };
      final Function2<CancelIndicator, Object, Object> _function_2 = (CancelIndicator $0, Object $1) -> {
        throw new RuntimeException();
      };
      final CompletableFuture<Object> future = this.requestManager.<Object, Object>runWrite(_function_1, _function_2);
      try {
        future.join();
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    };
    final LoggingTester.LogCapture logResult = LoggingTester.captureLogging(Level.ALL, WriteRequest.class, _function);
    logResult.assertLogEntry("Error during request:");
  }
  
  @Test(timeout = 1000)
  public void testRunWriteLogExceptionCancellable() {
    final Runnable _function = () -> {
      final Function0<Object> _function_1 = () -> {
        throw new RuntimeException();
      };
      final Function2<CancelIndicator, Object, Object> _function_2 = (CancelIndicator $0, Object $1) -> {
        return null;
      };
      final CompletableFuture<Object> future = this.requestManager.<Object, Object>runWrite(_function_1, _function_2);
      try {
        future.join();
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    };
    final LoggingTester.LogCapture logResult = LoggingTester.captureLogging(Level.ALL, WriteRequest.class, _function);
    logResult.assertLogEntry("Error during request:");
  }
  
  @Test(timeout = 1000, expected = ExecutionException.class)
  public void testRunWriteCatchException() {
    final Runnable _function = () -> {
      try {
        final Function0<Object> _function_1 = () -> {
          throw new RuntimeException();
        };
        final Function2<CancelIndicator, Object, Object> _function_2 = (CancelIndicator $0, Object $1) -> {
          return null;
        };
        final CompletableFuture<Object> future = this.requestManager.<Object, Object>runWrite(_function_1, _function_2);
        Assert.assertEquals("Foo", future.get());
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    LoggingTester.captureLogging(Level.ALL, WriteRequest.class, _function);
    Assert.fail("unreachable");
  }
  
  @Test(timeout = 1000)
  public void testRunReadLogException() {
    final Runnable _function = () -> {
      final Function1<CancelIndicator, Object> _function_1 = (CancelIndicator it) -> {
        throw new RuntimeException();
      };
      final CompletableFuture<Object> future = this.requestManager.<Object>runRead(_function_1);
      try {
        future.join();
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    };
    final LoggingTester.LogCapture logResult = LoggingTester.captureLogging(Level.ALL, ReadRequest.class, _function);
    logResult.assertLogEntry("Error during request:");
  }
  
  @Test(timeout = 1000, expected = ExecutionException.class)
  public void testRunReadCatchException() {
    final Runnable _function = () -> {
      try {
        final Function1<CancelIndicator, Object> _function_1 = (CancelIndicator it) -> {
          throw new RuntimeException();
        };
        final CompletableFuture<Object> future = this.requestManager.<Object>runRead(_function_1);
        Assert.assertEquals("Foo", future.get());
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    LoggingTester.captureLogging(Level.ALL, ReadRequest.class, _function);
    Assert.fail();
  }
  
  @Test
  public void testWriteWaitsForReadToFinish_01() throws Exception {
    final AtomicBoolean marked = new AtomicBoolean(false);
    final CountDownLatch countDownInRead = new CountDownLatch(1);
    final CountDownLatch countDownInWrite = new CountDownLatch(1);
    final CountDownLatch proceedWithWrite = new CountDownLatch(1);
    final Function1<CancelIndicator, Object> _function = (CancelIndicator cancelIndicator) -> {
      countDownInRead.countDown();
      Uninterruptibles.awaitUninterruptibly(countDownInWrite);
      marked.set(true);
      proceedWithWrite.countDown();
      return null;
    };
    final CompletableFuture<Object> reader = this.requestManager.<Object>runRead(_function);
    Uninterruptibles.awaitUninterruptibly(countDownInRead);
    final Function0<Object> _function_1 = () -> {
      return null;
    };
    final Function2<CancelIndicator, Object, Object> _function_2 = (CancelIndicator cancelIndicator, Object ignored) -> {
      Object _xblockexpression = null;
      {
        countDownInWrite.countDown();
        Uninterruptibles.awaitUninterruptibly(proceedWithWrite);
        Assert.assertTrue(marked.get());
        _xblockexpression = null;
      }
      return _xblockexpression;
    };
    final CompletableFuture<Object> writer = this.requestManager.<Object, Object>runWrite(_function_1, _function_2);
    try {
      Uninterruptibles.<Object>getUninterruptibly(writer, 100, TimeUnit.MILLISECONDS);
      Assert.fail("Expected timeout");
    } catch (final Throwable _t) {
      if (_t instanceof TimeoutException) {
        Assert.assertFalse(marked.get());
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    countDownInWrite.countDown();
    Uninterruptibles.<Object>getUninterruptibly(writer, 100, TimeUnit.MILLISECONDS);
    Assert.assertTrue(reader.isDone());
    Assert.assertFalse(reader.isCancelled());
  }
  
  @Test
  public void testWriteWaitsForReadToFinish_02() throws Exception {
    final AtomicBoolean marked = new AtomicBoolean(false);
    final CountDownLatch countDownInRead = new CountDownLatch(1);
    final CountDownLatch countDownInWrite = new CountDownLatch(1);
    final CountDownLatch proceedWithWrite = new CountDownLatch(1);
    final Function1<CancelIndicator, Object> _function = (CancelIndicator cancelIndicator) -> {
      countDownInRead.countDown();
      Uninterruptibles.awaitUninterruptibly(countDownInWrite);
      marked.set(true);
      proceedWithWrite.countDown();
      throw new CancellationException();
    };
    final CompletableFuture<Object> reader = this.requestManager.<Object>runRead(_function);
    Uninterruptibles.awaitUninterruptibly(countDownInRead);
    final Function0<Object> _function_1 = () -> {
      return null;
    };
    final Function2<CancelIndicator, Object, Object> _function_2 = (CancelIndicator cancelIndicator, Object ignored) -> {
      Object _xblockexpression = null;
      {
        countDownInWrite.countDown();
        Uninterruptibles.awaitUninterruptibly(proceedWithWrite);
        Assert.assertTrue(marked.get());
        _xblockexpression = null;
      }
      return _xblockexpression;
    };
    final CompletableFuture<Object> writer = this.requestManager.<Object, Object>runWrite(_function_1, _function_2);
    try {
      Uninterruptibles.<Object>getUninterruptibly(writer, 100, TimeUnit.MILLISECONDS);
      Assert.fail("Expected timeout");
    } catch (final Throwable _t) {
      if (_t instanceof TimeoutException) {
        Assert.assertFalse(marked.get());
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    countDownInWrite.countDown();
    Uninterruptibles.<Object>getUninterruptibly(writer, 100, TimeUnit.MILLISECONDS);
    Assert.assertTrue(reader.isDone());
    Assert.assertTrue(reader.isCancelled());
  }
  
  @Test(timeout = 1000)
  public void testRunRead() {
    try {
      final Function1<CancelIndicator, String> _function = (CancelIndicator it) -> {
        return "Foo";
      };
      final CompletableFuture<String> future = this.requestManager.<String>runRead(_function);
      Assert.assertEquals("Foo", future.get());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test(timeout = 1000)
  public void testRunReadConcurrent() {
    final Function1<CancelIndicator, Integer> _function = (CancelIndicator it) -> {
      try {
        int _xblockexpression = (int) 0;
        {
          while ((this.sharedState.get() == 0)) {
            Thread.sleep(10);
          }
          _xblockexpression = this.sharedState.incrementAndGet();
        }
        return Integer.valueOf(_xblockexpression);
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    final CompletableFuture<Integer> future = this.requestManager.<Integer>runRead(_function);
    final Function1<CancelIndicator, Integer> _function_1 = (CancelIndicator it) -> {
      return Integer.valueOf(this.sharedState.incrementAndGet());
    };
    this.requestManager.<Integer>runRead(_function_1);
    future.join();
    Assert.assertEquals(2, this.sharedState.get());
  }
  
  @Test(timeout = 1000)
  public void testRunReadAfterWrite() {
    try {
      final Function0<Object> _function = () -> {
        return null;
      };
      final Function2<CancelIndicator, Object, Integer> _function_1 = (CancelIndicator $0, Object $1) -> {
        return Integer.valueOf(this.sharedState.incrementAndGet());
      };
      this.requestManager.<Object, Integer>runWrite(_function, _function_1);
      final Function1<CancelIndicator, Integer> _function_2 = (CancelIndicator it) -> {
        return Integer.valueOf(this.sharedState.get());
      };
      final CompletableFuture<Integer> future = this.requestManager.<Integer>runRead(_function_2);
      Assert.assertEquals(1, (future.get()).intValue());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test(timeout = 1000)
  public void testRunWrite() {
    final Function0<Object> _function = () -> {
      return null;
    };
    final Function2<CancelIndicator, Object, Integer> _function_1 = (CancelIndicator $0, Object $1) -> {
      return Integer.valueOf(this.sharedState.incrementAndGet());
    };
    this.requestManager.<Object, Integer>runWrite(_function, _function_1).join();
    Assert.assertEquals(1, this.sharedState.get());
  }
  
  @Test(timeout = 1000)
  public void testRunWriteAfterWrite() {
    final Function0<Object> _function = () -> {
      return null;
    };
    final Function2<CancelIndicator, Object, Integer> _function_1 = (CancelIndicator $0, Object $1) -> {
      return Integer.valueOf(this.sharedState.incrementAndGet());
    };
    this.requestManager.<Object, Integer>runWrite(_function, _function_1).join();
    final Function0<Object> _function_2 = () -> {
      return null;
    };
    final Function2<CancelIndicator, Object, Integer> _function_3 = (CancelIndicator $0, Object $1) -> {
      Integer _xifexpression = null;
      int _get = this.sharedState.get();
      boolean _notEquals = (_get != 0);
      if (_notEquals) {
        int _incrementAndGet = this.sharedState.incrementAndGet();
        _xifexpression = ((Integer) Integer.valueOf(_incrementAndGet));
      }
      return _xifexpression;
    };
    this.requestManager.<Object, Integer>runWrite(_function_2, _function_3).join();
    Assert.assertEquals(2, this.sharedState.get());
  }
  
  @Test(timeout = 1000)
  @RepeatedTest(times = 50)
  public void testRunWriteAfterReadStarted() {
    final CountDownLatch readStarted = new CountDownLatch(1);
    final Function1<CancelIndicator, Integer> _function = (CancelIndicator it) -> {
      int _xblockexpression = (int) 0;
      {
        readStarted.countDown();
        _xblockexpression = this.sharedState.incrementAndGet();
      }
      return Integer.valueOf(_xblockexpression);
    };
    this.requestManager.<Integer>runRead(_function);
    Uninterruptibles.awaitUninterruptibly(readStarted);
    final Function0<Object> _function_1 = () -> {
      return null;
    };
    final Function2<CancelIndicator, Object, Integer> _function_2 = (CancelIndicator $0, Object $1) -> {
      int _xblockexpression = (int) 0;
      {
        Assert.assertEquals(1, this.sharedState.get());
        _xblockexpression = this.sharedState.incrementAndGet();
      }
      return Integer.valueOf(_xblockexpression);
    };
    this.requestManager.<Object, Integer>runWrite(_function_1, _function_2).join();
    Assert.assertEquals(2, this.sharedState.get());
  }
  
  @Test(timeout = 1000)
  @RepeatedTest(times = 50)
  public void testRunWriteBeforeReadStarted() {
    final CountDownLatch writeSubmitted = new CountDownLatch(1);
    final AtomicBoolean firstWriteDone = new AtomicBoolean();
    final Function0<Object> _function = () -> {
      Object _xblockexpression = null;
      {
        Uninterruptibles.awaitUninterruptibly(writeSubmitted);
        firstWriteDone.set(true);
        _xblockexpression = null;
      }
      return _xblockexpression;
    };
    final Function2<CancelIndicator, Object, Integer> _function_1 = (CancelIndicator $0, Object $1) -> {
      return Integer.valueOf(this.sharedState.incrementAndGet());
    };
    this.requestManager.<Object, Integer>runWrite(_function, _function_1);
    final Function1<CancelIndicator, Integer> _function_2 = (CancelIndicator it) -> {
      return Integer.valueOf(this.sharedState.incrementAndGet());
    };
    this.requestManager.<Integer>runRead(_function_2);
    final Function0<Object> _function_3 = () -> {
      return null;
    };
    final Function2<CancelIndicator, Object, Integer> _function_4 = (CancelIndicator $0, Object $1) -> {
      int _xblockexpression = (int) 0;
      {
        Assert.assertEquals(0, this.sharedState.get());
        Assert.assertTrue(firstWriteDone.get());
        _xblockexpression = this.sharedState.incrementAndGet();
      }
      return Integer.valueOf(_xblockexpression);
    };
    final CompletableFuture<Integer> joinMe = this.requestManager.<Object, Integer>runWrite(_function_3, _function_4);
    writeSubmitted.countDown();
    joinMe.join();
    Assert.assertTrue(firstWriteDone.get());
    Assert.assertEquals(1, this.sharedState.get());
  }
  
  @Test(timeout = 1000)
  public void testCancelRead() {
    try {
      final AtomicBoolean isCanceled = new AtomicBoolean(false);
      final Function1<CancelIndicator, Object> _function = (CancelIndicator cancelIndicator) -> {
        try {
          try {
            this.sharedState.incrementAndGet();
            while ((!cancelIndicator.isCanceled())) {
              Thread.sleep(10);
            }
          } finally {
            isCanceled.set(true);
          }
          return null;
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      final CompletableFuture<Object> future = this.requestManager.<Object>runRead(_function);
      while ((this.sharedState.get() == 0)) {
        Thread.sleep(10);
      }
      future.cancel(true);
      while ((!isCanceled.get())) {
        Thread.sleep(10);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * The tests assumes an implementation of a Command that has access to the request manager
   */
  @Test(timeout = 5000)
  @RepeatedTest(times = 50)
  public void testReadCommandSubmitsWriteCommand() {
    try {
      final Thread mainThread = Thread.currentThread();
      final CountDownLatch submittedFromMain = new CountDownLatch(1);
      final CountDownLatch addedFromReader = new CountDownLatch(1);
      final AtomicReference<Thread> readerThreadRef = new AtomicReference<Thread>();
      ExecutorService _get = this.executorServiceProvider.get();
      OperationCanceledManager _get_1 = this.cancelManagerProvider.get();
      final RequestManager myRequestManager = new RequestManager(_get, _get_1) {
        @Override
        protected void addRequest(final AbstractRequest<?> request) {
          if (((request instanceof WriteRequest) && Objects.equal(Thread.currentThread(), readerThreadRef.get()))) {
            super.addRequest(request);
            addedFromReader.countDown();
            Uninterruptibles.awaitUninterruptibly(submittedFromMain, 100, TimeUnit.MILLISECONDS);
          } else {
            super.addRequest(request);
          }
        }
        
        @Override
        protected void submitRequest(final AbstractRequest<?> request) {
          if (((request instanceof WriteRequest) && Objects.equal(Thread.currentThread(), mainThread))) {
            super.submitRequest(request);
            submittedFromMain.countDown();
          } else {
            super.submitRequest(request);
          }
        }
        
        @Override
        protected CompletableFuture<Void> cancel() {
          CompletableFuture<Void> _xblockexpression = null;
          {
            Thread _currentThread = Thread.currentThread();
            boolean _equals = Objects.equal(_currentThread, mainThread);
            if (_equals) {
              Uninterruptibles.awaitUninterruptibly(addedFromReader, 100, TimeUnit.MILLISECONDS);
            }
            _xblockexpression = super.cancel();
          }
          return _xblockexpression;
        }
      };
      final CountDownLatch threadSet = new CountDownLatch(1);
      final Function1<CancelIndicator, CompletableFuture<Object>> _function = (CancelIndicator it) -> {
        readerThreadRef.set(Thread.currentThread());
        threadSet.countDown();
        final Function0<Object> _function_1 = () -> {
          return null;
        };
        final Function2<CancelIndicator, Object, Object> _function_2 = (CancelIndicator $0, Object $1) -> {
          return null;
        };
        return myRequestManager.<Object, Object>runWrite(_function_1, _function_2);
      };
      final CompletableFuture<CompletableFuture<Object>> readResult = myRequestManager.<CompletableFuture<Object>>runRead(_function);
      Uninterruptibles.awaitUninterruptibly(threadSet);
      Assert.assertNotNull(readerThreadRef.get());
      final Function0<Object> _function_1 = () -> {
        return null;
      };
      final Function2<CancelIndicator, Object, Object> _function_2 = (CancelIndicator $0, Object $1) -> {
        return null;
      };
      final CompletableFuture<Object> writeResult = myRequestManager.<Object, Object>runWrite(_function_1, _function_2);
      final CompletableFuture<Object> writeFromReader = readResult.get();
      try {
        writeFromReader.get();
        try {
          writeResult.get();
        } catch (final Throwable _t) {
          if (_t instanceof CancellationException) {
            Assert.assertTrue(writeFromReader.isDone());
            Assert.assertTrue(writeResult.isDone());
            boolean _isCancelled = writeFromReader.isCancelled();
            boolean _isCancelled_1 = writeResult.isCancelled();
            boolean _notEquals = (_isCancelled != _isCancelled_1);
            Assert.assertTrue(_notEquals);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      } catch (final Throwable _t) {
        if (_t instanceof CancellationException) {
          writeResult.get();
          Assert.assertTrue(writeFromReader.isDone());
          Assert.assertTrue(writeResult.isDone());
          boolean _isCancelled = writeFromReader.isCancelled();
          boolean _isCancelled_1 = writeResult.isCancelled();
          boolean _notEquals = (_isCancelled != _isCancelled_1);
          Assert.assertTrue(_notEquals);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
