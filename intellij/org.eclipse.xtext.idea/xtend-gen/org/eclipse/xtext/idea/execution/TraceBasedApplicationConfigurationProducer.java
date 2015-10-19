package org.eclipse.xtext.idea.execution;

import com.google.inject.Inject;
import com.intellij.execution.actions.ConfigurationContext;
import com.intellij.execution.application.ApplicationConfiguration;
import com.intellij.execution.application.ApplicationConfigurationProducer;
import com.intellij.openapi.util.Ref;
import com.intellij.psi.PsiElement;
import org.eclipse.xtext.idea.execution.ConfigurationProducerExtensions;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class TraceBasedApplicationConfigurationProducer /* extends ApplicationConfigurationProducer<ApplicationConfiguration>  */{
  @Inject
  @Extension
  private ConfigurationProducerExtensions _configurationProducerExtensions;
  
  public TraceBasedApplicationConfigurationProducer(final IXtextLanguage xtextLanguage) {
    throw new Error("Unresolved compilation problems:"
      + "\nInvalid number of arguments. The constructor ApplicationConfigurationProducer() is not applicable for the arguments (ApplicationConfigurationType)");
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
