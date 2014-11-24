package org.eclipse.xtext.psi.tree;

import java.io.IOException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.psi.PsiEObject;
import org.eclipse.xtext.psi.stubs.PsiEObjectStub;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class IGrammarAwareElementType /* implements IStubElementType<PsiEObjectStub, PsiEObject>  */{
  @Accessors
  private final EObject grammarElement;
  
  public IGrammarAwareElementType(final String debugName, final /* Language */Object language, final EObject grammarElement) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method super is undefined for the type IGrammarAwareElementType");
  }
  
  public void createPsi(final PsiEObjectStub stub) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void createStub(final PsiEObject psi, final /* StubElement */Object parentStub) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void deserialize(final /* StubInputStream */Object dataStream, final /* StubElement */Object parentStub) throws IOException {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public Object getExternalId() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field language is undefined for the type IGrammarAwareElementType"
      + "\nThe method or field toString is undefined for the type IGrammarAwareElementType"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved");
  }
  
  public void indexStub(final PsiEObjectStub stub, final /* IndexSink */Object sink) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void serialize(final PsiEObjectStub stub, final /* StubOutputStream */Object dataStream) throws IOException {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public boolean shouldCreateStub(final /* ASTNode */Object node) {
    return false;
  }
  
  @Pure
  public EObject getGrammarElement() {
    return this.grammarElement;
  }
}
