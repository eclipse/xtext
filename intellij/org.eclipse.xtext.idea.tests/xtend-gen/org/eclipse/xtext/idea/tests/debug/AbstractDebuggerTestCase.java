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
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.PathManager;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.projectRoots.impl.JavaAwareProjectJdkTableImpl;
import com.intellij.openapi.projectRoots.impl.ProjectJdkImpl;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.util.Computable;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.testFramework.IdeaTestCase;
import com.intellij.testFramework.PlatformTestCase;
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
import junit.framework.TestCase;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.macro.Active;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("all")
public abstract class AbstractDebuggerTestCase extends IdeaTestCase {
  @Override
  protected boolean isRunInWriteAction() {
    return false;
  }
  
  protected <T extends Object> T write(final Computable<T> c) {
    Application _application = ApplicationManager.getApplication();
    return _application.<T>runWriteAction(c);
  }
  
  private DebuggerSession myDebuggerSession;
  
  private DebugProcessImpl myDebugProcess;
  
  protected VirtualFile addFile(final Pair<String, String> file) {
    final Computable<VirtualFile> _function = new Computable<VirtualFile>() {
      @Override
      public VirtualFile compute() {
        try {
          String _key = file.getKey();
          final VirtualFile result = AbstractDebuggerTestCase.this.srcFolder.createChildData(null, _key);
          String _value = file.getValue();
          byte[] _bytes = _value.getBytes();
          result.setBinaryContent(_bytes);
          AbstractDebuggerTestCase.this.assertNoCompileErrors(result);
          return result;
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    return this.<VirtualFile>write(_function);
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    final Computable<Object> _function = new Computable<Object>() {
      @Override
      public Object compute() {
        try {
          Module _module = AbstractDebuggerTestCase.this.getModule();
          final ModuleRootManager mnr = ModuleRootManager.getInstance(_module);
          final ModifiableRootModel model = mnr.getModifiableModel();
          Project _project = AbstractDebuggerTestCase.this.getProject();
          VirtualFile _baseDir = _project.getBaseDir();
          final ContentEntry entry = model.addContentEntry(_baseDir);
          Project _project_1 = AbstractDebuggerTestCase.this.getProject();
          VirtualFile _baseDir_1 = _project_1.getBaseDir();
          VirtualFile _createChildDirectory = _baseDir_1.createChildDirectory(null, "src");
          AbstractDebuggerTestCase.this.srcFolder = _createChildDirectory;
          entry.addSourceFolder(AbstractDebuggerTestCase.this.srcFolder, false);
          Module _module_1 = AbstractDebuggerTestCase.this.getModule();
          AbstractDebuggerTestCase.this.configureModule(_module_1, model, entry);
          model.commit();
          return null;
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    this.<Object>write(_function);
  }
  
  public abstract void configureModule(final Module module, final ModifiableRootModel model, final ContentEntry entry);
  
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
  
  protected LineBreakpoint addLineBreakpoint(final VirtualFile file, final int line) {
    DebuggerManagerEx _instanceEx = DebuggerManagerImpl.getInstanceEx(this.myProject);
    final BreakpointManager breakpointManager = _instanceEx.getBreakpointManager();
    PsiManager _instance = PsiManager.getInstance(this.myProject);
    final PsiFile psiFile = _instance.findFile(file);
    PsiDocumentManager _instance_1 = PsiDocumentManager.getInstance(this.myProject);
    final Document document = _instance_1.getDocument(psiFile);
    return breakpointManager.addLineBreakpoint(document, line);
  }
  
  private final static int timeout = 10000000;
  
  private VirtualFile srcFolder;
  
  protected void stepOver(final int times) {
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, times, true);
    for (final Integer i : _doubleDotLessThan) {
      this.stepOver();
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
  
  private SuspendContextImpl waitForContextChange(final Runnable command) {
    try {
      int i = 0;
      final SuspendManager suspendManager = this.myDebugProcess.getSuspendManager();
      DebuggerSession _session = this.myDebugProcess.getSession();
      DebuggerStateManager _contextManager = _session.getContextManager();
      DebuggerContextImpl _context = _contextManager.getContext();
      final SourcePosition oldSourcePosition = _context.getSourcePosition();
      command.run();
      while (((i++ < (AbstractDebuggerTestCase.timeout / 10)) && (Objects.equal(oldSourcePosition, this.myDebugProcess.getSession().getContextManager().getContext().getSourcePosition()) || Objects.equal(this.myDebugProcess.getSession().getContextManager().getContext().getSourcePosition(), null)))) {
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
        ProcessHandler _processHandler = this.myDebugProcess.getProcessHandler();
        boolean _isProcessTerminated = _processHandler.isProcessTerminated();
        _builder.append(_isProcessTerminated, "");
        TestCase.fail(_builder.toString());
      }
      return suspendManager.getPausedContext();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  protected Sdk getTestProjectJdk() {
    try {
      JavaAwareProjectJdkTableImpl _instanceEx = JavaAwareProjectJdkTableImpl.getInstanceEx();
      Sdk _internalJdk = _instanceEx.getInternalJdk();
      Object _clone = _internalJdk.clone();
      ProjectJdkImpl jdk = ((ProjectJdkImpl) _clone);
      jdk.setName("JDK");
      return jdk;
    } catch (final Throwable _t) {
      if (_t instanceof CloneNotSupportedException) {
        final CloneNotSupportedException e = (CloneNotSupportedException)_t;
        PlatformTestCase.LOG.error(e);
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  private void assertNoCompileErrors(final VirtualFile file) {
    PsiManager _psiManager = this.getPsiManager();
    final PsiFile psiFile = _psiManager.findFile(file);
    if ((psiFile instanceof BaseXtextFile)) {
      final XtextResource resource = ((BaseXtextFile)psiFile).getResource();
      IResourceServiceProvider _resourceServiceProvider = resource.getResourceServiceProvider();
      IResourceValidator _resourceValidator = _resourceServiceProvider.getResourceValidator();
      final List<Issue> issues = _resourceValidator.validate(resource, CheckMode.NORMAL_AND_FAST, CancelIndicator.NullImpl);
      String _string = issues.toString();
      final Function1<Issue, Boolean> _function = new Function1<Issue, Boolean>() {
        @Override
        public Boolean apply(final Issue it) {
          Severity _severity = it.getSeverity();
          return Boolean.valueOf(Objects.equal(_severity, Severity.ERROR));
        }
      };
      boolean _exists = IterableExtensions.<Issue>exists(issues, _function);
      TestCase.assertFalse(_string, _exists);
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
          while ((AbstractDebuggerTestCase.this.myDebuggerSession.getState() == 2)) {
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
    final DebuggerSession[] debuggerSession = { null };
    DebuggerSettings _instance = DebuggerSettings.getInstance();
    _instance.DEBUGGER_TRANSPORT = transport;
    GenericDebuggerRunnerSettings debuggerRunnerSettings = new GenericDebuggerRunnerSettings();
    debuggerRunnerSettings.LOCAL = true;
    debuggerRunnerSettings.setDebugPort("3456");
    Executor _debugExecutorInstance = DefaultDebugExecutor.getDebugExecutorInstance();
    ExecutionEnvironmentBuilder _executionEnvironmentBuilder = new ExecutionEnvironmentBuilder(this.myProject, _debugExecutorInstance);
    ExecutionEnvironmentBuilder _runnerSettings = _executionEnvironmentBuilder.runnerSettings(debuggerRunnerSettings);
    DebuggerTestCase.MockConfiguration _mockConfiguration = new DebuggerTestCase.MockConfiguration();
    ExecutionEnvironmentBuilder _runProfile = _runnerSettings.runProfile(_mockConfiguration);
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
