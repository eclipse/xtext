#!/usr/bin/env bash
if [ -z "$JENKINS_URL" ]; then
  # if not set in environment use default
  JENKINS_URL=https://ci.eclipse.org/xtext/
fi

# Use TARGET_PLATFORM from environment and 'oxygen' as default.
# Overridable by 'tp' command-line arg
if [ -z "$TARGET_PLATFORM" ]; then
  TARGET_PLATFORM=oxygen
fi

MVN_ARGS=(\
  --update-snapshots \
  --fae \
  -Dmaven.test.failure.ignore=true \
  -Declipse.p2.mirrors=false \
  -DJENKINS_URL=$JENKINS_URL \
  -Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=warn \
)

# args parsing inspired by https://gist.github.com/jehiah/855086
while [ "$1" != "" ]; do
  PARAM=`echo $1 | awk -F= '{print $1}'`
  VALUE=`echo $1 | awk -F= '{print $2}'`
  case $PARAM in
    -h | --help)
      echo "Perform Maven build for xtext-xtend"
      echo ""
      echo "./1-maven-build.sh"
      echo -e "\t-h --help"
      echo -e "\t--no-tests Skip test execution"
      echo -e "\t--local-repository=<PATH> Use local Maven repository"
      echo -e "\t--tp=$TARGET_PLATFORM (valid values: oxygen,photon,r201809,r201812,latest)"
      echo ""
      exit
      ;;
    --no-tests)
      MVN_ARGS+=(-DskipTests=true)
      ;;
    --local-repository)
      MVN_ARGS+=" -Dmaven.repo.local=$VALUE"
      ;;
    --tp)
      TARGET_PLATFORM=($VALUE)
      ;;
    *)
      # append any additionally passed arg
      if [ -z "$VALUE" ]; then
        MVN_ARGS+=($PARAM)
      else
        MVN_ARGS+=($PARAM=$VALUE)
      fi
      ;;
  esac
  shift
done

MVN_ARGS+=(-P$TARGET_PLATFORM)
echo mvn -B -f tycho-pom.xml ${MVN_ARGS[@]} $@

echo "Using target platform '$TARGET_PLATFORM'"
mvn -B \
  -f tycho-pom.xml \
  ${MVN_ARGS[@]} \
  $@
