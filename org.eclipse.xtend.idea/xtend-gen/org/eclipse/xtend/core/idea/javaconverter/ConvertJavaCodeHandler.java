/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.javaconverter;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.intellij.codeInsight.FileModificationService;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.CommandProcessor;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.progress.ProcessCanceledException;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.util.Computable;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiJavaFile;
import com.intellij.psi.codeStyle.CodeStyleManager;
import com.intellij.psi.util.PsiUtil;
import com.intellij.refactoring.RefactoringActionHandler;
import com.intellij.util.SequentialModalProgressTask;
import com.intellij.util.SequentialTask;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.eclipse.xtend.core.formatting2.FormatterFacade;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;
import org.eclipse.xtend.core.javaconverter.JavaConverter;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class ConvertJavaCodeHandler implements RefactoringActionHandler {
  private static class ConvertJavaSequentialTask implements SequentialTask {
    private final int todo;
    
    private final Iterator<Runnable> workUnits;
    
    private final SequentialModalProgressTask progressTask;
    
    private int alreadyDone = 0;
    
    private ConvertJavaSequentialTask(final Map<PsiFile, JavaConverter.ConversionResult> runnables, final SequentialModalProgressTask modalProgressTask) {
      final Function1<Map.Entry<PsiFile, JavaConverter.ConversionResult>, Runnable> _function = (Map.Entry<PsiFile, JavaConverter.ConversionResult> resultEntry) -> {
        return ((Runnable) new Runnable() {
          @Override
          public void run() {
            try {
              final JavaConverter.ConversionResult result = resultEntry.getValue();
              boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(result.getXtendCode());
              boolean _not = (!_isNullOrEmpty);
              if (_not) {
                final VirtualFile jvf = resultEntry.getKey().getVirtualFile();
                String _nameWithoutExtension = jvf.getNameWithoutExtension();
                final String xtendFileName = (_nameWithoutExtension + ".xtend");
                VirtualFile _findChild = jvf.getParent().findChild(xtendFileName);
                boolean _tripleEquals = (_findChild == null);
                if (_tripleEquals) {
                  final VirtualFile xtendFile = jvf.getParent().createChildData(this, xtendFileName);
                  xtendFile.setBinaryContent(result.getXtendCode().getBytes());
                  final Project project = resultEntry.getKey().getProject();
                  final CodeStyleManager formatter = CodeStyleManager.getInstance(project);
                  final PsiFile xtendPsiFile = PsiUtil.getPsiFile(project, xtendFile);
                  formatter.reformat(xtendPsiFile);
                  jvf.delete(this);
                  int _size = runnables.size();
                  boolean _tripleEquals_1 = (_size == 1);
                  if (_tripleEquals_1) {
                    final Runnable _function = () -> {
                      FileEditorManager.getInstance(project).openFile(xtendFile, true);
                    };
                    ApplicationManager.getApplication().invokeLater(_function);
                  }
                }
              }
            } catch (Throwable _e) {
              throw Exceptions.sneakyThrow(_e);
            }
          }
        });
      };
      this.workUnits = IterableExtensions.<Map.Entry<PsiFile, JavaConverter.ConversionResult>, Runnable>map(runnables.entrySet(), _function).iterator();
      this.progressTask = modalProgressTask;
      this.todo = runnables.size();
    }
    
    @Override
    public void prepare() {
    }
    
    @Override
    public boolean isDone() {
      return (this.alreadyDone > (this.todo - 1));
    }
    
    @Override
    public boolean iteration() {
      final ProgressIndicator indicator = this.progressTask.getIndicator();
      if ((indicator != null)) {
        indicator.setFraction((((double) this.alreadyDone) / this.todo));
      }
      this.workUnits.next().run();
      this.alreadyDone++;
      return true;
    }
    
    @Override
    public void stop() {
      this.alreadyDone = this.todo;
    }
  }
  
  @Inject
  private Provider<JavaConverter> jcProvider;
  
  @Inject
  private FormatterFacade formatter;
  
  public ConvertJavaCodeHandler() {
    XtendLanguage.INSTANCE.injectMembers(this);
  }
  
  @Override
  public void invoke(final Project project, final Editor editor, final PsiFile file, final DataContext dataContext) {
    this.invoke(project, ((PsiElement[])Conversions.unwrapArray(CollectionLiterals.<PsiElement>newImmutableList(file), PsiElement.class)), dataContext);
  }
  
  @Override
  public void invoke(final Project project, final PsiElement[] elements, final DataContext dataContext) {
    this.runJavaConverter(IterableExtensions.<PsiJavaFile>toList(ConvertJavaCodeHandler.collectJavaFiles(elements)), CommonDataKeys.PROJECT.getData(dataContext));
  }
  
  public static Iterable<PsiJavaFile> collectJavaFiles(final PsiElement[] elements) {
    final Function1<PsiElement, Iterable<PsiJavaFile>> _function = (PsiElement it) -> {
      Iterable<PsiJavaFile> _xifexpression = null;
      if ((it instanceof PsiJavaFile)) {
        _xifexpression = ImmutableList.<PsiJavaFile>of(((PsiJavaFile)it));
      } else {
        Iterable<PsiJavaFile> _xifexpression_1 = null;
        PsiFile _containingFile = it.getContainingFile();
        if ((_containingFile instanceof PsiJavaFile)) {
          PsiFile _containingFile_1 = it.getContainingFile();
          _xifexpression_1 = ImmutableList.<PsiJavaFile>of(((PsiJavaFile) _containingFile_1));
        } else {
          Iterable<PsiJavaFile> _xifexpression_2 = null;
          if ((it instanceof PsiDirectory)) {
            _xifexpression_2 = ConvertJavaCodeHandler.collectJavaFiles(((PsiDirectory)it).getChildren());
          }
          _xifexpression_1 = _xifexpression_2;
        }
        _xifexpression = _xifexpression_1;
      }
      return _xifexpression;
    };
    final List<Iterable<PsiJavaFile>> iterables = ListExtensions.<PsiElement, Iterable<PsiJavaFile>>map(((List<PsiElement>)Conversions.doWrapArray(elements)), _function);
    return Iterables.<PsiJavaFile>concat(IterableExtensions.<Iterable<PsiJavaFile>>filterNull(iterables));
  }
  
  public void runJavaConverter(final Collection<PsiJavaFile> files, final Project project) {
    abstract class __ConvertJavaCodeHandler_1 extends Task.Backgroundable {
      final __ConvertJavaCodeHandler_1 _this__ConvertJavaCodeHandler_1 = this;
      
      __ConvertJavaCodeHandler_1(@Nullable final Project project, @Nls(capitalization = Nls.Capitalization.Title) @NotNull final String title, final boolean canBeCancelled) {
        super(project, title, canBeCancelled);
      }
      
      int done;
    }
    
    final Map<PsiFile, JavaConverter.ConversionResult> coversionResult = CollectionLiterals.<PsiFile, JavaConverter.ConversionResult>newHashMap();
    Task.Backgroundable task = new __ConvertJavaCodeHandler_1(project, "Conversion...", true) {
      {
        done = 0;
      }
      @Override
      public void run(final ProgressIndicator indicator) {
        final Consumer<PsiJavaFile> _function = (PsiJavaFile javaFile) -> {
          boolean _isCanceled = indicator.isCanceled();
          if (_isCanceled) {
            return;
          }
          String _name = javaFile.getName();
          String _plus = ("Converting " + _name);
          indicator.setText(_plus);
          final JavaConverter jc = ConvertJavaCodeHandler.this.jcProvider.get();
          final Function1<Object, String> _function_1 = (Object it) -> {
            return javaFile.getText();
          };
          final String javaSrc = ApplicationManager.getApplication().<String>runReadAction(((Computable<String>) new Computable<String>() {
              public String compute() {
                return _function_1.apply(null);
              }
          }));
          final Module context = ProjectRootManager.getInstance(this.getProject()).getFileIndex().getModuleForFile(
            javaFile.getVirtualFile());
          final JavaConverter.ConversionResult result = jc.toXtend(javaFile.getVirtualFile().getNameWithoutExtension(), javaSrc, context);
          result.setXtendCode(ConvertJavaCodeHandler.this.formatter.format(result.getXtendCode()));
          coversionResult.put(javaFile, result);
          this.done++;
          int _size = files.size();
          double _divide = (((double) this.done) / _size);
          indicator.setFraction(_divide);
        };
        files.forEach(_function);
      }
      
      @Override
      public void onSuccess() {
        boolean _isEmpty = coversionResult.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          boolean _preparePsiElementsForWrite = FileModificationService.getInstance().preparePsiElementsForWrite(coversionResult.keySet());
          boolean _not_1 = (!_preparePsiElementsForWrite);
          if (_not_1) {
            return;
          }
          Project _project = this.getProject();
          final SequentialModalProgressTask progressTask = new SequentialModalProgressTask(_project, "Applying conversion results", true);
          progressTask.setMinIterationTime(50);
          ConvertJavaCodeHandler.ConvertJavaSequentialTask _convertJavaSequentialTask = new ConvertJavaCodeHandler.ConvertJavaSequentialTask(coversionResult, progressTask);
          progressTask.setTask(_convertJavaSequentialTask);
          CommandProcessor _instance = CommandProcessor.getInstance();
          Project _project_1 = this.getProject();
          final Runnable _function = () -> {
            CommandProcessor.getInstance().markCurrentCommandAsGlobal(this.getProject());
            final Function1<Object, String> _function_1 = (Object it) -> {
              String _xtrycatchfinallyexpression = null;
              try {
                ProgressManager.getInstance().run(progressTask);
              } catch (final Throwable _t) {
                if (_t instanceof ProcessCanceledException) {
                  final ProcessCanceledException e = (ProcessCanceledException)_t;
                  _xtrycatchfinallyexpression = InputOutput.<String>println("Canceled");
                } else {
                  throw Exceptions.sneakyThrow(_t);
                }
              }
              return _xtrycatchfinallyexpression;
            };
            ApplicationManager.getApplication().runWriteAction(
              ((Runnable) new Runnable() {
                  public void run() {
                    _function_1.apply(null);
                  }
              }));
          };
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Convert ");
          int _size = coversionResult.keySet().size();
          _builder.append(_size);
          _builder.append(" Java to Xtend");
          _instance.executeCommand(_project_1, _function, _builder.toString(), null);
        }
      }
    };
    ProgressManager.getInstance().run(task);
  }
}
