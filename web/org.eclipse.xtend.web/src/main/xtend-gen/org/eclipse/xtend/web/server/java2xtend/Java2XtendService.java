package org.eclipse.xtend.web.server.java2xtend;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.xtend.core.formatting2.FormatterFacade;
import org.eclipse.xtend.core.javaconverter.JavaConverter;
import org.eclipse.xtend.web.server.java2xtend.Java2XtendResult;
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess;
import org.eclipse.xtext.xbase.lib.Exceptions;

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
    boolean _equals = Objects.equal(_xtendCode, null);
    if (_equals) {
      return new Java2XtendResult(Integer.valueOf(0), null);
    }
    String _xtrycatchfinallyexpression = null;
    try {
      String _xtendCode_1 = xtendSrc.getXtendCode();
      _xtrycatchfinallyexpression = this.formatter.format(_xtendCode_1);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        return new Java2XtendResult(Integer.valueOf(0), "");
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    String generateCode = _xtrycatchfinallyexpression;
    return new Java2XtendResult(Integer.valueOf(1), generateCode);
  }
}
