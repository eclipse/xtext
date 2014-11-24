package org.eclipse.xtext.idea.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class PsiXtextTokenStream extends XtextTokenStream {
  private boolean afterSeek;
  
  private final /* PsiBuilder */Object builder;
  
  private final /* List<PsiBuilder.Marker> */Object markers;
  
  private final Map<Integer, Integer> psiToOriginalMarkers;
  
  public PsiXtextTokenStream(final /* PsiBuilder */Object builder, final TokenSource tokenSource, final ITokenDefProvider tokenDefProvider) {
    super(tokenSource, tokenDefProvider);
    this.builder = builder;
    this.afterSeek = false;
    ArrayList<Marker> _newArrayList = CollectionLiterals.<Marker>newArrayList();
    this.markers = _newArrayList;
    HashMap<Integer, Integer> _newHashMap = CollectionLiterals.<Integer, Integer>newHashMap();
    this.psiToOriginalMarkers = _newHashMap;
  }
  
  public void consume() {
    throw new Error("Unresolved compilation problems:"
      + "\nrawTokenIndex cannot be resolved"
      + "\n< cannot be resolved");
  }
  
  protected void advanceLexer() {
    throw new Error("Unresolved compilation problems:"
      + "\nCreateElementType cannot be resolved."
      + "\nThe method putUserData is undefined for the type PsiXtextTokenStream"
      + "\neof cannot be resolved"
      + "\nrawTokenIndex cannot be resolved"
      + "\ntokenType cannot be resolved"
      + "\nremapCurrentToken cannot be resolved"
      + "\nadvanceLexer cannot be resolved");
  }
  
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
    throw new Error("Unresolved compilation problems:"
      + "\nmark cannot be resolved");
  }
  
  protected int getLastPsiMarker() {
    int _size = this.markers.size();
    return (_size - 1);
  }
  
  public void release(final int psiMarker) {
    throw new Error("Unresolved compilation problems:"
      + "\ndrop cannot be resolved");
  }
  
  public void rewind() {
    super.rewind();
    int _lastPsiMarker = this.getLastPsiMarker();
    this.rewind(_lastPsiMarker);
    this.mark();
    this.afterSeek = false;
  }
  
  public void rewind(final int psiMarker) {
    throw new Error("Unresolved compilation problems:"
      + "\nrollbackTo cannot be resolved");
  }
  
  public void seek(final int index) {
    super.seek(index);
    this.afterSeek = true;
  }
}
