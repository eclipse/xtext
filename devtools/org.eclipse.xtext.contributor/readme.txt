How to use.

1. Run the ant script located here http://git.eclipse.org/c/tmf/org.eclipse.xtext.git/plain/devtools/org.eclipse.xtext.contributor/workspace.ant 
	Unix console: wget -N http://git.eclipse.org/c/tmf/org.eclipse.xtext.git/plain/devtools/org.eclipse.xtext.contributor/workspace.ant; ant -f workspace.ant

2. Download and start eclipse DSL package, choose ${user.home}/workspaces/xtext-sources as eclipse workspace

3. (Optional) Setup working sets:
	a) In package explorer view menu select "Top level elements -> Working sets"
	b) Select File -> Import -> Team -> Team Project Set.
	c) Point to the following URL http://git.eclipse.org/c/tmf/org.eclipse.xtext.git/plain/devtools/org.eclipse.xtext.contributor/projectSet.psf
	d) Perform import

5. (Optional) Pushing changes to gerrit.
	a) create an eclipse/bugzilla user account. Please see http://wiki.eclipse.org/Gerrit#User_Account
	b) Follow steps described here: http://wiki.eclipse.org/Gerrit#SSH_Keys
	c) After that you should be able to push to gerrit 