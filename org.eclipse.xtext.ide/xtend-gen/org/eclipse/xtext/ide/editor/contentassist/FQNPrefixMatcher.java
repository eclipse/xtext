/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.editor.contentassist;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.ide.editor.contentassist.IPrefixMatcher;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Prefix matcher for fully qualified names.
 * 
 * @since 2.10
 * @noreference
 */
@SuppressWarnings("all")
public class FQNPrefixMatcher implements IPrefixMatcher {
  @Accessors
  @Inject
  private IPrefixMatcher.IgnoreCase delegate;
  
  @Inject
  private IQualifiedNameConverter qualifiedNameConverter;
  
  @Override
  public boolean isCandidateMatchingPrefix(final String name, final String prefix) {
    boolean _isCandidateMatchingPrefix = this.delegate.isCandidateMatchingPrefix(name, prefix);
    if (_isCandidateMatchingPrefix) {
      return true;
    }
    final String delimiter = this.getDelimiter();
    if (((!StringExtensions.isNullOrEmpty(delimiter)) && (name.indexOf(delimiter) >= 0))) {
      int _indexOf = prefix.indexOf(delimiter);
      boolean _lessThan = (_indexOf < 0);
      if (_lessThan) {
        final String lastSegment = this.getLastSegment(name, delimiter);
        if (((lastSegment != null) && this.delegate.isCandidateMatchingPrefix(lastSegment, prefix))) {
          return true;
        }
      } else {
        final List<String> splitPrefix = Strings.split(prefix, delimiter);
        boolean _isEmpty = splitPrefix.isEmpty();
        if (_isEmpty) {
          return false;
        }
        final List<String> splitName = Strings.split(name, delimiter);
        int _size = splitName.size();
        int _size_1 = splitPrefix.size();
        boolean _lessThan_1 = (_size < _size_1);
        if (_lessThan_1) {
          return false;
        }
        for (int i = 0; (i < splitPrefix.size()); i++) {
          boolean _isCandidateMatchingPrefix_1 = this.delegate.isCandidateMatchingPrefix(splitName.get(i), splitPrefix.get(i));
          boolean _not = (!_isCandidateMatchingPrefix_1);
          if (_not) {
            return false;
          }
        }
        return true;
      }
    }
    return false;
  }
  
  protected String getLastSegment(final String fqn, final String delimiter) {
    final int lastDelimIndex = fqn.lastIndexOf(delimiter);
    if (((lastDelimIndex >= 0) && ((lastDelimIndex + delimiter.length()) < fqn.length()))) {
      int _length = delimiter.length();
      int _plus = (lastDelimIndex + _length);
      return fqn.substring(_plus);
    }
    return null;
  }
  
  public String getDelimiter() {
    if ((this.qualifiedNameConverter instanceof IQualifiedNameConverter.DefaultImpl)) {
      return ((IQualifiedNameConverter.DefaultImpl)this.qualifiedNameConverter).getDelimiter();
    } else {
      return ".";
    }
  }
  
  @Pure
  public IPrefixMatcher.IgnoreCase getDelegate() {
    return this.delegate;
  }
  
  public void setDelegate(final IPrefixMatcher.IgnoreCase delegate) {
    this.delegate = delegate;
  }
}
