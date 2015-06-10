package org.eclipse.xtext.idea.extensions;

import com.intellij.openapi.project.DumbService;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.LanguageLevelProjectExtension;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.psi.JavaPsiFacade;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.search.GlobalSearchScope;
import org.eclipse.xtext.util.Wrapper;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public class IdeaProjectExtensions {
  public static PsiClass findClassWithAlternativeResolvedEnabled(final JavaPsiFacade javaPsiFacade, final String name, final GlobalSearchScope searchScope) {
    Project _project = javaPsiFacade.getProject();
    final Function0<PsiClass> _function = new Function0<PsiClass>() {
      @Override
      public PsiClass apply() {
        return javaPsiFacade.findClass(name, searchScope);
      }
    };
    return IdeaProjectExtensions.<PsiClass>withAlternativeResolvedEnabled(_project, _function);
  }
  
  public static PsiClass[] findClassesWithAlternativeResolvedEnabled(final JavaPsiFacade javaPsiFacade, final String name, final GlobalSearchScope searchScope) {
    Project _project = javaPsiFacade.getProject();
    final Function0<PsiClass[]> _function = new Function0<PsiClass[]>() {
      @Override
      public PsiClass[] apply() {
        return javaPsiFacade.findClasses(name, searchScope);
      }
    };
    return IdeaProjectExtensions.<PsiClass[]>withAlternativeResolvedEnabled(_project, _function);
  }
  
  /**
   * The given function is executed with a fallback to the slow indexing mode, which
   * is demand indexing rather than using a populated index.
   */
  public static <T extends Object> T withAlternativeResolvedEnabled(final Project project, final Function0<? extends T> function) {
    DumbService _dumbService = IdeaProjectExtensions.getDumbService(project);
    return IdeaProjectExtensions.<T>withAlternativeResolvedEnabled(_dumbService, function);
  }
  
  /**
   * The given function is executed with a fallback to the slow indexing mode, which
   * is demand indexing rather than using a populated index.
   */
  public static <T extends Object> T withAlternativeResolvedEnabled(final DumbService dumbService, final Function0<? extends T> function) {
    final Wrapper<T> result = Wrapper.<T>wrap(null);
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        T _apply = function.apply();
        result.set(_apply);
      }
    };
    dumbService.withAlternativeResolveEnabled(_function);
    return result.get();
  }
  
  public static JavaPsiFacade getJavaPsiFacade(final Project project) {
    return JavaPsiFacade.getInstance(project);
  }
  
  public static DumbService getDumbService(final Project project) {
    return DumbService.getInstance(project);
  }
  
  public static ProjectFileIndex getProjectFileIndex(final Project project) {
    return ProjectFileIndex.SERVICE.getInstance(project);
  }
  
  public static LanguageLevelProjectExtension getLanguageLevelProjectExtension(final Project project) {
    return LanguageLevelProjectExtension.getInstance(project);
  }
  
  public static PsiFileFactory getPsiFileFactory(final Project project) {
    return PsiFileFactory.getInstance(project);
  }
  
  public static PsiDocumentManager getPsiDocumentManager(final Project project) {
    return PsiDocumentManager.getInstance(project);
  }
}
