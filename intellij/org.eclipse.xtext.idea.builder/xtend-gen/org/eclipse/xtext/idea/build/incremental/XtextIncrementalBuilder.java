package org.eclipse.xtext.idea.build.incremental;

import com.google.common.base.Objects;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.intellij.openapi.util.SystemInfo;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtext.builder.standalone.LanguageAccess;
import org.eclipse.xtext.idea.build.XtextIdeaRefreshComponent;
import org.eclipse.xtext.idea.build.incremental.IdeaBuildData;
import org.eclipse.xtext.idea.build.incremental.IdeaStandaloneBuilder;
import org.eclipse.xtext.idea.build.incremental.IdeaStandaloneBuilderModule;
import org.eclipse.xtext.idea.build.incremental.XtextLanguages;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.jetbrains.jps.ModuleChunk;
import org.jetbrains.jps.builders.DirtyFilesHolder;
import org.jetbrains.jps.builders.FileProcessor;
import org.jetbrains.jps.builders.java.JavaSourceRootDescriptor;
import org.jetbrains.jps.incremental.BuilderCategory;
import org.jetbrains.jps.incremental.CompileContext;
import org.jetbrains.jps.incremental.ModuleBuildTarget;
import org.jetbrains.jps.incremental.ModuleLevelBuilder;
import org.jetbrains.jps.incremental.ProjectBuildException;
import org.jetbrains.jps.incremental.messages.CustomBuilderMessage;

@SuppressWarnings("all")
public class XtextIncrementalBuilder extends ModuleLevelBuilder {
  private final static Injector standaloneInjector = Guice.createInjector(new IdeaStandaloneBuilderModule());
  
  @Inject
  private XtextIdeaRefreshComponent refreshComponent;
  
  public XtextIncrementalBuilder() {
    super(BuilderCategory.SOURCE_GENERATOR);
  }
  
  @Override
  public ModuleLevelBuilder.ExitCode build(final CompileContext context, final ModuleChunk chunk, final DirtyFilesHolder<JavaSourceRootDescriptor, ModuleBuildTarget> dirtyFilesHolder, final ModuleLevelBuilder.OutputConsumer outputConsumer) throws ProjectBuildException, IOException {
    boolean _and = false;
    boolean _hasDirtyFiles = dirtyFilesHolder.hasDirtyFiles();
    boolean _not = (!_hasDirtyFiles);
    if (!_not) {
      _and = false;
    } else {
      boolean _hasRemovedFiles = dirtyFilesHolder.hasRemovedFiles();
      boolean _not_1 = (!_hasRemovedFiles);
      _and = _not_1;
    }
    if (_and) {
      return ModuleLevelBuilder.ExitCode.NOTHING_DONE;
    }
    final ArrayList<File> dirtyJavaFiles = CollectionLiterals.<File>newArrayList();
    final ArrayList<File> dirtyXtextFiles = CollectionLiterals.<File>newArrayList();
    final FileProcessor<JavaSourceRootDescriptor, ModuleBuildTarget> _function = new FileProcessor<JavaSourceRootDescriptor, ModuleBuildTarget>() {
      @Override
      public boolean apply(final ModuleBuildTarget target, final File file, final JavaSourceRootDescriptor root) throws IOException {
        boolean _xblockexpression = false;
        {
          final String fileExtension = XtextIncrementalBuilder.this.getFileExtension(file);
          boolean _equals = Objects.equal(fileExtension, "java");
          if (_equals) {
            dirtyJavaFiles.add(file);
          } else {
            Map<String, LanguageAccess> _languageAccesses = XtextLanguages.getLanguageAccesses();
            Set<String> _keySet = _languageAccesses.keySet();
            boolean _contains = _keySet.contains(fileExtension);
            if (_contains) {
              dirtyXtextFiles.add(file);
            }
          }
          _xblockexpression = true;
        }
        return _xblockexpression;
      }
    };
    dirtyFilesHolder.processDirtyFiles(_function);
    String _presentableName = this.getPresentableName();
    final IdeaBuildData buildData = new IdeaBuildData(_presentableName, context, chunk, outputConsumer, this.refreshComponent);
    IdeaStandaloneBuilder _instance = XtextIncrementalBuilder.standaloneInjector.<IdeaStandaloneBuilder>getInstance(IdeaStandaloneBuilder.class);
    final Procedure1<IdeaStandaloneBuilder> _function_1 = new Procedure1<IdeaStandaloneBuilder>() {
      @Override
      public void apply(final IdeaStandaloneBuilder it) {
        it.setBuildData(buildData);
        it.setFailOnValidationError(false);
        Map<String, LanguageAccess> _languageAccesses = XtextLanguages.getLanguageAccesses();
        it.setLanguages(_languageAccesses);
      }
    };
    final IdeaStandaloneBuilder standaloneBuilder = ObjectExtensions.<IdeaStandaloneBuilder>operator_doubleArrow(_instance, _function_1);
    boolean _launch = standaloneBuilder.launch();
    if (_launch) {
      return ModuleLevelBuilder.ExitCode.OK;
    } else {
      return ModuleLevelBuilder.ExitCode.ABORT;
    }
  }
  
  @Override
  public void buildFinished(final CompileContext context) {
    final Collection<String> filesToRefresh = this.refreshComponent.getFilesToRefresh();
    boolean _isEmpty = filesToRefresh.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      for (final String file : filesToRefresh) {
        CustomBuilderMessage _customBuilderMessage = new CustomBuilderMessage("xtext", "generated", file);
        context.processMessage(_customBuilderMessage);
      }
      CustomBuilderMessage _customBuilderMessage_1 = new CustomBuilderMessage("xtext", "refresh", "");
      context.processMessage(_customBuilderMessage_1);
    }
  }
  
  @Override
  public List<String> getCompilableFileExtensions() {
    Map<String, LanguageAccess> _languageAccesses = XtextLanguages.getLanguageAccesses();
    Set<String> _keySet = _languageAccesses.keySet();
    return IterableExtensions.<String>toList(_keySet);
  }
  
  private String getFileExtension(final File file) {
    String _xifexpression = null;
    if (SystemInfo.isFileSystemCaseSensitive) {
      _xifexpression = file.getName();
    } else {
      String _name = file.getName();
      _xifexpression = _name.toLowerCase();
    }
    final String fileName = _xifexpression;
    final int index = fileName.lastIndexOf(".");
    if ((index != (-1))) {
      String _name_1 = file.getName();
      String _name_2 = file.getName();
      int _lastIndexOf = _name_2.lastIndexOf(".");
      int _plus = (_lastIndexOf + 1);
      return _name_1.substring(_plus);
    } else {
      return null;
    }
  }
  
  @Override
  public String getPresentableName() {
    return "Xtext (incremental)";
  }
}
