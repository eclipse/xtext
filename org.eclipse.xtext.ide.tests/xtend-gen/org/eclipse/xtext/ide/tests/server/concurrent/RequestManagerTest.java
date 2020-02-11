/**
 * Copyright (c) 2016, 2017, 2018 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server.concurrent;

import com.google.inject.Guice;
import com.google.inject.Inject;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.log4j.Level;
import org.eclipse.xtext.ide.server.ServerModule;
import org.eclipse.xtext.ide.server.concurrent.ReadRequest;
import org.eclipse.xtext.ide.server.concurrent.RequestManager;
import org.eclipse.xtext.ide.server.concurrent.WriteRequest;
import org.eclipse.xtext.testing.logging.LoggingTester;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class RequestManagerTest {
  @Inject
  private RequestManager requestManager;
  
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
  @Ignore("https://github.com/eclipse/xtext-core/issues/622")
  public void testRunWriteAfterRead() {
    final Function1<CancelIndicator, Integer> _function = (CancelIndicator it) -> {
      return Integer.valueOf(this.sharedState.incrementAndGet());
    };
    this.requestManager.<Integer>runRead(_function);
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
}
