/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.ui.wizard.project;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;

/**
 * @author dhuebner - Initial contribution and API
 */
public class StatusWidget extends Composite {

	private Link link;

	private Label imageLabel;

	private Procedure0 quickFix = () -> {};

	private int severity = IMessageProvider.NONE;
	
	private static final Pattern ANCHOR_PATTERN = Pattern.compile("<a>(.*)</a>");

	public StatusWidget(Composite parent, int style) {
		super(parent, style);
		createControls();
	}

	protected void createControls() {
		setLayout(new GridLayout(2, false));

		imageLabel = new Label(this, SWT.NONE);
		imageLabel.setText("   ");
		GridData imgLabelLayoutData = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
		imgLabelLayoutData.widthHint = 20;
		imageLabel.setLayoutData(imgLabelLayoutData);

		link = new Link(this, SWT.NONE);
		GridData linkLayoutData = new GridData(GridData.FILL_HORIZONTAL);
		linkLayoutData.heightHint = 40;
		link.setLayoutData(linkLayoutData);
		link.setFont(getFont());
		link.setText("\n\n\n");
		link.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				quickFix.apply();
			}
		});
	}

	public Procedure0 clearStatus() {
		return setStatus(IMessageProvider.NONE, "\n\n\n", () -> {}, () -> {});
	}
	
	public Procedure0 setStatus(int severity, String text, Procedure0 quickFix, Procedure0 callback) {
		this.severity = severity;
		setVisible(severity != IMessageProvider.NONE);
		imageLabel.setImage(imageFor(severity));
		link.setText(text);
		Matcher matcher = ANCHOR_PATTERN.matcher(text.trim());
		link.setToolTipText(matcher.replaceAll("$1"));
		this.quickFix = () -> {
			quickFix.apply();
			callback.apply();
		};
		return this.quickFix;
	}

	public Procedure0 addStatus(int severity, String text) {
		Procedure0 status = null;
		if (link.getText().trim().isEmpty()) {
			status = setStatus(severity, text, () -> {}, () -> {});
		} else {
			link.setText(link.getText() + "\n" + text);
			Matcher matcher = ANCHOR_PATTERN.matcher(text.trim());
			link.setToolTipText(matcher.replaceAll("$1"));
			if (severity > this.severity) {
				this.severity = severity;
				setVisible(severity != IMessageProvider.NONE);
				imageLabel.setImage(imageFor(severity));
			}
		}
		return status;
	}

	public int getSevertity() {
		return severity;
	}

	private Image imageFor(int type) {
		switch (type) {
			case IMessageProvider.NONE:
				return null;
			case IMessageProvider.INFORMATION:
				return JFaceResources.getImage(Dialog.DLG_IMG_MESSAGE_INFO);
			case IMessageProvider.WARNING:
				return JFaceResources.getImage(Dialog.DLG_IMG_MESSAGE_WARNING);
			case IMessageProvider.ERROR:
				return JFaceResources.getImage(Dialog.DLG_IMG_MESSAGE_ERROR);
			default:
				return null;
		}
	}
}
