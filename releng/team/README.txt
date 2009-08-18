This is the place where we put our development infrastructure tools.

1) Importing the workspace

In order to get a workspace, use any Eclipse IDE and import the workspace using one of the team project sets in 'projectset/'

2) creating the target platform

Execute org.eclipse.xtext.releng.MaterializeTargetPlatform.
It will download all the required target platform libraried and extract them to targetplatform/.
You'll have to point your PDE tooling to the materialized target platform, by using the 
corresponding preference page (type 'Target Platform' into the search field).
Add a new definition, start with 'nothing' and add aa 'Directory' location
pointing to ${workspace_loc}/releng/team/targetplatform/eclipse


