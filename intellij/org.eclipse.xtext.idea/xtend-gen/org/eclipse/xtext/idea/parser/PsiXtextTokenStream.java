package org.eclipse.xtext.idea.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.psi.tree.IElementType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtext.idea.lang.CreateElementType;
import org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class PsiXtextTokenStream extends XtextTokenStream {
  private boolean afterSeek;
  
  private final PsiBuilder builder;
  
  private final List<PsiBuilder.Marker> markers;
  
  private final Map<Integer, Integer> psiToOriginalMarkers;
  
  public PsiXtextTokenStream(final PsiBuilder builder, final TokenSource tokenSource, final ITokenDefProvider tokenDefProvider) {
    super(tokenSource, tokenDefProvider);
    this.builder = builder;
    this.afterSeek = false;
    ArrayList<PsiBuilder.Marker> _newArrayList = CollectionLiterals.<PsiBuilder.Marker>newArrayList();
    this.markers = _newArrayList;
    HashMap<Integer, Integer> _newHashMap = CollectionLiterals.<Integer, Integer>newHashMap();
    this.psiToOriginalMarkers = _newHashMap;
  }
  
  @Override
  public void consume() {
    if (this.afterSeek) {
      super.consume();
    } else {
      final int rawTokenIndex = this.builder.rawTokenIndex();
      if ((rawTokenIndex < this.p)) {
        final int n = (this.p - rawTokenIndex);
        for (int i = 0; (i < n); i++) {
          this.advanceLexer();
        }
      }
      super.consume();
      this.advanceLexer();
    }
  }
  
  protected void advanceLexer() {
    boolean _eof = this.builder.eof();
    if (_eof) {
      return;
    }
    int _rawTokenIndex = this.builder.rawTokenIndex();
    final Token token = this.get(_rawTokenIndex);
    int _channel = token.getChannel();
    final boolean hidden = (_channel == BaseRecognizer.HIDDEN);
    final IElementType tokenType = this.builder.getTokenType();
    final CreateElementType.CreateCallback _function = new CreateElementType.CreateCallback() {
      @Override
      public void onCreate(final ASTNode it) {
        it.<Boolean>putUserData(IASTNodeAwareNodeModelBuilder.HIDDEN_KEY, Boolean.valueOf(hidden));
      }
    };
    CreateElementType _createElementType = new CreateElementType(tokenType, _function);
    this.builder.remapCurrentToken(_createElementType);
    this.builder.advanceLexer();
  }
  
  @Override
  public int mark() {
    int _xblockexpression = (int) 0;
    {
      final int psiMarker = this.markPsi();
      int _mark = super.mark();
      this.psiToOriginalMarkers.put(Integer.valueOf(psiMarker), Integer.valueOf(_mark));
      _xblockexpression = psiMarker;
    }
    return _xblockexpression;
  }
  
  protected int markPsi() {
    int _xblockexpression = (int) 0;
    {
      PsiBuilder.Marker _mark = this.builder.mark();
      this.markers.add(_mark);
      _xblockexpression = this.getLastPsiMarker();
    }
    return _xblockexpression;
  }
  
  protected int getLastPsiMarker() {
    int _size = this.markers.size();
    return (_size - 1);
  }
  
  @Override
  public void release(final int psiMarker) {
    Integer _get = this.psiToOriginalMarkers.get(Integer.valueOf(psiMarker));
    super.release((_get).intValue());
    PsiBuilder.Marker _get_1 = this.markers.get(psiMarker);
    _get_1.drop();
  }
  
  @Override
  public void rewind() {
    super.rewind();
    int _lastPsiMarker = this.getLastPsiMarker();
    this.rewind(_lastPsiMarker);
    this.mark();
    this.afterSeek = false;
  }
  
  @Override
  public void rewind(final int psiMarker) {
    Integer _get = this.psiToOriginalMarkers.get(Integer.valueOf(psiMarker));
    super.rewind((_get).intValue());
    PsiBuilder.Marker _get_1 = this.markers.get(psiMarker);
    _get_1.rollbackTo();
    this.afterSeek = false;
  }
  
  @Override
  public void seek(final int index) {
    super.seek(index);
    this.afterSeek = true;
  }
}
