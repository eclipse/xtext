package org.eclipse.xtend.web.server.java2xtend;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.xtend.core.formatting2.FormatterFacade;
import org.eclipse.xtend.core.javaconverter.JavaConverter;
import org.eclipse.xtend.web.server.java2xtend.Java2XtendResult;
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess;

@Singleton
@SuppressWarnings("all")
public class Java2XtendService {
  @Inject
  private JavaConverter javaConverter;
  
  @Inject
  private FormatterFacade formatter;
  
  public Java2XtendResult generate(final String javaSrc, final XtextWebDocumentAccess document) {
    final JavaConverter.ConversionResult xtendSrc = this.javaConverter.toXtend("Clazz", javaSrc);
    String _xtendCode = xtendSrc.getXtendCode();
    String _format = this.formatter.format(_xtendCode);
    return new Java2XtendResult(_format);
  }
}
