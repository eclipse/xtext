package org.eclipse.xtext.xtext.idea.tests.resource;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiFile;
import com.intellij.psi.impl.JavaPsiFacadeEx;
import com.intellij.psi.search.GlobalSearchScope;
import junit.framework.TestCase;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.idea.lang.XtextFileType;
import org.eclipse.xtext.idea.resource.IdeaClasspathURIResolver;
import org.eclipse.xtext.idea.resource.VirtualFileURIUtil;
import org.eclipse.xtext.idea.tests.LightToolingTest;
import org.eclipse.xtext.resource.ClasspathUriUtil;
import org.junit.Test;

@SuppressWarnings("all")
public class IdeaClasspathURIResolverTest extends LightToolingTest {
  public IdeaClasspathURIResolverTest() {
    super(XtextFileType.INSTANCE);
  }
  
  private final IdeaClasspathURIResolver resolver = new IdeaClasspathURIResolver();
  
  @Test
  public void testResolveFromSourceFolder() {
    final PsiFile file = this.myFixture.addFileToProject("foo/MyFile.text", "My Contents");
    Module _module = this.myFixture.getModule();
    URI _createURI = URI.createURI((ClasspathUriUtil.CLASSPATH_SCHEME + "://foo/MyFile.text"));
    final URI result = this.resolver.resolve(_module, _createURI);
    VirtualFile _virtualFile = file.getVirtualFile();
    URI _uRI = VirtualFileURIUtil.getURI(_virtualFile);
    TestCase.assertEquals(_uRI, result);
  }
  
  @Test
  public void testResolveFromLibrary() {
    JavaPsiFacadeEx _javaFacade = this.myFixture.getJavaFacade();
    Module _module = this.myFixture.getModule();
    GlobalSearchScope _moduleWithLibrariesScope = GlobalSearchScope.moduleWithLibrariesScope(_module);
    final PsiClass type = _javaFacade.findClass("java.lang.String", _moduleWithLibrariesScope);
    Module _module_1 = this.myFixture.getModule();
    URI _createURI = URI.createURI((ClasspathUriUtil.CLASSPATH_SCHEME + "://java/lang/String.class"));
    final URI result = this.resolver.resolve(_module_1, _createURI);
    PsiFile _containingFile = type.getContainingFile();
    VirtualFile _virtualFile = _containingFile.getVirtualFile();
    URI _uRI = VirtualFileURIUtil.getURI(_virtualFile);
    TestCase.assertEquals(_uRI, result);
  }
}
