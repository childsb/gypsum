#! /bin/sh

osxBuild(){
	unamestr=`uname`
    echo "Running osx build..."
	# INCLUDEPATH=/System/Library/Frameworks/JavaVM.framework/Versions/Current/Headers
    # COPTS="-D_SAFE -std=c99 -fnested-functions "
    #libName=posix_Process.jnilib  // this is for native library loading and not absolute. 
    libName="posix_Process.so"
    dest="lib/${unamestr}"
    mkdir -p $dest
    
    gcc -I/System/Library/Frameworks/JavaVM.framework/Versions/A/Headers/ -I/System/Library/Frameworks/JavaVM.framework/Versions/Current/Headers -c src/main/c/posix_Process.c
	gcc -dynamiclib -o $libName posix_Process.o
	mv ${libName} ${dest}
}

linuxBuild(){
 unamestr=`uname`
 echo "Running Linux build..."
 INCLUDEPATH="${JAVA_HOME}/include"
 libName="posix_Process.so"
 dest="lib/${unamestr}"
 mkdir -p $dest
 gcc -I$INCLUDEPATH -c src/main/c/posix_Process.c
 gcc -o $libName} posix_Process.o
 mv ${libName} ${dest}
 
}

unamestr=`uname`
if [[ "$unamestr" == 'Linux' ]]; then
  linuxBuild
elif [[ "$unamestr" == 'Darwin' ]]; then
  osxBuild
fi



