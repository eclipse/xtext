/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.ide;

import com.google.common.base.Objects;
import java.util.ArrayList;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalCreator;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class TestLanguageProposalCreator extends IdeContentProposalCreator {
  @Override
  public ContentAssistEntry createProposal(final String proposal, final String prefix, final ContentAssistContext context, final String kind, final Procedure1<? super ContentAssistEntry> init) {
    ContentAssistEntry _xblockexpression = null;
    {
      final ContentAssistEntry entry = super.createProposal(proposal, prefix, context, kind, init);
      if ((((entry != null) && Objects.equal(kind, ContentAssistEntry.KIND_KEYWORD)) && Objects.equal(proposal, "{"))) {
        ArrayList<ReplaceRegion> _textReplacements = entry.getTextReplacements();
        int _offset = context.getOffset();
        int _plus = (_offset + 1);
        ReplaceRegion _replaceRegion = new ReplaceRegion(_plus, 0, "}");
        _textReplacements.add(_replaceRegion);
      }
      _xblockexpression = entry;
    }
    return _xblockexpression;
  }
}
