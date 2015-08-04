#!/bin/bash
cd `dirname $0` #change to p2distro.sh parent directory


DIR_ROOT=$PWD # PWD is the working directory var

#Parameters (first parameter ECLIPSE_CODENAME, second DIR_SOURCE_ECLIPSE (optional))
DIR_SOURCE_ECLIPSE=$2        # eclipse to build with (optional) default "$DIR_ROOT/builder"
if [ ! $2 ]
then
DIR_SOURCE_ECLIPSE="$DIR_ROOT/builder"
fi
echo "Using eclipse from $DIR_SOURCE_ECLIPSE"
set -u #unseted variables assertion
ECLIPSE_CODENAME=$1            #i.e. indigo

# Constants
DIR_TARGETPLATFORMS="$DIR_ROOT/$ECLIPSE_CODENAME/targetplatforms"		# platform depended eclipses where feature should be installed
DIR_OUTPUT="$DIR_ROOT/$ECLIPSE_CODENAME/output"							# produced distros folder
DIR_TMP="$DIR_ROOT/$ECLIPSE_CODENAME/tmp"								# temp folder
DIR_REPOSITORIES="$DIR_ROOT/$ECLIPSE_CODENAME/repositories"			 	# local zipped repositories to be used
DIR_LOCAL_REPO="$DIR_ROOT/$ECLIPSE_CODENAME/local-repo/final"           # local b3 aggregated repo

IDEPREFIX="eclipse-dsl"
ZIPSUFFIX=".zip"
JARSUFFIX=".jar"

function var.defined {
	eval '[[ ${!'$1'[@]} ]]'
}

# reads property from $ECLIPSE_CODENAME.properties file and set it as global var. Exp.: parseProperty VERSION
function parseProperty()
{
if var.defined $1
then
	eval 'echo '$1 is already set to \$$1''
else
local __propertyName=$1
local parsedValue=`sed '/^\#/d' $ECLIPSE_CODENAME/builder.properties | grep $__propertyName  | tail -n 1 | cut -d "=" -f2- | sed 's/^[[:space:]]*//;s/[[:space:]]*$//'`
echo "setting parsed value: $__propertyName = $parsedValue"
eval $__propertyName="'$parsedValue'"
fi
}

#read properties
parseProperty DISTRO_SUFFIX
parseProperty REMOTE_REPOSITORIES
parseProperty VERSION

#Add local aggregator repo
REMOTE_REPOSITORIES="$REMOTE_REPOSITORIES,file:///$DIR_LOCAL_REPO"

echo "
Building $ECLIPSE_CODENAME for $DISTRO_SUFFIX $VERSION
"

parseProperty ADDITIONAL_IUS
echo "additional tools parsed: $ADDITIONAL_IUS"

parseProperty INSTALL_IUS

INSTALL_IUS="$INSTALL_IUS,$ADDITIONAL_IUS"
echo "IUs to install parsed:"
echo "$INSTALL_IUS"|sed -e 's/\,/\
/g'

SEDEXPRESSION="s/^$IDEPREFIX-\([0-9\.]*\)\([^-]*\)-\(.*\)/$IDEPREFIX-\1\2-$DISTRO_SUFFIX-$VERSION\2-\3/"

# uncompress to tmp folder
# USAGE: uncompress file [ todir ]
function uncompress()
{
if [[ "$1" == *"$ZIPSUFFIX" ]] || [[ "$1" == *"$JARSUFFIX" ]]
then
unzip -q -d "$2" "$1"
else
tar xzf "$1" -C "$2"
fi
}

function compress()
{
if [[ "$1" == *"$ZIPSUFFIX" ]]
then
zip -q -r "$1" "$2"
else
tar czf "$1" "$2"
fi
}


# Create dirs
echo "creating directories..."
mkdir -pv $DIR_TMP $DIR_OUTPUT
echo "mkdir: finished"
#Clean output dir
echo "clean: output folder"
rm -r $DIR_OUTPUT/*
echo "clean: finished"

#collect repos
if [[ -d "$DIR_REPOSITORIES" ]]
then 
	cd $DIR_REPOSITORIES
	# we are in $DIR_REPOSITORIES now
	i=0
	repository_urls=""
	for file in *
	do
        if [[ "$file" == *".zip" ]] # only update zips
        then
        echo "adding repository $file"
        #jar:file:/Users/huebner/Downloads/emft-mwe-Update-1.0.0RC2.zip!/
        fqn="jar:file:$DIR_REPOSITORIES/$file!/"
            if [[ $i == 0 ]]
            then
                repository_urls="$REMOTE_REPOSITORIES,$fqn"
            else
                repository_urls="$repository_urls,$fqn"
            fi
        i=$i+1
        fi
	done
else
	repository_urls="$REMOTE_REPOSITORIES"
	echo "zipped repositories folder is empty... using $REMOTE_REPOSITORIES urls"
fi

cd $DIR_ROOT
# we are in root now

parseProperty DOWNLOAD_FTP_HOST
parseProperty DOWNLOAD_FTP_PATH
ECLIPSE_DOWNLOAD="ftp://$DOWNLOAD_FTP_HOST/$DOWNLOAD_FTP_PATH"

# uncompress ides
if [[ -d "$DIR_TARGETPLATFORMS" && "$(ls -A $DIR_TARGETPLATFORMS)" ]]
then
    echo "Using local targetplatforms folder"
else
    echo "$DIR_TARGETPLATFORMS does not exists. It will be created.
target platforms will be downloaded from $ECLIPSE_DOWNLOAD"
   mkdir -p $DIR_TARGETPLATFORMS
   cd $DIR_TARGETPLATFORMS
    #FTP download
    echo "$ECLIPSE_DOWNLOAD"
   ftp -n <<ENDFTP
   prompt off
   open $DOWNLOAD_FTP_HOST
   user anonymous anonymous
   bin
   cd $DOWNLOAD_FTP_PATH
   lcd $DIR_TARGETPLATFORMS
   mget eclipse-dsl-$ECLIPSE_CODENAME-*-win*.zip
   mget eclipse-dsl-$ECLIPSE_CODENAME-*-linux-gtk.tar.gz
   mget eclipse-dsl-$ECLIPSE_CODENAME-*-linux-gtk-x86_64.tar.gz
   mget eclipse-dsl-$ECLIPSE_CODENAME-*-macosx-cocoa*.gz
ENDFTP
fi

cd $DIR_TARGETPLATFORMS
echo "Start building..."
# we are in $DIR_TARGETPLATFORMS now
for file in *
do
if [[ "$file" == *"$IDEPREFIX"* ]] # only ide
then
echo ""
echo "processing $file"
echo "uncompress $file to $DIR_TMP"
uncompress "$file" "$DIR_TMP/"

echo "Starting p2 director..."
ECLIPSE_ROOT="eclipse"
ECLIPSE_INSTALL_LOCATION="eclipse"
if [[ "$file" == *"macosx-cocoa"* ]] # Other root for mars macosx
then
ECLIPSE_ROOT="Eclipse.app"
ECLIPSE_INSTALL_LOCATION="Eclipse.app/Contents/Eclipse"
fi

$DIR_SOURCE_ECLIPSE/eclipse -nosplash -application org.eclipse.equinox.p2.director -consoleLog -repository $repository_urls \
-installIU $INSTALL_IUS -destination $DIR_TMP/$ECLIPSE_INSTALL_LOCATION -profile epp.package.dsl \
-profileProperties org.eclipse.update.install.features=true
if [[ $? == 0 ]]
then
    echo "installing done... exit code: $?"
else
    echo "installing failed... exit code: $?"
    rm -r $DIR_TMP
    exit 1
fi

# add distro suffix into filename
renamed=`echo $file` # was `echo $file | sed $SEDEXPRESSION`
cd $DIR_TMP
# we are in $DIR_TMP now
echo "compressing in $renamed"
compress $renamed $ECLIPSE_ROOT
echo "moving $renamed in $DIR_OUTPUT"
mv $renamed $DIR_OUTPUT
echo "cleaning up tmp folder..."
rm -r *
cd $DIR_TARGETPLATFORMS
# we are in $DIR_TARGETPLATFORMS again
fi
done
# we are stil in $DIR_TARGETPLATFORMS
rm -r $DIR_TMP
echo "Done..."
exit 0