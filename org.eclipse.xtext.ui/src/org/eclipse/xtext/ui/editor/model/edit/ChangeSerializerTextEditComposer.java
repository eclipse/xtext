/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model.edit;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.ide.serializer.IEmfResourceChange;
import org.eclipse.xtext.ide.serializer.ITextDocumentChange;
import org.eclipse.xtext.ide.serializer.impl.ChangeSerializer;

import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ChangeSerializerTextEditComposer extends ChangeSerializer implements ITextEditComposer {

	private Resource recording;
	private TextEdit result;

	public ChangeSerializerTextEditComposer() {
		this.setUpdateCrossReferences(false);
		this.setUpdateRelatedFiles(false);
	}

	@Override
	public void beginRecording(Resource resource) {
		resetState();
		recording = resource;
		super.beginRecordChanges(resource);
	}

	protected void collectChanges(IEmfResourceChange e, List<TextEdit> edits) {
		if (e instanceof ITextDocumentChange && e.getResource() == recording) {
			ITextDocumentChange change = (ITextDocumentChange) e;
			for (ITextReplacement c : change.getReplacements()) {
				ReplaceEdit edit = new ReplaceEdit(c.getOffset(), c.getLength(), c.getReplacementText());
				edits.add(edit);
			}
		}
	}

	@Override
	public TextEdit endRecording() {
		if (recording == null) {
			return null;
		}
		result = endRecordingAndCompose();
		recording = null;
		return result;
	}

	protected TextEdit endRecordingAndCompose() {
		List<TextEdit> edits = Lists.newArrayList();
		super.endRecordChanges(change -> {
			collectChanges(change, edits);
		});
		if (edits.isEmpty()) {
			return null;
		}
		if (edits.size() == 1) {
			return edits.get(0);
		}
		MultiTextEdit multi = new MultiTextEdit();
		for (TextEdit e : edits) {
			multi.addChild(e);
		}
		return multi;
	}

	@Override
	public TextEdit getTextEdit() {
		return result;
	}

	@Override
	protected void resetState() {
		super.resetState();
		this.recording = null;
		this.result = null;
	}

}
