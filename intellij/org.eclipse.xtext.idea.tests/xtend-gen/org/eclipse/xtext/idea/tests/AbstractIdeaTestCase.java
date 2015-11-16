package org.eclipse.xtext.idea.tests;

import com.google.common.base.Objects;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.projectRoots.impl.JavaAwareProjectJdkTableImpl;
import com.intellij.openapi.projectRoots.impl.ProjectJdkImpl;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.util.Computable;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.testFramework.IdeaTestCase;
import com.intellij.testFramework.PlatformTestCase;
import java.util.List;
import junit.framework.TestCase;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public abstract class AbstractIdeaTestCase extends IdeaTestCase {
  private VirtualFile srcFolder;
  
  public abstract void configureModule(final Module module, final ModifiableRootModel model, final ContentEntry entry);
  
  @Override
  protected boolean isRunInWriteAction() {
    return false;
  }
  
  protected <T extends Object> T write(final Computable<T> c) {
    Application _application = ApplicationManager.getApplication();
    return _application.<T>runWriteAction(c);
  }
  
  protected VirtualFile addFile(final Pair<String, String> file) {
    final Computable<VirtualFile> _function = new Computable<VirtualFile>() {
      @Override
      public VirtualFile compute() {
        try {
          String _key = file.getKey();
          final VirtualFile result = AbstractIdeaTestCase.this.srcFolder.findOrCreateChildData(AbstractIdeaTestCase.this, _key);
          String _value = file.getValue();
          VfsUtil.saveText(result, _value);
          AbstractIdeaTestCase.this.assertNoCompileErrors(result);
          return result;
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    return this.<VirtualFile>write(_function);
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    final Computable<Object> _function = new Computable<Object>() {
      @Override
      public Object compute() {
        try {
          Module _module = AbstractIdeaTestCase.this.getModule();
          final ModuleRootManager mnr = ModuleRootManager.getInstance(_module);
          final ModifiableRootModel model = mnr.getModifiableModel();
          Project _project = AbstractIdeaTestCase.this.getProject();
          VirtualFile _baseDir = _project.getBaseDir();
          final ContentEntry entry = model.addContentEntry(_baseDir);
          Project _project_1 = AbstractIdeaTestCase.this.getProject();
          VirtualFile _baseDir_1 = _project_1.getBaseDir();
          VirtualFile _createDirectoryIfMissing = VfsUtil.createDirectoryIfMissing(_baseDir_1, "src");
          AbstractIdeaTestCase.this.srcFolder = _createDirectoryIfMissing;
          boolean _isTestSource = AbstractIdeaTestCase.this.isTestSource(AbstractIdeaTestCase.this.srcFolder);
          entry.addSourceFolder(AbstractIdeaTestCase.this.srcFolder, _isTestSource);
          Module _module_1 = AbstractIdeaTestCase.this.getModule();
          AbstractIdeaTestCase.this.configureModule(_module_1, model, entry);
          model.commit();
          return null;
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    this.<Object>write(_function);
  }
  
  protected boolean isTestSource(final VirtualFile srcFolder) {
    return false;
  }
  
  protected void assertNoCompileErrors(final VirtualFile file) {
    PsiManager _psiManager = this.getPsiManager();
    final PsiFile psiFile = _psiManager.findFile(file);
    if ((psiFile instanceof BaseXtextFile)) {
      final XtextResource resource = ((BaseXtextFile)psiFile).getResource();
      IResourceServiceProvider _resourceServiceProvider = resource.getResourceServiceProvider();
      IResourceValidator _resourceValidator = _resourceServiceProvider.getResourceValidator();
      final List<Issue> issues = _resourceValidator.validate(resource, 
        CheckMode.NORMAL_AND_FAST, CancelIndicator.NullImpl);
      String _string = issues.toString();
      final Function1<Issue, Boolean> _function = new Function1<Issue, Boolean>() {
        @Override
        public Boolean apply(final Issue it) {
          Severity _severity = it.getSeverity();
          return Boolean.valueOf(Objects.equal(_severity, Severity.ERROR));
        }
      };
      boolean _exists = IterableExtensions.<Issue>exists(issues, _function);
      TestCase.assertFalse(_string, _exists);
    }
  }
  
  @Override
  protected Sdk getTestProjectJdk() {
    try {
      JavaAwareProjectJdkTableImpl _instanceEx = JavaAwareProjectJdkTableImpl.getInstanceEx();
      Sdk _internalJdk = _instanceEx.getInternalJdk();
      Object _clone = _internalJdk.clone();
      ProjectJdkImpl jdk = ((ProjectJdkImpl) _clone);
      jdk.setName("JDK");
      return jdk;
    } catch (final Throwable _t) {
      if (_t instanceof CloneNotSupportedException) {
        final CloneNotSupportedException e = (CloneNotSupportedException)_t;
        PlatformTestCase.LOG.error(e);
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
