/*******************************************************************************
 * @license
 * Copyright (c) 2011, 2013 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 
 * (http://www.eclipse.org/legal/epl-v10.html), and the Eclipse Distribution 
 * License v1.0 (http://www.eclipse.org/org/documents/edl-v10.html). 
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 ******************************************************************************/
/*eslint-env browser, amd*/
define("orion/editor/editorFeatures", [ //$NON-NLS-0$
	'orion/editor/factories', //$NON-NLS-0$
	'orion/editor/actions', //$NON-NLS-0$
	'orion/editor/linkedMode', //$NON-NLS-0$
	'orion/objects' //$NON-NLS-0$
], function(mFactories, mActions, mLinkedMode, objects) {
	return objects.mixin({}, mFactories, mActions, mLinkedMode);
});
