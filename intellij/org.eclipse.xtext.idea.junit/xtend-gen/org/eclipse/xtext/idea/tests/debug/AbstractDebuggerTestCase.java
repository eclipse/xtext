package org.eclipse.xtext.idea.tests.debug;

import com.google.common.base.Objects;
import com.intellij.debugger.DebuggerManagerEx;
import com.intellij.debugger.DebuggerTestCase;
import com.intellij.debugger.DefaultDebugEnvironment;
import com.intellij.debugger.SourcePosition;
import com.intellij.debugger.engine.DebugProcess;
import com.intellij.debugger.engine.DebugProcessImpl;
import com.intellij.debugger.engine.JavaDebugProcess;
import com.intellij.debugger.engine.SuspendContextImpl;
import com.intellij.debugger.engine.SuspendManager;
import com.intellij.debugger.impl.DebuggerContextImpl;
import com.intellij.debugger.impl.DebuggerManagerImpl;
import com.intellij.debugger.impl.DebuggerSession;
import com.intellij.debugger.impl.DebuggerStateManager;
import com.intellij.debugger.impl.GenericDebuggerRunnerSettings;
import com.intellij.debugger.impl.OutputChecker;
import com.intellij.debugger.settings.DebuggerSettings;
import com.intellij.debugger.ui.breakpoints.BreakpointManager;
import com.intellij.debugger.ui.breakpoints.LineBreakpoint;
import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.CommandLineBuilder;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.configurations.JavaCommandLineState;
import com.intellij.execution.configurations.JavaParameters;
import com.intellij.execution.configurations.RemoteConnection;
import com.intellij.execution.configurations.RunProfileState;
import com.intellij.execution.executors.DefaultDebugExecutor;
import com.intellij.execution.process.ProcessAdapter;
import com.intellij.execution.process.ProcessEvent;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.execution.runners.ExecutionEnvironmentBuilder;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.application.PathManager;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.util.ArrayUtil;
import com.intellij.util.PathsList;
import com.intellij.util.ui.UIUtil;
import com.intellij.xdebugger.XDebugProcess;
import com.intellij.xdebugger.XDebugProcessStarter;
import com.intellij.xdebugger.XDebugSession;
import com.intellij.xdebugger.XDebuggerManager;
import com.sun.tools.javac.Main;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import junit.framework.AssertionFailedError;
import junit.framework.TestCase;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.macro.Active;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.idea.tests.AbstractIdeaTestCase;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("all")
public abstract class AbstractDebuggerTestCase extends AbstractIdeaTestCase {
  private DebuggerSession myDebuggerSession;
  
  private DebugProcessImpl myDebugProcess;
  
  private final static int timeout = 10000;
  
  protected void assertCurrentLine(final VirtualFile file, final String fragment) {
    DebuggerStateManager _contextManager = this.myDebuggerSession.getContextManager();
    DebuggerContextImpl _context = _contextManager.getContext();
    final SourcePosition sp = _context.getSourcePosition();
    PsiFile _file = sp.getFile();
    VirtualFile _virtualFile = _file.getVirtualFile();
    TestCase.assertEquals(file, _virtualFile);
    Project _project = this.getProject();
    PsiDocumentManager _instance = PsiDocumentManager.getInstance(_project);
    PsiFile _file_1 = sp.getFile();
    final Document doc = _instance.getDocument(_file_1);
    String _text = doc.getText();
    final int index = _text.indexOf(fragment);
    if ((index == (-1))) {
      PsiFile _file_2 = sp.getFile();
      VirtualFile _virtualFile_1 = _file_2.getVirtualFile();
      String _name = _virtualFile_1.getName();
      String _plus = ((("couldn\'t find \'" + fragment) + "\' in file ") + _name);
      TestCase.fail(_plus);
    }
    int _lineNumber = doc.getLineNumber(index);
    int _line = sp.getLine();
    TestCase.assertEquals(_lineNumber, _line);
  }
  
  protected void assertCurrentLine(final VirtualFile file, final int line) {
    DebuggerStateManager _contextManager = this.myDebuggerSession.getContextManager();
    DebuggerContextImpl _context = _contextManager.getContext();
    final SourcePosition sp = _context.getSourcePosition();
    PsiFile _file = sp.getFile();
    VirtualFile _virtualFile = _file.getVirtualFile();
    TestCase.assertEquals(file, _virtualFile);
    int _line = sp.getLine();
    TestCase.assertEquals(line, _line);
  }
  
  protected void assertProcessTerminated() {
    ProcessHandler _processHandler = this.myDebugProcess.getProcessHandler();
    boolean _isProcessTerminated = _processHandler.isProcessTerminated();
    TestCase.assertTrue(_isProcessTerminated);
  }
  
  protected LineBreakpoint<?> addLineBreakpoint(final VirtualFile file, final int line) {
    DebuggerManagerEx _instanceEx = DebuggerManagerImpl.getInstanceEx(this.myProject);
    final BreakpointManager breakpointManager = _instanceEx.getBreakpointManager();
    PsiManager _instance = PsiManager.getInstance(this.myProject);
    final PsiFile psiFile = _instance.findFile(file);
    PsiDocumentManager _instance_1 = PsiDocumentManager.getInstance(this.myProject);
    final Document document = _instance_1.getDocument(psiFile);
    return breakpointManager.addLineBreakpoint(document, line);
  }
  
  protected void stepOver(final int times) {
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, times, true);
    for (final Integer i : _doubleDotLessThan) {
      try {
        this.stepOver();
      } catch (final Throwable _t) {
        if (_t instanceof AssertionFailedError) {
          final AssertionFailedError e = (AssertionFailedError)_t;
          String _message = e.getMessage();
          String _plus = ((("Failed on step " + i) + " : ") + _message);
          TestCase.fail(_plus);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
  }
  
  protected SuspendContextImpl stepOver() {
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        AbstractDebuggerTestCase.this.myDebuggerSession.stepOver(false);
      }
    };
    return this.waitForContextChange(_function);
  }
  
  protected SuspendContextImpl stepInto() {
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        AbstractDebuggerTestCase.this.myDebuggerSession.stepInto(false, null);
      }
    };
    return this.waitForContextChange(_function);
  }
  
  protected SuspendContextImpl stepOut() {
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        AbstractDebuggerTestCase.this.myDebuggerSession.stepOut();
      }
    };
    return this.waitForContextChange(_function);
  }
  
  protected SuspendContextImpl resume() {
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        AbstractDebuggerTestCase.this.myDebuggerSession.resume();
      }
    };
    return this.waitForContextChange(_function);
  }
  
  private SuspendContextImpl waitForContextChange(final Runnable command) {
    try {
      ProcessHandler _processHandler = this.myDebugProcess.getProcessHandler();
      boolean _isProcessTerminated = _processHandler.isProcessTerminated();
      TestCase.assertFalse(_isProcessTerminated);
      int i = 0;
      final SuspendManager suspendManager = this.myDebugProcess.getSuspendManager();
      DebuggerSession _session = this.myDebugProcess.getSession();
      DebuggerStateManager _contextManager = _session.getContextManager();
      DebuggerContextImpl _context = _contextManager.getContext();
      final SourcePosition oldSourcePosition = _context.getSourcePosition();
      command.run();
      while (((i++ < (AbstractDebuggerTestCase.timeout / 10)) && (Objects.equal(oldSourcePosition, this.myDebugProcess.getSession().getContextManager().getContext().getSourcePosition()) || 
        Objects.equal(this.myDebugProcess.getSession().getContextManager().getContext().getSourcePosition(), null)))) {
        {
          Thread.sleep(10);
          UIUtil.dispatchAllInvocationEvents();
        }
      }
      DebuggerSession _session_1 = this.myDebugProcess.getSession();
      DebuggerStateManager _contextManager_1 = _session_1.getContextManager();
      DebuggerContextImpl _context_1 = _contextManager_1.getContext();
      SourcePosition _sourcePosition = _context_1.getSourcePosition();
      boolean _equals = Objects.equal(oldSourcePosition, _sourcePosition);
      if (_equals) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("too long process, terminated=");
        ProcessHandler _processHandler_1 = this.myDebugProcess.getProcessHandler();
        boolean _isProcessTerminated_1 = _processHandler_1.isProcessTerminated();
        _builder.append(_isProcessTerminated_1, "");
        TestCase.fail(_builder.toString());
      }
      return suspendManager.getPausedContext();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void compile() {
    final List<String> args = new ArrayList<String>();
    args.add("-g");
    args.add("-d");
    Module _module = this.getModule();
    VirtualFile _moduleFile = _module.getModuleFile();
    VirtualFile _parent = _moduleFile.getParent();
    final String modulePath = _parent.getPath();
    final File classesDir = new File(modulePath, "classes");
    classesDir.mkdir();
    String _path = classesDir.getPath();
    args.add(_path);
    final Class<TestCase> testCaseClass = TestCase.class;
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/");
    String _name = testCaseClass.getName();
    Character _valueOf = Character.valueOf('.');
    char _charValue = _valueOf.charValue();
    Character _valueOf_1 = Character.valueOf('/');
    char _charValue_1 = _valueOf_1.charValue();
    String _replace = _name.replace(_charValue, _charValue_1);
    _builder.append(_replace, "");
    _builder.append(".class");
    final String junitLibRoot = PathManager.getResourceRoot(testCaseClass, _builder.toString());
    if ((junitLibRoot != null)) {
      args.add("-cp");
      String _jarPathForClass = PathManager.getJarPathForClass(Objects.class);
      String _jarPathForClass_1 = PathManager.getJarPathForClass(IterableExtensions.class);
      String _jarPathForClass_2 = PathManager.getJarPathForClass(Accessors.class);
      String _jarPathForClass_3 = PathManager.getJarPathForClass(Active.class);
      String _join = IterableExtensions.join(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(junitLibRoot, _jarPathForClass, _jarPathForClass_1, _jarPathForClass_2, _jarPathForClass_3)), File.pathSeparator);
      args.add(_join);
    }
    final int before = args.size();
    File _file = new File(modulePath, "src");
    File[] _listFiles = _file.listFiles();
    final Function1<File, Boolean> _function = new Function1<File, Boolean>() {
      @Override
      public Boolean apply(final File it) {
        String _name = it.getName();
        return Boolean.valueOf(_name.endsWith(".java"));
      }
    };
    Iterable<File> _filter = IterableExtensions.<File>filter(((Iterable<File>)Conversions.doWrapArray(_listFiles)), _function);
    for (final File file : _filter) {
      String _path_1 = file.getPath();
      args.add(_path_1);
    }
    File _file_1 = new File(modulePath, "xtend-gen");
    File[] _listFiles_1 = _file_1.listFiles();
    final Function1<File, Boolean> _function_1 = new Function1<File, Boolean>() {
      @Override
      public Boolean apply(final File it) {
        String _name = it.getName();
        return Boolean.valueOf(_name.endsWith(".java"));
      }
    };
    Iterable<File> _filter_1 = IterableExtensions.<File>filter(((Iterable<File>)Conversions.doWrapArray(_listFiles_1)), _function_1);
    for (final File file_1 : _filter_1) {
      String _path_2 = file_1.getPath();
      args.add(_path_2);
    }
    int _size = args.size();
    boolean _lessThan = (before < _size);
    TestCase.assertTrue("No Java files!", _lessThan);
    String[] _stringArray = ArrayUtil.toStringArray(args);
    Main.compile(_stringArray);
  }
  
  protected void startDebugProcess(final String className) throws ExecutionException, InterruptedException, InvocationTargetException {
    TestCase.assertTrue((this.myDebugProcess == null));
    JavaParameters _javaParameters = new JavaParameters();
    final Procedure1<JavaParameters> _function = new Procedure1<JavaParameters>() {
      @Override
      public void apply(final JavaParameters it) {
        try {
          it.setMainClass(className);
          Module _module = AbstractDebuggerTestCase.this.getModule();
          Sdk _testProjectJdk = AbstractDebuggerTestCase.this.getTestProjectJdk();
          it.configureByModule(_module, JavaParameters.JDK_AND_CLASSES, _testProjectJdk);
          Module _module_1 = AbstractDebuggerTestCase.this.getModule();
          VirtualFile _moduleFile = _module_1.getModuleFile();
          VirtualFile _parent = _moduleFile.getParent();
          final String modulePath = _parent.getPath();
          final File classesDir = new File(modulePath, "classes");
          PathsList _classPath = it.getClassPath();
          _classPath.add(classesDir);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    JavaParameters _doubleArrow = ObjectExtensions.<JavaParameters>operator_doubleArrow(_javaParameters, _function);
    DebuggerSession _createLocalProcess = this.createLocalProcess(DebuggerSettings.SOCKET_TRANSPORT, _doubleArrow);
    this.myDebuggerSession = _createLocalProcess;
    DebugProcessImpl _process = this.myDebuggerSession.getProcess();
    this.myDebugProcess = _process;
    final Disposable _function_1 = new Disposable() {
      @Override
      public void dispose() {
        AbstractDebuggerTestCase.this.myDebugProcess.dispose();
      }
    };
    this.<Disposable>disposeOnTearDown(_function_1);
    final Runnable _function_2 = new Runnable() {
      @Override
      public void run() {
        try {
          DebugProcessImpl _process = AbstractDebuggerTestCase.this.myDebuggerSession.getProcess();
          ProcessHandler _processHandler = _process.getProcessHandler();
          _processHandler.startNotify();
          while ((!AbstractDebuggerTestCase.this.myDebuggerSession.isAttached())) {
            {
              UIUtil.dispatchAllInvocationEvents();
              Thread.sleep(10);
            }
          }
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    this.waitForContextChange(_function_2);
  }
  
  private DebuggerSession createLocalProcess(final int transport, final JavaParameters myJavaParameters) throws ExecutionException, InterruptedException, InvocationTargetException {
    abstract class __AbstractDebuggerTestCase_1 extends DebuggerTestCase {
      public abstract DebuggerTestCase.MockConfiguration createMockConf();
    }
    
    final DebuggerSession[] debuggerSession = { null };
    DebuggerSettings _instance = DebuggerSettings.getInstance();
    _instance.DEBUGGER_TRANSPORT = transport;
    GenericDebuggerRunnerSettings debuggerRunnerSettings = new GenericDebuggerRunnerSettings();
    debuggerRunnerSettings.LOCAL = true;
    debuggerRunnerSettings.setDebugPort("3456");
    __AbstractDebuggerTestCase_1 ___AbstractDebuggerTestCase_1 = new __AbstractDebuggerTestCase_1() {
      @Override
      protected String getTestAppPath() {
        return null;
      }
      
      @Override
      protected OutputChecker initOutputChecker() {
        return null;
      }
      
      public DebuggerTestCase.MockConfiguration createMockConf() {
        return new DebuggerTestCase.MockConfiguration();
      }
    };
    final DebuggerTestCase.MockConfiguration profile = ___AbstractDebuggerTestCase_1.createMockConf();
    Executor _debugExecutorInstance = DefaultDebugExecutor.getDebugExecutorInstance();
    ExecutionEnvironmentBuilder _executionEnvironmentBuilder = new ExecutionEnvironmentBuilder(this.myProject, _debugExecutorInstance);
    ExecutionEnvironmentBuilder _runnerSettings = _executionEnvironmentBuilder.runnerSettings(debuggerRunnerSettings);
    ExecutionEnvironmentBuilder _runProfile = _runnerSettings.runProfile(profile);
    ExecutionEnvironment environment = _runProfile.build();
    final JavaCommandLineState javaCommandLineState = new JavaCommandLineState(environment) {
      @Override
      protected JavaParameters createJavaParameters() {
        return myJavaParameters;
      }
      
      @Override
      protected GeneralCommandLine createCommandLine() throws ExecutionException {
        JavaParameters _javaParameters = this.getJavaParameters();
        return CommandLineBuilder.createFromJavaParameters(_javaParameters);
      }
    };
    JavaParameters _javaParameters = javaCommandLineState.getJavaParameters();
    final RemoteConnection debugParameters = DebuggerManagerImpl.createDebugParameters(_javaParameters, debuggerRunnerSettings, true);
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        try {
          ExecutionEnvironment _environment = javaCommandLineState.getEnvironment();
          DebuggerSession _attachVirtualMachine = AbstractDebuggerTestCase.this.attachVirtualMachine(javaCommandLineState, _environment, debugParameters, 
            false);
          debuggerSession[0] = _attachVirtualMachine;
        } catch (final Throwable _t) {
          if (_t instanceof ExecutionException) {
            final ExecutionException e = (ExecutionException)_t;
            String _message = e.getMessage();
            TestCase.fail(_message);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
    };
    this.invokeAndWaitIfNeeded(_function);
    DebuggerSession _get = debuggerSession[0];
    DebugProcessImpl _process = _get.getProcess();
    final ProcessHandler processHandler = _process.getProcessHandler();
    DebuggerSession _get_1 = debuggerSession[0];
    DebugProcessImpl _process_1 = _get_1.getProcess();
    _process_1.addProcessListener(new ProcessAdapter() {
      @Override
      public void onTextAvailable(final ProcessEvent event, final Key outputType) {
        String _text = event.getText();
        String _plus = (_text + " - ");
        String _plus_1 = (_plus + outputType);
        InputOutput.<String>println(_plus_1);
      }
    });
    DebuggerManagerEx _instanceEx = DebuggerManagerEx.getInstanceEx(this.myProject);
    DebugProcess _debugProcess = _instanceEx.getDebugProcess(processHandler);
    DebugProcessImpl process = ((DebugProcessImpl) _debugProcess);
    TestCase.assertNotNull(process);
    return debuggerSession[0];
  }
  
  private void invokeAndWaitIfNeeded(final Runnable run) {
    UIUtil.invokeAndWaitIfNeeded(run);
  }
  
  private DebuggerSession attachVirtualMachine(final RunProfileState state, final ExecutionEnvironment environment, final RemoteConnection remoteConnection, final boolean pollConnection) throws ExecutionException {
    DebuggerManagerEx _instanceEx = DebuggerManagerEx.getInstanceEx(this.myProject);
    DefaultDebugEnvironment _defaultDebugEnvironment = new DefaultDebugEnvironment(environment, state, remoteConnection, pollConnection);
    final DebuggerSession debuggerSession = _instanceEx.attachVirtualMachine(_defaultDebugEnvironment);
    XDebuggerManager _instance = XDebuggerManager.getInstance(this.myProject);
    _instance.startSession(environment, new XDebugProcessStarter() {
      @NotNull
      @Override
      public XDebugProcess start(@NotNull final XDebugSession session) {
        return JavaDebugProcess.create(session, debuggerSession);
      }
    });
    return debuggerSession;
  }
}
