package bootstrap;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.HashSet;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xdoc.generator.util.GitExtensions;
import org.eclipse.xtext.xdoc.generator.util.JavaDocExtension;

@SuppressWarnings("all")
public class CodeRefs {
  @Inject
  private GitExtensions _gitExtensions;
  
  @Inject
  private JavaDocExtension _javaDocExtension;
  
  private final static HashSet<String> NO_SOURCE_PACKAGES = new Function0<HashSet<String>>() {
    public HashSet<String> apply() {
      HashSet<String> _newHashSet = CollectionLiterals.<String>newHashSet("java.", "org.eclipse.", "javax.", "com.mongodb.");
      return _newHashSet;
    }
  }.apply();
  
  public String getJavaDocURI(final JvmIdentifiableElement element) {
    String _xblockexpression = null;
    {
      final String uri = this._javaDocExtension.genJavaDocLink(element);
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(uri);
      if (_isNullOrEmpty) {
        String _identifier = element.getIdentifier();
        String _plus = ("Missing JavaDoc link for " + _identifier);
        InputOutput.<String>println(_plus);
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
      boolean _or = false;
      boolean _equals = Objects.equal(uri, null);
      if (_equals) {
        _or = true;
      } else {
        boolean _contains = uri.contains("broken-link");
        _or = (_equals || _contains);
      }
      if (!_or) {
        _and = false;
      } else {
        final Function1<String,Boolean> _function = new Function1<String,Boolean>() {
            public Boolean apply(final String it) {
              String _identifier = element.getIdentifier();
              boolean _startsWith = _identifier.startsWith(it);
              return Boolean.valueOf(_startsWith);
            }
          };
        boolean _exists = IterableExtensions.<String>exists(CodeRefs.NO_SOURCE_PACKAGES, _function);
        boolean _not = (!_exists);
        _and = (_or && _not);
      }
      if (_and) {
        String _identifier = element.getIdentifier();
        String _plus = ("Missing source link for " + _identifier);
        InputOutput.<String>println(_plus);
        return null;
      }
      _xblockexpression = (uri);
    }
    return _xblockexpression;
  }
}
