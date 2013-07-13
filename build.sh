#! /bin/sh

#! /bin/sh

osxBuild(){
    echo "Running osx build.."
	# INCLUDEPATH=/System/Library/Frameworks/JavaVM.framework/Versions/Current/Headers
    # COPTS="-D_SAFE -std=c99 -fnested-functions "
    mkdir lib
	gcc -I/System/Library/Frameworks/JavaVM.framework/Versions/A/Headers/ -I/System/Library/Frameworks/JavaVM.framework/Versions/Current/Headers -c src/main/c/posix_Process.c
	gcc -dynamiclib -o posix_Process.jnilib posix_Process.o
	mv posix_Process.jnilib lib/
}

osxBuild

