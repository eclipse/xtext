package org.eclipse.xtext.idea.tests.debug

import com.google.common.base.Objects
import com.intellij.debugger.DebuggerManagerEx
import com.intellij.debugger.DebuggerTestCase.MockConfiguration
import com.intellij.debugger.DefaultDebugEnvironment
import com.intellij.debugger.engine.DebugProcessImpl
import com.intellij.debugger.engine.JavaDebugProcess
import com.intellij.debugger.impl.DebuggerManagerImpl
import com.intellij.debugger.impl.DebuggerSession
import com.intellij.debugger.impl.GenericDebuggerRunnerSettings
import com.intellij.debugger.settings.DebuggerSettings
import com.intellij.debugger.ui.breakpoints.LineBreakpoint
import com.intellij.execution.ExecutionException
import com.intellij.execution.configurations.CommandLineBuilder
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.configurations.JavaCommandLineState
import com.intellij.execution.configurations.JavaParameters
import com.intellij.execution.configurations.RemoteConnection
import com.intellij.execution.configurations.RunProfileState
import com.intellij.execution.executors.DefaultDebugExecutor
import com.intellij.execution.process.ProcessAdapter
import com.intellij.execution.process.ProcessEvent
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.execution.runners.ExecutionEnvironmentBuilder
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.application.PathManager
import com.intellij.openapi.module.Module
import com.intellij.openapi.projectRoots.impl.JavaAwareProjectJdkTableImpl
import com.intellij.openapi.projectRoots.impl.ProjectJdkImpl
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.openapi.util.Computable
import com.intellij.openapi.util.Key
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiManager
import com.intellij.testFramework.IdeaTestCase
import com.intellij.util.ArrayUtil
import com.intellij.util.ui.UIUtil
import com.intellij.xdebugger.XDebugProcess
import com.intellij.xdebugger.XDebugProcessStarter
import com.intellij.xdebugger.XDebugSession
import com.intellij.xdebugger.XDebuggerManager
import com.sun.tools.javac.Main
import java.io.File
import java.lang.reflect.InvocationTargetException
import java.util.ArrayList
import java.util.List
import junit.framework.TestCase
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.psi.impl.BaseXtextFile
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.validation.CheckMode
import org.jetbrains.annotations.NotNull

import static junit.framework.TestCase.*

abstract class AbstractDebuggerTestCase extends IdeaTestCase {
	
	override protected isRunInWriteAction() {
		return false
	}
	
	protected def <T> T write(Computable<T> c) {
		ApplicationManager.application.runWriteAction(c)
	}

	DebuggerSession myDebuggerSession

	DebugProcessImpl myDebugProcess
	
	protected def VirtualFile addFile(Pair<String,String> file) {
		write [
			val result = srcFolder.createChildData(null, file.key)
			result.binaryContent = file.value.getBytes
			assertNoCompileErrors(result)
			return result
		]
	}
	
	override protected setUp() throws Exception {
		super.setUp()
		write [
			val mnr = ModuleRootManager.getInstance(module)
			val model = mnr.modifiableModel
			val entry = model.addContentEntry(project.baseDir)
			srcFolder = project.baseDir.createChildDirectory(null, "src")
			entry.addSourceFolder(srcFolder, false)
			configureModule(module, model, entry)
			model.commit
			return null;
		]
	}
	
	abstract def void configureModule(Module module, ModifiableRootModel model, ContentEntry entry);
	
	protected def void assertCurrentLine(VirtualFile file, String fragment) {
		val sp = myDebuggerSession.contextManager.context.sourcePosition
		assertEquals(file , sp.file.virtualFile)
		val doc = PsiDocumentManager.getInstance(project).getDocument(sp.file)
		val index = doc.text.indexOf(fragment)
		if (index == -1) {
			fail("couldn't find '"+fragment+"' in file "+sp.file.virtualFile.name)
		}
		assertEquals(doc.getLineNumber(index), sp.line)
	}
	
	protected def void assertCurrentLine(VirtualFile file, int line) {
		val sp = myDebuggerSession.contextManager.context.sourcePosition
		assertEquals(file , sp.file.virtualFile)
		assertEquals(line, sp.line)
	}
	
	
	protected def void assertProcessTerminated() {
		assertTrue(myDebugProcess.getProcessHandler.processTerminated)
	}

	protected def LineBreakpoint addLineBreakpoint(VirtualFile file, int line) {
		val breakpointManager = DebuggerManagerImpl.getInstanceEx(myProject).getBreakpointManager();
		val psiFile = PsiManager.getInstance(myProject).findFile(file)
		val document = PsiDocumentManager.getInstance(myProject).getDocument(psiFile);
		return breakpointManager.addLineBreakpoint(document, line)
	}

	static val timeout = 10_000_000
	
	VirtualFile srcFolder

	protected def stepOver(int times) {
		for (i : 0..<times) {
			stepOver
		}
	}
	protected def stepOver() {
		waitForContextChange [
			myDebuggerSession.stepOver(false)
		]
	}
	
	protected def stepInto() {
		waitForContextChange [
			myDebuggerSession.stepInto(false, null)
		]
	}
	
	protected def stepOut() {
		waitForContextChange [
			myDebuggerSession.stepOut
		]
	}
	
	private def waitForContextChange(Runnable command) {
		var i = 0
		val suspendManager = myDebugProcess.suspendManager
		val oldSourcePosition = myDebugProcess.session.contextManager.context.sourcePosition
		command.run
		while (i++ < timeout / 10 
			&& (oldSourcePosition == myDebugProcess.session.contextManager.context.sourcePosition 
			|| myDebugProcess.session.contextManager.context.sourcePosition == null)) {
			Thread.sleep(10)
			UIUtil.dispatchAllInvocationEvents()
		}
		if (oldSourcePosition == myDebugProcess.session.contextManager.context.sourcePosition) {
			fail('''too long process, terminated=«myDebugProcess.processHandler.processTerminated»''')
		}
		return suspendManager.pausedContext
	}

	override protected getTestProjectJdk() {
		try {
			var ProjectJdkImpl jdk = JavaAwareProjectJdkTableImpl.getInstanceEx().getInternalJdk().
				clone() as ProjectJdkImpl
			jdk.setName("JDK")
			return jdk
		} catch (CloneNotSupportedException e) {
			LOG.error(e)
			return null
		}
	}
	
	private def void assertNoCompileErrors(VirtualFile file) {
		val psiFile = psiManager.findFile(file)
		if (psiFile instanceof BaseXtextFile) {
			val resource = psiFile.resource
			val issues = resource.resourceServiceProvider.resourceValidator.validate(resource, CheckMode.NORMAL_AND_FAST, CancelIndicator.NullImpl)
			assertFalse(issues.toString, issues.exists[severity==Severity.ERROR])
		}
	}

	protected def void compile() {
		val List<String> args = new ArrayList<String>()
		args.add("-g")
		args.add("-d")
		val modulePath = module.moduleFile.parent.path
		val classesDir = new File(modulePath, "classes")
		classesDir.mkdir
		args.add(classesDir.path)
		
		val Class<TestCase> testCaseClass = TestCase
		val String junitLibRoot = PathManager.getResourceRoot(
			testCaseClass, '''/«testCaseClass.getName().replace(Character.valueOf('.').charValue, Character.valueOf('/').charValue)».class''')
		if (junitLibRoot !== null) {
			args.add("-cp")
			args.add(#[junitLibRoot, 
				PathManager.getJarPathForClass(Objects), 
				PathManager.getJarPathForClass(IterableExtensions),
				PathManager.getJarPathForClass(Accessors),
				PathManager.getJarPathForClass(Active)].join(File.pathSeparator))
		}
		val before = args.size
		for (File file : new File(modulePath, "src").listFiles.filter[name.endsWith(".java")]) {
			args.add(file.getPath())
		}
		for (File file : new File(modulePath, "xtend-gen").listFiles.filter[name.endsWith(".java")]) {
			args.add(file.getPath())
		}
		assertTrue("No Java files!", before < args.size)
		Main.compile(ArrayUtil.toStringArray(args))
	}
	
	protected def void startDebugProcess(String className) throws ExecutionException, InterruptedException, InvocationTargetException {
		assertTrue(myDebugProcess === null)
		myDebuggerSession = createLocalProcess(DebuggerSettings.SOCKET_TRANSPORT, new JavaParameters => [
			mainClass = className
			configureByModule(module, JavaParameters.JDK_AND_CLASSES, testProjectJdk)
			val modulePath = module.moduleFile.parent.path
			val classesDir = new File(modulePath, "classes")
			it.classPath.add(classesDir)
		])
		myDebugProcess = myDebuggerSession.getProcess()
		disposeOnTearDown [
			myDebugProcess.dispose
		]
		waitForContextChange [
			myDebuggerSession.process.processHandler.startNotify
			while (myDebuggerSession.state == 2) {
				UIUtil.dispatchAllInvocationEvents()
				Thread.sleep(10)
			}
		]
	}

	private def DebuggerSession createLocalProcess(int transport,
		JavaParameters myJavaParameters) throws ExecutionException, InterruptedException, InvocationTargetException {
		val DebuggerSession[] debuggerSession = #[null]
		DebuggerSettings.getInstance().DEBUGGER_TRANSPORT = transport
		var GenericDebuggerRunnerSettings debuggerRunnerSettings = new GenericDebuggerRunnerSettings()
		debuggerRunnerSettings.LOCAL = true
		debuggerRunnerSettings.setDebugPort("3456")
		var ExecutionEnvironment environment = new ExecutionEnvironmentBuilder(myProject,
			DefaultDebugExecutor.getDebugExecutorInstance()).runnerSettings(debuggerRunnerSettings).runProfile(
			new MockConfiguration()).build()
		val JavaCommandLineState javaCommandLineState = new JavaCommandLineState(environment) {
			override protected JavaParameters createJavaParameters() {
				return myJavaParameters
			}

			override protected GeneralCommandLine createCommandLine() throws ExecutionException {
				return CommandLineBuilder.createFromJavaParameters(getJavaParameters())
			}
		}
		val RemoteConnection debugParameters = DebuggerManagerImpl.createDebugParameters(
			javaCommandLineState.getJavaParameters(), debuggerRunnerSettings, true)
		invokeAndWaitIfNeeded [

			try {
				debuggerSession.set(0,
					attachVirtualMachine(javaCommandLineState, javaCommandLineState.getEnvironment(), debugParameters,
						false))
			} catch (ExecutionException e) {
				fail(e.getMessage())
			}
		]

		val ProcessHandler processHandler = debuggerSession.get(0).getProcess().getProcessHandler()
		debuggerSession.get(0).getProcess().addProcessListener(new ProcessAdapter() {
			override void onTextAvailable(ProcessEvent event, Key outputType) {
				println(event.getText() + ' - ' + outputType)
			}
		})
		var DebugProcessImpl process = DebuggerManagerEx.getInstanceEx(myProject).
			getDebugProcess(processHandler) as DebugProcessImpl
		assertNotNull(process)
		return debuggerSession.get(0)
	}


	private def invokeAndWaitIfNeeded(Runnable run) {
		UIUtil.invokeAndWaitIfNeeded(run)
	}

	private def DebuggerSession attachVirtualMachine(RunProfileState state, ExecutionEnvironment environment,
		RemoteConnection remoteConnection, boolean pollConnection) throws ExecutionException {
		val DebuggerSession debuggerSession = DebuggerManagerEx.getInstanceEx(myProject).attachVirtualMachine(
			new DefaultDebugEnvironment(environment, state, remoteConnection, pollConnection))
		XDebuggerManager.getInstance(myProject).startSession(environment, new XDebugProcessStarter() {
			@NotNull override XDebugProcess start(@NotNull XDebugSession session) {
				return JavaDebugProcess.create(session, debuggerSession)
			}
		})
		return debuggerSession
	}

}