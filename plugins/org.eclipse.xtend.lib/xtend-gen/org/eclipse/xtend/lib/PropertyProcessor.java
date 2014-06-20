package org.eclipse.xtend.lib;

import com.google.common.annotations.Beta;
import org.eclipse.xtend.lib.GetterProcessor;
import org.eclipse.xtend.lib.SetterProcessor;
import org.eclipse.xtend.lib.macro.AbstractFieldProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * @since 2.7
 */
@Beta
@SuppressWarnings("all")
public class PropertyProcessor extends AbstractFieldProcessor {
  public void doTransform(final MutableFieldDeclaration it, @Extension final TransformationContext context) {
    @Extension
    final GetterProcessor.Util getterUtil = new GetterProcessor.Util(context);
    @Extension
    final SetterProcessor.Util setterUtil = new SetterProcessor.Util(context);
    boolean _hasGetter = getterUtil.hasGetter(it);
    boolean _not = (!_hasGetter);
    if (_not) {
      getterUtil.addGetter(it);
    }
    boolean _and = false;
    boolean _isFinal = it.isFinal();
    boolean _not_1 = (!_isFinal);
    if (!_not_1) {
      _and = false;
    } else {
      boolean _hasSetter = setterUtil.hasSetter(it);
      boolean _not_2 = (!_hasSetter);
      _and = _not_2;
    }
    if (_and) {
      setterUtil.addSetter(it);
    }
    String _simpleName = it.getSimpleName();
    String _firstLower = StringExtensions.toFirstLower(_simpleName);
    String _plus = ("_" + _firstLower);
    it.setSimpleName(_plus);
  }
}
