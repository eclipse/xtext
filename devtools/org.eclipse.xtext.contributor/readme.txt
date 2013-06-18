How to use.

1. Run the ant script located here http://git.eclipse.org/c/tmf/org.eclipse.xtext.git/plain/devtools/org.eclipse.xtext.contributor/workspace.ant 
	Unix console: wget -N http://git.eclipse.org/c/tmf/org.eclipse.xtext.git/plain/devtools/org.eclipse.xtext.contributor/workspace.ant; ant -f workspace.ant

2. Download and start eclipse DSL package, choose ${user.home}/workspaces/xtext-sources as eclipse workspace

3. In package explorer view menu select "Top level elements -> Working sets"

4. Select File -> Import -> Team -> Team Project Set.
	Point to the following URL http://git.eclipse.org/c/tmf/org.eclipse.xtext.git/plain/devtools/org.eclipse.xtext.contributor/projectSet.psf
	Push finish button

5. (Optional) If you would like to push to gerrit please follow steps described here: http://wiki.eclipse.org/Gerrit#SSH_Keys