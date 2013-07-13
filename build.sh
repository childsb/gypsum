#! /bin/sh

osxBuild(){
    echo "Running osx build..."
	# INCLUDEPATH=/System/Library/Frameworks/JavaVM.framework/Versions/Current/Headers
    # COPTS="-D_SAFE -std=c99 -fnested-functions "
    mkdir lib
    libName="posix_Process_osx_64.jnilib"
	gcc -I/System/Library/Frameworks/JavaVM.framework/Versions/A/Headers/ -I/System/Library/Frameworks/JavaVM.framework/Versions/Current/Headers -c src/main/c/posix_Process.c
	gcc -dynamiclib -o $libName posix_Process.o
	mv ${libName} lib/
}

osxBuild

