Start a new Eclipse Application and create an empty Java project.
Add new source folder called "src-gen/" and put the following statemachine into a file in the "src/" folder.

// MrsGrantsSecretCompartments.statemachine

events
	doorClosed	D1CL
	drawOpened	D2OP
	lightOn		L1ON
	doorOpened	D1OP
	panelClosed PNCL
end

resetEvents
	doorClosed
end

commands
	unlockPanel PNUL
	lockPanel	PNLK
	lockDoor	D1LK
	unlockDoor	D1UL
end

state idle
	actions {unlockDoor lockPanel}
	doorClosed => active
end

state active
	drawOpened 	=> waitingForLight
	lightOn		=> waitingForDraw
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