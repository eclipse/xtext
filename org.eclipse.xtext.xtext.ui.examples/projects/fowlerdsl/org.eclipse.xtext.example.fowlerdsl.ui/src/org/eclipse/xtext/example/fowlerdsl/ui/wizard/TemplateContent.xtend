/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.fowlerdsl.ui.wizard

/**
 * @author miklossy - Initial contribution and API
 */
class TemplateContent {
	
	public static val MrsGrantsSecretCompartments = '''
		events
			doorClosed  D1CL
			drawOpened  D2OP
			lightOn     L1ON
			doorOpened  D1OP
			panelClosed PNCL
		end
		
		resetEvents
			doorClosed
		end
		
		commands
			unlockPanel PNUL
			lockPanel   PNLK
			lockDoor    D1LK
			unlockDoor  D1UL
		end
		
		state idle
			actions {unlockDoor lockPanel}
			doorClosed => active
		end
		
		state active
			drawOpened => waitingForLight
			lightOn    => waitingForDraw
		end
		
		state waitingForLight
			lightOn => unlockedPanel
		end
		
		state waitingForDraw
			drawOpened => unlockedPanel
		end
		
		state unlockedPanel
			actions {unlockPanel lockDoor}
			panelClosed => idle
		end
	'''
}