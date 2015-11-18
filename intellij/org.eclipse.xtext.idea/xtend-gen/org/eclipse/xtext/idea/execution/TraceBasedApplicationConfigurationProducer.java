package org.eclipse.xtext.idea.execution;

import com.google.inject.Inject;
import com.intellij.codeInsight.TestFrameworks;
import com.intellij.execution.JavaExecutionUtil;
import com.intellij.execution.Location;
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
import org.eclipse.xtext.idea.execution.ConfigurationProducerExtensions;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.xbase.lib.Extension;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("all")
public class TraceBasedApplicationConfigurationProducer extends JavaRunConfigurationProducerBase<ApplicationConfiguration> {
  @Inject
  @Extension
  private ConfigurationProducerExtensions _configurationProducerExtensions;
  
  public TraceBasedApplicationConfigurationProducer(final IXtextLanguage xtextLanguage) {
    super(ApplicationConfigurationType.getInstance());
    xtextLanguage.injectMembers(this);
  }
  
  @Override
  protected boolean setupConfigurationFromContext(final ApplicationConfiguration conf, final ConfigurationContext context, final Ref<PsiElement> sourceElement) {
    final PsiElement javaElement = this._configurationProducerExtensions.tracedJavaElement(context);
    if ((javaElement != null)) {
      ConfigurationContext _prepareContextFor = this._configurationProducerExtensions.prepareContextFor(context, javaElement);
      return this.internalSetupConfigurationFromContext(conf, _prepareContextFor, sourceElement);
    }
    return false;
  }
  
  @Override
  public boolean isConfigurationFromContext(final ApplicationConfiguration appConf, final ConfigurationContext context) {
    final PsiElement javaElement = this._configurationProducerExtensions.tracedJavaElement(context);
    if ((javaElement != null)) {
      ConfigurationContext _prepareContextFor = this._configurationProducerExtensions.prepareContextFor(context, javaElement);
      return this.internalIsConfigurationFromContext(appConf, _prepareContextFor);
    }
    return false;
  }
  
  protected boolean internalSetupConfigurationFromContext(final ApplicationConfiguration configuration, final ConfigurationContext context, final Ref<PsiElement> sourceElement) {
    final Location contextLocation = context.getLocation();
    if ((contextLocation == null)) {
      return false;
    }
    final Location location = JavaExecutionUtil.stepIntoSingleClass(contextLocation);
    if ((location == null)) {
      return false;
    }
    final PsiElement element = location.getPsiElement();
    boolean _isPhysical = element.isPhysical();
    boolean _not = (!_isPhysical);
    if (_not) {
      return false;
    }
    PsiElement currentElement = element;
    PsiMethod method = null;
    while (((method = TraceBasedApplicationConfigurationProducer.findMain(currentElement)) != null)) {
      {
        final PsiClass aClass = method.getContainingClass();
        boolean _value = ConfigurationUtil.MAIN_CLASS.value(aClass);
        if (_value) {
          sourceElement.set(method);
          this.setupConfiguration(configuration, aClass, context);
          return true;
        }
        PsiElement _parent = method.getParent();
        currentElement = _parent;
      }
    }
    final PsiClass aClass = ApplicationConfigurationType.getMainClass(element);
    if ((aClass == null)) {
      return false;
    }
    sourceElement.set(aClass);
    this.setupConfiguration(configuration, aClass, context);
    return true;
  }
  
  private void setupConfiguration(final ApplicationConfiguration configuration, final PsiClass aClass, final ConfigurationContext context) {
    String _runtimeQualifiedName = JavaExecutionUtil.getRuntimeQualifiedName(aClass);
    configuration.MAIN_CLASS_NAME = _runtimeQualifiedName;
    configuration.setGeneratedName();
    this.setupConfigurationModule(context, configuration);
  }
  
  @Nullable
  private static PsiMethod findMain(final PsiElement element_finalParam_) {
    PsiElement element = element_finalParam_;
    PsiMethod method = null;
    while (((method = PsiTreeUtil.<PsiMethod>getParentOfType(element, PsiMethod.class)) != null)) {
      boolean _isMainMethod = PsiMethodUtil.isMainMethod(method);
      if (_isMainMethod) {
        return method;
      } else {
        PsiElement _parent = method.getParent();
        element = _parent;
      }
    }
    return null;
  }
  
  public boolean internalIsConfigurationFromContext(final ApplicationConfiguration appConfiguration, final ConfigurationContext context) {
    final PsiElement location = context.getPsiLocation();
    final PsiClass aClass = ApplicationConfigurationType.getMainClass(location);
    boolean _and = false;
    if (!(aClass != null)) {
      _and = false;
    } else {
      String _runtimeQualifiedName = JavaExecutionUtil.getRuntimeQualifiedName(aClass);
      boolean _equal = Comparing.equal(_runtimeQualifiedName, appConfiguration.MAIN_CLASS_NAME);
      _and = _equal;
    }
    if (_and) {
      final PsiMethod method = PsiTreeUtil.<PsiMethod>getParentOfType(location, PsiMethod.class, false);
      boolean _and_1 = false;
      if (!(method != null)) {
        _and_1 = false;
      } else {
        TestFrameworks _instance = TestFrameworks.getInstance();
        boolean _isTestMethod = _instance.isTestMethod(method);
        _and_1 = _isTestMethod;
      }
      if (_and_1) {
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
      RunConfiguration _configuration = _configurationTemplate.getConfiguration();
      ApplicationConfiguration template = ((ApplicationConfiguration) _configuration);
      JavaRunConfigurationModule _configurationModule_1 = template.getConfigurationModule();
      final Module predefinedModule = _configurationModule_1.getModule();
      boolean _equal_2 = Comparing.<Module>equal(predefinedModule, configurationModule);
      if (_equal_2) {
        return true;
      }
    }
    return false;
  }
}
