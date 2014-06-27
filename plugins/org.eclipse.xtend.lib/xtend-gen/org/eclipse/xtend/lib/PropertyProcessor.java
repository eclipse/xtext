package org.eclipse.xtend.lib;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
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
@GwtCompatible
@SuppressWarnings("all")
public class PropertyProcessor extends AbstractFieldProcessor {
  public void doTransform(final MutableFieldDeclaration it, @Extension final TransformationContext context) {
    @Extension
    final GetterProcessor.Util getterUtil = new GetterProcessor.Util(context);
    @Extension
    final SetterProcessor.Util setterUtil = new SetterProcessor.Util(context);
    boolean _and = false;
    boolean _hasGetter = getterUtil.hasGetter(it);
    boolean _not = (!_hasGetter);
    if (!_not) {
      _and = false;
    } else {
      boolean _canAddGetter = getterUtil.canAddGetter(it);
      _and = _canAddGetter;
    }
    if (_and) {
      getterUtil.addGetter(it);
    }
    boolean _and_1 = false;
    boolean _and_2 = false;
    boolean _isFinal = it.isFinal();
    boolean _not_1 = (!_isFinal);
    if (!_not_1) {
      _and_2 = false;
    } else {
      boolean _hasSetter = setterUtil.hasSetter(it);
      boolean _not_2 = (!_hasSetter);
      _and_2 = _not_2;
    }
    if (!_and_2) {
      _and_1 = false;
    } else {
      boolean _canAddSetter = setterUtil.canAddSetter(it);
      _and_1 = _canAddSetter;
    }
    if (_and_1) {
      setterUtil.addSetter(it);
    }
    String _simpleName = it.getSimpleName();
    String _firstLower = StringExtensions.toFirstLower(_simpleName);
    String _plus = ("_" + _firstLower);
    it.setSimpleName(_plus);
  }
}
