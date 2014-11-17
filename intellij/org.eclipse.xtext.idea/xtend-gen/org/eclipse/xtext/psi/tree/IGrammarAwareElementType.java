package org.eclipse.xtext.psi.tree;

import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.IndexSink;
import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.stubs.StubInputStream;
import com.intellij.psi.stubs.StubOutputStream;
import java.io.IOException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.psi.PsiEObject;
import org.eclipse.xtext.psi.stubs.PsiEObjectStub;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class IGrammarAwareElementType extends IStubElementType<PsiEObjectStub, PsiEObject> {
  @Accessors
  private final EObject grammarElement;
  
  public IGrammarAwareElementType(final String debugName, final Language language, final EObject grammarElement) {
    super(debugName, language);
    this.grammarElement = grammarElement;
  }
  
  public PsiEObject createPsi(final PsiEObjectStub stub) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public PsiEObjectStub createStub(final PsiEObject psi, final StubElement parentStub) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public PsiEObjectStub deserialize(final StubInputStream dataStream, final StubElement parentStub) throws IOException {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public String getExternalId() {
    Language _language = this.getLanguage();
    String _plus = (_language + ".");
    String _string = this.toString();
    return (_plus + _string);
  }
  
  public void indexStub(final PsiEObjectStub stub, final IndexSink sink) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void serialize(final PsiEObjectStub stub, final StubOutputStream dataStream) throws IOException {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public boolean shouldCreateStub(final ASTNode node) {
    return false;
  }
  
  @Pure
  public EObject getGrammarElement() {
    return this.grammarElement;
  }
}
