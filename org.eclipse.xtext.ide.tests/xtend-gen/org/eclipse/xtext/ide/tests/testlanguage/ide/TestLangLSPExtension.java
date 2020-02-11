/**
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.ide;

import com.google.common.collect.Iterables;
import com.google.inject.ImplementedBy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.jsonrpc.Endpoint;
import org.eclipse.lsp4j.jsonrpc.json.JsonRpcMethod;
import org.eclipse.lsp4j.jsonrpc.json.JsonRpcMethodProvider;
import org.eclipse.lsp4j.jsonrpc.services.JsonNotification;
import org.eclipse.lsp4j.jsonrpc.services.JsonRequest;
import org.eclipse.lsp4j.jsonrpc.services.ServiceEndpoints;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.xtend.lib.annotations.ToString;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.ide.server.ILanguageServerExtension;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TestLanguagePackage;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @author efftinge - Initial contribution and API
 */
@ImplementedBy(TestLangLSPExtension.Impl.class)
@SuppressWarnings("all")
public interface TestLangLSPExtension extends ILanguageServerExtension {
  class TextOfLineResult {
    public String text;
  }
  
  class TextOfLineParam {
    public String uri;
    
    public int line;
  }
  
  @ToString
  class BuildNotification {
    public String message;
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("message", this.message);
      return b.toString();
    }
  }
  
  interface CustomClient {
    @JsonNotification
    void buildHappened(final TestLangLSPExtension.BuildNotification notification);
  }
  
  class Impl implements ILanguageServerExtension, TestLangLSPExtension, ILanguageServerAccess.IBuildListener, JsonRpcMethodProvider {
    private ILanguageServerAccess access;
    
    private TestLangLSPExtension.CustomClient client;
    
    @Override
    public CompletableFuture<TestLangLSPExtension.TextOfLineResult> getTextOfLine(final TestLangLSPExtension.TextOfLineParam param) {
      final Function<ILanguageServerAccess.Context, TestLangLSPExtension.TextOfLineResult> _function = (ILanguageServerAccess.Context ctx) -> {
        Position _position = new Position(param.line, 0);
        final int start = ctx.getDocument().getOffSet(_position);
        Position _position_1 = new Position((param.line + 1), 0);
        int _offSet = ctx.getDocument().getOffSet(_position_1);
        int _length = System.lineSeparator().length();
        final int end = (_offSet - _length);
        TestLangLSPExtension.TextOfLineResult _textOfLineResult = new TestLangLSPExtension.TextOfLineResult();
        final Procedure1<TestLangLSPExtension.TextOfLineResult> _function_1 = (TestLangLSPExtension.TextOfLineResult it) -> {
          it.text = ctx.getDocument().getContents().substring(start, end);
        };
        return ObjectExtensions.<TestLangLSPExtension.TextOfLineResult>operator_doubleArrow(_textOfLineResult, _function_1);
      };
      return this.access.<TestLangLSPExtension.TextOfLineResult>doRead(param.uri, _function);
    }
    
    @Override
    public void initialize(final ILanguageServerAccess access) {
      this.access = access;
      this.access.addBuildListener(this);
      LanguageClient _languageClient = access.getLanguageClient();
      this.client = ServiceEndpoints.<TestLangLSPExtension.CustomClient>toServiceObject(((Endpoint) _languageClient), TestLangLSPExtension.CustomClient.class);
    }
    
    @Override
    public void afterBuild(final List<IResourceDescription.Delta> deltas) {
      TestLangLSPExtension.BuildNotification _buildNotification = new TestLangLSPExtension.BuildNotification();
      final Procedure1<TestLangLSPExtension.BuildNotification> _function = (TestLangLSPExtension.BuildNotification it) -> {
        final Function1<IResourceDescription.Delta, String> _function_1 = (IResourceDescription.Delta it_1) -> {
          return it_1.getUri().toString();
        };
        String _join = IterableExtensions.join(ListExtensions.<IResourceDescription.Delta, String>map(deltas, _function_1), ", ");
        String _plus = ("Built " + _join);
        it.message = _plus;
      };
      TestLangLSPExtension.BuildNotification _doubleArrow = ObjectExtensions.<TestLangLSPExtension.BuildNotification>operator_doubleArrow(_buildNotification, _function);
      this.client.buildHappened(_doubleArrow);
    }
    
    @Override
    public Map<String, JsonRpcMethod> supportedMethods() {
      final HashMap<String, JsonRpcMethod> result = CollectionLiterals.<String, JsonRpcMethod>newHashMap();
      result.putAll(ServiceEndpoints.getSupportedMethods(this.getClass()));
      result.putAll(ServiceEndpoints.getSupportedMethods(TestLangLSPExtension.CustomClient.class));
      return result;
    }
    
    @Override
    public CompletableFuture<Set<String>> getAllOpNames() {
      final Function<ILanguageServerAccess.IndexContext, Set<String>> _function = (ILanguageServerAccess.IndexContext context) -> {
        final Function1<IResourceDescription, Iterable<IEObjectDescription>> _function_1 = (IResourceDescription it) -> {
          return it.getExportedObjects();
        };
        final Function1<IEObjectDescription, Boolean> _function_2 = (IEObjectDescription it) -> {
          EClass _eClass = it.getEClass();
          return Boolean.valueOf((_eClass == TestLanguagePackage.Literals.OPERATION));
        };
        final Function1<IEObjectDescription, String> _function_3 = (IEObjectDescription it) -> {
          return it.getName().getLastSegment();
        };
        return IterableExtensions.<String>toSet(IterableExtensions.<IEObjectDescription, String>map(IterableExtensions.<IEObjectDescription>filter(Iterables.<IEObjectDescription>concat(IterableExtensions.<IResourceDescription, Iterable<IEObjectDescription>>map(context.getIndex().getAllResourceDescriptions(), _function_1)), _function_2), _function_3));
      };
      return this.access.<Set<String>>doReadIndex(_function);
    }
  }
  
  @JsonRequest
  CompletableFuture<TestLangLSPExtension.TextOfLineResult> getTextOfLine(final TestLangLSPExtension.TextOfLineParam param);
  
  @JsonRequest
  CompletableFuture<Set<String>> getAllOpNames();
}
