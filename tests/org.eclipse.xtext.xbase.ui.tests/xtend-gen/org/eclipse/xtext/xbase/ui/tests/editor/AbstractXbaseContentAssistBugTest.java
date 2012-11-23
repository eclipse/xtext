package org.eclipse.xtext.xbase.ui.tests.editor;

import com.google.inject.Injector;
import java.io.InputStream;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProviderFactory;
import org.eclipse.xtext.junit4.ui.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.ui.tests.AbstractXbaseUITestCase;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;

@SuppressWarnings("all")
public class AbstractXbaseContentAssistBugTest extends AbstractXbaseUITestCase implements IJavaProjectProvider {
  private IProject demandCreateProject;
  
  private static IProject staticProject;
  
  @BeforeClass
  public static void createTestProject() throws Exception {
    String _name = AbstractXbaseContentAssistBugTest.class.getName();
    IProject _createPluginProject = AbstractXbaseUITestCase.createPluginProject(_name);
    AbstractXbaseContentAssistBugTest.staticProject = _createPluginProject;
  }
  
  @AfterClass
  public static void deleteTestProject() throws Exception {
    JavaProjectSetupUtil.deleteProject(AbstractXbaseContentAssistBugTest.staticProject);
  }
  
  public void tearDown() throws Exception {
    boolean _notEquals = ObjectExtensions.operator_notEquals(this.demandCreateProject, null);
    if (_notEquals) {
      JavaProjectSetupUtil.deleteProject(this.demandCreateProject);
    }
    super.tearDown();
  }
  
  public boolean doCleanWorkspace() {
    return false;
  }
  
  public IJavaProject getJavaProject(final ResourceSet resourceSet) {
    final String projectName = this.getProjectName();
    IJavaProject javaProject = JavaProjectSetupUtil.findJavaProject(projectName);
    boolean _or = false;
    boolean _equals = ObjectExtensions.operator_equals(javaProject, null);
    if (_equals) {
      _or = true;
    } else {
      boolean _exists = javaProject.exists();
      boolean _not = (!_exists);
      _or = (_equals || _not);
    }
    if (_or) {
      try {
        IProject _createPluginProject = AbstractXbaseUITestCase.createPluginProject(projectName);
        this.demandCreateProject = _createPluginProject;
        IJavaProject _findJavaProject = JavaProjectSetupUtil.findJavaProject(projectName);
        javaProject = _findJavaProject;
      } catch (final Throwable _t) {
        if (_t instanceof CoreException) {
          final CoreException e = (CoreException)_t;
          String _message = e.getMessage();
          String _plus = ("cannot create java project due to: " + _message);
          String _plus_1 = (_plus + " / ");
          String _plus_2 = (_plus_1 + e);
          Assert.fail(_plus_2);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
    return javaProject;
  }
  
  protected String getProjectName() {
    Class<? extends Object> _class = this.getClass();
    String _simpleName = _class.getSimpleName();
    return (_simpleName + "Project");
  }
  
  public XtextResource getResourceFor(final InputStream stream) {
    final XtextResource result = super.getResourceFor(stream);
    this.initializeTypeProvider(result);
    return result;
  }
  
  protected void initializeTypeProvider(final XtextResource result) {
    ResourceSet _resourceSet = result.getResourceSet();
    final XtextResourceSet resourceSet = ((XtextResourceSet) _resourceSet);
    JdtTypeProviderFactory _jdtTypeProviderFactory = new JdtTypeProviderFactory(this);
    final JdtTypeProviderFactory typeProviderFactory = _jdtTypeProviderFactory;
    typeProviderFactory.findOrCreateTypeProvider(resourceSet);
    IJavaProject _javaProject = this.getJavaProject(resourceSet);
    resourceSet.setClasspathURIContext(_javaProject);
  }
  
  protected ContentAssistProcessorTestBuilder newBuilder() throws Exception {
    Injector _injector = this.getInjector();
    ContentAssistProcessorTestBuilder _contentAssistProcessorTestBuilder = new ContentAssistProcessorTestBuilder(_injector, this);
    return _contentAssistProcessorTestBuilder;
  }
}
