package org.eclipse.xtext.xbase.idea.execution;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.codeInsight.TestFrameworks;
import com.intellij.execution.JavaExecutionUtil;
import com.intellij.execution.RunManager;
import com.intellij.execution.RunnerAndConfigurationSettings;
import com.intellij.execution.actions.ConfigurationContext;
import com.intellij.execution.application.ApplicationConfiguration;
import com.intellij.execution.application.ApplicationConfigurationType;
import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationUtil;
import com.intellij.execution.configurations.JavaRunConfigurationModule;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.junit.JavaRunConfigurationProducerBase;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.util.Comparing;
import com.intellij.openapi.util.Ref;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.util.PsiMethodUtil;
import com.intellij.psi.util.PsiTreeUtil;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.idea.trace.TraceUtils;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class JvmTypesApplicationConfigurationProducer extends JavaRunConfigurationProducerBase<ApplicationConfiguration> {
  @Inject
  private TraceUtils traceUtils;
  
  private IXtextLanguage xtextLanguage;
  
  public JvmTypesApplicationConfigurationProducer(final IXtextLanguage xtextLanguage) {
    super(ApplicationConfigurationType.getInstance());
    xtextLanguage.injectMembers(this);
    this.xtextLanguage = xtextLanguage;
  }
  
  @Override
  public boolean isConfigurationFromContext(final ApplicationConfiguration appConf, final ConfigurationContext context) {
    PsiElement _psiLocation = context.getPsiLocation();
    boolean _isConfiguration = false;
    if (_psiLocation!=null) {
      _isConfiguration=this.isConfiguration(_psiLocation, appConf, context);
    }
    return _isConfiguration;
  }
  
  @Override
  protected boolean setupConfigurationFromContext(final ApplicationConfiguration conf, final ConfigurationContext context, final Ref<PsiElement> sourceElement) {
    boolean _isNull = sourceElement.isNull();
    boolean _not = (!_isNull);
    if (_not) {
      PsiElement _get = sourceElement.get();
      Iterable<PsiElement> _bestJavaElementMatch = this.traceUtils.getBestJavaElementMatch(_get);
      final PsiElement javaElement = IterableExtensions.<PsiElement>head(_bestJavaElementMatch);
      boolean _notEquals = (!Objects.equal(javaElement, null));
      if (_notEquals) {
        return this.setupConfiguration(javaElement, conf, context, sourceElement);
      }
    }
    return false;
  }
  
  protected boolean setupConfiguration(final PsiElement it, final ApplicationConfiguration configuration, final ConfigurationContext context, final Ref<PsiElement> sourceElement) {
    boolean _or = false;
    boolean _setupConfigurationWithMethod = this.setupConfigurationWithMethod(it, configuration, context, sourceElement);
    if (_setupConfigurationWithMethod) {
      _or = true;
    } else {
      boolean _setupConfigurationWithClass = this.setupConfigurationWithClass(it, configuration, context, sourceElement);
      _or = _setupConfigurationWithClass;
    }
    return _or;
  }
  
  protected boolean setupConfigurationWithClass(final PsiElement element, final ApplicationConfiguration configuration, final ConfigurationContext context, final Ref<PsiElement> sourceElement) {
    final PsiClass mainClass = ApplicationConfigurationType.getMainClass(element);
    boolean _equals = Objects.equal(mainClass, null);
    if (_equals) {
      return false;
    }
    sourceElement.set(mainClass);
    this.setupConfiguration(configuration, mainClass, context);
    return true;
  }
  
  protected boolean setupConfigurationWithMethod(final PsiElement element, final ApplicationConfiguration configuration, final ConfigurationContext context, final Ref<PsiElement> sourceElement) {
    boolean _xblockexpression = false;
    {
      final PsiMethod mainMethod = this.findMainMethod(element);
      boolean _equals = Objects.equal(mainMethod, null);
      if (_equals) {
        return false;
      }
      final PsiClass class_ = mainMethod.getContainingClass();
      boolean _value = ConfigurationUtil.MAIN_CLASS.value(class_);
      if (_value) {
        sourceElement.set(mainMethod);
        this.setupConfiguration(configuration, class_, context);
        return true;
      }
      PsiElement _parent = mainMethod.getParent();
      _xblockexpression = this.setupConfigurationWithMethod(_parent, configuration, context, sourceElement);
    }
    return _xblockexpression;
  }
  
  protected void setupConfiguration(final ApplicationConfiguration configuration, final PsiClass aClass, final ConfigurationContext context) {
    String _runtimeQualifiedName = JavaExecutionUtil.getRuntimeQualifiedName(aClass);
    configuration.MAIN_CLASS_NAME = _runtimeQualifiedName;
    configuration.setGeneratedName();
    this.setupConfigurationModule(context, configuration);
  }
  
  protected PsiMethod findMainMethod(final PsiElement element) {
    PsiMethod _xblockexpression = null;
    {
      final PsiMethod method = PsiTreeUtil.<PsiMethod>getParentOfType(element, PsiMethod.class, false);
      boolean _equals = Objects.equal(method, null);
      if (_equals) {
        return null;
      }
      boolean _isMainMethod = PsiMethodUtil.isMainMethod(method);
      if (_isMainMethod) {
        return method;
      }
      PsiElement _parent = method.getParent();
      _xblockexpression = this.findMainMethod(_parent);
    }
    return _xblockexpression;
  }
  
  protected boolean isConfiguration(final PsiElement element, final ApplicationConfiguration appConfiguration, final ConfigurationContext context) {
    final PsiClass mainClass = ApplicationConfigurationType.getMainClass(element);
    boolean _equals = Objects.equal(mainClass, null);
    if (_equals) {
      return false;
    }
    String _runtimeQualifiedName = JavaExecutionUtil.getRuntimeQualifiedName(mainClass);
    boolean _equal = Comparing.equal(_runtimeQualifiedName, appConfiguration.MAIN_CLASS_NAME);
    boolean _not = (!_equal);
    if (_not) {
      return false;
    }
    final PsiMethod method = PsiTreeUtil.<PsiMethod>getParentOfType(element, PsiMethod.class, false);
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(method, null));
    if (!_notEquals) {
      _and = false;
    } else {
      TestFrameworks _instance = TestFrameworks.getInstance();
      boolean _isTestMethod = _instance.isTestMethod(method);
      _and = _isTestMethod;
    }
    if (_and) {
      return false;
    }
    JavaRunConfigurationModule _configurationModule = appConfiguration.getConfigurationModule();
    final Module configurationModule = _configurationModule.getModule();
    Module _module = context.getModule();
    boolean _equal_1 = Comparing.<Module>equal(_module, configurationModule);
    if (_equal_1) {
      return true;
    }
    RunManager _runManager = context.getRunManager();
    ConfigurationFactory _configurationFactory = this.getConfigurationFactory();
    RunnerAndConfigurationSettings _configurationTemplate = _runManager.getConfigurationTemplate(_configurationFactory);
    RunConfiguration template = _configurationTemplate.getConfiguration();
    if ((template instanceof ApplicationConfiguration)) {
      JavaRunConfigurationModule _configurationModule_1 = ((ApplicationConfiguration)template).getConfigurationModule();
      final Module predefinedModule = _configurationModule_1.getModule();
      boolean _equal_2 = Comparing.<Module>equal(predefinedModule, configurationModule);
      if (_equal_2) {
        return true;
      }
    }
    return false;
  }
}
