/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.javaconverter;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.intellij.codeInsight.FileModificationService;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.application.Application;
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
import com.intellij.openapi.roots.ProjectFileIndex;
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
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
      Set<Map.Entry<PsiFile, JavaConverter.ConversionResult>> _entrySet = runnables.entrySet();
      final Function1<Map.Entry<PsiFile, JavaConverter.ConversionResult>, Runnable> _function = new Function1<Map.Entry<PsiFile, JavaConverter.ConversionResult>, Runnable>() {
        @Override
        public Runnable apply(final Map.Entry<PsiFile, JavaConverter.ConversionResult> resultEntry) {
          return ((Runnable) new Runnable() {
            @Override
            public void run() {
              try {
                final JavaConverter.ConversionResult result = resultEntry.getValue();
                String _xtendCode = result.getXtendCode();
                boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_xtendCode);
                boolean _not = (!_isNullOrEmpty);
                if (_not) {
                  PsiFile _key = resultEntry.getKey();
                  final VirtualFile jvf = _key.getVirtualFile();
                  String _nameWithoutExtension = jvf.getNameWithoutExtension();
                  final String xtendFileName = (_nameWithoutExtension + ".xtend");
                  VirtualFile _parent = jvf.getParent();
                  VirtualFile _findChild = _parent.findChild(xtendFileName);
                  boolean _tripleEquals = (_findChild == null);
                  if (_tripleEquals) {
                    VirtualFile _parent_1 = jvf.getParent();
                    final VirtualFile xtendFile = _parent_1.createChildData(this, xtendFileName);
                    String _xtendCode_1 = result.getXtendCode();
                    byte[] _bytes = _xtendCode_1.getBytes();
                    xtendFile.setBinaryContent(_bytes);
                    PsiFile _key_1 = resultEntry.getKey();
                    final Project project = _key_1.getProject();
                    final CodeStyleManager formatter = CodeStyleManager.getInstance(project);
                    final PsiFile xtendPsiFile = PsiUtil.getPsiFile(project, xtendFile);
                    formatter.reformat(xtendPsiFile);
                    jvf.delete(this);
                    int _size = runnables.size();
                    boolean _tripleEquals_1 = (_size == 1);
                    if (_tripleEquals_1) {
                      Application _application = ApplicationManager.getApplication();
                      final Runnable _function = new Runnable() {
                        @Override
                        public void run() {
                          FileEditorManager _instance = FileEditorManager.getInstance(project);
                          _instance.openFile(xtendFile, true);
                        }
                      };
                      _application.invokeLater(_function);
                    }
                  }
                }
              } catch (Throwable _e) {
                throw Exceptions.sneakyThrow(_e);
              }
            }
          });
        }
      };
      Iterable<Runnable> _map = IterableExtensions.<Map.Entry<PsiFile, JavaConverter.ConversionResult>, Runnable>map(_entrySet, _function);
      Iterator<Runnable> _iterator = _map.iterator();
      this.workUnits = _iterator;
      this.progressTask = modalProgressTask;
      int _size = runnables.size();
      this.todo = _size;
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
      Runnable _next = this.workUnits.next();
      _next.run();
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
    List<PsiElement> _newImmutableList = CollectionLiterals.<PsiElement>newImmutableList(file);
    this.invoke(project, ((PsiElement[])Conversions.unwrapArray(_newImmutableList, PsiElement.class)), dataContext);
  }
  
  @Override
  public void invoke(final Project project, final PsiElement[] elements, final DataContext dataContext) {
    HashSet<PsiJavaFile> _newHashSet = CollectionLiterals.<PsiJavaFile>newHashSet();
    Collection<PsiJavaFile> _collectJavaFiles = this.collectJavaFiles(elements, _newHashSet);
    Project _data = CommonDataKeys.PROJECT.getData(dataContext);
    this.runJavaConverter(_collectJavaFiles, _data);
  }
  
  public Collection<PsiJavaFile> collectJavaFiles(final PsiElement[] elements, final Set<PsiJavaFile> collector) {
    final Procedure1<PsiElement> _function = new Procedure1<PsiElement>() {
      @Override
      public void apply(final PsiElement it) {
        if ((it instanceof PsiJavaFile)) {
          collector.add(((PsiJavaFile)it));
        } else {
          if ((it instanceof PsiDirectory)) {
            PsiElement[] _children = ((PsiDirectory)it).getChildren();
            Collection<PsiJavaFile> _collectJavaFiles = ConvertJavaCodeHandler.this.collectJavaFiles(_children, collector);
            collector.addAll(_collectJavaFiles);
          } else {
            PsiFile _containingFile = it.getContainingFile();
            if ((_containingFile instanceof PsiJavaFile)) {
              PsiFile _containingFile_1 = it.getContainingFile();
              collector.add(((PsiJavaFile) _containingFile_1));
            }
          }
        }
      }
    };
    IterableExtensions.<PsiElement>forEach(((Iterable<PsiElement>)Conversions.doWrapArray(elements)), _function);
    return collector;
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
        final Procedure1<PsiJavaFile> _function = new Procedure1<PsiJavaFile>() {
          @Override
          public void apply(final PsiJavaFile javaFile) {
            boolean _isCanceled = indicator.isCanceled();
            if (_isCanceled) {
              return;
            }
            String _name = javaFile.getName();
            String _plus = ("Converting " + _name);
            indicator.setText(_plus);
            final JavaConverter jc = ConvertJavaCodeHandler.this.jcProvider.get();
            Application _application = ApplicationManager.getApplication();
            final Function1<Object, String> _function = new Function1<Object, String>() {
              @Override
              public String apply(final Object it) {
                return javaFile.getText();
              }
            };
            final String javaSrc = _application.<String>runReadAction(((Computable<String>) new Computable<String>() {
                public String compute() {
                  return _function.apply(null);
                }
            }));
            Project _project = _this__ConvertJavaCodeHandler_1.getProject();
            ProjectRootManager _instance = ProjectRootManager.getInstance(_project);
            ProjectFileIndex _fileIndex = _instance.getFileIndex();
            VirtualFile _virtualFile = javaFile.getVirtualFile();
            final Module context = _fileIndex.getModuleForFile(_virtualFile);
            VirtualFile _virtualFile_1 = javaFile.getVirtualFile();
            String _nameWithoutExtension = _virtualFile_1.getNameWithoutExtension();
            final JavaConverter.ConversionResult result = jc.toXtend(_nameWithoutExtension, javaSrc, context);
            String _xtendCode = result.getXtendCode();
            String _format = ConvertJavaCodeHandler.this.formatter.format(_xtendCode);
            result.setXtendCode(_format);
            coversionResult.put(javaFile, result);
            _this__ConvertJavaCodeHandler_1.done++;
            int _size = files.size();
            double _divide = (((double) _this__ConvertJavaCodeHandler_1.done) / _size);
            indicator.setFraction(_divide);
          }
        };
        IterableExtensions.<PsiJavaFile>forEach(files, _function);
      }
      
      @Override
      public void onSuccess() {
        boolean _isEmpty = coversionResult.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          FileModificationService _instance = FileModificationService.getInstance();
          Set<PsiFile> _keySet = coversionResult.keySet();
          boolean _preparePsiElementsForWrite = _instance.preparePsiElementsForWrite(_keySet);
          boolean _not_1 = (!_preparePsiElementsForWrite);
          if (_not_1) {
            return;
          }
          Project _project = this.getProject();
          final SequentialModalProgressTask progressTask = new SequentialModalProgressTask(_project, "Applying conversion results", true);
          progressTask.setMinIterationTime(50);
          ConvertJavaCodeHandler.ConvertJavaSequentialTask _convertJavaSequentialTask = new ConvertJavaCodeHandler.ConvertJavaSequentialTask(coversionResult, progressTask);
          progressTask.setTask(_convertJavaSequentialTask);
          CommandProcessor _instance_1 = CommandProcessor.getInstance();
          Project _project_1 = this.getProject();
          final Runnable _function = new Runnable() {
            @Override
            public void run() {
              CommandProcessor _instance = CommandProcessor.getInstance();
              Project _project = _this__ConvertJavaCodeHandler_1.getProject();
              _instance.markCurrentCommandAsGlobal(_project);
              Application _application = ApplicationManager.getApplication();
              final Function1<Object, String> _function = new Function1<Object, String>() {
                @Override
                public String apply(final Object it) {
                  String _xtrycatchfinallyexpression = null;
                  try {
                    ProgressManager _instance = ProgressManager.getInstance();
                    _instance.run(progressTask);
                  } catch (final Throwable _t) {
                    if (_t instanceof ProcessCanceledException) {
                      final ProcessCanceledException e = (ProcessCanceledException)_t;
                      _xtrycatchfinallyexpression = InputOutput.<String>println("Canceled");
                    } else {
                      throw Exceptions.sneakyThrow(_t);
                    }
                  }
                  return _xtrycatchfinallyexpression;
                }
              };
              _application.runWriteAction(
                ((Runnable) new Runnable() {
                    public void run() {
                      _function.apply(null);
                    }
                }));
            }
          };
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Convert ");
          Set<PsiFile> _keySet_1 = coversionResult.keySet();
          int _size = _keySet_1.size();
          _builder.append(_size, "");
          _builder.append(" Java to Xtend");
          _instance_1.executeCommand(_project_1, _function, _builder.toString(), null);
        }
      }
    };
    ProgressManager _instance = ProgressManager.getInstance();
    _instance.run(task);
  }
}
