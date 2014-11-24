package org.eclipse.xtext.psi.stubs;

import com.google.inject.Inject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.psi.stubs.XtextFileStub;

@SuppressWarnings("all")
public class XtextStubBuilder /* implements DefaultStubBuilder  */{
  @Inject
  private IElementTypeProvider elementTypeProvider;
  
  protected /* StubElement<?> */Object createStubForFile(final /* PsiFile */Object file) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field super is undefined for the type XtextStubBuilder"
      + "\ncreateStubForFile cannot be resolved"
      + "\ncreateStubForFile cannot be resolved");
  }
  
  protected XtextFileStub<BaseXtextFile> createStubForFile(final BaseXtextFile xtextFile) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method fileType is undefined for the type XtextStubBuilder");
  }
}
