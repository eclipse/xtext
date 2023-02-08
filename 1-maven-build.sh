#!/usr/bin/env bash
if [ -z "$JENKINS_URL" ]; then
  # if not set in environment use default
  JENKINS_URL=https://ci.eclipse.org/xtext/
fi

# Use TARGET_PLATFORM from environment and 'r202203' as default.
# Overridable by 'tp' command-line arg
if [ -z "$TARGET_PLATFORM" ]; then
  TARGET_PLATFORM=r202203
fi

MVN_ARGS=(\
  --batch-mode \
  --update-snapshots \
  --fae \
  -Declipse.p2.mirrors=false \
  -Dtycho.disableP2Mirrors=true \
  -DJENKINS_URL=$JENKINS_URL \
  -Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=info \
)

# args parsing inspired by https://gist.github.com/jehiah/855086
while [ "$1" != "" ]; do
  PARAM=`echo $1 | awk -F= '{print $1}'`
  VALUE=`echo $1 | awk -F= '{print $2}'`
  case $PARAM in
    -h | --help)
      echo "Perform Maven build for xtext-eclipse"
      echo ""
      echo "./1-maven-build.sh"
      echo -e "\t-h --help"
      echo -e "\t--tp=$TARGET_PLATFORM (valid values: r202203,r202206,...,latest)"
      echo ""
      exit
      ;;
    --tp)
      TARGET_PLATFORM=($VALUE)
      ;;
    --no-tests)
      MVN_ARGS+=(-DskipTests=true)
      ;;
    --local-repository)
      MVN_ARGS+=(-Dmaven.repo.local="$VALUE")
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
echo "Calling Maven with ARGS: ${MVN_ARGS[@]}"

echo "Using target platform '$TARGET_PLATFORM'"
mvn \
  ${MVN_ARGS[@]} \
  $@
