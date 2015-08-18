/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.completion;

import com.intellij.codeInsight.completion.JavaPsiClassReferenceElement;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementWeigher;
import org.eclipse.xtext.idea.completion.AbstractCompletionContributor;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XbaseLookupElementWeigher extends LookupElementWeigher {
  public enum LookupElementKind {
    DEFAULT,
    
    KEYWORD,
    
    JAVA_TYPE;
  }
  
  public XbaseLookupElementWeigher() {
    super("xbaseWeigher");
  }
  
  @Override
  public XbaseLookupElementWeigher.LookupElementKind weigh(final LookupElement element) {
    XbaseLookupElementWeigher.LookupElementKind _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (element instanceof AbstractCompletionContributor.KeywordLookupElement) {
        _matched=true;
        _switchResult = XbaseLookupElementWeigher.LookupElementKind.KEYWORD;
      }
    }
    if (!_matched) {
      if (element instanceof JavaPsiClassReferenceElement) {
        _matched=true;
        _switchResult = XbaseLookupElementWeigher.LookupElementKind.JAVA_TYPE;
      }
    }
    if (!_matched) {
      _switchResult = XbaseLookupElementWeigher.LookupElementKind.DEFAULT;
    }
    return _switchResult;
  }
}
