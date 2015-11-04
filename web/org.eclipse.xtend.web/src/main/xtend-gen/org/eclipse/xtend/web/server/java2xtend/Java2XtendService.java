package org.eclipse.xtend.web.server.java2xtend;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.xtend.core.formatting2.FormatterFacade;
import org.eclipse.xtend.core.javaconverter.JavaConverter;
import org.eclipse.xtend.web.server.java2xtend.Java2XtendResult;
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@Singleton
@SuppressWarnings("all")
public class Java2XtendService {
  @Inject
  private JavaConverter javaConverter;
  
  @Inject
  private FormatterFacade formatter;
  
  public Java2XtendResult generate(final String javaSrc, final XtextWebDocumentAccess document) {
    final JavaConverter.ConversionResult xtendSrc = this.javaConverter.toXtend("Clazz", javaSrc);
    boolean _or = false;
    String _xtendCode = xtendSrc.getXtendCode();
    boolean _equals = Objects.equal(_xtendCode, null);
    if (_equals) {
      _or = true;
    } else {
      Iterable<String> _problems = xtendSrc.getProblems();
      int _size = IterableExtensions.size(_problems);
      boolean _greaterThan = (_size > 0);
      _or = _greaterThan;
    }
    if (_or) {
      return new Java2XtendResult(Integer.valueOf(0), null);
    }
    String _xtendCode_1 = xtendSrc.getXtendCode();
    String _format = this.formatter.format(_xtendCode_1);
    return new Java2XtendResult(Integer.valueOf(1), _format);
  }
}
