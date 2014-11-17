package org.eclipse.xtext.idea.types.stubindex;

import com.intellij.psi.stubs.StringStubIndexExtension;
import com.intellij.psi.stubs.StubIndexKey;
import org.eclipse.xtext.psi.impl.BaseXtextFile;

@SuppressWarnings("all")
public class JvmDeclaredTypeShortNameIndex extends StringStubIndexExtension<BaseXtextFile> {
  public static StubIndexKey<String, BaseXtextFile> KEY = StubIndexKey.<String, BaseXtextFile>createIndexKey("JvmDeclaredTypeShortNameIndex");
  
  public StubIndexKey<String, BaseXtextFile> getKey() {
    return JvmDeclaredTypeShortNameIndex.KEY;
  }
}
