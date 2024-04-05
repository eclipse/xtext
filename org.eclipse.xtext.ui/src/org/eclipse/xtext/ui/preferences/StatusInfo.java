/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0 
 *******************************************************************************/
package org.eclipse.xtext.ui.preferences;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;

/**
 * Initially copied from Jdt.
 * 
 * @author Michael Clay
 * @since 2.1
 */
public class StatusInfo implements IStatus {

	public static final IStatus OK_STATUS = new StatusInfo();

	private String fStatusMessage;
	private int fSeverity;

	public StatusInfo() {
		this(OK, null);
	}

	public StatusInfo(int severity, String message) {
		fStatusMessage = message;
		fSeverity = severity;
	}

	@Override
	public boolean isOK() {
		return fSeverity == IStatus.OK;
	}

	public boolean isWarning() {
		return fSeverity == IStatus.WARNING;
	}

	public boolean isInfo() {
		return fSeverity == IStatus.INFO;
	}

	public boolean isError() {
		return fSeverity == IStatus.ERROR;
	}

	@Override
	public String getMessage() {
		return fStatusMessage;
	}

	public void setError(String errorMessage) {
		Assert.isNotNull(errorMessage);
		fStatusMessage = errorMessage;
		fSeverity = IStatus.ERROR;
	}

	public void setWarning(String warningMessage) {
		Assert.isNotNull(warningMessage);
		fStatusMessage = warningMessage;
		fSeverity = IStatus.WARNING;
	}

	public void setInfo(String infoMessage) {
		Assert.isNotNull(infoMessage);
		fStatusMessage = infoMessage;
		fSeverity = IStatus.INFO;
	}

	public void setOK() {
		fStatusMessage = null;
		fSeverity = IStatus.OK;
	}

	@Override
	public boolean matches(int severityMask) {
		return (fSeverity & severityMask) != 0;
	}

	@Override
	public boolean isMultiStatus() {
		return false;
	}

	@Override
	public int getSeverity() {
		return fSeverity;
	}

	@Override
	public String getPlugin() {
		//FIXME pull from DefaultuiModule
		return "org.eclipse.xtext.ui";
	}

	@Override
	public Throwable getException() {
		return null;
	}

	@Override
	public int getCode() {
		return fSeverity;
	}

	@Override
	public IStatus[] getChildren() {
		return new IStatus[0];
	}

	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("StatusInfo "); //$NON-NLS-1$
		if (fSeverity == OK) {
			buf.append("OK"); //$NON-NLS-1$
		} else if (fSeverity == ERROR) {
			buf.append("ERROR"); //$NON-NLS-1$
		} else if (fSeverity == WARNING) {
			buf.append("WARNING"); //$NON-NLS-1$
		} else if (fSeverity == INFO) {
			buf.append("INFO"); //$NON-NLS-1$
		} else {
			buf.append("severity="); //$NON-NLS-1$
			buf.append(fSeverity);
		}
		buf.append(": "); //$NON-NLS-1$
		buf.append(fStatusMessage);
		return buf.toString();
	}
}
