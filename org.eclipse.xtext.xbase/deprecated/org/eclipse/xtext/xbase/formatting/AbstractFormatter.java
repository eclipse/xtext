/*******************************************************************************
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.formatting;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

import com.google.common.base.Objects;

/**
 * @deprecated use {@link AbstractFormatter2}
 */
@Deprecated
public abstract class AbstractFormatter implements IBasicFormatter {
	private boolean allowIdentityEdits = false;

	private boolean diagnoseConflicts = true;

	private boolean conflictOccurred = false;

	@Override
	public List<TextReplacement> format(XtextResource res, int offset, int length, FormattingPreferenceValues cfg) {
		String doc = res.getParseResult().getRootNode().getText();
		FormattableDocument format = new FormattableDocument(cfg, doc);
		format(IterableExtensions.<EObject>head(res.getContents()), format);
		if (diagnoseConflicts && format.isConflictOccurred()) {
			FormattableDocument debug = new FormattableDocument(cfg, doc);
			debug.setRootTrace(new RuntimeException());
			this.format(IterableExtensions.head(res.getContents()), debug);
		}
		conflictOccurred = format.isConflictOccurred();
		List<TextReplacement> edits = format.renderToEdits(offset, length);
		if (allowIdentityEdits) {
			return edits;
		} else {
			return IterableExtensions.toList(IterableExtensions.filter(edits, (TextReplacement it) -> {
				return !Objects.equal(doc.substring(it.getOffset(), (it.getOffset() + it.getLength())), it.getText());
			}));
		}
	}

	public boolean isConflictOccurred() {
		return conflictOccurred;
	}

	protected void _format(Void expr, FormattableDocument format) {
	}

	protected void _format(EObject expr, FormattableDocument format) {
	}

	protected void format(EObject expr, FormattableDocument format) {
		if (expr != null) {
			_format(expr, format);
		} else if (expr == null) {
			_format((Void) null, format);
		}
	}

	@Pure
	public boolean isAllowIdentityEdits() {
		return this.allowIdentityEdits;
	}

	public void setAllowIdentityEdits(boolean allowIdentityEdits) {
		this.allowIdentityEdits = allowIdentityEdits;
	}

	@Pure
	public boolean isDiagnoseConflicts() {
		return this.diagnoseConflicts;
	}

	public void setDiagnoseConflicts(boolean diagnoseConflicts) {
		this.diagnoseConflicts = diagnoseConflicts;
	}
}
