/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.editor.contentassist;

import com.google.inject.ImplementedBy;

/**
 * Prefix matchers are used to reject content assist proposals that do not match the prefix at
 * the current cursor position.
 * 
 * @since 2.10
 * @noreference
 */
@ImplementedBy(IPrefixMatcher.IgnoreCase.class)
@SuppressWarnings("all")
public interface IPrefixMatcher {
  /**
   * Default prefix matcher that compares the prefix of the candidate ignoring case.
   */
  class IgnoreCase implements IPrefixMatcher {
    @Override
    public boolean isCandidateMatchingPrefix(final String name, final String prefix) {
      return name.regionMatches(true, 0, prefix, 0, prefix.length());
    }
  }
  
  boolean isCandidateMatchingPrefix(final String name, final String prefix);
}
