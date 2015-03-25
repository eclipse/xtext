package org.eclipse.xtext.idea.extensions;

import com.intellij.openapi.project.DumbService;
import com.intellij.openapi.project.IndexNotReadyException;
import com.intellij.openapi.project.Project;
import com.intellij.psi.JavaPsiFacade;
import com.intellij.psi.PsiClass;
import com.intellij.psi.search.GlobalSearchScope;
import org.apache.log4j.Logger;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public class IdeaProjectExtensions {
  private final static Logger LOG = Logger.getLogger(IdeaProjectExtensions.class);
  
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
  
  public static <T extends Object> T withAlternativeResolvedEnabled(final Project project, final Function0<? extends T> function) {
    DumbService _dumbService = IdeaProjectExtensions.getDumbService(project);
    return IdeaProjectExtensions.<T>withAlternativeResolvedEnabled(_dumbService, function);
  }
  
  public static <T extends Object> T withAlternativeResolvedEnabled(final DumbService dumbService, final Function0<? extends T> function) {
    T _xblockexpression = null;
    {
      final boolean alternativeResolvedEnabled = dumbService.isAlternativeResolveEnabled();
      dumbService.setAlternativeResolveEnabled(true);
      T _xtrycatchfinallyexpression = null;
      try {
        _xtrycatchfinallyexpression = function.apply();
      } catch (final Throwable _t) {
        if (_t instanceof IndexNotReadyException) {
          final IndexNotReadyException e = (IndexNotReadyException)_t;
          Object _xblockexpression_1 = null;
          {
            String _message = e.getMessage();
            IdeaProjectExtensions.LOG.warn(_message, e);
            _xblockexpression_1 = null;
          }
          _xtrycatchfinallyexpression = ((T)_xblockexpression_1);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      } finally {
        dumbService.setAlternativeResolveEnabled(alternativeResolvedEnabled);
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  public static JavaPsiFacade getJavaPsiFacade(final Project project) {
    return JavaPsiFacade.getInstance(project);
  }
  
  public static DumbService getDumbService(final Project project) {
    return DumbService.getInstance(project);
  }
}
