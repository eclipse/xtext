package org.eclipse.xtend.lib;

import com.google.common.annotations.Beta;
import org.eclipse.xtend.lib.macro.AbstractFieldProcessor;
import org.eclipse.xtend.lib.macro.CommonQueries;
import org.eclipse.xtend.lib.macro.CommonTransformations;
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
    final CommonTransformations transformations = new CommonTransformations(context);
    boolean _hasGetter = CommonQueries.hasGetter(it);
    boolean _not = (!_hasGetter);
    if (_not) {
      transformations.addGetter(it);
    }
    boolean _and = false;
    boolean _isFinal = it.isFinal();
    boolean _not_1 = (!_isFinal);
    if (!_not_1) {
      _and = false;
    } else {
      boolean _hasSetter = CommonQueries.hasSetter(it);
      boolean _not_2 = (!_hasSetter);
      _and = _not_2;
    }
    if (_and) {
      transformations.addSetter(it);
    }
    String _simpleName = it.getSimpleName();
    String _firstLower = StringExtensions.toFirstLower(_simpleName);
    String _plus = ("_" + _firstLower);
    it.setSimpleName(_plus);
  }
}
