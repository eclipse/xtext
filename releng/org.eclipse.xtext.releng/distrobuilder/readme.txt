What p2distro.sh do:
It installs all the IUs listed in the corresponding builder.properties into each of eclipse packages from targetplatforms folder.
If targetplatforms folder is empty it will download win32 macosx and linux packages from $ECLIPSE_DOWNLOAD site
If repositories folder does not exists it will use $REMOTE_REPOSITORIES to resolve dependencies
It compress new eclipse IDEs 
It renames file names using DISTRO_SUFFIX and VERSION property, so i.e. eclipse-SDK-3.8-macosx-cocoa-x86_64.tar.gz became eclipse-SDK-3.8-Xtext-2.0.1-macosx-cocoa-x86_64.tar.gz


How to build a juno based distro.

In eclipse /org.eclipse.xtext.releng/distrobuilder:

create ./juno folder
create ./juno/builder.properties or copy existing i.e. indigo/builder.properties
edit ECLIPSE_DOWNLOAD and REMOTE_REPOSITORIES property if necessary

push the changes with git

auto grab dependencies:
	- if ./juno/repositories does not exists, script will use ECLIPSE_REPOSITORY URLs to resolve dependencies
	- if ./juno/targetplatform does not exists or is empty, script will use ECLIPSE_DOWNLOAD URL to download tragetplatforms
manually prepare dependencies:
	-	If using hudson: Connect to kiel1 machine (sftp) path /home/hudson/build/distrobuilder
	-	If working local: use /org.eclipse.xtext.releng/distrobuilder
	Create ./juno/targetplatforms folder, copy juno packages to work with (i.e. eclipse-SDK-3.8-macosx-cocoa-x86_64.tar.gz)
	Now you can copy zipped p2.repositories that should be used during the build in ./juno/repositories, or you set REMOTE_REPOSITORIES property properly.

	
Start builder:
If you build is local, decide which eclipse should be used as p2 director you may also use your running eclipse IDE i.e. /Applications/eclipse

	-	Local: run "bash p2distro.sh juno /Application/eclipse" or use the "Create Juno distros.launch"
			first parameter is ECLIPSE_CODENAME here juno , the second is DIR_SOURCE_ECLIPSE which is optional (default is ./builder)
	-	Hudson: open https://kiel1/hudson/job/xtext-distro-builder/, start new build, select juno as ECLIPSE_CODENAME

Script will create ./juno/output folder where new distro files are located