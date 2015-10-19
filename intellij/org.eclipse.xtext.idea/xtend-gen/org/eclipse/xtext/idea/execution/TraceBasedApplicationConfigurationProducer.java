package org.eclipse.xtext.idea.execution;

import com.google.inject.Inject;
import com.intellij.execution.actions.ConfigurationContext;
import com.intellij.execution.application.ApplicationConfiguration;
import com.intellij.execution.application.ApplicationConfigurationProducer;
import com.intellij.execution.application.ApplicationConfigurationType;
import com.intellij.openapi.util.Ref;
import com.intellij.psi.PsiElement;
import org.eclipse.xtext.idea.execution.ConfigurationProducerExtensions;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class TraceBasedApplicationConfigurationProducer extends ApplicationConfigurationProducer<ApplicationConfiguration> {
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
      return super.setupConfigurationFromContext(conf, _prepareContextFor, sourceElement);
    }
    return false;
  }
  
  @Override
  public boolean isConfigurationFromContext(final ApplicationConfiguration appConf, final ConfigurationContext context) {
    final PsiElement javaElement = this._configurationProducerExtensions.tracedJavaElement(context);
    if ((javaElement != null)) {
      ConfigurationContext _prepareContextFor = this._configurationProducerExtensions.prepareContextFor(context, javaElement);
      return super.isConfigurationFromContext(appConf, _prepareContextFor);
    }
    return false;
  }
}
