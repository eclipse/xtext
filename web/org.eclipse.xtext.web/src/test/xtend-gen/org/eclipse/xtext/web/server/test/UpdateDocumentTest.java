/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.test;

import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Singleton;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.resource.XtextResource;
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
import org.eclipse.xtext.web.server.test.AbstractWebServerTest;
import org.eclipse.xtext.web.server.test.HashMapSession;
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
    
    private volatile boolean canceled;
    
    private int entryCounter;
    
    private int exitCounter;
    
    @Override
    public List<Issue> validate(final Resource resource, final CheckMode mode, final CancelIndicator mon) {
      try {
        List<Issue> _xblockexpression = null;
        {
          Thread _currentThread = Thread.currentThread();
          this.workerThread = _currentThread;
          synchronized (this) {
            this.entryCounter++;
            this.notifyAll();
          }
          final long startTime = System.currentTimeMillis();
          while (((((System.currentTimeMillis() - startTime) < this.sleepTime) && (!mon.isCanceled())) && (!this.workerThread.isInterrupted()))) {
            Thread.sleep(30);
          }
          boolean _isCanceled = mon.isCanceled();
          if (_isCanceled) {
            this.canceled = true;
          }
          synchronized (this) {
            this.exitCounter++;
            this.notifyAll();
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
            boolean _lessThan = (_minus < 8000);
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
  protected Module getRuntimeModule() {
    abstract class __UpdateDocumentTest_1 extends StatemachineRuntimeModule {
      public abstract Class<? extends IResourceValidator> bindIResourceValidator();
    }
    
    return new __UpdateDocumentTest_1() {
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
    this.resourceValidator.reset(0);
    final File file = this.createFile("input signal x state foo end");
    final HashMapSession session = new HashMapSession();
    Pair<String, String> _mappedTo = Pair.<String, String>of("serviceType", "update");
    String _name = file.getName();
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("resource", _name);
    Pair<String, String> _mappedTo_2 = Pair.<String, String>of("deltaText", "bar");
    Pair<String, String> _mappedTo_3 = Pair.<String, String>of("deltaOffset", "21");
    Pair<String, String> _mappedTo_4 = Pair.<String, String>of("deltaReplaceLength", "3");
    XtextServiceDispatcher.ServiceDescriptor update = this.getService(
      Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3, _mappedTo_4)), session);
    boolean _isHasSideEffects = update.isHasSideEffects();
    Assert.assertTrue(_isHasSideEffects);
    Function0<? extends IServiceResult> _service = update.getService();
    IServiceResult _apply = _service.apply();
    final DocumentStateResult updateResult = ((DocumentStateResult) _apply);
    Pair<String, String> _mappedTo_5 = Pair.<String, String>of("serviceType", "update");
    String _name_1 = file.getName();
    Pair<String, String> _mappedTo_6 = Pair.<String, String>of("resource", _name_1);
    Pair<String, String> _mappedTo_7 = Pair.<String, String>of("deltaText", " set x = true");
    Pair<String, String> _mappedTo_8 = Pair.<String, String>of("deltaOffset", "24");
    Pair<String, String> _mappedTo_9 = Pair.<String, String>of("deltaReplaceLength", "0");
    String _stateId = updateResult.getStateId();
    Pair<String, String> _mappedTo_10 = Pair.<String, String>of("requiredStateId", _stateId);
    XtextServiceDispatcher.ServiceDescriptor _service_1 = this.getService(
      Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo_5, _mappedTo_6, _mappedTo_7, _mappedTo_8, _mappedTo_9, _mappedTo_10)), session);
    update = _service_1;
    Function0<? extends IServiceResult> _service_2 = update.getService();
    _service_2.apply();
    Pair<String, String> _mappedTo_11 = Pair.<String, String>of("serviceType", "load");
    String _name_2 = file.getName();
    Pair<String, String> _mappedTo_12 = Pair.<String, String>of("resource", _name_2);
    final XtextServiceDispatcher.ServiceDescriptor load = this.getService(Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo_11, _mappedTo_12)), session);
    Function0<? extends IServiceResult> _service_3 = load.getService();
    IServiceResult _apply_1 = _service_3.apply();
    final ResourceContentResult loadResult = ((ResourceContentResult) _apply_1);
    String _fullText = loadResult.getFullText();
    Assert.assertEquals("input signal x state bar set x = true end", _fullText);
  }
  
  @Test
  public void testIncorrectStateId1() {
    this.resourceValidator.reset(0);
    final File file = this.createFile("state foo end");
    Pair<String, String> _mappedTo = Pair.<String, String>of("serviceType", "update");
    String _name = file.getName();
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("resource", _name);
    Pair<String, String> _mappedTo_2 = Pair.<String, String>of("deltaText", " set x = true");
    Pair<String, String> _mappedTo_3 = Pair.<String, String>of("deltaOffset", "10");
    Pair<String, String> _mappedTo_4 = Pair.<String, String>of("deltaReplaceLength", "0");
    Pair<String, String> _mappedTo_5 = Pair.<String, String>of("requiredStateId", "totalerquatsch");
    final XtextServiceDispatcher.ServiceDescriptor update = this.getService(
      Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3, _mappedTo_4, _mappedTo_5)));
    boolean _isHasConflict = update.isHasConflict();
    Assert.assertTrue(_isHasConflict);
    Function0<? extends IServiceResult> _service = update.getService();
    final IServiceResult result = _service.apply();
    Matcher<IServiceResult> _instanceOf = IsInstanceOf.<IServiceResult>instanceOf(ServiceConflictResult.class);
    Assert.<IServiceResult>assertThat(result, _instanceOf);
    String _conflict = ((ServiceConflictResult) result).getConflict();
    Assert.assertEquals(_conflict, "invalidStateId");
  }
  
  @Test
  public void testIncorrectStateId2() {
    this.resourceValidator.reset(0);
    final File file = this.createFile("input signal x state foo end");
    final HashMapSession session = new HashMapSession();
    Pair<String, String> _mappedTo = Pair.<String, String>of("serviceType", "update");
    String _name = file.getName();
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("resource", _name);
    Pair<String, String> _mappedTo_2 = Pair.<String, String>of("deltaText", "bar");
    Pair<String, String> _mappedTo_3 = Pair.<String, String>of("deltaOffset", "21");
    Pair<String, String> _mappedTo_4 = Pair.<String, String>of("deltaReplaceLength", "3");
    final XtextServiceDispatcher.ServiceDescriptor update1 = this.getService(
      Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3, _mappedTo_4)), session);
    Function0<? extends IServiceResult> _service = update1.getService();
    IServiceResult _apply = _service.apply();
    final DocumentStateResult updateResult = ((DocumentStateResult) _apply);
    Pair<String, String> _mappedTo_5 = Pair.<String, String>of("serviceType", "update");
    String _name_1 = file.getName();
    Pair<String, String> _mappedTo_6 = Pair.<String, String>of("resource", _name_1);
    Pair<String, String> _mappedTo_7 = Pair.<String, String>of("deltaText", " set x = true");
    Pair<String, String> _mappedTo_8 = Pair.<String, String>of("deltaOffset", "24");
    Pair<String, String> _mappedTo_9 = Pair.<String, String>of("deltaReplaceLength", "0");
    String _stateId = updateResult.getStateId();
    Pair<String, String> _mappedTo_10 = Pair.<String, String>of("requiredStateId", _stateId);
    final XtextServiceDispatcher.ServiceDescriptor update2 = this.getService(
      Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo_5, _mappedTo_6, _mappedTo_7, _mappedTo_8, _mappedTo_9, _mappedTo_10)), session);
    Pair<String, String> _mappedTo_11 = Pair.<String, String>of("serviceType", "update");
    String _name_2 = file.getName();
    Pair<String, String> _mappedTo_12 = Pair.<String, String>of("resource", _name_2);
    Pair<String, String> _mappedTo_13 = Pair.<String, String>of("deltaText", "y");
    Pair<String, String> _mappedTo_14 = Pair.<String, String>of("deltaOffset", "12");
    Pair<String, String> _mappedTo_15 = Pair.<String, String>of("deltaReplaceLength", "1");
    String _stateId_1 = updateResult.getStateId();
    Pair<String, String> _mappedTo_16 = Pair.<String, String>of("requiredStateId", _stateId_1);
    final XtextServiceDispatcher.ServiceDescriptor update3 = this.getService(
      Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo_11, _mappedTo_12, _mappedTo_13, _mappedTo_14, _mappedTo_15, _mappedTo_16)), session);
    Function0<? extends IServiceResult> _service_1 = update2.getService();
    _service_1.apply();
    Function0<? extends IServiceResult> _service_2 = update3.getService();
    final IServiceResult result = _service_2.apply();
    Matcher<IServiceResult> _instanceOf = IsInstanceOf.<IServiceResult>instanceOf(ServiceConflictResult.class);
    Assert.<IServiceResult>assertThat(result, _instanceOf);
    String _conflict = ((ServiceConflictResult) result).getConflict();
    Assert.assertEquals(_conflict, "invalidStateId");
  }
  
  @Test
  public void testNoBackgroundWorkWhenConflict() {
    this.resourceValidator.reset(0);
    final File file = this.createFile("input signal x state foo end");
    final HashMapSession session = new HashMapSession();
    Pair<String, String> _mappedTo = Pair.<String, String>of("serviceType", "update");
    String _name = file.getName();
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("resource", _name);
    Pair<String, String> _mappedTo_2 = Pair.<String, String>of("deltaText", "bar");
    Pair<String, String> _mappedTo_3 = Pair.<String, String>of("deltaOffset", "21");
    Pair<String, String> _mappedTo_4 = Pair.<String, String>of("deltaReplaceLength", "3");
    XtextServiceDispatcher.ServiceDescriptor update = this.getService(
      Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3, _mappedTo_4)), session);
    boolean _isHasSideEffects = update.isHasSideEffects();
    Assert.assertTrue(_isHasSideEffects);
    Function0<? extends IServiceResult> _service = update.getService();
    IServiceResult _apply = _service.apply();
    final DocumentStateResult updateResult = ((DocumentStateResult) _apply);
    Pair<String, String> _mappedTo_5 = Pair.<String, String>of("serviceType", "update");
    String _name_1 = file.getName();
    Pair<String, String> _mappedTo_6 = Pair.<String, String>of("resource", _name_1);
    Pair<String, String> _mappedTo_7 = Pair.<String, String>of("deltaText", " set x = true");
    Pair<String, String> _mappedTo_8 = Pair.<String, String>of("deltaOffset", "24");
    Pair<String, String> _mappedTo_9 = Pair.<String, String>of("deltaReplaceLength", "0");
    String _stateId = updateResult.getStateId();
    Pair<String, String> _mappedTo_10 = Pair.<String, String>of("requiredStateId", _stateId);
    XtextServiceDispatcher.ServiceDescriptor _service_1 = this.getService(
      Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo_5, _mappedTo_6, _mappedTo_7, _mappedTo_8, _mappedTo_9, _mappedTo_10)), session);
    update = _service_1;
    String _name_2 = file.getName();
    Pair<Class<XtextWebDocument>, String> _mappedTo_11 = Pair.<Class<XtextWebDocument>, String>of(XtextWebDocument.class, _name_2);
    final XtextWebDocument document = session.<XtextWebDocument>get(_mappedTo_11);
    XtextResource _resource = document.getResource();
    _resource.setModificationStamp(1234);
    Function0<? extends IServiceResult> _service_2 = update.getService();
    final IServiceResult result = _service_2.apply();
    Matcher<IServiceResult> _instanceOf = IsInstanceOf.<IServiceResult>instanceOf(ServiceConflictResult.class);
    Assert.<IServiceResult>assertThat(result, _instanceOf);
    Pair<String, String> _mappedTo_12 = Pair.<String, String>of("serviceType", "load");
    String _name_3 = file.getName();
    Pair<String, String> _mappedTo_13 = Pair.<String, String>of("resource", _name_3);
    final XtextServiceDispatcher.ServiceDescriptor load = this.getService(Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo_12, _mappedTo_13)), session);
    Function0<? extends IServiceResult> _service_3 = load.getService();
    IServiceResult _apply_1 = _service_3.apply();
    final ResourceContentResult loadResult = ((ResourceContentResult) _apply_1);
    String _fullText = loadResult.getFullText();
    Assert.assertEquals("input signal x state bar end", _fullText);
  }
  
  @Test
  public void testCancelBackgroundWork1() {
    this.resourceValidator.reset(300);
    final File file = this.createFile("input signal x state foo end");
    final HashMapSession session = new HashMapSession();
    Pair<String, String> _mappedTo = Pair.<String, String>of("serviceType", "update");
    String _name = file.getName();
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("resource", _name);
    Pair<String, String> _mappedTo_2 = Pair.<String, String>of("deltaText", "bar");
    Pair<String, String> _mappedTo_3 = Pair.<String, String>of("deltaOffset", "21");
    Pair<String, String> _mappedTo_4 = Pair.<String, String>of("deltaReplaceLength", "3");
    final XtextServiceDispatcher.ServiceDescriptor update1 = this.getService(
      Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3, _mappedTo_4)), session);
    Function0<? extends IServiceResult> _service = update1.getService();
    IServiceResult _apply = _service.apply();
    final DocumentStateResult updateResult = ((DocumentStateResult) _apply);
    Pair<String, String> _mappedTo_5 = Pair.<String, String>of("serviceType", "update");
    String _name_1 = file.getName();
    Pair<String, String> _mappedTo_6 = Pair.<String, String>of("resource", _name_1);
    Pair<String, String> _mappedTo_7 = Pair.<String, String>of("deltaText", " set x = true");
    Pair<String, String> _mappedTo_8 = Pair.<String, String>of("deltaOffset", "24");
    Pair<String, String> _mappedTo_9 = Pair.<String, String>of("deltaReplaceLength", "0");
    String _stateId = updateResult.getStateId();
    Pair<String, String> _mappedTo_10 = Pair.<String, String>of("requiredStateId", _stateId);
    final XtextServiceDispatcher.ServiceDescriptor update2 = this.getService(
      Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo_5, _mappedTo_6, _mappedTo_7, _mappedTo_8, _mappedTo_9, _mappedTo_10)), session);
    final Function1<UpdateDocumentTest.TestResourceValidator, Boolean> _function = new Function1<UpdateDocumentTest.TestResourceValidator, Boolean>() {
      @Override
      public Boolean apply(final UpdateDocumentTest.TestResourceValidator it) {
        return Boolean.valueOf((it.entryCounter == 1));
      }
    };
    this.resourceValidator.waitUntil(_function);
    Injector _injector = this.getInjector();
    ExecutorService _instance = _injector.<ExecutorService>getInstance(ExecutorService.class);
    final Callable<IServiceResult> _function_1 = new Callable<IServiceResult>() {
      @Override
      public IServiceResult call() throws Exception {
        Function0<? extends IServiceResult> _service = update2.getService();
        return _service.apply();
      }
    };
    _instance.<IServiceResult>submit(_function_1);
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
  }
  
  @Test
  public void testCancelBackgroundWork2() {
    this.resourceValidator.reset(300);
    final File file = this.createFile("input signal x state foo end");
    final HashMapSession session = new HashMapSession();
    Pair<String, String> _mappedTo = Pair.<String, String>of("serviceType", "update");
    String _name = file.getName();
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("resource", _name);
    Pair<String, String> _mappedTo_2 = Pair.<String, String>of("deltaText", "bar");
    Pair<String, String> _mappedTo_3 = Pair.<String, String>of("deltaOffset", "21");
    Pair<String, String> _mappedTo_4 = Pair.<String, String>of("deltaReplaceLength", "3");
    final XtextServiceDispatcher.ServiceDescriptor update = this.getService(
      Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3, _mappedTo_4)), session);
    Function0<? extends IServiceResult> _service = update.getService();
    IServiceResult _apply = _service.apply();
    final DocumentStateResult updateResult = ((DocumentStateResult) _apply);
    Pair<String, String> _mappedTo_5 = Pair.<String, String>of("serviceType", "assist");
    String _name_1 = file.getName();
    Pair<String, String> _mappedTo_6 = Pair.<String, String>of("resource", _name_1);
    Pair<String, String> _mappedTo_7 = Pair.<String, String>of("caretOffset", "15");
    String _stateId = updateResult.getStateId();
    Pair<String, String> _mappedTo_8 = Pair.<String, String>of("requiredStateId", _stateId);
    final XtextServiceDispatcher.ServiceDescriptor contentAssist = this.getService(
      Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo_5, _mappedTo_6, _mappedTo_7, _mappedTo_8)), session);
    final Function1<UpdateDocumentTest.TestResourceValidator, Boolean> _function = new Function1<UpdateDocumentTest.TestResourceValidator, Boolean>() {
      @Override
      public Boolean apply(final UpdateDocumentTest.TestResourceValidator it) {
        return Boolean.valueOf((it.entryCounter == 1));
      }
    };
    this.resourceValidator.waitUntil(_function);
    Injector _injector = this.getInjector();
    ExecutorService _instance = _injector.<ExecutorService>getInstance(ExecutorService.class);
    final Callable<IServiceResult> _function_1 = new Callable<IServiceResult>() {
      @Override
      public IServiceResult call() throws Exception {
        Function0<? extends IServiceResult> _service = contentAssist.getService();
        return _service.apply();
      }
    };
    _instance.<IServiceResult>submit(_function_1);
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
  }
  
  @Test
  public void testCancelLowPriorityService1() {
    this.resourceValidator.reset(3000);
    final File file = this.createFile("state foo end");
    final HashMapSession session = new HashMapSession();
    Pair<String, String> _mappedTo = Pair.<String, String>of("serviceType", "validate");
    String _name = file.getName();
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("resource", _name);
    final XtextServiceDispatcher.ServiceDescriptor validate = this.getService(Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1)), session);
    Pair<String, String> _mappedTo_2 = Pair.<String, String>of("serviceType", "update");
    String _name_1 = file.getName();
    Pair<String, String> _mappedTo_3 = Pair.<String, String>of("resource", _name_1);
    Pair<String, String> _mappedTo_4 = Pair.<String, String>of("deltaText", "bar");
    Pair<String, String> _mappedTo_5 = Pair.<String, String>of("deltaOffset", "6");
    Pair<String, String> _mappedTo_6 = Pair.<String, String>of("deltaReplaceLength", "3");
    final XtextServiceDispatcher.ServiceDescriptor update = this.getService(
      Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo_2, _mappedTo_3, _mappedTo_4, _mappedTo_5, _mappedTo_6)), session);
    Injector _injector = this.getInjector();
    ExecutorService _instance = _injector.<ExecutorService>getInstance(ExecutorService.class);
    final Callable<IServiceResult> _function = new Callable<IServiceResult>() {
      @Override
      public IServiceResult call() throws Exception {
        Function0<? extends IServiceResult> _service = validate.getService();
        return _service.apply();
      }
    };
    _instance.<IServiceResult>submit(_function);
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
  }
  
  @Test
  public void testCancelLowPriorityService2() {
    this.resourceValidator.reset(3000);
    final File file = this.createFile("state foo end");
    final HashMapSession session = new HashMapSession();
    Pair<String, String> _mappedTo = Pair.<String, String>of("serviceType", "validate");
    String _name = file.getName();
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("resource", _name);
    final XtextServiceDispatcher.ServiceDescriptor validate = this.getService(Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1)), session);
    Pair<String, String> _mappedTo_2 = Pair.<String, String>of("serviceType", "assist");
    String _name_1 = file.getName();
    Pair<String, String> _mappedTo_3 = Pair.<String, String>of("resource", _name_1);
    Pair<String, String> _mappedTo_4 = Pair.<String, String>of("caretOffset", "0");
    final XtextServiceDispatcher.ServiceDescriptor contentAssist = this.getService(
      Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo_2, _mappedTo_3, _mappedTo_4)), session);
    Injector _injector = this.getInjector();
    ExecutorService _instance = _injector.<ExecutorService>getInstance(ExecutorService.class);
    final Callable<IServiceResult> _function = new Callable<IServiceResult>() {
      @Override
      public IServiceResult call() throws Exception {
        Function0<? extends IServiceResult> _service = validate.getService();
        return _service.apply();
      }
    };
    _instance.<IServiceResult>submit(_function);
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
  }
  
  @Test
  public void testContentAssistWithUpdate() {
    this.resourceValidator.reset(0);
    final File file = this.createFile("input signal x state foo end");
    final HashMapSession session = new HashMapSession();
    Pair<String, String> _mappedTo = Pair.<String, String>of("serviceType", "update");
    String _name = file.getName();
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("resource", _name);
    Pair<String, String> _mappedTo_2 = Pair.<String, String>of("deltaText", "bar");
    Pair<String, String> _mappedTo_3 = Pair.<String, String>of("deltaOffset", "21");
    Pair<String, String> _mappedTo_4 = Pair.<String, String>of("deltaReplaceLength", "3");
    XtextServiceDispatcher.ServiceDescriptor update = this.getService(
      Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3, _mappedTo_4)), session);
    Function0<? extends IServiceResult> _service = update.getService();
    IServiceResult _apply = _service.apply();
    final DocumentStateResult updateResult = ((DocumentStateResult) _apply);
    Pair<String, String> _mappedTo_5 = Pair.<String, String>of("serviceType", "assist");
    String _name_1 = file.getName();
    Pair<String, String> _mappedTo_6 = Pair.<String, String>of("resource", _name_1);
    Pair<String, String> _mappedTo_7 = Pair.<String, String>of("caretOffset", "34");
    Pair<String, String> _mappedTo_8 = Pair.<String, String>of("deltaText", " set x = ");
    Pair<String, String> _mappedTo_9 = Pair.<String, String>of("deltaOffset", "24");
    Pair<String, String> _mappedTo_10 = Pair.<String, String>of("deltaReplaceLength", "0");
    String _stateId = updateResult.getStateId();
    Pair<String, String> _mappedTo_11 = Pair.<String, String>of("requiredStateId", _stateId);
    final XtextServiceDispatcher.ServiceDescriptor contentAssist = this.getService(
      Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo_5, _mappedTo_6, _mappedTo_7, _mappedTo_8, _mappedTo_9, _mappedTo_10, _mappedTo_11)), session);
    Function0<? extends IServiceResult> _service_1 = contentAssist.getService();
    _service_1.apply();
    Pair<String, String> _mappedTo_12 = Pair.<String, String>of("serviceType", "load");
    String _name_2 = file.getName();
    Pair<String, String> _mappedTo_13 = Pair.<String, String>of("resource", _name_2);
    final XtextServiceDispatcher.ServiceDescriptor load = this.getService(Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo_12, _mappedTo_13)), session);
    Function0<? extends IServiceResult> _service_2 = load.getService();
    IServiceResult _apply_1 = _service_2.apply();
    final ResourceContentResult loadResult = ((ResourceContentResult) _apply_1);
    String _fullText = loadResult.getFullText();
    Assert.assertEquals("input signal x state bar set x =  end", _fullText);
  }
  
  @Test
  public void testNoPrecomputationInStatelessMode() {
    this.resourceValidator.reset(0);
    final File file = this.createFile("");
    final HashMapSession session = new HashMapSession();
    Pair<String, String> _mappedTo = Pair.<String, String>of("serviceType", "assist");
    String _name = file.getName();
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("resource", _name);
    Pair<String, String> _mappedTo_2 = Pair.<String, String>of("caretOffset", "6");
    Pair<String, String> _mappedTo_3 = Pair.<String, String>of("fullText", "input signal x state foo end");
    XtextServiceDispatcher.ServiceDescriptor _service = this.getService(
      Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3)), session);
    Function0<? extends IServiceResult> _service_1 = _service.getService();
    _service_1.apply();
    Pair<String, String> _mappedTo_4 = Pair.<String, String>of("serviceType", "assist");
    String _name_1 = file.getName();
    Pair<String, String> _mappedTo_5 = Pair.<String, String>of("resource", _name_1);
    Pair<String, String> _mappedTo_6 = Pair.<String, String>of("caretOffset", "6");
    Pair<String, String> _mappedTo_7 = Pair.<String, String>of("fullText", "input signal x state foo end");
    XtextServiceDispatcher.ServiceDescriptor _service_2 = this.getService(
      Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo_4, _mappedTo_5, _mappedTo_6, _mappedTo_7)), session);
    Function0<? extends IServiceResult> _service_3 = _service_2.getService();
    _service_3.apply();
    Assert.assertEquals(0, this.resourceValidator.entryCounter);
  }
}
