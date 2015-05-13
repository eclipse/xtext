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
import org.eclipse.xtext.builder.standalone.incremental.FilesAndURIs;
import org.eclipse.xtext.idea.build.client.DaemonConnector;
import org.eclipse.xtext.idea.build.client.IdeaClassFileDependencyFinder;
import org.eclipse.xtext.idea.build.net.ObjectChannel;
import org.eclipse.xtext.idea.build.net.Protocol;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
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
import org.jetbrains.jps.model.module.JpsModule;
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
          if (!_matched) {
            if (message instanceof Protocol.BuildFailureMessage) {
              _matched=true;
              String _message = ((Protocol.BuildFailureMessage)message).getMessage();
              this.reportError(_message, context);
              result = ModuleLevelBuilder.ExitCode.ABORT;
            }
          }
          if (!_matched) {
            if (message instanceof Protocol.JavaDependencyRequest) {
              _matched=true;
              Protocol.JavaDependencyResult _handleJavaDependencyRequest = this.handleJavaDependencyRequest(((Protocol.JavaDependencyRequest)message), context);
              channel.writeObject(_handleJavaDependencyRequest);
            }
          }
        }
      }
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception exc = (Exception)_t;
        XtextIdeaBuilder.LOG.error("Error in build", exc);
        String _message = exc.getMessage();
        this.reportError(_message, context);
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
    Protocol.BuildRequestMessage _xblockexpression = null;
    {
      Protocol.BuildRequestMessage _buildRequestMessage = new Protocol.BuildRequestMessage();
      final Procedure1<Protocol.BuildRequestMessage> _function = new Procedure1<Protocol.BuildRequestMessage>() {
        @Override
        public void apply(final Protocol.BuildRequestMessage it) {
          try {
            final FileProcessor<JavaSourceRootDescriptor, ModuleBuildTarget> _function = new FileProcessor<JavaSourceRootDescriptor, ModuleBuildTarget>() {
              @Override
              public boolean apply(final ModuleBuildTarget target, final File file, final JavaSourceRootDescriptor root) throws IOException {
                boolean _xblockexpression = false;
                {
                  List<String> _dirtyFiles = it.getDirtyFiles();
                  URI _asURI = FilesAndURIs.asURI(file);
                  String _string = _asURI.toString();
                  _dirtyFiles.add(_string);
                  _xblockexpression = true;
                }
                return _xblockexpression;
              }
            };
            dirtyFilesHolder.processDirtyFiles(_function);
            List<String> _deletedFiles = it.getDeletedFiles();
            ModuleBuildTarget _representativeTarget = chunk.representativeTarget();
            Collection<String> _removedFiles = dirtyFilesHolder.getRemovedFiles(_representativeTarget);
            final Function1<String, String> _function_1 = new Function1<String, String>() {
              @Override
              public String apply(final String it) {
                URI _asFileURI = FilesAndURIs.asFileURI(it);
                return _asFileURI.toString();
              }
            };
            Iterable<String> _map = IterableExtensions.<String, String>map(_removedFiles, _function_1);
            Iterables.<String>addAll(_deletedFiles, _map);
            List<String> _classpath = it.getClasspath();
            Collection<File> _compilationClasspath = ProjectPaths.getCompilationClasspath(chunk, true);
            List<File> _list = IterableExtensions.<File>toList(_compilationClasspath);
            final Function1<File, String> _function_2 = new Function1<File, String>() {
              @Override
              public String apply(final File it) {
                URI _asURI = FilesAndURIs.asURI(it);
                return _asURI.toString();
              }
            };
            List<String> _map_1 = ListExtensions.<File, String>map(_list, _function_2);
            Iterables.<String>addAll(_classpath, _map_1);
            List<String> _outputs = it.getOutputs();
            Collection<File> _outputPathsWithDependents = ProjectPaths.getOutputPathsWithDependents(chunk);
            final Function1<File, String> _function_3 = new Function1<File, String>() {
              @Override
              public String apply(final File it) {
                URI _asURI = FilesAndURIs.asURI(it);
                return _asURI.toString();
              }
            };
            Iterable<String> _map_2 = IterableExtensions.<File, String>map(_outputPathsWithDependents, _function_3);
            Iterables.<String>addAll(_outputs, _map_2);
            List<String> _sourceRoots = it.getSourceRoots();
            Map<File, String> _sourceRootsWithDependents = ProjectPaths.getSourceRootsWithDependents(chunk);
            Set<File> _keySet = _sourceRootsWithDependents.keySet();
            List<File> _list_1 = IterableExtensions.<File>toList(_keySet);
            final Function1<File, String> _function_4 = new Function1<File, String>() {
              @Override
              public String apply(final File it) {
                URI _asURI = FilesAndURIs.asURI(it);
                return _asURI.toString();
              }
            };
            List<String> _map_3 = ListExtensions.<File, String>map(_list_1, _function_4);
            Iterables.<String>addAll(_sourceRoots, _map_3);
            ProjectDescriptor _projectDescriptor = context.getProjectDescriptor();
            CompilerEncodingConfiguration _encodingConfiguration = _projectDescriptor.getEncodingConfiguration();
            String _preferredModuleChunkEncoding = _encodingConfiguration.getPreferredModuleChunkEncoding(chunk);
            it.setEncoding(_preferredModuleChunkEncoding);
            ModuleBuildTarget _representativeTarget_1 = chunk.representativeTarget();
            JpsModule _module = _representativeTarget_1.getModule();
            JpsUrlList _contentRootsList = _module.getContentRootsList();
            List<String> _urls = _contentRootsList.getUrls();
            final Function1<String, URI> _function_5 = new Function1<String, URI>() {
              @Override
              public URI apply(final String it) {
                return FilesAndURIs.asURI(it);
              }
            };
            List<URI> _map_4 = ListExtensions.<String, URI>map(_urls, _function_5);
            final Function1<URI, Boolean> _function_6 = new Function1<URI, Boolean>() {
              @Override
              public Boolean apply(final URI it) {
                return Boolean.valueOf(it.isFile());
              }
            };
            URI _findFirst = IterableExtensions.<URI>findFirst(_map_4, _function_6);
            String _string = _findFirst.toString();
            it.setBaseDir(_string);
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      final Protocol.BuildRequestMessage buildRequest = ObjectExtensions.<Protocol.BuildRequestMessage>operator_doubleArrow(_buildRequestMessage, _function);
      _xblockexpression = buildRequest;
    }
    return _xblockexpression;
  }
  
  private Protocol.JavaDependencyResult handleJavaDependencyRequest(final Protocol.JavaDependencyRequest request, final CompileContext context) {
    Protocol.JavaDependencyResult _xblockexpression = null;
    {
      final IdeaClassFileDependencyFinder dependencyFinder = new IdeaClassFileDependencyFinder(context);
      List<String> _dirtyJavaFiles = request.getDirtyJavaFiles();
      final Function1<String, URI> _function = new Function1<String, URI>() {
        @Override
        public URI apply(final String it) {
          return FilesAndURIs.asURI(it);
        }
      };
      List<URI> _map = ListExtensions.<String, URI>map(_dirtyJavaFiles, _function);
      List<String> _deletedJavaFiles = request.getDeletedJavaFiles();
      final Function1<String, URI> _function_1 = new Function1<String, URI>() {
        @Override
        public URI apply(final String it) {
          return FilesAndURIs.asURI(it);
        }
      };
      List<URI> _map_1 = ListExtensions.<String, URI>map(_deletedJavaFiles, _function_1);
      final Iterable<? extends URI> dependentJavaFiles = dependencyFinder.getDependentJavaFiles(_map, _map_1);
      Protocol.JavaDependencyResult _javaDependencyResult = new Protocol.JavaDependencyResult();
      final Procedure1<Protocol.JavaDependencyResult> _function_2 = new Procedure1<Protocol.JavaDependencyResult>() {
        @Override
        public void apply(final Protocol.JavaDependencyResult it) {
          List<String> _dependentJavaFiles = it.getDependentJavaFiles();
          final Function1<URI, String> _function = new Function1<URI, String>() {
            @Override
            public String apply(final URI it) {
              return it.toString();
            }
          };
          Iterable<String> _map = IterableExtensions.map(dependentJavaFiles, _function);
          Iterables.<String>addAll(_dependentJavaFiles, _map);
        }
      };
      _xblockexpression = ObjectExtensions.<Protocol.JavaDependencyResult>operator_doubleArrow(_javaDependencyResult, _function_2);
    }
    return _xblockexpression;
  }
  
  private void handleBuildResult(final Protocol.BuildResultMessage result, final CompileContext context, final ModuleChunk chunk, final ModuleLevelBuilder.OutputConsumer outputConsumer) {
    final ModuleBuildTarget target = chunk.representativeTarget();
    List<Protocol.GeneratedFile> _generatedFiles = result.getGeneratedFiles();
    final Procedure1<Protocol.GeneratedFile> _function = new Procedure1<Protocol.GeneratedFile>() {
      @Override
      public void apply(final Protocol.GeneratedFile it) {
        try {
          String _file = it.getFile();
          URI _asURI = FilesAndURIs.asURI(_file);
          final File outputFile = FilesAndURIs.asFile(_asURI);
          FSOperations.markDirty(context, CompilationRound.CURRENT, outputFile);
          long _compilationStartStamp = context.getCompilationStartStamp();
          outputFile.setLastModified(_compilationStartStamp);
          String _presentableName = XtextIdeaBuilder.this.getPresentableName();
          String _file_1 = it.getFile();
          CustomBuilderMessage _customBuilderMessage = new CustomBuilderMessage(_presentableName, "generated", _file_1);
          context.processMessage(_customBuilderMessage);
          List<String> _sourceFiles = it.getSourceFiles();
          final Function1<String, String> _function = new Function1<String, String>() {
            @Override
            public String apply(final String it) {
              URI _asURI = FilesAndURIs.asURI(it);
              return FilesAndURIs.asPath(_asURI);
            }
          };
          List<String> _map = ListExtensions.<String, String>map(_sourceFiles, _function);
          outputConsumer.registerOutputFile(target, outputFile, _map);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    IterableExtensions.<Protocol.GeneratedFile>forEach(_generatedFiles, _function);
    List<String> _deletedFiles = result.getDeletedFiles();
    final Procedure1<String> _function_1 = new Procedure1<String>() {
      @Override
      public void apply(final String it) {
        try {
          File _file = new File(it);
          FSOperations.markDeleted(context, _file);
          String _presentableName = XtextIdeaBuilder.this.getPresentableName();
          CustomBuilderMessage _customBuilderMessage = new CustomBuilderMessage(_presentableName, "generated", it);
          context.processMessage(_customBuilderMessage);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    IterableExtensions.<String>forEach(_deletedFiles, _function_1);
    String _presentableName = this.getPresentableName();
    CustomBuilderMessage _customBuilderMessage = new CustomBuilderMessage(_presentableName, "refresh", null);
    context.processMessage(_customBuilderMessage);
  }
  
  private void reportIssue(final Protocol.BuildIssueMessage it, final CompileContext context) {
    String _presentableName = this.getPresentableName();
    BuildMessage.Kind _kind = it.getKind();
    String _message = it.getMessage();
    String _uriToProblem = it.getUriToProblem();
    URI _asURI = FilesAndURIs.asURI(_uriToProblem);
    String _asPath = FilesAndURIs.asPath(_asURI);
    int _startOffset = it.getStartOffset();
    int _endOffset = it.getEndOffset();
    int _locationOffset = it.getLocationOffset();
    int _line = it.getLine();
    int _column = it.getColumn();
    CompilerMessage _compilerMessage = new CompilerMessage(_presentableName, _kind, _message, _asPath, _startOffset, _endOffset, _locationOffset, _line, _column);
    context.processMessage(_compilerMessage);
  }
  
  protected void reportError(final String message, final CompileContext context) {
    context.processMessage(new BuildMessage(message, BuildMessage.Kind.ERROR) {
    });
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
