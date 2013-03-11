package bootstrap;

import com.google.inject.Inject;
import java.util.HashSet;
import org.apache.log4j.Logger;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xdoc.generator.util.GitExtensions;
import org.eclipse.xtext.xdoc.generator.util.JavaDocExtension;

@SuppressWarnings("all")
public class CodeRefs {
  private final static Logger LOG = new Function0<Logger>() {
    public Logger apply() {
      Logger _logger = Logger.getLogger(CodeRefs.class);
      return _logger;
    }
  }.apply();
  
  @Inject
  @Extension
  private GitExtensions _gitExtensions;
  
  @Inject
  @Extension
  private JavaDocExtension _javaDocExtension;
  
  private final static HashSet<String> NO_JAVADOC_PACKAGE_PREFIXES = new Function0<HashSet<String>>() {
    public HashSet<String> apply() {
      HashSet<String> _newHashSet = CollectionLiterals.<String>newHashSet("org.xtext.");
      return _newHashSet;
    }
  }.apply();
  
  private final static HashSet<String> NO_SOURCE_PACKAGE_PREFIXES = new Function0<HashSet<String>>() {
    public HashSet<String> apply() {
      HashSet<String> _newHashSet = CollectionLiterals.<String>newHashSet("java.", "org.eclipse.", "javax.", "com.mongodb.", "com.google.", "org.junit.");
      return _newHashSet;
    }
  }.apply();
  
  public String getJavaDocURI(final JvmIdentifiableElement element) {
    String _xblockexpression = null;
    {
      final String uri = this._javaDocExtension.genJavaDocLink(element);
      boolean _and = false;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(uri);
      if (!_isNullOrEmpty) {
        _and = false;
      } else {
        final Function1<String,Boolean> _function = new Function1<String,Boolean>() {
            public Boolean apply(final String it) {
              boolean _xblockexpression = false;
              {
                final String identifier = element==null?(String)null:element.getIdentifier();
                boolean _and = false;
                boolean _notEquals = ObjectExtensions.operator_notEquals(identifier, null);
                if (!_notEquals) {
                  _and = false;
                } else {
                  boolean _startsWith = identifier.startsWith(it);
                  _and = (_notEquals && _startsWith);
                }
                _xblockexpression = (_and);
              }
              return Boolean.valueOf(_xblockexpression);
            }
          };
        boolean _exists = IterableExtensions.<String>exists(CodeRefs.NO_JAVADOC_PACKAGE_PREFIXES, _function);
        boolean _not = (!_exists);
        _and = (_isNullOrEmpty && _not);
      }
      if (_and) {
        String _identifier = element.getIdentifier();
        String _plus = ("Missing JavaDoc link for " + _identifier);
        CodeRefs.LOG.error(_plus);
        return null;
      }
      _xblockexpression = (uri);
    }
    return _xblockexpression;
  }
  
  public String getSourceCodeURI(final JvmIdentifiableElement element) {
    String _xblockexpression = null;
    {
      final String uri = this._gitExtensions.gitLink(element);
      boolean _and = false;
      boolean _and_1 = false;
      boolean _or = false;
      boolean _equals = ObjectExtensions.operator_equals(uri, null);
      if (_equals) {
        _or = true;
      } else {
        boolean _contains = uri.contains("broken-link");
        _or = (_equals || _contains);
      }
      if (!_or) {
        _and_1 = false;
      } else {
        String _identifier = element.getIdentifier();
        boolean _notEquals = ObjectExtensions.operator_notEquals(_identifier, null);
        _and_1 = (_or && _notEquals);
      }
      if (!_and_1) {
        _and = false;
      } else {
        final Function1<String,Boolean> _function = new Function1<String,Boolean>() {
            public Boolean apply(final String it) {
              String _identifier = element.getIdentifier();
              boolean _startsWith = _identifier.startsWith(it);
              return Boolean.valueOf(_startsWith);
            }
          };
        boolean _exists = IterableExtensions.<String>exists(CodeRefs.NO_SOURCE_PACKAGE_PREFIXES, _function);
        boolean _not = (!_exists);
        _and = (_and_1 && _not);
      }
      if (_and) {
        String _identifier_1 = element.getIdentifier();
        String _plus = ("Missing source link for " + _identifier_1);
        CodeRefs.LOG.error(_plus);
        return null;
      }
      _xblockexpression = (uri);
    }
    return _xblockexpression;
  }
}
