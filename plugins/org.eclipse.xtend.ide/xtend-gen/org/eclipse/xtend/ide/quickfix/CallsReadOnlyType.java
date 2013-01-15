/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.quickfix;

import com.google.inject.Inject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.xtend.ide.quickfix.FeatureCallTargetTypeProvider;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder;
import org.eclipse.xtext.xbase.XMemberFeatureCall;

@SuppressWarnings("all")
public class CallsReadOnlyType {
  private IJavaElementFinder elementFinder;
  
  private FeatureCallTargetTypeProvider targetTypeProvider;
  
  @Inject
  public CallsReadOnlyType(final IJavaElementFinder elementFinder, final FeatureCallTargetTypeProvider targetTypeProvider) {
    this.elementFinder = elementFinder;
    this.targetTypeProvider = targetTypeProvider;
  }
  
  public boolean receiverIsReadOnly(final XMemberFeatureCall featureCall) {
    JvmType _targetType = this.targetTypeProvider.targetType(featureCall);
    IJavaElement _targetJavaElement = _targetType==null?(IJavaElement)null:this.targetJavaElement(_targetType);
    return _targetJavaElement==null?false:_targetJavaElement.isReadOnly();
  }
  
  protected IJavaElement targetJavaElement(final JvmType type) {
    IJavaElement _findElementFor = this.elementFinder.findElementFor(type);
    return _findElementFor;
  }
}
