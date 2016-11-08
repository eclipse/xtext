/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.testlanguage.ide;

import com.google.inject.ImplementedBy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import org.eclipse.emf.common.util.URI;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.jsonrpc.Endpoint;
import org.eclipse.lsp4j.jsonrpc.json.JsonRpcMethod;
import org.eclipse.lsp4j.jsonrpc.json.JsonRpcMethodProvider;
import org.eclipse.lsp4j.jsonrpc.services.JsonNotification;
import org.eclipse.lsp4j.jsonrpc.services.JsonRequest;
import org.eclipse.lsp4j.jsonrpc.services.ServiceEndpoints;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.xtend.lib.annotations.ToString;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.ide.server.ILanguageServerExtension;
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
  public static class TextOfLineResult {
    public String text;
  }
  
  public static class TextOfLineParam {
    public String uri;
    
    public int line;
  }
  
  @ToString
  public static class BuildNotification {
    public String message;
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("message", this.message);
      return b.toString();
    }
  }
  
  public interface CustomClient {
    @JsonNotification
    public abstract void buildHappened(final TestLangLSPExtension.BuildNotification notification);
  }
  
  public static class Impl implements ILanguageServerExtension, TestLangLSPExtension, ILanguageServerAccess.IBuildListener, JsonRpcMethodProvider {
    private ILanguageServerAccess access;
    
    private TestLangLSPExtension.CustomClient client;
    
    @Override
    public CompletableFuture<TestLangLSPExtension.TextOfLineResult> getTextOfLine(final TestLangLSPExtension.TextOfLineParam param) {
      final Function<ILanguageServerAccess.Context, TestLangLSPExtension.TextOfLineResult> _function = (ILanguageServerAccess.Context ctx) -> {
        Document _document = ctx.getDocument();
        Position _position = new Position(param.line, 0);
        final int start = _document.getOffSet(_position);
        Document _document_1 = ctx.getDocument();
        Position _position_1 = new Position((param.line + 1), 0);
        int _offSet = _document_1.getOffSet(_position_1);
        final int end = (_offSet - 1);
        TestLangLSPExtension.TextOfLineResult _textOfLineResult = new TestLangLSPExtension.TextOfLineResult();
        final Procedure1<TestLangLSPExtension.TextOfLineResult> _function_1 = (TestLangLSPExtension.TextOfLineResult it) -> {
          Document _document_2 = ctx.getDocument();
          String _contents = _document_2.getContents();
          String _substring = _contents.substring(start, end);
          it.text = _substring;
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
      TestLangLSPExtension.CustomClient _serviceObject = ServiceEndpoints.<TestLangLSPExtension.CustomClient>toServiceObject(((Endpoint) _languageClient), TestLangLSPExtension.CustomClient.class);
      this.client = _serviceObject;
    }
    
    @Override
    public void afterBuild(final List<IResourceDescription.Delta> deltas) {
      TestLangLSPExtension.BuildNotification _buildNotification = new TestLangLSPExtension.BuildNotification();
      final Procedure1<TestLangLSPExtension.BuildNotification> _function = (TestLangLSPExtension.BuildNotification it) -> {
        final Function1<IResourceDescription.Delta, String> _function_1 = (IResourceDescription.Delta it_1) -> {
          URI _uri = it_1.getUri();
          return _uri.toString();
        };
        List<String> _map = ListExtensions.<IResourceDescription.Delta, String>map(deltas, _function_1);
        String _join = IterableExtensions.join(_map, ", ");
        String _plus = ("Built " + _join);
        it.message = _plus;
      };
      TestLangLSPExtension.BuildNotification _doubleArrow = ObjectExtensions.<TestLangLSPExtension.BuildNotification>operator_doubleArrow(_buildNotification, _function);
      this.client.buildHappened(_doubleArrow);
    }
    
    @Override
    public Map<String, JsonRpcMethod> supportedMethods() {
      final HashMap<String, JsonRpcMethod> result = CollectionLiterals.<String, JsonRpcMethod>newHashMap();
      Class<? extends TestLangLSPExtension.Impl> _class = this.getClass();
      Map<String, JsonRpcMethod> _supportedMethods = ServiceEndpoints.getSupportedMethods(_class);
      result.putAll(_supportedMethods);
      Map<String, JsonRpcMethod> _supportedMethods_1 = ServiceEndpoints.getSupportedMethods(TestLangLSPExtension.CustomClient.class);
      result.putAll(_supportedMethods_1);
      return result;
    }
  }
  
  @JsonRequest
  public abstract CompletableFuture<TestLangLSPExtension.TextOfLineResult> getTextOfLine(final TestLangLSPExtension.TextOfLineParam param);
}
