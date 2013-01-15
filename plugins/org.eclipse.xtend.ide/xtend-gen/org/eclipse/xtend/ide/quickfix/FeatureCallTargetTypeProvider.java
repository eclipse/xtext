/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.quickfix;

import com.google.inject.Inject;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.typing.ITypeProvider;

/**
 * @author Sebastian Benz - Initial contribution and API
 */
@SuppressWarnings("all")
public class FeatureCallTargetTypeProvider {
  @Inject
  private ITypeProvider _iTypeProvider;
  
  public JvmType targetType(final XMemberFeatureCall featureCall) {
    JvmIdentifiableElement _targetFeature = this.targetFeature(featureCall);
    JvmTypeReference _typeForIdentifiable = _targetFeature==null?(JvmTypeReference)null:this._iTypeProvider.getTypeForIdentifiable(_targetFeature);
    JvmType _type = _typeForIdentifiable==null?(JvmType)null:_typeForIdentifiable.getType();
    return _type;
  }
  
  protected JvmIdentifiableElement targetFeature(final XMemberFeatureCall featureCall) {
    JvmIdentifiableElement _xblockexpression = null;
    {
      final XExpression memberCallTarget = featureCall.getMemberCallTarget();
      if ((memberCallTarget instanceof XConstructorCall)) {
        JvmConstructor _constructor = ((XConstructorCall) memberCallTarget).getConstructor();
        return _constructor==null?(JvmDeclaredType)null:_constructor.getDeclaringType();
      }
      boolean _not = (!(memberCallTarget instanceof XAbstractFeatureCall));
      if (_not) {
        return null;
      }
      JvmIdentifiableElement _feature = ((XAbstractFeatureCall) memberCallTarget).getFeature();
      _xblockexpression = (_feature);
    }
    return _xblockexpression;
  }
}
