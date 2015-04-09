/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.build.client;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.channels.SocketChannel;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.ISetupExtension;
import org.eclipse.xtext.idea.build.client.DaemonConnector;
import org.eclipse.xtext.idea.build.net.ObjectChannel;
import org.eclipse.xtext.idea.build.net.Protocol;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.jetbrains.jps.ModuleChunk;
import org.jetbrains.jps.ProjectPaths;
import org.jetbrains.jps.builders.DirtyFilesHolder;
import org.jetbrains.jps.builders.FileProcessor;
import org.jetbrains.jps.builders.java.JavaSourceRootDescriptor;
import org.jetbrains.jps.cmdline.ProjectDescriptor;
import org.jetbrains.jps.incremental.BuilderCategory;
import org.jetbrains.jps.incremental.CompileContext;
import org.jetbrains.jps.incremental.CompilerEncodingConfiguration;
import org.jetbrains.jps.incremental.FSOperations;
import org.jetbrains.jps.incremental.ModuleBuildTarget;
import org.jetbrains.jps.incremental.ModuleLevelBuilder;
import org.jetbrains.jps.incremental.ProjectBuildException;
import org.jetbrains.jps.incremental.fs.CompilationRound;
import org.jetbrains.jps.incremental.messages.BuildMessage;
import org.jetbrains.jps.incremental.messages.CompilerMessage;
import org.jetbrains.jps.incremental.messages.CustomBuilderMessage;
import org.jetbrains.jps.model.JpsUrlList;
import org.jetbrains.jps.model.java.JavaSourceRootProperties;
import org.jetbrains.jps.model.java.JavaSourceRootType;
import org.jetbrains.jps.model.module.JpsModule;
import org.jetbrains.jps.model.module.JpsModuleSourceRoot;
import org.jetbrains.jps.model.module.JpsTypedModuleSourceRoot;
import org.jetbrains.jps.service.JpsServiceManager;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtextIdeaBuilder extends ModuleLevelBuilder {
  private final static Logger LOG = Logger.getLogger(XtextIdeaBuilder.class);
  
  @Inject
  private DaemonConnector connector;
  
  public XtextIdeaBuilder() {
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
    ModuleLevelBuilder.ExitCode result = null;
    SocketChannel socketChannel = null;
    try {
      final Protocol.BuildRequestMessage buildRequest = this.createBuildRequest(chunk, context, dirtyFilesHolder);
      SocketChannel _connect = this.connector.connect();
      socketChannel = _connect;
      final ObjectChannel channel = new ObjectChannel(socketChannel);
      channel.writeObject(buildRequest);
      while (Objects.equal(result, null)) {
        {
          final Serializable message = channel.readObject();
          boolean _matched = false;
          if (!_matched) {
            if (message instanceof Protocol.BuildResultMessage) {
              _matched=true;
              this.handleBuildResult(((Protocol.BuildResultMessage)message), context, chunk, outputConsumer);
              result = ModuleLevelBuilder.ExitCode.OK;
            }
          }
          if (!_matched) {
            if (message instanceof Protocol.BuildIssueMessage) {
              _matched=true;
              this.reportIssue(((Protocol.BuildIssueMessage)message), context);
            }
          }
        }
      }
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception exc = (Exception)_t;
        XtextIdeaBuilder.LOG.error("Error in build", exc);
        String _message = exc.getMessage();
        context.processMessage(new BuildMessage(_message, BuildMessage.Kind.ERROR) {
        });
        result = ModuleLevelBuilder.ExitCode.ABORT;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    } finally {
      if (socketChannel!=null) {
        socketChannel.close();
      }
    }
    return result;
  }
  
  private Protocol.BuildRequestMessage createBuildRequest(final ModuleChunk chunk, final CompileContext context, final DirtyFilesHolder<JavaSourceRootDescriptor, ModuleBuildTarget> dirtyFilesHolder) {
    try {
      Protocol.BuildRequestMessage _xblockexpression = null;
      {
        final Protocol.BuildRequestMessage buildRequest = new Protocol.BuildRequestMessage();
        final FileProcessor<JavaSourceRootDescriptor, ModuleBuildTarget> _function = new FileProcessor<JavaSourceRootDescriptor, ModuleBuildTarget>() {
          @Override
          public boolean apply(final ModuleBuildTarget target, final File file, final JavaSourceRootDescriptor root) throws IOException {
            boolean _xblockexpression = false;
            {
              List<String> _dirtyFiles = buildRequest.getDirtyFiles();
              String _path = file.getPath();
              _dirtyFiles.add(_path);
              _xblockexpression = true;
            }
            return _xblockexpression;
          }
        };
        dirtyFilesHolder.processDirtyFiles(_function);
        List<String> _deletedFiles = buildRequest.getDeletedFiles();
        ModuleBuildTarget _representativeTarget = chunk.representativeTarget();
        Collection<String> _removedFiles = dirtyFilesHolder.getRemovedFiles(_representativeTarget);
        Iterables.<String>addAll(_deletedFiles, _removedFiles);
        List<String> _classpath = buildRequest.getClasspath();
        Collection<File> _compilationClasspath = ProjectPaths.getCompilationClasspath(chunk, true);
        List<File> _list = IterableExtensions.<File>toList(_compilationClasspath);
        final Function1<File, String> _function_1 = new Function1<File, String>() {
          @Override
          public String apply(final File it) {
            return it.getPath();
          }
        };
        List<String> _map = ListExtensions.<File, String>map(_list, _function_1);
        Iterables.<String>addAll(_classpath, _map);
        List<String> _sourceRoots = buildRequest.getSourceRoots();
        Map<File, String> _sourceRootsWithDependents = ProjectPaths.getSourceRootsWithDependents(chunk);
        Set<File> _keySet = _sourceRootsWithDependents.keySet();
        List<File> _list_1 = IterableExtensions.<File>toList(_keySet);
        final Function1<File, String> _function_2 = new Function1<File, String>() {
          @Override
          public String apply(final File it) {
            return it.getPath();
          }
        };
        List<String> _map_1 = ListExtensions.<File, String>map(_list_1, _function_2);
        Iterables.<String>addAll(_sourceRoots, _map_1);
        ProjectDescriptor _projectDescriptor = context.getProjectDescriptor();
        CompilerEncodingConfiguration _encodingConfiguration = _projectDescriptor.getEncodingConfiguration();
        String _preferredModuleChunkEncoding = _encodingConfiguration.getPreferredModuleChunkEncoding(chunk);
        buildRequest.setEncoding(_preferredModuleChunkEncoding);
        ModuleBuildTarget _representativeTarget_1 = chunk.representativeTarget();
        JpsModule _module = _representativeTarget_1.getModule();
        JpsUrlList _contentRootsList = _module.getContentRootsList();
        List<String> _urls = _contentRootsList.getUrls();
        final Function1<String, URI> _function_3 = new Function1<String, URI>() {
          @Override
          public URI apply(final String it) {
            return URI.createURI(it);
          }
        };
        List<URI> _map_2 = ListExtensions.<String, URI>map(_urls, _function_3);
        final Function1<URI, Boolean> _function_4 = new Function1<URI, Boolean>() {
          @Override
          public Boolean apply(final URI it) {
            return Boolean.valueOf(it.isFile());
          }
        };
        URI _findFirst = IterableExtensions.<URI>findFirst(_map_2, _function_4);
        String _path = _findFirst.path();
        buildRequest.setBaseDir(_path);
        _xblockexpression = buildRequest;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void handleBuildResult(final Protocol.BuildResultMessage result, final CompileContext context, final ModuleChunk chunk, final ModuleLevelBuilder.OutputConsumer outputConsumer) {
    ModuleBuildTarget _representativeTarget = chunk.representativeTarget();
    final JpsModule module = _representativeTarget.getModule();
    List<String> _outputDirs = result.getOutputDirs();
    final Procedure1<String> _function = new Procedure1<String>() {
      @Override
      public void apply(final String it) {
        XtextIdeaBuilder.this.createSourceRoot(it, module);
      }
    };
    IterableExtensions.<String>forEach(_outputDirs, _function);
    List<String> _dirtyFiles = result.getDirtyFiles();
    final Procedure1<String> _function_1 = new Procedure1<String>() {
      @Override
      public void apply(final String it) {
        try {
          File _file = new File(it);
          FSOperations.markDirty(context, CompilationRound.CURRENT, _file);
          String _presentableName = XtextIdeaBuilder.this.getPresentableName();
          CustomBuilderMessage _customBuilderMessage = new CustomBuilderMessage(_presentableName, "generated", it);
          context.processMessage(_customBuilderMessage);
          String _presentableName_1 = XtextIdeaBuilder.this.getPresentableName();
          CustomBuilderMessage _customBuilderMessage_1 = new CustomBuilderMessage(_presentableName_1, "refresh", it);
          context.processMessage(_customBuilderMessage_1);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    IterableExtensions.<String>forEach(_dirtyFiles, _function_1);
    List<String> _deletedFiles = result.getDeletedFiles();
    final Procedure1<String> _function_2 = new Procedure1<String>() {
      @Override
      public void apply(final String it) {
        try {
          File _file = new File(it);
          FSOperations.markDeleted(context, _file);
          String _presentableName = XtextIdeaBuilder.this.getPresentableName();
          CustomBuilderMessage _customBuilderMessage = new CustomBuilderMessage(_presentableName, "generated", it);
          context.processMessage(_customBuilderMessage);
          String _presentableName_1 = XtextIdeaBuilder.this.getPresentableName();
          CustomBuilderMessage _customBuilderMessage_1 = new CustomBuilderMessage(_presentableName_1, "refresh", it);
          context.processMessage(_customBuilderMessage_1);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    IterableExtensions.<String>forEach(_deletedFiles, _function_2);
  }
  
  private void reportIssue(final Protocol.BuildIssueMessage it, final CompileContext context) {
    String _presentableName = this.getPresentableName();
    BuildMessage.Kind _kind = it.getKind();
    String _message = it.getMessage();
    String _path = it.getPath();
    int _startOffset = it.getStartOffset();
    int _endOffset = it.getEndOffset();
    int _locationOffset = it.getLocationOffset();
    int _line = it.getLine();
    int _column = it.getColumn();
    CompilerMessage _compilerMessage = new CompilerMessage(_presentableName, _kind, _message, _path, _startOffset, _endOffset, _locationOffset, _line, _column);
    context.processMessage(_compilerMessage);
  }
  
  protected JpsModuleSourceRoot createSourceRoot(final String outputDir, final JpsModule module) {
    JpsModuleSourceRoot _xblockexpression = null;
    {
      URI _createFileURI = URI.createFileURI(outputDir);
      final String outletUrl = _createFileURI.toString();
      JpsModuleSourceRoot _xifexpression = null;
      Iterable<JpsTypedModuleSourceRoot<JavaSourceRootProperties>> _sourceRoots = module.<JavaSourceRootProperties>getSourceRoots(JavaSourceRootType.SOURCE);
      final Function1<JpsTypedModuleSourceRoot<JavaSourceRootProperties>, Boolean> _function = new Function1<JpsTypedModuleSourceRoot<JavaSourceRootProperties>, Boolean>() {
        @Override
        public Boolean apply(final JpsTypedModuleSourceRoot<JavaSourceRootProperties> it) {
          String _url = it.getUrl();
          return Boolean.valueOf(Objects.equal(_url, outletUrl));
        }
      };
      boolean _exists = IterableExtensions.<JpsTypedModuleSourceRoot<JavaSourceRootProperties>>exists(_sourceRoots, _function);
      boolean _not = (!_exists);
      if (_not) {
        _xifexpression = module.<JavaSourceRootProperties>addSourceRoot(outletUrl, JavaSourceRootType.SOURCE);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  @Override
  public List<String> getCompilableFileExtensions() {
    JpsServiceManager _instance = JpsServiceManager.getInstance();
    Iterable<ISetup> _extensions = _instance.<ISetup>getExtensions(ISetup.class);
    Iterable<ISetupExtension> _filter = Iterables.<ISetupExtension>filter(_extensions, ISetupExtension.class);
    final Function1<ISetupExtension, List<String>> _function = new Function1<ISetupExtension, List<String>>() {
      @Override
      public List<String> apply(final ISetupExtension it) {
        return it.getFileExtensions();
      }
    };
    Iterable<List<String>> _map = IterableExtensions.<ISetupExtension, List<String>>map(_filter, _function);
    Iterable<String> _flatten = Iterables.<String>concat(_map);
    return IterableExtensions.<String>toList(_flatten);
  }
  
  @Override
  public String getPresentableName() {
    return "Xtext";
  }
}
