/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.server.concurrent;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.xtext.ide.server.ServerModule;
import org.eclipse.xtext.ide.server.concurrent.RequestManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
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
    Injector _createInjector = Guice.createInjector(_serverModule);
    _createInjector.injectMembers(this);
  }
  
  @After
  public void tearDown() {
    this.requestManager.shutdown();
    this.sharedState = null;
  }
  
  @Test
  public void testRunRead() {
    try {
      final Function1<CancelIndicator, String> _function = new Function1<CancelIndicator, String>() {
        @Override
        public String apply(final CancelIndicator it) {
          return "Foo";
        }
      };
      final CompletableFuture<String> future = this.requestManager.<String>runRead(_function);
      String _get = future.get();
      Assert.assertEquals("Foo", _get);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRunReadConcurrent() {
    final Function1<CancelIndicator, Integer> _function = new Function1<CancelIndicator, Integer>() {
      @Override
      public Integer apply(final CancelIndicator it) {
        int _xblockexpression = (int) 0;
        {
          while ((RequestManagerTest.this.sharedState.get() == 0)) {
          }
          _xblockexpression = RequestManagerTest.this.sharedState.incrementAndGet();
        }
        return Integer.valueOf(_xblockexpression);
      }
    };
    final CompletableFuture<Integer> future = this.requestManager.<Integer>runRead(_function);
    final Function1<CancelIndicator, Integer> _function_1 = new Function1<CancelIndicator, Integer>() {
      @Override
      public Integer apply(final CancelIndicator it) {
        return Integer.valueOf(RequestManagerTest.this.sharedState.incrementAndGet());
      }
    };
    this.requestManager.<Integer>runRead(_function_1);
    future.join();
    int _get = this.sharedState.get();
    Assert.assertEquals(2, _get);
  }
  
  @Test
  public void testRunReadAfterWrite() {
    try {
      final Procedure1<CancelIndicator> _function = new Procedure1<CancelIndicator>() {
        @Override
        public void apply(final CancelIndicator it) {
          while ((RequestManagerTest.this.sharedState.get() == 0)) {
          }
          RequestManagerTest.this.sharedState.incrementAndGet();
        }
      };
      this.requestManager.runWrite(_function);
      final Function1<CancelIndicator, Integer> _function_1 = new Function1<CancelIndicator, Integer>() {
        @Override
        public Integer apply(final CancelIndicator it) {
          return Integer.valueOf(RequestManagerTest.this.sharedState.get());
        }
      };
      final CompletableFuture<Integer> future = this.requestManager.<Integer>runRead(_function_1);
      this.sharedState.incrementAndGet();
      Integer _get = future.get();
      Assert.assertEquals(2, (_get).intValue());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRunWrite() {
    final Procedure1<CancelIndicator> _function = new Procedure1<CancelIndicator>() {
      @Override
      public void apply(final CancelIndicator it) {
        RequestManagerTest.this.sharedState.incrementAndGet();
      }
    };
    CompletableFuture<Void> _runWrite = this.requestManager.runWrite(_function);
    _runWrite.join();
    int _get = this.sharedState.get();
    Assert.assertEquals(1, _get);
  }
  
  @Test
  public void testRunWriteAfterWrite() {
    final Procedure1<CancelIndicator> _function = new Procedure1<CancelIndicator>() {
      @Override
      public void apply(final CancelIndicator it) {
        RequestManagerTest.this.sharedState.incrementAndGet();
      }
    };
    this.requestManager.runWrite(_function);
    final Procedure1<CancelIndicator> _function_1 = new Procedure1<CancelIndicator>() {
      @Override
      public void apply(final CancelIndicator it) {
        int _get = RequestManagerTest.this.sharedState.get();
        boolean _notEquals = (_get != 0);
        if (_notEquals) {
          RequestManagerTest.this.sharedState.incrementAndGet();
        }
      }
    };
    CompletableFuture<Void> _runWrite = this.requestManager.runWrite(_function_1);
    _runWrite.join();
    int _get = this.sharedState.get();
    Assert.assertEquals(2, _get);
  }
  
  @Test
  public void testRunWriteAfterRead() {
    final Function1<CancelIndicator, Integer> _function = new Function1<CancelIndicator, Integer>() {
      @Override
      public Integer apply(final CancelIndicator it) {
        return Integer.valueOf(RequestManagerTest.this.sharedState.incrementAndGet());
      }
    };
    this.requestManager.<Integer>runRead(_function);
    final Procedure1<CancelIndicator> _function_1 = new Procedure1<CancelIndicator>() {
      @Override
      public void apply(final CancelIndicator it) {
        while ((RequestManagerTest.this.sharedState.get() == 0)) {
        }
        RequestManagerTest.this.sharedState.incrementAndGet();
      }
    };
    CompletableFuture<Void> _runWrite = this.requestManager.runWrite(_function_1);
    _runWrite.join();
    int _get = this.sharedState.get();
    Assert.assertEquals(2, _get);
  }
  
  @Test
  public void testCancelWrite() {
    final Procedure1<CancelIndicator> _function = new Procedure1<CancelIndicator>() {
      @Override
      public void apply(final CancelIndicator cancelIndicator) {
        while ((!cancelIndicator.isCanceled())) {
        }
        RequestManagerTest.this.sharedState.incrementAndGet();
      }
    };
    this.requestManager.runWrite(_function);
    final Procedure1<CancelIndicator> _function_1 = new Procedure1<CancelIndicator>() {
      @Override
      public void apply(final CancelIndicator it) {
        RequestManagerTest.this.sharedState.incrementAndGet();
      }
    };
    CompletableFuture<Void> _runWrite = this.requestManager.runWrite(_function_1);
    _runWrite.join();
    int _get = this.sharedState.get();
    Assert.assertEquals(2, _get);
  }
  
  @Test
  public void testCancelRead() {
    try {
      this.sharedState.incrementAndGet();
      final Function1<CancelIndicator, Integer> _function = new Function1<CancelIndicator, Integer>() {
        @Override
        public Integer apply(final CancelIndicator cancelIndicator) {
          int _xblockexpression = (int) 0;
          {
            while ((!cancelIndicator.isCanceled())) {
            }
            _xblockexpression = RequestManagerTest.this.sharedState.get();
          }
          return Integer.valueOf(_xblockexpression);
        }
      };
      final CompletableFuture<Integer> future = this.requestManager.<Integer>runRead(_function);
      final Procedure1<CancelIndicator> _function_1 = new Procedure1<CancelIndicator>() {
        @Override
        public void apply(final CancelIndicator it) {
          RequestManagerTest.this.sharedState.set(0);
        }
      };
      CompletableFuture<Void> _runWrite = this.requestManager.runWrite(_function_1);
      _runWrite.join();
      Integer _get = future.get();
      Assert.assertEquals(1, (_get).intValue());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
