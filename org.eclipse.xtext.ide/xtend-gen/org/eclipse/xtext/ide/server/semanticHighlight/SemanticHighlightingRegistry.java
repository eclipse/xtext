/**
 * Copyright (c) 2018 TypeFox and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.server.semanticHighlight;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.lsp4j.ClientCapabilities;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.SemanticHighlightingCapabilities;
import org.eclipse.lsp4j.SemanticHighlightingInformation;
import org.eclipse.lsp4j.SemanticHighlightingParams;
import org.eclipse.lsp4j.TextDocumentClientCapabilities;
import org.eclipse.lsp4j.VersionedTextDocumentIdentifier;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.lsp4j.util.SemanticHighlightingTokens;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.ide.editor.syntaxcoloring.LightweightPosition;
import org.eclipse.xtext.ide.editor.syntaxcoloring.MergingHighlightedPositionAcceptor;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.ide.server.UriExtensions;
import org.eclipse.xtext.ide.server.semanticHighlight.ISemanticHighlightingStyleToTokenMapper;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Shared semantic highlighting manager per language server.
 * Responsible for converting the semantic highlighted ranges into the LSP standard by producing a compact,
 * {@code base64} encoded token string.
 */
@Log
@SuppressWarnings("all")
public class SemanticHighlightingRegistry {
  /**
   * A highlighted range with additional <a href="https://manual.macromates.com/en/language_grammars">TextMate scopes</a> information.
   */
  @Data
  public static class HighlightedRange extends Range {
    /**
     * The internal index of the corresponding TextMate scope.
     */
    private final int scope;
    
    public HighlightedRange(final Position start, final Position end, final int scope) {
      super(start, end);
      this.scope = scope;
    }
    
    @Override
    @Pure
    public int hashCode() {
      return 31 * super.hashCode() + this.scope;
    }
    
    @Override
    @Pure
    public boolean equals(final Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      if (!super.equals(obj))
        return false;
      SemanticHighlightingRegistry.HighlightedRange other = (SemanticHighlightingRegistry.HighlightedRange) obj;
      if (other.scope != this.scope)
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      return new ToStringBuilder(this)
      	.addAllFields()
      	.toString();
    }
    
    @Pure
    public int getScope() {
      return this.scope;
    }
  }
  
  /**
   * Reserved TextMate scope identifier for styles that cannot be handled.
   */
  public static final String UNKNOWN_SCOPE = "unknown.xtext";
  
  /**
   * TextMate scopes indicating an unhandled style ID to TextMate scope mapping.
   */
  public static final List<String> UNKNOWN_SCOPES = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(SemanticHighlightingRegistry.UNKNOWN_SCOPE));
  
  @Inject
  @Extension
  private UriExtensions _uriExtensions;
  
  /**
   * Lookup table for all known TextMate scopes.
   */
  protected BiMap<Integer, List<String>> scopes;
  
  protected LanguageClient client;
  
  public void initialize(final Iterable<? extends IResourceServiceProvider> allLanguages, final ClientCapabilities capabilities, final LanguageClient client) {
    Preconditions.checkState((this.client == null), "Already initialized.");
    Boolean _elvis = null;
    TextDocumentClientCapabilities _textDocument = null;
    if (capabilities!=null) {
      _textDocument=capabilities.getTextDocument();
    }
    SemanticHighlightingCapabilities _semanticHighlightingCapabilities = null;
    if (_textDocument!=null) {
      _semanticHighlightingCapabilities=_textDocument.getSemanticHighlightingCapabilities();
    }
    Boolean _semanticHighlighting = null;
    if (_semanticHighlightingCapabilities!=null) {
      _semanticHighlighting=_semanticHighlightingCapabilities.getSemanticHighlighting();
    }
    if (_semanticHighlighting != null) {
      _elvis = _semanticHighlighting;
    } else {
      _elvis = Boolean.valueOf(false);
    }
    final Boolean enabled = _elvis;
    final ImmutableBiMap.Builder<Integer, List<String>> builder = ImmutableBiMap.<Integer, List<String>>builder();
    if ((enabled).booleanValue()) {
      final Function1<IResourceServiceProvider, ISemanticHighlightingStyleToTokenMapper> _function = (IResourceServiceProvider it) -> {
        return it.<ISemanticHighlightingStyleToTokenMapper>get(ISemanticHighlightingStyleToTokenMapper.class);
      };
      final Function1<ISemanticHighlightingStyleToTokenMapper, Iterable<List<String>>> _function_1 = (ISemanticHighlightingStyleToTokenMapper mapper) -> {
        final Function1<String, List<String>> _function_2 = (String styleId) -> {
          return mapper.toScopes(styleId);
        };
        return IterableExtensions.<String, List<String>>map(mapper.getAllStyleIds(), _function_2);
      };
      final Function1<List<String>, Boolean> _function_2 = (List<String> it) -> {
        boolean _isNullOrEmpty = IterableExtensions.isNullOrEmpty(it);
        return Boolean.valueOf((!_isNullOrEmpty));
      };
      final Procedure2<List<String>, Integer> _function_3 = (List<String> scope, Integer index) -> {
        builder.put(index, scope);
      };
      IterableExtensions.<List<String>>forEach(IterableExtensions.<List<String>>toSet(IterableExtensions.<List<String>>filter(Iterables.<List<String>>concat(IterableExtensions.<ISemanticHighlightingStyleToTokenMapper, Iterable<List<String>>>map(IterableExtensions.<ISemanticHighlightingStyleToTokenMapper>filterNull(IterableExtensions.map(allLanguages, _function)), _function_1)), _function_2)), _function_3);
    }
    this.scopes = builder.build();
    this.client = client;
  }
  
  /**
   * Returns with a list of TextMate scopes for the internal scope index. Returns the
   * {@link SemanticHighlightingRegistry#UNKNOWN_SCOPES unknown scopes} if no scopes are registered for the argument.
   */
  public List<String> getScopes(final int scopeIndex) {
    this.checkInitialized();
    return this.scopes.getOrDefault(Integer.valueOf(scopeIndex), SemanticHighlightingRegistry.UNKNOWN_SCOPES);
  }
  
  /**
   * Returns with the internal scope index for the argument. Returns {@code -1} if the scopes
   * argument is <code>null</code>, the {@link SemanticHighlightingRegistry#UNKNOWN_SCOPES unknown scopes}
   * or is not registered to this manager.
   */
  public int getIndex(final List<String> scopes) {
    this.checkInitialized();
    boolean _isNullOrUnknown = this.isNullOrUnknown(scopes);
    if (_isNullOrUnknown) {
      return (-1);
    }
    final Integer index = this.scopes.inverse().get(scopes);
    Integer _xifexpression = null;
    if ((index == null)) {
      _xifexpression = Integer.valueOf((-1));
    } else {
      _xifexpression = index;
    }
    return (_xifexpression).intValue();
  }
  
  /**
   * Returns with a view of all scopes known by this manager.
   */
  public List<List<String>> getAllScopes() {
    this.checkInitialized();
    final ImmutableList.Builder<List<String>> builder = ImmutableList.<List<String>>builder();
    final Consumer<Integer> _function = (Integer it) -> {
      List<String> _get = this.scopes.get(it);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("No scopes are available for index: ");
      _builder.append(it);
      builder.add(Preconditions.<List<String>>checkNotNull(_get, _builder));
    };
    this.scopes.keySet().forEach(_function);
    return builder.build();
  }
  
  public void update(final ILanguageServerAccess.Context context) {
    this.checkInitialized();
    Resource _resource = context.getResource();
    boolean _not = (!(_resource instanceof XtextResource));
    if (_not) {
      return;
    }
    boolean _isDocumentOpen = context.isDocumentOpen();
    boolean _not_1 = (!_isDocumentOpen);
    if (_not_1) {
      return;
    }
    Resource _resource_1 = context.getResource();
    final XtextResource resource = ((XtextResource) _resource_1);
    IResourceServiceProvider _resourceServiceProvider = resource.getResourceServiceProvider();
    ISemanticHighlightingCalculator _get = null;
    if (_resourceServiceProvider!=null) {
      _get=_resourceServiceProvider.<ISemanticHighlightingCalculator>get(ISemanticHighlightingCalculator.class);
    }
    final ISemanticHighlightingCalculator calculator = _get;
    IResourceServiceProvider _resourceServiceProvider_1 = resource.getResourceServiceProvider();
    ISemanticHighlightingStyleToTokenMapper _get_1 = null;
    if (_resourceServiceProvider_1!=null) {
      _get_1=_resourceServiceProvider_1.<ISemanticHighlightingStyleToTokenMapper>get(ISemanticHighlightingStyleToTokenMapper.class);
    }
    final ISemanticHighlightingStyleToTokenMapper mapper = _get_1;
    if (((calculator == null) || this.isIgnoredMapper(mapper))) {
      return;
    }
    final Document document = context.getDocument();
    final MergingHighlightedPositionAcceptor acceptor = new MergingHighlightedPositionAcceptor(calculator);
    calculator.provideHighlightingFor(resource, acceptor, CancelIndicator.NullImpl);
    final Function1<LightweightPosition, List<SemanticHighlightingRegistry.HighlightedRange>> _function = (LightweightPosition position) -> {
      final Function1<String, SemanticHighlightingRegistry.HighlightedRange> _function_1 = (String id) -> {
        final Position start = document.getPosition(position.getOffset());
        int _offset = position.getOffset();
        int _length = position.getLength();
        int _plus = (_offset + _length);
        final Position end = document.getPosition(_plus);
        final int scope = this.getIndex(mapper.toScopes(id));
        return new SemanticHighlightingRegistry.HighlightedRange(start, end, scope);
      };
      return ListExtensions.<String, SemanticHighlightingRegistry.HighlightedRange>map(((List<String>)Conversions.doWrapArray(position.getIds())), _function_1);
    };
    final Iterable<SemanticHighlightingRegistry.HighlightedRange> ranges = Iterables.<SemanticHighlightingRegistry.HighlightedRange>concat(ListExtensions.<LightweightPosition, List<SemanticHighlightingRegistry.HighlightedRange>>map(acceptor.getPositions(), _function));
    final List<SemanticHighlightingInformation> lines = this.toSemanticHighlightingInformation(ranges, document);
    final VersionedTextDocumentIdentifier textDocument = this.toVersionedTextDocumentIdentifier(context);
    SemanticHighlightingParams _semanticHighlightingParams = new SemanticHighlightingParams(textDocument, lines);
    this.notifyClient(_semanticHighlightingParams);
  }
  
  /**
   * {@code true} if the argument is an ignored mapper. Otherwise, {@code false}.
   * If a mapper is ignored, no semantic highlighting information will be calculated. Clients won't be notified at all.
   * 
   * By default, the argument is ignored if {@code null}, or instance of the {@link ISemanticHighlightingStyleToTokenMapper.Noop NOOP mapper}.
   */
  protected boolean isIgnoredMapper(final ISemanticHighlightingStyleToTokenMapper mapper) {
    return ((mapper == null) || (mapper instanceof ISemanticHighlightingStyleToTokenMapper.Noop));
  }
  
  protected List<SemanticHighlightingInformation> toSemanticHighlightingInformation(final Iterable<? extends SemanticHighlightingRegistry.HighlightedRange> ranges, final Document document) {
    final ImmutableMultimap.Builder<Integer, SemanticHighlightingTokens.Token> builder = ImmutableMultimap.<Integer, SemanticHighlightingTokens.Token>builder();
    final Function1<SemanticHighlightingRegistry.HighlightedRange, Boolean> _function = (SemanticHighlightingRegistry.HighlightedRange it) -> {
      Position _start = it.getStart();
      Position _end = it.getEnd();
      return Boolean.valueOf((!Objects.equal(_start, _end)));
    };
    final Consumer<SemanticHighlightingRegistry.HighlightedRange> _function_1 = (SemanticHighlightingRegistry.HighlightedRange it) -> {
      final int startLine = it.getStart().getLine();
      final int endLine = it.getEnd().getLine();
      if ((startLine == endLine)) {
        int _character = it.getEnd().getCharacter();
        int _character_1 = it.getStart().getCharacter();
        final int length = (_character - _character_1);
        int _character_2 = it.getStart().getCharacter();
        SemanticHighlightingTokens.Token _token = new SemanticHighlightingTokens.Token(_character_2, length, it.scope);
        builder.put(Integer.valueOf(startLine), _token);
      } else {
        final String startLineContent = document.getLineContent(startLine);
        int _length = startLineContent.length();
        int _character_3 = it.getStart().getCharacter();
        final int startLength = (_length - _character_3);
        int _character_4 = it.getStart().getCharacter();
        SemanticHighlightingTokens.Token _token_1 = new SemanticHighlightingTokens.Token(_character_4, startLength, it.scope);
        builder.put(Integer.valueOf(startLine), _token_1);
        for (int line = (startLine + 1); (line < endLine); line++) {
          {
            final String lineContent = document.getLineContent(line);
            int _length_1 = lineContent.length();
            SemanticHighlightingTokens.Token _token_2 = new SemanticHighlightingTokens.Token(0, _length_1, it.scope);
            builder.put(Integer.valueOf(line), _token_2);
          }
        }
        int _character_5 = it.getEnd().getCharacter();
        SemanticHighlightingTokens.Token _token_2 = new SemanticHighlightingTokens.Token(0, _character_5, it.scope);
        builder.put(Integer.valueOf(endLine), _token_2);
      }
    };
    IterableExtensions.filter(ranges, _function).forEach(_function_1);
    final Function1<Map.Entry<Integer, Collection<SemanticHighlightingTokens.Token>>, SemanticHighlightingInformation> _function_2 = (Map.Entry<Integer, Collection<SemanticHighlightingTokens.Token>> it) -> {
      SemanticHighlightingInformation _xblockexpression = null;
      {
        final Integer line = it.getKey();
        final Collection<SemanticHighlightingTokens.Token> tokens = it.getValue();
        String _encode = SemanticHighlightingTokens.encode(tokens);
        _xblockexpression = new SemanticHighlightingInformation((line).intValue(), _encode);
      }
      return _xblockexpression;
    };
    return this.appendEmptyLineTokens(IterableExtensions.<SemanticHighlightingInformation>toList(IterableExtensions.<Map.Entry<Integer, Collection<SemanticHighlightingTokens.Token>>, SemanticHighlightingInformation>map(builder.build().asMap().entrySet(), _function_2)), document);
  }
  
  protected List<SemanticHighlightingInformation> appendEmptyLineTokens(final List<SemanticHighlightingInformation> infos, final Document document) {
    final int lineCount = document.getLineCount();
    final Function<SemanticHighlightingInformation, Integer> _function = (SemanticHighlightingInformation it) -> {
      return Integer.valueOf(it.getLine());
    };
    final HashMap<Integer, SemanticHighlightingInformation> tokens = Maps.<Integer, SemanticHighlightingInformation>newHashMap(Maps.<Integer, SemanticHighlightingInformation>uniqueIndex(infos, _function));
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, lineCount, true);
    for (final Integer i : _doubleDotLessThan) {
      boolean _containsKey = tokens.containsKey(i);
      boolean _not = (!_containsKey);
      if (_not) {
        SemanticHighlightingInformation _semanticHighlightingInformation = new SemanticHighlightingInformation((i).intValue(), null);
        tokens.put(i, _semanticHighlightingInformation);
      }
    }
    return IterableExtensions.<SemanticHighlightingInformation>toList(tokens.values());
  }
  
  protected VersionedTextDocumentIdentifier toVersionedTextDocumentIdentifier(final ILanguageServerAccess.Context context) {
    VersionedTextDocumentIdentifier _versionedTextDocumentIdentifier = new VersionedTextDocumentIdentifier();
    final Procedure1<VersionedTextDocumentIdentifier> _function = (VersionedTextDocumentIdentifier it) -> {
      it.setUri(this._uriExtensions.toUriString(context.getResource().getURI()));
      it.setVersion(context.getDocument().getVersion());
    };
    return ObjectExtensions.<VersionedTextDocumentIdentifier>operator_doubleArrow(_versionedTextDocumentIdentifier, _function);
  }
  
  protected void notifyClient(final SemanticHighlightingParams params) {
    this.client.semanticHighlighting(params);
  }
  
  protected void checkInitialized() {
    Preconditions.checkState((this.client != null), "Not initialized.");
  }
  
  protected boolean isNullOrUnknown(final List<String> nullable) {
    return ((nullable == null) || Objects.equal(nullable, SemanticHighlightingRegistry.UNKNOWN_SCOPES));
  }
  
  private static final Logger LOG = Logger.getLogger(SemanticHighlightingRegistry.class);
}
