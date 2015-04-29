/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.test;

import com.google.inject.Injector;
import com.google.inject.Singleton;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.idea.example.entities.EntitiesRuntimeModule;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.ResourceValidatorImpl;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.web.server.ServiceConflictResult;
import org.eclipse.xtext.web.server.XtextServiceDispatcher;
import org.eclipse.xtext.web.server.model.DocumentStateResult;
import org.eclipse.xtext.web.server.persistence.ResourceContentResult;
import org.eclipse.xtext.web.server.test.AbstractWebServerTest;
import org.eclipse.xtext.web.server.test.HashMapSessionStore;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Pure;
import org.hamcrest.Matcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class UpdateDocumentTest extends AbstractWebServerTest {
  /**
   * The resource validator is applied asynchronously after each update.
   */
  @Singleton
  @Accessors(AccessorType.PUBLIC_GETTER)
  public static class TestResourceValidator extends ResourceValidatorImpl {
    private Thread workerThread;
    
    private long sleepTime;
    
    private boolean canceled;
    
    private int entryCounter;
    
    private int exitCounter;
    
    @Override
    public List<Issue> validate(final Resource resource, final CheckMode mode, final CancelIndicator mon) {
      try {
        List<Issue> _xblockexpression = null;
        {
          Thread _currentThread = Thread.currentThread();
          this.workerThread = _currentThread;
          /* this; */
          synchronized (this) {
            {
              this.entryCounter++;
              this.notifyAll();
            }
          }
          final long startTime = System.currentTimeMillis();
          while (((((System.currentTimeMillis() - startTime) < this.sleepTime) && (!mon.isCanceled())) && (!this.workerThread.isInterrupted()))) {
            {
              Thread.sleep(30);
              boolean _isCanceled = mon.isCanceled();
              if (_isCanceled) {
                this.canceled = true;
              }
            }
          }
          /* this; */
          synchronized (this) {
            {
              this.exitCounter++;
              this.notifyAll();
            }
          }
          _xblockexpression = super.validate(resource, mode, mon);
        }
        return _xblockexpression;
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    }
    
    public int reset(final long sleepTime) {
      int _xblockexpression = (int) 0;
      {
        if ((this.workerThread != null)) {
          this.workerThread.interrupt();
        }
        this.workerThread = null;
        this.sleepTime = sleepTime;
        this.canceled = false;
        this.entryCounter = 0;
        _xblockexpression = this.exitCounter = 0;
      }
      return _xblockexpression;
    }
    
    public synchronized void waitUntil(final Function1<? super UpdateDocumentTest.TestResourceValidator, ? extends Boolean> condition) {
      try {
        final long startTime = System.currentTimeMillis();
        while ((!(condition.apply(this)).booleanValue())) {
          {
            long _currentTimeMillis = System.currentTimeMillis();
            long _minus = (_currentTimeMillis - startTime);
            boolean _lessThan = (_minus < 3000);
            Assert.assertTrue(_lessThan);
            this.wait(3000);
          }
        }
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    }
    
    @Pure
    public Thread getWorkerThread() {
      return this.workerThread;
    }
    
    @Pure
    public long getSleepTime() {
      return this.sleepTime;
    }
    
    @Pure
    public boolean isCanceled() {
      return this.canceled;
    }
    
    @Pure
    public int getEntryCounter() {
      return this.entryCounter;
    }
    
    @Pure
    public int getExitCounter() {
      return this.exitCounter;
    }
  }
  
  private UpdateDocumentTest.TestResourceValidator resourceValidator;
  
  @Override
  protected EntitiesRuntimeModule getRuntimeModule() {
    return new EntitiesRuntimeModule() {
      @Override
      public Class<? extends IResourceValidator> bindIResourceValidator() {
        return UpdateDocumentTest.TestResourceValidator.class;
      }
    };
  }
  
  @Override
  public void setUp() {
    super.setUp();
    Injector _injector = this.getInjector();
    IResourceValidator _instance = _injector.<IResourceValidator>getInstance(IResourceValidator.class);
    this.resourceValidator = ((UpdateDocumentTest.TestResourceValidator) _instance);
  }
  
  @Test
  public void testCorrectStateId() {
    try {
      this.resourceValidator.reset(0);
      final File file = this.createFile("entity foo {}");
      final HashMapSessionStore sessionStore = new HashMapSessionStore();
      XtextServiceDispatcher _dispatcher = this.getDispatcher();
      String _name = file.getName();
      Pair<String, String> _mappedTo = Pair.<String, String>of("resource", _name);
      Pair<String, String> _mappedTo_1 = Pair.<String, String>of("deltaText", "bar");
      Pair<String, String> _mappedTo_2 = Pair.<String, String>of("deltaOffset", "7");
      Pair<String, String> _mappedTo_3 = Pair.<String, String>of("deltaReplaceLength", "3");
      XtextServiceDispatcher.ServiceDescriptor update = _dispatcher.getService("/update", Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3)), sessionStore);
      boolean _isHasSideEffects = update.isHasSideEffects();
      Assert.assertTrue(_isHasSideEffects);
      boolean _isHasTextInput = update.isHasTextInput();
      Assert.assertTrue(_isHasTextInput);
      Function0<? extends IServiceResult> _service = update.getService();
      IServiceResult _apply = _service.apply();
      final DocumentStateResult updateResult = ((DocumentStateResult) _apply);
      XtextServiceDispatcher _dispatcher_1 = this.getDispatcher();
      String _name_1 = file.getName();
      Pair<String, String> _mappedTo_4 = Pair.<String, String>of("resource", _name_1);
      Pair<String, String> _mappedTo_5 = Pair.<String, String>of("deltaText", "prop: String");
      Pair<String, String> _mappedTo_6 = Pair.<String, String>of("deltaOffset", "12");
      Pair<String, String> _mappedTo_7 = Pair.<String, String>of("deltaReplaceLength", "0");
      String _stateId = updateResult.getStateId();
      Pair<String, String> _mappedTo_8 = Pair.<String, String>of("requiredStateId", _stateId);
      XtextServiceDispatcher.ServiceDescriptor _service_1 = _dispatcher_1.getService("/update", Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo_4, _mappedTo_5, _mappedTo_6, _mappedTo_7, _mappedTo_8)), sessionStore);
      update = _service_1;
      Function0<? extends IServiceResult> _service_2 = update.getService();
      _service_2.apply();
      XtextServiceDispatcher _dispatcher_2 = this.getDispatcher();
      String _name_2 = file.getName();
      Pair<String, String> _mappedTo_9 = Pair.<String, String>of("resource", _name_2);
      final XtextServiceDispatcher.ServiceDescriptor load = _dispatcher_2.getService("/load", Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo_9)), sessionStore);
      Function0<? extends IServiceResult> _service_3 = load.getService();
      IServiceResult _apply_1 = _service_3.apply();
      final ResourceContentResult loadResult = ((ResourceContentResult) _apply_1);
      String _fullText = loadResult.getFullText();
      Assert.assertEquals("entity bar {prop: String}", _fullText);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIncorrectStateId1() {
    try {
      this.resourceValidator.reset(0);
      final File file = this.createFile("entity foo {}");
      final HashMapSessionStore sessionStore = new HashMapSessionStore();
      XtextServiceDispatcher _dispatcher = this.getDispatcher();
      String _name = file.getName();
      Pair<String, String> _mappedTo = Pair.<String, String>of("resource", _name);
      Pair<String, String> _mappedTo_1 = Pair.<String, String>of("deltaText", "prop: String");
      Pair<String, String> _mappedTo_2 = Pair.<String, String>of("deltaOffset", "12");
      Pair<String, String> _mappedTo_3 = Pair.<String, String>of("deltaReplaceLength", "0");
      Pair<String, String> _mappedTo_4 = Pair.<String, String>of("requiredStateId", "totalerquatsch");
      final XtextServiceDispatcher.ServiceDescriptor update = _dispatcher.getService("/update", Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3, _mappedTo_4)), sessionStore);
      boolean _isHasConflict = update.isHasConflict();
      Assert.assertTrue(_isHasConflict);
      Function0<? extends IServiceResult> _service = update.getService();
      final IServiceResult result = _service.apply();
      Matcher<IServiceResult> _instanceOf = IsInstanceOf.<IServiceResult>instanceOf(ServiceConflictResult.class);
      Assert.<IServiceResult>assertThat(result, _instanceOf);
      String _conflict = ((ServiceConflictResult) result).getConflict();
      Assert.assertEquals(_conflict, "invalidStateId");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIncorrectStateId2() {
    try {
      this.resourceValidator.reset(0);
      final File file = this.createFile("entity foo {}");
      final HashMapSessionStore sessionStore = new HashMapSessionStore();
      XtextServiceDispatcher _dispatcher = this.getDispatcher();
      String _name = file.getName();
      Pair<String, String> _mappedTo = Pair.<String, String>of("resource", _name);
      Pair<String, String> _mappedTo_1 = Pair.<String, String>of("deltaText", "bar");
      Pair<String, String> _mappedTo_2 = Pair.<String, String>of("deltaOffset", "7");
      Pair<String, String> _mappedTo_3 = Pair.<String, String>of("deltaReplaceLength", "3");
      final XtextServiceDispatcher.ServiceDescriptor update1 = _dispatcher.getService("/update", Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3)), sessionStore);
      Function0<? extends IServiceResult> _service = update1.getService();
      IServiceResult _apply = _service.apply();
      final DocumentStateResult updateResult = ((DocumentStateResult) _apply);
      XtextServiceDispatcher _dispatcher_1 = this.getDispatcher();
      String _name_1 = file.getName();
      Pair<String, String> _mappedTo_4 = Pair.<String, String>of("resource", _name_1);
      Pair<String, String> _mappedTo_5 = Pair.<String, String>of("deltaText", "prop: String");
      Pair<String, String> _mappedTo_6 = Pair.<String, String>of("deltaOffset", "12");
      Pair<String, String> _mappedTo_7 = Pair.<String, String>of("deltaReplaceLength", "0");
      String _stateId = updateResult.getStateId();
      Pair<String, String> _mappedTo_8 = Pair.<String, String>of("requiredStateId", _stateId);
      final XtextServiceDispatcher.ServiceDescriptor update2 = _dispatcher_1.getService("/update", Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo_4, _mappedTo_5, _mappedTo_6, _mappedTo_7, _mappedTo_8)), sessionStore);
      XtextServiceDispatcher _dispatcher_2 = this.getDispatcher();
      String _name_2 = file.getName();
      Pair<String, String> _mappedTo_9 = Pair.<String, String>of("resource", _name_2);
      Pair<String, String> _mappedTo_10 = Pair.<String, String>of("deltaText", "blub");
      Pair<String, String> _mappedTo_11 = Pair.<String, String>of("deltaOffset", "7");
      Pair<String, String> _mappedTo_12 = Pair.<String, String>of("deltaReplaceLength", "3");
      String _stateId_1 = updateResult.getStateId();
      Pair<String, String> _mappedTo_13 = Pair.<String, String>of("requiredStateId", _stateId_1);
      final XtextServiceDispatcher.ServiceDescriptor update3 = _dispatcher_2.getService("/update", Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo_9, _mappedTo_10, _mappedTo_11, _mappedTo_12, _mappedTo_13)), sessionStore);
      Function0<? extends IServiceResult> _service_1 = update2.getService();
      _service_1.apply();
      Function0<? extends IServiceResult> _service_2 = update3.getService();
      final IServiceResult result = _service_2.apply();
      Matcher<IServiceResult> _instanceOf = IsInstanceOf.<IServiceResult>instanceOf(ServiceConflictResult.class);
      Assert.<IServiceResult>assertThat(result, _instanceOf);
      String _conflict = ((ServiceConflictResult) result).getConflict();
      Assert.assertEquals(_conflict, "invalidStateId");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testCancelBackgroundWork1() {
    try {
      this.resourceValidator.reset(3000);
      final File file = this.createFile("entity foo {}");
      final HashMapSessionStore sessionStore = new HashMapSessionStore();
      XtextServiceDispatcher _dispatcher = this.getDispatcher();
      String _name = file.getName();
      Pair<String, String> _mappedTo = Pair.<String, String>of("resource", _name);
      Pair<String, String> _mappedTo_1 = Pair.<String, String>of("deltaText", "bar");
      Pair<String, String> _mappedTo_2 = Pair.<String, String>of("deltaOffset", "7");
      Pair<String, String> _mappedTo_3 = Pair.<String, String>of("deltaReplaceLength", "3");
      final XtextServiceDispatcher.ServiceDescriptor update1 = _dispatcher.getService("/update", Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3)), sessionStore);
      Function0<? extends IServiceResult> _service = update1.getService();
      IServiceResult _apply = _service.apply();
      final DocumentStateResult updateResult = ((DocumentStateResult) _apply);
      XtextServiceDispatcher _dispatcher_1 = this.getDispatcher();
      String _name_1 = file.getName();
      Pair<String, String> _mappedTo_4 = Pair.<String, String>of("resource", _name_1);
      Pair<String, String> _mappedTo_5 = Pair.<String, String>of("deltaText", "prop: String");
      Pair<String, String> _mappedTo_6 = Pair.<String, String>of("deltaOffset", "12");
      Pair<String, String> _mappedTo_7 = Pair.<String, String>of("deltaReplaceLength", "0");
      String _stateId = updateResult.getStateId();
      Pair<String, String> _mappedTo_8 = Pair.<String, String>of("requiredStateId", _stateId);
      final XtextServiceDispatcher.ServiceDescriptor update2 = _dispatcher_1.getService("/update", Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo_4, _mappedTo_5, _mappedTo_6, _mappedTo_7, _mappedTo_8)), sessionStore);
      final Function1<UpdateDocumentTest.TestResourceValidator, Boolean> _function = new Function1<UpdateDocumentTest.TestResourceValidator, Boolean>() {
        @Override
        public Boolean apply(final UpdateDocumentTest.TestResourceValidator it) {
          return Boolean.valueOf((it.entryCounter == 1));
        }
      };
      this.resourceValidator.waitUntil(_function);
      ExecutorService _executorService = this.getExecutorService();
      final Callable<IServiceResult> _function_1 = new Callable<IServiceResult>() {
        @Override
        public IServiceResult call() throws Exception {
          Function0<? extends IServiceResult> _service = update2.getService();
          return _service.apply();
        }
      };
      _executorService.<IServiceResult>submit(_function_1);
      final Function1<UpdateDocumentTest.TestResourceValidator, Boolean> _function_2 = new Function1<UpdateDocumentTest.TestResourceValidator, Boolean>() {
        @Override
        public Boolean apply(final UpdateDocumentTest.TestResourceValidator it) {
          return Boolean.valueOf((it.exitCounter == 1));
        }
      };
      this.resourceValidator.waitUntil(_function_2);
      Assert.assertTrue(this.resourceValidator.canceled);
      final Function1<UpdateDocumentTest.TestResourceValidator, Boolean> _function_3 = new Function1<UpdateDocumentTest.TestResourceValidator, Boolean>() {
        @Override
        public Boolean apply(final UpdateDocumentTest.TestResourceValidator it) {
          return Boolean.valueOf((it.entryCounter == 2));
        }
      };
      this.resourceValidator.waitUntil(_function_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testCancelBackgroundWork2() {
    try {
      this.resourceValidator.reset(3000);
      final File file = this.createFile("entity foo {}");
      final HashMapSessionStore sessionStore = new HashMapSessionStore();
      XtextServiceDispatcher _dispatcher = this.getDispatcher();
      String _name = file.getName();
      Pair<String, String> _mappedTo = Pair.<String, String>of("resource", _name);
      Pair<String, String> _mappedTo_1 = Pair.<String, String>of("deltaText", "bar");
      Pair<String, String> _mappedTo_2 = Pair.<String, String>of("deltaOffset", "7");
      Pair<String, String> _mappedTo_3 = Pair.<String, String>of("deltaReplaceLength", "3");
      final XtextServiceDispatcher.ServiceDescriptor update = _dispatcher.getService("/update", Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3)), sessionStore);
      Function0<? extends IServiceResult> _service = update.getService();
      IServiceResult _apply = _service.apply();
      final DocumentStateResult updateResult = ((DocumentStateResult) _apply);
      XtextServiceDispatcher _dispatcher_1 = this.getDispatcher();
      String _name_1 = file.getName();
      Pair<String, String> _mappedTo_4 = Pair.<String, String>of("resource", _name_1);
      Pair<String, String> _mappedTo_5 = Pair.<String, String>of("caretOffset", "12");
      String _stateId = updateResult.getStateId();
      Pair<String, String> _mappedTo_6 = Pair.<String, String>of("requiredStateId", _stateId);
      final XtextServiceDispatcher.ServiceDescriptor contentAssist = _dispatcher_1.getService("/content-assist", Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo_4, _mappedTo_5, _mappedTo_6)), sessionStore);
      final Function1<UpdateDocumentTest.TestResourceValidator, Boolean> _function = new Function1<UpdateDocumentTest.TestResourceValidator, Boolean>() {
        @Override
        public Boolean apply(final UpdateDocumentTest.TestResourceValidator it) {
          return Boolean.valueOf((it.entryCounter == 1));
        }
      };
      this.resourceValidator.waitUntil(_function);
      ExecutorService _executorService = this.getExecutorService();
      final Callable<IServiceResult> _function_1 = new Callable<IServiceResult>() {
        @Override
        public IServiceResult call() throws Exception {
          Function0<? extends IServiceResult> _service = contentAssist.getService();
          return _service.apply();
        }
      };
      _executorService.<IServiceResult>submit(_function_1);
      final Function1<UpdateDocumentTest.TestResourceValidator, Boolean> _function_2 = new Function1<UpdateDocumentTest.TestResourceValidator, Boolean>() {
        @Override
        public Boolean apply(final UpdateDocumentTest.TestResourceValidator it) {
          return Boolean.valueOf((it.exitCounter == 1));
        }
      };
      this.resourceValidator.waitUntil(_function_2);
      Assert.assertTrue(this.resourceValidator.canceled);
      final Function1<UpdateDocumentTest.TestResourceValidator, Boolean> _function_3 = new Function1<UpdateDocumentTest.TestResourceValidator, Boolean>() {
        @Override
        public Boolean apply(final UpdateDocumentTest.TestResourceValidator it) {
          return Boolean.valueOf((it.entryCounter == 2));
        }
      };
      this.resourceValidator.waitUntil(_function_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testCancelLowPriorityService1() {
    try {
      this.resourceValidator.reset(3000);
      final File file = this.createFile("entity foo {}");
      final HashMapSessionStore sessionStore = new HashMapSessionStore();
      XtextServiceDispatcher _dispatcher = this.getDispatcher();
      String _name = file.getName();
      Pair<String, String> _mappedTo = Pair.<String, String>of("resource", _name);
      final XtextServiceDispatcher.ServiceDescriptor validate = _dispatcher.getService("/validation", Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo)), sessionStore);
      XtextServiceDispatcher _dispatcher_1 = this.getDispatcher();
      String _name_1 = file.getName();
      Pair<String, String> _mappedTo_1 = Pair.<String, String>of("resource", _name_1);
      Pair<String, String> _mappedTo_2 = Pair.<String, String>of("deltaText", "bar");
      Pair<String, String> _mappedTo_3 = Pair.<String, String>of("deltaOffset", "7");
      Pair<String, String> _mappedTo_4 = Pair.<String, String>of("deltaReplaceLength", "3");
      final XtextServiceDispatcher.ServiceDescriptor update = _dispatcher_1.getService("/update", Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo_1, _mappedTo_2, _mappedTo_3, _mappedTo_4)), sessionStore);
      ExecutorService _executorService = this.getExecutorService();
      final Callable<IServiceResult> _function = new Callable<IServiceResult>() {
        @Override
        public IServiceResult call() throws Exception {
          Function0<? extends IServiceResult> _service = validate.getService();
          return _service.apply();
        }
      };
      _executorService.<IServiceResult>submit(_function);
      final Function1<UpdateDocumentTest.TestResourceValidator, Boolean> _function_1 = new Function1<UpdateDocumentTest.TestResourceValidator, Boolean>() {
        @Override
        public Boolean apply(final UpdateDocumentTest.TestResourceValidator it) {
          return Boolean.valueOf((it.entryCounter == 1));
        }
      };
      this.resourceValidator.waitUntil(_function_1);
      Function0<? extends IServiceResult> _service = update.getService();
      _service.apply();
      final Function1<UpdateDocumentTest.TestResourceValidator, Boolean> _function_2 = new Function1<UpdateDocumentTest.TestResourceValidator, Boolean>() {
        @Override
        public Boolean apply(final UpdateDocumentTest.TestResourceValidator it) {
          return Boolean.valueOf((it.exitCounter == 1));
        }
      };
      this.resourceValidator.waitUntil(_function_2);
      Assert.assertTrue(this.resourceValidator.canceled);
      final Function1<UpdateDocumentTest.TestResourceValidator, Boolean> _function_3 = new Function1<UpdateDocumentTest.TestResourceValidator, Boolean>() {
        @Override
        public Boolean apply(final UpdateDocumentTest.TestResourceValidator it) {
          return Boolean.valueOf((it.entryCounter == 2));
        }
      };
      this.resourceValidator.waitUntil(_function_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testCancelLowPriorityService2() {
    try {
      this.resourceValidator.reset(3000);
      final File file = this.createFile("entity foo {}");
      final HashMapSessionStore sessionStore = new HashMapSessionStore();
      XtextServiceDispatcher _dispatcher = this.getDispatcher();
      String _name = file.getName();
      Pair<String, String> _mappedTo = Pair.<String, String>of("resource", _name);
      final XtextServiceDispatcher.ServiceDescriptor validate = _dispatcher.getService("/validation", Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo)), sessionStore);
      XtextServiceDispatcher _dispatcher_1 = this.getDispatcher();
      String _name_1 = file.getName();
      Pair<String, String> _mappedTo_1 = Pair.<String, String>of("resource", _name_1);
      Pair<String, String> _mappedTo_2 = Pair.<String, String>of("caretOffset", "12");
      final XtextServiceDispatcher.ServiceDescriptor contentAssist = _dispatcher_1.getService("/content-assist", Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo_1, _mappedTo_2)), sessionStore);
      ExecutorService _executorService = this.getExecutorService();
      final Callable<IServiceResult> _function = new Callable<IServiceResult>() {
        @Override
        public IServiceResult call() throws Exception {
          Function0<? extends IServiceResult> _service = validate.getService();
          return _service.apply();
        }
      };
      _executorService.<IServiceResult>submit(_function);
      final Function1<UpdateDocumentTest.TestResourceValidator, Boolean> _function_1 = new Function1<UpdateDocumentTest.TestResourceValidator, Boolean>() {
        @Override
        public Boolean apply(final UpdateDocumentTest.TestResourceValidator it) {
          return Boolean.valueOf((it.entryCounter == 1));
        }
      };
      this.resourceValidator.waitUntil(_function_1);
      Function0<? extends IServiceResult> _service = contentAssist.getService();
      _service.apply();
      final Function1<UpdateDocumentTest.TestResourceValidator, Boolean> _function_2 = new Function1<UpdateDocumentTest.TestResourceValidator, Boolean>() {
        @Override
        public Boolean apply(final UpdateDocumentTest.TestResourceValidator it) {
          return Boolean.valueOf((it.exitCounter == 1));
        }
      };
      this.resourceValidator.waitUntil(_function_2);
      Assert.assertTrue(this.resourceValidator.canceled);
      final Function1<UpdateDocumentTest.TestResourceValidator, Boolean> _function_3 = new Function1<UpdateDocumentTest.TestResourceValidator, Boolean>() {
        @Override
        public Boolean apply(final UpdateDocumentTest.TestResourceValidator it) {
          return Boolean.valueOf((it.entryCounter == 2));
        }
      };
      this.resourceValidator.waitUntil(_function_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testContentAssistWithUpdate() {
    try {
      this.resourceValidator.reset(0);
      final File file = this.createFile("entity foo {}");
      final HashMapSessionStore sessionStore = new HashMapSessionStore();
      XtextServiceDispatcher _dispatcher = this.getDispatcher();
      String _name = file.getName();
      Pair<String, String> _mappedTo = Pair.<String, String>of("resource", _name);
      Pair<String, String> _mappedTo_1 = Pair.<String, String>of("deltaText", "bar");
      Pair<String, String> _mappedTo_2 = Pair.<String, String>of("deltaOffset", "7");
      Pair<String, String> _mappedTo_3 = Pair.<String, String>of("deltaReplaceLength", "3");
      XtextServiceDispatcher.ServiceDescriptor update = _dispatcher.getService("/update", Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3)), sessionStore);
      Function0<? extends IServiceResult> _service = update.getService();
      IServiceResult _apply = _service.apply();
      final DocumentStateResult updateResult = ((DocumentStateResult) _apply);
      XtextServiceDispatcher _dispatcher_1 = this.getDispatcher();
      String _name_1 = file.getName();
      Pair<String, String> _mappedTo_4 = Pair.<String, String>of("resource", _name_1);
      Pair<String, String> _mappedTo_5 = Pair.<String, String>of("caretOffset", "18");
      Pair<String, String> _mappedTo_6 = Pair.<String, String>of("deltaText", "prop: ");
      Pair<String, String> _mappedTo_7 = Pair.<String, String>of("deltaOffset", "12");
      Pair<String, String> _mappedTo_8 = Pair.<String, String>of("deltaReplaceLength", "0");
      String _stateId = updateResult.getStateId();
      Pair<String, String> _mappedTo_9 = Pair.<String, String>of("requiredStateId", _stateId);
      final XtextServiceDispatcher.ServiceDescriptor contentAssist = _dispatcher_1.getService("/content-assist", Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo_4, _mappedTo_5, _mappedTo_6, _mappedTo_7, _mappedTo_8, _mappedTo_9)), sessionStore);
      Function0<? extends IServiceResult> _service_1 = contentAssist.getService();
      _service_1.apply();
      XtextServiceDispatcher _dispatcher_2 = this.getDispatcher();
      String _name_2 = file.getName();
      Pair<String, String> _mappedTo_10 = Pair.<String, String>of("resource", _name_2);
      final XtextServiceDispatcher.ServiceDescriptor load = _dispatcher_2.getService("/load", Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo_10)), sessionStore);
      Function0<? extends IServiceResult> _service_2 = load.getService();
      IServiceResult _apply_1 = _service_2.apply();
      final ResourceContentResult loadResult = ((ResourceContentResult) _apply_1);
      String _fullText = loadResult.getFullText();
      Assert.assertEquals("entity bar {prop: }", _fullText);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
