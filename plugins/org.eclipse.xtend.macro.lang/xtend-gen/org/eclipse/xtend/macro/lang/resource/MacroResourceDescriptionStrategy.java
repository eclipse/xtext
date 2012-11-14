package org.eclipse.xtend.macro.lang.resource;

import com.google.common.collect.ImmutableMap.Builder;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.resource.XtendResourceDescriptionStrategy;
import org.eclipse.xtend.macro.lang.macro.MacroAnnotation;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

@SuppressWarnings("all")
public class MacroResourceDescriptionStrategy extends XtendResourceDescriptionStrategy {
  protected void createUserData(final EObject eObject, final Builder<String,String> userData) {
    boolean _matched = false;
    if (!_matched) {
      if (eObject instanceof MacroAnnotation) {
        final MacroAnnotation _macroAnnotation = (MacroAnnotation)eObject;
        _matched=true;
        ICompositeNode _node = NodeModelUtils.getNode(_macroAnnotation);
        String _text = _node==null?(String)null:_node.getText();
        int _hashCode = _text==null?0:_text.hashCode();
        String _plus = ("hash_" + Integer.valueOf(_hashCode));
        userData.put("hash", _plus);
      }
    }
    super.createUserData(eObject, userData);
  }
}
